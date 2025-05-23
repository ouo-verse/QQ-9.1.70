package mk1;

import com.tencent.mobileqq.guild.feed.gallery.data.GuildGalleryCommentPanelParams;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "c", "", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {
    @NotNull
    public static final String a(@NotNull GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(guildFeedGalleryInitBean, "<this>");
        HashMap<String, Serializable> attrs = guildFeedGalleryInitBean.getAttrs();
        String str = null;
        if (attrs != null) {
            obj = (Serializable) attrs.get(JumpGuildParam.EXTRA_KEY_TRACE_ID);
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String traceId = guildFeedGalleryInitBean.getTraceId();
            if (traceId == null) {
                return "";
            }
            return traceId;
        }
        return str;
    }

    @NotNull
    public static final GuildGalleryCommentPanelParams b(@NotNull GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(guildFeedGalleryInitBean, "<this>");
        GuildGalleryCommentPanelParams guildGalleryCommentPanelParams = new GuildGalleryCommentPanelParams();
        String feedId = guildFeedGalleryInitBean.getFeedId();
        Intrinsics.checkNotNullExpressionValue(feedId, "this@transToCommentPanelInfo.feedId");
        guildGalleryCommentPanelParams.setFeedId(feedId);
        String guildId = guildFeedGalleryInitBean.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "this@transToCommentPanelInfo.guildId");
        guildGalleryCommentPanelParams.setGuildId(guildId);
        String channelId = guildFeedGalleryInitBean.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "this@transToCommentPanelInfo.channelId");
        guildGalleryCommentPanelParams.setChannelId(channelId);
        guildGalleryCommentPanelParams.setCommentCount(guildFeedGalleryInitBean.getFeed().getCommentCount());
        String str2 = guildFeedGalleryInitBean.getFeed().channelInfo.sign.joinGuildSig;
        Intrinsics.checkNotNullExpressionValue(str2, "this@transToCommentPanel\u2026nelInfo.sign.joinGuildSig");
        guildGalleryCommentPanelParams.setJoinGuildSig(str2);
        String posterId = guildFeedGalleryInitBean.getPosterId();
        Intrinsics.checkNotNullExpressionValue(posterId, "this@transToCommentPanelInfo.posterId");
        guildGalleryCommentPanelParams.setPosterId(posterId);
        guildGalleryCommentPanelParams.setCreatedTime(guildFeedGalleryInitBean.getFeed().createTime);
        guildGalleryCommentPanelParams.setLastModifiedTime(guildFeedGalleryInitBean.getFeed().meta.lastModifiedTime);
        guildGalleryCommentPanelParams.setImmersiveSource(guildFeedGalleryInitBean.getImmersiveSource());
        guildGalleryCommentPanelParams.setTraceId(a(guildFeedGalleryInitBean));
        if (guildFeedGalleryInitBean.getFeed().getAllowFeedComment() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        guildGalleryCommentPanelParams.setAllowComment(z16);
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        if (iGPSService != null) {
            str = iGPSService.getSelfTinyId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "QQGuildUtil.runtimeServi\u2026ss.java)?.selfTinyId?: \"\"");
        }
        guildGalleryCommentPanelParams.setPosterSelf(Intrinsics.areEqual(guildFeedGalleryInitBean.getFeed().poster.idd, str));
        return guildGalleryCommentPanelParams;
    }

    @NotNull
    public static final GuildGalleryCommentPanelParams c(@NotNull GProStFeed gProStFeed) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
        GuildGalleryCommentPanelParams guildGalleryCommentPanelParams = new GuildGalleryCommentPanelParams();
        String str2 = gProStFeed.idd;
        Intrinsics.checkNotNullExpressionValue(str2, "this@transToCommentPanelInfo.idd");
        guildGalleryCommentPanelParams.setFeedId(str2);
        guildGalleryCommentPanelParams.setGuildId(String.valueOf(gProStFeed.channelInfo.sign.guildId));
        guildGalleryCommentPanelParams.setChannelId(String.valueOf(gProStFeed.channelInfo.sign.channelId));
        guildGalleryCommentPanelParams.setCommentCount(gProStFeed.getCommentCount());
        String str3 = gProStFeed.channelInfo.sign.joinGuildSig;
        Intrinsics.checkNotNullExpressionValue(str3, "this@transToCommentPanel\u2026nelInfo.sign.joinGuildSig");
        guildGalleryCommentPanelParams.setJoinGuildSig(str3);
        guildGalleryCommentPanelParams.setPosterId(gProStFeed.poster.idd.toString());
        guildGalleryCommentPanelParams.setCreatedTime(gProStFeed.createTime);
        guildGalleryCommentPanelParams.setLastModifiedTime(gProStFeed.meta.lastModifiedTime);
        guildGalleryCommentPanelParams.setImmersiveSource(6);
        String str4 = "";
        guildGalleryCommentPanelParams.setTraceId("");
        if (gProStFeed.getAllowFeedComment() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        guildGalleryCommentPanelParams.setAllowComment(z16);
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        if (iGPSService != null) {
            str = iGPSService.getSelfTinyId();
        } else {
            str = null;
        }
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(str, "QQGuildUtil.runtimeServi\u2026s.java)?.selfTinyId ?: \"\"");
            str4 = str;
        }
        guildGalleryCommentPanelParams.setPosterSelf(Intrinsics.areEqual(gProStFeed.poster.idd, str4));
        return guildGalleryCommentPanelParams;
    }
}
