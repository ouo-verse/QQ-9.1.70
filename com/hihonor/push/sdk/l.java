package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes2.dex */
public class l {

    /* renamed from: e, reason: collision with root package name */
    public static final l f36402e = new l();

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f36403a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f36404b = false;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f36405c = false;

    /* renamed from: d, reason: collision with root package name */
    public s f36406d;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f36407a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HonorPushCallback f36408b;

        public a(Runnable runnable, HonorPushCallback honorPushCallback) {
            this.f36407a = runnable;
            this.f36408b = honorPushCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f36404b) {
                this.f36407a.run();
                return;
            }
            HonorPushCallback honorPushCallback = this.f36408b;
            if (honorPushCallback != null) {
                HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;
                honorPushCallback.onFailure(honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
            }
        }
    }

    public boolean a(Context context) {
        return HonorPushErrorEnum.SUCCESS.statusCode == b.b(context);
    }

    public Context a() {
        return this.f36403a.get();
    }

    public final void a(Runnable runnable, HonorPushCallback<?> honorPushCallback) {
        b1.a(new a(runnable, honorPushCallback));
    }
}
