package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.module.feedcomponent.manage.PublicAccountFollowManager;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.util.CardUtils;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes39.dex */
public class CanvasPublicAccountContainerView extends QzoneCanvasAreaView {
    private static final String ALREADY_FOLLOW_CIRCLE = "\u5df2\u5173\u6ce8";
    private static final String ALREADY_FOLLOW_DEFAULT = "\u5df2\u8ba2\u9605";
    private static final Set<String> CIRCLE_FOLLOW_SET = new HashSet();
    private static final String CIRCLE_VIP_ICON_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20200323162800_tHRLLViWSu.png";
    private static final String FOLLOW_CIRCLE = "\u5173\u6ce8";
    private static final String FOLLOW_DEFAULT = "\u8ba2\u9605";
    private static final String TAG = "CanvasPublicAccountCont";
    private String alreadyFollow;
    private String follow;

    @DittoField("account_desc")
    DittoTextArea mAccountDesc;

    @DittoField("account_logo")
    AsyncCanvasImageArea mAccountLogo;

    @DittoField("account_name")
    DittoTextArea mAccountName;

    @DittoField("btn_close")
    AsyncCanvasImageArea mBtnClose;
    private BusinessFeedData mFeedData;
    private int mFeedPosition;
    private int mIndex;

    @DittoField("jump_button")
    DittoButtonArea mJumpButton;

    @DittoField("card_root")
    DittoArea mRoot;
    private String mUin;

    @DittoField("icon_vip")
    AsyncCanvasImageArea mVipIcon;
    private Paint shadowPaint;

    public CanvasPublicAccountContainerView(Context context) {
        super(context);
        this.follow = FOLLOW_DEFAULT;
        this.alreadyFollow = ALREADY_FOLLOW_DEFAULT;
        this.mIndex = 0;
        initUI();
    }

    public static void addCircleCache(String str, boolean z16) {
        b.e(TAG, "addCircleCache: " + str + " " + z16);
        if (z16) {
            CIRCLE_FOLLOW_SET.add(str);
        } else {
            CIRCLE_FOLLOW_SET.remove(str);
        }
    }

    public static void clearCircleCache() {
        b.e(TAG, "clearCircleCache");
        CIRCLE_FOLLOW_SET.clear();
    }

    private void doReport(int i3, int i16) {
        i.H().z(12, i3, i16, System.currentTimeMillis(), this.mFeedData, this.mFeedPosition, this.mIndex);
    }

    private void initUI() {
        setContentAreaForJsonFile("qzone_canvas_ui_public_account_container.json");
        Paint paint = new Paint();
        this.shadowPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.shadowPaint.setStrokeWidth(1.0f);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public int getFeedPosition() {
        return this.mFeedPosition;
    }

    public void initFollowStatus() {
        boolean e16;
        if (this.mFeedData.isQQCircleRecomm) {
            e16 = CIRCLE_FOLLOW_SET.contains(this.mUin);
            b.e(TAG, "initFollowStatus: circle " + this.mUin + " " + e16);
        } else if (PublicAccountFollowManager.g().hasUin(this.mUin)) {
            e16 = PublicAccountFollowManager.g().getUinFollowed(this.mUin);
        } else {
            e16 = com.qzone.proxy.feedcomponent.util.i.e(this.mFeedData);
        }
        updateFollowStatus(e16);
        if (this.mFeedData.isQQCircleRecomm) {
            return;
        }
        PublicAccountFollowManager.g().addOnFollowListener(getContext(), new PublicAccountFollowManager.OnFollowListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerView.1
            @Override // com.qzone.module.feedcomponent.manage.PublicAccountFollowManager.OnFollowListener
            public void onFollow(String str, boolean z16) {
                if (str == null || !str.equals(CanvasPublicAccountContainerView.this.mUin)) {
                    return;
                }
                CanvasPublicAccountContainerView.this.updateFollowStatus(z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    public void onDraw(Canvas canvas) {
        int paddingLeft = CardUtils.CARD_SHADOW_WIDTH_SPACE + getPaddingLeft();
        int i3 = AreaConst.f48746dp1;
        int i16 = CardUtils.CARD_SHADOW_TOP_SPACE;
        RectF rectF = new RectF(paddingLeft + i3, i16 + i3, (getWidth() - getPaddingRight()) - i3, getBottom() - CardUtils.CARD_SHADOW_SIZE);
        float f16 = rectF.top + i16;
        float f17 = rectF.right;
        int i17 = AreaConst.f48748dp3;
        RectF rectF2 = new RectF(0.0f, f16, f17 - i17, rectF.bottom - i16);
        canvas.save();
        Path path = new Path();
        path.addRoundRect(rectF2, 8.0f, 8.0f, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.translate(i17, 0.0f);
        super.onDraw(canvas);
        canvas.restore();
        CardUtils.drawCardShadow(canvas, rectF, false, 8, this.shadowPaint);
    }

    @Override // android.view.View
    public void setAlpha(float f16) {
        try {
            this.mRoot.setAlpha(f16);
        } catch (Throwable th5) {
            b.d("Feed", "", th5);
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void setFeedPosition(int i3) {
        this.mFeedPosition = i3;
    }

    public void setRecFeedData(BusinessFeedData businessFeedData, int i3, boolean z16) {
        this.mFeedData = businessFeedData;
        if (businessFeedData != null) {
            businessFeedData.isQQCircleRecomm = z16;
        }
        String str = null;
        CellUserInfo cellUserInfo = businessFeedData != null ? businessFeedData.getCellUserInfo() : null;
        this.mIndex = i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setRecFeedData: ");
        sb5.append(z16);
        sb5.append(" ");
        sb5.append(cellUserInfo != null ? cellUserInfo.getUser().uin : -1L);
        b.e(TAG, sb5.toString());
        if (z16) {
            this.follow = FOLLOW_CIRCLE;
            this.alreadyFollow = ALREADY_FOLLOW_CIRCLE;
            if (cellUserInfo != null && cellUserInfo.getUser() != null && cellUserInfo.getUser().isCircleVip()) {
                this.mVipIcon.setAsyncImage(null, CIRCLE_VIP_ICON_URL, null, null);
                this.mVipIcon.setVisibility(0);
            } else {
                this.mVipIcon.setVisibility(8);
            }
        } else {
            this.follow = FOLLOW_DEFAULT;
            this.alreadyFollow = ALREADY_FOLLOW_DEFAULT;
            this.mVipIcon.setVisibility(8);
        }
        this.mAccountName.setVisibility(0);
        this.mBtnClose.setImageResource(j.h(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY));
        if (cellUserInfo != null && cellUserInfo.getUser() != null) {
            if (z16) {
                this.mAccountLogo.setAvatar(cellUserInfo.getUser().uin, AreaConst.dp50, AreaManager.DEFAULT_AVATAR);
            } else {
                this.mAccountLogo.setAsyncImage(null, cellUserInfo.getUser().logo, null, null, this.mAccountLogo.getLayoutAttr().width, this.mAccountLogo.getLayoutAttr().height);
            }
        }
        if (cellUserInfo != null && cellUserInfo.getUser() != null) {
            this.mAccountName.setText(cellUserInfo.getUser().nickName, 5, MiniBoxNoticeInfo.APPNAME_SUFFIX);
        }
        this.mAccountDesc.setMaxLines(z16 ? 1 : 2);
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 != null && businessFeedData2.getCellSummary() != null) {
            str = this.mFeedData.getCellSummary().displayReadeableStr;
        }
        if (z16 && TextUtils.isEmpty(str)) {
            str = "\u731c\u4f60\u559c\u6b22";
        }
        this.mAccountDesc.setText(str);
        BusinessFeedData businessFeedData3 = this.mFeedData;
        if (businessFeedData3 != null && businessFeedData3.getCellUserInfo() != null && this.mFeedData.getCellUserInfo().user != null) {
            this.mUin = String.valueOf(this.mFeedData.getCellUserInfo().user.uin);
        }
        initFollowStatus();
        if (this.mFeedData != null) {
            doReport(26, 19);
        }
    }

    public void updateFollowStatus(boolean z16) {
        if (z16) {
            this.mJumpButton.setText(this.alreadyFollow);
            this.mJumpButton.setBackgroundColor(-1183755);
        } else {
            this.mJumpButton.setText(this.follow);
            this.mJumpButton.setBackgroundColor(-16725252);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"jump_button", "card_root", "account_logo", "account_name"})
    public void onClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        if (dittoArea == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onClick: ");
        sb5.append(this.mUin);
        sb5.append(" ");
        sb5.append(this.mFeedData.getCellUserInfo().user == null ? -1L : this.mFeedData.getCellUserInfo().user.uin);
        b.e(TAG, sb5.toString());
        DittoButtonArea dittoButtonArea = this.mJumpButton;
        if (dittoButtonArea == dittoArea) {
            if (!ALREADY_FOLLOW_DEFAULT.equals(dittoButtonArea.getText())) {
                this.onFeedElementClickListener.onClick(this, FeedElement.PUBLIC_ACCOUNT_FOLLOW, this.mFeedPosition, this.mFeedData);
                doReport(201, 1);
                return;
            } else {
                this.onFeedElementClickListener.onClick(this, FeedElement.PUBLIC_ACCOUNT_UNFOLLOW, this.mFeedPosition, this.mFeedData);
                doReport(202, 1);
                return;
            }
        }
        if (this.mRoot == dittoArea) {
            this.onFeedElementClickListener.onClick(this, FeedElement.PUBLIC_ACCOUNT_NAVIGATE_HOME, this.mFeedPosition, this.mFeedData);
            doReport(26, 1);
        } else if (this.mAccountLogo == dittoArea) {
            this.onFeedElementClickListener.onClick(this, FeedElement.PUBLIC_ACCOUNT_NAVIGATE_HOME, this.mFeedPosition, this.mFeedData);
            doReport(17, 1);
        } else if (this.mAccountName == dittoArea) {
            this.onFeedElementClickListener.onClick(this, FeedElement.PUBLIC_ACCOUNT_NAVIGATE_HOME, this.mFeedPosition, this.mFeedData);
            doReport(18, 1);
        }
    }

    public CanvasPublicAccountContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.follow = FOLLOW_DEFAULT;
        this.alreadyFollow = ALREADY_FOLLOW_DEFAULT;
        this.mIndex = 0;
        initUI();
    }
}
