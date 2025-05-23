package dl1;

import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Ldl1/b;", "", "", "a", "Landroid/widget/TextView;", "tipsView", "", "configTip", "", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, TextView textView, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = "";
                }
                bVar.b(textView, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCommentHint");
        }
    }

    int a();

    void b(@NotNull TextView tipsView, @NotNull String configTip);
}
