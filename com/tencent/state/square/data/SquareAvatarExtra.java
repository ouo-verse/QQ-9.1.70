package com.tencent.state.square.data;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.state.service.SquarePageBackgroundInfo;
import com.tencent.state.square.api.MsgType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import com.tencent.state.square.api.SummaryData;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.flower.data.MedalData;
import com.tencent.state.square.like.LikeListInfo;
import com.tencent.state.template.data.CommonFootLabel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bW\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u00a7\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\u000b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010+\u001a\u00020\u000b\u00a2\u0006\u0002\u0010,J\u0006\u0010|\u001a\u00020\u000bJ\u0006\u0010}\u001a\u00020\u000bJ\b\u0010~\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u007f\u001a\u00020\u000bJ\u0007\u0010\u0080\u0001\u001a\u00020\u000bJ\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001J\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003J\u0007\u0010\u0084\u0001\u001a\u00020\u0011J\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001J\u0011\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010(\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010.R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010.\"\u0004\bB\u0010CR\u001a\u0010\u001e\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010\u0018\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010Q\"\u0004\bX\u0010SR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010Q\"\u0004\bY\u0010SR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010E\"\u0004\b^\u0010GR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010%\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010Q\"\u0004\bh\u0010SR\u001a\u0010+\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010Q\"\u0004\bj\u0010SR\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010Q\"\u0004\bl\u0010SR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0013\u0010!\u001a\u0004\u0018\u00010\"\u00a2\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b{\u0010.\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/tencent/state/square/data/SquareAvatarExtra;", "", "textMood", "", "audioMood", "cycleScheme", "onlineStatus", "Lcom/tencent/state/square/data/OnlineStatus;", "isPlayingPtt", "Lcom/tencent/state/square/data/PlayState;", "isFixed", "", "needRingPagAnim", "likeUnReadInfo", "Lcom/tencent/state/square/like/LikeListInfo;", "isMultiMotion", "labelType", "", "footLabel", "Lcom/tencent/state/template/data/CommonFootLabel;", "lastUnReadMsg", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "posterInfo", "Lcom/tencent/state/square/data/SquarePosterInfo;", "inSquare", "relationType", "Lcom/tencent/state/square/data/RelationType;", "detailBackgroundInfo", "Lcom/tencent/state/service/SquarePageBackgroundInfo;", "flowerBubbleText", "flowerCount", "flowerMedal", "Lcom/tencent/state/square/flower/data/MedalData;", "strangerExtra", "Lcom/tencent/state/square/data/SquareStrangerInfo;", "blindBoxEntranceInfo", "Lcom/tencent/state/square/data/SquareBlindBoxEntranceInfo;", "needBubbleAnim", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "changeAvatarImageVisible", "intimateExtra", "Lcom/tencent/state/square/data/SquareIntimateInfo;", "needIntimateAnim", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/square/data/OnlineStatus;Lcom/tencent/state/square/data/PlayState;ZZLcom/tencent/state/square/like/LikeListInfo;ZILcom/tencent/state/template/data/CommonFootLabel;Lcom/tencent/state/square/api/SquareBaseMessageRecord;Lcom/tencent/state/square/data/SquarePosterInfo;ZLcom/tencent/state/square/data/RelationType;Lcom/tencent/state/service/SquarePageBackgroundInfo;Ljava/lang/String;ILcom/tencent/state/square/flower/data/MedalData;Lcom/tencent/state/square/data/SquareStrangerInfo;Lcom/tencent/state/square/data/SquareBlindBoxEntranceInfo;ZLcom/tencent/state/square/bubblesetting/SquareBubbleInfo;Ljava/lang/Boolean;Lcom/tencent/state/square/data/SquareIntimateInfo;Z)V", "getAudioMood", "()Ljava/lang/String;", "getBlindBoxEntranceInfo", "()Lcom/tencent/state/square/data/SquareBlindBoxEntranceInfo;", "setBlindBoxEntranceInfo", "(Lcom/tencent/state/square/data/SquareBlindBoxEntranceInfo;)V", "getBubbleInfo", "()Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "setBubbleInfo", "(Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;)V", "getChangeAvatarImageVisible", "()Ljava/lang/Boolean;", "setChangeAvatarImageVisible", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCycleScheme", "getDetailBackgroundInfo", "()Lcom/tencent/state/service/SquarePageBackgroundInfo;", "setDetailBackgroundInfo", "(Lcom/tencent/state/service/SquarePageBackgroundInfo;)V", "getFlowerBubbleText", "setFlowerBubbleText", "(Ljava/lang/String;)V", "getFlowerCount", "()I", "setFlowerCount", "(I)V", "getFlowerMedal", "()Lcom/tencent/state/square/flower/data/MedalData;", "setFlowerMedal", "(Lcom/tencent/state/square/flower/data/MedalData;)V", "getFootLabel", "()Lcom/tencent/state/template/data/CommonFootLabel;", "setFootLabel", "(Lcom/tencent/state/template/data/CommonFootLabel;)V", "getInSquare", "()Z", "setInSquare", "(Z)V", "getIntimateExtra", "()Lcom/tencent/state/square/data/SquareIntimateInfo;", "setIntimateExtra", "(Lcom/tencent/state/square/data/SquareIntimateInfo;)V", "setFixed", "setMultiMotion", "()Lcom/tencent/state/square/data/PlayState;", "setPlayingPtt", "(Lcom/tencent/state/square/data/PlayState;)V", "getLabelType", "setLabelType", "getLastUnReadMsg", "()Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "setLastUnReadMsg", "(Lcom/tencent/state/square/api/SquareBaseMessageRecord;)V", "getLikeUnReadInfo", "()Lcom/tencent/state/square/like/LikeListInfo;", "setLikeUnReadInfo", "(Lcom/tencent/state/square/like/LikeListInfo;)V", "getNeedBubbleAnim", "setNeedBubbleAnim", "getNeedIntimateAnim", "setNeedIntimateAnim", "getNeedRingPagAnim", "setNeedRingPagAnim", "getOnlineStatus", "()Lcom/tencent/state/square/data/OnlineStatus;", "setOnlineStatus", "(Lcom/tencent/state/square/data/OnlineStatus;)V", "getPosterInfo", "()Lcom/tencent/state/square/data/SquarePosterInfo;", "setPosterInfo", "(Lcom/tencent/state/square/data/SquarePosterInfo;)V", "getRelationType", "()Lcom/tencent/state/square/data/RelationType;", "setRelationType", "(Lcom/tencent/state/square/data/RelationType;)V", "getStrangerExtra", "()Lcom/tencent/state/square/data/SquareStrangerInfo;", "getTextMood", "forbiddenNotify", "hasUnreadPttMsg", "hightText", IProfileProtocolConst.PARAM_IS_FRIEND, "isStranger", "messageType", "Lcom/tencent/state/square/api/MsgType;", "msgText", "unReadCount", "unReadTimestamp", "", "updateUnReadCount", "", "count", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAvatarExtra {
    private final String audioMood;
    private SquareBlindBoxEntranceInfo blindBoxEntranceInfo;
    private SquareBubbleInfo bubbleInfo;
    private Boolean changeAvatarImageVisible;
    private final String cycleScheme;
    private SquarePageBackgroundInfo detailBackgroundInfo;
    private String flowerBubbleText;
    private int flowerCount;
    private MedalData flowerMedal;
    private CommonFootLabel footLabel;
    private boolean inSquare;
    private SquareIntimateInfo intimateExtra;
    private boolean isFixed;
    private boolean isMultiMotion;
    private PlayState isPlayingPtt;
    private int labelType;
    private SquareBaseMessageRecord lastUnReadMsg;
    private LikeListInfo likeUnReadInfo;
    private boolean needBubbleAnim;
    private boolean needIntimateAnim;
    private boolean needRingPagAnim;
    private OnlineStatus onlineStatus;
    private SquarePosterInfo posterInfo;
    private RelationType relationType;
    private final SquareStrangerInfo strangerExtra;
    private final String textMood;

    public SquareAvatarExtra() {
        this(null, null, null, null, null, false, false, null, false, 0, null, null, null, false, null, null, null, 0, null, null, null, false, null, null, null, false, 67108863, null);
    }

    public final boolean forbiddenNotify() {
        SquareBaseMessageRecord squareBaseMessageRecord = this.lastUnReadMsg;
        if (squareBaseMessageRecord != null) {
            return squareBaseMessageRecord.getForbiddenNotify();
        }
        return false;
    }

    public final String getAudioMood() {
        return this.audioMood;
    }

    public final SquareBlindBoxEntranceInfo getBlindBoxEntranceInfo() {
        return this.blindBoxEntranceInfo;
    }

    public final SquareBubbleInfo getBubbleInfo() {
        return this.bubbleInfo;
    }

    public final Boolean getChangeAvatarImageVisible() {
        return this.changeAvatarImageVisible;
    }

    public final String getCycleScheme() {
        return this.cycleScheme;
    }

    public final SquarePageBackgroundInfo getDetailBackgroundInfo() {
        return this.detailBackgroundInfo;
    }

    public final String getFlowerBubbleText() {
        return this.flowerBubbleText;
    }

    public final int getFlowerCount() {
        return this.flowerCount;
    }

    public final MedalData getFlowerMedal() {
        return this.flowerMedal;
    }

    public final CommonFootLabel getFootLabel() {
        return this.footLabel;
    }

    public final boolean getInSquare() {
        return this.inSquare;
    }

    public final SquareIntimateInfo getIntimateExtra() {
        return this.intimateExtra;
    }

    public final int getLabelType() {
        return this.labelType;
    }

    public final SquareBaseMessageRecord getLastUnReadMsg() {
        return this.lastUnReadMsg;
    }

    public final LikeListInfo getLikeUnReadInfo() {
        return this.likeUnReadInfo;
    }

    public final boolean getNeedBubbleAnim() {
        return this.needBubbleAnim;
    }

    public final boolean getNeedIntimateAnim() {
        return this.needIntimateAnim;
    }

    public final boolean getNeedRingPagAnim() {
        return this.needRingPagAnim;
    }

    public final OnlineStatus getOnlineStatus() {
        return this.onlineStatus;
    }

    public final SquarePosterInfo getPosterInfo() {
        return this.posterInfo;
    }

    public final RelationType getRelationType() {
        return this.relationType;
    }

    public final SquareStrangerInfo getStrangerExtra() {
        return this.strangerExtra;
    }

    public final String getTextMood() {
        return this.textMood;
    }

    public final boolean hasUnreadPttMsg() {
        if (messageType() == MsgType.PTT) {
            return true;
        }
        SquareBaseMessageRecord squareBaseMessageRecord = this.lastUnReadMsg;
        return squareBaseMessageRecord != null && squareBaseMessageRecord.getHasUnreadPtt();
    }

    public final String hightText() {
        SummaryData summaryData;
        SquareBaseMessageRecord squareBaseMessageRecord = this.lastUnReadMsg;
        if (squareBaseMessageRecord == null || (summaryData = squareBaseMessageRecord.getSummaryData()) == null) {
            return null;
        }
        return summaryData.getHighText();
    }

    /* renamed from: isFixed, reason: from getter */
    public final boolean getIsFixed() {
        return this.isFixed;
    }

    public final boolean isFriend() {
        return this.relationType == RelationType.FRIEND;
    }

    /* renamed from: isMultiMotion, reason: from getter */
    public final boolean getIsMultiMotion() {
        return this.isMultiMotion;
    }

    /* renamed from: isPlayingPtt, reason: from getter */
    public final PlayState getIsPlayingPtt() {
        return this.isPlayingPtt;
    }

    public final boolean isStranger() {
        return this.relationType == RelationType.STRANGER;
    }

    public final MsgType messageType() {
        MsgType msgType;
        SquareBaseMessageRecord squareBaseMessageRecord = this.lastUnReadMsg;
        if (!(squareBaseMessageRecord instanceof SquareMessageRecord)) {
            squareBaseMessageRecord = null;
        }
        SquareMessageRecord squareMessageRecord = (SquareMessageRecord) squareBaseMessageRecord;
        return (squareMessageRecord == null || (msgType = squareMessageRecord.getMsgType()) == null) ? MsgType.TEXT : msgType;
    }

    public final String msgText() {
        SummaryData summaryData;
        SquareBaseMessageRecord squareBaseMessageRecord = this.lastUnReadMsg;
        if (squareBaseMessageRecord == null || (summaryData = squareBaseMessageRecord.getSummaryData()) == null) {
            return null;
        }
        return summaryData.getMsgText();
    }

    public final void setBlindBoxEntranceInfo(SquareBlindBoxEntranceInfo squareBlindBoxEntranceInfo) {
        this.blindBoxEntranceInfo = squareBlindBoxEntranceInfo;
    }

    public final void setBubbleInfo(SquareBubbleInfo squareBubbleInfo) {
        this.bubbleInfo = squareBubbleInfo;
    }

    public final void setChangeAvatarImageVisible(Boolean bool) {
        this.changeAvatarImageVisible = bool;
    }

    public final void setDetailBackgroundInfo(SquarePageBackgroundInfo squarePageBackgroundInfo) {
        this.detailBackgroundInfo = squarePageBackgroundInfo;
    }

    public final void setFixed(boolean z16) {
        this.isFixed = z16;
    }

    public final void setFlowerBubbleText(String str) {
        this.flowerBubbleText = str;
    }

    public final void setFlowerCount(int i3) {
        this.flowerCount = i3;
    }

    public final void setFlowerMedal(MedalData medalData) {
        this.flowerMedal = medalData;
    }

    public final void setFootLabel(CommonFootLabel commonFootLabel) {
        this.footLabel = commonFootLabel;
    }

    public final void setInSquare(boolean z16) {
        this.inSquare = z16;
    }

    public final void setIntimateExtra(SquareIntimateInfo squareIntimateInfo) {
        this.intimateExtra = squareIntimateInfo;
    }

    public final void setLabelType(int i3) {
        this.labelType = i3;
    }

    public final void setLastUnReadMsg(SquareBaseMessageRecord squareBaseMessageRecord) {
        this.lastUnReadMsg = squareBaseMessageRecord;
    }

    public final void setLikeUnReadInfo(LikeListInfo likeListInfo) {
        this.likeUnReadInfo = likeListInfo;
    }

    public final void setMultiMotion(boolean z16) {
        this.isMultiMotion = z16;
    }

    public final void setNeedBubbleAnim(boolean z16) {
        this.needBubbleAnim = z16;
    }

    public final void setNeedIntimateAnim(boolean z16) {
        this.needIntimateAnim = z16;
    }

    public final void setNeedRingPagAnim(boolean z16) {
        this.needRingPagAnim = z16;
    }

    public final void setOnlineStatus(OnlineStatus onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public final void setPlayingPtt(PlayState playState) {
        Intrinsics.checkNotNullParameter(playState, "<set-?>");
        this.isPlayingPtt = playState;
    }

    public final void setPosterInfo(SquarePosterInfo squarePosterInfo) {
        this.posterInfo = squarePosterInfo;
    }

    public final void setRelationType(RelationType relationType) {
        Intrinsics.checkNotNullParameter(relationType, "<set-?>");
        this.relationType = relationType;
    }

    public final int unReadCount() {
        SquareBaseMessageRecord squareBaseMessageRecord = this.lastUnReadMsg;
        if (squareBaseMessageRecord != null) {
            return squareBaseMessageRecord.getUnreadCount();
        }
        return 0;
    }

    public final long unReadTimestamp() {
        SquareBaseMessageRecord squareBaseMessageRecord = this.lastUnReadMsg;
        if (squareBaseMessageRecord != null) {
            return squareBaseMessageRecord.getLastTimeStamp();
        }
        return 0L;
    }

    public final void updateUnReadCount(int count) {
        SquareBaseMessageRecord squareBaseMessageRecord = this.lastUnReadMsg;
        if (squareBaseMessageRecord != null) {
            squareBaseMessageRecord.setUnreadCount(count);
        }
    }

    public SquareAvatarExtra(String str, String str2, String cycleScheme, OnlineStatus onlineStatus, PlayState isPlayingPtt, boolean z16, boolean z17, LikeListInfo likeListInfo, boolean z18, int i3, CommonFootLabel commonFootLabel, SquareBaseMessageRecord squareBaseMessageRecord, SquarePosterInfo squarePosterInfo, boolean z19, RelationType relationType, SquarePageBackgroundInfo squarePageBackgroundInfo, String str3, int i16, MedalData medalData, SquareStrangerInfo squareStrangerInfo, SquareBlindBoxEntranceInfo squareBlindBoxEntranceInfo, boolean z26, SquareBubbleInfo squareBubbleInfo, Boolean bool, SquareIntimateInfo squareIntimateInfo, boolean z27) {
        Intrinsics.checkNotNullParameter(cycleScheme, "cycleScheme");
        Intrinsics.checkNotNullParameter(isPlayingPtt, "isPlayingPtt");
        Intrinsics.checkNotNullParameter(relationType, "relationType");
        this.textMood = str;
        this.audioMood = str2;
        this.cycleScheme = cycleScheme;
        this.onlineStatus = onlineStatus;
        this.isPlayingPtt = isPlayingPtt;
        this.isFixed = z16;
        this.needRingPagAnim = z17;
        this.likeUnReadInfo = likeListInfo;
        this.isMultiMotion = z18;
        this.labelType = i3;
        this.footLabel = commonFootLabel;
        this.lastUnReadMsg = squareBaseMessageRecord;
        this.posterInfo = squarePosterInfo;
        this.inSquare = z19;
        this.relationType = relationType;
        this.detailBackgroundInfo = squarePageBackgroundInfo;
        this.flowerBubbleText = str3;
        this.flowerCount = i16;
        this.flowerMedal = medalData;
        this.strangerExtra = squareStrangerInfo;
        this.blindBoxEntranceInfo = squareBlindBoxEntranceInfo;
        this.needBubbleAnim = z26;
        this.bubbleInfo = squareBubbleInfo;
        this.changeAvatarImageVisible = bool;
        this.intimateExtra = squareIntimateInfo;
        this.needIntimateAnim = z27;
    }

    public /* synthetic */ SquareAvatarExtra(String str, String str2, String str3, OnlineStatus onlineStatus, PlayState playState, boolean z16, boolean z17, LikeListInfo likeListInfo, boolean z18, int i3, CommonFootLabel commonFootLabel, SquareBaseMessageRecord squareBaseMessageRecord, SquarePosterInfo squarePosterInfo, boolean z19, RelationType relationType, SquarePageBackgroundInfo squarePageBackgroundInfo, String str4, int i16, MedalData medalData, SquareStrangerInfo squareStrangerInfo, SquareBlindBoxEntranceInfo squareBlindBoxEntranceInfo, boolean z26, SquareBubbleInfo squareBubbleInfo, Boolean bool, SquareIntimateInfo squareIntimateInfo, boolean z27, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? null : str, (i17 & 2) != 0 ? null : str2, (i17 & 4) != 0 ? "" : str3, (i17 & 8) != 0 ? null : onlineStatus, (i17 & 16) != 0 ? PlayState.INIT : playState, (i17 & 32) != 0 ? false : z16, (i17 & 64) != 0 ? false : z17, (i17 & 128) != 0 ? null : likeListInfo, (i17 & 256) != 0 ? false : z18, (i17 & 512) != 0 ? 0 : i3, (i17 & 1024) != 0 ? null : commonFootLabel, (i17 & 2048) != 0 ? null : squareBaseMessageRecord, (i17 & 4096) != 0 ? null : squarePosterInfo, (i17 & 8192) != 0 ? true : z19, (i17 & 16384) != 0 ? RelationType.FRIEND : relationType, (i17 & 32768) != 0 ? null : squarePageBackgroundInfo, (i17 & 65536) != 0 ? null : str4, (i17 & 131072) != 0 ? 0 : i16, (i17 & 262144) != 0 ? null : medalData, (i17 & 524288) != 0 ? null : squareStrangerInfo, (i17 & 1048576) != 0 ? null : squareBlindBoxEntranceInfo, (i17 & 2097152) != 0 ? true : z26, (i17 & 4194304) != 0 ? null : squareBubbleInfo, (i17 & 8388608) != 0 ? null : bool, (i17 & 16777216) != 0 ? null : squareIntimateInfo, (i17 & 33554432) == 0 ? z27 : true);
    }
}
