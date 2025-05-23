package com.tencent.robot.adelie.homepage.maintab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.robot.adelie.homepage.maintab.b;
import com.tencent.robot.adelie.reddot.AdelieRedDotManager;
import com.tencent.robot.adelie.reddot.RedDotInfo;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001\u000fB`\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u000e\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0@\u0012'\b\u0002\u0010!\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001a\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0017\u0010\u0015\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017R6\u0010!\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001a\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010+\u001a\u00020&8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R&\u00109\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u000105\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R)\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u0001050:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010#\u001a\u0004\b\u0011\u0010<\u00a8\u0006E"}, d2 = {"Lcom/tencent/robot/adelie/homepage/maintab/IconTextTab;", "Landroid/widget/FrameLayout;", "Lcom/tencent/robot/adelie/homepage/maintab/b;", "", "color", "", "f", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "e", "", "selected", "setTabSelected", "a", "c", "d", "I", "getIconResId", "()I", "iconResId", "Lcom/tencent/robot/adelie/homepage/maintab/TabType;", "Lcom/tencent/robot/adelie/homepage/maintab/TabType;", "type", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "Lkotlin/ParameterName;", "name", "fragment", "Lkotlin/jvm/functions/Function1;", "getOnSelected", "()Lkotlin/jvm/functions/Function1;", "onSelected", h.F, "Lkotlin/Lazy;", "getFragment", "()Landroidx/fragment/app/Fragment;", "", "i", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "desc", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "iconView", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "redDotView", "Landroidx/lifecycle/LiveData;", "", "Lcom/tencent/robot/adelie/reddot/a;", "D", "Landroidx/lifecycle/LiveData;", "redDotLiveData", "Landroidx/lifecycle/Observer;", "E", "()Landroidx/lifecycle/Observer;", "redDotObserver", "Landroid/view/View;", "logicParent", "Lkotlin/Function0;", "fragmentCreator", "<init>", "(Landroid/content/Context;Landroid/view/View;ILcom/tencent/robot/adelie/homepage/maintab/TabType;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", UserInfo.SEX_FEMALE, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class IconTextTab extends FrameLayout implements b {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QUIBadge redDotView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private LiveData<List<RedDotInfo>> redDotLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy redDotObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int iconResId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TabType type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function1<Fragment, Unit> onSelected;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy fragment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String desc;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView iconView;

    public /* synthetic */ IconTextTab(Context context, View view, int i3, TabType tabType, Function0 function0, Function1 function1, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, view, i3, tabType, function0, (i16 & 32) != 0 ? null : function1);
    }

    private final Observer<List<RedDotInfo>> d() {
        return (Observer) this.redDotObserver.getValue();
    }

    private final void f(int color) {
        Drawable o16 = ie0.a.f().o(getContext(), this.iconResId, color, 1000);
        if (o16 == null) {
            return;
        }
        this.iconView.setImageDrawable(o16);
    }

    @Override // com.tencent.robot.adelie.homepage.maintab.b
    public void a(@NotNull Context context) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        b.C9756b.b(this, context);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("tab_name", this.type.toReportValue()));
        VideoReport.reportEvent("clck", this, mapOf);
    }

    public void c() {
        b.C9756b.a(this);
        LiveData<List<RedDotInfo>> liveData = this.redDotLiveData;
        if (liveData != null) {
            liveData.removeObserver(d());
        }
    }

    public final void e(@NotNull Context context, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        QUIBadge qUIBadge = new QUIBadge(context);
        qUIBadge.setVisibility(8);
        qUIBadge.setRedDot();
        this.redDotView = qUIBadge;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        Unit unit = Unit.INSTANCE;
        addView(qUIBadge, layoutParams);
        AdelieRedDotManager adelieRedDotManager = AdelieRedDotManager.f366808a;
        AdelieRedDotManager.i(adelieRedDotManager, null, null, 3, null);
        MutableLiveData<List<RedDotInfo>> e16 = adelieRedDotManager.e();
        this.redDotLiveData = e16;
        if (e16 != null) {
            e16.observe(lifecycleOwner, d());
        }
    }

    @Override // com.tencent.robot.adelie.homepage.maintab.b
    @NotNull
    public String getDesc() {
        return this.desc;
    }

    @Override // com.tencent.robot.adelie.homepage.maintab.b
    @Nullable
    public Fragment getFragment() {
        return (Fragment) this.fragment.getValue();
    }

    @Override // com.tencent.robot.adelie.homepage.maintab.b
    public void setTabSelected(boolean selected) {
        int i3;
        if (selected) {
            i3 = R.color.qui_common_brand_standard;
        } else {
            i3 = R.color.qui_common_icon_secondary;
        }
        f(i3);
        Function1<Fragment, Unit> function1 = this.onSelected;
        if (function1 != null) {
            function1.invoke(getFragment());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public IconTextTab(@NotNull Context context, @NotNull View logicParent, int i3, @NotNull TabType type, @NotNull final Function0<? extends Fragment> fragmentCreator, @Nullable Function1<? super Fragment, Unit> function1) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logicParent, "logicParent");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(fragmentCreator, "fragmentCreator");
        this.iconResId = i3;
        this.type = type;
        this.onSelected = function1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Fragment>() { // from class: com.tencent.robot.adelie.homepage.maintab.IconTextTab$fragment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Fragment invoke() {
                return fragmentCreator.invoke();
            }
        });
        this.fragment = lazy;
        this.desc = type.name();
        lazy2 = LazyKt__LazyJVMKt.lazy(new IconTextTab$redDotObserver$2(this));
        this.redDotObserver = lazy2;
        int dpToPx = ViewUtils.dpToPx(40.0f);
        setLayoutParams(new FrameLayout.LayoutParams(dpToPx, dpToPx));
        int dpToPx2 = ViewUtils.dpToPx(28.0f);
        ImageView imageView = new ImageView(context);
        this.iconView = imageView;
        f(R.color.qui_common_icon_secondary);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx2, dpToPx2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(imageView, layoutParams);
        VideoReport.setElementId(this, "em_bas_bottom_tab");
        VideoReport.setLogicParent(this, logicParent);
        VideoReport.setPageReportPolicy(this, PageReportPolicy.REPORT_NONE);
    }
}
