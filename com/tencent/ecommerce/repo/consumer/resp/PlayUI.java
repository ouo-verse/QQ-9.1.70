package com.tencent.ecommerce.repo.consumer.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0016\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0016\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0016\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0016\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0016\u0010\u001d\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0016\u0010\u001f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0016\u0010!\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0016\u0010#\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0016\u0010%\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0016\u0010'\u001a\u00020(8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*\u00a8\u0006,"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/PlayUI;", "", "()V", "bigCardActivityUIInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "getBigCardActivityUIInfo", "()Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "bigCardGamePromotion", "getBigCardGamePromotion", "bigCardProductUIInfo", "getBigCardProductUIInfo", "bottomFloatingCardUIInfo", "getBottomFloatingCardUIInfo", "mediumCardActivityUIInfo", "getMediumCardActivityUIInfo", "mediumCardGameUIInfo", "getMediumCardGameUIInfo", "mediumCardGradientUIInfo", "getMediumCardGradientUIInfo", "mediumCardMiniGameUIInfo", "getMediumCardMiniGameUIInfo", "mediumCardProductUIInfo", "getMediumCardProductUIInfo", "mediumCardWeakenUIInfo", "getMediumCardWeakenUIInfo", "mediumFilmCardProductUIInfo", "getMediumFilmCardProductUIInfo", "samllCardActivityUIInfo", "getSamllCardActivityUIInfo", "samllCardGradientUIInfo", "getSamllCardGradientUIInfo", "smallCardGameUIInfo", "getSmallCardGameUIInfo", "smallCardMiniGameUIInfo", "getSmallCardMiniGameUIInfo", "smallCardProductUIInfo", "getSmallCardProductUIInfo", "topViewUIInfo", "getTopViewUIInfo", "uiType", "", "getUiType", "()I", "UIType", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class PlayUI {

    @SerializedName("ui_type")
    private final int uiType = -1;

    @SerializedName(alternate = {"ui_small_card_ng"}, value = "ui_small_card_product")
    private final UIInfo smallCardProductUIInfo = new UIInfo();

    @SerializedName(alternate = {"ui_big_card_ng"}, value = "ui_big_card_product")
    private final UIInfo mediumCardProductUIInfo = new UIInfo();

    @SerializedName("ui_small_card_game_promotion")
    private final UIInfo smallCardGameUIInfo = new UIInfo();

    @SerializedName("ui_big_card_game_promotion")
    private final UIInfo mediumCardGameUIInfo = new UIInfo();

    @SerializedName("ui_small_card_mini_game_promotion")
    private final UIInfo smallCardMiniGameUIInfo = new UIInfo();

    @SerializedName("ui_big_card_mini_game_promotion")
    private final UIInfo mediumCardMiniGameUIInfo = new UIInfo();

    @SerializedName("ui_max_card_game_promotion")
    private final UIInfo bigCardGamePromotion = new UIInfo();

    @SerializedName("ui_small_card")
    private final UIInfo samllCardGradientUIInfo = new UIInfo();

    @SerializedName("ui_gradient_card")
    private final UIInfo mediumCardGradientUIInfo = new UIInfo();

    @SerializedName("ui_activity_small_card")
    private final UIInfo samllCardActivityUIInfo = new UIInfo();

    @SerializedName("ui_activity_card")
    private final UIInfo mediumCardActivityUIInfo = new UIInfo();

    @SerializedName("ui_weaken_card")
    private final UIInfo mediumCardWeakenUIInfo = new UIInfo();

    @SerializedName("ui_max_card")
    private final UIInfo bigCardProductUIInfo = new UIInfo();

    @SerializedName("ui_film_big_card")
    private final UIInfo mediumFilmCardProductUIInfo = new UIInfo();

    @SerializedName("ui_top_view")
    private final UIInfo topViewUIInfo = new UIInfo();

    @SerializedName("ui_bottom_floating_card")
    private final UIInfo bottomFloatingCardUIInfo = new UIInfo();

    @SerializedName("ui_activity_max_card")
    private final UIInfo bigCardActivityUIInfo = new UIInfo();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/PlayUI$UIType;", "", "()V", "ACTIVITY_BIG_CARD_PRODUCT", "", "ACTIVITY_MEDIUM_CARD_PRODUCT", "ACTIVITY_SMALL_CARD_PRODUCT", "BIG_CARD_GAME_RECOMMEND", "BIG_CARD_LEFT_PIC_BOTTOM_BUTTON", "BIG_CARD_MINI_GAME_RECOMMEND", "BIG_CARD_NG", "BIG_CARD_ONLY_PIC", "BIG_CARD_SHAPED_PIC", "BIG_CARD_TOP_PIC_BOTTOM_BUTTON", "BIG_CARD_TOP_PIC_BOTTOM_TITLE", "BIG_GUIDE_CARD_NG", "BOTTOM_FLOATING_CARD", "COMMENT_UI_CARD", "GRADIENT_MEDIUM_CARD_NG", "GRADIENT_SMALL_CARD_NG", "MEDIUM_CARD_GAME", "MEDIUM_CARD_NG", "MEDIUM_CARD_PRODUCT", "MEDIUM_VIDEO_CARD_NG", "SMALL_CARD_GAME", "SMALL_CARD_GAME_RECOMMEND", "SMALL_CARD_MINI_GAME_RECOMMEND", "SMALL_CARD_NG", "SMALL_CARD_PRODUCT", "TOP_VIEW", "UNKOWN", "WEAKEN_MEDIUM_CARD_NG", "WEAKEN_SMALL_CARD_NG", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class UIType {
        public static final int ACTIVITY_BIG_CARD_PRODUCT = 10302;
        public static final int ACTIVITY_MEDIUM_CARD_PRODUCT = 10301;
        public static final int ACTIVITY_SMALL_CARD_PRODUCT = 10300;
        public static final int BIG_CARD_GAME_RECOMMEND = 400;
        public static final int BIG_CARD_LEFT_PIC_BOTTOM_BUTTON = 422;
        public static final int BIG_CARD_MINI_GAME_RECOMMEND = 401;
        public static final int BIG_CARD_NG = 10200;
        public static final int BIG_CARD_ONLY_PIC = 425;
        public static final int BIG_CARD_SHAPED_PIC = 426;
        public static final int BIG_CARD_TOP_PIC_BOTTOM_BUTTON = 424;
        public static final int BIG_CARD_TOP_PIC_BOTTOM_TITLE = 423;
        public static final int BIG_GUIDE_CARD_NG = 10201;
        public static final int BOTTOM_FLOATING_CARD = 10602;
        public static final int COMMENT_UI_CARD = 700;
        public static final int GRADIENT_MEDIUM_CARD_NG = 10501;
        public static final int GRADIENT_SMALL_CARD_NG = 10500;
        public static final UIType INSTANCE = new UIType();
        public static final int MEDIUM_CARD_GAME = 421;
        public static final int MEDIUM_CARD_NG = 10100;
        public static final int MEDIUM_CARD_PRODUCT = 600;
        public static final int MEDIUM_VIDEO_CARD_NG = 10600;
        public static final int SMALL_CARD_GAME = 420;
        public static final int SMALL_CARD_GAME_RECOMMEND = 300;
        public static final int SMALL_CARD_MINI_GAME_RECOMMEND = 301;
        public static final int SMALL_CARD_NG = 10000;
        public static final int SMALL_CARD_PRODUCT = 500;
        public static final int TOP_VIEW = 10601;
        public static final int UNKOWN = -1;
        public static final int WEAKEN_MEDIUM_CARD_NG = 10401;
        public static final int WEAKEN_SMALL_CARD_NG = 10400;

        UIType() {
        }
    }

    public final UIInfo getBigCardActivityUIInfo() {
        return this.bigCardActivityUIInfo;
    }

    public final UIInfo getBigCardGamePromotion() {
        return this.bigCardGamePromotion;
    }

    public final UIInfo getBigCardProductUIInfo() {
        return this.bigCardProductUIInfo;
    }

    public final UIInfo getBottomFloatingCardUIInfo() {
        return this.bottomFloatingCardUIInfo;
    }

    public final UIInfo getMediumCardActivityUIInfo() {
        return this.mediumCardActivityUIInfo;
    }

    public final UIInfo getMediumCardGameUIInfo() {
        return this.mediumCardGameUIInfo;
    }

    public final UIInfo getMediumCardGradientUIInfo() {
        return this.mediumCardGradientUIInfo;
    }

    public final UIInfo getMediumCardMiniGameUIInfo() {
        return this.mediumCardMiniGameUIInfo;
    }

    public final UIInfo getMediumCardProductUIInfo() {
        return this.mediumCardProductUIInfo;
    }

    public final UIInfo getMediumCardWeakenUIInfo() {
        return this.mediumCardWeakenUIInfo;
    }

    public final UIInfo getMediumFilmCardProductUIInfo() {
        return this.mediumFilmCardProductUIInfo;
    }

    public final UIInfo getSamllCardActivityUIInfo() {
        return this.samllCardActivityUIInfo;
    }

    public final UIInfo getSamllCardGradientUIInfo() {
        return this.samllCardGradientUIInfo;
    }

    public final UIInfo getSmallCardGameUIInfo() {
        return this.smallCardGameUIInfo;
    }

    public final UIInfo getSmallCardMiniGameUIInfo() {
        return this.smallCardMiniGameUIInfo;
    }

    public final UIInfo getSmallCardProductUIInfo() {
        return this.smallCardProductUIInfo;
    }

    public final UIInfo getTopViewUIInfo() {
        return this.topViewUIInfo;
    }

    public final int getUiType() {
        return this.uiType;
    }
}
