package com.tencent.mobileqq.bizParts;

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
import com.tencent.mobileqq.tianshu.ui.RedTouch;
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

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\r\b\u0007\u0018\u0000 Z2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001[B\u0007\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010#\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010(\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010)\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010*\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010>R\u0018\u0010G\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010>R\u0018\u0010I\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00102R\u0018\u0010K\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u00102R\u0018\u0010M\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010,R!\u0010T\u001a\b\u0012\u0004\u0012\u00020O0N8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR!\u0010W\u001a\b\u0012\u0004\u0012\u00020\b0N8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010Q\u001a\u0004\bV\u0010S\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeNavigationPart;", "Lcom/tencent/mobileqq/part/a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "", "y", "", "da", "", "showZPlanOrBanner", "ba", "Landroid/view/ViewGroup;", "container1", "container2", "ca", "U9", com.tencent.luggage.wxa.c8.c.f123400v, "ea", "X9", "T9", "P9", "N9", "Z9", "Y9", "S9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/a;", "bean", "aa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "v", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "onTouch", "onPartResume", "onPartDestroy", "f", "Landroid/view/View;", "topContainerBg", tl.h.F, "topContainer", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "signInContainer", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "signInRedTouch", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "signInWord", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "backIcon", "Lcom/tencent/image/URLImageView;", "E", "Lcom/tencent/image/URLImageView;", "signInIcon", UserInfo.SEX_FEMALE, "leftArrowIcon", "G", "settingIcon", "H", "onlineStatusContainerBelowNav", "I", "onlineStatusContainerInNav", "J", "onlineStatusView", "Landroidx/lifecycle/Observer;", "", "K", "Lkotlin/Lazy;", "R9", "()Landroidx/lifecycle/Observer;", "zPlanOffsetObserver", "L", "Q9", "showZPlanOrBannerObserver", "<init>", "()V", "M", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes11.dex */
public final class QQSettingMeNavigationPart extends com.tencent.mobileqq.part.a implements View.OnClickListener, View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView signInWord;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView backIcon;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private URLImageView signInIcon;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView leftArrowIcon;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView settingIcon;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LinearLayout onlineStatusContainerBelowNav;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private LinearLayout onlineStatusContainerInNav;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View onlineStatusView;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy zPlanOffsetObserver;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy showZPlanOrBannerObserver;

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
    private RedTouch signInRedTouch;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeNavigationPart$a;", "", "", "ALPHA_MAX", "I", "ALPHA_MIN", "", "DP_REAL_CONTAINER_HEIGHT", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.bizParts.QQSettingMeNavigationPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25852);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeNavigationPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new QQSettingMeNavigationPart$zPlanOffsetObserver$2(this));
            this.zPlanOffsetObserver = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new QQSettingMeNavigationPart$showZPlanOrBannerObserver$2(this));
            this.showZPlanOrBannerObserver = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void N9() {
        MutableLiveData<Integer> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).V;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeNavigationPart$bindNavigation$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeNavigationPart.this);
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
                    QQSettingMeNavigationPart.this.Y9();
                    return;
                }
                if (num != null && num.intValue() == 1) {
                    QQSettingMeNavigationPart.this.Z9();
                } else if (num != null && num.intValue() == 2) {
                    QQSettingMeNavigationPart.this.S9();
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.bizParts.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeNavigationPart.O9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void P9() {
        ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).S1().observe(getPartHost().getLifecycleOwner(), Q9());
    }

    private final Observer<Boolean> Q9() {
        return (Observer) this.showZPlanOrBannerObserver.getValue();
    }

    private final Observer<Float> R9() {
        return (Observer) this.zPlanOffsetObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9() {
        View view = this.topContainer;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private final void T9() {
        List<ImageView> listOf;
        VideoReport.setElementId(this.leftArrowIcon, "em_zplan_manage_back");
        VideoReport.setElementId(this.settingIcon, "em_zplan_manage_setting");
        VideoReport.setElementId(this.signInContainer, "em_drawer_sign_up");
        VideoReport.setElementClickPolicy(this.signInContainer, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.signInContainer, ExposurePolicy.REPORT_NONE);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ImageView[]{this.leftArrowIcon, this.settingIcon});
        for (ImageView imageView : listOf) {
            VideoReport.setElementClickPolicy(imageView, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(imageView, ExposurePolicy.REPORT_ALL);
        }
    }

    private final void U9() {
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
        ea(0);
        ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).T1().observe(getPartHost().getLifecycleOwner(), R9());
        MutableLiveData<Boolean> R1 = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final QQSettingMeNavigationPart$initStatusBar$1 qQSettingMeNavigationPart$initStatusBar$1 = new QQSettingMeNavigationPart$initStatusBar$1(this);
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.bizParts.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj2) {
                QQSettingMeNavigationPart.V9(Function1.this, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(int alpha) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3 = null;
        if (alpha <= 0) {
            ea(0);
            URLImageView uRLImageView = this.signInIcon;
            if (uRLImageView != null) {
                uRLImageView.setImageResource(R.drawable.qui_daka_icon_white);
            }
            TextView textView = this.signInWord;
            if (textView != null) {
                textView.setTextColor(ex.b(R.color.qui_common_text_allwhite_primary));
            }
            LinearLayout linearLayout = this.signInContainer;
            if (linearLayout != null) {
                drawable2 = linearLayout.getBackground();
            } else {
                drawable2 = null;
            }
            if (drawable2 != null) {
                drawable2.setAlpha(255);
            }
            ImageView imageView = this.backIcon;
            if (imageView != null) {
                drawable3 = imageView.getBackground();
            }
            if (drawable3 != null) {
                drawable3.setAlpha(255);
            }
            ImageView imageView2 = this.backIcon;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.qui_close_icon_white);
                return;
            }
            return;
        }
        ea(alpha);
        URLImageView uRLImageView2 = this.signInIcon;
        if (uRLImageView2 != null) {
            uRLImageView2.setImageResource(R.drawable.qui_daka);
        }
        TextView textView2 = this.signInWord;
        if (textView2 != null) {
            textView2.setTextColor(ex.b(R.color.qui_common_text_primary));
        }
        LinearLayout linearLayout2 = this.signInContainer;
        if (linearLayout2 != null) {
            drawable = linearLayout2.getBackground();
        } else {
            drawable = null;
        }
        if (drawable != null) {
            drawable.setAlpha(255 - alpha);
        }
        ImageView imageView3 = this.backIcon;
        if (imageView3 != null) {
            drawable3 = imageView3.getBackground();
        }
        if (drawable3 != null) {
            drawable3.setAlpha(255 - alpha);
        }
        ImageView imageView4 = this.backIcon;
        if (imageView4 != null) {
            imageView4.setImageResource(R.drawable.qui_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9() {
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
        if (Intrinsics.areEqual(Boolean.TRUE, ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).S1().getValue())) {
            LinearLayout linearLayout2 = this.onlineStatusContainerBelowNav;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            LinearLayout linearLayout3 = this.onlineStatusContainerInNav;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
        } else {
            LinearLayout linearLayout4 = this.onlineStatusContainerInNav;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            LinearLayout linearLayout5 = this.onlineStatusContainerBelowNav;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
        }
        ImageView imageView2 = this.settingIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ImageView imageView3 = this.leftArrowIcon;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9() {
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
        LinearLayout linearLayout2 = this.onlineStatusContainerBelowNav;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        LinearLayout linearLayout3 = this.onlineStatusContainerInNav;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        ImageView imageView2 = this.settingIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        ImageView imageView3 = this.leftArrowIcon;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa(com.tencent.mobileqq.activity.qqsettingme.bean.a bean) {
        TextView textView = this.signInWord;
        if (textView != null) {
            textView.setText(bean.f184873e);
        }
        RedTouch redTouch = this.signInRedTouch;
        if (redTouch != null) {
            redTouch.clearRedTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(boolean showZPlanOrBanner) {
        if (showZPlanOrBanner) {
            ca(this.onlineStatusContainerInNav, this.onlineStatusContainerBelowNav);
        } else {
            ca(this.onlineStatusContainerBelowNav, this.onlineStatusContainerInNav);
        }
    }

    private final void ca(ViewGroup container1, ViewGroup container2) {
        ViewParent viewParent;
        if (container1 != null) {
            container1.setVisibility(8);
        }
        if (this.onlineStatusView == null) {
            if (container2 != null) {
                container2.setVisibility(8);
            }
        } else {
            if (container2 == null) {
                return;
            }
            container2.setVisibility(0);
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
            container2.addView(this.onlineStatusView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da(int y16) {
        if (Intrinsics.areEqual(Boolean.TRUE, ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).S1().getValue())) {
            if (y16 > com.tencent.mobileqq.activity.qqsettingme.utils.b.b()) {
                LinearLayout linearLayout = this.onlineStatusContainerBelowNav;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            LinearLayout linearLayout2 = this.onlineStatusContainerBelowNav;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            LinearLayout linearLayout3 = this.onlineStatusContainerInNav;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
        }
    }

    private final void ea(int alpha) {
        View view;
        boolean z16 = false;
        if (alpha >= 0 && alpha < 256) {
            z16 = true;
        }
        if (z16 && (view = this.topContainerBg) != null) {
            view.setAlpha(alpha / 255.0f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        float f16;
        int i3;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else if (!FastClickUtils.isFastDoubleClick("QQSettingMeNavigationPart")) {
            QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.ung) {
                RedTouch redTouch = this.signInRedTouch;
                if (redTouch != null) {
                    Intrinsics.checkNotNull(redTouch);
                    if (redTouch.hasRedTouch()) {
                        i3 = 1;
                        VideoReport.setElementParam(v3, "is_red_tips_em", Integer.valueOf(i3));
                        VideoReport.reportEvent("clck", v3, null);
                        qQSettingMeViewModel.N1("d_daily").onClick(v3);
                    }
                }
                i3 = 0;
                VideoReport.setElementParam(v3, "is_red_tips_em", Integer.valueOf(i3));
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
                    QLog.i("QQSettingMeNavigationPart", 2, "onClick title");
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
        ImageView imageView2;
        ImageView imageView3;
        LinearLayout linearLayout2;
        List<View> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        LinearLayout linearLayout3 = null;
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
        LinearLayout linearLayout4 = this.signInContainer;
        if (linearLayout4 != null) {
            uRLImageView = (URLImageView) linearLayout4.findViewById(R.id.und);
        } else {
            uRLImageView = null;
        }
        this.signInIcon = uRLImageView;
        RedTouch redTouch = new RedTouch(getActivity(), this.signInIcon);
        this.signInRedTouch = redTouch;
        RedTouch gravity = redTouch.setGravity(8388661);
        if (gravity != null) {
            gravity.applyTo();
        }
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f165026um4);
        } else {
            imageView = null;
        }
        this.backIcon = imageView;
        if (rootView != null) {
            imageView2 = (ImageView) rootView.findViewById(R.id.f165024um2);
        } else {
            imageView2 = null;
        }
        this.leftArrowIcon = imageView2;
        if (rootView != null) {
            imageView3 = (ImageView) rootView.findViewById(R.id.uog);
        } else {
            imageView3 = null;
        }
        this.settingIcon = imageView3;
        if (rootView != null) {
            linearLayout2 = (LinearLayout) rootView.findViewById(R.id.zxp);
        } else {
            linearLayout2 = null;
        }
        this.onlineStatusContainerBelowNav = linearLayout2;
        if (rootView != null) {
            linearLayout3 = (LinearLayout) rootView.findViewById(R.id.zxq);
        }
        this.onlineStatusContainerInNav = linearLayout3;
        this.onlineStatusView = ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).getOnlineStatusEntranceView(getActivity());
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{this.topContainerBg, this.signInContainer, this.backIcon, this.leftArrowIcon, this.settingIcon});
        for (View view3 : listOf) {
            if (view3 != null) {
                view3.setOnClickListener(this);
            }
            if (view3 != null) {
                view3.setOnTouchListener(this);
            }
        }
        ba(Intrinsics.areEqual(Boolean.TRUE, ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).S1().getValue()));
        U9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        P9();
        N9();
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.a> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).f312705m;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.a, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.a, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeNavigationPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeNavigationPart.this);
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
                QQSettingMeNavigationPart qQSettingMeNavigationPart = QQSettingMeNavigationPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeNavigationPart.aa(it);
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.bizParts.ae
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeNavigationPart.W9(Function1.this, obj);
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
        LinearLayout linearLayout = this.onlineStatusContainerBelowNav;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        LinearLayout linearLayout2 = this.onlineStatusContainerInNav;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
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
        ba(Intrinsics.areEqual(Boolean.TRUE, ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).S1().getValue()));
        T9();
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
