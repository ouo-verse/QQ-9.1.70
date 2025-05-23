package com.tencent.mobileqq.wink.picker.utils;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.core.render.builder.light.model.CustomRenderConfig;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import com.tencent.tavcut.core.render.exporter.IExporter;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.device.OfflineConfig;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetUtils;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.components.TimeRange;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u008a\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2(\b\u0002\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00112\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0006R0\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u0010j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0019`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/utils/p;", "", "Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;", "d", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "recordMate", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, WadlProxyConsts.KEY_MATERIAL, "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "outputPath", "", "_width", "_height", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assetData", "Lkotlin/Function1;", "", "", "onProgressUpdate", "b", "a", "Lcom/tencent/tavcut/core/render/exporter/IExporter;", "Ljava/util/HashMap;", "taskMap", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f325325a = new p();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, IExporter> taskMap = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/picker/utils/p$b", "Lcom/tencent/tavcut/core/operator/b;", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends com.tencent.tavcut.core.operator.b {
        b() {
        }

        @Override // com.tencent.tavcut.core.operator.b, com.tencent.tavcut.core.operator.c
        /* renamed from: b */
        public boolean getF318735b() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J(\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/wink/picker/utils/p$c", "Lcom/tencent/tavcut/core/render/exporter/IExporter$ExportListener;", "", "onExportCancel", "", "exportPath", "onExportCompleted", "", "errCode", "errorMsg", "onExportError", "onExportStart", "", "progress", "", QFSEdgeItem.KEY_VIDEO_TIME, "audioTime", "totalTime", "onExporting", "", "a", "Z", "progressRecord", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements IExporter.ExportListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean progressRecord;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f325329b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f325330c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f325331d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Float, Unit> f325332e;

        /* JADX WARN: Multi-variable type inference failed */
        c(CountDownLatch countDownLatch, long j3, Ref.ObjectRef<String> objectRef, Function1<? super Float, Unit> function1) {
            this.f325329b = countDownLatch;
            this.f325330c = j3;
            this.f325331d = objectRef;
            this.f325332e = function1;
        }

        @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
        public void onExportCancel() {
            QLog.e("TemplateExportHelper", 1, "export video canceled");
            this.f325329b.countDown();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
        public void onExportCompleted(@Nullable String exportPath) {
            QLog.i("TemplateExportHelper", 1, "export video completed path:" + exportPath + ", time:" + (System.nanoTime() - this.f325330c));
            this.f325331d.element = exportPath;
            this.f325329b.countDown();
        }

        @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
        public void onExportError(int errCode, @Nullable String errorMsg) {
            QLog.e("TemplateExportHelper", 1, "export video error code:" + errCode + " errorMsg:" + errorMsg);
            this.f325329b.countDown();
        }

        @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
        public void onExportStart() {
            QLog.d("TemplateExportHelper", 1, "export video start");
        }

        @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
        public void onExporting(float progress, long videoTime, long audioTime, long totalTime) {
            if (progress > 0.0f && !this.progressRecord) {
                this.progressRecord = true;
            }
            QLog.d("TemplateExportHelper", 4, "export video progress " + progress);
            Function1<Float, Unit> function1 = this.f325332e;
            if (function1 != null) {
                function1.invoke(Float.valueOf((progress * 0.8f) + 0.2f));
            }
        }
    }

    p() {
    }

    public static /* synthetic */ String c(p pVar, MetaMaterial metaMaterial, String str, MetaMaterial metaMaterial2, List list, String str2, int i3, int i16, HashMap hashMap, Function1 function1, int i17, Object obj) {
        HashMap hashMap2;
        Function1 function12;
        if ((i17 & 128) != 0) {
            hashMap2 = null;
        } else {
            hashMap2 = hashMap;
        }
        if ((i17 & 256) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return pVar.b(metaMaterial, str, metaMaterial2, list, str2, i3, i16, hashMap2, function12);
    }

    private final CustomRenderConfig d() {
        boolean booleanValue;
        Boolean bool = u53.i.f438428a;
        if (bool == null) {
            int phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplication.context);
            Boolean valueOf = Boolean.valueOf(QzoneConfig.isOpenFFmpegDecode(phonePerfLevel, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()));
            u53.i.f438428a = valueOf;
            QLog.e("TemplateExportHelper", 1, "[wns][prepareFFmpegDecodeConfig] deviceLevel = " + phonePerfLevel + ", isOpenFFmpegDecode = " + valueOf);
        } else {
            QLog.e("TemplateExportHelper", 1, "[wns][prepareFFmpegDecodeConfig] isOpenFFmpegDecode = " + bool);
        }
        CustomRenderConfig customRenderConfig = new CustomRenderConfig();
        Boolean bool2 = u53.i.f438428a;
        if (bool2 == null) {
            booleanValue = false;
        } else {
            booleanValue = bool2.booleanValue();
        }
        customRenderConfig.setEnableFastSoftDecode(booleanValue);
        Integer softDecodeThreadCnt = u53.i.f438429b;
        Intrinsics.checkNotNullExpressionValue(softDecodeThreadCnt, "softDecodeThreadCnt");
        customRenderConfig.setSoftDecodeThreadCount(softDecodeThreadCnt.intValue());
        return customRenderConfig;
    }

    public final void a(@NotNull String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        HashMap<String, IExporter> hashMap = taskMap;
        synchronized (hashMap) {
            IExporter remove = hashMap.remove(taskId);
            if (remove != null) {
                remove.cancelExport();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x008b, code lost:
    
        if (r0 == null) goto L10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0228 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b(@Nullable MetaMaterial recordMate, @NotNull String taskId, @NotNull MetaMaterial material, @NotNull List<? extends LocalMediaInfo> localMediaInfos, @NotNull String outputPath, int _width, int _height, @Nullable HashMap<String, String> assetData, @Nullable Function1<? super Float, Unit> onProgressUpdate) {
        Throwable th5;
        Throwable th6;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        CountDownLatch countDownLatch;
        String D;
        Ref.ObjectRef objectRef3;
        rd4.c cVar;
        LAKRenderModel j3;
        int i3;
        int i16;
        float f16;
        boolean z16;
        int i17;
        String str;
        HashMap<String, IExporter> hashMap;
        IExporter f17;
        Iterator it;
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        Intrinsics.checkNotNullParameter(outputPath, "outputPath");
        ?? r122 = 1;
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        String templateFilePath = WinkEditorResourceManager.a1().i2(material);
        long nanoTime = System.nanoTime();
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        com.tencent.mobileqq.wink.picker.utils.a aVar = null;
        rd4.c.t(context, "", "lightsdk_qq", WinkContext.Companion.j(WinkContext.INSTANCE, false, 1, null));
        rd4.b.f431129b.b(false);
        w53.a.e(4);
        ICutSession h16 = rd4.c.f431135f.h(d());
        Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        com.tencent.mobileqq.wink.picker.utils.a aVar2 = new com.tencent.mobileqq.wink.picker.utils.a(h16);
        try {
            countDownLatch = new CountDownLatch(1);
            aVar2.setCutStatusListener(new a(countDownLatch));
            aVar2.getIClipSourceOperator().h(new b());
            if (templateFilePath != null) {
                try {
                    D = WinkExportUtils.D(templateFilePath);
                } catch (Throwable th7) {
                    th5 = th7;
                    aVar = aVar2;
                    objectRef2 = objectRef4;
                    try {
                        aVar.close();
                    } catch (Throwable th8) {
                        ExceptionsKt__ExceptionsKt.addSuppressed(th5, th8);
                    }
                    th6 = th5;
                    objectRef = objectRef2;
                    if (th6 != null) {
                    }
                    return (String) objectRef.element;
                }
            }
            D = WinkExportUtils.w();
            Intrinsics.checkNotNullExpressionValue(D, "templateFilePath?.let { \u2026s.getDefaultTemplateDir()");
            aVar2.setTemplateDir(D);
            ArrayList arrayList = new ArrayList();
            Iterator it5 = localMediaInfos.iterator();
            while (it5.hasNext()) {
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) it5.next();
                if (e93.i.G(localMediaInfo)) {
                    td4.d n3 = rd4.c.f431135f.n();
                    String str2 = localMediaInfo.path;
                    Intrinsics.checkNotNullExpressionValue(str2, "localMediaInfo.path");
                    it = it5;
                    arrayList.add(n3.a(str2, new TimeRange(0L, 0L)));
                    objectRef3 = objectRef4;
                } else {
                    it = it5;
                    td4.d n16 = rd4.c.f431135f.n();
                    String str3 = localMediaInfo.path;
                    Intrinsics.checkNotNullExpressionValue(str3, "localMediaInfo.path");
                    objectRef3 = objectRef4;
                    try {
                        arrayList.add(n16.b(str3, new TimeRange(0L, localMediaInfo.mDuration)));
                    } catch (Throwable th9) {
                        th5 = th9;
                        aVar = aVar2;
                        objectRef2 = objectRef3;
                        aVar.close();
                        th6 = th5;
                        objectRef = objectRef2;
                        if (th6 != null) {
                        }
                        return (String) objectRef.element;
                    }
                }
                it5 = it;
                objectRef4 = objectRef3;
                r122 = 1;
                aVar = null;
            }
            objectRef3 = objectRef4;
            try {
                cVar = rd4.c.f431135f;
                Intrinsics.checkNotNullExpressionValue(templateFilePath, "templateFilePath");
                j3 = cVar.j(templateFilePath, arrayList);
                try {
                } catch (Throwable th10) {
                    th = th10;
                    th5 = th;
                    objectRef2 = r122;
                    aVar.close();
                    th6 = th5;
                    objectRef = objectRef2;
                    if (th6 != null) {
                    }
                    return (String) objectRef.element;
                }
            } catch (Throwable th11) {
                th = th11;
                aVar = aVar2;
                r122 = objectRef3;
            }
        } catch (Throwable th12) {
            th = th12;
            aVar = aVar2;
            r122 = objectRef4;
        }
        if (j3 != null) {
            aVar2.setRenderModel(j3);
            String str4 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap().get("Ace_3d_Engine");
            if (str4 != null) {
                cVar.B("Ace_3d_Engine", str4);
            }
            LightAsset Load = LightAsset.Load(templateFilePath, 0);
            if (Load != null) {
                i3 = Load.width();
            } else {
                i3 = _width;
            }
            if (Load != null) {
                i16 = Load.height();
            } else {
                i16 = _height;
            }
            QLog.i("TemplateExportHelper", 1, "width: " + i3 + ", height: " + i16 + ", _width: " + _width + ", _height: " + _height);
            Size size = new Size(i3, i16);
            if (i3 > i16) {
                f16 = 1000.0f;
            } else {
                f16 = 0.0f;
            }
            aVar2.updateRenderSize(size, f16);
            r122 = 0;
            r122 = 0;
            aVar2.bindCutPlayer(cVar.g(null));
            aVar2.flushWithoutDelay();
            QLog.i("TemplateExportHelper", 1, "exportVideoByMaterial|update cutsession");
            try {
                countDownLatch.await(3000L, TimeUnit.MILLISECONDS);
                QLog.i("TemplateExportHelper", 1, "exportVideoByMaterial| cutsession is ready");
                countDownLatch.countDown();
                z16 = true;
            } catch (Throwable th13) {
                try {
                    z16 = true;
                    QLog.e("TemplateExportHelper", 1, "export video canceled:" + th13.getMessage());
                } finally {
                }
            }
            ExportOutput exportOutput = new ExportOutput(i3, i16);
            exportOutput.setFixOutputSize(z16);
            if (Math.min(i3, i16) >= 1080) {
                if (WinkExportUtils.V()) {
                    i17 = 300;
                    exportOutput.setResolutionLevel(i17);
                    if (!WinkExportUtils.M()) {
                        str = "video/hevc";
                    } else {
                        str = "video/avc";
                    }
                    exportOutput.setOutputVideoMimeType(str);
                    exportOutput.setFrameRate(30);
                    CustomRenderConfig d16 = f325325a.d();
                    hashMap = taskMap;
                    synchronized (hashMap) {
                        try {
                            rd4.c cVar2 = rd4.c.f431135f;
                            LAKRenderModel allInputSourceRenderModel = aVar2.getAllInputSourceRenderModel();
                            Intrinsics.checkNotNull(allInputSourceRenderModel);
                            allInputSourceRenderModel.setJsonData(LightAssetUtils.getAssetJsonString(aVar2.getLightAsset()));
                            f17 = cVar2.f(allInputSourceRenderModel, d16);
                            if (hashMap.get(taskId) == null) {
                                hashMap.put(taskId, f17);
                            }
                            aVar = aVar2;
                            r122 = objectRef3;
                        } catch (Throwable th14) {
                            th = th14;
                        }
                        try {
                            f17.setExportListener(new c(countDownLatch2, nanoTime, objectRef3, onProgressUpdate));
                            f17.setRenderSyncMode(false, 30);
                            QLog.i("TemplateExportHelper", 4, "export video");
                            f17.export(exportOutput, outputPath, templateFilePath);
                            if (assetData != null) {
                                f17.setAssetData(templateFilePath, assetData);
                                Unit unit = Unit.INSTANCE;
                            }
                            try {
                                countDownLatch2.await();
                            } finally {
                                try {
                                    aVar.close();
                                    th6 = null;
                                    objectRef = r122;
                                } finally {
                                }
                            }
                            aVar.close();
                            th6 = null;
                            objectRef = r122;
                            if (th6 != null) {
                                QLog.e("TemplateExportHelper", 1, "export video error", th6);
                            }
                            return (String) objectRef.element;
                        } catch (Throwable th15) {
                            th = th15;
                            throw th;
                        }
                    }
                }
            }
            i17 = 200;
            exportOutput.setResolutionLevel(i17);
            if (!WinkExportUtils.M()) {
            }
            exportOutput.setOutputVideoMimeType(str);
            exportOutput.setFrameRate(30);
            CustomRenderConfig d162 = f325325a.d();
            hashMap = taskMap;
            synchronized (hashMap) {
            }
        } else {
            throw new IllegalArgumentException("invalid template, renderModel null");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/picker/utils/p$a", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "", "onRenderChainReady", "Lorg/light/lightAssetKit/Entity;", "rootEntity", "onLightEntityReload", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements ICutStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f325327a;

        a(CountDownLatch countDownLatch) {
            this.f325327a = countDownLatch;
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
            QLog.i("TemplateExportHelper", 1, "exportVideoByMaterial|onRenderChainReady");
            this.f325327a.countDown();
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(@Nullable Entity rootEntity) {
        }
    }
}
