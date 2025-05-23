package com.tencent.mobileqq.parts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqsettingme.IQQSettingMeExtApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0017R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010&\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeVipNameplatePartV3;", "Lcom/tencent/mobileqq/part/a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "", "M9", "L9", "N9", "J9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/g;", "bean", "R9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/h;", "nicknameBean", "S9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "v", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "", "onTouch", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "vipIcon", tl.h.F, "vipPendantIcon", "i", "Z", "isShowZPlanDrawer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "namePlateView", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes16.dex */
public final class QQSettingMeVipNameplatePartV3 extends com.tencent.mobileqq.part.a implements View.OnClickListener, View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView vipIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView vipPendantIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isShowZPlanDrawer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View namePlateView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeVipNameplatePartV3$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.parts.QQSettingMeVipNameplatePartV3$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28381);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeVipNameplatePartV3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void J9() {
        MutableLiveData<Integer> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).V;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeVipNameplatePartV3$bindContainer$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeVipNameplatePartV3.this);
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
                if (num != null && num.intValue() == 1) {
                    QQSettingMeVipNameplatePartV3.this.isShowZPlanDrawer = true;
                } else if (num != null && num.intValue() == 0) {
                    QQSettingMeVipNameplatePartV3.this.isShowZPlanDrawer = false;
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.ca
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeVipNameplatePartV3.K9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void L9() {
        boolean z16;
        ImageView imageView = this.vipIcon;
        boolean z17 = false;
        if (imageView != null) {
            if (imageView.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (!z17) {
            return;
        }
        VideoReport.reportEvent("imp", this.vipIcon, null);
    }

    private final void M9() {
        VideoReport.setElementId(this.vipIcon, "em_bas_dogtag");
        VideoReport.setElementClickPolicy(this.vipIcon, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.vipIcon, ExposurePolicy.REPORT_NONE);
    }

    private final void N9() {
        ViewStub viewStub;
        ImageView imageView;
        View partRootView = getPartRootView();
        ImageView imageView2 = null;
        if (partRootView != null) {
            viewStub = (ViewStub) partRootView.findViewById(R.id.f28180i9);
        } else {
            viewStub = null;
        }
        Intrinsics.checkNotNull(viewStub, "null cannot be cast to non-null type android.view.ViewStub");
        viewStub.setLayoutResource(((IQQSettingMeExtApi) QRoute.api(IQQSettingMeExtApi.class)).getVipNameplateLayout());
        this.namePlateView = viewStub.inflate();
        View partRootView2 = getPartRootView();
        if (partRootView2 != null) {
            imageView = (ImageView) partRootView2.findViewById(R.id.uo6);
        } else {
            imageView = null;
        }
        this.vipIcon = imageView;
        View partRootView3 = getPartRootView();
        if (partRootView3 != null) {
            imageView2 = (ImageView) partRootView3.findViewById(R.id.uo7);
        }
        this.vipPendantIcon = imageView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QQSettingMeVipNameplatePartV3 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d0, code lost:
    
        if (r2 != false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R9(com.tencent.mobileqq.activity.qqsettingme.bean.g bean) {
        boolean z16;
        boolean z17;
        boolean z18;
        try {
            if (bean.f184893b != null && getActivity() != null && this.vipIcon != null && this.vipPendantIcon != null) {
                Resources resources = getActivity().getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
                ImageView imageView = this.vipPendantIcon;
                int i3 = 8;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                if (com.tencent.mobileqq.activity.qqsettingme.utils.b.e(bean)) {
                    ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setVipExtIcon(getActivity(), this.vipPendantIcon, bean.f184893b.nameplateExtId, false);
                }
                if (QQTheme.isNowSimpleUI() && !VasInjectApi.getInstance().isShowVipIconForSimpleMode()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (bean.f184901j != null && bean.f184902k != 0 && !z16) {
                    ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setVipCardDrawable(resources, this.vipIcon, bean.f184901j, ResourcesCompat.getDrawable(resources, bean.f184902k, null), false);
                    ImageView imageView2 = this.vipIcon;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                    ImageView imageView3 = this.vipIcon;
                    if (imageView3 != null) {
                        imageView3.setContentDescription(HardCodeUtil.qqStr(R.string.vhq));
                    }
                    ImageView imageView4 = this.vipIcon;
                    if (imageView4 != null) {
                        imageView4.setFocusableInTouchMode(true);
                    }
                } else {
                    ImageView imageView5 = this.vipIcon;
                    if (imageView5 != null) {
                        imageView5.setVisibility(8);
                    }
                    ImageView imageView6 = this.vipIcon;
                    if (imageView6 != null) {
                        imageView6.setOnTouchListener(null);
                    }
                }
                View view = this.namePlateView;
                if (view != null) {
                    ImageView imageView7 = this.vipIcon;
                    if (imageView7 != null && imageView7.getVisibility() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        ImageView imageView8 = this.vipPendantIcon;
                        if (imageView8 != null && imageView8.getVisibility() == 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                    }
                    i3 = 0;
                    view.setVisibility(i3);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeVipNameplatePartV3", 2, "updateQQLevelVipView card == null");
            }
        } catch (Throwable th5) {
            QLog.e("QQSettingMeVipNameplatePartV3", 1, "error:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(com.tencent.mobileqq.activity.qqsettingme.bean.h nicknameBean) {
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        if (TextUtils.isEmpty(currentAccountUin)) {
            ImageView imageView = this.vipIcon;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.vipPendantIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            View view = this.namePlateView;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else if (!this.isShowZPlanDrawer && !FastClickUtils.isFastDoubleClick("QQSettingMeVipNameplatePartV3")) {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.uo7) {
                ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_head_vip").onClick(v3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        N9();
        M9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        J9();
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.g> mutableLiveData = qQSettingMeViewModel.G;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.g, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.g, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeVipNameplatePartV3$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeVipNameplatePartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.g gVar) {
                invoke2(gVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.g it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeVipNameplatePartV3 qQSettingMeVipNameplatePartV3 = QQSettingMeVipNameplatePartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeVipNameplatePartV3.R9(it);
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.bw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeVipNameplatePartV3.O9(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.h> mutableLiveData2 = qQSettingMeViewModel.M;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.h, Unit> function12 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.h, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeVipNameplatePartV3$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeVipNameplatePartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.h hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.h it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeVipNameplatePartV3 qQSettingMeVipNameplatePartV3 = QQSettingMeVipNameplatePartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeVipNameplatePartV3.S9(it);
            }
        };
        mutableLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.parts.bx
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeVipNameplatePartV3.P9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.post(new Runnable() { // from class: com.tencent.mobileqq.parts.bz
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeVipNameplatePartV3.Q9(QQSettingMeVipNameplatePartV3.this);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        if (v3 != null && !this.isShowZPlanDrawer && v3.getId() == R.id.uo7) {
            ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).c2(v3, event);
        }
        return false;
    }
}
