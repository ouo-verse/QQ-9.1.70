package dg1;

import android.graphics.Color;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.main.topchannel.adapter.TextCardItemData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.BackgroundInfo;
import com.tencent.mobileqq.guild.widget.ChannelStatusInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProStickyFeedChannel;
import com.tencent.mobileqq.qqguildsdk.data.IGProStickyTextChannel;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.fe;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudienceInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCoverInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLiveChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import fh1.AvatarInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u0003H\u0002\u00a8\u0006\u001d"}, d2 = {"Ldg1/a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendItem;", "Lkotlin/collections/ArrayList;", "activeChannels", "", "Ldg1/b;", "d", "activeChannel", "c", "Ldg1/g;", "j", "Ldg1/c;", "e", "Ldg1/d;", "f", "Ldg1/e;", "i", "g", "", "itemType", "a", "Lcom/tencent/mobileqq/guild/widget/e;", "b", "Ldg1/f;", h.F, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f393684a = new a();

    a() {
    }

    private final int a(int itemType) {
        if (itemType == 5) {
            return 5;
        }
        if (itemType != 11) {
            return 3;
        }
        return 8;
    }

    private final ChannelStatusInfo b(int itemType) {
        if (itemType != 5) {
            if (itemType != 11) {
                String r16 = QQGuildUIUtil.r(R.string.f157771nt);
                Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild\u2026_card_channel_hint_audio)");
                return new ChannelStatusInfo(true, R.string.f143250lk, r16, new BackgroundInfo(QQGuildUIUtil.f(20.0f), Color.parseColor("#FF5BF8"), Color.parseColor("#B3220731")));
            }
            String r17 = QQGuildUIUtil.r(R.string.f157801nw);
            Intrinsics.checkNotNullExpressionValue(r17, "getString(R.string.guild\u2026_card_channel_hint_music)");
            return new ChannelStatusInfo(true, R.string.f143280ln, r17, new BackgroundInfo(QQGuildUIUtil.f(20.0f), Color.parseColor("#0BFFB6"), Color.parseColor("#B3053E33")));
        }
        String r18 = QQGuildUIUtil.r(R.string.f157791nv);
        Intrinsics.checkNotNullExpressionValue(r18, "getString(R.string.guild\u2026card_channel_hint_kaihei)");
        return new ChannelStatusInfo(true, R.string.f143260ll, r18, new BackgroundInfo(QQGuildUIUtil.f(20.0f), Color.parseColor("#31E6FF"), Color.parseColor("#B3003756")));
    }

    @JvmStatic
    @Nullable
    public static final b c(@NotNull IGProRecommendItem activeChannel) {
        Intrinsics.checkNotNullParameter(activeChannel, "activeChannel");
        if (activeChannel.getTemplateType() == 1) {
            return f393684a.i(activeChannel);
        }
        int itemType = activeChannel.getItemType();
        if (itemType != 2) {
            if (itemType != 3) {
                if (itemType != 4) {
                    if (itemType != 5) {
                        if (itemType != 23) {
                            if (itemType != 24) {
                                if (itemType != 100) {
                                    switch (itemType) {
                                        case 9:
                                        case 10:
                                        case 11:
                                            break;
                                        default:
                                            Logger.f235387a.d().w("Guild.userl.ChannelCardDataTransformer", 1, "transformCardData invalid type: " + activeChannel);
                                            return null;
                                    }
                                }
                            } else {
                                return f393684a.e(activeChannel);
                            }
                        } else {
                            return f393684a.j(activeChannel);
                        }
                    }
                } else {
                    return f393684a.h(activeChannel);
                }
            }
            return f393684a.g(activeChannel);
        }
        return f393684a.f(activeChannel);
    }

    @JvmStatic
    @NotNull
    public static final List<b> d(@NotNull ArrayList<IGProRecommendItem> activeChannels) {
        List<b> take;
        Intrinsics.checkNotNullParameter(activeChannels, "activeChannels");
        Logger.f235387a.d().i("Guild.userl.ChannelCardDataTransformer", 1, "transformCardDataList size: " + activeChannels.size());
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : activeChannels) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            b c16 = c((IGProRecommendItem) obj);
            if (c16 != null) {
                arrayList.add(c16);
            }
            i3 = i16;
        }
        take = CollectionsKt___CollectionsKt.take(arrayList, 6);
        return take;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000e, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.take(r1, 3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ChannelFeedCardItemData e(IGProRecommendItem activeChannel) {
        List emptyList;
        List take;
        int collectionSizeOrDefault;
        IGProRecommendChannelInfo channelInfo = activeChannel.getChannelInfo();
        IGProStickyFeedChannel activeFeedChannel = activeChannel.getActiveFeedChannel();
        ArrayList<IGProUserInfo> activeMemberList = activeFeedChannel.getActiveMemberList();
        if (activeMemberList == null || take == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List list = take;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String avatarMeta = ((IGProUserInfo) it.next()).getAvatarMeta();
                Intrinsics.checkNotNullExpressionValue(avatarMeta, "it.avatarMeta");
                emptyList.add(new AvatarInfo(3, avatarMeta, 0, null, 8, null));
            }
        }
        long channelId = channelInfo.getChannelId();
        int channelType = channelInfo.getChannelType();
        String channelName = channelInfo.getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "channelInfo.channelName");
        long guildId = channelInfo.getGuildId();
        String activeMemberCount = activeFeedChannel.getActiveMemberCount();
        Intrinsics.checkNotNullExpressionValue(activeMemberCount, "activeFeedChannel.activeMemberCount");
        ArrayList<IGProFeedSummary> feedSummaryList = activeFeedChannel.getFeedSummaryList();
        Intrinsics.checkNotNullExpressionValue(feedSummaryList, "activeFeedChannel.feedSummaryList");
        return new ChannelFeedCardItemData(channelId, channelType, channelName, 1, guildId, activeMemberCount, feedSummaryList, emptyList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        r2 = kotlin.collections.CollectionsKt___CollectionsKt.take(r2, 3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ChannelLiveCardItemData f(IGProRecommendItem activeChannel) {
        List emptyList;
        String str;
        boolean z16;
        String str2;
        String str3;
        String str4;
        IGProRoomInfo roomInfo;
        IGProRoomInfo roomInfo2;
        IGProRoomInfo roomInfo3;
        List take;
        int collectionSizeOrDefault;
        IGProRecommendChannelInfo channelInfo = activeChannel.getChannelInfo();
        IGProRecommendLiveChannel recommendLiveChannel = activeChannel.getRecommendLiveChannel();
        IGProLiveRoomInfo liveChannel = recommendLiveChannel.getLiveChannel();
        if (liveChannel == null || (roomInfo3 = liveChannel.getRoomInfo()) == null || (r2 = roomInfo3.getAudienceInfo()) == null || take == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List list = take;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String avatarMeta = ((IGProAudienceInfo) it.next()).getAvatarMeta();
                Intrinsics.checkNotNullExpressionValue(avatarMeta, "it.avatarMeta");
                emptyList.add(new AvatarInfo(1, avatarMeta, 0, null, 8, null));
            }
        }
        List list2 = emptyList;
        IGProLiveRoomInfo liveChannel2 = recommendLiveChannel.getLiveChannel();
        String str5 = null;
        if (liveChannel2 != null && (roomInfo2 = liveChannel2.getRoomInfo()) != null) {
            str = roomInfo2.getRoomName();
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
        lh1.a aVar = lh1.a.f414590d;
        IGProRecommendCoverInfo cover = recommendLiveChannel.getCover();
        if (cover != null) {
            str2 = cover.getImageUrl();
        } else {
            str2 = null;
        }
        String a16 = aVar.a(str2);
        IGProRecommendCoverInfo cover2 = recommendLiveChannel.getCover();
        if (cover2 != null) {
            str3 = cover2.getStreamUrl();
        } else {
            str3 = null;
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
        Intrinsics.checkNotNullExpressionValue(channelName, "channelName");
        return new ChannelLiveCardItemData(channelId, channelType, channelName, 2, guildId, str4, a16, str3, list2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c7, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.take(r1, 3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ChannelMediaCardItemData g(IGProRecommendItem activeChannel) {
        boolean z16;
        String valueOf;
        List emptyList;
        List list;
        List take;
        int collectionSizeOrDefault;
        String str;
        Object obj;
        boolean z17;
        if (activeChannel.getItemType() == 5) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (activeChannel.getItemType() == 5) {
            ArrayList<IGProBusinessNode> businessList = activeChannel.getVoiceChannel().getVoiceChannel().getAVChannelConfig().getBusinessList();
            IGProVoiceSmobaGameRoomStateInfo iGProVoiceSmobaGameRoomStateInfo = null;
            if (businessList != null) {
                Iterator<T> it = businessList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((IGProBusinessNode) obj).getNodeType() == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
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
        List<IGProUserInfo> userList = activeChannel.getVoiceChannel().getVoiceChannel().getUserList();
        if (userList == null || take == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        } else {
            List<IGProUserInfo> list2 = take;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (IGProUserInfo iGProUserInfo : list2) {
                String avatarMeta = iGProUserInfo.getAvatarMeta();
                Intrinsics.checkNotNullExpressionValue(avatarMeta, "it.avatarMeta");
                arrayList.add(new AvatarInfo(0, avatarMeta, iGProUserInfo.getGender(), null, 8, null));
            }
            list = arrayList;
        }
        long channelId = activeChannel.getChannelInfo().getChannelId();
        int channelType = activeChannel.getChannelInfo().getChannelType();
        String channelName = activeChannel.getChannelInfo().getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "activeChannel.channelInfo.channelName");
        return new ChannelMediaCardItemData(channelId, channelType, channelName, a(activeChannel.getItemType()), activeChannel.getChannelInfo().getGuildId(), String.valueOf(activeChannel.getVoiceChannel().getVoiceChannel().getChannelMemberCount()), lh1.a.f414590d.a(activeChannel.getVoiceChannel().getCover().getImageUrl()), b(activeChannel.getItemType()), null, z16, str2, list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000e, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.take(r0, 3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ChannelScreenShareCardItemData h(IGProRecommendItem activeChannel) {
        List emptyList;
        List take;
        int collectionSizeOrDefault;
        List<IGProUserInfo> userList = activeChannel.getVoiceChannel().getVoiceChannel().getUserList();
        if (userList == null || take == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<IGProUserInfo> list = take;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList = new ArrayList(collectionSizeOrDefault);
            for (IGProUserInfo iGProUserInfo : list) {
                String avatarMeta = iGProUserInfo.getAvatarMeta();
                Intrinsics.checkNotNullExpressionValue(avatarMeta, "it.avatarMeta");
                emptyList.add(new AvatarInfo(0, avatarMeta, iGProUserInfo.getGender(), null, 8, null));
            }
        }
        List list2 = emptyList;
        long channelId = activeChannel.getChannelInfo().getChannelId();
        int channelType = activeChannel.getChannelInfo().getChannelType();
        String channelName = activeChannel.getChannelInfo().getChannelName();
        long guildId = activeChannel.getChannelInfo().getGuildId();
        String a16 = lh1.a.f414590d.a(activeChannel.getVoiceChannel().getCover().getImageUrl());
        String streamUrl = activeChannel.getVoiceChannel().getCover().getStreamUrl();
        String valueOf = String.valueOf(activeChannel.getVoiceChannel().getVoiceChannel().getChannelMemberCount());
        Intrinsics.checkNotNullExpressionValue(channelName, "channelName");
        return new ChannelScreenShareCardItemData(channelId, channelType, channelName, 4, guildId, valueOf, a16, streamUrl, list2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        r3 = kotlin.collections.CollectionsKt___CollectionsKt.take(r3, 3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ChannelMediaCardItemData i(IGProRecommendItem activeChannel) {
        boolean z16;
        boolean z17;
        String bottomText;
        List emptyList;
        List list;
        List take;
        int collectionSizeOrDefault;
        String name = activeChannel.getVoiceTemplate().getName();
        if (name != null && name.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String name2 = activeChannel.getVoiceTemplate().getName();
        if (name2 != null && name2.length() != 0) {
            z17 = false;
        } else {
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
                String avatarMeta = iGProMemberInfo.getAvatarMeta();
                Intrinsics.checkNotNullExpressionValue(avatarMeta, "it.avatarMeta");
                arrayList.add(new AvatarInfo(0, avatarMeta, iGProMemberInfo.getGender(), String.valueOf(iGProMemberInfo.getTinyId())));
            }
            list = arrayList;
        }
        String r16 = QQGuildUIUtil.r(R.string.f157811nx);
        Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild\u2026annel_hint_play_together)");
        ChannelStatusInfo channelStatusInfo = new ChannelStatusInfo(true, R.string.f143260ll, r16, new BackgroundInfo(QQGuildUIUtil.f(20.0f), Color.parseColor("#31E6FF"), Color.parseColor("#B3003756")));
        long channelId = activeChannel.getChannelInfo().getChannelId();
        int channelType = activeChannel.getChannelInfo().getChannelType();
        String channelName = activeChannel.getChannelInfo().getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "activeChannel.channelInfo.channelName");
        int itemType = activeChannel.getItemType();
        long guildId = activeChannel.getChannelInfo().getGuildId();
        String valueOf = String.valueOf(activeChannel.getVoiceTemplate().getCurrentNum());
        String a16 = lh1.a.f414590d.a(activeChannel.getVoiceTemplate().getCover().getImageUrl());
        String statusIcon = activeChannel.getVoiceTemplate().getStatusIcon();
        Intrinsics.checkNotNullExpressionValue(bottomText, "bottomText");
        return new ChannelMediaCardItemData(channelId, channelType, channelName, itemType, guildId, valueOf, a16, channelStatusInfo, statusIcon, z16, bottomText, list);
    }

    private final ChannelTextCardItemData j(IGProRecommendItem activeChannel) {
        ArrayList arrayList;
        List take;
        int collectionSizeOrDefault;
        boolean z16;
        Object firstOrNull;
        long longValue;
        IGProRecommendChannelInfo channelInfo = activeChannel.getChannelInfo();
        IGProStickyTextChannel activeTextChannel = activeChannel.getActiveTextChannel();
        ArrayList<fe> msgAbstracts = activeTextChannel.getMsgAbstracts();
        if (msgAbstracts != null) {
            arrayList = new ArrayList();
            Iterator<T> it = msgAbstracts.iterator();
            while (it.hasNext()) {
                Object a16 = ((fe) it.next()).a();
                TextCardItemData textCardItemData = null;
                Long l3 = null;
                textCardItemData = null;
                if (a16 instanceof MsgAbstract) {
                    MsgAbstract msgAbstract = (MsgAbstract) a16;
                    ArrayList<MsgAbstractElement> arrayList2 = msgAbstract.elements;
                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        ArrayList<MsgAbstractElement> arrayList3 = msgAbstract.elements;
                        Intrinsics.checkNotNullExpressionValue(arrayList3, "msgAbstract.elements");
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList3);
                        MsgAbstractElement msgAbstractElement = (MsgAbstractElement) firstOrNull;
                        if (msgAbstractElement != null) {
                            l3 = msgAbstractElement.msgSeq;
                        }
                        if (l3 == null) {
                            longValue = 0;
                        } else {
                            Intrinsics.checkNotNullExpressionValue(l3, "msgAbstract.elements.firstOrNull()?.msgSeq ?: 0L");
                            longValue = l3.longValue();
                        }
                        long j3 = longValue;
                        cv1.a a17 = kr1.a.a(msgAbstract);
                        a17.e(j3);
                        String str = msgAbstract.senderUid;
                        Intrinsics.checkNotNullExpressionValue(str, "msgAbstract.senderUid");
                        textCardItemData = new TextCardItemData(MiscKt.l(str), j3, a17);
                    }
                }
                if (textCardItemData != null) {
                    arrayList.add(textCardItemData);
                }
            }
        } else {
            arrayList = new ArrayList();
        }
        ArrayList arrayList4 = arrayList;
        ArrayList<IGProUserInfo> activeMemberList = activeTextChannel.getActiveMemberList();
        Intrinsics.checkNotNullExpressionValue(activeMemberList, "activeTextChannel.activeMemberList");
        take = CollectionsKt___CollectionsKt.take(activeMemberList, 3);
        List list = take;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            String avatarMeta = ((IGProUserInfo) it5.next()).getAvatarMeta();
            Intrinsics.checkNotNullExpressionValue(avatarMeta, "it.avatarMeta");
            arrayList5.add(new AvatarInfo(2, avatarMeta, 0, null, 8, null));
        }
        long channelId = channelInfo.getChannelId();
        int channelType = channelInfo.getChannelType();
        String channelName = channelInfo.getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "channelInfo.channelName");
        long guildId = channelInfo.getGuildId();
        String activeMemberCount = activeTextChannel.getActiveMemberCount();
        Intrinsics.checkNotNullExpressionValue(activeMemberCount, "activeTextChannel.activeMemberCount");
        return new ChannelTextCardItemData(channelId, channelType, channelName, 7, guildId, activeMemberCount, arrayList4, arrayList5);
    }
}
