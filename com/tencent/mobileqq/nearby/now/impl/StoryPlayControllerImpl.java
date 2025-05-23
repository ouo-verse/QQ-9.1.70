package com.tencent.mobileqq.nearby.now.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.av.utils.ba;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.common.app.AppInterface;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.model.a;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.utils.IStorageCenter;
import com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil;
import com.tencent.mobileqq.nearby.now.view.IMagazinePlayerViewCreater;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.h;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class StoryPlayControllerImpl implements StuffContainerView.e, ViewPager.OnPageChangeListener, IStoryPlayController {
    public static final int MSG_CHECK_GUIDE = 1001;
    public static final String TAG = "VideoPlayController";
    public static final int UNSUPPORT_IMAGE_ERROR_CODE = 1000730;
    public QQAppInterface app;
    public com.tencent.mobileqq.nearby.now.a callBack;
    public QQStoryVideoPlayerErrorView errorView;
    public h mAdapter;
    public Bundle mBundle;
    public Context mContext;
    public int mCurrentIndex;
    public int mCurrentMediaType;
    private boolean mIsDestroy;
    private boolean mIsShownNewGuide;
    private com.tencent.mobileqq.nearby.now.view.widget.a mNewGuideDialog;
    public com.tencent.mobileqq.nearby.now.model.a mPlayListDataModel;
    public QQStoryLoadingView mProgressBar;
    public com.tencent.mobileqq.nearby.now.view.d mVideoPlayer;
    public StuffContainerView stuffContainerView;
    private int mOldState = -1;
    public int mFirstShowIndex = 0;
    private boolean mIsFirstGetData = true;
    private String mFeedId = "";
    private boolean mIsInfinite = false;
    private boolean mShouldOpenComment = false;
    boolean isUrlProvided = false;
    Handler mHandler = new a();
    private boolean mFirstResume = true;
    private boolean mInfiniteFirstPlay = false;
    private boolean mHasShowToast = false;
    private boolean mFirstPlayShow = true;
    public HashMap<Integer, IVideoInfoListener> itemListeners = new HashMap<>();
    public boolean mNeedRepeat = false;
    public boolean mIsMultiProgressBar = false;
    a.InterfaceC8140a mDataComeListener = new b();
    private Runnable hideNewGuideRunnable = new Runnable() { // from class: com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl.9
        @Override // java.lang.Runnable
        public void run() {
            if (StoryPlayControllerImpl.this.mNewGuideDialog == null || !StoryPlayControllerImpl.this.mNewGuideDialog.isShowing()) {
                return;
            }
            StoryPlayControllerImpl storyPlayControllerImpl = StoryPlayControllerImpl.this;
            if ((storyPlayControllerImpl.mContext instanceof Activity) && (storyPlayControllerImpl.mIsDestroy || ((Activity) StoryPlayControllerImpl.this.mContext).isFinishing())) {
                StoryPlayControllerImpl.this.mNewGuideDialog = null;
            } else {
                StoryPlayControllerImpl.this.mNewGuideDialog.dismiss();
                StoryPlayControllerImpl.this.mNewGuideDialog = null;
            }
        }
    };

    /* loaded from: classes33.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1001) {
                StoryPlayControllerImpl storyPlayControllerImpl = StoryPlayControllerImpl.this;
                storyPlayControllerImpl.checkNewGuide(storyPlayControllerImpl.mCurrentIndex);
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes33.dex */
    class b implements a.InterfaceC8140a {

        /* loaded from: classes33.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StoryPlayControllerImpl.this.mPlayListDataModel.a();
                StoryPlayControllerImpl.this.stuffContainerView.F.setVisibility(8);
                StoryPlayControllerImpl.this.stuffContainerView.L.setVisibility(8);
            }
        }

        b() {
        }

        @Override // com.tencent.mobileqq.nearby.now.model.a.InterfaceC8140a
        public void a(VideoData videoData) {
            if (QLog.isColorLevel()) {
                QLog.i(StoryPlayControllerImpl.TAG, 2, "onFillData ! data is: " + videoData.toString() + " " + videoData.f252700h);
            }
            if (StoryPlayControllerImpl.this.mAdapter.f252886h.size() == 1 && StoryPlayControllerImpl.this.mAdapter.f252884e.size() == 1 && StoryPlayControllerImpl.this.mAdapter.f252885f.size() == 1) {
                if (QLog.isColorLevel()) {
                    QLog.i(StoryPlayControllerImpl.TAG, 2, "onFillData ! suc");
                }
                videoData.f252700h = StoryPlayControllerImpl.this.mAdapter.f252886h.get(0).f252700h;
                StoryPlayControllerImpl.this.mAdapter.f252886h.set(0, videoData);
                StoryPlayControllerImpl.this.mAdapter.f252884e.get(0).f252898h = videoData;
                h.b bVar = StoryPlayControllerImpl.this.mAdapter.f252884e.get(0);
                IShortVideoCommentsView iShortVideoCommentsView = (IShortVideoCommentsView) StoryPlayControllerImpl.this.mAdapter.f252885f.get(0);
                iShortVideoCommentsView.setVideoData(videoData);
                iShortVideoCommentsView.initLocationView();
                iShortVideoCommentsView.initRecorderInfoView();
                bVar.f252894d.setCurrentAnchorUin(videoData.D);
                StoryPlayControllerImpl.this.onFillData(bVar, videoData, false, iShortVideoCommentsView, false);
            }
        }

        @Override // com.tencent.mobileqq.nearby.now.model.a.InterfaceC8140a
        public void b(int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.i(StoryPlayControllerImpl.TAG, 2, "onDataCome ! type is: " + i3 + " errorCode is " + i16);
            }
            if (i16 <= 0 && StoryPlayControllerImpl.this.mPlayListDataModel.c().size() != 0) {
                StoryPlayControllerImpl.this.stuffContainerView.F.setVisibility(8);
                StoryPlayControllerImpl.this.stuffContainerView.L.setVisibility(8);
                StoryPlayControllerImpl storyPlayControllerImpl = StoryPlayControllerImpl.this;
                storyPlayControllerImpl.stuffContainerView.D.d(storyPlayControllerImpl.mPlayListDataModel.d());
                StoryPlayControllerImpl storyPlayControllerImpl2 = StoryPlayControllerImpl.this;
                storyPlayControllerImpl2.stuffContainerView.D.c(storyPlayControllerImpl2.mPlayListDataModel.d());
                StoryPlayControllerImpl storyPlayControllerImpl3 = StoryPlayControllerImpl.this;
                h hVar = storyPlayControllerImpl3.mAdapter;
                boolean z16 = hVar.C;
                if (!z16) {
                    if (z16) {
                        return;
                    }
                    hVar.d(i3, storyPlayControllerImpl3.mPlayListDataModel.c());
                    StoryPlayControllerImpl.this.initReporterFeedType();
                    StoryPlayControllerImpl.this.mAdapter.notifyDataSetChanged();
                    StoryPlayControllerImpl storyPlayControllerImpl4 = StoryPlayControllerImpl.this;
                    storyPlayControllerImpl4.stuffContainerView.setCurrentItem(storyPlayControllerImpl4.mCurrentIndex, false);
                    return;
                }
                if (storyPlayControllerImpl3.mIsFirstGetData) {
                    int i17 = 0;
                    while (true) {
                        if (i17 >= StoryPlayControllerImpl.this.mPlayListDataModel.c().size()) {
                            i17 = -1;
                            break;
                        } else if (StoryPlayControllerImpl.this.mPlayListDataModel.c().get(i17).f252695e.equals(StoryPlayControllerImpl.this.mFeedId)) {
                            break;
                        } else {
                            i17++;
                        }
                    }
                    if (i17 == -1) {
                        i17 = (StoryPlayControllerImpl.this.mPlayListDataModel.c().size() / 2) - 1;
                    }
                    StoryPlayControllerImpl storyPlayControllerImpl5 = StoryPlayControllerImpl.this;
                    storyPlayControllerImpl5.mFirstShowIndex = i17;
                    if (i17 != -1) {
                        storyPlayControllerImpl5.mCurrentIndex = i17;
                        storyPlayControllerImpl5.mAdapter.G = i17;
                    }
                    q92.c.d();
                } else if (i3 == 0) {
                    StoryPlayControllerImpl storyPlayControllerImpl6 = StoryPlayControllerImpl.this;
                    int i18 = storyPlayControllerImpl6.mCurrentIndex;
                    storyPlayControllerImpl6.mPlayListDataModel.c().size();
                }
                StoryPlayControllerImpl storyPlayControllerImpl7 = StoryPlayControllerImpl.this;
                storyPlayControllerImpl7.mAdapter.d(i3, storyPlayControllerImpl7.mPlayListDataModel.c());
                StoryPlayControllerImpl.this.initReporterFeedType();
                if (StoryPlayControllerImpl.this.mIsFirstGetData) {
                    StoryPlayControllerImpl storyPlayControllerImpl8 = StoryPlayControllerImpl.this;
                    storyPlayControllerImpl8.stuffContainerView.setCurrentItem(storyPlayControllerImpl8.mCurrentIndex, false);
                    StoryPlayControllerImpl.this.mIsFirstGetData = false;
                }
                StoryPlayControllerImpl.this.mAdapter.notifyDataSetChanged();
                StoryPlayControllerImpl storyPlayControllerImpl9 = StoryPlayControllerImpl.this;
                storyPlayControllerImpl9.showSlideGuide(storyPlayControllerImpl9.mCurrentIndex);
                return;
            }
            QLog.e(StoryPlayControllerImpl.TAG, 1, "onDataCome errorCode > 0, errorCode=" + i16 + " mPlayListDataModel.getDataList().size() is : " + StoryPlayControllerImpl.this.mPlayListDataModel.c().size());
            if (i16 == 1000730) {
                if (QLog.isColorLevel()) {
                    QLog.i(StoryPlayControllerImpl.TAG, 2, "onDataCome error! errorCode is: " + i16);
                    return;
                }
                return;
            }
            if (StoryPlayControllerImpl.this.mAdapter.f252886h.size() != 0) {
                if (QLog.isColorLevel()) {
                    QLog.i(StoryPlayControllerImpl.TAG, 2, "onDataCome error! pass it! errorCode is: " + i16);
                    return;
                }
                return;
            }
            StoryPlayControllerImpl.this.stuffContainerView.m(false);
            StoryPlayControllerImpl.this.stuffContainerView.F.setVisibility(0);
            StoryPlayControllerImpl.this.stuffContainerView.L.setVisibility(0);
            StoryPlayControllerImpl.this.stuffContainerView.F.b(i16);
        }

        @Override // com.tencent.mobileqq.nearby.now.model.a.InterfaceC8140a
        public void onError() {
            if (!com.tencent.biz.common.util.g.b(StoryPlayControllerImpl.this.getContext()) || StoryPlayControllerImpl.this.mAdapter.f252886h.size() == 0) {
                return;
            }
            StoryPlayControllerImpl.this.stuffContainerView.F.c();
            StoryPlayControllerImpl.this.stuffContainerView.F.setVisibility(0);
            StoryPlayControllerImpl.this.stuffContainerView.L.setVisibility(0);
            StoryPlayControllerImpl.this.stuffContainerView.F.setOnRetryClickListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class f implements com.tencent.mobileqq.nearby.now.view.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.b f252656a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ VideoData f252657b;

        /* loaded from: classes33.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.f252656a.f252896f.setVisibility(8);
                f fVar = f.this;
                fVar.f252656a.f252895e.c(fVar.f252657b);
            }
        }

        f(h.b bVar, VideoData videoData) {
            this.f252656a = bVar;
            this.f252657b = videoData;
        }

        @Override // com.tencent.mobileqq.nearby.now.view.g
        public void a(String str, View view, int i3) {
            OperationView operationView = this.f252656a.f252894d;
            if (operationView != null) {
                operationView.b().getmBinding().findViewById(R.id.e9a).setVisibility(8);
            }
            this.f252656a.f252896f.c();
            this.f252656a.f252896f.setVisibility(0);
            this.f252656a.f252896f.setOnClickListener(new a());
        }

        @Override // com.tencent.mobileqq.nearby.now.view.g
        public void b(int i3, int i16) {
            OperationView operationView = this.f252656a.f252894d;
            if (operationView != null) {
                operationView.b().getmBinding().findViewById(R.id.e9a).setVisibility(0);
            }
            this.f252656a.f252896f.setVisibility(8);
            this.f252656a.f252895e.setVisibility(0);
            this.f252656a.f252895e.requestLayout();
            StoryPlayControllerImpl.this.callBack.U7();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class g implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h.b f252660d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashMap f252661e;

        g(h.b bVar, HashMap hashMap) {
            this.f252660d = bVar;
            this.f252661e = hashMap;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f252660d.f252893c != null) {
                ((IVideoPlayerView) StoryPlayControllerImpl.this.mVideoPlayer).resume();
                if (this.f252661e.get(Integer.valueOf(this.f252660d.f252891a)) != null) {
                    ((IVideoInfoListener) this.f252661e.get(Integer.valueOf(this.f252660d.f252891a))).scrollToTop();
                }
            }
            StoryPlayControllerImpl.this.mNewGuideDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNewGuide(int i3) {
        h.b e16;
        if (i3 != this.mCurrentIndex || this.mIsDestroy || (e16 = this.mAdapter.e(i3)) == null || this.mAdapter.f252886h.size() <= 1 || this.mIsShownNewGuide) {
            return;
        }
        if (e16.f252893c != null) {
            ((IVideoPlayerView) this.mVideoPlayer).pause();
        }
        if (this.mNewGuideDialog != null) {
            return;
        }
        com.tencent.mobileqq.nearby.now.view.widget.a aVar = new com.tencent.mobileqq.nearby.now.view.widget.a(this.stuffContainerView.f252838d);
        this.mNewGuideDialog = aVar;
        aVar.a(HardCodeUtil.qqStr(R.string.tuq));
        this.mNewGuideDialog.setOnDismissListener(new g(e16, this.itemListeners));
        this.mNewGuideDialog.show();
        this.mIsShownNewGuide = true;
        ((IStorageCenter) QRoute.api(IStorageCenter.class)).putBoolean("short_video_player_guide_shown", true);
        ThreadManager.getUIHandler().postDelayed(this.hideNewGuideRunnable, 3000L);
    }

    private void playPictuer(int i3, h.b bVar, VideoData videoData) {
        this.stuffContainerView.D.a(true);
        bVar.f252895e.setRelayoutListener(new f(bVar, videoData));
        if (videoData.f252703i0.get(0) != null) {
            if (this.mAdapter.getView(i3) instanceof IShortVideoCommentsView) {
                ((IStoryRelayoutUtil) QRoute.api(IStoryRelayoutUtil.class)).dynamicLayoutStoryImageContainerView(bVar, videoData.f252703i0.get(0).f252714c, videoData.f252703i0.get(0).f252713b, videoData, (IShortVideoCommentsView) this.mAdapter.getView(i3));
            }
            bVar.f252895e.setVisibility(8);
            bVar.f252895e.c(videoData);
            hideRootCover();
        }
    }

    private void playShortVideo(int i3, h.b bVar, VideoData videoData) {
        OperationView operationView;
        int i16;
        q92.c.f();
        if (com.tencent.biz.common.util.g.a(getContext()) != 1 && (i16 = this.mCurrentMediaType) != 4 && i16 != VideoData.f252689l0 && !videoData.f252701h0) {
            QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.tug), 1).show();
            this.mHasShowToast = true;
        }
        com.tencent.mobileqq.nearby.now.a aVar = this.callBack;
        if (aVar != null) {
            aVar.o4();
        }
        if (bVar != null && (operationView = bVar.f252894d) != null) {
            operationView.f(videoData);
            ((IVideoPlayerView) this.mVideoPlayer).setOnVideoInfoListener(this.itemListeners.get(Integer.valueOf(bVar.f252891a)));
            ((IVideoPlayerView) this.mVideoPlayer).play(bVar.f252893c, videoData, new e());
        }
        this.stuffContainerView.D.b(i3, 0);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "playShortVideovideoDataIndex is: " + i3 + " percent is: 0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSlideGuide(int i3) {
        if (this.mIsShownNewGuide) {
            return;
        }
        this.mHandler.removeMessages(1001);
        this.mHandler.sendEmptyMessageDelayed(1001, 1000L);
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void doOnDestroy() {
        if (this.mVideoPlayer.getVideoData() != null) {
            long fileSize = ((IVideoPlayerView) this.mVideoPlayer).getFileSize();
            long downloadOffset = ((IVideoPlayerView) this.mVideoPlayer).getDownloadOffset();
            q92.c.l(this.mVideoPlayer.getVideoData().f252695e, 2, String.valueOf(fileSize != 0 ? downloadOffset / fileSize : 0.0d), String.valueOf(fileSize), String.valueOf(downloadOffset), String.valueOf(q92.c.b()), ((IVideoPlayerView) this.mVideoPlayer).isPlaying());
        }
        ((IVideoPlayerView) this.mVideoPlayer).suspend();
        this.mAdapter.destroy();
        this.mIsDestroy = true;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void doOnPause() {
        ((IVideoPlayerView) this.mVideoPlayer).pause();
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void doOnResume() {
        SparseArray<h.b> sparseArray;
        h.b bVar;
        OperationView operationView;
        IPlayOperationViewModel b16;
        int i3;
        ((IVideoPlayerView) this.mVideoPlayer).resume();
        if (com.tencent.biz.common.util.g.a(getContext()) != 1 && (i3 = this.mCurrentMediaType) != 4 && i3 != VideoData.f252689l0 && this.mVideoPlayer.getVideoData() != null && !this.mVideoPlayer.getVideoData().f252701h0) {
            QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.tur), 1).show();
        }
        this.mFirstResume = false;
        h hVar = this.mAdapter;
        if (hVar == null || (sparseArray = hVar.f252884e) == null || sparseArray.size() == 0 || (bVar = this.mAdapter.f252884e.get(0)) == null || (operationView = bVar.f252894d) == null || (b16 = operationView.b()) == null) {
            return;
        }
        b16.doOnResume();
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public Object getAdapter() {
        return this.mAdapter;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public Object getBasePlayListDataModel() {
        return this.mPlayListDataModel;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public int getCurrentMediaType() {
        return this.mCurrentMediaType;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public int getFirstShowIndex() {
        return this.mFirstShowIndex;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public HashMap<Integer, Object> getItemListeners() {
        return this.itemListeners;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public int getOldState() {
        return this.mOldState;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public Object getStuffContainerView() {
        return this.stuffContainerView;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public String getValue(String str) {
        String str2;
        String str3;
        Bundle bundle = this.mBundle;
        if (bundle == null) {
            str2 = "";
        } else {
            str2 = bundle.getString(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        Bundle bundle2 = this.mBundle;
        if (bundle2 == null) {
            return "";
        }
        String string = bundle2.getString("raw_url");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            str3 = Uri.parse(string).getQueryParameter(str);
        } catch (Exception e16) {
            QLog.w(TAG, 1, e16 + "getValue no value in url key=" + str);
            str3 = "";
        }
        return TextUtils.isEmpty(str3) ? "" : str3;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public Object getVideoPlayer() {
        return this.mVideoPlayer;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void handleDeviceNavChange() {
        IVideoInfoListener iVideoInfoListener = this.itemListeners.get(Integer.valueOf(this.mCurrentIndex));
        if (iVideoInfoListener != null) {
            iVideoInfoListener.handleDeviceNavChange();
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void hideRootCover() {
        com.tencent.mobileqq.nearby.now.a aVar = this.callBack;
        if (aVar != null) {
            aVar.Je();
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void initReporterFeedType() {
        List<VideoData> list;
        h hVar = this.mAdapter;
        if (hVar == null || (list = hVar.f252886h) == null || list.size() <= 0) {
            return;
        }
        if (!this.mAdapter.f(0).f252701h0 && this.mAdapter.f252886h.size() <= 1) {
            if (this.mAdapter.f(0).f252692c0 == 4) {
                ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).setFeedType("2");
            }
            if (this.mAdapter.f(0).f252692c0 != 4) {
                ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).setFeedType("1");
                return;
            }
            return;
        }
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).setFeedType("3");
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void initialize(Bundle bundle) {
        if (bundle.getBoolean("play_list", true)) {
            if ("2".equals(bundle.getString("play_mode", "1"))) {
                this.mIsInfinite = false;
                this.mPlayListDataModel = new com.tencent.mobileqq.nearby.now.model.d();
                if ("1".equals(bundle.getString("isLocal"))) {
                    this.mPlayListDataModel.h(true);
                }
            } else {
                this.mIsInfinite = true;
                this.mPlayListDataModel = new com.tencent.mobileqq.nearby.now.model.c();
            }
        }
        QLog.i(TAG, 1, "rawUrl = " + bundle.getString("raw_url"));
        String value = getValue("feeds_id");
        this.mFeedId = value;
        if (TextUtils.isEmpty(value)) {
            this.mFeedId = getValue("feed_id");
            QLog.i(TAG, 1, " feeds_id is null,feed_id ==" + this.mFeedId);
        }
        if (this.mFeedId == null) {
            this.mFeedId = "";
        }
        this.stuffContainerView.D.a(false);
        String string = bundle.getString("processbar");
        if (!TextUtils.isEmpty(string)) {
            try {
                int parseInt = Integer.parseInt(string);
                if (parseInt == 1) {
                    this.stuffContainerView.D.a(false);
                } else if (parseInt == 2) {
                    this.stuffContainerView.D.a(true);
                }
            } catch (Exception unused) {
                QLog.w(TAG, 1, "bad url parameter in arguments 'progressbar'");
            }
        }
        this.mShouldOpenComment = bundle.getBoolean("should_show_comment_view", false);
        this.mPlayListDataModel.e(bundle);
        com.tencent.mobileqq.nearby.now.model.a aVar = this.mPlayListDataModel;
        aVar.f252709c = this.app;
        aVar.g(this.mDataComeListener);
        q92.c.e();
        this.mPlayListDataModel.a();
        VideoData videoData = new VideoData();
        String value2 = getValue("preLoadParams");
        boolean equals = getValue(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE).equals("4");
        QLog.i(TAG, 1, "preLoadJson~ in init = " + value2);
        if (TextUtils.isEmpty(value2)) {
            return;
        }
        String decode = URLDecoder.decode(value2);
        try {
            this.isUrlProvided = true;
            JSONObject jSONObject = new JSONObject(decode);
            videoData.f252695e = jSONObject.optString("id");
            videoData.H = jSONObject.optString("headerUrl");
            videoData.f252697f = jSONObject.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
            videoData.f252694d0 = jSONObject.optInt("videoHeight");
            videoData.f252696e0 = jSONObject.optInt("videoWidth");
            videoData.f252700h = jSONObject.optString("coverUrl");
            videoData.f252702i = jSONObject.optString("doodleUrl");
            videoData.V = jSONObject.optLong("video_timelong");
            videoData.f252693d = jSONObject.optLong("is_local") == 1 ? 4 : 2;
            videoData.f252701h0 = true;
            videoData.f252692c0 = 3;
            if (equals) {
                videoData.f252692c0 = 4;
                videoData.f252703i0 = new ArrayList<>();
                com.tencent.mobileqq.nearby.now.model.b bVar = new com.tencent.mobileqq.nearby.now.model.b();
                bVar.f252714c = videoData.f252694d0;
                bVar.f252713b = videoData.f252696e0;
                bVar.f252712a = videoData.f252700h;
                videoData.f252703i0.add(bVar);
            }
            if (videoData.f252693d == 4) {
                this.mPlayListDataModel.h(true);
            } else {
                this.mPlayListDataModel.b();
            }
            this.mPlayListDataModel.c().add(videoData);
            this.mPlayListDataModel.i(this.mFeedId, videoData.f252695e);
            this.mDataComeListener.b(1, 0);
            this.stuffContainerView.setCurrentItem(0, false);
        } catch (JSONException unused2) {
            QLog.i(TAG, 1, "no preload params~ in init");
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public boolean isIsMultiProgressBar() {
        return this.mIsMultiProgressBar;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public boolean isMultiProgressBar() {
        return this.mIsMultiProgressBar;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public boolean isNeedRepeat() {
        return this.mNeedRepeat;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public boolean isRefreshCurrentItem() {
        return this.mIsInfinite;
    }

    protected boolean isVideoListEnd() {
        return this.mPlayListDataModel.f();
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void loadCoverImage(ImageView imageView, String str, Object obj) {
        ((IImageLoader) QRoute.api(IImageLoader.class)).displayImage(imageView, str, new ColorDrawable(0), new ColorDrawable(0), ba.getScreenWidth(this.mContext) / 2, ba.getScreenHeight(this.mContext) / 2, new c(imageView, (IVideoInfoListener) obj), false);
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void onFillData(Object obj, VideoData videoData, boolean z16, Object obj2) {
        onFillData((h.b) obj, videoData, z16, (IShortVideoCommentsView) obj2, true);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        if (this.mAdapter.f252886h.size() == 1 || i3 == this.mOldState) {
            return;
        }
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "onPageScrollStateChanged SCROLL_STATE_IDLE currentIndex is: " + this.mCurrentIndex);
            }
            if (this.mCurrentIndex >= this.mAdapter.f252886h.size()) {
                return;
            }
            if (this.mAdapter.f252886h.get(this.mCurrentIndex).f252699g0) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "videoItem.isReady state = [" + i3 + "]");
                }
                ((IVideoPlayerView) this.mVideoPlayer).resume();
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "startPlayVideo state = [" + i3 + "]");
                }
                q92.c.c(1);
                startPlayVideo(this.mCurrentIndex);
            }
        } else if (i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "onPageScrollStateChanged mVideoPlayer.pause()");
            }
            ((IVideoPlayerView) this.mVideoPlayer).pause();
        }
        this.mOldState = i3;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void prepare(boolean z16, RelativeLayout relativeLayout, VideoData videoData, Object obj) {
        prepare(z16, relativeLayout, videoData, (IVideoInfoListener) obj, true);
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void returnBack() {
        this.stuffContainerView.h();
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void setCurrentIndex(int i3) {
        this.mCurrentIndex = i3;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void setCurrentMediaType(int i3) {
        this.mCurrentMediaType = i3;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void setFirstShowIndex(int i3) {
        this.mFirstShowIndex = i3;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void setIsMultiProgressBar(boolean z16) {
        this.mIsMultiProgressBar = z16;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void setNeedRepeat(boolean z16) {
        this.mNeedRepeat = z16;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void setOldState(int i3) {
        this.mOldState = i3;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void setVideoPlayer(Object obj) {
        this.mVideoPlayer = (com.tencent.mobileqq.nearby.now.view.d) obj;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void startPlayVideo(int i3) {
        int i16;
        h.b e16 = this.mAdapter.e(i3);
        if (e16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "startPlayVideo: videoViewHolder == null videoDataIndex=" + i3 + "  mAdapter.realIndex" + this.mAdapter.G);
                return;
            }
            return;
        }
        VideoData videoData = this.mAdapter.f252886h.get(i3);
        if (videoData != null) {
            q92.c.k(videoData.f252695e, 2, "0", "0");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "startPlayVideo:videoItem=" + videoData + ",videoItem.anchorUin=" + videoData.D + ",videoItem.anchorNickName=" + videoData.N);
            }
            OperationView operationView = e16.f252894d;
            if (operationView != null) {
                operationView.setCurrentAnchorUin(videoData.D);
            }
            if (i3 != this.mCurrentIndex) {
                return;
            }
            OperationView operationView2 = e16.f252894d;
            if (operationView2 != null) {
                operationView2.d();
            }
            int i17 = videoData.f252692c0;
            this.mCurrentMediaType = i17;
            if (i17 == 4) {
                playPictuer(i3, e16, videoData);
                ((INowShortVideoProtoManager) QRoute.api(INowShortVideoProtoManager.class)).init(this.app).reportPlay(videoData.f252695e, null);
                ((u92.c) this.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(videoData.f252695e);
                return;
            }
            int i18 = VideoData.f252689l0;
            if (i17 == i18) {
                ((INowShortVideoProtoManager) QRoute.api(INowShortVideoProtoManager.class)).init(this.app).reportPlay(videoData.f252695e, null);
                ((u92.c) this.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(videoData.f252695e);
                return;
            }
            playShortVideo(i3, e16, videoData);
            if (com.tencent.biz.common.util.g.a(getContext()) != 1 && (i16 = this.mCurrentMediaType) != 4 && i16 != i18 && !videoData.f252701h0) {
                QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.tun), 1).show();
                this.mFirstPlayShow = false;
            }
            showSlideGuide(i3);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void updateVideoLabelState() {
        h hVar = this.mAdapter;
        if (hVar.f252884e == null || hVar.f252886h == null) {
            QLog.e(TAG, 1, "updateVideoLabelState mAdapter.mVideoViewHolderList == null || mAdapter.mVideoDataList == null !!!!");
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public StoryPlayControllerImpl init(Context context, Object obj, Object obj2, Bundle bundle, Object obj3, AppInterface appInterface, com.tencent.mobileqq.nearby.now.a aVar) {
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        this.app = qQAppInterface;
        this.stuffContainerView = (StuffContainerView) obj;
        this.mAdapter = (h) obj2;
        this.mContext = context;
        this.mVideoPlayer = ((IMagazinePlayerViewCreater) QRoute.api(IMagazinePlayerViewCreater.class)).create(context, aVar, qQAppInterface);
        this.errorView = (QQStoryVideoPlayerErrorView) obj3;
        this.mBundle = bundle;
        String value = getValue("repeat");
        if (value != null && value.equals("1")) {
            this.mNeedRepeat = true;
        }
        this.mIsMultiProgressBar = bundle.getBoolean("is_multi_progress_bar", false);
        this.mIsShownNewGuide = ((IStorageCenter) QRoute.api(IStorageCenter.class)).getBoolean("short_video_player_guide_shown", false);
        this.callBack = aVar;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void onFillData(Object obj, VideoData videoData, boolean z16, Object obj2, boolean z17) {
        h.b bVar = (h.b) obj;
        IShortVideoCommentsView iShortVideoCommentsView = (IShortVideoCommentsView) obj2;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onFillData() called with: holder = [" + bVar + "], videoData = [" + videoData + "], willToPlay = [" + z16 + "], commentsView = [" + iShortVideoCommentsView + "]");
        }
        bVar.f252894d.f(videoData);
        bVar.f252894d.e(true);
        String str = videoData.f252700h;
        if (str != null && !TextUtils.isEmpty(str)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = new ColorDrawable(-16777216);
            obtain.mLoadingDrawable = new ColorDrawable(-16777216);
            obtain.mMemoryCacheKeySuffix = "now_blur";
            obtain.mUseAutoScaleParams = false;
            URLDrawable drawable = URLDrawable.getDrawable(videoData.f252700h, obtain);
            drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306340t);
            bVar.f252893c.setBackgroundDrawable(drawable);
        } else {
            bVar.f252893c.setBackgroundDrawable(new ColorDrawable(-16777216));
        }
        IVideoInfoListener init = ((IVideoInfoListener) QRoute.api(IVideoInfoListener.class)).init(bVar, this, iShortVideoCommentsView, ((IStoryRelayoutUtil) QRoute.api(IStoryRelayoutUtil.class)).dynamicChangeStoryContainerView(bVar, videoData.f252696e0, videoData.f252694d0));
        this.itemListeners.put(Integer.valueOf(bVar.f252891a), init);
        if (videoData.f252693d == 4) {
            bVar.f252894d.setVisibility(8);
            View view = bVar.f252897g;
            if (view != null) {
                view.findViewById(R.id.f166989jp2).setVisibility(4);
            }
        }
        prepare(z16, bVar.f252893c, videoData, init, z17);
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void prepare(boolean z16, RelativeLayout relativeLayout, VideoData videoData, Object obj, boolean z17) {
        String str;
        IVideoInfoListener iVideoInfoListener = (IVideoInfoListener) obj;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.duw);
        ImageView imageView2 = (ImageView) relativeLayout.findViewById(R.id.bo_);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setVisibility(0);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "prepare() called with: willToPlay = [" + z16 + "], rootView = [" + relativeLayout + "], videoData = [" + videoData + "], videoInfoListener = [" + iVideoInfoListener + "], loadCover = [" + z17 + "]");
        }
        if (z17 && (str = videoData.f252700h) != null) {
            if (!videoData.f252701h0) {
                loadCoverImage(imageView, str, iVideoInfoListener);
            } else {
                File file = AbsDownloader.getFile(str);
                if (file != null && file.exists()) {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "load cover,localFile exists,filepath = " + file.getAbsolutePath());
                        }
                        imageView.setImageDrawable(new ImageDrawable(BitmapReference.getBitmapReference(BitmapFactory.decodeFile(file.getAbsolutePath()))));
                        ((IVideoPlayerView.b) iVideoInfoListener).onCoverComplete(videoData.f252696e0, videoData.f252694d0, true);
                    } catch (OutOfMemoryError e16) {
                        QLog.e(TAG, 1, e16, new Object[0]);
                        loadCoverImage(imageView, videoData.f252700h, iVideoInfoListener);
                    }
                } else {
                    loadCoverImage(imageView, videoData.f252700h, iVideoInfoListener);
                }
            }
        }
        ((IImageLoader) QRoute.api(IImageLoader.class)).displayImage(imageView2, videoData.f252702i, new ColorDrawable(0), new ColorDrawable(0), new d(iVideoInfoListener));
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        int i16 = (i3 - 50) + this.mAdapter.G;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onPageSelected index is: " + i16 + " mCurrentIndex=" + this.mCurrentIndex);
        }
        if (i16 >= 0 && this.mAdapter.f252886h.size() != 0) {
            if (i16 >= this.mAdapter.f252886h.size() - 2) {
                this.mPlayListDataModel.i(this.mFeedId, this.mAdapter.f252886h.get(r3.size() - 1).f252695e);
                this.mFeedId = this.mAdapter.f252886h.get(r0.size() - 1).f252695e;
                this.mPlayListDataModel.a();
            }
            if (i16 < 2) {
                this.mPlayListDataModel.i(this.mFeedId, this.mAdapter.f252886h.get(0).f252695e);
                this.mFeedId = this.mAdapter.f252886h.get(0).f252695e;
                this.mPlayListDataModel.b();
            }
            if (i16 < this.mCurrentIndex) {
                ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_left_slide").genderInd1().reportByVideo(this.app);
            }
            final VideoData videoData = this.mAdapter.f252886h.get(this.mCurrentIndex);
            videoData.f252699g0 = false;
            if (i16 > this.mCurrentIndex) {
                ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_right_slide").genderInd1().reportByVideo(this.app);
                final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl.7
                    @Override // java.lang.Runnable
                    public void run() {
                        q h16 = new q(StoryPlayControllerImpl.this.app).i("dc00899").a("grp_lbs").f("video").d("playpage_right_slide").h(String.valueOf(videoData.D));
                        String[] strArr = new String[4];
                        String str = "";
                        strArr[0] = "";
                        strArr[1] = String.valueOf(bVar.getSelfGender());
                        strArr[2] = ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFrom();
                        if (TextUtils.equals(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFrom(), "2")) {
                            str = String.valueOf(videoData.f252695e);
                        }
                        strArr[3] = str;
                        h16.b(strArr).g();
                    }
                }, 16, null, false);
            }
            this.mCurrentIndex = i16;
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            return false;
        }
        this.stuffContainerView.h();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class e implements com.tencent.mobileqq.nearby.now.view.e {
        e() {
        }

        @Override // com.tencent.mobileqq.nearby.now.view.e
        public void a(String str, int i3, int i16, String str2) {
            if (i3 != 100) {
                q92.c.k(StoryPlayControllerImpl.this.mVideoPlayer.getVideoData().f252695e, ((IVideoPlayerView) StoryPlayControllerImpl.this.mVideoPlayer).isVideoCached() ? 1 : 2, String.valueOf(i3), String.valueOf(i16));
            } else {
                q92.c.g();
                q92.c.j(StoryPlayControllerImpl.this.mFeedId, ((IVideoPlayerView) StoryPlayControllerImpl.this.mVideoPlayer).isVideoCached() ? 1 : 2, StoryPlayControllerImpl.this.isUrlProvided);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.StuffContainerView.e
    public void onFlingDown() {
    }

    @Override // com.tencent.mobileqq.nearby.now.view.StuffContainerView.e
    public void onFlingLeft() {
    }

    @Override // com.tencent.mobileqq.nearby.now.view.StuffContainerView.e
    public void onFlingRight() {
    }

    @Override // com.tencent.mobileqq.nearby.now.view.StuffContainerView.e
    public void onFlingUp() {
    }

    @Override // com.tencent.mobileqq.nearby.now.view.StuffContainerView.e
    public void onSingleTap() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class c implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f252650d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IVideoInfoListener f252651e;

        c(ImageView imageView, IVideoInfoListener iVideoInfoListener) {
            this.f252650d = imageView;
            this.f252651e = iVideoInfoListener;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            this.f252650d.setImageDrawable(null);
            this.f252650d.setImageDrawable(uRLDrawable);
            IVideoInfoListener iVideoInfoListener = this.f252651e;
            if (iVideoInfoListener != null) {
                ((IVideoPlayerView.b) iVideoInfoListener).onCoverComplete(uRLDrawable.getIntrinsicWidth(), uRLDrawable.getIntrinsicHeight(), true);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class d implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IVideoInfoListener f252653d;

        d(IVideoInfoListener iVideoInfoListener) {
            this.f252653d = iVideoInfoListener;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IVideoInfoListener iVideoInfoListener = this.f252653d;
            if (iVideoInfoListener != null) {
                ((IVideoPlayerView.b) iVideoInfoListener).onCoverComplete(uRLDrawable.getIntrinsicWidth(), uRLDrawable.getIntrinsicHeight(), true);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    protected int getCurrentProgressIndex(int i3) {
        return i3;
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void onPagerItemClick(View view) {
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void doOnActivityResult(int i3, int i16, Intent intent) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }

    @Override // com.tencent.mobileqq.nearby.now.IStoryPlayController
    public void onViewConstruct(LayoutInflater layoutInflater, Object obj, Object obj2) {
    }
}
