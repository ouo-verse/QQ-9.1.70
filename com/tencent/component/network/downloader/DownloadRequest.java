package com.tencent.component.network.downloader;

import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.utils.AssertUtil;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DownloadRequest {
    private long fileSizeForRangeMode;
    private boolean mCacheEntry;
    private Downloader.DownloadListener mListener;
    private Map<String, String> mParams;
    private final String[] mPaths;
    private final String mUrl;
    public OnResponseDataListener onResponseDataListener;
    public OutputStream outputStream;
    public long range;
    public int rangeNumber;
    private boolean mIsCanceled = false;
    public Downloader.DownloadMode mode = Downloader.DownloadMode.FastMode;
    public float progressCallbackStep = 0.0f;
    public boolean needMd5 = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnResponseDataListener {
        void onRecvData(byte[] bArr, int i3, int i16, long j3, int i17, boolean z16);
    }

    public DownloadRequest(String str, String[] strArr, boolean z16, Downloader.DownloadListener downloadListener) {
        boolean z17 = false;
        this.mCacheEntry = false;
        if (Utils.checkUrl(str) && strArr != null) {
            z17 = true;
        }
        AssertUtil.assertTrue(z17);
        this.mUrl = str;
        this.mPaths = strArr;
        this.mListener = downloadListener;
        this.mCacheEntry = z16;
    }

    private static boolean equalsObject(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    private static int hashCodeObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public void addParam(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.mParams == null) {
                this.mParams = new HashMap();
            }
            this.mParams.put(str, str2);
        }
    }

    public void cancel() {
        this.mIsCanceled = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        if (this.mUrl.equalsIgnoreCase(downloadRequest.mUrl) && equalsObject(this.mListener, downloadRequest.mListener)) {
            return true;
        }
        return false;
    }

    public long getFileSizeForRangeMode() {
        return this.fileSizeForRangeMode;
    }

    public Downloader.DownloadListener getListener() {
        return this.mListener;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public String getPath() {
        String[] strArr = this.mPaths;
        if (strArr != null && strArr.length > 0) {
            return strArr[0];
        }
        return null;
    }

    public String[] getPaths() {
        return this.mPaths;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public int hashCode() {
        return ((527 + this.mUrl.hashCode()) * 31) + hashCodeObject(this.mListener);
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public void setFileSizeForRangeMode(long j3) {
        this.fileSizeForRangeMode = j3;
    }

    public void setListener(Downloader.DownloadListener downloadListener) {
        this.mListener = downloadListener;
    }

    public boolean shouldCacheEntry() {
        return this.mCacheEntry;
    }
}
