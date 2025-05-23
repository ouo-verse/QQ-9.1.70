package com.tencent.biz.qqcircle.immersive.part.addtabguide;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0004R\u0016\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u0017\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/addtabguide/QFSQCircleAddTabManager;", "", "Lorg/json/JSONObject;", h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "f", "showCount", "j", "", "c", "firstShowTimeS", "i", "", "g", "l", "k", "b", "J", "firstShowTimestampS", "I", "showCounter", "d", "Lkotlin/Lazy;", "()Z", "featEnable", "e", "()I", "intervalDurationS", "maxShowTimes", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSQCircleAddTabManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSQCircleAddTabManager f87671a;

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
        QFSQCircleAddTabManager qFSQCircleAddTabManager = new QFSQCircleAddTabManager();
        f87671a = qFSQCircleAddTabManager;
        firstShowTimestampS = qFSQCircleAddTabManager.c();
        showCounter = qFSQCircleAddTabManager.f();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.biz.qqcircle.immersive.part.addtabguide.QFSQCircleAddTabManager$featEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_add_to_qq_tab_enable", true));
            }
        });
        featEnable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.biz.qqcircle.immersive.part.addtabguide.QFSQCircleAddTabManager$intervalDurationS$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                JSONObject h16;
                h16 = QFSQCircleAddTabManager.f87671a.h();
                int optInt = h16.optInt("interval_duration_s", 86400);
                QLog.i("QFSQCircleAddTabManager", 1, "intervalDurationS:" + optInt);
                return Integer.valueOf(optInt);
            }
        });
        intervalDurationS = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.biz.qqcircle.immersive.part.addtabguide.QFSQCircleAddTabManager$maxShowTimes$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                JSONObject h16;
                h16 = QFSQCircleAddTabManager.f87671a.h();
                int optInt = h16.optInt("max_show_times_per_interval", 1);
                QLog.i("QFSQCircleAddTabManager", 1, "maxShowTimes:" + optInt);
                return Integer.valueOf(optInt);
            }
        });
        maxShowTimes = lazy3;
    }

    QFSQCircleAddTabManager() {
    }

    private final boolean b() {
        return ((Boolean) featEnable.getValue()).booleanValue();
    }

    private final long c() {
        return k.a().f("mmkv_key_bottom_guide_pop_first_show_time_s", 0L);
    }

    private final int d() {
        return ((Number) intervalDurationS.getValue()).intValue();
    }

    private final int e() {
        return ((Number) maxShowTimes.getValue()).intValue();
    }

    private final int f() {
        return k.a().e("mmkv_key_bottom_guide_pop_current_show_count", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject h() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_set_qvideo_as_bottom_tab_guide_frequency_control", "");
        if (TextUtils.isEmpty(loadAsString)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(loadAsString);
        } catch (Exception e16) {
            QLog.e("QFSQCircleAddTabManager", 1, "loadConfig, parse json error:" + e16);
            return new JSONObject();
        }
    }

    private final void i(long firstShowTimeS) {
        k.a().n("mmkv_key_bottom_guide_pop_first_show_time_s", firstShowTimeS);
    }

    private final void j(int showCount) {
        k.a().m("mmkv_key_bottom_guide_pop_current_show_count", showCount);
    }

    private final void m() {
        if ((System.currentTimeMillis() / 1000) - firstShowTimestampS >= d()) {
            showCounter = 0;
        }
    }

    public final boolean g() {
        return b();
    }

    public final void k() {
        int i3 = showCounter + 1;
        showCounter = i3;
        j(i3);
        if (showCounter == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            firstShowTimestampS = currentTimeMillis;
            i(currentTimeMillis);
        }
        QLog.i("QFSQCircleAddTabManager", 1, "saveShowRecord, showCounter:" + showCounter + ", firstShowTimestampS:" + firstShowTimestampS);
    }

    public final boolean l() {
        boolean z16;
        m();
        if (showCounter < e()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("QFSQCircleAddTabManager", 1, "shouldShowBottomGuidePop, result:" + z16);
        return z16;
    }
}
