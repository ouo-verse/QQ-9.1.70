package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$SNSUpdateResult;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$SetRsp;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class l extends a<FriendHandler> {
    static IPatchRedirector $redirector_;

    public l(@NonNull AppInterface appInterface, @NonNull FriendHandler friendHandler) {
        super(appInterface, friendHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) friendHandler);
        }
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "OidbSvcTrpcTcp.0x1122_1";
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean z16 = false;
        if (fromServiceMsg != null && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_0x1122$SetRsp oidb_0x1122_setrsp = new oidb_0x1122$SetRsp();
            Bundle bundle = new Bundle();
            try {
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0 && fromServiceMsg.isSuccess()) {
                    oidb_0x1122_setrsp.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    List<oidb_0x1122$SNSUpdateResult> list = oidb_0x1122_setrsp.results.get();
                    if (list != null && list.size() > 0) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ArrayList<Integer> arrayList2 = new ArrayList<>();
                        for (oidb_0x1122$SNSUpdateResult oidb_0x1122_snsupdateresult : list) {
                            arrayList.add(String.valueOf(oidb_0x1122_snsupdateresult.uin.get()));
                            arrayList2.add(Integer.valueOf(oidb_0x1122_snsupdateresult.result.get()));
                        }
                        bundle.putStringArrayList("qzone_permission_uins", arrayList);
                        bundle.putIntegerArrayList("qzone_permission_res", arrayList2);
                        bundle.putInt("qzone_permission_status", toServiceMsg.extraData.getInt("qzone_permission_status"));
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d("SetQZonePermissionReceiver", 2, "handleSetFriendPermission \uff5c result: " + arrayList2.toString());
                                QLog.d("SetQZonePermissionReceiver", 2, "handleSetFriendPermission \uff5c status: " + toServiceMsg.extraData.getInt("qzone_permission_status"));
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferMicroException unused) {
                            z16 = true;
                            QLog.d("SetQZonePermissionReceiver", 1, "InvalidProtocolBufferMicroException");
                            d().notifyUI(126, z16, bundle);
                            return;
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("SetQZonePermissionReceiver", 2, "handleSetQZonePermission | error msg: " + oidb_sso_oidbssopkg.str_error_msg.get());
                }
            } catch (InvalidProtocolBufferMicroException unused2) {
            }
            d().notifyUI(126, z16, bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SetQZonePermissionReceiver", 2, "handleSetQZonePermission | result is null");
        }
        d().notifyUI(126, false, null);
    }
}
