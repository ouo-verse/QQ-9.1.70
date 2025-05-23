package com.tencent.mobileqq.guild.channellist.title;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.x;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/title/GuildChannelHeaderTitleLayout;", "Landroid/widget/FrameLayout;", "", "from", "", "a", "", c.f123400v, "setViewAlpha", "", "count", "setChannelCount", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Lvp1/x;", "d", "Lvp1/x;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildChannelHeaderTitleLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private x binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelHeaderTitleLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(String from) {
        Integer num;
        int f16 = QQGuildUIUtil.f(170.0f);
        Logger.a d16 = Logger.f235387a.d();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            num = Integer.valueOf(layoutParams.height);
        } else {
            num = null;
        }
        d16.d("Guild.NewHome.GuildChannelHeaderTitleLayout", 1, "headTitleInList updateHeight height:" + num + "->" + f16 + " from:" + from);
        if (getLayoutParams() == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-1, f16));
        } else {
            getLayoutParams().height = f16;
            getLayoutParams().width = -1;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        if (w3 != oldw || h16 != oldh) {
            a(MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED);
        }
    }

    public final void setChannelCount(int count) {
        CharSequence charSequence;
        TextView textView = this.binding.f443139e;
        if (count > 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            StyleSpan styleSpan = new StyleSpan(1);
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) String.valueOf(count));
            spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) "\u4e2a\u8ba8\u8bba\u7ec4");
            charSequence = new SpannedString(spannableStringBuilder);
        } else {
            charSequence = "\u5feb\u548c\u5927\u5bb6\u4e00\u8d77\u804a\u804a\u5427";
        }
        textView.setText(charSequence);
    }

    public final void setViewAlpha(float alpha) {
        this.binding.f443136b.setAlpha(alpha);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelHeaderTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildChannelHeaderTitleLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelHeaderTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        x g16 = x.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        a("init");
        this.binding.f443137c.setPadding(0, ImmersiveUtils.getStatusBarHeight(context), 0, 0);
    }
}
