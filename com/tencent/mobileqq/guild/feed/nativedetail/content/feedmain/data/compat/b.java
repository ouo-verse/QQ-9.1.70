package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat;

import com.google.gson.FieldNamingStrategy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelUserInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCommThirdShareInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCommThirdVideoInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedMetaData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRichTextContentCount;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoleGroupInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextAtContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextGroupContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextTencentDocsContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextTopicContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.lang.reflect.Field;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R:\u0010\r\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00060\u00068\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00068\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/compat/b;", "Lcom/google/gson/FieldNamingStrategy;", "Ljava/lang/reflect/Field;", "field", "", "translateName", "", "Ljava/lang/Class;", "", "e", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "keyAliasMaps", "f", "a", "globalKeyAliasMap", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements FieldNamingStrategy {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final b f221028d = new b();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Class<? extends Object>, Map<String, String>> keyAliasMaps;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> globalKeyAliasMap;

    static {
        Map mapOf;
        Map mapOf2;
        Map mapOf3;
        Map mapOf4;
        Map mapOf5;
        Map mapOf6;
        Map mapOf7;
        Map mapOf8;
        Map mapOf9;
        Map mapOf10;
        Map mapOf11;
        Map mapOf12;
        Map mapOf13;
        Map mapOf14;
        Map mapOf15;
        Map mapOf16;
        Map mapOf17;
        Map mapOf18;
        Map<Class<? extends Object>, Map<String, String>> mapOf19;
        Map<String, String> mapOf20;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("opMaskList", "opMask"), TuplesKt.to("updateTime", "update_time"), TuplesKt.to("feedType", QCircleFolderFunnelCollect.EXTRA_FEED_TYPE), TuplesKt.to("extInfoList", "extInfo"), TuplesKt.to("feedSourceType", "feed_source_type"), TuplesKt.to("vecCommentList", "vecComment"), TuplesKt.to("recomInfo", "recom_info"), TuplesKt.to("topInfo", "top_info"), TuplesKt.to("totalLike", "total_like"), TuplesKt.to("groupCode", "group_code"), TuplesKt.to("recommendChannels", "recommend_channels"), TuplesKt.to("thirdBar", "third_bar"), TuplesKt.to("mediaLockCount", "media_lock_count"), TuplesKt.to("feedContentType", "feed_content_type"), TuplesKt.to("taskContent", "task_content"), TuplesKt.to("clientTaskId", "client_task_id"));
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("vecVideoUrlList", "vecVideoUrl"), TuplesKt.to("displayIndex", "display_index"), TuplesKt.to("patternId", "pattern_id"));
        mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("vecImageUrlList", "vecImageUrl"), TuplesKt.to("displayIndex", "display_index"), TuplesKt.to("patternId", "pattern_id"), TuplesKt.to("origSize", "orig_size"), TuplesKt.to("isOrig", "is_orig"), TuplesKt.to(NodeProps.CUSTOM_PROP_ISGIF, "is_gif"));
        mapOf4 = MapsKt__MapsKt.mapOf(TuplesKt.to("patternId", "pattern_id"), TuplesKt.to("atContent", "at_content"), TuplesKt.to("textContent", "text_content"), TuplesKt.to("urlContent", "url_content"), TuplesKt.to("emojiContent", "emoji_content"), TuplesKt.to("channelContent", "channel_content"), TuplesKt.to("guildContent", "guild_content"), TuplesKt.to("iconContent", "icon_content"), TuplesKt.to("topicContent", "topic_content"), TuplesKt.to("groupContent", "group_content"));
        mapOf5 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("roleGroupId", "role_group_id"));
        mapOf6 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("roleId", "role_id"));
        mapOf7 = MapsKt__MapsKt.mapOf(TuplesKt.to("playUrl", "play_url"), TuplesKt.to("thirdVideoInfo", "third_video_info"), TuplesKt.to("tencentDocsContent", "tencent_docs_content"), TuplesKt.to("thirdShareInfo", "third_share_info"), TuplesKt.to("iconType", "icon_type"));
        c.a aVar = c.a.f220905a;
        mapOf8 = MapsKt__MapsKt.mapOf(TuplesKt.to("imageUrl", "image_url"), TuplesKt.to("redirectUrl", "redirect_url"), TuplesKt.to("stringAbstract", "abstract"));
        c.b bVar = c.b.f220906a;
        mapOf9 = MapsKt__MapsKt.mapOf(TuplesKt.to(WadlProxyConsts.KEY_JUMP_URL, "jump_url"), TuplesKt.to("pcJumpUrl", "pc_jump_url"));
        mapOf10 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("platformName", "platform_name"));
        mapOf11 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("lastModifiedTime", "last_modified_time"));
        mapOf12 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("textWord", "text_word"));
        mapOf13 = MapsKt__MapsKt.mapOf(TuplesKt.to("iconUrl", "icon_url"), TuplesKt.to("privateType", "private_type"), TuplesKt.to("guildName", "guild_name"), TuplesKt.to("hotIcon", "hot_icon"), TuplesKt.to("hotIndex", "hot_index"), TuplesKt.to("movePostSection", "move_post_section"), TuplesKt.to("isSquare", "is_square"));
        mapOf14 = MapsKt__MapsKt.mapOf(TuplesKt.to("guildId", "guild_id"), TuplesKt.to("channelId", "channel_id"), TuplesKt.to("channelType", "channel_type"));
        mapOf15 = MapsKt__MapsKt.mapOf(TuplesKt.to("channelUserInfo", "channel_user_info"), TuplesKt.to("nickFlag", "nick_flag"), TuplesKt.to("manageTag", "manage_tag"), TuplesKt.to("personalMedal", "personal_medal"));
        mapOf16 = MapsKt__MapsKt.mapOf(TuplesKt.to("roleGroups", "role_groups"), TuplesKt.to("clientIdentity", "client_identity"), TuplesKt.to("memberType", "member_type"), TuplesKt.to("clientIdentityBytes", "client_identity_bytes"), TuplesKt.to("clientIdentityBytesJson", "client_identity_bytes_json"), TuplesKt.to("voiceLiveInfo", "voice_live_info"), TuplesKt.to("roleType", "role_type"));
        mapOf17 = MapsKt__MapsKt.mapOf(TuplesKt.to("topicId", "topic_id"), TuplesKt.to("topicName", "topic_name"), TuplesKt.to("showStatus", "show_status"));
        mapOf18 = MapsKt__MapsKt.mapOf(TuplesKt.to("groupCode", "group_code"), TuplesKt.to("groupName", "group_name"), TuplesKt.to("groupMemberNum", "group_member_num"), TuplesKt.to("groupAvatar", "group_avatar"), TuplesKt.to("groupJoinAuth", "group_join_auth"));
        mapOf19 = MapsKt__MapsKt.mapOf(TuplesKt.to(GProStFeed.class, mapOf), TuplesKt.to(GProStVideo.class, mapOf2), TuplesKt.to(GProStImage.class, mapOf3), TuplesKt.to(GProStRichTextContent.class, mapOf4), TuplesKt.to(GProStRichTextAtContent.class, mapOf5), TuplesKt.to(GProRoleGroupInfo.class, mapOf6), TuplesKt.to(GProStRichTextURLContent.class, mapOf7), TuplesKt.to(GProCommThirdShareInfo.class, mapOf8), TuplesKt.to(GProCommThirdVideoInfo.class, mapOf9), TuplesKt.to(GProStRichTextTencentDocsContent.class, mapOf10), TuplesKt.to(GProFeedMetaData.class, mapOf11), TuplesKt.to(GProRichTextContentCount.class, mapOf12), TuplesKt.to(GProStChannelInfo.class, mapOf13), TuplesKt.to(GProStChannelSign.class, mapOf14), TuplesKt.to(GProStUser.class, mapOf15), TuplesKt.to(GProChannelUserInfo.class, mapOf16), TuplesKt.to(GProStRichTextTopicContent.class, mapOf17), TuplesKt.to(GProStRichTextGroupContent.class, mapOf18));
        keyAliasMaps = mapOf19;
        mapOf20 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("idd", "id"));
        globalKeyAliasMap = mapOf20;
    }

    b() {
    }

    @NotNull
    public final Map<String, String> a() {
        return globalKeyAliasMap;
    }

    @NotNull
    public final Map<Class<? extends Object>, Map<String, String>> b() {
        return keyAliasMaps;
    }

    @Override // com.google.gson.FieldNamingStrategy
    @NotNull
    public String translateName(@NotNull Field field) {
        String str;
        Intrinsics.checkNotNullParameter(field, "field");
        String fieldName = field.getName();
        String str2 = globalKeyAliasMap.get(fieldName);
        if (str2 == null) {
            Map<String, String> map = keyAliasMaps.get(field.getDeclaringClass());
            if (map != null) {
                str = map.get(fieldName);
            } else {
                str = null;
            }
            if (str == null) {
                Intrinsics.checkNotNullExpressionValue(fieldName, "fieldName");
                return fieldName;
            }
            return str;
        }
        return str2;
    }
}
