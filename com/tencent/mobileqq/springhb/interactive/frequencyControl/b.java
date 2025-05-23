package com.tencent.mobileqq.springhb.interactive.frequencyControl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001bR0\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R0\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!R0\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001dj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!R0\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010!R0\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010!R0\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001dj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010!\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/frequencyControl/b;", "Lcom/tencent/mobileqq/springhb/interactive/api/a;", "Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord;", QQPermissionConstants.Permission.AUIDO_GROUP, "", "e", "f", "g", h.F, "", "time", "", "k", "i", "j", "", "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "r", "msg", "a", "b", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkv", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "guestPlayCountMap", "d", "guestPlayCountPerDayMap", "guestLastPlayTimeMap", "totalPlayCountMap", "totalPlayCountPerDayMap", "totalLastPlayTimeMap", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b implements com.tencent.mobileqq.springhb.interactive.api.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f289236a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MMKVOptionEntity mmkv;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, Integer> guestPlayCountMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Integer> guestPlayCountPerDayMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, Long> guestLastPlayTimeMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, Integer> totalPlayCountMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Integer> totalPlayCountPerDayMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, Long> totalLastPlayTimeMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21136);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f289236a = new b();
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026), QMMKVFile.FILE_COMMON)");
        mmkv = from;
        guestPlayCountMap = new HashMap<>();
        guestPlayCountPerDayMap = new HashMap<>();
        guestLastPlayTimeMap = new HashMap<>();
        totalPlayCountMap = new HashMap<>();
        totalPlayCountPerDayMap = new HashMap<>();
        totalLastPlayTimeMap = new HashMap<>();
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(InteractiveRecord record) {
        Intrinsics.checkNotNullParameter(record, "$record");
        b bVar = f289236a;
        bVar.o(record);
        bVar.p(record);
        bVar.q(record);
        if (!record.b()) {
            bVar.l(record);
            bVar.m(record);
            bVar.n(record);
        }
    }

    private final boolean e(InteractiveRecord record) {
        if (record.p().triggerLimit == 0) {
            return false;
        }
        if (record.p().triggerLimit < 0) {
            return true;
        }
        long j3 = record.p().businessID;
        HashMap<Long, Integer> hashMap = guestPlayCountMap;
        Integer num = hashMap.get(Long.valueOf(j3));
        if (num == null) {
            num = Integer.valueOf(mmkv.decodeInt("AIO_POP_ANIM_GUEST_PLAY_COUNT_" + j3, 0));
            hashMap.put(Long.valueOf(j3), num);
        }
        if (num.intValue() >= record.p().triggerLimit) {
            return false;
        }
        return true;
    }

    private final boolean f(InteractiveRecord record) {
        if (record.p().triggerLimitPerDay == 0) {
            return false;
        }
        if (record.p().triggerLimitPerDay < 0) {
            return true;
        }
        String k3 = k(NetConnInfoCenter.getServerTimeMillis());
        long j3 = record.p().businessID;
        String str = k3 + j3;
        HashMap<String, Integer> hashMap = guestPlayCountPerDayMap;
        Integer num = hashMap.get(str);
        if (num == null) {
            String str2 = "AIO_POP_ANIM_GUEST_PLAY_COUNT_SAVE_TIME_" + j3;
            String str3 = "AIO_POP_ANIM_GUEST_PLAY_COUNT_PER_DAY_" + j3;
            MMKVOptionEntity mMKVOptionEntity = mmkv;
            if (Intrinsics.areEqual(mMKVOptionEntity.decodeString(str2, ""), k3)) {
                num = Integer.valueOf(mMKVOptionEntity.decodeInt(str3, 0));
            } else {
                mMKVOptionEntity.encodeInt(str3, 0);
                mMKVOptionEntity.encodeString(str2, k3);
                num = 0;
            }
            hashMap.put(str, num);
        }
        if (num.intValue() >= record.p().triggerLimitPerDay) {
            return false;
        }
        return true;
    }

    private final boolean g(InteractiveRecord record) {
        if (record.p().timeInterval <= 0) {
            return true;
        }
        long j3 = record.p().businessID;
        HashMap<Long, Long> hashMap = guestLastPlayTimeMap;
        Long l3 = hashMap.get(Long.valueOf(j3));
        if (l3 == null) {
            l3 = Long.valueOf(mmkv.decodeLong("AIO_POP_ANIM_GUEST_LAST_PLAY_TIME_" + j3, 0L));
            hashMap.put(Long.valueOf(j3), l3);
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (serverTimeMillis < l3.longValue() || serverTimeMillis - l3.longValue() > record.p().timeInterval) {
            return true;
        }
        return false;
    }

    private final boolean h(InteractiveRecord record) {
        if (record.p().totalTriggerLimit == 0) {
            return false;
        }
        if (record.p().totalTriggerLimit < 0) {
            return true;
        }
        long j3 = record.p().businessID;
        HashMap<Long, Integer> hashMap = totalPlayCountMap;
        Integer num = hashMap.get(Long.valueOf(j3));
        if (num == null) {
            num = Integer.valueOf(mmkv.decodeInt("AIO_POP_ANIM_TOTAL_PLAY_COUNT_" + j3, 0));
            hashMap.put(Long.valueOf(j3), num);
        }
        if (num.intValue() >= record.p().totalTriggerLimit) {
            return false;
        }
        return true;
    }

    private final boolean i(InteractiveRecord record) {
        if (record.p().totalTriggerLimitPerDay == 0) {
            return false;
        }
        if (record.p().totalTriggerLimitPerDay < 0) {
            return true;
        }
        String k3 = k(NetConnInfoCenter.getServerTimeMillis());
        long j3 = record.p().businessID;
        String str = k3 + j3;
        HashMap<String, Integer> hashMap = totalPlayCountPerDayMap;
        Integer num = hashMap.get(str);
        if (num == null) {
            String str2 = "AIO_POP_ANIM_TOTAL_PLAY_COUNT_SAVE_TIME_" + j3;
            String str3 = "AIO_POP_ANIM_TOTAL_PLAY_COUNT_PER_DAY_" + j3;
            MMKVOptionEntity mMKVOptionEntity = mmkv;
            if (Intrinsics.areEqual(mMKVOptionEntity.decodeString(str2, ""), k3)) {
                num = Integer.valueOf(mMKVOptionEntity.decodeInt(str3, 0));
            } else {
                mMKVOptionEntity.encodeInt(str3, 0);
                mMKVOptionEntity.encodeString(str2, k3);
                num = 0;
            }
            hashMap.put(str, num);
        }
        if (num.intValue() >= record.p().totalTriggerLimitPerDay) {
            return false;
        }
        return true;
    }

    private final boolean j(InteractiveRecord record) {
        if (record.p().totalTimeInterval <= 0) {
            return true;
        }
        long j3 = record.p().businessID;
        HashMap<Long, Long> hashMap = totalLastPlayTimeMap;
        Long l3 = hashMap.get(Long.valueOf(j3));
        if (l3 == null) {
            l3 = Long.valueOf(mmkv.decodeLong("AIO_POP_ANIM_TOTAL_LAST_PLAY_TIME_" + j3, 0L));
            hashMap.put(Long.valueOf(j3), l3);
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (serverTimeMillis < l3.longValue() || serverTimeMillis - l3.longValue() > record.p().totalTimeInterval) {
            return true;
        }
        return false;
    }

    private final String k(long time) {
        String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date(time));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"yyyy-MM-dd\").format(Date(time))");
        return format;
    }

    private final void l(InteractiveRecord record) {
        long j3 = record.p().businessID;
        Integer num = guestPlayCountMap.get(Long.valueOf(j3));
        if (num == null) {
            num = 0;
        }
        int intValue = num.intValue();
        if (intValue > 0) {
            mmkv.encodeInt("AIO_POP_ANIM_GUEST_PLAY_COUNT_" + j3, intValue);
        }
    }

    private final void m(InteractiveRecord record) {
        String k3 = k(NetConnInfoCenter.getServerTimeMillis());
        long j3 = record.p().businessID;
        Integer num = guestPlayCountPerDayMap.get(k3 + j3);
        if (num == null) {
            num = 0;
        }
        int intValue = num.intValue();
        if (intValue > 0) {
            String str = "AIO_POP_ANIM_GUEST_PLAY_COUNT_SAVE_TIME_" + j3;
            MMKVOptionEntity mMKVOptionEntity = mmkv;
            mMKVOptionEntity.encodeInt("AIO_POP_ANIM_GUEST_PLAY_COUNT_PER_DAY_" + j3, intValue);
            mMKVOptionEntity.encodeString(str, k3);
        }
    }

    private final void n(InteractiveRecord record) {
        long j3 = record.p().businessID;
        Long l3 = guestLastPlayTimeMap.get(Long.valueOf(j3));
        if (l3 == null) {
            l3 = 0L;
        }
        long longValue = l3.longValue();
        if (longValue > 0) {
            mmkv.encodeLong("AIO_POP_ANIM_GUEST_LAST_PLAY_TIME_" + j3, longValue);
        }
    }

    private final void o(InteractiveRecord record) {
        long j3 = record.p().businessID;
        Integer num = totalPlayCountMap.get(Long.valueOf(j3));
        if (num == null) {
            num = 0;
        }
        int intValue = num.intValue();
        if (intValue > 0) {
            mmkv.encodeInt("AIO_POP_ANIM_TOTAL_PLAY_COUNT_" + j3, intValue);
        }
    }

    private final void p(InteractiveRecord record) {
        String k3 = k(NetConnInfoCenter.getServerTimeMillis());
        long j3 = record.p().businessID;
        Integer num = totalPlayCountPerDayMap.get(k3 + j3);
        if (num == null) {
            num = 0;
        }
        int intValue = num.intValue();
        if (intValue > 0) {
            String str = "AIO_POP_ANIM_TOTAL_PLAY_COUNT_SAVE_TIME_" + j3;
            MMKVOptionEntity mMKVOptionEntity = mmkv;
            mMKVOptionEntity.encodeInt("AIO_POP_ANIM_TOTAL_PLAY_COUNT_PER_DAY_" + j3, intValue);
            mMKVOptionEntity.encodeString(str, k3);
        }
    }

    private final void q(InteractiveRecord record) {
        long j3 = record.p().businessID;
        Long l3 = totalLastPlayTimeMap.get(Long.valueOf(j3));
        if (l3 == null) {
            l3 = 0L;
        }
        long longValue = l3.longValue();
        if (longValue > 0) {
            mmkv.encodeLong("AIO_POP_ANIM_TOTAL_LAST_PLAY_TIME_" + j3, longValue);
        }
    }

    private final void r(InteractiveRecord record) {
        long j3 = record.p().businessID;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        String str = k(serverTimeMillis) + j3;
        HashMap<Long, Integer> hashMap = totalPlayCountMap;
        Long valueOf = Long.valueOf(j3);
        Integer num = hashMap.get(Long.valueOf(j3));
        Integer num2 = 0;
        if (num == null) {
            num = num2;
        }
        hashMap.put(valueOf, Integer.valueOf(num.intValue() + 1));
        HashMap<String, Integer> hashMap2 = totalPlayCountPerDayMap;
        Integer num3 = hashMap2.get(str);
        if (num3 == null) {
            num3 = num2;
        }
        hashMap2.put(str, Integer.valueOf(num3.intValue() + 1));
        Long valueOf2 = Long.valueOf(j3);
        Long valueOf3 = Long.valueOf(serverTimeMillis);
        HashMap<Long, Long> hashMap3 = totalLastPlayTimeMap;
        hashMap3.put(valueOf2, valueOf3);
        if (!record.b()) {
            HashMap<Long, Integer> hashMap4 = guestPlayCountMap;
            Long valueOf4 = Long.valueOf(j3);
            Integer num4 = hashMap4.get(Long.valueOf(j3));
            if (num4 == null) {
                num4 = num2;
            }
            hashMap4.put(valueOf4, Integer.valueOf(num4.intValue() + 1));
            HashMap<String, Integer> hashMap5 = guestPlayCountPerDayMap;
            Integer num5 = hashMap5.get(str);
            if (num5 != null) {
                num2 = num5;
            }
            hashMap5.put(str, Integer.valueOf(num2.intValue() + 1));
            guestLastPlayTimeMap.put(Long.valueOf(j3), Long.valueOf(serverTimeMillis));
        }
        QLog.d("DefaultFrequencyController", 1, "updatePlayData businessID:" + j3 + ",", "totalPlayCount:" + hashMap.get(Long.valueOf(j3)) + ",", "totalPlayCountPerDay:" + hashMap2.get(str) + ",", "totalLastPlayTime:" + hashMap3.get(Long.valueOf(j3)) + ",", "guestPlayCount:" + guestPlayCountMap.get(Long.valueOf(j3)) + ",", "guestPlayCountPerDay:" + guestPlayCountPerDayMap.get(str) + ",", "guestLastPlayTime:" + guestLastPlayTimeMap.get(Long.valueOf(j3)));
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.a
    public boolean a(@NotNull InteractiveRecord msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode() && !msg2.p().isSupportChildrenMode) {
            QLog.d("DefaultFrequencyController", 1, "needShow don't support StudyMode");
            return false;
        }
        if (!h(msg2)) {
            QLog.d("DefaultFrequencyController", 1, "needShow exceed TotalPlayCount");
            return false;
        }
        if (!i(msg2)) {
            QLog.d("DefaultFrequencyController", 1, "needShow exceed TotalPlayCountPerDay");
            return false;
        }
        if (!j(msg2)) {
            QLog.d("DefaultFrequencyController", 1, "needShow exceed TotalPlayInterval");
            return false;
        }
        if (!msg2.b()) {
            if (!e(msg2)) {
                QLog.d("DefaultFrequencyController", 1, "needShow exceed GuestPlayCount");
                return false;
            }
            if (!f(msg2)) {
                QLog.d("DefaultFrequencyController", 1, "needShow exceed GuestPlayCountPerDay");
                return false;
            }
            if (!g(msg2)) {
                QLog.d("DefaultFrequencyController", 1, "needShow exceed GuestPlayInterval");
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.a
    public void b(@NotNull final InteractiveRecord record) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) record);
            return;
        }
        Intrinsics.checkNotNullParameter(record, "record");
        r(record);
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.springhb.interactive.frequencyControl.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d(InteractiveRecord.this);
            }
        });
    }
}
