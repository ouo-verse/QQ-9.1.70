package gi1;

import android.util.Log;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCoverInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLiveChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendVoiceChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0003J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0002\u00a8\u0006%"}, d2 = {"Lgi1/j;", "", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendItem;", "activeChannels", "", "traceId", "Lgi1/a;", "e", "activeChannel", "d", "Lgi1/d;", "g", "Lgi1/c;", "k", "Lgi1/e;", tl.h.F, "Lgi1/g;", "j", "f", "Lgi1/f;", "i", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "gproUserInfoList", "Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView$a;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendVoiceChannel;", "voiceChannel", "c", "", "itemType", "Lgi1/h;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f402155a = new j();

    j() {
    }

    private final ChannelStatusInfo a(int itemType) {
        if (itemType != 5) {
            if (itemType != 11) {
                if (itemType != 12) {
                    String r16 = QQGuildUIUtil.r(R.string.f157771nt);
                    Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild\u2026_card_channel_hint_audio)");
                    return new ChannelStatusInfo(true, R.string.f1487310d, r16);
                }
                String r17 = QQGuildUIUtil.r(R.string.f157811nx);
                Intrinsics.checkNotNullExpressionValue(r17, "getString(R.string.guild\u2026annel_hint_play_together)");
                return new ChannelStatusInfo(true, R.string.f1487210c, r17);
            }
            String r18 = QQGuildUIUtil.r(R.string.f157801nw);
            Intrinsics.checkNotNullExpressionValue(r18, "getString(R.string.guild\u2026_card_channel_hint_music)");
            return new ChannelStatusInfo(true, R.string.f1487510f, r18);
        }
        String r19 = QQGuildUIUtil.r(R.string.f157791nv);
        Intrinsics.checkNotNullExpressionValue(r19, "getString(R.string.guild\u2026card_channel_hint_kaihei)");
        return new ChannelStatusInfo(true, R.string.f1487210c, r19);
    }

    private final List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> b(long guildId, List<? extends IGProUserInfo> gproUserInfoList) {
        boolean z16;
        List plus;
        List take;
        int collectionSizeOrDefault;
        List take2;
        int collectionSizeOrDefault2;
        List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> emptyList;
        List<? extends IGProUserInfo> list = gproUserInfoList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<? extends IGProUserInfo> list2 = gproUserInfoList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (!((IGProUserInfo) obj).isMuteSeat()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() >= 3) {
            take2 = CollectionsKt___CollectionsKt.take(arrayList, 3);
            List<IGProUserInfo> list3 = take2;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            for (IGProUserInfo iGProUserInfo : list3) {
                String valueOf = String.valueOf(guildId);
                String tinyId = iGProUserInfo.getTinyId();
                Intrinsics.checkNotNullExpressionValue(tinyId, "it.tinyId");
                String avatarMeta = iGProUserInfo.getAvatarMeta();
                Intrinsics.checkNotNullExpressionValue(avatarMeta, "it.avatarMeta");
                arrayList2.add(new GuildHomeActiveChannelMicAvatarView.AvatarInfo(valueOf, tinyId, avatarMeta, true));
            }
            return arrayList2;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list2) {
            if (((IGProUserInfo) obj2).isMuteSeat()) {
                arrayList3.add(obj2);
            }
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList3);
        take = CollectionsKt___CollectionsKt.take(plus, 3);
        List<IGProUserInfo> list4 = take;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        for (IGProUserInfo iGProUserInfo2 : list4) {
            String valueOf2 = String.valueOf(guildId);
            String tinyId2 = iGProUserInfo2.getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId2, "it.tinyId");
            String avatarMeta2 = iGProUserInfo2.getAvatarMeta();
            Intrinsics.checkNotNullExpressionValue(avatarMeta2, "it.avatarMeta");
            arrayList4.add(new GuildHomeActiveChannelMicAvatarView.AvatarInfo(valueOf2, tinyId2, avatarMeta2, !iGProUserInfo2.isMuteSeat()));
        }
        return arrayList4;
    }

    private final String c(IGProRecommendVoiceChannel voiceChannel) {
        ArrayList<IGProGuildThemeInfo> themeList = voiceChannel.getVoiceChannel().getAVChannelConfig().getThemeList();
        if (themeList == null) {
            return "";
        }
        for (IGProGuildThemeInfo iGProGuildThemeInfo : themeList) {
            if (iGProGuildThemeInfo.getThemeType() == 7) {
                if (voiceChannel.getVoiceChannel().getScreenShareUserInfo() != null) {
                    String sessionId = iGProGuildThemeInfo.getSessionId();
                    Intrinsics.checkNotNullExpressionValue(sessionId, "theme.sessionId");
                    return sessionId;
                }
            } else {
                String sessionId2 = iGProGuildThemeInfo.getSessionId();
                Intrinsics.checkNotNullExpressionValue(sessionId2, "theme.sessionId");
                return sessionId2;
            }
        }
        return "";
    }

    @JvmStatic
    private static final a d(IGProRecommendItem activeChannel, String traceId) {
        if (activeChannel.getTemplateType() == 1) {
            return f402155a.k(activeChannel, traceId);
        }
        int itemType = activeChannel.getItemType();
        if (itemType != 2) {
            if (itemType != 3) {
                if (itemType != 4) {
                    if (itemType != 5) {
                        if (itemType != 100) {
                            switch (itemType) {
                                case 9:
                                case 10:
                                    break;
                                case 11:
                                    return f402155a.f(activeChannel, traceId);
                                default:
                                    Logger.f235387a.d().w("HotLiveDataTransformer", 1, "transformCardData invalid type: " + activeChannel);
                                    return null;
                            }
                        }
                    } else {
                        return f402155a.j(activeChannel, traceId);
                    }
                } else {
                    return f402155a.i(activeChannel, traceId);
                }
            }
            return f402155a.h(activeChannel, traceId);
        }
        return f402155a.g(activeChannel, traceId);
    }

    @JvmStatic
    @NotNull
    public static final List<a> e(@NotNull List<? extends IGProRecommendItem> activeChannels, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(activeChannels, "activeChannels");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Logger.f235387a.d().i("HotLiveDataTransformer", 1, "transformCardDataList size: " + activeChannels.size() + ", traceId: " + traceId);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : activeChannels) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            IGProRecommendItem iGProRecommendItem = (IGProRecommendItem) obj;
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("HotLiveDataTransformer", i3 + MsgSummary.STR_COLON + iGProRecommendItem);
            }
            a d16 = d(iGProRecommendItem, traceId);
            if (d16 != null) {
                arrayList.add(d16);
            }
            i3 = i16;
        }
        return arrayList;
    }

    private final ChannelListenCardItemData f(IGProRecommendItem activeChannel, String traceId) {
        String valueOf;
        IAudioChannelMemberInfos voiceChannel = activeChannel.getVoiceChannel().getVoiceChannel();
        if (voiceChannel.getNoMemberMaxLimit() != 1 && voiceChannel.getChannelMemberMax() != 0) {
            valueOf = voiceChannel.getChannelMemberCount() + "/" + voiceChannel.getChannelMemberMax();
        } else if (voiceChannel.getChannelMemberCount() > 999) {
            valueOf = "999+";
        } else {
            valueOf = String.valueOf(voiceChannel.getChannelMemberCount());
        }
        String str = valueOf;
        long channelId = activeChannel.getChannelInfo().getChannelId();
        int channelType = activeChannel.getChannelInfo().getChannelType();
        String channelName = activeChannel.getChannelInfo().getChannelName();
        long guildId = activeChannel.getChannelInfo().getGuildId();
        String guildIcon = activeChannel.getChannelInfo().getGuildIcon();
        String a16 = lh1.a.f414590d.a(activeChannel.getVoiceChannel().getCover().getImageUrl());
        ChannelStatusInfo a17 = a(activeChannel.getItemType());
        String joinGuildSig = activeChannel.getChannelInfo().getJoinGuildSig();
        IGProRecommendVoiceChannel voiceChannel2 = activeChannel.getVoiceChannel();
        Intrinsics.checkNotNullExpressionValue(voiceChannel2, "activeChannel.voiceChannel");
        String c16 = c(voiceChannel2);
        List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> b16 = b(activeChannel.getChannelInfo().getGuildId(), activeChannel.getVoiceChannel().getVoiceChannel().getUserList());
        Intrinsics.checkNotNullExpressionValue(channelName, "channelName");
        Intrinsics.checkNotNullExpressionValue(joinGuildSig, "joinGuildSig");
        return new ChannelListenCardItemData(channelId, channelType, channelName, guildId, guildIcon, joinGuildSig, traceId, 4, c16, a16, a17, true, str, b16);
    }

    private final ChannelLiveCardItemData g(IGProRecommendItem activeChannel, String traceId) {
        String str;
        boolean z16;
        String str2;
        String str3;
        String str4;
        IGProRoomInfo roomInfo;
        IGProRoomInfo roomInfo2;
        String l3;
        IGProRoomInfo roomInfo3;
        IGProRecommendChannelInfo channelInfo = activeChannel.getChannelInfo();
        IGProRecommendLiveChannel recommendLiveChannel = activeChannel.getRecommendLiveChannel();
        IGProLiveRoomInfo liveChannel = recommendLiveChannel.getLiveChannel();
        String str5 = null;
        if (liveChannel != null && (roomInfo3 = liveChannel.getRoomInfo()) != null) {
            str = roomInfo3.getRoomName();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = channelInfo.getChannelName();
        }
        String channelName = str;
        long channelId = channelInfo.getChannelId();
        int channelType = channelInfo.getChannelType();
        long guildId = channelInfo.getGuildId();
        String guildIcon = activeChannel.getChannelInfo().getGuildIcon();
        lh1.a aVar = lh1.a.f414590d;
        IGProRecommendCoverInfo cover = recommendLiveChannel.getCover();
        if (cover != null) {
            str2 = cover.getImageUrl();
        } else {
            str2 = null;
        }
        String a16 = aVar.a(str2);
        IGProLiveRoomInfo liveChannel2 = recommendLiveChannel.getLiveChannel();
        if (liveChannel2 == null || (roomInfo2 = liveChannel2.getRoomInfo()) == null || (l3 = Long.valueOf(roomInfo2.getRoomId()).toString()) == null) {
            str3 = "";
        } else {
            str3 = l3;
        }
        IGProLiveRoomInfo liveChannel3 = recommendLiveChannel.getLiveChannel();
        if (liveChannel3 != null && (roomInfo = liveChannel3.getRoomInfo()) != null) {
            str5 = roomInfo.getRoomPv();
        }
        if (str5 == null) {
            str4 = "";
        } else {
            str4 = str5;
        }
        String joinGuildSig = channelInfo.getJoinGuildSig();
        List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> b16 = b(activeChannel.getChannelInfo().getGuildId(), activeChannel.getVoiceChannel().getVoiceChannel().getUserList());
        Intrinsics.checkNotNullExpressionValue(channelName, "channelName");
        Intrinsics.checkNotNullExpressionValue(joinGuildSig, "joinGuildSig");
        return new ChannelLiveCardItemData(channelId, channelType, channelName, guildId, guildIcon, joinGuildSig, traceId, str3, str4, a16, b16);
    }

    private final ChannelNormalMediaCardItemData h(IGProRecommendItem activeChannel, String traceId) {
        String valueOf;
        IAudioChannelMemberInfos voiceChannel = activeChannel.getVoiceChannel().getVoiceChannel();
        if (voiceChannel.getNoMemberMaxLimit() != 1 && voiceChannel.getChannelMemberMax() != 0) {
            valueOf = voiceChannel.getChannelMemberCount() + "/" + voiceChannel.getChannelMemberMax();
        } else if (voiceChannel.getChannelMemberCount() > 999) {
            valueOf = "999+";
        } else {
            valueOf = String.valueOf(voiceChannel.getChannelMemberCount());
        }
        String str = valueOf;
        long channelId = activeChannel.getChannelInfo().getChannelId();
        int channelType = activeChannel.getChannelInfo().getChannelType();
        String channelName = activeChannel.getChannelInfo().getChannelName();
        long guildId = activeChannel.getChannelInfo().getGuildId();
        String guildIcon = activeChannel.getChannelInfo().getGuildIcon();
        ChannelStatusInfo a16 = a(activeChannel.getItemType());
        String joinGuildSig = activeChannel.getChannelInfo().getJoinGuildSig();
        IGProRecommendVoiceChannel voiceChannel2 = activeChannel.getVoiceChannel();
        Intrinsics.checkNotNullExpressionValue(voiceChannel2, "activeChannel.voiceChannel");
        String c16 = c(voiceChannel2);
        List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> b16 = b(activeChannel.getChannelInfo().getGuildId(), activeChannel.getVoiceChannel().getVoiceChannel().getUserList());
        Intrinsics.checkNotNullExpressionValue(channelName, "channelName");
        Intrinsics.checkNotNullExpressionValue(joinGuildSig, "joinGuildSig");
        return new ChannelNormalMediaCardItemData(channelId, channelType, channelName, guildId, guildIcon, joinGuildSig, traceId, 0, c16, a16, str, b16, 128, null);
    }

    private final ChannelScreenShareCardItemData i(IGProRecommendItem activeChannel, String traceId) {
        long channelId = activeChannel.getChannelInfo().getChannelId();
        int channelType = activeChannel.getChannelInfo().getChannelType();
        String channelName = activeChannel.getChannelInfo().getChannelName();
        long guildId = activeChannel.getChannelInfo().getGuildId();
        String guildIcon = activeChannel.getChannelInfo().getGuildIcon();
        String a16 = lh1.a.f414590d.a(activeChannel.getVoiceChannel().getCover().getImageUrl());
        String streamUrl = activeChannel.getVoiceChannel().getCover().getStreamUrl();
        String valueOf = String.valueOf(activeChannel.getVoiceChannel().getVoiceChannel().getChannelMemberCount());
        String joinGuildSig = activeChannel.getChannelInfo().getJoinGuildSig();
        IGProRecommendVoiceChannel voiceChannel = activeChannel.getVoiceChannel();
        Intrinsics.checkNotNullExpressionValue(voiceChannel, "activeChannel.voiceChannel");
        String c16 = c(voiceChannel);
        List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> b16 = b(activeChannel.getChannelInfo().getGuildId(), activeChannel.getVoiceChannel().getVoiceChannel().getUserList());
        Intrinsics.checkNotNullExpressionValue(channelName, "channelName");
        Intrinsics.checkNotNullExpressionValue(joinGuildSig, "joinGuildSig");
        return new ChannelScreenShareCardItemData(channelId, channelType, channelName, guildId, guildIcon, joinGuildSig, traceId, 0, c16, valueOf, a16, streamUrl, b16, 128, null);
    }

    private final ChannelSmobaMediaCardItemData j(IGProRecommendItem activeChannel, String traceId) {
        String valueOf;
        String str;
        Object obj;
        if (activeChannel.getItemType() == 5) {
            ArrayList<IGProBusinessNode> businessList = activeChannel.getVoiceChannel().getVoiceChannel().getAVChannelConfig().getBusinessList();
            IGProVoiceSmobaGameRoomStateInfo iGProVoiceSmobaGameRoomStateInfo = null;
            if (businessList != null) {
                Iterator<T> it = businessList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        boolean z16 = true;
                        if (((IGProBusinessNode) obj).getNodeType() != 1) {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                IGProBusinessNode iGProBusinessNode = (IGProBusinessNode) obj;
                if (iGProBusinessNode != null) {
                    iGProVoiceSmobaGameRoomStateInfo = iGProBusinessNode.getRoomStateInfo();
                }
            }
            if (iGProVoiceSmobaGameRoomStateInfo != null && iGProVoiceSmobaGameRoomStateInfo.getGameInfo().getMaxNum() > 0) {
                if (iGProVoiceSmobaGameRoomStateInfo.getRoomState() == 3) {
                    str = "\u6e38\u620f\u4e2d";
                } else {
                    str = "\u7ec4\u961f\u4e2d";
                }
                valueOf = iGProVoiceSmobaGameRoomStateInfo.getGameInfo().getGameMode() + APLogFileUtil.SEPARATOR_LOG + str + iGProVoiceSmobaGameRoomStateInfo.getCurrentNum() + "/" + iGProVoiceSmobaGameRoomStateInfo.getGameInfo().getMaxNum();
            } else {
                valueOf = "\u738b\u8005\u8363\u8000";
            }
        } else {
            valueOf = String.valueOf(activeChannel.getVoiceChannel().getVoiceChannel().getChannelMemberCount());
        }
        String str2 = valueOf;
        long channelId = activeChannel.getChannelInfo().getChannelId();
        int channelType = activeChannel.getChannelInfo().getChannelType();
        String channelName = activeChannel.getChannelInfo().getChannelName();
        long guildId = activeChannel.getChannelInfo().getGuildId();
        String guildIcon = activeChannel.getChannelInfo().getGuildIcon();
        String a16 = lh1.a.f414590d.a(activeChannel.getVoiceChannel().getCover().getImageUrl());
        ChannelStatusInfo a17 = a(activeChannel.getItemType());
        String joinGuildSig = activeChannel.getChannelInfo().getJoinGuildSig();
        IGProRecommendVoiceChannel voiceChannel = activeChannel.getVoiceChannel();
        Intrinsics.checkNotNullExpressionValue(voiceChannel, "activeChannel.voiceChannel");
        String c16 = c(voiceChannel);
        List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> b16 = b(activeChannel.getChannelInfo().getGuildId(), activeChannel.getVoiceChannel().getVoiceChannel().getUserList());
        Intrinsics.checkNotNullExpressionValue(channelName, "channelName");
        Intrinsics.checkNotNullExpressionValue(joinGuildSig, "joinGuildSig");
        return new ChannelSmobaMediaCardItemData(channelId, channelType, channelName, guildId, guildIcon, joinGuildSig, traceId, 0, c16, a16, a17, str2, b16, 128, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        r2 = kotlin.collections.CollectionsKt___CollectionsKt.take(r2, 3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ChannelListenCardItemData k(IGProRecommendItem activeChannel, String traceId) {
        boolean z16;
        String bottomText;
        List emptyList;
        List list;
        List take;
        int collectionSizeOrDefault;
        String name = activeChannel.getVoiceTemplate().getName();
        boolean z17 = false;
        if (name != null && name.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String name2 = activeChannel.getVoiceTemplate().getName();
        if (name2 == null || name2.length() == 0) {
            z17 = true;
        }
        if (z17) {
            bottomText = String.valueOf(activeChannel.getVoiceTemplate().getCurrentNum());
        } else {
            bottomText = activeChannel.getVoiceTemplate().getName();
        }
        ArrayList<IGProMemberInfo> members = activeChannel.getVoiceTemplate().getMembers();
        if (members == null || take == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        } else {
            List<IGProMemberInfo> list2 = take;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (IGProMemberInfo iGProMemberInfo : list2) {
                String valueOf = String.valueOf(activeChannel.getChannelInfo().getGuildId());
                String valueOf2 = String.valueOf(iGProMemberInfo.getTinyId());
                String avatarMeta = iGProMemberInfo.getAvatarMeta();
                Intrinsics.checkNotNullExpressionValue(avatarMeta, "it.avatarMeta");
                arrayList.add(new GuildHomeActiveChannelMicAvatarView.AvatarInfo(valueOf, valueOf2, avatarMeta, true));
            }
            list = arrayList;
        }
        long channelId = activeChannel.getChannelInfo().getChannelId();
        int channelType = activeChannel.getChannelInfo().getChannelType();
        String channelName = activeChannel.getChannelInfo().getChannelName();
        long guildId = activeChannel.getChannelInfo().getGuildId();
        String guildIcon = activeChannel.getChannelInfo().getGuildIcon();
        String a16 = lh1.a.f414590d.a(activeChannel.getVoiceTemplate().getCover().getImageUrl());
        ChannelStatusInfo a17 = a(activeChannel.getItemType());
        String joinGuildSig = activeChannel.getChannelInfo().getJoinGuildSig();
        IGProRecommendVoiceChannel voiceChannel = activeChannel.getVoiceChannel();
        Intrinsics.checkNotNullExpressionValue(voiceChannel, "activeChannel.voiceChannel");
        String c16 = c(voiceChannel);
        Intrinsics.checkNotNullExpressionValue(channelName, "channelName");
        Intrinsics.checkNotNullExpressionValue(joinGuildSig, "joinGuildSig");
        Intrinsics.checkNotNullExpressionValue(bottomText, "bottomText");
        return new ChannelListenCardItemData(channelId, channelType, channelName, guildId, guildIcon, joinGuildSig, traceId, 6, c16, a16, a17, z16, bottomText, list);
    }
}
