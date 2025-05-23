package com.tencent.mobileqq.newfriend.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendVerificationServiceImpl;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.newfriend.observer.d;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import tencent.im.oidb.cmd0xd7e.oidb_cmd0xd7e$ReqBody;
import tencent.im.oidb.cmd0xd82.oidb_cmd0xd82$ReqBody;
import tencent.im.oidb.cmd0xd82.oidb_cmd0xd82$RspBody;
import tencent.im.oidb.cmd0xd83.oidb_cmd0xd83$BlockedInfo;
import tencent.im.oidb.cmd0xd83.oidb_cmd0xd83$ReqBody;
import tencent.im.oidb.cmd0xd83.oidb_cmd0xd83$RspBody;
import tencent.im.oidb.cmd0xd86.oidb_cmd0xd86$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NewFriendVerificationHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final NewFriendVerificationServiceImpl f254019d;

    public NewFriendVerificationHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f254019d = (NewFriendVerificationServiceImpl) appInterface.getRuntimeService(INewFriendVerificationService.class, "");
        }
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("NewFriendVerification.handler", 1, "handleGetAddFriendBlockedRedPoint");
        }
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            NewFriendVerificationServiceImpl newFriendVerificationServiceImpl = this.f254019d;
            if (newFriendVerificationServiceImpl != null) {
                newFriendVerificationServiceImpl.onClearAddFriendBlockedList(fromServiceMsg.isSuccess());
                return;
            }
            return;
        }
        NewFriendVerificationServiceImpl newFriendVerificationServiceImpl2 = this.f254019d;
        if (newFriendVerificationServiceImpl2 != null) {
            newFriendVerificationServiceImpl2.onClearAddFriendBlockedList(true);
        }
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("NewFriendVerification.handler", 1, "handleGetAddFriendBlockedList");
        }
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            try {
                if (fromServiceMsg.isSuccess()) {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                    oidb_cmd0xd83$RspBody oidb_cmd0xd83_rspbody = new oidb_cmd0xd83$RspBody();
                    oidb_cmd0xd83_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    List<oidb_cmd0xd83$BlockedInfo> list = oidb_cmd0xd83_rspbody.rpt_block_list.get();
                    ArrayList arrayList = new ArrayList();
                    for (oidb_cmd0xd83$BlockedInfo oidb_cmd0xd83_blockedinfo : list) {
                        String valueOf = String.valueOf(oidb_cmd0xd83_blockedinfo.uint64_uin.get());
                        AddFriendBlockedInfo addFriendBlockedInfo = new AddFriendBlockedInfo();
                        addFriendBlockedInfo.f254008d = valueOf;
                        addFriendBlockedInfo.f254009e = oidb_cmd0xd83_blockedinfo.bytes_nick.get().toStringUtf8();
                        addFriendBlockedInfo.f254010f = oidb_cmd0xd83_blockedinfo.uint32_age.get();
                        addFriendBlockedInfo.f254011h = oidb_cmd0xd83_blockedinfo.uint32_sex.get();
                        if (oidb_cmd0xd83_blockedinfo.uint32_has_read.get() == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        addFriendBlockedInfo.C = z16;
                        addFriendBlockedInfo.f254012i = oidb_cmd0xd83_blockedinfo.bytes_source.get().toStringUtf8();
                        addFriendBlockedInfo.f254013m = oidb_cmd0xd83_blockedinfo.uint32_time.get();
                        addFriendBlockedInfo.D = oidb_cmd0xd83_blockedinfo.uint32_comm_frd.get();
                        arrayList.add(addFriendBlockedInfo);
                        if (QLog.isDebugVersion()) {
                            QLog.d("NewFriendVerification.handler", 2, " handleGetAddFriendBlockedList()--> blockedInfo =  " + addFriendBlockedInfo.toString());
                        }
                    }
                    String stringUtf8 = oidb_cmd0xd83_rspbody.bytes_cookies.get().toStringUtf8();
                    oidb_cmd0xd83_rspbody.uint32_entrance.get();
                    if (arrayList.size() > 0) {
                        String str = ((AddFriendBlockedInfo) arrayList.get(0)).f254008d;
                    }
                    NewFriendVerificationServiceImpl newFriendVerificationServiceImpl = this.f254019d;
                    if (newFriendVerificationServiceImpl != null) {
                        newFriendVerificationServiceImpl.onGetAddFriendBlockedList(true, arrayList, stringUtf8);
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception unused) {
                NewFriendVerificationServiceImpl newFriendVerificationServiceImpl2 = this.f254019d;
                if (newFriendVerificationServiceImpl2 != null) {
                    newFriendVerificationServiceImpl2.onGetAddFriendBlockedList(false, null, "");
                    return;
                }
                return;
            }
        }
        NewFriendVerificationServiceImpl newFriendVerificationServiceImpl3 = this.f254019d;
        if (newFriendVerificationServiceImpl3 != null) {
            newFriendVerificationServiceImpl3.onGetAddFriendBlockedList(false, null, "");
        }
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (QLog.isColorLevel()) {
            QLog.d("NewFriendVerification.handler", 1, "handleGetAddFriendBlockedRedPoint: req is " + toServiceMsg + "res is " + fromServiceMsg + "data is " + obj);
        }
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            if (fromServiceMsg.isSuccess()) {
                try {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                    oidb_cmd0xd82$RspBody oidb_cmd0xd82_rspbody = new oidb_cmd0xd82$RspBody();
                    oidb_cmd0xd82_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    int i3 = oidb_cmd0xd82_rspbody.uint32_entrance.get();
                    int i16 = oidb_cmd0xd82_rspbody.uint32_redpoint.get();
                    String valueOf = String.valueOf(oidb_cmd0xd82_rspbody.uint64_blocked_uin.get());
                    int i17 = oidb_cmd0xd82_rspbody.uint32_unread.get();
                    if (QLog.isColorLevel()) {
                        QLog.i("NewFriendVerification.handler", 2, String.format("entrance is %s, redPoint is %s, recentBlockFriendUin is %s, unread is %s", Integer.valueOf(i3), Integer.valueOf(i16), valueOf, Integer.valueOf(i17)));
                    }
                    NewFriendVerificationServiceImpl newFriendVerificationServiceImpl = this.f254019d;
                    if (newFriendVerificationServiceImpl != null) {
                        if (i3 == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (i16 == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (i17 > 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        newFriendVerificationServiceImpl.onGetAddFriendBlockedRedPoint(true, z16, z17, valueOf, z18);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    NewFriendVerificationServiceImpl newFriendVerificationServiceImpl2 = this.f254019d;
                    if (newFriendVerificationServiceImpl2 != null) {
                        newFriendVerificationServiceImpl2.onGetAddFriendBlockedRedPoint(true, false, false, "", false);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        NewFriendVerificationServiceImpl newFriendVerificationServiceImpl3 = this.f254019d;
        if (newFriendVerificationServiceImpl3 != null) {
            newFriendVerificationServiceImpl3.onGetAddFriendBlockedRedPoint(true, false, false, "", false);
        }
    }

    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("NewFriendVerification.handler", 1, "handleReportAddFriendBlocked");
        }
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            NewFriendVerificationServiceImpl newFriendVerificationServiceImpl = this.f254019d;
            if (newFriendVerificationServiceImpl != null) {
                newFriendVerificationServiceImpl.onReportAddFriendBlocked(fromServiceMsg.isSuccess());
                return;
            }
            return;
        }
        NewFriendVerificationServiceImpl newFriendVerificationServiceImpl2 = this.f254019d;
        if (newFriendVerificationServiceImpl2 != null) {
            newFriendVerificationServiceImpl2.onReportAddFriendBlocked(false);
        }
    }

    private static boolean isNumeric(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
    }

    public void D2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        try {
            oidb_cmd0xd7e$ReqBody oidb_cmd0xd7e_reqbody = new oidb_cmd0xd7e$ReqBody();
            oidb_cmd0xd7e_reqbody.uin.set(Long.parseLong(str));
            sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd7e", 3454, 0, oidb_cmd0xd7e_reqbody.toByteArray()));
        } catch (NumberFormatException unused) {
            NewFriendVerificationServiceImpl newFriendVerificationServiceImpl = this.f254019d;
            if (newFriendVerificationServiceImpl != null) {
                newFriendVerificationServiceImpl.onClearAddFriendBlockedList(false);
            }
        }
    }

    public void E2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        try {
            oidb_cmd0xd82$ReqBody oidb_cmd0xd82_reqbody = new oidb_cmd0xd82$ReqBody();
            oidb_cmd0xd82_reqbody.uin.set(Long.parseLong(str));
            sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd82", 3458, 0, oidb_cmd0xd82_reqbody.toByteArray()));
        } catch (NumberFormatException unused) {
            NewFriendVerificationServiceImpl newFriendVerificationServiceImpl = this.f254019d;
            if (newFriendVerificationServiceImpl != null) {
                newFriendVerificationServiceImpl.onGetAddFriendBlockedRedPoint(false, false, false, "", false);
            }
        }
    }

    public void F2(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2);
            return;
        }
        try {
            oidb_cmd0xd83$ReqBody oidb_cmd0xd83_reqbody = new oidb_cmd0xd83$ReqBody();
            oidb_cmd0xd83_reqbody.uint64_uin.set(Long.parseLong(str));
            oidb_cmd0xd83_reqbody.uint32_req_num.set(i3);
            oidb_cmd0xd83_reqbody.bytes_cookies.set(ByteStringMicro.copyFromUtf8(str2));
            sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd83", 3459, 0, oidb_cmd0xd83_reqbody.toByteArray()));
        } catch (NumberFormatException unused) {
            NewFriendVerificationServiceImpl newFriendVerificationServiceImpl = this.f254019d;
            if (newFriendVerificationServiceImpl != null) {
                newFriendVerificationServiceImpl.onGetAddFriendBlockedList(false, null, "");
            }
        }
    }

    public void K2(String str, String str2, int i3, int i16, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3);
            return;
        }
        try {
            oidb_cmd0xd86$ReqBody oidb_cmd0xd86_reqbody = new oidb_cmd0xd86$ReqBody();
            oidb_cmd0xd86_reqbody.uin.set(Long.parseLong(str));
            oidb_cmd0xd86_reqbody.blocked_uin.set(Long.parseLong(str2));
            oidb_cmd0xd86_reqbody.source_id.set(i3);
            oidb_cmd0xd86_reqbody.sub_sourceid.set(i16);
            if (isNumeric(str3)) {
                oidb_cmd0xd86_reqbody.group_uin.set(Long.parseLong(str3));
            } else {
                oidb_cmd0xd86_reqbody.group_uin.set(0L);
            }
            sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd86", 3462, 0, oidb_cmd0xd86_reqbody.toByteArray()));
        } catch (NumberFormatException unused) {
            NewFriendVerificationServiceImpl newFriendVerificationServiceImpl = this.f254019d;
            if (newFriendVerificationServiceImpl != null) {
                newFriendVerificationServiceImpl.onReportAddFriendBlocked(false);
            }
        }
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
            hashSet.add("OidbSvc.oidb_0xd86");
            this.allowCmdSet.add("OidbSvc.oidb_0xd83");
            this.allowCmdSet.add("OidbSvc.oidb_0xd82");
            this.allowCmdSet.add("OidbSvc.oidb_0xd7e");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Class) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return d.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.oidb_0xd86".equals(fromServiceMsg.getServiceCmd())) {
            J2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.oidb_0xd83".equals(fromServiceMsg.getServiceCmd())) {
            H2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.oidb_0xd82".equals(fromServiceMsg.getServiceCmd())) {
            I2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.oidb_0xd7e".equals(fromServiceMsg.getServiceCmd())) {
            G2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
