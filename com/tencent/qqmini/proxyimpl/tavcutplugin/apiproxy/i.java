package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import ce4.b;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.render.exporter.ExportOutput;
import com.tencent.tavcut.rendermodel.RenderModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0003\u0013\u0017\u001bB\u0007\u00a2\u0006\u0004\b(\u0010)J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0015\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010'\u001a\u00020 2\u0006\u0010$\u001a\u00020 8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/i;", "", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/e;", "tavCutSession", "", "i", "Lcom/tencent/tavcut/composition/model/component/Size;", "outputSize", "l", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/i$b;", "exportListener", "j", "", "outputPath", "g", "f", "", "videoBitRate", "k", "a", "Ljava/lang/String;", "TAG", "Lcom/tencent/tavcut/render/exporter/ExportOutput;", "b", "Lcom/tencent/tavcut/render/exporter/ExportOutput;", "exportOutput", "Lce4/b;", "c", "Lce4/b;", "exporter", "d", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/i$b;", "", "e", "Z", "isCanceled", "<set-?>", tl.h.F, "()Z", "isExporting", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "TavExporter@" + Integer.toHexString(hashCode());

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ExportOutput exportOutput;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ce4.b exporter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b exportListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isCanceled;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isExporting;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u000f\u001a\u00020\u0002H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/i$b;", "", "", "onExportStart", "", "progress", "onExporting", "", "exportPath", "onExportCompleted", "", "errCode", "", "throwable", "a", "onExportCancel", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(int errCode, Throwable throwable);

        void onExportCancel();

        void onExportCompleted(String exportPath);

        void onExportStart();

        void onExporting(float progress);
    }

    public i() {
        ExportOutput exportOutput = new ExportOutput(720, 1280);
        this.exportOutput = exportOutput;
        exportOutput.i(30);
        exportOutput.k(300);
        exportOutput.h(true);
    }

    public final void g(String outputPath) {
        Intrinsics.checkNotNullParameter(outputPath, "outputPath");
        if (this.isExporting) {
            return;
        }
        ce4.b bVar = this.exporter;
        if (bVar != null) {
            bVar.a(new c(this, outputPath));
        }
        ce4.b bVar2 = this.exporter;
        if (bVar2 != null) {
            b.a.a(bVar2, this.exportOutput, outputPath, null, 4, null);
        }
        this.isExporting = true;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsExporting() {
        return this.isExporting;
    }

    public final void i(e tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        od4.b bVar = od4.b.f422509e;
        RenderModel renderModel = tavCutSession.getCutSession().getRenderModel();
        Intrinsics.checkNotNull(renderModel);
        this.exporter = bVar.f(renderModel);
    }

    public final void j(b exportListener) {
        this.exportListener = exportListener;
    }

    public final void l(Size outputSize) {
        Intrinsics.checkNotNullParameter(outputSize, "outputSize");
        Integer num = outputSize.width;
        Integer num2 = outputSize.height;
        if (num == null || num2 == null) {
            return;
        }
        this.exportOutput.j(num.intValue(), num2.intValue());
    }

    public final void f() {
        this.isCanceled = true;
        ce4.b bVar = this.exporter;
        if (bVar != null) {
            bVar.cancelExport();
        }
        this.isExporting = false;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/i$c;", "Lce4/b$c;", "", "onExportCancel", "", "exportPath", "onExportCompleted", "", "errCode", "errorMsg", "onExportError", "onExportStart", "", "progress", "onExporting", "a", "Ljava/lang/String;", "outputPath", "<init>", "(Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/i;Ljava/lang/String;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private final class c implements b.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String outputPath;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f347965b;

        public c(i iVar, String outputPath) {
            Intrinsics.checkNotNullParameter(outputPath, "outputPath");
            this.f347965b = iVar;
            this.outputPath = outputPath;
        }

        @Override // ce4.b.c
        public void onExportCancel() {
            if (this.f347965b.isCanceled) {
                this.f347965b.isCanceled = false;
                b bVar = this.f347965b.exportListener;
                if (bVar != null) {
                    bVar.onExportCancel();
                }
            }
            this.f347965b.isExporting = false;
        }

        @Override // ce4.b.c
        public void onExportCompleted(String exportPath) {
            ee4.b.e(this.f347965b.TAG, "export progress finished");
            b bVar = this.f347965b.exportListener;
            if (bVar != null) {
                bVar.onExportCompleted(this.outputPath);
            }
            this.f347965b.isExporting = false;
        }

        @Override // ce4.b.c
        public void onExportError(int errCode, String errorMsg) {
            b bVar = this.f347965b.exportListener;
            if (bVar != null) {
                bVar.a(errCode, new Throwable(errorMsg));
            }
            this.f347965b.isExporting = false;
        }

        @Override // ce4.b.c
        public void onExporting(float progress) {
            b bVar;
            ee4.b.e(this.f347965b.TAG, "export progress: " + progress);
            if (!this.f347965b.getIsExporting() && (bVar = this.f347965b.exportListener) != null) {
                bVar.onExportStart();
            }
            b bVar2 = this.f347965b.exportListener;
            if (bVar2 != null) {
                bVar2.onExporting(progress);
            }
            this.f347965b.isExporting = true;
        }

        @Override // ce4.b.c
        public void onExportStart() {
        }
    }

    public final void k(int videoBitRate) {
    }
}
