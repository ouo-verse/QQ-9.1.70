package com.tencent.mobileqq.parts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.fa;
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

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0019\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0017J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeProfilePrettyIconPartV3;", "Lcom/tencent/mobileqq/part/a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mobileqq/utils/fa;", "", "M9", "L9", "J9", "N9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/i;", "bean", "T9", "R9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/h;", "nicknameBean", "S9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "v", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "", "onTouch", "", "rightMargin", "b0", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "prettyIcon", tl.h.F, "Z", "isShowZPlanDrawer", "<init>", "()V", "i", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes16.dex */
public final class QQSettingMeProfilePrettyIconPartV3 extends com.tencent.mobileqq.part.a implements View.OnClickListener, View.OnTouchListener, fa {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView prettyIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isShowZPlanDrawer;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeProfilePrettyIconPartV3$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.parts.QQSettingMeProfilePrettyIconPartV3$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28169);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeProfilePrettyIconPartV3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void J9() {
        MutableLiveData<Integer> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).V;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeProfilePrettyIconPartV3$bindContainer$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeProfilePrettyIconPartV3.this);
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
                    QQSettingMeProfilePrettyIconPartV3.this.isShowZPlanDrawer = true;
                } else if (num != null && num.intValue() == 0) {
                    QQSettingMeProfilePrettyIconPartV3.this.isShowZPlanDrawer = false;
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.bb
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfilePrettyIconPartV3.K9(Function1.this, obj);
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
        ImageView imageView = this.prettyIcon;
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
        VideoReport.reportEvent("imp", this.prettyIcon, null);
    }

    private final void M9() {
        VideoReport.setElementId(this.prettyIcon, "em_bas_good_number");
        VideoReport.setElementClickPolicy(this.prettyIcon, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.prettyIcon, ExposurePolicy.REPORT_NONE);
    }

    private final void N9() {
        ImageView imageView;
        View partRootView = getPartRootView();
        if (partRootView != null) {
            imageView = (ImageView) partRootView.findViewById(R.id.uny);
        } else {
            imageView = null;
        }
        this.prettyIcon = imageView;
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
    public static final void Q9(QQSettingMeProfilePrettyIconPartV3 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
    }

    private final void R9() {
        if (je0.a.a(getActivity())) {
            ImageView imageView = this.prettyIcon;
            if (imageView != null) {
                imageView.setColorFilter(1996488704);
                return;
            }
            return;
        }
        ImageView imageView2 = this.prettyIcon;
        if (imageView2 != null) {
            imageView2.setColorFilter(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(com.tencent.mobileqq.activity.qqsettingme.bean.h nicknameBean) {
        ImageView imageView;
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        if (TextUtils.isEmpty(currentAccountUin) && (imageView = this.prettyIcon) != null) {
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(com.tencent.mobileqq.activity.qqsettingme.bean.i bean) {
        ImageView imageView = this.prettyIcon;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (bean.f184913d != null) {
            ImageView imageView2 = this.prettyIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            Drawable drawable = bean.f184913d;
            if (drawable instanceof FastDynamicDrawable) {
                Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable");
                ((FastDynamicDrawable) drawable).setLoopCount(1);
                Drawable drawable2 = bean.f184913d;
                Intrinsics.checkNotNull(drawable2, "null cannot be cast to non-null type com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable");
                ((FastDynamicDrawable) drawable2).restart();
            }
            ImageView imageView3 = this.prettyIcon;
            if (imageView3 != null) {
                imageView3.setImageDrawable(bean.f184913d);
            }
            R9();
            return;
        }
        if (!bean.f184910a || bean.f184911b == null || bean.f184912c == null) {
            return;
        }
        ImageView imageView4 = this.prettyIcon;
        if (imageView4 != null) {
            imageView4.setVisibility(0);
        }
        ImageView imageView5 = this.prettyIcon;
        if (imageView5 != null) {
            imageView5.setImageDrawable(bean.f184912c);
        }
        R9();
    }

    @Override // com.tencent.mobileqq.utils.fa
    public void b0(int rightMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, rightMargin);
            return;
        }
        QLog.i("QQSettingMeProfileCardPartV3", 1, "padding change to " + rightMargin);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else if (!this.isShowZPlanDrawer && !FastClickUtils.isFastDoubleClick("QQSettingMeProfileCardPartV3")) {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.uny) {
                ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_pretty_num").onClick(v3);
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
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.h> mutableLiveData = qQSettingMeViewModel.M;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.h, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.h, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeProfilePrettyIconPartV3$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfilePrettyIconPartV3.this);
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
                QQSettingMeProfilePrettyIconPartV3 qQSettingMeProfilePrettyIconPartV3 = QQSettingMeProfilePrettyIconPartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfilePrettyIconPartV3.S9(it);
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.ay
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfilePrettyIconPartV3.O9(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.i> mutableLiveData2 = qQSettingMeViewModel.N;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.i, Unit> function12 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.i, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeProfilePrettyIconPartV3$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfilePrettyIconPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.i iVar) {
                invoke2(iVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.i it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeProfilePrettyIconPartV3 qQSettingMeProfilePrettyIconPartV3 = QQSettingMeProfilePrettyIconPartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfilePrettyIconPartV3.T9(it);
            }
        };
        mutableLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.parts.az
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfilePrettyIconPartV3.P9(Function1.this, obj);
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
            partRootView.post(new Runnable() { // from class: com.tencent.mobileqq.parts.ba
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeProfilePrettyIconPartV3.Q9(QQSettingMeProfilePrettyIconPartV3.this);
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
        if (v3 != null && !this.isShowZPlanDrawer && v3.getId() == R.id.uny) {
            ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).c2(v3, event);
        }
        return false;
    }
}
