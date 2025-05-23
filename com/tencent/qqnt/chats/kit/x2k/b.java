package com.tencent.qqnt.chats.kit.x2k;

import android.content.Context;
import android.os.Trace;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/chats/kit/x2k/b;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroidx/constraintlayout/widget/ConstraintLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", "j", "(Landroid/view/View;)V", "_root", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "c", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "getImageView", "()Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "g", "(Lcom/tencent/qqnt/base/widget/RoundRectImageView;)V", "imageView", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "getTextView2", "()Landroid/widget/ImageView;", h.F, "(Landroid/widget/ImageView;)V", "textView2", "getTextView3", "i", "textView3", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public RoundRectImageView imageView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ImageView textView2;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ImageView textView3;

    public b(@NotNull Context context, @Nullable Integer num) {
        ConstraintLayout e16;
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
        j(e16);
    }

    @NotNull
    public final ConstraintLayout e(@NotNull Context context) {
        int i3;
        int i16;
        ViewGroup.LayoutParams layoutParams;
        int i17;
        int i18;
        ViewGroup.LayoutParams layoutParams2;
        int i19;
        int i26;
        ViewGroup.LayoutParams layoutParams3;
        int i27;
        int i28;
        ViewGroup.LayoutParams layoutParams4;
        ViewGroup.LayoutParams layoutParams5;
        int i29;
        int i36;
        ViewGroup.LayoutParams layoutParams6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ConstraintLayout) iPatchRedirector.redirect((short) 13, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        int l3 = com.tencent.aio.view_dsl.dsl.b.l();
        if (constraintLayout.getLayoutParams() == null) {
            constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
        } else {
            constraintLayout.getLayoutParams().width = l3;
        }
        int intValue = ((Number) a.a(70)).intValue();
        if (constraintLayout.getLayoutParams() == null) {
            constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(0, intValue));
        } else {
            constraintLayout.getLayoutParams().height = intValue;
        }
        RoundRectImageView roundRectImageView = new RoundRectImageView(constraintLayout.getContext(), null, 0, 6, null);
        constraintLayout.addView(roundRectImageView);
        roundRectImageView.setCornerRadiusAndMode(((Number) a.a(25)).intValue(), 1);
        int intValue2 = ((Number) a.a(48)).intValue();
        if (roundRectImageView.getLayoutParams() == null) {
            roundRectImageView.setLayoutParams(new ViewGroup.LayoutParams(intValue2, 0));
        } else {
            roundRectImageView.getLayoutParams().width = intValue2;
        }
        roundRectImageView.setId(R.id.dce);
        int intValue3 = ((Number) a.a(48)).intValue();
        if (roundRectImageView.getLayoutParams() == null) {
            roundRectImageView.setLayoutParams(new ViewGroup.LayoutParams(0, intValue3));
        } else {
            roundRectImageView.getLayoutParams().height = intValue3;
        }
        com.tencent.aio.view_dsl.dsl.a.a(roundRectImageView, 0);
        com.tencent.aio.view_dsl.dsl.a.h(roundRectImageView, 0);
        int intValue4 = ((Number) a.a(16)).intValue();
        ViewGroup.LayoutParams layoutParams7 = roundRectImageView.getLayoutParams();
        if (!(layoutParams7 instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams7 = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams7;
        if (marginLayoutParams != null) {
            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, intValue4);
            layoutParams = marginLayoutParams;
        } else {
            ViewGroup.LayoutParams layoutParams8 = roundRectImageView.getLayoutParams();
            if (layoutParams8 != null) {
                i3 = layoutParams8.width;
            } else {
                i3 = 0;
            }
            ViewGroup.LayoutParams layoutParams9 = roundRectImageView.getLayoutParams();
            if (layoutParams9 != null) {
                i16 = layoutParams9.height;
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
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance, intValue4);
                layoutParams = (ViewGroup.LayoutParams) newInstance;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        roundRectImageView.setLayoutParams(layoutParams);
        com.tencent.aio.view_dsl.dsl.a.f(roundRectImageView, 0);
        roundRectImageView.setImageDrawable(AppCompatResources.getDrawable(roundRectImageView.getContext(), R.drawable.qui_common_fill_standard_primary_bg_corner_4));
        g(roundRectImageView);
        Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
        ImageView imageView = new ImageView(constraintLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(constraintLayout, new Object[0]);
        if (invoke != null) {
            imageView.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int intValue5 = ((Number) a.a(86)).intValue();
            if (imageView.getLayoutParams() == null) {
                imageView.setLayoutParams(new ViewGroup.LayoutParams(intValue5, 0));
            } else {
                imageView.getLayoutParams().width = intValue5;
            }
            imageView.setId(R.id.jfq);
            int intValue6 = ((Number) a.a(16)).intValue();
            if (imageView.getLayoutParams() == null) {
                imageView.setLayoutParams(new ViewGroup.LayoutParams(0, intValue6));
            } else {
                imageView.getLayoutParams().height = intValue6;
            }
            com.tencent.aio.view_dsl.dsl.a.h(imageView, 0);
            com.tencent.aio.view_dsl.dsl.a.d(imageView, ((Number) com.tencent.aio.view_dsl.dsl.c.a(Double.valueOf(0.0d))).floatValue());
            int intValue7 = ((Number) a.a(16)).intValue();
            ViewGroup.LayoutParams layoutParams10 = imageView.getLayoutParams();
            if (!(layoutParams10 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams10 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams10;
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.topMargin = intValue7;
                layoutParams2 = marginLayoutParams2;
            } else {
                ViewGroup.LayoutParams layoutParams11 = imageView.getLayoutParams();
                if (layoutParams11 != null) {
                    i17 = layoutParams11.width;
                } else {
                    i17 = 0;
                }
                ViewGroup.LayoutParams layoutParams12 = imageView.getLayoutParams();
                if (layoutParams12 != null) {
                    i18 = layoutParams12.height;
                } else {
                    i18 = 0;
                }
                Object[] objArr2 = {new ViewGroup.LayoutParams(i17, i18)};
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(objArr2[0].getClass());
                Object[] array2 = arrayList2.toArray(new Class[0]);
                if (array2 != null) {
                    Class[] clsArr2 = (Class[]) array2;
                    Constructor it5 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    it5.setAccessible(true);
                    Object newInstance2 = it5.newInstance(Arrays.copyOf(objArr2, 1));
                    ((ViewGroup.MarginLayoutParams) newInstance2).topMargin = intValue7;
                    layoutParams2 = (ViewGroup.LayoutParams) newInstance2;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            imageView.setLayoutParams(layoutParams2);
            int intValue8 = ((Number) a.a(13)).intValue();
            ViewGroup.LayoutParams layoutParams13 = imageView.getLayoutParams();
            if (!(layoutParams13 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams13 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams13;
            if (marginLayoutParams3 != null) {
                MarginLayoutParamsCompat.setMarginStart(marginLayoutParams3, intValue8);
                layoutParams3 = marginLayoutParams3;
            } else {
                ViewGroup.LayoutParams layoutParams14 = imageView.getLayoutParams();
                if (layoutParams14 != null) {
                    i19 = layoutParams14.width;
                } else {
                    i19 = 0;
                }
                ViewGroup.LayoutParams layoutParams15 = imageView.getLayoutParams();
                if (layoutParams15 != null) {
                    i26 = layoutParams15.height;
                } else {
                    i26 = 0;
                }
                Object[] objArr3 = {new ViewGroup.LayoutParams(i19, i26)};
                ArrayList arrayList3 = new ArrayList(1);
                arrayList3.add(objArr3[0].getClass());
                Object[] array3 = arrayList3.toArray(new Class[0]);
                if (array3 != null) {
                    Class[] clsArr3 = (Class[]) array3;
                    Constructor it6 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr3, clsArr3.length));
                    Intrinsics.checkNotNullExpressionValue(it6, "it");
                    it6.setAccessible(true);
                    Object newInstance3 = it6.newInstance(Arrays.copyOf(objArr3, 1));
                    MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance3, intValue8);
                    layoutParams3 = (ViewGroup.LayoutParams) newInstance3;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            imageView.setLayoutParams(layoutParams3);
            imageView.setBackground(AppCompatResources.getDrawable(imageView.getContext(), R.drawable.qui_common_fill_standard_primary_bg_corner_4));
            com.tencent.aio.view_dsl.dsl.a.b(imageView, 0);
            com.tencent.aio.view_dsl.dsl.a.e(imageView, R.id.dce);
            h(imageView);
            constraintLayout.addView(imageView);
            Trace.endSection();
            Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
            ImageView imageView2 = new ImageView(constraintLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(constraintLayout, new Object[0]);
            if (invoke2 != null) {
                imageView2.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int intValue9 = ((Number) a.a(206)).intValue();
                if (imageView2.getLayoutParams() == null) {
                    imageView2.setLayoutParams(new ViewGroup.LayoutParams(intValue9, 0));
                } else {
                    imageView2.getLayoutParams().width = intValue9;
                }
                imageView2.setId(R.id.jfr);
                int intValue10 = ((Number) a.a(16)).intValue();
                if (imageView2.getLayoutParams() == null) {
                    imageView2.setLayoutParams(new ViewGroup.LayoutParams(0, intValue10));
                } else {
                    imageView2.getLayoutParams().height = intValue10;
                }
                com.tencent.aio.view_dsl.dsl.a.a(imageView2, 0);
                com.tencent.aio.view_dsl.dsl.a.d(imageView2, ((Number) com.tencent.aio.view_dsl.dsl.c.a(Double.valueOf(0.0d))).floatValue());
                int intValue11 = ((Number) a.a(16)).intValue();
                ViewGroup.LayoutParams layoutParams16 = imageView2.getLayoutParams();
                if (!(layoutParams16 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams16 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams16;
                if (marginLayoutParams4 != null) {
                    marginLayoutParams4.bottomMargin = intValue11;
                    layoutParams4 = marginLayoutParams4;
                } else {
                    ViewGroup.LayoutParams layoutParams17 = imageView2.getLayoutParams();
                    if (layoutParams17 != null) {
                        i27 = layoutParams17.width;
                    } else {
                        i27 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams18 = imageView2.getLayoutParams();
                    if (layoutParams18 != null) {
                        i28 = layoutParams18.height;
                    } else {
                        i28 = 0;
                    }
                    Object[] objArr4 = {new ViewGroup.LayoutParams(i27, i28)};
                    ArrayList arrayList4 = new ArrayList(1);
                    arrayList4.add(objArr4[0].getClass());
                    Object[] array4 = arrayList4.toArray(new Class[0]);
                    if (array4 != null) {
                        Class[] clsArr4 = (Class[]) array4;
                        Constructor it7 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr4, clsArr4.length));
                        Intrinsics.checkNotNullExpressionValue(it7, "it");
                        it7.setAccessible(true);
                        Object newInstance4 = it7.newInstance(Arrays.copyOf(objArr4, 1));
                        ((ViewGroup.MarginLayoutParams) newInstance4).bottomMargin = intValue11;
                        layoutParams4 = (ViewGroup.LayoutParams) newInstance4;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                imageView2.setLayoutParams(layoutParams4);
                int intValue12 = ((Number) a.a(13)).intValue();
                ViewGroup.LayoutParams layoutParams19 = imageView2.getLayoutParams();
                if (!(layoutParams19 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams5 = null;
                } else {
                    layoutParams5 = layoutParams19;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams5;
                if (marginLayoutParams5 != null) {
                    MarginLayoutParamsCompat.setMarginStart(marginLayoutParams5, intValue12);
                    layoutParams6 = marginLayoutParams5;
                } else {
                    ViewGroup.LayoutParams layoutParams20 = imageView2.getLayoutParams();
                    if (layoutParams20 != null) {
                        i29 = layoutParams20.width;
                    } else {
                        i29 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams21 = imageView2.getLayoutParams();
                    if (layoutParams21 != null) {
                        i36 = layoutParams21.height;
                    } else {
                        i36 = 0;
                    }
                    Object[] objArr5 = {new ViewGroup.LayoutParams(i29, i36)};
                    ArrayList arrayList5 = new ArrayList(1);
                    arrayList5.add(objArr5[0].getClass());
                    Object[] array5 = arrayList5.toArray(new Class[0]);
                    if (array5 != null) {
                        Class[] clsArr5 = (Class[]) array5;
                        Constructor it8 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr5, clsArr5.length));
                        Intrinsics.checkNotNullExpressionValue(it8, "it");
                        it8.setAccessible(true);
                        Object newInstance5 = it8.newInstance(Arrays.copyOf(objArr5, 1));
                        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance5, intValue12);
                        layoutParams6 = (ViewGroup.LayoutParams) newInstance5;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                imageView2.setLayoutParams(layoutParams6);
                imageView2.setBackground(AppCompatResources.getDrawable(imageView2.getContext(), R.drawable.qui_common_fill_standard_primary_bg_corner_4));
                com.tencent.aio.view_dsl.dsl.a.b(imageView2, 0);
                com.tencent.aio.view_dsl.dsl.a.e(imageView2, R.id.dce);
                i(imageView2);
                constraintLayout.addView(imageView2);
                Trace.endSection();
                return constraintLayout;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @NotNull
    public final View f() {
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

    public final void g(@NotNull RoundRectImageView roundRectImageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) roundRectImageView);
        } else {
            Intrinsics.checkNotNullParameter(roundRectImageView, "<set-?>");
            this.imageView = roundRectImageView;
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return f();
    }

    public final void h(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.textView2 = imageView;
        }
    }

    public final void i(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.textView3 = imageView;
        }
    }

    public final void j(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this._root = view;
        }
    }

    public /* synthetic */ b(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
