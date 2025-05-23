package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.module.feedcomponent.FeedUtil;
import com.qzone.module.feedcomponent.util.PressStateUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellForwardListInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellLuckyMoney;
import com.qzone.proxy.feedcomponent.model.CellRedBonus;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.ColorTextCell;
import com.qzone.proxy.feedcomponent.text.NetImageCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class PraiseListView extends QzoneCanvasAreaView {
    private static String TAG = "PraiseListView";

    @DittoField
    RichCanvasTextArea feed_praiselist_LuckyMoneyList;

    @DittoField
    RichCanvasTextArea feed_praiselist_PraiseList;

    @DittoField
    RichCanvasTextArea feed_praiselist_RedPocketList;

    @DittoField
    RichCanvasTextArea feed_praiselist_commentcount;

    @DittoField
    RichCanvasTextArea feed_praiselist_forward;

    @DittoField
    LinearAreaLayout feed_praiselist_root;
    private Runnable invalidateRunnable;
    CellCommentInfo mCommentInfo;
    BusinessFeedData mFeedData;
    CellForwardListInfo mForwardinfo;
    CellLikeInfo mLikeInfo;
    CellLuckyMoney mLuckyMoney;
    CellRedBonus mRedBonus;
    private DittoArea mTouchingArea;

    public PraiseListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.invalidateRunnable = new Runnable() { // from class: com.qzone.module.feedcomponent.ui.PraiseListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (((QzoneCanvasAreaView) PraiseListView.this).mScrollState == 1) {
                    PraiseListView.this.postInvalidate();
                }
            }
        };
        setContentAreaForJsonFile("qzone_canvas_ui_praiselist.json");
        setVisibility(8);
    }

    public FeedTextArea getTouchingFeedTextArea() {
        DittoArea dittoArea = this.mTouchingArea;
        if (dittoArea == null || !(dittoArea instanceof RichCanvasTextArea)) {
            return null;
        }
        return ((RichCanvasTextArea) dittoArea).getTextArea();
    }

    public boolean isEmpty() {
        return this.feed_praiselist_root.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"feed_praiselist_PraiseList", "feed_praiselist_RedPocketList", "feed_praiselist_LuckyMoneyList", "feed_praiselist_forward", "feed_praiselist_commentcount"})
    public void onCanvasAreaClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        com.qzone.proxy.feedcomponent.b.c("CANVASLOG", "onCanvasAreaClicked " + dittoArea.getId());
        com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
        if (gVar == null) {
            return;
        }
        this.mTouchingArea = dittoArea;
        if (obj != null && (obj instanceof TextCell)) {
            TextCell textCell = (TextCell) obj;
            if (textCell instanceof UserNameCell) {
                gVar.onClick(this, FeedElement.FRIEND_NICKNAME, this.feedPosition, ((UserNameCell) textCell).getUin());
                return;
            }
            if (!(textCell instanceof UrlCell) && !(textCell instanceof ColorTextCell)) {
                if (textCell instanceof NetImageCell) {
                    gVar.onClick(this, FeedElement.CUSTOM_PRAISE_ICON, this.feedPosition, textCell);
                    return;
                }
                return;
            }
            UrlCell urlCell = (UrlCell) obj;
            if (urlCell.getAction() == 2) {
                com.qzone.proxy.feedcomponent.ui.g gVar2 = this.onFeedElementClickListener;
                FeedElement feedElement = FeedElement.LEFT_THUMB;
                int i3 = this.feedPosition;
                gVar2.onClick(this, feedElement, i3, Integer.valueOf(i3));
                return;
            }
            this.onFeedElementClickListener.onClick(this, FeedElement.URL, this.feedPosition, new com.qzone.proxy.feedcomponent.model.e(urlCell.getUrl(), urlCell.post, this.feedPosition));
            return;
        }
        if (dittoArea == this.feed_praiselist_PraiseList) {
            gVar.onClick(this, FeedElement.PRAISE_LIST, this.feedPosition, null);
            return;
        }
        if (dittoArea == this.feed_praiselist_RedPocketList) {
            gVar.onClick(this, FeedElement.REDPOCKET_LIST, this.feedPosition, null);
            return;
        }
        if (dittoArea == this.feed_praiselist_LuckyMoneyList) {
            gVar.onClick(this, FeedElement.SPACE_REDPOCKET_LIST, this.feedPosition, null);
        } else if (dittoArea == this.feed_praiselist_forward) {
            gVar.onClick(this, FeedElement.FEED_FORWARD_LIST, this.feedPosition, null);
        } else if (dittoArea == this.feed_praiselist_commentcount) {
            gVar.onClick(this, FeedElement.FEED_COMMENT_COUNT_AREA, this.feedPosition, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.DittoAreaView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.DittoAreaView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        this.mLikeInfo = null;
        this.mRedBonus = null;
        this.mLuckyMoney = null;
        this.mForwardinfo = null;
        this.mCommentInfo = null;
        this.mTouchingArea = null;
        RichCanvasTextArea richCanvasTextArea = this.feed_praiselist_RedPocketList;
        if (richCanvasTextArea != null) {
            richCanvasTextArea.onRecycled();
        }
        RichCanvasTextArea richCanvasTextArea2 = this.feed_praiselist_PraiseList;
        if (richCanvasTextArea2 != null) {
            richCanvasTextArea2.onRecycled();
        }
        RichCanvasTextArea richCanvasTextArea3 = this.feed_praiselist_LuckyMoneyList;
        if (richCanvasTextArea3 != null) {
            richCanvasTextArea3.onRecycled();
        }
        RichCanvasTextArea richCanvasTextArea4 = this.feed_praiselist_forward;
        if (richCanvasTextArea4 != null) {
            richCanvasTextArea4.onRecycled();
        }
        RichCanvasTextArea richCanvasTextArea5 = this.feed_praiselist_commentcount;
        if (richCanvasTextArea5 != null) {
            richCanvasTextArea5.onRecycled();
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void onStateIdle() {
        super.onStateIdle();
        getHandler().postDelayed(this.invalidateRunnable, 100L);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        PressStateUtils.setAlphaAfterPress(this);
        PressStateUtils.setColorAfterPress(this.feed_praiselist_root);
        return false;
    }

    public boolean setCommentCountInfo(CellCommentInfo cellCommentInfo, BusinessFeedData businessFeedData) {
        if (!FeedUtil.hasCommentCount(businessFeedData)) {
            return false;
        }
        this.mCommentInfo = cellCommentInfo;
        return true;
    }

    public boolean setForwardListInfo(CellForwardListInfo cellForwardListInfo, BusinessFeedData businessFeedData) {
        BusinessFeedData businessFeedData2 = businessFeedData.parentFeedData;
        if ((businessFeedData2 != null && businessFeedData2.isFriendLikeContainer()) || !FeedUtil.hasForwardCount(businessFeedData)) {
            return false;
        }
        if (cellForwardListInfo != null && cellForwardListInfo.num > 0 && !TextUtils.isEmpty(cellForwardListInfo.displayStr)) {
            this.mForwardinfo = cellForwardListInfo;
        }
        CellForwardListInfo cellForwardListInfo2 = this.mForwardinfo;
        return (cellForwardListInfo2 == null || cellForwardListInfo2.num <= 0 || TextUtils.isEmpty(cellForwardListInfo2.displayStr)) ? false : true;
    }

    public boolean setLikeInfo(BusinessFeedData businessFeedData, CellLikeInfo cellLikeInfo, boolean z16, int i3) {
        BusinessFeedData businessFeedData2;
        this.mFeedData = businessFeedData;
        if ((businessFeedData == null || (businessFeedData2 = businessFeedData.parentFeedData) == null || !businessFeedData2.isFriendLikeContainer()) ? false : true) {
            return false;
        }
        this.mLikeInfo = cellLikeInfo;
        return (cellLikeInfo == null || TextUtils.isEmpty(cellLikeInfo.displayStr)) ? false : true;
    }

    public void update() {
        setContentAreaForJsonFile("qzone_canvas_ui_praiselist.json");
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        CellLikeInfo cellLikeInfo = this.mLikeInfo;
        if (cellLikeInfo != null && !TextUtils.isEmpty(cellLikeInfo.displayStr)) {
            this.feed_praiselist_PraiseList.setVisibility(0);
            this.feed_praiselist_PraiseList.setText(this.mLikeInfo.displayStr);
            this.feed_praiselist_PraiseList.setAreaCacheKey(this.mLikeInfo.integerUnikey);
            Drawable drawable = AreaManager.HAS_PRAISE_DRAWABLE;
            BusinessFeedData businessFeedData = this.mFeedData;
            if (businessFeedData != null) {
                this.feed_praiselist_PraiseList.setTag(businessFeedData.getFeedCommInfoV2().feedskey);
            }
            this.feed_praiselist_PraiseList.setLeftDrawable(drawable, AreaConst.f48749dp4);
        } else {
            this.feed_praiselist_PraiseList.setVisibility(8);
        }
        this.feed_praiselist_RedPocketList.setVisibility(8);
        this.feed_praiselist_LuckyMoneyList.setVisibility(8);
        CellForwardListInfo cellForwardListInfo = this.mForwardinfo;
        if (cellForwardListInfo != null && cellForwardListInfo.num > 0 && !TextUtils.isEmpty(cellForwardListInfo.displayStr)) {
            this.feed_praiselist_forward.setVisibility(0);
            this.feed_praiselist_forward.setText(this.mForwardinfo.displayStr);
            this.feed_praiselist_forward.setContentDescription(this.mForwardinfo.displayStr);
            this.feed_praiselist_forward.setAreaCacheKey(this.mForwardinfo.integerUnikey);
            Drawable drawable2 = AreaManager.FORWARD_DRAWABLE;
            BusinessFeedData businessFeedData2 = this.mFeedData;
            if (businessFeedData2 != null) {
                this.feed_praiselist_forward.setTag(businessFeedData2.getFeedCommInfoV2().feedskey);
            }
            this.feed_praiselist_forward.setLeftDrawable(drawable2, AreaConst.f48749dp4);
        } else {
            this.feed_praiselist_forward.setVisibility(8);
        }
        CellCommentInfo cellCommentInfo = this.mCommentInfo;
        if (cellCommentInfo != null && cellCommentInfo.realCount > 0) {
            this.feed_praiselist_commentcount.setVisibility(0);
            String T = com.qzone.adapter.feedcomponent.i.H().T("QZoneSetting", "Feed_Comment_Count_Desc", "%s\u6761\u8bc4\u8bba\u56de\u590d");
            try {
                T = String.format(T, com.qzone.proxy.feedcomponent.util.d.l(this.mCommentInfo.realCount));
            } catch (IllegalArgumentException unused) {
                com.qzone.proxy.feedcomponent.b.c(TAG, "\u4e0b\u53d1\u53c2\u6570\u7c7b\u578b\u9519\u8bef\uff0c%d->%s");
            }
            String str = this.mCommentInfo.commentNumInfoFoldText;
            if (str != null && !str.equals("")) {
                com.qzone.proxy.feedcomponent.b.e(TAG, "mCommentInfo.commentNumInfoFoldText = " + this.mCommentInfo.commentNumInfoFoldText);
                T = this.mCommentInfo.commentNumInfoFoldText;
            }
            this.feed_praiselist_commentcount.setLeftDrawable(AreaManager.COMMENT_COUNT_DRAWABLE, AreaConst.f48749dp4);
            this.feed_praiselist_commentcount.setText(" " + T);
            this.feed_praiselist_commentcount.setAreaCacheKey(this.mCommentInfo.integerUnikeyCommentRealCount);
            this.feed_praiselist_commentcount.setContentDescription(T);
            BusinessFeedData businessFeedData3 = this.mFeedData;
            if (businessFeedData3 != null) {
                this.feed_praiselist_commentcount.setTag(businessFeedData3.getFeedCommInfoV2().feedskey);
            }
        } else {
            this.feed_praiselist_commentcount.setVisibility(8);
        }
        if (this.feed_praiselist_root.isEmpty()) {
            this.feed_praiselist_root.setVisibility(8);
        } else {
            this.feed_praiselist_root.setVisibility(0);
        }
        if (com.qzone.adapter.feedcomponent.i.H().S0() && this.mLikeInfo != null) {
            StringBuilder sb5 = new StringBuilder();
            CellLikeInfo cellLikeInfo2 = this.mLikeInfo;
            ArrayList<CellLikeInfo.LikeMan> arrayList = cellLikeInfo2.likeMans;
            int i3 = cellLikeInfo2.likeNum;
            if (arrayList != null) {
                int size = arrayList.size();
                User user = null;
                for (int i16 = 0; i16 < size; i16++) {
                    try {
                        user = arrayList.get(i16).user;
                    } catch (Exception unused2) {
                    }
                    if (user == null) {
                        break;
                    }
                    if (i16 > 0) {
                        sb5.append("\u3001");
                    }
                    sb5.append(user.nickName);
                }
            }
            if (arrayList != null) {
                arrayList.size();
            }
            sb5.append(this.mLikeInfo.likeNumInfoFoldTxt);
            setFocusable(true);
            setFocusableInTouchMode(true);
            this.feed_praiselist_PraiseList.setContentDescription(sb5.toString());
        }
        updateAccessibility();
        PressStateUtils.setAlphaBeforePress(this);
        PressStateUtils.setColorBeforePress(this.feed_praiselist_root);
    }

    public boolean setRedPocketInfo(CellRedBonus cellRedBonus, BusinessFeedData businessFeedData) {
        if (cellRedBonus != null && !TextUtils.isEmpty(cellRedBonus.displayStr)) {
            this.mRedBonus = cellRedBonus;
        }
        CellRedBonus cellRedBonus2 = this.mRedBonus;
        return (cellRedBonus2 == null || TextUtils.isEmpty(cellRedBonus2.displayStr)) ? false : true;
    }

    public boolean setSpaceRedPocketInfo(CellLuckyMoney cellLuckyMoney, BusinessFeedData businessFeedData) {
        if (cellLuckyMoney != null && cellLuckyMoney.num > 0 && !TextUtils.isEmpty(cellLuckyMoney.displayStr)) {
            this.mLuckyMoney = cellLuckyMoney;
        }
        CellLuckyMoney cellLuckyMoney2 = this.mLuckyMoney;
        return (cellLuckyMoney2 == null || cellLuckyMoney2.num <= 0 || TextUtils.isEmpty(cellLuckyMoney2.displayStr)) ? false : true;
    }
}
