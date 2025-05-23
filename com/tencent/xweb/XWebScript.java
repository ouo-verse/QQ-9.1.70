package com.tencent.xweb;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskCacheData;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebScript {
    public static final int CACHE_OPTION_CODE_CACHE_IN_MEN = 512;
    public static final int CACHE_OPTION_FLAG_CACHE_UTF16 = 256;
    public static final int CACHE_OPTION_JS_SRC_IN_MEM = 1024;
    public static final int CODE_CACHE_COMPILE_MODE_FULL = 3;
    public static final int CODE_CACHE_COMPILE_MODE_NONE = 0;
    public static final int CODE_CACHE_COMPILE_MODE_NORMAL = 2;
    public static final int CODE_CACHE_COMPILE_MODE_SIMPLE = 1;
    public static final String JS_CODE_CACHE_COMPILE_MODE_FULL = "fullcache";
    public static final String JS_CODE_CACHE_COMPILE_MODE_NONE = "nocache";
    public static final String JS_CODE_CACHE_COMPILE_MODE_NORMAL = "normalcache";
    public static final String JS_CODE_CACHE_COMPILE_MODE_SIMPLE = "simplecache";

    /* renamed from: a, reason: collision with root package name */
    public int f385071a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f385072b;

    /* renamed from: c, reason: collision with root package name */
    public String f385073c;

    /* renamed from: d, reason: collision with root package name */
    public String f385074d;

    /* renamed from: e, reason: collision with root package name */
    public String f385075e;

    /* renamed from: f, reason: collision with root package name */
    public String f385076f;

    /* renamed from: g, reason: collision with root package name */
    public String f385077g;

    /* renamed from: h, reason: collision with root package name */
    public int f385078h;

    /* renamed from: i, reason: collision with root package name */
    public long f385079i;

    /* renamed from: j, reason: collision with root package name */
    public int f385080j;

    /* renamed from: k, reason: collision with root package name */
    public String f385081k;

    /* renamed from: l, reason: collision with root package name */
    public WebView f385082l;

    public XWebScript(int i3, int i16, WebView webView) {
        this.f385078h = 0;
        setCacheMode(i3);
        this.f385078h = i16;
        this.f385082l = webView;
    }

    public void a(String str, String str2) {
        this.f385073c = str;
        this.f385072b = str2;
    }

    public boolean checkValid() {
        WebView webView = this.f385082l;
        if (webView != null && webView.supportFeature(2002)) {
            if (TextUtils.isEmpty(this.f385073c)) {
                x0.c("XWebScript", "checkValid failed jsSrcValue invalid = " + this.f385073c);
                return false;
            }
            if (TextUtils.isEmpty(this.f385072b)) {
                x0.c("XWebScript", "checkValid failed jsSrcKind invalid = " + this.f385072b);
                return false;
            }
            if (this.f385071a >= 0) {
                long j3 = this.f385079i;
                if (j3 != 0 && this.f385080j <= 0) {
                    x0.c("XWebScript", "checkValid failed bufferSize invalid = " + this.f385080j);
                    return false;
                }
                if (this.f385080j != 0 && j3 == 0) {
                    x0.c("XWebScript", "checkValid failed bufferAddr invalid = " + this.f385079i);
                    return false;
                }
                if (!TextUtils.isEmpty(this.f385077g) && !this.f385082l.supportFeature(2008)) {
                    x0.c("XWebScript", "not support jsparam as file path, apk ver = " + XWalkEnvironment.getAvailableVersion());
                    return false;
                }
                return true;
            }
            x0.c("XWebScript", "checkValid failed compile mode invalid = " + this.f385071a);
        }
        return false;
    }

    public void execute() {
        this.f385078h &= MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
        this.f385082l.evaluateJavascript(toString(), null);
    }

    public void setCacheKey(String str) {
        this.f385074d = str;
    }

    public void setCacheMode(String str) {
        if ("nocache".equals(str)) {
            setCacheMode(0);
            return;
        }
        if (JS_CODE_CACHE_COMPILE_MODE_SIMPLE.equals(str)) {
            setCacheMode(1);
        } else if (JS_CODE_CACHE_COMPILE_MODE_NORMAL.equals(str)) {
            setCacheMode(2);
        } else if (JS_CODE_CACHE_COMPILE_MODE_FULL.equals(str)) {
            setCacheMode(3);
        }
    }

    public void setCacheOption(int i3) {
        this.f385078h = i3;
    }

    public void setFallBackLogic(String str) {
        this.f385076f = str;
    }

    public void setJsFilename(String str) {
        this.f385081k = str;
    }

    public void setJsParamAsBuffer(long j3, int i3) {
        this.f385079i = j3;
        this.f385080j = i3;
    }

    public void setJsParamAsFilePath(String str) {
        this.f385077g = str;
    }

    public void setJsSrcAsPath(String str) {
        a(str, "path");
    }

    public void setJsSrcAsRawString(String str) {
        a(str, HippyControllerProps.STRING);
    }

    public String toString() {
        if (!checkValid()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder("//XWEB_SCRIPT:");
        JSONStringer jSONStringer = new JSONStringer();
        try {
            if (this.f385082l.supportFeature(2011)) {
                this.f385078h |= 2048;
            }
            JSONStringer value = jSONStringer.object().key("compile_mode").value(this.f385071a).key("cache_option").value(this.f385078h).key("js_src_kind").value(this.f385072b).key("js_src").value(this.f385073c);
            if (!TextUtils.isEmpty(this.f385074d)) {
                value = value.key(QCircleReportOutboxTaskCacheData.Columns.CACHE_KEY).value(this.f385074d);
            }
            if (!TextUtils.isEmpty(this.f385075e)) {
                value = value.key("append_script").value(this.f385075e);
            }
            if (!TextUtils.isEmpty(this.f385077g)) {
                value = value.key("js_param_kind").value("path").key("js_param").value(this.f385077g);
            } else if (this.f385079i != 0 && this.f385080j != 0) {
                value = value.key("js_param_kind").value("buffer").key("js_param").value(Long.toHexString(this.f385079i)).key("js_param_length").value(this.f385080j);
            }
            if (!TextUtils.isEmpty(this.f385081k)) {
                value = value.key("js_filename").value(this.f385081k);
            }
            value.endObject();
            sb5.append(value.toString());
            WebView webView = this.f385082l;
            if (webView != null && webView.supportFeature(2004)) {
                sb5.append("XWEB_SCRIPT_END\n\r" + this.f385076f);
            }
        } catch (Throwable th5) {
            x0.a("XWebScript", "xweb script create failed, error", th5);
        }
        return sb5.toString();
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class XWebScriptPerformance {

        /* renamed from: a, reason: collision with root package name */
        public String f385086a = "";

        /* renamed from: b, reason: collision with root package name */
        public JSONObject f385087b;

        public XWebScriptPerformance(String str) {
            if (str == null) {
                return;
            }
            try {
                this.f385087b = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }

        public long a(String str, long j3) {
            JSONObject jSONObject = this.f385087b;
            if (jSONObject == null) {
                return j3;
            }
            try {
                return jSONObject.getLong(str);
            } catch (JSONException unused) {
                return j3;
            }
        }

        public long getCompileCost() {
            return a("compile_cost", -1L);
        }

        public long getRunCost() {
            return a("run_cost", -1L);
        }

        public String getScriptRet() {
            JSONObject jSONObject = this.f385087b;
            if (jSONObject == null) {
                return this.f385086a;
            }
            try {
                return jSONObject.getString("script_ret");
            } catch (JSONException unused) {
                return this.f385086a;
            }
        }

        public boolean getUseCodeCache() {
            return a("use_code_cache", false);
        }

        public long getV8StrCost() {
            return a("v8str_cost", -1L);
        }

        public String toString() {
            JSONObject jSONObject = this.f385087b;
            if (jSONObject == null) {
                return this.f385086a;
            }
            return jSONObject.toString();
        }

        public boolean a(String str, boolean z16) {
            JSONObject jSONObject = this.f385087b;
            if (jSONObject == null) {
                return z16;
            }
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
                return z16;
            }
        }
    }

    public void setJsSrcAsPath(String str, String str2) {
        a(str, "path");
        this.f385075e = str2;
    }

    public void execute(ValueCallback<String> valueCallback) {
        this.f385078h &= MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
        this.f385082l.evaluateJavascript(toString(), valueCallback);
    }

    public void execute(final ValueCallback<String> valueCallback, final ValueCallback<XWebScriptPerformance> valueCallback2) {
        if (!this.f385082l.supportFeature(2011)) {
            execute(valueCallback);
            x0.d("XWebScript", "current xweb version not support xweb script performance dump");
        } else {
            if (valueCallback2 != null) {
                this.f385078h |= 2048;
            }
            this.f385082l.evaluateJavascript(toString(), new ValueCallback<String>() { // from class: com.tencent.xweb.XWebScript.1
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                    String str2;
                    if (valueCallback2 != null) {
                        XWebScriptPerformance xWebScriptPerformance = new XWebScriptPerformance(str);
                        valueCallback2.onReceiveValue(xWebScriptPerformance);
                        str2 = xWebScriptPerformance.getScriptRet();
                    } else {
                        str2 = str;
                    }
                    ValueCallback valueCallback3 = valueCallback;
                    if (valueCallback3 != null) {
                        valueCallback3.onReceiveValue(str2);
                    }
                    x0.d("XWebScript", "andrewu excute js , ret = " + str);
                }
            });
        }
    }

    public void setCacheMode(int i3) {
        this.f385071a = i3;
    }
}
