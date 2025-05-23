package com.tencent.biz.richframework.video;

import android.text.TextUtils;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUICStatus {
    private int mHTTPDownloadFailedByCount;
    private volatile boolean mHasReportQUICTOHttp;
    private int mHttpDownLoadCompleteCount;
    private boolean mIsDownloadByQUIC;
    private String mPlyUrl;
    private int mQUICDownloadCompleteCount;
    private int mQUICDownloadFailCount;
    private QUICListener mQUICListener;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface QUICListener {
        void reportQUICTOHttp(QUICStatus qUICStatus);
    }

    public QUICStatus(String str) {
        this.mPlyUrl = TextUtils.isEmpty(str) ? "" : str;
    }

    private void reportQUICToHTTP() {
        if (this.mQUICListener != null && !this.mHasReportQUICTOHttp) {
            this.mHasReportQUICTOHttp = true;
            this.mQUICListener.reportQUICTOHttp(this);
            return;
        }
        QLog.d("QUICStatus", 2, hashCode() + "|reportQUICToHTTP() return:" + this.mHasReportQUICTOHttp + " url" + this.mPlyUrl);
    }

    public void increaseHTTPFailedCount() {
        this.mHTTPDownloadFailedByCount++;
        QLog.d("QUICStatus", 2, hashCode() + "|increaseHTTPFailedCount():" + this.mHTTPDownloadFailedByCount + " url" + this.mPlyUrl);
    }

    public void increaseHttpCompleteCount() {
        this.mHttpDownLoadCompleteCount++;
        QLog.d("QUICStatus", 2, hashCode() + "|increaseHttpCompleteCount():" + this.mHttpDownLoadCompleteCount + " url" + this.mPlyUrl);
        if (this.mQUICDownloadFailCount > 0) {
            reportQUICToHTTP();
            QLog.d("QUICStatus", 2, hashCode() + "|increaseHttpCompleteCount(): trigger report," + this.mHttpDownLoadCompleteCount + APLogFileUtil.SEPARATOR_LOG + this.mQUICDownloadFailCount + " url" + this.mPlyUrl);
        }
    }

    public void increaseQUICCompleteCount() {
        this.mQUICDownloadCompleteCount++;
        if (!QLog.isColorLevel()) {
            return;
        }
        QLog.d("QUICStatus", 2, hashCode() + "|increaseQUICCompleteCount():" + this.mQUICDownloadCompleteCount + " url" + this.mPlyUrl);
    }

    public void increaseQUICFailedCount() {
        this.mQUICDownloadFailCount++;
        QLog.d("QUICStatus", 2, hashCode() + "|increaseQUICFailedCount():" + this.mQUICDownloadFailCount + " url" + this.mPlyUrl);
        if (this.mHttpDownLoadCompleteCount > 0) {
            reportQUICToHTTP();
            QLog.d("QUICStatus", 2, hashCode() + "|increaseQUICFailedCount(): trigger report," + this.mHttpDownLoadCompleteCount + APLogFileUtil.SEPARATOR_LOG + this.mQUICDownloadFailCount + " url" + this.mPlyUrl);
        }
    }

    public void setIsDownLoadByQUIC() {
        this.mIsDownloadByQUIC = true;
        QLog.d("QUICStatus", 2, hashCode() + "|setIsDownLoadByQUIC() true url" + this.mPlyUrl);
    }

    public void setQUICListener(QUICListener qUICListener) {
        this.mQUICListener = qUICListener;
    }
}
