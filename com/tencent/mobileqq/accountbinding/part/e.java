package com.tencent.mobileqq.accountbinding.part;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.accountbinding.fragment.WechatLoginBindingFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/accountbinding/part/e;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/login/adapter/e;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "D9", "", "accountSize", "G9", "F9", NodeProps.MAX_HEIGHT, "B9", "", "C9", "", "tValue", "E9", "onInitView", "Lcom/tencent/mobileqq/login/account/a;", "account", "z7", "W2", "v", NodeProps.ON_CLICK, "d", "Landroid/view/View;", "containerView", "Lcom/tencent/mobileqq/widget/BounceScrollView;", "e", "Lcom/tencent/mobileqq/widget/BounceScrollView;", "bounceScrollView", "f", "I", "itemSpace", h.F, "itemHeight", "<init>", "()V", "i", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class e extends Part implements com.tencent.mobileqq.login.adapter.e, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View containerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BounceScrollView bounceScrollView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int itemSpace;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int itemHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/accountbinding/part/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.accountbinding.part.e$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/accountbinding/part/e$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildAdapterPosition(view) != 0) {
                i3 = e.this.itemSpace;
            }
            outRect.top = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/accountbinding/part/e$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f174670e;

        c(int i3) {
            this.f174670e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, i3);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                View view = e.this.containerView;
                View view2 = null;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    view = null;
                }
                if (view.getHeight() > 0) {
                    e.this.G9(this.f174670e);
                }
                View view3 = e.this.containerView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                } else {
                    view2 = view3;
                }
                view2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17652);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.itemSpace = ViewUtils.dip2px(-4.0f);
            this.itemHeight = ViewUtils.dip2px(104.0f);
        }
    }

    private final int B9(int maxHeight) {
        int C9 = C9(4.5f);
        int C92 = C9(3.5f);
        int C93 = C9(2.5f);
        if (maxHeight >= C9) {
            return C9;
        }
        if (maxHeight >= C92) {
            return C92;
        }
        if (maxHeight >= C93) {
            return C93;
        }
        return maxHeight;
    }

    private final int C9(float accountSize) {
        boolean z16;
        if (accountSize == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        return (int) ((this.itemHeight * accountSize) + (this.itemSpace * ((int) (accountSize - 1))));
    }

    private final void D9(View rootView) {
        View findViewById = rootView.findViewById(R.id.adr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.bounce_scroll_view)");
        this.bounceScrollView = (BounceScrollView) findViewById;
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f71803p5);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        recyclerView.addItemDecoration(new b());
        List<com.tencent.mobileqq.login.account.a> f16 = com.tencent.mobileqq.login.account.d.f241848a.f();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        recyclerView.setAdapter(new com.tencent.mobileqq.login.adapter.c(activity, f16, this, null, true));
        G9(f16.size());
    }

    private final void E9(String tValue) {
        ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", tValue, tValue, 0, 0, "", "2", o.c(), "");
    }

    private final void F9(View rootView) {
        List listOf;
        int collectionSizeOrDefault;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.f164651td0), Integer.valueOf(R.id.tdo)});
        List list = listOf;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList<View> arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(rootView.findViewById(((Number) it.next()).intValue()));
        }
        for (View view : arrayList) {
            if (view != null) {
                view.setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(int accountSize) {
        if (getActivity() == null) {
            return;
        }
        View view = this.containerView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view = null;
        }
        if (view.getHeight() == 0) {
            View view3 = this.containerView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            } else {
                view2 = view3;
            }
            view2.getViewTreeObserver().addOnGlobalLayoutListener(new c(accountSize));
            return;
        }
        View view4 = this.containerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view4 = null;
        }
        int B9 = B9(view4.getHeight() - ViewUtils.dip2px(175.0f));
        int C9 = C9(accountSize);
        BounceScrollView bounceScrollView = this.bounceScrollView;
        if (bounceScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bounceScrollView");
            bounceScrollView = null;
        }
        ViewGroup.LayoutParams layoutParams = bounceScrollView.getLayoutParams();
        if (C9 > B9) {
            layoutParams.height = B9;
        } else {
            layoutParams.height = -2;
        }
        BounceScrollView bounceScrollView2 = this.bounceScrollView;
        if (bounceScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bounceScrollView");
        } else {
            view2 = bounceScrollView2;
        }
        view2.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mobileqq.login.adapter.e
    public void W2(@NotNull com.tencent.mobileqq.login.account.a account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) account);
        } else {
            Intrinsics.checkNotNullParameter(account, "account");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f164651td0) {
                if (u.a().b()) {
                    QLog.d("WechatLoginUnbindPart", 1, "onClick too fast");
                } else {
                    if (getPartHost() instanceof WechatLoginBindingFragment) {
                        IPartHost partHost = getPartHost();
                        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.accountbinding.fragment.WechatLoginBindingFragment");
                        WechatLoginBindingFragment.uh((WechatLoginBindingFragment) partHost, null, 0, 0, 0, 14, null);
                    }
                    E9("0X800C44D");
                }
            } else if (num != null && num.intValue() == R.id.tdo && (getPartHost() instanceof WechatLoginBindingFragment)) {
                IPartHost partHost2 = getPartHost();
                Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type com.tencent.mobileqq.accountbinding.fragment.WechatLoginBindingFragment");
                ((WechatLoginBindingFragment) partHost2).vh();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.u7k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026container_unbind_account)");
        this.containerView = findViewById;
        View view = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            findViewById = null;
        }
        findViewById.setVisibility(0);
        View view2 = this.containerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view2 = null;
        }
        D9(view2);
        View view3 = this.containerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            view = view3;
        }
        F9(view);
    }

    @Override // com.tencent.mobileqq.login.adapter.e
    public void z7(@NotNull com.tencent.mobileqq.login.account.a account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) account);
            return;
        }
        Intrinsics.checkNotNullParameter(account, "account");
        if (getPartHost() instanceof WechatLoginBindingFragment) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.accountbinding.fragment.WechatLoginBindingFragment");
            ((WechatLoginBindingFragment) partHost).rh(account.f());
        }
    }
}
