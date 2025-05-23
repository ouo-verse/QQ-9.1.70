package com.tencent.mobileqq.troop.utils.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0015*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/utils/api/impl/TroopBeaconReporter;", "Lcom/tencent/mobileqq/troop/utils/api/ITroopBeaconReporter;", "()V", "KEY_APP_ENV", "", "KEY_IMEI_36", "KEY_NETWORK_TYPE", "KEY_OS", "KEY_QQ", "TAG", "VALUE_NON_PUBLIC_VERSION", "", "VALUE_OS", "VALUE_PUBLIC_VERSION", "report", "", "event", "params", "", "", "appendCommonParams", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopBeaconReporter implements ITroopBeaconReporter {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final TroopBeaconReporter INSTANCE;

    @NotNull
    private static final String KEY_APP_ENV = "app_env";

    @NotNull
    private static final String KEY_IMEI_36 = "qimei36";

    @NotNull
    private static final String KEY_NETWORK_TYPE = "network_type";

    @NotNull
    private static final String KEY_OS = "os";

    @NotNull
    private static final String KEY_QQ = "qq";

    @NotNull
    private static final String TAG = "TroopBeaconReporter";
    private static final int VALUE_NON_PUBLIC_VERSION = 0;

    @NotNull
    private static final String VALUE_OS = "Android";
    private static final int VALUE_PUBLIC_VERSION = 1;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62045);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new TroopBeaconReporter();
        }
    }

    TroopBeaconReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, Object> appendCommonParams(Map<String, ? extends Object> map) {
        Map<String, Object> mutableMap;
        String str;
        Map<? extends String, ? extends Object> mapOf;
        mutableMap = MapsKt__MapsKt.toMutableMap(map);
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to(KEY_APP_ENV, Integer.valueOf(AppSetting.isPublicVersion() ? 1 : 0));
        pairArr[1] = TuplesKt.to("os", "Android");
        pairArr[2] = TuplesKt.to("network_type", Integer.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.context)));
        pairArr[3] = TuplesKt.to("qimei36", o.c());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "MobileQQ.sMobileQQ.peekA\u2026?.currentAccountUin ?: \"\"");
        }
        pairArr[4] = TuplesKt.to("qq", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        mutableMap.putAll(mapOf);
        return mutableMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void report$lambda$1(Map map, AppRuntime app, String str) {
        Map hashMap;
        Map<String, Object> appendCommonParams;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(app, "$app");
        if (map != null && (appendCommonParams = INSTANCE.appendCommonParams(map)) != null) {
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(appendCommonParams.size());
            hashMap = new LinkedHashMap(mapCapacity);
            Iterator<T> it = appendCommonParams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        } else {
            hashMap = new HashMap();
        }
        QQBeaconReport.report(app.getCurrentUin(), str, (Map<String, String>) hashMap, true);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter
    public void report(@Nullable final String event, @Nullable final Map<String, ? extends Object> params) {
        final AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) event, (Object) params);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "event=" + event + ", params=" + params);
        }
        if (event == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                TroopBeaconReporter.report$lambda$1(params, peekAppRuntime, event);
            }
        }, 16, null, false);
    }
}
