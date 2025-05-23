package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u00012\u00020\u0002:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b'\u0010(B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\b'\u0010+B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010,\u001a\u00020\f\u00a2\u0006\u0004\b'\u0010-B+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010,\u001a\u00020\f\u0012\u0006\u0010.\u001a\u00020\f\u00a2\u0006\u0004\b'\u0010/J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0006\u0010\b\u001a\u00020\u0005J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildGuestBottomLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "", "c", "d", "b", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "colorMode", "setColorMode", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "topTips", "f", "bottomTips", tl.h.F, "a", "()Landroid/widget/TextView;", "setJoinButton", "(Landroid/widget/TextView;)V", "joinButton", "i", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View$OnClickListener;", "getJoinButtonClickListener", "()Landroid/view/View$OnClickListener;", "setJoinButtonClickListener", "(Landroid/view/View$OnClickListener;)V", "joinButtonClickListener", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", BdhLogUtil.LogTag.Tag_Conn, "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGuestBottomLayout extends FrameLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildUserAvatarView avatarView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView topTips;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView bottomTips;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public TextView joinButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int colorMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener joinButtonClickListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildGuestBottomLayout(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c(Context context) {
        LayoutInflater.from(context).inflate(R.layout.f168100et2, this);
        View findViewById = findViewById(R.id.f164552t20);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar_view)");
        this.avatarView = (GuildUserAvatarView) findViewById;
        View findViewById2 = findViewById(R.id.f100045rf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.top_tips)");
        this.topTips = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f164641tb4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.bottom_tips)");
        this.bottomTips = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f165979ya4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.join_button)");
        setJoinButton((TextView) findViewById4);
        a().setOnClickListener(this);
        setOnClickListener(this);
        setColorMode(this.colorMode);
        d();
    }

    private final void d() {
        String str;
        GuildUserAvatarView guildUserAvatarView = null;
        if (at.c()) {
            str = ((IGPSService) bz.b(IGPSService.class)).getSelfTinyId();
        } else {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("setAvatar session not ready");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildGuestBottomLayout", 1, (String) it.next(), null);
            }
            str = "";
        }
        GuildUserAvatarView guildUserAvatarView2 = this.avatarView;
        if (guildUserAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            guildUserAvatarView2 = null;
        }
        guildUserAvatarView2.setAvatarTinyId("0", str);
        GuildUserAvatarView guildUserAvatarView3 = this.avatarView;
        if (guildUserAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        } else {
            guildUserAvatarView = guildUserAvatarView3;
        }
        guildUserAvatarView.setLogTag("GuildGuestBottomLayout");
    }

    @NotNull
    public final TextView a() {
        TextView textView = this.joinButton;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("joinButton");
        return null;
    }

    public final void b() {
        TextView textView = this.topTips;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTips");
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 0;
        TextView textView3 = this.topTips;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTips");
            textView3 = null;
        }
        textView3.setLayoutParams(layoutParams2);
        TextView textView4 = this.bottomTips;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTips");
        } else {
            textView2 = textView4;
        }
        textView2.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        View.OnClickListener onClickListener;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (Intrinsics.areEqual(v3, a()) && (onClickListener = this.joinButtonClickListener) != null) {
            onClickListener.onClick(v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setColorMode(int colorMode) {
        Typeface typeface;
        TextView textView = null;
        if (colorMode != 0) {
            if (colorMode != 1) {
                com.tencent.mobileqq.guild.util.s.f("GuildGuestBottomLayout", "setColorMode invalid " + colorMode, new IllegalStateException());
                return;
            }
            setBackgroundColor(ie0.a.f().g(getContext(), R.color.qui_common_bg_middle_light, 1002));
            TextView textView2 = this.topTips;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topTips");
                textView2 = null;
            }
            textView2.setTypeface(Typeface.DEFAULT_BOLD);
            TextView textView3 = this.topTips;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topTips");
                textView3 = null;
            }
            textView3.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1002));
            TextView textView4 = this.bottomTips;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTips");
            } else {
                textView = textView4;
            }
            textView.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_secondary_light, 1002));
            a().setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_brand_standard, 1002));
            a().setBackground(GuildUIUtils.f235378a.l(ie0.a.f().g(getContext(), R.color.qui_common_fill_standard_primary, 1002), ColorUtils.compositeColors(ie0.a.f().g(getContext(), R.color.qui_common_overlay_light, 1002), ie0.a.f().g(getContext(), R.color.qui_common_fill_standard_primary, 1002)), 100.0f));
            return;
        }
        setBackgroundResource(R.drawable.guild_guest_bottom_layout_bg);
        TextView textView5 = this.topTips;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTips");
            textView5 = null;
        }
        if (QQTheme.isNowThemeIsNight()) {
            typeface = Typeface.DEFAULT_BOLD;
        } else {
            typeface = Typeface.DEFAULT;
        }
        textView5.setTypeface(typeface);
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        TextView textView6 = this.topTips;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTips");
            textView6 = null;
        }
        guildUIUtils.b(textView6, R.color.qui_common_text_primary);
        TextView textView7 = this.bottomTips;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTips");
        } else {
            textView = textView7;
        }
        guildUIUtils.b(textView, R.color.qui_common_text_secondary_light);
        guildUIUtils.b(a(), R.color.qui_common_brand_standard);
        a().setBackgroundResource(R.drawable.guild_bottom_join_button_selector);
    }

    public final void setJoinButton(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.joinButton = textView;
    }

    public final void setJoinButtonClickListener(@Nullable View.OnClickListener onClickListener) {
        this.joinButtonClickListener = onClickListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildGuestBottomLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildGuestBottomLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGuestBottomLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.guild.api.j.f214633y1);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026e.GuildGuestBottomLayout)");
        this.colorMode = obtainStyledAttributes.getInteger(com.tencent.mobileqq.guild.api.j.f214640z1, 0);
        obtainStyledAttributes.recycle();
        c(context);
    }
}
