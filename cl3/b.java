package cl3;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J&\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\r"}, d2 = {"Lcl3/b;", "Lvb3/b;", "", "j", "", "Y", "Landroid/content/Context;", "context", "", "url", "Landroid/os/Bundle;", "pageBundle", "C0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public interface b extends vb3.b {
    void C0(Context context, String url, Bundle pageBundle);

    boolean Y();

    void j();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, Context context, String str, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = "";
                }
                if ((i3 & 4) != 0) {
                    bundle = new Bundle();
                }
                bVar.C0(context, str, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openCustomTitleBrowserPage");
        }
    }
}
