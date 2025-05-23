package oh1;

import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Landroid/widget/TextView;", "textview", "", "textcolor", "", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    public static final void a(@NotNull TextView textview, int i3) {
        Intrinsics.checkNotNullParameter(textview, "textview");
        textview.setTextColor(AppCompatResources.getColorStateList(textview.getContext(), i3));
    }
}
