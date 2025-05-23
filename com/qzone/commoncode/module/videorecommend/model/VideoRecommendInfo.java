package com.qzone.commoncode.module.videorecommend.model;

import NS_MOBILE_FEEDS.s_droplist_option;
import android.content.ContentValues;
import android.os.Parcel;
import com.qzone.component.cache.database.a;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellCanvas;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellCornerAdv;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellLive;
import com.qzone.proxy.feedcomponent.model.CellNegativeFeedback;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellPermissionInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellRecommAction;
import com.qzone.proxy.feedcomponent.model.CellRedBonus;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.CellVisitorInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VideoRecommendInfo extends a implements SmartParcelable {

    @NeedParcel
    public CellBottomRecomm mCellBottomRecomm;

    @NeedParcel
    public CellCanvas mCellCanvas;

    @NeedParcel
    public CellCornerAdv mCellCornerAdv;

    @NeedParcel
    public CellLive mCellLive;

    @NeedParcel
    public CellNegativeFeedback mCellNegativeFeedback;

    @NeedParcel
    public CellPictureInfo mCellPictureInfo;
    public int mVideoHeight;
    public int mVideoWidth;

    @NeedParcel
    public CellUserInfo mCellUserInfo = new CellUserInfo();

    @NeedParcel
    public CellFeedCommInfo mFeedCommInfo = new CellFeedCommInfo();

    @NeedParcel
    public VideoInfo mCellVideoInfo = new VideoInfo();

    @NeedParcel
    public CellIdInfo mCellIdInfo = new CellIdInfo();

    @NeedParcel
    public CellSummary mCellSummary = new CellSummary();

    @NeedParcel
    public CellRedBonus mCellRedBonus = new CellRedBonus();

    @NeedParcel
    public CellLikeInfo mCellLikeInfo = new CellLikeInfo();

    @NeedParcel
    public CellCommentInfo mCellCommentInfo = new CellCommentInfo();

    @NeedParcel
    public CellOperationInfo mCellOperationInfo = new CellOperationInfo();

    @NeedParcel
    public CellVisitorInfo mCellVisitorInfo = new CellVisitorInfo();

    @NeedParcel
    public CellRecommAction mCellRecommAction = new CellRecommAction();

    @NeedParcel
    public CellPermissionInfo mCellPermissionInfo = new CellPermissionInfo();

    @NeedParcel
    public int feedFakeType = 2;

    public String getFeedsKey() {
        CellFeedCommInfo cellFeedCommInfo = this.mFeedCommInfo;
        if (cellFeedCommInfo != null) {
            return cellFeedCommInfo.feedskey;
        }
        return null;
    }

    public String getUgcKey() {
        CellFeedCommInfo cellFeedCommInfo = this.mFeedCommInfo;
        if (cellFeedCommInfo != null) {
            return cellFeedCommInfo.ugckey;
        }
        return null;
    }

    public boolean hasCustomDropList() {
        ArrayList<s_droplist_option> arrayList;
        CellFeedCommInfo cellFeedCommInfo = this.mFeedCommInfo;
        return (cellFeedCommInfo == null || (arrayList = cellFeedCommInfo.customDroplist) == null || arrayList.size() <= 0) ? false : true;
    }

    public boolean isAdFeeds() {
        CellFeedCommInfo cellFeedCommInfo = this.mFeedCommInfo;
        if (cellFeedCommInfo != null) {
            return cellFeedCommInfo.isVideoAdv() || this.mFeedCommInfo.isAppAdvFeed() || this.mFeedCommInfo.isFamousRecommAdvFeed() || this.mFeedCommInfo.isVideoAdvShareFeed() || this.mFeedCommInfo.isBrandUgcAdvFeeds();
        }
        return false;
    }

    public boolean isBrandUgcAdvFeeds() {
        CellFeedCommInfo cellFeedCommInfo = this.mFeedCommInfo;
        return cellFeedCommInfo != null && cellFeedCommInfo.isBrandUgcAdvFeeds();
    }

    public boolean isGDTAdvFeed() {
        CellFeedCommInfo cellFeedCommInfo = this.mFeedCommInfo;
        return cellFeedCommInfo != null && cellFeedCommInfo.isGDTAdvFeed();
    }

    public boolean isLiveVideoFeed() {
        return this.mCellLive != null;
    }

    public boolean isVideoAdv() {
        CellFeedCommInfo cellFeedCommInfo = this.mFeedCommInfo;
        return cellFeedCommInfo != null && cellFeedCommInfo.isVideoAdv();
    }

    public void setCellFeedCommInfo(CellFeedCommInfo cellFeedCommInfo) {
        this.mFeedCommInfo = cellFeedCommInfo;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put("feed_data", marshall);
    }
}
