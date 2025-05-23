package com.tencent.mobileqq.wink.editor.export;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.gyailib.library.GYTrackStickerInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.cu;
import com.tencent.mobileqq.wink.editor.draft.TrackStickerInfo;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.draft.WinkStickerModelExtra;
import com.tencent.mobileqq.wink.editor.export.j;
import com.tencent.mobileqq.wink.editor.export.p;
import com.tencent.mobileqq.wink.export.model.ExportingParam;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.winkpublish.compact.WinkPublishServiceReporter;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.player.Player;
import com.tencent.tavcut.core.render.builder.light.model.CustomRenderConfig;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import com.tencent.tavcut.core.render.exporter.IExporter;
import com.tencent.tavcut.core.render.exporter.MovieExporter;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavkit.tavffmpeg.TAVFFmpegResourceLoader;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import com.tencent.util.ArrayUtils;
import com.tencent.util.QQToastUtil;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.light.device.OfflineConfig;
import org.light.lightAssetKit.components.Size;
import org.light.listener.OnClipAssetListener;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkVideoComposeTask implements d {

    /* renamed from: v, reason: collision with root package name */
    public static volatile boolean f320110v = false;

    /* renamed from: w, reason: collision with root package name */
    public static volatile Object f320111w = new Object();

    /* renamed from: a, reason: collision with root package name */
    public boolean f320112a;

    /* renamed from: d, reason: collision with root package name */
    private ICutSession f320115d;

    /* renamed from: e, reason: collision with root package name */
    private IExporter f320116e;

    /* renamed from: f, reason: collision with root package name */
    private long f320117f;

    /* renamed from: g, reason: collision with root package name */
    private long f320118g;

    /* renamed from: h, reason: collision with root package name */
    private long f320119h;

    /* renamed from: i, reason: collision with root package name */
    private long f320120i;

    /* renamed from: j, reason: collision with root package name */
    private float f320121j;

    /* renamed from: l, reason: collision with root package name */
    private String f320123l;

    /* renamed from: p, reason: collision with root package name */
    private long f320127p;

    /* renamed from: r, reason: collision with root package name */
    private p.ExportResolutionData f320129r;

    /* renamed from: s, reason: collision with root package name */
    private int f320130s;

    /* renamed from: t, reason: collision with root package name */
    private WinkVideoQuickClipTask f320131t;

    /* renamed from: u, reason: collision with root package name */
    private WinkVideoMergeTask f320132u;

    /* renamed from: b, reason: collision with root package name */
    private boolean f320113b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f320114c = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f320122k = false;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f320124m = false;

    /* renamed from: n, reason: collision with root package name */
    private long f320125n = 0;

    /* renamed from: o, reason: collision with root package name */
    private volatile int f320126o = 0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f320128q = false;

    public static ExportingParam L(String str, float f16, float f17, float f18, long j3, String str2, ArrayList<LocalMediaInfo> arrayList) {
        ExportingParam exportingParam = new ExportingParam(str, f16, f17, f18, j3, str2);
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3) != null) {
                    exportingParam.C += arrayList.get(i3).fileSize;
                }
            }
        }
        return exportingParam;
    }

    private void M(WinkEditDataWrapper winkEditDataWrapper) {
        MetaMaterial b16;
        String templateFilePath = winkEditDataWrapper.getTemplateFilePath();
        if (templateFilePath != null && (b16 = WinkEditorResourceManager.a1().b1(templateFilePath)) != null) {
            WinkEditorResourceManager.a1().i0(b16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(final ExportOutput exportOutput, final WinkEditDataWrapper winkEditDataWrapper, final LAKRenderModel lAKRenderModel, final WinkExportParams winkExportParams, final c cVar, boolean z16) {
        String e16;
        WinkEditData winkEditData;
        boolean h16 = com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_COMPOSE_USE_SOFT, 0);
        boolean z17 = h16 || z16;
        w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "\u3010composeVideo\u3011 start, forceUseSoftEncoder: " + h16 + ", useSoftEncoder: " + z17);
        M(winkEditDataWrapper);
        String str = winkExportParams.D;
        final String str2 = winkExportParams.E;
        LAKRenderModel c16 = com.tencent.mobileqq.wink.editor.template.a.c(lAKRenderModel, WinkConfig.f317649a.b());
        com.tencent.mobileqq.wink.editor.template.a.a(c16, (int) exportOutput.getOutputSize().width, (int) exportOutput.getOutputSize().height);
        IExporter f16 = rd4.c.f431135f.f(c16, Z());
        this.f320116e = f16;
        this.f320113b = z17;
        f16.useSoftEncoder(z17);
        if (!TextUtils.isEmpty(winkExportParams.J) && "QZONE".equals(winkExportParams.D) && uq3.c.L4()) {
            e16 = winkExportParams.J;
            FileUtils.delete(e16, true);
        } else {
            e16 = af.f320186a.e(str, str2, 0);
        }
        final String str3 = e16;
        if (this.f320113b) {
            TAVFFmpegResourceLoader.loadLibrary(((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEKitBaseResUnzipFinalPath() + "libtavffmpeg.so");
        }
        ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
        List<BaseEffectNode> T1 = (editDatas == null || editDatas.size() <= 0) ? null : u.T1(editDatas.get(0));
        if (T1 != null) {
            this.f320116e.setRenderNodes(T1);
        }
        IExporter iExporter = this.f320116e;
        if (iExporter instanceof MovieExporter) {
            ((MovieExporter) iExporter).setClipAssetListener(new OnClipAssetListener() { // from class: com.tencent.mobileqq.wink.editor.export.z
                @Override // org.light.listener.OnClipAssetListener
                public final void OnLoadClipError(int i3, String str4) {
                    WinkVideoComposeTask.X(i3, str4);
                }
            });
        }
        this.f320116e.setExportListener(new IExporter.ExportListener() { // from class: com.tencent.mobileqq.wink.editor.export.WinkVideoComposeTask.3
            @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
            public void onExportCancel() {
                w53.b.g("WinkPublish-Export-WinkVideoComposeTask", "[composeVideo][onExportCancel]");
                WinkVideoComposeTask winkVideoComposeTask = WinkVideoComposeTask.this;
                winkVideoComposeTask.O(winkExportParams, winkEditDataWrapper, str3, winkVideoComposeTask.f320112a, winkVideoComposeTask.f320113b, WinkVideoComposeTask.this.f320114c, cVar);
            }

            @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
            public void onExportCompleted(@Nullable final String str4) {
                if (WinkVideoComposeTask.this.f320124m) {
                    return;
                }
                w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "[composeVideo][onExportCompleted] path=" + str4 + ", useSoftEncoder=" + WinkVideoComposeTask.this.f320113b + ", mUseH265=" + WinkVideoComposeTask.this.f320112a + ", type=" + WinkVideoComposeTask.this.f320126o);
                LocalMediaInfo d16 = WinkExportUtils.d(str4);
                ExportErrorCode b16 = af.f320186a.b(d16, (long) exportOutput.getVideoBitRate(), winkExportParams.D, 0, winkEditDataWrapper.getOriginMediaInfos(), winkExportParams.F);
                if (b16.transformedCode() == 0) {
                    if (WinkVideoComposeTask.this.f320126o != 3) {
                        WinkVideoComposeTask.this.P(winkEditDataWrapper, d16, winkExportParams, true, false, 0, cVar);
                        return;
                    } else {
                        WinkVideoComposeTask winkVideoComposeTask = WinkVideoComposeTask.this;
                        winkVideoComposeTask.S(winkEditDataWrapper, d16, winkExportParams, winkVideoComposeTask.f320126o, cVar);
                        return;
                    }
                }
                if (b16.transformedCode() == ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_RESULT_BLACK) {
                    WinkVideoComposeTask.this.Q(winkExportParams, b16, "", cVar, d16);
                } else {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.WinkVideoComposeTask.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LocalMediaInfo d17;
                            ExportErrorCode b17;
                            int parseInt = Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_video_check_retry_count", "3"));
                            do {
                                try {
                                    LockMethodProxy.sleep(2000L);
                                } catch (InterruptedException e17) {
                                    w53.b.e("WinkPublish-Export-WinkVideoComposeTask", e17);
                                }
                                d17 = WinkExportUtils.d(str4);
                                af afVar = af.f320186a;
                                long videoBitRate = exportOutput.getVideoBitRate();
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                b17 = afVar.b(d17, videoBitRate, winkExportParams.D, 0, winkEditDataWrapper.getOriginMediaInfos(), winkExportParams.F);
                                parseInt--;
                                if (b17.transformedCode() != ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_FILE_BITRATE_ZERO) {
                                    break;
                                }
                            } while (parseInt > 0);
                            if (b17.transformedCode() != 0) {
                                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                WinkVideoComposeTask.this.Q(winkExportParams, b17, "", cVar, d17);
                            } else if (WinkVideoComposeTask.this.f320126o == 3) {
                                AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                                WinkVideoComposeTask winkVideoComposeTask2 = WinkVideoComposeTask.this;
                                winkVideoComposeTask2.S(winkEditDataWrapper, d17, winkExportParams, winkVideoComposeTask2.f320126o, cVar);
                            } else {
                                AnonymousClass3 anonymousClass34 = AnonymousClass3.this;
                                WinkVideoComposeTask.this.P(winkEditDataWrapper, d17, winkExportParams, true, false, 0, cVar);
                            }
                        }
                    }, 16, null, true);
                }
            }

            @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
            public void onExportError(int i3, @Nullable String str4) {
                if (WinkVideoComposeTask.this.f320124m) {
                    return;
                }
                if (WinkVideoComposeTask.this.f320130s == 500 && WinkVideoComposeTask.this.f320129r != null) {
                    WinkVideoComposeTask winkVideoComposeTask = WinkVideoComposeTask.this;
                    winkVideoComposeTask.f320130s = winkVideoComposeTask.f320129r.getOriginalVideoLevel();
                    exportOutput.setResolutionLevel(WinkVideoComposeTask.this.f320130s);
                    w53.b.c("WinkPublish-Export-WinkVideoComposeTask", "4K\u5bfc\u51fa\u5931\u8d25\uff0c\u5207\u56de\u539f\u59cb\u5206\u8fa8\u7387");
                    WinkVideoComposeTask.this.N(exportOutput, winkEditDataWrapper, lAKRenderModel, winkExportParams, cVar, false);
                    return;
                }
                if (WinkExportUtils.N(winkEditDataWrapper) && winkExportParams.j()) {
                    ArrayList<LocalMediaInfo> originMediaInfos = winkEditDataWrapper.getOriginMediaInfos();
                    if (originMediaInfos != null && originMediaInfos.size() == 1 && originMediaInfos.get(0) != null) {
                        LocalMediaInfo d16 = WinkExportUtils.d(originMediaInfos.get(0).path);
                        ExportErrorCode b16 = af.f320186a.b(d16, exportOutput.getVideoBitRate(), winkExportParams.D, -1, winkEditDataWrapper.getOriginMediaInfos(), winkExportParams.F);
                        if (b16.transformedCode() != 0) {
                            WinkVideoComposeTask.this.Q(winkExportParams, b16, "", cVar, null);
                            return;
                        } else {
                            WinkVideoComposeTask.this.P(winkEditDataWrapper, d16, winkExportParams, false, false, -1, cVar);
                            w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "export error, upload origin video");
                            return;
                        }
                    }
                    WinkVideoComposeTask.this.Q(winkExportParams, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_ORIGIN_FILE_INVALID, "\u6e90\u5a92\u4f53\u5f02\u5e38"), "", cVar, null);
                    return;
                }
                if (WinkVideoComposeTask.this.f320112a) {
                    QzoneConfig.getInstance();
                    if (QzoneConfig.getWinkExportEnableH265ToH264()) {
                        WinkVideoComposeTask.this.f320112a = false;
                        exportOutput.setOutputVideoMimeType("video/avc");
                        w53.b.c("WinkPublish-Export-WinkVideoComposeTask", "h265\u7f16\u7801\u5931\u8d25\uff0c\u8d70h264\u7f16\u7801");
                        WinkVideoComposeTask.this.N(exportOutput, winkEditDataWrapper, lAKRenderModel, winkExportParams, cVar, false);
                        return;
                    }
                }
                if (!WinkVideoComposeTask.this.f320113b) {
                    QzoneConfig.getInstance();
                    if (QzoneConfig.getWinkExportEnableSoftEncoder()) {
                        WinkExportUtils.j(winkExportParams, "T_CATCH_IMPORTANT_INFO", i3, "\u786c\u7f16\u5931\u8d25\u8d70\u8f6f\u7f16", "scene_compose_video");
                        w53.b.c("WinkPublish-Export-WinkVideoComposeTask", "\u786c\u7f16\u5931\u8d25\uff0c\u8d70\u8f6f\u7f16");
                        WinkVideoComposeTask.this.N(exportOutput, winkEditDataWrapper, lAKRenderModel, winkExportParams, cVar, true);
                        return;
                    }
                }
                WinkVideoComposeTask.this.Q(winkExportParams, new ExportErrorCode(i3, "\u5408\u6210\u5931\u8d25"), str4, cVar, null);
                if (i3 == -5) {
                    WinkExportUtils.i(winkEditDataWrapper);
                }
            }

            @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
            public void onExportStart() {
                if (WinkVideoComposeTask.this.f320124m) {
                    WinkVideoComposeTask.this.cancel();
                    return;
                }
                w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "[composeVideo][onExportStart] mUseH265=" + WinkVideoComposeTask.this.f320112a);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.e(str2, WinkVideoComposeTask.this.f320126o);
                }
                WinkVideoComposeTask.this.f320119h = System.currentTimeMillis() - WinkVideoComposeTask.this.f320117f;
                WinkVideoComposeTask.this.f320117f = System.currentTimeMillis();
            }

            @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
            public void onExporting(float f17, long j3, long j16, long j17) {
                long currentTimeMillis = System.currentTimeMillis();
                WinkVideoComposeTask.this.f320125n = Math.max(Math.abs(j3 - j16), WinkVideoComposeTask.this.f320125n);
                if (Math.abs(currentTimeMillis - WinkVideoComposeTask.this.f320120i) > 1000) {
                    if (WinkVideoComposeTask.this.f320124m) {
                        WinkVideoComposeTask.this.cancel();
                        return;
                    }
                    long j18 = 0;
                    if (WinkVideoComposeTask.this.f320121j > 0.0f && WinkVideoComposeTask.this.f320120i > 0 && f17 != WinkVideoComposeTask.this.f320121j) {
                        j18 = ((float) (currentTimeMillis - WinkVideoComposeTask.this.f320120i)) / (f17 - WinkVideoComposeTask.this.f320121j);
                    }
                    long j19 = j18;
                    WinkVideoComposeTask.this.f320120i = currentTimeMillis;
                    WinkVideoComposeTask.this.f320121j = f17;
                    if (cVar != null) {
                        cVar.b(str2, WinkVideoComposeTask.L(str2, f17, 0.0f, 0.0f, j19, str3, winkEditDataWrapper.getOriginMediaInfos()));
                    }
                    w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "[composeVideo][onExporting], progress:" + f17 + " predictTime:" + j19 + ", videoTime:" + j3 + ", audioTime:" + j16);
                }
            }
        });
        if (ac.f320179a.a(winkEditDataWrapper, winkExportParams, this.f320114c)) {
            synchronized (f320111w) {
                try {
                    if (f320110v) {
                        LockMethodProxy.wait(f320111w);
                    }
                } catch (Exception e17) {
                    w53.b.e("WinkPublish-Export-WinkVideoComposeTask", e17);
                }
            }
            this.f320127p = ac.f320179a.g(winkExportParams.E);
            w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "setStartExportTime,startTime = " + this.f320127p);
            long j3 = this.f320127p;
            if (j3 > 0 && j3 < winkEditDataWrapper.getDuration() / 1000 && this.f320127p < WinkConfig.f317649a.a()) {
                this.f320116e.setStartExportTime(new CMTime(((float) this.f320127p) / 1000.0f));
                this.f320126o = 3;
                w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "setStartExportTime success");
            } else {
                w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "setStartExportTime error");
            }
        }
        this.f320116e.export(exportOutput, str3, com.tencent.mobileqq.wink.editor.draft.c.r(winkEditDataWrapper), false);
        cVar.f(str2, this.f320126o);
        this.f320118g = System.currentTimeMillis() - this.f320117f;
        this.f320117f = System.currentTimeMillis();
        R(winkEditDataWrapper, this.f320126o, this.f320118g, winkExportParams);
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_VIDEO_EXPORT);
        if (editDatas != null && editDatas.size() > 0 && (winkEditData = editDatas.get(0)) != null && winkEditData.getAssetData() != null) {
            this.f320116e.setAssetData(com.tencent.mobileqq.wink.editor.draft.c.r(winkEditDataWrapper), winkEditData.getAssetData());
        }
        if (winkEditDataWrapper.getEditDatas() != null) {
            Iterator<WinkEditData> it = winkEditDataWrapper.getEditDatas().iterator();
            while (it.hasNext()) {
                WinkEditData next = it.next();
                Map<String, WinkStickerModelExtra> stickerExtraMap = next.getStickerExtraMap();
                if (stickerExtraMap != null) {
                    Iterator<String> it5 = stickerExtraMap.keySet().iterator();
                    while (it5.hasNext()) {
                        WinkStickerModelExtra winkStickerModelExtra = next.getStickerExtraMap().get(it5.next());
                        if (winkStickerModelExtra.getEntityName() != null) {
                            this.f320116e.updateTrackedStickerPosition(T(winkStickerModelExtra.getStickerTrackerResult()), winkStickerModelExtra.getEntityName(), winkStickerModelExtra.getEntityId());
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(final WinkExportParams winkExportParams, final WinkEditDataWrapper winkEditDataWrapper, final String str, final boolean z16, boolean z17, boolean z18, c cVar) {
        if (cVar != null) {
            cVar.a(winkExportParams.E);
        }
        if (ac.f320179a.h() && !z17 && !z18) {
            f320110v = true;
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.WinkVideoComposeTask.5
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (WinkVideoComposeTask.f320111w) {
                        try {
                            ac acVar = ac.f320179a;
                            WinkExportParams winkExportParams2 = winkExportParams;
                            acVar.i(winkExportParams2.E, str, winkExportParams2, winkEditDataWrapper, WinkVideoComposeTask.this.f320127p, z16);
                            WinkVideoComposeTask.f320111w.notifyAll();
                            WinkVideoComposeTask.f320110v = false;
                        } catch (Exception e16) {
                            w53.b.e("WinkPublish-Export-WinkVideoComposeTask", e16);
                        }
                    }
                }
            }, 64, null, true, 2000L);
        }
        ExportErrorCode exportErrorCode = new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_CANCEL_CALLBACK, null);
        JsonObject a16 = WinkExportUtils.a(true, false, this.f320126o, winkExportParams.H);
        a16.addProperty("softencoder", String.valueOf(this.f320113b));
        WinkExportUtils.k(winkExportParams, "E_VIDEO_EXPORT_RESULT", exportErrorCode.transformedCode(), exportErrorCode.getMessage(), "", "", "", "", "", winkExportParams.E, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(final WinkEditDataWrapper winkEditDataWrapper, LocalMediaInfo localMediaInfo, final WinkExportParams winkExportParams, boolean z16, boolean z17, int i3, c cVar) {
        boolean booleanValue;
        String str;
        w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "[doOnExportCompleted] filePath=" + localMediaInfo.path + ", missionId=" + winkExportParams.E + ", isExported=" + z16);
        if (cVar != null) {
            cVar.d(winkExportParams.E, localMediaInfo, z16);
        }
        if (z16 && !z17) {
            WinkExportUtils.U(winkExportParams.E, localMediaInfo, winkExportParams);
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f320117f;
        if (!z16 || z17) {
            currentTimeMillis = 0;
        }
        long j3 = currentTimeMillis;
        JsonObject a16 = WinkExportUtils.a(z16, z17, i3, 1);
        a16.addProperty(QCircleWeakNetReporter.KEY_COST, String.valueOf(j3));
        a16.addProperty("videoAheadTime", String.valueOf(this.f320125n));
        a16.addProperty("newAudioEncode", String.valueOf(EncoderWriter.USE_NEW_AUDIO_ENCODE));
        a16.addProperty("preAudioDecode", String.valueOf(EncoderWriter.PRE_DECODE_AUDIO));
        a16.addProperty("softencoder", String.valueOf(this.f320113b));
        a16.addProperty("exportMode", String.valueOf(this.f320128q));
        Boolean bool = u53.i.f438428a;
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        a16.addProperty("enableFastSoftDecode", String.valueOf(booleanValue));
        a16.addProperty("softDecodeThreadCnt", String.valueOf(u53.i.f438429b));
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(WinkExportUtils.o(localMediaInfo, winkEditDataWrapper));
        a16.add("mediainfo", jsonArray);
        WinkExportUtils.k(winkExportParams, "E_VIDEO_EXPORT_RESULT", 0L, "", localMediaInfo.mediaWidth + HippyTKDListViewAdapter.X + localMediaInfo.mediaHeight, String.valueOf(localMediaInfo.mediaBitrate), String.valueOf(localMediaInfo.fileSize), String.valueOf(localMediaInfo.mDuration / 1000), String.valueOf(localMediaInfo.path), z16 + ContainerUtils.FIELD_DELIMITER + z17 + ContainerUtils.FIELD_DELIMITER + i3, a16);
        ICutSession iCutSession = this.f320115d;
        if (iCutSession != null) {
            iCutSession.release();
        }
        if (winkEditDataWrapper != null) {
            winkEditDataWrapper.setOutMediaInfo(localMediaInfo);
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.y
                @Override // java.lang.Runnable
                public final void run() {
                    WinkVideoComposeTask.Y(WinkEditDataWrapper.this, winkExportParams);
                }
            });
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_VIDEO_EXPORT);
            cu.A(winkEditDataWrapper.getEditDatas());
        }
        String valueOf = String.valueOf(j3);
        if (this.f320112a) {
            str = "1";
        } else {
            str = "0";
        }
        WinkExportUtils.k(winkExportParams, WinkPublishServiceReporter.P_PUBLISH_ALL_COST, 0L, "", valueOf, "key_export_video", str, this.f320118g + ContainerUtils.FIELD_DELIMITER + this.f320119h, com.tencent.mobileqq.wink.editor.draft.c.j(winkEditDataWrapper), z16 + ContainerUtils.FIELD_DELIMITER + z17 + ContainerUtils.FIELD_DELIMITER + i3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(WinkExportParams winkExportParams, ExportErrorCode exportErrorCode, String str, c cVar, LocalMediaInfo localMediaInfo) {
        long j3;
        ms.a.c("WinkPublish-Export-WinkVideoComposeTask", "[doOnExportError] errorCode:" + exportErrorCode + " useSoftEncoder:" + this.f320113b + ", mUseH265=" + this.f320112a + " throwable:" + str);
        if (cVar != null) {
            cVar.c(winkExportParams.E, exportErrorCode);
        }
        ICutSession iCutSession = this.f320115d;
        if (iCutSession != null) {
            iCutSession.release();
        }
        JsonObject a16 = WinkExportUtils.a(true, false, this.f320126o, winkExportParams.H);
        a16.addProperty("softencoder", String.valueOf(this.f320113b));
        long transformedCode = exportErrorCode.transformedCode();
        String message = exportErrorCode.getMessage();
        if (localMediaInfo == null) {
            j3 = -1;
        } else {
            j3 = localMediaInfo.mediaBitrate;
        }
        WinkExportUtils.k(winkExportParams, "E_VIDEO_EXPORT_RESULT", transformedCode, message, "", String.valueOf(j3), String.valueOf(2), "", "", str, a16);
    }

    private void R(WinkEditDataWrapper winkEditDataWrapper, int i3, long j3, WinkExportParams winkExportParams) {
        long duration;
        winkExportParams.o();
        JsonObject a16 = WinkExportUtils.a(true, false, i3, 1);
        a16.addProperty("softencoder", String.valueOf(this.f320113b));
        a16.addProperty("process", String.valueOf(MobileQQ.sProcessId));
        a16.addProperty("id", String.valueOf(winkExportParams.K));
        long duration2 = winkEditDataWrapper.getDuration();
        WinkConfig winkConfig = WinkConfig.f317649a;
        if (duration2 > winkConfig.b()) {
            duration = winkConfig.a();
        } else {
            duration = winkEditDataWrapper.getDuration() / 1000;
        }
        a16.addProperty("duration", String.valueOf(duration));
        a16.addProperty("newAudioEncode", String.valueOf(EncoderWriter.USE_NEW_AUDIO_ENCODE));
        a16.addProperty("preAudioDecode", String.valueOf(EncoderWriter.PRE_DECODE_AUDIO));
        ArrayList<LocalMediaInfo> originMediaInfos = winkEditDataWrapper.getOriginMediaInfos();
        if (originMediaInfos != null && originMediaInfos.size() > 0) {
            a16.addProperty("mediaCount", String.valueOf(originMediaInfos.size()));
            JsonArray jsonArray = new JsonArray();
            int min = Math.min(originMediaInfos.size(), 5);
            for (int i16 = 0; i16 < min; i16++) {
                jsonArray.add(WinkExportUtils.n(originMediaInfos.get(i16)));
            }
            a16.add("mediainfo", jsonArray);
        }
        WinkExportUtils.k(winkExportParams, "E_VIDEO_EXPORT_START", 0L, "", String.valueOf(AEOfflineConfig.getPhonePerfLevel()), String.valueOf(j3), String.valueOf(i3), com.tencent.mobileqq.wink.editor.draft.c.j(winkEditDataWrapper), "", winkExportParams.E, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S(WinkEditDataWrapper winkEditDataWrapper, LocalMediaInfo localMediaInfo, WinkExportParams winkExportParams, int i3, c cVar) {
        WinkVideoMergeTask winkVideoMergeTask = new WinkVideoMergeTask();
        this.f320132u = winkVideoMergeTask;
        return winkVideoMergeTask.t(winkEditDataWrapper, localMediaInfo, winkExportParams, this.f320127p, this.f320112a, cVar);
    }

    private ArrayList<GYTrackStickerInfo> T(ArrayList<TrackStickerInfo> arrayList) {
        if (arrayList != null) {
            ArrayList<GYTrackStickerInfo> arrayList2 = new ArrayList<>();
            Iterator<TrackStickerInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                TrackStickerInfo next = it.next();
                GYTrackStickerInfo gYTrackStickerInfo = new GYTrackStickerInfo();
                gYTrackStickerInfo.f35992x = next.getX();
                gYTrackStickerInfo.f35993y = next.getY();
                gYTrackStickerInfo.f35991w = next.getW();
                gYTrackStickerInfo.f35990h = next.getH();
                gYTrackStickerInfo.radian = next.getRadian();
                gYTrackStickerInfo.imageW = next.getImageW();
                gYTrackStickerInfo.imageH = next.getImageH();
                gYTrackStickerInfo.confidence = next.getConfidence();
                gYTrackStickerInfo.timestamp = next.getTimestamp();
                arrayList2.add(gYTrackStickerInfo);
            }
            return arrayList2;
        }
        return null;
    }

    private ExportOutput U(WinkEditDataWrapper winkEditDataWrapper, WinkExportParams winkExportParams) {
        boolean z16;
        Pair<Integer, Integer> u16 = com.tencent.mobileqq.wink.editor.draft.c.u(winkEditDataWrapper);
        ExportOutput exportOutput = new ExportOutput(((Integer) u16.first).intValue(), ((Integer) u16.second).intValue());
        boolean f16 = WinkExportUtils.f(winkEditDataWrapper);
        this.f320129r = p.f320241a.a(f16, winkEditDataWrapper, winkExportParams);
        w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "getComposeResolution:" + this.f320129r);
        int b16 = this.f320129r.b();
        this.f320130s = b16;
        exportOutput.setResolutionLevel(b16);
        if (winkExportParams.g() && WinkExportUtils.M()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f320112a = z16;
        if (z16) {
            exportOutput.setOutputVideoMimeType("video/hevc");
        } else {
            exportOutput.setOutputVideoMimeType("video/avc");
        }
        int i3 = winkExportParams.f323991f;
        if (i3 <= 0) {
            i3 = j.y(winkEditDataWrapper.getOriginMediaInfos(), (int) exportOutput.getOutputSize().width, (int) exportOutput.getOutputSize().height, this.f320112a);
        }
        exportOutput.setFrameRate(i3);
        if (winkExportParams.f323990e > uq3.c.K4()) {
            exportOutput.setVideoBitRate(winkExportParams.f323990e);
        } else {
            j.Q(exportOutput, f16, i3);
        }
        try {
            if (WinkExportUtils.N(winkEditDataWrapper) && !ArrayUtils.isOutOfArrayIndex(0, winkEditDataWrapper.getOriginMediaInfos())) {
                LocalMediaInfo localMediaInfo = winkEditDataWrapper.getOriginMediaInfos().get(0);
                VideoFormatInfo y16 = e93.i.y(localMediaInfo);
                if (j.h(localMediaInfo, y16, this.f320112a, winkExportParams)) {
                    j.m(y16, exportOutput, this.f320112a, winkExportParams);
                    this.f320114c = true;
                }
            }
        } catch (Exception e16) {
            w53.b.d("WinkPublish-Export-WinkVideoComposeTask", "fill hdr error", e16);
        }
        exportOutput.setFormatInteger("i-frame-interval", winkExportParams.a());
        exportOutput.setFixOutputSize(true);
        Player.setPlayerStaticConfig(Player.PlayerStaticConfigKey.CONFIG_STATIC_AUDIO_SYNC_ENABLE, false);
        EncoderWriter.FORCE_FAIL_ON_STOP_ERROR = false;
        WinkExportUtils.l(exportOutput, winkExportParams.D, 0);
        return exportOutput;
    }

    private boolean V(WinkEditDataWrapper winkEditDataWrapper) {
        WinkEditData winkEditData;
        if (winkEditDataWrapper == null || winkEditDataWrapper.getEditDatas().size() == 0 || (winkEditData = winkEditDataWrapper.getEditDatas().get(0)) == null || com.tencent.mobileqq.wink.editor.draft.c.p(winkEditData) == null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(int i3, String str) {
        w53.b.c("WinkPublish-Export-WinkVideoComposeTask", "\u5a92\u4f53\u8bfb\u53d6\u5931\u8d25$code,path=$path,\u8bf7\u91cd\u8bd5");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.aa
            @Override // java.lang.Runnable
            public final void run() {
                QQToastUtil.showQQToast(1, "\u8bfb\u53d6\u5a92\u4f53\u5f02\u5e38,\u8bf7\u91cd\u8bd5");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(WinkEditDataWrapper winkEditDataWrapper, WinkExportParams winkExportParams) {
        e.d(winkEditDataWrapper, winkExportParams.F, winkExportParams.D);
    }

    @NotNull
    private CustomRenderConfig Z() {
        boolean booleanValue;
        if (u53.i.f438428a == null) {
            int phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplication.context);
            u53.i.f438428a = Boolean.valueOf(QzoneConfig.isOpenFFmpegDecode(phonePerfLevel, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()));
            w53.b.c("WinkPublish-Export-WinkVideoComposeTask", "[wns][prepareFFmpegDecodeConfig] deviceLevel = " + phonePerfLevel + " , isOpenFFmpegDecode = " + u53.i.f438428a);
        } else {
            w53.b.c("WinkPublish-Export-WinkVideoComposeTask", "[wns][prepareFFmpegDecodeConfig] isOpenFFmpegDecode =" + u53.i.f438428a);
        }
        CustomRenderConfig customRenderConfig = new CustomRenderConfig();
        Boolean bool = u53.i.f438428a;
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        customRenderConfig.setEnableFastSoftDecode(booleanValue);
        customRenderConfig.setSoftDecodeThreadCount(u53.i.f438429b.intValue());
        return customRenderConfig;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
    
        if (com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil.c().b("SP_EXPORT_MODE", true, 0) != false) goto L14;
     */
    @Override // com.tencent.mobileqq.wink.editor.export.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(final ExportOutput exportOutput, final WinkEditDataWrapper winkEditDataWrapper, final WinkExportParams winkExportParams, final c cVar) {
        boolean z16;
        this.f320126o = 0;
        if (!WinkExportUtils.G()) {
            w53.b.c("WinkPublish-Export-WinkVideoComposeTask", "[composeVideo] error, load so fail");
            cVar.c(winkExportParams.E, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_SO_LOAD_FAIL, null));
            return;
        }
        if (V(winkEditDataWrapper)) {
            w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "use renderModel export video.");
            final LAKRenderModel q16 = com.tencent.mobileqq.wink.editor.draft.c.q(winkEditDataWrapper.getEditDatas().get(0));
            if (uq3.c.w5()) {
                z16 = true;
            }
            z16 = false;
            this.f320128q = z16;
            q16.setExportMode(z16);
            w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "exportMode " + q16.getExportMode());
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.WinkVideoComposeTask.1
                @Override // java.lang.Runnable
                public void run() {
                    WinkVideoComposeTask.this.N(exportOutput, winkEditDataWrapper, q16, winkExportParams, cVar, false);
                }
            }, 16, null, false);
            return;
        }
        this.f320122k = false;
        final List<String> w3 = j.w(winkEditDataWrapper);
        j.r(winkEditDataWrapper, new j.g() { // from class: com.tencent.mobileqq.wink.editor.export.WinkVideoComposeTask.2
            @Override // com.tencent.mobileqq.wink.editor.export.j.g
            public void a(ICutSession iCutSession, Size size) {
                if (WinkVideoComposeTask.this.f320122k) {
                    return;
                }
                j.T(iCutSession, w3, winkEditDataWrapper);
                boolean z17 = true;
                WinkVideoComposeTask.this.f320122k = true;
                final LAKRenderModel u16 = j.u(iCutSession, new Size((int) exportOutput.getOutputSize().width, (int) exportOutput.getOutputSize().height));
                WinkVideoComposeTask winkVideoComposeTask = WinkVideoComposeTask.this;
                if (!uq3.c.w5() || !AECameraPrefsUtil.c().b("SP_EXPORT_MODE", true, 0)) {
                    z17 = false;
                }
                winkVideoComposeTask.f320128q = z17;
                u16.setExportMode(WinkVideoComposeTask.this.f320128q);
                w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "exportMode " + u16.getExportMode());
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.WinkVideoComposeTask.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        WinkVideoComposeTask.this.N(exportOutput, winkEditDataWrapper, u16, winkExportParams, cVar, false);
                    }
                }, 16, null, false);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.export.d
    public boolean b(WinkExportParams winkExportParams, c cVar) {
        String str;
        boolean z16;
        boolean z17;
        ExportOutput exportOutput;
        ExportOutput exportOutput2;
        long j3;
        this.f320117f = System.currentTimeMillis();
        w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "[composeVideo] ExportParams: " + winkExportParams);
        if (cVar == null) {
            w53.b.c("WinkPublish-Export-WinkVideoComposeTask", "[composeVideo] error, callback is null");
            return false;
        }
        if (winkExportParams != null && !TextUtils.isEmpty(winkExportParams.E) && !TextUtils.isEmpty(winkExportParams.D)) {
            String str2 = winkExportParams.E;
            this.f320123l = str2;
            WinkEditDataWrapper d16 = com.tencent.mobileqq.wink.editor.draft.a.d(str2);
            if (d16 == null) {
                w53.b.c("WinkPublish-Export-WinkVideoComposeTask", "[composeVideo] error, winkEditDataWrapper is null");
                cVar.c(winkExportParams.E, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_PARAMS_ERROR, "winkEditDataWrapper is null"));
                return false;
            }
            LocalMediaInfo x16 = WinkExportUtils.x(winkExportParams.E);
            WinkExportParams y16 = WinkExportUtils.y(winkExportParams.E);
            if (x16 != null && winkExportParams.equals(y16)) {
                P(d16, x16, winkExportParams, true, true, -1, cVar);
                return true;
            }
            if (!WinkExportUtils.S(d16)) {
                w53.b.c("WinkPublish-Export-WinkVideoComposeTask", "[composeVideo] error, origin file not exist");
                cVar.c(winkExportParams.E, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_FILE_NOT_EXIST, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST));
                return false;
            }
            ExportOutput U = U(d16, winkExportParams);
            long p16 = WinkExportUtils.p(d16.getOriginMediaInfos().get(0));
            long parseLong = Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_clip_max_bitrate", "13000000"));
            if (parseLong == 0) {
                parseLong = U.getVideoBitRate();
            }
            if (p16 > 0 && p16 <= parseLong) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (WinkExportUtils.O(d16, true)) {
                if (d16.getDuration() > WinkConfig.f317649a.b() && WinkVideoQuickClipTask.INSTANCE.a()) {
                    if (z16) {
                        if (p16 > U.getVideoBitRate()) {
                            exportOutput2 = U;
                            j3 = parseLong;
                            WinkExportUtils.j(winkExportParams, "T_CATCH_IMPORTANT_INFO", 0L, "", "scene_hit_15min_max_bitrate");
                        } else {
                            exportOutput2 = U;
                            j3 = parseLong;
                        }
                        w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "[composeVideo] maxVideoBitRate:" + j3);
                        WinkVideoQuickClipTask winkVideoQuickClipTask = new WinkVideoQuickClipTask();
                        this.f320131t = winkVideoQuickClipTask;
                        winkVideoQuickClipTask.s(this);
                        this.f320131t.t(exportOutput2, d16, winkExportParams, cVar);
                        return true;
                    }
                    exportOutput = U;
                    z17 = true;
                } else {
                    exportOutput = U;
                    if (winkExportParams.f323993i && p16 > 0 && p16 <= exportOutput.getVideoBitRate()) {
                        P(d16, d16.getOriginMediaInfos().get(0), winkExportParams, false, false, -1, cVar);
                        return true;
                    }
                    z17 = true;
                }
            } else {
                z17 = true;
                exportOutput = U;
                if (z16 && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_wink_clip_mix_music", true) && WinkExportUtils.J(d16)) {
                    WinkVideoQuickClipTask winkVideoQuickClipTask2 = new WinkVideoQuickClipTask();
                    this.f320131t = winkVideoQuickClipTask2;
                    winkVideoQuickClipTask2.s(this);
                    this.f320131t.t(exportOutput, d16, winkExportParams, cVar);
                    return true;
                }
            }
            a(exportOutput, d16, winkExportParams, cVar);
            return z17;
        }
        ExportErrorCode exportErrorCode = new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_PARAMS_ERROR, "exportParams error" + winkExportParams);
        if (winkExportParams != null) {
            str = winkExportParams.E;
        } else {
            str = "";
        }
        cVar.c(str, exportErrorCode);
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.export.d
    public void cancel() {
        w53.b.f("WinkPublish-Export-WinkVideoComposeTask", "cancelCompose");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.WinkVideoComposeTask.4
            @Override // java.lang.Runnable
            public void run() {
                WinkVideoComposeTask.this.f320124m = true;
                if (WinkVideoComposeTask.this.f320116e != null) {
                    WinkVideoComposeTask.this.f320116e.cancelExport();
                }
                if (WinkVideoComposeTask.this.f320115d != null) {
                    WinkVideoComposeTask.this.f320115d.release();
                }
                if (WinkVideoComposeTask.this.f320131t != null) {
                    WinkVideoComposeTask.this.f320131t.o();
                }
                if (WinkVideoComposeTask.this.f320132u != null) {
                    WinkVideoComposeTask.this.f320132u.p();
                }
                WinkExportUtils.h(WinkVideoComposeTask.this.f320123l);
            }
        }, 16, null, false);
    }
}
