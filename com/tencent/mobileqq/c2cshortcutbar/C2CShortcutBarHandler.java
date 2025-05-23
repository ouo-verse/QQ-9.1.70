package com.tencent.mobileqq.c2cshortcutbar;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.c2cshortcutbar.b;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xd51.Oidb_0xd51$AioQuickAppData;
import tencent.im.oidb.cmd0xd51.Oidb_0xd51$ReqBody;
import tencent.im.oidb.cmd0xeb5.oidb_0xeb5$App;
import tencent.im.oidb.cmd0xeb5.oidb_0xeb5$Label;
import tencent.im.oidb.cmd0xeb5.oidb_0xeb5$ReqBody;
import tencent.im.oidb.cmd0xeb5.oidb_0xeb5$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class C2CShortcutBarHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f200917d;

    public C2CShortcutBarHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f200917d = qQAppInterface;
        }
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        int i16;
        int i17;
        int i18;
        String str;
        long j3;
        String str2;
        String str3;
        String str4;
        String str5;
        int i19;
        int i26;
        boolean z17;
        String str6;
        String str7;
        String str8;
        String str9;
        oidb_0xeb5$RspBody oidb_0xeb5_rspbody = new oidb_0xeb5$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xeb5_rspbody);
        long j16 = toServiceMsg.extraData.getLong("key_friend_uin");
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarHandler", 2, "handleRequestC2CShortcutAppList result = " + parseOIDBPkg);
        }
        ArrayList arrayList = new ArrayList();
        if (parseOIDBPkg == 0) {
            if (oidb_0xeb5_rspbody.cache_ts.has()) {
                i16 = oidb_0xeb5_rspbody.cache_ts.get();
            } else {
                i16 = 0;
            }
            e.d(this.f200917d).p(Long.valueOf(j16), Long.valueOf((System.currentTimeMillis() / 1000) + i16));
            if (oidb_0xeb5_rspbody.max_show_app_num.has()) {
                i17 = oidb_0xeb5_rspbody.max_show_app_num.get();
            } else {
                i17 = 0;
            }
            e.d(this.f200917d).n(i17);
            if (oidb_0xeb5_rspbody.redpoint_cache_ts.has()) {
                oidb_0xeb5_rspbody.redpoint_cache_ts.get();
            }
            if (oidb_0xeb5_rspbody.cookies.has()) {
                oidb_0xeb5_rspbody.cookies.get().toStringUtf8();
            }
            if (oidb_0xeb5_rspbody.expose_id.has()) {
                i18 = oidb_0xeb5_rspbody.expose_id.get();
            } else {
                i18 = 0;
            }
            e.d(this.f200917d).m(String.valueOf(j16), i18);
            if (oidb_0xeb5_rspbody.app.has()) {
                for (oidb_0xeb5$App oidb_0xeb5_app : oidb_0xeb5_rspbody.app.get()) {
                    b bVar = new b();
                    if (!oidb_0xeb5_app.appid.has()) {
                        str = "";
                    } else {
                        str = oidb_0xeb5_app.appid.get();
                    }
                    bVar.f200935a = str;
                    if (oidb_0xeb5_app.type.has()) {
                        j3 = oidb_0xeb5_app.type.get();
                    } else {
                        j3 = 0;
                    }
                    bVar.f200936b = j3;
                    if (!oidb_0xeb5_app.name.has()) {
                        str2 = "";
                    } else {
                        str2 = oidb_0xeb5_app.name.get();
                    }
                    bVar.f200937c = str2;
                    if (!oidb_0xeb5_app.icon.has()) {
                        str3 = "";
                    } else {
                        str3 = oidb_0xeb5_app.icon.get();
                    }
                    bVar.f200938d = str3;
                    if (!oidb_0xeb5_app.url.has()) {
                        str4 = "";
                    } else {
                        str4 = oidb_0xeb5_app.url.get();
                    }
                    bVar.f200939e = str4;
                    if (!oidb_0xeb5_app.desc.has()) {
                        str5 = "";
                    } else {
                        str5 = oidb_0xeb5_app.desc.get();
                    }
                    bVar.f200940f = str5;
                    if (oidb_0xeb5_app.redpoint.has()) {
                        i19 = oidb_0xeb5_app.redpoint.get();
                    } else {
                        i19 = 0;
                    }
                    bVar.f200942h = i19;
                    if (oidb_0xeb5_app.playing_num.has()) {
                        i26 = oidb_0xeb5_app.playing_num.get();
                    } else {
                        i26 = 0;
                    }
                    bVar.f200944j = i26;
                    if (oidb_0xeb5_app.ark.has()) {
                        z17 = oidb_0xeb5_app.ark.get();
                    } else {
                        z17 = false;
                    }
                    bVar.f200945k = z17;
                    if (!oidb_0xeb5_app.ark_label.has()) {
                        str6 = "";
                    } else {
                        str6 = oidb_0xeb5_app.ark_label.get();
                    }
                    bVar.f200946l = str6;
                    if (oidb_0xeb5_app.labels.has()) {
                        bVar.f200947m = new ArrayList<>();
                        for (oidb_0xeb5$Label oidb_0xeb5_label : oidb_0xeb5_app.labels.get()) {
                            b.a aVar = new b.a();
                            if (!oidb_0xeb5_label.string_name.has()) {
                                str7 = "";
                            } else {
                                str7 = oidb_0xeb5_label.string_name.get();
                            }
                            aVar.f200949a = str7;
                            if (!oidb_0xeb5_label.text_color.has()) {
                                str8 = "";
                            } else {
                                str8 = oidb_0xeb5_label.text_color.get();
                            }
                            aVar.f200951c = str8;
                            if (!oidb_0xeb5_label.bg_color.has()) {
                                str9 = "";
                            } else {
                                str9 = oidb_0xeb5_label.bg_color.get();
                            }
                            aVar.f200950b = str9;
                            bVar.f200947m.add(aVar);
                        }
                    }
                    bVar.f200948n = oidb_0xeb5_app.jump_type.get();
                    arrayList.add(bVar);
                }
                e.d(this.f200917d).o(Long.valueOf(j16), arrayList);
                if (arrayList.size() > i17) {
                    e.d(this.f200917d).k(String.valueOf(j16), arrayList.subList(i17, arrayList.size()));
                }
            }
            if (QLog.isColorLevel()) {
                i3 = 2;
                QLog.d("C2CShortcutBarHandler", 2, "handleRequestC2CShortcutAppList maxDisplayNum = " + i17 + "\uff0ccacheTS = " + i16 + "\uff0c friendUin = " + j16 + " \uff0cexposeId = " + i18 + "\uff0cshortcutAppInfoList = " + arrayList);
            } else {
                i3 = 2;
            }
            z16 = true;
        } else {
            i3 = 2;
            z16 = false;
        }
        Object[] objArr = new Object[i3];
        objArr[0] = Long.valueOf(j16);
        objArr[1] = arrayList;
        notifyUI(1, z16, objArr);
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("is_open")).booleanValue();
        String str = (String) toServiceMsg.getAttribute("friend_uin");
        if (z16) {
            byte[] bArr = (byte[]) obj;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.d("C2CShortcutBarHandler", 1, "handleSetC2CSwitcherStatus()  e =", e16);
            }
            if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarHandler", 2, "handleSetSwitcherStatus() isOpen = ", Boolean.valueOf(booleanValue), " isSuccess =" + z16);
        }
        QQAppInterface qQAppInterface = this.f200917d;
        if (z16) {
            z17 = booleanValue;
        } else if (!booleanValue) {
            z17 = true;
        } else {
            z17 = false;
        }
        g.h(qQAppInterface, z17, str);
        notifyUI(2, z16, new Object[]{str, Boolean.valueOf(booleanValue)});
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17 = false;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("is_global_open")).booleanValue();
        if (z16) {
            byte[] bArr = (byte[]) obj;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.d("C2CShortcutBarHandler", 1, "handleSetC2CSwitcherStatus()  e =", e16);
            }
            if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarHandler", 2, "handleSetGlobalSwitcherStatus() isGlobalOpen = ", Boolean.valueOf(booleanValue), " isSuccess = ", Boolean.valueOf(z16));
        }
        QQAppInterface qQAppInterface = this.f200917d;
        if (z16) {
            z17 = booleanValue;
        } else if (!booleanValue) {
            z17 = true;
        }
        g.i(qQAppInterface, z17);
        notifyUI(3, z16, Boolean.valueOf(booleanValue));
    }

    public void G2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            e.d(this.f200917d).p(Long.valueOf(j3), 0L);
            notifyUI(6, true, new Object[]{Long.valueOf(j3)});
        }
    }

    public void H2(long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16));
            return;
        }
        try {
            if (!this.f200917d.getCurrentUin().equals(String.valueOf(j16))) {
                QLog.d("C2CShortcutBarHandler", 1, "onPushC2CSwitcherStatusChanged() accountUin is not current user just return");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarHandler", 2, "onPushC2CSwitcherStatusChanged()");
            }
            if (z16) {
                e.d(this.f200917d).p(Long.valueOf(j3), 0L);
            }
            g.h(this.f200917d, z16, String.valueOf(j3));
            notifyUI(2, true, new Object[]{String.valueOf(j3), Boolean.valueOf(z16)});
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
    }

    public void I2(long j3, int i3, boolean z16, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarHandler", 2, "requestC2CShortcutAppList");
        }
        oidb_0xeb5$ReqBody oidb_0xeb5_reqbody = new oidb_0xeb5$ReqBody();
        oidb_0xeb5_reqbody.friend_uin.set(j3);
        oidb_0xeb5_reqbody.aio_type.set(i3);
        oidb_0xeb5_reqbody.redpoint.set(z16);
        if (i16 > 0) {
            oidb_0xeb5_reqbody.num.set(i16);
        }
        if (!TextUtils.isEmpty(str)) {
            oidb_0xeb5_reqbody.cookies.set(ByteStringMicro.copyFromUtf8(str));
        }
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.oidb_0xeb5", 3765, 1, oidb_0xeb5_reqbody.toByteArray());
        makeOIDBPkg.extraData.putLong("key_friend_uin", j3);
        sendPbReq(makeOIDBPkg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J2(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
            return;
        }
        Oidb_0xd51$ReqBody oidb_0xd51$ReqBody = new Oidb_0xd51$ReqBody();
        oidb_0xd51$ReqBody.appid.set(10002L);
        oidb_0xd51$ReqBody.frd_uin.set(Long.valueOf(str).longValue());
        oidb_0xd51$ReqBody.add_direction.set(1);
        oidb_0xd51$ReqBody.ext_sns_type.set(25);
        Oidb_0xd51$AioQuickAppData oidb_0xd51$AioQuickAppData = new Oidb_0xd51$AioQuickAppData();
        oidb_0xd51$AioQuickAppData.uint32_switch.set(z16 ? 1 : 0);
        oidb_0xd51$ReqBody.bytes_aio_quick_app.set(ByteStringMicro.copyFrom(oidb_0xd51$AioQuickAppData.toByteArray()));
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarHandler", 2, "setSwitcherStatus() isOpen = ", Boolean.valueOf(z16), " friendUin =", str);
        }
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.oidb_0xd51", 3409, 15, oidb_0xd51$ReqBody.toByteArray());
        makeOIDBPkg.addAttribute("is_open", Boolean.valueOf(z16));
        makeOIDBPkg.addAttribute("friend_uin", str);
        sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.oidb_0xeb5");
            this.allowCmdSet.add("OidbSvc.oidb_0xd51");
            this.allowCmdSet.add("OidbSvc.oidb_0x587");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            QLog.d("C2CShortcutBarHandler", 4, "onReceive() req.cmd = ", toServiceMsg.getServiceCmd());
            return;
        }
        if ("OidbSvc.oidb_0xeb5".equals(fromServiceMsg.getServiceCmd())) {
            D2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.oidb_0xd51".equals(toServiceMsg.getServiceCmd())) {
            E2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.oidb_0x587".equals(toServiceMsg.getServiceCmd())) {
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
