package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x10fa.oidb_0x10fa$IsFriendBatchRsp;
import tencent.im.oidb.cmd0x10fa.oidb_0x10fa$IsFriendResult;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h extends a<FriendHandler> {
    static IPatchRedirector $redirector_;

    public h(@NotNull AppInterface appInterface, @NotNull FriendHandler friendHandler) {
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
        return "OidbSvcTrpcTcp.0x10fa";
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    public void e(@NotNull ToServiceMsg toServiceMsg, @NotNull FromServiceMsg fromServiceMsg, @Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        } else if (obj instanceof byte[]) {
            f(toServiceMsg, fromServiceMsg, (byte[]) obj);
        }
    }

    protected void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, byte[] bArr) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, bArr);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleGetInfoWithOpenId ");
        sb5.append(fromServiceMsg.isSuccess());
        sb5.append(", ");
        if (bArr != null) {
            i3 = bArr.length;
        } else {
            i3 = -1;
        }
        sb5.append(i3);
        QLog.d("GetIsFriendByOpenidReceiver", 1, sb5.toString());
        Bundle bundle = toServiceMsg.extraData;
        boolean z16 = bundle.getBoolean("isFromZPlan", false);
        ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("zplanResultReceiver");
        if (z16 && resultReceiver != null) {
            HashMap hashMap = new HashMap();
            if (fromServiceMsg.isSuccess()) {
                try {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom(bArr);
                    if (oidb_sso_oidbssopkg.uint32_result.has()) {
                        QLog.d("GetIsFriendByOpenidReceiver", 1, "handleGetInfoWithOpenId sso.uint32_result:", Integer.valueOf(oidb_sso_oidbssopkg.uint32_result.get()));
                        if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                            oidb_0x10fa$IsFriendBatchRsp oidb_0x10fa_isfriendbatchrsp = new oidb_0x10fa$IsFriendBatchRsp();
                            oidb_0x10fa_isfriendbatchrsp.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                            QLog.d("GetIsFriendByOpenidReceiver", 1, "handleGetInfoWithOpenId response.results.size():", Integer.valueOf(oidb_0x10fa_isfriendbatchrsp.results.size()));
                            if (oidb_0x10fa_isfriendbatchrsp.results.size() > 0) {
                                for (oidb_0x10fa$IsFriendResult oidb_0x10fa_isfriendresult : oidb_0x10fa_isfriendbatchrsp.results.get()) {
                                    String str = oidb_0x10fa_isfriendresult.openid.get();
                                    boolean z17 = oidb_0x10fa_isfriendresult.is_friend.get();
                                    hashMap.put(str, Boolean.valueOf(z17));
                                    if (QLog.isColorLevel()) {
                                        QLog.d("GetIsFriendByOpenidReceiver", 2, "handleGetInfoWithOpenId " + str + " isFriend:" + z17);
                                    }
                                }
                            }
                        }
                        bundle.putSerializable("isFriendMap", hashMap);
                        resultReceiver.send(oidb_sso_oidbssopkg.uint32_result.get(), bundle);
                        return;
                    }
                    QLog.d("GetIsFriendByOpenidReceiver", 1, "handleGetInfoWithOpenId sso.uint32_result.has() is false");
                } catch (Throwable th5) {
                    QLog.e("GetIsFriendByOpenidReceiver", 1, "handleGetInfoWithOpenId error", th5);
                }
            }
            resultReceiver.send(-1, null);
            return;
        }
        QLog.d("GetIsFriendByOpenidReceiver", 1, "handleGetInfoWithOpenId isNotFromZplan or receiver is null");
    }
}
