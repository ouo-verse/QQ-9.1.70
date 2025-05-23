package com.tencent.mobileqq.bizParts;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeZPlanFloatingViewPart;", "Lcom/tencent/mobileqq/part/a;", "", "M9", "N9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "Landroid/view/ViewStub;", "f", "Landroid/view/ViewStub;", "viewStub", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", tl.h.F, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "zPlanMenuFloatingView", "", "i", "I", "zPlanMenuDefaultHeight", "Ljava/util/concurrent/atomic/AtomicBoolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInit", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QQSettingMeZPlanFloatingViewPart extends com.tencent.mobileqq.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewStub viewStub;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUSHalfScreenFloatingView zPlanMenuFloatingView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int zPlanMenuDefaultHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isInit;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeZPlanFloatingViewPart$a;", "", "", "TAG", "Ljava/lang/String;", "", "ZPLAN_MENU_DEFAULT_HEIGHT", UserInfo.SEX_FEMALE, "ZPLAN_MENU_DEFAULT_HEIGHT_RATE", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.bizParts.QQSettingMeZPlanFloatingViewPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/bizParts/QQSettingMeZPlanFloatingViewPart$b", "Lcom/tencent/mobileqq/widget/qus/a;", "", "onShowDefault", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QUSHalfScreenFloatingView f200433d;

        b(QUSHalfScreenFloatingView qUSHalfScreenFloatingView) {
            this.f200433d = qUSHalfScreenFloatingView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qUSHalfScreenFloatingView);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefault() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f200433d.setVisibility(0);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/bizParts/QQSettingMeZPlanFloatingViewPart$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "defaultHeight", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f200434d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQSettingMeZPlanFloatingViewPart f200435e;

        c(View view, QQSettingMeZPlanFloatingViewPart qQSettingMeZPlanFloatingViewPart) {
            this.f200434d = view;
            this.f200435e = qQSettingMeZPlanFloatingViewPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) qQSettingMeZPlanFloatingViewPart);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        /* renamed from: createContentView */
        public View getF57179d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f200434d;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int defaultHeight() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.f200435e.zPlanMenuFloatingView;
                int i16 = 0;
                if (qUSHalfScreenFloatingView != null) {
                    i3 = qUSHalfScreenFloatingView.F();
                } else {
                    i3 = 0;
                }
                if (i3 > 0) {
                    i16 = Math.min(this.f200435e.zPlanMenuDefaultHeight, i3 - ex.d(Float.valueOf(70.0f)));
                }
                ((QQSettingMeViewModel) this.f200435e.getViewModel(QQSettingMeViewModel.class)).f312701i0.postValue(Integer.valueOf(i16));
                return i16;
            }
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26308);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeZPlanFloatingViewPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isInit = new AtomicBoolean(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.zPlanMenuFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9() {
        ViewGroup viewGroup;
        View view;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView;
        if (this.zPlanMenuFloatingView == null) {
            ViewStub viewStub = this.viewStub;
            if (viewStub != null) {
                view = viewStub.inflate();
            } else {
                view = null;
            }
            if (view instanceof QUSHalfScreenFloatingView) {
                qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) view;
            } else {
                qUSHalfScreenFloatingView = null;
            }
            this.zPlanMenuFloatingView = qUSHalfScreenFloatingView;
        }
        this.zPlanMenuDefaultHeight = (int) (((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).Q1() * 0.37f);
        final QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.zPlanMenuFloatingView;
        if (qUSHalfScreenFloatingView2 != null) {
            qUSHalfScreenFloatingView2.setVisibility(8);
            qUSHalfScreenFloatingView2.r();
            qUSHalfScreenFloatingView2.q();
            qUSHalfScreenFloatingView2.setIsHeightWrapContent(true);
            qUSHalfScreenFloatingView2.setEnableParentDisallowInterruptTouchEvent(true);
            qUSHalfScreenFloatingView2.setOnDismissStartListener(new QUSBaseHalfScreenFloatingView.m() { // from class: com.tencent.mobileqq.bizParts.bs
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.m
                public final void a() {
                    QQSettingMeZPlanFloatingViewPart.O9(QQSettingMeZPlanFloatingViewPart.this);
                }
            });
            qUSHalfScreenFloatingView2.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.bizParts.bt
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    QQSettingMeZPlanFloatingViewPart.P9(QUSHalfScreenFloatingView.this);
                }
            });
            qUSHalfScreenFloatingView2.j(new b(qUSHalfScreenFloatingView2));
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.qq_setting_me_layout_zplan_menu, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(activity).inflate(R\u2026_layout_zplan_menu, null)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.zPlanMenuFloatingView;
        if (qUSHalfScreenFloatingView3 != null) {
            qUSHalfScreenFloatingView3.setQUSDragFloatController(new c(inflate, this));
        }
        ViewParent parent = inflate.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.setBackground(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(QQSettingMeZPlanFloatingViewPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((QQSettingMeViewModel) this$0.getViewModel(QQSettingMeViewModel.class)).f312693b0.postValue(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QUSHalfScreenFloatingView this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewStub viewStub;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            viewStub = (ViewStub) rootView.findViewById(R.id.f1194376u);
        } else {
            viewStub = null;
        }
        this.viewStub = viewStub;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        final QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        MutableLiveData<Integer> mutableLiveData = qQSettingMeViewModel.f312693b0;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeZPlanFloatingViewPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeZPlanFloatingViewPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                QUSHalfScreenFloatingView qUSHalfScreenFloatingView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                if (num != null && num.intValue() == 2) {
                    QQSettingMeZPlanFloatingViewPart.this.M9();
                } else {
                    if (num == null || num.intValue() != 1 || (qUSHalfScreenFloatingView = QQSettingMeZPlanFloatingViewPart.this.zPlanMenuFloatingView) == null) {
                        return;
                    }
                    qUSHalfScreenFloatingView.N(0);
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.bizParts.bp
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZPlanFloatingViewPart.Q9(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> mutableLiveData2 = qQSettingMeViewModel.f312696e0;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeZPlanFloatingViewPart$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeZPlanFloatingViewPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QUSHalfScreenFloatingView qUSHalfScreenFloatingView = QQSettingMeZPlanFloatingViewPart.this.zPlanMenuFloatingView;
                if (qUSHalfScreenFloatingView != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qUSHalfScreenFloatingView.setOutSideTouchEnable(it.booleanValue());
                }
            }
        };
        mutableLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.bizParts.bq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZPlanFloatingViewPart.R9(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> mutableLiveData3 = qQSettingMeViewModel.f312695d0;
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>(qQSettingMeViewModel) { // from class: com.tencent.mobileqq.bizParts.QQSettingMeZPlanFloatingViewPart$onPartCreate$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ QQSettingMeViewModel $viewModel;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$viewModel = qQSettingMeViewModel;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeZPlanFloatingViewPart.this, (Object) qQSettingMeViewModel);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                AtomicBoolean atomicBoolean;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                if (num != null && num.intValue() == 2) {
                    QQSettingMeZPlanFloatingViewPart.this.M9();
                    return;
                }
                if (num != null && num.intValue() == 1) {
                    DrawerUtils drawerUtils = DrawerUtils.f306948a;
                    atomicBoolean = QQSettingMeZPlanFloatingViewPart.this.isInit;
                    drawerUtils.b(atomicBoolean, new Function0<Unit>(this.$viewModel) { // from class: com.tencent.mobileqq.bizParts.QQSettingMeZPlanFloatingViewPart$onPartCreate$3.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ QQSettingMeViewModel $viewModel;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$viewModel = r5;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) QQSettingMeZPlanFloatingViewPart.this, (Object) r5);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                QQSettingMeZPlanFloatingViewPart.this.N9();
                                this.$viewModel.f312694c0.postValue(Boolean.TRUE);
                            }
                        }
                    });
                    QQSettingMeZPlanFloatingViewPart.this.M9();
                }
            }
        };
        mutableLiveData3.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.bizParts.br
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZPlanFloatingViewPart.S9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
            M9();
        }
    }
}
