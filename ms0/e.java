package ms0;

import android.view.View;
import android.widget.LinearLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import z12.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lms0/e;", "Lms0/d;", "Landroid/view/View;", "view", "", "c", "Landroid/widget/LinearLayout;", "v", "i", "Landroid/view/View;", "nickView", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends d {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View nickView;

    @Override // ms0.d, eq0.g
    public void c(@Nullable View view) {
        LinearLayout linearLayout;
        if (view != null) {
            this.nickView = view;
            g binding = getBinding();
            if (binding != null && (linearLayout = binding.f451768g) != null) {
                linearLayout.addView(view);
            }
        }
    }

    @Override // ms0.d, eq0.g
    @Nullable
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public LinearLayout e() {
        g binding = getBinding();
        if (binding != null) {
            return binding.f451768g;
        }
        return null;
    }
}
