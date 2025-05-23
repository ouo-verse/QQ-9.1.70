package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/s;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "attach", "Landroid/widget/FrameLayout;", "g", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "i", "()Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/view/View;)V", "_root", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "()Landroidx/recyclerview/widget/RecyclerView;", "l", "(Landroidx/recyclerview/widget/RecyclerView;)V", "ry", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "d", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "f", "()Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "k", "(Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;)V", "refreshLayout", "e", "Landroid/widget/FrameLayout;", "()Landroid/widget/FrameLayout;", "j", "(Landroid/widget/FrameLayout;)V", "flEmptyContainer", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;Landroid/view/ViewGroup;Z)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class s implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public RecyclerView ry;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public SmartRefreshLayout refreshLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public FrameLayout flEmptyContainer;

    public s(@NotNull Context context, @Nullable Integer num, @Nullable ViewGroup viewGroup, boolean z16) {
        FrameLayout g16;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, num, viewGroup, Boolean.valueOf(z16));
            return;
        }
        this.context = context;
        if (num != null) {
            g16 = g(new ContextThemeWrapper(context, num.intValue()), viewGroup, z16);
        } else {
            g16 = g(context, viewGroup, z16);
        }
        m(g16);
    }

    @NotNull
    public final FrameLayout e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        FrameLayout frameLayout = this.flEmptyContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flEmptyContainer");
        return null;
    }

    @NotNull
    public final SmartRefreshLayout f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SmartRefreshLayout) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout != null) {
            return smartRefreshLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        return null;
    }

    @NotNull
    public final FrameLayout g(@NotNull Context context, @Nullable ViewGroup parent, boolean attach) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 13, this, context, parent, Boolean.valueOf(attach));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (parent == null) {
            parent = new FrameLayout(context);
        }
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(parent, new Object[0]);
        if (invoke != null) {
            frameLayout.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l3 = com.tencent.aio.view_dsl.dsl.b.l();
            if (frameLayout.getLayoutParams() == null) {
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
            } else {
                frameLayout.getLayoutParams().width = l3;
            }
            frameLayout.setBackground(AppCompatResources.getDrawable(frameLayout.getContext(), R.drawable.skin_background));
            int l16 = com.tencent.aio.view_dsl.dsl.b.l();
            if (frameLayout.getLayoutParams() == null) {
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l16));
            } else {
                frameLayout.getLayoutParams().height = l16;
            }
            SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(frameLayout.getContext());
            frameLayout.addView(smartRefreshLayout);
            int l17 = com.tencent.aio.view_dsl.dsl.b.l();
            if (smartRefreshLayout.getLayoutParams() == null) {
                smartRefreshLayout.setLayoutParams(new ViewGroup.LayoutParams(l17, 0));
            } else {
                smartRefreshLayout.getLayoutParams().width = l17;
            }
            smartRefreshLayout.setId(R.id.f72333qk);
            int l18 = com.tencent.aio.view_dsl.dsl.b.l();
            if (smartRefreshLayout.getLayoutParams() == null) {
                smartRefreshLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l18));
            } else {
                smartRefreshLayout.getLayoutParams().height = l18;
            }
            RecyclerView recyclerView = new RecyclerView(smartRefreshLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(smartRefreshLayout, new Object[0]);
            if (invoke2 != null) {
                recyclerView.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int l19 = com.tencent.aio.view_dsl.dsl.b.l();
                if (recyclerView.getLayoutParams() == null) {
                    recyclerView.setLayoutParams(new ViewGroup.LayoutParams(l19, 0));
                } else {
                    recyclerView.getLayoutParams().width = l19;
                }
                recyclerView.setId(R.id.f792849c);
                int l26 = com.tencent.aio.view_dsl.dsl.b.l();
                if (recyclerView.getLayoutParams() == null) {
                    recyclerView.setLayoutParams(new ViewGroup.LayoutParams(0, l26));
                } else {
                    recyclerView.getLayoutParams().height = l26;
                }
                l(recyclerView);
                smartRefreshLayout.addView(recyclerView);
                k(smartRefreshLayout);
                FrameLayout frameLayout2 = new FrameLayout(frameLayout.getContext());
                Object invoke3 = LayoutBuilderKt.b().invoke(frameLayout, new Object[0]);
                if (invoke3 != null) {
                    frameLayout2.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                    int l27 = com.tencent.aio.view_dsl.dsl.b.l();
                    if (frameLayout2.getLayoutParams() == null) {
                        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(l27, 0));
                    } else {
                        frameLayout2.getLayoutParams().width = l27;
                    }
                    frameLayout2.setId(R.id.v7b);
                    int l28 = com.tencent.aio.view_dsl.dsl.b.l();
                    if (frameLayout2.getLayoutParams() == null) {
                        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(0, l28));
                    } else {
                        frameLayout2.getLayoutParams().height = l28;
                    }
                    frameLayout2.setClickable(true);
                    j(frameLayout2);
                    frameLayout.addView(frameLayout2);
                    if (attach) {
                        parent.addView(frameLayout);
                    }
                    return frameLayout;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    /* renamed from: getRoot */
    public View getMRv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return i();
    }

    @NotNull
    public final RecyclerView h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        RecyclerView recyclerView = this.ry;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ry");
        return null;
    }

    @NotNull
    public final View i() {
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

    public final void j(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.flEmptyContainer = frameLayout;
        }
    }

    public final void k(@NotNull SmartRefreshLayout smartRefreshLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) smartRefreshLayout);
        } else {
            Intrinsics.checkNotNullParameter(smartRefreshLayout, "<set-?>");
            this.refreshLayout = smartRefreshLayout;
        }
    }

    public final void l(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) recyclerView);
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.ry = recyclerView;
        }
    }

    public final void m(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this._root = view;
        }
    }

    public /* synthetic */ s(Context context, Integer num, ViewGroup viewGroup, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num, (i3 & 4) == 0 ? viewGroup : null, (i3 & 8) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, viewGroup, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
