package com.tencent.av.ui.api.impl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.aj;
import com.tencent.av.ui.api.IAVVideoFunCallBizApi;
import com.tencent.av.utils.AVUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vas.vipav.VipFunCallMediaListener;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AVVideoFunCallBizApiImpl implements IAVVideoFunCallBizApi {
    private static final String TAG = "VideoFunCallHelper";
    private WeakReference<AVActivity> mAVActivity;
    private Runnable mVipVideoRunnable = new Runnable() { // from class: com.tencent.av.ui.api.impl.AVVideoFunCallBizApiImpl.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            AVActivity aVActivity = (AVActivity) AVVideoFunCallBizApiImpl.this.mAVActivity.get();
            if (aVActivity == null || AVVideoFunCallBizApiImpl.this.videoView == null) {
                return;
            }
            if (AVVideoFunCallBizApiImpl.this.videoView.isPlaying()) {
                AVVideoFunCallBizApiImpl.this.videoView.stopPlayback();
            }
            aj ajVar = aVActivity.I0;
            if (ajVar != null) {
                ajVar.b(false);
            }
            View findViewById = aVActivity.findViewById(R.id.g6f);
            if (findViewById != null) {
                ((ViewGroup) findViewById).removeView((View) AVVideoFunCallBizApiImpl.this.videoView.getParent());
                AVVideoFunCallBizApiImpl.this.videoView = null;
            } else {
                AVVideoFunCallBizApiImpl.this.videoView.setVisibility(8);
            }
            QLog.d("vip", 1, "VipVideoRunnable stop play.");
        }
    };
    private VipFunCallMediaListener vfcListener = new VipFunCallMediaListener() { // from class: com.tencent.av.ui.api.impl.AVVideoFunCallBizApiImpl.2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.vas.vipav.VipFunCallMediaListener
        public void onError(int i3, int i16, int i17) {
            VideoAppInterface videoAppInterface;
            final AVActivity aVActivity = (AVActivity) AVVideoFunCallBizApiImpl.this.mAVActivity.get();
            if (aVActivity == null || aVActivity.isDestroyed() || (videoAppInterface = aVActivity.H0) == null) {
                return;
            }
            videoAppInterface.M().post(new Runnable() { // from class: com.tencent.av.ui.api.impl.AVVideoFunCallBizApiImpl.2.2
                @Override // java.lang.Runnable
                public void run() {
                    aVActivity.X3(false);
                    aVActivity.U3();
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.vas.vipav.VipFunCallMediaListener
        public void onMediaPrepare() {
            VideoAppInterface videoAppInterface;
            final AVActivity aVActivity = (AVActivity) AVVideoFunCallBizApiImpl.this.mAVActivity.get();
            if (aVActivity == null || (videoAppInterface = aVActivity.H0) == null) {
                return;
            }
            videoAppInterface.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.api.impl.AVVideoFunCallBizApiImpl.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (r.h0() == null || aVActivity.isDestroyed() || n.e().f().f73043k == 4) {
                        return;
                    }
                    AVActivity aVActivity2 = aVActivity;
                    if (aVActivity2.f74644b0 != 1 || aVActivity2.f74679u0) {
                        return;
                    }
                    aVActivity2.X3(false);
                    aVActivity.U3();
                    aj ajVar = aVActivity.I0;
                    if (ajVar != null) {
                        ajVar.b(true);
                        aVActivity.I0.i1(-1028L, 33554431);
                    }
                }
            }, 0L);
        }
    };
    private VipFullScreenVideoView videoView;

    @Override // com.tencent.av.ui.api.IAVVideoFunCallBizApi
    public void addVipCallVideo(final Activity activity) {
        if (activity instanceof AVActivity) {
            WeakReference<AVActivity> weakReference = new WeakReference<>((AVActivity) activity);
            this.mAVActivity = weakReference;
            final AVActivity aVActivity = weakReference.get();
            if (r.h0() == null || aVActivity == null || aVActivity.isDestroyed()) {
                return;
            }
            final View findViewById = aVActivity.findViewById(R.id.g6f);
            SessionInfo f16 = n.e().f();
            if (f16 == null || f16.f73043k == 4 || !f16.E() || aVActivity.f74679u0 || aVActivity.f74644b0 != 1 || findViewById == null || aVActivity.isDestroyed()) {
                return;
            }
            final int a16 = kw.a.a(aVActivity.H0, f16.f73091w, true, true);
            if (a16 > 0 && this.videoView == null) {
                this.videoView = com.tencent.mobileqq.vipav.a.a(activity, (ViewGroup) findViewById, false);
                QLog.d("vip", 1, "oncreate addVideoView");
            }
            final int resourceType = VipFunCallUtil.getResourceType();
            final String resourcePathByUrl = VipFunCallUtil.getResourcePathByUrl(aVActivity.H0, a16, resourceType, null);
            if (resourcePathByUrl != null) {
                if (new File(resourcePathByUrl).exists()) {
                    VideoAppInterface videoAppInterface = aVActivity.H0;
                    if (videoAppInterface != null) {
                        videoAppInterface.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.api.impl.AVVideoFunCallBizApiImpl.3
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                if (r.h0() == null || AVVideoFunCallBizApiImpl.this.mAVActivity == null || ((AVActivity) AVVideoFunCallBizApiImpl.this.mAVActivity.get()).isDestroyed() || n.e().f().f73043k == 4) {
                                    return;
                                }
                                AVActivity aVActivity2 = aVActivity;
                                if (aVActivity2.f74644b0 != 1 || aVActivity2.f74679u0 || findViewById == null) {
                                    return;
                                }
                                VideoLayerUI videoLayerUI = aVActivity2.J0;
                                if (videoLayerUI != null) {
                                    videoLayerUI.G0();
                                }
                                VideoAppInterface videoAppInterface2 = aVActivity.H0;
                                if (VipFunCallUtil.play(activity, AVVideoFunCallBizApiImpl.this.videoView, resourcePathByUrl, resourceType, AVVideoFunCallBizApiImpl.this.vfcListener, a16, false, videoAppInterface2 != null ? AVUtil.k(videoAppInterface2.getCurrentAccountUin()) : false)) {
                                    QLog.d("vip", 1, "oncreate play VipFunCall");
                                    return;
                                }
                                QLog.d("vip", 1, "oncreate play VipFunCall false: " + resourcePathByUrl);
                                QLog.e(AVVideoFunCallBizApiImpl.TAG, 1, "funcall --> play false :" + resourcePathByUrl);
                            }
                        }, 1000L);
                        return;
                    }
                    return;
                }
                QLog.e(TAG, 1, "funcall --> !file.exists() + path:" + resourcePathByUrl);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "addVipCallVideo for get not AVActivity - " + activity);
    }

    @Override // com.tencent.av.ui.api.IAVVideoFunCallBizApi
    public void onConnected() {
        VideoAppInterface videoAppInterface;
        AVActivity aVActivity = this.mAVActivity.get();
        if (aVActivity == null || (videoAppInterface = aVActivity.H0) == null) {
            return;
        }
        videoAppInterface.M().postDelayed(this.mVipVideoRunnable, 200L);
    }

    @Override // com.tencent.av.ui.api.IAVVideoFunCallBizApi
    public void onDestroy() {
        VideoAppInterface videoAppInterface;
        try {
            VipFullScreenVideoView vipFullScreenVideoView = this.videoView;
            if (vipFullScreenVideoView != null) {
                vipFullScreenVideoView.stopPlayback();
                ViewParent parent = this.videoView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeAllViews();
                }
                this.videoView = null;
                QLog.d("vip", 1, "ondestroy stopPlayback.");
            }
            AVActivity aVActivity = this.mAVActivity.get();
            if (aVActivity != null && (videoAppInterface = aVActivity.H0) != null) {
                videoAppInterface.M().removeCallbacks(this.mVipVideoRunnable);
            }
            this.mVipVideoRunnable = null;
        } catch (Throwable unused) {
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoFunCallBizApi
    public void onPlayAnimate(int i3) {
        int resourceType;
        String resourcePathByUrl;
        AVActivity aVActivity = this.mAVActivity.get();
        if (r.h0() == null || aVActivity == null || aVActivity.H0 == null || (resourcePathByUrl = VipFunCallUtil.getResourcePathByUrl(aVActivity.H0, i3, (resourceType = VipFunCallUtil.getResourceType()), null)) == null) {
            return;
        }
        File file = new File(resourcePathByUrl);
        View findViewById = aVActivity.findViewById(R.id.g6f);
        if (file.exists() && n.e().f().f73043k != 4 && aVActivity.f74644b0 == 1 && findViewById != null) {
            VideoLayerUI videoLayerUI = aVActivity.J0;
            if (videoLayerUI != null) {
                videoLayerUI.G0();
            }
            if (this.videoView == null) {
                this.videoView = com.tencent.mobileqq.vipav.a.a(aVActivity, (ViewGroup) findViewById, false);
                QLog.d("vip", 1, "onplayAnnimate addVideoView.");
            }
            Context applicationContext = aVActivity.H0.getApp().getApplicationContext();
            VipFullScreenVideoView vipFullScreenVideoView = this.videoView;
            VipFunCallMediaListener vipFunCallMediaListener = this.vfcListener;
            VideoAppInterface videoAppInterface = aVActivity.H0;
            VipFunCallUtil.play(applicationContext, vipFullScreenVideoView, resourcePathByUrl, resourceType, vipFunCallMediaListener, i3, false, videoAppInterface == null || AVUtil.k(videoAppInterface.getAccount()));
            QLog.d("vip", 1, "onplayAnnimate play VipFunCall.");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "yiler onPlayAnnimate finish id:" + i3);
        }
    }
}
