package com.tencent.ecommerce.repo.consumer.resp;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.ecommerce.base.config.annotation.RawStringJsonAdapter;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010P\u001a\u00020\bH\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0016\u0010\u0019\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0016\u0010\u001b\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\nR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R&\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\nR\u0016\u0010)\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\nR\u0016\u0010+\u001a\u00020,8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00148\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0016R\u0016\u00100\u001a\u00020\u00148\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0016R&\u00101\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u0016\u00103\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\nR\u0016\u00105\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\nR\u0016\u00107\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\nR\u0014\u00109\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\nR\u0016\u0010;\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\nR\u0016\u0010=\u001a\u00020>8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020B8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u001e\u0010E\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\n\"\u0004\bG\u0010HR\u001e\u0010I\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\n\"\u0004\bK\u0010HR\u0016\u0010L\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010\nR\u0014\u0010N\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010\n\u00a8\u0006Q"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "", "()V", "action", "", "getAction", "()I", "activityEndTime", "", "getActivityEndTime", "()Ljava/lang/String;", "activityMaskUrl", "getActivityMaskUrl", "activityStartTime", "getActivityStartTime", "activityTagInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/ActivityTagInfo;", "getActivityTagInfo", "()Lcom/tencent/ecommerce/repo/consumer/resp/ActivityTagInfo;", "backbuttonSwitch", "", "getBackbuttonSwitch", "()Z", "buttonBgColor", "getButtonBgColor", "buttonColor", "getButtonColor", "buttonEndColor", "getButtonEndColor", "buttonInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/ButtonInfo;", "getButtonInfo", "()Lcom/tencent/ecommerce/repo/consumer/resp/ButtonInfo;", "buttonJumpInfoArray", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/repo/consumer/resp/JumpInfo;", "Lkotlin/collections/ArrayList;", "getButtonJumpInfoArray", "()Ljava/util/ArrayList;", "buttonStartColor", "getButtonStartColor", "buttonText", "getButtonText", "gameInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/GameInfo;", "getGameInfo", "()Lcom/tencent/ecommerce/repo/consumer/resp/GameInfo;", "isRectangleCover", "isShowScore", "jumpInfoArray", "getJumpInfoArray", "originPrice", "getOriginPrice", "pagUrl", "getPagUrl", "picUrl", "getPicUrl", "price", "getPrice", "promotionText", "getPromotionText", "ratingScore", "", "getRatingScore", "()F", "redirectLinkInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/RedirectLinkInfo;", "getRedirectLinkInfo", "()Lcom/tencent/ecommerce/repo/consumer/resp/RedirectLinkInfo;", "richSubTitle", "getRichSubTitle", "setRichSubTitle", "(Ljava/lang/String;)V", "richTitle", "getRichTitle", "setRichTitle", "subtitle", "getSubtitle", "title", "getTitle", "toString", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class UIInfo {

    @SerializedName("action")
    private final int action;

    @SerializedName("backbutton_switch")
    private final boolean backbuttonSwitch;

    @SerializedName("is_rectangle_cover")
    private final boolean isRectangleCover;

    @SerializedName("is_show_score")
    private final boolean isShowScore;

    @SerializedName("rating_score")
    private final float ratingScore;
    private final String title = "";

    @SerializedName("sub_title")
    private final String subtitle = "";

    @SerializedName("pag_url")
    private final String pagUrl = "";

    @SerializedName("pic_url")
    private final String picUrl = "";

    @SerializedName("activity_mask_url")
    private final String activityMaskUrl = "";

    @SerializedName("redirect_link_info")
    private final RedirectLinkInfo redirectLinkInfo = new RedirectLinkInfo();
    private final String price = "";

    @SerializedName("origin_price")
    private final String originPrice = "";

    @SerializedName(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT)
    private final String buttonText = "";

    @SerializedName("button_bg_color")
    private final String buttonBgColor = "";

    @SerializedName("button_color")
    private final String buttonColor = "";

    @SerializedName("button_start_color")
    private final String buttonStartColor = "";

    @SerializedName("button_end_color")
    private final String buttonEndColor = "";

    @SerializedName("game_info")
    private final GameInfo gameInfo = new GameInfo();

    @SerializedName("rich_title")
    @JsonAdapter(RawStringJsonAdapter.class)
    private String richTitle = "";

    @SerializedName("rich_sub_title_1")
    @JsonAdapter(RawStringJsonAdapter.class)
    private String richSubTitle = "";

    @SerializedName("tag")
    private final ActivityTagInfo activityTagInfo = new ActivityTagInfo();

    @SerializedName("activity_start_time")
    private final String activityStartTime = "";

    @SerializedName("activity_end_time")
    private final String activityEndTime = "";

    @SerializedName("promotion_text")
    private final String promotionText = "";

    @SerializedName("jump_info")
    private final ArrayList<JumpInfo> jumpInfoArray = new ArrayList<>();

    @SerializedName("button_jump_info")
    private final ArrayList<JumpInfo> buttonJumpInfoArray = new ArrayList<>();

    @SerializedName("button")
    private final ButtonInfo buttonInfo = new ButtonInfo();

    public final int getAction() {
        return this.action;
    }

    public final String getActivityEndTime() {
        return this.activityEndTime;
    }

    public final String getActivityMaskUrl() {
        return this.activityMaskUrl;
    }

    public final String getActivityStartTime() {
        return this.activityStartTime;
    }

    public final ActivityTagInfo getActivityTagInfo() {
        return this.activityTagInfo;
    }

    public final boolean getBackbuttonSwitch() {
        return this.backbuttonSwitch;
    }

    public final String getButtonBgColor() {
        return this.buttonBgColor;
    }

    public final String getButtonColor() {
        return this.buttonColor;
    }

    public final String getButtonEndColor() {
        return this.buttonEndColor;
    }

    public final ButtonInfo getButtonInfo() {
        return this.buttonInfo;
    }

    public final ArrayList<JumpInfo> getButtonJumpInfoArray() {
        return this.buttonJumpInfoArray;
    }

    public final String getButtonStartColor() {
        return this.buttonStartColor;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final GameInfo getGameInfo() {
        return this.gameInfo;
    }

    public final ArrayList<JumpInfo> getJumpInfoArray() {
        return this.jumpInfoArray;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final String getPagUrl() {
        return this.pagUrl;
    }

    public final String getPicUrl() {
        return this.picUrl;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getPromotionText() {
        return this.promotionText;
    }

    public final float getRatingScore() {
        return this.ratingScore;
    }

    public final RedirectLinkInfo getRedirectLinkInfo() {
        return this.redirectLinkInfo;
    }

    public final String getRichSubTitle() {
        return this.richSubTitle;
    }

    public final String getRichTitle() {
        return this.richTitle;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    /* renamed from: isRectangleCover, reason: from getter */
    public final boolean getIsRectangleCover() {
        return this.isRectangleCover;
    }

    /* renamed from: isShowScore, reason: from getter */
    public final boolean getIsShowScore() {
        return this.isShowScore;
    }

    public final void setRichSubTitle(String str) {
        this.richSubTitle = str;
    }

    public final void setRichTitle(String str) {
        this.richTitle = str;
    }

    public String toString() {
        return "UIInfo(title=" + this.title + ", pagUrl=" + this.pagUrl + ", picUrl=" + this.picUrl + ", redirectLinkInfo=" + this.redirectLinkInfo + ", price=" + this.price + ", buttonText=" + this.buttonText + ", richTitle=" + this.richTitle + ", richSubTitle=" + this.richSubTitle + ", buttonBgColor=" + this.buttonBgColor + ",buttonStartColor=" + this.buttonStartColor + ",buttonEndColor=" + this.buttonEndColor + ",backbuttonSwitch=" + this.backbuttonSwitch + ",isShowScore=" + this.isShowScore + ",ratingScore=" + this.ratingScore + ",action=" + this.action + ')';
    }
}
