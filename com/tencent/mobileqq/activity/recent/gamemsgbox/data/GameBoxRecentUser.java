package com.tencent.mobileqq.activity.recent.gamemsgbox.data;

import com.tencent.mobileqq.gamecenter.data.f;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GameBoxRecentUser extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "GameBoxRecentUser";

    @unique
    public String mConvertUin;
    public String mFromOpenId;
    public String mFromRoleId;
    public String mFromTinyId;
    public String mGameAppId;
    public String mSig;
    public long mTime;
    public String mToOpenId;
    public String mToRoleId;
    public String mToTinyId;

    public GameBoxRecentUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public void print() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder(500);
                sb5.append(" appId:");
                sb5.append(this.mGameAppId);
                sb5.append(",fromRoleId:");
                sb5.append(this.mFromRoleId);
                sb5.append(",toRoleId:");
                sb5.append(this.mToRoleId);
                sb5.append(",fromTinyId:");
                sb5.append(this.mToTinyId);
                sb5.append(",fromOpenId:");
                sb5.append(this.mFromOpenId);
                sb5.append(",toOpenId:");
                sb5.append(this.mToOpenId);
                sb5.append(",sig:");
                sb5.append(this.mSig);
                QLog.d(TAG, 2, sb5.toString());
            }
        } catch (Throwable th5) {
            QLog.w(TAG, 1, th5.getMessage());
        }
    }

    public GameBoxRecentUser(String str, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) fVar);
            return;
        }
        this.mGameAppId = fVar.f212012a;
        this.mFromRoleId = fVar.f212013b;
        this.mToRoleId = fVar.f212014c;
        this.mFromTinyId = fVar.f212015d;
        this.mToTinyId = fVar.f212016e;
        this.mFromOpenId = fVar.f212017f;
        this.mToOpenId = fVar.f212018g;
        this.mSig = fVar.f212019h;
        this.mTime = fVar.f212020i;
        this.mConvertUin = str;
    }
}
