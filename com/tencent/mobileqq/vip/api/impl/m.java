package com.tencent.mobileqq.vip.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasNtMMKV;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.lovechat.api.ILoveStateData;
import com.tencent.mobileqq.vas.utils.VasCommonUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.mobileqq.vip.api.i;
import com.tencent.pb.vipdata.userdata$UserData;
import com.tencent.pb.vipdata.vipdata$UserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ0\u0010\n\u001a\u00020\t2\u0014\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J,\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002J\u0018\u0010\u0013\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\rR\"\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/m;", "", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vip/api/j;", "changedCallbackList", "Lcom/tencent/mobileqq/vip/api/VipData;", "newData", "oldData", "", "e", "Lcom/tencent/pb/vipdata/vipdata$UserInfo;", "it", "", "randomKey", "f", "uin", "", "vipdataFlag", "d", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "dataCaches", "b", "Lcom/tencent/mobileqq/vip/api/VipData;", "defaultData", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ConcurrentHashMap<String, VipData> dataCaches;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VipData defaultData;

    public m() {
        ConcurrentHashMap<String, VipData> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        if (VasCommonUtils.INSTANCE.isMainProcess()) {
            concurrentHashMap = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap = null;
        }
        this.dataCaches = concurrentHashMap;
        this.defaultData = new VipData(false, 0L, false, false, 0, null, 0, 0, 0, 0, 0, 0, null, 0, false, 0L, false, 0, false, 524287, null);
    }

    private final void e(CopyOnWriteArrayList<WeakReference<com.tencent.mobileqq.vip.api.j>> changedCallbackList, VipData newData, VipData oldData) {
        if (changedCallbackList == null) {
            return;
        }
        try {
            Iterator<WeakReference<com.tencent.mobileqq.vip.api.j>> it = changedCallbackList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "changedCallbackList.iterator()");
            while (it.hasNext()) {
                WeakReference<com.tencent.mobileqq.vip.api.j> next = it.next();
                com.tencent.mobileqq.vip.api.j jVar = next.get();
                if (jVar == null) {
                    changedCallbackList.remove(next);
                } else {
                    jVar.changed(newData, oldData);
                }
            }
        } catch (Exception e16) {
            QLog.w(VipDataUtilsImpl.TAG, 1, "notifyChanged excep:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(VipData oldData, VipData data, long j3, String uin, HashMap hashMap) {
        HashSet<Long> hashSetOf;
        Intrinsics.checkNotNullParameter(oldData, "$oldData");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        String str = "";
        if (oldData.getColorName() != data.getColorName()) {
            i.C8957i c8957i = new i.C8957i(0);
            String str2 = (String) hashMap.get(Long.valueOf(j3));
            if (str2 == null) {
                str2 = "";
            }
            c8957i.e(false, j3, str2);
            i.C8957i c8957i2 = new i.C8957i(0);
            String str3 = (String) hashMap.get(Long.valueOf(j3));
            if (str3 == null) {
                str3 = "";
            }
            c8957i2.e(true, j3, str3);
        }
        if (oldData.getLoveChatItemId() != data.getLoveChatItemId() && Intrinsics.areEqual(uin, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()) && ((ILoveStateData) QRoute.api(ILoveStateData.class)).getLoveState() == 1) {
            try {
                final long parseLong = Long.parseLong(((ILoveStateData) QRoute.api(ILoveStateData.class)).getLoveUin());
                ag j16 = com.tencent.qqnt.msg.f.j();
                if (j16 != null) {
                    hashSetOf = SetsKt__SetsKt.hashSetOf(Long.valueOf(parseLong));
                    j16.getUid(hashSetOf, new IKernelGetUidInfoCallback() { // from class: com.tencent.mobileqq.vip.api.impl.l
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback
                        public final void onResult(HashMap hashMap2) {
                            m.h(parseLong, hashMap2);
                        }
                    });
                }
            } catch (Exception e16) {
                QLog.e(VipDataUtilsImpl.TAG, 1, e16, new Object[0]);
            }
        }
        if (oldData.getPendantItemId() != data.getPendantItemId()) {
            i.d dVar = new i.d(0L);
            String str4 = (String) hashMap.get(Long.valueOf(j3));
            if (str4 == null) {
                str4 = "";
            }
            dVar.e(false, j3, str4);
        }
        if (oldData.getNameplateItemId() != data.getNameplateItemId() || !oldData.getNameplateLetters().equals(data.getNameplateLetters())) {
            i.l lVar = new i.l(0);
            String str5 = (String) hashMap.get(Long.valueOf(j3));
            if (str5 == null) {
                str5 = "";
            }
            lVar.e(false, j3, str5);
            i.l lVar2 = new i.l(0);
            String str6 = (String) hashMap.get(Long.valueOf(j3));
            if (str6 == null) {
                str6 = "";
            }
            lVar2.e(true, j3, str6);
        }
        if (oldData.getSpecialAvatarId() != data.getSpecialAvatarId()) {
            i.e eVar = new i.e(0);
            String str7 = (String) hashMap.get(Long.valueOf(j3));
            if (str7 == null) {
                str7 = "";
            }
            eVar.e(false, j3, str7);
            i.e eVar2 = new i.e(0);
            String str8 = (String) hashMap.get(Long.valueOf(j3));
            if (str8 != null) {
                str = str8;
            }
            eVar2.e(true, j3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(long j3, HashMap hashMap) {
        i.c cVar = new i.c(0);
        String str = (String) hashMap.get(Long.valueOf(j3));
        if (str == null) {
            str = "";
        }
        cVar.e(false, j3, str);
    }

    @NotNull
    public final VipData c(@Nullable String uin) {
        VipData vipData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (VipData) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uin);
        }
        if (uin == null) {
            return this.defaultData;
        }
        ConcurrentHashMap<String, VipData> concurrentHashMap = this.dataCaches;
        if (concurrentHashMap != null && (vipData = concurrentHashMap.get(uin)) != null) {
            return vipData;
        }
        userdata$UserData userdata_userdata = null;
        byte[] decodeBytes = VasNtMMKV.INSTANCE.getVipDataPb().decodeBytes(uin, null);
        if (decodeBytes != null) {
            try {
                userdata_userdata = new userdata$UserData().mergeFrom(decodeBytes);
            } catch (Exception unused) {
                VasLogNtReporter.INSTANCE.getVipData().reportLow("mergeFrom error");
            }
        }
        if (userdata_userdata != null) {
            VipData a16 = VipData.INSTANCE.a(userdata_userdata);
            ConcurrentHashMap<String, VipData> concurrentHashMap2 = this.dataCaches;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.put(uin, a16);
                return a16;
            }
            return a16;
        }
        return this.defaultData;
    }

    @NotNull
    public final String d(@Nullable String uin, int vipdataFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin, vipdataFlag);
        }
        return "pb_" + String.valueOf(vipdataFlag);
    }

    public final void f(@NotNull vipdata$UserInfo it, @NotNull String randomKey, @Nullable CopyOnWriteArrayList<WeakReference<com.tencent.mobileqq.vip.api.j>> changedCallbackList) {
        long j3;
        VipData vipData;
        HashSet<Long> hashSetOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, it, randomKey, changedCallbackList);
            return;
        }
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(randomKey, "randomKey");
        com.tencent.mobileqq.vas.api.g gVar = com.tencent.mobileqq.vas.api.g.f308459b;
        if (gVar.isDebugVersion() && this.dataCaches == null) {
            throw new RuntimeException("\u4e0d\u5141\u8bb8\u5728\u975e\u4e3b\u8fdb\u7a0b\u5237\u65b0");
        }
        final String valueOf = String.valueOf(it.uin.get());
        VipNtMMKV.INSTANCE.getVipDataNeedRequest().removeKey(valueOf);
        userdata$UserData userdata_userdata = it.data.get();
        long j16 = userdata_userdata.f342178ts.get();
        VasNtMMKV.Companion companion = VasNtMMKV.INSTANCE;
        if (j16 < companion.getVipDataTimeStamp().decodeLong(valueOf, 0L)) {
            if (QLog.isColorLevel()) {
                VasLogNtReporter.INSTANCE.getVipData().reportLow("ts[" + j16 + "]\u4e0d\u7b26\u5408\u66f4\u65b0\u8981\u6c42");
                return;
            }
            return;
        }
        final VipData c16 = c(valueOf);
        VipData.Companion companion2 = VipData.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(userdata_userdata, "this");
        final VipData a16 = companion2.a(userdata_userdata);
        ConcurrentHashMap<String, VipData> concurrentHashMap = this.dataCaches;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(valueOf, a16);
        }
        final long j17 = it.uin.get();
        ag j18 = com.tencent.qqnt.msg.f.j();
        if (j18 != null) {
            hashSetOf = SetsKt__SetsKt.hashSetOf(Long.valueOf(j17));
            j3 = j16;
            vipData = a16;
            j18.getUid(hashSetOf, new IKernelGetUidInfoCallback() { // from class: com.tencent.mobileqq.vip.api.impl.k
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback
                public final void onResult(HashMap hashMap) {
                    m.g(VipData.this, a16, j17, valueOf, hashMap);
                }
            });
        } else {
            j3 = j16;
            vipData = a16;
        }
        e(changedCallbackList, vipData, c16);
        if (gVar.isDebugVersion()) {
            VasLogNtReporter.INSTANCE.getVipData().reportLow("uin[" + valueOf + "]~data[" + vipData.toJson() + "]");
        }
        companion.getVipDataPb().encodeBytes(valueOf, userdata_userdata.toByteArray());
        companion.getVipDataTimeStamp().encodeLong(valueOf, j3);
        companion.getVipDataRandomKey().encodeString(valueOf, randomKey);
    }
}
