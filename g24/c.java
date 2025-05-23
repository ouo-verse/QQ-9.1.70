package g24;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.robot.aio.bottombar.model.OptionType;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import com.tencent.robot.aio.bottombar.viewholder.RobotBottomBarViewHolder;
import hn2.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lg24/c;", "Lcom/tencent/robot/aio/bottombar/viewholder/RobotBottomBarViewHolder;", "", "u", "t", "Lcom/tencent/robot/aio/bottombar/model/a;", "model", ReportConstant.COSTREPORT_PREFIX, "Lhn2/k;", "H", "Lhn2/k;", "binding", "", "I", "activeColor", "<init>", "(Lhn2/k;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends RobotBottomBarViewHolder {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final k binding;

    /* renamed from: I, reason: from kotlin metadata */
    private final int activeColor;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(@NotNull k binding) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        LinearLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        this.binding = binding;
        this.activeColor = ie0.a.f().g(binding.getRoot().getContext(), R.color.qui_common_text_link, 1000);
    }

    private final void t() {
        this.binding.f405385d.setTextColor(this.activeColor);
        this.binding.f405383b.setBackgroundDrawable(this.binding.getRoot().getContext().getDrawable(R.drawable.qui_robot_bottom_item_check_dot_highlight_bg));
    }

    private final void u() {
        k kVar = this.binding;
        kVar.f405385d.setTextColor(kVar.getRoot().getContext().getColorStateList(R.color.qui_common_text_secondary));
        this.binding.f405383b.setBackgroundResource(R.drawable.qui_robot_bottom_item_check_dot_bg);
    }

    public final void s(@NotNull RobotBottomBarItemModel model) {
        boolean z16;
        Drawable drawable;
        Intrinsics.checkNotNullParameter(model, "model");
        if (model.getIconResId() != 0) {
            drawable = this.itemView.getContext().getDrawable(model.getIconResId());
        } else {
            if (model.getIconUrl().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String iconUrl = model.getIconUrl();
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = new ColorDrawable(0);
                obtain.mFailedDrawable = new ColorDrawable(0);
                drawable = URLDrawable.getDrawable(iconUrl, obtain);
                if (model.getIsChecked()) {
                    drawable.setColorFilter(this.activeColor, PorterDuff.Mode.SRC_ATOP);
                } else {
                    drawable.setColorFilter(this.itemView.getContext().getColor(R.color.qui_common_icon_primary), PorterDuff.Mode.SRC_ATOP);
                }
            } else {
                drawable = null;
            }
        }
        this.binding.f405384c.setImageDrawable(drawable);
        this.binding.f405385d.setText(model.getTitle());
        if (model.getIsChecked()) {
            t();
        } else {
            u();
        }
        Context context = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        r(context, model);
        if (model.getOptionType() == OptionType.OPTION_CHECK) {
            this.binding.f405383b.setVisibility(0);
        } else {
            this.binding.f405383b.setVisibility(8);
        }
    }
}
