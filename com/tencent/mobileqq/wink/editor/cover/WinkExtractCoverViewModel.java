package com.tencent.mobileqq.wink.editor.cover;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.export.e;
import com.tencent.mobileqq.wink.editor.export.u;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.compact.WinkPublishServiceReporter;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.util.PublishVideoUtils;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.OnReadSnapShootListener;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.cover.ICoverProvider;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.tavcut.core.session.LAKCutSession;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.render.ComposeRenderLayer;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetUtils;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkExtractCoverViewModel extends BaseViewModel {
    private dr C;
    private WinkEditDataWrapper D;
    private String E;
    private long F;
    private Runnable G;
    boolean H = true;
    private MutableLiveData<c> I = new MutableLiveData<>();
    private Handler J = new a();

    /* renamed from: i, reason: collision with root package name */
    private boolean f319673i;

    /* renamed from: m, reason: collision with root package name */
    private String f319674m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class TimeOutRunnable implements Runnable {
        TimeOutRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WinkExtractCoverViewModel winkExtractCoverViewModel = WinkExtractCoverViewModel.this;
            winkExtractCoverViewModel.H = false;
            winkExtractCoverViewModel.i2();
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull @NotNull Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    WinkExtractCoverViewModel.this.i2();
                    return;
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        WinkExtractCoverViewModel.this.k2(null, i3);
                        return;
                    }
                    return;
                }
            }
            WinkExtractCoverViewModel.this.k2((Bitmap) message.obj, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements OnReadSnapShootListener {
        b() {
        }

        @Override // com.tencent.tav.player.OnReadSnapShootListener
        public void onSuccess(Bitmap bitmap, CMTime cMTime) {
            WinkExtractCoverViewModel winkExtractCoverViewModel = WinkExtractCoverViewModel.this;
            if (!winkExtractCoverViewModel.H) {
                return;
            }
            if (winkExtractCoverViewModel.G != null) {
                ThreadManagerV2.removeJob(WinkExtractCoverViewModel.this.G, 16);
            }
            WinkExtractCoverViewModel.this.c2(bitmap, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c2(Bitmap bitmap, int i3) {
        if (bitmap != null && !bitmap.isRecycled()) {
            Message message = new Message();
            if (i3 == 1) {
                message.what = 1;
            } else {
                message.what = 3;
            }
            message.obj = bitmap;
            this.J.sendMessage(message);
            return;
        }
        if (i3 == 1) {
            this.J.sendEmptyMessage(2);
        } else {
            this.J.sendEmptyMessage(4);
        }
    }

    private void e2(int i3) {
        this.I.postValue(new c(3));
        l2(null, 3, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 5)
    public LocalMediaInfo f2(final ICutSession iCutSession, final ComposeRenderLayer composeRenderLayer, final LocalMediaInfo localMediaInfo, final MediaModel mediaModel, final String str, String str2, final List<BaseEffectNode> list, final String str3, final boolean z16) {
        Object obj;
        String str4 = localMediaInfo.path;
        final ArrayList arrayList = new ArrayList();
        arrayList.add(str4);
        final LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
        final String str5 = str2 + File.separator + "output_" + str + "_" + System.currentTimeMillis() + "_.jpg";
        final Object obj2 = new Object();
        synchronized (obj2) {
            try {
                try {
                    iCutSession.setCutStatusListener(new ICutStatusCallback() { // from class: com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel.7
                        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
                        public void onRenderChainReady() {
                            iCutSession.setCutStatusListener(null);
                            r73.a.f430927a.c(composeRenderLayer, mediaModel);
                            composeRenderLayer.o(mediaModel, ComposeRenderLayer.FlushMode.FLUSH_WITHOUT_DELAY, -1L, true);
                            WinkCoverExtractorUtils.f319672a.a(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Size size;
                                    String str6;
                                    String str7;
                                    SizeF sizeF;
                                    synchronized (obj2) {
                                        w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "extractImageCover|onRenderChainReady\u3002");
                                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                        BackgroundModel backgroundModel = mediaModel.backgroundModel;
                                        if (backgroundModel != null && (sizeF = backgroundModel.renderSize) != null) {
                                            size = WinkExtractCoverViewModel.o2((int) sizeF.width, (int) sizeF.height, 720, WinkExtractCoverViewModel.this.n2(z16));
                                        } else {
                                            w53.b.c("WinkPublish-Export-WinkExtractCoverViewModel", "extractImageCover mediaModel.backgroundModel.renderSize is null, use default size");
                                            size = new Size(720, 1080);
                                        }
                                        Size size2 = size;
                                        LAKRenderModel E = WinkExportUtils.E(iCutSession, size2, null);
                                        if (E != null) {
                                            boolean z17 = false;
                                            try {
                                                try {
                                                    rd4.c cVar = rd4.c.f431135f;
                                                    AnonymousClass7 anonymousClass72 = AnonymousClass7.this;
                                                    ICoverProvider d16 = cVar.d(E, size2, str3, list, null);
                                                    long currentTimeMillis = System.currentTimeMillis();
                                                    Bitmap coverAtTime = d16.getCoverAtTime(0L);
                                                    w53.b.c("WinkPublish-Export-WinkExtractCoverViewModel", "getCoverAtTime cost:" + (System.currentTimeMillis() - currentTimeMillis));
                                                    if (coverAtTime != null) {
                                                        z17 = WinkExtractCoverViewModel.u2(coverAtTime, str5);
                                                        if (z17) {
                                                            coverAtTime.recycle();
                                                            d16.release();
                                                            AnonymousClass7 anonymousClass73 = AnonymousClass7.this;
                                                            ArrayList arrayList2 = arrayList;
                                                            String str8 = str5;
                                                            LocalMediaInfo localMediaInfo3 = localMediaInfo;
                                                            u.Q1(arrayList2, str8, localMediaInfo3.mediaWidth, localMediaInfo3.mediaHeight, null, str, localMediaInfo2);
                                                        }
                                                        coverAtTime.recycle();
                                                    }
                                                    d16.release();
                                                    str6 = "WinkPublish-Export-WinkExtractCoverViewModel";
                                                    str7 = "startExport... extract cover isSuccess:" + z17 + " thumbfileName:" + str5;
                                                } catch (Exception e16) {
                                                    w53.b.d("WinkPublish-Export-WinkExtractCoverViewModel", "startExport ERROR", e16);
                                                    str6 = "WinkPublish-Export-WinkExtractCoverViewModel";
                                                    str7 = "startExport... extract cover isSuccess:" + z17 + " thumbfileName:" + str5;
                                                }
                                                w53.b.c(str6, str7);
                                            } catch (Throwable th5) {
                                                w53.b.c("WinkPublish-Export-WinkExtractCoverViewModel", "startExport... extract cover isSuccess:false thumbfileName:" + str5);
                                                throw th5;
                                            }
                                        }
                                        obj2.notifyAll();
                                    }
                                }
                            }, iCutSession);
                        }

                        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
                        public void onLightEntityReload(@Nullable Entity entity) {
                        }
                    });
                    w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "extractImageCover|update mediaModel");
                    iCutSession.bindCutPlayer(rd4.c.f431135f.g(null));
                    WinkCoverExtractorUtils.f319672a.b(composeRenderLayer, mediaModel, str3);
                    obj = obj2;
                    try {
                        try {
                            obj.wait(3000L);
                            w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "extractImageCover|\u7b49\u5f85\u66f4\u65b0");
                        } catch (Exception e16) {
                            w53.b.c("WinkPublish-Export-WinkExtractCoverViewModel", "extractImageCover|exception:" + e16.getMessage());
                        }
                        if (localMediaInfo2.path != null) {
                            return localMediaInfo2;
                        }
                        return localMediaInfo;
                    } catch (Throwable th5) {
                        th = th5;
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    obj = obj2;
                }
            } catch (Throwable th7) {
                th = th7;
                obj = obj2;
            }
        }
    }

    private void g2(final WinkEditorViewModel winkEditorViewModel, dr drVar, final WinkEditDataWrapper winkEditDataWrapper, final String str) {
        if (drVar == null) {
            w53.b.c("WinkPublish-Export-WinkExtractCoverViewModel", "exportImage... error winkTavCutDelegate == null");
            this.I.postValue(new c(5));
            return;
        }
        final List<MediaModel> J = drVar.J();
        if (J != null && J.size() != 0) {
            this.I.postValue(new c(3));
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel.6
                @Override // java.lang.Runnable
                public void run() {
                    List<BaseEffectNode> list;
                    String str2;
                    String str3;
                    HashMap hashMap;
                    boolean z16;
                    boolean z17;
                    boolean z18;
                    boolean z19;
                    long j3;
                    int i3;
                    String str4;
                    HashMap hashMap2;
                    HashMap hashMap3;
                    String str5;
                    String str6;
                    ArrayList arrayList;
                    ArrayList<LocalMediaInfo> arrayList2;
                    ArrayList arrayList3;
                    boolean z26;
                    boolean z27;
                    ArrayList arrayList4;
                    HashMap hashMap4;
                    HashMap hashMap5;
                    long currentTimeMillis = System.currentTimeMillis();
                    String missionId = winkEditorViewModel.getMissionId();
                    String str7 = u53.b.f438374e;
                    File file = new File(str7);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    ArrayList<LocalMediaInfo> R2 = winkEditorViewModel.R2();
                    WinkEditDataWrapper winkEditDataWrapper2 = winkEditDataWrapper;
                    if (winkEditDataWrapper2 != null && winkEditDataWrapper2.getEditDatas() != null && winkEditDataWrapper.getEditDatas().size() > 0) {
                        list = u.T1(winkEditDataWrapper.getEditDatas().get(0));
                    } else {
                        list = null;
                    }
                    List<BaseEffectNode> list2 = list;
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    HashMap hashMap6 = new HashMap();
                    HashMap hashMap7 = new HashMap();
                    int i16 = 0;
                    while (i16 < J.size()) {
                        LocalMediaInfo localMediaInfo = R2.get(i16);
                        WinkEditDataWrapper winkEditDataWrapper3 = winkEditDataWrapper;
                        if (winkEditDataWrapper3 != null) {
                            str2 = winkEditDataWrapper3.getTemplateFilePath();
                            boolean z28 = !TextUtils.isEmpty(str2);
                            z18 = winkEditDataWrapper.getEditDatas().get(i16).isAIElimination();
                            if (winkEditDataWrapper.getEditDatas().get(i16).getAiTemplate() != null) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            hashMap = hashMap7;
                            str3 = "WinkPublish-Export-WinkExtractCoverViewModel";
                            z17 = z28;
                        } else {
                            str2 = "";
                            str3 = "WinkPublish-Export-WinkExtractCoverViewModel";
                            hashMap = hashMap7;
                            z16 = false;
                            z17 = false;
                            z18 = false;
                        }
                        HashMap hashMap8 = hashMap6;
                        if (J.size() == 1 && !z17 && z18) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (!z17 && !com.tencent.mobileqq.wink.editor.model.a.y((MediaModel) J.get(i16)) && !z16) {
                            if (z18) {
                                String o16 = com.tencent.mobileqq.wink.editor.model.a.o((MediaModel) J.get(i16));
                                if (!TextUtils.isEmpty(o16)) {
                                    LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
                                    ArrayList arrayList7 = new ArrayList();
                                    arrayList7.add(localMediaInfo.path);
                                    j3 = currentTimeMillis;
                                    str4 = str3;
                                    i3 = i16;
                                    hashMap2 = hashMap;
                                    hashMap3 = hashMap8;
                                    u.Q1(arrayList7, o16, localMediaInfo.mediaWidth, localMediaInfo.mediaHeight, null, missionId, localMediaInfo2);
                                    arrayList3 = arrayList5;
                                    str6 = str7;
                                    arrayList2 = R2;
                                    localMediaInfo = localMediaInfo2;
                                    z26 = false;
                                    arrayList = arrayList6;
                                    z27 = z18;
                                }
                            }
                            j3 = currentTimeMillis;
                            i3 = i16;
                            str4 = str3;
                            hashMap2 = hashMap;
                            hashMap3 = hashMap8;
                            arrayList3 = arrayList5;
                            str6 = str7;
                            arrayList2 = R2;
                            z26 = false;
                            arrayList = arrayList6;
                            z27 = z18;
                        } else {
                            j3 = currentTimeMillis;
                            i3 = i16;
                            str4 = str3;
                            hashMap2 = hashMap;
                            hashMap3 = hashMap8;
                            w53.b.f(str4, "real extract, isUsingTemplate:" + z17);
                            ICutSession createLAKCutSession = LAKCutSession.INSTANCE.createLAKCutSession();
                            LAKRenderModel y16 = rd4.c.f431135f.y(new ArrayList());
                            if (TextUtils.isEmpty(str2)) {
                                str5 = r73.a.f430927a.b();
                            } else {
                                str5 = str2;
                            }
                            createLAKCutSession.setTemplateDir(str5);
                            createLAKCutSession.setRenderModel(y16);
                            ComposeRenderLayer composeRenderLayer = new ComposeRenderLayer(createLAKCutSession, new MediaModel(), ComposeRenderLayer.RenderScene.PIC, ComposeRenderLayer.RunningMode.EXPORT);
                            String str8 = str7;
                            str6 = str7;
                            arrayList = arrayList6;
                            arrayList2 = R2;
                            arrayList3 = arrayList5;
                            z26 = false;
                            z27 = z18;
                            localMediaInfo = WinkExtractCoverViewModel.this.f2(createLAKCutSession, composeRenderLayer, R2.get(i3), (MediaModel) J.get(i3), missionId, str8, list2, str5, z19);
                            createLAKCutSession.release();
                        }
                        w53.b.f(str4, "cover path:" + localMediaInfo.path + ", isAIElimination:" + z27);
                        if (!TextUtils.isEmpty(localMediaInfo.path)) {
                            localMediaInfo.missionID = missionId;
                            ArrayList<String> arrayList8 = new ArrayList<>();
                            ArrayList<String> arrayList9 = localMediaInfo.mOriginPath;
                            if (arrayList9 != null && !arrayList9.isEmpty()) {
                                arrayList8.addAll(localMediaInfo.mOriginPath);
                            } else {
                                arrayList8.add(localMediaInfo.path);
                            }
                            localMediaInfo.mOriginPath = arrayList8;
                            arrayList.add(localMediaInfo.path);
                            hashMap4 = hashMap3;
                            hashMap4.put(localMediaInfo.path, localMediaInfo);
                            hashMap5 = hashMap2;
                            hashMap5.put(((MediaModel) J.get(i3)).id, localMediaInfo);
                            arrayList4 = arrayList3;
                            arrayList4.add(localMediaInfo);
                        } else {
                            arrayList4 = arrayList3;
                            hashMap4 = hashMap3;
                            hashMap5 = hashMap2;
                        }
                        i16 = i3 + 1;
                        hashMap6 = hashMap4;
                        hashMap7 = hashMap5;
                        arrayList5 = arrayList4;
                        arrayList6 = arrayList;
                        str7 = str6;
                        currentTimeMillis = j3;
                        R2 = arrayList2;
                    }
                    HashMap hashMap9 = hashMap6;
                    ArrayList arrayList10 = arrayList6;
                    ArrayList arrayList11 = arrayList5;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    w53.b.c("WinkPublish-Export-WinkExtractCoverViewModel", "exportImage total count:" + J.size() + " cost:" + currentTimeMillis2);
                    if (WinkExtractCoverViewModel.this.f319673i) {
                        z93.c f16 = Wink.INSTANCE.f();
                        if (f16 != null) {
                            WinkPublishQualityReportData.Builder builder = new WinkPublishQualityReportData.Builder();
                            builder.traceId(str).eventId(WinkPublishServiceReporter.P_PUBLISH_ALL_COST).ext1(String.valueOf(currentTimeMillis2)).ext2("key_export_pic").ext3(String.valueOf(J.size())).desc("image");
                            f16.a(builder.getReportData(), 1);
                        }
                        e.c(winkEditDataWrapper, arrayList10, hashMap9, str, WinkExtractCoverViewModel.this.f319674m);
                    }
                    com.tencent.mobileqq.wink.editor.draft.a.h(winkEditDataWrapper, missionId);
                    WinkExtractCoverViewModel.this.I.postValue(new c(4, arrayList11));
                }
            }, 64, null, true);
        } else {
            w53.b.c("WinkPublish-Export-WinkExtractCoverViewModel", "exportImage... error mediaModels == null");
            this.I.postValue(new c(5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2() {
        w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "start extractVideoCoverBitmap");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel.3
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap = null;
                try {
                    if (WinkExtractCoverViewModel.this.D.getEditDatas().size() == 1) {
                        WinkEditData winkEditData = WinkExtractCoverViewModel.this.D.getEditDatas().get(0);
                        Pair<Integer, Integer> r26 = WinkExtractCoverViewModel.r2(WinkExtractCoverViewModel.this.D);
                        float intValue = ((Integer) r26.first).intValue();
                        float intValue2 = ((Integer) r26.second).intValue();
                        AssetImageGenerator.UN_CATCH_EGL_ERROR = true;
                        bitmap = WinkExtractCoverViewModel.q2((int) intValue, (int) intValue2, WinkExtractCoverViewModel.this.C, winkEditData, com.tencent.mobileqq.wink.editor.draft.c.r(WinkExtractCoverViewModel.this.D), WinkExtractCoverViewModel.this.D.getPreferredCoverTime());
                        AssetImageGenerator.UN_CATCH_EGL_ERROR = false;
                    }
                } catch (Exception e16) {
                    w53.b.d("WinkPublish-Export-WinkExtractCoverViewModel", "extractVideoCoverBitmap error", e16);
                }
                WinkExtractCoverViewModel.this.c2(bitmap, 2);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j2(String str) {
        String str2 = u53.b.f438374e;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + File.separator + "output_" + str + "_" + System.currentTimeMillis() + ".jpg";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2(Bitmap bitmap, int i3) {
        l2(bitmap, i3, 0);
    }

    private void l2(final Bitmap bitmap, final int i3, final int i16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel.4
            @Override // java.lang.Runnable
            public void run() {
                int i17;
                int i18;
                boolean z16;
                int i19;
                File file;
                int floor;
                int i26;
                try {
                    int i27 = i3;
                    if (i27 == 1) {
                        i17 = 1;
                    } else if (i27 == 3) {
                        i17 = 2;
                    } else {
                        i17 = 0;
                    }
                    String missionId = WinkExtractCoverViewModel.this.D.getMissionId();
                    String j26 = WinkExtractCoverViewModel.this.j2(missionId);
                    Pair<Integer, Integer> r26 = WinkExtractCoverViewModel.r2(WinkExtractCoverViewModel.this.D);
                    float intValue = ((Integer) r26.first).intValue();
                    float intValue2 = ((Integer) r26.second).intValue();
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 != null && com.tencent.mobileqq.wink.editor.draft.c.a(WinkExtractCoverViewModel.this.D, WinkExtractCoverViewModel.this.C)) {
                        Pair<Integer, Integer> r27 = WinkExtractCoverViewModel.r2(WinkExtractCoverViewModel.this.D);
                        intValue = ((Integer) r27.first).intValue();
                        intValue2 = ((Integer) r27.second).intValue();
                        int width = bitmap2.getWidth();
                        int height = bitmap2.getHeight();
                        w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "create coverImage: cropWidth = " + intValue + ", cropHeight = " + intValue2 + ", coverWidth = " + width + ", coverHeight = " + height);
                        float f16 = intValue / intValue2;
                        float f17 = ((float) width) / ((float) height);
                        i18 = i17;
                        if (Math.abs(f16 - f17) >= 0.001d) {
                            if (f16 < f17) {
                                i26 = (int) Math.floor(r6 * f16);
                                floor = height;
                            } else {
                                floor = (int) Math.floor(r15 / f16);
                                i26 = width;
                            }
                            w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "need crop cover image: final cropWidth = " + i26 + ", final cropHeight = " + floor);
                            Bitmap createBitmap = Bitmap.createBitmap(bitmap2, (width - i26) / 2, (height - floor) / 2, i26, floor);
                            bitmap2.recycle();
                            bitmap2 = createBitmap;
                        }
                    } else {
                        i18 = i17;
                    }
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    long j3 = 0;
                    if (z16) {
                        boolean u26 = WinkExtractCoverViewModel.u2(bitmap2, j26);
                        w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "bitmap save success:" + u26);
                        bitmap2.recycle();
                        int i28 = i18;
                        if (!u26 && i28 == 1) {
                            WinkExtractCoverViewModel.this.J.sendEmptyMessage(2);
                            return;
                        } else {
                            z16 = u26;
                            i19 = i28;
                        }
                    } else {
                        int i29 = i18;
                        if (WinkExtractCoverViewModel.this.D.getOriginMediaInfos().size() > i16) {
                            LocalMediaInfo localMediaInfo = WinkExtractCoverViewModel.this.D.getOriginMediaInfos().get(i16);
                            int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
                            if (mediaType == 0) {
                                j26 = localMediaInfo.path;
                                i19 = 4;
                            } else if (mediaType == 1) {
                                j26 = PublishVideoUtils.getVideoCover(localMediaInfo.path);
                                i19 = 3;
                            }
                            file = new File(j26);
                            if (file.exists() && file.length() > 0) {
                                w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "extract cover success from PublishVideoUtils");
                                z16 = true;
                            }
                        }
                        i19 = i29;
                        file = new File(j26);
                        if (file.exists()) {
                            w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "extract cover success from PublishVideoUtils");
                            z16 = true;
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis() - WinkExtractCoverViewModel.this.F;
                    w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "extract cover success:" + z16 + ", cost:" + currentTimeMillis);
                    z93.c f18 = Wink.INSTANCE.f();
                    if (f18 == null) {
                        return;
                    }
                    if (!z16) {
                        j3 = ExportErrorCode.ERROR_CODE_COVER_EXTRACT_FAILED;
                    }
                    ExportErrorCode exportErrorCode = new ExportErrorCode(j3, null);
                    WinkPublishQualityReportData.Builder ext2 = new WinkPublishQualityReportData.Builder().eventId("E_EXTRACT_VIDEO_COVER").traceId(WinkExtractCoverViewModel.this.E).retCode(String.valueOf(exportErrorCode.transformedCode())).desc(exportErrorCode.getMessage()).ext1(intValue + HippyTKDListViewAdapter.X + intValue2).ext2(j26);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(i19);
                    sb5.append("");
                    f18.b(ext2.ext3(sb5.toString()).attachInfo(MobileQQ.sProcessId + "").getReportData(), WinkExtractCoverViewModel.this.f319674m);
                    f18.b(new WinkPublishQualityReportData.Builder().eventId(WinkPublishServiceReporter.P_PUBLISH_ALL_COST).traceId(WinkExtractCoverViewModel.this.E).retCode(String.valueOf(exportErrorCode.transformedCode())).desc(exportErrorCode.getMessage()).ext1(String.valueOf(currentTimeMillis)).ext2("key_export_pic").ext3(i19 + "").attachInfo(MobileQQ.sProcessId + "").getReportData(), WinkExtractCoverViewModel.this.f319674m);
                    if (z16) {
                        LocalMediaInfo P1 = u.P1(null, j26, (int) intValue, (int) intValue2, null, missionId);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(P1);
                        WinkExtractCoverViewModel.this.I.postValue(new c(1, arrayList));
                        return;
                    }
                    WinkExtractCoverViewModel.this.I.postValue(new c(2));
                } catch (Throwable th5) {
                    WinkExtractCoverViewModel.this.I.postValue(new c(2));
                    w53.b.e("WinkPublish-Export-WinkExtractCoverViewModel", th5);
                }
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n2(boolean z16) {
        if (z16) {
            return 1600;
        }
        return 1080;
    }

    public static Size o2(int i3, int i16, int i17, int i18) {
        if (i3 != 0 && i16 != 0) {
            if (i3 <= i16) {
                if (i3 > i18) {
                    i16 = (i16 * i18) / i3;
                    i3 = i18;
                } else if (i3 < i17) {
                    i16 = (i16 * i17) / i3;
                    i3 = i17;
                }
            } else if (i16 > i18) {
                i3 = (i3 * i18) / i16;
                i16 = i18;
            } else if (i16 < i17) {
                i3 = (i3 * i17) / i16;
                i16 = i17;
            }
            return new Size(i3, i16);
        }
        return new Size(720, 1280);
    }

    public static void p2(final String str, final int i3, final int i16, final dr drVar, final WinkEditDataWrapper winkEditDataWrapper, final long j3, final com.tencent.mobileqq.wink.editor.cover.a aVar) {
        boolean z16 = false;
        if (drVar != null && drVar.getCurrentPlayer() != null) {
            try {
                drVar.getCurrentPlayer().readSnapShootBitmap(new OnReadSnapShootListener() { // from class: com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel.5
                    @Override // com.tencent.tav.player.OnReadSnapShootListener
                    public void onSuccess(final Bitmap bitmap, CMTime cMTime) {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap q26;
                                Bitmap bitmap2 = bitmap;
                                if (bitmap2 != null && !bitmap2.isRecycled()) {
                                    q26 = bitmap;
                                } else {
                                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                    q26 = WinkExtractCoverViewModel.q2(i3, i16, drVar, winkEditDataWrapper.getEditDatas().get(0), com.tencent.mobileqq.wink.editor.draft.c.r(winkEditDataWrapper), j3);
                                }
                                boolean u26 = WinkExtractCoverViewModel.u2(q26, str);
                                if (q26 != null && !q26.isRecycled()) {
                                    q26.recycle();
                                }
                                com.tencent.mobileqq.wink.editor.cover.a aVar2 = aVar;
                                if (aVar2 != null) {
                                    aVar2.onResult(u26);
                                }
                            }
                        }, 64, null, true);
                    }
                });
                if (!drVar.getCurrentPlayer().isPlaying()) {
                    drVar.getCurrentPlayer().seek(drVar.getCurrentPlayer().getCurrentPlayUs());
                    return;
                }
                return;
            } catch (Exception e16) {
                w53.b.d("WinkPublish-Export-WinkExtractCoverViewModel", "getVideoCover error", e16);
                if (winkEditDataWrapper.getOriginMediaInfos() != null && winkEditDataWrapper.getOriginMediaInfos().get(0) != null) {
                    String videoCover = PublishVideoUtils.getVideoCover(winkEditDataWrapper.getOriginMediaInfos().get(0).path);
                    if (FileUtils.fileExists(videoCover)) {
                        FileUtils.copyFile(videoCover, str);
                        z16 = true;
                        FileUtils.delete(videoCover, true);
                    }
                }
                if (aVar != null) {
                    aVar.onResult(z16);
                    return;
                }
                return;
            }
        }
        w53.b.c("WinkPublish-Export-WinkExtractCoverViewModel", "getVideoCover error winkTavCutDelegate.getPlayer() is null");
        if (aVar != null) {
            aVar.onResult(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap q2(int i3, int i16, dr drVar, WinkEditData winkEditData, String str, long j3) {
        ICoverProvider iCoverProvider;
        String str2;
        LAKRenderModel allInputSourceRenderModel = drVar.getSession().getAllInputSourceRenderModel();
        ICoverProvider iCoverProvider2 = null;
        if (allInputSourceRenderModel != null) {
            allInputSourceRenderModel.setJsonData(LightAssetUtils.getAssetJsonString(drVar.getSession().getLightAsset()));
            try {
                try {
                    if (!(drVar instanceof WinkVideoTavCut)) {
                        str2 = "/";
                    } else {
                        str2 = str;
                    }
                    iCoverProvider = rd4.c.f431135f.d(allInputSourceRenderModel, new Size(i3, i16), str2, u.T1(winkEditData), null);
                } catch (Exception e16) {
                    e = e16;
                    iCoverProvider = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (iCoverProvider2 != null) {
                    }
                    throw th;
                }
                try {
                    Bitmap coverAtTime = iCoverProvider.getCoverAtTime(Math.max(0L, j3));
                    iCoverProvider.release();
                    return coverAtTime;
                } catch (Exception e17) {
                    e = e17;
                    w53.b.d("WinkPublish-Export-WinkExtractCoverViewModel", "startExport ERROR", e);
                    if (iCoverProvider != null) {
                        iCoverProvider.release();
                    }
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
                iCoverProvider2 = i3;
                if (iCoverProvider2 != null) {
                    iCoverProvider2.release();
                }
                throw th;
            }
        }
        w53.b.c("WinkPublish-Export-WinkExtractCoverViewModel", "getVideoCover renderModel == null");
        return null;
    }

    public static Pair<Integer, Integer> r2(WinkEditDataWrapper winkEditDataWrapper) {
        return s2(winkEditDataWrapper.getEditDatas().get(0).getMediaModel());
    }

    public static Pair<Integer, Integer> s2(MediaModel mediaModel) {
        int i3;
        int i16;
        int i17;
        int i18;
        SizeF sizeF;
        try {
            BackgroundModel backgroundModel = mediaModel.backgroundModel;
            if (backgroundModel != null && (sizeF = backgroundModel.renderSize) != null) {
                i3 = (int) sizeF.width;
                i16 = (int) sizeF.height;
            } else {
                i3 = 0;
                i16 = 0;
            }
            if (i3 != 0 && i16 != 0) {
                if (i3 > i16) {
                    i18 = (i3 * 720) / i16;
                    i17 = 720;
                    return new Pair<>(Integer.valueOf(i18), Integer.valueOf(i17));
                }
                i17 = (i16 * 720) / i3;
                i18 = 720;
                return new Pair<>(Integer.valueOf(i18), Integer.valueOf(i17));
            }
            i17 = 1280;
            i18 = 720;
            return new Pair<>(Integer.valueOf(i18), Integer.valueOf(i17));
        } catch (Exception e16) {
            w53.b.e("WinkPublish-Export-WinkExtractCoverViewModel", e16);
            return new Pair<>(720, 1280);
        }
    }

    private void t2(long j3) {
        w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "start readSnapShotBitmap");
        dr drVar = this.C;
        if (drVar != null && drVar.getCurrentPlayer() != null) {
            this.C.getCurrentPlayer().pause();
            this.C.getCurrentPlayer().readSnapShootBitmap(new b());
            this.C.getCurrentPlayer().seek(Math.max(j3, 0L));
            return;
        }
        w53.b.c("WinkPublish-Export-WinkExtractCoverViewModel", "getVideoCover error winkTavCutDelegate.getPlayer() is null");
    }

    public static boolean u2(Bitmap bitmap, String str) {
        w53.b.a("WinkPublish-Export-WinkExtractCoverViewModel", "saveBitmapToFile:" + str);
        if (bitmap == null || str == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str));
                try {
                    boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e16) {
                        w53.b.d("WinkPublish-Export-WinkExtractCoverViewModel", "saveBitmapToFile error", e16);
                    }
                    return compress;
                } catch (IOException e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    w53.b.d("WinkPublish-Export-WinkExtractCoverViewModel", "saveBitmapToFile error", e);
                    if (bufferedOutputStream == null) {
                        return false;
                    }
                    try {
                        bufferedOutputStream.close();
                        return false;
                    } catch (IOException e18) {
                        w53.b.d("WinkPublish-Export-WinkExtractCoverViewModel", "saveBitmapToFile error", e18);
                        return false;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e19) {
                            w53.b.d("WinkPublish-Export-WinkExtractCoverViewModel", "saveBitmapToFile error", e19);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
    }

    public void d2(BasePartFragment basePartFragment, dr drVar, WinkEditDataWrapper winkEditDataWrapper, String str, boolean z16, String str2, Boolean bool, int i3) {
        w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "start extractCover");
        this.f319673i = z16;
        this.f319674m = str2;
        this.C = drVar;
        this.D = winkEditDataWrapper;
        this.E = str;
        if (bool.booleanValue()) {
            e2(i3);
        } else if (winkEditDataWrapper.getEditMode().intValue() == 0) {
            h2();
        } else if (winkEditDataWrapper.getEditMode().intValue() == 1) {
            g2((WinkEditorViewModel) basePartFragment.getViewModel(WinkEditorViewModel.class), drVar, winkEditDataWrapper, str);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkPublish-Export-WinkExtractCoverViewModel";
    }

    public void h2() {
        w53.b.f("WinkPublish-Export-WinkExtractCoverViewModel", "start extractVideoCover");
        if (!com.tencent.mobileqq.wink.editor.draft.c.C(this.D)) {
            w53.b.c("WinkPublish-Export-WinkExtractCoverViewModel", "extractCover error, dataWrapper illegal");
            this.I.postValue(new c(2));
            return;
        }
        this.I.postValue(new c(0));
        this.F = System.currentTimeMillis();
        if (uq3.c.v5()) {
            this.H = true;
            this.G = ThreadManagerV2.executeDelay(new TimeOutRunnable(), 16, null, true, 3000L);
            t2(this.D.getPreferredCoverTime());
            return;
        }
        i2();
    }

    public MutableLiveData<c> m2() {
        return this.I;
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        int f319706a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<LocalMediaInfo> f319707b;

        public c(int i3, ArrayList<LocalMediaInfo> arrayList) {
            this.f319706a = i3;
            this.f319707b = arrayList;
        }

        public ArrayList<LocalMediaInfo> a() {
            return this.f319707b;
        }

        public int b() {
            return this.f319706a;
        }

        public c(int i3) {
            this.f319706a = i3;
            this.f319707b = null;
        }
    }
}
