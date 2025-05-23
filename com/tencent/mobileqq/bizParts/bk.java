package com.tencent.mobileqq.bizParts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.widget.NightModeSettingItem;
import com.tencent.mobileqq.widget.NormalSettingItem;
import com.tencent.mobileqq.widget.WeatherSettingItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/bizParts/bk;", "Lcom/tencent/mobileqq/part/a;", "", "H9", "G9", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onAccountChanged", "onPartDestroy", "onPostThemeChanged", "f", "Landroid/view/View;", "bottomContainer", "Lcom/tencent/mobileqq/widget/NormalSettingItem;", tl.h.F, "Lcom/tencent/mobileqq/widget/NormalSettingItem;", "normalSettingItem", "Lcom/tencent/mobileqq/widget/NightModeSettingItem;", "i", "Lcom/tencent/mobileqq/widget/NightModeSettingItem;", "nightModeSettingItem", "Lcom/tencent/mobileqq/widget/WeatherSettingItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/WeatherSettingItem;", "weatherSettingItem", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes11.dex */
public final class bk extends com.tencent.mobileqq.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bottomContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NormalSettingItem normalSettingItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NightModeSettingItem nightModeSettingItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeatherSettingItem weatherSettingItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/bizParts/bk$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.bizParts.bk$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26047);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public bk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void G9() {
        LinearLayout linearLayout;
        NightModeSettingItem nightModeSettingItem;
        View rlRoot;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        this.nightModeSettingItem = new NightModeSettingItem(activity, lifecycleOwner, 0, false, 12, null);
        View view = this.bottomContainer;
        if (view != null && (linearLayout = (LinearLayout) view.findViewById(R.id.umv)) != null && (nightModeSettingItem = this.nightModeSettingItem) != null && (rlRoot = nightModeSettingItem.getRlRoot()) != null) {
            linearLayout.addView(rlRoot);
        }
    }

    private final void H9() {
        LinearLayout linearLayout;
        NormalSettingItem normalSettingItem;
        View rlRoot;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        ViewModel viewModel = getViewModel(QQSettingMeViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QQSettingMeViewModel::class.java)");
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        NormalSettingItem normalSettingItem2 = new NormalSettingItem(activity, (QQSettingMeViewModel) viewModel, lifecycleOwner, 0, 8, null);
        normalSettingItem2.u(new View.OnClickListener() { // from class: com.tencent.mobileqq.bizParts.bj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bk.I9(bk.this, view);
            }
        });
        this.normalSettingItem = normalSettingItem2;
        View view = this.bottomContainer;
        if (view != null && (linearLayout = (LinearLayout) view.findViewById(R.id.un9)) != null && (normalSettingItem = this.normalSettingItem) != null && (rlRoot = normalSettingItem.getRlRoot()) != null) {
            linearLayout.addView(rlRoot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(bk this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSettingMeSettingPart")) {
            ((QQSettingMeViewModel) this$0.getViewModel(QQSettingMeViewModel.class)).N1("d_setting").onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J9() {
        LinearLayout linearLayout;
        WeatherSettingItem weatherSettingItem;
        View root;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        ViewModel viewModel = getViewModel(QQSettingMeViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QQSettingMeViewModel::class.java)");
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        WeatherSettingItem weatherSettingItem2 = new WeatherSettingItem(activity, (QQSettingMeViewModel) viewModel, lifecycleOwner, 0, 8, null);
        weatherSettingItem2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.bizParts.bi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bk.K9(bk.this, view);
            }
        });
        this.weatherSettingItem = weatherSettingItem2;
        View view = this.bottomContainer;
        if (view != null && (linearLayout = (LinearLayout) view.findViewById(R.id.uoa)) != null && (weatherSettingItem = this.weatherSettingItem) != null && (root = weatherSettingItem.getRoot()) != null) {
            linearLayout.addView(root);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(bk this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSettingMeSettingPart")) {
            ((QQSettingMeViewModel) this$0.getViewModel(QQSettingMeViewModel.class)).N1("d_weather").onClick(view);
            VideoReport.setElementParam(view, "is_red_tips_em", 0);
            VideoReport.reportEvent("clck", view, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(bk this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NormalSettingItem normalSettingItem = this$0.normalSettingItem;
        if (normalSettingItem != null) {
            normalSettingItem.s();
        }
        NightModeSettingItem nightModeSettingItem = this$0.nightModeSettingItem;
        if (nightModeSettingItem != null) {
            nightModeSettingItem.y();
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onAccountChanged();
        NightModeSettingItem nightModeSettingItem = this.nightModeSettingItem;
        if (nightModeSettingItem != null) {
            nightModeSettingItem.s();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            view = rootView.findViewById(R.id.um5);
        } else {
            view = null;
        }
        this.bottomContainer = view;
        com.tencent.mobileqq.qui.b.f276860a.a(view, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        H9();
        G9();
        J9();
        View view2 = this.bottomContainer;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.bizParts.bg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    bk.L9(view3);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        NightModeSettingItem nightModeSettingItem = this.nightModeSettingItem;
        if (nightModeSettingItem != null) {
            nightModeSettingItem.x();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartPause(activity);
        WeatherSettingItem weatherSettingItem = this.weatherSettingItem;
        if (weatherSettingItem != null) {
            weatherSettingItem.t(false);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        WeatherSettingItem weatherSettingItem = this.weatherSettingItem;
        if (weatherSettingItem != null) {
            weatherSettingItem.t(true);
        }
        getPartRootView().post(new Runnable() { // from class: com.tencent.mobileqq.bizParts.bh
            @Override // java.lang.Runnable
            public final void run() {
                bk.M9(bk.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.part.a
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        NightModeSettingItem nightModeSettingItem = this.nightModeSettingItem;
        if (nightModeSettingItem != null) {
            nightModeSettingItem.onPostThemeChanged();
        }
    }
}
