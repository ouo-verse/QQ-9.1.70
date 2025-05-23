package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.b;
import jv2.c;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a {
    public static final String JAVASCRIPT_PREFIX = "javascript:";
    public static final String JSAPI_JS_EVENT_HANDLER = "_handleMessageFromQQLive";
    public static final String RESULT_ERROR_PARAM = "{\"errCode\":1, \"errMsg\":\"param error\", \"result\":{}}";
    public static final String RESULT_FORMAT = "{\"errCode\":%d, \"errMsg\":\"%s\", \"result\":%s}";
    public static final String RESULT_NORMAL = "{\"errCode\":0, \"errMsg\":\"\", \"result\":{}}";
    private static final String TAG = "QAdBaseJsApi";
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.a mJsApiContainer;
    private b mJsBridge;

    public a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.a aVar, b bVar) {
        this.mJsApiContainer = aVar;
        this.mJsBridge = bVar;
    }

    public static void callbackParamError(c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            cVar.a(RESULT_ERROR_PARAM);
        } catch (Throwable th5) {
            n.c(TAG, th5);
        }
    }

    public static void callbackSuccessToH5(c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            cVar.a(RESULT_NORMAL);
        } catch (Throwable th5) {
            n.c(TAG, th5);
        }
    }

    public static void callbackToH5(c cVar, int i3, String str, String str2) {
        if (cVar == null) {
            return;
        }
        try {
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = str;
            if (TextUtils.isEmpty(str2)) {
                str2 = "{}";
            }
            objArr[2] = str2;
            cVar.a(String.format(RESULT_FORMAT, objArr));
        } catch (Throwable th5) {
            n.c(TAG, th5);
        }
    }

    public com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.a getJsApiContainer() {
        return this.mJsApiContainer;
    }

    public b getJsBridge() {
        return this.mJsBridge;
    }

    public void publishMessageToH5(jv2.b bVar) {
        if (bVar == null) {
            return;
        }
        String str = "javascript:TenvideoJSBridge._handleMessageFromQQLive(" + bVar.toString() + ")";
        b bVar2 = this.mJsBridge;
        if (bVar2 != null) {
            bVar2.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callbackToH5(c cVar, String str) {
        if (cVar == null) {
            return;
        }
        try {
            cVar.a(str);
        } catch (Throwable th5) {
            n.c(TAG, th5);
        }
    }
}
