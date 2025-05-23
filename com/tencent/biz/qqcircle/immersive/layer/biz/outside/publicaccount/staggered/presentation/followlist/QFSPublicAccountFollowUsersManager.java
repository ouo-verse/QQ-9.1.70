package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;
import uq3.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0002R\u0016\u0010\u0011\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u001b\u0010\u0019\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/QFSPublicAccountFollowUsersManager;", "", "", "d", "i", "", "c", "requestCount", "f", "", "b", "firstRequestTimeMs", "e", "", h.F, "g", "I", "intervalDurationS", "maxShowTimes", "J", "firstRequestTimestampS", "requestCounter", "Lkotlin/Lazy;", "a", "()Z", "featEnable", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountFollowUsersManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSPublicAccountFollowUsersManager f86913a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int intervalDurationS;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int maxShowTimes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long firstRequestTimestampS;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int requestCounter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy featEnable;

    static {
        Lazy lazy;
        QFSPublicAccountFollowUsersManager qFSPublicAccountFollowUsersManager = new QFSPublicAccountFollowUsersManager();
        f86913a = qFSPublicAccountFollowUsersManager;
        intervalDurationS = 86400;
        maxShowTimes = 10;
        firstRequestTimestampS = qFSPublicAccountFollowUsersManager.b();
        requestCounter = qFSPublicAccountFollowUsersManager.c();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist.QFSPublicAccountFollowUsersManager$featEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_public_account_follow_users_enable", true));
            }
        });
        featEnable = lazy;
        qFSPublicAccountFollowUsersManager.d();
    }

    QFSPublicAccountFollowUsersManager() {
    }

    private final boolean a() {
        return ((Boolean) featEnable.getValue()).booleanValue();
    }

    private final long b() {
        return k.a().f("mmkv_key_first_request_time_s", 0L);
    }

    private final int c() {
        return k.a().e("mmkv_key_current_request_count", 0);
    }

    private final void d() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("103172", "");
        if (TextUtils.isEmpty(loadAsString)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(loadAsString);
            intervalDurationS = jSONObject.optInt("interval_duration_s", 86400);
            maxShowTimes = jSONObject.optInt("max_show_times_per_interval", 10);
        } catch (Exception e16) {
            QLog.e("QFSPublicAccountFollowUsersManager", 1, "initConfig, parse json error:" + e16);
            intervalDurationS = 86400;
            maxShowTimes = 10;
        }
        QLog.i("QFSPublicAccountFollowUsersManager", 1, "initConfig, intervalDurationS:" + intervalDurationS + ", maxShowTimes:" + maxShowTimes);
    }

    private final void e(long firstRequestTimeMs) {
        k.a().n("mmkv_key_first_request_time_s", firstRequestTimeMs);
    }

    private final void f(int requestCount) {
        k.a().m("mmkv_key_current_request_count", requestCount);
    }

    private final void i() {
        if ((System.currentTimeMillis() / 1000) - firstRequestTimestampS >= intervalDurationS) {
            requestCounter = 0;
        }
    }

    public final void g() {
        int i3 = requestCounter + 1;
        requestCounter = i3;
        f(i3);
        if (requestCounter == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            firstRequestTimestampS = currentTimeMillis;
            e(currentTimeMillis);
        }
        QLog.i("QFSPublicAccountFollowUsersManager", 1, "saveRequestRecord, requestCounter:" + requestCounter + ", firstRequestTimestampS:" + firstRequestTimestampS);
    }

    public final boolean h() {
        i();
        if (a() && requestCounter < maxShowTimes) {
            return true;
        }
        return false;
    }
}
