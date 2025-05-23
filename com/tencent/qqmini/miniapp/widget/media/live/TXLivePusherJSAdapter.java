package com.tencent.qqmini.miniapp.widget.media.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class TXLivePusherJSAdapter implements TXLivePushListenerReflect.OnBGMNotify, TXLivePushListenerReflect.ITXLivePushListener {
    private static final String TAG = "TXLivePusherJSAdapter";
    private TXLivePushListenerReflect.OnBGMNotify mBGMNotifyListener;
    private Context mContext;
    private Handler mHandler;
    private TXLivePushListenerReflect.ITXLivePushListener mLivePushListener;
    private Surface mSurface;
    private final IWXLivePusherProxy mWXLivePusherProxy;
    private ArrayList<String> pusherKeyList;
    private int mLastAngle = 0;
    private boolean mInited = false;
    private boolean mPushingBeforeEnterBackground = false;
    private boolean mForceStop = false;
    private boolean mBGMPlaying = false;
    private boolean mNeedEvent = false;
    private boolean mNeedBGMEvent = false;
    private String mBackgroundImage = "";
    private String mPauseImagePath = "";
    private int mSurfaceWidth = 368;
    private int mSurfaceHeight = 640;

    public TXLivePusherJSAdapter(Context context) {
        QMLog.d(TAG, "TXLivePusherJSAdapter()");
        IWXLivePusherProxy iWXLivePusherProxy = (IWXLivePusherProxy) ProxyManager.getNew(IWXLivePusherProxy.class);
        this.mWXLivePusherProxy = iWXLivePusherProxy;
        this.mContext = context;
        this.mHandler = new Handler(this.mContext.getMainLooper());
        initPusherKeyList();
        iWXLivePusherProxy.initInstance(context);
        iWXLivePusherProxy.setPushListener(iWXLivePusherProxy.newITXLivePushListener(this));
        iWXLivePusherProxy.setBGMNofify(iWXLivePusherProxy.newOnBGMNotify(this));
    }

    private Bundle adaptJsonToBundle(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        if (jSONObject == null) {
            return bundle;
        }
        ArrayList<String> arrayList = this.pusherKeyList;
        if (arrayList == null) {
            QMLog.e(TAG, "adaptJsonToBundle - pusherKeyList is null");
            return bundle;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (isStringValueKey(next)) {
                try {
                    bundle.putString(next, jSONObject.getString(next));
                } catch (JSONException unused) {
                }
            } else if (isIntKeyForParams(next)) {
                bundle.putInt(next, jSONObject.getInt(next));
            } else if (isBooleanKeyForParams(next)) {
                bundle.putBoolean(next, jSONObject.getBoolean(next));
            } else if (isFloatKeyForParams(next)) {
                bundle.putDouble(next, jSONObject.getDouble(next));
            }
        }
        if (jSONObject.has("position")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            this.mSurfaceWidth = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("width", -1)) + 0.5f);
            this.mSurfaceHeight = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("height", -1)) + 0.5f);
        }
        return bundle;
    }

    private void adjustHomeOrientation(int i3, String str) {
        QMLog.d(TAG, "adjustHomeOrientation, angle:" + i3 + ", orientation:" + str);
        int i16 = !str.equals("horizontal") ? 1 : 0;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("adjustHomeOrientation, homeOrientation:");
        sb5.append(i16);
        QMLog.d(TAG, sb5.toString());
        this.mWXLivePusherProxy.setHomeOrientation(i16);
    }

    private void asyncProcessPauseImage(final Context context, final String str) {
        QMLog.d(TAG, "asyncProcessPauseImage, backgroundImage:" + str);
        if (context != null && !TextUtils.isEmpty(str)) {
            if (str.equalsIgnoreCase(this.mBackgroundImage)) {
                QMLog.d(TAG, "asyncProcessPauseImage, backgroundImage equeals");
                this.mHandler.post(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle = new Bundle();
                        bundle.putString("backgroundImage", TXLivePusherJSAdapter.this.mPauseImagePath);
                        TXLivePusherJSAdapter.this.mWXLivePusherProxy.updateLivePusher(bundle);
                    }
                });
                return;
            } else {
                if (str.startsWith("http://") || str.startsWith("https://")) {
                    final String str2 = "pause_image.jpg";
                    AsyncTask.execute(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter.3
                        /* JADX WARN: Can't wrap try/catch for region: R(11:(14:8|9|(1:11)|12|13|14|15|16|17|(2:18|(1:20)(1:21))|22|23|24|26)|13|14|15|16|17|(3:18|(0)(0)|20)|22|23|24|26) */
                        /* JADX WARN: Can't wrap try/catch for region: R(20:1|2|3|(14:8|9|(1:11)|12|13|14|15|16|17|(2:18|(1:20)(1:21))|22|23|24|26)|51|(1:53)(1:54)|9|(0)|12|13|14|15|16|17|(3:18|(0)(0)|20)|22|23|24|26|(1:(0))) */
                        /* JADX WARN: Code restructure failed: missing block: B:29:0x009c, code lost:
                        
                            r0 = move-exception;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
                        
                            r2 = r0;
                            r0 = r4;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
                        
                            r2.printStackTrace();
                            com.tencent.qqmini.sdk.launcher.log.QMLog.d(com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter.TAG, "asyncProcessPauseImage, Exception");
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b5, code lost:
                        
                            if (r0 != null) goto L39;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:33:0x00b7, code lost:
                        
                            r0.close();
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ba, code lost:
                        
                            if (r1 == null) goto L42;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:35:0x00bd, code lost:
                        
                            return;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:37:0x0098, code lost:
                        
                            r0 = move-exception;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:38:0x0099, code lost:
                        
                            r2 = r0;
                            r0 = r4;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:39:0x00bf, code lost:
                        
                            if (r0 != null) goto L55;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:40:0x00c4, code lost:
                        
                            if (r1 != null) goto L47;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:41:0x00c6, code lost:
                        
                            r1.close();
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:44:0x00c9, code lost:
                        
                            throw r2;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:46:0x00c1, code lost:
                        
                            r0.close();
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:48:0x00a0, code lost:
                        
                            r2 = e;
                         */
                        /* JADX WARN: Removed duplicated region for block: B:11:0x003d A[Catch: all -> 0x00a2, Exception -> 0x00a6, TryCatch #8 {Exception -> 0x00a6, all -> 0x00a2, blocks: (B:3:0x0001, B:5:0x000e, B:8:0x0015, B:9:0x0030, B:11:0x003d, B:12:0x0040, B:51:0x0020, B:53:0x002a), top: B:2:0x0001 }] */
                        /* JADX WARN: Removed duplicated region for block: B:20:0x007c A[Catch: all -> 0x0098, Exception -> 0x009c, LOOP:0: B:18:0x0075->B:20:0x007c, LOOP_END, TryCatch #7 {Exception -> 0x009c, all -> 0x0098, blocks: (B:17:0x0073, B:18:0x0075, B:20:0x007c, B:22:0x0080), top: B:16:0x0073 }] */
                        /* JADX WARN: Removed duplicated region for block: B:21:0x0080 A[EDGE_INSN: B:21:0x0080->B:22:0x0080 BREAK  A[LOOP:0: B:18:0x0075->B:20:0x007c], SYNTHETIC] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            Throwable th5;
                            InputStream inputStream;
                            String str3;
                            final File file;
                            FileOutputStream fileOutputStream;
                            byte[] bArr;
                            int read;
                            FileOutputStream fileOutputStream2 = null;
                            try {
                                try {
                                } catch (Exception e16) {
                                    Exception e17 = e16;
                                    inputStream = null;
                                } catch (Throwable th6) {
                                    th5 = th6;
                                    inputStream = null;
                                }
                                try {
                                    if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
                                        str3 = context.getFilesDir().getPath();
                                        file = new File(str3, str2);
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                        file.createNewFile();
                                        TXLivePusherJSAdapter.this.mBackgroundImage = str;
                                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(TXLivePusherJSAdapter.this.mBackgroundImage).openConnection();
                                        httpURLConnection.setConnectTimeout(6000);
                                        httpURLConnection.setDoInput(true);
                                        httpURLConnection.setUseCaches(false);
                                        inputStream = httpURLConnection.getInputStream();
                                        fileOutputStream = new FileOutputStream(file);
                                        bArr = new byte[4096];
                                        while (true) {
                                            read = inputStream.read(bArr);
                                            if (read != -1) {
                                                break;
                                            } else {
                                                fileOutputStream.write(bArr, 0, read);
                                            }
                                        }
                                        fileOutputStream.flush();
                                        TXLivePusherJSAdapter.this.mHandler.post(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter.3.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                TXLivePusherJSAdapter.this.mPauseImagePath = file.getAbsolutePath();
                                                Bundle bundle = new Bundle();
                                                bundle.putString("backgroundImage", file.getAbsolutePath());
                                                TXLivePusherJSAdapter.this.mWXLivePusherProxy.updateLivePusher(bundle);
                                            }
                                        });
                                        fileOutputStream.close();
                                        inputStream.close();
                                        return;
                                    }
                                    fileOutputStream = new FileOutputStream(file);
                                    bArr = new byte[4096];
                                    while (true) {
                                        read = inputStream.read(bArr);
                                        if (read != -1) {
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    fileOutputStream.flush();
                                    TXLivePusherJSAdapter.this.mHandler.post(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter.3.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            TXLivePusherJSAdapter.this.mPauseImagePath = file.getAbsolutePath();
                                            Bundle bundle = new Bundle();
                                            bundle.putString("backgroundImage", file.getAbsolutePath());
                                            TXLivePusherJSAdapter.this.mWXLivePusherProxy.updateLivePusher(bundle);
                                        }
                                    });
                                    fileOutputStream.close();
                                    inputStream.close();
                                    return;
                                } catch (Throwable th7) {
                                    th5 = th7;
                                }
                                File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                                if (externalFilesDir != null) {
                                    str3 = externalFilesDir.getPath();
                                } else {
                                    str3 = null;
                                }
                                file = new File(str3, str2);
                                if (file.exists()) {
                                }
                                file.createNewFile();
                                TXLivePusherJSAdapter.this.mBackgroundImage = str;
                                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(TXLivePusherJSAdapter.this.mBackgroundImage).openConnection();
                                httpURLConnection2.setConnectTimeout(6000);
                                httpURLConnection2.setDoInput(true);
                                httpURLConnection2.setUseCaches(false);
                                inputStream = httpURLConnection2.getInputStream();
                            } catch (Exception unused) {
                            }
                        }
                    });
                    return;
                }
                return;
            }
        }
        QMLog.d(TAG, "asyncProcessPauseImage, backgroundImage: null");
    }

    private TXJSAdapterError baseLivePusherOperate(String str, JSONObject jSONObject) {
        QMLog.d(TAG, "baseLivePusherOperate: operateName = " + str + " param = " + jSONObject);
        if (str.equalsIgnoreCase("start")) {
            this.mWXLivePusherProxy.startPusher("");
            return new TXJSAdapterError();
        }
        if (str.equalsIgnoreCase("stop")) {
            this.mWXLivePusherProxy.stopPusher();
            return new TXJSAdapterError();
        }
        if (str.equalsIgnoreCase("pause")) {
            this.mWXLivePusherProxy.pausePusher();
            return new TXJSAdapterError();
        }
        if (str.equalsIgnoreCase("resume")) {
            this.mWXLivePusherProxy.resumePusher();
            return new TXJSAdapterError();
        }
        return null;
    }

    private TXJSAdapterError bgmLivePusherOperate(String str, JSONObject jSONObject) {
        if (str.equalsIgnoreCase(c.f123373g0)) {
            return playBGM(jSONObject);
        }
        if (str.equalsIgnoreCase("stopBGM")) {
            this.mWXLivePusherProxy.stopBGM();
            this.mBGMPlaying = false;
            return new TXJSAdapterError();
        }
        if (str.equalsIgnoreCase("pauseBGM")) {
            this.mWXLivePusherProxy.pauseBGM();
            this.mBGMPlaying = false;
            return new TXJSAdapterError();
        }
        if (str.equalsIgnoreCase("resumeBGM")) {
            this.mWXLivePusherProxy.resumeBGM();
            this.mBGMPlaying = true;
            return new TXJSAdapterError();
        }
        if (str.equalsIgnoreCase("setBGMPosition")) {
            return setBGMPosition(jSONObject);
        }
        if (str.equalsIgnoreCase("setBGMVolume")) {
            return setBGMVolume(jSONObject);
        }
        if (str.equalsIgnoreCase("setMICVolume")) {
            setMICVolume(jSONObject);
            return null;
        }
        return null;
    }

    private TXJSAdapterError cameraLivePusherOperate(String str, JSONObject jSONObject) {
        String str2;
        QMLog.d(TAG, "cameraLivePusherOperate: operateName = " + str + " param = " + jSONObject);
        if (str.equalsIgnoreCase("startPreview")) {
            if (this.mWXLivePusherProxy.isPushing()) {
                QMLog.d(TAG, "do not support startPreview when pushing");
            } else {
                this.mWXLivePusherProxy.startCameraPreview(null);
            }
            return new TXJSAdapterError();
        }
        if (str.equalsIgnoreCase("stopPreview")) {
            if (this.mWXLivePusherProxy.isPushing()) {
                QMLog.d(TAG, "do not support stopPreview when pushing");
            } else {
                this.mWXLivePusherProxy.stopCameraPreview(true);
            }
            return new TXJSAdapterError();
        }
        if (str.equalsIgnoreCase("switchCamera")) {
            this.mWXLivePusherProxy.switchCamera();
            return new TXJSAdapterError();
        }
        if (!str.equalsIgnoreCase("toggleTorch")) {
            return null;
        }
        int i3 = -2;
        if (this.mWXLivePusherProxy.isPushing()) {
            boolean turnOnFlashLight = this.mWXLivePusherProxy.turnOnFlashLight(true);
            if (turnOnFlashLight) {
                i3 = 0;
            }
            if (turnOnFlashLight) {
                str2 = "Success";
            } else {
                str2 = "Failed";
            }
            return new TXJSAdapterError(i3, str2);
        }
        return new TXJSAdapterError(-2, "fail");
    }

    private void initPusherKeyList() {
        if (this.pusherKeyList == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.pusherKeyList = arrayList;
            arrayList.add("pushUrl");
            this.pusherKeyList.add("mode");
            this.pusherKeyList.add("hide");
            this.pusherKeyList.add("autopush");
            this.pusherKeyList.add("muted");
            this.pusherKeyList.add("enableCamera");
            this.pusherKeyList.add("enableMic");
            this.pusherKeyList.add("enableAGC");
            this.pusherKeyList.add("enableANS");
            this.pusherKeyList.add("audioVolumeType");
            this.pusherKeyList.add("audioReverbType");
            this.pusherKeyList.add("devicePosition");
            this.pusherKeyList.add("focusMode");
            this.pusherKeyList.add("orientation");
            this.pusherKeyList.add("beauty");
            this.pusherKeyList.add("whiteness");
            this.pusherKeyList.add("aspect");
            this.pusherKeyList.add("videoWidth");
            this.pusherKeyList.add("videoHeight");
            this.pusherKeyList.add("minBitrate");
            this.pusherKeyList.add("maxBitrate");
            this.pusherKeyList.add("audioQuality");
            this.pusherKeyList.add("backgroundImage");
            this.pusherKeyList.add("backgroundMute");
            this.pusherKeyList.add("zoom");
            this.pusherKeyList.add("needEvent");
            this.pusherKeyList.add("needBGMEvent");
            this.pusherKeyList.add("watermarkImage");
            this.pusherKeyList.add("watermarkLeft");
            this.pusherKeyList.add("watermarkTop");
            this.pusherKeyList.add("watermarkWidth");
            this.pusherKeyList.add("debug");
            this.pusherKeyList.add("mirror");
            this.pusherKeyList.add("remoteMirror");
            this.pusherKeyList.add("localMirror");
            this.pusherKeyList.add("enableEarMonitor");
        }
    }

    private boolean isBooleanKeyForParams(String str) {
        if (!str.equalsIgnoreCase("hide") && !str.equalsIgnoreCase("autopush") && !str.equalsIgnoreCase("muted") && !str.equalsIgnoreCase("enableCamera") && !str.equalsIgnoreCase("enableMic") && !str.equalsIgnoreCase("enableAGC") && !str.equalsIgnoreCase("enableANS") && !isaBooleanKeyP2(str)) {
            return false;
        }
        return true;
    }

    private boolean isFloatKeyForParams(String str) {
        if (!str.equalsIgnoreCase("watermarkLeft") && !str.equalsIgnoreCase("watermarkTop") && !str.equalsIgnoreCase("watermarkWidth")) {
            return false;
        }
        return true;
    }

    private boolean isIntKeyForParams(String str) {
        if (!str.equalsIgnoreCase("mode") && !str.equalsIgnoreCase("focusMode") && !str.equalsIgnoreCase("beauty") && !str.equalsIgnoreCase("whiteness") && !str.equalsIgnoreCase("aspect") && !str.equalsIgnoreCase("videoWidth") && !str.equalsIgnoreCase("videoHeight") && !str.equalsIgnoreCase("audioReverbType") && !str.equalsIgnoreCase("minBitrate") && !str.equalsIgnoreCase("maxBitrate")) {
            return false;
        }
        return true;
    }

    private boolean isStringValueKey(String str) {
        if (!str.equalsIgnoreCase("pushUrl") && !str.equalsIgnoreCase("orientation") && !str.equalsIgnoreCase("backgroundImage") && !str.equalsIgnoreCase("audioQuality") && !str.equalsIgnoreCase("watermarkImage") && !str.equalsIgnoreCase("audioVolumeType") && !str.equalsIgnoreCase("localMirror") && !str.equalsIgnoreCase("devicePosition")) {
            return false;
        }
        return true;
    }

    private boolean isaBooleanKeyP2(String str) {
        if (!str.equalsIgnoreCase("enableEarMonitor") && !str.equalsIgnoreCase("backgroundMute") && !str.equalsIgnoreCase("zoom") && !str.equalsIgnoreCase("needEvent") && !str.equalsIgnoreCase("needBGMEvent") && !str.equalsIgnoreCase("debug") && !str.equalsIgnoreCase("mirror") && !str.equalsIgnoreCase("remoteMirror")) {
            return false;
        }
        return true;
    }

    private TXJSAdapterError otherLivePusherOperate(String str, JSONObject jSONObject) {
        String str2;
        QMLog.d(TAG, "otherLivePusherOperate: operateName = " + str + " param = " + jSONObject);
        String str3 = null;
        int i3 = 0;
        if (str.equalsIgnoreCase("sendMessage")) {
            if (jSONObject != null) {
                str3 = jSONObject.optString("msg");
            }
            if (str3 != null) {
                boolean sendMessageEx = this.mWXLivePusherProxy.sendMessageEx(str3.getBytes());
                if (!sendMessageEx) {
                    i3 = -2;
                }
                if (sendMessageEx) {
                    str2 = "Success";
                } else {
                    str2 = "Failed";
                }
                return new TXJSAdapterError(i3, str2);
            }
            return new TXJSAdapterError(-2, "fail");
        }
        if (!str.equalsIgnoreCase("setAudioReverbType")) {
            return null;
        }
        if (jSONObject != null) {
            i3 = jSONObject.optInt("audioReverbType", 0);
        }
        this.mWXLivePusherProxy.setReverb(i3);
        return new TXJSAdapterError();
    }

    private TXJSAdapterError playBGM(JSONObject jSONObject) {
        String str = "";
        if (jSONObject != null) {
            str = jSONObject.optString("BGMFilePath", "");
        }
        QMLog.d(TAG, "playBGM filePath = " + str);
        if (str != null && str.length() > 0) {
            this.mWXLivePusherProxy.playBGM(str);
            return new TXJSAdapterError();
        }
        return new TXJSAdapterError(-2, "fail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeRecycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            QMLog.d(TAG, "bitmap recycle " + bitmap.toString());
            bitmap.recycle();
        }
    }

    private TXJSAdapterError setBGMPosition(JSONObject jSONObject) {
        int optInt;
        if (this.mBGMPlaying && jSONObject != null && (optInt = jSONObject.optInt("BGMPosition", -1)) > 0) {
            this.mWXLivePusherProxy.setBGMPosition(optInt);
        }
        return new TXJSAdapterError();
    }

    private TXJSAdapterError setBGMVolume(JSONObject jSONObject) {
        double d16 = 1.0d;
        if (jSONObject != null) {
            d16 = jSONObject.optDouble(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, 1.0d);
        }
        this.mWXLivePusherProxy.setBGMVolume((float) d16);
        return new TXJSAdapterError();
    }

    private void setMICVolume(JSONObject jSONObject) {
        double d16 = 1.0d;
        if (jSONObject != null) {
            d16 = jSONObject.optDouble(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, 1.0d);
        }
        this.mWXLivePusherProxy.setMicVolume((float) d16);
    }

    public TXJSAdapterError enterBackground(boolean z16) {
        TXLivePushListenerReflect.ITXLivePushListener iTXLivePushListener;
        boolean isPushing = this.mWXLivePusherProxy.isPushing();
        this.mPushingBeforeEnterBackground = isPushing;
        if (isPushing) {
            if (z16) {
                this.mForceStop = z16;
                if (this.mNeedEvent && (iTXLivePushListener = this.mLivePushListener) != null) {
                    iTXLivePushListener.onPushEvent(5000, new Bundle());
                }
                return operateLivePusher("stop", null);
            }
            return operateLivePusher("pause", null);
        }
        return new TXJSAdapterError();
    }

    public TXJSAdapterError enterForeground() {
        if (this.mPushingBeforeEnterBackground) {
            if (this.mForceStop) {
                return operateLivePusher("start", null);
            }
            return operateLivePusher("resume", null);
        }
        return new TXJSAdapterError();
    }

    public TXJSAdapterError initEmbeddedLivePusher(JSONObject jSONObject) {
        QMLog.d(TAG, "initEmbeddedLivePusher jsonObj:" + jSONObject);
        Bundle adaptJsonToBundle = adaptJsonToBundle(jSONObject);
        if (adaptJsonToBundle != null) {
            this.mNeedEvent = adaptJsonToBundle.getBoolean("needEvent", this.mNeedEvent);
            this.mNeedBGMEvent = adaptJsonToBundle.getBoolean("needBGMEvent", this.mNeedBGMEvent);
            String string = adaptJsonToBundle.getString("backgroundImage", "");
            if (!TextUtils.isEmpty(string) && BitmapFactory.decodeFile(string) == null) {
                adaptJsonToBundle.putString("backgroundImage", "");
                asyncProcessPauseImage(this.mContext, string);
            }
        }
        this.mWXLivePusherProxy.initLivePusher(null, adaptJsonToBundle);
        Surface surface = this.mSurface;
        if (surface != null) {
            setSurface(surface);
            setSurfaceSize(this.mSurfaceWidth, this.mSurfaceHeight);
        }
        this.mInited = true;
        QMLog.d(TAG, "initEmbeddedLivePusher: mInited = true");
        return new TXJSAdapterError();
    }

    public TXJSAdapterError initLivePusher(Object obj, JSONObject jSONObject) {
        QMLog.d(TAG, "initLivePusher tXCloudVideoView:" + obj + " , jsonObj = " + jSONObject);
        Bundle adaptJsonToBundle = adaptJsonToBundle(jSONObject);
        if (adaptJsonToBundle != null) {
            this.mNeedEvent = adaptJsonToBundle.getBoolean("needEvent", this.mNeedEvent);
            this.mNeedBGMEvent = adaptJsonToBundle.getBoolean("needBGMEvent", this.mNeedBGMEvent);
            String string = adaptJsonToBundle.getString("backgroundImage", "");
            if (!TextUtils.isEmpty(string) && BitmapFactory.decodeFile(string) == null) {
                adaptJsonToBundle.putString("backgroundImage", "");
                asyncProcessPauseImage(this.mContext, string);
            }
        }
        if (obj != null) {
            this.mWXLivePusherProxy.initLivePusher(obj, adaptJsonToBundle);
        } else {
            this.mWXLivePusherProxy.initLivePusher(null, adaptJsonToBundle);
            Surface surface = this.mSurface;
            if (surface != null) {
                setSurface(surface);
                setSurfaceSize(this.mSurfaceWidth, this.mSurfaceHeight);
            }
        }
        this.mInited = true;
        QMLog.d(TAG, "initLivePusher: mInited = true");
        return new TXJSAdapterError();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify
    public void onBGMComplete(int i3) {
        TXLivePushListenerReflect.OnBGMNotify onBGMNotify;
        this.mBGMPlaying = false;
        if (this.mNeedBGMEvent && (onBGMNotify = this.mBGMNotifyListener) != null) {
            onBGMNotify.onBGMComplete(i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify
    public void onBGMProgress(long j3, long j16) {
        TXLivePushListenerReflect.OnBGMNotify onBGMNotify;
        if (this.mNeedBGMEvent && (onBGMNotify = this.mBGMNotifyListener) != null) {
            onBGMNotify.onBGMProgress(j3, j16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify
    public void onBGMStart() {
        TXLivePushListenerReflect.OnBGMNotify onBGMNotify;
        this.mBGMPlaying = true;
        if (this.mNeedBGMEvent && (onBGMNotify = this.mBGMNotifyListener) != null) {
            onBGMNotify.onBGMStart();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXLivePushListener
    public void onNetStatus(Bundle bundle) {
        TXLivePushListenerReflect.ITXLivePushListener iTXLivePushListener = this.mLivePushListener;
        if (iTXLivePushListener != null) {
            iTXLivePushListener.onNetStatus(bundle);
        }
        if (QMLog.isColorLevel()) {
            String format = String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", "CPU:" + bundle.getString("CPU_USAGE"), "RES:" + bundle.getInt("VIDEO_WIDTH") + "*" + bundle.getInt("VIDEO_HEIGHT"), "SPD:" + bundle.getInt("NET_SPEED") + "Kbps", "JIT:" + bundle.getInt("NET_JITTER"), "FPS:" + bundle.getInt("VIDEO_FPS"), "GOP:" + bundle.getInt("VIDEO_GOP") + ReportConstant.COSTREPORT_PREFIX, "ARA:" + bundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + bundle.getInt("AUDIO_CACHE") + APLogFileUtil.SEPARATOR_LOG + bundle.getInt("VIDEO_CACHE") + "," + bundle.getInt("V_SUM_CACHE_SIZE") + "," + bundle.getInt("V_DEC_CACHE_SIZE") + APLogFileUtil.SEPARATOR_LOG + bundle.getInt("AV_RECV_INTERVAL") + "," + bundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", Float.valueOf(bundle.getFloat("AUDIO_CACHE_THRESHOLD"))).toString(), "VRA:" + bundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + bundle.getInt("AUDIO_DROP") + "|" + bundle.getInt("VIDEO_DROP"), "SVR:" + bundle.getString("SERVER_IP"), "AUDIO:" + bundle.getString("AUDIO_PLAY_INFO"));
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onNetStatus:");
            sb5.append(format);
            QMLog.d(TAG, sb5.toString());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXLivePushListener
    public void onPushEvent(int i3, Bundle bundle) {
        TXLivePushListenerReflect.ITXLivePushListener iTXLivePushListener;
        if (i3 == -1307 || i3 == -1313) {
            operateLivePusher("stop", null);
        }
        if (this.mNeedEvent && (iTXLivePushListener = this.mLivePushListener) != null) {
            iTXLivePushListener.onPushEvent(i3, bundle);
        }
        QMLog.d(TAG, "onPushEvent: event = " + i3 + " message = " + bundle.getString("EVT_MSG"));
    }

    public TXJSAdapterError operateLivePusher(String str, JSONObject jSONObject) {
        String str2;
        QMLog.d(TAG, "operateLivePusher param:" + jSONObject);
        if (str == null) {
            return new TXJSAdapterError(-1, "invalid params");
        }
        if (!this.mInited) {
            return new TXJSAdapterError(-3, "uninited livePusher");
        }
        if (jSONObject != null) {
            str2 = jSONObject.toString();
        } else {
            str2 = "";
        }
        QMLog.d(TAG, "operateLivePusher: type = " + str + " params = " + str2);
        TXJSAdapterError baseLivePusherOperate = baseLivePusherOperate(str, jSONObject);
        if (baseLivePusherOperate == null) {
            baseLivePusherOperate = cameraLivePusherOperate(str, jSONObject);
        }
        if (baseLivePusherOperate == null) {
            baseLivePusherOperate = bgmLivePusherOperate(str, jSONObject);
        }
        if (baseLivePusherOperate == null) {
            baseLivePusherOperate = otherLivePusherOperate(str, jSONObject);
        }
        if (baseLivePusherOperate == null) {
            return new TXJSAdapterError(-4, "invalid operate command");
        }
        return baseLivePusherOperate;
    }

    public void setBGMNotifyListener(TXLivePushListenerReflect.OnBGMNotify onBGMNotify) {
        this.mBGMNotifyListener = onBGMNotify;
    }

    public void setPushListener(TXLivePushListenerReflect.ITXLivePushListener iTXLivePushListener) {
        this.mLivePushListener = iTXLivePushListener;
    }

    public TXJSAdapterError setSurface(Surface surface) {
        QMLog.d(TAG, "setSurface surface:" + surface);
        this.mSurface = surface;
        this.mWXLivePusherProxy.setSurface(surface);
        return new TXJSAdapterError();
    }

    public TXJSAdapterError setSurfaceSize(int i3, int i16) {
        this.mSurfaceWidth = i3;
        this.mSurfaceHeight = i16;
        this.mWXLivePusherProxy.setSurfaceSize(i3, i16);
        return new TXJSAdapterError();
    }

    public int startDumpAudioData(String str) {
        return this.mWXLivePusherProxy.startDumpAudioData(str);
    }

    public void stopDumpAudioData() {
        this.mWXLivePusherProxy.stopDumpAudioData();
    }

    public void takePhoto(final boolean z16, final TXLivePushListenerReflect.ITXSnapshotListener iTXSnapshotListener) {
        if (this.mWXLivePusherProxy.isPushing()) {
            IWXLivePusherProxy iWXLivePusherProxy = this.mWXLivePusherProxy;
            iWXLivePusherProxy.snapshot(iWXLivePusherProxy.newITXSnapshotListener(new TXLivePushListenerReflect.ITXSnapshotListener() { // from class: com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter.1
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXSnapshotListener
                public void onSnapshot(Bitmap bitmap) {
                    QMLog.i(TXLivePusherJSAdapter.TAG, "onSnapshot -> bitmap:" + bitmap);
                    TXLivePushListenerReflect.ITXSnapshotListener iTXSnapshotListener2 = iTXSnapshotListener;
                    if (iTXSnapshotListener2 != null) {
                        if (z16) {
                            if (bitmap != null) {
                                int width = bitmap.getWidth();
                                int height = bitmap.getHeight();
                                Matrix matrix = new Matrix();
                                matrix.setScale(0.5f, 0.5f);
                                iTXSnapshotListener.onSnapshot(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false));
                                TXLivePusherJSAdapter.this.safeRecycleBitmap(bitmap);
                                return;
                            }
                            iTXSnapshotListener2.onSnapshot(bitmap);
                            return;
                        }
                        iTXSnapshotListener2.onSnapshot(bitmap);
                    }
                }
            }));
        }
    }

    public TXJSAdapterError unInitLivePusher() {
        if (!this.mInited) {
            return new TXJSAdapterError(-3, "uninited livePusher");
        }
        this.mWXLivePusherProxy.stopPusher();
        this.mWXLivePusherProxy.setPushListener(null);
        this.mInited = false;
        return new TXJSAdapterError();
    }

    public void updateCurHomeOrientation(String str) {
        QMLog.d(TAG, "updateCurHomeOrientation, orientation:" + str);
        adjustHomeOrientation(this.mLastAngle, str);
    }

    public TXJSAdapterError updateLivePusher(JSONObject jSONObject) {
        QMLog.d(TAG, "updateLivePusher jsonObject:" + jSONObject);
        Bundle adaptJsonToBundle = adaptJsonToBundle(jSONObject);
        if (adaptJsonToBundle != null) {
            this.mNeedEvent = adaptJsonToBundle.getBoolean("needEvent", this.mNeedEvent);
            this.mNeedBGMEvent = adaptJsonToBundle.getBoolean("needBGMEvent", this.mNeedBGMEvent);
            String string = adaptJsonToBundle.getString("backgroundImage", "");
            if (!TextUtils.isEmpty(string) && BitmapFactory.decodeFile(string) == null) {
                adaptJsonToBundle.putString("backgroundImage", "");
                asyncProcessPauseImage(this.mContext, string);
            }
        }
        this.mWXLivePusherProxy.updateLivePusher(adaptJsonToBundle);
        return new TXJSAdapterError();
    }

    public void updateHomeOrientation(IMiniAppContext iMiniAppContext) {
    }
}
