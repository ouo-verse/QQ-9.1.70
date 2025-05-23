package com.tencent.state.square.data;

import android.app.Application;
import android.util.Size;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemKt;
import com.tencent.state.service.SquarePageBackgroundInfo;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.flower.data.MedalData;
import com.tencent.state.square.interaction.InteractionUnreadInfo;
import com.tencent.state.square.like.LikeListInfo;
import com.tencent.state.template.data.CommonFootLabel;
import cooperation.qzone.util.WnsError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u000f\u001a\n\u0010\u0010\u001a\u00020\u000e*\u00020\u000f\u001a\n\u0010\u0010\u001a\u00020\u000e*\u00020\u0001\u00a8\u0006\u0011"}, d2 = {"getDefaultSquareAvatarItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "message", "Lcom/tencent/state/square/api/SquareMessageRecord;", "location", "Lcom/tencent/state/map/Location;", "getDefaultSquareItem", "Lcom/tencent/state/map/MapItem;", "uin", "", "type", "", "copyAvatarItem", "isBasicStatus", "", "Lcom/tencent/state/square/data/OnlineStatus;", "isMusicStatus", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAvatarItemKt {
    public static final SquareAvatarItem copyAvatarItem(SquareAvatarItem copyAvatarItem) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        OnlineStatus onlineStatus;
        OnlineStatus copy;
        Intrinsics.checkNotNullParameter(copyAvatarItem, "$this$copyAvatarItem");
        String uin = copyAvatarItem.getUin();
        boolean isGenderMale = copyAvatarItem.getIsGenderMale();
        String nickName = copyAvatarItem.getNickName();
        boolean isCenter = copyAvatarItem.getIsCenter();
        List<AvatarAction> actions = copyAvatarItem.getActions();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(actions, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = actions.iterator();
        while (it.hasNext()) {
            arrayList.add(SquareItemKt.copyDepth((AvatarAction) it.next()));
        }
        List<AvatarAction> standActions = copyAvatarItem.getStandActions();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(standActions, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = standActions.iterator();
        while (it5.hasNext()) {
            arrayList2.add(SquareItemKt.copyDepth((AvatarAction) it5.next()));
        }
        Tag tag = copyAvatarItem.getTag();
        Tag copy$default = tag != null ? Tag.copy$default(tag, 0, null, 0, null, 15, null) : null;
        String textMood = copyAvatarItem.getExtra().getTextMood();
        String audioMood = copyAvatarItem.getExtra().getAudioMood();
        String cycleScheme = copyAvatarItem.getExtra().getCycleScheme();
        OnlineStatus onlineStatus2 = copyAvatarItem.getExtra().getOnlineStatus();
        if (onlineStatus2 != null) {
            copy = onlineStatus2.copy((r22 & 1) != 0 ? onlineStatus2.id : 0, (r22 & 2) != 0 ? onlineStatus2.topStatusId : 0, (r22 & 4) != 0 ? onlineStatus2.richStatus : 0, (r22 & 8) != 0 ? onlineStatus2.title : null, (r22 & 16) != 0 ? onlineStatus2.icon : null, (r22 & 32) != 0 ? onlineStatus2.bigIcon : null, (r22 & 64) != 0 ? onlineStatus2.extraData : null, (r22 & 128) != 0 ? onlineStatus2.customText : null, (r22 & 256) != 0 ? onlineStatus2.publishTimeTips : null, (r22 & 512) != 0 ? onlineStatus2.panelPreviewIcon : null);
            onlineStatus = copy;
        } else {
            onlineStatus = null;
        }
        PlayState isPlayingPtt = copyAvatarItem.getExtra().getIsPlayingPtt();
        boolean isFixed = copyAvatarItem.getExtra().getIsFixed();
        boolean needRingPagAnim = copyAvatarItem.getExtra().getNeedRingPagAnim();
        LikeListInfo likeUnReadInfo = copyAvatarItem.getExtra().getLikeUnReadInfo();
        LikeListInfo copy$default2 = likeUnReadInfo != null ? LikeListInfo.copy$default(likeUnReadInfo, null, 0, 3, null) : null;
        boolean isMultiMotion = copyAvatarItem.getExtra().getIsMultiMotion();
        int labelType = copyAvatarItem.getExtra().getLabelType();
        CommonFootLabel footLabel = copyAvatarItem.getExtra().getFootLabel();
        SquareBaseMessageRecord lastUnReadMsg = copyAvatarItem.getExtra().getLastUnReadMsg();
        SquareBaseMessageRecord copyDepth = lastUnReadMsg != null ? lastUnReadMsg.copyDepth() : null;
        SquarePosterInfo posterInfo = copyAvatarItem.getExtra().getPosterInfo();
        SquarePosterInfo copy$default3 = posterInfo != null ? SquarePosterInfo.copy$default(posterInfo, 0, null, 0L, null, 15, null) : null;
        boolean inSquare = copyAvatarItem.getExtra().getInSquare();
        RelationType relationType = copyAvatarItem.getExtra().getRelationType();
        SquarePageBackgroundInfo detailBackgroundInfo = copyAvatarItem.getExtra().getDetailBackgroundInfo();
        SquarePageBackgroundInfo copyDepth2 = detailBackgroundInfo != null ? detailBackgroundInfo.copyDepth() : null;
        int flowerCount = copyAvatarItem.getExtra().getFlowerCount();
        MedalData flowerMedal = copyAvatarItem.getExtra().getFlowerMedal();
        SquareStrangerInfo strangerExtra = copyAvatarItem.getExtra().getStrangerExtra();
        SquareStrangerInfo copy$default4 = strangerExtra != null ? SquareStrangerInfo.copy$default(strangerExtra, 0, null, 3, null) : null;
        SquareBubbleInfo bubbleInfo = copyAvatarItem.getExtra().getBubbleInfo();
        SquareBubbleInfo copy$default5 = bubbleInfo != null ? SquareBubbleInfo.copy$default(bubbleInfo, 0, null, null, null, null, null, null, 127, null) : null;
        SquareIntimateInfo intimateExtra = copyAvatarItem.getExtra().getIntimateExtra();
        return new SquareAvatarItem(uin, isGenderMale, nickName, isCenter, arrayList, arrayList2, copy$default, new SquareAvatarExtra(textMood, audioMood, cycleScheme, onlineStatus, isPlayingPtt, isFixed, needRingPagAnim, copy$default2, isMultiMotion, labelType, footLabel, copyDepth, copy$default3, inSquare, relationType, copyDepth2, null, flowerCount, flowerMedal, copy$default4, null, false, copy$default5, null, intimateExtra != null ? SquareIntimateInfo.copy$default(intimateExtra, null, null, null, null, 15, null) : null, false, 45154304, null), Location.copy$default(copyAvatarItem.getLocation(), 0, 0, 0, 0, 0, 0, 63, null), copyAvatarItem.getDressKey(), copyAvatarItem.getNewInfoList(), copyAvatarItem.getNickNames(), new QZoneFeedsInfo(copyAvatarItem.getFeedInfo().getId(), copyAvatarItem.getFeedInfo().getType(), copyAvatarItem.getFeedInfo().getText(), copyAvatarItem.getFeedInfo().getImage(), copyAvatarItem.getFeedInfo().getJumpUrl(), copyAvatarItem.getFeedInfo().getHasNew()), new AvatarLocationInfo(copyAvatarItem.getLocationInfo().getLongitude(), copyAvatarItem.getLocationInfo().getLatitude(), copyAvatarItem.getLocationInfo().getPoi(), copyAvatarItem.getLocationInfo().getPoiId(), copyAvatarItem.getLocationInfo().getPoiAddress()), InteractionUnreadInfo.copy$default(copyAvatarItem.getInteractionUnReadInfo(), 0, null, 3, null), copyAvatarItem.getStickers());
    }

    public static final boolean isBasicStatus(OnlineStatus isBasicStatus) {
        Intrinsics.checkNotNullParameter(isBasicStatus, "$this$isBasicStatus");
        return isBasicStatus.getRichStatus() == 0;
    }

    public static final boolean isMusicStatus(SquareAvatarItem isMusicStatus) {
        Intrinsics.checkNotNullParameter(isMusicStatus, "$this$isMusicStatus");
        OnlineStatus onlineStatus = isMusicStatus.getExtra().getOnlineStatus();
        if (onlineStatus != null) {
            return isMusicStatus(onlineStatus);
        }
        return false;
    }

    public static final boolean isMusicStatus(OnlineStatus isMusicStatus) {
        Intrinsics.checkNotNullParameter(isMusicStatus, "$this$isMusicStatus");
        return isMusicStatus.getId() == 1028 && isMusicStatus.getTopStatusId() == 11;
    }

    public static final MapItem getDefaultSquareItem(String uin, int i3, Location location) {
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(location, "location");
        if (i3 != 1) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return new SquareAvatarItem(uin, true, "", false, emptyList, emptyList2, null, new SquareAvatarExtra(null, null, null, null, null, false, false, null, false, 0, null, null, null, false, null, null, null, 0, null, null, null, false, null, null, null, false, 67108863, null), location, null, null, null, null, null, null, null, 65088, null);
        }
        Application application = Square.INSTANCE.getApplication();
        Size size = new Size(ViewExtensionsKt.calPx(application, 500), ViewExtensionsKt.calPx(application, 500));
        SquareExtraTroopInfo squareExtraTroopInfo = new SquareExtraTroopInfo(false, false, false, null, 15, null);
        squareExtraTroopInfo.setNeedLandAnim(true);
        return new SquareTroopItem(uin, false, MapItemKt.relocation(location, size), null, null, null, null, new Resource(0, null, null, new Size(ViewExtensionsKt.calPx(application, 420), ViewExtensionsKt.calPx(application, 420)), null, false, null, 0, 0, null, 1015, null), null, null, false, squareExtraTroopInfo, WnsError.WNS_CODE_LOGIN_ILLIGAL_APPID, null);
    }

    public static final SquareAvatarItem getDefaultSquareAvatarItem(SquareMessageRecord message, Location location) {
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(location, "location");
        String uin = message.getUin();
        String nickName = message.getNickName();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        return new SquareAvatarItem(uin, true, nickName, false, emptyList, emptyList2, null, new SquareAvatarExtra(null, null, null, null, null, false, false, null, false, 0, null, message, null, false, null, null, null, 0, null, null, null, false, null, null, null, false, 67106815, null), location, null, null, null, null, null, null, null, 65088, null);
    }
}
