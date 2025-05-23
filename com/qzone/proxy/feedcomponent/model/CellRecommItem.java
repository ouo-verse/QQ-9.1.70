package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_recomm_item;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellRecommItem implements SmartParcelable {
    public static final String EXTEND_KEY_ALG = "algorithm_info";
    public static final String EXTEND_KEY_BG = "backgd_url";
    public static final String EXTEND_KEY_SEX = "sex";

    @NeedParcel
    public int buttonType;

    @NeedParcel
    public String content;

    @NeedParcel
    public boolean hasPlaySendAnimation;

    @NeedParcel
    public boolean iSpecialFollowed;

    @NeedParcel
    public PictureUrl iconUrlAfterClick;

    @NeedParcel
    public PictureUrl iconUrlBeforeClick;

    @NeedParcel
    public boolean isFollowed;

    @NeedParcel
    public boolean isFriend;

    @NeedParcel
    public int listStyleCurrentPage;

    @NeedParcel
    public User userInfo;

    @NeedParcel
    public String descriptionBeforeClick = "";

    @NeedParcel
    public String descriptionAfterClick = "";

    @NeedParcel
    public Map<String, String> extendinfo = null;
    public int minLine = -1;

    public String getSmartRemark() {
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            return map.get("huin_smart_remark");
        }
        return null;
    }

    public boolean isAddFollowButton() {
        return this.buttonType == 1;
    }

    public boolean isAddFriendButton() {
        return this.buttonType == 0;
    }

    public boolean isAddSpecialFollowButton() {
        return this.buttonType == 13;
    }

    public boolean isCommentButton() {
        return this.buttonType == 3;
    }

    public boolean isCommentNumButton() {
        return this.buttonType == 6;
    }

    public boolean isDoLikeButton() {
        return this.buttonType == 2;
    }

    public boolean isDoLikeNumButton() {
        return this.buttonType == 5;
    }

    public boolean isForwardButton() {
        return this.buttonType == 4;
    }

    public boolean isForwardNumButton() {
        return this.buttonType == 7;
    }

    public static CellRecommItem create(l lVar) {
        if (lVar == null || lVar.T == null) {
            return null;
        }
        CellRecommItem cellRecommItem = new CellRecommItem();
        User q16 = com.qzone.proxy.feedcomponent.util.e.q(lVar.T.userinfo);
        com.qzone.proxy.feedcomponent.util.e.c(lVar, q16);
        cellRecommItem.userInfo = q16;
        cellRecommItem.iconUrlBeforeClick = com.qzone.proxy.feedcomponent.util.e.n(lVar.T.icon_before_click);
        cellRecommItem.iconUrlAfterClick = com.qzone.proxy.feedcomponent.util.e.n(lVar.T.icon_after_click);
        cell_recomm_item cell_recomm_itemVar = lVar.T;
        cellRecommItem.descriptionBeforeClick = cell_recomm_itemVar.desc_before_click;
        cellRecommItem.descriptionAfterClick = cell_recomm_itemVar.desc_after_click;
        cellRecommItem.content = cell_recomm_itemVar.content;
        cellRecommItem.extendinfo = cell_recomm_itemVar.extendinfo;
        cellRecommItem.buttonType = cell_recomm_itemVar.ButtonType;
        return cellRecommItem;
    }
}
