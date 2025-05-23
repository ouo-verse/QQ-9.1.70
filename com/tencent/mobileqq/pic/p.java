package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes16.dex */
public class p implements Comparable<p> {
    static IPatchRedirector $redirector_;
    public v C;
    public l D;
    public PicMessageExtraData E;
    public ArrayList<l> F;
    public ac G;
    public MessageForPic H;
    public int I;
    public int J;
    public int K;
    public int L;
    public com.tencent.mobileqq.activity.aio.photo.j M;
    public Object N;

    /* renamed from: d, reason: collision with root package name */
    public int f258783d;

    /* renamed from: e, reason: collision with root package name */
    public int f258784e;

    /* renamed from: f, reason: collision with root package name */
    public String f258785f;

    /* renamed from: h, reason: collision with root package name */
    public String f258786h;

    /* renamed from: i, reason: collision with root package name */
    public CompressInfo f258787i;

    /* renamed from: m, reason: collision with root package name */
    public k f258788m;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f258783d = -1;
        this.K = 1;
        this.L = 1;
        this.f258785f = i();
    }

    public static String i() {
        return "__" + UUID.randomUUID().toString();
    }

    public void c(ArrayList<l> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<l> it = arrayList.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (next != null) {
                    v vVar = next.f258731f;
                    if (vVar != null) {
                        vVar.f258711e = this.f258785f;
                        vVar.f258712f = this.f258784e;
                    }
                    k kVar = next.f258732h;
                    if (kVar != null) {
                        kVar.f258711e = this.f258785f;
                        kVar.f258712f = this.f258784e;
                    }
                }
            }
            this.F = arrayList;
            this.f258786h = f.a(arrayList.get(0).f258731f.f258713h, 2, 1);
            return;
        }
        f.c("PIC_TAG_ERROR", this.f258785f, "bindReqObj", "fwInfoList is empty");
    }

    public boolean d(MessageForPic messageForPic, k kVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageForPic, (Object) kVar)).booleanValue();
        }
        if (kVar == null) {
            f.c("PIC_TAG_ERROR", this.f258785f, "bindReqObj", "downInfo == null");
            return false;
        }
        kVar.f258711e = this.f258785f;
        kVar.f258712f = this.f258784e;
        kVar.S = messageForPic.time;
        kVar.f258729f0 = messageForPic.bEnableEnc;
        this.f258788m = kVar;
        int i16 = this.f258783d;
        if (i16 == 5) {
            kVar.I = "chatthumb";
            i3 = 65537;
        } else if (i16 == 7) {
            kVar.I = ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW;
            i3 = 131075;
        } else {
            if (i16 == 6) {
                kVar.I = ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE;
            }
            i3 = 1;
        }
        this.f258786h = f.a(kVar.f258713h, 0, i3);
        this.H = messageForPic;
        return true;
    }

    public boolean e(l lVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) lVar)).booleanValue();
        }
        if (lVar == null) {
            f.c("PIC_TAG_ERROR", this.f258785f, "bindReqObj", "forwardInfo == null");
            return false;
        }
        v vVar = lVar.f258731f;
        if (vVar != null) {
            vVar.f258711e = this.f258785f;
            vVar.f258712f = this.f258784e;
        }
        k kVar = lVar.f258732h;
        if (kVar != null) {
            kVar.f258711e = this.f258785f;
            kVar.f258712f = this.f258784e;
        }
        this.D = lVar;
        if (vVar != null) {
            i3 = vVar.f258713h;
        } else {
            i3 = -1;
        }
        this.f258786h = f.a(i3, 2, 1);
        return true;
    }

    public boolean f(v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) vVar)).booleanValue();
        }
        if (vVar == null) {
            f.c("PIC_TAG_ERROR", this.f258785f, "bindReqObj", "upInfo == null");
            return false;
        }
        vVar.f258711e = this.f258785f;
        vVar.f258712f = this.f258784e;
        this.C = vVar;
        this.f258786h = f.a(vVar.f258713h, 1, 1);
        return true;
    }

    public void g(ac acVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) acVar);
        } else {
            this.G = acVar;
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compareTo(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) pVar)).intValue();
        }
        int i3 = this.K;
        int i16 = pVar.K;
        if (i3 < i16) {
            return -1;
        }
        if (i3 > i16) {
            return 1;
        }
        return 0;
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        this.f258785f = str;
        CompressInfo compressInfo = this.f258787i;
        if (compressInfo != null) {
            compressInfo.f258514d = str;
        }
        v vVar = this.C;
        if (vVar != null) {
            vVar.f258711e = str;
        }
        k kVar = this.f258788m;
        if (kVar != null) {
            kVar.f258711e = str;
        }
    }
}
