package com.tencent.qqlive.tvkplayer.logo;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.event.ITVKEventObserver;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqlive.tvkplayer.event.TVKEventParams;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKLogoCommonDefine;
import com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr;
import com.tencent.qqlive.tvkplayer.logo.manager.TVKLogoMgrFactory;
import com.tencent.qqlive.tvkplayer.logo.utils.TVKLogoInfoParser;
import com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
public class TVKLogoPlugin implements ITVKEventObserver, ITVKPlugin {
    private static final int LOGO_DRAW = 1003;
    private static final int LOGO_DRAW_MAX_RETRY_TIMES = 5;
    private static final int LOGO_REALTIME_INFO_CHANGE = 1008;
    private static final int LOGO_RELEASE = 1011;
    private static final int LOGO_RESET = 1004;
    private static final int LOGO_RESET_REALTIME = 1009;
    private static final int LOGO_SET_XY_AXIS = 1005;
    private static final int LOGO_START = 1002;
    private static final int LOGO_UPDATE_INFO = 1001;
    private static final int LOGO_UPDATE_POSITION = 1010;
    private static final int LOGO_UPDATE_VIEW = 1007;
    private static final int LOGO_VIDEO_SIZE_CHANGE = 1006;
    private static final String TAG = "TVKLogoPlugin";
    private static final Map<Integer, Integer> sEventMap;
    private final TVKLogoEventHandler mEventHandler;
    private final HandlerThread mHandlerThread;
    private final ITVKLogger mLogger;
    private ITVKLogoMgr mLogoMgr;
    private TVKLogoCommonDefine.TVKOriginalLogoInfo mOriginalLogoInfo;
    private final TVKContext mTVKContext;
    private final Map<Integer, MessageExecutor> mMessageHandler = new HashMap();
    private int mRetryTime = 0;
    private int mVideoW = 0;
    private int mVideoH = 0;
    private ViewGroup mLogoViewGroup = null;
    private final LogoViewGroupOnLayoutChangeListener mLogoViewGroupOnLayoutChangeListener = new LogoViewGroupOnLayoutChangeListener();
    private boolean mIsDynamicLogoOpen = true;
    private boolean mIsStaticLogoOpen = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class LogoViewGroupOnLayoutChangeListener implements View.OnLayoutChangeListener {
        LogoViewGroupOnLayoutChangeListener() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            TVKLogoPlugin.this.drawLogoAsync();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public interface MessageExecutor {
        void execute(Message message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class TVKLogoEventHandler extends Handler {
        TVKLogoEventHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MessageExecutor messageExecutor = (MessageExecutor) TVKLogoPlugin.this.mMessageHandler.get(Integer.valueOf(message.what));
            if (messageExecutor != null) {
                messageExecutor.execute(message);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        sEventMap = hashMap;
        hashMap.put(10201, 1001);
        hashMap.put(Integer.valueOf(TVKEventId.PLAYER_STATE_START_PLAY), 1002);
        hashMap.put(12001, 1004);
        hashMap.put(13001, 1005);
        hashMap.put(11000, 1011);
        hashMap.put(Integer.valueOf(TVKEventId.PLAYER_STATE_UPDATE_VIEW), 1007);
        hashMap.put(Integer.valueOf(TVKEventId.PLAYER_STATE_REAL_TIME_INFO_CHANGE), 1008);
        hashMap.put(Integer.valueOf(TVKEventId.PLAYER_STATE_VIDEO_SIZE_CHANGE), 1006);
        hashMap.put(Integer.valueOf(TVKEventId.PLAYER_STATE_SWITCHDEF_DONE), 1009);
        hashMap.put(16000, 1010);
    }

    public TVKLogoPlugin(@NonNull TVKContext tVKContext, ViewGroup viewGroup) {
        this.mTVKContext = tVKContext;
        this.mLogger = new TVKLogger(tVKContext, TAG);
        HandlerThread obtainSharedHandlerThread = TVKThreadPool.getInstance().obtainSharedHandlerThread();
        this.mHandlerThread = obtainSharedHandlerThread;
        this.mEventHandler = new TVKLogoEventHandler(obtainSharedHandlerThread.getLooper());
        this.mLogoMgr = TVKLogoMgrFactory.createLogoMgr(tVKContext, viewGroup);
        updateLogoViewGroup(viewGroup);
        addOnLayoutChangeListenerToLogoViewGroup();
        msgFunctionInit();
    }

    private void addOnLayoutChangeListenerToLogoViewGroup() {
        ViewGroup viewGroup = this.mLogoViewGroup;
        if (viewGroup != null) {
            viewGroup.addOnLayoutChangeListener(this.mLogoViewGroupOnLayoutChangeListener);
        }
    }

    private void changeLogoMgrByVideoView(ViewGroup viewGroup) {
        this.mLogoMgr.reset();
        ITVKLogoMgr createLogoMgr = TVKLogoMgrFactory.createLogoMgr(this.mTVKContext, viewGroup);
        this.mLogoMgr = createLogoMgr;
        createLogoMgr.setVideoSize(this.mVideoW, this.mVideoH);
        this.mLogoMgr.setStaticLogoOpen(this.mIsStaticLogoOpen);
        this.mLogoMgr.setDynamicLogoOpen(this.mIsDynamicLogoOpen);
        TVKLogoCommonDefine.TVKOriginalLogoInfo tVKOriginalLogoInfo = this.mOriginalLogoInfo;
        if (tVKOriginalLogoInfo != null) {
            this.mLogoMgr.updateLogoInfo(tVKOriginalLogoInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        if (this.mLogoMgr.draw()) {
            this.mRetryTime = 0;
            return;
        }
        int i3 = this.mRetryTime;
        if (i3 < 5) {
            this.mRetryTime = i3 + 1;
            this.mLogger.info("logo draw retryTime:" + this.mRetryTime, new Object[0]);
            drawLogoAsync();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawLogoAsync() {
        this.mEventHandler.removeMessages(1003);
        this.mEventHandler.sendEmptyMessage(1003);
    }

    private void msgFunctionInit() {
        this.mMessageHandler.put(1001, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.1
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.MessageExecutor
            public void execute(Message message) {
                TVKLogoPlugin.this.mLogger.info("LOGO_UPDATE_INFO", new Object[0]);
                TVKLogoPlugin.this.updateLogoInfo((TVKEventParams.GetVInfoResponseParam) message.obj);
            }
        });
        this.mMessageHandler.put(1002, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.2
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.MessageExecutor
            public void execute(Message message) {
                TVKLogoPlugin.this.mLogger.info("LOGO_START", new Object[0]);
                TVKLogoPlugin.this.start(message.obj);
            }
        });
        this.mMessageHandler.put(1004, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.3
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.MessageExecutor
            public void execute(Message message) {
                TVKLogoPlugin.this.mLogger.info("LOGO_RESET", new Object[0]);
                TVKLogoPlugin.this.reset();
            }
        });
        this.mMessageHandler.put(1005, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.4
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.MessageExecutor
            public void execute(Message message) {
                TVKLogoPlugin.this.mLogger.info("LOGO_SET_XY_AXIS", new Object[0]);
                TVKLogoPlugin.this.setXYAxis(((Integer) message.obj).intValue());
            }
        });
        this.mMessageHandler.put(1007, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.5
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.MessageExecutor
            public void execute(Message message) {
                TVKLogoPlugin.this.mLogger.info("LOGO_UPDATE_VIEW", new Object[0]);
                TVKLogoPlugin.this.updateView(message.obj);
            }
        });
        this.mMessageHandler.put(1008, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.6
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.MessageExecutor
            public void execute(Message message) {
                TVKLogoPlugin.this.mLogger.info("LOGO_REALTIME_INFO_CHANGE", new Object[0]);
                TVKLogoPlugin.this.onRealTimeInfoChange(message.arg1, message.obj);
            }
        });
        this.mMessageHandler.put(1006, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.7
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.MessageExecutor
            public void execute(Message message) {
                TVKLogoPlugin.this.mLogger.info("LOGO_VIDEO_SIZE_CHANGE", new Object[0]);
                TVKLogoPlugin.this.onVideoSizeChange(message.arg1, message.arg2);
            }
        });
        this.mMessageHandler.put(1003, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.8
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.MessageExecutor
            public void execute(Message message) {
                TVKLogoPlugin.this.draw();
            }
        });
        this.mMessageHandler.put(1009, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.9
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.MessageExecutor
            public void execute(Message message) {
                TVKLogoPlugin.this.mLogger.info("LOGO_RESET_REALTIME", new Object[0]);
                TVKLogoPlugin.this.resetStartTime();
            }
        });
        this.mMessageHandler.put(1011, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.10
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.MessageExecutor
            public void execute(Message message) {
                TVKLogoPlugin.this.mLogger.info("LOGO_RELEASE", new Object[0]);
                TVKLogoPlugin.this.release();
            }
        });
        this.mMessageHandler.put(1010, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.11
            @Override // com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin.MessageExecutor
            public void execute(Message message) {
                TVKLogoPlugin.this.updatePlayerPositionMs(((Long) message.obj).longValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRealTimeInfoChange(int i3, Object obj) {
        this.mLogger.info("onRealTimeInfoChange:" + i3, new Object[0]);
        if (i3 != 11 && i3 != 9) {
            if (i3 == 12 && (obj instanceof Boolean)) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                this.mIsDynamicLogoOpen = booleanValue;
                this.mLogoMgr.setDynamicLogoOpen(booleanValue);
                drawLogoAsync();
                return;
            }
            return;
        }
        if (obj instanceof Boolean) {
            boolean booleanValue2 = ((Boolean) obj).booleanValue();
            this.mIsStaticLogoOpen = booleanValue2;
            this.mLogoMgr.setStaticLogoOpen(booleanValue2);
            drawLogoAsync();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoSizeChange(int i3, int i16) {
        this.mVideoW = i3;
        this.mVideoH = i16;
        this.mLogoMgr.setVideoSize(i3, i16);
        drawLogoAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        resetParams();
        TVKThreadPool.getInstance().recycle(this.mHandlerThread, this.mEventHandler);
        removeOnLayoutChangeListenerFromLogoViewGroup();
    }

    private void removeOnLayoutChangeListenerFromLogoViewGroup() {
        ViewGroup viewGroup = this.mLogoViewGroup;
        if (viewGroup != null) {
            viewGroup.removeOnLayoutChangeListener(this.mLogoViewGroupOnLayoutChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        resetParams();
        this.mLogoMgr.reset();
    }

    private void resetParams() {
        this.mIsDynamicLogoOpen = true;
        this.mIsStaticLogoOpen = true;
        this.mVideoH = 0;
        this.mVideoW = 0;
        this.mRetryTime = 0;
        this.mOriginalLogoInfo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetStartTime() {
        this.mLogoMgr.resetStartTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setXYAxis(int i3) {
        this.mLogoMgr.setXYAxis(i3);
        drawLogoAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(Object obj) {
        if (obj != null && (obj instanceof TVKEventParams.StartPlayParam)) {
            if (!((TVKEventParams.StartPlayParam) obj).isFirstStart) {
                this.mLogger.info("start return direct, no first start!", new Object[0]);
            } else {
                resetStartTime();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLogoInfo(TVKEventParams.GetVInfoResponseParam getVInfoResponseParam) {
        TVKNetVideoInfo tVKNetVideoInfo = getVInfoResponseParam.videoInfo;
        if (tVKNetVideoInfo == null) {
            this.mLogger.info("vInfoResponseParam is null", new Object[0]);
            return;
        }
        try {
            TVKLogoCommonDefine.TVKOriginalLogoInfo logoInfoFromVideoInfo = TVKLogoInfoParser.getLogoInfoFromVideoInfo(tVKNetVideoInfo);
            if (logoInfoFromVideoInfo == null) {
                this.mLogger.info("vInfoResponseParam has no logoInfo", new Object[0]);
                this.mLogoMgr.reset();
            } else {
                this.mOriginalLogoInfo = logoInfoFromVideoInfo;
                this.mLogoMgr.updateLogoInfo(logoInfoFromVideoInfo);
            }
        } catch (Exception e16) {
            this.mLogger.error("updateLogoInfo " + e16, new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateLogoViewGroup(View view) {
        if (view instanceof ITVKVideoViewPrivate) {
            this.mLogoViewGroup = ((ITVKVideoViewPrivate) view).getInnerLogoView();
        } else {
            this.mLogoViewGroup = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayerPositionMs(long j3) {
        this.mLogoMgr.updatePlayerPositionMs(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView(Object obj) {
        removeOnLayoutChangeListenerFromLogoViewGroup();
        if (!(obj instanceof TVKEventParams.UpdateVideoViewEventParam)) {
            this.mLogoViewGroup = null;
            changeLogoMgrByVideoView(null);
            return;
        }
        TVKEventParams.UpdateVideoViewEventParam updateVideoViewEventParam = (TVKEventParams.UpdateVideoViewEventParam) obj;
        updateLogoViewGroup(updateVideoViewEventParam.viewGroup);
        addOnLayoutChangeListenerToLogoViewGroup();
        changeLogoMgrByVideoView(updateVideoViewEventParam.viewGroup);
        drawLogoAsync();
    }

    @Override // com.tencent.qqlive.tvkplayer.event.ITVKEventObserver
    public void onEvent(int i3, int i16, int i17, String str, Object obj) {
        if (i3 != 10201 && i3 != 12001 && i3 != 16550 && i3 != 11000 && !this.mLogoMgr.isLogoEnabled()) {
            return;
        }
        Map<Integer, Integer> map = sEventMap;
        if (!map.containsKey(Integer.valueOf(i3))) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = map.get(Integer.valueOf(i3)).intValue();
        obtain.arg1 = i16;
        obtain.arg2 = i17;
        obtain.obj = obj;
        TVKLogoEventHandler tVKLogoEventHandler = this.mEventHandler;
        if (tVKLogoEventHandler != null) {
            tVKLogoEventHandler.sendMessage(obtain);
        }
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
