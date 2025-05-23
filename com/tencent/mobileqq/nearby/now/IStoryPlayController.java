package com.tencent.mobileqq.nearby.now;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.HashMap;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IStoryPlayController extends QRouteApi {
    void doOnActivityResult(int i3, int i16, Intent intent);

    void doOnDestroy();

    void doOnPause();

    void doOnResume();

    Object getAdapter();

    Object getBasePlayListDataModel();

    Context getContext();

    int getCurrentIndex();

    int getCurrentMediaType();

    int getFirstShowIndex();

    HashMap<Integer, Object> getItemListeners();

    int getOldState();

    Object getStuffContainerView();

    String getValue(String str);

    Object getVideoPlayer();

    void handleDeviceNavChange();

    void hideRootCover();

    IStoryPlayController init(Context context, Object obj, Object obj2, Bundle bundle, Object obj3, AppInterface appInterface, a aVar);

    void initReporterFeedType();

    void initialize(Bundle bundle);

    boolean isIsMultiProgressBar();

    boolean isMultiProgressBar();

    boolean isNeedRepeat();

    boolean isRefreshCurrentItem();

    void loadCoverImage(ImageView imageView, String str, Object obj);

    void onFillData(Object obj, VideoData videoData, boolean z16, Object obj2);

    void onFillData(Object obj, VideoData videoData, boolean z16, Object obj2, boolean z17);

    boolean onKeyDown(int i3, KeyEvent keyEvent);

    void onPagerItemClick(View view);

    void onViewConstruct(LayoutInflater layoutInflater, Object obj, Object obj2);

    void prepare(boolean z16, RelativeLayout relativeLayout, VideoData videoData, Object obj);

    void prepare(boolean z16, RelativeLayout relativeLayout, VideoData videoData, Object obj, boolean z17);

    void returnBack();

    void setCurrentIndex(int i3);

    void setCurrentMediaType(int i3);

    void setFirstShowIndex(int i3);

    void setIsMultiProgressBar(boolean z16);

    void setNeedRepeat(boolean z16);

    void setOldState(int i3);

    void setVideoPlayer(Object obj);

    void startPlayVideo(int i3);

    void updateVideoLabelState();
}
