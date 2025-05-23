package com.tencent.mobileqq.guild.setting.channeldetails;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\u0001\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00016B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\bH\u0007J\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\bJ\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\bJ\u001e\u0010&\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\b2\u0006\u0010%\u001a\u00020$J\u0016\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\bJ\u0016\u0010,\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\bJ\u0016\u0010/\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\bJ\u0016\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\bj\u0002\b7j\u0002\b8\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewStyle;", "", "Landroid/widget/ImageView;", "iconView", "", "drawableResId", "", "bindIconView", "Landroid/widget/TextView;", "textView", "bindIconTextView", "Landroid/content/Context;", "context", "getIconPrimaryNightColor", "tokenResId", "themeId", "getQuiColor", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "splitView", "setBackground", "upTopIcon", "upTopTextView", "bindUpTopIcon", "msgNotifyType", "guildDetailNoticeIcon", "noticeText", "setGuildDetailNoticeIcon", "guildDetailAudioIcon", "audioIconTextView", "setGuildDetailAudioIcon", "robotIconView", "robotTextView", "bindRobotIcon", "guildDetailSubscribeIcon", "subscribeTextView", "", "isSubscribe", "setGuildDetailSubscribeIcon", "summonIcon", "summonTextView", "bindSummonIcon", "shareIcon", ThirdPartyMiniPageProxy.KEY_SHARE_TEXT, "bindShareIcon", "settingIcon", "settingIconText", "bindSettingIcon", "jubaoIcon", "jubaoTextView", "bindJuBaoIcon", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "STYLE_SKIN", "STYLE_NIGHT", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public enum GuildChannelDetailHeadViewStyle {
    STYLE_SKIN,
    STYLE_NIGHT;


    @NotNull
    private static final String TAG = "Guild.MF.End.GuildChannelDetailHeadViewStyle";

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f233345a;

        static {
            int[] iArr = new int[GuildChannelDetailHeadViewStyle.values().length];
            try {
                iArr[GuildChannelDetailHeadViewStyle.STYLE_SKIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildChannelDetailHeadViewStyle.STYLE_NIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f233345a = iArr;
        }
    }

    private final void bindIconTextView(TextView textView) {
        int i3 = b.f233345a[ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                textView.setTextColor(textView.getResources().getColor(R.color.f158017al3));
            }
        } else {
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "textView.context");
            textView.setTextColor(getQuiColor(context, R.color.qui_common_text_primary, 1000));
        }
    }

    private final void bindIconView(ImageView iconView, int drawableResId) {
        int i3 = b.f233345a[ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                Context context = iconView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "iconView.context");
                Context context2 = iconView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "iconView.context");
                iconView.setImageDrawable(GuildUIUtils.y(context, drawableResId, getIconPrimaryNightColor(context2)));
                return;
            }
            return;
        }
        Context context3 = iconView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "iconView.context");
        iconView.setImageDrawable(GuildUIUtils.w(context3, drawableResId, Integer.valueOf(R.color.qui_common_icon_primary)));
    }

    private final int getIconPrimaryNightColor(Context context) {
        return getQuiColor(context, R.color.qui_common_icon_primary, 1002);
    }

    private final int getQuiColor(Context context, int tokenResId, int themeId) {
        return ie0.a.f().g(context, tokenResId, themeId);
    }

    public final void bindJuBaoIcon(@NotNull ImageView jubaoIcon, @NotNull TextView jubaoTextView) {
        Intrinsics.checkNotNullParameter(jubaoIcon, "jubaoIcon");
        Intrinsics.checkNotNullParameter(jubaoTextView, "jubaoTextView");
        bindIconView(jubaoIcon, R.drawable.guild_detail_report_icon);
        bindIconTextView(jubaoTextView);
    }

    public final void bindRobotIcon(@NotNull ImageView robotIconView, @NotNull TextView robotTextView) {
        Intrinsics.checkNotNullParameter(robotIconView, "robotIconView");
        Intrinsics.checkNotNullParameter(robotTextView, "robotTextView");
        bindIconView(robotIconView, R.drawable.guild_bot_icon);
        bindIconTextView(robotTextView);
    }

    public final void bindSettingIcon(@NotNull ImageView settingIcon, @NotNull TextView settingIconText) {
        Intrinsics.checkNotNullParameter(settingIcon, "settingIcon");
        Intrinsics.checkNotNullParameter(settingIconText, "settingIconText");
        bindIconView(settingIcon, R.drawable.guild_detail_setting_icon);
        bindIconTextView(settingIconText);
    }

    public final void bindShareIcon(@NotNull ImageView shareIcon, @NotNull TextView shareText) {
        Intrinsics.checkNotNullParameter(shareIcon, "shareIcon");
        Intrinsics.checkNotNullParameter(shareText, "shareText");
        bindIconView(shareIcon, R.drawable.guild_channel_detail_share_icon);
        bindIconTextView(shareText);
    }

    public final void bindSummonIcon(@NotNull ImageView summonIcon, @NotNull TextView summonTextView) {
        Intrinsics.checkNotNullParameter(summonIcon, "summonIcon");
        Intrinsics.checkNotNullParameter(summonTextView, "summonTextView");
        bindIconView(summonIcon, R.drawable.guild_detail_summon_icon);
        bindIconTextView(summonTextView);
    }

    public final void bindUpTopIcon(@NotNull ImageView upTopIcon, @NotNull TextView upTopTextView, int drawableResId) {
        Intrinsics.checkNotNullParameter(upTopIcon, "upTopIcon");
        Intrinsics.checkNotNullParameter(upTopTextView, "upTopTextView");
        bindIconView(upTopIcon, drawableResId);
        bindIconTextView(upTopTextView);
    }

    public final void setBackground(@NotNull View rootView, @NotNull View splitView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(splitView, "splitView");
        int i3 = b.f233345a[ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                Context context = rootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                rootView.setBackgroundColor(getQuiColor(context, R.color.qui_common_fill_light_primary, 1002));
                Context context2 = rootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
                splitView.setBackgroundColor(getQuiColor(context2, R.color.qui_common_fill_standard_primary, 1002));
                return;
            }
            return;
        }
        rootView.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
        splitView.setBackgroundResource(R.drawable.guild_schedule_fill_standard_primary);
    }

    public final void setGuildDetailAudioIcon(@NotNull ImageView guildDetailAudioIcon, @NotNull TextView audioIconTextView) {
        Intrinsics.checkNotNullParameter(guildDetailAudioIcon, "guildDetailAudioIcon");
        Intrinsics.checkNotNullParameter(audioIconTextView, "audioIconTextView");
        int k3 = bw.k();
        int i3 = b.f233345a[ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                if (k3 == 1 && MediaChannelCore.INSTANCE.a().y0().q() == 1) {
                    Context context = guildDetailAudioIcon.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "guildDetailAudioIcon.context");
                    Context context2 = guildDetailAudioIcon.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "guildDetailAudioIcon.context");
                    guildDetailAudioIcon.setBackground(GuildUIUtils.y(context, R.drawable.guild_detail_audio_speed_mode_bg, getIconPrimaryNightColor(context2)));
                    guildDetailAudioIcon.setImageResource(R.drawable.guild_detail_subscribed_icon_top);
                } else {
                    guildDetailAudioIcon.setBackground(null);
                    Context context3 = guildDetailAudioIcon.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "guildDetailAudioIcon.context");
                    Context context4 = guildDetailAudioIcon.getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "guildDetailAudioIcon.context");
                    guildDetailAudioIcon.setImageDrawable(GuildUIUtils.y(context3, R.drawable.guild_audio_default_mode, getIconPrimaryNightColor(context4)));
                }
            }
        } else if (k3 == 1 && MediaChannelCore.INSTANCE.a().y0().q() == 1) {
            Context context5 = guildDetailAudioIcon.getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "guildDetailAudioIcon.context");
            guildDetailAudioIcon.setBackground(GuildUIUtils.w(context5, R.drawable.guild_detail_audio_speed_mode_bg, Integer.valueOf(R.color.qui_common_icon_primary)));
            guildDetailAudioIcon.setImageResource(R.drawable.guild_detail_subscribed_icon_top);
        } else {
            guildDetailAudioIcon.setBackground(null);
            Context context6 = guildDetailAudioIcon.getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "guildDetailAudioIcon.context");
            guildDetailAudioIcon.setImageDrawable(GuildUIUtils.w(context6, R.drawable.guild_audio_default_mode, Integer.valueOf(R.color.qui_common_icon_primary)));
        }
        bindIconTextView(audioIconTextView);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void setGuildDetailNoticeIcon(int msgNotifyType, @NotNull ImageView guildDetailNoticeIcon, @NotNull TextView noticeText) {
        Intrinsics.checkNotNullParameter(guildDetailNoticeIcon, "guildDetailNoticeIcon");
        Intrinsics.checkNotNullParameter(noticeText, "noticeText");
        int i3 = b.f233345a[ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                if (msgNotifyType != 1) {
                    if (msgNotifyType != 2) {
                        if (msgNotifyType != 3) {
                            QLog.e(TAG, 1, "invalid notification type");
                            Context context = guildDetailNoticeIcon.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "guildDetailNoticeIcon.context");
                            Context context2 = guildDetailNoticeIcon.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "guildDetailNoticeIcon.context");
                            guildDetailNoticeIcon.setImageDrawable(GuildUIUtils.y(context, R.drawable.guild_detail_notice_on_icon, getIconPrimaryNightColor(context2)));
                        } else {
                            Context context3 = guildDetailNoticeIcon.getContext();
                            Intrinsics.checkNotNullExpressionValue(context3, "guildDetailNoticeIcon.context");
                            Context context4 = guildDetailNoticeIcon.getContext();
                            Intrinsics.checkNotNullExpressionValue(context4, "guildDetailNoticeIcon.context");
                            guildDetailNoticeIcon.setBackground(GuildUIUtils.y(context3, R.drawable.guild_detail_notice_off_icon_bg, getIconPrimaryNightColor(context4)));
                            guildDetailNoticeIcon.setImageResource(R.drawable.guild_detail_notice_off_icon_top_line);
                        }
                    } else {
                        Context context5 = guildDetailNoticeIcon.getContext();
                        Intrinsics.checkNotNullExpressionValue(context5, "guildDetailNoticeIcon.context");
                        Context context6 = guildDetailNoticeIcon.getContext();
                        Intrinsics.checkNotNullExpressionValue(context6, "guildDetailNoticeIcon.context");
                        guildDetailNoticeIcon.setBackground(GuildUIUtils.y(context5, R.drawable.guild_detail_notice_only_at_icon_bg, getIconPrimaryNightColor(context6)));
                        guildDetailNoticeIcon.setImageResource(R.drawable.guild_detail_notice_only_at_icon_at);
                    }
                } else {
                    Context context7 = guildDetailNoticeIcon.getContext();
                    Intrinsics.checkNotNullExpressionValue(context7, "guildDetailNoticeIcon.context");
                    Context context8 = guildDetailNoticeIcon.getContext();
                    Intrinsics.checkNotNullExpressionValue(context8, "guildDetailNoticeIcon.context");
                    guildDetailNoticeIcon.setImageDrawable(GuildUIUtils.y(context7, R.drawable.guild_detail_notice_on_icon, getIconPrimaryNightColor(context8)));
                }
            }
        } else if (msgNotifyType != 1) {
            if (msgNotifyType != 2) {
                if (msgNotifyType != 3) {
                    QLog.e(TAG, 1, "invalid notification type");
                    Context context9 = guildDetailNoticeIcon.getContext();
                    Intrinsics.checkNotNullExpressionValue(context9, "guildDetailNoticeIcon.context");
                    guildDetailNoticeIcon.setImageDrawable(GuildUIUtils.w(context9, R.drawable.guild_detail_notice_on_icon, Integer.valueOf(R.color.qui_common_icon_primary)));
                } else {
                    Context context10 = guildDetailNoticeIcon.getContext();
                    Intrinsics.checkNotNullExpressionValue(context10, "guildDetailNoticeIcon.context");
                    guildDetailNoticeIcon.setBackground(GuildUIUtils.w(context10, R.drawable.guild_detail_notice_off_icon_bg, Integer.valueOf(R.color.qui_common_icon_primary)));
                    guildDetailNoticeIcon.setImageResource(R.drawable.guild_detail_notice_off_icon_top_line);
                }
            } else {
                Context context11 = guildDetailNoticeIcon.getContext();
                Intrinsics.checkNotNullExpressionValue(context11, "guildDetailNoticeIcon.context");
                guildDetailNoticeIcon.setBackground(GuildUIUtils.w(context11, R.drawable.guild_detail_notice_only_at_icon_bg, Integer.valueOf(R.color.qui_common_icon_primary)));
                guildDetailNoticeIcon.setImageResource(R.drawable.guild_detail_notice_only_at_icon_at);
            }
        } else {
            Context context12 = guildDetailNoticeIcon.getContext();
            Intrinsics.checkNotNullExpressionValue(context12, "guildDetailNoticeIcon.context");
            guildDetailNoticeIcon.setImageDrawable(GuildUIUtils.w(context12, R.drawable.guild_detail_notice_on_icon, Integer.valueOf(R.color.qui_common_icon_primary)));
        }
        bindIconTextView(noticeText);
    }

    public final void setGuildDetailSubscribeIcon(@NotNull ImageView guildDetailSubscribeIcon, @NotNull TextView subscribeTextView, boolean isSubscribe) {
        Intrinsics.checkNotNullParameter(guildDetailSubscribeIcon, "guildDetailSubscribeIcon");
        Intrinsics.checkNotNullParameter(subscribeTextView, "subscribeTextView");
        int i3 = b.f233345a[ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                if (isSubscribe) {
                    Context context = guildDetailSubscribeIcon.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "guildDetailSubscribeIcon.context");
                    Context context2 = guildDetailSubscribeIcon.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "guildDetailSubscribeIcon.context");
                    guildDetailSubscribeIcon.setBackground(GuildUIUtils.y(context, R.drawable.guild_detail_subscribed_icon_bg, getIconPrimaryNightColor(context2)));
                    guildDetailSubscribeIcon.setImageResource(R.drawable.guild_detail_subscribed_icon_top);
                } else {
                    guildDetailSubscribeIcon.setBackground(null);
                    Context context3 = guildDetailSubscribeIcon.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "guildDetailSubscribeIcon.context");
                    Context context4 = guildDetailSubscribeIcon.getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "guildDetailSubscribeIcon.context");
                    guildDetailSubscribeIcon.setImageDrawable(GuildUIUtils.y(context3, R.drawable.guild_detail_subscribe_icon, getIconPrimaryNightColor(context4)));
                }
            }
        } else if (isSubscribe) {
            Context context5 = guildDetailSubscribeIcon.getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "guildDetailSubscribeIcon.context");
            guildDetailSubscribeIcon.setBackground(GuildUIUtils.w(context5, R.drawable.guild_detail_subscribed_icon_bg, Integer.valueOf(R.color.qui_common_icon_primary)));
            guildDetailSubscribeIcon.setImageResource(R.drawable.guild_detail_subscribed_icon_top);
        } else {
            guildDetailSubscribeIcon.setBackground(null);
            Context context6 = guildDetailSubscribeIcon.getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "guildDetailSubscribeIcon.context");
            guildDetailSubscribeIcon.setImageDrawable(GuildUIUtils.w(context6, R.drawable.guild_detail_subscribe_icon, Integer.valueOf(R.color.qui_common_icon_primary)));
        }
        bindIconTextView(subscribeTextView);
    }
}
