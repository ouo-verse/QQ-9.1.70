package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.os.Trace;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001dR\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010=\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b6\u00109\u001a\u0004\b:\u0010;\"\u0004\b2\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/f;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "attach", "Landroid/widget/RelativeLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/view/View;)V", "_root", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getShortVideoTitle", "()Landroid/widget/TextView;", "l", "(Landroid/widget/TextView;)V", "shortVideoTitle", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "d", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "getShortVideoAuthorAvatar", "()Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "i", "(Lcom/tencent/qqnt/base/widget/RoundRectImageView;)V", "shortVideoAuthorAvatar", "getShortVideoAuthorName", "j", "shortVideoAuthorName", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "getShortVideoItemDetail", "()Landroid/widget/LinearLayout;", "k", "(Landroid/widget/LinearLayout;)V", "shortVideoItemDetail", "Landroid/widget/ImageView;", "g", "Landroid/widget/ImageView;", "getSearchShortVideoItemCover", "()Landroid/widget/ImageView;", tl.h.F, "(Landroid/widget/ImageView;)V", "searchShortVideoItemCover", "Landroid/widget/RelativeLayout;", "getSearchShortVideoItem", "()Landroid/widget/RelativeLayout;", "(Landroid/widget/RelativeLayout;)V", "searchShortVideoItem", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;Landroid/view/ViewGroup;Z)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public TextView shortVideoTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public RoundRectImageView shortVideoAuthorAvatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView shortVideoAuthorName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public LinearLayout shortVideoItemDetail;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public ImageView searchShortVideoItemCover;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout searchShortVideoItem;

    public f(@NotNull Context context, @Nullable Integer num, @Nullable ViewGroup viewGroup, boolean z16) {
        RelativeLayout e16;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, num, viewGroup, Boolean.valueOf(z16));
            return;
        }
        this.context = context;
        if (num != null) {
            e16 = e(new ContextThemeWrapper(context, num.intValue()), viewGroup, z16);
        } else {
            e16 = e(context, viewGroup, z16);
        }
        m(e16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v11, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, java.lang.Object, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.widget.RelativeLayout, android.view.View, java.lang.Object, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r7v13, types: [android.widget.LinearLayout, android.view.View, java.lang.Object, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r9v28, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r9v40, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r9v52, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r9v56, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r9v76, types: [java.lang.reflect.Method] */
    @NotNull
    public final RelativeLayout e(@NotNull Context context, @Nullable ViewGroup parent, boolean attach) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        ViewGroup.MarginLayoutParams marginLayoutParams4;
        ViewGroup.LayoutParams layoutParams;
        int i3;
        ViewGroup.LayoutParams layoutParams2;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 19, this, context, parent, Boolean.valueOf(attach));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ?? frameLayout = parent == null ? new FrameLayout(context) : parent;
        Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
        ?? relativeLayout = new RelativeLayout(frameLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(frameLayout, new Object[0]);
        if (invoke != null) {
            relativeLayout.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l3 = com.tencent.aio.view_dsl.dsl.b.l();
            if (relativeLayout.getLayoutParams() == null) {
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
            } else {
                relativeLayout.getLayoutParams().width = l3;
            }
            relativeLayout.setBackground(AppCompatResources.getDrawable(relativeLayout.getContext(), R.drawable.qui_common_fill_light_secondary_bg_corner_8));
            relativeLayout.setId(R.id.f81184dh);
            int intValue = ((Number) com.tencent.aio.view_dsl.dsl.c.e(284)).intValue();
            if (relativeLayout.getLayoutParams() == null) {
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, intValue));
            } else {
                relativeLayout.getLayoutParams().height = intValue;
            }
            ?? linearLayout = new LinearLayout(relativeLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
            if (invoke2 != null) {
                linearLayout.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int l16 = com.tencent.aio.view_dsl.dsl.b.l();
                if (linearLayout.getLayoutParams() == null) {
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(l16, 0));
                } else {
                    linearLayout.getLayoutParams().width = l16;
                }
                linearLayout.setId(R.id.f84744n3);
                int p16 = com.tencent.aio.view_dsl.dsl.b.p();
                if (linearLayout.getLayoutParams() == null) {
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
                } else {
                    linearLayout.getLayoutParams().height = p16;
                }
                int intValue2 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(8)).intValue();
                ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
                if (!(layoutParams3 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams3 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams3;
                if (marginLayoutParams5 != null) {
                    MarginLayoutParamsCompat.setMarginStart(marginLayoutParams5, intValue2);
                    marginLayoutParams = marginLayoutParams5;
                } else {
                    ViewGroup.LayoutParams layoutParams4 = linearLayout.getLayoutParams();
                    int i17 = layoutParams4 != null ? layoutParams4.width : 0;
                    ViewGroup.LayoutParams layoutParams5 = linearLayout.getLayoutParams();
                    Object[] objArr = {new ViewGroup.LayoutParams(i17, layoutParams5 != null ? layoutParams5.height : 0)};
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(objArr[0].getClass());
                    Object[] array = arrayList.toArray(new Class[0]);
                    if (array != null) {
                        Class[] clsArr = (Class[]) array;
                        Constructor it = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        it.setAccessible(true);
                        Object newInstance = it.newInstance(Arrays.copyOf(objArr, 1));
                        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance, intValue2);
                        marginLayoutParams = (ViewGroup.LayoutParams) newInstance;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                linearLayout.setLayoutParams(marginLayoutParams);
                int intValue3 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(8)).intValue();
                ViewGroup.LayoutParams layoutParams6 = linearLayout.getLayoutParams();
                if (!(layoutParams6 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams6 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams6;
                if (marginLayoutParams6 != null) {
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams6, intValue3);
                    marginLayoutParams2 = marginLayoutParams6;
                } else {
                    ViewGroup.LayoutParams layoutParams7 = linearLayout.getLayoutParams();
                    int i18 = layoutParams7 != null ? layoutParams7.width : 0;
                    ViewGroup.LayoutParams layoutParams8 = linearLayout.getLayoutParams();
                    Object[] objArr2 = {new ViewGroup.LayoutParams(i18, layoutParams8 != null ? layoutParams8.height : 0)};
                    ArrayList arrayList2 = new ArrayList(1);
                    arrayList2.add(objArr2[0].getClass());
                    Object[] array2 = arrayList2.toArray(new Class[0]);
                    if (array2 != null) {
                        Class[] clsArr2 = (Class[]) array2;
                        Constructor it5 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                        Intrinsics.checkNotNullExpressionValue(it5, "it");
                        it5.setAccessible(true);
                        Object newInstance2 = it5.newInstance(Arrays.copyOf(objArr2, 1));
                        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance2, intValue3);
                        marginLayoutParams2 = (ViewGroup.LayoutParams) newInstance2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                linearLayout.setLayoutParams(marginLayoutParams2);
                int intValue4 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(8)).intValue();
                ViewGroup.LayoutParams layoutParams9 = linearLayout.getLayoutParams();
                if (!(layoutParams9 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams9 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams9;
                if (marginLayoutParams7 != null) {
                    marginLayoutParams7.topMargin = intValue4;
                    marginLayoutParams3 = marginLayoutParams7;
                } else {
                    ViewGroup.LayoutParams layoutParams10 = linearLayout.getLayoutParams();
                    int i19 = layoutParams10 != null ? layoutParams10.width : 0;
                    ViewGroup.LayoutParams layoutParams11 = linearLayout.getLayoutParams();
                    Object[] objArr3 = {new ViewGroup.LayoutParams(i19, layoutParams11 != null ? layoutParams11.height : 0)};
                    ArrayList arrayList3 = new ArrayList(1);
                    arrayList3.add(objArr3[0].getClass());
                    Object[] array3 = arrayList3.toArray(new Class[0]);
                    if (array3 != null) {
                        Class[] clsArr3 = (Class[]) array3;
                        Constructor it6 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr3, clsArr3.length));
                        Intrinsics.checkNotNullExpressionValue(it6, "it");
                        it6.setAccessible(true);
                        Object newInstance3 = it6.newInstance(Arrays.copyOf(objArr3, 1));
                        ((ViewGroup.MarginLayoutParams) newInstance3).topMargin = intValue4;
                        marginLayoutParams3 = (ViewGroup.LayoutParams) newInstance3;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                linearLayout.setLayoutParams(marginLayoutParams3);
                com.tencent.aio.view_dsl.dsl.f.c(linearLayout, true);
                int intValue5 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(8)).intValue();
                ViewGroup.LayoutParams layoutParams12 = linearLayout.getLayoutParams();
                if (!(layoutParams12 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams12 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams8 = (ViewGroup.MarginLayoutParams) layoutParams12;
                if (marginLayoutParams8 != null) {
                    marginLayoutParams8.bottomMargin = intValue5;
                    marginLayoutParams4 = marginLayoutParams8;
                } else {
                    ViewGroup.LayoutParams layoutParams13 = linearLayout.getLayoutParams();
                    int i26 = layoutParams13 != null ? layoutParams13.width : 0;
                    ViewGroup.LayoutParams layoutParams14 = linearLayout.getLayoutParams();
                    Object[] objArr4 = {new ViewGroup.LayoutParams(i26, layoutParams14 != null ? layoutParams14.height : 0)};
                    ArrayList arrayList4 = new ArrayList(1);
                    arrayList4.add(objArr4[0].getClass());
                    Object[] array4 = arrayList4.toArray(new Class[0]);
                    if (array4 != null) {
                        Class[] clsArr4 = (Class[]) array4;
                        Constructor it7 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr4, clsArr4.length));
                        Intrinsics.checkNotNullExpressionValue(it7, "it");
                        it7.setAccessible(true);
                        Object newInstance4 = it7.newInstance(Arrays.copyOf(objArr4, 1));
                        ((ViewGroup.MarginLayoutParams) newInstance4).bottomMargin = intValue5;
                        marginLayoutParams4 = (ViewGroup.LayoutParams) newInstance4;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                linearLayout.setLayoutParams(marginLayoutParams4);
                linearLayout.setOrientation(1);
                TextView textView = new TextView(linearLayout.getContext());
                Object invoke3 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                if (invoke3 != null) {
                    textView.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                    int l17 = com.tencent.aio.view_dsl.dsl.b.l();
                    if (textView.getLayoutParams() == null) {
                        textView.setLayoutParams(new ViewGroup.LayoutParams(l17, 0));
                    } else {
                        textView.getLayoutParams().width = l17;
                    }
                    textView.setId(R.id.f84764n5);
                    textView.setTypeface(textView.getTypeface(), com.tencent.aio.view_dsl.dsl.b.a());
                    int p17 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView.getLayoutParams() == null) {
                        textView.setLayoutParams(new ViewGroup.LayoutParams(0, p17));
                    } else {
                        textView.getLayoutParams().height = p17;
                    }
                    textView.setTextSize(0, ((Number) com.tencent.aio.view_dsl.dsl.c.g(13)).floatValue());
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setSingleLine(true);
                    int intValue6 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(8)).intValue();
                    ViewGroup.LayoutParams layoutParams15 = textView.getLayoutParams();
                    if (!(layoutParams15 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams15 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams9 = (ViewGroup.MarginLayoutParams) layoutParams15;
                    if (marginLayoutParams9 != null) {
                        marginLayoutParams9.bottomMargin = intValue6;
                        layoutParams = marginLayoutParams9;
                    } else {
                        ViewGroup.LayoutParams layoutParams16 = textView.getLayoutParams();
                        int i27 = layoutParams16 != null ? layoutParams16.width : 0;
                        ViewGroup.LayoutParams layoutParams17 = textView.getLayoutParams();
                        Object[] objArr5 = {new ViewGroup.LayoutParams(i27, layoutParams17 != null ? layoutParams17.height : 0)};
                        ArrayList arrayList5 = new ArrayList(1);
                        arrayList5.add(objArr5[0].getClass());
                        Object[] array5 = arrayList5.toArray(new Class[0]);
                        if (array5 != null) {
                            Class[] clsArr5 = (Class[]) array5;
                            Constructor it8 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr5, clsArr5.length));
                            Intrinsics.checkNotNullExpressionValue(it8, "it");
                            it8.setAccessible(true);
                            Object newInstance5 = it8.newInstance(Arrays.copyOf(objArr5, 1));
                            ((ViewGroup.MarginLayoutParams) newInstance5).bottomMargin = intValue6;
                            layoutParams = (ViewGroup.LayoutParams) newInstance5;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    textView.setLayoutParams(layoutParams);
                    textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_primary));
                    l(textView);
                    linearLayout.addView(textView);
                    LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
                    Object invoke4 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                    if (invoke4 != null) {
                        linearLayout2.setLayoutParams((ViewGroup.LayoutParams) invoke4);
                        int p18 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (linearLayout2.getLayoutParams() == null) {
                            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(p18, 0));
                        } else {
                            linearLayout2.getLayoutParams().width = p18;
                        }
                        int p19 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (linearLayout2.getLayoutParams() == null) {
                            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(0, p19));
                        } else {
                            linearLayout2.getLayoutParams().height = p19;
                        }
                        linearLayout2.setGravity(com.tencent.aio.view_dsl.dsl.b.e());
                        linearLayout2.setOrientation(0);
                        com.tencent.aio.view_dsl.dsl.f.e(linearLayout2, true);
                        RoundRectImageView roundRectImageView = new RoundRectImageView(linearLayout2.getContext(), null, 0, 6, null);
                        linearLayout2.addView(roundRectImageView);
                        int intValue7 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(18)).intValue();
                        if (roundRectImageView.getLayoutParams() == null) {
                            roundRectImageView.setLayoutParams(new ViewGroup.LayoutParams(intValue7, 0));
                        } else {
                            roundRectImageView.getLayoutParams().width = intValue7;
                        }
                        roundRectImageView.setId(R.id.f84724n1);
                        int intValue8 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(18)).intValue();
                        if (roundRectImageView.getLayoutParams() == null) {
                            roundRectImageView.setLayoutParams(new ViewGroup.LayoutParams(0, intValue8));
                        } else {
                            roundRectImageView.getLayoutParams().height = intValue8;
                        }
                        roundRectImageView.setImageDrawable(AppCompatResources.getDrawable(roundRectImageView.getContext(), R.drawable.ofg));
                        int intValue9 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(2)).intValue();
                        ViewGroup.LayoutParams layoutParams18 = roundRectImageView.getLayoutParams();
                        if (!(layoutParams18 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams18 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams10 = (ViewGroup.MarginLayoutParams) layoutParams18;
                        if (marginLayoutParams10 != null) {
                            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams10, intValue9);
                            i3 = 1;
                            layoutParams2 = marginLayoutParams10;
                        } else {
                            ViewGroup.LayoutParams layoutParams19 = roundRectImageView.getLayoutParams();
                            int i28 = layoutParams19 != null ? layoutParams19.width : 0;
                            ViewGroup.LayoutParams layoutParams20 = roundRectImageView.getLayoutParams();
                            Object[] objArr6 = {new ViewGroup.LayoutParams(i28, layoutParams20 != null ? layoutParams20.height : 0)};
                            ArrayList arrayList6 = new ArrayList(1);
                            arrayList6.add(objArr6[0].getClass());
                            Object[] array6 = arrayList6.toArray(new Class[0]);
                            if (array6 != null) {
                                Class[] clsArr6 = (Class[]) array6;
                                Constructor it9 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr6, clsArr6.length));
                                Intrinsics.checkNotNullExpressionValue(it9, "it");
                                i3 = 1;
                                it9.setAccessible(true);
                                Object newInstance6 = it9.newInstance(Arrays.copyOf(objArr6, 1));
                                MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance6, intValue9);
                                layoutParams2 = (ViewGroup.LayoutParams) newInstance6;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        roundRectImageView.setLayoutParams(layoutParams2);
                        i(roundRectImageView);
                        roundRectImageView.setCornerRadiusAndMode(ViewUtils.dip2px(20.0f), i3);
                        TextView textView2 = new TextView(linearLayout2.getContext());
                        Object invoke5 = LayoutBuilderKt.b().invoke(linearLayout2, new Object[0]);
                        if (invoke5 != null) {
                            textView2.setLayoutParams((ViewGroup.LayoutParams) invoke5);
                            int p26 = com.tencent.aio.view_dsl.dsl.b.p();
                            if (textView2.getLayoutParams() == null) {
                                textView2.setLayoutParams(new ViewGroup.LayoutParams(p26, 0));
                            } else {
                                textView2.getLayoutParams().width = p26;
                            }
                            textView2.setId(R.id.f84734n2);
                            int p27 = com.tencent.aio.view_dsl.dsl.b.p();
                            if (textView2.getLayoutParams() == null) {
                                i16 = 0;
                                textView2.setLayoutParams(new ViewGroup.LayoutParams(0, p27));
                            } else {
                                i16 = 0;
                                textView2.getLayoutParams().height = p27;
                            }
                            textView2.setTextSize(i16, ((Number) com.tencent.aio.view_dsl.dsl.c.g(11)).floatValue());
                            textView2.setEllipsize(TextUtils.TruncateAt.END);
                            textView2.setSingleLine(true);
                            textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), R.color.qui_common_text_primary));
                            j(textView2);
                            linearLayout2.addView(textView2);
                            linearLayout.addView(linearLayout2);
                            k(linearLayout);
                            relativeLayout.addView(linearLayout);
                            Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
                            ImageView imageView = new ImageView(relativeLayout.getContext());
                            Object invoke6 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
                            if (invoke6 != null) {
                                imageView.setLayoutParams((ViewGroup.LayoutParams) invoke6);
                                int l18 = com.tencent.aio.view_dsl.dsl.b.l();
                                if (imageView.getLayoutParams() == null) {
                                    imageView.setLayoutParams(new ViewGroup.LayoutParams(l18, 0));
                                } else {
                                    imageView.getLayoutParams().width = l18;
                                }
                                com.tencent.aio.view_dsl.dsl.f.a(imageView, R.id.f84744n3);
                                imageView.setId(R.id.f81194di);
                                int l19 = com.tencent.aio.view_dsl.dsl.b.l();
                                if (imageView.getLayoutParams() == null) {
                                    imageView.setLayoutParams(new ViewGroup.LayoutParams(0, l19));
                                } else {
                                    imageView.getLayoutParams().height = l19;
                                }
                                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                h(imageView);
                                relativeLayout.addView(imageView);
                                Trace.endSection();
                                g(relativeLayout);
                                if (attach) {
                                    frameLayout.addView(relativeLayout);
                                }
                                Trace.endSection();
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

    public final void g(@NotNull RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) relativeLayout);
        } else {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.searchShortVideoItem = relativeLayout;
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (View) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return f();
    }

    public final void h(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.searchShortVideoItemCover = imageView;
        }
    }

    public final void i(@NotNull RoundRectImageView roundRectImageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) roundRectImageView);
        } else {
            Intrinsics.checkNotNullParameter(roundRectImageView, "<set-?>");
            this.shortVideoAuthorAvatar = roundRectImageView;
        }
    }

    public final void j(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.shortVideoAuthorName = textView;
        }
    }

    public final void k(@NotNull LinearLayout linearLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) linearLayout);
        } else {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.shortVideoItemDetail = linearLayout;
        }
    }

    public final void l(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.shortVideoTitle = textView;
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

    public /* synthetic */ f(Context context, Integer num, ViewGroup viewGroup, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num, (i3 & 4) == 0 ? viewGroup : null, (i3 & 8) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, viewGroup, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
