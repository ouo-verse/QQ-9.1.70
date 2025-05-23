package com.tencent.mtt.hippy.adapter.http;

import android.os.Build;
import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyHttpRequest {
    public static final int DEFAULT_TIMEOUT_MS = 3000;
    private static String USER_AGENT;
    private String mBody;

    @Nullable
    private HippyMap mInitParams;

    @Nullable
    private Map<String, Object> mNativeParams;

    @Nullable
    private HippyArray mRequestCookies;
    private String mUrl;
    private int mConnectTimeout = 3000;
    private int mReadTimeout = 3000;
    private boolean mUseCaches = true;
    private String mMethod = "GET";
    private boolean mInstanceFollowRedirects = false;
    private final Map<String, Object> mHeaderMap = new HashMap();

    public HippyHttpRequest() {
        initUserAgent();
        String str = USER_AGENT;
        if (str != null) {
            addHeader("User-Agent", str);
        } else {
            System.err.println("user_agent is null!");
        }
    }

    private void initUserAgent() {
        if (USER_AGENT == null) {
            Locale locale = Locale.getDefault();
            StringBuffer stringBuffer = new StringBuffer();
            String str = Build.VERSION.RELEASE;
            if (str.length() <= 0) {
                str = "1.0";
            }
            stringBuffer.append(str);
            stringBuffer.append("; ");
            stringBuffer.append(locale.getLanguage().toLowerCase());
            String country = locale.getCountry();
            stringBuffer.append("-");
            stringBuffer.append(country.toLowerCase());
            USER_AGENT = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Mobile Safari/533.1", stringBuffer);
        }
    }

    public void addHeader(String str, String str2) {
        this.mHeaderMap.put(str, str2);
    }

    public String getBody() {
        return this.mBody;
    }

    public int getConnectTimeout() {
        return this.mConnectTimeout;
    }

    public Map<String, Object> getHeaders() {
        return this.mHeaderMap;
    }

    @Nullable
    public HippyMap getInitParams() {
        return this.mInitParams;
    }

    public String getMethod() {
        return this.mMethod;
    }

    @Nullable
    public Map<String, Object> getNativeParams() {
        return this.mNativeParams;
    }

    public int getReadTimeout() {
        return this.mReadTimeout;
    }

    @Nullable
    public HippyArray getRequestCookies() {
        return this.mRequestCookies;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isInstanceFollowRedirects() {
        return this.mInstanceFollowRedirects;
    }

    public boolean isUseCaches() {
        return this.mUseCaches;
    }

    public void setBody(String str) {
        this.mBody = str;
    }

    public void setConnectTimeout(int i3) {
        this.mConnectTimeout = i3;
    }

    public void setInitParams(@Nullable HippyMap hippyMap) {
        this.mInitParams = hippyMap;
    }

    public void setInstanceFollowRedirects(boolean z16) {
        this.mInstanceFollowRedirects = z16;
    }

    public void setMethod(String str) {
        this.mMethod = str;
    }

    public void setNativeParams(@Nullable Map<String, Object> map) {
        this.mNativeParams = map;
    }

    public void setReadTimeout(int i3) {
        this.mReadTimeout = i3;
    }

    public void setRequestCookies(@Nullable HippyArray hippyArray) {
        this.mRequestCookies = hippyArray;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void setUseCaches(boolean z16) {
        this.mUseCaches = z16;
    }

    public void addHeader(String str, List<String> list) {
        this.mHeaderMap.put(str, list);
    }
}
