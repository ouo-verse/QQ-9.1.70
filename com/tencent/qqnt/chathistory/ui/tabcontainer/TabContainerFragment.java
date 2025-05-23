package com.tencent.qqnt.chathistory.ui.tabcontainer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.category.c;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.chathistory.x2k.n;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0013\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/tabcontainer/TabContainerFragment;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/tabcontainer/a;", "Lcom/tencent/qqnt/chathistory/ui/category/c$b;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "uh", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "rightContent", "Landroid/view/View$OnClickListener;", "clickListener", "f3", "k8", "u", "gd", "", "enable", "setEnable", "Lcom/tencent/qqnt/chathistory/x2k/n;", "E", "Lcom/tencent/qqnt/chathistory/x2k/n;", "rootBinding", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "title", "<init>", "()V", "G", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TabContainerFragment extends BaseHistoryFragment<a> implements c.b {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    private n rootBinding;

    /* renamed from: F, reason: from kotlin metadata */
    private QUISecNavBar title;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/tabcontainer/TabContainerFragment$a;", "", "", "KEY_TAB_BUSINESS_PARAM", "Ljava/lang/String;", "KEY_TAB_CONTAINER", "TAG", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.tabcontainer.TabContainerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50991);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TabContainerFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c.b
    public void f3(@Nullable String rightContent, @Nullable View.OnClickListener clickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rightContent, (Object) clickListener);
            return;
        }
        QUISecNavBar qUISecNavBar = this.title;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            qUISecNavBar = null;
        }
        BaseAction baseAction = BaseAction.ACTION_RIGHT_TEXT;
        qUISecNavBar.setBaseViewVisible(baseAction, !TextUtils.isEmpty(rightContent));
        qUISecNavBar.setRightText(rightContent);
        qUISecNavBar.setBaseClickListener(baseAction, new com.tencent.qqnt.chathistory.util.n(clickListener));
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c.b
    @NotNull
    public View gd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        QUISecNavBar qUISecNavBar = this.title;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            qUISecNavBar = null;
        }
        return qUISecNavBar.g(BaseAction.ACTION_LEFT_BUTTON);
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c.b
    public void k8(@Nullable String rightContent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rightContent);
            return;
        }
        QUISecNavBar qUISecNavBar = this.title;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            qUISecNavBar = null;
        }
        qUISecNavBar.setRightText(rightContent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        int i3 = requireArguments().getInt("key_tab_container");
        d.f354054a.a("TabContainerFragmentDebug", "type " + i3);
        Pair<Integer, BaseHistoryFragment<?>> N1 = rh().L1().N1(i3);
        QUISecNavBar qUISecNavBar = this.title;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            qUISecNavBar = null;
        }
        qUISecNavBar.setCenterText(qUISecNavBar.getContext().getResources().getText(N1.getFirst().intValue()));
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.tabcontainer.TabContainerFragment$onViewCreated$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TabContainerFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view2, BaseAction baseAction) {
                invoke2(view2, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view2, @NotNull BaseAction action) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2, (Object) action);
                    return;
                }
                Intrinsics.checkNotNullParameter(view2, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(action, "action");
                if (action == BaseAction.ACTION_LEFT_BUTTON) {
                    TabContainerFragment.this.requireActivity().onBackPressed();
                }
            }
        });
        getChildFragmentManager().beginTransaction().add(R.id.ixw, N1.getSecond()).commitNowAllowingStateLoss();
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c.b
    public void setEnable(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, enable);
            return;
        }
        QUISecNavBar qUISecNavBar = this.title;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            qUISecNavBar = null;
        }
        qUISecNavBar.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, enable);
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c.b
    @NotNull
    public View u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        QUISecNavBar qUISecNavBar = this.title;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            qUISecNavBar = null;
        }
        return qUISecNavBar.g(BaseAction.ACTION_RIGHT_TEXT);
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @Nullable
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        QUISecNavBar qUISecNavBar = null;
        n nVar = new n(requireContext, null, 2, null);
        QUISecNavBar e16 = nVar.e();
        this.title = e16;
        if (e16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        } else {
            qUISecNavBar = e16;
        }
        qUISecNavBar.S(this);
        this.rootBinding = nVar;
        return nVar.f();
    }
}
