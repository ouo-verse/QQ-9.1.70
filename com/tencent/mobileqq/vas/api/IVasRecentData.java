package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasRecentData;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getFriendsVipData", "Lcom/tencent/mobileqq/vas/api/IVasRecentData$FriendsVipData;", "uin", "", "needDb", "", "FriendsVipData", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasRecentData extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001a\u0010(\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001a\u0010+\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001a\u00104\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\u001a\u00107\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001a\u0010:\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u001a\u0010=\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\b\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasRecentData$FriendsVipData;", "", "()V", "bubbleId", "", "getBubbleId", "()I", "setBubbleId", "(I)V", "carouselNamePlateIds", "Ljava/util/ArrayList;", "getCarouselNamePlateIds", "()Ljava/util/ArrayList;", "setCarouselNamePlateIds", "(Ljava/util/ArrayList;)V", "colorName", "getColorName", "setColorName", "diyNamePlateContentIds", "getDiyNamePlateContentIds", "setDiyNamePlateContentIds", "diyNamePlateItemId", "getDiyNamePlateItemId", "setDiyNamePlateItemId", MessageForRichState.SIGN_MSG_FONT_ID, "getFontId", "setFontId", "gameCardId", "getGameCardId", "setGameCardId", "grayNameplateFlag", "getGrayNameplateFlag", "setGrayNameplateFlag", "isLove", "", "()Z", "setLove", "(Z)V", "isSuperVip", "setSuperVip", "loveChatItemId", "getLoveChatItemId", "setLoveChatItemId", "namePlateId", "getNamePlateId", "setNamePlateId", "pendantItemId", "getPendantItemId", "setPendantItemId", "specialShapeMaskId", "getSpecialShapeMaskId", "setSpecialShapeMaskId", "themePendantId", "getThemePendantId", "setThemePendantId", "vipIconEx", "getVipIconEx", "setVipIconEx", "vipLevel", "getVipLevel", "setVipLevel", "vipType", "getVipType", "setVipType", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class FriendsVipData {
        private int bubbleId;
        private int colorName;
        private int diyNamePlateItemId;
        private int fontId;
        private int gameCardId;
        private int grayNameplateFlag;
        private boolean isLove;
        private boolean isSuperVip;
        private int loveChatItemId;
        private int namePlateId;
        private int pendantItemId;
        private int specialShapeMaskId;
        private int themePendantId;
        private int vipIconEx;
        private int vipLevel;
        private int vipType;

        @NotNull
        private ArrayList<Integer> carouselNamePlateIds = new ArrayList<>();

        @NotNull
        private ArrayList<Integer> diyNamePlateContentIds = new ArrayList<>();

        public final int getBubbleId() {
            return this.bubbleId;
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

        public final int getFontId() {
            return this.fontId;
        }

        public final int getGameCardId() {
            return this.gameCardId;
        }

        public final int getGrayNameplateFlag() {
            return this.grayNameplateFlag;
        }

        public final int getLoveChatItemId() {
            return this.loveChatItemId;
        }

        public final int getNamePlateId() {
            return this.namePlateId;
        }

        public final int getPendantItemId() {
            return this.pendantItemId;
        }

        public final int getSpecialShapeMaskId() {
            return this.specialShapeMaskId;
        }

        public final int getThemePendantId() {
            return this.themePendantId;
        }

        public final int getVipIconEx() {
            return this.vipIconEx;
        }

        public final int getVipLevel() {
            return this.vipLevel;
        }

        public final int getVipType() {
            return this.vipType;
        }

        /* renamed from: isLove, reason: from getter */
        public final boolean getIsLove() {
            return this.isLove;
        }

        /* renamed from: isSuperVip, reason: from getter */
        public final boolean getIsSuperVip() {
            return this.isSuperVip;
        }

        public final void setBubbleId(int i3) {
            this.bubbleId = i3;
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

        public final void setFontId(int i3) {
            this.fontId = i3;
        }

        public final void setGameCardId(int i3) {
            this.gameCardId = i3;
        }

        public final void setGrayNameplateFlag(int i3) {
            this.grayNameplateFlag = i3;
        }

        public final void setLove(boolean z16) {
            this.isLove = z16;
        }

        public final void setLoveChatItemId(int i3) {
            this.loveChatItemId = i3;
        }

        public final void setNamePlateId(int i3) {
            this.namePlateId = i3;
        }

        public final void setPendantItemId(int i3) {
            this.pendantItemId = i3;
        }

        public final void setSpecialShapeMaskId(int i3) {
            this.specialShapeMaskId = i3;
        }

        public final void setSuperVip(boolean z16) {
            this.isSuperVip = z16;
        }

        public final void setThemePendantId(int i3) {
            this.themePendantId = i3;
        }

        public final void setVipIconEx(int i3) {
            this.vipIconEx = i3;
        }

        public final void setVipLevel(int i3) {
            this.vipLevel = i3;
        }

        public final void setVipType(int i3) {
            this.vipType = i3;
        }
    }

    @NotNull
    FriendsVipData getFriendsVipData(@NotNull String uin);

    @NotNull
    FriendsVipData getFriendsVipData(@NotNull String uin, boolean needDb);
}
