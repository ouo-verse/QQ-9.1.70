package com.tencent.mobileqq.troop.deletemember.inject.title;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.deletemember.event.TroopDeleteMemberEvent;
import com.tencent.mobileqq.troop.selectmember.bean.c;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.troop.selectmember.inject.d;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010!\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/inject/title/TroopDeleteMemberTitleHandler;", "Lcom/tencent/mobileqq/troop/selectmember/inject/d;", "", h.F, "i", "k", DomainData.DOMAIN_NAME, "Landroid/view/View;", "view", "o", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "titleBar", "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "vmOperator", "g", "f", "a", "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "b", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "c", "Landroidx/fragment/app/FragmentActivity;", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "d", "Lkotlin/Lazy;", "l", "()Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", DownloadInfo.spKey_Config, "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "rightView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopDeleteMemberTitleHandler implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.selectmember.vm.a vmOperator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private QUISecNavBar titleBar;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private FragmentActivity activity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rightView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/inject/title/TroopDeleteMemberTitleHandler$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.deletemember.inject.title.TroopDeleteMemberTitleHandler$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31263);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopDeleteMemberTitleHandler() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectMemberConfig>() { // from class: com.tencent.mobileqq.troop.deletemember.inject.title.TroopDeleteMemberTitleHandler$config$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberTitleHandler.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TroopSelectMemberConfig invoke() {
                    com.tencent.mobileqq.troop.selectmember.vm.a aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TroopSelectMemberConfig) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    aVar = TroopDeleteMemberTitleHandler.this.vmOperator;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vmOperator");
                        aVar = null;
                    }
                    return aVar.G1();
                }
            });
            this.config = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.troop.deletemember.inject.title.TroopDeleteMemberTitleHandler$rightView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberTitleHandler.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final View invoke() {
                    QUISecNavBar qUISecNavBar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    qUISecNavBar = TroopDeleteMemberTitleHandler.this.titleBar;
                    if (qUISecNavBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
                        qUISecNavBar = null;
                    }
                    return qUISecNavBar.g(BaseAction.ACTION_RIGHT_TEXT);
                }
            });
            this.rightView = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void h() {
        QUISecNavBar qUISecNavBar = this.titleBar;
        QUISecNavBar qUISecNavBar2 = null;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            qUISecNavBar = null;
        }
        qUISecNavBar.setLeftType(1);
        QUISecNavBar qUISecNavBar3 = this.titleBar;
        if (qUISecNavBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        } else {
            qUISecNavBar2 = qUISecNavBar3;
        }
        qUISecNavBar2.setLeftText("\u53d6\u6d88");
    }

    private final void i() {
        boolean z16;
        final String b16 = com.tencent.mobileqq.troop.selectmember.config.a.b(l());
        if (QLog.isColorLevel()) {
            QLog.i("TroopDeleteMemberTitleHandler", 2, "[configDefaultRightText] rightText:" + b16);
        }
        QUISecNavBar qUISecNavBar = this.titleBar;
        FragmentActivity fragmentActivity = null;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            qUISecNavBar = null;
        }
        qUISecNavBar.setRightText(com.tencent.mobileqq.troop.selectmember.config.a.b(l()));
        if (b16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        com.tencent.mobileqq.troop.selectmember.vm.a aVar = this.vmOperator;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vmOperator");
            aVar = null;
        }
        LiveData<List<c>> P = aVar.P();
        FragmentActivity fragmentActivity2 = this.activity;
        if (fragmentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        } else {
            fragmentActivity = fragmentActivity2;
        }
        final Function1<List<? extends c>, Unit> function1 = new Function1<List<? extends c>, Unit>(b16) { // from class: com.tencent.mobileqq.troop.deletemember.inject.title.TroopDeleteMemberTitleHandler$configRightText$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $rightText;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$rightText = b16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberTitleHandler.this, (Object) b16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends c> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends c> it) {
                QUISecNavBar qUISecNavBar2;
                QUISecNavBar qUISecNavBar3;
                QUISecNavBar qUISecNavBar4;
                QUISecNavBar qUISecNavBar5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                QUISecNavBar qUISecNavBar6 = null;
                if (!it.isEmpty()) {
                    qUISecNavBar4 = TroopDeleteMemberTitleHandler.this.titleBar;
                    if (qUISecNavBar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
                        qUISecNavBar4 = null;
                    }
                    qUISecNavBar4.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, true);
                    qUISecNavBar5 = TroopDeleteMemberTitleHandler.this.titleBar;
                    if (qUISecNavBar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
                    } else {
                        qUISecNavBar6 = qUISecNavBar5;
                    }
                    qUISecNavBar6.setRightText(this.$rightText + "(" + it.size() + ")");
                    return;
                }
                qUISecNavBar2 = TroopDeleteMemberTitleHandler.this.titleBar;
                if (qUISecNavBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleBar");
                    qUISecNavBar2 = null;
                }
                qUISecNavBar2.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, false);
                qUISecNavBar3 = TroopDeleteMemberTitleHandler.this.titleBar;
                if (qUISecNavBar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleBar");
                } else {
                    qUISecNavBar6 = qUISecNavBar3;
                }
                qUISecNavBar6.setRightText(this.$rightText);
            }
        };
        P.observe(fragmentActivity, new Observer() { // from class: com.tencent.mobileqq.troop.deletemember.inject.title.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopDeleteMemberTitleHandler.j(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void k() {
        View m3 = m();
        VideoReport.setElementId(m3, "em_group_remove_btn");
        VideoReport.reportEvent("dt_imp", m3, null);
        VideoReport.setElementClickPolicy(m3, ClickPolicy.REPORT_NONE);
    }

    private final TroopSelectMemberConfig l() {
        return (TroopSelectMemberConfig) this.config.getValue();
    }

    private final View m() {
        return (View) this.rightView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        SimpleEventBus.getInstance().dispatchEvent(new TroopDeleteMemberEvent.ClickBackEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(View view) {
        com.tencent.mobileqq.troop.selectmember.vm.a aVar = null;
        VideoReport.reportEvent("dt_clck", view, null);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        com.tencent.mobileqq.troop.selectmember.vm.a aVar2 = this.vmOperator;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vmOperator");
        } else {
            aVar = aVar2;
        }
        simpleEventBus.dispatchEvent(new TroopDeleteMemberEvent.ClickRemoveEvent(aVar));
    }

    @Override // com.tencent.mobileqq.troop.selectmember.inject.d
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            VideoReport.reportEvent("dt_imp_end", m(), null);
        }
    }

    @Override // com.tencent.mobileqq.troop.selectmember.inject.d
    public void g(@NotNull FragmentActivity activity, @NotNull QUISecNavBar titleBar, @NotNull com.tencent.mobileqq.troop.selectmember.vm.a vmOperator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, titleBar, vmOperator);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(titleBar, "titleBar");
        Intrinsics.checkNotNullParameter(vmOperator, "vmOperator");
        this.vmOperator = vmOperator;
        this.titleBar = titleBar;
        this.activity = activity;
        titleBar.R(activity);
        titleBar.setCenterText(com.tencent.mobileqq.troop.selectmember.config.a.a(l()));
        h();
        i();
        k();
        titleBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.deletemember.inject.title.TroopDeleteMemberTitleHandler$dispatchTitleBar$1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes19.dex */
            public /* synthetic */ class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f295033a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31248);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 1)) {
                        redirector.redirect((short) 1);
                        return;
                    }
                    int[] iArr = new int[BaseAction.values().length];
                    try {
                        iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[BaseAction.ACTION_LEFT_TEXT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[BaseAction.ACTION_RIGHT_TEXT.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f295033a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberTitleHandler.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view, @NotNull BaseAction baseAction) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
                    return;
                }
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(baseAction, "baseAction");
                int i3 = a.f295033a[baseAction.ordinal()];
                if (i3 == 1 || i3 == 2) {
                    TroopDeleteMemberTitleHandler.this.n();
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    TroopDeleteMemberTitleHandler.this.o(view);
                }
            }
        });
    }
}
