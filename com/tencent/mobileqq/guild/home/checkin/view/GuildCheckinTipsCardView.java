package com.tencent.mobileqq.guild.home.checkin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0015\u0010\u0019B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0015\u0010\u001bB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0015\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/checkin/view/GuildCheckinTipsCardView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "a", "", "todayActive", "setTodayActive", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "calendarImage", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "todayActiveTips", "Lcom/airbnb/lottie/LottieAnimationView;", "f", "Lcom/airbnb/lottie/LottieAnimationView;", "calendarLottie", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildCheckinTipsCardView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView calendarImage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView todayActiveTips;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView calendarLottie;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildCheckinTipsCardView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.ej7, this);
        View findViewById = findViewById(R.id.f164712tl1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.calendar_image)");
        this.calendarImage = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f99235p9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.today_active_tips)");
        this.todayActiveTips = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f164713tl2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.calendar_lottie)");
        this.calendarLottie = (LottieAnimationView) findViewById3;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = bi.b(254);
        obtain.mRequestHeight = bi.b(180);
        obtain.mLoadingDrawable = getContext().getResources().getDrawable(R.drawable.guild_checkin_detail_card_bg);
        obtain.mFailedDrawable = getContext().getResources().getDrawable(R.drawable.guild_checkin_detail_card_bg);
        URLDrawable drawable = URLDrawable.getDrawable("https://downv6.qq.com/innovate/guild/checkin/guild_checkin_tips_bg.png", obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(GUILD_CHECKIN_TIPS_BG, options)");
        ImageView imageView = this.calendarImage;
        LottieAnimationView lottieAnimationView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarImage");
            imageView = null;
        }
        imageView.setImageDrawable(drawable);
        if (QQTheme.isNowThemeIsNight()) {
            LottieAnimationView lottieAnimationView2 = this.calendarLottie;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("calendarLottie");
            } else {
                lottieAnimationView = lottieAnimationView2;
            }
            lottieAnimationView.setAnimationFromUrl("https://downv6.qq.com/innovate/guild/checkin/guild_checkin_tips_lottie_dark.json");
            return;
        }
        LottieAnimationView lottieAnimationView3 = this.calendarLottie;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarLottie");
        } else {
            lottieAnimationView = lottieAnimationView3;
        }
        lottieAnimationView.setAnimationFromUrl("https://downv6.qq.com/innovate/guild/checkin/guild_checkin_tips_lottie.json");
    }

    public final void setTodayActive(int todayActive) {
        TextView textView = this.todayActiveTips;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("todayActiveTips");
            textView = null;
        }
        textView.setText("\u4eca\u65e5\u7b7e\u5230\u53ef\u5f97\u6d3b\u8dc3\u503c+" + todayActive);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildCheckinTipsCardView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildCheckinTipsCardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCheckinTipsCardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context);
    }
}
