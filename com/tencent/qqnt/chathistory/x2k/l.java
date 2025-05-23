package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00106\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u00102\u001a\u0004\b+\u00103\"\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/l;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "g", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", tl.h.F, "()Landroid/view/View;", DomainData.DOMAIN_NAME, "(Landroid/view/View;)V", "_root", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "c", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "e", "()Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "k", "(Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;)V", "rlCommenTitle", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "d", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "getPageTitleBar", "()Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "j", "(Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;)V", "pageTitleBar", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "getSlidingContainer", "()Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/widget/FrameLayout;)V", "slidingContainer", "Lcom/tencent/mobileqq/widget/QQViewPager;", "f", "Lcom/tencent/mobileqq/widget/QQViewPager;", "getChatHistoryViewPager", "()Lcom/tencent/mobileqq/widget/QQViewPager;", "i", "(Lcom/tencent/mobileqq/widget/QQViewPager;)V", "chatHistoryViewPager", "Landroid/widget/RelativeLayout;", "()Landroid/widget/RelativeLayout;", "l", "(Landroid/widget/RelativeLayout;)V", "root", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class l implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public QUISecNavBar rlCommenTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public QUIPageTabBar pageTitleBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public FrameLayout slidingContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public QQViewPager chatHistoryViewPager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout root;

    public l(@NotNull Context context, @Nullable Integer num) {
        RelativeLayout g16;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) num);
            return;
        }
        this.context = context;
        if (num != null) {
            g16 = g(new ContextThemeWrapper(context, num.intValue()));
        } else {
            g16 = g(context);
        }
        n(g16);
    }

    @NotNull
    public final QUISecNavBar e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QUISecNavBar) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        QUISecNavBar qUISecNavBar = this.rlCommenTitle;
        if (qUISecNavBar != null) {
            return qUISecNavBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rlCommenTitle");
        return null;
    }

    @NotNull
    public final RelativeLayout f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        RelativeLayout relativeLayout = this.root;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    @NotNull
    public final RelativeLayout g(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 17, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        int c16 = com.tencent.aio.view_dsl.dsl.b.c();
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(c16, 0));
        } else {
            relativeLayout.getLayoutParams().width = c16;
        }
        relativeLayout.setBackground(AppCompatResources.getDrawable(relativeLayout.getContext(), R.drawable.qui_common_bg_bottom_light_bg));
        relativeLayout.setId(R.id.root);
        int c17 = com.tencent.aio.view_dsl.dsl.b.c();
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, c17));
        } else {
            relativeLayout.getLayoutParams().height = c17;
        }
        Context context2 = relativeLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        QUISecNavBar qUISecNavBar = new QUISecNavBar(context2, null, 0, 6, null);
        relativeLayout.addView(qUISecNavBar);
        qUISecNavBar.setId(R.id.rlCommenTitle);
        int l3 = com.tencent.aio.view_dsl.dsl.b.l();
        if (qUISecNavBar.getLayoutParams() == null) {
            qUISecNavBar.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
        } else {
            qUISecNavBar.getLayoutParams().width = l3;
        }
        int p16 = com.tencent.aio.view_dsl.dsl.b.p();
        if (qUISecNavBar.getLayoutParams() == null) {
            qUISecNavBar.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
        } else {
            qUISecNavBar.getLayoutParams().height = p16;
        }
        qUISecNavBar.setRightType(1);
        qUISecNavBar.setLeftType(2);
        qUISecNavBar.setCenterType(1);
        k(qUISecNavBar);
        FrameLayout frameLayout = new FrameLayout(relativeLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
        if (invoke != null) {
            frameLayout.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l16 = com.tencent.aio.view_dsl.dsl.b.l();
            if (frameLayout.getLayoutParams() == null) {
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(l16, 0));
            } else {
                frameLayout.getLayoutParams().width = l16;
            }
            frameLayout.setId(R.id.ixw);
            int a16 = com.tencent.qqnt.chathistory.util.m.a(50);
            if (frameLayout.getLayoutParams() == null) {
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(0, a16));
            } else {
                frameLayout.getLayoutParams().height = a16;
            }
            com.tencent.aio.view_dsl.dsl.f.m(frameLayout, R.id.rlCommenTitle);
            frameLayout.setBackground(AppCompatResources.getDrawable(frameLayout.getContext(), R.drawable.qui_common_fill_light_primary_bg));
            frameLayout.setPadding(frameLayout.getPaddingLeft(), frameLayout.getPaddingTop(), frameLayout.getPaddingRight(), com.tencent.qqnt.chathistory.util.m.a(10));
            QUIPageTabBar qUIPageTabBar = new QUIPageTabBar(frameLayout.getContext());
            frameLayout.addView(qUIPageTabBar);
            int l17 = com.tencent.aio.view_dsl.dsl.b.l();
            if (qUIPageTabBar.getLayoutParams() == null) {
                qUIPageTabBar.setLayoutParams(new ViewGroup.LayoutParams(l17, 0));
            } else {
                qUIPageTabBar.getLayoutParams().width = l17;
            }
            qUIPageTabBar.setId(R.id.f220902s);
            j(qUIPageTabBar);
            m(frameLayout);
            relativeLayout.addView(frameLayout);
            QQViewPager qQViewPager = new QQViewPager(relativeLayout.getContext());
            relativeLayout.addView(qQViewPager);
            int l18 = com.tencent.aio.view_dsl.dsl.b.l();
            if (qQViewPager.getLayoutParams() == null) {
                qQViewPager.setLayoutParams(new ViewGroup.LayoutParams(l18, 0));
            } else {
                qQViewPager.getLayoutParams().width = l18;
            }
            qQViewPager.setId(R.id.f164772au1);
            int p17 = com.tencent.aio.view_dsl.dsl.b.p();
            if (qQViewPager.getLayoutParams() == null) {
                qQViewPager.setLayoutParams(new ViewGroup.LayoutParams(0, p17));
            } else {
                qQViewPager.getLayoutParams().height = p17;
            }
            com.tencent.aio.view_dsl.dsl.f.m(qQViewPager, R.id.ixw);
            i(qQViewPager);
            l(relativeLayout);
            return relativeLayout;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    /* renamed from: getRoot */
    public View getMRv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (View) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return h();
    }

    @NotNull
    public final View h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        View view = this._root;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_root");
        return null;
    }

    public final void i(@NotNull QQViewPager qQViewPager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) qQViewPager);
        } else {
            Intrinsics.checkNotNullParameter(qQViewPager, "<set-?>");
            this.chatHistoryViewPager = qQViewPager;
        }
    }

    public final void j(@NotNull QUIPageTabBar qUIPageTabBar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qUIPageTabBar);
        } else {
            Intrinsics.checkNotNullParameter(qUIPageTabBar, "<set-?>");
            this.pageTitleBar = qUIPageTabBar;
        }
    }

    public final void k(@NotNull QUISecNavBar qUISecNavBar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qUISecNavBar);
        } else {
            Intrinsics.checkNotNullParameter(qUISecNavBar, "<set-?>");
            this.rlCommenTitle = qUISecNavBar;
        }
    }

    public final void l(@NotNull RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) relativeLayout);
        } else {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.root = relativeLayout;
        }
    }

    public final void m(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.slidingContainer = frameLayout;
        }
    }

    public final void n(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this._root = view;
        }
    }

    public /* synthetic */ l(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
