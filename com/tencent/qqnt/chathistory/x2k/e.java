package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00103\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b.\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\"\u00106\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b2\u0010+\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\"\u00109\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b7\u0010+\u001a\u0004\b8\u0010-\"\u0004\b7\u0010/R\"\u0010?\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b:\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/e;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", "o", "(Landroid/view/View;)V", "_root", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "c", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "getStructSelected", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;)V", "structSelected", "Lcom/tencent/mobileqq/widget/RoundImageView;", "d", "Lcom/tencent/mobileqq/widget/RoundImageView;", "getStructIcon", "()Lcom/tencent/mobileqq/widget/RoundImageView;", "k", "(Lcom/tencent/mobileqq/widget/RoundImageView;)V", "structIcon", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "getStructIconFrame", "()Landroid/widget/FrameLayout;", "l", "(Landroid/widget/FrameLayout;)V", "structIconFrame", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getBrief", "()Landroid/widget/TextView;", "g", "(Landroid/widget/TextView;)V", "brief", "getDateText", tl.h.F, "dateText", "getTvFromLabel", DomainData.DOMAIN_NAME, "tvFromLabel", "i", "getMsgfrom", "msgfrom", "j", "Landroid/widget/RelativeLayout;", "getRecentStructItem", "()Landroid/widget/RelativeLayout;", "(Landroid/widget/RelativeLayout;)V", "recentStructItem", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public QUICheckBox structSelected;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public RoundImageView structIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public FrameLayout structIconFrame;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView brief;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public TextView dateText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public TextView tvFromLabel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public TextView msgfrom;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout recentStructItem;

    public e(@NotNull Context context, @Nullable Integer num) {
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
        o(e16);
    }

    @NotNull
    public final RelativeLayout e(@NotNull Context context) {
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
        int i29;
        int i36;
        ViewGroup.LayoutParams layoutParams5;
        int i37;
        int i38;
        ViewGroup.LayoutParams layoutParams6;
        int i39;
        int i46;
        ViewGroup.LayoutParams layoutParams7;
        int i47;
        int i48;
        ViewGroup.LayoutParams layoutParams8;
        int i49;
        int i56;
        ViewGroup.LayoutParams layoutParams9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 23, (Object) this, (Object) context);
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
        relativeLayout.setBackground(AppCompatResources.getDrawable(relativeLayout.getContext(), R.drawable.qui_common_fill_light_primary_bg_selector));
        relativeLayout.setId(R.id.i0y);
        int p16 = com.tencent.aio.view_dsl.dsl.b.p();
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
        } else {
            relativeLayout.getLayoutParams().height = p16;
        }
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), relativeLayout.getPaddingTop(), relativeLayout.getPaddingRight(), ((Number) com.tencent.qqnt.chathistory.util.m.c(12)).intValue());
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), ((Number) com.tencent.qqnt.chathistory.util.m.c(12)).intValue(), relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
        QUICheckBox qUICheckBox = new QUICheckBox(relativeLayout.getContext());
        relativeLayout.addView(qUICheckBox);
        qUICheckBox.setId(R.id.j4f);
        int intValue = ((Number) com.tencent.qqnt.chathistory.util.m.c(24)).intValue();
        if (qUICheckBox.getLayoutParams() == null) {
            qUICheckBox.setLayoutParams(new ViewGroup.LayoutParams(intValue, 0));
        } else {
            qUICheckBox.getLayoutParams().width = intValue;
        }
        int intValue2 = ((Number) com.tencent.qqnt.chathistory.util.m.c(24)).intValue();
        if (qUICheckBox.getLayoutParams() == null) {
            qUICheckBox.setLayoutParams(new ViewGroup.LayoutParams(0, intValue2));
        } else {
            qUICheckBox.getLayoutParams().height = intValue2;
        }
        int intValue3 = ((Number) com.tencent.qqnt.chathistory.util.m.c(17)).intValue();
        ViewGroup.LayoutParams layoutParams10 = qUICheckBox.getLayoutParams();
        if (!(layoutParams10 instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams10 = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams10;
        if (marginLayoutParams != null) {
            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, intValue3);
            layoutParams = marginLayoutParams;
        } else {
            ViewGroup.LayoutParams layoutParams11 = qUICheckBox.getLayoutParams();
            if (layoutParams11 != null) {
                i3 = layoutParams11.width;
            } else {
                i3 = 0;
            }
            ViewGroup.LayoutParams layoutParams12 = qUICheckBox.getLayoutParams();
            if (layoutParams12 != null) {
                i16 = layoutParams12.height;
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
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance, intValue3);
                layoutParams = (ViewGroup.LayoutParams) newInstance;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        qUICheckBox.setLayoutParams(layoutParams);
        qUICheckBox.setFocusable(false);
        qUICheckBox.setFocusableInTouchMode(false);
        qUICheckBox.setClickable(false);
        qUICheckBox.setVisibility(8);
        com.tencent.aio.view_dsl.dsl.f.e(qUICheckBox, true);
        com.tencent.aio.view_dsl.dsl.f.o(qUICheckBox, true);
        m(qUICheckBox);
        FrameLayout frameLayout = new FrameLayout(relativeLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
        if (invoke != null) {
            frameLayout.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int intValue4 = ((Number) com.tencent.qqnt.chathistory.util.m.c(52)).intValue();
            if (frameLayout.getLayoutParams() == null) {
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(intValue4, 0));
            } else {
                frameLayout.getLayoutParams().width = intValue4;
            }
            frameLayout.setId(R.id.j4e);
            int intValue5 = ((Number) com.tencent.qqnt.chathistory.util.m.c(52)).intValue();
            if (frameLayout.getLayoutParams() == null) {
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(0, intValue5));
            } else {
                frameLayout.getLayoutParams().height = intValue5;
            }
            int intValue6 = ((Number) com.tencent.qqnt.chathistory.util.m.c(16)).intValue();
            ViewGroup.LayoutParams layoutParams13 = frameLayout.getLayoutParams();
            if (!(layoutParams13 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams13 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams13;
            if (marginLayoutParams2 != null) {
                MarginLayoutParamsCompat.setMarginStart(marginLayoutParams2, intValue6);
                layoutParams2 = marginLayoutParams2;
            } else {
                ViewGroup.LayoutParams layoutParams14 = frameLayout.getLayoutParams();
                if (layoutParams14 != null) {
                    i17 = layoutParams14.width;
                } else {
                    i17 = 0;
                }
                ViewGroup.LayoutParams layoutParams15 = frameLayout.getLayoutParams();
                if (layoutParams15 != null) {
                    i18 = layoutParams15.height;
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
                    MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance2, intValue6);
                    layoutParams2 = (ViewGroup.LayoutParams) newInstance2;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            frameLayout.setLayoutParams(layoutParams2);
            com.tencent.aio.view_dsl.dsl.f.s(frameLayout, R.id.j4f);
            int intValue7 = ((Number) com.tencent.qqnt.chathistory.util.m.c(16)).intValue();
            ViewGroup.LayoutParams layoutParams16 = frameLayout.getLayoutParams();
            if (!(layoutParams16 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams16 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams16;
            if (marginLayoutParams3 != null) {
                MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams3, intValue7);
                layoutParams3 = marginLayoutParams3;
            } else {
                ViewGroup.LayoutParams layoutParams17 = frameLayout.getLayoutParams();
                if (layoutParams17 != null) {
                    i19 = layoutParams17.width;
                } else {
                    i19 = 0;
                }
                ViewGroup.LayoutParams layoutParams18 = frameLayout.getLayoutParams();
                if (layoutParams18 != null) {
                    i26 = layoutParams18.height;
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
                    MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance3, intValue7);
                    layoutParams3 = (ViewGroup.LayoutParams) newInstance3;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            frameLayout.setLayoutParams(layoutParams3);
            com.tencent.aio.view_dsl.dsl.f.o(frameLayout, true);
            RoundImageView roundImageView = new RoundImageView(frameLayout.getContext());
            frameLayout.addView(roundImageView);
            int c17 = com.tencent.aio.view_dsl.dsl.b.c();
            if (roundImageView.getLayoutParams() == null) {
                roundImageView.setLayoutParams(new ViewGroup.LayoutParams(c17, 0));
            } else {
                roundImageView.getLayoutParams().width = c17;
            }
            roundImageView.setId(R.id.j4d);
            int c18 = com.tencent.aio.view_dsl.dsl.b.c();
            if (roundImageView.getLayoutParams() == null) {
                roundImageView.setLayoutParams(new ViewGroup.LayoutParams(0, c18));
            } else {
                roundImageView.getLayoutParams().height = c18;
            }
            roundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            com.tencent.aio.view_dsl.dsl.f.p(roundImageView, com.tencent.aio.view_dsl.dsl.b.e());
            roundImageView.setImageDrawable(AppCompatResources.getDrawable(roundImageView.getContext(), R.drawable.mpn));
            roundImageView.setmRadius(8, false);
            k(roundImageView);
            l(frameLayout);
            relativeLayout.addView(frameLayout);
            TextView textView = new TextView(relativeLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
            if (invoke2 != null) {
                textView.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int p17 = com.tencent.aio.view_dsl.dsl.b.p();
                if (textView.getLayoutParams() == null) {
                    textView.setLayoutParams(new ViewGroup.LayoutParams(p17, 0));
                } else {
                    textView.getLayoutParams().width = p17;
                }
                textView.setId(R.id.f164642ae0);
                int p18 = com.tencent.aio.view_dsl.dsl.b.p();
                if (textView.getLayoutParams() == null) {
                    textView.setLayoutParams(new ViewGroup.LayoutParams(0, p18));
                } else {
                    textView.getLayoutParams().height = p18;
                }
                textView.setText("\u4f01\u4e1a\u5fae\u4fe1\u6587\u6863");
                textView.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(17)).floatValue());
                int intValue8 = ((Number) com.tencent.qqnt.chathistory.util.m.c(1)).intValue();
                ViewGroup.LayoutParams layoutParams19 = textView.getLayoutParams();
                if (!(layoutParams19 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams19 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams19;
                if (marginLayoutParams4 != null) {
                    marginLayoutParams4.topMargin = intValue8;
                    layoutParams4 = marginLayoutParams4;
                } else {
                    ViewGroup.LayoutParams layoutParams20 = textView.getLayoutParams();
                    if (layoutParams20 != null) {
                        i27 = layoutParams20.width;
                    } else {
                        i27 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams21 = textView.getLayoutParams();
                    if (layoutParams21 != null) {
                        i28 = layoutParams21.height;
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
                        ((ViewGroup.MarginLayoutParams) newInstance4).topMargin = intValue8;
                        layoutParams4 = (ViewGroup.LayoutParams) newInstance4;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                textView.setLayoutParams(layoutParams4);
                com.tencent.aio.view_dsl.dsl.f.s(textView, R.id.j4e);
                textView.setMaxLines(((Number) com.tencent.aio.view_dsl.dsl.c.a(2)).intValue());
                textView.setDuplicateParentStateEnabled(true);
                int intValue9 = ((Number) com.tencent.qqnt.chathistory.util.m.c(12)).intValue();
                ViewGroup.LayoutParams layoutParams22 = textView.getLayoutParams();
                if (!(layoutParams22 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams22 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams22;
                if (marginLayoutParams5 != null) {
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams5, intValue9);
                    layoutParams5 = marginLayoutParams5;
                } else {
                    ViewGroup.LayoutParams layoutParams23 = textView.getLayoutParams();
                    if (layoutParams23 != null) {
                        i29 = layoutParams23.width;
                    } else {
                        i29 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams24 = textView.getLayoutParams();
                    if (layoutParams24 != null) {
                        i36 = layoutParams24.height;
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
                        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance5, intValue9);
                        layoutParams5 = (ViewGroup.LayoutParams) newInstance5;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                textView.setLayoutParams(layoutParams5);
                textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_primary, null));
                g(textView);
                relativeLayout.addView(textView);
                TextView textView2 = new TextView(relativeLayout.getContext());
                Object invoke3 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
                if (invoke3 != null) {
                    textView2.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                    int p19 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView2.getLayoutParams() == null) {
                        textView2.setLayoutParams(new ViewGroup.LayoutParams(p19, 0));
                    } else {
                        textView2.getLayoutParams().width = p19;
                    }
                    textView2.setId(R.id.bdn);
                    int p26 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView2.getLayoutParams() == null) {
                        textView2.setLayoutParams(new ViewGroup.LayoutParams(0, p26));
                    } else {
                        textView2.getLayoutParams().height = p26;
                    }
                    textView2.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(14)).floatValue());
                    textView2.setEllipsize(TextUtils.TruncateAt.END);
                    com.tencent.aio.view_dsl.dsl.f.m(textView2, R.id.f164642ae0);
                    textView2.setSingleLine(true);
                    com.tencent.aio.view_dsl.dsl.f.s(textView2, R.id.j4e);
                    int intValue10 = ((Number) com.tencent.qqnt.chathistory.util.m.c(4)).intValue();
                    ViewGroup.LayoutParams layoutParams25 = textView2.getLayoutParams();
                    if (!(layoutParams25 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams25 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams25;
                    if (marginLayoutParams6 != null) {
                        marginLayoutParams6.topMargin = intValue10;
                        layoutParams6 = marginLayoutParams6;
                    } else {
                        ViewGroup.LayoutParams layoutParams26 = textView2.getLayoutParams();
                        if (layoutParams26 != null) {
                            i37 = layoutParams26.width;
                        } else {
                            i37 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams27 = textView2.getLayoutParams();
                        if (layoutParams27 != null) {
                            i38 = layoutParams27.height;
                        } else {
                            i38 = 0;
                        }
                        Object[] objArr6 = {new ViewGroup.LayoutParams(i37, i38)};
                        ArrayList arrayList6 = new ArrayList(1);
                        arrayList6.add(objArr6[0].getClass());
                        Object[] array6 = arrayList6.toArray(new Class[0]);
                        if (array6 != null) {
                            Class[] clsArr6 = (Class[]) array6;
                            Constructor it9 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr6, clsArr6.length));
                            Intrinsics.checkNotNullExpressionValue(it9, "it");
                            it9.setAccessible(true);
                            Object newInstance6 = it9.newInstance(Arrays.copyOf(objArr6, 1));
                            ((ViewGroup.MarginLayoutParams) newInstance6).topMargin = intValue10;
                            layoutParams6 = (ViewGroup.LayoutParams) newInstance6;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    textView2.setLayoutParams(layoutParams6);
                    textView2.setDuplicateParentStateEnabled(true);
                    textView2.setTextColor(textView2.getResources().getColorStateList(R.color.qui_common_text_secondary, null));
                    h(textView2);
                    relativeLayout.addView(textView2);
                    TextView textView3 = new TextView(relativeLayout.getContext());
                    Object invoke4 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
                    if (invoke4 != null) {
                        textView3.setLayoutParams((ViewGroup.LayoutParams) invoke4);
                        int p27 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (textView3.getLayoutParams() == null) {
                            textView3.setLayoutParams(new ViewGroup.LayoutParams(0, p27));
                        } else {
                            textView3.getLayoutParams().height = p27;
                        }
                        int intValue11 = ((Number) com.tencent.qqnt.chathistory.util.m.c(4)).intValue();
                        ViewGroup.LayoutParams layoutParams28 = textView3.getLayoutParams();
                        if (!(layoutParams28 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams28 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams28;
                        if (marginLayoutParams7 != null) {
                            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams7, intValue11);
                            layoutParams7 = marginLayoutParams7;
                        } else {
                            ViewGroup.LayoutParams layoutParams29 = textView3.getLayoutParams();
                            if (layoutParams29 != null) {
                                i39 = layoutParams29.width;
                            } else {
                                i39 = 0;
                            }
                            ViewGroup.LayoutParams layoutParams30 = textView3.getLayoutParams();
                            if (layoutParams30 != null) {
                                i46 = layoutParams30.height;
                            } else {
                                i46 = 0;
                            }
                            Object[] objArr7 = {new ViewGroup.LayoutParams(i39, i46)};
                            ArrayList arrayList7 = new ArrayList(1);
                            arrayList7.add(objArr7[0].getClass());
                            Object[] array7 = arrayList7.toArray(new Class[0]);
                            if (array7 != null) {
                                Class[] clsArr7 = (Class[]) array7;
                                Constructor it10 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr7, clsArr7.length));
                                Intrinsics.checkNotNullExpressionValue(it10, "it");
                                it10.setAccessible(true);
                                Object newInstance7 = it10.newInstance(Arrays.copyOf(objArr7, 1));
                                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance7, intValue11);
                                layoutParams7 = (ViewGroup.LayoutParams) newInstance7;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        textView3.setLayoutParams(layoutParams7);
                        textView3.setText(R.string.zk5);
                        textView3.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(14)).floatValue());
                        com.tencent.aio.view_dsl.dsl.f.m(textView3, R.id.f164642ae0);
                        textView3.setSingleLine(true);
                        textView3.setTextColor(textView3.getResources().getColorStateList(R.color.qui_common_text_secondary, null));
                        int p28 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (textView3.getLayoutParams() == null) {
                            textView3.setLayoutParams(new ViewGroup.LayoutParams(p28, 0));
                        } else {
                            textView3.getLayoutParams().width = p28;
                        }
                        textView3.setId(R.id.f1053265p);
                        textView3.setEllipsize(TextUtils.TruncateAt.END);
                        com.tencent.aio.view_dsl.dsl.f.s(textView3, R.id.bdn);
                        int intValue12 = ((Number) com.tencent.qqnt.chathistory.util.m.c(4)).intValue();
                        ViewGroup.LayoutParams layoutParams31 = textView3.getLayoutParams();
                        if (!(layoutParams31 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams31 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams8 = (ViewGroup.MarginLayoutParams) layoutParams31;
                        if (marginLayoutParams8 != null) {
                            marginLayoutParams8.topMargin = intValue12;
                            layoutParams8 = marginLayoutParams8;
                        } else {
                            ViewGroup.LayoutParams layoutParams32 = textView3.getLayoutParams();
                            if (layoutParams32 != null) {
                                i47 = layoutParams32.width;
                            } else {
                                i47 = 0;
                            }
                            ViewGroup.LayoutParams layoutParams33 = textView3.getLayoutParams();
                            if (layoutParams33 != null) {
                                i48 = layoutParams33.height;
                            } else {
                                i48 = 0;
                            }
                            Object[] objArr8 = {new ViewGroup.LayoutParams(i47, i48)};
                            ArrayList arrayList8 = new ArrayList(1);
                            arrayList8.add(objArr8[0].getClass());
                            Object[] array8 = arrayList8.toArray(new Class[0]);
                            if (array8 != null) {
                                Class[] clsArr8 = (Class[]) array8;
                                Constructor it11 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr8, clsArr8.length));
                                Intrinsics.checkNotNullExpressionValue(it11, "it");
                                it11.setAccessible(true);
                                Object newInstance8 = it11.newInstance(Arrays.copyOf(objArr8, 1));
                                ((ViewGroup.MarginLayoutParams) newInstance8).topMargin = intValue12;
                                layoutParams8 = (ViewGroup.LayoutParams) newInstance8;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        textView3.setLayoutParams(layoutParams8);
                        textView3.setDuplicateParentStateEnabled(true);
                        n(textView3);
                        relativeLayout.addView(textView3);
                        TextView textView4 = new TextView(relativeLayout.getContext());
                        Object invoke5 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
                        if (invoke5 != null) {
                            textView4.setLayoutParams((ViewGroup.LayoutParams) invoke5);
                            int p29 = com.tencent.aio.view_dsl.dsl.b.p();
                            if (textView4.getLayoutParams() == null) {
                                textView4.setLayoutParams(new ViewGroup.LayoutParams(p29, 0));
                            } else {
                                textView4.getLayoutParams().width = p29;
                            }
                            textView4.setId(R.id.f2a);
                            int p36 = com.tencent.aio.view_dsl.dsl.b.p();
                            if (textView4.getLayoutParams() == null) {
                                textView4.setLayoutParams(new ViewGroup.LayoutParams(0, p36));
                            } else {
                                textView4.getLayoutParams().height = p36;
                            }
                            textView4.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(14)).floatValue());
                            textView4.setEllipsize(TextUtils.TruncateAt.END);
                            com.tencent.aio.view_dsl.dsl.f.m(textView4, R.id.f164642ae0);
                            textView4.setSingleLine(true);
                            com.tencent.aio.view_dsl.dsl.f.s(textView4, R.id.f1053265p);
                            int intValue13 = ((Number) com.tencent.qqnt.chathistory.util.m.c(4)).intValue();
                            ViewGroup.LayoutParams layoutParams34 = textView4.getLayoutParams();
                            if (!(layoutParams34 instanceof ViewGroup.MarginLayoutParams)) {
                                layoutParams34 = null;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams9 = (ViewGroup.MarginLayoutParams) layoutParams34;
                            if (marginLayoutParams9 != null) {
                                marginLayoutParams9.topMargin = intValue13;
                                layoutParams9 = marginLayoutParams9;
                            } else {
                                ViewGroup.LayoutParams layoutParams35 = textView4.getLayoutParams();
                                if (layoutParams35 != null) {
                                    i49 = layoutParams35.width;
                                } else {
                                    i49 = 0;
                                }
                                ViewGroup.LayoutParams layoutParams36 = textView4.getLayoutParams();
                                if (layoutParams36 != null) {
                                    i56 = layoutParams36.height;
                                } else {
                                    i56 = 0;
                                }
                                Object[] objArr9 = {new ViewGroup.LayoutParams(i49, i56)};
                                ArrayList arrayList9 = new ArrayList(1);
                                arrayList9.add(objArr9[0].getClass());
                                Object[] array9 = arrayList9.toArray(new Class[0]);
                                if (array9 != null) {
                                    Class[] clsArr9 = (Class[]) array9;
                                    Constructor it12 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr9, clsArr9.length));
                                    Intrinsics.checkNotNullExpressionValue(it12, "it");
                                    it12.setAccessible(true);
                                    Object newInstance9 = it12.newInstance(Arrays.copyOf(objArr9, 1));
                                    ((ViewGroup.MarginLayoutParams) newInstance9).topMargin = intValue13;
                                    layoutParams9 = (ViewGroup.LayoutParams) newInstance9;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                            textView4.setLayoutParams(layoutParams9);
                            textView4.setDuplicateParentStateEnabled(true);
                            textView4.setTextColor(textView4.getResources().getColorStateList(R.color.qui_common_text_secondary, null));
                            i(textView4);
                            relativeLayout.addView(textView4);
                            j(relativeLayout);
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

    public final void g(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.brief = textView;
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return f();
    }

    public final void h(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.dateText = textView;
        }
    }

    public final void i(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.msgfrom = textView;
        }
    }

    public final void j(@NotNull RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) relativeLayout);
        } else {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.recentStructItem = relativeLayout;
        }
    }

    public final void k(@NotNull RoundImageView roundImageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) roundImageView);
        } else {
            Intrinsics.checkNotNullParameter(roundImageView, "<set-?>");
            this.structIcon = roundImageView;
        }
    }

    public final void l(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.structIconFrame = frameLayout;
        }
    }

    public final void m(@NotNull QUICheckBox qUICheckBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qUICheckBox);
        } else {
            Intrinsics.checkNotNullParameter(qUICheckBox, "<set-?>");
            this.structSelected = qUICheckBox;
        }
    }

    public final void n(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvFromLabel = textView;
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

    public /* synthetic */ e(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
