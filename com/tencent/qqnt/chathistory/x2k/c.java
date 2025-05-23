package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/c;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "attach", "Landroid/widget/LinearLayout;", "i", "a", "Landroid/content/Context;", "e", "()Landroid/content/Context;", "b", "Landroid/view/View;", "k", "()Landroid/view/View;", "o", "(Landroid/view/View;)V", "_root", "Landroid/widget/ProgressBar;", "c", "Landroid/widget/ProgressBar;", tl.h.F, "()Landroid/widget/ProgressBar;", DomainData.DOMAIN_NAME, "(Landroid/widget/ProgressBar;)V", "progressBar", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "f", "()Landroid/widget/TextView;", "l", "(Landroid/widget/TextView;)V", "morebtnFooter", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "msgMigrationTips", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public ProgressBar progressBar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public TextView morebtnFooter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView msgMigrationTips;

    public c(@NotNull Context context, @Nullable Integer num) {
        LinearLayout j3;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) num);
            return;
        }
        this.context = context;
        if (num != null) {
            j3 = j(this, new ContextThemeWrapper(context, num.intValue()), null, false, 6, null);
        } else {
            j3 = j(this, context, null, false, 6, null);
        }
        o(j3);
    }

    public static /* synthetic */ LinearLayout j(c cVar, Context context, ViewGroup viewGroup, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            viewGroup = null;
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return cVar.i(context, viewGroup, z16);
    }

    @NotNull
    public final Context e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Context) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.context;
    }

    @NotNull
    public final TextView f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TextView) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        TextView textView = this.morebtnFooter;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("morebtnFooter");
        return null;
    }

    @NotNull
    public final TextView g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TextView) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        TextView textView = this.msgMigrationTips;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("msgMigrationTips");
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return k();
    }

    @NotNull
    public final ProgressBar h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ProgressBar) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            return progressBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        return null;
    }

    @NotNull
    public final LinearLayout i(@NotNull Context context, @Nullable ViewGroup parent, boolean attach) {
        int i3;
        int i16;
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 13, this, context, parent, Boolean.valueOf(attach));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ViewGroup viewGroup = parent;
        if (parent == null) {
            viewGroup = new FrameLayout(context);
        }
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(viewGroup, new Object[0]);
        if (invoke != null) {
            linearLayout.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l3 = com.tencent.aio.view_dsl.dsl.b.l();
            if (linearLayout.getLayoutParams() == null) {
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
            } else {
                linearLayout.getLayoutParams().width = l3;
            }
            int intValue = ((Number) com.tencent.qqnt.chathistory.util.m.c(60)).intValue();
            if (linearLayout.getLayoutParams() == null) {
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, intValue));
            } else {
                linearLayout.getLayoutParams().height = intValue;
            }
            linearLayout.setGravity(com.tencent.aio.view_dsl.dsl.b.e());
            linearLayout.setOrientation(0);
            linearLayout.setMinimumHeight(((Number) com.tencent.qqnt.chathistory.util.m.c(60)).intValue());
            ProgressBar progressBar = new ProgressBar(linearLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
            if (invoke2 != null) {
                progressBar.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int intValue2 = ((Number) com.tencent.qqnt.chathistory.util.m.c(20)).intValue();
                if (progressBar.getLayoutParams() == null) {
                    progressBar.setLayoutParams(new ViewGroup.LayoutParams(intValue2, 0));
                } else {
                    progressBar.getLayoutParams().width = intValue2;
                }
                com.tencent.aio.view_dsl.dsl.e.a(progressBar, R.drawable.f160875o7);
                progressBar.setId(R.id.g1g);
                progressBar.setIndeterminate(true);
                int intValue3 = ((Number) com.tencent.qqnt.chathistory.util.m.c(20)).intValue();
                if (progressBar.getLayoutParams() == null) {
                    progressBar.setLayoutParams(new ViewGroup.LayoutParams(0, intValue3));
                } else {
                    progressBar.getLayoutParams().height = intValue3;
                }
                com.tencent.aio.view_dsl.dsl.f.p(progressBar, com.tencent.aio.view_dsl.dsl.b.g() | com.tencent.aio.view_dsl.dsl.b.f());
                int intValue4 = ((Number) com.tencent.qqnt.chathistory.util.m.c(12)).intValue();
                ViewGroup.LayoutParams layoutParams2 = progressBar.getLayoutParams();
                if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams2 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                if (marginLayoutParams != null) {
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, intValue4);
                    layoutParams = marginLayoutParams;
                } else {
                    ViewGroup.LayoutParams layoutParams3 = progressBar.getLayoutParams();
                    if (layoutParams3 != null) {
                        i3 = layoutParams3.width;
                    } else {
                        i3 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams4 = progressBar.getLayoutParams();
                    if (layoutParams4 != null) {
                        i16 = layoutParams4.height;
                    } else {
                        i16 = 0;
                    }
                    Object[] objArr = {new ViewGroup.LayoutParams(i3, i16)};
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(objArr[0].getClass());
                    Object[] array = arrayList.toArray(new Class[0]);
                    if (array != null) {
                        Class[] clsArr = (Class[]) array;
                        Constructor it = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        it.setAccessible(true);
                        Object newInstance = it.newInstance(Arrays.copyOf(objArr, 1));
                        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance, intValue4);
                        layoutParams = (ViewGroup.LayoutParams) newInstance;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                progressBar.setLayoutParams(layoutParams);
                n(progressBar);
                linearLayout.addView(progressBar);
                TextView textView = new TextView(linearLayout.getContext());
                Object invoke3 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                if (invoke3 != null) {
                    textView.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                    int p16 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView.getLayoutParams() == null) {
                        textView.setLayoutParams(new ViewGroup.LayoutParams(p16, 0));
                    } else {
                        textView.getLayoutParams().width = p16;
                    }
                    textView.setId(R.id.f0v);
                    int p17 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView.getLayoutParams() == null) {
                        textView.setLayoutParams(new ViewGroup.LayoutParams(0, p17));
                    } else {
                        textView.getLayoutParams().height = p17;
                    }
                    textView.setText(R.string.f170729zk2);
                    textView.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(14)).floatValue());
                    com.tencent.aio.view_dsl.dsl.f.p(textView, com.tencent.aio.view_dsl.dsl.b.g() | com.tencent.aio.view_dsl.dsl.b.f());
                    textView.setGravity(com.tencent.aio.view_dsl.dsl.b.e());
                    textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.skin_gray3));
                    l(textView);
                    linearLayout.addView(textView);
                    TextView textView2 = new TextView(linearLayout.getContext());
                    Object invoke4 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                    if (invoke4 != null) {
                        textView2.setLayoutParams((ViewGroup.LayoutParams) invoke4);
                        int p18 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (textView2.getLayoutParams() == null) {
                            textView2.setLayoutParams(new ViewGroup.LayoutParams(p18, 0));
                        } else {
                            textView2.getLayoutParams().width = p18;
                        }
                        textView2.setId(R.id.zg6);
                        int p19 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (textView2.getLayoutParams() == null) {
                            textView2.setLayoutParams(new ViewGroup.LayoutParams(0, p19));
                        } else {
                            textView2.getLayoutParams().height = p19;
                        }
                        textView2.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(14)).floatValue());
                        com.tencent.aio.view_dsl.dsl.f.p(textView2, com.tencent.aio.view_dsl.dsl.b.g() | com.tencent.aio.view_dsl.dsl.b.f());
                        textView2.setGravity(com.tencent.aio.view_dsl.dsl.b.e());
                        m(textView2);
                        linearLayout.addView(textView2);
                        if (attach) {
                            viewGroup.addView(linearLayout);
                        }
                        return linearLayout;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @NotNull
    public final View k() {
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

    public final void l(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.morebtnFooter = textView;
        }
    }

    public final void m(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.msgMigrationTips = textView;
        }
    }

    public final void n(@NotNull ProgressBar progressBar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) progressBar);
        } else {
            Intrinsics.checkNotNullParameter(progressBar, "<set-?>");
            this.progressBar = progressBar;
        }
    }

    public final void o(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this._root = view;
        }
    }

    public /* synthetic */ c(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
