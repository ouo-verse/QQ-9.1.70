package com.tencent.mobileqq.zplan.show;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.SuperQQShowConfig;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\bR\u001b\u0010\u0010\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0014\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/show/SuperQQShowGuideDialogConfig;", "", "", "b", "c", "a", "", "f", "", h.F, "g", "i", "Lcom/tencent/sqshow/utils/featureswitch/model/n;", "Lkotlin/Lazy;", "d", "()Lcom/tencent/sqshow/utils/featureswitch/model/n;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "e", "()Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "zPlanMMKV", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SuperQQShowGuideDialogConfig {

    /* renamed from: a, reason: collision with root package name */
    public static final SuperQQShowGuideDialogConfig f335621a = new SuperQQShowGuideDialogConfig();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy zPlanMMKV;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SuperQQShowConfig>() { // from class: com.tencent.mobileqq.zplan.show.SuperQQShowGuideDialogConfig$config$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuperQQShowConfig invoke() {
                return ZPlanQQMC.INSTANCE.getSuperQQShowGuideConfig();
            }
        });
        config = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IZPlanMMKVApi>() { // from class: com.tencent.mobileqq.zplan.show.SuperQQShowGuideDialogConfig$zPlanMMKV$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IZPlanMMKVApi invoke() {
                QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
                return (IZPlanMMKVApi) api;
            }
        });
        zPlanMMKV = lazy2;
    }

    SuperQQShowGuideDialogConfig() {
    }

    private final String a() {
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            e16 = "";
        }
        return e16 + "SHOW_FROM_ENTER_AIO";
    }

    private final String b() {
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            e16 = "";
        }
        return e16 + "SHOW_FROM_USER_CLICK";
    }

    private final String c() {
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            e16 = "";
        }
        return e16 + "CURRENT_SHOW_TIME";
    }

    private final IZPlanMMKVApi e() {
        return (IZPlanMMKVApi) zPlanMMKV.getValue();
    }

    public final SuperQQShowConfig d() {
        return (SuperQQShowConfig) config.getValue();
    }

    public final boolean f() {
        return e().getBoolean(a(), true);
    }

    public final void h() {
        e().setBoolean(a(), false);
    }

    public final void i() {
        e().setBoolean(b(), false);
    }

    public final boolean g() {
        boolean z16;
        try {
            String b16 = b();
            String c16 = c();
            z16 = e().getBoolean(b16, true);
            if (z16) {
                try {
                    int i3 = e().getInt(c16, 1);
                    if (i3 >= d().getShowTimes()) {
                        e().setBoolean(b16, false);
                    }
                    e().setInt(c16, i3 + 1);
                } catch (Exception e16) {
                    e = e16;
                    QLog.i("SuperQQShowGuideDialogConfig", 1, e.toString());
                    return z16;
                }
            }
        } catch (Exception e17) {
            e = e17;
            z16 = true;
        }
        return z16;
    }
}
