package i72;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.aio.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Li72/k;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/res/ColorStateList;", "normalColor", "pressColor", "Landroid/graphics/drawable/StateListDrawable;", "l", "", "o", "Lc51/c;", "E", "Lc51/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lc51/c;", "binding", "<init>", "(Lc51/c;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
final class k extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final c51.c binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c51.c binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    /* renamed from: m, reason: from getter */
    public final c51.c getBinding() {
        return this.binding;
    }

    public final void o() {
        this.binding.getRoot().setBackground(l(ContextCompat.getColorStateList(this.itemView.getContext(), R.color.qui_common_fill_light_secondary), ContextCompat.getColorStateList(this.itemView.getContext(), R.color.qui_common_overlay_standard_primary)));
    }

    private final StateListDrawable l(ColorStateList normalColor, ColorStateList pressColor) {
        float b16 = l.b(8);
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
        gradientDrawable.setColor(pressColor);
        gradientDrawable.setCornerRadius(b16);
        gradientDrawable2.setColor(pressColor);
        gradientDrawable2.setCornerRadius(b16);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, layerDrawable);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(normalColor);
        gradientDrawable3.setCornerRadius(b16);
        stateListDrawable.addState(new int[0], gradientDrawable3);
        return stateListDrawable;
    }
}
