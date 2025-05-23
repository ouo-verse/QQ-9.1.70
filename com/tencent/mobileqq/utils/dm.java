package com.tencent.mobileqq.utils;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\t\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/utils/dm;", "", "", "b", "", "", "", "Ljava/util/Map;", "defaultUsedMap", "c", "Z", "a", "()Z", "(Z)V", "currentUsedV3", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class dm {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final dm f307679a = new dm();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Integer> defaultUsedMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean currentUsedV3;

    static {
        Map<String, Integer> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("", -1));
        defaultUsedMap = mutableMapOf;
    }

    dm() {
    }

    public final boolean a() {
        return currentUsedV3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b() {
        Integer drawerUIForm;
        int i3;
        if (((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getTestAndVibrateValue()) {
            return true;
        }
        String accountUid = RFWApplication.getAccountId();
        Map<String, Integer> map = defaultUsedMap;
        Intrinsics.checkNotNullExpressionValue(accountUid, "accountUid");
        Object obj = map.get(accountUid);
        if (obj == null) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            int i16 = fromV2.getInt("IS_USED_DRAWER_UI_V3", -1, true);
            if (i16 != -1) {
                Pair pair = TuplesKt.to(accountUid, Integer.valueOf(i16));
                map.put(pair.getFirst(), pair.getSecond());
            }
            obj = Integer.valueOf(i16);
        }
        int intValue = ((Number) obj).intValue();
        if (intValue != -1) {
            QLog.i("QQSettingTypeManager", 1, "1 [isUsedV3]: defalutUsedMap is :  " + map + ", accountUid: " + accountUid + ", value: " + intValue);
            if (intValue == 1) {
                return true;
            }
            return false;
        }
        QQSettingMeViewListBean b16 = dl.f307676a.b();
        if (b16 != null && (drawerUIForm = b16.getDrawerUIForm()) != null) {
            int intValue2 = drawerUIForm.intValue();
            if (intValue2 == 1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            Pair pair2 = TuplesKt.to(accountUid, Integer.valueOf(i3));
            map.put(pair2.getFirst(), pair2.getSecond());
            QLog.i("QQSettingTypeManager", 1, "2 [isUsedV3]: defalutUsedMap is :  " + map + ", accountUid: " + accountUid);
            if (intValue2 == 1) {
                return true;
            }
            return false;
        }
        Pair pair3 = TuplesKt.to(accountUid, 1);
        map.put(pair3.getFirst(), pair3.getSecond());
        QLog.i("QQSettingTypeManager", 1, "3 [isUsedV3]: defalutUsedMap i s :  " + map + ", accountUid: " + accountUid);
        return true;
    }

    public final void c(boolean z16) {
        currentUsedV3 = z16;
    }
}
