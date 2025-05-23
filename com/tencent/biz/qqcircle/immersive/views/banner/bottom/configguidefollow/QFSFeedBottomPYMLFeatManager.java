package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

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
import uq3.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0004R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0016\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/configguidefollow/QFSFeedBottomPYMLFeatManager;", "", "Lorg/json/JSONObject;", "g", "", "l", "", "f", "showCount", "i", "", "c", "firstShowTimeS", tl.h.F, "", "k", "j", "b", "J", "firstShowTimestampS", "I", "showCounter", "d", "Lkotlin/Lazy;", "()Z", "featEnable", "e", "()I", "intervalDurationS", "maxShowTimes", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSFeedBottomPYMLFeatManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSFeedBottomPYMLFeatManager f90657a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long firstShowTimestampS;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int showCounter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy featEnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy intervalDurationS;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy maxShowTimes;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        QFSFeedBottomPYMLFeatManager qFSFeedBottomPYMLFeatManager = new QFSFeedBottomPYMLFeatManager();
        f90657a = qFSFeedBottomPYMLFeatManager;
        firstShowTimestampS = qFSFeedBottomPYMLFeatManager.c();
        showCounter = qFSFeedBottomPYMLFeatManager.f();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSFeedBottomPYMLFeatManager$featEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_guide_follow_view_pyml_enable", true));
            }
        });
        featEnable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSFeedBottomPYMLFeatManager$intervalDurationS$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                JSONObject g16;
                g16 = QFSFeedBottomPYMLFeatManager.f90657a.g();
                int optInt = g16.optInt("interval_duration_s", 86400);
                QLog.i("QFSFeedBottomPYMLFeatManager", 1, "intervalDurationS:" + optInt);
                return Integer.valueOf(optInt);
            }
        });
        intervalDurationS = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSFeedBottomPYMLFeatManager$maxShowTimes$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                JSONObject g16;
                g16 = QFSFeedBottomPYMLFeatManager.f90657a.g();
                int optInt = g16.optInt("max_show_times_per_interval", 3);
                QLog.i("QFSFeedBottomPYMLFeatManager", 1, "maxShowTimes:" + optInt);
                return Integer.valueOf(optInt);
            }
        });
        maxShowTimes = lazy3;
    }

    QFSFeedBottomPYMLFeatManager() {
    }

    private final boolean b() {
        return ((Boolean) featEnable.getValue()).booleanValue();
    }

    private final long c() {
        return k.a().f("mmkv_key_pyml_first_show_time_s", 0L);
    }

    private final int d() {
        return ((Number) intervalDurationS.getValue()).intValue();
    }

    private final int e() {
        return ((Number) maxShowTimes.getValue()).intValue();
    }

    private final int f() {
        return k.a().e("mmkv_key_pyml_current_show_count", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject g() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("103237", "");
        if (TextUtils.isEmpty(loadAsString)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(loadAsString);
        } catch (Exception e16) {
            QLog.e("QFSFeedBottomPYMLFeatManager", 1, "loadConfig, parse json error:" + e16);
            return new JSONObject();
        }
    }

    private final void h(long firstShowTimeS) {
        k.a().n("mmkv_key_pyml_first_show_time_s", firstShowTimeS);
    }

    private final void i(int showCount) {
        k.a().m("mmkv_key_pyml_current_show_count", showCount);
    }

    private final void l() {
        if ((System.currentTimeMillis() / 1000) - firstShowTimestampS >= d()) {
            showCounter = 0;
        }
    }

    public final void j() {
        int i3 = showCounter + 1;
        showCounter = i3;
        i(i3);
        if (showCounter == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            firstShowTimestampS = currentTimeMillis;
            h(currentTimeMillis);
        }
        QLog.i("QFSFeedBottomPYMLFeatManager", 1, "saveShowRecord, showCounter:" + showCounter + ", firstShowTimestampS:" + firstShowTimestampS);
    }

    public final boolean k() {
        boolean z16;
        l();
        if (b() && showCounter < e()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("QFSFeedBottomPYMLFeatManager", 1, "shouldShowFollowPYML, result:" + z16);
        return z16;
    }
}
