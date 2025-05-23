package com.tencent.mobileqq.app.automator.step;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class o implements com.tencent.relation.common.handler.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    boolean f195387a;

    /* renamed from: b, reason: collision with root package name */
    boolean f195388b;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f195387a = false;
            this.f195388b = false;
        }
    }

    private QQAppInterface a() {
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private String b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getAccount();
        }
        return "0";
    }

    @Override // com.tencent.relation.common.handler.c
    public oidb_0x5eb$ReqBody get0x5ebReqBody(Bundle bundle, oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (oidb_0x5eb$ReqBody) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle, (Object) oidb_0x5eb_reqbody);
        }
        boolean z16 = false;
        String[] strArr = {b()};
        int[] iArr = {27375, 42417, 42489, ProfileContants.FIELD_HAOMA_NAMEPLATE, ProfileContants.FILED_KID_MODE_URL_FILTER_SWITCH};
        ArrayList arrayList = new ArrayList();
        String str = strArr[0];
        if (!arrayList.contains(str)) {
            arrayList.add(str);
        }
        String[] strArr2 = (String[]) arrayList.toArray(new String[1]);
        for (String str2 : strArr2) {
            try {
                oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(str2)));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        int i3 = 0;
        boolean z17 = false;
        while (true) {
            if (i3 >= 5) {
                break;
            }
            if (iArr[i3] == 42255) {
                oidb_0x5eb_reqbody.roam_flag_qq_7day.set(1);
                oidb_0x5eb_reqbody.roam_flag_vip_30day.set(1);
                oidb_0x5eb_reqbody.roam_flag_svip_2year.set(1);
                oidb_0x5eb_reqbody.roam_flag_svip_5year.set(1);
                oidb_0x5eb_reqbody.roam_flag_svip_forever.set(1);
                z16 = true;
                break;
            }
            j13.a.z(iArr, oidb_0x5eb_reqbody, i3);
            z17 = j13.a.A(iArr, oidb_0x5eb_reqbody, z17, i3);
            i3++;
        }
        this.f195387a = z16;
        this.f195388b = z17;
        bundle.putStringArray("uins", strArr2);
        QLog.i("I0x5ebHandlerProcessor.SelfPendantIdHandlerProcessor", 1, "SelfPendantId start request");
        return oidb_0x5eb_reqbody;
    }

    @Override // com.tencent.relation.common.handler.c
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 5;
    }

    @Override // com.tencent.relation.common.handler.c
    public Bundle getRequestExtraData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("req_roam_type", this.f195387a);
        bundle.putBoolean("req_music_type", this.f195388b);
        return bundle;
    }

    @Override // com.tencent.relation.common.handler.c
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, oidb_0x5eb$RspBody oidb_0x5eb_rspbody, boolean z16) {
        com.tencent.mobileqq.apollo.handler.b bVar;
        com.tencent.mobileqq.apollo.handler.d m06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj, oidb_0x5eb_rspbody, Boolean.valueOf(z16));
            return;
        }
        QLog.i("I0x5ebHandlerProcessor.SelfPendantIdHandlerProcessor", 1, "SelfPendantId onReceive");
        Object businessHandler = a().getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        if (!(businessHandler instanceof com.tencent.mobileqq.apollo.handler.b) || (m06 = (bVar = (com.tencent.mobileqq.apollo.handler.b) businessHandler).m0("OidbSvc.0x5eb_99")) == null) {
            return;
        }
        Intent intent = new Intent();
        Bundle bundle = toServiceMsg.extraData;
        if (bundle != null) {
            intent.putExtra("req_roam_type", bundle.getBoolean("req_roam_type"));
            intent.putExtra("req_music_type", bundle.getBoolean("req_music_type"));
        }
        if (obj instanceof byte[]) {
            m06.a(bVar, intent, fromServiceMsg, (byte[]) obj);
        }
    }
}
