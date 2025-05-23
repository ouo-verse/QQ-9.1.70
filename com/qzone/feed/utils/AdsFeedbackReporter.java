package com.qzone.feed.utils;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AdsFeedbackReporter {
    private static final String TAG = "AdsFeedbackReporter";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class ReportRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        boolean f47408d = false;

        /* renamed from: e, reason: collision with root package name */
        int f47409e = 0;

        /* renamed from: f, reason: collision with root package name */
        int f47410f = 0;

        /* renamed from: h, reason: collision with root package name */
        String f47411h;

        public ReportRunnable(String str) {
            this.f47411h = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpResponse d16;
            if (TextUtils.isEmpty(this.f47411h)) {
                return;
            }
            while (!this.f47408d && this.f47410f <= 1) {
                int i3 = this.f47409e;
                if (i3 > 1) {
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this, MiniBoxNoticeInfo.MIN_5);
                    this.f47410f++;
                    this.f47409e = 0;
                    return;
                }
                this.f47409e = i3 + 1;
                try {
                    d16 = to.e.d(BaseApplication.getContext(), this.f47411h);
                } catch (UnsupportedEncodingException e16) {
                    QZLog.e(AdsFeedbackReporter.TAG, "exception when report:UnsupportedEncodingException", e16);
                } catch (IOException e17) {
                    QZLog.e(AdsFeedbackReporter.TAG, "exception when report:IOException", e17);
                } catch (SecurityException e18) {
                    QZLog.e(AdsFeedbackReporter.TAG, "exception when report:SecurityException", e18);
                } catch (ClientProtocolException e19) {
                    QZLog.e(AdsFeedbackReporter.TAG, "exception when report:ClientProtocolException", e19);
                } catch (Throwable th5) {
                    QZLog.e(AdsFeedbackReporter.TAG, "exception when report:Throwable", th5);
                }
                if (d16 == null) {
                    return;
                }
                if (d16.getStatusLine().getStatusCode() == 200) {
                    this.f47408d = true;
                } else {
                    QZLog.e(AdsFeedbackReporter.TAG, "HttpStatus error when report : " + d16.getStatusLine().getStatusCode());
                }
            }
        }
    }

    public static void report(String str) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new ReportRunnable(str));
    }

    public static void reportFeedback(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new ReportRunnable(str.replace("__ACT_TYPE__", "2001").replace("__REPORT_SOURCE__", "1")) { // from class: com.qzone.feed.utils.AdsFeedbackReporter.1
            {
                this.f47410f = 1;
            }
        });
    }

    public static void report(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getRecommAction() == null || businessFeedData.getRecommAction().reportUrl == null) {
            return;
        }
        reportFeedback(businessFeedData.getRecommAction().reportUrl);
    }
}
