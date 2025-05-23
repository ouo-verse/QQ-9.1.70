package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellRecommItem;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.RelativeAreaLayout;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasRecomFollowListItemView extends QzoneCanvasAreaView {

    @DittoField
    RelativeAreaLayout feed_recommend_follow_contentview;

    @DittoField
    RichCanvasTextArea feed_recommend_follow_description;

    @DittoField
    AsyncCanvasImageArea feed_recommend_follow_icon;

    @DittoField
    RelativeAreaLayout feed_recommend_follow_item_layout;

    @DittoField
    RichCanvasTextArea feed_recommend_follow_nickname;

    @DittoField
    DittoArea feed_recommmend_follow_divider;
    private BusinessFeedData mFeedData;
    private int mListIndex;

    @DittoField
    DittoButtonArea recommend_follow_add_button;

    public CanvasRecomFollowListItemView(Context context) {
        super(context, null);
        this.mListIndex = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"recommend_follow_add_button", "feed_recommend_follow_item_layout"})
    public void onCanvasAreaClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        BusinessFeedData businessFeedData;
        CellRecommItem cellRecommItem;
        User user;
        g gVar = this.onFeedElementClickListener;
        if (gVar == null || (businessFeedData = this.mFeedData) == null || (cellRecommItem = businessFeedData.cellRecommItem) == null || (user = cellRecommItem.userInfo) == null) {
            return;
        }
        if (this.recommend_follow_add_button == dittoArea) {
            gVar.onClick(this, FeedElement.FEED_RECOMMEND_FRIENDS_FOLLOW, this.feedPosition, new Object[]{Long.valueOf(user.uin), this.mFeedData, Integer.valueOf(this.feedPosition), Integer.valueOf(this.mListIndex)});
        } else {
            gVar.onClick(this, FeedElement.FEED_RECOMMEND_FRIENDS_CLICK_AVATAR_OR_NICKNAME, this.feedPosition, user);
        }
    }

    public CanvasRecomFollowListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mListIndex = -1;
    }

    public void setFeedData(BusinessFeedData businessFeedData, int i3) {
        CellRecommItem cellRecommItem;
        if (businessFeedData == null || (cellRecommItem = businessFeedData.cellRecommItem) == null || cellRecommItem.userInfo == null) {
            return;
        }
        this.mFeedData = businessFeedData;
        setContentAreaForJsonFile("qzone_canvas_ui_recom_follow_listitem.json");
        CellRecommItem cellRecommItem2 = businessFeedData.cellRecommItem;
        User user = cellRecommItem2.userInfo;
        long j3 = user.uin;
        String str = user.nickName;
        String str2 = cellRecommItem2.content;
        this.feed_recommend_follow_icon.setAvatar(j3, AreaConst.dp40, AreaManager.DEFAULT_AVATAR);
        if (!TextUtils.isEmpty(str)) {
            this.feed_recommend_follow_nickname.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.feed_recommend_follow_description.setText(str2);
        }
        if (businessFeedData.getRecommItem().isFollowed) {
            this.recommend_follow_add_button.setTextColor(Color.parseColor("#AAAAAA"));
            this.recommend_follow_add_button.setText("\u5df2\u5173\u6ce8");
            this.recommend_follow_add_button.setBackgroundColor(-1);
            this.recommend_follow_add_button.setBorderColor(-1);
        } else {
            this.recommend_follow_add_button.setTextColor(Color.parseColor("#000000"));
            this.recommend_follow_add_button.setText("\u5173\u6ce8");
            this.recommend_follow_add_button.setBorderColor(Color.parseColor("#ffca00"));
            this.recommend_follow_add_button.setBackgroundColor(Color.parseColor("#ffca00"));
        }
        if (this.mListIndex >= 2) {
            this.feed_recommmend_follow_divider.setVisibility(8);
        } else {
            this.feed_recommmend_follow_divider.setVisibility(0);
        }
    }
}
