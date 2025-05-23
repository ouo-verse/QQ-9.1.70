package com.tencent.sqshow.zootopia.nativeui.view.detail.recommend;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanFilamentRecommendAntiDisturbConfig;
import com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.IStateChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/a;", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/IStateChangeListener;", "", "c", "", "time", "", "e", "b", "d", "f", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/IStateChangeListener$State;", "oldState", "newState", "a", "", "Ljava/lang/String;", "mKeyAccountAntiDisturb", "Lcom/tencent/sqshow/utils/featureswitch/model/w;", "Lcom/tencent/sqshow/utils/featureswitch/model/w;", "mAntiDisturbConfig", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements IStateChangeListener {

    /* renamed from: d, reason: collision with root package name */
    private static String f371713d = "key_filament_recommend_anti_disturb_time_stamp";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZPlanFilamentRecommendAntiDisturbConfig mAntiDisturbConfig = ZPlanQQMC.INSTANCE.getFilamentRecommendAntiDisturbConfig();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String mKeyAccountAntiDisturb = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "_" + f371713d;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f371716a;

        static {
            int[] iArr = new int[IStateChangeListener.State.values().length];
            try {
                iArr[IStateChangeListener.State.FOLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IStateChangeListener.State.EXPAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f371716a = iArr;
        }
    }

    private final long b() {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getLong(this.mKeyAccountAntiDisturb, 0L);
    }

    private final boolean c() {
        long b16 = b();
        QLog.i("AvatarRecommendAntiDisturbController", 1, "isAntiDisturbInEffect lastDisturbTime=" + b16);
        if (b16 == 0) {
            return false;
        }
        long currentTimeMillis = (System.currentTimeMillis() - b16) / 1000;
        QLog.i("AvatarRecommendAntiDisturbController", 1, "isAntiDisturbInEffect disturbDuration=" + currentTimeMillis + ", configDuration=" + this.mAntiDisturbConfig.getAntiDisturbDurationSecond());
        return currentTimeMillis < ((long) this.mAntiDisturbConfig.getAntiDisturbDurationSecond());
    }

    private final void e(long time) {
        if (b() > 0) {
            QLog.i("AvatarRecommendAntiDisturbController", 1, "saveAntiDisturbTime isAntiDisturbInEffect, no save");
            return;
        }
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setLong(this.mKeyAccountAntiDisturb, time);
        QLog.i("AvatarRecommendAntiDisturbController", 1, "saveAntiDisturbTime time=" + time);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.IStateChangeListener
    public void a(IStateChangeListener.State oldState, IStateChangeListener.State newState) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        int i3 = b.f371716a[newState.ordinal()];
        if (i3 == 1) {
            e(System.currentTimeMillis());
        } else {
            if (i3 != 2) {
                return;
            }
            d();
        }
    }

    public final boolean f() {
        return !c();
    }

    private final void d() {
        QLog.i("AvatarRecommendAntiDisturbController", 1, "resetAntiDisturbTime");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setLong(this.mKeyAccountAntiDisturb, 0L);
    }
}
