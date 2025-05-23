package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.module.feedcomponent.manage.PublicAccountFollowManager;
import com.qzone.module.feedcomponent.ui.FeedChildView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.util.g;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasRecommActionNonAd extends MarginCanvasAreaView implements FeedChildView {
    private static final String ALREADY_FOLLOW = "\u5df2\u8ba2\u9605";
    private static final String FOLLOW = "\u8ba2\u9605";
    private static final String TAG = "CanvasRecommActionNonAd";

    @DittoField
    AsyncCanvasImageArea full_height_icon;

    @DittoField
    LinearAreaLayout layout_mini_app_text;
    public BusinessFeedData mFeedData;
    private boolean mInitStage;
    private String mUin;

    @DittoField
    AsyncCanvasImageArea mini_app_icon;

    @DittoField
    RelativeAreaLayout qzone_recomm_action_root_container;

    @DittoField
    DittoButtonArea right_button_area;

    @DittoField
    DittoTextArea text_mini_app;

    @DittoField
    DittoTextArea text_mini_app_desc;
    public static FeedViewSection.SectionController RecommActionController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAd.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            if (businessFeedData != null) {
                return (!businessFeedData.isPublicAccountContent() || businessFeedData.getCellBottomRecomm() == null) && !businessFeedData.isPublicAccountShare();
            }
            return true;
        }
    };
    private static Drawable advBackgroundDrawable = j.g(729);
    private static Drawable advBackgroundDrawableBlack = j.g(954);

    public CanvasRecommActionNonAd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInitStage = true;
    }

    private void doReport(int i3, int i16) {
        i.H().z(12, i3, i16, System.currentTimeMillis(), this.mFeedData, this.feedPosition, 0);
    }

    private boolean getFollowStatus() {
        if (PublicAccountFollowManager.g().hasUin(this.mUin)) {
            return PublicAccountFollowManager.g().getUinFollowed(this.mUin);
        }
        return com.qzone.proxy.feedcomponent.util.i.e(this.mFeedData);
    }

    private void setupPublicAccountContentUI() {
        PictureUrl pictureUrl;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || !businessFeedData.isPublicAccountContent()) {
            return;
        }
        CellBottomRecomm cellBottomRecomm = this.mFeedData.getCellBottomRecomm();
        if (cellBottomRecomm != null) {
            this.text_mini_app.setIncludeFontPadding(false);
            this.text_mini_app.setText(cellBottomRecomm.title, 8, MiniBoxNoticeInfo.APPNAME_SUFFIX);
            this.text_mini_app_desc.setText(cellBottomRecomm.summary, 16, MiniBoxNoticeInfo.APPNAME_SUFFIX);
            this.right_button_area.setText(cellBottomRecomm.buttontext);
            PictureItem pictureItem = cellBottomRecomm.picinfo;
            if (pictureItem != null && (pictureUrl = pictureItem.currentUrl) != null) {
                this.mini_app_icon.setAsyncImage(pictureUrl.imageUrl, pictureUrl.url, null, null);
            }
        }
        CellBottomRecomm cellBottomRecomm2 = this.mFeedData.getCellBottomRecomm();
        if (cellBottomRecomm2 != null && !TextUtils.isEmpty(cellBottomRecomm2.jsonData)) {
            try {
                this.mUin = new JSONObject(cellBottomRecomm2.jsonData).getString(IPublicAccountBrowser.KEY_PUB_UIN);
            } catch (Exception e16) {
                b.b(TAG, "get uin failed", e16);
            }
        }
        initFollowStatus();
    }

    private void setupPublicAccountShareUI() {
        PictureUrl pictureUrl;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || !businessFeedData.isPublicAccountShare()) {
            return;
        }
        this.full_height_icon.setVisibility(0);
        CellBottomRecomm cellBottomRecomm = this.mFeedData.getCellBottomRecomm();
        if (cellBottomRecomm != null) {
            this.text_mini_app.setText(cellBottomRecomm.title, 14, MiniBoxNoticeInfo.APPNAME_SUFFIX);
            this.text_mini_app_desc.setText(cellBottomRecomm.summary, 17, MiniBoxNoticeInfo.APPNAME_SUFFIX);
            PictureItem pictureItem = cellBottomRecomm.picinfo;
            if (pictureItem != null && (pictureUrl = pictureItem.currentUrl) != null) {
                this.full_height_icon.setAsyncImage(pictureUrl.imageUrl, pictureUrl.url, null, null);
            }
            if (!TextUtils.isEmpty(cellBottomRecomm.jsonData)) {
                try {
                    this.mUin = new JSONObject(cellBottomRecomm.jsonData).getString(IPublicAccountBrowser.KEY_PUB_UIN);
                } catch (Exception e16) {
                    b.b(TAG, "get uin failed", e16);
                }
            }
        }
        initFollowStatus();
    }

    private void updateRoot() {
        Drawable drawable;
        this.qzone_recomm_action_root_container.getLayoutAttr().rightMargin = (int) (DittoUIEngine.g().getDensity() * 6.0f);
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || !businessFeedData.isPublicAccountShare()) {
            this.qzone_recomm_action_root_container.getLayoutAttr().leftMargin = (int) (DittoUIEngine.g().getDensity() * 6.0f);
        }
        j.g(954);
        if (i.H().p1()) {
            drawable = advBackgroundDrawableBlack;
        } else {
            drawable = advBackgroundDrawable;
        }
        drawable.setAlpha(this.mTrans);
        this.qzone_recomm_action_root_container.setBackgroundDrawable(drawable);
    }

    public void initFollowStatus() {
        boolean followStatus;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.isPublicAccountShare()) {
            CellBottomRecomm cellBottomRecomm = this.mFeedData.getCellBottomRecomm();
            followStatus = false;
            if (cellBottomRecomm != null) {
                int i3 = cellBottomRecomm.iButtonFlag;
                if (i3 == 0) {
                    this.right_button_area.setVisibility(8);
                } else if (i3 == 1) {
                    this.right_button_area.setVisibility(0);
                    followStatus = getFollowStatus();
                }
            }
        } else {
            followStatus = getFollowStatus();
        }
        updateFollowStatus(followStatus, true);
        PublicAccountFollowManager.g().addOnFollowListener(getContext(), new PublicAccountFollowManager.OnFollowListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAd.2
            @Override // com.qzone.module.feedcomponent.manage.PublicAccountFollowManager.OnFollowListener
            public void onFollow(String str, boolean z16) {
                if (str == null || !str.equals(CanvasRecommActionNonAd.this.mUin)) {
                    return;
                }
                CanvasRecommActionNonAd.this.updateFollowStatus(z16, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.module.feedcomponent.ui.canvasui.MarginCanvasAreaView, com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
        if (businessFeedData != null && businessFeedData.isPublicAccountShare()) {
            setContentAreaForJsonFile("qzone_canvas_ui_recommAction_non_ad_big_icon.json");
        } else {
            setContentAreaForJsonFile("qzone_canvas_ui_recommAction_non_ad.json");
        }
        update();
    }

    public void setTrans(int i3) {
        this.mTrans = g.b(i3);
        if (this.mFeedData != null) {
            updateRoot();
        }
    }

    public void updateFollowStatus(boolean z16) {
        updateFollowStatus(z16, false);
    }

    public void update() {
        setVisibility(0);
        updateRoot();
        setupPublicAccountContentUI();
        setupPublicAccountShareUI();
    }

    public void updateFollowStatus(boolean z16, boolean z17) {
        BusinessFeedData businessFeedData;
        if (z16) {
            this.right_button_area.setText(ALREADY_FOLLOW);
            this.right_button_area.setBackgroundColor(j.B());
        } else {
            this.right_button_area.setText(FOLLOW);
            this.right_button_area.setBackgroundColor(j.x());
        }
        if (this.mInitStage) {
            this.mInitStage = false;
        } else {
            if (z17 || !z16 || (businessFeedData = this.mFeedData) == null || !businessFeedData.isPublicAccountShare()) {
                return;
            }
            FeedGlobalEnv.g().showToast(1000, getContext(), "\u53ef\u5728\u6d88\u606f-\u8ba2\u9605\u53f7\u4e2d\u67e5\u770b\u5df2\u8ba2\u9605\u5185\u5bb9", 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"right_button_area", "qzone_recomm_action_root_container", "mini_app_icon", "text_mini_app", "text_mini_app_desc"})
    public void onAreaClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        if (dittoArea == null) {
            return;
        }
        DittoButtonArea dittoButtonArea = this.right_button_area;
        if (dittoArea == dittoButtonArea) {
            if (!ALREADY_FOLLOW.equals(dittoButtonArea.getText())) {
                this.onFeedElementClickListener.onClick(this, FeedElement.PUBLIC_ACCOUNT_FOLLOW, this.feedPosition, this.mFeedData);
                doReport(201, 1);
                return;
            } else {
                this.onFeedElementClickListener.onClick(this, FeedElement.PUBLIC_ACCOUNT_UNFOLLOW, this.feedPosition, this.mFeedData);
                doReport(202, 1);
                return;
            }
        }
        if (dittoArea == this.qzone_recomm_action_root_container) {
            this.onFeedElementClickListener.onClick(this, FeedElement.PUBLIC_ACCOUNT_NAVIGATE_HOME, this.feedPosition, this.mFeedData);
            doReport(26, 1);
            return;
        }
        if (dittoArea == this.mini_app_icon) {
            this.onFeedElementClickListener.onClick(this, FeedElement.PUBLIC_ACCOUNT_NAVIGATE_HOME, this.feedPosition, this.mFeedData);
            doReport(17, 1);
        } else if (dittoArea == this.text_mini_app) {
            this.onFeedElementClickListener.onClick(this, FeedElement.PUBLIC_ACCOUNT_NAVIGATE_HOME, this.feedPosition, this.mFeedData);
            doReport(18, 1);
        } else if (dittoArea == this.text_mini_app_desc) {
            this.onFeedElementClickListener.onClick(this, FeedElement.PUBLIC_ACCOUNT_NAVIGATE_HOME, this.feedPosition, this.mFeedData);
            doReport(19, 1);
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }
}
