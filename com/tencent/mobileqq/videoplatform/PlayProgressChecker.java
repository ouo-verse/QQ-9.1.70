package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes20.dex */
public class PlayProgressChecker implements Runnable {
    static IPatchRedirector $redirector_ = null;
    static final int PROGRESS_REFRESH_TIME = 200;
    private VideoPlayerCallback mCallback;
    private long mId;
    public ISuperPlayer mPlayer;
    private AtomicBoolean mStoped;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayProgressChecker(long j3, ISuperPlayer iSuperPlayer, VideoPlayerCallback videoPlayerCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), iSuperPlayer, videoPlayerCallback);
            return;
        }
        this.mStoped = new AtomicBoolean(false);
        this.mPlayer = iSuperPlayer;
        this.mCallback = videoPlayerCallback;
        this.mId = j3;
    }

    protected String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "[VideoPlatForm]PlayProgressChecker[" + this.mId + "]";
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.mStoped.get()) {
            return;
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
            long currentPositionMs = this.mPlayer.getCurrentPositionMs();
            if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "ProgressChecker, playPos = " + currentPositionMs);
            }
            if (currentPositionMs > 0 && this.mCallback != null) {
                ThreadUtil.postOnUIThread(new Runnable(currentPositionMs) { // from class: com.tencent.mobileqq.videoplatform.PlayProgressChecker.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ long val$playPos;

                    {
                        this.val$playPos = currentPositionMs;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, PlayProgressChecker.this, Long.valueOf(currentPositionMs));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            PlayProgressChecker.this.mCallback.onPlayProgress(PlayProgressChecker.this.mId, this.val$playPos);
                        }
                    }
                });
            }
        }
        ThreadUtil.postOnSubThreadDelayed(this, 200L);
    }

    public void setId(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.mId = j3;
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "start");
        }
        this.mStoped.set(false);
        ThreadUtil.removeCallbacksInSubHandler(this);
        ThreadUtil.postOnSubThreadDelayed(this, 200L);
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "stop");
        }
        this.mStoped.set(true);
        ThreadUtil.removeCallbacksInSubHandler(this);
    }
}
