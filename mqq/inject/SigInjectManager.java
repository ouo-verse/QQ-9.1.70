package mqq.inject;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.e;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SigInjectManager implements ISigInject {
    private static final String TAG = "SkeyInjectManager";

    @ConfigInject(configPath = "AutoInjectYml/Foundation/mqq/Inject_mqq_sig.yml", version = 1)
    public static ArrayList<Class<? extends ISigInject>> sInjectorList;
    private static volatile SigInjectManager sInstance;
    private ISigInject injector;

    static {
        ArrayList<Class<? extends ISigInject>> arrayList = new ArrayList<>();
        sInjectorList = arrayList;
        arrayList.add(e.class);
    }

    SigInjectManager() {
        this.injector = null;
        if (sInjectorList.size() == 0) {
            return;
        }
        try {
            this.injector = sInjectorList.get(0).newInstance();
        } catch (IllegalAccessException | InstantiationException e16) {
            QLog.e(TAG, 1, "ISkeyInject new instance fail: ", e16);
        }
    }

    public static SigInjectManager instance() {
        if (sInstance == null) {
            synchronized (SigInjectManager.class) {
                if (sInstance == null) {
                    sInstance = new SigInjectManager();
                }
            }
        }
        return sInstance;
    }

    @Override // mqq.inject.ISigInject
    public boolean banSkeyAccess() {
        ISigInject iSigInject = this.injector;
        if (iSigInject == null) {
            QLog.d(TAG, 1, "injector is null");
            return false;
        }
        return iSigInject.banSkeyAccess();
    }

    @Override // mqq.inject.ISigInject
    public String getFakeSkey(String str) {
        ISigInject iSigInject = this.injector;
        if (iSigInject == null) {
            QLog.d(TAG, 1, "injector is null");
            return "";
        }
        return iSigInject.getFakeSkey(str);
    }

    @Override // mqq.inject.ISigInject
    public void getLoginSig(long j3, long j16, ILoginMainTicketCallback iLoginMainTicketCallback) {
        ISigInject iSigInject = this.injector;
        if (iSigInject == null) {
            QLog.d(TAG, 1, "injector is null");
        } else {
            iSigInject.getLoginSig(j3, j16, iLoginMainTicketCallback);
        }
    }
}
