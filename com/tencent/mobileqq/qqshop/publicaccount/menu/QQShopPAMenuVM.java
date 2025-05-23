package com.tencent.mobileqq.qqshop.publicaccount.menu;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.aio.PAInputIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqshop.publicaccount.d;
import com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopPAMenuIntent;
import com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopPAMenuState;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0012\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R(\u0010\u001b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00120\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopPAMenuVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopPAMenuIntent;", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopPAMenuState;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "", "toTabIndex", "r", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", "com/tencent/mobileqq/qqshop/publicaccount/menu/QQShopPAMenuVM$a", "d", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopPAMenuVM$a;", "mAction", "", "Lkotlin/Pair;", "", "e", "Ljava/util/List;", "messageList", "f", "I", "currentTabIndex", "Lcom/tencent/mobileqq/qqshop/publicaccount/d$a;", tl.h.F, "Lcom/tencent/mobileqq/qqshop/publicaccount/d$a;", "dailyMenuStyle", "i", "coinsMenuStyle", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "paMenuStyle", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQShopPAMenuVM extends com.tencent.aio.base.mvvm.b<QQShopPAMenuIntent, QQShopPAMenuState> implements LifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, a>> messageList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentTabIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d.a dailyMenuStyle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d.a coinsMenuStyle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d.a paMenuStyle;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqshop/publicaccount/menu/QQShopPAMenuVM$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQShopPAMenuVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                QQShopPAMenuVM.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    public QQShopPAMenuVM() {
        List<Pair<String, a>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        a aVar = new a();
        this.mAction = aVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(Reflection.getOrCreateKotlinClass(QQShopPAMenuIntent.SwitchTabWithIndex.class).getQualifiedName(), aVar));
        this.messageList = listOf;
        this.currentTabIndex = -1;
        com.tencent.mobileqq.qqshop.publicaccount.d dVar = com.tencent.mobileqq.qqshop.publicaccount.d.f274576a;
        this.dailyMenuStyle = dVar.g();
        this.coinsMenuStyle = dVar.g();
        this.paMenuStyle = dVar.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof QQShopPAMenuIntent.SwitchTabWithIndex) {
            r(((QQShopPAMenuIntent.SwitchTabWithIndex) intent).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(com.tencent.aio.api.runtime.a context) {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            String str = (String) pair.getFirst();
            com.tencent.mvi.base.route.a aVar = (com.tencent.mvi.base.route.a) pair.getSecond();
            LifecycleOwner d16 = context.d();
            Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
            e16.c(str, aVar, d16);
        }
    }

    private final void r(int toTabIndex) {
        QQShopPAMenuState.UpdateMenuStyle updateMenuStyle;
        if (this.currentTabIndex == toTabIndex) {
            return;
        }
        this.currentTabIndex = toTabIndex;
        if (toTabIndex == 0) {
            updateMenuStyle = new QQShopPAMenuState.UpdateMenuStyle(this.dailyMenuStyle);
        } else if (toTabIndex == com.tencent.mobileqq.qqshop.publicaccount.b.INSTANCE.a()) {
            updateMenuStyle = new QQShopPAMenuState.UpdateMenuStyle(this.coinsMenuStyle);
        } else {
            updateMenuStyle = new QQShopPAMenuState.UpdateMenuStyle(this.paMenuStyle);
        }
        updateUI(updateMenuStyle);
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull final com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        q(context);
        context.e().h(new PAInputIntent.InputContainerVisibleIntent(8));
        MutableLiveData<d.a> e16 = com.tencent.mobileqq.qqshop.publicaccount.d.f274576a.e();
        LifecycleOwner d16 = context.d();
        final Function1<d.a, Unit> function1 = new Function1<d.a, Unit>(context) { // from class: com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopPAMenuVM$onCreate$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.aio.api.runtime.a $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQShopPAMenuVM.this, (Object) context);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(d.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable d.a aVar) {
                int i3;
                d.a aVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                QQShopPAMenuVM qQShopPAMenuVM = QQShopPAMenuVM.this;
                if (aVar == null) {
                    return;
                }
                qQShopPAMenuVM.dailyMenuStyle = aVar;
                i3 = QQShopPAMenuVM.this.currentTabIndex;
                if (i3 == 0) {
                    QQShopPAMenuVM qQShopPAMenuVM2 = QQShopPAMenuVM.this;
                    aVar2 = qQShopPAMenuVM2.dailyMenuStyle;
                    qQShopPAMenuVM2.updateUI(new QQShopPAMenuState.UpdateMenuStyle(aVar2));
                    Context context2 = this.$context.c().getContext();
                    Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
                    if (activity != null) {
                        QUIImmersiveHelper.s(activity, false, true);
                    }
                }
            }
        };
        e16.observe(d16, new Observer() { // from class: com.tencent.mobileqq.qqshop.publicaccount.menu.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQShopPAMenuVM.p(Function1.this, obj);
            }
        });
        g gVar = g.f274629a;
        updateUI(new QQShopPAMenuState.UpdateMenuData(gVar.d().getTabItems()));
        gVar.f(new Function2<Boolean, QQShopMenuConfBean, Unit>() { // from class: com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopPAMenuVM$onCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQShopPAMenuVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, QQShopMenuConfBean qQShopMenuConfBean) {
                invoke(bool.booleanValue(), qQShopMenuConfBean);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable QQShopMenuConfBean qQShopMenuConfBean) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), qQShopMenuConfBean);
                } else if (z16 && qQShopMenuConfBean != null && !qQShopMenuConfBean.getTabItems().isEmpty()) {
                    QQShopPAMenuVM.this.updateUI(new QQShopPAMenuState.UpdateMenuData(qQShopMenuConfBean.getTabItems()));
                } else {
                    QLog.e(FrameworkVM.TAG, 1, "pa config no update:is update on fail");
                }
            }
        });
    }
}
