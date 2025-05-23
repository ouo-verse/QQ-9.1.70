package com.tencent.mobileqq.relation.api.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relation.api.IFriendsUtils;
import friendlist.GetOnlineInfoResp;

/* compiled from: P */
/* loaded from: classes17.dex */
public class FriendsUtilsImpl implements IFriendsUtils {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends ar {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IFriendsUtils.a f280589d;

        a(IFriendsUtils.a aVar) {
            this.f280589d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendsUtilsImpl.this, (Object) aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onGetOnlineInfoByUinOrMobile(boolean z16, long j3, String str, GetOnlineInfoResp getOnlineInfoResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3), str, getOnlineInfoResp);
            } else {
                this.f280589d.b(z16, j3, str);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            } else {
                this.f280589d.a(str, z16);
            }
        }
    }

    public FriendsUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IFriendsUtils
    public BusinessObserver createFriendObserver(IFriendsUtils.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        return new a(aVar);
    }

    @Override // com.tencent.mobileqq.relation.api.IFriendsUtils
    public int getNetworkType(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).intValue();
        }
        return com.tencent.mobileqq.activity.contacts.friend.a.a(i3, i16, i17);
    }
}
