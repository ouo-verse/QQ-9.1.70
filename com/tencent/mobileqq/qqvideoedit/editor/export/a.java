package com.tencent.mobileqq.qqvideoedit.editor.export;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import ce4.b;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoEditData;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoEditDataWrapper;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.ComposeRenderLayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.render.exporter.ExportOutput;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.tavcut.session.a f275733b;

    /* renamed from: c, reason: collision with root package name */
    private ce4.b f275734c;

    /* renamed from: e, reason: collision with root package name */
    private long f275736e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f275732a = false;

    /* renamed from: d, reason: collision with root package name */
    private String f275735d = "/";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.export.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C8434a extends com.tencent.tavcut.operator.b {
        C8434a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements b.c {

        /* renamed from: a, reason: collision with root package name */
        private long f275738a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MutableLiveData f275739b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f275740c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.tavcut.session.a f275741d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LocalMediaInfo f275742e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f275743f;

        b(MutableLiveData mutableLiveData, long j3, com.tencent.tavcut.session.a aVar, LocalMediaInfo localMediaInfo, String str) {
            this.f275739b = mutableLiveData;
            this.f275740c = j3;
            this.f275741d = aVar;
            this.f275742e = localMediaInfo;
            this.f275743f = str;
        }

        @Override // ce4.b.c
        public void onExportCancel() {
            ms.a.c("VideoExportManager", "onGoNext... exportVideo onExportCancel");
            a.this.q(false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ce4.b.c
        public void onExportCompleted(@Nullable String str) {
            if (QLog.isColorLevel() && !TextUtils.isEmpty(str)) {
                ms.a.c("VideoExportManager", "onGoNext... exportVideo onExportCompleted, file.exists:" + new File(str).exists());
            }
            ms.a.c("VideoExportManager", "onGoNext... exportVideo onExportCompleted:" + str);
            a.this.q(false);
            this.f275741d.release();
            MutableLiveData mutableLiveData = this.f275739b;
            if (mutableLiveData != null && mutableLiveData.getValue() != 0) {
                VideoExportProgress videoExportProgress = (VideoExportProgress) this.f275739b.getValue();
                videoExportProgress.j(2);
                videoExportProgress.g(this.f275742e);
                videoExportProgress.h(SystemClock.elapsedRealtime() - this.f275738a);
                this.f275739b.postValue(videoExportProgress);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ce4.b.c
        public void onExportError(int i3, @Nullable String str) {
            ms.a.c("VideoExportManager", "onGoNext... exportVideo onExportError, errorCode:" + i3 + " errorMsg:" + str);
            a.this.q(false);
            this.f275741d.release();
            ((IPeakIpcController) QRoute.api(IPeakIpcController.class)).report(this.f275743f, ((IPeakIpcModuleServer) QRoute.api(IPeakIpcModuleServer.class)).actionQcirclePickerReport(), ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).tCatchImportantInfo(), ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).sceneForExportVideoError(), "", "", String.valueOf(i3), str);
            MutableLiveData mutableLiveData = this.f275739b;
            if (mutableLiveData != null && mutableLiveData.getValue() != 0) {
                VideoExportProgress videoExportProgress = (VideoExportProgress) this.f275739b.getValue();
                videoExportProgress.j(3);
                videoExportProgress.f(str);
                this.f275739b.postValue(videoExportProgress);
            }
        }

        @Override // ce4.b.c
        public void onExportStart() {
            this.f275738a = SystemClock.elapsedRealtime();
            ms.a.c("VideoExportManager", "onGoNext... exportVideo onExportStart");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ce4.b.c
        public void onExporting(float f16) {
            ms.a.a("VideoExportManager", "onGoNext... exportVideo onExporting, progress:" + f16);
            MutableLiveData mutableLiveData = this.f275739b;
            if (mutableLiveData != null && mutableLiveData.getValue() != 0) {
                VideoExportProgress videoExportProgress = (VideoExportProgress) this.f275739b.getValue();
                videoExportProgress.j(1);
                videoExportProgress.i((int) Math.abs(f16 * 100.0f));
                this.f275739b.postValue(videoExportProgress);
            }
            if (this.f275740c < a.this.f275736e) {
                ms.a.f("VideoExportManager", "user click cancel after click export immediately, call cancelExport() again");
                a.this.b(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        static final a f275745a = new a();
    }

    private void c(Context context, com.tencent.tavcut.session.a aVar, ExportOutput exportOutput, LocalMediaInfo localMediaInfo, String str, List<fe4.a> list, long j3, MutableLiveData<VideoExportProgress> mutableLiveData) {
        ce4.b f16 = od4.b.f422509e.f(bk2.a.a(aVar.getRenderModel(), 300000000L));
        this.f275734c = f16;
        if (list != null) {
            f16.setRenderNodes(list);
        }
        this.f275734c.a(new b(mutableLiveData, j3, aVar, localMediaInfo, str));
        ms.a.f("VideoExportManager", "call sdk export, compare two time, startExportTime: " + j3 + ", mCancelExportTime: " + this.f275736e);
        if (j3 < this.f275736e) {
            ms.a.f("VideoExportManager", "user click cancel after click export immediately, just return");
        } else {
            this.f275734c.b(exportOutput, localMediaInfo.path, this.f275735d, false);
            q(true);
        }
    }

    public static void d(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo != null && QAlbumUtil.getMediaType(localMediaInfo) == 1) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(localMediaInfo.path);
                    localMediaInfo.mediaHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    localMediaInfo.mediaWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                    localMediaInfo.rotation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                } catch (Exception e16) {
                    ms.a.d("VideoExportManager", "fixVideoWidthAndHeight", e16);
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        }
    }

    private com.tencent.tavcut.session.a e(VideoEditDataWrapper videoEditDataWrapper) {
        MediaModel mediaModel;
        ms.a.c("VideoExportManager", "create export cutsession");
        od4.b.s(BaseApplication.getContext(), "", "lightsdk_qq", QQWinkConstants.ENTRY_QQ_WORLD);
        od4.a.f422504b.b(false);
        mj2.b.d(2, 6);
        od4.b bVar = od4.b.f422509e;
        com.tencent.tavcut.session.a h16 = bVar.h();
        h16.g(bVar.x(videoEditDataWrapper.getTemplateFilePath()));
        this.f275735d = h(videoEditDataWrapper.getTemplateFilePath());
        ComposeRenderLayer composeRenderLayer = new ComposeRenderLayer(h16, new MediaModel(), ComposeRenderLayer.RenderScene.VIDEO);
        ArrayList<VideoEditData> editData = videoEditDataWrapper.getEditData();
        if (editData != null && editData.size() == 1 && (mediaModel = editData.get(0).getMediaModel()) != null) {
            composeRenderLayer.d(mediaModel);
        }
        return h16;
    }

    public static a g() {
        return c.f275745a;
    }

    public static Pair<Integer, Integer> i(VideoEditDataWrapper videoEditDataWrapper) {
        int i3;
        int i16;
        try {
            SizeF sizeF = videoEditDataWrapper.getEditData().get(0).getMediaModel().backgroundModel.renderSize;
            int i17 = (int) sizeF.width;
            int i18 = (int) sizeF.height;
            if (i17 != 0 && i18 != 0) {
                if (i17 > i18) {
                    i16 = (i17 * 720) / i18;
                    i3 = 720;
                    return new Pair<>(Integer.valueOf(i16), Integer.valueOf(i3));
                }
                i3 = (i18 * 720) / i17;
                i16 = 720;
                return new Pair<>(Integer.valueOf(i16), Integer.valueOf(i3));
            }
            i3 = 1280;
            i16 = 720;
            return new Pair<>(Integer.valueOf(i16), Integer.valueOf(i3));
        } catch (Exception e16) {
            ms.a.e("VideoExportManager", e16);
            return new Pair<>(720, 1280);
        }
    }

    public static Pair<Integer, Integer> j(VideoEditDataWrapper videoEditDataWrapper) {
        try {
            SizeF sizeF = videoEditDataWrapper.getEditData().get(0).getMediaModel().backgroundModel.renderSize;
            int i3 = (int) sizeF.width;
            int i16 = (int) sizeF.height;
            if (i3 == 0 || i16 == 0) {
                i16 = 1280;
                i3 = 720;
            }
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
        } catch (Exception e16) {
            ms.a.e("VideoExportManager", e16);
            return new Pair<>(720, 1280);
        }
    }

    public static boolean k(VideoEditDataWrapper videoEditDataWrapper) {
        Integer editMode = videoEditDataWrapper.getEditMode();
        if (editMode != null && editMode.intValue() == 0) {
            return m(videoEditDataWrapper.getEditData());
        }
        return false;
    }

    private static boolean l(int i3, int i16) {
        if (i16 <= i3) {
            i3 = i16;
        }
        if (i3 >= 1080) {
            return true;
        }
        return false;
    }

    private static boolean m(List<VideoEditData> list) {
        ResourceModel resourceModel;
        SizeF sizeF;
        if (list != null && list.size() != 0) {
            list.get(0).getMediaModel();
            for (MediaClip mediaClip : list.get(0).getMediaModel().videos) {
                if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (sizeF = resourceModel.size) != null && l((int) sizeF.width, (int) sizeF.height)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void n() {
        com.tencent.mobileqq.qqvideoedit.c.b();
        od4.b.t(((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightAssetsDir());
        com.tencent.mobileqq.qqvideoedit.c.c();
    }

    public static boolean s() {
        if (AEModule.getContext() == null) {
            AEModule.setContext(BaseApplication.context);
        }
        if (AEOfflineConfig.getPhonePerfLevel() >= 4) {
            return true;
        }
        return false;
    }

    public void b(boolean z16) {
        if (z16) {
            this.f275736e = System.currentTimeMillis();
            ms.a.f("VideoExportManager", "manual click cancel export time: " + this.f275736e);
        }
        ce4.b bVar = this.f275734c;
        if (bVar != null) {
            bVar.cancelExport();
        }
        com.tencent.tavcut.session.a aVar = this.f275733b;
        if (aVar != null) {
            aVar.release();
        }
        this.f275732a = false;
    }

    public int f(String str) {
        VideoEditDataWrapper a16;
        if (TextUtils.isEmpty(str) || (a16 = wj2.a.a(str)) == null) {
            return 0;
        }
        return a16.getUseHD();
    }

    public String h(String str) {
        if (str != null) {
            try {
                return new File(str).getParent() + File.separator;
            } catch (Exception e16) {
                ms.a.c("VideoExportManager", "getTemplateDir exception:" + e16.getMessage());
            }
        }
        return "/";
    }

    public void o(VideoEditDataWrapper videoEditDataWrapper, String str, long j3, MutableLiveData<VideoExportProgress> mutableLiveData) {
        int i3;
        List<fe4.a> list;
        com.tencent.tavcut.session.a e16 = e(videoEditDataWrapper);
        this.f275733b = e16;
        e16.getClipSourceOperator().h(new C8434a());
        Pair<Integer, Integer> j16 = j(videoEditDataWrapper);
        ExportOutput exportOutput = new ExportOutput(((Integer) j16.first).intValue(), ((Integer) j16.second).intValue());
        exportOutput.h(true);
        exportOutput.k(200);
        if (Math.min(((Integer) j16.first).intValue(), ((Integer) j16.second).intValue()) > 720) {
            i3 = 3145728;
        } else {
            i3 = 2097152;
        }
        exportOutput.l(i3);
        exportOutput.i(Math.min(exportOutput.g(this.f275733b.getRenderModel()), 30));
        ArrayList<VideoEditData> editData = videoEditDataWrapper.getEditData();
        if (editData != null && editData.size() > 0) {
            list = VideoExportViewModel.N1(editData.get(0));
        } else {
            list = null;
        }
        c(BaseApplication.getContext(), this.f275733b, exportOutput, videoEditDataWrapper.getOutMediaInfo(), str, list, j3, mutableLiveData);
    }

    public void p(String str) {
        VideoEditDataWrapper a16;
        if (this.f275732a || TextUtils.isEmpty(str) || (a16 = wj2.a.a(str)) == null) {
            return;
        }
        n();
        o(a16, "", System.currentTimeMillis(), null);
    }

    public void q(boolean z16) {
        this.f275732a = z16;
    }

    public void r(String str, boolean z16) {
        VideoEditDataWrapper a16;
        int i3;
        if (TextUtils.isEmpty(str) || (a16 = wj2.a.a(str)) == null) {
            return;
        }
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        a16.setUseHD(i3);
        wj2.a.c(a16, str);
    }

    public boolean t(String str) {
        VideoEditDataWrapper a16;
        if (TextUtils.isEmpty(str) || (a16 = wj2.a.a(str)) == null || !k(a16) || !s()) {
            return false;
        }
        return true;
    }
}
