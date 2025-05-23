package com.tencent.mobileqq.webview.webso;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpVersion;
import org.apache.httpcore.HttpHeaders;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
/* loaded from: classes20.dex */
public class HttpRequestPackage {
    static IPatchRedirector $redirector_ = null;
    private static final String CRLF = "\r\n";
    public String accept_Charset;
    public String accept_Encoding;
    public String accept_Language;
    public String content_length;
    public String content_type;
    public String cookie;
    public String entity_body;
    public String expect;
    public String extendHeaderJsonStr;
    public String host;
    public String if_Match;
    public String if_Modified_Since;
    public String if_None_Match;
    public String if_Range;
    public String if_Unmodified_Since;
    public String method;
    public String no_Chunked;
    public String range;
    public String uri;
    public String user_Agent;
    public String web_page_version;

    public HttpRequestPackage(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.user_Agent = str;
            this.entity_body = "";
        }
    }

    private String addExtHeader(StringBuilder sb5, String str) {
        if (sb5 == null) {
            sb5 = new StringBuilder();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            new ArrayList();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                addHeaderItem(sb5, str2, jSONObject.getString(str2));
            }
            return sb5.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private StringBuilder addHeaderItem(StringBuilder sb5, String str, String str2) {
        if (sb5 == null) {
            sb5 = new StringBuilder();
        }
        if (str2 != null && str2.length() > 0) {
            sb5.append(str);
            sb5.append(MsgSummary.STR_COLON);
            sb5.append(str2);
            sb5.append("\r\n");
        }
        return sb5;
    }

    private String getRequest_Line() {
        return this.method + " " + this.uri + " " + HttpVersion.HTTP_1_1 + "\r\n";
    }

    private void put(String str, String str2, String str3) {
        if (str2 == null || str2.length() == 0) {
            if (str3 != null && str3.length() != 0) {
                str2 = str3;
            } else {
                return;
            }
        }
        try {
            Field declaredField = HttpRequestPackage.class.getDeclaredField(str);
            if (str.equals(LayoutAttrDefine.CLICK_URI)) {
                setUri(str2);
            } else if (declaredField != null) {
                declaredField.set(this, str2);
            }
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
        }
    }

    public void addHeader(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.extendHeaderJsonStr = str;
        }
    }

    public String getBodyString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.entity_body;
    }

    public String getHeaderString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(getRequest_Line());
        addHeaderItem(sb5, HttpHeaders.ACCEPT_CHARSET, this.accept_Charset);
        addHeaderItem(sb5, "Accept-Encoding", this.accept_Encoding);
        addHeaderItem(sb5, "Accept-Language", this.accept_Language);
        addHeaderItem(sb5, "Expect", this.expect);
        addHeaderItem(sb5, "Host", this.host);
        addHeaderItem(sb5, HttpHeaders.IF_MATCH, this.if_Match);
        addHeaderItem(sb5, "If-Modified-Since", this.if_Modified_Since);
        addHeaderItem(sb5, "If-None-Match", this.if_None_Match);
        addHeaderItem(sb5, HttpHeaders.IF_RANGE, this.if_Range);
        addHeaderItem(sb5, HttpHeaders.IF_UNMODIFIED_SINCE, this.if_Unmodified_Since);
        addHeaderItem(sb5, "Range", this.range);
        addHeaderItem(sb5, "User-Agent", this.user_Agent);
        addHeaderItem(sb5, "Content-Type", this.content_type);
        addHeaderItem(sb5, "Content-Length", this.content_length);
        addHeaderItem(sb5, "webso-page-version", this.web_page_version);
        addHeaderItem(sb5, "Cookie", this.cookie);
        addHeaderItem(sb5, "No-Chunked", this.no_Chunked);
        if (!TextUtils.isEmpty(this.extendHeaderJsonStr)) {
            addExtHeader(sb5, this.extendHeaderJsonStr);
        }
        return sb5.toString();
    }

    public void readFromJson(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
            return;
        }
        readFromJson(jSONObject, "method", "GET");
        readFromJson(jSONObject, LayoutAttrDefine.CLICK_URI, null);
        readFromJson(jSONObject, "accept_Charset", "utf-8");
        readFromJson(jSONObject, "accept_Encoding", "");
        readFromJson(jSONObject, "accept_Language", "zh-CN,zh;");
        readFromJson(jSONObject, TencentMapServiceProtocol.SERVICE_NAME_AUTHORIZATION, null);
        readFromJson(jSONObject, "expect", null);
        readFromJson(jSONObject, "if_Match", null);
        readFromJson(jSONObject, "if_Modified_Since", null);
        readFromJson(jSONObject, "if_None_Match", null);
        readFromJson(jSONObject, "if_Range", null);
        readFromJson(jSONObject, "if_Unmodified_Since", null);
        readFromJson(jSONObject, DownloaderConstant.KEY_RANGE, null);
        readFromJson(jSONObject, "cookie", null);
        readFromJson(jSONObject, "entity_body", null);
        readFromJson(jSONObject, "content_type", null);
        readFromJson(jSONObject, "content_length", null);
        readFromJson(jSONObject, "no_Chunked", null);
        readFromJson(jSONObject, "web_page_version", null);
    }

    public void setUri(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.host = Uri.parse(str).getHost();
            this.uri = str;
        }
    }

    public HttpRequestPackage(String str, JSONObject jSONObject) {
        this(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            readFromJson(jSONObject);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) jSONObject);
        }
    }

    private void readFromJson(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null || str == null || str.length() <= 0) {
            return;
        }
        try {
            put(str, jSONObject.getString(str), str2);
        } catch (JSONException unused) {
            put(str, null, str2);
        } catch (Throwable th5) {
            put(str, null, str2);
            throw th5;
        }
    }
}
