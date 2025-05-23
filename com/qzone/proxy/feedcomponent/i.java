package com.qzone.proxy.feedcomponent;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface i {
    void calculatePic(BusinessFeedData businessFeedData);

    com.qzone.proxy.feedcomponent.ui.detail.a createDetailWidgetAdapter(Context context, int i3);

    com.qzone.proxy.feedcomponent.ui.detail.b createFeedCommentDetailAdapter(Context context, ViewGroup viewGroup, com.qzone.proxy.feedcomponent.ui.g gVar);

    com.qzone.proxy.feedcomponent.ui.detail.b createFeedDetailCommentAdapter(Context context, ViewGroup viewGroup, com.qzone.proxy.feedcomponent.ui.g gVar);

    void doCommentActionReport(int i3);

    void doFloatViewActionReport(int i3);

    void feedVideoReport(BusinessFeedData businessFeedData, int i3, int i16, boolean z16, int i17);

    AbsFeedView generateFeedView(Context context, com.qzone.proxy.feedcomponent.ui.g gVar, boolean z16, boolean z17);

    AbsFeedView generateFrdLikeVideoFeedView(Context context);

    AbsFeedView generateFrdLikeVideoSlideFeedView(Context context);

    AbsFeedView generateFriendVideoFeedView(Context context);

    AbsFeedView gererateFriendAnniversaryFeedView(Context context);

    AbsFeedView gererateFunctionGuideFeedView(Context context);

    com.qzone.proxy.feedcomponent.ui.d getAreaManagerInstance();

    int getCellCommentViewBottom(View view);

    String getCommentTextAreaDisReplyStr(Comment comment, int i3);

    boolean isOriginal(View view);

    void notifyNetworkChange(boolean z16);

    AbsFeedView obtainFeedAdvContainer(Context context, BusinessFeedData businessFeedData);

    AbsFeedView obtainFeedBirthdayContainer(Context context, BusinessFeedData businessFeedData);

    AbsFeedView obtainFeedGalleryContainer(Context context, BusinessFeedData businessFeedData);

    AbsFeedView obtainFeedView(Context context, com.qzone.proxy.feedcomponent.ui.g gVar, boolean z16, boolean z17, int i3);

    AbsFeedView obtainFriendAnniversyFeedView(Context context);

    AbsFeedView obtainFunctionGuideFeedView(Context context);

    AbsFeedView obtainNegativeFeedbackFeedView(Context context);

    AbsFeedView obtainNewGuideView(Context context);

    AbsFeedView obtainNewUserFeedView(Context context);

    AbsFeedView obtainRegisterAnniversyFeedView(Context context);

    AbsFeedView obtainVerticalRecomFollowFeedView(Context context);

    void onBirthdayGiftSendResult(View view, int i3, boolean z16);

    void onBirthdayGiftSending(View view, int i3);

    void onConfigurationChanged(Configuration configuration);

    void onFeedScrollAction(ViewGroup viewGroup, Adapter adapter, int i3, int i16, int i17, int i18);

    void onFeedScrollStateChangedAction(ViewGroup viewGroup, Adapter adapter, int i3, boolean z16, int i16);

    void onListViewIdle(ViewGroup viewGroup);

    void onListViewIdleWithPanorama(ViewGroup viewGroup, ListAdapter listAdapter);

    void onListViewIdleWithVideoCover(ViewGroup viewGroup, FrameLayout frameLayout, BaseAdapter baseAdapter, boolean z16);

    void onListViewScrolling(ViewGroup viewGroup);

    void onThemeColorChange();

    void onUserActionReportCickListener(View view, FeedElement feedElement, BusinessFeedData businessFeedData, int i3, Object obj, int i16);

    String parseCommentTextAreaCommentText(User user, String str);

    String parseCommentTextAreaReplyText(Reply reply);

    void preCalculateData(BusinessFeedData businessFeedData, boolean z16);

    void recyleFeedView(boolean z16, int i3);

    void replaceVideoInfoIfNecessary(BusinessFeedData businessFeedData);

    void setFeedViewData(Context context, AbsFeedView absFeedView, BusinessFeedData businessFeedData, boolean z16);

    void setMyFeedViewData(AbsFeedView absFeedView, BusinessFeedData businessFeedData, boolean z16);

    void updateCardAddFriendItemState(AbsFeedView absFeedView, String str);

    void updateRecommenAddFriendItemState(AbsFeedView absFeedView, String str);
}
