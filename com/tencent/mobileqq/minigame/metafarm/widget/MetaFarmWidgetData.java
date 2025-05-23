package com.tencent.mobileqq.minigame.metafarm.widget;

import com.google.gson.annotations.SerializedName;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0003!\"#B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020\fH\u0016R.\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R \u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmWidgetData;", "Ljava/io/Serializable;", "()V", "cards", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmWidgetData$CropCard;", "Lkotlin/collections/ArrayList;", "getCards", "()Ljava/util/ArrayList;", "setCards", "(Ljava/util/ArrayList;)V", WadlProxyConsts.KEY_JUMP_URL, "", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "nextPullGapSecond", "", "getNextPullGapSecond", "()J", "setNextPullGapSecond", "(J)V", "pullTs", "getPullTs", "setPullTs", ITVKPlayerEventListener.KEY_USER_INFO, "Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmWidgetData$UserInfo;", "getUserInfo", "()Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmWidgetData$UserInfo;", "setUserInfo", "(Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmWidgetData$UserInfo;)V", "toString", "Companion", "CropCard", "UserInfo", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class MetaFarmWidgetData implements Serializable {
    public static final int IMG_TYPE_AVATAR = 1;
    public static final int IMG_TYPE_COIN = 3;
    public static final int IMG_TYPE_CROP_ICON = 4;
    public static final int IMG_TYPE_FARM_LEVEL = 2;

    @SerializedName("pullTs")
    private long pullTs;

    @SerializedName(ITVKPlayerEventListener.KEY_USER_INFO)
    @Nullable
    private UserInfo userInfo;

    @SerializedName("nextPullGapSecond")
    private long nextPullGapSecond = 120;

    @SerializedName("cards")
    @NotNull
    private ArrayList<CropCard> cards = new ArrayList<>();

    @SerializedName(WadlProxyConsts.KEY_JUMP_URL)
    @NotNull
    private String jumpUrl = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmWidgetData$CropCard;", "Ljava/io/Serializable;", "()V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "iconImgPath", "getIconImgPath", "setIconImgPath", "text", "getText", IECSearchBar.METHOD_SET_TEXT, "textHighlight", "", "getTextHighlight", "()Z", "setTextHighlight", "(Z)V", "timeText", "getTimeText", "setTimeText", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "toString", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class CropCard implements Serializable {

        @SerializedName("textHighlight")
        private boolean textHighlight;

        @SerializedName("timestamp")
        private long timestamp;

        @SerializedName("icon")
        @NotNull
        private String icon = "";

        @SerializedName("iconImgPath")
        @NotNull
        private String iconImgPath = "";

        @SerializedName("text")
        @NotNull
        private String text = "";

        @SerializedName("timeText")
        @NotNull
        private String timeText = "";

        @NotNull
        public final String getIcon() {
            return this.icon;
        }

        @NotNull
        public final String getIconImgPath() {
            return this.iconImgPath;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public final boolean getTextHighlight() {
            return this.textHighlight;
        }

        @NotNull
        public final String getTimeText() {
            return this.timeText;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final void setIcon(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.icon = str;
        }

        public final void setIconImgPath(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.iconImgPath = str;
        }

        public final void setText(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }

        public final void setTextHighlight(boolean z16) {
            this.textHighlight = z16;
        }

        public final void setTimeText(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.timeText = str;
        }

        public final void setTimestamp(long j3) {
            this.timestamp = j3;
        }

        @NotNull
        public String toString() {
            return "CropCard(icon='" + this.icon + "', iconImgPath='" + this.iconImgPath + "', text='" + this.text + "', textHighlight=" + this.textHighlight + ", timeText='" + this.timeText + "', timestamp=" + this.timestamp + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00100\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmWidgetData$UserInfo;", "Ljava/io/Serializable;", "()V", "avatar", "", "getAvatar", "()Ljava/lang/String;", QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR, "(Ljava/lang/String;)V", "avatarImgPath", "getAvatarImgPath", "setAvatarImgPath", "blessingTimes", "", "getBlessingTimes", "()I", "setBlessingTimes", "(I)V", "coin", "", "getCoin", "()J", "setCoin", "(J)V", "coinDesc", "getCoinDesc", "setCoinDesc", "coinIconImgPath", "getCoinIconImgPath", "setCoinIconImgPath", "coinIconUrl", "getCoinIconUrl", "setCoinIconUrl", "level", "getLevel", "setLevel", "levelIconImgPath", "getLevelIconImgPath", "setLevelIconImgPath", "levelIconUrl", "getLevelIconUrl", "setLevelIconUrl", "nick", "getNick", "setNick", "stealableTimes", "getStealableTimes", "setStealableTimes", "toString", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class UserInfo implements Serializable {

        @SerializedName("blessingTimes")
        private int blessingTimes;

        @SerializedName("coin")
        private long coin;

        @SerializedName("level")
        private int level;

        @SerializedName("stealableTimes")
        private int stealableTimes;

        @SerializedName("nick")
        @NotNull
        private String nick = "";

        @SerializedName("avatar")
        @NotNull
        private String avatar = "";

        @SerializedName("avatarImgPath")
        @NotNull
        private String avatarImgPath = "";

        @SerializedName("levelIconUrl")
        @NotNull
        private String levelIconUrl = "";

        @SerializedName("levelIconImgPath")
        @NotNull
        private String levelIconImgPath = "";

        @SerializedName("coinDesc")
        @NotNull
        private String coinDesc = "";

        @SerializedName("coinIconUrl")
        @NotNull
        private String coinIconUrl = "";

        @SerializedName("coinIconImgPath")
        @NotNull
        private String coinIconImgPath = "";

        @NotNull
        public final String getAvatar() {
            return this.avatar;
        }

        @NotNull
        public final String getAvatarImgPath() {
            return this.avatarImgPath;
        }

        public final int getBlessingTimes() {
            return this.blessingTimes;
        }

        public final long getCoin() {
            return this.coin;
        }

        @NotNull
        public final String getCoinDesc() {
            return this.coinDesc;
        }

        @NotNull
        public final String getCoinIconImgPath() {
            return this.coinIconImgPath;
        }

        @NotNull
        public final String getCoinIconUrl() {
            return this.coinIconUrl;
        }

        public final int getLevel() {
            return this.level;
        }

        @NotNull
        public final String getLevelIconImgPath() {
            return this.levelIconImgPath;
        }

        @NotNull
        public final String getLevelIconUrl() {
            return this.levelIconUrl;
        }

        @NotNull
        public final String getNick() {
            return this.nick;
        }

        public final int getStealableTimes() {
            return this.stealableTimes;
        }

        public final void setAvatar(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.avatar = str;
        }

        public final void setAvatarImgPath(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.avatarImgPath = str;
        }

        public final void setBlessingTimes(int i3) {
            this.blessingTimes = i3;
        }

        public final void setCoin(long j3) {
            this.coin = j3;
        }

        public final void setCoinDesc(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.coinDesc = str;
        }

        public final void setCoinIconImgPath(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.coinIconImgPath = str;
        }

        public final void setCoinIconUrl(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.coinIconUrl = str;
        }

        public final void setLevel(int i3) {
            this.level = i3;
        }

        public final void setLevelIconImgPath(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.levelIconImgPath = str;
        }

        public final void setLevelIconUrl(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.levelIconUrl = str;
        }

        public final void setNick(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.nick = str;
        }

        public final void setStealableTimes(int i3) {
            this.stealableTimes = i3;
        }

        @NotNull
        public String toString() {
            return "UserInfo(nick='" + this.nick + "', avatar='" + this.avatar + "', avatarImgPath='" + this.avatarImgPath + "', level=" + this.level + ", levelIconUrl='" + this.levelIconUrl + "', levelIconImgPath='" + this.levelIconImgPath + "', coin=" + this.coin + ", coinDesc='" + this.coinDesc + "', coinIconUrl='" + this.coinIconUrl + "', coinIconImgPath='" + this.coinIconImgPath + "', stealableTimes=" + this.stealableTimes + ", blessingTimes=" + this.blessingTimes + ')';
        }
    }

    @NotNull
    public final ArrayList<CropCard> getCards() {
        return this.cards;
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final long getNextPullGapSecond() {
        return this.nextPullGapSecond;
    }

    public final long getPullTs() {
        return this.pullTs;
    }

    @Nullable
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public final void setCards(@NotNull ArrayList<CropCard> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.cards = arrayList;
    }

    public final void setJumpUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void setNextPullGapSecond(long j3) {
        this.nextPullGapSecond = j3;
    }

    public final void setPullTs(long j3) {
        this.pullTs = j3;
    }

    public final void setUserInfo(@Nullable UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @NotNull
    public String toString() {
        return "MetaFarmWidgetData(pullTs=" + this.pullTs + ", nextPullGapSecond=" + this.nextPullGapSecond + ", userInfo=" + this.userInfo + ", cards=" + this.cards + ", jumpUrl='" + this.jumpUrl + "')";
    }
}
