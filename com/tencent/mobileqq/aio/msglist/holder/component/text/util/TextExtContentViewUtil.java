package com.tencent.mobileqq.aio.msglist.holder.component.text.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.widget.CommonImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.base.utils.c;
import com.tencent.qqnt.kernel.nativeinterface.LinkInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichStatus;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w71.r;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002JI\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0002J\"\u0010!\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\bH\u0002J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u000e\u0010$\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0002JK\u0010'\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020#2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b'\u0010(J\u000e\u0010)\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fR\u0014\u0010+\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010*R\u001b\u0010/\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/text/util/TextExtContentViewUtil;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "", "url", "", QQBrowserActivity.KEY_MSG_TYPE, "", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/LinkInfo;", "linkInfo", "infoView", "Landroid/widget/TextView;", "titleView", "descView", "Lcom/tencent/mobileqq/aio/widget/CommonImageView;", "iconView", "", "isSelf", "bubbleTextColor", "b", "(Lcom/tencent/qqnt/kernel/nativeinterface/LinkInfo;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/TextView;Lcom/tencent/mobileqq/aio/widget/CommonImageView;ZLjava/lang/Integer;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "tintColor", "l", "color", "", "coefficient", "diff", "g", "j", "Landroid/widget/RelativeLayout;", "e", "extTextView", "text", "k", "(Landroid/content/Context;Landroid/widget/RelativeLayout;Lcom/tencent/qqnt/kernel/nativeinterface/LinkInfo;ZLjava/lang/String;Ljava/lang/Integer;I)Z", "i", "I", "RICH_MSG_TOP_MARGIN", "Lkotlin/Lazy;", "f", "()Z", "addPrefixSwitch", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class TextExtContentViewUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TextExtContentViewUtil f192002a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int RICH_MSG_TOP_MARGIN;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy addPrefixSwitch;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192005a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63639);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[RichStatus.values().length];
            try {
                iArr[RichStatus.KRICHSTART.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RichStatus.KRICHPROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RichStatus.KRICHCOMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f192005a = iArr;
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63644);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f192002a = new TextExtContentViewUtil();
        RICH_MSG_TOP_MARGIN = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.dbv);
        lazy = LazyKt__LazyJVMKt.lazy(TextExtContentViewUtil$addPrefixSwitch$2.INSTANCE);
        addPrefixSwitch = lazy;
    }

    TextExtContentViewUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(LinkInfo linkInfo, View infoView, TextView titleView, TextView descView, CommonImageView iconView, boolean isSelf, Integer bubbleTextColor) {
        int i3;
        int i16;
        int i17;
        int color;
        int color2;
        Context context = titleView.getContext();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = ContextCompat.getDrawable(context, R.drawable.f160250mn0);
        obtain.mFailedDrawable = ContextCompat.getDrawable(context, R.drawable.f160250mn0);
        if (isSelf) {
            i3 = R.color.qui_common_bubble_host_text_primary;
        } else {
            i3 = R.color.qui_common_bubble_guest_text_primary;
        }
        int i18 = R.color.qui_common_bubble_guest_text_secondary;
        if (bubbleTextColor != null) {
            int intValue = bubbleTextColor.intValue();
            titleView.setTextColor(bubbleTextColor.intValue());
            if (isSelf && !QQTheme.isNowThemeDefaultNight()) {
                i16 = 0;
                i17 = 8;
                color = h(this, bubbleTextColor.intValue(), 0.8f, 0, 4, null);
            } else {
                i16 = 0;
                i17 = 8;
                color = context.getResources().getColor(R.color.qui_common_bubble_guest_text_secondary);
            }
            descView.setTextColor(color);
            if (isSelf) {
                if (QQTheme.isNowThemeDefaultNight()) {
                    color2 = Color.parseColor("#05FFFFFF");
                } else {
                    color2 = j(bubbleTextColor.intValue(), 0.05f);
                }
            } else if (QQTheme.isNowThemeDefaultNight()) {
                color2 = Color.parseColor("#05FFFFFF");
            } else {
                color2 = context.getResources().getColor(R.color.qui_common_fill_standard_extra);
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(ColorStateList.valueOf(color2));
            float a16 = c.f353052a.a(8.0f);
            float[] fArr = new float[i17];
            fArr[i16] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = a16;
            fArr[5] = a16;
            fArr[6] = a16;
            fArr[7] = a16;
            gradientDrawable.setCornerRadii(fArr);
            infoView.setBackground(gradientDrawable);
            i3 = intValue;
        } else {
            i16 = 0;
            i17 = 8;
            if (isSelf) {
                i18 = R.color.qui_common_bubble_host_text_secondary;
            }
            infoView.setBackgroundResource(R.drawable.j97);
            titleView.setTextColor(AppCompatResources.getColorStateList(context, i3));
            descView.setTextColor(AppCompatResources.getColorStateList(context, i18));
        }
        if (linkInfo.isDefaultPicture) {
            iconView.setVisibility(i17);
        }
        titleView.setText(linkInfo.title);
        Drawable drawable = context.getResources().getDrawable(R.drawable.qui_link);
        Intrinsics.checkNotNullExpressionValue(drawable, "context.resources.getDra\u2026oken.R.drawable.qui_link)");
        Drawable l3 = l(drawable, i3);
        c cVar = c.f353052a;
        int b16 = cVar.b(16);
        l3.setBounds(i16, i16, b16, b16);
        titleView.setCompoundDrawables(l3, null, null, null);
        titleView.setCompoundDrawablePadding(cVar.b(4));
        descView.setText(linkInfo.desc);
        if (!URLUtil.isHttpUrl(linkInfo.icon) && !URLUtil.isHttpsUrl(linkInfo.icon)) {
            iconView.setVisibility(i17);
        } else {
            iconView.setImageDrawable(URLDrawable.getDrawable(linkInfo.icon, obtain));
            iconView.setCornerRadiusAndMode(cVar.a(6.0f), 1);
        }
        com.tencent.mobileqq.aio.utils.b.f194119a.p("em_bas_link_rich_content");
    }

    private final void c(final Context context, View view, final String url, final int msgType) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.text.util.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TextExtContentViewUtil.d(url, msgType, context, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, int i3, Context context, View view) {
        String str2;
        int lastIndexOf$default;
        String str3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        if (f192002a.f() && str != null) {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, "#", 0, false, 6, (Object) null);
            if (lastIndexOf$default > 0) {
                str3 = str.substring(lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String).substring(startIndex)");
            } else {
                str3 = null;
            }
            str = URLUtil.guessUrl(str);
            if (str3 != null) {
                str = str + str3;
            }
        }
        if (str != null) {
            Bundle bundle = new Bundle();
            if (1 == i3) {
                str2 = "mqq.c2c";
            } else {
                str2 = "mqq.group";
            }
            bundle.putString("key_url_source", str2);
            ((IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class)).openBrowserDelegate(context, str, bundle);
        }
        com.tencent.mobileqq.aio.utils.b.f194119a.k("em_bas_link_rich_content");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean f() {
        return ((Boolean) addPrefixSwitch.getValue()).booleanValue();
    }

    private final int g(int color, float coefficient, int diff) {
        return ((color & 255) | (((color >> 16) & 255) << 16) | (((color >> 8) & 255) << 8) | (((int) (((color >> 24) & 255) * coefficient)) << 24)) + diff;
    }

    static /* synthetic */ int h(TextExtContentViewUtil textExtContentViewUtil, int i3, float f16, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        return textExtContentViewUtil.g(i3, f16, i16);
    }

    private final int j(int color, float coefficient) {
        int i3 = (int) (((color >> 24) & 255) * coefficient);
        int i16 = 255 - color;
        return (i16 & 255) | (((i16 >> 16) & 255) << 16) | (((i16 >> 8) & 255) << 8) | (i3 << 24);
    }

    private final Drawable l(Drawable drawable, int tintColor) {
        Drawable newDr;
        if (drawable instanceof SkinnableBitmapDrawable) {
            newDr = ((SkinnableBitmapDrawable) drawable).mutate2();
        } else {
            newDr = drawable.mutate();
        }
        newDr.setColorFilter(new PorterDuffColorFilter(tintColor, PorterDuff.Mode.SRC_IN));
        Intrinsics.checkNotNullExpressionValue(newDr, "newDr");
        return newDr;
    }

    @NotNull
    public final RelativeLayout e(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        r g16 = r.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        RelativeLayout relativeLayout = g16.f444897i;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.root");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = RICH_MSG_TOP_MARGIN;
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    public final boolean i(@NotNull LinkInfo linkInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) linkInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(linkInfo, "linkInfo");
        if (!TextUtils.isEmpty(linkInfo.title) && !TextUtils.isEmpty(linkInfo.desc) && !TextUtils.isEmpty(linkInfo.icon)) {
            return true;
        }
        return false;
    }

    public final boolean k(@NotNull Context context, @NotNull RelativeLayout extTextView, @Nullable LinkInfo linkInfo, boolean isSelf, @Nullable String text, @Nullable Integer bubbleTextColor, int msgType) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, context, extTextView, linkInfo, Boolean.valueOf(isSelf), text, bubbleTextColor, Integer.valueOf(msgType))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extTextView, "extTextView");
        if (linkInfo == null) {
            extTextView.setVisibility(8);
            return false;
        }
        RelativeLayout relativeLayout = (RelativeLayout) extTextView.findViewById(R.id.f74263vs);
        RelativeLayout infoView = (RelativeLayout) extTextView.findViewById(R.id.f74203vm);
        TextView titleView = (TextView) extTextView.findViewById(R.id.f74233vp);
        TextView descView = (TextView) extTextView.findViewById(R.id.f74213vn);
        CommonImageView iconView = (CommonImageView) extTextView.findViewById(R.id.f74223vo);
        extTextView.setVisibility(0);
        RichStatus richStatus = linkInfo.richStatus;
        if (richStatus == null) {
            i3 = -1;
        } else {
            i3 = a.f192005a[richStatus.ordinal()];
        }
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                extTextView.setVisibility(8);
                return false;
            }
            relativeLayout.setVisibility(8);
            if (!i(linkInfo)) {
                extTextView.setVisibility(8);
                return false;
            }
            infoView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(infoView, "infoView");
            Intrinsics.checkNotNullExpressionValue(titleView, "titleView");
            Intrinsics.checkNotNullExpressionValue(descView, "descView");
            Intrinsics.checkNotNullExpressionValue(iconView, "iconView");
            b(linkInfo, infoView, titleView, descView, iconView, isSelf, bubbleTextColor);
            c(context, infoView, text, msgType);
            return true;
        }
        relativeLayout.setVisibility(0);
        infoView.setVisibility(8);
        return false;
    }
}
