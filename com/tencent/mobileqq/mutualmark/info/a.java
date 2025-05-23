package com.tencent.mobileqq.mutualmark.info;

import android.text.TextUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements bb1.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<Long, d> f252067a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f252067a = new ConcurrentHashMap<>();
        }
    }

    public static void g(String str) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(uidFromUin, str);
        aVar.q();
        aVar.v(0);
        aVar.u(0);
        aVar.t(0);
        aVar.w(0L);
        aVar.r(Boolean.FALSE);
        aVar.z("");
        ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).accurateUpdateIntimateSimpleInfo(aVar, "ExtensionMutualMarkData_removeAllMutualMarks", (hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>) null);
        IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
        com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar2 = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(uidFromUin, str);
        aVar2.j0(0);
        aVar2.k0(0L);
        iOtherInfoService.accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singletonList(aVar2)), "ExtensionMutualMarkDataremoveAllMutualMarks", null);
    }

    @Override // bb1.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void c(ExtensionInfo extensionInfo, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) extensionInfo, (Object) objArr);
        }
    }

    @Override // bb1.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void a(ExtensionInfo extensionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) extensionInfo);
        } else if (!TextUtils.isEmpty(extensionInfo.mutual_marks_store_json)) {
            this.f252067a = d.c(extensionInfo.mutual_marks_store_json);
        } else {
            this.f252067a.clear();
        }
    }

    @Override // bb1.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void b(ExtensionInfo extensionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) extensionInfo);
            return;
        }
        ConcurrentHashMap<Long, d> concurrentHashMap = this.f252067a;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            extensionInfo.mutual_marks_store_json = d.f(new ConcurrentHashMap(this.f252067a));
        } else {
            extensionInfo.mutual_marks_store_json = "";
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "ExtensionMutualMarkData{mutualMarks=" + this.f252067a + '}';
    }
}
