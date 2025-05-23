package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.d;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLbsInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellReferInfo;
import com.qzone.proxy.feedcomponent.model.CellRemarkInfo;
import com.qzone.proxy.feedcomponent.model.CellTitleInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.text.ColorTextCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasAttachView extends QzoneCanvasAreaView {

    @DittoField
    RichCanvasTextArea feed_attach_lbs;

    @DittoField
    RichCanvasTextArea feed_attach_refer;

    @DittoField
    RichCanvasTextArea feed_attach_remark;

    @DittoField
    LinearAreaLayout feed_attach_root;

    @DittoField
    RichCanvasTextArea feed_attach_shootinfo;

    @DittoField
    RichCanvasTextArea feed_attach_titleinfo;
    CellLbsInfo mCellLbsInfo;
    BusinessFeedData mFeedData;
    CellReferInfo mReferInfo;
    CellRemarkInfo mRemarkInfo;
    CellTitleInfo mTitleInfo;

    public CanvasAttachView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentAreaForJsonFile("qzone_canvas_ui_attachview.json");
    }

    private void reportWithThirdAppId(boolean z16) {
        Map<Integer, String> map;
        CellOperationInfo cellOperationInfo = this.mFeedData.cellOperationInfo;
        if (cellOperationInfo == null || (map = cellOperationInfo.feedReportCookie) == null) {
            return;
        }
        String str = map.get(3);
        String str2 = this.mFeedData.cellOperationInfo.feedReportCookie.get(55);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        i.H().g(PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT, 20, z16 ? 1 : 2, "", str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"feed_attach_refer", "feed_attach_shootinfo", "feed_attach_remark", "feed_attach_lbs", "feed_attach_titleinfo"})
    public void onCanvasAreaClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        b.c("CANVASLOG", "onCanvasAreaClicked " + dittoArea.getId());
        g gVar = this.onFeedElementClickListener;
        if (gVar == null) {
            return;
        }
        if (obj != null && (obj instanceof TextCell)) {
            TextCell textCell = (TextCell) obj;
            if (textCell instanceof UserNameCell) {
                gVar.onClick(this, FeedElement.FRIEND_NICKNAME, this.feedPosition, ((UserNameCell) textCell).getUin());
                return;
            }
            if ((textCell instanceof UrlCell) || (textCell instanceof ColorTextCell)) {
                UrlCell urlCell = (UrlCell) obj;
                if (urlCell.getAction() == 2) {
                    g gVar2 = this.onFeedElementClickListener;
                    FeedElement feedElement = FeedElement.LEFT_THUMB;
                    int i3 = this.feedPosition;
                    gVar2.onClick(this, feedElement, i3, Integer.valueOf(i3));
                    return;
                }
                this.onFeedElementClickListener.onClick(this, FeedElement.URL, this.feedPosition, new e(urlCell.getUrl(), urlCell.post, this.feedPosition));
                return;
            }
            return;
        }
        if (dittoArea == this.feed_attach_refer) {
            CellReferInfo cellReferInfo = this.mReferInfo;
            if (cellReferInfo == null) {
                return;
            }
            int i16 = cellReferInfo.actionType;
            if (i16 == 17) {
                e eVar = new e(cellReferInfo.actionUrl, "", this.feedPosition);
                eVar.d(12);
                this.onFeedElementClickListener.onClick(this, FeedElement.URL, this.feedPosition, eVar);
            } else if (i16 == 2) {
                e eVar2 = new e(cellReferInfo.actionUrl, "", this.feedPosition);
                eVar2.d(12);
                this.onFeedElementClickListener.onClick(this, FeedElement.URL, this.feedPosition, eVar2);
            } else {
                gVar.onClick(this, FeedElement.REFER, this.feedPosition, cellReferInfo);
            }
            BusinessFeedData businessFeedData = this.mFeedData;
            if (businessFeedData != null) {
                if (businessFeedData.isNewHandBlogFeed()) {
                    i.H().f(302, 100, 0);
                }
                reportWithThirdAppId(false);
                return;
            }
            return;
        }
        if (dittoArea == this.feed_attach_shootinfo) {
            String jumpUrl = this.mRemarkInfo.getJumpUrl();
            if (!TextUtils.isEmpty(jumpUrl)) {
                i.H().H2(jumpUrl, null, getContext());
                return;
            }
            g gVar3 = this.onFeedElementClickListener;
            FeedElement feedElement2 = FeedElement.CONTENT;
            int i17 = this.feedPosition;
            gVar3.onClick(this, feedElement2, i17, Integer.valueOf(i17));
            return;
        }
        if (dittoArea == this.feed_attach_remark) {
            gVar.onClick(this, FeedElement.REMARK, this.feedPosition, this.mCellLbsInfo);
        } else if (dittoArea == this.feed_attach_lbs) {
            gVar.onClick(this, FeedElement.LBS_INFO, this.feedPosition, this.mCellLbsInfo);
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
        this.mRemarkInfo = null;
        this.mReferInfo = null;
        this.mCellLbsInfo = null;
        this.mTitleInfo = null;
        RichCanvasTextArea richCanvasTextArea = this.feed_attach_remark;
        if (richCanvasTextArea != null) {
            richCanvasTextArea.onRecycled();
        }
        RichCanvasTextArea richCanvasTextArea2 = this.feed_attach_refer;
        if (richCanvasTextArea2 != null) {
            richCanvasTextArea2.onRecycled();
        }
        RichCanvasTextArea richCanvasTextArea3 = this.feed_attach_titleinfo;
        if (richCanvasTextArea3 != null) {
            richCanvasTextArea3.onRecycled();
        }
        RichCanvasTextArea richCanvasTextArea4 = this.feed_attach_shootinfo;
        if (richCanvasTextArea4 != null) {
            richCanvasTextArea4.onRecycled();
        }
        RichCanvasTextArea richCanvasTextArea5 = this.feed_attach_lbs;
        if (richCanvasTextArea5 != null) {
            richCanvasTextArea5.onRecycled();
        }
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
    }

    public void setLbsInfo(CellLbsInfo cellLbsInfo) {
        this.mCellLbsInfo = cellLbsInfo;
    }

    public void setReferInfo(CellReferInfo cellReferInfo) {
        this.mReferInfo = cellReferInfo;
    }

    public void setRemarkInfo(CellRemarkInfo cellRemarkInfo) {
        this.mRemarkInfo = cellRemarkInfo;
    }

    public void setTitleInfo(CellTitleInfo cellTitleInfo) {
        this.mTitleInfo = cellTitleInfo;
    }

    public void update() {
        CellLbsInfo cellLbsInfo;
        String str;
        long j3;
        String str2;
        LpReportInfo_dc03950 lpReportInfo_dc03950;
        CellUserInfo cellUserInfo;
        setContentAreaForJsonFile("qzone_canvas_ui_attachview.json");
        CellRemarkInfo cellRemarkInfo = this.mRemarkInfo;
        if (cellRemarkInfo != null && !TextUtils.isEmpty(cellRemarkInfo.getRemarkDisplayStr())) {
            this.feed_attach_remark.setVisibility(0);
            this.feed_attach_remark.setText(this.mRemarkInfo.getRemarkDisplayStr());
            this.feed_attach_remark.setAreaCacheKey(this.mRemarkInfo.integerUnikeyRemark);
            BusinessFeedData businessFeedData = this.mFeedData;
            if (businessFeedData != null) {
                this.feed_attach_remark.setTag(businessFeedData.getFeedCommInfoV2().feedskey);
            }
            if (i.H().S0()) {
                this.feed_attach_remark.setContentDescription(d.t(d.r(this.mRemarkInfo.getRemarkDisplayStr())));
            }
        } else {
            this.feed_attach_remark.setVisibility(8);
        }
        CellReferInfo cellReferInfo = this.mReferInfo;
        String str3 = cellReferInfo == null ? null : cellReferInfo.appName;
        if (TextUtils.isEmpty(str3)) {
            BusinessFeedData businessFeedData2 = this.mFeedData;
            CellFeedCommInfo feedCommInfoV2 = businessFeedData2 == null ? null : businessFeedData2.getFeedCommInfoV2();
            str3 = feedCommInfoV2 == null ? null : feedCommInfoV2.refer;
        }
        boolean z16 = true;
        if (!TextUtils.isEmpty(str3)) {
            RichCanvasTextArea richCanvasTextArea = this.feed_attach_refer;
            CellReferInfo cellReferInfo2 = this.mReferInfo;
            richCanvasTextArea.setAreaCacheKey(cellReferInfo2 != null ? cellReferInfo2.integerUniKey : null);
            this.feed_attach_refer.setVisibility(0);
            this.feed_attach_refer.setText(str3);
            if (i.H().S0()) {
                this.feed_attach_refer.setContentDescription(d.t(d.r(str3)));
            }
            BusinessFeedData businessFeedData3 = this.mFeedData;
            if (businessFeedData3 != null) {
                this.feed_attach_refer.setTag(businessFeedData3.getFeedCommInfoV2().feedskey);
                if (this.mFeedData.isNewHandBlogFeed()) {
                    i.H().f(302, 101, 0);
                }
                reportWithThirdAppId(true);
            }
            CellReferInfo cellReferInfo3 = this.mReferInfo;
            if (cellReferInfo3 != null && (str = cellReferInfo3.actionUrl) != null && str.startsWith(QzoneConfig.SCHEME_FOR_SWEET_MAIN_PAGE_JUMP)) {
                BusinessFeedData businessFeedData4 = this.mFeedData;
                if (businessFeedData4 != null) {
                    j3 = businessFeedData4.owner_uin;
                    if (j3 == 0 && (cellUserInfo = businessFeedData4.getCellUserInfo()) != null && cellUserInfo.getUserV2() != null) {
                        j3 = cellUserInfo.getUserV2().uin;
                    }
                } else {
                    j3 = 0;
                }
                if (j3 > 0 && j3 == i.H().j0()) {
                    str2 = "5";
                } else {
                    str2 = "9";
                }
                String str4 = str2;
                String l06 = i.H().l0(i.H().j0());
                if (!TextUtils.isEmpty(l06)) {
                    lpReportInfo_dc03950 = new LpReportInfo_dc03950("25", str4, "1", "1", l06);
                } else {
                    lpReportInfo_dc03950 = new LpReportInfo_dc03950("25", str4, "1", "1");
                }
                LpReportInfo_dc03950.report(lpReportInfo_dc03950);
            }
        } else {
            this.feed_attach_refer.setVisibility(8);
        }
        CellTitleInfo cellTitleInfo = this.mTitleInfo;
        if (cellTitleInfo != null && !TextUtils.isEmpty(cellTitleInfo.likeListStr)) {
            this.feed_attach_titleinfo.setVisibility(0);
            this.feed_attach_titleinfo.setText(this.mTitleInfo.likeListStr);
            this.feed_attach_titleinfo.setAreaCacheKey(this.mTitleInfo.integerUnikey);
            if (i.H().S0()) {
                this.feed_attach_titleinfo.setContentDescription(d.t(d.r(this.mTitleInfo.likeListStr)));
            }
            BusinessFeedData businessFeedData5 = this.mFeedData;
            if (businessFeedData5 != null) {
                this.feed_attach_titleinfo.setTag(businessFeedData5.getFeedCommInfoV2().feedskey);
            }
        } else {
            this.feed_attach_titleinfo.setVisibility(8);
        }
        CellRemarkInfo cellRemarkInfo2 = this.mRemarkInfo;
        if (cellRemarkInfo2 != null && !TextUtils.isEmpty(cellRemarkInfo2.getShootInfoStringOrig())) {
            this.feed_attach_shootinfo.setVisibility(0);
            this.feed_attach_shootinfo.setText(this.mRemarkInfo.getShootInfoStringOrig());
            this.feed_attach_shootinfo.setAreaCacheKey(this.mRemarkInfo.integerUnikeyShoot);
            if (i.H().S0()) {
                this.feed_attach_shootinfo.setContentDescription(d.t(d.r(this.mRemarkInfo.getShootInfoStringOrig())));
            }
            BusinessFeedData businessFeedData6 = this.mFeedData;
            if (businessFeedData6 != null) {
                this.feed_attach_shootinfo.setTag(businessFeedData6.getFeedCommInfoV2().feedskey);
            }
            z16 = false;
        } else {
            this.feed_attach_shootinfo.setVisibility(8);
        }
        if (z16 && (cellLbsInfo = this.mCellLbsInfo) != null && !TextUtils.isEmpty(cellLbsInfo.getLBSString())) {
            this.feed_attach_lbs.setVisibility(0);
            this.feed_attach_lbs.setText(this.mCellLbsInfo.getLBSString());
            this.feed_attach_lbs.setAreaCacheKey(this.mCellLbsInfo.integerUniKey);
            if (i.H().S0()) {
                this.feed_attach_lbs.setContentDescription(d.t(d.r(this.mCellLbsInfo.getLBSString())));
            }
            BusinessFeedData businessFeedData7 = this.mFeedData;
            if (businessFeedData7 != null) {
                this.feed_attach_lbs.setTag(businessFeedData7.getFeedCommInfoV2().feedskey);
            }
        } else {
            this.feed_attach_lbs.setVisibility(8);
        }
        if (this.feed_attach_root.isEmpty()) {
            this.feed_attach_root.setVisibility(8);
        } else {
            this.feed_attach_root.setVisibility(0);
        }
        updateAccessibility();
    }
}
