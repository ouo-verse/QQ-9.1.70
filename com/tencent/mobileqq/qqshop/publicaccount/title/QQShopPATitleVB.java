package com.tencent.mobileqq.qqshop.publicaccount.title;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopMenuLayout;
import com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopPAMenuVB;
import com.tencent.mobileqq.qqshop.publicaccount.title.QQShopPATitleState;
import com.tencent.mobileqq.qqshop.publicaccount.title.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0016\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000f0\u000eH\u0016J\u001a\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J,\u0010\u0018\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020\u0016\u0012\u0006\b\u0001\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00150\u000e2\u0006\u0010\u0014\u001a\u00020\nH\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/title/QQShopPATitleVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/qqshop/publicaccount/title/a;", "Lcom/tencent/mobileqq/qqshop/publicaccount/title/QQShopPATitleState;", "", "tabIndex", "", ICustomDataEditor.NUMBER_PARAM_1, "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "state", "h1", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "hostView", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mobileqq/qqshop/publicaccount/title/QQShopTitleLayout;", "d", "Lcom/tencent/mobileqq/qqshop/publicaccount/title/QQShopTitleLayout;", "titleLayout", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout;", "e", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout;", "menuLayout", "Landroidx/viewpager2/widget/ViewPager2;", "f", "Landroidx/viewpager2/widget/ViewPager2;", "fragmentContainer", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQShopPATitleVB extends com.tencent.aio.base.mvvm.a<a, QQShopPATitleState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QQShopTitleLayout titleLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQShopMenuLayout menuLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 fragmentContainer;

    public QQShopPATitleVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(QQShopPATitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.C8431a.f274687d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(QQShopPATitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.c.f274689d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(QQShopPATitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.b.f274688d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(QQShopPATitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.d.f274690d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(com.tencent.mvi.api.help.a createViewParams, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(createViewParams, "$createViewParams");
        QRoute.createNavigator(createViewParams.a(), IPublicAccountDetailActivity.ROUTE_NAME).withString("uin", IPublicAccountUtil.UIN_FOR_SHOP).withInt("source", 5).request();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void n1(int tabIndex) {
        ViewPager2 viewPager2 = this.fragmentContainer;
        QQShopTitleLayout qQShopTitleLayout = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            viewPager2 = null;
        }
        viewPager2.setCurrentItem(tabIndex, false);
        QQShopTitleLayout qQShopTitleLayout2 = this.titleLayout;
        if (qQShopTitleLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        } else {
            qQShopTitleLayout = qQShopTitleLayout2;
        }
        qQShopTitleLayout.j(tabIndex);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<a, QQShopPATitleState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BaseVM) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new QQShopPATitleVM();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends QQShopPATitleState>> getObserverStates() {
        List<Class<? extends QQShopPATitleState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{QQShopPATitleState.SetFragmentAdapter.class, QQShopPATitleState.UpdateTitleStyle.class, QQShopPATitleState.UpdateUnreadDailyMsgCount.class, QQShopPATitleState.UpdateCoinsMsgRedDot.class, QQShopPATitleState.UpdateUnreadPaMsgCount.class, QQShopPATitleState.SwitchTabWithIndex.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull QQShopPATitleState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        QQShopTitleLayout qQShopTitleLayout = null;
        ViewPager2 viewPager2 = null;
        QQShopTitleLayout qQShopTitleLayout2 = null;
        QQShopTitleLayout qQShopTitleLayout3 = null;
        QQShopTitleLayout qQShopTitleLayout4 = null;
        if (state instanceof QQShopPATitleState.SetFragmentAdapter) {
            ViewPager2 viewPager22 = this.fragmentContainer;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            } else {
                viewPager2 = viewPager22;
            }
            viewPager2.setAdapter(((QQShopPATitleState.SetFragmentAdapter) state).a());
            return;
        }
        if (state instanceof QQShopPATitleState.UpdateTitleStyle) {
            QQShopTitleLayout qQShopTitleLayout5 = this.titleLayout;
            if (qQShopTitleLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            } else {
                qQShopTitleLayout2 = qQShopTitleLayout5;
            }
            qQShopTitleLayout2.n(((QQShopPATitleState.UpdateTitleStyle) state).a());
            return;
        }
        boolean z16 = true;
        if (state instanceof QQShopPATitleState.UpdateUnreadDailyMsgCount) {
            QQShopTitleLayout qQShopTitleLayout6 = this.titleLayout;
            if (qQShopTitleLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            } else {
                qQShopTitleLayout3 = qQShopTitleLayout6;
            }
            if (((QQShopPATitleState.UpdateUnreadDailyMsgCount) state).a() <= 0) {
                z16 = false;
            }
            qQShopTitleLayout3.l(z16);
            return;
        }
        if (state instanceof QQShopPATitleState.UpdateCoinsMsgRedDot) {
            QQShopTitleLayout qQShopTitleLayout7 = this.titleLayout;
            if (qQShopTitleLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            } else {
                qQShopTitleLayout4 = qQShopTitleLayout7;
            }
            qQShopTitleLayout4.k(((QQShopPATitleState.UpdateCoinsMsgRedDot) state).a());
            return;
        }
        if (state instanceof QQShopPATitleState.UpdateUnreadPaMsgCount) {
            QQShopTitleLayout qQShopTitleLayout8 = this.titleLayout;
            if (qQShopTitleLayout8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            } else {
                qQShopTitleLayout = qQShopTitleLayout8;
            }
            if (((QQShopPATitleState.UpdateUnreadPaMsgCount) state).a() <= 0) {
                z16 = false;
            }
            qQShopTitleLayout.m(z16);
            return;
        }
        if (state instanceof QQShopPATitleState.SwitchTabWithIndex) {
            n1(((QQShopPATitleState.SwitchTabWithIndex) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new QQShopPAMenuVB(new Function0<QQShopMenuLayout>() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.QQShopPATitleVB$initializeChildVB$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQShopPATitleVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQShopMenuLayout invoke() {
                QQShopMenuLayout qQShopMenuLayout;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (QQShopMenuLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                qQShopMenuLayout = QQShopPATitleVB.this.menuLayout;
                if (qQShopMenuLayout != null) {
                    return qQShopMenuLayout;
                }
                Intrinsics.throwUninitializedPropertyAccessException("menuLayout");
                return null;
            }
        }));
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull final com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        ViewPager2 viewPager2 = null;
        View rootView = View.inflate(createViewParams.a(), R.layout.h4q, null);
        View findViewById = rootView.findViewById(R.id.f623930p);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.qq_shop_pa_title_layout)");
        this.titleLayout = (QQShopTitleLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f623730n);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qq_shop_pa_menu_layout)");
        this.menuLayout = (QQShopMenuLayout) findViewById2;
        QQShopTitleLayout qQShopTitleLayout = this.titleLayout;
        if (qQShopTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            qQShopTitleLayout = null;
        }
        qQShopTitleLayout.e();
        QQShopTitleLayout qQShopTitleLayout2 = this.titleLayout;
        if (qQShopTitleLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            qQShopTitleLayout2 = null;
        }
        qQShopTitleLayout2.setOnBackClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQShopPATitleVB.i1(QQShopPATitleVB.this, view);
            }
        });
        QQShopTitleLayout qQShopTitleLayout3 = this.titleLayout;
        if (qQShopTitleLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            qQShopTitleLayout3 = null;
        }
        qQShopTitleLayout3.setDailyTitleClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQShopPATitleVB.j1(QQShopPATitleVB.this, view);
            }
        });
        QQShopTitleLayout qQShopTitleLayout4 = this.titleLayout;
        if (qQShopTitleLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            qQShopTitleLayout4 = null;
        }
        qQShopTitleLayout4.setCoinsTitleClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQShopPATitleVB.k1(QQShopPATitleVB.this, view);
            }
        });
        QQShopTitleLayout qQShopTitleLayout5 = this.titleLayout;
        if (qQShopTitleLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            qQShopTitleLayout5 = null;
        }
        qQShopTitleLayout5.setPaTitleClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQShopPATitleVB.l1(QQShopPATitleVB.this, view);
            }
        });
        QQShopTitleLayout qQShopTitleLayout6 = this.titleLayout;
        if (qQShopTitleLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            qQShopTitleLayout6 = null;
        }
        qQShopTitleLayout6.setOnDetailClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQShopPATitleVB.m1(com.tencent.mvi.api.help.a.this, view);
            }
        });
        View findViewById3 = rootView.findViewById(R.id.f623530l);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.qq_shop_frag_container)");
        ViewPager2 viewPager22 = (ViewPager2) findViewById3;
        this.fragmentContainer = viewPager22;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        } else {
            viewPager2 = viewPager22;
        }
        viewPager2.setUserInputEnabled(false);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }
}
