package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x74b.oidb_0x74b$ReqBody;
import tencent.im.oidb.cmd0x74b.oidb_0x74b$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DynamicAvatarInfoHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f199955d;

    public DynamicAvatarInfoHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f199955d = appInterface;
        }
    }

    public void D2(Long l3, int i3, int i16, int i17, boolean z16) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, l3, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(17);
        arrayList2.add(18);
        ArrayList arrayList3 = null;
        if (i3 != 18) {
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(l3);
            arrayList3 = arrayList4;
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(l3);
        }
        oidb_0x74b$ReqBody oidb_0x74b_reqbody = new oidb_0x74b$ReqBody();
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            oidb_0x74b_reqbody.rpt_uint64_uin.set(arrayList3);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            oidb_0x74b_reqbody.rpt_uint64_tinyid.set(arrayList);
        }
        if (!arrayList2.isEmpty()) {
            oidb_0x74b_reqbody.rpt_head_type.set(arrayList2);
        }
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x74b", 1867, 0, oidb_0x74b_reqbody.toByteArray());
        makeOIDBPkg.extraData.putLong("id", l3.longValue());
        makeOIDBPkg.extraData.putInt("type", i3);
        makeOIDBPkg.extraData.putInt("headType", i16);
        makeOIDBPkg.extraData.putInt("sizeType", i17);
        makeOIDBPkg.extraData.putBoolean("isSmartMode", z16);
        sendPbReq(makeOIDBPkg);
    }

    public void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null) {
            if (fromServiceMsg == null) {
                obj2 = null;
                i3 = 1001;
            } else {
                oidb_0x74b$RspBody oidb_0x74b_rspbody = new oidb_0x74b$RspBody();
                int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x74b_rspbody);
                Long valueOf = Long.valueOf(toServiceMsg.extraData.getLong("id"));
                int i16 = toServiceMsg.extraData.getInt("type");
                int i17 = toServiceMsg.extraData.getInt("headType");
                int i18 = toServiceMsg.extraData.getInt("sizeType");
                boolean z16 = toServiceMsg.extraData.getBoolean("isSmartMode");
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 4, "handleDynamicAvatarInfo, result : " + parseOIDBPkg);
                if (parseOIDBPkg == 0) {
                    b a16 = b.a(oidb_0x74b_rspbody);
                    notifyUI(1001, true, new Object[]{a16, valueOf, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16)});
                    DynamicAvatarManager dynamicAvatarManager = (DynamicAvatarManager) this.f199955d.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER);
                    if (dynamicAvatarManager != null) {
                        if (this.f199955d instanceof QQAppInterface) {
                            dynamicAvatarManager.f(a16);
                        } else {
                            dynamicAvatarManager.g(oidb_0x74b_rspbody.toByteArray());
                        }
                    }
                    com.tencent.mobileqq.avatar.api.a.c(true, 0, "3");
                    return;
                }
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 1, "handleGetDynamicAvatarInfo result not success.");
                com.tencent.mobileqq.avatar.api.a.c(false, parseOIDBPkg, "3");
                notifyUI(1001, false, new Object[]{null, valueOf, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16)});
                return;
            }
        } else {
            i3 = 1001;
            obj2 = null;
        }
        notifyUI(i3, false, obj2);
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
            hashSet.add("OidbSvc.0x74b");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return c.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg == null || fromServiceMsg == null || msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            return;
        }
        fromServiceMsg.getServiceCmd();
        if ("OidbSvc.0x74b".equals(fromServiceMsg.getServiceCmd())) {
            E2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
