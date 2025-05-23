package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.feed.feedsquare.data.SectionInfo;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.part.GuildFeedGalleryPreloadPart;
import com.tencent.mobileqq.guild.feed.util.am;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r12.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J!\u0010\u001d\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001d\u0010\u001eJ(\u0010#\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 J.\u0010,\u001a\u00020+2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0006\u0010&\u001a\u00020\u00112\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/j;", "", "Lcom/tencent/mobileqq/guild/feed/adapter/n;", "mixedMediaData", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "b", "Landroid/widget/ImageView;", "imageView", "", "url", "", "g", "guildId", "", "f", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "channelInfo", "", "tabType", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "j", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "model", "d", "", "allMuteExpiredTime", "selfMuteExpiredTime", "e", "(Ljava/lang/Long;Ljava/lang/Long;)Ljava/lang/String;", "verifyUrl", "", "tipText", "jumpText", tl.h.F, "", "mediaList", "currentIndex", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "sourceInitBean", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "c", "Ljava/text/DecimalFormat;", "Ljava/text/DecimalFormat;", "mDecimalFormat", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f219338a = new j();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final DecimalFormat mDecimalFormat = new DecimalFormat("#.#");

    j() {
    }

    private final GProStImage b(com.tencent.mobileqq.guild.feed.adapter.n mixedMediaData) {
        if (mixedMediaData.e() == 1) {
            return mixedMediaData.c();
        }
        if (mixedMediaData.e() == 2) {
            return mixedMediaData.d().cover;
        }
        return null;
    }

    private final void g(ImageView imageView, String url) {
        BitmapDrawable bitmapDrawable;
        Drawable drawable = imageView.getDrawable();
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmapDrawable = (BitmapDrawable) drawable;
        } else {
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            bitmap = bitmapDrawable.getBitmap();
        }
        GuildFeedGalleryPreloadPart.J9(com.tencent.mobileqq.guild.picload.e.d(url), bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ch.i1(QBaseActivity.sTopActivity, str);
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final GuildFeedGalleryInitBean c(@NotNull List<? extends com.tencent.mobileqq.guild.feed.adapter.n> mediaList, int currentIndex, @NotNull GuildFeedBaseInitBean sourceInitBean, @Nullable View view) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(sourceInitBean, "sourceInitBean");
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = new GuildFeedGalleryInitBean();
        guildFeedGalleryInitBean.setRichMediaDataList(am.d(mediaList, "pg_channel_forum_page")).setEnterPos(currentIndex);
        TransitionBean transitionBean = new TransitionBean();
        transitionBean.setEnterViewRect(view);
        GProStImage b16 = b(mediaList.get(currentIndex));
        if (b16 != null) {
            transitionBean.setStImage(bm.f(mediaList.get(currentIndex)), b16.width, b16.height);
            guildFeedGalleryInitBean.setTransitionBean(transitionBean);
            transitionBean.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        guildFeedGalleryInitBean.setFromPage(2);
        guildFeedGalleryInitBean.setBusinessType(sourceInitBean.getBusinessType());
        if (sourceInitBean.getBusinessType() == 7) {
            guildFeedGalleryInitBean.setTroopUin(sourceInitBean.getTroopUin());
            guildFeedGalleryInitBean.setTroopRole(sourceInitBean.getTroopRole());
            guildFeedGalleryInitBean.setChannelId(sourceInitBean.getChannelId());
        }
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        } else {
            imageView = null;
        }
        if (imageView != null) {
            j jVar = f219338a;
            String b17 = mediaList.get(currentIndex).b();
            Intrinsics.checkNotNullExpressionValue(b17, "mediaList[currentIndex].picUrl");
            jVar.g(imageView, b17);
        }
        guildFeedGalleryInitBean.setJoinInfoParam(sourceInitBean.getJoinInfoParam());
        return guildFeedGalleryInitBean;
    }

    @NotNull
    public final String d(@NotNull Context context, @NotNull com.tencent.mobileqq.guild.feed.viewmodel.k model) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        return e(model.L1().getValue(), model.T1().getValue());
    }

    @NotNull
    public final String e(@Nullable Long allMuteExpiredTime, @Nullable Long selfMuteExpiredTime) {
        long serverTime = NetConnInfoCenter.getServerTime();
        if (allMuteExpiredTime != null && allMuteExpiredTime.longValue() > serverTime) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f1506215h);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_mute_user_hint_format)");
            String format = String.format(qqStr, Arrays.copyOf(new Object[]{com.tencent.mobileqq.guild.setting.mute.c.B(allMuteExpiredTime)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        if (selfMuteExpiredTime != null && selfMuteExpiredTime.longValue() > serverTime) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String qqStr2 = HardCodeUtil.qqStr(R.string.f158151ou);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(com.tencent.mobile\u2026er_mute_user_hint_format)");
            String format2 = String.format(qqStr2, Arrays.copyOf(new Object[]{com.tencent.mobileqq.guild.setting.mute.c.G(selfMuteExpiredTime)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        String qqStr3 = HardCodeUtil.qqStr(R.string.f145470rk);
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.guild_feed_square_can_not_publish)");
        return qqStr3;
    }

    public final boolean f(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        IGProGuildInfo L = ch.L(guildId);
        if (L != null && L.isMovePostSection() && !L.isGroupGuild()) {
            return true;
        }
        return false;
    }

    public final void h(@NotNull Context context, @Nullable final String verifyUrl, @NotNull CharSequence tipText, @NotNull CharSequence jumpText) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tipText, "tipText");
        Intrinsics.checkNotNullParameter(jumpText, "jumpText");
        if (verifyUrl != null && verifyUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            yl1.n.A(0, tipText);
        } else {
            r12.a.a(context, new a.C11105a(tipText, jumpText, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.i(verifyUrl, view);
                }
            })).b();
        }
    }

    @NotNull
    public final com.tencent.mobileqq.guild.feed.feedsquare.data.l j(@NotNull IGProChannel channelInfo, int tabType) {
        String sectionName;
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        if (tabType != 4) {
            if (tabType != 5) {
                sectionName = channelInfo.getChannelName();
            } else {
                sectionName = MobileQQ.sMobileQQ.getString(R.string.f145420rf);
            }
        } else {
            sectionName = MobileQQ.sMobileQQ.getString(R.string.f145440rh);
        }
        String valueOf = String.valueOf(channelInfo.getChannelId());
        String valueOf2 = String.valueOf(channelInfo.getGuildId());
        Intrinsics.checkNotNullExpressionValue(sectionName, "sectionName");
        return new com.tencent.mobileqq.guild.feed.feedsquare.data.l(new SectionInfo(valueOf, valueOf2, sectionName, tabType));
    }
}
