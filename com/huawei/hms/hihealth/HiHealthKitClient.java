package com.huawei.hms.hihealth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.health.aabz;
import com.huawei.hms.health.aacb;
import com.huawei.hms.health.aaci;
import com.huawei.hms.health.aack;
import com.huawei.hms.health.aacn;
import com.huawei.hms.health.aacu;
import com.huawei.hms.hihealth.aab;
import com.huawei.hms.hihealth.aabc;
import com.huawei.hms.hihealth.aabe;
import com.huawei.hms.hihealth.aabg;
import com.huawei.hms.hihealth.aabh;
import com.huawei.hms.hihealth.aabi;
import com.huawei.hms.hihealth.aabj;
import com.huawei.hms.hihealth.aabl;
import com.huawei.hms.hihealth.aabn;
import com.huawei.hms.hihealth.aabo;
import com.huawei.hms.hihealth.aabr;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HiHealthKitClient {
    private HandlerThread aab;
    private Handler aaba;
    private List<Scope> aabb;
    private Activity aabd;
    private long aabf;
    private Timer aabg;
    private TimerTask aabh;
    private com.huawei.hms.hihealth.aabh aabi;
    private CountDownLatch aabj;
    private Context aabc = null;
    private Activity aabe = null;
    private AtomicBoolean aabk = new AtomicBoolean(false);
    private AtomicBoolean aabl = new AtomicBoolean(false);
    private ExecutorService aabm = ProxyExecutors.newSingleThreadExecutor();
    private aabd aabn = new aabd(null);
    private List<aabg> aabo = new CopyOnWriteArrayList();
    private ServiceConnection aabp = new aab();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private Context aab;
        private Activity aaba;
        private final List<Scope> aabb;
        private final Map<Api<?>, Api.ApiOptions> aabc;

        public Builder(Activity activity) {
            this.aabb = new ArrayList();
            this.aabc = new HashMap();
            this.aab = activity.getApplicationContext();
            this.aaba = activity;
            HiHealthKitClient.getInstance().setContext(this.aab);
        }

        public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            this.aabc.put(api, null);
            return this;
        }

        public Builder addScope(@NonNull Scope scope) {
            this.aabb.add(scope);
            return this;
        }

        public HiHealthKitClient build() {
            HiHealthKitClient hiHealthKitClient = HiHealthKitClient.getInstance();
            hiHealthKitClient.setContext(this.aab);
            hiHealthKitClient.aabb = this.aabb;
            hiHealthKitClient.aabd = this.aaba;
            return hiHealthKitClient;
        }

        public Builder(Context context) {
            this.aabb = new ArrayList();
            this.aabc = new HashMap();
            this.aab = context;
            this.aaba = null;
            HiHealthKitClient.getInstance().setContext(this.aab);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aab implements ServiceConnection {
        aab() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            aabz.aabb("ServiceConnection", "onServiceConnected success!");
            HiHealthKitClient.this.aabi = aabh.aab.aab(iBinder);
            HiHealthKitClient.this.aabj.countDown();
            HiHealthKitClient.this.aabk.getAndSet(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            aabz.aabb("ServiceConnection", "onServiceDisconnected success!");
            HiHealthKitClient.this.aabk.getAndSet(false);
            HiHealthKitClient.this.aabb();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class aaba implements Runnable {
        aaba() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HiHealthKitClient.aabh(HiHealthKitClient.this);
            HiHealthKitClient.this.aab();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabb implements OnSuccessListener<com.huawei.hms.health.aabp> {
        final /* synthetic */ Task aab;

        aabb(Task task) {
            this.aab = task;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public void onSuccess(com.huawei.hms.health.aabp aabpVar) {
            Intent aab = ((com.huawei.hms.health.aabp) this.aab.getResult()).aab();
            if (aab == null) {
                aabz.aabb("HiHealthKitClient", "onSuccess : Task optApkService fail. get intent failed!");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("sdkVersion", "6.11.0.303");
            aab.putExtras(bundle);
            if (HiHealthKitClient.this.aabc != null) {
                aacu.aab(aab, HMSPackageManager.getInstance(HiHealthKitClient.this.aabc).getHMSPackageName());
                boolean bindService = HiHealthKitClient.this.aabc.bindService(aab, HiHealthKitClient.this.aabp, 1);
                HiHealthKitClient.this.aabl.getAndSet(bindService);
                aabz.aabb("HiHealthKitClient", "connectWithHms result " + bindService);
                return;
            }
            aabz.aab("HiHealthKitClient", "HiHealthClient connect onSuccess,  context is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabc extends Handler {
        aabc(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            StringBuilder aab = com.huawei.hms.health.aab.aab("sync message begin to handle ");
            aab.append(message.what);
            aabz.aabb("HiHealthKitClient", aab.toString());
            if (message.what == 1000) {
                HiHealthKitClient.this.aaba();
                HiHealthKitClient.this.aab(false);
            } else {
                aabz.aabb("HiHealthKitClient", "unknown msg");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class aabd extends aab.AbstractBinderC0262aab {
        /* synthetic */ aabd(aab aabVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class aabe implements OnFailureListener {
        /* synthetic */ aabe(aab aabVar) {
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            aabz.aabb("HiHealthKitClient", "onFailure : Task optApkService fail.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class aabf {
        private int aab;
        private IBinder aaba;

        aabf(int i3, IBinder iBinder) {
            this.aab = i3;
            this.aaba = iBinder;
        }

        public IInterface aab() {
            int i3 = this.aab;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 100) {
                                switch (i3) {
                                    case 7:
                                        com.huawei.hms.hihealth.aabe aab = aabe.aab.aab(this.aaba);
                                        aack.aabf().aab(aab);
                                        return aab;
                                    case 8:
                                        aabj aab2 = aabj.aab.aab(this.aaba);
                                        aack.aabf().aab(aab2);
                                        return aab2;
                                    case 9:
                                        aabn aab3 = aabn.aab.aab(this.aaba);
                                        aack.aabf().aab(aab3);
                                        return aab3;
                                    case 10:
                                        aabo aab4 = aabo.aab.aab(this.aaba);
                                        aack.aabf().aab(aab4);
                                        return aab4;
                                    default:
                                        aabz.aab("HiHealthKitClient", "unknown apiType");
                                        return null;
                                }
                            }
                            com.huawei.hms.hihealth.aabi aab5 = aabi.aab.aab(this.aaba);
                            aack.aabf().aab(aab5);
                            return aab5;
                        }
                        aabr aab6 = aabr.aab.aab(this.aaba);
                        aack.aabf().aab(aab6);
                        return aab6;
                    }
                    com.huawei.hms.hihealth.aabg aab7 = aabg.aab.aab(this.aaba);
                    aack.aabf().aab(aab7);
                    return aab7;
                }
                com.huawei.hms.hihealth.aabc aab8 = aabc.aab.aab(this.aaba);
                aack.aabf().aab(aab8);
                return aab8;
            }
            aabl aab9 = aabl.aab.aab(this.aaba);
            aack.aabf().aab(aab9);
            return aab9;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface aabg {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class aabh {
        public static final HiHealthKitClient aab = new HiHealthKitClient();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class aabi implements OnSuccessListener<AuthHuaweiId> {
        /* synthetic */ aabi(aab aabVar) {
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public void onSuccess(AuthHuaweiId authHuaweiId) {
            String str;
            if (authHuaweiId == null) {
                str = "silentSignIn huaweiId is null";
            } else {
                str = "silentSignIn success";
            }
            aabz.aabb("HiHealthKitClient", str);
        }
    }

    private synchronized void aabc() {
        if (this.aab == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("kit_thread_handler");
            this.aab = baseHandlerThread;
            baseHandlerThread.start();
            this.aaba = new aabc(this.aab.getLooper());
        }
    }

    static /* synthetic */ void aabh(HiHealthKitClient hiHealthKitClient) {
        String str;
        List<Scope> list = hiHealthKitClient.aabb;
        if (list != null && !list.isEmpty()) {
            if (hiHealthKitClient.aabd == null) {
                aabz.aab("HiHealthKitClient", "mActivity is null");
                return;
            }
            Iterator<Scope> it = hiHealthKitClient.aabb.iterator();
            while (it.hasNext()) {
                if (it.next().getScopeUri() == null) {
                    aabz.aabc("HiHealthKitClient", "some scope url is null");
                    it.remove();
                }
            }
            HuaweiIdAuthParamsHelper huaweiIdAuthParamsHelper = new HuaweiIdAuthParamsHelper();
            if (hiHealthKitClient.aabb.isEmpty()) {
                aabz.aabb("HiHealthKitClient", "requestScopes scope array is empty");
            } else {
                aabz.aabb("HiHealthKitClient", "requestScopes scope array is not empty");
                huaweiIdAuthParamsHelper = huaweiIdAuthParamsHelper.setScopeList(hiHealthKitClient.aabb);
            }
            HuaweiIdAuthParams createParams = huaweiIdAuthParamsHelper.createParams();
            if (createParams == null) {
                str = "signIn authParams is null";
            } else {
                Activity activity = hiHealthKitClient.aabd;
                if (activity == null) {
                    str = "signIn mActivity is null";
                } else {
                    HuaweiIdAuthService service = HuaweiIdAuthManager.getService(activity.getApplicationContext(), createParams);
                    service.silentSignIn().addOnSuccessListener(new aabi(null)).addOnFailureListener(new com.huawei.hms.hihealth.aabb(hiHealthKitClient, service));
                    return;
                }
            }
            aabz.aab("HiHealthKitClient", str);
            return;
        }
        aabz.aabc("HiHealthKitClient", "scope list is invalid");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void aabj(HiHealthKitClient hiHealthKitClient) {
        if (hiHealthKitClient.aabk.get()) {
            hiHealthKitClient.aaba.removeMessages(1000);
            hiHealthKitClient.aaba();
            hiHealthKitClient.aabf = System.currentTimeMillis();
        }
    }

    public static HiHealthKitClient getInstance() {
        return aabh.aab;
    }

    public void addServiceDisconnectedListener(aabg aabgVar) {
        this.aabo.add(aabgVar);
    }

    public IInterface bindService(int i3) throws SecurityException {
        aacb.aab();
        return bindServiceWithOutCheckEmui(i3);
    }

    public IInterface bindServiceWithOutCheckEmui(int i3) throws SecurityException {
        this.aaba.removeMessages(1000);
        aab(true);
        IInterface aab2 = aack.aabf().aab(i3);
        if (aab2 != null && isConnected()) {
            return aab2;
        }
        aab();
        IBinder queryBinder = queryBinder(i3);
        if (queryBinder != null) {
            return new aabf(i3, queryBinder).aab();
        }
        aabz.aab("HiHealthKitClient", "queryBinder binder is null");
        return null;
    }

    public void connect() {
        if (this.aabk.get()) {
            return;
        }
        this.aabm.execute(new aaba());
    }

    public void connectHmsWithTransActivity(Activity activity) {
        com.huawei.hms.health.aabn aab2 = com.huawei.hms.health.aabk.aab(activity, new com.huawei.hms.health.aabl());
        if (this.aabj == null) {
            this.aabj = new CountDownLatch(1);
        }
        Checker.checkNonNull(new com.huawei.hms.health.aabo());
        Task<com.huawei.hms.health.aabp> doWrite = ((com.huawei.hms.health.aabj) aab2).doWrite(new com.huawei.hms.health.aabm("hihealth.getHmsHealthService", "HealthHmsInputBean"));
        if (com.huawei.hms.health.aabf.aaba() != null) {
            com.huawei.hms.health.aabf.aaba().sendEmptyMessageDelayed(2388, 1000L);
        }
        aab(doWrite);
    }

    public void countDownChange() {
        this.aabj.countDown();
    }

    public void delayedDisconnect() {
        if (this.aaba.hasMessages(1000)) {
            aabz.aabb("HiHealthKitClient", "delayedDisconnect remove first");
            this.aaba.removeMessages(1000);
        }
        if (this.aabc == null) {
            this.aaba.sendEmptyMessageDelayed(1000, 30000L);
            return;
        }
        int aabb2 = aaci.aabc().aabb();
        aabz.aabb("HiHealthKitClient", "delayedDisconnect " + aabb2);
        this.aaba.sendEmptyMessageDelayed(1000, (long) aabb2);
    }

    public void disconnect() {
        if (aacu.aab(this.aabf, 30000L)) {
            aabz.aabb("HiHealthKitClient", "disconnect immediately");
            if (this.aabk.get()) {
                this.aaba.removeMessages(1000);
                aaba();
                this.aabf = System.currentTimeMillis();
                return;
            }
            return;
        }
        if (this.aabh == null) {
            com.huawei.hms.hihealth.aaba aabaVar = new com.huawei.hms.hihealth.aaba(this);
            this.aabh = aabaVar;
            this.aabg.schedule(aabaVar, 10000L);
        }
    }

    public Context getContext() {
        return this.aabc;
    }

    public boolean isConnected() {
        return this.aabk.get();
    }

    public IBinder queryBinder(int i3) {
        String appId = Util.getAppId(this.aabc);
        if (!this.aabk.get()) {
            for (int i16 = 0; i16 < 5; i16++) {
                try {
                    LockMethodProxy.sleep(200);
                } catch (InterruptedException unused) {
                    aabz.aabb("HiHealthKitClient", "sleep error!");
                }
                if (this.aabk.get()) {
                    break;
                }
            }
            if (!this.aabk.get()) {
                aabz.aabc("HiHealthKitClient", "queryBinder not connected");
                if (this.aabl.get()) {
                    try {
                        this.aabc.unbindService(this.aabp);
                    } catch (IllegalArgumentException unused2) {
                        aabz.aab("HiHealthKitClient", "unbindService error");
                    }
                    this.aabl.getAndSet(false);
                    aabz.aabc("HiHealthKitClient", "unbind hmsService");
                }
                return null;
            }
        }
        com.huawei.hms.hihealth.aabh aabhVar = this.aabi;
        if (aabhVar != null) {
            try {
                ((aabh.aab.C0266aab) aabhVar).aab(this.aabn);
                return ((aabh.aab.C0266aab) this.aabi).aab(i3, appId);
            } catch (RemoteException unused3) {
                aabz.aabc("HiHealthKitClient", "queryBinder query failed");
                if (this.aabl.get()) {
                    try {
                        this.aabc.unbindService(this.aabp);
                    } catch (IllegalArgumentException unused4) {
                        aabz.aab("HiHealthKitClient", "unbind hmsService error");
                    }
                    this.aabl.getAndSet(false);
                    aabz.aabc("HiHealthKitClient", "unbind hmsService");
                }
                this.aabk.getAndSet(false);
            }
        }
        aabz.aabc("HiHealthKitClient", "queryBinder failed something happened");
        return null;
    }

    public void setContext(Context context) {
        aabz.aabb("HiHealthKitClient", "entry setContext,sdkVersion=6.11.0.303");
        this.aabc = context.getApplicationContext();
        if (context instanceof Activity) {
            this.aabe = (Activity) context;
        }
        aabc();
        this.aabg = new BaseTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaba() {
        String str;
        if (this.aabc == null) {
            aabz.aab("HiHealthKitClient", "disconnectWithHms, mContext is null");
            return;
        }
        if (this.aabl.get()) {
            aabz.aabb("HiHealthKitClient", "enter disconnectWithHms");
            try {
                this.aabc.unbindService(this.aabp);
            } catch (IllegalArgumentException unused) {
                str = "disconnectWithHms catch IllegalArgumentException";
                aabz.aaba("HiHealthKitClient", str);
                this.aabl.getAndSet(false);
                this.aabk.getAndSet(false);
                aabb();
                aabz.aabc("HiHealthKitClient", "unbind hmsService success");
            } catch (Exception unused2) {
                str = "disconnectWithHms catch basic exception";
                aabz.aaba("HiHealthKitClient", str);
                this.aabl.getAndSet(false);
                this.aabk.getAndSet(false);
                aabb();
                aabz.aabc("HiHealthKitClient", "unbind hmsService success");
            }
            this.aabl.getAndSet(false);
            this.aabk.getAndSet(false);
            aabb();
            aabz.aabc("HiHealthKitClient", "unbind hmsService success");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aabb() {
        aabz.aabb("HiHealthKitClient", "begin executeServiceDisconnectedListener");
        Iterator<aabg> it = this.aabo.iterator();
        while (it.hasNext()) {
            ((aacn) it.next()).aab();
        }
    }

    private void aab(Task<com.huawei.hms.health.aabp> task) {
        boolean z16;
        task.addOnFailureListener(new aabe(null)).addOnSuccessListener(new aabb(task));
        try {
            z16 = this.aabj.await(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            aabz.aabc("HiHealthKitClient", "connectWithHms connect service time out");
            z16 = false;
        }
        if (z16) {
            return;
        }
        aabz.aabc("HiHealthKitClient", "connectWithHms connect service time out without interruption");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab(boolean z16) {
        TimerTask timerTask = this.aabh;
        if (timerTask != null) {
            timerTask.cancel();
            this.aabh = null;
            if (z16) {
                aabz.aabb("HiHealthKitClient", "disconnect delay timer task delay");
                if (this.aabh == null) {
                    com.huawei.hms.hihealth.aaba aabaVar = new com.huawei.hms.hihealth.aaba(this);
                    this.aabh = aabaVar;
                    this.aabg.schedule(aabaVar, 10000L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        com.huawei.hms.health.aabn aab2;
        this.aaba.removeMessages(1000);
        if (this.aabk.get()) {
            return;
        }
        this.aabj = new CountDownLatch(1);
        if (this.aabe != null) {
            aabz.aabb("HiHealthKitClient", "enter connectWithHms with activity");
            aab2 = com.huawei.hms.health.aabk.aab(this.aabe, new com.huawei.hms.health.aabl());
            this.aabe = null;
        } else {
            aabz.aabb("HiHealthKitClient", "enter connectWithHms with context");
            aab2 = com.huawei.hms.health.aabk.aab(this.aabc, new com.huawei.hms.health.aabl());
        }
        if (this.aabj == null) {
            this.aabj = new CountDownLatch(1);
        }
        Checker.checkNonNull(new com.huawei.hms.health.aabo());
        aab(((com.huawei.hms.health.aabj) aab2).doWrite(new com.huawei.hms.health.aabm("hihealth.getHmsHealthService", "HealthHmsInputBean")));
    }
}
