package com.tencent.qqnt.chathistory.x2k;

import android.app.Activity;
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
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00103\u001a\u00020-8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/FragmentChatHistoryFileCategory;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "g", "()Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/view/View;)V", "_root", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "c", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "f", "()Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "l", "(Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;)V", "title", "d", "getLine", "i", "line", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "getRy", "()Landroidx/recyclerview/widget/RecyclerView;", "j", "(Landroidx/recyclerview/widget/RecyclerView;)V", "ry", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "getSmartRefreshLayout", "()Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "k", "(Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;)V", "smartRefreshLayout", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "getFlEmptyContainer", "()Landroid/widget/FrameLayout;", tl.h.F, "(Landroid/widget/FrameLayout;)V", "flEmptyContainer", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class FragmentChatHistoryFileCategory implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public QUISecNavBar title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public View line;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public RecyclerView ry;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public SmartRefreshLayout smartRefreshLayout;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public FrameLayout flEmptyContainer;

    public FragmentChatHistoryFileCategory(@NotNull Context context, @Nullable Integer num) {
        RelativeLayout e16;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) num);
            return;
        }
        this.context = context;
        if (num != null) {
            e16 = e(new ContextThemeWrapper(context, num.intValue()));
        } else {
            e16 = e(context);
        }
        m(e16);
    }

    @NotNull
    public final RelativeLayout e(@NotNull final Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 17, (Object) this, (Object) context);
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
        relativeLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        QUISecNavBar qUISecNavBar = new QUISecNavBar(context, null, 0, 6, null);
        qUISecNavBar.setLeftType(2);
        qUISecNavBar.setCenterType(1);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>(context) { // from class: com.tencent.qqnt.chathistory.x2k.FragmentChatHistoryFileCategory$getRootView$1$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view, @NotNull BaseAction motion) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) motion);
                    return;
                }
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(motion, "motion");
                if (motion == BaseAction.ACTION_LEFT_BUTTON) {
                    Context context2 = this.$context;
                    Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
                    if (activity != null) {
                        activity.onBackPressed();
                    }
                }
            }
        });
        qUISecNavBar.setId(R.id.title);
        relativeLayout.addView(qUISecNavBar);
        l(qUISecNavBar);
        View view = new View(relativeLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
        if (invoke != null) {
            view.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l17 = com.tencent.aio.view_dsl.dsl.b.l();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(l17, 0));
            } else {
                view.getLayoutParams().width = l17;
            }
            view.setBackground(AppCompatResources.getDrawable(view.getContext(), R.drawable.qui_common_border_standard_bg));
            view.setId(R.id.e_1);
            int intValue = ((Number) com.tencent.qqnt.chathistory.util.m.c(Double.valueOf(0.5d))).intValue();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(0, intValue));
            } else {
                view.getLayoutParams().height = intValue;
            }
            com.tencent.aio.view_dsl.dsl.f.m(view, R.id.title);
            i(view);
            relativeLayout.addView(view);
            SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(relativeLayout.getContext());
            relativeLayout.addView(smartRefreshLayout);
            int l18 = com.tencent.aio.view_dsl.dsl.b.l();
            if (smartRefreshLayout.getLayoutParams() == null) {
                smartRefreshLayout.setLayoutParams(new ViewGroup.LayoutParams(l18, 0));
            } else {
                smartRefreshLayout.getLayoutParams().width = l18;
            }
            smartRefreshLayout.a(false);
            smartRefreshLayout.setId(R.id.f86434rn);
            int l19 = com.tencent.aio.view_dsl.dsl.b.l();
            if (smartRefreshLayout.getLayoutParams() == null) {
                smartRefreshLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l19));
            } else {
                smartRefreshLayout.getLayoutParams().height = l19;
            }
            com.tencent.aio.view_dsl.dsl.f.m(smartRefreshLayout, R.id.e_1);
            smartRefreshLayout.setEnableOverScrollDrag(true);
            smartRefreshLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
            RecyclerView recyclerView = new RecyclerView(smartRefreshLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(smartRefreshLayout, new Object[0]);
            if (invoke2 != null) {
                recyclerView.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int l26 = com.tencent.aio.view_dsl.dsl.b.l();
                if (recyclerView.getLayoutParams() == null) {
                    recyclerView.setLayoutParams(new ViewGroup.LayoutParams(l26, 0));
                } else {
                    recyclerView.getLayoutParams().width = l26;
                }
                recyclerView.setId(R.id.f792849c);
                int p16 = com.tencent.aio.view_dsl.dsl.b.p();
                if (recyclerView.getLayoutParams() == null) {
                    recyclerView.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
                } else {
                    recyclerView.getLayoutParams().height = p16;
                }
                recyclerView.setOverScrollMode(2);
                j(recyclerView);
                smartRefreshLayout.addView(recyclerView);
                k(smartRefreshLayout);
                FrameLayout frameLayout = new FrameLayout(relativeLayout.getContext());
                Object invoke3 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
                if (invoke3 != null) {
                    frameLayout.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                    int l27 = com.tencent.aio.view_dsl.dsl.b.l();
                    if (frameLayout.getLayoutParams() == null) {
                        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(l27, 0));
                    } else {
                        frameLayout.getLayoutParams().width = l27;
                    }
                    frameLayout.setId(R.id.v7b);
                    int l28 = com.tencent.aio.view_dsl.dsl.b.l();
                    if (frameLayout.getLayoutParams() == null) {
                        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l28));
                    } else {
                        frameLayout.getLayoutParams().height = l28;
                    }
                    com.tencent.aio.view_dsl.dsl.f.m(frameLayout, R.id.e_1);
                    frameLayout.setVisibility(8);
                    frameLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
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
    public final QUISecNavBar f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QUISecNavBar) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        QUISecNavBar qUISecNavBar = this.title;
        if (qUISecNavBar != null) {
            return qUISecNavBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("title");
        return null;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (View) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return g();
    }

    public final void h(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.flEmptyContainer = frameLayout;
        }
    }

    public final void i(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.line = view;
        }
    }

    public final void j(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) recyclerView);
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.ry = recyclerView;
        }
    }

    public final void k(@NotNull SmartRefreshLayout smartRefreshLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) smartRefreshLayout);
        } else {
            Intrinsics.checkNotNullParameter(smartRefreshLayout, "<set-?>");
            this.smartRefreshLayout = smartRefreshLayout;
        }
    }

    public final void l(@NotNull QUISecNavBar qUISecNavBar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qUISecNavBar);
        } else {
            Intrinsics.checkNotNullParameter(qUISecNavBar, "<set-?>");
            this.title = qUISecNavBar;
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

    public /* synthetic */ FragmentChatHistoryFileCategory(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
