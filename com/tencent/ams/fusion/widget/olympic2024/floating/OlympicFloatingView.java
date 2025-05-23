package com.tencent.ams.fusion.widget.olympic2024.floating;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingIconView;
import com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.NetworkResLoader;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OlympicFloatingView extends FrameLayout implements IOlympicFloatingView {
    static IPatchRedirector $redirector_ = null;
    private static final long DISMISS_TIME = 15000;
    private static final int MSG_DISMISS = 0;
    private static final String TAG = "OlympicFloatingView";
    private boolean mFloatingIconDisable;

    @NonNull
    private final OlympicFloatingIconView mFloatingIconView;

    @NonNull
    private final OlympicFloatingVideoView mFloatingVideoView;
    private final Handler mHandler;
    private OlympicFloatingViewListener mListener;
    private long mTotalDuration;

    public OlympicFloatingView(@NonNull Context context) {
        this(context, 2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private OlympicFloatingIconView createAndAddFloatingIconView(Context context) {
        OlympicFloatingIconView olympicFloatingIconView = new OlympicFloatingIconView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        addView(olympicFloatingIconView, layoutParams);
        olympicFloatingIconView.setViewClickListener(new OlympicFloatingIconView.OnViewClickListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicFloatingView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingIconView.OnViewClickListener
            public void onClick(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    OlympicFloatingViewListener olympicFloatingViewListener = OlympicFloatingView.this.mListener;
                    if (olympicFloatingViewListener != null) {
                        olympicFloatingViewListener.onViewClick(i3);
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        });
        olympicFloatingIconView.setVisibility(4);
        return olympicFloatingIconView;
    }

    private OlympicFloatingVideoView createAndAddFloatingVideoView(Context context, int i3) {
        OlympicFloatingVideoView olympicFloatingVideoView = new OlympicFloatingVideoView(context, i3);
        addView(olympicFloatingVideoView, new FrameLayout.LayoutParams(-1, -1));
        olympicFloatingVideoView.setListener(new OlympicFloatingVideoView.FloatingVideoViewListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicFloatingView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.FloatingVideoViewListener
            public void onCloseViewClick() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    iPatchRedirector.redirect((short) 9, (Object) this);
                } else if (OlympicFloatingView.this.mListener != null) {
                    OlympicFloatingView.this.mListener.onViewClick(2);
                }
            }

            @Override // com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.FloatingVideoViewListener
            public void onVideoPlayComplete() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this);
                    return;
                }
                Logger.i(OlympicFloatingView.TAG, "video play complete");
                if (OlympicFloatingView.this.mListener != null) {
                    OlympicFloatingView.this.mListener.onVideoPlayComplete();
                }
                if (!OlympicFloatingView.this.mFloatingIconDisable) {
                    OlympicFloatingView.this.showFloatingIconView();
                } else {
                    Logger.i(OlympicFloatingView.TAG, "not show icon view, floating icon disable");
                    OlympicFloatingView.this.mHandler.sendEmptyMessage(0);
                }
            }

            @Override // com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.FloatingVideoViewListener
            public void onVideoPlayError(int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this, i16);
                } else if (OlympicFloatingView.this.mListener != null) {
                    OlympicFloatingView.this.mListener.onVideoPlayError(i16);
                }
            }

            @Override // com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.FloatingVideoViewListener
            public void onVideoPlayPause() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                } else if (OlympicFloatingView.this.mListener != null) {
                    OlympicFloatingView.this.mListener.onVideoPlayPause();
                }
            }

            @Override // com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.FloatingVideoViewListener
            public void onVideoPlayStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (OlympicFloatingView.this.mListener != null) {
                    OlympicFloatingView.this.mListener.onVideoPlayStart();
                    OlympicFloatingView.this.mListener.onViewExposure(1);
                }
            }

            @Override // com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.FloatingVideoViewListener
            public void onVideoPlayStop() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                } else if (OlympicFloatingView.this.mListener != null) {
                    OlympicFloatingView.this.mListener.onVideoPlayStop();
                }
            }

            @Override // com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.FloatingVideoViewListener
            public void onVideoPlayUpdate(long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, j3);
                } else if (OlympicFloatingView.this.mListener != null) {
                    OlympicFloatingView.this.mListener.onVideoPlayUpdate(j3);
                }
            }

            @Override // com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.FloatingVideoViewListener
            public void onVideoViewClick() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    iPatchRedirector.redirect((short) 8, (Object) this);
                } else if (OlympicFloatingView.this.mListener != null) {
                    OlympicFloatingView.this.mListener.onViewClick(1);
                }
            }
        });
        return olympicFloatingVideoView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFloatingIconView() {
        Utils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicFloatingView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                OlympicFloatingView.this.mFloatingIconView.setVisibility(0);
                OlympicFloatingView.this.mFloatingIconView.expand();
                OlympicFloatingView.this.mHandler.sendEmptyMessageDelayed(0, OlympicFloatingView.this.mTotalDuration);
                if (OlympicFloatingView.this.mListener != null) {
                    OlympicFloatingView.this.mListener.onViewExposure(3);
                }
            }
        });
    }

    private String tryGetCachePath(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
            String cacheFilePath = NetworkResLoader.getCacheFilePath(getContext(), str);
            if (cacheFilePath != null) {
                if (new File(cacheFilePath).exists()) {
                    Logger.i(TAG, "get cache path success for url: " + str);
                    return cacheFilePath;
                }
            } else {
                Logger.w(TAG, "not found cache for url: " + str);
            }
        }
        Logger.i(TAG, "tryGetCachePath video path: " + str);
        return str;
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void foldIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (this.mFloatingIconDisable) {
            Logger.w(TAG, "floating icon disable");
            return;
        }
        if (this.mFloatingIconView.getVisibility() == 0) {
            this.mFloatingIconView.fold();
            OlympicFloatingViewListener olympicFloatingViewListener = this.mListener;
            if (olympicFloatingViewListener != null) {
                olympicFloatingViewListener.onViewExposure(4);
                return;
            }
            return;
        }
        Logger.w(TAG, "fold floating icon must after video play complete");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
            super.onDetachedFromWindow();
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void setBottomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        Logger.i(TAG, "setBottomMargin bottomMargin: " + i3);
        this.mFloatingIconView.setBottomMargin(i3);
        this.mFloatingVideoView.setPadding(0, 0, 0, i3);
    }

    public void setEnableFloatingVideoClickArea(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.mFloatingVideoView.setEnableFloatingVideoClickArea(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void setFloatingIconDisable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        Logger.i(TAG, "setFloatingIconDisable disable: " + z16);
        this.mFloatingIconDisable = z16;
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void setFloatingVideoClickArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.i(TAG, "setFloatingVideoClickArea bottomPaddingRatio: " + i3 + ", leftPaddingRatio: " + i16 + ", rightPaddingRatio: " + i17 + ", heightRatio: " + i18);
        this.mFloatingVideoView.setFloatingVideoClickArea(i3, i16, i17, i18);
    }

    public void setFloatingVideoClickAreaDebug(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        Logger.i(TAG, "setFloatingVideoClickAreaDebug debug: " + z16);
        this.mFloatingVideoView.setFloatingVideoClickAreaDebug(z16);
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void setFloatingVideoClickDelay(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        Logger.i(TAG, "setFloatingVideoClickDelay delayTimeMs: " + i3);
        this.mFloatingVideoView.setFloatingVideoClickDelay(i3);
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void setIconPath(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        Logger.i(TAG, "setIconPath expandPath: " + str + ", foldPath:" + str2);
        this.mFloatingIconView.setIconPath(tryGetCachePath(str), tryGetCachePath(str2));
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void setListener(OlympicFloatingViewListener olympicFloatingViewListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) olympicFloatingViewListener);
        } else {
            this.mListener = olympicFloatingViewListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void setSecondViewBottomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        Logger.i(TAG, "setSecondViewBottomMargin bottomMargin: " + i3);
        this.mFloatingIconView.setExpandViewBottomMargin(i3);
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void setThirdViewBottomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        Logger.i(TAG, "setThirdViewBottomMargin bottomMargin: " + i3);
        this.mFloatingIconView.setFoldViewBottomMargin(i3);
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void setTotalDuration(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        Logger.i(TAG, "setTotalDuration duration: " + j3);
        if (j3 > 0) {
            this.mTotalDuration = j3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void setVideoDuration(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
            return;
        }
        Logger.i(TAG, "setVideoDuration duration: " + j3);
        this.mFloatingVideoView.setVideoDuration(j3);
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void setVideoPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        Logger.i(TAG, "setVideoPath path: " + str);
        this.mFloatingVideoView.setVideoPath(str);
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.floating.IOlympicFloatingView
    public void skipVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (this.mFloatingVideoView.getVisibility() == 0) {
            Utils.safeRemoveChildView(this.mFloatingVideoView);
            OlympicFloatingViewListener olympicFloatingViewListener = this.mListener;
            if (olympicFloatingViewListener != null) {
                olympicFloatingViewListener.onVideoPlayStop();
            }
            if (!this.mFloatingIconDisable) {
                showFloatingIconView();
            }
        }
    }

    public OlympicFloatingView(Context context, int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            return;
        }
        this.mTotalDuration = 15000L;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingView.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OlympicFloatingView.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    OlympicFloatingViewListener olympicFloatingViewListener = OlympicFloatingView.this.mListener;
                    if (message.what == 0 && olympicFloatingViewListener != null) {
                        olympicFloatingViewListener.onDismiss();
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
            }
        };
        this.mFloatingVideoView = createAndAddFloatingVideoView(context, i3);
        this.mFloatingIconView = createAndAddFloatingIconView(context);
    }
}
