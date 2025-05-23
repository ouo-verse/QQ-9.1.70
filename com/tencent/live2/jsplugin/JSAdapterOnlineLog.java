package com.tencent.live2.jsplugin;

import android.text.TextUtils;
import com.tencent.liteav.base.logger.OnlineLoggerAndroid;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.live2.impl.V2TXLiveUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.URLDecoder;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JSAdapterOnlineLog {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "JSAdapterOnlineLog";
    private static volatile JSAdapterOnlineLog instance;
    private OnlineLoggerAndroid.a mBusinessName;
    private boolean mIsInitted;
    private OnlineLoggerAndroid.b mLoggerLevel;
    private ConcurrentLinkedQueue<String> mLoggerQueue;
    private int mMaxCacheLogNumber;
    private OnlineLoggerAndroid mOnlineLogger;
    private String mRoomId;
    private int mSDkAppId;
    private String mUserId;

    JSAdapterOnlineLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLoggerLevel = OnlineLoggerAndroid.b.kApi;
        this.mMaxCacheLogNumber = 10;
        this.mIsInitted = false;
        this.mBusinessName = OnlineLoggerAndroid.a.kLive;
        this.mSDkAppId = 0;
        this.mRoomId = "";
        this.mUserId = "";
        this.mLoggerQueue = new ConcurrentLinkedQueue<>();
    }

    private boolean checkNeedInit(OnlineLoggerAndroid.a aVar, int i3, String str, String str2) {
        if (this.mBusinessName == aVar && this.mSDkAppId == i3 && this.mRoomId.equals(str) && this.mUserId.equals(str2)) {
            return false;
        }
        return true;
    }

    public static JSAdapterOnlineLog getInstance() {
        if (instance == null) {
            synchronized (JSAdapterOnlineLog.class) {
                if (instance == null) {
                    instance = new JSAdapterOnlineLog();
                }
            }
        }
        return instance;
    }

    private void insertCacheLog(String str) {
        while (this.mLoggerQueue.size() >= this.mMaxCacheLogNumber) {
            this.mLoggerQueue.poll();
        }
        this.mLoggerQueue.add(str);
    }

    private void reportCacheLog() {
        if (this.mLoggerQueue.isEmpty()) {
            return;
        }
        while (!this.mLoggerQueue.isEmpty()) {
            this.mOnlineLogger.log(this.mLoggerLevel, this.mLoggerQueue.poll());
        }
    }

    public synchronized void log(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.mIsInitted) {
                this.mOnlineLogger.log(this.mLoggerLevel, str);
            } else {
                insertCacheLog(str);
            }
        }
    }

    public synchronized void updateUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            OnlineLoggerAndroid onlineLoggerAndroid = this.mOnlineLogger;
            if (onlineLoggerAndroid != null) {
                onlineLoggerAndroid.destroy();
            }
            this.mOnlineLogger = null;
            this.mIsInitted = false;
            this.mBusinessName = OnlineLoggerAndroid.a.kLive;
            this.mSDkAppId = 0;
            this.mRoomId = "";
            this.mUserId = "";
            return;
        }
        try {
            String decode = URLDecoder.decode(str, "UTF-8");
            OnlineLoggerAndroid.a aVar = OnlineLoggerAndroid.a.kLive;
            if (decode.startsWith(V2TXLiveUtils.TRTC_ADDRESS1) || decode.startsWith(V2TXLiveUtils.TRTC_ADDRESS2) || decode.startsWith("trtc://")) {
                aVar = OnlineLoggerAndroid.a.kTRTC;
            }
            String str2 = "0";
            String str3 = "";
            String str4 = "";
            if (decode.startsWith("rtmp")) {
                str3 = LiveURLParser.getStreamId(decode);
                str4 = LiveURLParser.getStreamId(decode);
            } else if (decode.startsWith("trtc://")) {
                str2 = LiveURLParser.getURLParams(decode, "sdkappid");
                str4 = LiveURLParser.getURLParams(decode, "userId");
                str3 = LiveURLParser.getStreamId(decode);
            } else if (decode.startsWith("room://")) {
                str2 = LiveURLParser.getURLParams(decode, "sdkappid");
                str3 = LiveURLParser.getURLParams(decode, "roomid");
                str4 = LiveURLParser.getURLParams(decode, "userid");
            }
            int parseInt = Integer.parseInt(str2);
            if (!checkNeedInit(aVar, parseInt, str3, str4)) {
                return;
            }
            OnlineLoggerAndroid onlineLoggerAndroid2 = this.mOnlineLogger;
            if (onlineLoggerAndroid2 != null) {
                onlineLoggerAndroid2.destroy();
                this.mOnlineLogger = null;
            }
            this.mBusinessName = aVar;
            this.mSDkAppId = parseInt;
            this.mRoomId = str3;
            this.mUserId = str4;
            this.mOnlineLogger = new OnlineLoggerAndroid(aVar, parseInt, str3, str4);
            this.mIsInitted = true;
            reportCacheLog();
        } catch (Exception unused) {
            LiteavLog.e(TAG, "updateUrl fail, url:".concat(String.valueOf(str)));
        }
    }
}
