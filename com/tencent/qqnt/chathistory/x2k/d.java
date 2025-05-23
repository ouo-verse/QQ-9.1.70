package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.RoundImageView;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010(\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/d;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", "k", "(Landroid/view/View;)V", "_root", "Lcom/tencent/mobileqq/widget/RoundImageView;", "c", "Lcom/tencent/mobileqq/widget/RoundImageView;", "getIvIcon", "()Lcom/tencent/mobileqq/widget/RoundImageView;", "g", "(Lcom/tencent/mobileqq/widget/RoundImageView;)V", "ivIcon", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "j", "(Landroid/widget/TextView;)V", "tvTitle", "getTvTime", "i", "tvTime", "getTvSubTitle", tl.h.F, "tvSubTitle", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public RoundImageView ivIcon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public TextView tvTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView tvTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView tvSubTitle;

    public d(@NotNull Context context, @Nullable Integer num) {
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
        k(e16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.widget.RelativeLayout, android.view.View, java.lang.Object, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r6v35, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r6v54, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r8v13, types: [android.view.ViewGroup$LayoutParams] */
    @NotNull
    public final RelativeLayout e(@NotNull Context context) {
        int i3;
        int i16;
        ViewGroup.LayoutParams layoutParams;
        int i17;
        int i18;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i19;
        int i26;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        int i27;
        int i28;
        ViewGroup.LayoutParams layoutParams2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 15, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ?? relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        relativeLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        int l3 = com.tencent.aio.view_dsl.dsl.b.l();
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
        } else {
            relativeLayout.getLayoutParams().width = l3;
        }
        relativeLayout.setPadding(((Number) com.tencent.qqnt.chathistory.util.m.c(16)).intValue(), relativeLayout.getPaddingTop(), relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
        int intValue = ((Number) com.tencent.qqnt.chathistory.util.m.c(80)).intValue();
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, intValue));
        } else {
            relativeLayout.getLayoutParams().height = intValue;
        }
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), relativeLayout.getPaddingTop(), ((Number) com.tencent.qqnt.chathistory.util.m.c(16)).intValue(), relativeLayout.getPaddingBottom());
        RoundImageView roundImageView = new RoundImageView(relativeLayout.getContext());
        relativeLayout.addView(roundImageView);
        int intValue2 = ((Number) com.tencent.qqnt.chathistory.util.m.c(52)).intValue();
        if (roundImageView.getLayoutParams() == null) {
            roundImageView.setLayoutParams(new ViewGroup.LayoutParams(intValue2, 0));
        } else {
            roundImageView.getLayoutParams().width = intValue2;
        }
        roundImageView.setId(R.id.drx);
        int intValue3 = ((Number) com.tencent.qqnt.chathistory.util.m.c(52)).intValue();
        if (roundImageView.getLayoutParams() == null) {
            roundImageView.setLayoutParams(new ViewGroup.LayoutParams(0, intValue3));
        } else {
            roundImageView.getLayoutParams().height = intValue3;
        }
        roundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        roundImageView.setImageDrawable(AppCompatResources.getDrawable(roundImageView.getContext(), R.drawable.mpn));
        com.tencent.aio.view_dsl.dsl.f.o(roundImageView, true);
        roundImageView.setRadiusWithoutRight(8);
        g(roundImageView);
        TextView textView = new TextView(relativeLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
        if (invoke != null) {
            textView.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l16 = com.tencent.aio.view_dsl.dsl.b.l();
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(new ViewGroup.LayoutParams(l16, 0));
            } else {
                textView.getLayoutParams().width = l16;
            }
            textView.setId(R.id.k4v);
            int p16 = com.tencent.aio.view_dsl.dsl.b.p();
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
            } else {
                textView.getLayoutParams().height = p16;
            }
            int intValue4 = ((Number) com.tencent.qqnt.chathistory.util.m.c(12)).intValue();
            ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
            if (!(layoutParams3 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams3 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
            if (marginLayoutParams3 != null) {
                MarginLayoutParamsCompat.setMarginStart(marginLayoutParams3, intValue4);
                layoutParams = marginLayoutParams3;
            } else {
                ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
                if (layoutParams4 != null) {
                    i3 = layoutParams4.width;
                } else {
                    i3 = 0;
                }
                ViewGroup.LayoutParams layoutParams5 = textView.getLayoutParams();
                if (layoutParams5 != null) {
                    i16 = layoutParams5.height;
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
            textView.setLayoutParams(layoutParams);
            textView.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(17)).floatValue());
            textView.setEllipsize(TextUtils.TruncateAt.END);
            com.tencent.aio.view_dsl.dsl.f.k(textView, R.id.drx);
            com.tencent.aio.view_dsl.dsl.f.s(textView, R.id.drx);
            textView.setMaxLines(((Number) com.tencent.aio.view_dsl.dsl.c.a(1)).intValue());
            textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_primary, null));
            j(textView);
            relativeLayout.addView(textView);
            LinearLayout linearLayout = new LinearLayout(relativeLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
            if (invoke2 != null) {
                linearLayout.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int p17 = com.tencent.aio.view_dsl.dsl.b.p();
                if (linearLayout.getLayoutParams() == null) {
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(p17, 0));
                } else {
                    linearLayout.getLayoutParams().width = p17;
                }
                int p18 = com.tencent.aio.view_dsl.dsl.b.p();
                if (linearLayout.getLayoutParams() == null) {
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p18));
                } else {
                    linearLayout.getLayoutParams().height = p18;
                }
                int intValue5 = ((Number) com.tencent.qqnt.chathistory.util.m.c(12)).intValue();
                ViewGroup.LayoutParams layoutParams6 = linearLayout.getLayoutParams();
                if (!(layoutParams6 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams6 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams6;
                if (marginLayoutParams4 != null) {
                    MarginLayoutParamsCompat.setMarginStart(marginLayoutParams4, intValue5);
                    marginLayoutParams = marginLayoutParams4;
                } else {
                    ViewGroup.LayoutParams layoutParams7 = linearLayout.getLayoutParams();
                    if (layoutParams7 != null) {
                        i17 = layoutParams7.width;
                    } else {
                        i17 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams8 = linearLayout.getLayoutParams();
                    if (layoutParams8 != null) {
                        i18 = layoutParams8.height;
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
                        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance2, intValue5);
                        marginLayoutParams = (ViewGroup.LayoutParams) newInstance2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                linearLayout.setLayoutParams(marginLayoutParams);
                com.tencent.aio.view_dsl.dsl.f.m(linearLayout, R.id.k4v);
                com.tencent.aio.view_dsl.dsl.f.s(linearLayout, R.id.drx);
                int intValue6 = ((Number) com.tencent.qqnt.chathistory.util.m.c(4)).intValue();
                ViewGroup.LayoutParams layoutParams9 = linearLayout.getLayoutParams();
                if (!(layoutParams9 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams9 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams9;
                if (marginLayoutParams5 != null) {
                    marginLayoutParams5.topMargin = intValue6;
                    marginLayoutParams2 = marginLayoutParams5;
                } else {
                    ViewGroup.LayoutParams layoutParams10 = linearLayout.getLayoutParams();
                    if (layoutParams10 != null) {
                        i19 = layoutParams10.width;
                    } else {
                        i19 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams11 = linearLayout.getLayoutParams();
                    if (layoutParams11 != null) {
                        i26 = layoutParams11.height;
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
                        ((ViewGroup.MarginLayoutParams) newInstance3).topMargin = intValue6;
                        marginLayoutParams2 = (ViewGroup.LayoutParams) newInstance3;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                linearLayout.setLayoutParams(marginLayoutParams2);
                linearLayout.setOrientation(0);
                TextView textView2 = new TextView(linearLayout.getContext());
                Object invoke3 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                if (invoke3 != null) {
                    textView2.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                    int p19 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView2.getLayoutParams() == null) {
                        textView2.setLayoutParams(new ViewGroup.LayoutParams(p19, 0));
                    } else {
                        textView2.getLayoutParams().width = p19;
                    }
                    textView2.setId(R.id.k4u);
                    int p26 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView2.getLayoutParams() == null) {
                        textView2.setLayoutParams(new ViewGroup.LayoutParams(0, p26));
                    } else {
                        textView2.getLayoutParams().height = p26;
                    }
                    textView2.setText("\u4eca\u5929");
                    textView2.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(14)).floatValue());
                    textView2.setTextColor(textView2.getResources().getColorStateList(R.color.qui_common_text_secondary, null));
                    i(textView2);
                    linearLayout.addView(textView2);
                    TextView textView3 = new TextView(linearLayout.getContext());
                    Object invoke4 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                    if (invoke4 != null) {
                        textView3.setLayoutParams((ViewGroup.LayoutParams) invoke4);
                        int p27 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (textView3.getLayoutParams() == null) {
                            textView3.setLayoutParams(new ViewGroup.LayoutParams(p27, 0));
                        } else {
                            textView3.getLayoutParams().width = p27;
                        }
                        int p28 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (textView3.getLayoutParams() == null) {
                            textView3.setLayoutParams(new ViewGroup.LayoutParams(0, p28));
                        } else {
                            textView3.getLayoutParams().height = p28;
                        }
                        int intValue7 = ((Number) com.tencent.qqnt.chathistory.util.m.c(5)).intValue();
                        ViewGroup.LayoutParams layoutParams12 = textView3.getLayoutParams();
                        if (!(layoutParams12 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams12 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams12;
                        if (marginLayoutParams6 != null) {
                            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams6, intValue7);
                            layoutParams2 = marginLayoutParams6;
                        } else {
                            ViewGroup.LayoutParams layoutParams13 = textView3.getLayoutParams();
                            if (layoutParams13 != null) {
                                i27 = layoutParams13.width;
                            } else {
                                i27 = 0;
                            }
                            ViewGroup.LayoutParams layoutParams14 = textView3.getLayoutParams();
                            if (layoutParams14 != null) {
                                i28 = layoutParams14.height;
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
                                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance4, intValue7);
                                layoutParams2 = (ViewGroup.LayoutParams) newInstance4;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        textView3.setLayoutParams(layoutParams2);
                        textView3.setText("\u6765\u81ea");
                        textView3.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(14)).floatValue());
                        textView3.setTextColor(textView3.getResources().getColorStateList(R.color.qui_common_text_secondary, null));
                        linearLayout.addView(textView3);
                        TextView textView4 = new TextView(linearLayout.getContext());
                        Object invoke5 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                        if (invoke5 != null) {
                            textView4.setLayoutParams((ViewGroup.LayoutParams) invoke5);
                            int l17 = com.tencent.aio.view_dsl.dsl.b.l();
                            if (textView4.getLayoutParams() == null) {
                                textView4.setLayoutParams(new ViewGroup.LayoutParams(l17, 0));
                            } else {
                                textView4.getLayoutParams().width = l17;
                            }
                            textView4.setId(R.id.f1056566l);
                            int p29 = com.tencent.aio.view_dsl.dsl.b.p();
                            if (textView4.getLayoutParams() == null) {
                                textView4.setLayoutParams(new ViewGroup.LayoutParams(0, p29));
                            } else {
                                textView4.getLayoutParams().height = p29;
                            }
                            textView4.setText("XXX");
                            textView4.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(14)).floatValue());
                            textView4.setTextColor(textView4.getResources().getColorStateList(R.color.qui_common_text_secondary, null));
                            h(textView4);
                            linearLayout.addView(textView4);
                            relativeLayout.addView(linearLayout);
                            return relativeLayout;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
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

    public final void g(@NotNull RoundImageView roundImageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) roundImageView);
        } else {
            Intrinsics.checkNotNullParameter(roundImageView, "<set-?>");
            this.ivIcon = roundImageView;
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return f();
    }

    public final void h(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvSubTitle = textView;
        }
    }

    public final void i(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTime = textView;
        }
    }

    public final void j(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTitle = textView;
        }
    }

    public final void k(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this._root = view;
        }
    }

    public /* synthetic */ d(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
