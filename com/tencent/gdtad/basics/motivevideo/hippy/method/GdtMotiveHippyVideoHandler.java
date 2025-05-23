package com.tencent.gdtad.basics.motivevideo.hippy.method;

import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtMotiveHippyVideoHandler implements DKMethodHandler {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<om0.c> f109010d;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    private @interface PlayerEventId {
        public static final int COMPLETE = 4;
        public static final int ERROR = 5;
        public static final int PAUSE = 2;
        public static final int RESUME = 3;
        public static final int START = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    private @interface VideoPlayerEvent {
        public static final String ON_PLAY_STATUS_CHANGED = "onPlayStatusChanged";
    }

    public GdtMotiveHippyVideoHandler(WeakReference<om0.c> weakReference) {
        this.f109010d = weakReference;
    }

    private void a(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        om0.c cVar;
        QLog.i("GdtMotiveHippyVideoHandler: ", 1, "[handleVideoPlayStatusChanged] params: " + AdJSONUtil.toString(jSONObject));
        int optInt = AdJSONUtil.optInt(jSONObject, "eventId", Integer.MIN_VALUE);
        WeakReference<om0.c> weakReference = this.f109010d;
        if (weakReference != null) {
            cVar = weakReference.get();
        } else {
            cVar = null;
        }
        if (cVar != null) {
            if (optInt != 1) {
                if (optInt != 2) {
                    if (optInt != 3) {
                        if (optInt != 4) {
                            if (optInt == 5) {
                                cVar.a();
                            }
                        } else {
                            cVar.onAdPlayComplete();
                        }
                    } else {
                        cVar.onAdPlayResume();
                    }
                } else {
                    cVar.onAdPlayPause();
                }
            } else {
                cVar.onAdPlayStart();
            }
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public String getModuleId() {
        return "VideoPlayer";
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public boolean invoke(DKEngine dKEngine, String str, JSONObject jSONObject, DKMethodHandler.Callback callback) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("GdtMotiveHippyVideoHandler: ", 1, "[invoke] error, methodName is empty");
            return false;
        }
        QLog.i("GdtMotiveHippyVideoHandler: ", 1, "[invoke] methodName:" + str + " params:" + AdJSONUtil.toString(jSONObject));
        str.hashCode();
        if (!str.equals("onPlayStatusChanged")) {
            return false;
        }
        a(jSONObject, callback);
        return true;
    }
}
