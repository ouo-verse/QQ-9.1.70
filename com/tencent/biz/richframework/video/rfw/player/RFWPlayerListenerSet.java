package com.tencent.biz.richframework.video.rfw.player;

import com.tencent.biz.richframework.video.rfw.player.listener.IRFWOnTvkPermissionTimeOutListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerDownGradeListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerDownloadListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerOnInfoListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPassivePauseListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerRateChangListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSprListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWSeekCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWTVKOnNetVideoInfoListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWVideoSizeChangedListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class RFWPlayerListenerSet {
    private List<IRFWPlayerCompletionListener> mCompletionListener;
    private List<IRFWPlayerDownGradeListener> mDownGradeListener;
    private List<IRFWPlayerDownloadListener> mDownloadListeners;
    private List<IRFWPlayErrorStatusListener> mErrorStatusListener;
    private List<IRFWPlayerOnInfoListener> mInfoListener;
    private List<IRFWPlayerLifeCycle> mLifeCycleListeners;
    private List<IRFWPlayerLooperListener> mLooperListeners;
    private List<IRFWPlayerPassivePauseListener> mPlayerPassivePauseListeners;
    private List<IRFWPlayerRateChangListener> mPlayerRateChangeListener;
    private List<IRFWPlayerPrepareListener> mPrePrepareListeners;
    private List<IRFWPlayerSdkInitListener> mSDKInitListeners;
    private List<IRFWPlayerSecondBufferListener> mSecondBufferListeners;
    private List<IRFWSeekCompletionListener> mSeekCompletionListener;
    private List<IRFWPlayerSeekListener> mSeekListeners;
    private List<IRFWPlayerSprListener> mSprListener;
    private List<IRFWTVKOnNetVideoInfoListener> mTVKNetVideoInfoListener;
    private List<IRFWOnTvkPermissionTimeOutListener> mTvkPermissionTimeListener;
    private List<IRFWVideoSizeChangedListener> mVideoSizeChangedListener;

    public synchronized RFWPlayerListenerSet addCompletionListener(IRFWPlayerCompletionListener iRFWPlayerCompletionListener) {
        if (iRFWPlayerCompletionListener == null) {
            return this;
        }
        if (this.mCompletionListener == null) {
            this.mCompletionListener = new ArrayList();
        }
        this.mCompletionListener.add(iRFWPlayerCompletionListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addDownGradeVideoListener(IRFWPlayerDownGradeListener iRFWPlayerDownGradeListener) {
        if (iRFWPlayerDownGradeListener == null) {
            return this;
        }
        if (this.mDownGradeListener == null) {
            this.mDownGradeListener = new ArrayList();
        }
        this.mDownGradeListener.add(iRFWPlayerDownGradeListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addErrorStatusListener(IRFWPlayErrorStatusListener iRFWPlayErrorStatusListener) {
        if (iRFWPlayErrorStatusListener == null) {
            return this;
        }
        if (this.mErrorStatusListener == null) {
            this.mErrorStatusListener = new ArrayList();
        }
        this.mErrorStatusListener.add(iRFWPlayErrorStatusListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addInfoListener(IRFWPlayerOnInfoListener iRFWPlayerOnInfoListener) {
        if (iRFWPlayerOnInfoListener == null) {
            return this;
        }
        if (this.mInfoListener == null) {
            this.mInfoListener = new ArrayList();
        }
        this.mInfoListener.add(iRFWPlayerOnInfoListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addLifeCycleListeners(IRFWPlayerLifeCycle iRFWPlayerLifeCycle) {
        if (iRFWPlayerLifeCycle == null) {
            return this;
        }
        if (this.mLifeCycleListeners == null) {
            this.mLifeCycleListeners = new ArrayList();
        }
        this.mLifeCycleListeners.add(iRFWPlayerLifeCycle);
        return this;
    }

    public synchronized RFWPlayerListenerSet addLooperListeners(IRFWPlayerLooperListener iRFWPlayerLooperListener) {
        if (iRFWPlayerLooperListener == null) {
            return this;
        }
        if (this.mLooperListeners == null) {
            this.mLooperListeners = new ArrayList();
        }
        this.mLooperListeners.add(iRFWPlayerLooperListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addPlayerPassivePauseListeners(IRFWPlayerPassivePauseListener iRFWPlayerPassivePauseListener) {
        if (iRFWPlayerPassivePauseListener == null) {
            return this;
        }
        if (this.mPlayerPassivePauseListeners == null) {
            this.mPlayerPassivePauseListeners = new ArrayList();
        }
        this.mPlayerPassivePauseListeners.add(iRFWPlayerPassivePauseListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addPrepareListeners(IRFWPlayerPrepareListener iRFWPlayerPrepareListener) {
        if (iRFWPlayerPrepareListener == null) {
            return this;
        }
        if (this.mPrePrepareListeners == null) {
            this.mPrePrepareListeners = new ArrayList();
        }
        this.mPrePrepareListeners.add(iRFWPlayerPrepareListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addRateChangeListener(IRFWPlayerRateChangListener iRFWPlayerRateChangListener) {
        if (iRFWPlayerRateChangListener == null) {
            return this;
        }
        if (this.mPlayerRateChangeListener == null) {
            this.mPlayerRateChangeListener = new ArrayList();
        }
        this.mPlayerRateChangeListener.add(iRFWPlayerRateChangListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addSDKInitListeners(IRFWPlayerSdkInitListener iRFWPlayerSdkInitListener) {
        if (iRFWPlayerSdkInitListener == null) {
            return this;
        }
        if (this.mSDKInitListeners == null) {
            this.mSDKInitListeners = new ArrayList();
        }
        this.mSDKInitListeners.add(iRFWPlayerSdkInitListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addSecondBufferListeners(IRFWPlayerSecondBufferListener iRFWPlayerSecondBufferListener) {
        if (iRFWPlayerSecondBufferListener == null) {
            return this;
        }
        if (this.mSecondBufferListeners == null) {
            this.mSecondBufferListeners = new ArrayList();
        }
        this.mSecondBufferListeners.add(iRFWPlayerSecondBufferListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addSeekCompletionListeners(IRFWSeekCompletionListener iRFWSeekCompletionListener) {
        if (iRFWSeekCompletionListener == null) {
            return this;
        }
        if (this.mSeekCompletionListener == null) {
            this.mSeekCompletionListener = new ArrayList();
        }
        this.mSeekCompletionListener.add(iRFWSeekCompletionListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addSeekListeners(IRFWPlayerSeekListener iRFWPlayerSeekListener) {
        if (iRFWPlayerSeekListener == null) {
            return this;
        }
        if (this.mSeekListeners == null) {
            this.mSeekListeners = new ArrayList();
        }
        this.mSeekListeners.add(iRFWPlayerSeekListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addSprListener(IRFWPlayerSprListener iRFWPlayerSprListener) {
        if (iRFWPlayerSprListener == null) {
            return this;
        }
        if (this.mSprListener == null) {
            this.mSprListener = new ArrayList();
        }
        this.mSprListener.add(iRFWPlayerSprListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addTVKNetVideoInfoListener(IRFWTVKOnNetVideoInfoListener iRFWTVKOnNetVideoInfoListener) {
        if (iRFWTVKOnNetVideoInfoListener == null) {
            return this;
        }
        if (this.mTVKNetVideoInfoListener == null) {
            this.mTVKNetVideoInfoListener = new ArrayList();
        }
        this.mTVKNetVideoInfoListener.add(iRFWTVKOnNetVideoInfoListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addTvkPermissionTimeOutListener(IRFWOnTvkPermissionTimeOutListener iRFWOnTvkPermissionTimeOutListener) {
        if (iRFWOnTvkPermissionTimeOutListener == null) {
            return this;
        }
        if (this.mTvkPermissionTimeListener == null) {
            this.mTvkPermissionTimeListener = new ArrayList();
        }
        this.mTvkPermissionTimeListener.add(iRFWOnTvkPermissionTimeOutListener);
        return this;
    }

    public synchronized RFWPlayerListenerSet addVideoSizeChangedListener(IRFWVideoSizeChangedListener iRFWVideoSizeChangedListener) {
        if (iRFWVideoSizeChangedListener == null) {
            return this;
        }
        if (this.mVideoSizeChangedListener == null) {
            this.mVideoSizeChangedListener = new ArrayList();
        }
        this.mVideoSizeChangedListener.add(iRFWVideoSizeChangedListener);
        return this;
    }

    public List<IRFWPlayerCompletionListener> getCompletionListener() {
        return this.mCompletionListener;
    }

    public List<IRFWPlayerDownGradeListener> getDownGradeVideoListener() {
        return this.mDownGradeListener;
    }

    public List<IRFWPlayerDownloadListener> getDownloadListener() {
        return this.mDownloadListeners;
    }

    public List<IRFWPlayErrorStatusListener> getErrorStatusListener() {
        return this.mErrorStatusListener;
    }

    public List<IRFWPlayerOnInfoListener> getInfoListener() {
        return this.mInfoListener;
    }

    public List<IRFWPlayerLifeCycle> getLifeCycleListeners() {
        return this.mLifeCycleListeners;
    }

    public List<IRFWPlayerLooperListener> getLooperListeners() {
        return this.mLooperListeners;
    }

    public List<IRFWPlayerPassivePauseListener> getPlayerPassivePauseListeners() {
        return this.mPlayerPassivePauseListeners;
    }

    public List<IRFWPlayerRateChangListener> getPlayerRateChangeListener() {
        return this.mPlayerRateChangeListener;
    }

    public List<IRFWPlayerPrepareListener> getPrePrepareListeners() {
        return this.mPrePrepareListeners;
    }

    public List<IRFWPlayerSdkInitListener> getSDKInitListeners() {
        return this.mSDKInitListeners;
    }

    public List<IRFWPlayerSecondBufferListener> getSecondBufferListeners() {
        return this.mSecondBufferListeners;
    }

    public List<IRFWSeekCompletionListener> getSeekCompletionListeners() {
        return this.mSeekCompletionListener;
    }

    public List<IRFWPlayerSeekListener> getSeekListeners() {
        return this.mSeekListeners;
    }

    public List<IRFWPlayerSprListener> getSprListener() {
        return this.mSprListener;
    }

    public List<IRFWTVKOnNetVideoInfoListener> getTVKNetVideoInfoListener() {
        return this.mTVKNetVideoInfoListener;
    }

    public List<IRFWOnTvkPermissionTimeOutListener> getTvkPermissionTimeOutListener() {
        return this.mTvkPermissionTimeListener;
    }

    public List<IRFWVideoSizeChangedListener> getVideoSizeChangedListener() {
        return this.mVideoSizeChangedListener;
    }
}
