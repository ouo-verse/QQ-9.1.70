package com.tencent.gdtad.basics.motivevideo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class CmGameGdtVideoPlayer implements ICmGameVideoPlayer, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener {
    private static final long ONE_SECOND = 1000;
    public static final String TAG = "CmGameGdtVideoPlayer";
    private long mLeftMilSec;
    private ISuperPlayer mPlayer;
    private ISPlayerVideoView mPlayerVideoView;
    private int mStatus;
    private boolean mSurfaceViewDestroyed;
    private CopyOnWriteArrayList<l> mIVideoCallback = new CopyOnWriteArrayList<>();
    private Handler mCountHandler = new Handler(Looper.getMainLooper());
    private long mCallbackFreq = 1000;
    private Runnable mCountRun = new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.CmGameGdtVideoPlayer.1
        @Override // java.lang.Runnable
        public void run() {
            if (CmGameGdtVideoPlayer.this.mLeftMilSec < 0) {
                return;
            }
            Iterator it = CmGameGdtVideoPlayer.this.mIVideoCallback.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar != null) {
                    lVar.b(CmGameGdtVideoPlayer.this.mLeftMilSec, CmGameGdtVideoPlayer.this.getVideoDuration());
                }
            }
            CmGameGdtVideoPlayer cmGameGdtVideoPlayer = CmGameGdtVideoPlayer.this;
            cmGameGdtVideoPlayer.mLeftMilSec = cmGameGdtVideoPlayer.getVideoDuration() - CmGameGdtVideoPlayer.this.getCurrentPosition();
            if (CmGameGdtVideoPlayer.this.mCountHandler != null) {
                CmGameGdtVideoPlayer.this.mCountHandler.postDelayed(this, CmGameGdtVideoPlayer.this.mCallbackFreq);
            }
        }
    };

    /* loaded from: classes6.dex */
    class a implements ISPlayerVideoView.IVideoViewCallBack {
        a() {
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceChanged(Object obj) {
            QLog.i(CmGameGdtVideoPlayer.TAG, 1, "[onSurfaceChanged]");
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceCreated(Object obj) {
            QLog.i(CmGameGdtVideoPlayer.TAG, 1, "[onSurfaceCreated]");
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceDestroy(Object obj) {
            QLog.i(CmGameGdtVideoPlayer.TAG, 1, "[onSurfaceDestroy]");
            CmGameGdtVideoPlayer.this.mSurfaceViewDestroyed = true;
        }
    }

    private void startCount() {
        Handler handler;
        if (this.mPlayer != null && (handler = this.mCountHandler) != null) {
            handler.removeCallbacks(this.mCountRun);
            long durationMs = this.mPlayer.getDurationMs() - this.mPlayer.getCurrentPositionMs();
            this.mLeftMilSec = durationMs;
            if (durationMs > 0) {
                this.mCountHandler.post(this.mCountRun);
            }
        }
    }

    private void stopCount() {
        Handler handler = this.mCountHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mCountRun);
        }
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public void addPlayerCallback(l lVar) {
        addPlayerCallback(lVar, 1000L);
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public long getCurrentPosition() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getCurrentPositionMs();
        }
        return 0L;
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public boolean getMuteValue() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isOutputMute();
        }
        return false;
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public int getStatus() {
        return this.mStatus;
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public View getVideoContainer() {
        if (this.mPlayerVideoView == null || this.mPlayer == null) {
            try {
                QLog.i(TAG, 1, "[createPlayerVideoView]");
                this.mPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext());
                ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 110, this.mPlayerVideoView);
                this.mPlayer = createMediaPlayer;
                createMediaPlayer.setOnCompletionListener(this);
                this.mPlayer.setOnVideoPreparedListener(this);
                this.mPlayer.setOnErrorListener(this);
                this.mPlayer.setOnInfoListener(this);
                this.mStatus = 1;
                this.mPlayerVideoView.addViewCallBack(new a());
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getVideoContainer", e16);
                this.mPlayerVideoView = null;
                this.mPlayer = null;
            }
        }
        return (View) this.mPlayerVideoView;
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public long getVideoDuration() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getDurationMs();
        }
        return 0L;
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public int getVideoHeight() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public int getVideoWidth() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public boolean isPaused() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPausing();
        }
        return false;
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public boolean isPlaying() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public boolean isSurfaceDestroyed() {
        return this.mSurfaceViewDestroyed;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        QLog.i(TAG, 1, "[onCompletion]");
        this.mLeftMilSec = -1L;
        this.mStatus = 5;
        Iterator<l> it = this.mIVideoCallback.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next != null) {
                next.d();
            }
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        QLog.i(TAG, 1, "[onError]extra model = " + i3 + ", errorType = " + i16 + ", errorCode = " + i17 + ", detailInfo = " + str);
        Iterator<l> it = this.mIVideoCallback.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next != null) {
                next.a(i3, i16, i16, str);
            }
        }
        stopCount();
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        QLog.i(TAG, 1, "what:" + i3);
        if (i3 == 105) {
            GdtLog.i(TAG, "[onInfo] first frame rendered");
            CopyOnWriteArrayList<l> copyOnWriteArrayList = this.mIVideoCallback;
            if (copyOnWriteArrayList == null) {
                GdtLog.e(TAG, "[onInfo] mIVideoCallback is null");
                return false;
            }
            Iterator<l> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (next != null) {
                    next.c();
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        QLog.i(TAG, 1, "[onVideoPrepared]");
        this.mStatus = 2;
        this.mSurfaceViewDestroyed = false;
        Iterator<l> it = this.mIVideoCallback.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next != null) {
                next.onVideoPrepared();
            }
        }
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public boolean pause() {
        if (this.mPlayer != null) {
            QLog.i(TAG, 1, "[pause]");
            this.mPlayer.pause();
            stopCount();
            this.mStatus = 4;
            return true;
        }
        return false;
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public void release() {
        QLog.i(TAG, 1, "[release]");
        stopCount();
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
            this.mPlayer.release();
            this.mPlayer = null;
            this.mStatus = 6;
        }
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public void removePlayerCallback(l lVar) {
        CopyOnWriteArrayList<l> copyOnWriteArrayList = this.mIVideoCallback;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.contains(lVar)) {
            this.mIVideoCallback.remove(lVar);
        }
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public void resume() {
        if (this.mPlayer != null) {
            QLog.i(TAG, 1, "[resume]");
            this.mPlayer.start();
            this.mStatus = 3;
            startCount();
        }
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public void seekTo(int i3) {
        if (this.mPlayer != null) {
            QLog.i(TAG, 1, "[seekTo]" + i3);
            this.mPlayer.seekTo(i3);
        }
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public void setMute(boolean z16) {
        if (this.mPlayer != null) {
            QLog.i(TAG, 1, "setMute " + z16);
            this.mPlayer.setOutputMute(z16);
        }
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public void startPlay(String str, String str2, int i3) {
        if (this.mPlayer != null) {
            QLog.i(TAG, 1, "[startPlay] url = " + str);
            this.mPlayer.openMediaPlayer(BaseApplication.getContext(), SuperPlayerFactory.createVideoInfoForUrl(str, 104, (String) null), (long) i3);
        }
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public void stopPlay() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
        }
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public void addPlayerCallback(l lVar, long j3) {
        CopyOnWriteArrayList<l> copyOnWriteArrayList = this.mIVideoCallback;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(lVar)) {
            this.mIVideoCallback.add(lVar);
        }
        this.mCallbackFreq = j3;
    }

    @Override // com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer
    public void initVideoPlayer(Context context, AppInterface appInterface) {
    }
}
