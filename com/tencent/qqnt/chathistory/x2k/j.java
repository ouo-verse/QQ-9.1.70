package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.os.Trace;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.util.Xml2LayoutKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010,\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\"\u0010/\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010$\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\"\u00105\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b6\u0010\u000f\"\u0004\b7\u0010\u0011R\"\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b7\u00100\u001a\u0004\b9\u00102\"\u0004\b:\u00104\u00a8\u0006@"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/j;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", "o", "(Landroid/view/View;)V", "_root", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "c", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "getIcon", "()Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "g", "(Lcom/tencent/qqnt/base/widget/RoundRectImageView;)V", "icon", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "getIconContainer", "()Landroid/widget/FrameLayout;", tl.h.F, "(Landroid/widget/FrameLayout;)V", "iconContainer", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getLastMsgTime", "()Landroid/widget/TextView;", "i", "(Landroid/widget/TextView;)V", "lastMsgTime", "getText1", "l", "text1", "getText2", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "text2", "Landroid/widget/RelativeLayout;", "getTroopMemHistoryItemBody", "()Landroid/widget/RelativeLayout;", DomainData.DOMAIN_NAME, "(Landroid/widget/RelativeLayout;)V", "troopMemHistoryItemBody", "getListDivider", "j", "listDivider", "getRelativeItem", "k", "relativeItem", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class j implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public RoundRectImageView icon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public FrameLayout iconContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView lastMsgTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView text1;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public TextView text2;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout troopMemHistoryItemBody;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public View listDivider;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout relativeItem;

    public j(@NotNull Context context, @Nullable Integer num) {
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
        relativeLayout.setId(R.id.relativeItem);
        int p16 = com.tencent.aio.view_dsl.dsl.b.p();
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
        } else {
            relativeLayout.getLayoutParams().height = p16;
        }
        relativeLayout.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg_selector);
        Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
        RelativeLayout relativeLayout2 = new RelativeLayout(relativeLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
        if (invoke != null) {
            relativeLayout2.setLayoutParams((ViewGroup.LayoutParams) invoke);
            relativeLayout2.setPadding(relativeLayout2.getPaddingLeft(), com.tencent.qqnt.chathistory.util.m.a(16), relativeLayout2.getPaddingRight(), relativeLayout2.getPaddingBottom());
            relativeLayout2.setPadding(relativeLayout2.getPaddingLeft(), relativeLayout2.getPaddingTop(), relativeLayout2.getPaddingRight(), com.tencent.qqnt.chathistory.util.m.a(16));
            int l3 = com.tencent.aio.view_dsl.dsl.b.l();
            if (relativeLayout2.getLayoutParams() == null) {
                relativeLayout2.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
            } else {
                relativeLayout2.getLayoutParams().width = l3;
            }
            relativeLayout2.setId(R.id.mbs);
            int p17 = com.tencent.aio.view_dsl.dsl.b.p();
            if (relativeLayout2.getLayoutParams() == null) {
                relativeLayout2.setLayoutParams(new ViewGroup.LayoutParams(0, p17));
            } else {
                relativeLayout2.getLayoutParams().height = p17;
            }
            FrameLayout frameLayout = new FrameLayout(relativeLayout2.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(relativeLayout2, new Object[0]);
            if (invoke2 != null) {
                frameLayout.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int intValue = ((Number) com.tencent.qqnt.chathistory.util.m.c(40)).intValue();
                if (frameLayout.getLayoutParams() == null) {
                    frameLayout.setLayoutParams(new ViewGroup.LayoutParams(intValue, 0));
                } else {
                    frameLayout.getLayoutParams().width = intValue;
                }
                frameLayout.setId(R.id.d_b);
                int intValue2 = ((Number) com.tencent.qqnt.chathistory.util.m.c(40)).intValue();
                if (frameLayout.getLayoutParams() == null) {
                    frameLayout.setLayoutParams(new ViewGroup.LayoutParams(0, intValue2));
                } else {
                    frameLayout.getLayoutParams().height = intValue2;
                }
                int intValue3 = ((Number) com.tencent.qqnt.chathistory.util.m.c(16)).intValue();
                ViewGroup.LayoutParams layoutParams7 = frameLayout.getLayoutParams();
                ViewGroup.LayoutParams layoutParams8 = null;
                if (!(layoutParams7 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams7 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams7;
                if (marginLayoutParams != null) {
                    MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, intValue3);
                    layoutParams = marginLayoutParams;
                } else {
                    ViewGroup.LayoutParams layoutParams9 = frameLayout.getLayoutParams();
                    if (layoutParams9 != null) {
                        i3 = layoutParams9.width;
                    } else {
                        i3 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams10 = frameLayout.getLayoutParams();
                    if (layoutParams10 != null) {
                        i16 = layoutParams10.height;
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
                frameLayout.setLayoutParams(layoutParams);
                int intValue4 = ((Number) com.tencent.qqnt.chathistory.util.m.c(Double.valueOf(10.5d))).intValue();
                ViewGroup.LayoutParams layoutParams11 = frameLayout.getLayoutParams();
                if (!(layoutParams11 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams11 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams11;
                if (marginLayoutParams2 != null) {
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams2, intValue4);
                    layoutParams2 = marginLayoutParams2;
                } else {
                    ViewGroup.LayoutParams layoutParams12 = frameLayout.getLayoutParams();
                    if (layoutParams12 != null) {
                        i17 = layoutParams12.width;
                    } else {
                        i17 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams13 = frameLayout.getLayoutParams();
                    if (layoutParams13 != null) {
                        i18 = layoutParams13.height;
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
                        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance2, intValue4);
                        layoutParams2 = (ViewGroup.LayoutParams) newInstance2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                frameLayout.setLayoutParams(layoutParams2);
                RoundRectImageView roundRectImageView = new RoundRectImageView(frameLayout.getContext(), null, 0, 6, null);
                frameLayout.addView(roundRectImageView);
                int l16 = com.tencent.aio.view_dsl.dsl.b.l();
                if (roundRectImageView.getLayoutParams() == null) {
                    roundRectImageView.setLayoutParams(new ViewGroup.LayoutParams(l16, 0));
                } else {
                    roundRectImageView.getLayoutParams().width = l16;
                }
                roundRectImageView.setId(R.id.icon);
                int l17 = com.tencent.aio.view_dsl.dsl.b.l();
                if (roundRectImageView.getLayoutParams() == null) {
                    roundRectImageView.setLayoutParams(new ViewGroup.LayoutParams(0, l17));
                } else {
                    roundRectImageView.getLayoutParams().height = l17;
                }
                roundRectImageView.setContentDescription(Xml2LayoutKt.NULL_VALUE);
                roundRectImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                roundRectImageView.setFocusable(false);
                roundRectImageView.setClickable(false);
                g(roundRectImageView);
                h(frameLayout);
                relativeLayout2.addView(frameLayout);
                TextView textView = new TextView(relativeLayout2.getContext());
                Object invoke3 = LayoutBuilderKt.b().invoke(relativeLayout2, new Object[0]);
                if (invoke3 != null) {
                    textView.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                    int p18 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView.getLayoutParams() == null) {
                        textView.setLayoutParams(new ViewGroup.LayoutParams(0, p18));
                    } else {
                        textView.getLayoutParams().height = p18;
                    }
                    textView.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(12)).floatValue());
                    textView.setSingleLine(true);
                    com.tencent.aio.view_dsl.dsl.f.l(textView, true);
                    textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_secondary, null));
                    int p19 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView.getLayoutParams() == null) {
                        textView.setLayoutParams(new ViewGroup.LayoutParams(p19, 0));
                    } else {
                        textView.getLayoutParams().width = p19;
                    }
                    textView.setId(R.id.lastMsgTime);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    com.tencent.aio.view_dsl.dsl.f.f(textView, true);
                    textView.setDuplicateParentStateEnabled(true);
                    textView.setIncludeFontPadding(false);
                    com.tencent.aio.view_dsl.dsl.f.h(textView, true);
                    int intValue5 = ((Number) com.tencent.qqnt.chathistory.util.m.c(15)).intValue();
                    ViewGroup.LayoutParams layoutParams14 = textView.getLayoutParams();
                    if (!(layoutParams14 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams14 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams14;
                    if (marginLayoutParams3 != null) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams3, intValue5);
                        layoutParams3 = marginLayoutParams3;
                    } else {
                        ViewGroup.LayoutParams layoutParams15 = textView.getLayoutParams();
                        if (layoutParams15 != null) {
                            i19 = layoutParams15.width;
                        } else {
                            i19 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams16 = textView.getLayoutParams();
                        if (layoutParams16 != null) {
                            i26 = layoutParams16.height;
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
                            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance3, intValue5);
                            layoutParams3 = (ViewGroup.LayoutParams) newInstance3;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    textView.setLayoutParams(layoutParams3);
                    i(textView);
                    relativeLayout2.addView(textView);
                    TextView textView2 = new TextView(relativeLayout2.getContext());
                    Object invoke4 = LayoutBuilderKt.b().invoke(relativeLayout2, new Object[0]);
                    if (invoke4 != null) {
                        textView2.setLayoutParams((ViewGroup.LayoutParams) invoke4);
                        int p26 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (textView2.getLayoutParams() == null) {
                            textView2.setLayoutParams(new ViewGroup.LayoutParams(0, p26));
                        } else {
                            textView2.getLayoutParams().height = p26;
                        }
                        textView2.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(12)).floatValue());
                        textView2.setSingleLine(true);
                        textView2.setTextColor(textView2.getResources().getColorStateList(R.color.qui_common_text_secondary, null));
                        int c17 = com.tencent.aio.view_dsl.dsl.b.c();
                        if (textView2.getLayoutParams() == null) {
                            textView2.setLayoutParams(new ViewGroup.LayoutParams(c17, 0));
                        } else {
                            textView2.getLayoutParams().width = c17;
                        }
                        textView2.setId(R.id.text1);
                        com.tencent.aio.view_dsl.dsl.f.k(textView2, R.id.lastMsgTime);
                        com.tencent.aio.view_dsl.dsl.f.s(textView2, R.id.d_b);
                        textView2.setDuplicateParentStateEnabled(true);
                        textView2.setIncludeFontPadding(false);
                        int intValue6 = ((Number) com.tencent.qqnt.chathistory.util.m.c(9)).intValue();
                        ViewGroup.LayoutParams layoutParams17 = textView2.getLayoutParams();
                        if (!(layoutParams17 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams17 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams17;
                        if (marginLayoutParams4 != null) {
                            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams4, intValue6);
                            layoutParams4 = marginLayoutParams4;
                        } else {
                            ViewGroup.LayoutParams layoutParams18 = textView2.getLayoutParams();
                            if (layoutParams18 != null) {
                                i27 = layoutParams18.width;
                            } else {
                                i27 = 0;
                            }
                            ViewGroup.LayoutParams layoutParams19 = textView2.getLayoutParams();
                            if (layoutParams19 != null) {
                                i28 = layoutParams19.height;
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
                                MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance4, intValue6);
                                layoutParams4 = (ViewGroup.LayoutParams) newInstance4;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        textView2.setLayoutParams(layoutParams4);
                        com.tencent.aio.view_dsl.dsl.f.r(textView2, R.id.lastMsgTime);
                        l(textView2);
                        relativeLayout2.addView(textView2);
                        TextView textView3 = new TextView(relativeLayout2.getContext());
                        Object invoke5 = LayoutBuilderKt.b().invoke(relativeLayout2, new Object[0]);
                        if (invoke5 != null) {
                            textView3.setLayoutParams((ViewGroup.LayoutParams) invoke5);
                            int intValue7 = ((Number) com.tencent.qqnt.chathistory.util.m.c(5)).intValue();
                            ViewGroup.LayoutParams layoutParams20 = textView3.getLayoutParams();
                            if (!(layoutParams20 instanceof ViewGroup.MarginLayoutParams)) {
                                layoutParams20 = null;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams20;
                            if (marginLayoutParams5 != null) {
                                marginLayoutParams5.topMargin = intValue7;
                                layoutParams5 = marginLayoutParams5;
                            } else {
                                ViewGroup.LayoutParams layoutParams21 = textView3.getLayoutParams();
                                if (layoutParams21 != null) {
                                    i29 = layoutParams21.width;
                                } else {
                                    i29 = 0;
                                }
                                ViewGroup.LayoutParams layoutParams22 = textView3.getLayoutParams();
                                if (layoutParams22 != null) {
                                    i36 = layoutParams22.height;
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
                                    ((ViewGroup.MarginLayoutParams) newInstance5).topMargin = intValue7;
                                    layoutParams5 = (ViewGroup.LayoutParams) newInstance5;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                            textView3.setLayoutParams(layoutParams5);
                            int p27 = com.tencent.aio.view_dsl.dsl.b.p();
                            if (textView3.getLayoutParams() == null) {
                                textView3.setLayoutParams(new ViewGroup.LayoutParams(0, p27));
                            } else {
                                textView3.getLayoutParams().height = p27;
                            }
                            textView3.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(16)).floatValue());
                            com.tencent.aio.view_dsl.dsl.f.m(textView3, R.id.text1);
                            textView3.setTextColor(textView3.getResources().getColorStateList(R.color.qui_common_text_primary, null));
                            int c18 = com.tencent.aio.view_dsl.dsl.b.c();
                            if (textView3.getLayoutParams() == null) {
                                textView3.setLayoutParams(new ViewGroup.LayoutParams(c18, 0));
                            } else {
                                textView3.getLayoutParams().width = c18;
                            }
                            textView3.setId(R.id.text2);
                            textView3.setEllipsize(TextUtils.TruncateAt.END);
                            com.tencent.aio.view_dsl.dsl.f.s(textView3, R.id.d_b);
                            textView3.setMaxLines(((Number) com.tencent.aio.view_dsl.dsl.c.a(3)).intValue());
                            textView3.setGravity(com.tencent.aio.view_dsl.dsl.b.g() | com.tencent.aio.view_dsl.dsl.b.i());
                            com.tencent.aio.view_dsl.dsl.f.i(textView3, R.id.lastMsgTime);
                            textView3.setDuplicateParentStateEnabled(true);
                            textView3.setIncludeFontPadding(false);
                            com.tencent.aio.view_dsl.dsl.f.b(textView3, R.id.text1);
                            m(textView3);
                            relativeLayout2.addView(textView3);
                            n(relativeLayout2);
                            relativeLayout.addView(relativeLayout2);
                            Trace.endSection();
                            View view = new View(relativeLayout.getContext());
                            Object invoke6 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
                            if (invoke6 != null) {
                                view.setLayoutParams((ViewGroup.LayoutParams) invoke6);
                                int b16 = com.tencent.qqnt.chathistory.util.m.b(Double.valueOf(66.5d));
                                ViewGroup.LayoutParams layoutParams23 = view.getLayoutParams();
                                if (layoutParams23 instanceof ViewGroup.MarginLayoutParams) {
                                    layoutParams8 = layoutParams23;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams8;
                                if (marginLayoutParams6 != null) {
                                    MarginLayoutParamsCompat.setMarginStart(marginLayoutParams6, b16);
                                    layoutParams6 = marginLayoutParams6;
                                } else {
                                    ViewGroup.LayoutParams layoutParams24 = view.getLayoutParams();
                                    if (layoutParams24 != null) {
                                        i37 = layoutParams24.width;
                                    } else {
                                        i37 = 0;
                                    }
                                    ViewGroup.LayoutParams layoutParams25 = view.getLayoutParams();
                                    if (layoutParams25 != null) {
                                        i38 = layoutParams25.height;
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
                                        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance6, b16);
                                        layoutParams6 = (ViewGroup.LayoutParams) newInstance6;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                    }
                                }
                                view.setLayoutParams(layoutParams6);
                                int l18 = com.tencent.aio.view_dsl.dsl.b.l();
                                if (view.getLayoutParams() == null) {
                                    view.setLayoutParams(new ViewGroup.LayoutParams(l18, 0));
                                } else {
                                    view.getLayoutParams().width = l18;
                                }
                                view.setBackground(AppCompatResources.getDrawable(view.getContext(), R.drawable.qui_common_border_light_bg));
                                view.setId(R.id.lpv);
                                int intValue8 = ((Number) com.tencent.qqnt.chathistory.util.m.c(Double.valueOf(0.5d))).intValue();
                                if (view.getLayoutParams() == null) {
                                    view.setLayoutParams(new ViewGroup.LayoutParams(0, intValue8));
                                } else {
                                    view.getLayoutParams().height = intValue8;
                                }
                                view.setVisibility(0);
                                com.tencent.aio.view_dsl.dsl.f.h(view, true);
                                com.tencent.aio.view_dsl.dsl.f.e(view, true);
                                j(view);
                                relativeLayout.addView(view);
                                k(relativeLayout);
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

    public final void g(@NotNull RoundRectImageView roundRectImageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) roundRectImageView);
        } else {
            Intrinsics.checkNotNullParameter(roundRectImageView, "<set-?>");
            this.icon = roundRectImageView;
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

    public final void h(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.iconContainer = frameLayout;
        }
    }

    public final void i(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.lastMsgTime = textView;
        }
    }

    public final void j(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.listDivider = view;
        }
    }

    public final void k(@NotNull RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) relativeLayout);
        } else {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.relativeItem = relativeLayout;
        }
    }

    public final void l(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.text1 = textView;
        }
    }

    public final void m(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.text2 = textView;
        }
    }

    public final void n(@NotNull RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) relativeLayout);
        } else {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.troopMemHistoryItemBody = relativeLayout;
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

    public /* synthetic */ j(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
