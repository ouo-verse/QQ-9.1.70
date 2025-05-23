package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IPlayOperationViewModel extends QRouteApi {
    public static final int FEED_TYPE_RECORD_LIVE_VIDEO_FEED = 1;
    public static final int FEED_TYPE_RECORD_STORY_VIDEO_FEED = 3;
    public static final int FEED_TYPE_RECORD_VIDEO_FEED = 2;
    public static final int TRANSPARENT = 0;
    public static final int TYPE_CHANG = 6;
    public static final int TYPE_PIC = 4;
    public static final int WHITE_BGK = 1;

    void destroy();

    void doOnResume();

    AppInterface getApp();

    String getExtraInfo();

    boolean getIsAggregation();

    boolean getIsCanJump();

    boolean getIsFollow();

    boolean getIsLiked();

    boolean getIsLocal();

    boolean getIsMine();

    boolean getIsRecord();

    int getLikes();

    String getNickName();

    int getOperatorMode();

    String getRecordTime();

    String getRecordTitle();

    String getVideoSrc();

    int getWatchCount();

    View getmBinding();

    View getmHeadBinding();

    void hideCommentsWidget();

    void hideHead();

    IPlayOperationViewModel init(View view, AppInterface appInterface);

    void initCommentsWidget();

    boolean isDialogShow();

    boolean isJubaoDialogShow();

    void onClickClose(View view);

    void onClickFollow(View view);

    void onClickHeader(View view);

    void onClickLabelJump(View view);

    void onClickLike(View view);

    void onClickMore(View view);

    void onClickNickName(View view);

    void onClickPublishComment(View view);

    void onClickShare(View view);

    void parseShortVideoVideoLabel(Object obj);

    boolean queryVideoState(long j3);

    void release();

    void reshowOperaView();

    void setAgeAndGender(int i3, int i16);

    void setAggregation(boolean z16);

    void setApp(AppInterface appInterface);

    void setCanJump(boolean z16);

    void setCommentsCount(long j3);

    void setCurrentAnchorUin(long j3);

    void setDialogShow(boolean z16);

    void setExtraInfo(String str);

    void setFeedType(int i3);

    void setFollow(boolean z16);

    void setHeadBinding(View view);

    void setHeadInfoMaskWhiteMode();

    void setHeadUrl(String str);

    void setIsMine(boolean z16);

    void setJubaoDialogShow(boolean z16);

    void setLiked(boolean z16);

    void setLikes(int i3);

    void setLocal(boolean z16);

    void setNickName(String str);

    void setOnCloseListener(Object obj);

    void setOnCommentClickListener(View.OnClickListener onClickListener);

    void setOpenRoomHeadUrl(String str);

    void setOperatorMode(int i3);

    void setRecord(boolean z16);

    void setRecordTime(String str);

    void setRecordTitle(String str);

    void setTopOperationBkg(int i3);

    void setVideoPageSource(int i3);

    void setVideoSrc(String str);

    void setWatchCount(int i3);

    void setmBinding(View view);

    void setmHeadBinding(View view);

    void showIfCan(boolean z16);

    void updateShowInfo(VideoData videoData);
}
