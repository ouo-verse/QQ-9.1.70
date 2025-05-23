package com.tencent.mobileqq.utils.abtest;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.event.open.EventType;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tab.exp.sdk.export.config.TabEnvironment;
import com.tencent.tab.exp.sdk.impl.TabExpDependInjector;
import com.tencent.tab.exp.sdk.impl.k;
import com.tencent.tab.exp.sdk.impl.l;
import com.tencent.tab.exp.sdk.impl.m;
import com.tencent.tab.exp.sdk.impl.o;
import com.tencent.tab.exp.sdk.impl.q;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class ABHolder {
    private static final int DEFAULT_REQUEST_TIMEOUT = 30;
    private static final String QQ_DOMAIN_URL = "https://qqdata.ab.qq.com";
    private static final String QQ_EXPERIMENT_DATA_APP_KEY = "0DOU0FJX7W40ANTK";
    private static final int STATE_NOTINIT = 0;
    private static final int STATE_RUNNING = 1;
    private static final int STATE_SUCCESS = 2;
    private static final String TAG = "ABTestController";
    private static final AtomicBoolean tabInitTaskInvoked = new AtomicBoolean(false);
    protected final String appIdx;
    private final String appKey;
    private volatile String expGuid;
    private final Map<String, String> profiles;
    private final String sceneId;
    private volatile m tabExpInstance;
    private final AtomicInteger tabInitState = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements md4.a {
        a() {
        }

        @Override // md4.a
        public boolean a(Map<String, String> map) {
            EventResult report = BeaconReport.getInstance().report(BeaconEvent.builder().withCode("rqd_tfm_metrics").withParams(map).withAppKey("0DOU0NXHEH4H15C5").build());
            if (report != null && report.isSuccess()) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements hd4.a {
        b() {
        }

        @Override // hd4.a
        public boolean b(@NonNull @android.support.annotation.NonNull hd4.b bVar) {
            EventType eventType;
            if (bVar.d()) {
                eventType = EventType.REALTIME;
            } else {
                eventType = EventType.NORMAL;
            }
            EventResult report = BeaconReport.getInstance().report(BeaconEvent.builder().withAppKey(bVar.c()).withCode(bVar.a()).withParams(bVar.b()).withType(eventType).withIsSucceed(bVar.e()).build());
            if (report != null && report.isSuccess()) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements dd4.a {
        c() {
        }

        @Override // dd4.a
        public void d(String str, String str2) {
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, str2);
            }
        }

        @Override // dd4.a
        public void i(String str, String str2) {
            QLog.i(str, 1, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ABHolder(String str, String str2, String str3, String str4, Map<String, String> map) {
        this.profiles = map;
        this.appIdx = str;
        this.appKey = str2;
        this.sceneId = str3;
        this.expGuid = str4;
        ABTestUtil.log("create ABHolder:" + toString());
        if (!isTabInited()) {
            ABTestUtil.log(TAG, "checkInit when [BOOT_FROM_USER] for:" + toString());
            if (tabInitTaskInvoked.compareAndSet(false, true)) {
                try {
                    ABTestUtil.log("TabExpInitTask#init called:" + System.currentTimeMillis());
                    l.a(MobileQQ.sMobileQQ);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, e16, new Object[0]);
                }
            }
            checkInitStateBeforeQueryExpEntity();
        }
    }

    private q createTabParams(String str) {
        boolean z16;
        if (1 == MobileQQ.sProcessId) {
            z16 = true;
        } else {
            z16 = false;
        }
        ABTestUtil.log(TAG, "createTabParams AtMainProcess: " + z16);
        return new q.b().w(this.appIdx).C(str).x(this.appKey).G(this.sceneId).A(TabEnvironment.RELEASE).F(30).h(true).i(false).l(z16).m(this.profiles).j(null).y(QQ_EXPERIMENT_DATA_APP_KEY).E(QQ_DOMAIN_URL).z();
    }

    private TabExpDependInjector getLogDependInjector() {
        return new TabExpDependInjector.b().b(new c()).d(new b()).c(new a()).a();
    }

    private k getTabExpInfo(@NonNull String str, boolean z16) {
        cd4.c d16;
        if (!isTabInited()) {
            ABTestUtil.log(TAG, "checkInit when [GetTabExpInfo] name: " + str);
            checkInitStateBeforeQueryExpEntity();
        }
        if (!TextUtils.isEmpty(str) && isTabInited() && (d16 = this.tabExpInstance.d()) != null) {
            if (z16) {
                return d16.c(str, false);
            }
            return d16.a(str, false);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkInitStateBeforeQueryExpEntity$1(com.tencent.tab.exp.sdk.export.injector.network.b bVar) {
        boolean d16 = com.tencent.tab.exp.sdk.export.injector.network.b.d(bVar);
        int i3 = 0;
        ABTestUtil.log(String.format("start tab sdk. appId: %s succ: %s, code: %s, msg: %s", this.appIdx, Boolean.valueOf(d16), Integer.valueOf(bVar.a()), bVar.b()));
        AtomicInteger atomicInteger = this.tabInitState;
        if (d16) {
            i3 = 2;
        }
        atomicInteger.set(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkSwitchWhenAccountReceive$2(com.tencent.tab.exp.sdk.export.injector.network.b bVar) {
        ABTestUtil.log(String.format("switchGuid succ: %s, code: %s, msg: %s", Boolean.valueOf(com.tencent.tab.exp.sdk.export.injector.network.b.d(bVar)), Integer.valueOf(bVar.a()), bVar.b()));
    }

    protected synchronized void checkInitStateBeforeQueryExpEntity() {
        if (this.tabInitState.compareAndSet(0, 1)) {
            if (this.tabExpInstance == null) {
                this.tabExpInstance = o.c().a(createTabParams(this.expGuid), getLogDependInjector());
            }
            if (this.tabExpInstance != null) {
                ABTestUtil.log("checkInit. tabExpInstance#start sdk. from=" + hashCode());
                this.tabExpInstance.e(new kd4.a() { // from class: com.tencent.mobileqq.utils.abtest.b
                    @Override // kd4.a
                    public final void a(com.tencent.tab.exp.sdk.export.injector.network.b bVar) {
                        ABHolder.this.lambda$checkInitStateBeforeQueryExpEntity$1(bVar);
                    }
                });
                this.tabInitState.set(2);
            } else {
                QLog.e(TAG, 1, new Throwable("create tabExpInstance null"), new Object[0]);
                this.tabInitState.set(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void checkSwitchWhenAccountReceive(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(this.expGuid, str)) {
            this.expGuid = str;
            if (this.tabExpInstance == null) {
                this.tabExpInstance = o.c().a(createTabParams(str), getLogDependInjector());
            }
            if (this.tabExpInstance != null) {
                ABTestUtil.log("[ACCOUNT_CHANGED] switchGuid: " + toString());
                this.tabExpInstance.f(str, new kd4.a() { // from class: com.tencent.mobileqq.utils.abtest.c
                    @Override // kd4.a
                    public final void a(com.tencent.tab.exp.sdk.export.injector.network.b bVar) {
                        ABHolder.lambda$checkSwitchWhenAccountReceive$2(bVar);
                    }
                });
            }
            return;
        }
        ABTestUtil.log("[ACCOUNT_CHANGED] when uin unexpected:" + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean clearExpData(@NonNull String str) {
        cd4.c d16;
        if (!isTabInited()) {
            ABTestUtil.log(TAG, "checkInit when [clearExpData] layerCode: " + str);
            checkInitStateBeforeQueryExpEntity();
        }
        if (!TextUtils.isEmpty(str) && isTabInited() && (d16 = this.tabExpInstance.d()) != null) {
            d16.d(str);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public ExpEntityInfo getExpEntity(@NonNull String str, boolean z16) {
        k tabExpInfo = getTabExpInfo(str, z16);
        if (tabExpInfo != null) {
            return new ExpEntityInfo(this.appIdx, tabExpInfo);
        }
        return new ExpEntityInfo(this.appIdx, str, "", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isTabInited() {
        if (this.tabExpInstance != null && this.tabInitState.get() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportExposure(final k kVar) {
        if (kVar != null && isTabInited()) {
            final cd4.c d16 = this.tabExpInstance.d();
            if (d16 != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.utils.abtest.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        cd4.c.this.b(kVar);
                    }
                }, 128, null, false);
            } else {
                ABTestUtil.log(TAG, "reportExpExposure when ITabExperiment null");
            }
        }
    }

    public String toString() {
        return String.format("ABSDKHolder{appId=%s, appKey=%s, sceneId=%s, expGuid=%s}", this.appIdx, this.appKey, this.sceneId, this.expGuid);
    }
}
