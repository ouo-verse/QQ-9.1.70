package com.tencent.sqshow.zootopia.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019R<\u0010 \u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006 \u001e*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001d0\u001d0\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/g;", "", "", "a", "b", "c", "", "result", "", "g", "f", "useCache", "d", "", "Ljava/lang/String;", "PHONE_OPPOO_RENO7", "I", "getDEV_LEVEL_NONE", "()I", "setDEV_LEVEL_NONE", "(I)V", "DEV_LEVEL_NONE", "sDeviceLevel", "Lcom/tencent/sqshow/zootopia/utils/g$a;", "e", "Lcom/tencent/sqshow/zootopia/utils/g$a;", "mLowDeviceInfo", "mHighDeviceInfo", "Lmqq/util/WeakReference;", "Lkotlin/Pair;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "cacheHitPhoneModelResult", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g {

    /* renamed from: a */
    public static final g f373269a = new g();

    /* renamed from: b, reason: from kotlin metadata */
    private static final String PHONE_OPPOO_RENO7 = "oppo reno7";

    /* renamed from: c, reason: from kotlin metadata */
    private static int DEV_LEVEL_NONE;

    /* renamed from: d, reason: from kotlin metadata */
    private static int sDeviceLevel = DEV_LEVEL_NONE;

    /* renamed from: e, reason: from kotlin metadata */
    private static final a mLowDeviceInfo = new a(6, 0, 4294967296L);

    /* renamed from: f, reason: from kotlin metadata */
    private static final a mHighDeviceInfo = new a(8, 0, 8589934592L);

    /* renamed from: g, reason: from kotlin metadata */
    private static WeakReference<Pair<Boolean, Boolean>> cacheHitPhoneModelResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/g$a;", "", "", "a", "I", "()I", "setMCpuCoreNum", "(I)V", "mCpuCoreNum", "", "b", "J", "()J", "setMFreqKHz", "(J)V", "mFreqKHz", "c", "setMRamMemory", "mRamMemory", "cpuCoreNum", "freqKHz", "ramMemory", "<init>", "(IJJ)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a {

        /* renamed from: a, reason: from kotlin metadata */
        private int mCpuCoreNum;

        /* renamed from: b, reason: from kotlin metadata */
        private long mFreqKHz;

        /* renamed from: c, reason: from kotlin metadata */
        private long mRamMemory;

        public a(int i3, long j3, long j16) {
            this.mCpuCoreNum = i3;
            this.mFreqKHz = j3;
            this.mRamMemory = j16;
        }

        /* renamed from: a, reason: from getter */
        public final int getMCpuCoreNum() {
            return this.mCpuCoreNum;
        }

        /* renamed from: b, reason: from getter */
        public final long getMFreqKHz() {
            return this.mFreqKHz;
        }

        /* renamed from: c, reason: from getter */
        public final long getMRamMemory() {
            return this.mRamMemory;
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        cacheHitPhoneModelResult = new WeakReference<>(new Pair(bool, bool));
    }

    g() {
    }

    private final int a() {
        int i3 = sDeviceLevel;
        if (i3 != DEV_LEVEL_NONE) {
            return i3;
        }
        int b16 = b();
        sDeviceLevel = b16;
        if (b16 != DEV_LEVEL_NONE) {
            return b16;
        }
        sDeviceLevel = c();
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setInt("zplan_dev_level_key", sDeviceLevel);
        QLog.d("DeviceUtils", 1, "[getDeviceLevel] device level: " + sDeviceLevel);
        return sDeviceLevel;
    }

    private final int b() {
        try {
            Integer valueOf = Integer.valueOf(String.valueOf(((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getInt("zplan_dev_level_key", DEV_LEVEL_NONE)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(cacheVal.toString())");
            int intValue = valueOf.intValue();
            sDeviceLevel = intValue;
            return intValue;
        } catch (Throwable th5) {
            QLog.d("DeviceUtils", 1, "[getPrefDeviceLevel] error: ", th5);
            return DEV_LEVEL_NONE;
        }
    }

    private final int c() {
        int J = com.tencent.mobileqq.utils.ah.J();
        long m3 = com.tencent.mobileqq.utils.ah.m();
        long c16 = com.tencent.mobileqq.utils.m.c();
        a aVar = mHighDeviceInfo;
        if (J >= aVar.getMCpuCoreNum() && m3 >= aVar.getMFreqKHz() && c16 > aVar.getMRamMemory()) {
            sDeviceLevel = 3;
        } else {
            a aVar2 = mLowDeviceInfo;
            if (J > aVar2.getMCpuCoreNum() && c16 > aVar2.getMRamMemory()) {
                sDeviceLevel = 2;
            } else {
                sDeviceLevel = 1;
            }
        }
        return sDeviceLevel;
    }

    private final void g(boolean result) {
        cacheHitPhoneModelResult = new WeakReference<>(new Pair(Boolean.TRUE, Boolean.valueOf(result)));
    }

    public final boolean f() {
        return a() == 1;
    }

    public final boolean d(boolean useCache) {
        boolean contains$default;
        if (useCache) {
            Pair<Boolean, Boolean> pair = cacheHitPhoneModelResult.get();
            if (pair != null && pair.getFirst().booleanValue()) {
                Pair<Boolean, Boolean> pair2 = cacheHitPhoneModelResult.get();
                if (pair2 != null) {
                    return pair2.getSecond().booleanValue();
                }
                return false;
            }
        }
        List<String> zPlanPagSoDecoderPhoneList = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZPlanPagSoDecoderPhoneList();
        QLog.d("DeviceUtils", 1, "list= " + zPlanPagSoDecoderPhoneList);
        List<String> list = zPlanPagSoDecoderPhoneList;
        if (list == null || list.isEmpty()) {
            g(false);
            return false;
        }
        int size = zPlanPagSoDecoderPhoneList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String MODEL = DeviceInfoMonitor.getModel();
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = MODEL.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String str = zPlanPagSoDecoderPhoneList.get(i3);
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase2 = str.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null);
            if (contains$default) {
                g(true);
                return true;
            }
        }
        g(false);
        return false;
    }

    public static /* synthetic */ boolean e(g gVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return gVar.d(z16);
    }
}
