package com.tencent.mobileqq.location;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgTypeFilter;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.qq_lbs_share$C2CRelationInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static CopyOnWriteArrayList<InterfaceC7969a> f241206a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.location.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC7969a {
        void a(Contact contact, Boolean bool);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72766);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f241206a = new CopyOnWriteArrayList<>();
        }
    }

    public static boolean a(PBBytesField pBBytesField) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        byte[] byteArray = pBBytesField.get().toByteArray();
        qq_lbs_share$C2CRelationInfo qq_lbs_share_c2crelationinfo = new qq_lbs_share$C2CRelationInfo();
        try {
            qq_lbs_share_c2crelationinfo.mergeFrom(byteArray);
            long j3 = qq_lbs_share_c2crelationinfo.f436008id1.get();
            long j16 = qq_lbs_share_c2crelationinfo.f436009id2.get();
            if (QLog.isColorLevel()) {
                QLog.d("LocationMessageUtil", 2, "isC2cSharingLocation: invoked. C2C profile flag [uin\u4e0d\u4e3a0\u5373\u53ef\u8bf4\u660e\u6b63\u5728\u5206\u4eab]", " id1: ", Long.valueOf(j3), " id2: ", Long.valueOf(j16));
            }
            if (waitAppRuntime.getLongAccountUin() == j3) {
                if (j16 > 0) {
                    return true;
                }
                return false;
            }
            if (waitAppRuntime.getLongAccountUin() == j16 && j3 > 0) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.e("LocationMessageUtil", 1, "isC2cSharingLocation: failed. ", e16);
            return false;
        }
    }

    private static void b(Contact contact, Boolean bool) {
        if (f241206a.isEmpty()) {
            return;
        }
        Iterator<InterfaceC7969a> it = f241206a.iterator();
        while (it.hasNext()) {
            it.next().a(contact, bool);
        }
    }

    public static void c(AppInterface appInterface, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("LocationMessageUtil", 2, "onDecodeC2cLbsCloseRoomMessage: invoked. ", " friendUin: ", str);
        }
        g(appInterface, 0, str, false);
    }

    public static void d(AppInterface appInterface, String str) {
        g(appInterface, 1, str, false);
    }

    public static void e(InterfaceC7969a interfaceC7969a) {
        f241206a.add(interfaceC7969a);
    }

    public static void f(InterfaceC7969a interfaceC7969a) {
        f241206a.remove(interfaceC7969a);
    }

    public static void g(AppInterface appInterface, int i3, String str, boolean z16) {
        int i16;
        if (i3 != 0 && i3 != 1) {
            return;
        }
        if (i3 == 0) {
            str = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        }
        if (str.isEmpty()) {
            return;
        }
        if (i3 == 0) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        ArrayList arrayList = new ArrayList();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_relation_share_location_search_DB", false)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(1);
            arrayList.add(new MsgTypeFilter(25, arrayList2));
        } else {
            arrayList.add(new MsgTypeFilter(25, new ArrayList()));
        }
        b(new Contact(i16, str, ""), Boolean.valueOf(z16));
    }
}
