package com.tencent.mobileqq.parts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u0000 N2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001OB\u0007\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010 \u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010%\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010&\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010'\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010(\u001a\u00020\u0006H\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00100R\u0018\u0010A\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010*R!\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR!\u0010K\u001a\b\u0012\u0004\u0012\u00020H0B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010F\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeNavigationPartV3;", "Lcom/tencent/mobileqq/part/a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "", "showZPlanOrBanner", "", "ea", "Landroid/view/ViewGroup;", "container1", "ga", "W9", "V9", "R9", "Q9", "O9", "ca", "ba", "U9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/a;", "bean", "da", "", com.tencent.luggage.wxa.c8.c.f123400v, "ha", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "v", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "onTouch", "onPartResume", "onPartDestroy", "onPostThemeChanged", "f", "Landroid/view/View;", "topContainerBg", tl.h.F, "topContainer", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "signInContainer", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "signInWord", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "backIcon", "Lcom/tencent/image/URLImageView;", "D", "Lcom/tencent/image/URLImageView;", "signInIcon", "E", "onlineStatusContainerInNav", UserInfo.SEX_FEMALE, "onlineStatusView", "Landroidx/lifecycle/Observer;", "G", "Lkotlin/Lazy;", "S9", "()Landroidx/lifecycle/Observer;", "showZPlanOrBannerObserver", "", "H", "T9", "zPlanOffsetObserver", "<init>", "()V", "I", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes16.dex */
public final class QQSettingMeNavigationPartV3 extends com.tencent.mobileqq.part.a implements View.OnClickListener, View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView backIcon;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private URLImageView signInIcon;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private LinearLayout onlineStatusContainerInNav;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View onlineStatusView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy showZPlanOrBannerObserver;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy zPlanOffsetObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View topContainerBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View topContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout signInContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView signInWord;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeNavigationPartV3$a;", "", "", "ALPHA_MAX", "I", "ALPHA_MIN", "", "DP_REAL_CONTAINER_HEIGHT", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.parts.QQSettingMeNavigationPartV3$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27939);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeNavigationPartV3() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new QQSettingMeNavigationPartV3$showZPlanOrBannerObserver$2(this));
            this.showZPlanOrBannerObserver = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new QQSettingMeNavigationPartV3$zPlanOffsetObserver$2(this));
            this.zPlanOffsetObserver = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void O9() {
        MutableLiveData<Integer> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).V;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeNavigationPartV3$bindNavigation$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeNavigationPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                if (num != null && num.intValue() == 0) {
                    QQSettingMeNavigationPartV3.this.ba();
                    return;
                }
                if (num != null && num.intValue() == 1) {
                    QQSettingMeNavigationPartV3.this.ca();
                } else if (num != null && num.intValue() == 2) {
                    QQSettingMeNavigationPartV3.this.U9();
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeNavigationPartV3.P9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Q9() {
        ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).S1().observe(getPartHost().getLifecycleOwner(), S9());
    }

    private final void R9() {
        VideoReport.reportEvent("imp", this.signInContainer, null);
    }

    private final Observer<Boolean> S9() {
        return (Observer) this.showZPlanOrBannerObserver.getValue();
    }

    private final Observer<Float> T9() {
        return (Observer) this.zPlanOffsetObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9() {
        View view = this.topContainer;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private final void V9() {
        VideoReport.setElementId(this.signInContainer, "em_drawer_sign_up");
        VideoReport.setElementClickPolicy(this.signInContainer, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.signInContainer, ExposurePolicy.REPORT_NONE);
    }

    private final void W9() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Object obj;
        View view = this.topContainer;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, 0);
        }
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
        marginLayoutParams.topMargin = statusBarHeight;
        View view2 = this.topContainer;
        if (view2 != null) {
            view2.setLayoutParams(marginLayoutParams);
        }
        View view3 = this.topContainerBg;
        if (view3 != null) {
            obj = view3.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams2 = (ViewGroup.MarginLayoutParams) obj;
        }
        int d16 = ex.d(Float.valueOf(48.0f));
        if (marginLayoutParams2 == null) {
            marginLayoutParams2 = new ViewGroup.MarginLayoutParams(-1, d16);
        }
        marginLayoutParams2.height = statusBarHeight + d16;
        View view4 = this.topContainerBg;
        if (view4 != null) {
            view4.setLayoutParams(marginLayoutParams2);
        }
        MutableLiveData<Boolean> R1 = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final QQSettingMeNavigationPartV3$initStatusBar$1 qQSettingMeNavigationPartV3$initStatusBar$1 = new QQSettingMeNavigationPartV3$initStatusBar$1(this);
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj2) {
                QQSettingMeNavigationPartV3.X9(Function1.this, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(QQSettingMeNavigationPartV3 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba() {
        View view = this.topContainer;
        if (view != null) {
            view.setVisibility(0);
        }
        LinearLayout linearLayout = this.signInContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        ImageView imageView = this.backIcon;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.onlineStatusContainerInNav;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca() {
        View view = this.topContainer;
        if (view != null) {
            view.setVisibility(0);
        }
        LinearLayout linearLayout = this.signInContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ImageView imageView = this.backIcon;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.onlineStatusContainerInNav;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da(com.tencent.mobileqq.activity.qqsettingme.bean.a bean) {
        TextView textView = this.signInWord;
        if (textView != null) {
            textView.setText(bean.f184873e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ea(boolean showZPlanOrBanner) {
        ga(this.onlineStatusContainerInNav);
    }

    private final void ga(ViewGroup container1) {
        ViewParent viewParent;
        if (container1 == null) {
            return;
        }
        if (this.onlineStatusView == null) {
            container1.setVisibility(8);
            return;
        }
        container1.setVisibility(0);
        View view = this.onlineStatusView;
        ViewGroup viewGroup = null;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        }
        if (viewGroup != null) {
            viewGroup.removeView(this.onlineStatusView);
        }
        container1.addView(this.onlineStatusView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha(int alpha) {
        if (alpha <= 0) {
            ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).updateOnlineTextColor(R.color.qui_common_text_allwhite_primary, this.onlineStatusView);
        } else {
            ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).updateOnlineTextColor(R.color.qui_common_text_primary, this.onlineStatusView);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        float f16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else if (!FastClickUtils.isFastDoubleClick("QQSettingMeNavigationPartV3")) {
            QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.ung) {
                VideoReport.setElementParam(v3, "is_red_tips_em", 0);
                VideoReport.reportEvent("clck", v3, null);
                qQSettingMeViewModel.N1("d_daily").onClick(v3);
            } else if (num != null && num.intValue() == R.id.f165026um4) {
                qQSettingMeViewModel.N1("d_common").onClick(v3);
            } else if (num != null && num.intValue() == R.id.f165024um2) {
                qQSettingMeViewModel.f312693b0.postValue(2);
            } else if (num != null && num.intValue() == R.id.uog) {
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                iZPlanApi.startAvatarSettingActivity(activity, "setting_me");
            } else if (num != null && num.intValue() == R.id.unm) {
                View view = this.topContainerBg;
                if (view != null) {
                    f16 = view.getAlpha();
                } else {
                    f16 = 0.0f;
                }
                if (f16 > 0.0f) {
                    QLog.i("QQSettingMeNavigationPartV3", 2, "onClick title");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        View view2;
        LinearLayout linearLayout;
        TextView textView;
        URLImageView uRLImageView;
        ImageView imageView;
        List<View> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        LinearLayout linearLayout2 = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.unm);
        } else {
            view = null;
        }
        this.topContainerBg = view;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.unl);
        } else {
            view2 = null;
        }
        this.topContainer = view2;
        if (rootView != null) {
            linearLayout = (LinearLayout) rootView.findViewById(R.id.ung);
        } else {
            linearLayout = null;
        }
        this.signInContainer = linearLayout;
        if (linearLayout != null) {
            textView = (TextView) linearLayout.findViewById(R.id.unf);
        } else {
            textView = null;
        }
        this.signInWord = textView;
        LinearLayout linearLayout3 = this.signInContainer;
        if (linearLayout3 != null) {
            uRLImageView = (URLImageView) linearLayout3.findViewById(R.id.und);
        } else {
            uRLImageView = null;
        }
        this.signInIcon = uRLImageView;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f165026um4);
        } else {
            imageView = null;
        }
        this.backIcon = imageView;
        if (rootView != null) {
            linearLayout2 = (LinearLayout) rootView.findViewById(R.id.zxq);
        }
        this.onlineStatusContainerInNav = linearLayout2;
        this.onlineStatusView = ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).getOnlineStatusEntranceView(getActivity());
        ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).updateOnlineStatusViewPadding(this.onlineStatusView);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{this.topContainerBg, this.signInContainer, this.backIcon});
        for (View view3 : listOf) {
            if (view3 != null) {
                view3.setOnClickListener(this);
            }
            if (view3 != null) {
                view3.setOnTouchListener(this);
            }
        }
        ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).T1().observe(getPartHost().getLifecycleOwner(), T9());
        ea(Intrinsics.areEqual(Boolean.TRUE, ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).S1().getValue()));
        W9();
        V9();
        MutableLiveData<Boolean> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).f312699h0;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeNavigationPartV3$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeNavigationPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                } else if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                    QQSettingMeNavigationPartV3.this.ha(0);
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeNavigationPartV3.Y9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        Q9();
        O9();
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.a> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).f312705m;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.a, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.a, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeNavigationPartV3$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeNavigationPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.a it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeNavigationPartV3 qQSettingMeNavigationPartV3 = QQSettingMeNavigationPartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeNavigationPartV3.da(it);
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeNavigationPartV3.Z9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        LinearLayout linearLayout = this.onlineStatusContainerInNav;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        ea(Intrinsics.areEqual(Boolean.TRUE, ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).S1().getValue()));
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.post(new Runnable() { // from class: com.tencent.mobileqq.parts.w
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeNavigationPartV3.aa(QQSettingMeNavigationPartV3.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void onPostThemeChanged() {
        Integer num;
        View findViewById;
        Drawable background;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        int i3 = !isNowThemeIsNight ? 1 : 0;
        View partRootView = getPartRootView();
        if (partRootView != null && (findViewById = partRootView.findViewById(R.id.zxq)) != null && (background = findViewById.getBackground()) != null) {
            num = Integer.valueOf(background.getAlpha());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 255 && !isNowThemeIsNight) {
            i3 = 0;
        }
        ha(i3);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        Integer num;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        boolean z18 = true;
        if ((num != null && num.intValue() == R.id.ung) || (num != null && num.intValue() == R.id.f165026um4)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || (num != null && num.intValue() == R.id.f165024um2)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 && (num == null || num.intValue() != R.id.uog)) {
            z18 = false;
        }
        if (z18) {
            ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).c2(v3, event);
        }
        return false;
    }
}
