package com.tencent.mobileqq.qzoneplayer.video;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes35.dex */
public class TencentVideoHttpRetryLogic implements HttpRetryLogic {

    /* renamed from: a, reason: collision with root package name */
    private String f279905a;

    /* renamed from: b, reason: collision with root package name */
    private String f279906b;

    /* renamed from: c, reason: collision with root package name */
    private String f279907c;

    public TencentVideoHttpRetryLogic(String str, String str2, String str3) {
        this.f279905a = str;
        this.f279906b = str2;
        this.f279907c = str3;
    }

    @Override // com.tencent.oskplayer.proxy.HttpRetryLogic
    public String getRetryUrl(String str, int i3, int i16, Map<String, List<String>> map) {
        PlayerUtils.log(4, "HttpRetryLogic", "retry originUrl=" + str + " retryCount=" + i3 + " responseCode=" + i16);
        if (i3 < 5 && i16 == 403 && !TextUtils.isEmpty(this.f279905a) && !TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                String path = parse.getPath();
                int i17 = 0;
                if (!TextUtils.isEmpty(path) && vl2.b.b(path)) {
                    String lastPathSegment = parse.getLastPathSegment();
                    if (!TextUtils.isEmpty(lastPathSegment)) {
                        try {
                            i17 = Integer.getInteger(lastPathSegment.substring(lastPathSegment.indexOf(".") - 1, lastPathSegment.indexOf(".")), 0).intValue();
                        } catch (Exception e16) {
                            PlayerUtils.log(5, "HttpRetryLogic", PlayerUtils.getPrintableStackTrace(e16));
                        }
                    }
                }
                PlayerUtils.log(4, "TencentVideoHttpRetryLogic", "request segment = " + i17);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                final m mVar = new m(i17, countDownLatch);
                new Handler(FeedVideoEnv.externalFunc.getRealTimeThread().getLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.TencentVideoHttpRetryLogic.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FeedVideoEnv.externalFunc.cleanCacheFor403(TencentVideoHttpRetryLogic.this.f279906b);
                        FeedVideoEnv.externalFunc.getSafeurl(TencentVideoHttpRetryLogic.this.f279905a, TencentVideoHttpRetryLogic.this.f279906b, null, TencentVideoHttpRetryLogic.this.f279907c, mVar);
                    }
                });
                try {
                    if (!countDownLatch.await(8000L, TimeUnit.MILLISECONDS) || !mVar.f280012c) {
                        return null;
                    }
                    PlayerUtils.log(4, "HttpRetryLogic", "retry originUrl=" + str + " retryUrl=" + mVar.f280014e);
                    return mVar.f280014e;
                } catch (InterruptedException unused) {
                    PlayerUtils.log(4, "HttpRetryLogic", "retryUrl interrupted!");
                    Thread.currentThread().interrupt();
                    return mVar.f280014e;
                }
            } catch (Exception e17) {
                PlayerUtils.log(5, "HttpRetryLogic", PlayerUtils.getPrintableStackTrace(e17));
            }
        }
        return null;
    }
}
