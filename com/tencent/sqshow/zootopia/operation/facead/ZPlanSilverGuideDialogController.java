package com.tencent.sqshow.zootopia.operation.facead;

import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.MinSilverConfig;
import com.tencent.sqshow.utils.featureswitch.model.ShowSilverGuideConditionsConfig;
import com.tencent.sqshow.zootopia.operation.ConditionsCache;
import com.tencent.sqshow.zootopia.operation.SilverDialogParams;
import com.tencent.sqshow.zootopia.operation.SilverGuideType;
import com.tencent.sqshow.zootopia.operation.ZPlanSilverGuideDialog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.Calendar;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0006\u0010\u0010\u001a\u00020\rJ\u001e\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013J\u0006\u0010\u0016\u001a\u00020\u0002R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\u001d8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/ZPlanSilverGuideDialogController;", "", "Lcom/tencent/sqshow/zootopia/operation/a;", "data", "", "j", "", "b", "", "l", "bytes", "d", "cache", "", "i", tl.h.F, "c", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function0;", "confirmCallback", "k", "e", "Lcom/tencent/sqshow/utils/featureswitch/model/l;", "a", "Lkotlin/Lazy;", "f", "()Lcom/tencent/sqshow/utils/featureswitch/model/l;", "portalSilverGuideConfig", "Lcom/tencent/sqshow/zootopia/operation/SilverGuideType;", "g", "()Lcom/tencent/sqshow/zootopia/operation/SilverGuideType;", "silverGuideType", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanSilverGuideDialogController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy portalSilverGuideConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy silverGuideType;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f372126a;

        static {
            int[] iArr = new int[SilverGuideType.values().length];
            try {
                iArr[SilverGuideType.TYPE_SILVER_LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SilverGuideType.TYPE_SILVER_SUFFICIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f372126a = iArr;
        }
    }

    public ZPlanSilverGuideDialogController() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ShowSilverGuideConditionsConfig>() { // from class: com.tencent.sqshow.zootopia.operation.facead.ZPlanSilverGuideDialogController$portalSilverGuideConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShowSilverGuideConditionsConfig invoke() {
                return ZPlanQQMC.INSTANCE.getPortalSilverGuideConfig2();
            }
        });
        this.portalSilverGuideConfig = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SilverGuideType>() { // from class: com.tencent.sqshow.zootopia.operation.facead.ZPlanSilverGuideDialogController$silverGuideType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SilverGuideType invoke() {
                ShowSilverGuideConditionsConfig f16;
                ShowSilverGuideConditionsConfig f17;
                int b16 = com.tencent.sqshow.zootopia.operation.f.f372119a.b();
                f16 = ZPlanSilverGuideDialogController.this.f();
                if (b16 > f16.getMinSilverThreshold()) {
                    f17 = ZPlanSilverGuideDialogController.this.f();
                    if (b16 >= f17.getMaxSilverThreshold()) {
                        return SilverGuideType.TYPE_SILVER_SUFFICIENT;
                    }
                    return SilverGuideType.TYPE_NO_NEED;
                }
                return SilverGuideType.TYPE_SILVER_LOW;
            }
        });
        this.silverGuideType = lazy2;
    }

    private final String b() {
        String currentUin = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        return currentUin + "_ZPLAN_SILVER_GUIDE_KEY" + g().name();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShowSilverGuideConditionsConfig f() {
        return (ShowSilverGuideConditionsConfig) this.portalSilverGuideConfig.getValue();
    }

    private final boolean h(ConditionsCache cache) {
        int todayShowTimes;
        long todayFirstShowMilliSeconds = cache.getTodayFirstShowMilliSeconds();
        long currentTimeMillis = System.currentTimeMillis();
        if (todayFirstShowMilliSeconds == 0) {
            cache.e(currentTimeMillis);
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(todayFirstShowMilliSeconds));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
            int i3 = b.f372126a[g().ordinal()];
            if (i3 == 1) {
                todayShowTimes = f().getMinSilverConfig().getTodayShowTimes();
            } else {
                if (i3 != 2) {
                    return false;
                }
                todayShowTimes = f().getMaxSilverConfig().getTodayShowTimes();
            }
            return cache.getTodayShowTimes() < todayShowTimes;
        }
        cache.e(currentTimeMillis);
        cache.f(0);
        return true;
    }

    private final boolean i(ConditionsCache cache) {
        int totalDays;
        int totalShowTimes;
        long totalFirstShowSeconds = cache.getTotalFirstShowSeconds();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (totalFirstShowSeconds == 0) {
            cache.g(currentTimeMillis);
            cache.h(0);
            return true;
        }
        SilverGuideType g16 = g();
        int[] iArr = b.f372126a;
        int i3 = iArr[g16.ordinal()];
        if (i3 == 1) {
            totalDays = f().getMinSilverConfig().getTotalDays();
        } else {
            if (i3 != 2) {
                return false;
            }
            totalDays = f().getMaxSilverConfig().getTotalDays();
        }
        if (currentTimeMillis > totalFirstShowSeconds + (totalDays * 86400)) {
            cache.g(currentTimeMillis);
            cache.h(0);
            return true;
        }
        int i16 = iArr[g().ordinal()];
        if (i16 == 1) {
            totalShowTimes = f().getMinSilverConfig().getTotalShowTimes();
        } else {
            if (i16 != 2) {
                return false;
            }
            totalShowTimes = f().getMaxSilverConfig().getTotalShowTimes();
        }
        return cache.getTotalShowTimes() < totalShowTimes;
    }

    private final void j(ConditionsCache data) {
        QLog.i("ZPlanSilverGuideDialogController", 1, "setCache, data: " + data);
        byte[] l3 = l(data);
        if (l3 != null) {
            if (l3.length == 0) {
                return;
            }
            try {
                ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBytes(b(), l3);
            } catch (Throwable th5) {
                QLog.e("ZPlanSilverGuideDialogController", 1, "setCache failed.", th5);
            }
        }
    }

    private final byte[] l(ConditionsCache data) {
        try {
            String json = new Gson().toJson(data);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(data)");
            byte[] bytes = json.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        } catch (Throwable th5) {
            QLog.e("ZPlanSilverGuideDialogController", 2, "toBytes error", th5);
            return null;
        }
    }

    public final boolean c() {
        if (g() == SilverGuideType.TYPE_NO_NEED) {
            QLog.i("ZPlanSilverGuideDialogController", 1, "displayConditions false, silverGuideType TYPE_NO_NEED.");
            return false;
        }
        ConditionsCache e16 = e();
        if (!i(e16)) {
            QLog.i("ZPlanSilverGuideDialogController", 1, "displayConditions false, isInTotalDayRange false");
            return false;
        }
        if (!h(e16)) {
            QLog.i("ZPlanSilverGuideDialogController", 1, "displayConditions false, isInTodayRange false");
            return false;
        }
        e16.h(e16.getTotalShowTimes() + 1);
        e16.f(e16.getTodayShowTimes() + 1);
        j(e16);
        return true;
    }

    public final ConditionsCache e() {
        QLog.i("ZPlanSilverGuideDialogController", 1, "getCache");
        try {
            byte[] bytes = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBytes(b(), new byte[0]);
            if (!(bytes.length == 0)) {
                return d(bytes);
            }
            return new ConditionsCache(0L, 0, 0L, 0, 15, null);
        } catch (Throwable th5) {
            QLog.e("ZPlanSilverGuideDialogController", 1, "getCache failed.", th5);
            return new ConditionsCache(0L, 0, 0L, 0, 15, null);
        }
    }

    public final SilverGuideType g() {
        return (SilverGuideType) this.silverGuideType.getValue();
    }

    public final void k(final FragmentManager fragmentManager, final Function0<Unit> confirmCallback) {
        Intrinsics.checkNotNullParameter(confirmCallback, "confirmCallback");
        QLog.i("ZPlanSilverGuideDialogController", 1, "showADDialog");
        if (fragmentManager == null) {
            QLog.e("ZPlanSilverGuideDialogController", 1, "showADDialog failed, fragment null.");
            return;
        }
        int b16 = com.tencent.sqshow.zootopia.operation.f.f372119a.b();
        int i3 = b.f372126a[g().ordinal()];
        boolean z16 = false;
        if (i3 == 1 ? b16 <= f().getMinSilverThreshold() : !(i3 != 2 || b16 < f().getMaxSilverThreshold())) {
            z16 = true;
        }
        if (!z16) {
            QLog.e("ZPlanSilverGuideDialogController", 1, "showADDialog failed, canShow false. currSilverNum: " + b16 + ", silverGuideConfigTag: " + g().name());
            return;
        }
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.operation.facead.ZPlanSilverGuideDialogController$showADDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ShowSilverGuideConditionsConfig f16;
                int minSilverThreshold;
                ShowSilverGuideConditionsConfig f17;
                ShowSilverGuideConditionsConfig f18;
                if (ZPlanSilverGuideDialogController.this.g() != SilverGuideType.TYPE_SILVER_SUFFICIENT) {
                    f16 = ZPlanSilverGuideDialogController.this.f();
                    minSilverThreshold = f16.getMinSilverThreshold();
                } else {
                    minSilverThreshold = com.tencent.sqshow.zootopia.operation.f.f372119a.b();
                }
                SilverGuideType g16 = ZPlanSilverGuideDialogController.this.g();
                f17 = ZPlanSilverGuideDialogController.this.f();
                MinSilverConfig minSilverConfig = f17.getMinSilverConfig();
                f18 = ZPlanSilverGuideDialogController.this.f();
                ZPlanSilverGuideDialog.INSTANCE.a(fragmentManager, new SilverDialogParams(minSilverThreshold, g16, minSilverConfig, f18.getMaxSilverConfig()), confirmCallback);
            }
        });
    }

    private final ConditionsCache d(byte[] bytes) {
        try {
            if (bytes == null) {
                return new ConditionsCache(0L, 0, 0L, 0, 15, null);
            }
            Object fromJson = new Gson().fromJson(new String(bytes, Charsets.UTF_8), (Class<Object>) ConditionsCache.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(String(d\u2026ditionsCache::class.java)");
            return (ConditionsCache) fromJson;
        } catch (Throwable th5) {
            QLog.e("ZPlanSilverGuideDialogController", 2, "fromBytes error", th5);
            return new ConditionsCache(0L, 0, 0L, 0, 15, null);
        }
    }
}
