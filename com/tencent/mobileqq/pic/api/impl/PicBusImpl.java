package com.tencent.mobileqq.pic.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.i;
import com.tencent.mobileqq.pic.l;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class PicBusImpl implements IPicBus {
    static IPatchRedirector $redirector_;

    public PicBusImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicBus
    public CompressInfo createCompressInfo(int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CompressInfo) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) intent);
        }
        return i.a(i3, intent);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicBus
    public l createForwardPicInfo(int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? i.b(i3, intent) : (l) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) intent);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicBus
    public ArrayList<l> createForwardPicInfos(int i3, MessageRecord messageRecord, int i16, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), messageRecord, Integer.valueOf(i16), str, str2, str3);
        }
        return i.d(i3, messageRecord, i16, str, str2, str3);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicBus
    public p createPicReq(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? i.e(i3, i16) : (p) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // com.tencent.mobileqq.pic.api.IPicBus
    public v createPicUploadInfo(int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (v) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) intent);
        }
        return i.g(i3, intent);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicBus
    public long getC2CPicSizeLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return PicUploadFileSizeLimit.getLimitC2C();
    }

    @Override // com.tencent.mobileqq.pic.api.IPicBus
    public long getGroupPicSizeLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return PicUploadFileSizeLimit.getLimitGroup();
    }

    @Override // com.tencent.mobileqq.pic.api.IPicBus
    public void launch(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pVar);
        } else {
            i.k(pVar);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicBus
    public l createForwardPicInfo(int i3, MessageForPic messageForPic, int i16, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? i.c(i3, messageForPic, i16, str, str2, str3) : (l) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), messageForPic, Integer.valueOf(i16), str, str2, str3);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicBus
    public p createPicReq(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? i.f(i3, i16, i17) : (p) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
    }
}
