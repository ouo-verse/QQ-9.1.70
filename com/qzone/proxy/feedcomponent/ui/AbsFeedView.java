package com.qzone.proxy.feedcomponent.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class AbsFeedView extends LinearLayout implements com.qzone.proxy.feedcomponent.widget.g {
    public static final int MY_FEED_TYPE_COUNT = 2;
    public static final int SECRET_FEED_VIEW = 6;
    public static final int TYPE_ADVCONTAINER = 2;
    public static final int TYPE_BIRTHDAY_CARD = 21;
    public static final int TYPE_CONTAINER = 1;
    public static final int TYPE_COUNT = 28;
    public static final int TYPE_EXTEND_NUAN_FRIEND_FEED_ENTER = 15;
    public static final int TYPE_FRD_LIKE_VIDEO = 12;
    public static final int TYPE_FRIEND_ANNIVERSARY_VIEW = 5;
    public static final int TYPE_FRIEND_LIKE_VIDEO_SLIDE = 16;
    public static final int TYPE_FRIEND_VIDEO = 11;
    public static final int TYPE_FUNCTION_GUIDE_VIEW = 4;
    public static final int TYPE_ISSUED_FEED = 17;
    public static final int TYPE_LAST_PUBLISH_SUPPORT_REEDIT_FEED = 26;
    public static final int TYPE_MY_EVENT_TAG = 9;
    public static final int TYPE_NEGATIVE_FEEDBACK_VIEW = 8;
    public static final int TYPE_NEW_FUNCTION_GUIDE = 14;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_QCIRCLE_FRD_HOT_VIDEO_FEED_LISTVIEW = 27;
    public static final int TYPE_QQ_LIVE_FEED = 24;
    public static final int TYPE_READ_LINE_FEED = 23;
    public static final int TYPE_RECOMM_EVENT_TAG = 7;
    public static final int TYPE_REGISTER_ANNIVERSARY_VIEW = 13;
    public static final int TYPE_SHAI_SHAI_FEED = 22;
    public static final int TYPE_SHAI_SHAI_RECOMMEND_FEED = 25;
    public static final int TYPE_VERTICAL_RECOMMEND_FRIEND = 3;
    public static final int TYPE_VERTICAL_RECOM_FOLLOW = 10;
    public static final int USER_HOME_TYPE_COUNT = 3;
    public int alpha;
    private int headViewCount;
    public long intoScreenTimestamp;
    public BusinessFeedData mFeedData;
    public long mLastTouchDownTime;
    public int mLastTouchDownX;
    public int mLastTouchDownY;
    public long mLastTouchUpTime;
    public int mLastTouchUpX;
    public int mLastTouchUpY;
    public int mPos;
    public WeakReference<View> parentView;
    public long timeStamp;
    public int type;

    public AbsFeedView(Context context) {
        super(context);
        this.type = 0;
        this.mPos = -1;
    }

    public boolean canLiveFeedAutoPlay() {
        return false;
    }

    public boolean canShowFeedSkin() {
        return true;
    }

    public View getFeedDateHeader() {
        return null;
    }

    /* renamed from: getFeedPosition */
    public int getMFeedPosition() {
        return -1;
    }

    public View getFollowButtonPos(Rect rect) {
        return null;
    }

    public int getHeadViewCount() {
        return this.headViewCount;
    }

    public View getVideoView() {
        return null;
    }

    public View getVideoViewPos(Rect rect, boolean z16) {
        return null;
    }

    public abstract boolean hasVideoPlayed();

    public abstract boolean isAlwaysAutoPlayFeed();

    public abstract boolean isAutoVideoFeed();

    public boolean isDateHeaderShow() {
        return false;
    }

    public void onPause() {
        reportStayScreen();
    }

    public void onRecycled(boolean z16) {
        reportStayScreen();
    }

    public abstract void onStateIdle();

    public abstract void onStateIdleOnDetail(boolean z16);

    public abstract void onStateScrolling();

    public String printViewTree() {
        return "";
    }

    public abstract void reportFeed(BusinessFeedData businessFeedData, int i3);

    public abstract void setAlpha(int i3);

    public void setData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
    }

    public abstract void setFeedPosition(int i3);

    public abstract void setHasRecommHeader(boolean z16);

    public abstract void setHasSearchSeparator(boolean z16);

    public void setHeadViewCount(int i3) {
        this.headViewCount = i3;
    }

    public abstract void setNeedFillBlackArea(boolean z16);

    public abstract void setOnFeedElementClickListener(g gVar);

    public abstract void setOnFeedEventListener(h hVar);

    public abstract void showSearchSeparator(boolean z16, String str);

    public abstract void startFlashNickName();

    public abstract void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16);

    public abstract void updateLikeInfo(BusinessFeedData businessFeedData);

    public abstract void updateRecommAction(BusinessFeedData businessFeedData);

    public abstract void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16);

    public abstract void updateTitle(BusinessFeedData businessFeedData, @Deprecated Boolean bool);

    public abstract void updateTransparentBackground(BusinessFeedData businessFeedData);

    public void onRecycled() {
        onRecycled(true);
    }

    public void setParentView(View view) {
        if (view != null) {
            this.parentView = new WeakReference<>(view);
        }
    }

    public View getSinglePicAreaPos(Rect rect) {
        return this;
    }

    void reportStayScreen() {
    }

    public void reset() {
    }

    public void setOnFeedFirstDrawListener(i iVar) {
    }

    public void updateFollowGuide() {
    }

    public void updateMenuArea(BusinessFeedData businessFeedData) {
    }

    public void updateRecommVideoData(BusinessFeedData businessFeedData) {
    }
}
