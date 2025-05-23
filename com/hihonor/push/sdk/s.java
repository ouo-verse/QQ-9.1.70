package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public final Context f36427a;

    /* renamed from: b, reason: collision with root package name */
    public a0 f36428b = new a0();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f36429a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HonorPushCallback f36430b;

        public a(Callable callable, HonorPushCallback honorPushCallback) {
            this.f36429a = callable;
            this.f36430b = honorPushCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Object call = this.f36429a.call();
                s sVar = s.this;
                HonorPushCallback honorPushCallback = this.f36430b;
                sVar.getClass();
                b1.a(new t(sVar, honorPushCallback, call));
            } catch (ApiException e16) {
                s.a(s.this, this.f36430b, e16.getErrorCode(), e16.getMessage());
            } catch (Exception unused) {
                s sVar2 = s.this;
                HonorPushCallback honorPushCallback2 = this.f36430b;
                HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
                s.a(sVar2, honorPushCallback2, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
            }
        }
    }

    public s(Context context) {
        this.f36427a = context;
    }

    public static void a(s sVar, HonorPushCallback honorPushCallback, int i3, String str) {
        sVar.getClass();
        b1.a(new u(sVar, honorPushCallback, i3, str));
    }

    public final <T> void a(Callable<T> callable, HonorPushCallback<T> honorPushCallback) {
        a aVar = new a(callable, honorPushCallback);
        b1 b1Var = b1.f36357d;
        if (b1Var.f36359b == null) {
            synchronized (b1Var.f36360c) {
                if (b1Var.f36359b == null) {
                    b1Var.f36359b = b1Var.b();
                }
            }
        }
        b1Var.f36359b.execute(aVar);
    }
}
