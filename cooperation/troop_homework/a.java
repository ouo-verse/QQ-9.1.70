package cooperation.troop_homework;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f390928c = DPCNames.homeworkCfg.name();

    /* renamed from: d, reason: collision with root package name */
    private static a f390929d;

    /* renamed from: a, reason: collision with root package name */
    private int f390930a = 22;

    /* renamed from: b, reason: collision with root package name */
    private DPCObserver f390931b = new C10124a();

    /* compiled from: P */
    /* renamed from: cooperation.troop_homework.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    class C10124a implements DPCObserver {
        C10124a() {
        }

        @Override // com.tencent.mobileqq.dpc.DPCObserver
        public void onDpcPullFinished(boolean z16) {
            if (z16) {
                a.this.c();
            }
        }
    }

    a() {
        ((IDPCApi) QRoute.api(IDPCApi.class)).addObserver(this.f390931b);
        c();
    }

    public static a a() {
        if (f390929d == null) {
            synchronized (a.class) {
                if (f390929d == null) {
                    f390929d = new a();
                }
            }
        }
        return f390929d;
    }

    public boolean b() {
        int i3 = Build.VERSION.SDK_INT;
        QLog.d("HomeworkDpcCfg", 1, String.format("hwUseNewAPI thisVer=%d cfgVer=%d", Integer.valueOf(i3), Integer.valueOf(this.f390930a)));
        if (i3 > this.f390930a) {
            return false;
        }
        return true;
    }

    public void c() {
        String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(f390928c);
        if (!TextUtils.isEmpty(featureValueWithoutAccountManager)) {
            String[] split = featureValueWithoutAccountManager.split("\\|");
            if (split.length >= 1) {
                try {
                    this.f390930a = Integer.valueOf(split[0]).intValue();
                } catch (Exception e16) {
                    QLog.d("HomeworkDpcCfg", 1, "loadConfig exception :" + e16.getMessage());
                    this.f390930a = 22;
                }
            }
        } else {
            this.f390930a = 22;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HomeworkDpcCfg", 2, String.format("loadConfig, mUseNewApiLevel: %s, dpc=%s", Integer.valueOf(this.f390930a), featureValueWithoutAccountManager));
        }
    }
}
