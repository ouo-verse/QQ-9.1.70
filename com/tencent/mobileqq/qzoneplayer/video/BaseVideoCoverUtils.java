package com.tencent.mobileqq.qzoneplayer.video;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoCoverOpenTrafficText;
import com.tencent.oskplayer.util.PlayerUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class BaseVideoCoverUtils {
    public static volatile BaseVideoCoverUtils sInstance;
    public HandlerThread mCoverHandlerThread;

    public BaseVideoCoverUtils() {
        getCoverThread();
    }

    public static synchronized BaseVideoCoverUtils getInstance() {
        BaseVideoCoverUtils baseVideoCoverUtils;
        synchronized (BaseVideoCoverUtils.class) {
            if (sInstance == null) {
                synchronized (BaseVideoCoverUtils.class) {
                    if (sInstance == null) {
                        sInstance = new BaseVideoCoverUtils();
                    }
                }
            }
            baseVideoCoverUtils = sInstance;
        }
        return baseVideoCoverUtils;
    }

    public static VideoCoverOpenTrafficText parseOpenTrafficText(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new VideoCoverOpenTrafficText(jSONObject.getString("normal"), jSONObject.getString("underline"));
        } catch (JSONException e16) {
            PlayerUtils.log(5, "BaseVideoCoverUtils", "parseOpenTrafficText" + PlayerUtils.getPrintableStackTrace(e16));
            return null;
        }
    }

    public HandlerThread getCoverThread() {
        if (this.mCoverHandlerThread == null) {
            this.mCoverHandlerThread = new HandlerThread("BaseVideoCover_RealTime_HandlerThread");
        }
        if (!this.mCoverHandlerThread.isAlive()) {
            this.mCoverHandlerThread.start();
        }
        return this.mCoverHandlerThread;
    }
}
