package com.tencent.mobileqq.app;

import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pb.now.ilive_feeds_near_anchor$NearAnchorInfo;
import com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend$QueryRspItem;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ca implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public ca() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void H(boolean z16, Object obj) {
        if (z16 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            C(z16, ((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), ((Integer) objArr[8]).intValue(), (String) objArr[9], (String) objArr[10], (String) objArr[11]);
        }
    }

    private void a(boolean z16, Object obj) {
        if (z16 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            p(((Boolean) objArr[0]).booleanValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), (String) objArr[7]);
        }
    }

    private void b(boolean z16, Object obj) {
        if (z16 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            q(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), (String) objArr[8]);
        }
    }

    private void c(Object obj) {
        if (obj == null) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length == 3) {
            r((FromServiceMsg) objArr[0], (ToServiceMsg) objArr[1], (Object[]) objArr[2]);
        }
    }

    private void d(boolean z16, Object obj) {
        if (obj instanceof Object[]) {
            A(z16, (List) ((Object[]) obj)[0]);
        }
    }

    private void e(boolean z16, Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            n(z16, ((Integer) objArr[0]).intValue(), (String) objArr[1]);
        }
    }

    private void f(boolean z16, Object obj) {
        if (obj instanceof Object[]) {
            z(z16, (String) ((Object[]) obj)[0], ((Integer) r5[1]).intValue());
        }
    }

    private void g(boolean z16, Object obj) {
        if (z16 && (obj instanceof Object[])) {
            t(z16, (NearbyMyTabCard) ((Object[]) obj)[0]);
        } else {
            t(false, null);
        }
    }

    private void h(boolean z16, Object[] objArr) {
        if (z16 && objArr != null) {
            B(true, (NearbyMyTabCard) objArr[0]);
        } else {
            B(false, null);
        }
    }

    private void i(Object obj) {
        if (obj instanceof Object[]) {
            s((List) ((Object[]) obj)[0]);
        }
    }

    private void j(boolean z16, Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            y(z16, ((Integer) objArr[0]).intValue(), (String) objArr[1]);
        }
    }

    private void k(int i3, boolean z16, Object obj) {
        oidb_0x8dd$RspBody oidb_0x8dd_rspbody;
        ToServiceMsg toServiceMsg;
        List<Object> list;
        if (obj == null) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length >= 4) {
            int intValue = ((Integer) objArr[0]).intValue();
            Object obj2 = objArr[1];
            if (obj2 instanceof oidb_0x8dd$RspBody) {
                oidb_0x8dd_rspbody = (oidb_0x8dd$RspBody) obj2;
            } else {
                oidb_0x8dd_rspbody = null;
            }
            Object obj3 = objArr[2];
            if (obj3 instanceof ToServiceMsg) {
                toServiceMsg = (ToServiceMsg) obj3;
            } else {
                toServiceMsg = null;
            }
            Object obj4 = objArr[3];
            if (obj4 instanceof List) {
                list = (List) obj4;
            } else {
                list = null;
            }
            if (i3 == 1) {
                E(z16, intValue, oidb_0x8dd_rspbody, toServiceMsg, list);
            } else {
                F(z16, intValue, oidb_0x8dd_rspbody, toServiceMsg, list);
            }
        }
    }

    private void l(boolean z16, Object obj) {
        if (z16 && obj != null) {
            v(true, (byte[]) obj);
        }
    }

    private void m(boolean z16, Object obj) {
        if (z16 && obj != null) {
            Object[] objArr = (Object[]) obj;
            w(true, new LBSInfo(String.valueOf(objArr[0]), String.valueOf(objArr[1]), String.valueOf(objArr[2]), String.valueOf(objArr[3]), String.valueOf(objArr[4]), String.valueOf(objArr[5]), String.valueOf(objArr[6]), String.valueOf(objArr[7]), ((Integer) objArr[8]).doubleValue(), ((Integer) objArr[9]).doubleValue(), ((Integer) objArr[10]).doubleValue(), (String[]) objArr[11]));
        } else {
            w(false, null);
        }
    }

    protected void A(boolean z16, List<ilive_feeds_near_anchor$NearAnchorInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), list);
        }
    }

    public void B(boolean z16, NearbyMyTabCard nearbyMyTabCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), nearbyMyTabCard);
        }
    }

    public void C(boolean z16, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Integer.valueOf(i29), str, str2, str3);
        }
    }

    public void D(boolean z16, String str, List<m92.a> list, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), str, list, str2, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void E(boolean z16, int i3, oidb_0x8dd$RspBody oidb_0x8dd_rspbody, ToServiceMsg toServiceMsg, List<Object> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), oidb_0x8dd_rspbody, toServiceMsg, list);
        }
    }

    protected void F(boolean z16, int i3, oidb_0x8dd$RspBody oidb_0x8dd_rspbody, ToServiceMsg toServiceMsg, List<Object> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), oidb_0x8dd_rspbody, toServiceMsg, list);
        }
    }

    protected void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    protected void n(boolean z16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        switch (i3) {
            case 1:
            case 13:
                k(i3, z16, obj);
                return;
            case 2:
            case 7:
            case 14:
            default:
                return;
            case 3:
                g(z16, obj);
                return;
            case 4:
                h(z16, (Object[]) obj);
                return;
            case 5:
                l(z16, obj);
                return;
            case 6:
                m(z16, obj);
                return;
            case 8:
                a(z16, obj);
                return;
            case 9:
                b(z16, obj);
                return;
            case 10:
                Object[] objArr = (Object[]) obj;
                D(z16, (String) objArr[0], (List) objArr[1], (String) objArr[2], ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue());
                return;
            case 11:
                Object[] objArr2 = (Object[]) obj;
                u(z16, (ArrayList) objArr2[0], (byte[]) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), (String) objArr2[4], ((Boolean) objArr2[5]).booleanValue(), ((Long) objArr2[6]).longValue(), ((Long) objArr2[7]).longValue());
                return;
            case 12:
                x();
                return;
            case 15:
                c(obj);
                return;
            case 16:
                H(z16, obj);
                return;
            case 17:
                f(z16, obj);
                return;
            case 18:
                j(z16, obj);
                return;
            case 19:
                d(z16, obj);
                return;
            case 20:
                o();
                return;
            case 21:
                e(z16, obj);
                return;
            case 22:
                i(obj);
                return;
            case 23:
                G();
                return;
        }
    }

    protected void p(boolean z16, int i3, int i16, int i17, int i18, int i19, int i26, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), str);
        }
    }

    protected void q(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), str);
        }
    }

    protected void r(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, fromServiceMsg, toServiceMsg, obj);
        }
    }

    public void s(List<nearbyPeopleRecommend$QueryRspItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) list);
        }
    }

    protected void t(boolean z16, NearbyMyTabCard nearbyMyTabCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), nearbyMyTabCard);
        }
    }

    protected void u(boolean z16, ArrayList<StrangerInfo> arrayList, byte[] bArr, int i3, long j3, String str, boolean z17, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), arrayList, bArr, Integer.valueOf(i3), Long.valueOf(j3), str, Boolean.valueOf(z17), Long.valueOf(j16), Long.valueOf(j17));
        }
    }

    protected void v(boolean z16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), bArr);
        }
    }

    protected void w(boolean z16, LBSInfo lBSInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), lBSInfo);
        }
    }

    protected void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    protected void y(boolean z16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
        }
    }

    protected void z(boolean z16, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), str, Long.valueOf(j3));
        }
    }
}
