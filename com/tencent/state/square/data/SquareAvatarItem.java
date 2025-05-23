package com.tencent.state.square.data;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SummaryData;
import com.tencent.state.square.interaction.InteractionUnreadInfo;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.template.data.CommonFootLabel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u00b1\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\t\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u0000H\u0002J\b\u0010X\u001a\u00020%H\u0016J\u0006\u0010Y\u001a\u00020\u0005J\u000e\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020%J\u0006\u0010[\u001a\u00020\u0005J\u0006\u0010\\\u001a\u00020\u0005J\u0006\u0010]\u001a\u00020\u0005J\b\u0010^\u001a\u00020_H\u0016J\u0006\u0010`\u001a\u00020\u0005J\u0006\u0010a\u001a\u00020\u0005J\u0006\u0010b\u001a\u00020\u0005J\b\u0010c\u001a\u00020\u0003H\u0016J\u0010\u0010d\u001a\u00020_2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010e\u001a\u00020_2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010f\u001a\u00020_2\u0006\u0010Z\u001a\u00020%2\u0006\u0010g\u001a\u00020\u0005J\u0010\u0010h\u001a\u00020_2\u0006\u0010E\u001a\u00020FH\u0016J\u000e\u0010i\u001a\u00020_2\u0006\u0010j\u001a\u00020\u001eR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0014\u00108\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u00109R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010)R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010!\"\u0004\bB\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010)R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\t\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010!R\u0016\u0010E\u001a\u0004\u0018\u00010F8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u0010HR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010!\"\u0004\bJ\u0010#R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R\u00a8\u0006k"}, d2 = {"Lcom/tencent/state/square/data/SquareAvatarItem;", "Lcom/tencent/state/map/MapPlayableItem;", "uin", "", "isMale", "", "nickName", "isCenter", "actions", "", "Lcom/tencent/state/square/data/AvatarAction;", "standActions", "tag", "Lcom/tencent/state/square/data/Tag;", "extra", "Lcom/tencent/state/square/data/SquareAvatarExtra;", "location", "Lcom/tencent/state/map/Location;", "dressKey", "newInfoList", "Lcom/tencent/state/square/data/NewInfo;", "nickNames", "Lcom/tencent/state/square/data/NickName;", QCircleScheme.AttrDetail.FEED_INFO, "Lcom/tencent/state/square/data/QZoneFeedsInfo;", "locationInfo", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "interactionUnReadInfo", "Lcom/tencent/state/square/interaction/InteractionUnreadInfo;", c.B, "Lcom/tencent/state/square/data/Stickers;", "(Ljava/lang/String;ZLjava/lang/String;ZLjava/util/List;Ljava/util/List;Lcom/tencent/state/square/data/Tag;Lcom/tencent/state/square/data/SquareAvatarExtra;Lcom/tencent/state/map/Location;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/tencent/state/square/data/QZoneFeedsInfo;Lcom/tencent/state/square/data/AvatarLocationInfo;Lcom/tencent/state/square/interaction/InteractionUnreadInfo;Lcom/tencent/state/square/data/Stickers;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "defaultResourceId", "", "getDefaultResourceId", "()I", "getDressKey", "()Ljava/lang/String;", "setDressKey", "(Ljava/lang/String;)V", "getExtra", "()Lcom/tencent/state/square/data/SquareAvatarExtra;", "setExtra", "(Lcom/tencent/state/square/data/SquareAvatarExtra;)V", "getFeedInfo", "()Lcom/tencent/state/square/data/QZoneFeedsInfo;", "setFeedInfo", "(Lcom/tencent/state/square/data/QZoneFeedsInfo;)V", "getInteractionUnReadInfo", "()Lcom/tencent/state/square/interaction/InteractionUnreadInfo;", "setInteractionUnReadInfo", "(Lcom/tencent/state/square/interaction/InteractionUnreadInfo;)V", "isFixed", "()Z", "isGenderMale", "getLocationInfo", "()Lcom/tencent/state/square/data/AvatarLocationInfo;", "setLocationInfo", "(Lcom/tencent/state/square/data/AvatarLocationInfo;)V", "name", "getName", "getNewInfoList", "setNewInfoList", "getNickName", "getNickNames", "resource", "Lcom/tencent/state/square/data/Resource;", "getResource", "()Lcom/tencent/state/square/data/Resource;", "getStandActions", "setStandActions", "getStickers", "()Lcom/tencent/state/square/data/Stickers;", "setStickers", "(Lcom/tencent/state/square/data/Stickers;)V", "getTag", "()Lcom/tencent/state/square/data/Tag;", "setTag", "(Lcom/tencent/state/square/data/Tag;)V", "canUpdate", "newItem", "Lcom/tencent/state/map/MapItem;", "checkIntimateChange", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "getUnitType", "hasNewFlag", "type", "isDefault", "isNearToMe", "isStranger", "resetDefault", "", "shouldShowBottomLabelText", "shouldShowNewDressFlag", "shouldShowNewInteractFlag", "toString", "updateDressKey", "updateGender", "updateNewFlag", "flag", "updateResource", "updateSticker", "newStickers", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAvatarItem extends MapPlayableItem {
    private List<AvatarAction> actions;
    private String dressKey;
    private SquareAvatarExtra extra;
    private QZoneFeedsInfo feedInfo;
    private InteractionUnreadInfo interactionUnReadInfo;
    private boolean isMale;
    private AvatarLocationInfo locationInfo;
    private List<NewInfo> newInfoList;
    private final String nickName;
    private final List<NickName> nickNames;
    private List<AvatarAction> standActions;
    private Stickers stickers;
    private Tag tag;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RelationType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[RelationType.FRIEND.ordinal()] = 1;
            iArr[RelationType.STRANGER.ordinal()] = 2;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SquareAvatarItem(String str, boolean z16, String str2, boolean z17, List list, List list2, Tag tag, SquareAvatarExtra squareAvatarExtra, Location location, String str3, List list3, List list4, QZoneFeedsInfo qZoneFeedsInfo, AvatarLocationInfo avatarLocationInfo, InteractionUnreadInfo interactionUnreadInfo, Stickers stickers, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z16, str2, z17, list, list2, r10, r11, location, r13, r14, r15, r16, r17, r18, r19);
        List list5;
        List list6;
        Stickers stickers2;
        List emptyList;
        List emptyList2;
        List emptyList3;
        List emptyList4;
        Tag tag2 = (i3 & 64) != 0 ? null : tag;
        SquareAvatarExtra squareAvatarExtra2 = (i3 & 128) != 0 ? new SquareAvatarExtra(null, null, null, null, null, false, false, null, false, 0, null, null, null, false, null, null, null, 0, null, null, null, false, null, null, null, false, 67108863, null) : squareAvatarExtra;
        String str4 = (i3 & 512) != 0 ? "" : str3;
        if ((i3 & 1024) != 0) {
            emptyList4 = CollectionsKt__CollectionsKt.emptyList();
            list5 = emptyList4;
        } else {
            list5 = list3;
        }
        if ((i3 & 2048) != 0) {
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            list6 = emptyList3;
        } else {
            list6 = list4;
        }
        QZoneFeedsInfo qZoneFeedsInfo2 = (i3 & 4096) != 0 ? new QZoneFeedsInfo(null, 0, null, null, null, false, 31, null) : qZoneFeedsInfo;
        AvatarLocationInfo avatarLocationInfo2 = (i3 & 8192) != 0 ? new AvatarLocationInfo(0.0d, 0.0d, null, null, null, 31, null) : avatarLocationInfo;
        InteractionUnreadInfo interactionUnreadInfo2 = (i3 & 16384) != 0 ? new InteractionUnreadInfo(0, null, 3, null) : interactionUnreadInfo;
        if ((i3 & 32768) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            stickers2 = new Stickers(emptyList, 0, emptyList2);
        } else {
            stickers2 = stickers;
        }
    }

    private final boolean checkIntimateChange(SquareAvatarItem item) {
        if (this.extra.getIntimateExtra() == null && item.extra.getIntimateExtra() != null) {
            return true;
        }
        SquareIntimateInfo intimateExtra = this.extra.getIntimateExtra();
        return intimateExtra != null && intimateExtra.canUpdate(item.extra.getIntimateExtra());
    }

    @Override // com.tencent.state.map.MapItem
    public boolean canUpdate(MapItem newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof SquareAvatarItem)) {
            newItem = null;
        }
        return ((SquareAvatarItem) newItem) != null;
    }

    public final List<AvatarAction> getActions() {
        return this.actions;
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public int getDefaultResourceId() {
        return getIsGenderMale() ? R.drawable.i9f : R.drawable.i9e;
    }

    public final String getDressKey() {
        return this.dressKey;
    }

    public final SquareAvatarExtra getExtra() {
        return this.extra;
    }

    public final QZoneFeedsInfo getFeedInfo() {
        return this.feedInfo;
    }

    public final InteractionUnreadInfo getInteractionUnReadInfo() {
        return this.interactionUnReadInfo;
    }

    public final AvatarLocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    @Override // com.tencent.state.map.MapPlayableItem
    /* renamed from: getName, reason: from getter */
    public String getTroopName() {
        return this.nickName;
    }

    public final List<NewInfo> getNewInfoList() {
        return this.newInfoList;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final List<NickName> getNickNames() {
        return this.nickNames;
    }

    @Override // com.tencent.state.map.MapPlayableItem
    /* renamed from: getResource */
    public Resource getUserResource() {
        return SquareResourceManagerKt.getResource(this);
    }

    public final List<AvatarAction> getStandActions() {
        return this.standActions;
    }

    public final Stickers getStickers() {
        return this.stickers;
    }

    public final Tag getTag() {
        return this.tag;
    }

    @Override // com.tencent.state.map.MapItem
    public int getUnitType() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.extra.getRelationType().ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? -1 : 2;
        }
        return 0;
    }

    public final boolean hasNewFlag(int type) {
        Object obj;
        Iterator<T> it = this.newInfoList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((NewInfo) obj).getType() == type) {
                break;
            }
        }
        NewInfo newInfo = (NewInfo) obj;
        if (newInfo != null) {
            return newInfo.getHasNewFlag();
        }
        return false;
    }

    public final boolean isDefault() {
        return this.actions.isEmpty() && this.standActions.isEmpty();
    }

    @Override // com.tencent.state.map.MapItem
    /* renamed from: isFixed */
    public boolean getIsFixed() {
        return this.extra.getIsFixed();
    }

    @Override // com.tencent.state.map.MapPlayableItem
    /* renamed from: isGenderMale, reason: from getter */
    public boolean getIsGenderMale() {
        return this.isMale;
    }

    public final boolean isNearToMe() {
        return getIsFixed() && getLocation().getRank() == 1;
    }

    public final boolean isStranger() {
        return this.extra.getRelationType() == RelationType.STRANGER;
    }

    public final void setActions(List<AvatarAction> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.actions = list;
    }

    public final void setDressKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dressKey = str;
    }

    public final void setExtra(SquareAvatarExtra squareAvatarExtra) {
        Intrinsics.checkNotNullParameter(squareAvatarExtra, "<set-?>");
        this.extra = squareAvatarExtra;
    }

    public final void setFeedInfo(QZoneFeedsInfo qZoneFeedsInfo) {
        Intrinsics.checkNotNullParameter(qZoneFeedsInfo, "<set-?>");
        this.feedInfo = qZoneFeedsInfo;
    }

    public final void setInteractionUnReadInfo(InteractionUnreadInfo interactionUnreadInfo) {
        Intrinsics.checkNotNullParameter(interactionUnreadInfo, "<set-?>");
        this.interactionUnReadInfo = interactionUnreadInfo;
    }

    public final void setLocationInfo(AvatarLocationInfo avatarLocationInfo) {
        Intrinsics.checkNotNullParameter(avatarLocationInfo, "<set-?>");
        this.locationInfo = avatarLocationInfo;
    }

    public final void setNewInfoList(List<NewInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.newInfoList = list;
    }

    public final void setStandActions(List<AvatarAction> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.standActions = list;
    }

    public final void setStickers(Stickers stickers) {
        Intrinsics.checkNotNullParameter(stickers, "<set-?>");
        this.stickers = stickers;
    }

    public final void setTag(Tag tag) {
        this.tag = tag;
    }

    public final boolean shouldShowBottomLabelText() {
        CommonFootLabel footLabel = this.extra.getFootLabel();
        return footLabel != null && footLabel.showText();
    }

    public String toString() {
        Object firstOrNull;
        SummaryData summaryData;
        SummaryData summaryData2;
        String highText;
        SummaryData summaryData3;
        String msgText;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[SquareAvatarItem] uin:");
        sb5.append(getUin());
        sb5.append(", +");
        sb5.append("isMale:");
        sb5.append(this.isMale);
        sb5.append(", ");
        sb5.append("nickName:");
        sb5.append(this.nickName);
        sb5.append(", ");
        sb5.append("isMe:");
        sb5.append(isMe());
        sb5.append(", ");
        sb5.append("dressKey:");
        sb5.append(this.dressKey);
        sb5.append(", ");
        sb5.append("lookFront: ");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.actions);
        AvatarAction avatarAction = (AvatarAction) firstOrNull;
        sb5.append(avatarAction != null ? avatarAction.getLookFront() : null);
        sb5.append(", ");
        sb5.append("extra: [");
        sb5.append("summaryText: ");
        SquareBaseMessageRecord lastUnReadMsg = this.extra.getLastUnReadMsg();
        sb5.append((lastUnReadMsg == null || (summaryData3 = lastUnReadMsg.getSummaryData()) == null || (msgText = summaryData3.getMsgText()) == null) ? null : Integer.valueOf(msgText.length()));
        sb5.append(", ");
        sb5.append("summaryHigh: ");
        SquareBaseMessageRecord lastUnReadMsg2 = this.extra.getLastUnReadMsg();
        sb5.append((lastUnReadMsg2 == null || (summaryData2 = lastUnReadMsg2.getSummaryData()) == null || (highText = summaryData2.getHighText()) == null) ? null : Integer.valueOf(highText.length()));
        sb5.append(", ");
        sb5.append("summaryColor: ");
        SquareBaseMessageRecord lastUnReadMsg3 = this.extra.getLastUnReadMsg();
        sb5.append((lastUnReadMsg3 == null || (summaryData = lastUnReadMsg3.getSummaryData()) == null) ? null : Integer.valueOf(summaryData.getHighColor()));
        sb5.append(", ");
        sb5.append("unReadCount: ");
        sb5.append(this.extra.unReadCount());
        sb5.append(", ");
        sb5.append("onlineStatusId: ");
        OnlineStatus onlineStatus = this.extra.getOnlineStatus();
        sb5.append(onlineStatus != null ? Integer.valueOf(onlineStatus.getId()) : null);
        sb5.append(TokenParser.SP);
        sb5.append("]");
        return sb5.toString();
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void updateDressKey(String dressKey) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        this.dressKey = dressKey;
        for (AvatarAction avatarAction : this.actions) {
            DressKeys userDressKey = avatarAction.getLookFront().getFilament().getUserDressKey();
            if (userDressKey != null) {
                userDressKey.setOwner(dressKey);
            }
            DressKeys userDressKey2 = avatarAction.getUnread().getFilament().getUserDressKey();
            if (userDressKey2 != null) {
                userDressKey2.setOwner(dressKey);
            }
            DressKeys userDressKey3 = avatarAction.getBattery().getFilament().getUserDressKey();
            if (userDressKey3 != null) {
                userDressKey3.setOwner(dressKey);
            }
            DressKeys userDressKey4 = avatarAction.getFeedsNew().getFilament().getUserDressKey();
            if (userDressKey4 != null) {
                userDressKey4.setOwner(dressKey);
            }
        }
        for (AvatarAction avatarAction2 : this.standActions) {
            DressKeys userDressKey5 = avatarAction2.getLookFront().getFilament().getUserDressKey();
            if (userDressKey5 != null) {
                userDressKey5.setOwner(dressKey);
            }
            DressKeys userDressKey6 = avatarAction2.getUnread().getFilament().getUserDressKey();
            if (userDressKey6 != null) {
                userDressKey6.setOwner(dressKey);
            }
            DressKeys userDressKey7 = avatarAction2.getBattery().getFilament().getUserDressKey();
            if (userDressKey7 != null) {
                userDressKey7.setOwner(dressKey);
            }
            DressKeys userDressKey8 = avatarAction2.getFeedsNew().getFilament().getUserDressKey();
            if (userDressKey8 != null) {
                userDressKey8.setOwner(dressKey);
            }
        }
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void updateGender(boolean isMale) {
        this.isMale = isMale;
    }

    public final void updateNewFlag(int type, boolean flag) {
        Object obj;
        Iterator<T> it = this.newInfoList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((NewInfo) obj).getType() == type) {
                    break;
                }
            }
        }
        NewInfo newInfo = (NewInfo) obj;
        if (newInfo != null) {
            newInfo.setHasNewFlag(flag);
        }
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void updateResource(Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        for (AvatarAction avatarAction : this.actions) {
            avatarAction.setLookFront(resource);
            avatarAction.setUnread(resource);
        }
    }

    public final void updateSticker(Stickers newStickers) {
        Intrinsics.checkNotNullParameter(newStickers, "newStickers");
        this.stickers = newStickers;
    }

    public final boolean shouldShowNewDressFlag() {
        return hasNewFlag(2) && !isMe();
    }

    public final boolean shouldShowNewInteractFlag() {
        return hasNewFlag(3) && !isMe();
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void resetDefault() {
        Resource copyResource;
        Resource copyResource2;
        Resource copyResource3;
        Resource copyResource4;
        for (AvatarAction avatarAction : this.actions) {
            copyResource3 = SquareItemKt.copyResource(r3, (r21 & 1) != 0 ? r3.getActionId() : 0, (r21 & 2) != 0 ? r3.getDynamic() : null, (r21 & 4) != 0 ? r3.getStatic() : null, (r21 & 8) != 0 ? r3.getShowSize() : null, (r21 & 16) != 0 ? r3.getRecordSize() : null, (r21 & 32) != 0 ? r3.getIsDefault() : false, (r21 & 64) != 0 ? r3.getBubbleCoordinate() : null, (r21 & 128) != 0 ? r3.getActionType() : 0, (r21 & 256) != 0 ? r3.getActionStyle() : 0, (r21 & 512) != 0 ? avatarAction.getLookFront().getFilament() : null);
            avatarAction.setLookFront(copyResource3.resetDefault());
            copyResource4 = SquareItemKt.copyResource(r4, (r21 & 1) != 0 ? r4.getActionId() : 0, (r21 & 2) != 0 ? r4.getDynamic() : null, (r21 & 4) != 0 ? r4.getStatic() : null, (r21 & 8) != 0 ? r4.getShowSize() : null, (r21 & 16) != 0 ? r4.getRecordSize() : null, (r21 & 32) != 0 ? r4.getIsDefault() : false, (r21 & 64) != 0 ? r4.getBubbleCoordinate() : null, (r21 & 128) != 0 ? r4.getActionType() : 0, (r21 & 256) != 0 ? r4.getActionStyle() : 0, (r21 & 512) != 0 ? avatarAction.getUnread().getFilament() : null);
            avatarAction.setUnread(copyResource4.resetDefault());
        }
        for (AvatarAction avatarAction2 : this.standActions) {
            copyResource = SquareItemKt.copyResource(r3, (r21 & 1) != 0 ? r3.getActionId() : 0, (r21 & 2) != 0 ? r3.getDynamic() : null, (r21 & 4) != 0 ? r3.getStatic() : null, (r21 & 8) != 0 ? r3.getShowSize() : null, (r21 & 16) != 0 ? r3.getRecordSize() : null, (r21 & 32) != 0 ? r3.getIsDefault() : false, (r21 & 64) != 0 ? r3.getBubbleCoordinate() : null, (r21 & 128) != 0 ? r3.getActionType() : 0, (r21 & 256) != 0 ? r3.getActionStyle() : 0, (r21 & 512) != 0 ? avatarAction2.getLookFront().getFilament() : null);
            avatarAction2.setLookFront(copyResource.resetDefault());
            copyResource2 = SquareItemKt.copyResource(r4, (r21 & 1) != 0 ? r4.getActionId() : 0, (r21 & 2) != 0 ? r4.getDynamic() : null, (r21 & 4) != 0 ? r4.getStatic() : null, (r21 & 8) != 0 ? r4.getShowSize() : null, (r21 & 16) != 0 ? r4.getRecordSize() : null, (r21 & 32) != 0 ? r4.getIsDefault() : false, (r21 & 64) != 0 ? r4.getBubbleCoordinate() : null, (r21 & 128) != 0 ? r4.getActionType() : 0, (r21 & 256) != 0 ? r4.getActionStyle() : 0, (r21 & 512) != 0 ? avatarAction2.getUnread().getFilament() : null);
            avatarAction2.setUnread(copyResource2.resetDefault());
        }
    }

    public final boolean hasNewFlag() {
        List<NewInfo> list = this.newInfoList;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((NewInfo) it.next()).getHasNewFlag()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareAvatarItem(String uin, boolean z16, String nickName, boolean z17, List<AvatarAction> actions, List<AvatarAction> standActions, Tag tag, SquareAvatarExtra extra, Location location, String dressKey, List<NewInfo> newInfoList, List<NickName> nickNames, QZoneFeedsInfo feedInfo, AvatarLocationInfo locationInfo, InteractionUnreadInfo interactionUnReadInfo, Stickers stickers) {
        super(1, uin, z17, location);
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(standActions, "standActions");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(newInfoList, "newInfoList");
        Intrinsics.checkNotNullParameter(nickNames, "nickNames");
        Intrinsics.checkNotNullParameter(feedInfo, "feedInfo");
        Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
        Intrinsics.checkNotNullParameter(interactionUnReadInfo, "interactionUnReadInfo");
        Intrinsics.checkNotNullParameter(stickers, "stickers");
        this.isMale = z16;
        this.nickName = nickName;
        this.actions = actions;
        this.standActions = standActions;
        this.tag = tag;
        this.extra = extra;
        this.dressKey = dressKey;
        this.newInfoList = newInfoList;
        this.nickNames = nickNames;
        this.feedInfo = feedInfo;
        this.locationInfo = locationInfo;
        this.interactionUnReadInfo = interactionUnReadInfo;
        this.stickers = stickers;
    }
}
