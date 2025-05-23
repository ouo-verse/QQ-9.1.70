package com.qzone.proxy.covercomponent.ui;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cooperation.qzone.model.CoverCacheData;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface IQZoneCoverContainer extends ICoverBaseParent {
    void breezePause();

    void breezeResume();

    void calljs(String str);

    void delayShow();

    void dispatchPullEvent(int i3, int i16);

    void doWhenLoadingFailed();

    Activity getActivity();

    FrameLayout getAttachView();

    int getCoverType();

    <T> T getExtra(Class<T> cls);

    int getTransparency();

    void hideFullscreenCover();

    boolean isCoverVisible();

    boolean isPaused();

    void onConfigurationChanged(Configuration configuration);

    void onCoverInvislble();

    void onCoverVisible();

    void onDestory();

    void onHandleMessage(Message message);

    void onHierarchyChange(ViewGroup viewGroup);

    void onPause();

    void onPullChanged(float f16);

    void onPullEnd();

    void onPullStart();

    void onResume();

    void onStart();

    void onStop();

    void setActivity(Activity activity);

    void setCacheCover(long j3);

    void setCacheCover(long j3, CoverCacheData coverCacheData);

    void setCoverInMainThread(long j3, CoverCacheData coverCacheData);

    void setCustomWebviewCover(long j3, String str, String str2, String str3);

    void setEmptyCover();

    void setGravity(int i3);

    void setHandler(Handler handler);

    void setIsInLimitPage(boolean z16);

    void setIsTiantaiStyle(boolean z16);

    void setOnCoverChangedListener(IOnCoverChangedListener iOnCoverChangedListener);

    void setOnCoverClickListener(IOnCoverClickListener iOnCoverClickListener);

    void setOuterLayout(ViewGroup viewGroup);

    void setRefer(int i3);

    void setVisiblePadding(int i3);

    void setVisiblePadding(int i3, int i16);

    void showFullscreenCover(ViewGroup viewGroup);

    void stopCover();
}
