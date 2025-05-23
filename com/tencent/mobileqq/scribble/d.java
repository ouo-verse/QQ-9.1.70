package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d implements Comparable<d> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public MessageForScribble f282556d;

    /* renamed from: e, reason: collision with root package name */
    public int f282557e;

    public d(MessageForScribble messageForScribble, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageForScribble, i3);
            return;
        }
        this.f282557e = 200;
        this.f282556d = messageForScribble;
        if (i3 >= 200) {
            this.f282557e = i3;
        } else {
            QLog.e("ScribbleDownloadInfo", 1, "err priority");
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar)).intValue();
        }
        int i3 = this.f282557e;
        int i16 = dVar.f282557e;
        if (i3 < i16) {
            return -1;
        }
        if (i3 > i16) {
            return 1;
        }
        return 0;
    }
}
