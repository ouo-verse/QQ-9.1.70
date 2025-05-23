package com.tencent.mobileqq.discussion.observer;

import QQService.RespAddDiscussMember;
import QQService.RespGetDiscussInfo;
import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.discussion.b;
import com.tencent.protofile.discuss.FlyTicket$DiscussGetUrlResponse;
import com.tencent.protofile.discuss.FlyTicket$DiscussSigDecodeResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(boolean z16, Object[] objArr) {
        Object obj = objArr[1];
        if (!(obj instanceof Integer)) {
            return;
        }
        int intValue = ((Integer) obj).intValue();
        if (z16) {
            RespAddDiscussMember respAddDiscussMember = (RespAddDiscussMember) objArr[2];
            Map<Long, Integer> map = respAddDiscussMember.AddResult;
            Set<Long> keySet = map.keySet();
            ArrayList<String> arrayList = new ArrayList<>();
            for (Long l3 : keySet) {
                if (map.get(l3).intValue() == 0) {
                    arrayList.add(String.valueOf(l3));
                }
            }
            f(true, intValue, respAddDiscussMember.DiscussUin, arrayList);
            return;
        }
        f(false, intValue, Long.valueOf((String) objArr[0]).longValue(), null);
    }

    private void b(boolean z16, Object[] objArr) {
        long longValue;
        if (objArr != null && objArr.length == 3) {
            int intValue = ((Integer) objArr[2]).intValue();
            Object obj = objArr[0];
            if (obj == null) {
                longValue = 0;
            } else {
                longValue = ((Long) obj).longValue();
            }
            i(z16, intValue, longValue, (String) objArr[1]);
        }
    }

    private void c(boolean z16, FlyTicket$DiscussSigDecodeResponse flyTicket$DiscussSigDecodeResponse) {
        if (flyTicket$DiscussSigDecodeResponse != null && flyTicket$DiscussSigDecodeResponse.ret_info.get().ret_code.get() == 0) {
            j(z16, flyTicket$DiscussSigDecodeResponse.sig.get());
        } else {
            j(false, null);
        }
    }

    private void d(boolean z16, Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            boolean z17 = false;
            String str = (String) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            int intValue = ((Integer) objArr[2]).intValue();
            int intValue2 = ((Integer) objArr[3]).intValue();
            if (objArr.length >= 5) {
                z17 = ((Boolean) objArr[4]).booleanValue();
            }
            l(z16, str, booleanValue, intValue, intValue2, z17);
        }
    }

    private void e(boolean z16, Object[] objArr) {
        String str;
        int parseInt = Integer.parseInt((String) objArr[0]);
        FlyTicket$DiscussGetUrlResponse flyTicket$DiscussGetUrlResponse = (FlyTicket$DiscussGetUrlResponse) objArr[1];
        long longValue = ((Long) objArr[2]).longValue();
        if (flyTicket$DiscussGetUrlResponse != null && parseInt == 0) {
            String str2 = flyTicket$DiscussGetUrlResponse.url.get();
            if (!flyTicket$DiscussGetUrlResponse.url.get().endsWith("#flyticket") && !str2.endsWith(flyTicket$DiscussGetUrlResponse.sig.get())) {
                str2 = str2 + flyTicket$DiscussGetUrlResponse.sig.get();
            }
            String str3 = str2;
            if (flyTicket$DiscussGetUrlResponse.short_url.get() != null) {
                str = flyTicket$DiscussGetUrlResponse.short_url.get();
            } else {
                str = "";
            }
            n(z16, parseInt, flyTicket$DiscussGetUrlResponse.v_time.get(), str3, str, longValue);
            return;
        }
        n(false, parseInt, 0L, null, "", longValue);
    }

    protected void f(boolean z16, int i3, long j3, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), arrayList);
        }
    }

    protected void g(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str);
        }
    }

    protected void h(boolean z16, Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), l3);
        }
    }

    protected void i(boolean z16, int i3, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), str);
        }
    }

    protected void j(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), str);
        }
    }

    protected void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    protected void l(boolean z16, String str, boolean z17, int i3, int i16, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z18));
        }
    }

    protected void m(boolean z16, int i3, RespGetDiscussInfo respGetDiscussInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Integer.valueOf(i3), respGetDiscussInfo);
        }
    }

    protected void n(boolean z16, int i3, long j3, String str, String str2, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), str, str2, Long.valueOf(j16));
        }
    }

    protected void o(Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) objArr);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Discussion", 2, "Discussion DiscussObserver onUpdate type" + i3);
        }
        if (i3 != 2000) {
            switch (i3) {
                case 1000:
                    x(z16);
                    return;
                case 1001:
                    w(z16, obj);
                    return;
                case 1002:
                    b(z16, (Object[]) obj);
                    return;
                case 1003:
                    a(z16, (Object[]) obj);
                    return;
                case 1004:
                    ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).smallScreenUtils_getTrace("deleteDiscuss_onQuitDiscussion");
                    r(z16, (String) obj);
                    return;
                case 1005:
                    g(z16, (String) obj);
                    return;
                default:
                    switch (i3) {
                        case 1007:
                            Pair pair = (Pair) obj;
                            u(z16, ((Boolean) pair.first).booleanValue(), (String) pair.second);
                            return;
                        case 1008:
                            k();
                            return;
                        case 1009:
                            t();
                            return;
                        case 1010:
                            v(z16, ((Long) obj).longValue());
                            return;
                        case 1011:
                            e(z16, (Object[]) obj);
                            return;
                        case 1012:
                            c(z16, (FlyTicket$DiscussSigDecodeResponse) obj);
                            return;
                        case 1013:
                            Object[] objArr = (Object[]) obj;
                            m(z16, Integer.parseInt((String) objArr[0]), (RespGetDiscussInfo) objArr[1]);
                            return;
                        case 1014:
                            Long[] lArr = (Long[]) obj;
                            p(z16, lArr[1].longValue(), lArr[0].intValue());
                            return;
                        case 1015:
                            long[] jArr = (long[]) obj;
                            q(z16, Long.valueOf(jArr[0]), Long.valueOf(jArr[1]));
                            return;
                        case 1016:
                            h(z16, (Long) obj);
                            return;
                        case 1017:
                            s(z16, (Long) obj);
                            return;
                        case 1018:
                            d(z16, obj);
                            return;
                        default:
                            return;
                    }
            }
        }
        o((Object[]) obj);
    }

    protected void p(boolean z16, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    protected void q(boolean z16, Long l3, Long l16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), l3, l16);
        }
    }

    protected void r(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str);
        }
    }

    protected void s(boolean z16, Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), l3);
        }
    }

    protected void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    protected void u(boolean z16, boolean z17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
        }
    }

    protected void v(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Long.valueOf(j3));
        }
    }

    protected void w(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
    }
}
