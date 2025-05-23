package com.tencent.mobileqq.app.friendlist.receiver;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    public d(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f0  */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r6v10, types: [com.tencent.mobileqq.app.QQAppInterface] */
    /* JADX WARN: Type inference failed for: r6v11, types: [com.tencent.mobileqq.app.QQAppInterface] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.tencent.mobileqq.app.friendlist.receiver.a, com.tencent.mobileqq.app.friendlist.receiver.d] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        byte[] bArr;
        ?? r122;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        ?? r112;
        ?? r113;
        if (obj != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = toServiceMsg.extraData.getInt("key_permission_opcode");
        ArrayList arrayList = null;
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    cmd0x7c7$RspBody cmd0x7c7_rspbody = new cmd0x7c7$RspBody();
                    bArr = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                    cmd0x7c7_rspbody.mergeFrom(bArr);
                    try {
                        if (i3 == 1) {
                            if (cmd0x7c7_rspbody.uint32_not_see_qzone.get() == 1) {
                                r113 = 1;
                            } else {
                                r113 = 0;
                            }
                            this.f195646a.setNotAllowedSeeMyDongtai(r113, false);
                            bArr = r113;
                        } else if (i3 == 2) {
                            if (cmd0x7c7_rspbody.uint32_prevent_dynamic.get() == 1) {
                                r112 = 1;
                            } else {
                                r112 = 0;
                            }
                            this.f195646a.setShieldHisDongtai(r112, false);
                            bArr = r112;
                        } else if (i3 == 3) {
                            ArrayList arrayList2 = new ArrayList();
                            try {
                                if (cmd0x7c7_rspbody.uint32_not_see_qzone.get() == 1) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                arrayList2.add(Boolean.valueOf(z18));
                                if (cmd0x7c7_rspbody.uint32_prevent_dynamic.get() == 1) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                arrayList2.add(Boolean.valueOf(z19));
                                QQAppInterface qQAppInterface = this.f195646a;
                                if (cmd0x7c7_rspbody.uint32_not_see_qzone.get() == 1) {
                                    z26 = true;
                                } else {
                                    z26 = false;
                                }
                                qQAppInterface.setNotAllowedSeeMyDongtai(z26, false);
                                QQAppInterface qQAppInterface2 = this.f195646a;
                                if (cmd0x7c7_rspbody.uint32_prevent_dynamic.get() == 1) {
                                    z27 = true;
                                } else {
                                    z27 = false;
                                }
                                qQAppInterface2.setShieldHisDongtai(z27, false);
                                arrayList = arrayList2;
                            } catch (Exception e16) {
                                e = e16;
                                arrayList = arrayList2;
                                bArr = 1;
                                if (QLog.isColorLevel()) {
                                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetDongtaiPermission Exception " + e.getMessage());
                                }
                                r122 = bArr;
                                z16 = false;
                                if (!z16) {
                                }
                                if (i3 == 1) {
                                }
                            }
                        }
                        boolean z28 = z17;
                        r122 = bArr;
                        z16 = z28;
                    } catch (Exception e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                        }
                        r122 = bArr;
                        z16 = false;
                        if (!z16) {
                        }
                        if (i3 == 1) {
                        }
                    }
                } else {
                    int i16 = oidb_sso_oidbssopkg.uint32_result.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetDongtaiPermission  fail resultCode : " + i16);
                    }
                }
                bArr = 1;
                boolean z282 = z17;
                r122 = bArr;
                z16 = z282;
            } catch (Exception e18) {
                e = e18;
            }
        } else {
            r122 = true;
        }
        if (!z16) {
            if (i3 == 1) {
                r122 = this.f195646a.getNotAllowedSeeMyDongtai(false);
            } else if (i3 == 2) {
                r122 = this.f195646a.getShieldHisDongtai(false);
            } else if (i3 == 3) {
                arrayList = new ArrayList();
                arrayList.add(Boolean.valueOf(this.f195646a.getNotAllowedSeeMyDongtai(false)));
                arrayList.add(Boolean.valueOf(this.f195646a.getShieldHisDongtai(false)));
            }
        }
        if (i3 == 1) {
            b(78, z16, Boolean.valueOf((boolean) r122));
        } else if (i3 == 2) {
            b(80, z16, Boolean.valueOf((boolean) r122));
        } else if (i3 == 3) {
            b(82, z16, arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3 = toServiceMsg.extraData.getInt("key_permission_opcode");
        boolean z17 = toServiceMsg.extraData.getBoolean("key_dongtai_permission", false);
        if (FriendListHandler.parseSSOPkg(toServiceMsg, fromServiceMsg, obj) == null) {
            if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleSetDongtaiPermission: ssoPkg parse failed");
            }
        } else {
            try {
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleSetDongtaiPermission " + e16.getMessage());
                }
            }
            if (i3 == 1) {
                this.f195646a.setNotAllowedSeeMyDongtai(z17, false);
            } else if (i3 == 2) {
                this.f195646a.setShieldHisDongtai(z17, false);
            } else {
                if (i3 == 3) {
                    this.f195646a.setNotAllowedSeeMyDongtai(z17, false);
                    this.f195646a.setShieldHisDongtai(z17, false);
                }
                z16 = true;
                if (!z16) {
                    if (i3 == 1) {
                        z17 = this.f195646a.getNotAllowedSeeMyDongtai(false);
                    } else if (i3 == 2) {
                        z17 = this.f195646a.getShieldHisDongtai(false);
                    }
                }
                if (i3 == 1) {
                    b(77, z16, Boolean.valueOf(z17));
                    return;
                } else if (i3 == 2) {
                    b(79, z16, Boolean.valueOf(z17));
                    return;
                } else {
                    if (i3 == 3) {
                        b(81, z16, null);
                        return;
                    }
                    return;
                }
            }
            z16 = true;
            if (!z16) {
            }
            if (i3 == 1) {
            }
        }
        z16 = false;
        if (!z16) {
        }
        if (i3 == 1) {
        }
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!"OidbSvc.0x7c6_0".equals(str) && !"OidbSvc.0x7c7_0".equals(str)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("OidbSvc.0x7c6_0".equals(serviceCmd)) {
            f(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x7c7_0".equals(serviceCmd)) {
            e(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
