package com.tencent.mobileqq.qqshop.publicaccount.menu;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopPAMenuState;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\f0\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopPAMenuVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopPAMenuIntent;", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopPAMenuState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "", "Ljava/lang/Class;", "getObserverStates", "state", "", "d1", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout;", "d", "Lkotlin/jvm/functions/Function0;", "getMenuFromParent", "e", "Lkotlin/Lazy;", "c1", "()Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout;", "menuLayout", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQShopPAMenuVB extends com.tencent.aio.base.mvvm.a<QQShopPAMenuIntent, QQShopPAMenuState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<QQShopMenuLayout> getMenuFromParent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy menuLayout;

    public QQShopPAMenuVB(@NotNull Function0<QQShopMenuLayout> getMenuFromParent) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(getMenuFromParent, "getMenuFromParent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) getMenuFromParent);
            return;
        }
        this.getMenuFromParent = getMenuFromParent;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQShopMenuLayout>() { // from class: com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopPAMenuVB$menuLayout$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQShopPAMenuVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQShopMenuLayout invoke() {
                Function0 function0;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (QQShopMenuLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                function0 = QQShopPAMenuVB.this.getMenuFromParent;
                return (QQShopMenuLayout) function0.invoke();
            }
        });
        this.menuLayout = lazy;
    }

    private final QQShopMenuLayout c1() {
        return (QQShopMenuLayout) this.menuLayout.getValue();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<QQShopPAMenuIntent, QQShopPAMenuState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new QQShopPAMenuVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull QQShopPAMenuState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof QQShopPAMenuState.UpdateMenuStyle) {
            c1().f(((QQShopPAMenuState.UpdateMenuStyle) state).a());
        } else if (state instanceof QQShopPAMenuState.UpdateMenuData) {
            c1().e(((QQShopPAMenuState.UpdateMenuData) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends QQShopPAMenuState>> getObserverStates() {
        List<Class<? extends QQShopPAMenuState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{QQShopPAMenuState.UpdateMenuData.class, QQShopPAMenuState.UpdateMenuStyle.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return c1();
    }
}
