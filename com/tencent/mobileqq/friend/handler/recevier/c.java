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
import tencent.im.oidb.cmd0x1122.oidb_0x1122$FetchSelectRsp;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$UserPermission;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends a<FriendHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private FriendHandler f211676c;

    public c(@NonNull AppInterface appInterface, @NonNull FriendHandler friendHandler) {
        super(appInterface, friendHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) friendHandler);
        } else {
            this.f211676c = friendHandler;
        }
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "OidbSvcTrpcTcp.0x1130_1";
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

    /* JADX WARN: Removed duplicated region for block: B:53:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_0x1122$FetchSelectRsp oidb_0x1122_fetchselectrsp = new oidb_0x1122$FetchSelectRsp();
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            ArrayList<String> stringArrayList = toServiceMsg.extraData.getStringArrayList("qzone_permission_set_fetch_origin_uins");
            int i19 = toServiceMsg.extraData.getInt("qzone_permission_set_fetch_start");
            int i26 = toServiceMsg.extraData.getInt("qzone_permission_set_fetch_end");
            Bundle bundle = new Bundle();
            try {
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException unused) {
                z16 = false;
                i3 = 0;
            }
            if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0 && fromServiceMsg.isSuccess()) {
                oidb_0x1122_fetchselectrsp.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                List<oidb_0x1122$UserPermission> list = oidb_0x1122_fetchselectrsp.user_perms.get();
                if (list != null && list.size() > 0) {
                    i3 = list.size();
                    try {
                        for (oidb_0x1122$UserPermission oidb_0x1122_userpermission : list) {
                            arrayList.add(String.valueOf(oidb_0x1122_userpermission.uin.get()));
                            if (oidb_0x1122_userpermission.perm.only_chat.get()) {
                                i16 = 1;
                            } else {
                                i16 = 0;
                            }
                            if (oidb_0x1122_userpermission.perm.qzone_not_watched.get()) {
                                i17 = 1;
                            } else {
                                i17 = 0;
                            }
                            if (oidb_0x1122_userpermission.perm.qzone_not_watch.get()) {
                                i18 = 1;
                            } else {
                                i18 = 0;
                            }
                            arrayList2.add(Integer.valueOf(i16 + (i17 << 1) + (i18 << 2)));
                        }
                        bundle.putStringArrayList("qzone_permission_uins", arrayList);
                        bundle.putIntegerArrayList("qzone_permission_sets", arrayList2);
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d("FetchSelectFriendPermissionReceiver", 2, " handleFetchFriendPermission \uff5c status: " + arrayList2);
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferMicroException unused2) {
                            z16 = true;
                            QLog.d("FetchSelectFriendPermissionReceiver", 1, "InvalidProtocolBufferMicroException");
                            if (z16) {
                            }
                        }
                    } catch (InvalidProtocolBufferMicroException unused3) {
                        z16 = false;
                    }
                    if (z16) {
                        this.f211676c.K2(stringArrayList, i19 + i3, i26);
                        d().notifyUI(127, true, bundle);
                        return;
                    } else {
                        d().notifyUI(127, false, bundle);
                        return;
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("FetchSelectFriendPermissionReceiver", 2, "handleFetchFriendPermission | error msg: " + oidb_sso_oidbssopkg.str_error_msg.get());
            }
            z16 = false;
            i3 = 0;
            if (z16) {
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("FetchSelectFriendPermissionReceiver", 2, "handleFetchFriendPermission | result is null");
            }
            d().notifyUI(127, false, null);
        }
    }
}
