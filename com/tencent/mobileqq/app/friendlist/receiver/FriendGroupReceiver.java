package com.tencent.mobileqq.app.friendlist.receiver;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import friendlist.MovGroupMemResp;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FriendGroupReceiver extends a {
    static IPatchRedirector $redirector_;

    public FriendGroupReceiver(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    private void e(ToServiceMsg toServiceMsg, MovGroupMemResp movGroupMemResp) {
        Bundle bundle = toServiceMsg.extraData;
        String string = bundle.getString("uin");
        byte b16 = bundle.getByte("group_id");
        byte b17 = bundle.getByte("away_group_id");
        if (movGroupMemResp.result == 0) {
            ((FriendsManager) this.f195646a.getManager(QQManagerFactory.FRIENDS_MANAGER)).z0(string, b16, new hx3.c<Boolean>(string, b16, b17) { // from class: com.tencent.mobileqq.app.friendlist.receiver.FriendGroupReceiver.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f195641a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ byte f195642b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ byte f195643c;

                {
                    this.f195641a = string;
                    this.f195642b = b16;
                    this.f195643c = b17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, FriendGroupReceiver.this, string, Byte.valueOf(b16), Byte.valueOf(b17));
                    }
                }

                @Override // hx3.c
                public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.app.friendlist.receiver.FriendGroupReceiver.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    FriendGroupReceiver.this.b(9, true, new Object[]{anonymousClass1.f195641a, Byte.valueOf(anonymousClass1.f195642b), Byte.valueOf(AnonymousClass1.this.f195643c)});
                                }
                            }
                        });
                    }
                }
            });
        } else {
            b(9, false, null);
        }
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!"friendlist.MovGroupMemReq".equals(str) && !"friendlist.SetGroupReq".equals(str)) {
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
        if ("friendlist.MovGroupMemReq".equals(fromServiceMsg.getServiceCmd())) {
            byte b16 = toServiceMsg.extraData.getByte("move_fri_type");
            if (b16 == 0) {
                if (obj != null) {
                    e(toServiceMsg, (MovGroupMemResp) obj);
                    return;
                } else {
                    b(9, false, null);
                    return;
                }
            }
            if (b16 == 1 && obj != null) {
            }
        }
    }
}
