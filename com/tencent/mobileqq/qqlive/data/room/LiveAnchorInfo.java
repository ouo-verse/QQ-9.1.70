package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveAnchorInfo implements BaseAnchorInfo {
    static IPatchRedirector $redirector_;
    public String businessUid;
    public long explicitId;
    public String headUrl;
    public long imsdkTinyId;
    public int initialClientType;
    public String nickName;
    public int sex;
    public long uid;
    public String wechatPub;

    public LiveAnchorInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo
    public long getAnchorUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.uid;
    }
}
