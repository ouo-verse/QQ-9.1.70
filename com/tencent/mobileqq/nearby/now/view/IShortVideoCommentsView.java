package com.tencent.mobileqq.nearby.now.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IShortVideoCommentsView extends QRouteApi {
    void addLoadingErrorView(Object obj);

    boolean canPlayNext();

    AppInterface getApp();

    View getPlayerView();

    Comments getmComments();

    ImageView getmEmptyCloseBtn();

    void init(Object obj, VideoData videoData);

    void initLocationView();

    void initRecorderInfoView();

    boolean isScrollTop();

    void jump2Report(Comments.Comment comment);

    void onActivityCreated(Comments comments, int i3);

    void onActivityResult(int i3, int i16, Intent intent);

    void onCreate();

    View onCreateView();

    void onPause();

    void onResume();

    void reportBindPhoneAction(AppInterface appInterface, String str);

    void scrollToComment();

    void scrollToTop();

    void setApp(AppInterface appInterface);

    void setPlayerView(View view);

    void setVideoData(VideoData videoData);

    void setmComments(Comments comments);

    void setmEmptyCloseBtn(ImageView imageView);

    void showBindPhone(String str);

    void showBottomeArea();

    void showComment();

    void showDelAndReportSheet(Comments.Comment comment);

    void showDelSheet(Comments.Comment comment);

    void showEmptyCloseBtn();

    void showReportSheet(Comments.Comment comment);
}
