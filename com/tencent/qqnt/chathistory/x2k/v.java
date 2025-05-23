package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.graphics.Color;
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
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.qqnt.view.SquImageView;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00100\u001a\u00020'8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/v;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "attach", "Landroid/widget/RelativeLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", "k", "(Landroid/view/View;)V", "_root", "Lcom/tencent/qqnt/view/SquImageView;", "c", "Lcom/tencent/qqnt/view/SquImageView;", "getIvThumb", "()Lcom/tencent/qqnt/view/SquImageView;", tl.h.F, "(Lcom/tencent/qqnt/view/SquImageView;)V", "ivThumb", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "d", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "getPhotoSelectItemSelectedIconIv", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "i", "(Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;)V", "photoSelectItemSelectedIconIv", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getVideoLengthTv", "()Landroid/widget/TextView;", "j", "(Landroid/widget/TextView;)V", "videoLengthTv", "getFilename", "g", "filename", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;Landroid/view/ViewGroup;Z)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class v implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public SquImageView ivThumb;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public QUICheckBox photoSelectItemSelectedIconIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView videoLengthTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView filename;

    public v(@NotNull Context context, @Nullable Integer num, @Nullable ViewGroup viewGroup, boolean z16) {
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
        k(e16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v25, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r12v17, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r13v20, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, java.lang.Object, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r4v38, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.widget.RelativeLayout, android.view.View, java.lang.Object, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.reflect.Method] */
    @NotNull
    public final RelativeLayout e(@NotNull Context context, @Nullable ViewGroup parent, boolean attach) {
        String str;
        int i3;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        ViewGroup.LayoutParams layoutParams4;
        ViewGroup.LayoutParams layoutParams5;
        ViewGroup.LayoutParams layoutParams6;
        ViewGroup.LayoutParams layoutParams7;
        ViewGroup.LayoutParams layoutParams8;
        ViewGroup.LayoutParams layoutParams9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 15, this, context, parent, Boolean.valueOf(attach));
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
            int p16 = com.tencent.aio.view_dsl.dsl.b.p();
            if (relativeLayout.getLayoutParams() == null) {
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
            } else {
                relativeLayout.getLayoutParams().height = p16;
            }
            int intValue = ((Number) com.tencent.qqnt.chathistory.util.m.c(1)).intValue();
            relativeLayout.setPadding(intValue, intValue, intValue, intValue);
            relativeLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
            SquImageView squImageView = new SquImageView(relativeLayout.getContext());
            relativeLayout.addView(squImageView);
            int l16 = com.tencent.aio.view_dsl.dsl.b.l();
            if (squImageView.getLayoutParams() == null) {
                squImageView.setLayoutParams(new ViewGroup.LayoutParams(l16, 0));
            } else {
                squImageView.getLayoutParams().width = l16;
            }
            squImageView.setId(R.id.y9u);
            int l17 = com.tencent.aio.view_dsl.dsl.b.l();
            if (squImageView.getLayoutParams() == null) {
                squImageView.setLayoutParams(new ViewGroup.LayoutParams(0, l17));
            } else {
                squImageView.getLayoutParams().height = l17;
            }
            squImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            h(squImageView);
            QUICheckBox qUICheckBox = new QUICheckBox(relativeLayout.getContext());
            relativeLayout.addView(qUICheckBox);
            qUICheckBox.setType(3);
            qUICheckBox.setId(R.id.fqa);
            int intValue2 = ((Number) com.tencent.qqnt.chathistory.util.m.c(24)).intValue();
            if (qUICheckBox.getLayoutParams() == null) {
                qUICheckBox.setLayoutParams(new ViewGroup.LayoutParams(intValue2, 0));
            } else {
                qUICheckBox.getLayoutParams().width = intValue2;
            }
            int intValue3 = ((Number) com.tencent.qqnt.chathistory.util.m.c(24)).intValue();
            if (qUICheckBox.getLayoutParams() == null) {
                qUICheckBox.setLayoutParams(new ViewGroup.LayoutParams(0, intValue3));
            } else {
                qUICheckBox.getLayoutParams().height = intValue3;
            }
            int intValue4 = ((Number) com.tencent.qqnt.chathistory.util.m.c(4)).intValue();
            qUICheckBox.setPadding(intValue4, intValue4, intValue4, intValue4);
            com.tencent.aio.view_dsl.dsl.f.f(qUICheckBox, true);
            qUICheckBox.setVisibility(8);
            com.tencent.aio.view_dsl.dsl.f.h(qUICheckBox, true);
            i(qUICheckBox);
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
                linearLayout.setBackground(AppCompatResources.getDrawable(linearLayout.getContext(), R.drawable.f160443jg3));
                int p18 = com.tencent.aio.view_dsl.dsl.b.p();
                if (linearLayout.getLayoutParams() == null) {
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p18));
                } else {
                    linearLayout.getLayoutParams().height = p18;
                }
                com.tencent.aio.view_dsl.dsl.f.f(linearLayout, true);
                com.tencent.aio.view_dsl.dsl.f.c(linearLayout, true);
                int intValue5 = ((Number) com.tencent.qqnt.chathistory.util.m.c(4)).intValue();
                ViewGroup.LayoutParams layoutParams10 = linearLayout.getLayoutParams();
                if (!(layoutParams10 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams10 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams10;
                if (marginLayoutParams3 != null) {
                    marginLayoutParams3.bottomMargin = intValue5;
                    str = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams";
                    marginLayoutParams = marginLayoutParams3;
                } else {
                    ViewGroup.LayoutParams layoutParams11 = linearLayout.getLayoutParams();
                    int i16 = layoutParams11 != null ? layoutParams11.width : 0;
                    ViewGroup.LayoutParams layoutParams12 = linearLayout.getLayoutParams();
                    if (layoutParams12 != null) {
                        i3 = layoutParams12.height;
                        str = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams";
                    } else {
                        str = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams";
                        i3 = 0;
                    }
                    Object[] objArr = {new ViewGroup.LayoutParams(i16, i3)};
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(objArr[0].getClass());
                    Object[] array = arrayList.toArray(new Class[0]);
                    if (array != null) {
                        Class[] clsArr = (Class[]) array;
                        Constructor it = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        it.setAccessible(true);
                        Object newInstance = it.newInstance(Arrays.copyOf(objArr, 1));
                        ((ViewGroup.MarginLayoutParams) newInstance).bottomMargin = intValue5;
                        marginLayoutParams = (ViewGroup.LayoutParams) newInstance;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                linearLayout.setLayoutParams(marginLayoutParams);
                linearLayout.setOrientation(0);
                int intValue6 = ((Number) com.tencent.qqnt.chathistory.util.m.c(4)).intValue();
                ViewGroup.LayoutParams layoutParams13 = linearLayout.getLayoutParams();
                if (!(layoutParams13 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams13 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams13;
                if (marginLayoutParams4 != null) {
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams4, intValue6);
                    marginLayoutParams2 = marginLayoutParams4;
                } else {
                    ViewGroup.LayoutParams layoutParams14 = linearLayout.getLayoutParams();
                    int i17 = layoutParams14 != null ? layoutParams14.width : 0;
                    ViewGroup.LayoutParams layoutParams15 = linearLayout.getLayoutParams();
                    Object[] objArr2 = {new ViewGroup.LayoutParams(i17, layoutParams15 != null ? layoutParams15.height : 0)};
                    ArrayList arrayList2 = new ArrayList(1);
                    arrayList2.add(objArr2[0].getClass());
                    Object[] array2 = arrayList2.toArray(new Class[0]);
                    if (array2 != null) {
                        Class[] clsArr2 = (Class[]) array2;
                        Constructor it5 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                        Intrinsics.checkNotNullExpressionValue(it5, "it");
                        it5.setAccessible(true);
                        Object newInstance2 = it5.newInstance(Arrays.copyOf(objArr2, 1));
                        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance2, intValue6);
                        marginLayoutParams2 = (ViewGroup.LayoutParams) newInstance2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                linearLayout.setLayoutParams(marginLayoutParams2);
                Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
                ImageView imageView = new ImageView(linearLayout.getContext());
                Object invoke3 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                if (invoke3 != null) {
                    imageView.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                    int intValue7 = ((Number) com.tencent.qqnt.chathistory.util.m.c(8)).intValue();
                    if (imageView.getLayoutParams() == null) {
                        imageView.setLayoutParams(new ViewGroup.LayoutParams(intValue7, 0));
                    } else {
                        imageView.getLayoutParams().width = intValue7;
                    }
                    int intValue8 = ((Number) com.tencent.qqnt.chathistory.util.m.c(8)).intValue();
                    if (imageView.getLayoutParams() == null) {
                        imageView.setLayoutParams(new ViewGroup.LayoutParams(0, intValue8));
                    } else {
                        imageView.getLayoutParams().height = intValue8;
                    }
                    int intValue9 = ((Number) com.tencent.qqnt.chathistory.util.m.c(6)).intValue();
                    ViewGroup.LayoutParams layoutParams16 = imageView.getLayoutParams();
                    if (!(layoutParams16 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams16 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams16;
                    if (marginLayoutParams5 != null) {
                        MarginLayoutParamsCompat.setMarginStart(marginLayoutParams5, intValue9);
                        layoutParams = marginLayoutParams5;
                    } else {
                        ViewGroup.LayoutParams layoutParams17 = imageView.getLayoutParams();
                        int i18 = layoutParams17 != null ? layoutParams17.width : 0;
                        ViewGroup.LayoutParams layoutParams18 = imageView.getLayoutParams();
                        Object[] objArr3 = {new ViewGroup.LayoutParams(i18, layoutParams18 != null ? layoutParams18.height : 0)};
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(objArr3[0].getClass());
                        Object[] array3 = arrayList3.toArray(new Class[0]);
                        if (array3 != null) {
                            Class[] clsArr3 = (Class[]) array3;
                            Constructor it6 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr3, clsArr3.length));
                            Intrinsics.checkNotNullExpressionValue(it6, "it");
                            it6.setAccessible(true);
                            Object newInstance3 = it6.newInstance(Arrays.copyOf(objArr3, 1));
                            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance3, intValue9);
                            layoutParams = (ViewGroup.LayoutParams) newInstance3;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    imageView.setLayoutParams(layoutParams);
                    com.tencent.aio.view_dsl.dsl.f.p(imageView, com.tencent.aio.view_dsl.dsl.b.g());
                    int intValue10 = ((Number) com.tencent.qqnt.chathistory.util.m.c(3)).intValue();
                    ViewGroup.LayoutParams layoutParams19 = imageView.getLayoutParams();
                    if (!(layoutParams19 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams19 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams19;
                    if (marginLayoutParams6 != null) {
                        marginLayoutParams6.topMargin = intValue10;
                        layoutParams2 = marginLayoutParams6;
                    } else {
                        ViewGroup.LayoutParams layoutParams20 = imageView.getLayoutParams();
                        int i19 = layoutParams20 != null ? layoutParams20.width : 0;
                        ViewGroup.LayoutParams layoutParams21 = imageView.getLayoutParams();
                        Object[] objArr4 = {new ViewGroup.LayoutParams(i19, layoutParams21 != null ? layoutParams21.height : 0)};
                        ArrayList arrayList4 = new ArrayList(1);
                        arrayList4.add(objArr4[0].getClass());
                        Object[] array4 = arrayList4.toArray(new Class[0]);
                        if (array4 != null) {
                            Class[] clsArr4 = (Class[]) array4;
                            Constructor it7 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr4, clsArr4.length));
                            Intrinsics.checkNotNullExpressionValue(it7, "it");
                            it7.setAccessible(true);
                            Object newInstance4 = it7.newInstance(Arrays.copyOf(objArr4, 1));
                            ((ViewGroup.MarginLayoutParams) newInstance4).topMargin = intValue10;
                            layoutParams2 = (ViewGroup.LayoutParams) newInstance4;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    imageView.setLayoutParams(layoutParams2);
                    int intValue11 = ((Number) com.tencent.qqnt.chathistory.util.m.c(3)).intValue();
                    ViewGroup.LayoutParams layoutParams22 = imageView.getLayoutParams();
                    if (!(layoutParams22 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams22 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams22;
                    if (marginLayoutParams7 != null) {
                        marginLayoutParams7.bottomMargin = intValue11;
                        layoutParams3 = marginLayoutParams7;
                    } else {
                        ViewGroup.LayoutParams layoutParams23 = imageView.getLayoutParams();
                        int i26 = layoutParams23 != null ? layoutParams23.width : 0;
                        ViewGroup.LayoutParams layoutParams24 = imageView.getLayoutParams();
                        Object[] objArr5 = {new ViewGroup.LayoutParams(i26, layoutParams24 != null ? layoutParams24.height : 0)};
                        ArrayList arrayList5 = new ArrayList(1);
                        arrayList5.add(objArr5[0].getClass());
                        Object[] array5 = arrayList5.toArray(new Class[0]);
                        if (array5 != null) {
                            Class[] clsArr5 = (Class[]) array5;
                            Constructor it8 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr5, clsArr5.length));
                            Intrinsics.checkNotNullExpressionValue(it8, "it");
                            it8.setAccessible(true);
                            Object newInstance5 = it8.newInstance(Arrays.copyOf(objArr5, 1));
                            ((ViewGroup.MarginLayoutParams) newInstance5).bottomMargin = intValue11;
                            layoutParams3 = (ViewGroup.LayoutParams) newInstance5;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    imageView.setLayoutParams(layoutParams3);
                    imageView.setVisibility(0);
                    imageView.setImageDrawable(AppCompatResources.getDrawable(imageView.getContext(), R.drawable.mpr));
                    int intValue12 = ((Number) com.tencent.qqnt.chathistory.util.m.c(4)).intValue();
                    ViewGroup.LayoutParams layoutParams25 = imageView.getLayoutParams();
                    if (!(layoutParams25 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams25 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams8 = (ViewGroup.MarginLayoutParams) layoutParams25;
                    if (marginLayoutParams8 != null) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams8, intValue12);
                        layoutParams4 = marginLayoutParams8;
                    } else {
                        ViewGroup.LayoutParams layoutParams26 = imageView.getLayoutParams();
                        int i27 = layoutParams26 != null ? layoutParams26.width : 0;
                        ViewGroup.LayoutParams layoutParams27 = imageView.getLayoutParams();
                        Object[] objArr6 = {new ViewGroup.LayoutParams(i27, layoutParams27 != null ? layoutParams27.height : 0)};
                        ArrayList arrayList6 = new ArrayList(1);
                        arrayList6.add(objArr6[0].getClass());
                        Object[] array6 = arrayList6.toArray(new Class[0]);
                        if (array6 != null) {
                            Class[] clsArr6 = (Class[]) array6;
                            Constructor it9 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr6, clsArr6.length));
                            Intrinsics.checkNotNullExpressionValue(it9, "it");
                            it9.setAccessible(true);
                            Object newInstance6 = it9.newInstance(Arrays.copyOf(objArr6, 1));
                            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance6, intValue12);
                            layoutParams4 = (ViewGroup.LayoutParams) newInstance6;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    imageView.setLayoutParams(layoutParams4);
                    linearLayout.addView(imageView);
                    Trace.endSection();
                    TextView textView = new TextView(linearLayout.getContext());
                    Object invoke4 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                    if (invoke4 != null) {
                        textView.setLayoutParams((ViewGroup.LayoutParams) invoke4);
                        int p19 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (textView.getLayoutParams() == null) {
                            textView.setLayoutParams(new ViewGroup.LayoutParams(p19, 0));
                        } else {
                            textView.getLayoutParams().width = p19;
                        }
                        textView.setId(R.id.f167093ks0);
                        int p26 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (textView.getLayoutParams() == null) {
                            textView.setLayoutParams(new ViewGroup.LayoutParams(0, p26));
                        } else {
                            textView.getLayoutParams().height = p26;
                        }
                        textView.setText("03:22");
                        textView.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(11)).floatValue());
                        com.tencent.aio.view_dsl.dsl.f.p(textView, com.tencent.aio.view_dsl.dsl.b.g());
                        int intValue13 = ((Number) com.tencent.qqnt.chathistory.util.m.c(2)).intValue();
                        ViewGroup.LayoutParams layoutParams28 = textView.getLayoutParams();
                        if (!(layoutParams28 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams28 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams9 = (ViewGroup.MarginLayoutParams) layoutParams28;
                        if (marginLayoutParams9 != null) {
                            marginLayoutParams9.topMargin = intValue13;
                            layoutParams5 = marginLayoutParams9;
                        } else {
                            ViewGroup.LayoutParams layoutParams29 = textView.getLayoutParams();
                            int i28 = layoutParams29 != null ? layoutParams29.width : 0;
                            ViewGroup.LayoutParams layoutParams30 = textView.getLayoutParams();
                            Object[] objArr7 = {new ViewGroup.LayoutParams(i28, layoutParams30 != null ? layoutParams30.height : 0)};
                            ArrayList arrayList7 = new ArrayList(1);
                            arrayList7.add(objArr7[0].getClass());
                            Object[] array7 = arrayList7.toArray(new Class[0]);
                            if (array7 != null) {
                                Class[] clsArr7 = (Class[]) array7;
                                Constructor it10 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr7, clsArr7.length));
                                Intrinsics.checkNotNullExpressionValue(it10, "it");
                                it10.setAccessible(true);
                                Object newInstance7 = it10.newInstance(Arrays.copyOf(objArr7, 1));
                                ((ViewGroup.MarginLayoutParams) newInstance7).topMargin = intValue13;
                                layoutParams5 = (ViewGroup.LayoutParams) newInstance7;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        textView.setLayoutParams(layoutParams5);
                        textView.setGravity(com.tencent.aio.view_dsl.dsl.b.e());
                        int intValue14 = ((Number) com.tencent.qqnt.chathistory.util.m.c(2)).intValue();
                        ViewGroup.LayoutParams layoutParams31 = textView.getLayoutParams();
                        if (!(layoutParams31 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams31 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams10 = (ViewGroup.MarginLayoutParams) layoutParams31;
                        if (marginLayoutParams10 != null) {
                            marginLayoutParams10.bottomMargin = intValue14;
                            layoutParams6 = marginLayoutParams10;
                        } else {
                            ViewGroup.LayoutParams layoutParams32 = textView.getLayoutParams();
                            int i29 = layoutParams32 != null ? layoutParams32.width : 0;
                            ViewGroup.LayoutParams layoutParams33 = textView.getLayoutParams();
                            Object[] objArr8 = {new ViewGroup.LayoutParams(i29, layoutParams33 != null ? layoutParams33.height : 0)};
                            ArrayList arrayList8 = new ArrayList(1);
                            arrayList8.add(objArr8[0].getClass());
                            Object[] array8 = arrayList8.toArray(new Class[0]);
                            if (array8 != null) {
                                Class[] clsArr8 = (Class[]) array8;
                                Constructor it11 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr8, clsArr8.length));
                                Intrinsics.checkNotNullExpressionValue(it11, "it");
                                it11.setAccessible(true);
                                Object newInstance8 = it11.newInstance(Arrays.copyOf(objArr8, 1));
                                ((ViewGroup.MarginLayoutParams) newInstance8).bottomMargin = intValue14;
                                layoutParams6 = (ViewGroup.LayoutParams) newInstance8;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        textView.setLayoutParams(layoutParams6);
                        textView.setVisibility(8);
                        int intValue15 = ((Number) com.tencent.qqnt.chathistory.util.m.c(4)).intValue();
                        ViewGroup.LayoutParams layoutParams34 = textView.getLayoutParams();
                        if (!(layoutParams34 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams34 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams11 = (ViewGroup.MarginLayoutParams) layoutParams34;
                        if (marginLayoutParams11 != null) {
                            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams11, intValue15);
                            layoutParams7 = marginLayoutParams11;
                        } else {
                            ViewGroup.LayoutParams layoutParams35 = textView.getLayoutParams();
                            int i36 = layoutParams35 != null ? layoutParams35.width : 0;
                            ViewGroup.LayoutParams layoutParams36 = textView.getLayoutParams();
                            Object[] objArr9 = {new ViewGroup.LayoutParams(i36, layoutParams36 != null ? layoutParams36.height : 0)};
                            ArrayList arrayList9 = new ArrayList(1);
                            arrayList9.add(objArr9[0].getClass());
                            Object[] array9 = arrayList9.toArray(new Class[0]);
                            if (array9 != null) {
                                Class[] clsArr9 = (Class[]) array9;
                                Constructor it12 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr9, clsArr9.length));
                                Intrinsics.checkNotNullExpressionValue(it12, "it");
                                it12.setAccessible(true);
                                Object newInstance9 = it12.newInstance(Arrays.copyOf(objArr9, 1));
                                MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance9, intValue15);
                                layoutParams7 = (ViewGroup.LayoutParams) newInstance9;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        textView.setLayoutParams(layoutParams7);
                        textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_allwhite_primary, null));
                        j(textView);
                        linearLayout.addView(textView);
                        relativeLayout.addView(linearLayout);
                        TextView textView2 = new TextView(relativeLayout.getContext());
                        Object invoke5 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
                        if (invoke5 != null) {
                            textView2.setLayoutParams((ViewGroup.LayoutParams) invoke5);
                            int p27 = com.tencent.aio.view_dsl.dsl.b.p();
                            if (textView2.getLayoutParams() == null) {
                                textView2.setLayoutParams(new ViewGroup.LayoutParams(p27, 0));
                            } else {
                                textView2.getLayoutParams().width = p27;
                            }
                            textView2.setId(R.id.ca5);
                            int p28 = com.tencent.aio.view_dsl.dsl.b.p();
                            if (textView2.getLayoutParams() == null) {
                                textView2.setLayoutParams(new ViewGroup.LayoutParams(0, p28));
                            } else {
                                textView2.getLayoutParams().height = p28;
                            }
                            int intValue16 = ((Number) com.tencent.qqnt.chathistory.util.m.c(10)).intValue();
                            ViewGroup.LayoutParams layoutParams37 = textView2.getLayoutParams();
                            if (!(layoutParams37 instanceof ViewGroup.MarginLayoutParams)) {
                                layoutParams37 = null;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams12 = (ViewGroup.MarginLayoutParams) layoutParams37;
                            if (marginLayoutParams12 != null) {
                                MarginLayoutParamsCompat.setMarginStart(marginLayoutParams12, intValue16);
                                layoutParams8 = marginLayoutParams12;
                            } else {
                                ViewGroup.LayoutParams layoutParams38 = textView2.getLayoutParams();
                                int i37 = layoutParams38 != null ? layoutParams38.width : 0;
                                ViewGroup.LayoutParams layoutParams39 = textView2.getLayoutParams();
                                Object[] objArr10 = {new ViewGroup.LayoutParams(i37, layoutParams39 != null ? layoutParams39.height : 0)};
                                ArrayList arrayList10 = new ArrayList(1);
                                arrayList10.add(objArr10[0].getClass());
                                Object[] array10 = arrayList10.toArray(new Class[0]);
                                if (array10 != null) {
                                    Class[] clsArr10 = (Class[]) array10;
                                    Constructor it13 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr10, clsArr10.length));
                                    Intrinsics.checkNotNullExpressionValue(it13, "it");
                                    it13.setAccessible(true);
                                    Object newInstance10 = it13.newInstance(Arrays.copyOf(objArr10, 1));
                                    MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance10, intValue16);
                                    layoutParams8 = (ViewGroup.LayoutParams) newInstance10;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                            textView2.setLayoutParams(layoutParams8);
                            textView2.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.c(12)).floatValue());
                            textView2.setEllipsize(TextUtils.TruncateAt.END);
                            textView2.setMaxLines(((Number) com.tencent.aio.view_dsl.dsl.c.a(2)).intValue());
                            int intValue17 = ((Number) com.tencent.qqnt.chathistory.util.m.c(10)).intValue();
                            ViewGroup.LayoutParams layoutParams40 = textView2.getLayoutParams();
                            if (!(layoutParams40 instanceof ViewGroup.MarginLayoutParams)) {
                                layoutParams40 = null;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams13 = (ViewGroup.MarginLayoutParams) layoutParams40;
                            if (marginLayoutParams13 != null) {
                                marginLayoutParams13.topMargin = intValue17;
                                layoutParams9 = marginLayoutParams13;
                            } else {
                                ViewGroup.LayoutParams layoutParams41 = textView2.getLayoutParams();
                                int i38 = layoutParams41 != null ? layoutParams41.width : 0;
                                ViewGroup.LayoutParams layoutParams42 = textView2.getLayoutParams();
                                Object[] objArr11 = {new ViewGroup.LayoutParams(i38, layoutParams42 != null ? layoutParams42.height : 0)};
                                ArrayList arrayList11 = new ArrayList(1);
                                arrayList11.add(objArr11[0].getClass());
                                Object[] array11 = arrayList11.toArray(new Class[0]);
                                if (array11 != null) {
                                    Class[] clsArr11 = (Class[]) array11;
                                    Constructor it14 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr11, clsArr11.length));
                                    Intrinsics.checkNotNullExpressionValue(it14, "it");
                                    it14.setAccessible(true);
                                    Object newInstance11 = it14.newInstance(Arrays.copyOf(objArr11, 1));
                                    ((ViewGroup.MarginLayoutParams) newInstance11).topMargin = intValue17;
                                    layoutParams9 = (ViewGroup.LayoutParams) newInstance11;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                            textView2.setLayoutParams(layoutParams9);
                            textView2.setVisibility(0);
                            textView2.setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
                            g(textView2);
                            relativeLayout.addView(textView2);
                            if (attach) {
                                frameLayout.addView(relativeLayout);
                            }
                            Trace.endSection();
                            return relativeLayout;
                        }
                        throw new NullPointerException(str);
                    }
                    throw new NullPointerException(str);
                }
                throw new NullPointerException(str);
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
            this.filename = textView;
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

    public final void h(@NotNull SquImageView squImageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) squImageView);
        } else {
            Intrinsics.checkNotNullParameter(squImageView, "<set-?>");
            this.ivThumb = squImageView;
        }
    }

    public final void i(@NotNull QUICheckBox qUICheckBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qUICheckBox);
        } else {
            Intrinsics.checkNotNullParameter(qUICheckBox, "<set-?>");
            this.photoSelectItemSelectedIconIv = qUICheckBox;
        }
    }

    public final void j(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.videoLengthTv = textView;
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

    public /* synthetic */ v(Context context, Integer num, ViewGroup viewGroup, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num, (i3 & 4) == 0 ? viewGroup : null, (i3 & 8) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, viewGroup, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
