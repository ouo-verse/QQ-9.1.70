package com.tencent.qqmini.miniapp.widget.media.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class TXLivePlayerJSAdapter {
    public static final String EVT_DESCRIPTION = "EVT_MSG";
    public static final String EVT_GET_MSG = "EVT_GET_MSG";
    public static final String NET_STATUS_AUDIO_BITRATE = "AUDIO_BITRATE";
    public static final String NET_STATUS_AUDIO_CACHE = "AUDIO_CACHE";
    public static final String NET_STATUS_AUDIO_CACHE_THRESHOLD = "AUDIO_CACHE_THRESHOLD";
    public static final String NET_STATUS_AUDIO_DROP = "AUDIO_DROP";
    public static final String NET_STATUS_AUDIO_INFO = "AUDIO_PLAY_INFO";
    public static final String NET_STATUS_AV_PLAY_INTERVAL = "AV_PLAY_INTERVAL";
    public static final String NET_STATUS_AV_RECV_INTERVAL = "AV_RECV_INTERVAL";
    public static final String NET_STATUS_CPU_USAGE = "CPU_USAGE";
    public static final String NET_STATUS_NET_JITTER = "NET_JITTER";
    public static final String NET_STATUS_NET_SPEED = "NET_SPEED";
    public static final String NET_STATUS_SERVER_IP = "SERVER_IP";
    public static final String NET_STATUS_VIDEO_BITRATE = "VIDEO_BITRATE";
    public static final String NET_STATUS_VIDEO_CACHE = "VIDEO_CACHE";
    public static final String NET_STATUS_VIDEO_DROP = "VIDEO_DROP";
    public static final String NET_STATUS_VIDEO_FPS = "VIDEO_FPS";
    public static final String NET_STATUS_VIDEO_GOP = "VIDEO_GOP";
    public static final String NET_STATUS_VIDEO_HEIGHT = "VIDEO_HEIGHT";
    public static final String NET_STATUS_VIDEO_WIDTH = "VIDEO_WIDTH";
    public static final String NET_STATUS_V_DEC_CACHE_SIZE = "V_DEC_CACHE_SIZE";
    public static final String NET_STATUS_V_SUM_CACHE_SIZE = "V_SUM_CACHE_SIZE";
    public static final int PLAY_ERR_NET_DISCONNECT = -2301;
    public static final int PLAY_EVT_GET_MESSAGE = 2012;
    public static final int PLAY_EVT_PLAY_END = 2006;
    private static final String TAG = "TXLivePlayerJSAdapter";
    public static final int VIDEO_ANGLE_HOME_DOWN = 1;
    private ISnapshotOuterListener iTXSnapshotListener;
    private IPlayOuterListener iWXLivePlayerOuterListener;
    private ITXAudioVolumeEvaluationOuterListener itxAudioVolumeEvaluationOuterListener;
    private Context mContext;
    private Surface mSurface;
    private final IWXLivePlayerProxy mWXLivePlayerProxy;
    private String mPlayerUrl = "";
    private int mPlayType = 0;
    private boolean mInited = false;
    private boolean mPlayingBeforeEnterBackground = false;
    private boolean mMute = false;
    private boolean mNeedEvent = false;
    private boolean mAutoPauseIfNavigate = true;
    private boolean mAutoPauseIfOpenNative = true;
    private int mSurfaceWidth = 368;
    private int mSurfaceHeight = 640;

    /* loaded from: classes23.dex */
    public interface IPlayOuterListener {
        void onNetStatus(Bundle bundle);

        void onPlayEvent(int i3, Bundle bundle);
    }

    /* loaded from: classes23.dex */
    public interface ISnapshotOuterListener {
        void onSnapshot(Bitmap bitmap);
    }

    /* loaded from: classes23.dex */
    public interface ITXAudioVolumeEvaluationOuterListener {
        void onAudioVolumeEvaluationNotify(int i3);
    }

    /* loaded from: classes23.dex */
    public class InnerAudioVolumeEvaluationListenerImpl implements InvocationHandler {
        public InnerAudioVolumeEvaluationListenerImpl() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            QMLog.e(TXLivePlayerJSAdapter.TAG, "InnerAudioVolumeEvaluationListenerImpl invoke:" + method.getName());
            if (Object.class.equals(method.getDeclaringClass())) {
                try {
                    return method.invoke(this, objArr);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    return null;
                }
            }
            if ("onAudioVolumeEvaluationNotify".equals(method.getName()) && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof Integer) {
                    int intValue = ((Integer) obj2).intValue();
                    if (TXLivePlayerJSAdapter.this.itxAudioVolumeEvaluationOuterListener != null) {
                        TXLivePlayerJSAdapter.this.itxAudioVolumeEvaluationOuterListener.onAudioVolumeEvaluationNotify(intValue);
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes23.dex */
    public class InnerITXSnapshotListenerImpl implements InvocationHandler {
        private boolean mNeedCompress = false;

        public InnerITXSnapshotListenerImpl() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            QMLog.e(TXLivePlayerJSAdapter.TAG, "InnerITXSnapshotListenerImpl invoke:" + method.getName());
            if (Object.class.equals(method.getDeclaringClass())) {
                try {
                    return method.invoke(this, objArr);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    return null;
                }
            }
            if ("onSnapshot".equals(method.getName()) && objArr.length == 1) {
                Bitmap bitmap = (Bitmap) objArr[0];
                if (TXLivePlayerJSAdapter.this.iTXSnapshotListener != null) {
                    if (this.mNeedCompress) {
                        if (bitmap != null) {
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            Matrix matrix = new Matrix();
                            matrix.setScale(0.5f, 0.5f);
                            TXLivePlayerJSAdapter.this.iTXSnapshotListener.onSnapshot(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false));
                            TXLivePlayerJSAdapter.this.safeRecycleBitmap(bitmap);
                        } else {
                            TXLivePlayerJSAdapter.this.iTXSnapshotListener.onSnapshot(bitmap);
                        }
                    } else {
                        TXLivePlayerJSAdapter.this.iTXSnapshotListener.onSnapshot(bitmap);
                    }
                }
            }
            return null;
        }

        public void setNeedCompress(boolean z16) {
            this.mNeedCompress = z16;
        }
    }

    /* loaded from: classes23.dex */
    public class InnerTXLivePlayListenerImpl implements InvocationHandler {
        public InnerTXLivePlayListenerImpl() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            QMLog.e(TXLivePlayerJSAdapter.TAG, "InnerTXLivePlayListenerImpl invoke:" + method.getName());
            if (Object.class.equals(method.getDeclaringClass())) {
                try {
                    return method.invoke(this, objArr);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    return null;
                }
            }
            if ("onPlayEvent".equals(method.getName())) {
                TXLivePlayerJSAdapter.this.onPlayEvent(objArr);
                return null;
            }
            if ("onNetStatus".equals(method.getName())) {
                TXLivePlayerJSAdapter.this.onNetStatus(objArr);
                return null;
            }
            return null;
        }
    }

    public TXLivePlayerJSAdapter(Context context) {
        QMLog.d(TAG, "TXLivePlayerJSAdapter() ");
        this.mContext = context;
        IWXLivePlayerProxy iWXLivePlayerProxy = (IWXLivePlayerProxy) ProxyManager.getNew(IWXLivePlayerProxy.class);
        this.mWXLivePlayerProxy = iWXLivePlayerProxy;
        iWXLivePlayerProxy.init(this.mContext, new InnerTXLivePlayListenerImpl(), new InnerAudioVolumeEvaluationListenerImpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetStatus(Object[] objArr) {
        if (objArr.length == 1) {
            Bundle bundle = (Bundle) objArr[0];
            IPlayOuterListener iPlayOuterListener = this.iWXLivePlayerOuterListener;
            if (iPlayOuterListener != null) {
                iPlayOuterListener.onNetStatus(bundle);
            }
            if (QMLog.isColorLevel()) {
                String format = String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", "CPU:" + bundle.getString("CPU_USAGE"), "RES:" + bundle.getInt("VIDEO_WIDTH") + "*" + bundle.getInt("VIDEO_HEIGHT"), "SPD:" + bundle.getInt("NET_SPEED") + "Kbps", "JIT:" + bundle.getInt("NET_JITTER"), "FPS:" + bundle.getInt("VIDEO_FPS"), "GOP:" + bundle.getInt("VIDEO_GOP") + ReportConstant.COSTREPORT_PREFIX, "ARA:" + bundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + bundle.getInt("AUDIO_CACHE") + APLogFileUtil.SEPARATOR_LOG + bundle.getInt("VIDEO_CACHE") + "," + bundle.getInt("V_SUM_CACHE_SIZE") + "," + bundle.getInt("V_DEC_CACHE_SIZE") + APLogFileUtil.SEPARATOR_LOG + bundle.getInt("AV_RECV_INTERVAL") + "," + bundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", Float.valueOf(bundle.getFloat("AUDIO_CACHE_THRESHOLD"))).toString(), "VRA:" + bundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + bundle.getInt("AUDIO_DROP") + "|" + bundle.getInt("VIDEO_DROP"), "SVR:" + bundle.getString("SERVER_IP"), "AUDIO:" + bundle.getString("AUDIO_PLAY_INFO"));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onNetStatus:");
                sb5.append(format);
                QMLog.d(TAG, sb5.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayEvent(Object[] objArr) {
        IPlayOuterListener iPlayOuterListener;
        String str;
        if (objArr.length == 2) {
            Integer num = (Integer) objArr[0];
            Bundle bundle = (Bundle) objArr[1];
            if (num.equals(2006) || num.equals(-2301)) {
                operateLivePlayer("stop", null);
            }
            if (num.intValue() == 2012 && bundle != null) {
                byte[] byteArray = bundle.getByteArray("EVT_GET_MSG");
                if (byteArray != null && byteArray.length > 0) {
                    try {
                        str = new String(byteArray, "UTF-8");
                    } catch (UnsupportedEncodingException e16) {
                        e16.printStackTrace();
                    }
                    bundle.putString("EVT_MSG", str);
                }
                str = "";
                bundle.putString("EVT_MSG", str);
            }
            if (this.mNeedEvent && (iPlayOuterListener = this.iWXLivePlayerOuterListener) != null) {
                iPlayOuterListener.onPlayEvent(num.intValue(), bundle);
            }
            if (bundle != null) {
                QMLog.d(TAG, "onPlayEvent: event = " + num + " message = " + bundle.getString("EVT_MSG"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeRecycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            QMLog.d(TAG, "bitmap recycle " + bitmap.toString());
            bitmap.recycle();
        }
    }

    public Bundle createBundleFromJsonObject(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        String[] strArr = {"playUrl", "orientation", "objectFit", "soundMode"};
        for (int i3 = 0; i3 < 4; i3++) {
            String str = strArr[i3];
            if (jSONObject.has(str)) {
                bundle.putString(str, jSONObject.optString(str));
            }
        }
        String[] strArr2 = {"hide", "muted", "muteAudio", "muteVideo", "autoplay", "enableRecvMessage", "needAudioVolume", "needEvent", "autoPauseIfNavigate", "autoPauseIfOpenNative", TXJSAdapterConstants.PLAYER_KEY_ENABLE_META_DATA, "backgroundMute", "debug"};
        for (int i16 = 0; i16 < 13; i16++) {
            String str2 = strArr2[i16];
            if (jSONObject.has(str2)) {
                bundle.putBoolean(str2, jSONObject.optBoolean(str2));
            }
        }
        String[] strArr3 = {"minCache", "maxCache"};
        for (int i17 = 0; i17 < 2; i17++) {
            String str3 = strArr3[i17];
            if (jSONObject.has(str3)) {
                bundle.putFloat(str3, (float) jSONObject.optDouble(str3));
            }
        }
        String str4 = new String[]{"mode"}[0];
        if (jSONObject.has(str4)) {
            bundle.putInt(str4, jSONObject.optInt(str4));
        }
        if (jSONObject.has("position")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            this.mSurfaceWidth = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("width", -1)) + 0.5f);
            this.mSurfaceHeight = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("height", -1)) + 0.5f);
        }
        return bundle;
    }

    public TXJSAdapterError enterBackground(int i3) {
        IPlayOuterListener iPlayOuterListener;
        QMLog.d(TAG, "enterBackground");
        if ((i3 == 2 && !this.mAutoPauseIfOpenNative) || (i3 == 1 && !this.mAutoPauseIfNavigate)) {
            this.mPlayingBeforeEnterBackground = false;
            return new TXJSAdapterError();
        }
        boolean txLivePlayer_isPlaying = this.mWXLivePlayerProxy.txLivePlayer_isPlaying();
        this.mPlayingBeforeEnterBackground = txLivePlayer_isPlaying;
        if (txLivePlayer_isPlaying) {
            if (this.mNeedEvent && (iPlayOuterListener = this.iWXLivePlayerOuterListener) != null) {
                iPlayOuterListener.onPlayEvent(6000, new Bundle());
            }
            return operateLivePlayer("pause", null);
        }
        return new TXJSAdapterError();
    }

    public TXJSAdapterError enterForeground() {
        if (this.mPlayingBeforeEnterBackground) {
            return operateLivePlayer("resume", null);
        }
        return new TXJSAdapterError();
    }

    public TXJSAdapterError initEmbeddedLivePlayer(JSONObject jSONObject) {
        QMLog.d(TAG, "initEmbeddedLivePlayer:jsonObj" + jSONObject);
        this.mWXLivePlayerProxy.initLivePlayer(null, createBundleFromJsonObject(jSONObject));
        Surface surface = this.mSurface;
        if (surface != null) {
            setSurface(surface);
            setSurfaceSize(this.mSurfaceWidth, this.mSurfaceHeight);
        }
        QMLog.d(TAG, "initEmbeddedLivePlayer: mInited = true");
        this.mInited = true;
        return new TXJSAdapterError();
    }

    public TXJSAdapterError initLivePlayer(Object obj, JSONObject jSONObject) {
        QMLog.d(TAG, "initLivePlayer:videoView = " + obj + ", jsonObject = " + jSONObject.toString());
        return initLivePlayer(obj, createBundleFromJsonObject(jSONObject));
    }

    public boolean isMute() {
        return this.mMute;
    }

    public boolean isPlaying() {
        return this.mWXLivePlayerProxy.txLivePlayer_isPlaying();
    }

    public TXJSAdapterError operateLivePlayer(String str, JSONObject jSONObject) {
        QMLog.d(TAG, "operateLivePlayer:operateName = " + str + ",param = " + jSONObject);
        if (str == null) {
            return new TXJSAdapterError(-1, "invalid params");
        }
        if (!this.mInited) {
            return new TXJSAdapterError(-3, "uninited livePlayer");
        }
        if (str.equalsIgnoreCase("play")) {
            this.mWXLivePlayerProxy.txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
        } else if (str.equalsIgnoreCase("stop")) {
            this.mWXLivePlayerProxy.txLivePlayer_stopPlay(Boolean.TRUE);
        } else if (str.equalsIgnoreCase("pause")) {
            this.mWXLivePlayerProxy.txLivePlayer_pause();
        } else if (str.equalsIgnoreCase("resume")) {
            this.mWXLivePlayerProxy.txLivePlayer_resume();
        } else if (str.equalsIgnoreCase("mute")) {
            boolean z16 = !this.mMute;
            this.mMute = z16;
            this.mWXLivePlayerProxy.txLivePlayer_muteAudio(Boolean.valueOf(z16));
        } else {
            return new TXJSAdapterError(-4, "invalid operate command");
        }
        return new TXJSAdapterError();
    }

    public void setItxAudioVolumeEvaluationOuterListener(ITXAudioVolumeEvaluationOuterListener iTXAudioVolumeEvaluationOuterListener) {
        this.itxAudioVolumeEvaluationOuterListener = iTXAudioVolumeEvaluationOuterListener;
    }

    public void setPlayListener(IPlayOuterListener iPlayOuterListener) {
        this.iWXLivePlayerOuterListener = iPlayOuterListener;
    }

    public void setSnapshotListener(ISnapshotOuterListener iSnapshotOuterListener) {
        this.iTXSnapshotListener = iSnapshotOuterListener;
    }

    public TXJSAdapterError setSurface(Surface surface) {
        QMLog.d(TAG, "setSurface: " + surface);
        this.mSurface = surface;
        this.mWXLivePlayerProxy.txLivePlayer_setSurface(surface);
        return new TXJSAdapterError();
    }

    public TXJSAdapterError setSurfaceSize(int i3, int i16) {
        QMLog.d(TAG, "setSurfaceSize: width = " + i3 + ", height = " + i16);
        this.mSurfaceWidth = i3;
        this.mSurfaceHeight = i16;
        this.mWXLivePlayerProxy.txLivePlayer_setSurfaceSize(i3, i16);
        return new TXJSAdapterError();
    }

    public void takePhoto(boolean z16) {
        InnerITXSnapshotListenerImpl innerITXSnapshotListenerImpl = new InnerITXSnapshotListenerImpl();
        innerITXSnapshotListenerImpl.setNeedCompress(z16);
        this.mWXLivePlayerProxy.txLivePlay_snapshot(innerITXSnapshotListenerImpl);
    }

    public TXJSAdapterError uninitLivePlayer() {
        if (!this.mInited) {
            return new TXJSAdapterError(-3, "uninited livePlayer");
        }
        this.mWXLivePlayerProxy.txLivePlayer_stopPlay(Boolean.TRUE);
        this.mWXLivePlayerProxy.txLivePlayer_setPlayListener(null);
        this.mInited = false;
        return new TXJSAdapterError();
    }

    public TXJSAdapterError updateLivePlayer(JSONObject jSONObject) {
        QMLog.d(TAG, "updateLivePlayer:jsonObject" + jSONObject);
        return updateLivePlayer(createBundleFromJsonObject(jSONObject));
    }

    public TXJSAdapterError initLivePlayer(Object obj, Bundle bundle) {
        QMLog.d(TAG, "initLivePlayer:txCloudVideoView" + obj + "params = " + bundle);
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.mNeedEvent = bundle.getBoolean("needEvent", this.mNeedEvent);
        if (obj != null) {
            this.mWXLivePlayerProxy.initLivePlayer(obj, bundle);
        } else {
            this.mWXLivePlayerProxy.initLivePlayer(null, bundle);
            Surface surface = this.mSurface;
            if (surface != null) {
                setSurface(surface);
                setSurfaceSize(this.mSurfaceWidth, this.mSurfaceHeight);
            }
        }
        QMLog.d(TAG, "initLivePlayer: mInited = true");
        this.mInited = true;
        return new TXJSAdapterError();
    }

    public TXJSAdapterError updateLivePlayer(Bundle bundle) {
        QMLog.d(TAG, "updateLivePlayer:params" + bundle);
        if (bundle == null) {
            return new TXJSAdapterError(-1, "invalid params");
        }
        if (!this.mInited) {
            return new TXJSAdapterError(-3, "uninited livePlayer");
        }
        this.mNeedEvent = bundle.getBoolean("needEvent", this.mNeedEvent);
        this.mWXLivePlayerProxy.updateLivePlayer(bundle);
        return new TXJSAdapterError();
    }
}
