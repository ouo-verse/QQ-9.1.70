package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataUserInfo implements BaseAnchorInfo {
    static IPatchRedirector $redirector_;
    public String avatarUrl;
    public String businessUid;
    public long explicitId;

    /* renamed from: id, reason: collision with root package name */
    public long f271213id;
    public int initialClientType;
    public String nickName;
    public long tinyId;

    public QQLiveAnchorDataUserInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo
    public long getAnchorUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.f271213id;
    }

    public QQLiveAnchorDataUserInfo(QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataUserInfo);
            return;
        }
        this.f271213id = qQLiveAnchorDataUserInfo.f271213id;
        this.explicitId = qQLiveAnchorDataUserInfo.explicitId;
        this.nickName = qQLiveAnchorDataUserInfo.nickName;
        this.avatarUrl = qQLiveAnchorDataUserInfo.avatarUrl;
        this.initialClientType = qQLiveAnchorDataUserInfo.initialClientType;
        this.businessUid = qQLiveAnchorDataUserInfo.businessUid;
        this.tinyId = qQLiveAnchorDataUserInfo.tinyId;
    }
}
