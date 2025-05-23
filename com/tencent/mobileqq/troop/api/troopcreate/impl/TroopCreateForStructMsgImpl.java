package com.tencent.mobileqq.troop.api.troopcreate.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateForStructMsg;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopCreateForStructMsgImpl implements ITroopCreateForStructMsg {
    static IPatchRedirector $redirector_;
    private AbsStructMsg mStructMsg;

    public TroopCreateForStructMsgImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateForStructMsg
    public boolean instanceofImgaeShare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.mStructMsg instanceof StructMsgForImageShare;
    }

    @Override // com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateForStructMsg
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mStructMsg = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateForStructMsg
    public void sendStructingMsg(AppRuntime appRuntime, String str, int i3, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, str, Integer.valueOf(i3), businessObserver);
            return;
        }
        AbsStructMsg absStructMsg = this.mStructMsg;
        if (absStructMsg != null && (appRuntime instanceof QQAppInterface)) {
            ShareMsgHelper.g((QQAppInterface) appRuntime, str, i3, absStructMsg, null);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateForStructMsg
    public void setAbsStructMsgFromByte(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        } else {
            this.mStructMsg = i.d(bArr);
        }
    }
}
