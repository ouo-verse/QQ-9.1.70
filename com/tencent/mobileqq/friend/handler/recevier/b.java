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
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$FetchPagedRsp;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$UserPermission;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends a<FriendHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private FriendHandler f211675c;

    public b(@NonNull AppInterface appInterface, @NonNull FriendHandler friendHandler) {
        super(appInterface, friendHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) friendHandler);
        } else {
            this.f211675c = friendHandler;
        }
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "OidbSvcTrpcTcp.0x112b_1";
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
        Bundle bundle = new Bundle();
        boolean z16 = false;
        if (fromServiceMsg != null && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_0x1122$FetchPagedRsp oidb_0x1122_fetchpagedrsp = new oidb_0x1122$FetchPagedRsp();
            try {
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0 && fromServiceMsg.isSuccess()) {
                    oidb_0x1122_fetchpagedrsp.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    List<oidb_0x1122$UserPermission> list = oidb_0x1122_fetchpagedrsp.user_perms.get();
                    if (list != null && list.size() > 0) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        Iterator<oidb_0x1122$UserPermission> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(String.valueOf(it.next().uin.get()));
                        }
                        bundle.putStringArrayList("qzone_permission_uins", arrayList);
                        try {
                            if (oidb_0x1122_fetchpagedrsp.is_over.get()) {
                                this.f211675c.J2(oidb_0x1122_fetchpagedrsp.next_start.get());
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferMicroException unused) {
                            z16 = true;
                            QLog.d("FetchPageFriendPermissionReceiver", 1, "InvalidProtocolBufferMicroException");
                            d().notifyUI(128, z16, bundle);
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("FetchPageFriendPermissionReceiver", 2, "handleBatchOnlyChatPermission | error msg: " + oidb_sso_oidbssopkg.str_error_msg.get());
                }
            } catch (InvalidProtocolBufferMicroException unused2) {
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("FetchPageFriendPermissionReceiver", 2, "handleBatchOnlyChatPermission | result is null");
        }
        d().notifyUI(128, z16, bundle);
    }
}
