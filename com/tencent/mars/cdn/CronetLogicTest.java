package com.tencent.mars.cdn;

import android.os.Environment;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CronetLogicTest {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MicroMsg.CronetLogicTest";
    private static final String mUserAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36";
    private static final String testUrl = "https://stream.weixin.qq.com/weapp/SendMsg";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class callback implements CronetLogic.CronetTaskCallback {
        static IPatchRedirector $redirector_;
        private final String TAG;

        public callback(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.TAG = "CronetLogicTest." + str;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetReceiveChunkedData(CronetLogic.ChunkedData chunkedData, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, chunkedData, Long.valueOf(j3));
                return;
            }
            w.a(this.TAG, "onCronetReceiveChunkedData, length:" + j3 + ", data:" + chunkedData.data.length);
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public int onCronetReceiveHeader(CronetLogic.ResponseHeader responseHeader, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, this, responseHeader, Integer.valueOf(i3), str)).intValue();
            }
            StringBuilder sb5 = new StringBuilder();
            for (CronetLogic.HeaderMap headerMap : responseHeader.headers) {
                sb5.append("{");
                sb5.append(headerMap.key);
                sb5.append(":");
                sb5.append(headerMap.value);
                sb5.append("},");
            }
            w.a(this.TAG, "onCronetReceiveHeader, headers:" + ((Object) sb5) + ", statusCode " + i3 + ", protocol:" + str);
            return 0;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetReceiveUploadProgress(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            w.a(this.TAG, "onCronetReceiveUploadProgress, current:" + j3 + ", total" + j16);
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetTaskCompleted(String str, CronetLogic.CronetTaskResult cronetTaskResult, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, cronetTaskResult, str2);
                return;
            }
            w.a(this.TAG, "onCronetTaskCompleted, filekey:" + str + ", errorCode:" + cronetTaskResult.errorCode + ", errorMsg:" + cronetTaskResult.errorMsg + ", data: " + cronetTaskResult.getDataString() + ", totalWriteByte:" + cronetTaskResult.totalWriteByte + ", totalReceiveByte:" + cronetTaskResult.totalReceiveByte + ", totalSendByte:" + cronetTaskResult.totalSendByte);
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onDownloadProgressChanged(String str, CronetLogic.CronetDownloadProgress cronetDownloadProgress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) cronetDownloadProgress);
                return;
            }
            w.a(this.TAG, "onDownloadProgressChanged, totalByte:" + cronetDownloadProgress.totalByte + ", currentWriteByte:" + cronetDownloadProgress.currentWriteByte);
        }
    }

    public CronetLogicTest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void cronetDebugTest() {
        testChunk();
        testUpload();
        testIp();
        testCellular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$testSimpleDns$0(String str) {
        w.a("CronetLogicTest", "simple dns callback is being called");
        return new String[0];
    }

    private static void testCellular() {
        CronetLogic.CronetRequestParams cronetRequestParams = new CronetLogic.CronetRequestParams();
        cronetRequestParams.taskType = 1;
        cronetRequestParams.url = "https://www.cip.cc/";
        cronetRequestParams.forceBindMobileNetwork = true;
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", mUserAgent);
        cronetRequestParams.makeRequestHeader(hashMap);
        CronetLogic.startCronetHttpTask(cronetRequestParams, new callback("testCellular"));
    }

    private static void testChunk() {
        CronetLogic.CronetRequestParams cronetRequestParams = new CronetLogic.CronetRequestParams();
        cronetRequestParams.taskType = 10;
        cronetRequestParams.url = "https://www.httpwatch.com/httpgallery/chunked/chunkedimage.aspx";
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", mUserAgent);
        cronetRequestParams.makeRequestHeader(hashMap);
        CronetLogic.startCronetHttpTask(cronetRequestParams, new callback("testChunk"));
    }

    private static void testIp() {
        CronetLogic.CronetRequestParams cronetRequestParams = new CronetLogic.CronetRequestParams();
        cronetRequestParams.taskType = 1;
        cronetRequestParams.url = "https://www.cip.cc/";
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", mUserAgent);
        cronetRequestParams.makeRequestHeader(hashMap);
        CronetLogic.cancelCronetTask(CronetLogic.startCronetHttpTask(cronetRequestParams, new callback("testIp")).taskId);
    }

    private static void testSimpleDns() {
        CronetLogic.CronetRequestParams cronetRequestParams = new CronetLogic.CronetRequestParams();
        cronetRequestParams.taskType = 1;
        cronetRequestParams.dnsType = 1;
        CronetLogic.setSimpleDnsCallback(new CronetLogic.CronetDnsCallback() { // from class: com.tencent.mars.cdn.a
            @Override // com.tencent.mars.cdn.CronetLogic.CronetDnsCallback
            public final String[] dns(String str) {
                String[] lambda$testSimpleDns$0;
                lambda$testSimpleDns$0 = CronetLogicTest.lambda$testSimpleDns$0(str);
                return lambda$testSimpleDns$0;
            }
        });
        cronetRequestParams.url = testUrl;
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", mUserAgent);
        cronetRequestParams.makeRequestHeader(hashMap);
        CronetLogic.startCronetHttpTask(cronetRequestParams, new callback("testSimpleDns"));
    }

    private static void testUpload() {
        int length;
        CronetLogic.CronetRequestParams cronetRequestParams = new CronetLogic.CronetRequestParams();
        cronetRequestParams.taskType = 7;
        cronetRequestParams.url = "http://www.csm-testcenter.org/test";
        cronetRequestParams.method = "POST";
        CronetLogic.UploadParams uploadParams = new CronetLogic.UploadParams();
        uploadParams.filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/upload_text";
        long length2 = new File(uploadParams.filePath).length();
        uploadParams.uploadOffset = 0L;
        uploadParams.uploadRange = length2;
        uploadParams.formData = "----WebKitFormBoundaryn35wXoQ8S5FsBTGs".getBytes(StandardCharsets.UTF_8);
        uploadParams.endData = "----WebKitFormBoundaryn35wXoQ8S5FsBTGs".getBytes(StandardCharsets.UTF_8);
        uploadParams.vfsPath = true;
        uploadParams.reportId = TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC;
        cronetRequestParams.uploadParams = uploadParams;
        HashMap hashMap = new HashMap();
        byte[] bArr = uploadParams.formData;
        int i3 = 0;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        long j3 = length2 + length;
        byte[] bArr2 = uploadParams.endData;
        if (bArr2 != null) {
            i3 = bArr2.length;
        }
        hashMap.put("Content-Length", Long.toString(j3 + i3));
        hashMap.put("Origin", "http://www.csm-testcenter.org");
        hashMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        hashMap.put("Accept-Encoding", "gzip, deflate");
        hashMap.put("Referer", "http://www.csm-testcenter.org/test?do=show&subdo=common&test=file_upload");
        hashMap.put("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryn35wXoQ8S5FsBTGs");
        hashMap.put("Host", "www.csm-testcenter.org");
        hashMap.put("User-Agent", mUserAgent);
        cronetRequestParams.makeRequestHeader(hashMap);
        CronetLogic.startCronetUploadTask(cronetRequestParams, new callback("testUpload"));
    }
}
