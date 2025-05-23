package com.tencent.mtt.hippy.adapter.http;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyHttpResponse {
    public static final Integer UNKNOWN_STATUS = -1;
    private InputStream mErrorStream;
    private InputStream mInputStream;
    private String mResponseMessage;
    private Integer mStatusCode = UNKNOWN_STATUS;
    private Map<String, List<String>> mRspHeaderMap = null;

    public void close() {
        InputStream inputStream = this.mInputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        InputStream inputStream2 = this.mErrorStream;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
        }
    }

    public InputStream getErrorStream() {
        return this.mErrorStream;
    }

    public String getHeaderField(String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (TextUtils.isEmpty(str) || (map = this.mRspHeaderMap) == null || (list = map.get(str)) == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public List<String> getHeaderFields(String str) {
        Map<String, List<String>> map;
        if (!TextUtils.isEmpty(str) && (map = this.mRspHeaderMap) != null) {
            return map.get(str);
        }
        return null;
    }

    public InputStream getInputStream() {
        return this.mInputStream;
    }

    public String getResponseMessage() {
        return this.mResponseMessage;
    }

    public Map<String, List<String>> getRspHeaderMaps() {
        return this.mRspHeaderMap;
    }

    public Integer getStatusCode() {
        Integer num = this.mStatusCode;
        if (num == null) {
            return UNKNOWN_STATUS;
        }
        return num;
    }

    public void setErrorStream(InputStream inputStream) {
        this.mErrorStream = inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    public void setResponseMessage(String str) {
        this.mResponseMessage = str;
    }

    public void setRspHeaderMap(Map<String, List<String>> map) {
        this.mRspHeaderMap = map;
    }

    public void setStatusCode(Integer num) {
        this.mStatusCode = num;
    }
}
