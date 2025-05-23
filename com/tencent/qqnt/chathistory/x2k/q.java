package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.aio.view_dsl.dsl.MergeContainer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/q;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "f", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "g", "()Landroid/view/View;", "l", "(Landroid/view/View;)V", "_root", "Lcom/tencent/qqnt/chathistory/x2k/k;", "c", "Lcom/tencent/qqnt/chathistory/x2k/k;", "e", "()Lcom/tencent/qqnt/chathistory/x2k/k;", "i", "(Lcom/tencent/qqnt/chathistory/x2k/k;)V", "fileSearchContainer", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "getRy", "()Landroidx/recyclerview/widget/RecyclerView;", "k", "(Landroidx/recyclerview/widget/RecyclerView;)V", "ry", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "getRefreshLayout", "()Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "j", "(Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;)V", "refreshLayout", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "getEmptyContainer", "()Landroid/widget/FrameLayout;", tl.h.F, "(Landroid/widget/FrameLayout;)V", "emptyContainer", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class q implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public k fileSearchContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public RecyclerView ry;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public SmartRefreshLayout refreshLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public FrameLayout emptyContainer;

    public q(@NotNull Context context, @Nullable Integer num) {
        RelativeLayout f16;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) num);
            return;
        }
        this.context = context;
        if (num != null) {
            f16 = f(new ContextThemeWrapper(context, num.intValue()));
        } else {
            f16 = f(context);
        }
        l(f16);
    }

    @NotNull
    public final k e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (k) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        k kVar = this.fileSearchContainer;
        if (kVar != null) {
            return kVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fileSearchContainer");
        return null;
    }

    @NotNull
    public final RelativeLayout f(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 15, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        int l3 = com.tencent.aio.view_dsl.dsl.b.l();
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
        } else {
            relativeLayout.getLayoutParams().width = l3;
        }
        int l16 = com.tencent.aio.view_dsl.dsl.b.l();
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l16));
        } else {
            relativeLayout.getLayoutParams().height = l16;
        }
        k kVar = new k(context, null, null, false, 12, null);
        if (kVar.getMRv() instanceof MergeContainer) {
            View mRv = kVar.getMRv();
            if (mRv != null) {
                Iterator<View> it = ((MergeContainer) mRv).a().iterator();
                while (it.hasNext()) {
                    relativeLayout.addView(it.next());
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.view_dsl.dsl.MergeContainer");
            }
        } else {
            View mRv2 = kVar.getMRv();
            Intrinsics.checkNotNull(mRv2);
            Intrinsics.checkNotNullExpressionValue(mRv2, "view.root!!");
            int l17 = com.tencent.aio.view_dsl.dsl.b.l();
            if (mRv2.getLayoutParams() == null) {
                mRv2.setLayoutParams(new ViewGroup.LayoutParams(l17, 0));
            } else {
                mRv2.getLayoutParams().width = l17;
            }
            mRv2.setId(R.id.c_y);
            int a16 = com.tencent.qqnt.chathistory.util.m.a(60);
            if (mRv2.getLayoutParams() == null) {
                mRv2.setLayoutParams(new ViewGroup.LayoutParams(0, a16));
            } else {
                mRv2.getLayoutParams().height = a16;
            }
            relativeLayout.addView(kVar.getMRv());
        }
        i(kVar);
        View view = new View(relativeLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
        if (invoke != null) {
            view.setLayoutParams((ViewGroup.LayoutParams) invoke);
            com.tencent.aio.view_dsl.dsl.f.m(view, R.id.c_y);
            view.setId(R.id.bmt);
            int l18 = com.tencent.aio.view_dsl.dsl.b.l();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(l18, 0));
            } else {
                view.getLayoutParams().width = l18;
            }
            int b16 = com.tencent.qqnt.chathistory.util.m.b(Double.valueOf(0.5d));
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(0, b16));
            } else {
                view.getLayoutParams().height = b16;
            }
            relativeLayout.addView(view);
            SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(relativeLayout.getContext());
            relativeLayout.addView(smartRefreshLayout);
            com.tencent.aio.view_dsl.dsl.f.m(smartRefreshLayout, R.id.bmt);
            int l19 = com.tencent.aio.view_dsl.dsl.b.l();
            if (smartRefreshLayout.getLayoutParams() == null) {
                smartRefreshLayout.setLayoutParams(new ViewGroup.LayoutParams(l19, 0));
            } else {
                smartRefreshLayout.getLayoutParams().width = l19;
            }
            smartRefreshLayout.a(false);
            smartRefreshLayout.setId(R.id.f72333qk);
            smartRefreshLayout.setEnableLoadMore(true);
            int l26 = com.tencent.aio.view_dsl.dsl.b.l();
            if (smartRefreshLayout.getLayoutParams() == null) {
                smartRefreshLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l26));
            } else {
                smartRefreshLayout.getLayoutParams().height = l26;
            }
            smartRefreshLayout.Q(true);
            smartRefreshLayout.setEnableOverScrollDrag(true);
            RecyclerView recyclerView = new RecyclerView(smartRefreshLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(smartRefreshLayout, new Object[0]);
            if (invoke2 != null) {
                recyclerView.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int l27 = com.tencent.aio.view_dsl.dsl.b.l();
                if (recyclerView.getLayoutParams() == null) {
                    recyclerView.setLayoutParams(new ViewGroup.LayoutParams(l27, 0));
                } else {
                    recyclerView.getLayoutParams().width = l27;
                }
                recyclerView.setId(R.id.f792849c);
                int l28 = com.tencent.aio.view_dsl.dsl.b.l();
                if (recyclerView.getLayoutParams() == null) {
                    recyclerView.setLayoutParams(new ViewGroup.LayoutParams(0, l28));
                } else {
                    recyclerView.getLayoutParams().height = l28;
                }
                k(recyclerView);
                smartRefreshLayout.addView(recyclerView);
                j(smartRefreshLayout);
                FrameLayout frameLayout = new FrameLayout(relativeLayout.getContext());
                Object invoke3 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
                if (invoke3 != null) {
                    frameLayout.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                    com.tencent.aio.view_dsl.dsl.f.m(frameLayout, R.id.bmt);
                    frameLayout.setBackground(AppCompatResources.getDrawable(frameLayout.getContext(), R.drawable.qui_common_bg_bottom_light_bg));
                    int l29 = com.tencent.aio.view_dsl.dsl.b.l();
                    if (frameLayout.getLayoutParams() == null) {
                        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(l29, 0));
                    } else {
                        frameLayout.getLayoutParams().width = l29;
                    }
                    frameLayout.setId(R.id.bwb);
                    int l36 = com.tencent.aio.view_dsl.dsl.b.l();
                    if (frameLayout.getLayoutParams() == null) {
                        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l36));
                    } else {
                        frameLayout.getLayoutParams().height = l36;
                    }
                    frameLayout.setVisibility(8);
                    h(frameLayout);
                    relativeLayout.addView(frameLayout);
                    return relativeLayout;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @NotNull
    public final View g() {
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

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    /* renamed from: getRoot */
    public View getMRv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return g();
    }

    public final void h(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.emptyContainer = frameLayout;
        }
    }

    public final void i(@NotNull k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) kVar);
        } else {
            Intrinsics.checkNotNullParameter(kVar, "<set-?>");
            this.fileSearchContainer = kVar;
        }
    }

    public final void j(@NotNull SmartRefreshLayout smartRefreshLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) smartRefreshLayout);
        } else {
            Intrinsics.checkNotNullParameter(smartRefreshLayout, "<set-?>");
            this.refreshLayout = smartRefreshLayout;
        }
    }

    public final void k(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) recyclerView);
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.ry = recyclerView;
        }
    }

    public final void l(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this._root = view;
        }
    }

    public /* synthetic */ q(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
