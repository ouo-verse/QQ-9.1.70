package com.tencent.mobileqq.qrscan.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.a;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.qrscan.i;
import com.tencent.mobileqq.qrscan.j;
import com.tencent.mobileqq.qrscan.minicode.MiniCodeController;
import com.tencent.mobileqq.qrscan.minicode.e;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MiniCodeApiImpl implements IMiniCodeApi {
    static IPatchRedirector $redirector_;

    public MiniCodeApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public void addDetectCallback(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) iVar);
        } else {
            MiniCodeController.p().j(iVar);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public void addInitCallback(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) jVar);
        } else {
            MiniCodeController.p().i(jVar);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public boolean bValidDecodeResult(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        return MiniCodeController.k(str);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public String decode(byte[] bArr, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? MiniCodeController.p().l(bArr, i3, i16, i17, i18) : (String) iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public boolean detect(Bitmap bitmap, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, bitmap, Long.valueOf(j3))).booleanValue();
        }
        return MiniCodeController.p().n(bitmap, j3);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public boolean detectSync(Bitmap bitmap, ArrayList<a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bitmap, (Object) arrayList)).booleanValue();
        }
        return MiniCodeController.p().o(bitmap, arrayList);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public int getSupportDetectType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return e.i();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public void init(Context context, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Long.valueOf(j3), str);
        } else {
            MiniCodeController.p().q(context, j3, str);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public boolean isDecodeInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return MiniCodeController.t();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public boolean isDetectInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return MiniCodeController.u();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public boolean isDetectReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return MiniCodeController.p().r();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public void removeDetectCallback(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) iVar);
        } else {
            MiniCodeController.p().z(iVar);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public void removeInitCallback(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) jVar);
        } else {
            MiniCodeController.p().y(jVar);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public void unInit(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), str);
        } else {
            MiniCodeController.p().x(j3, str);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public int yuv2Rgba(int[] iArr, byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, iArr, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return MiniCodeController.h(iArr, bArr, i3, i16);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IMiniCodeApi
    public String decode(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? MiniCodeController.p().m(bArr, i3, i16, i17, i18, i19, i26, i27, i28) : (String) iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
    }
}
