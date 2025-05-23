package com.tencent.mobileqq.intervideo.od;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f238410a = ThreadManagerExecutor.getExecutorService(128);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.intervideo.od.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static final class CallableC7947a implements Callable<Bundle> {

        /* renamed from: d, reason: collision with root package name */
        private final String f238411d;

        /* renamed from: e, reason: collision with root package name */
        private final String f238412e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.intervideo.od.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes33.dex */
        public class C7948a implements ILoginKeyHelper.b {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ILoginKeyHelper f238413d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle[] f238414e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ CountDownLatch f238415f;

            C7948a(ILoginKeyHelper iLoginKeyHelper, Bundle[] bundleArr, CountDownLatch countDownLatch) {
                this.f238413d = iLoginKeyHelper;
                this.f238414e = bundleArr;
                this.f238415f = countDownLatch;
            }

            @Override // com.tencent.mobileqq.intervideo.ILoginKeyHelper.b
            public void a(String str, boolean z16, int i3) {
                if (z16) {
                    Bundle a16 = this.f238413d.getAccountInfo().a();
                    Bundle bundle = new Bundle();
                    bundle.putBundle("data", a16);
                    bundle.putBoolean("isSuccess", true);
                    bundle.putInt("code", i3);
                    this.f238414e[0] = bundle;
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("isSuccess", false);
                    bundle2.putInt("code", i3);
                    this.f238414e[0] = bundle2;
                }
                this.f238415f.countDown();
            }
        }

        CallableC7947a(String str, String str2) {
            this.f238411d = str;
            this.f238412e = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bundle call() throws Exception {
            Bundle[] bundleArr = new Bundle[1];
            AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
            ILoginKeyHelper iLoginKeyHelper = (ILoginKeyHelper) QRoute.api(ILoginKeyHelper.class);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            iLoginKeyHelper.getAccessToken(appInterface, this.f238412e, BaseApplication.getContext(), this.f238411d, new C7948a(iLoginKeyHelper, bundleArr, countDownLatch));
            countDownLatch.await();
            return bundleArr[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class b implements Callable<Bundle> {

        /* renamed from: d, reason: collision with root package name */
        private final String f238417d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.intervideo.od.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes33.dex */
        public class C7949a implements ILoginKeyHelper.b {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ILoginKeyHelper f238418d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle[] f238419e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ CountDownLatch f238420f;

            C7949a(ILoginKeyHelper iLoginKeyHelper, Bundle[] bundleArr, CountDownLatch countDownLatch) {
                this.f238418d = iLoginKeyHelper;
                this.f238419e = bundleArr;
                this.f238420f = countDownLatch;
            }

            @Override // com.tencent.mobileqq.intervideo.ILoginKeyHelper.b
            public void a(String str, boolean z16, int i3) {
                if (z16) {
                    Bundle a16 = this.f238418d.getAccountInfo().a();
                    Bundle bundle = new Bundle();
                    bundle.putBundle("data", a16);
                    bundle.putBoolean("isSuccess", true);
                    bundle.putInt("code", i3);
                    this.f238419e[0] = bundle;
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("isSuccess", false);
                    bundle2.putInt("code", i3);
                    this.f238419e[0] = bundle2;
                }
                this.f238420f.countDown();
            }
        }

        b(String str) {
            this.f238417d = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bundle call() throws Exception {
            Bundle[] bundleArr = new Bundle[1];
            AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
            ILoginKeyHelper iLoginKeyHelper = (ILoginKeyHelper) QRoute.api(ILoginKeyHelper.class);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            iLoginKeyHelper.getPSkey(appInterface, this.f238417d, new C7949a(iLoginKeyHelper, bundleArr, countDownLatch));
            countDownLatch.await();
            return bundleArr[0];
        }
    }

    public Bundle a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        try {
            Bundle bundle2 = b(str, str2).get();
            if (bundle2 != null && bundle2.getBundle("data") != null) {
                bundle.putAll(bundle2.getBundle("data"));
            }
            Bundle bundle3 = c(str3).get();
            if (bundle3 != null && bundle3.getBundle("data") != null) {
                bundle.putAll(bundle3.getBundle("data"));
            }
        } catch (Throwable th5) {
            QLog.e("ODLoginUtil", 1, "getAccessAndPSKeyToken error !", th5);
        }
        bundle.putInt("authtype", 1);
        return bundle;
    }

    public Future<Bundle> b(String str, String str2) {
        return this.f238410a.submit(new CallableC7947a(str2, str));
    }

    public Future<Bundle> c(String str) {
        return this.f238410a.submit(new b(str));
    }
}
