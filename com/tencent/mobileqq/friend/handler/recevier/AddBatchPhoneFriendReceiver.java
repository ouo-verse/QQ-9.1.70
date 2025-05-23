package com.tencent.mobileqq.friend.handler.recevier;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x829.oidb_0x829$AddFrdInfo;
import tencent.im.oidb.cmd0x829.oidb_0x829$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes12.dex */
public class AddBatchPhoneFriendReceiver extends a<FriendHandler> {
    static IPatchRedirector $redirector_;

    public AddBatchPhoneFriendReceiver(@NotNull AppInterface appInterface, @NotNull FriendHandler friendHandler) {
        super(appInterface, friendHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) friendHandler);
        }
    }

    public static oidb_sso$OIDBSSOPkg g(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddBatchPhoneFriendReceiver", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
                }
            }
            if (oidb_sso_oidbssopkg.uint32_result.get() == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                return oidb_sso_oidbssopkg;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AddBatchPhoneFriendReceiver", 2, "parseSSOPkg: oidb_sso ssoPkg.uint32_result.get() " + oidb_sso_oidbssopkg.uint32_result.get());
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "OidbSvc.0x829_1";
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    public void e(@NotNull ToServiceMsg toServiceMsg, @NotNull FromServiceMsg fromServiceMsg, @Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        } else {
            f(toServiceMsg, fromServiceMsg, obj);
        }
    }

    protected void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel() && fromServiceMsg != null) {
            QLog.d("AddBatchPhoneFriendReceiver", 2, "FriendListHandler.handleBatchAddPhoneFriend sso resp: " + fromServiceMsg + ", data: " + obj);
        }
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        oidb_0x829$RspBody oidb_0x829_rspbody = new oidb_0x829$RspBody();
        ArrayList arrayList = (ArrayList) toServiceMsg.extraData.getSerializable("phones");
        int intValue = Integer.valueOf(toServiceMsg.extraData.getInt("package", -1)).intValue();
        ArrayList arrayList2 = (ArrayList) toServiceMsg.extraData.getSerializable("resultList");
        String string = toServiceMsg.extraData.getString("verifyMsg");
        int intValue2 = Integer.valueOf(toServiceMsg.extraData.getInt("sourceId")).intValue();
        int i3 = intValue * 30;
        if (z16) {
            oidb_sso$OIDBSSOPkg g16 = g(toServiceMsg, fromServiceMsg, obj);
            if (g16 != null) {
                int i16 = g16.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d("AddBatchPhoneFriendReceiver", 2, "FriendListHandler.handleBatchAddPhoneFriend oidb result code: " + i16);
                }
                if (i16 == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    try {
                        oidb_0x829_rspbody.mergeFrom(g16.bytes_bodybuffer.get().toByteArray());
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AddBatchPhoneFriendReceiver", 2, "FriendListHandler.handleBatchAddPhoneFriend RspBody mergeFrom failed.");
                        }
                        e16.printStackTrace();
                    }
                }
                z16 = z17;
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AddBatchPhoneFriendReceiver", 2, "FriendListHandler.handleBatchAddPhoneFriend isSuccess: " + z16);
        }
        if (z16) {
            if (oidb_0x829_rspbody.rpt_add_frd_info.has()) {
                for (int i17 = 0; i17 < oidb_0x829_rspbody.rpt_add_frd_info.size(); i17++) {
                    oidb_0x829$AddFrdInfo oidb_0x829_addfrdinfo = oidb_0x829_rspbody.rpt_add_frd_info.get(i17);
                    AddBatchPhoneFriendResult addBatchPhoneFriendResult = new AddBatchPhoneFriendResult();
                    addBatchPhoneFriendResult.mobile = oidb_0x829_addfrdinfo.bytes_mobile.get().toStringUtf8();
                    addBatchPhoneFriendResult.remark = oidb_0x829_addfrdinfo.bytes_remark.get().toStringUtf8();
                    addBatchPhoneFriendResult.allowType = oidb_0x829_addfrdinfo.uint32_allow_type.get();
                    addBatchPhoneFriendResult.sendReqFlag = oidb_0x829_addfrdinfo.uint32_send_req_flag.get();
                    addBatchPhoneFriendResult.sendResult = oidb_0x829_addfrdinfo.uint32_send_result.get();
                    arrayList2.add(addBatchPhoneFriendResult);
                }
            }
            if (intValue != -1 && arrayList != null && arrayList2 != null && i3 < arrayList.size()) {
                b().runOnUiThread(new Runnable(arrayList, string, intValue, intValue2, arrayList2) { // from class: com.tencent.mobileqq.friend.handler.recevier.AddBatchPhoneFriendReceiver.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ArrayList f211663d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f211664e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f211665f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ int f211666h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ ArrayList f211667i;

                    {
                        this.f211663d = arrayList;
                        this.f211664e = string;
                        this.f211665f = intValue;
                        this.f211666h = intValue2;
                        this.f211667i = arrayList2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AddBatchPhoneFriendReceiver.this, arrayList, string, Integer.valueOf(intValue), Integer.valueOf(intValue2), arrayList2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            AddBatchPhoneFriendReceiver.this.d().P2(this.f211663d, this.f211664e, this.f211665f, this.f211666h, this.f211667i);
                        }
                    }
                });
                return;
            } else {
                d().notifyUI(105, true, arrayList2);
                return;
            }
        }
        if (intValue != -1 && arrayList != null && arrayList2 != null && i3 < arrayList.size()) {
            b().runOnUiThread(new Runnable(arrayList, string, intValue, intValue2, arrayList2) { // from class: com.tencent.mobileqq.friend.handler.recevier.AddBatchPhoneFriendReceiver.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f211668d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f211669e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f211670f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f211671h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ ArrayList f211672i;

                {
                    this.f211668d = arrayList;
                    this.f211669e = string;
                    this.f211670f = intValue;
                    this.f211671h = intValue2;
                    this.f211672i = arrayList2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AddBatchPhoneFriendReceiver.this, arrayList, string, Integer.valueOf(intValue), Integer.valueOf(intValue2), arrayList2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        AddBatchPhoneFriendReceiver.this.d().P2(this.f211668d, this.f211669e, this.f211670f, this.f211671h, this.f211672i);
                    }
                }
            });
        } else if (arrayList2 != null && arrayList2.size() > 0) {
            d().notifyUI(105, true, arrayList2);
        } else {
            d().notifyUI(105, false, null);
        }
    }
}
