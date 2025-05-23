package com.tencent.gamecenter.wadl.sdk.checker;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlChecker {
    public static final String TAG = "Wadl_WadlChecker";
    ICheckListener checkListener;
    private final HashMap<String, WadlParams> checkMap = new HashMap<>();
    private final String methodGet = "GET";
    private final String keyRange = "Range";
    private final String keyConnection = "Connection";
    private final String paramsCIP = "cip";
    private final String headRangeValue = "bytes=0-1";
    private final String headConnCloseValue = "close";
    private final int connTimeOut = 10000;
    private final int readTimeOut = 10000;
    private final int maxRetryNum = 4;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface ICheckListener {
        void onCheckDone(WadlParams wadlParams, WadlCheckResult wadlCheckResult);
    }

    private void closeConn(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                httpURLConnection.getInputStream().close();
                QLog.d(TAG, 1, "close a connection, host=" + httpURLConnection.getURL().getHost());
            } catch (Exception e16) {
                QLog.e(TAG, 1, "close connection error", e16);
            }
        }
    }

    private String getHeaderInfo(HttpURLConnection httpURLConnection) {
        Map<String, List<String>> map;
        if (httpURLConnection != null) {
            map = httpURLConnection.getHeaderFields();
        } else {
            map = null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                    stringBuffer.append(" ");
                }
            }
        }
        return stringBuffer.toString();
    }

    private boolean isIPv6FromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("cip");
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            boolean isIPv6LiteralAddress = IPAddressUtil.isIPv6LiteralAddress(queryParameter);
            QLog.d(TAG, 4, "isIPv6FromUrl cipValue=" + queryParameter + ",isIpv6=" + isIPv6LiteralAddress);
            return isIPv6LiteralAddress;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "isIPv6FromUrl exception", e16);
            return false;
        }
    }

    private boolean isJumpCode(int i3) {
        if (i3 != 301 && i3 != 302 && i3 != 303 && i3 != 307) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f5, code lost:
    
        r10 = com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils.parseToLong(r7.getHeaderField("Content-Length"));
        r0.fileSize = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0106, code lost:
    
        if (r10 != (-1)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:
    
        r2 = r7;
        r6 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x014b A[EDGE_INSN: B:20:0x014b->B:21:0x014b BREAK  A[LOOP:0: B:2:0x000e->B:28:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[LOOP:0: B:2:0x000e->B:28:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WadlCheckResult syncGetCheckResult(WadlParams wadlParams) {
        HttpURLConnection httpURLConnection;
        IOException e16;
        int responseCode;
        WadlCheckResult wadlCheckResult = new WadlCheckResult();
        String str = wadlParams.apkUrl;
        HttpURLConnection httpURLConnection2 = null;
        String str2 = "";
        int i3 = 0;
        boolean z16 = false;
        while (true) {
            closeConn(httpURLConnection2);
            if (!wadlParams.isCancelRequest) {
                boolean isNetSupport = AppNetConnInfo.isNetSupport();
                i3++;
                QLog.d(TAG, 1, "send request isUseRange=" + z16 + ",isNetSupport= " + isNetSupport + ",retryCount= " + i3 + ",lastUrl=" + str);
                if (!isNetSupport) {
                    str2 = "no net connection";
                    break;
                }
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    if (z16) {
                        try {
                            httpURLConnection.addRequestProperty("Range", "bytes=0-1");
                        } catch (IOException e17) {
                            e16 = e17;
                            e16.printStackTrace();
                            str2 = e16.getMessage();
                            QLog.e(TAG, 1, "send request exception", e16);
                            httpURLConnection2 = httpURLConnection;
                            if (i3 < 4) {
                            }
                        }
                    }
                    httpURLConnection.addRequestProperty("Connection", "close");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                    QLog.d(TAG, 1, "send request statusCode=" + responseCode);
                } catch (IOException e18) {
                    httpURLConnection = httpURLConnection2;
                    e16 = e18;
                }
                if (responseCode != 206 && responseCode != 200) {
                    if (isJumpCode(responseCode)) {
                        str = httpURLConnection.getHeaderField("location");
                        if (TextUtils.isEmpty(str)) {
                            str2 = "forward location is empty";
                            QLog.e(TAG, 1, "send request 302 url is empty,header=" + getHeaderInfo(httpURLConnection));
                            break;
                        }
                    } else {
                        str2 = "statusCode=" + responseCode;
                    }
                    httpURLConnection2 = httpURLConnection;
                    if (i3 < 4) {
                        break;
                    }
                }
                wadlCheckResult.fileSize = WadlUtils.parseContentLengthFromRange(httpURLConnection.getHeaderField("Content-Range"));
                break;
            }
            break;
        }
        wadlCheckResult.isSucc = true;
        QLog.d(TAG, 1, "send request header=" + getHeaderInfo(httpURLConnection));
        httpURLConnection2 = httpURLConnection;
        if (!wadlCheckResult.isSucc) {
            wadlCheckResult.errMsg = str2;
        } else {
            wadlCheckResult.isIPv6 = isIPv6FromUrl(str);
        }
        QLog.d(TAG, 1, "send request finish, lastUrl=" + str + ",isUseRange=" + z16 + ",result=" + wadlCheckResult);
        closeConn(httpURLConnection2);
        return wadlCheckResult;
    }

    public void cancel(String str) {
        QLog.d(TAG, 1, "cancel resId=" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.checkMap) {
            WadlParams wadlParams = this.checkMap.get(str);
            if (wadlParams != null) {
                wadlParams.isCancelRequest = true;
                this.checkMap.remove(str);
            }
        }
    }

    public void check(final WadlParams wadlParams) {
        if (wadlParams == null) {
            return;
        }
        final String resId = wadlParams.getResId();
        if (TextUtils.isEmpty(resId)) {
            return;
        }
        QLog.d(TAG, 1, "check checkMap size=" + this.checkMap.size());
        synchronized (this.checkMap) {
            if (this.checkMap.containsKey(resId)) {
                return;
            }
            this.checkMap.put(resId, wadlParams);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.sdk.checker.WadlChecker.1
                @Override // java.lang.Runnable
                public void run() {
                    ICheckListener iCheckListener;
                    WadlCheckResult syncGetCheckResult = WadlChecker.this.syncGetCheckResult(wadlParams);
                    if (!wadlParams.isCancelRequest && (iCheckListener = WadlChecker.this.checkListener) != null) {
                        iCheckListener.onCheckDone(wadlParams, syncGetCheckResult);
                    }
                    synchronized (WadlChecker.this.checkMap) {
                        WadlChecker.this.checkMap.remove(resId);
                    }
                }
            }, 128, null, false);
        }
    }

    public void clearCheckListener() {
        this.checkListener = null;
    }

    public void onDestroy() {
        QLog.d(TAG, 1, "cancelAll");
        clearCheckListener();
        synchronized (this.checkMap) {
            Iterator<Map.Entry<String, WadlParams>> it = this.checkMap.entrySet().iterator();
            while (it.hasNext()) {
                WadlParams value = it.next().getValue();
                if (value != null) {
                    value.isCancelRequest = true;
                    it.remove();
                }
            }
        }
    }

    public void setCheckListener(ICheckListener iCheckListener) {
        this.checkListener = iCheckListener;
    }
}
