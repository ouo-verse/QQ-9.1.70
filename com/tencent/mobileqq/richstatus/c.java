package com.tencent.mobileqq.richstatus;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements bb1.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public RichStatus f282317a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ hx3.c f282318a;

        a(hx3.c cVar) {
            this.f282318a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else if (this.f282318a != null && eVar != null) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar2 = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
                eVar2.d(eVar.a());
                this.f282318a.onUpdateResult(eVar2);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static RichStatus e(ExtensionInfo extensionInfo) {
        return f(extensionInfo, false);
    }

    public static RichStatus f(ExtensionInfo extensionInfo, boolean z16) {
        if (extensionInfo == null) {
            return null;
        }
        if (extensionInfo.richTime > 0 && z16) {
            return RichStatus.getEmptyStatus();
        }
        c cVar = (c) extensionInfo.getBusinessData(c.class, new Object[0]);
        if (cVar == null) {
            return null;
        }
        return cVar.f282317a;
    }

    public static RichStatus g(Long l3, byte[] bArr, Boolean bool) {
        if (l3 != null && bArr != null && l3.longValue() > 0) {
            if (bArr.length > 0 && !bool.booleanValue()) {
                RichStatus parseStatus = RichStatus.parseStatus(bArr);
                parseStatus.time = l3.longValue();
                return parseStatus;
            }
            return RichStatus.getEmptyStatus();
        }
        return RichStatus.getEmptyStatus();
    }

    public static RichStatus h(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar) {
        if (dVar == null) {
            return null;
        }
        if (dVar.t() > 0 && dVar.s() != null && dVar.s().length > 0) {
            RichStatus parseStatus = RichStatus.parseStatus(dVar.s());
            parseStatus.time = dVar.t();
            return parseStatus;
        }
        return RichStatus.getEmptyStatus();
    }

    public static void k(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, byte[] bArr, long j3) {
        l(dVar, bArr, j3, null);
    }

    public static void l(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, byte[] bArr, long j3, hx3.c<Boolean> cVar) {
        if (dVar == null) {
            return;
        }
        if (bArr == null) {
            bArr = new byte[1];
        }
        dVar.n0(bArr);
        dVar.o0(j3);
        Boolean bool = Boolean.FALSE;
        dVar.N(bool);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(dVar.getUid(), dVar.x());
        dVar2.M();
        dVar2.n0(bArr);
        dVar2.o0(j3);
        dVar2.N(bool);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList = new ArrayList<>();
        arrayList.add(dVar2);
        RichStatus parseStatus = RichStatus.parseStatus(bArr);
        QLog.i("ExtensionRichStatus", 1, "saveRichBuffer1 " + parseStatus.topics.size() + " " + parseStatus.actionText + " " + parseStatus.dataText);
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(arrayList, "ExtensionRichStatus", new a(cVar));
    }

    public static void m(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, byte[] bArr, long j3) {
        if (dVar != null) {
            if (bArr == null) {
                bArr = new byte[1];
            }
            dVar.n0(bArr);
            dVar.o0(j3);
            dVar.N(Boolean.FALSE);
        }
    }

    @Override // bb1.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void c(ExtensionInfo extensionInfo, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) extensionInfo, (Object) objArr);
            return;
        }
        boolean z16 = false;
        if (objArr != null && objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof Boolean) {
                z16 = ((Boolean) obj).booleanValue();
            }
        }
        if (this.f282317a == null) {
            long j3 = extensionInfo.richTime;
            if (j3 <= 0 || !z16) {
                if (j3 > 0) {
                    RichStatus parseStatus = RichStatus.parseStatus(extensionInfo.richBuffer);
                    this.f282317a = parseStatus;
                    parseStatus.time = extensionInfo.richTime;
                    return;
                }
                this.f282317a = new RichStatus(null);
            }
        }
    }

    @Override // bb1.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void a(ExtensionInfo extensionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) extensionInfo);
        }
    }

    @Override // bb1.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void b(ExtensionInfo extensionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) extensionInfo);
        }
    }
}
