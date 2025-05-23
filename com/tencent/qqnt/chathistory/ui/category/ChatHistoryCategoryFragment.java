package com.tencent.qqnt.chathistory.ui.category;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.category.c;
import com.tencent.qqnt.chathistory.ui.category.data.a;
import com.tencent.qqnt.chathistory.ui.category.viewModel.ChatHistoryCategoryViewModel;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.chathistory.util.n;
import com.tencent.qqnt.chathistory.x2k.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001.B\u0007\u00a2\u0006\u0004\b,\u0010-J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0013\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\bH\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/category/ChatHistoryCategoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/category/viewModel/ChatHistoryCategoryViewModel;", "Lcom/tencent/qqnt/chathistory/ui/category/c$b;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "uh", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "rightContent", "Landroid/view/View$OnClickListener;", "clickListener", "f3", "u", "gd", "k8", "", "enable", "setEnable", "outState", "onSaveInstanceState", "Landroidx/viewpager/widget/ViewPager;", "E", "Landroidx/viewpager/widget/ViewPager;", "vp", "Lcom/tencent/qqnt/chathistory/x2k/l;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chathistory/x2k/l;", "binding", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "G", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "title", "", "H", "I", "currentPage", "<init>", "()V", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryCategoryFragment extends BaseHistoryFragment<ChatHistoryCategoryViewModel> implements c.b {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a I;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewPager vp;

    /* renamed from: F, reason: from kotlin metadata */
    private l binding;

    /* renamed from: G, reason: from kotlin metadata */
    private QUISecNavBar title;

    /* renamed from: H, reason: from kotlin metadata */
    private int currentPage;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/category/ChatHistoryCategoryFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/chathistory/ui/category/ChatHistoryCategoryFragment$b", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements ViewPager.OnPageChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryCategoryFragment.this);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, state);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), Float.valueOf(positionOffset), Integer.valueOf(positionOffsetPixels));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ChatHistoryCategoryFragment.this.currentPage = position;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, position);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35120);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            I = new a(null);
        }
    }

    public ChatHistoryCategoryFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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
        qUISecNavBar.setBaseClickListener(baseAction, new n(clickListener));
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c.b
    @Nullable
    public View gd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) rightContent);
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
    public void onSaveInstanceState(@NotNull Bundle outState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) outState);
            return;
        }
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putInt("categorySelectKey", this.currentPage);
        }
        d.f354054a.a("ChatHistoryCategoryFragmentDebug", "onSaveInstanceState " + this.currentPage);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull final View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        QUISecNavBar qUISecNavBar = this.title;
        ViewPager viewPager = null;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            qUISecNavBar = null;
        }
        qUISecNavBar.setCenterText(getString(R.string.zjz));
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.category.ChatHistoryCategoryFragment$onViewCreated$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryCategoryFragment.this);
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
                    ChatHistoryCategoryFragment.this.requireActivity().onBackPressed();
                }
            }
        });
        ChatHistoryCategoryViewModel rh5 = rh();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        PagerAdapter S1 = rh5.S1(childFragmentManager);
        View findViewById = view.findViewById(R.id.f164772au1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<ViewPa\u2026.id.chatHistoryViewPager)");
        ViewPager viewPager2 = (ViewPager) findViewById;
        this.vp = viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vp");
            viewPager2 = null;
        }
        viewPager2.setAdapter(S1);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i3 = arguments.getInt("categorySelectKey", 0);
            d.f354054a.a("ChatHistoryCategoryFragmentDebug", "selectIndex " + i3);
            ViewPager viewPager3 = this.vp;
            if (viewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vp");
                viewPager3 = null;
            }
            viewPager3.setCurrentItem(i3);
            this.currentPage = i3;
        }
        QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) view.findViewById(R.id.f220902s);
        Intrinsics.checkNotNull(S1, "null cannot be cast to non-null type com.tencent.qqnt.chathistory.ui.category.HistoryCategoryPageAdapter");
        qUIPageTabBar.setTabData(((com.tencent.qqnt.chathistory.ui.category.b) S1).e());
        ViewPager viewPager4 = this.vp;
        if (viewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vp");
            viewPager4 = null;
        }
        qUIPageTabBar.setViewPager(viewPager4);
        LiveData obtainUiState = rh().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.qqnt.chathistory.ui.category.data.a, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.category.data.a, Unit>(view) { // from class: com.tencent.qqnt.chathistory.ui.category.ChatHistoryCategoryFragment$onViewCreated$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $view;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$view = view;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryCategoryFragment.this, (Object) view);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.category.data.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.chathistory.ui.category.data.a aVar) {
                QUISecNavBar qUISecNavBar2;
                QUISecNavBar qUISecNavBar3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                QUISecNavBar qUISecNavBar4 = null;
                if (aVar instanceof a.C9523a) {
                    qUISecNavBar3 = ChatHistoryCategoryFragment.this.title;
                    if (qUISecNavBar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("title");
                    } else {
                        qUISecNavBar4 = qUISecNavBar3;
                    }
                    View view2 = this.$view;
                    BaseAction baseAction = BaseAction.ACTION_RIGHT_TEXT;
                    qUISecNavBar4.setBaseViewVisible(baseAction, view2.getVisibility() == 0);
                    a.C9523a c9523a = (a.C9523a) aVar;
                    qUISecNavBar4.setRightText(c9523a.a());
                    View.OnClickListener b16 = c9523a.b();
                    if (b16 != null) {
                        qUISecNavBar4.setBaseClickListener(baseAction, b16);
                        return;
                    }
                    return;
                }
                if (aVar instanceof a.b) {
                    qUISecNavBar2 = ChatHistoryCategoryFragment.this.title;
                    if (qUISecNavBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("title");
                    } else {
                        qUISecNavBar4 = qUISecNavBar2;
                    }
                    qUISecNavBar4.setRightText(((a.b) aVar).a());
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.category.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatHistoryCategoryFragment.onViewCreated$lambda$3(Function1.this, obj);
            }
        });
        ViewPager viewPager5 = this.vp;
        if (viewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vp");
        } else {
            viewPager = viewPager5;
        }
        viewPager.addOnPageChangeListener(new b());
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
    @Nullable
    public View u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        QUISecNavBar qUISecNavBar = this.title;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            qUISecNavBar = null;
        }
        return qUISecNavBar.g(BaseAction.ACTION_RIGHT_TEXT);
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @NotNull
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        QUISecNavBar qUISecNavBar = null;
        l lVar = new l(context, null, 2, null);
        this.binding = lVar;
        QUISecNavBar e16 = lVar.e();
        this.title = e16;
        if (e16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        } else {
            qUISecNavBar = e16;
        }
        qUISecNavBar.S(this);
        return lVar.f();
    }
}
