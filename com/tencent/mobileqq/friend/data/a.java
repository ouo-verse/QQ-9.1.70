package com.tencent.mobileqq.friend.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendListSubSrvRspCode;
import friendlist.GetFriendListResp;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f211604a;

    /* renamed from: b, reason: collision with root package name */
    public int f211605b;

    /* renamed from: c, reason: collision with root package name */
    public int f211606c;

    /* renamed from: d, reason: collision with root package name */
    public int f211607d;

    public a(GetFriendListResp getFriendListResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) getFriendListResp);
            return;
        }
        this.f211604a = 0L;
        this.f211605b = 0;
        this.f211606c = 0;
        this.f211607d = 0;
        this.f211604a = getFriendListResp.serverTime;
        this.f211605b = getFriendListResp.wGetExtSnsRspCode;
        FriendListSubSrvRspCode friendListSubSrvRspCode = getFriendListResp.stSubSrvRspCode;
        if (friendListSubSrvRspCode != null) {
            this.f211606c = friendListSubSrvRspCode.wGetMutualMarkRspCode;
            this.f211607d = friendListSubSrvRspCode.wGetIntimateInfoRspCode;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtRspCode", 2, "wGetExtSnsRspCode: " + this.f211605b + ", wGetMutualMarkRspCode: " + this.f211606c + ", wGetIntimateInfoRspCode: " + this.f211607d);
        }
    }
}
