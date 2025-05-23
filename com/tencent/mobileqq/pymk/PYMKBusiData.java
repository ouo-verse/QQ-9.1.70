package com.tencent.mobileqq.pymk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import tencent.im.oidb.oidb_0xc26$BusiData;
import tencent.im.oidb.oidb_0xc26$BusiMediaData;

/* loaded from: classes16.dex */
public class PYMKBusiData implements Serializable, Cloneable {
    static IPatchRedirector $redirector_;
    public byte[] extra;
    public ArrayList<PYMKMedia> medias;
    public int type;

    public PYMKBusiData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static PYMKBusiData convertToPYMKBusiData(oidb_0xc26$BusiData oidb_0xc26_busidata) {
        PYMKBusiData pYMKBusiData = new PYMKBusiData();
        pYMKBusiData.type = oidb_0xc26_busidata.type.get();
        if (oidb_0xc26_busidata.extra.has()) {
            pYMKBusiData.extra = oidb_0xc26_busidata.extra.get().toByteArray();
        }
        pYMKBusiData.medias = new ArrayList<>();
        for (oidb_0xc26$BusiMediaData oidb_0xc26_busimediadata : oidb_0xc26_busidata.media.get()) {
            pYMKBusiData.medias.add(new PYMKMedia(oidb_0xc26_busimediadata.media_type.get(), oidb_0xc26_busimediadata.pic_url.get()));
        }
        return pYMKBusiData;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PYMKBusiData m213clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PYMKBusiData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            PYMKBusiData pYMKBusiData = (PYMKBusiData) super.clone();
            Iterator<PYMKMedia> it = this.medias.iterator();
            while (it.hasNext()) {
                pYMKBusiData.medias.add(it.next().m214clone());
            }
            byte[] bArr = this.extra;
            pYMKBusiData.extra = Arrays.copyOf(bArr, bArr.length);
            return pYMKBusiData;
        } catch (CloneNotSupportedException e16) {
            QLog.e("PYMKBusiData", 1, "clone error " + e16);
            return this;
        }
    }
}
