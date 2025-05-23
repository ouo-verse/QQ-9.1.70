package cooperation.vip.ad;

import cooperation.vip.tianshu.TianShuMMKVUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcooperation/vip/ad/o;", "", "", "adId", "", tl.h.F, "g", "d", "", "j", "c", "f", "", "b", "a", "Lcooperation/vip/ad/GrowHalfLayerInfo;", "growHalfLayerInfoCache", "i", "e", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f391192a = new o();

    o() {
    }

    private final String a(int adId) {
        return "sp_key_user_leading_last_pre_load_time_stamp_" + adId;
    }

    private final String b(int adId) {
        return "sp_key_user_leading_request_num_" + adId;
    }

    @JvmStatic
    public static final void c(int adId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        TianShuMMKVUtil.g(peekAppRuntime.getCurrentAccountUin()).removeKey(f391192a.a(adId));
    }

    @JvmStatic
    public static final void d(int adId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        TianShuMMKVUtil.g(peekAppRuntime.getCurrentAccountUin()).removeKey(f391192a.b(adId));
    }

    @JvmStatic
    public static final long f(int adId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return System.currentTimeMillis();
        }
        return TianShuMMKVUtil.g(peekAppRuntime.getCurrentAccountUin()).getLong(f391192a.a(adId), System.currentTimeMillis());
    }

    @JvmStatic
    public static final int g(int adId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 0;
        }
        return TianShuMMKVUtil.g(peekAppRuntime.getCurrentAccountUin()).getInt(f391192a.b(adId), 0);
    }

    @JvmStatic
    public static final void h(int adId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        TianShuMMKVUtil g16 = TianShuMMKVUtil.g(peekAppRuntime.getCurrentAccountUin());
        o oVar = f391192a;
        TianShuMMKVUtil.g(peekAppRuntime.getCurrentAccountUin()).putInt(oVar.b(adId), g16.getInt(oVar.b(adId), 0) + 1);
    }

    @JvmStatic
    public static final long j(int adId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TianShuMMKVUtil g16 = TianShuMMKVUtil.g(peekAppRuntime.getCurrentAccountUin());
        o oVar = f391192a;
        long j3 = g16.getLong(oVar.a(adId), 0L);
        TianShuMMKVUtil.g(peekAppRuntime.getCurrentAccountUin()).putLong(oVar.a(adId), currentTimeMillis);
        if (j3 <= 0) {
            return 0L;
        }
        return currentTimeMillis - j3;
    }

    @Nullable
    public final GrowHalfLayerInfo e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return (GrowHalfLayerInfo) TianShuMMKVUtil.g(peekAppRuntime.getCurrentAccountUin()).getParcelable("sp_key_grow_half_layer_cache", GrowHalfLayerInfo.class, null);
    }

    public final void i(@Nullable GrowHalfLayerInfo growHalfLayerInfoCache) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        TianShuMMKVUtil.g(peekAppRuntime.getCurrentAccountUin()).putParcelable("sp_key_grow_half_layer_cache", growHalfLayerInfoCache);
    }
}
