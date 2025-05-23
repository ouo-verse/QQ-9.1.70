package com.tencent.mobileqq.mutualmark;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.x;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import tencent.im.mutualmark.mutualmark$MutualMark;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b$MutualMarkData;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MutualMarkDataS2CHandleHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static Comparator<com.tencent.mobileqq.mutualmark.info.d> f251954a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f251959a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f251960b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f251961c;

        a(int i3, QQAppInterface qQAppInterface, String str) {
            this.f251959a = i3;
            this.f251960b = qQAppInterface;
            this.f251961c = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), qQAppInterface, str);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else if ((this.f251959a & 2) != 0) {
                this.f251960b.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, this.f251961c);
                com.tencent.mobileqq.mutualmark.nt.f.f252196a.p(this.f251961c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements Comparator<com.tencent.mobileqq.mutualmark.info.d> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.mutualmark.info.d dVar, com.tencent.mobileqq.mutualmark.info.d dVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) dVar2)).intValue();
            }
            return dVar.f252128t - dVar2.f252128t;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73262);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f251954a = new b();
        }
    }

    private static int a(QQAppInterface qQAppInterface, ExtensionInfo extensionInfo, String str, Oidb_0xd6b$MutualMarkData oidb_0xd6b$MutualMarkData, int i3, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar) {
        ArrayList arrayList = new ArrayList();
        if (oidb_0xd6b$MutualMarkData.mutualmark_info.has() && oidb_0xd6b$MutualMarkData.mutualmark_info.size() > 0) {
            Iterator<mutualmark$MutualMark> it = oidb_0xd6b$MutualMarkData.mutualmark_info.get().iterator();
            int i16 = 0;
            while (it.hasNext()) {
                com.tencent.mobileqq.mutualmark.info.e a16 = com.tencent.mobileqq.mutualmark.info.e.a(it.next());
                a16.f252150v = i16;
                i16++;
                arrayList.add(a16);
                if (!TextUtils.isEmpty(a16.f252142n) && !TextUtils.isEmpty(a16.f252143o)) {
                    f.b(qQAppInterface).a(a16.f252142n, a16.f252143o);
                }
            }
        }
        p(arrayList, extensionInfo, aVar);
        int i17 = i3 | 1;
        if (!arrayList.isEmpty()) {
            QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + str + " pullInfos:" + arrayList);
        }
        return i17;
    }

    private static int b(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, String str, Oidb_0xd6b$MutualMarkData oidb_0xd6b$MutualMarkData, int i3) {
        ArrayList arrayList = new ArrayList();
        if (oidb_0xd6b$MutualMarkData.mutualmark_info.has() && oidb_0xd6b$MutualMarkData.mutualmark_info.size() > 0) {
            Iterator<mutualmark$MutualMark> it = oidb_0xd6b$MutualMarkData.mutualmark_info.get().iterator();
            int i16 = 0;
            while (it.hasNext()) {
                com.tencent.mobileqq.mutualmark.info.e a16 = com.tencent.mobileqq.mutualmark.info.e.a(it.next());
                a16.f252150v = i16;
                i16++;
                arrayList.add(a16);
                if (!TextUtils.isEmpty(a16.f252142n) && !TextUtils.isEmpty(a16.f252143o)) {
                    f.b(qQAppInterface).a(a16.f252142n, a16.f252143o);
                }
            }
        }
        q(arrayList, aVar);
        int i17 = i3 | 1;
        if (!arrayList.isEmpty()) {
            QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + str + " pullInfos:" + arrayList);
        }
        return i17;
    }

    @NotNull
    private static com.tencent.mobileqq.mutualmark.info.d c(com.tencent.mobileqq.mutualmark.info.a aVar, com.tencent.mobileqq.mutualmark.info.e eVar, com.tencent.mobileqq.mutualmark.info.d dVar) {
        ConcurrentHashMap<Long, com.tencent.mobileqq.mutualmark.info.d> concurrentHashMap = aVar.f252067a;
        if (concurrentHashMap != null) {
            dVar = concurrentHashMap.get(Long.valueOf(eVar.f252129a));
        }
        if (dVar == null) {
            return new com.tencent.mobileqq.mutualmark.info.d();
        }
        return dVar;
    }

    @NotNull
    private static com.tencent.mobileqq.mutualmark.info.d d(com.tencent.mobileqq.mutualmark.info.f fVar, com.tencent.mobileqq.mutualmark.info.e eVar, com.tencent.mobileqq.mutualmark.info.d dVar) {
        ConcurrentHashMap<Long, com.tencent.mobileqq.mutualmark.info.d> concurrentHashMap = fVar.f252151a;
        if (concurrentHashMap != null) {
            dVar = concurrentHashMap.get(Long.valueOf(eVar.f252129a));
        }
        if (dVar == null) {
            return new com.tencent.mobileqq.mutualmark.info.d();
        }
        return dVar;
    }

    @Nullable
    private static com.tencent.mobileqq.mutualmark.info.d e(com.tencent.mobileqq.mutualmark.info.d dVar, List<com.tencent.mobileqq.mutualmark.info.d> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.tencent.mobileqq.mutualmark.info.d dVar2 = list.get(i3);
            if (dVar2 != null && dVar2.f252109a == dVar.f252109a) {
                dVar2.f252125q = dVar.f252125q;
                dVar2.f252126r = dVar.f252126r;
                return dVar2;
            }
        }
        return null;
    }

    public static void f(QQAppInterface qQAppInterface, Oidb_0xd6b$MutualMarkData oidb_0xd6b$MutualMarkData) {
        if (oidb_0xd6b$MutualMarkData == null) {
            return;
        }
        long j3 = oidb_0xd6b$MutualMarkData.uint64_frd_uin.get();
        if (j3 <= 0) {
            return;
        }
        String valueOf = String.valueOf(j3);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf);
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(uidFromUin, "MutualMarkDataS2CHandleHelper");
        if (intimateSimpleInfoWithUid == null) {
            intimateSimpleInfoWithUid = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(uidFromUin, valueOf);
        }
        int j16 = j(qQAppInterface, intimateSimpleInfoWithUid, valueOf, oidb_0xd6b$MutualMarkData);
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(uidFromUin, valueOf);
        aVar.q();
        if ((j16 & 1) != 0) {
            ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).accurateUpdateIntimateSimpleInfo(aVar, "MutualMarkDataS2CHandleHelper_handleGet0x5e0MutualMarkData", new a(j16, qQAppInterface, valueOf));
        }
    }

    public static boolean g(QQAppInterface qQAppInterface, ExtensionInfo extensionInfo, String str, byte[] bArr) {
        int i3;
        if (bArr != null && bArr.length > 0) {
            Oidb_0xd6b$MutualMarkData oidb_0xd6b$MutualMarkData = new Oidb_0xd6b$MutualMarkData();
            try {
                oidb_0xd6b$MutualMarkData.mergeFrom(bArr);
            } catch (Exception e16) {
                e16.printStackTrace();
                oidb_0xd6b$MutualMarkData = null;
            }
            if (oidb_0xd6b$MutualMarkData == null) {
                return false;
            }
            i3 = h(qQAppInterface, extensionInfo, str, oidb_0xd6b$MutualMarkData);
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return false;
        }
        return true;
    }

    private static int h(QQAppInterface qQAppInterface, ExtensionInfo extensionInfo, String str, Oidb_0xd6b$MutualMarkData oidb_0xd6b$MutualMarkData) {
        return i(qQAppInterface, extensionInfo, str, oidb_0xd6b$MutualMarkData, null);
    }

    private static int i(QQAppInterface qQAppInterface, ExtensionInfo extensionInfo, String str, Oidb_0xd6b$MutualMarkData oidb_0xd6b$MutualMarkData, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar) {
        int i3;
        if (oidb_0xd6b$MutualMarkData.uint32_result.has()) {
            i3 = oidb_0xd6b$MutualMarkData.uint32_result.get();
        } else {
            i3 = -1;
        }
        if (i3 != 0 || extensionInfo == null) {
            return 0;
        }
        return a(qQAppInterface, extensionInfo, str, oidb_0xd6b$MutualMarkData, 0, aVar);
    }

    private static int j(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, String str, Oidb_0xd6b$MutualMarkData oidb_0xd6b$MutualMarkData) {
        int i3;
        if (oidb_0xd6b$MutualMarkData.uint32_result.has()) {
            i3 = oidb_0xd6b$MutualMarkData.uint32_result.get();
        } else {
            i3 = -1;
        }
        if (i3 != 0 || aVar == null) {
            return 0;
        }
        return b(qQAppInterface, aVar, str, oidb_0xd6b$MutualMarkData, 0);
    }

    public static void k(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("add_mutualmark_graytips_ignore_update_data", true);
        if (r(xVar, aVar)) {
            if (xVar.f180249c == 1) {
                c.m(qQAppInterface, xVar.f180248b, aVar, xVar.f());
            }
            com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar2 = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(aVar.getUid(), aVar.n());
            aVar2.q();
            aVar2.z(aVar.m());
            ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).accurateUpdateIntimateSimpleInfo(aVar2, "MutualMarkDataS2CHandleHelper_handleMutualMarkDataPushCommonUpdate", new hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>(qQAppInterface, isSwitchOn, pushMsg0x210C7Info) { // from class: com.tencent.mobileqq.mutualmark.MutualMarkDataS2CHandleHelper.2
                static IPatchRedirector $redirector_;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f251956b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ boolean f251957c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ PushMsg0x210C7Info f251958d;

                {
                    this.f251956b = qQAppInterface;
                    this.f251957c = isSwitchOn;
                    this.f251958d = pushMsg0x210C7Info;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, x.this, qQAppInterface, Boolean.valueOf(isSwitchOn), pushMsg0x210C7Info);
                    }
                }

                @Override // hx3.c
                public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> eVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.MutualMarkDataS2CHandleHelper.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (!TextUtils.isEmpty(x.this.b()) && !TextUtils.isEmpty(x.this.a())) {
                                    f.b(AnonymousClass2.this.f251956b).a(x.this.b(), x.this.a());
                                }
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                if (!anonymousClass2.f251957c) {
                                    d.c(anonymousClass2.f251956b, x.this, anonymousClass2.f251958d);
                                }
                                AnonymousClass2.this.f251956b.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, x.this.f180248b);
                                com.tencent.mobileqq.mutualmark.nt.f.f252196a.p(x.this.f180248b);
                            }
                        });
                    }
                }
            });
        }
        if (isSwitchOn) {
            d.c(qQAppInterface, xVar, pushMsg0x210C7Info);
        }
    }

    private static void l(com.tencent.mobileqq.mutualmark.info.d dVar, com.tencent.mobileqq.mutualmark.info.f fVar) {
        ConcurrentHashMap<Long, com.tencent.mobileqq.mutualmark.info.d> concurrentHashMap;
        if (fVar != null && (concurrentHashMap = fVar.f252151a) != null && !concurrentHashMap.isEmpty()) {
            ArrayList arrayList = new ArrayList(fVar.f252151a.values());
            Collections.sort(arrayList, f251954a);
            com.tencent.mobileqq.mutualmark.info.d e16 = e(dVar, arrayList);
            if (e16 != null) {
                arrayList.remove(arrayList.indexOf(e16));
                if (dVar.f252126r) {
                    arrayList.add(0, e16);
                } else {
                    arrayList.add(e16);
                }
            }
            n(fVar, arrayList);
        }
    }

    private static boolean m(x xVar, boolean z16, com.tencent.mobileqq.mutualmark.info.f fVar) {
        if (xVar.f180251e != null) {
            long f16 = xVar.f();
            ConcurrentHashMap<Long, com.tencent.mobileqq.mutualmark.info.d> concurrentHashMap = fVar.f252151a;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(Long.valueOf(f16))) {
                fVar.f252151a.remove(Long.valueOf(f16));
                return true;
            }
            return z16;
        }
        return z16;
    }

    private static void n(com.tencent.mobileqq.mutualmark.info.f fVar, List<com.tencent.mobileqq.mutualmark.info.d> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.tencent.mobileqq.mutualmark.info.d dVar = list.get(i3);
            if (dVar != null) {
                dVar.f252128t = i3;
                if (fVar.f252151a == null) {
                    fVar.f252151a = new ConcurrentHashMap<>();
                }
                fVar.f252151a.put(Long.valueOf(dVar.f252109a), dVar);
            }
        }
    }

    private static boolean o(x.c cVar, long j3, com.tencent.mobileqq.mutualmark.info.f fVar) {
        int i3;
        com.tencent.mobileqq.mutualmark.info.d dVar;
        if (cVar == null || fVar == null || (i3 = cVar.f180260a) <= 0) {
            return false;
        }
        ConcurrentHashMap<Long, com.tencent.mobileqq.mutualmark.info.d> concurrentHashMap = fVar.f252151a;
        if (concurrentHashMap != null) {
            dVar = concurrentHashMap.get(Long.valueOf(i3));
        } else {
            dVar = null;
        }
        if (dVar == null) {
            dVar = new com.tencent.mobileqq.mutualmark.info.d();
        }
        boolean a16 = dVar.a(cVar, j3);
        if (a16) {
            if (fVar.f252151a == null) {
                fVar.f252151a = new ConcurrentHashMap<>();
            }
            if (j3 == 11003) {
                l(dVar, fVar);
            } else {
                fVar.f252151a.put(Long.valueOf(dVar.f252109a), dVar);
            }
        }
        return a16;
    }

    private static boolean p(ArrayList<com.tencent.mobileqq.mutualmark.info.e> arrayList, ExtensionInfo extensionInfo, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar) {
        ConcurrentHashMap<Long, com.tencent.mobileqq.mutualmark.info.d> concurrentHashMap;
        if (arrayList == null || extensionInfo == null) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        com.tencent.mobileqq.mutualmark.info.a aVar2 = (com.tencent.mobileqq.mutualmark.info.a) extensionInfo.getBusinessData(com.tencent.mobileqq.mutualmark.info.a.class, new Object[0]);
        Iterator<com.tencent.mobileqq.mutualmark.info.e> it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.mutualmark.info.e next = it.next();
            if (next != null) {
                com.tencent.mobileqq.mutualmark.info.d c16 = c(aVar2, next, null);
                c16.b(next);
                arrayList2.add(c16);
            }
        }
        if (aVar2.f252067a == null) {
            aVar2.f252067a = new ConcurrentHashMap<>();
        }
        if (!aVar2.f252067a.isEmpty()) {
            aVar2.f252067a.clear();
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            com.tencent.mobileqq.mutualmark.info.d dVar = (com.tencent.mobileqq.mutualmark.info.d) it5.next();
            if (dVar != null) {
                aVar2.f252067a.put(Long.valueOf(dVar.f252109a), dVar);
            }
        }
        if (aVar != null) {
            com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar3 = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(aVar.getUid(), aVar.n());
            aVar3.q();
            aVar3.z(com.tencent.mobileqq.mutualmark.info.d.f(aVar2.f252067a));
            ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).accurateUpdateIntimateSimpleInfo(aVar3, "MutualMarkDataS2CHandleHelper", (hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>) null);
        }
        if (QLog.isColorLevel() && (concurrentHashMap = aVar2.f252067a) != null && concurrentHashMap.size() > 0) {
            StringBuilder sb5 = new StringBuilder("updatePullInfoToExtensionInfo,friendUin=" + extensionInfo.uin + ",mutualmarks=[size=" + aVar2.f252067a.size());
            Iterator<Long> it6 = aVar2.f252067a.keySet().iterator();
            while (it6.hasNext()) {
                long longValue = it6.next().longValue();
                com.tencent.mobileqq.mutualmark.info.d dVar2 = aVar2.f252067a.get(Long.valueOf(longValue));
                if (dVar2 != null) {
                    sb5.append("{type:");
                    sb5.append(longValue);
                    sb5.append(",isWear=");
                    sb5.append(dVar2.f252126r);
                    sb5.append(",url:\"");
                    sb5.append(dVar2.f252124p);
                    sb5.append("\"}");
                }
            }
            sb5.append("]");
            QLog.i("MutualMarkDataS2CHandleHelper", 2, sb5.toString());
            return true;
        }
        return true;
    }

    private static boolean q(ArrayList<com.tencent.mobileqq.mutualmark.info.e> arrayList, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar) {
        ConcurrentHashMap<Long, com.tencent.mobileqq.mutualmark.info.d> concurrentHashMap;
        if (arrayList != null && aVar != null) {
            ArrayList arrayList2 = new ArrayList();
            com.tencent.mobileqq.mutualmark.info.f fVar = new com.tencent.mobileqq.mutualmark.info.f(aVar);
            Iterator<com.tencent.mobileqq.mutualmark.info.e> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.mutualmark.info.e next = it.next();
                if (next != null) {
                    com.tencent.mobileqq.mutualmark.info.d d16 = d(fVar, next, null);
                    d16.b(next);
                    arrayList2.add(d16);
                }
            }
            if (fVar.f252151a == null) {
                fVar.f252151a = new ConcurrentHashMap<>();
            }
            if (!fVar.f252151a.isEmpty()) {
                fVar.f252151a.clear();
            }
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                com.tencent.mobileqq.mutualmark.info.d dVar = (com.tencent.mobileqq.mutualmark.info.d) it5.next();
                if (dVar != null) {
                    fVar.f252151a.put(Long.valueOf(dVar.f252109a), dVar);
                }
            }
            fVar.a(aVar);
            if (QLog.isColorLevel() && (concurrentHashMap = fVar.f252151a) != null && concurrentHashMap.size() > 0) {
                StringBuilder sb5 = new StringBuilder("updatePullInfoToExtensionInfo,friendUin=" + aVar.n() + ",mutualmarks=[size=" + fVar.f252151a.size());
                Iterator<Long> it6 = fVar.f252151a.keySet().iterator();
                while (it6.hasNext()) {
                    long longValue = it6.next().longValue();
                    com.tencent.mobileqq.mutualmark.info.d dVar2 = fVar.f252151a.get(Long.valueOf(longValue));
                    if (dVar2 != null) {
                        sb5.append("{type:");
                        sb5.append(longValue);
                        sb5.append(",isWear=");
                        sb5.append(dVar2.f252126r);
                        sb5.append(",url:\"");
                        sb5.append(dVar2.f252124p);
                        sb5.append("\"}");
                    }
                }
                sb5.append("]");
                QLog.i("MutualMarkDataS2CHandleHelper", 2, sb5.toString());
                return true;
            }
            return true;
        }
        return false;
    }

    private static boolean r(x xVar, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar) {
        boolean z16;
        x.c cVar;
        boolean z17 = false;
        if (xVar == null || aVar == null) {
            return false;
        }
        com.tencent.mobileqq.mutualmark.info.f fVar = new com.tencent.mobileqq.mutualmark.info.f(aVar);
        int i3 = xVar.f180249c;
        if (i3 == 2) {
            z16 = m(xVar, false, fVar);
        } else {
            x.c cVar2 = xVar.f180252f;
            if (cVar2 != null) {
                z17 = false | o(cVar2, i3, fVar);
            }
            ArrayList<x.a> arrayList = xVar.f180253g;
            if (arrayList != null) {
                Iterator<x.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    x.a next = it.next();
                    if (next != null && (cVar = next.f180255b) != null) {
                        z17 |= o(cVar, xVar.f180249c, fVar);
                    }
                }
            }
            z16 = z17;
        }
        fVar.a(aVar);
        return z16;
    }
}
