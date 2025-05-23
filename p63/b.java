package p63;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.export.compress.base.c;
import com.tencent.mobileqq.wink.l;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u53.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\bH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lp63/b;", "Lcom/tencent/mobileqq/wink/editor/export/compress/base/c;", "", "b", "inputPath", "outputPath", "Lcom/tencent/tav/core/ExportConfig;", "exportConfig", "", "l", "cancel", "Lcom/tencent/tavkit/composition/resource/TAVAssetTrackResource;", "d", "Lcom/tencent/tavkit/composition/resource/TAVAssetTrackResource;", "trackResource", "Lcom/tencent/tavkit/component/TAVExporter;", "e", "Lcom/tencent/tavkit/component/TAVExporter;", "exporter", "<init>", "()V", "f", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TAVAssetTrackResource trackResource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TAVExporter exporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"p63/b$b", "Lcom/tencent/tavkit/component/TAVExporter$ExportListener;", "", "onExportStart", "", "progress", "", QFSEdgeItem.KEY_VIDEO_TIME, "audioTime", "totalTime", "onExporting", "", "exportPath", "onExportCompleted", "Lcom/tencent/tav/core/AssetExportSession;", SessionDbHelper.SESSION_ID, "onExportError", "onExportCancel", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: p63.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C10984b implements TAVExporter.ExportListener {
        C10984b() {
        }

        @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
        public void onExportCancel() {
            b.this.d();
        }

        @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
        public void onExportCompleted(@Nullable String exportPath) {
            b.this.g(exportPath);
        }

        @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
        public void onExportError(@Nullable AssetExportSession session) {
            long j3;
            Throwable th5;
            b bVar = b.this;
            if (session != null) {
                j3 = session.getErrCode();
            } else {
                j3 = 0;
            }
            if (session != null) {
                th5 = session.getThrowable();
            } else {
                th5 = null;
            }
            bVar.h(new ExportErrorCode(j3, String.valueOf(th5)));
        }

        @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
        public void onExportStart() {
            b.this.i();
        }

        @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
        public void onExporting(float progress, long videoTime, long audioTime, long totalTime) {
            b.this.j(progress, videoTime, audioTime, totalTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(b this$0, String inputPath, int i3, Throwable th5, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(inputPath, "$inputPath");
        QLog.e(this$0.b(), 1, "onRealStartCompress, TAVAssetTrackResource create error, errorCode:" + i3 + ", throwable:" + th5 + ", msg:" + obj);
        if (Intrinsics.areEqual(inputPath, obj)) {
            AssetExtractor.DOWNGRADING = true;
            this$0.trackResource = new TAVAssetTrackResource(inputPath);
            AssetExtractor.DOWNGRADING = false;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.c, com.tencent.mobileqq.wink.editor.export.compress.base.a
    @NotNull
    public String b() {
        return super.b() + "_WinkVideoTavKitCompressProcessor";
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.c, com.tencent.mobileqq.wink.editor.export.compress.base.a
    public void cancel() {
        super.cancel();
        TAVExporter tAVExporter = this.exporter;
        if (tAVExporter != null) {
            tAVExporter.cancelExport();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.c
    protected void l(@NotNull final String inputPath, @NotNull String outputPath, @NotNull ExportConfig exportConfig) {
        int i3;
        Intrinsics.checkNotNullParameter(inputPath, "inputPath");
        Intrinsics.checkNotNullParameter(outputPath, "outputPath");
        Intrinsics.checkNotNullParameter(exportConfig, "exportConfig");
        if (!l.g()) {
            QLog.e(b(), 1, "onRealStartCompress, load so fail ");
            h(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_SO_LOAD_FAIL, null));
            return;
        }
        if (n63.c.f418525a.d()) {
            QLog.e(b(), 1, "onRealStartCompress, load so fail ");
            h(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_RESULT_SOFT_COMPRESS_ERROR_TEST, null));
            return;
        }
        ExtractorUtils.setExtractErrorListener(new ExtractorUtils.IExtractErrorListener() { // from class: p63.a
            @Override // com.tencent.tav.extractor.ExtractorUtils.IExtractErrorListener
            public final void onError(int i16, Throwable th5, Object obj) {
                b.s(b.this, inputPath, i16, th5, obj);
            }
        });
        this.trackResource = new TAVAssetTrackResource(inputPath);
        ExtractorUtils.setExtractErrorListener(null);
        TAVClip tAVClip = new TAVClip(this.trackResource);
        ArrayList arrayList = new ArrayList();
        arrayList.add(tAVClip);
        TAVComposition tAVComposition = new TAVComposition();
        tAVComposition.addVideoChannel(arrayList);
        tAVComposition.addAudioChannel(arrayList);
        TAVExporter tAVExporter = new TAVExporter();
        this.exporter = tAVExporter;
        tAVExporter.setExportListener(new C10984b());
        boolean b16 = AECameraPrefsUtil.c().b("SP_USE_NEW_COMPRESS", false, 0);
        if (i.f438430c == null) {
            i.f438430c = Boolean.valueOf(QzoneConfig.isOpenFastCompress(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()));
        }
        QLog.e(b(), 1, "onRealStartCompress, isOpenFastCompress:" + i.f438430c);
        Boolean isOpenFastCompress = i.f438430c;
        Intrinsics.checkNotNullExpressionValue(isOpenFastCompress, "isOpenFastCompress");
        if (!isOpenFastCompress.booleanValue() && !b16) {
            TAVExporter tAVExporter2 = this.exporter;
            if (tAVExporter2 != null) {
                tAVExporter2.export(tAVComposition, outputPath, exportConfig);
                return;
            }
            return;
        }
        int phonePerfLevel = AEOfflineConfig.getPhonePerfLevel();
        if (phonePerfLevel > 3) {
            i3 = 3;
        } else if (phonePerfLevel == 3) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        QLog.i(b(), 1, "onRealStartCompress, do fast compress, segment:" + i3);
        TAVExporter tAVExporter3 = this.exporter;
        if (tAVExporter3 != null) {
            tAVExporter3.quickExport(inputPath, tAVComposition, outputPath, exportConfig, i3);
        }
    }
}
