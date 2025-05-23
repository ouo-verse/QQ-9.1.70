package com.tencent.robot.aio.bottombar.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.am;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.c;
import com.tencent.qui.quiblurview.f;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/aio/bottombar/viewholder/RobotBottomBarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "p", "Lcom/tencent/robot/aio/bottombar/model/a;", "model", "o", "Lcom/tencent/robot/aio/bottombar/viewholder/a;", "blurSource", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "", DomainData.DOMAIN_NAME, "Landroid/view/View;", "E", "Landroid/view/View;", "itemContentView", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "blurView", "<init>", "(Landroid/view/View;)V", "G", "a", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class RobotBottomBarViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View itemContentView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy blurView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/aio/bottombar/viewholder/RobotBottomBarViewHolder$a;", "", "Landroid/view/View;", "b", "", "ALPHA", "I", "<init>", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.bottombar.viewholder.RobotBottomBarViewHolder$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View b(View view) {
            int id5;
            ViewGroup viewGroup;
            RelativeLayout relativeLayout = new RelativeLayout(view.getContext());
            if (view.getParent() != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            }
            if (view.getId() == -1) {
                id5 = R.id.f764041k;
            } else {
                id5 = view.getId();
            }
            view.setId(id5);
            relativeLayout.addView(view);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            View qQBlurViewWrapper = new QQBlurViewWrapper(context, null, 0, 6, null);
            qQBlurViewWrapper.setId(R.id.f763741h);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, id5);
            layoutParams.addRule(7, id5);
            layoutParams.addRule(6, id5);
            layoutParams.addRule(8, id5);
            qQBlurViewWrapper.setLayoutParams(layoutParams);
            h.c(qQBlurViewWrapper, ViewUtils.f352270a.a(8.0f));
            relativeLayout.addView(qQBlurViewWrapper, 0);
            return relativeLayout;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/aio/bottombar/viewholder/RobotBottomBarViewHolder$b", "Lcom/tencent/qui/quiblurview/f$b;", "", "a", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements f.b {
        b() {
        }

        @Override // com.tencent.qui.quiblurview.f.b
        public boolean a() {
            return RobotBottomBarViewHolder.this.q().isDirty();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotBottomBarViewHolder(@NotNull View itemContentView) {
        super(INSTANCE.b(itemContentView));
        Lazy lazy;
        Intrinsics.checkNotNullParameter(itemContentView, "itemContentView");
        this.itemContentView = itemContentView;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQBlurViewWrapper>() { // from class: com.tencent.robot.aio.bottombar.viewholder.RobotBottomBarViewHolder$blurView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQBlurViewWrapper invoke() {
                return (QQBlurViewWrapper) RobotBottomBarViewHolder.this.itemView.findViewById(R.id.f763741h);
            }
        });
        this.blurView = lazy;
    }

    private final Drawable o(Context context, RobotBottomBarItemModel model) {
        int color;
        if (model.getShowStroke()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i3 = 0;
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(com.tencent.aio.base.tool.f.a(8.0f, context));
            if (model.getIsChecked()) {
                color = 0;
            } else {
                color = context.getColor(R.color.qui_common_border_standard);
            }
            gradientDrawable.setStroke(am.a(0.5f), color);
            if (model.getIsChecked()) {
                i3 = context.getColor(R.color.ce_);
            }
            gradientDrawable.setColor(i3);
            return gradientDrawable;
        }
        return null;
    }

    private final Drawable p(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(com.tencent.aio.base.tool.f.a(8.0f, context));
        gradientDrawable.setColor(context.getColorStateList(R.color.qui_common_bubble_guest_secondary));
        gradientDrawable.setAlpha((int) (gradientDrawable.getAlpha() * 0.6f));
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQBlurViewWrapper q() {
        Object value = this.blurView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-blurView>(...)");
        return (QQBlurViewWrapper) value;
    }

    public final void m(@NotNull RobotBottomBarItemModel model, @Nullable BlurSource blurSource) {
        boolean z16;
        View bgView;
        Intrinsics.checkNotNullParameter(model, "model");
        Context context = q().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "blurView.context");
        boolean n3 = n(model, context);
        if (blurSource != null && (bgView = blurSource.getBgView()) != null) {
            QQBlurViewWrapper q16 = q();
            f.a aVar = new f.a(n3, ViewUtils.f352270a.a(24.0f), blurSource.getBgView(), 0, null, null);
            aVar.o(true);
            q16.a(aVar);
            q().setBlurSource(bgView, blurSource.a(), new f.d(null, new b(), 1, null));
        }
        if (n3) {
            if (blurSource != null && blurSource.getShow()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                q().onResume();
                q().setEnableBlur(true);
                QQBlurViewWrapper q17 = q();
                Context context2 = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                q17.setForeground(p(context2));
                View view = this.itemContentView;
                Context context3 = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "itemView.context");
                view.setBackground(o(context3, model));
            }
        }
        q().onPause();
        q().setEnableBlur(false);
        QQBlurViewWrapper q172 = q();
        Context context22 = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context22, "itemView.context");
        q172.setForeground(p(context22));
        View view2 = this.itemContentView;
        Context context32 = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context32, "itemView.context");
        view2.setBackground(o(context32, model));
    }

    public boolean n(@NotNull RobotBottomBarItemModel model, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(context, "context");
        if (model.getEnableBlur() && c.f363628c.b(context)) {
            return true;
        }
        return false;
    }

    public final void r(@NotNull Context context, @NotNull RobotBottomBarItemModel model) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        this.itemContentView.setBackground(o(context, model));
    }
}
