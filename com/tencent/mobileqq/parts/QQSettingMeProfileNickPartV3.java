package com.tencent.mobileqq.parts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dh;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.utils.fa;
import com.tencent.mobileqq.vas.flash.VipFlashNickNameView;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.vip.api.IVipColorName;
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

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0019\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0017J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\f\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeProfileNickPartV3;", "Lcom/tencent/mobileqq/part/a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mobileqq/utils/fa;", "", "K9", "N9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/g;", "bean", "R9", "", "nickName", "S9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/h;", "nicknameBean", "T9", "M9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "v", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "", "onTouch", "", "rightMargin", "b0", "f", "Landroid/view/View;", "nickNameArea", "Lcom/tencent/mobileqq/vas/flash/VipFlashNickNameView;", tl.h.F, "Lcom/tencent/mobileqq/vas/flash/VipFlashNickNameView;", "i", "Z", "isShowZPlanDrawer", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes16.dex */
public final class QQSettingMeProfileNickPartV3 extends com.tencent.mobileqq.part.a implements View.OnClickListener, View.OnTouchListener, fa {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View nickNameArea;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VipFlashNickNameView nickName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isShowZPlanDrawer;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeProfileNickPartV3$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.parts.QQSettingMeProfileNickPartV3$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28143);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeProfileNickPartV3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void K9() {
        MutableLiveData<Integer> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).V;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeProfileNickPartV3$bindContainer$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileNickPartV3.this);
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
                    QQSettingMeProfileNickPartV3.this.isShowZPlanDrawer = true;
                } else if (num != null && num.intValue() == 0) {
                    QQSettingMeProfileNickPartV3.this.isShowZPlanDrawer = false;
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.ax
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileNickPartV3.L9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void M9() {
        VideoReport.setElementId(this.nickNameArea, "em_bas_my_qq_data_card");
        VideoReport.setElementClickPolicy(this.nickNameArea, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.nickNameArea, ExposurePolicy.REPORT_NONE);
    }

    private final void N9() {
        View view;
        VipFlashNickNameView vipFlashNickNameView;
        View partRootView = getPartRootView();
        VipFlashNickNameView vipFlashNickNameView2 = null;
        if (partRootView != null) {
            view = partRootView.findViewById(R.id.unv);
        } else {
            view = null;
        }
        this.nickNameArea = view;
        View partRootView2 = getPartRootView();
        if (partRootView2 != null) {
            vipFlashNickNameView2 = (VipFlashNickNameView) partRootView2.findViewById(R.id.unu);
        }
        this.nickName = vipFlashNickNameView2;
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "sMobileQQ.peekAppRuntime().currentAccountUin");
        if (!((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(this.nickName, currentAccountUin, false, false) && (vipFlashNickNameView = this.nickName) != null) {
            vipFlashNickNameView.setTextColor(ex.b(R.color.qui_common_text_primary));
        }
        dh.f307632a.b(this);
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
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(com.tencent.mobileqq.activity.qqsettingme.bean.g bean) {
        CharSequence charSequence;
        try {
            if (bean.f184893b != null && getActivity() != null) {
                if (AppSetting.f99565y) {
                    VipFlashNickNameView vipFlashNickNameView = this.nickName;
                    View view = null;
                    if (vipFlashNickNameView != null) {
                        charSequence = vipFlashNickNameView.getText();
                    } else {
                        charSequence = null;
                    }
                    String str = "";
                    if (charSequence == null) {
                        charSequence = "";
                    }
                    StringBuilder sb5 = new StringBuilder(charSequence);
                    if (bean.f184895d) {
                        str = "\u4f60\u662f\u5c0a\u8d35\u7684\u8d85\u7ea7\u4f1a\u5458";
                    } else if (bean.f184896e) {
                        str = "\u4f60\u662f\u5c0a\u8d35\u7684\u4f1a\u5458";
                    }
                    sb5.append(str);
                    if (bean.f184893b.iQQLevel > 0) {
                        sb5.append(" \u7b49\u7ea7");
                        sb5.append(bean.f184893b.iQQLevel);
                    }
                    View partRootView = getPartRootView();
                    if (partRootView != null) {
                        view = partRootView.findViewById(R.id.unq);
                    }
                    if (view != null) {
                        view.setContentDescription(sb5.toString());
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeProfileCardPartV3", 2, "updateQQLevelVipView card == null");
            }
        } catch (Throwable th5) {
            QLog.e("QQSettingMeProfileCardPartV3", 1, "error:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(String nickName) {
        VipFlashNickNameView vipFlashNickNameView = this.nickName;
        if (vipFlashNickNameView != null) {
            vipFlashNickNameView.setText(nickName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(com.tencent.mobileqq.activity.qqsettingme.bean.h nicknameBean) {
        CharSequence charSequence;
        View view;
        VipFlashNickNameView vipFlashNickNameView;
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        CharSequence charSequence2 = null;
        if (TextUtils.isEmpty(currentAccountUin)) {
            VipFlashNickNameView vipFlashNickNameView2 = this.nickName;
            if (vipFlashNickNameView2 != null) {
                vipFlashNickNameView2.setText("");
            }
            VipFlashNickNameView vipFlashNickNameView3 = this.nickName;
            if (vipFlashNickNameView3 != null) {
                vipFlashNickNameView3.setCompoundDrawables(null, null, null, null);
                return;
            }
            return;
        }
        VipFlashNickNameView vipFlashNickNameView4 = this.nickName;
        if (vipFlashNickNameView4 != null) {
            vipFlashNickNameView4.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
        String str = nicknameBean.f184909a;
        VipFlashNickNameView vipFlashNickNameView5 = this.nickName;
        if (vipFlashNickNameView5 != null) {
            charSequence = vipFlashNickNameView5.getText();
        } else {
            charSequence = null;
        }
        if (!Utils.p(str, charSequence) && (vipFlashNickNameView = this.nickName) != null) {
            vipFlashNickNameView.setText(nicknameBean.f184909a);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeProfileCardPartV3", 2, "updateLevelAndVip from updateAccountInfo");
        }
        qQSettingMeViewModel.N1("d_head_vip").e();
        if (AppSetting.f99565y) {
            View partRootView = getPartRootView();
            if (partRootView != null) {
                view = partRootView.findViewById(R.id.unq);
            } else {
                view = null;
            }
            if (view != null) {
                VipFlashNickNameView vipFlashNickNameView6 = this.nickName;
                if (vipFlashNickNameView6 != null) {
                    charSequence2 = vipFlashNickNameView6.getText();
                }
                view.setContentDescription(charSequence2);
            }
        }
        ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).updateTextColorGradientWithColor(this.nickName, currentAccountUin, ex.b(R.color.qui_common_text_primary), false);
    }

    @Override // com.tencent.mobileqq.utils.fa
    public void b0(int rightMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, rightMargin);
            return;
        }
        QLog.i("QQSettingMeProfileCardPartV3", 1, "padding change to " + rightMargin);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else if (!this.isShowZPlanDrawer && !FastClickUtils.isFastDoubleClick("QQSettingMeProfileCardPartV3")) {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.unv) {
                ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_nickname").onClick(v3);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        K9();
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.g> mutableLiveData = qQSettingMeViewModel.G;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.g, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.g, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeProfileNickPartV3$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileNickPartV3.this);
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
                QQSettingMeProfileNickPartV3 qQSettingMeProfileNickPartV3 = QQSettingMeProfileNickPartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileNickPartV3.R9(it);
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.au
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileNickPartV3.O9(Function1.this, obj);
            }
        });
        MutableLiveData<String> mutableLiveData2 = qQSettingMeViewModel.L;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeProfileNickPartV3$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileNickPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeProfileNickPartV3.this.S9(str);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                }
            }
        };
        mutableLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.parts.av
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileNickPartV3.P9(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.h> mutableLiveData3 = qQSettingMeViewModel.M;
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.h, Unit> function13 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.h, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeProfileNickPartV3$onPartCreate$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileNickPartV3.this);
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
                QQSettingMeProfileNickPartV3 qQSettingMeProfileNickPartV3 = QQSettingMeProfileNickPartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileNickPartV3.T9(it);
            }
        };
        mutableLiveData3.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.parts.aw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileNickPartV3.Q9(Function1.this, obj);
            }
        });
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        if (v3 != null && !this.isShowZPlanDrawer && v3.getId() == R.id.unv) {
            ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).c2(v3, event);
        }
        return false;
    }
}
