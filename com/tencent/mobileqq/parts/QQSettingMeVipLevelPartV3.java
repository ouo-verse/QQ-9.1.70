package com.tencent.mobileqq.parts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqsettingme.IQQSettingMeExtApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
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

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0019\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0017R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeVipLevelPartV3;", "Lcom/tencent/mobileqq/part/a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "", "N9", "J9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/g;", "bean", "S9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/h;", "nicknameBean", "T9", "M9", "L9", "", "R9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "v", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "", "onTouch", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "level", "Landroid/view/ViewGroup;", tl.h.F, "Landroid/view/ViewGroup;", "vipArea", "i", "Z", "isShowZPlanDrawer", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes16.dex */
public final class QQSettingMeVipLevelPartV3 extends com.tencent.mobileqq.part.a implements View.OnClickListener, View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView level;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup vipArea;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isShowZPlanDrawer;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeVipLevelPartV3$a;", "", "", "DRAWER_LEVEL_URL", "Ljava/lang/String;", "", "LEVEL_ICON_MAX_COUNT", "I", "TAG", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.parts.QQSettingMeVipLevelPartV3$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28326);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeVipLevelPartV3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void J9() {
        MutableLiveData<Integer> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).V;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeVipLevelPartV3$bindContainer$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeVipLevelPartV3.this);
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
                    QQSettingMeVipLevelPartV3.this.isShowZPlanDrawer = true;
                } else if (num != null && num.intValue() == 0) {
                    QQSettingMeVipLevelPartV3.this.isShowZPlanDrawer = false;
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.bs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeVipLevelPartV3.K9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void L9() {
        VideoReport.reportEvent("imp", this.level, null);
    }

    private final void M9() {
        VideoReport.setElementId(this.level, "em_drawer_qqlevel_sign");
        VideoReport.setElementClickPolicy(this.level, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.level, ExposurePolicy.REPORT_NONE);
    }

    private final void N9() {
        ViewStub viewStub;
        TextView textView;
        ViewGroup viewGroup;
        View partRootView = getPartRootView();
        ViewGroup viewGroup2 = null;
        if (partRootView != null) {
            viewStub = (ViewStub) partRootView.findViewById(R.id.f28150i6);
        } else {
            viewStub = null;
        }
        Intrinsics.checkNotNull(viewStub, "null cannot be cast to non-null type android.view.ViewStub");
        viewStub.setLayoutResource(((IQQSettingMeExtApi) QRoute.api(IQQSettingMeExtApi.class)).getVipLevelLayout());
        viewStub.inflate();
        View partRootView2 = getPartRootView();
        if (partRootView2 != null) {
            textView = (TextView) partRootView2.findViewById(R.id.f165032uo0);
        } else {
            textView = null;
        }
        this.level = textView;
        if (textView != null) {
            textView.setText("");
        }
        View partRootView3 = getPartRootView();
        if (partRootView3 != null) {
            viewGroup = (ViewGroup) partRootView3.findViewById(R.id.unr);
        } else {
            viewGroup = null;
        }
        if (viewGroup instanceof ViewGroup) {
            viewGroup2 = viewGroup;
        }
        this.vipArea = viewGroup2;
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
    public static final void Q9(QQSettingMeVipLevelPartV3 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
    }

    private final int R9(com.tencent.mobileqq.activity.qqsettingme.bean.g bean) {
        int n3;
        TextView textView = this.level;
        if (textView == null) {
            return 3;
        }
        Intrinsics.checkNotNull(textView);
        Resources resources = textView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "level!!.resources");
        float dimension = resources.getDimension(R.dimen.b7w);
        if (bean.f184904m == 0) {
            dimension = Utils.n(18.0f, resources);
        }
        TextView textView2 = this.level;
        Intrinsics.checkNotNull(textView2);
        float x16 = textView2.getX() + bean.f184903l + Utils.n(17.0f, resources);
        ViewGroup viewGroup = this.vipArea;
        if (viewGroup != null) {
            n3 = viewGroup.getMeasuredWidth();
        } else {
            n3 = Utils.n(265.0f, resources);
        }
        float f16 = n3 - x16;
        if (dimension <= 1.0f) {
            dimension = 1.0f;
        }
        int floor = (int) Math.floor(f16 / dimension);
        if (QLog.isColorLevel()) {
            QLog.i("QQSettingMeLevelPartV3", 4, "resizeQQLevelIconSize width=,iconSize=" + dimension + ",vipSize=" + bean.f184903l + ",space=" + f16 + ",maxIconSize=" + floor);
        }
        return floor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(com.tencent.mobileqq.activity.qqsettingme.bean.g bean) {
        try {
            if (bean.f184893b != null && getActivity() != null) {
                Resources resources = getActivity().getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).parseQQLevel(resources, bean.f184904m, bean.f184893b.iQQLevel, R9(bean), false));
                ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setTextForAnimation(this.level, spannableStringBuilder, TextView.BufferType.SPANNABLE);
                TextView textView = this.level;
                if (textView != null) {
                    textView.setContentDescription("\u7b49\u7ea7\uff1a" + bean.f184893b.iQQLevel);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeLevelPartV3", 2, "updateQQLevelVipView card == null");
            }
        } catch (Throwable th5) {
            QLog.e("QQSettingMeLevelPartV3", 1, "error:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(com.tencent.mobileqq.activity.qqsettingme.bean.h nicknameBean) {
        TextView textView;
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        if (TextUtils.isEmpty(currentAccountUin) && (textView = this.level) != null) {
            textView.setText("");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else if (!this.isShowZPlanDrawer && !FastClickUtils.isFastDoubleClick("QQSettingMeLevelPartV3")) {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f165032uo0) {
                IVasWebUrl iVasWebUrl = (IVasWebUrl) QRoute.api(IVasWebUrl.class);
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                if (!iVasWebUrl.gotoLevelPage(activity, QQSettingMeVipLevelPartV3$onClick$useNewUrl$1.INSTANCE)) {
                    Intent intent = new Intent();
                    intent.putExtra("url", "https://ti.qq.com/qqlevel/index?_wv=3&_wwv=1&tab=7&source=1");
                    RouteUtils.startActivity(getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER);
                }
                VideoReport.setElementParam(v3, "is_red_tips_em", 0);
                VideoReport.reportEvent("clck", v3, null);
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
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.g, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.g, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeVipLevelPartV3$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeVipLevelPartV3.this);
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
                QQSettingMeVipLevelPartV3 qQSettingMeVipLevelPartV3 = QQSettingMeVipLevelPartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeVipLevelPartV3.S9(it);
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.bp
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeVipLevelPartV3.O9(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.h> mutableLiveData2 = qQSettingMeViewModel.M;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.h, Unit> function12 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.h, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeVipLevelPartV3$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeVipLevelPartV3.this);
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
                QQSettingMeVipLevelPartV3 qQSettingMeVipLevelPartV3 = QQSettingMeVipLevelPartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeVipLevelPartV3.T9(it);
            }
        };
        mutableLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.parts.bq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeVipLevelPartV3.P9(Function1.this, obj);
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
            partRootView.post(new Runnable() { // from class: com.tencent.mobileqq.parts.br
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeVipLevelPartV3.Q9(QQSettingMeVipLevelPartV3.this);
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
        if (v3 != null && !this.isShowZPlanDrawer && v3.getId() == R.id.f165032uo0) {
            ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).c2(v3, event);
        }
        return false;
    }
}
