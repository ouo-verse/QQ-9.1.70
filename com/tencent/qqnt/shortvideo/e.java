package com.tencent.qqnt.shortvideo;

import com.tencent.mobileqq.qqnt.videoplay.api.so.a;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/shortvideo/e;", "Lcom/tencent/mobileqq/qqnt/videoplay/api/so/a$a;", "", "b", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e implements a.InterfaceC8418a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Ref.BooleanRef result, CountDownLatch countDownLatch, boolean z16) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        result.element = z16;
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Ref.BooleanRef result, CountDownLatch countDownLatch, boolean z16) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        result.element = z16;
        countDownLatch.countDown();
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.api.so.a.InterfaceC8418a
    public boolean a() {
        QLog.i("VideoPlayUtil", 1, "initSDK start");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        QQVideoPlaySDKManager.initDownloadSDKAsync(BaseApplication.context, new SDKInitListener() { // from class: com.tencent.qqnt.shortvideo.d
            @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
            public final void onSDKInited(boolean z16) {
                e.e(Ref.BooleanRef.this, countDownLatch, z16);
            }
        });
        try {
            countDownLatch.await(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e16) {
            QLog.e("VideoPlayUtil", 1, "VideoPlaySo initSDK fail", e16);
        }
        return booleanRef.element;
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.api.so.a.InterfaceC8418a
    public boolean b() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new com.tencent.mobileqq.qqvideoplatform.imp.a(false).loadSo(new LoadSoCallback() { // from class: com.tencent.qqnt.shortvideo.c
            @Override // com.tencent.mobileqq.videoplatform.api.LoadSoCallback
            public final void onLoad(boolean z16) {
                e.f(Ref.BooleanRef.this, countDownLatch, z16);
            }
        });
        try {
            countDownLatch.await(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e16) {
            QLog.e("VideoPlayUtil", 1, "VideoPlaySo load fail", e16);
        }
        return booleanRef.element;
    }
}
