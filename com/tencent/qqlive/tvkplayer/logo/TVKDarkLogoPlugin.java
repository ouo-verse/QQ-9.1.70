package com.tencent.qqlive.tvkplayer.logo;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKDarkLogoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.event.ITVKEventObserver;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqlive.tvkplayer.event.TVKEventParams;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKDarkLogo;
import com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
public class TVKDarkLogoPlugin implements ITVKEventObserver, ITVKPlugin {
    private TVKDarkLogo mDarkLogo;
    private final TVKContext mTVKContext;
    private ViewGroup mVideoView;
    private final Map<Integer, IMessageExecutor> mMessageExecutorMap = new HashMap();
    private final View.OnLayoutChangeListener mVideoViewOnLayoutChangeListener = new VideoViewOnLayoutChangeListener();
    private boolean mIsPlaying = false;

    @NonNull
    private final Handler mMessageHandler = new Handler(TVKThreadPool.getInstance().obtainSharedHandlerThread().getLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public interface IMessageExecutor {
        void execute(Message message);
    }

    /* loaded from: classes23.dex */
    private class VideoViewOnLayoutChangeListener implements View.OnLayoutChangeListener {
        VideoViewOnLayoutChangeListener() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            Handler handler = TVKDarkLogoPlugin.this.mMessageHandler;
            final TVKDarkLogoPlugin tVKDarkLogoPlugin = TVKDarkLogoPlugin.this;
            handler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.i
                @Override // java.lang.Runnable
                public final void run() {
                    TVKDarkLogoPlugin.access$200(TVKDarkLogoPlugin.this);
                }
            });
        }
    }

    public TVKDarkLogoPlugin(@NonNull TVKContext tVKContext, ViewGroup viewGroup) {
        this.mTVKContext = tVKContext;
        this.mVideoView = viewGroup;
        addOnLayoutChangeListenerToVideoViewGroup();
        initMessageExecutorMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void access$200(TVKDarkLogoPlugin tVKDarkLogoPlugin) {
        tVKDarkLogoPlugin.onViewSizeChanged();
    }

    private void addOnLayoutChangeListenerToVideoViewGroup() {
        ViewGroup viewGroup = this.mVideoView;
        if (viewGroup != null) {
            viewGroup.addOnLayoutChangeListener(this.mVideoViewOnLayoutChangeListener);
        }
    }

    private void initMessageExecutorMap() {
        this.mMessageExecutorMap.put(10201, new IMessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.b
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKDarkLogoPlugin.IMessageExecutor
            public final void execute(Message message) {
                TVKDarkLogoPlugin.this.lambda$initMessageExecutorMap$0(message);
            }
        });
        this.mMessageExecutorMap.put(Integer.valueOf(TVKEventId.PLAYER_STATE_START_PLAY), new IMessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.c
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKDarkLogoPlugin.IMessageExecutor
            public final void execute(Message message) {
                TVKDarkLogoPlugin.this.lambda$initMessageExecutorMap$1(message);
            }
        });
        this.mMessageExecutorMap.put(Integer.valueOf(TVKEventId.PLAYER_STATE_UPDATE_VIEW), new IMessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.d
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKDarkLogoPlugin.IMessageExecutor
            public final void execute(Message message) {
                TVKDarkLogoPlugin.this.lambda$initMessageExecutorMap$2(message);
            }
        });
        this.mMessageExecutorMap.put(Integer.valueOf(TVKEventId.PLAYER_STATE_STOP), new IMessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.e
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKDarkLogoPlugin.IMessageExecutor
            public final void execute(Message message) {
                TVKDarkLogoPlugin.this.lambda$initMessageExecutorMap$3(message);
            }
        });
        this.mMessageExecutorMap.put(Integer.valueOf(TVKEventId.PLAYER_STATE_PLAY_COMPLETE), new IMessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.f
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKDarkLogoPlugin.IMessageExecutor
            public final void execute(Message message) {
                TVKDarkLogoPlugin.this.lambda$initMessageExecutorMap$4(message);
            }
        });
        this.mMessageExecutorMap.put(Integer.valueOf(TVKEventId.PLAYER_STATE_PLAYER_ERROR), new IMessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.g
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKDarkLogoPlugin.IMessageExecutor
            public final void execute(Message message) {
                TVKDarkLogoPlugin.this.lambda$initMessageExecutorMap$5(message);
            }
        });
        this.mMessageExecutorMap.put(11000, new IMessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.h
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKDarkLogoPlugin.IMessageExecutor
            public final void execute(Message message) {
                TVKDarkLogoPlugin.this.lambda$initMessageExecutorMap$6(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMessageExecutorMap$0(Message message) {
        updateDarkLogoInfo(((TVKEventParams.GetVInfoResponseParam) message.obj).videoInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMessageExecutorMap$1(Message message) {
        TVKDarkLogo tVKDarkLogo;
        this.mIsPlaying = true;
        Object obj = message.obj;
        if ((!(obj instanceof TVKEventParams.StartPlayParam) || ((TVKEventParams.StartPlayParam) obj).isFirstStart) && (tVKDarkLogo = this.mDarkLogo) != null) {
            tVKDarkLogo.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMessageExecutorMap$2(Message message) {
        Object obj = message.obj;
        if (obj instanceof TVKEventParams.UpdateVideoViewEventParam) {
            updateVideoView(((TVKEventParams.UpdateVideoViewEventParam) obj).viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMessageExecutorMap$3(Message message) {
        this.mIsPlaying = false;
        stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMessageExecutorMap$4(Message message) {
        this.mIsPlaying = false;
        stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMessageExecutorMap$5(Message message) {
        this.mIsPlaying = false;
        stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMessageExecutorMap$6(Message message) {
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEvent$7(int i3, int i16, int i17, Object obj) {
        IMessageExecutor iMessageExecutor = this.mMessageExecutorMap.get(Integer.valueOf(i3));
        if (iMessageExecutor == null) {
            return;
        }
        Message message = new Message();
        message.what = i3;
        message.arg1 = i16;
        message.arg2 = i17;
        message.obj = obj;
        iMessageExecutor.execute(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onViewSizeChanged() {
        TVKDarkLogo tVKDarkLogo = this.mDarkLogo;
        if (tVKDarkLogo != null) {
            tVKDarkLogo.onViewSizeChanged();
        }
    }

    private void release() {
        stop();
        removeOnLayoutChangeListenerFromVideoViewGroup();
        this.mVideoView = null;
        this.mMessageHandler.removeCallbacksAndMessages(null);
    }

    private void removeOnLayoutChangeListenerFromVideoViewGroup() {
        ViewGroup viewGroup = this.mVideoView;
        if (viewGroup != null) {
            viewGroup.removeOnLayoutChangeListener(this.mVideoViewOnLayoutChangeListener);
        }
    }

    private void stop() {
        TVKDarkLogo tVKDarkLogo = this.mDarkLogo;
        if (tVKDarkLogo != null) {
            tVKDarkLogo.stop();
            this.mDarkLogo = null;
        }
    }

    private void updateDarkLogoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
        TVKDarkLogoInfo darkLogoInfo;
        stop();
        if (!(tVKNetVideoInfo instanceof TVKVodVideoInfo) || (darkLogoInfo = ((TVKVodVideoInfo) tVKNetVideoInfo).getDarkLogoInfo()) == null) {
            return;
        }
        TVKDarkLogo tVKDarkLogo = new TVKDarkLogo(this.mTVKContext, this.mVideoView);
        this.mDarkLogo = tVKDarkLogo;
        tVKDarkLogo.updateDarkLogoInfo(darkLogoInfo);
        if (this.mIsPlaying) {
            this.mDarkLogo.start();
        }
    }

    private void updateVideoView(@Nullable ViewGroup viewGroup) {
        removeOnLayoutChangeListenerFromVideoViewGroup();
        this.mVideoView = viewGroup;
        if (!(viewGroup instanceof ITVKVideoViewPrivate)) {
            return;
        }
        addOnLayoutChangeListenerToVideoViewGroup();
        TVKDarkLogo tVKDarkLogo = this.mDarkLogo;
        if (tVKDarkLogo != null) {
            tVKDarkLogo.updateVideoView(viewGroup);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.event.ITVKEventObserver
    public void onEvent(final int i3, final int i16, final int i17, String str, final Object obj) {
        this.mMessageHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.a
            @Override // java.lang.Runnable
            public final void run() {
                TVKDarkLogoPlugin.this.lambda$onEvent$7(i3, i16, i17, obj);
            }
        });
    }

    @Override // com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin
    public void onLoad() {
        this.mTVKContext.getEventSender().registerObserver(this);
    }

    @Override // com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin
    public void onUnload() {
        this.mTVKContext.getEventSender().unregisterObserver(this);
    }
}
