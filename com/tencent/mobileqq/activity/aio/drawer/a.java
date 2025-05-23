package com.tencent.mobileqq.activity.aio.drawer;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static a f178625e;

    /* renamed from: a, reason: collision with root package name */
    private String f178627a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f178628b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f178629c = true;

    /* renamed from: d, reason: collision with root package name */
    private static final String f178624d = DPCNames.aio_config.name();

    /* renamed from: f, reason: collision with root package name */
    public static DPCObserver f178626f = new C7125a();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.aio.drawer.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C7125a implements DPCObserver {
        C7125a() {
        }

        @Override // com.tencent.mobileqq.dpc.DPCObserver
        public void onDpcPullFinished(boolean z16) {
            if (z16) {
                a.d(true);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIODrawerDpc", 2, "onDpcPullFinished, hasChanged = " + z16);
            }
        }
    }

    a() {
        ((IDPCApi) QRoute.api(IDPCApi.class)).addObserver(f178626f);
    }

    public static a b() {
        if (f178625e == null) {
            d(false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIODrawerDpc", 2, "getInstance: " + f178625e);
        }
        return f178625e;
    }

    public static boolean c() {
        a b16 = b();
        if (b16 != null) {
            return b16.f178628b;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(boolean z16) {
        synchronized (a.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (f178625e == null) {
                f178625e = new a();
                z16 = true;
            }
            if (z16) {
                try {
                    String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(f178624d);
                    f178625e.f178627a = featureValueWithoutAccountManager;
                    if (!TextUtils.isEmpty(featureValueWithoutAccountManager)) {
                        String[] split = featureValueWithoutAccountManager.split("\\|");
                        if (split.length >= 19) {
                            if (Integer.valueOf(split[18]).intValue() == 1) {
                                f178625e.f178628b = true;
                            } else {
                                f178625e.f178628b = false;
                            }
                        } else {
                            f178625e.f178628b = true;
                        }
                        if (split.length >= 20) {
                            if (Integer.valueOf(split[19]).intValue() == 1) {
                                f178625e.f178629c = true;
                            } else {
                                f178625e.f178629c = false;
                            }
                        } else {
                            f178625e.f178629c = true;
                        }
                    }
                } catch (Exception e16) {
                    QLog.d("AIODrawerDpc", 1, "load exp:" + e16.getMessage());
                    a aVar = f178625e;
                    aVar.f178628b = true;
                    aVar.f178629c = true;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIODrawerDpc", 2, "loadDpc: " + f178625e + ", costMills: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public String toString() {
        return "AIODrawerDpc{dpcValue='" + this.f178627a + "', isSupport=" + this.f178628b + ", needPreInflate=" + this.f178629c + '}';
    }
}
