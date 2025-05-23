package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgBubble;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgFont;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u0000 \u000b2\u00020\u0001:\u0003\u000b\f\rJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasAioData;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAioVasMsgData", "Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioMsgData;", "sendUin", "", "getAioVasPersonalData", "Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioPersonalData;", "troopUin", "chatType", "", "Companion", "VasAioMsgData", "VasAioPersonalData", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasAioData extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasAioData$Companion;", "", "()V", "testAvatarIdMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getTestAvatarIdMap", "()Ljava/util/HashMap;", "setTestAvatarIdMap", "(Ljava/util/HashMap;)V", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static HashMap<String, Integer> testAvatarIdMap;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put("1046146442", 13635);
            hashMap.put("125021540", 20197);
            testAvatarIdMap = hashMap;
        }

        Companion() {
        }

        @NotNull
        public final HashMap<String, Integer> getTestAvatarIdMap() {
            return testAvatarIdMap;
        }

        public final void setTestAvatarIdMap(@NotNull HashMap<String, Integer> hashMap) {
            Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
            testAvatarIdMap = hashMap;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0016j\b\u0012\u0004\u0012\u00020\u0004`\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001a\u0010(\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001a\u0010+\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001a\u00106\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001a\u00109\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001a\u0010<\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001a\u0010?\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001a\u0010B\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\u001a\u0010E\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001a\u0010H\u001a\u00020IX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010N\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR\u001a\u0010Q\u001a\u00020IX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010K\"\u0004\bS\u0010MR\u001a\u0010T\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR\u001a\u0010W\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\b\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioMsgData;", "", "()V", "avatarId", "", "getAvatarId", "()I", "setAvatarId", "(I)V", "bubbleDiyTextId", "getBubbleDiyTextId", "setBubbleDiyTextId", "bubbleId", "getBubbleId", "setBubbleId", "bubbleVoiceId", "getBubbleVoiceId", "setBubbleVoiceId", "canConvertToText", "getCanConvertToText", "setCanConvertToText", "carouselNamePlateIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCarouselNamePlateIds", "()Ljava/util/ArrayList;", "setCarouselNamePlateIds", "(Ljava/util/ArrayList;)V", "diyFontCfgUpdateTime", "getDiyFontCfgUpdateTime", "setDiyFontCfgUpdateTime", "diyFontImageId", "getDiyFontImageId", "setDiyFontImageId", "extendNamePlateId", "getExtendNamePlateId", "setExtendNamePlateId", MessageForRichState.SIGN_MSG_FONT_ID, "getFontId", "setFontId", "gameNamePlateId", "getGameNamePlateId", "setGameNamePlateId", "grayNamePlate", "getGrayNamePlate", "setGrayNamePlate", "isIceBreakMsg", "setIceBreakMsg", "magicFontType", "getMagicFontType", "setMagicFontType", "msgBigClubFlag", "getMsgBigClubFlag", "setMsgBigClubFlag", "msgBigClubLevel", "getMsgBigClubLevel", "setMsgBigClubLevel", "msgVipLevel", "getMsgVipLevel", "setMsgVipLevel", "msgVipType", "getMsgVipType", "setMsgVipType", "namePlateId", "getNamePlateId", "setNamePlateId", "namePlateType", "getNamePlateType", "setNamePlateType", "pendantDiyInfoId", "getPendantDiyInfoId", "setPendantDiyInfoId", "pendantId", "", "getPendantId", "()J", "setPendantId", "(J)V", "subBubbleId", "getSubBubbleId", "setSubBubbleId", "subFontId", "getSubFontId", "setSubFontId", "templateID", "getTemplateID", "setTemplateID", "vipStarFlag", "getVipStarFlag", "setVipStarFlag", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class VasAioMsgData {
        private int avatarId;
        private int bubbleDiyTextId;
        private int bubbleId;
        private int bubbleVoiceId;
        private int canConvertToText;

        @NotNull
        private ArrayList<Integer> carouselNamePlateIds = new ArrayList<>();
        private int diyFontCfgUpdateTime;
        private int diyFontImageId;
        private int extendNamePlateId;
        private int fontId;
        private int gameNamePlateId;
        private int grayNamePlate;
        private int isIceBreakMsg;
        private int magicFontType;
        private int msgBigClubFlag;
        private int msgBigClubLevel;
        private int msgVipLevel;
        private int msgVipType;
        private int namePlateId;
        private int namePlateType;
        private int pendantDiyInfoId;
        private long pendantId;
        private int subBubbleId;
        private long subFontId;
        private int templateID;
        private int vipStarFlag;

        public final int getAvatarId() {
            return this.avatarId;
        }

        public final int getBubbleDiyTextId() {
            return this.bubbleDiyTextId;
        }

        public final int getBubbleId() {
            return this.bubbleId;
        }

        public final int getBubbleVoiceId() {
            return this.bubbleVoiceId;
        }

        public final int getCanConvertToText() {
            return this.canConvertToText;
        }

        @NotNull
        public final ArrayList<Integer> getCarouselNamePlateIds() {
            return this.carouselNamePlateIds;
        }

        public final int getDiyFontCfgUpdateTime() {
            return this.diyFontCfgUpdateTime;
        }

        public final int getDiyFontImageId() {
            return this.diyFontImageId;
        }

        public final int getExtendNamePlateId() {
            return this.extendNamePlateId;
        }

        public final int getFontId() {
            return this.fontId;
        }

        public final int getGameNamePlateId() {
            return this.gameNamePlateId;
        }

        public final int getGrayNamePlate() {
            return this.grayNamePlate;
        }

        public final int getMagicFontType() {
            return this.magicFontType;
        }

        public final int getMsgBigClubFlag() {
            return this.msgBigClubFlag;
        }

        public final int getMsgBigClubLevel() {
            return this.msgBigClubLevel;
        }

        public final int getMsgVipLevel() {
            return this.msgVipLevel;
        }

        public final int getMsgVipType() {
            return this.msgVipType;
        }

        public final int getNamePlateId() {
            return this.namePlateId;
        }

        public final int getNamePlateType() {
            return this.namePlateType;
        }

        public final int getPendantDiyInfoId() {
            return this.pendantDiyInfoId;
        }

        public final long getPendantId() {
            return this.pendantId;
        }

        public final int getSubBubbleId() {
            return this.subBubbleId;
        }

        public final long getSubFontId() {
            return this.subFontId;
        }

        public final int getTemplateID() {
            return this.templateID;
        }

        public final int getVipStarFlag() {
            return this.vipStarFlag;
        }

        /* renamed from: isIceBreakMsg, reason: from getter */
        public final int getIsIceBreakMsg() {
            return this.isIceBreakMsg;
        }

        public final void setAvatarId(int i3) {
            this.avatarId = i3;
        }

        public final void setBubbleDiyTextId(int i3) {
            this.bubbleDiyTextId = i3;
        }

        public final void setBubbleId(int i3) {
            this.bubbleId = i3;
        }

        public final void setBubbleVoiceId(int i3) {
            this.bubbleVoiceId = i3;
        }

        public final void setCanConvertToText(int i3) {
            this.canConvertToText = i3;
        }

        public final void setCarouselNamePlateIds(@NotNull ArrayList<Integer> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.carouselNamePlateIds = arrayList;
        }

        public final void setDiyFontCfgUpdateTime(int i3) {
            this.diyFontCfgUpdateTime = i3;
        }

        public final void setDiyFontImageId(int i3) {
            this.diyFontImageId = i3;
        }

        public final void setExtendNamePlateId(int i3) {
            this.extendNamePlateId = i3;
        }

        public final void setFontId(int i3) {
            this.fontId = i3;
        }

        public final void setGameNamePlateId(int i3) {
            this.gameNamePlateId = i3;
        }

        public final void setGrayNamePlate(int i3) {
            this.grayNamePlate = i3;
        }

        public final void setIceBreakMsg(int i3) {
            this.isIceBreakMsg = i3;
        }

        public final void setMagicFontType(int i3) {
            this.magicFontType = i3;
        }

        public final void setMsgBigClubFlag(int i3) {
            this.msgBigClubFlag = i3;
        }

        public final void setMsgBigClubLevel(int i3) {
            this.msgBigClubLevel = i3;
        }

        public final void setMsgVipLevel(int i3) {
            this.msgVipLevel = i3;
        }

        public final void setMsgVipType(int i3) {
            this.msgVipType = i3;
        }

        public final void setNamePlateId(int i3) {
            this.namePlateId = i3;
        }

        public final void setNamePlateType(int i3) {
            this.namePlateType = i3;
        }

        public final void setPendantDiyInfoId(int i3) {
            this.pendantDiyInfoId = i3;
        }

        public final void setPendantId(long j3) {
            this.pendantId = j3;
        }

        public final void setSubBubbleId(int i3) {
            this.subBubbleId = i3;
        }

        public final void setSubFontId(long j3) {
            this.subFontId = j3;
        }

        public final void setTemplateID(int i3) {
            this.templateID = i3;
        }

        public final void setVipStarFlag(int i3) {
            this.vipStarFlag = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010P\u001a\u00020QH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0013j\b\u0012\u0004\u0012\u00020\u0004`\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR*\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0013j\b\u0012\u0004\u0012\u00020\u0004`\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001a\u00104\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\u001a\u00107\u001a\u000208X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001a\u0010@\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\u001a\u0010C\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR*\u0010F\u001a\u0012\u0012\u0004\u0012\u00020G0\u0013j\b\u0012\u0004\u0012\u00020G`\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0016\"\u0004\bI\u0010\u0018R\u001a\u0010J\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0006\"\u0004\bL\u0010\bR\u001a\u0010M\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0006\"\u0004\bO\u0010\b\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioPersonalData;", "", "()V", "aioBadgeShowSwitch", "", "getAioBadgeShowSwitch", "()I", "setAioBadgeShowSwitch", "(I)V", "avatarId", "getAvatarId", "setAvatarId", "bubble", "Lcom/tencent/qqnt/kernel/nativeinterface/VASMsgBubble;", "getBubble", "()Lcom/tencent/qqnt/kernel/nativeinterface/VASMsgBubble;", "setBubble", "(Lcom/tencent/qqnt/kernel/nativeinterface/VASMsgBubble;)V", "carouselNamePlateIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCarouselNamePlateIds", "()Ljava/util/ArrayList;", "setCarouselNamePlateIds", "(Ljava/util/ArrayList;)V", "colorName", "getColorName", "setColorName", "diyNamePlateContentIds", "getDiyNamePlateContentIds", "setDiyNamePlateContentIds", "diyNamePlateItemId", "getDiyNamePlateItemId", "setDiyNamePlateItemId", "extendNamePlateId", "getExtendNamePlateId", "setExtendNamePlateId", "font", "Lcom/tencent/qqnt/kernel/nativeinterface/VASMsgFont;", "getFont", "()Lcom/tencent/qqnt/kernel/nativeinterface/VASMsgFont;", "setFont", "(Lcom/tencent/qqnt/kernel/nativeinterface/VASMsgFont;)V", "gameNamePlateId", "getGameNamePlateId", "setGameNamePlateId", "grayNameplateFlag", "getGrayNameplateFlag", "setGrayNameplateFlag", "namePlateId", "getNamePlateId", "setNamePlateId", "pendantDiyInfoId", "getPendantDiyInfoId", "setPendantDiyInfoId", "pendantId", "", "getPendantId", "()J", "setPendantId", "(J)V", "troopColorNameId", "getTroopColorNameId", "setTroopColorNameId", "vaDataChangeRand", "getVaDataChangeRand", "setVaDataChangeRand", "vipLevel", "getVipLevel", "setVipLevel", "vipNumbers", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "getVipNumbers", "setVipNumbers", "vipStarFlag", "getVipStarFlag", "setVipStarFlag", "vipType", "getVipType", "setVipType", "toString", "", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class VasAioPersonalData {
        private int aioBadgeShowSwitch;
        private int avatarId;
        private int colorName;
        private int diyNamePlateItemId;
        private int extendNamePlateId;
        private int gameNamePlateId;
        private int grayNameplateFlag;
        private int namePlateId;
        private int pendantDiyInfoId;
        private long pendantId;
        private int troopColorNameId;
        private int vaDataChangeRand;
        private int vipLevel;
        private int vipStarFlag;
        private int vipType;

        @NotNull
        private ArrayList<VipData.VipNumberInfo> vipNumbers = new ArrayList<>();

        @NotNull
        private ArrayList<Integer> carouselNamePlateIds = new ArrayList<>();

        @NotNull
        private ArrayList<Integer> diyNamePlateContentIds = new ArrayList<>();

        @NotNull
        private VASMsgBubble bubble = new VASMsgBubble();

        @NotNull
        private VASMsgFont font = new VASMsgFont();

        public final int getAioBadgeShowSwitch() {
            return this.aioBadgeShowSwitch;
        }

        public final int getAvatarId() {
            return this.avatarId;
        }

        @NotNull
        public final VASMsgBubble getBubble() {
            return this.bubble;
        }

        @NotNull
        public final ArrayList<Integer> getCarouselNamePlateIds() {
            return this.carouselNamePlateIds;
        }

        public final int getColorName() {
            return this.colorName;
        }

        @NotNull
        public final ArrayList<Integer> getDiyNamePlateContentIds() {
            return this.diyNamePlateContentIds;
        }

        public final int getDiyNamePlateItemId() {
            return this.diyNamePlateItemId;
        }

        public final int getExtendNamePlateId() {
            return this.extendNamePlateId;
        }

        @NotNull
        public final VASMsgFont getFont() {
            return this.font;
        }

        public final int getGameNamePlateId() {
            return this.gameNamePlateId;
        }

        public final int getGrayNameplateFlag() {
            return this.grayNameplateFlag;
        }

        public final int getNamePlateId() {
            return this.namePlateId;
        }

        public final int getPendantDiyInfoId() {
            return this.pendantDiyInfoId;
        }

        public final long getPendantId() {
            return this.pendantId;
        }

        public final int getTroopColorNameId() {
            return this.troopColorNameId;
        }

        public final int getVaDataChangeRand() {
            return this.vaDataChangeRand;
        }

        public final int getVipLevel() {
            return this.vipLevel;
        }

        @NotNull
        public final ArrayList<VipData.VipNumberInfo> getVipNumbers() {
            return this.vipNumbers;
        }

        public final int getVipStarFlag() {
            return this.vipStarFlag;
        }

        public final int getVipType() {
            return this.vipType;
        }

        public final void setAioBadgeShowSwitch(int i3) {
            this.aioBadgeShowSwitch = i3;
        }

        public final void setAvatarId(int i3) {
            this.avatarId = i3;
        }

        public final void setBubble(@NotNull VASMsgBubble vASMsgBubble) {
            Intrinsics.checkNotNullParameter(vASMsgBubble, "<set-?>");
            this.bubble = vASMsgBubble;
        }

        public final void setCarouselNamePlateIds(@NotNull ArrayList<Integer> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.carouselNamePlateIds = arrayList;
        }

        public final void setColorName(int i3) {
            this.colorName = i3;
        }

        public final void setDiyNamePlateContentIds(@NotNull ArrayList<Integer> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.diyNamePlateContentIds = arrayList;
        }

        public final void setDiyNamePlateItemId(int i3) {
            this.diyNamePlateItemId = i3;
        }

        public final void setExtendNamePlateId(int i3) {
            this.extendNamePlateId = i3;
        }

        public final void setFont(@NotNull VASMsgFont vASMsgFont) {
            Intrinsics.checkNotNullParameter(vASMsgFont, "<set-?>");
            this.font = vASMsgFont;
        }

        public final void setGameNamePlateId(int i3) {
            this.gameNamePlateId = i3;
        }

        public final void setGrayNameplateFlag(int i3) {
            this.grayNameplateFlag = i3;
        }

        public final void setNamePlateId(int i3) {
            this.namePlateId = i3;
        }

        public final void setPendantDiyInfoId(int i3) {
            this.pendantDiyInfoId = i3;
        }

        public final void setPendantId(long j3) {
            this.pendantId = j3;
        }

        public final void setTroopColorNameId(int i3) {
            this.troopColorNameId = i3;
        }

        public final void setVaDataChangeRand(int i3) {
            this.vaDataChangeRand = i3;
        }

        public final void setVipLevel(int i3) {
            this.vipLevel = i3;
        }

        public final void setVipNumbers(@NotNull ArrayList<VipData.VipNumberInfo> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.vipNumbers = arrayList;
        }

        public final void setVipStarFlag(int i3) {
            this.vipStarFlag = i3;
        }

        public final void setVipType(int i3) {
            this.vipType = i3;
        }

        @NotNull
        public String toString() {
            return "VasAioPersonalData(colorName=" + this.colorName + ", troopColorNameId=" + this.troopColorNameId + ", vipNumbers=" + this.vipNumbers + ", vaDataChangeRand=" + this.vaDataChangeRand + ", grayNameplateFlag=" + this.grayNameplateFlag + ", vipType=" + this.vipType + ", vipLevel=" + this.vipLevel + ", namePlateId=" + this.namePlateId + ", carouselNamePlateIds=" + this.carouselNamePlateIds + ", extendNamePlateId=" + this.extendNamePlateId + ", gameNamePlateId=" + this.gameNamePlateId + ", vipStarFlag=" + this.vipStarFlag + ", diyNamePlateItemId=" + this.diyNamePlateItemId + ", diyNamePlateContentIds=" + this.diyNamePlateContentIds + ", avatarId=" + this.avatarId + ", pendantId=" + this.pendantId + ", pendantDiyInfoId=" + this.pendantDiyInfoId + ", bubble=" + this.bubble + ", font=" + this.font + ")";
        }
    }

    @NotNull
    VasAioMsgData getAioVasMsgData(@NotNull String sendUin);

    @NotNull
    VasAioPersonalData getAioVasPersonalData(@NotNull String troopUin, @NotNull String sendUin, int chatType);
}
