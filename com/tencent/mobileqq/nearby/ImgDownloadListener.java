package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ImgDownloadListener implements URLDrawable.DownloadListener {

    /* renamed from: d, reason: collision with root package name */
    private long f252488d;

    /* renamed from: e, reason: collision with root package name */
    private Context f252489e;

    /* renamed from: f, reason: collision with root package name */
    private String f252490f;

    public ImgDownloadListener(Context context) {
        this.f252490f = "freshnews.small_pic_download";
        this.f252489e = context;
    }

    @Override // com.tencent.image.URLDrawable.DownloadListener
    public void onFileDownloadFailed(final int i3) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.nearby.ImgDownloadListener.2
            @Override // java.lang.Runnable
            public void run() {
                long elapsedRealtime = SystemClock.elapsedRealtime() - ImgDownloadListener.this.f252488d;
                String apn = NetworkUtil.getApn(ImgDownloadListener.this.f252489e);
                if (TextUtils.isEmpty(apn)) {
                    apn = "wifi";
                }
                HashMap hashMap = new HashMap();
                hashMap.put("errorCode", String.valueOf(i3));
                hashMap.put("costTime", String.valueOf(elapsedRealtime));
                hashMap.put("apn", apn);
                hashMap.put(ReportConstant.KEY_NET_TYPE, NetworkUtil.getSystemNetwork(null) + "");
                if (QLog.isColorLevel()) {
                    QLog.d("ImgDownloadListener", 2, "onFileDownloadFailed, errorCode=" + i3);
                }
            }
        }, null, true);
    }

    @Override // com.tencent.image.URLDrawable.DownloadListener
    public void onFileDownloadStarted() {
        this.f252488d = SystemClock.elapsedRealtime();
    }

    @Override // com.tencent.image.URLDrawable.DownloadListener
    public void onFileDownloadSucceed(final long j3) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.nearby.ImgDownloadListener.1
            @Override // java.lang.Runnable
            public void run() {
                long elapsedRealtime = SystemClock.elapsedRealtime() - ImgDownloadListener.this.f252488d;
                String apn = NetworkUtil.getApn(ImgDownloadListener.this.f252489e);
                if (TextUtils.isEmpty(apn)) {
                    apn = "wifi";
                }
                HashMap hashMap = new HashMap();
                hashMap.put("fileSize", String.valueOf(j3));
                hashMap.put("costTime", String.valueOf(elapsedRealtime));
                hashMap.put("apn", apn);
                hashMap.put(ReportConstant.KEY_NET_TYPE, NetworkUtil.getSystemNetwork(null) + "");
                if (QLog.isColorLevel()) {
                    QLog.d("ImgDownloadListener", 2, "onFileDownloadSucceed, fileSize=" + j3);
                }
            }
        }, null, true);
    }

    public ImgDownloadListener(Context context, String str) {
        this.f252489e = context;
        this.f252490f = str;
    }
}
