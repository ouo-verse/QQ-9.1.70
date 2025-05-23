package ce4;

import com.tencent.tavcut.render.exporter.ExportOutput;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u0012\u000fJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH&J,\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0005H&\u00a8\u0006\u0014"}, d2 = {"Lce4/b;", "", "", "Lfe4/a;", "renderNodes", "", "setRenderNodes", "Lce4/b$c;", "listener", "a", "Lcom/tencent/tavcut/render/exporter/ExportOutput;", "exportOutput", "", "destPath", "templatePath", "c", "", "isUE4Template", "b", "cancelExport", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface b {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, ExportOutput exportOutput, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "/";
                }
                bVar.c(exportOutput, str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: export");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lce4/b$b;", "", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: ce4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0186b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u000e\u001a\u00020\u0002H&\u00a8\u0006\u000f"}, d2 = {"Lce4/b$c;", "", "", "onExportStart", "", "progress", "onExporting", "", "exportPath", "onExportCompleted", "", "errCode", "errorMsg", "onExportError", "onExportCancel", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public interface c {
        void onExportCancel();

        void onExportCompleted(@Nullable String exportPath);

        void onExportError(int errCode, @Nullable String errorMsg);

        void onExportStart();

        void onExporting(float progress);
    }

    void a(@Nullable c listener);

    void b(@NotNull ExportOutput exportOutput, @NotNull String destPath, @NotNull String templatePath, boolean isUE4Template);

    void c(@NotNull ExportOutput exportOutput, @NotNull String destPath, @NotNull String templatePath);

    void cancelExport();

    void setRenderNodes(@NotNull List<? extends fe4.a> renderNodes);
}
