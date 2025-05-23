package gr0;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lgr0/a;", "", "Landroid/widget/TextView;", "d", "Landroid/view/View$OnClickListener;", "clickListener", "", "setNickClickListener", "", "nickName", "setNickName", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface a {
    @NotNull
    TextView d();

    void setNickClickListener(@Nullable View.OnClickListener clickListener);

    void setNickName(@NotNull String nickName);
}
