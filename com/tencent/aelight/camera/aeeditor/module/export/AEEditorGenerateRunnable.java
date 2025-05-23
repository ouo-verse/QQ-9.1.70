package com.tencent.aelight.camera.aeeditor.module.export;

import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.exporter.MovieExporter;
import com.tencent.qcircle.tavcut.exporter.VideoExportConfig;
import com.tencent.qcircle.tavcut.exporter.VideoExporter;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.util.VideoUtil;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavkit.report.TAVReportUtils;
import dr.b;
import dr.d;
import org.light.LightAsset;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorGenerateRunnable implements Runnable {
    private VideoExporter C;

    /* renamed from: d, reason: collision with root package name */
    private final String f66190d = "AEEditorGenerateRunnable";

    /* renamed from: e, reason: collision with root package name */
    private br.a f66191e;

    /* renamed from: f, reason: collision with root package name */
    private String f66192f;

    /* renamed from: h, reason: collision with root package name */
    private String f66193h;

    /* renamed from: i, reason: collision with root package name */
    private String f66194i;

    /* renamed from: m, reason: collision with root package name */
    private MediaModel f66195m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements MovieExporter.ExportListener {

        /* renamed from: a, reason: collision with root package name */
        private long f66196a;

        /* renamed from: b, reason: collision with root package name */
        private long f66197b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TAVCutVideoSession f66198c;

        a(TAVCutVideoSession tAVCutVideoSession) {
            this.f66198c = tAVCutVideoSession;
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.ExportListener
        public void onExportCancel() {
            ms.a.f("AEEditorGenerateRunnable", "onExportCancel:" + AEEditorGenerateRunnable.this.f66192f);
            if (AEEditorGenerateRunnable.this.f66191e != null) {
                AEEditorGenerateRunnable.this.f66191e.c(AEEditorGenerateRunnable.this.f66192f);
            }
            this.f66198c.release();
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.ExportListener
        public void onExportCompleted(String str) {
            this.f66197b = System.currentTimeMillis();
            ms.a.f("AEEditorGenerateRunnable", "perf: video export cost = " + (this.f66197b - this.f66196a) + "ms");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onExportCompleted mMissionID: ");
            sb5.append(AEEditorGenerateRunnable.this.f66192f);
            ms.a.f("AEEditorGenerateRunnable", sb5.toString());
            ms.a.f("AEEditorGenerateRunnable", "onExportCompleted exportPath: " + str);
            if (AEEditorGenerateRunnable.this.f66191e != null) {
                AEEditorGenerateRunnable.this.f66191e.b(AEEditorGenerateRunnable.this.f66192f, str);
            }
            this.f66198c.release();
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.ExportListener
        public void onExportError(AssetExportSession assetExportSession) {
            int i3;
            String str;
            if (assetExportSession != null) {
                i3 = assetExportSession.getErrCode();
                ms.a.c("AEEditorGenerateRunnable", "[onExportError] errorcode " + i3);
                str = TAVReportUtils.buildExportErrorMsg("unknown", assetExportSession);
                ms.a.c("AEEditorGenerateRunnable", "[onExportError] msg " + str);
            } else {
                i3 = -1;
                str = "";
            }
            ms.a.f("AEEditorGenerateRunnable", "onExportError:" + AEEditorGenerateRunnable.this.f66192f);
            if (AEEditorGenerateRunnable.this.f66191e != null) {
                AEEditorGenerateRunnable.this.f66191e.onAETavSessionExportError(AEEditorGenerateRunnable.this.f66192f, i3, str);
            }
            this.f66198c.release();
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.ExportListener
        public void onExportStart() {
            this.f66196a = System.currentTimeMillis();
            ms.a.f("AEEditorGenerateRunnable", "onExportStart :" + AEEditorGenerateRunnable.this.f66192f);
            if (AEEditorGenerateRunnable.this.f66191e != null) {
                AEEditorGenerateRunnable.this.f66191e.a(AEEditorGenerateRunnable.this.f66192f);
            }
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.ExportListener
        public void onExporting(float f16) {
            if (AEEditorGenerateRunnable.this.f66191e != null) {
                AEEditorGenerateRunnable.this.f66191e.onAETavSessionExporting(AEEditorGenerateRunnable.this.f66192f, f16);
            }
        }
    }

    public AEEditorGenerateRunnable(String str, String str2, String str3, MediaModel mediaModel, br.a aVar) {
        ms.a.f("AEEditorGenerateRunnable", "[AEEditorGenerateRunnable] new :" + str);
        this.f66192f = str;
        this.f66193h = str2;
        this.f66194i = str3;
        this.f66195m = mediaModel;
        this.f66191e = aVar;
    }

    private boolean f() {
        String str = this.f66192f;
        return str != null && str.startsWith("multi_video_");
    }

    private void g(d dVar, Size size) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("videoSrc=");
        sb5.append(this.f66193h);
        sb5.append(", videoDst=");
        sb5.append(this.f66194i);
        if (size != null) {
            sb5.append(", exportWidth=");
            sb5.append(size.getWidth());
            sb5.append(", exportHeight=");
            sb5.append(size.getHeight());
        }
        sb5.append(", exportBitRate=");
        sb5.append(dVar.d());
        sb5.append(", exportFrameRate=");
        sb5.append(dVar.a());
        ms.a.c("AEEditorGenerateRunnable", "[run], exportParams: " + sb5.toString());
    }

    public VideoExporter e() {
        return this.C;
    }

    @Override // java.lang.Runnable
    public void run() {
        Size videoSize;
        try {
            TAVCutVideoSession tAVCutVideoSession = new TAVCutVideoSession();
            d a16 = b.a();
            if (f()) {
                AEEditorVideoEditFragment.vh(BaseApplication.getContext(), tAVCutVideoSession, a16, this.f66195m, null, null);
                videoSize = AEEditorVideoEditFragment.wh(tAVCutVideoSession);
            } else {
                videoSize = VideoUtil.getVideoSize(this.f66193h);
                tAVCutVideoSession.setMediaModel(this.f66195m);
                tAVCutVideoSession.init(BaseApplication.getContext());
            }
            if (ModelExtKt.isLightTemplate(tAVCutVideoSession.getMediaModel())) {
                LightAsset Load = LightAsset.Load(tAVCutVideoSession.getMediaModel().getMediaTemplateModel().getLightMediaTemplateModel().getFilePath(), 100);
                videoSize = new Size(Load.width(), Load.height());
            }
            Size b16 = a16.b(videoSize);
            VideoExportConfig videoExportConfig = new VideoExportConfig();
            videoExportConfig.setOutputPath(this.f66194i);
            videoExportConfig.setSize(b16.getWidth(), b16.getHeight());
            videoExportConfig.setBitRate(a16.d());
            videoExportConfig.setFrameRate(a16.a());
            tAVCutVideoSession.applyCurrentSticker();
            g(a16, b16);
            VideoExporter exporter = tAVCutVideoSession.getExporter(videoExportConfig);
            this.C = exporter;
            exporter.export(new a(tAVCutVideoSession));
        } catch (Exception e16) {
            ms.a.c("AEEditorGenerateRunnable", "[ERROR!!!!] generate error" + e16.getMessage());
            br.a aVar = this.f66191e;
            if (aVar != null) {
                aVar.onAETavSessionExportError(this.f66192f, -3L, e16.toString());
            }
        }
    }
}
