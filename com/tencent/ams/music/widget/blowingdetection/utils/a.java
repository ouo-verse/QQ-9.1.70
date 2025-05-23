package com.tencent.ams.music.widget.blowingdetection.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected static final Comparator<byte[]> f71647e;

    /* renamed from: a, reason: collision with root package name */
    private final int f71648a;

    /* renamed from: b, reason: collision with root package name */
    private List<byte[]> f71649b;

    /* renamed from: c, reason: collision with root package name */
    private List<byte[]> f71650c;

    /* renamed from: d, reason: collision with root package name */
    private int f71651d;

    /* compiled from: P */
    /* renamed from: com.tencent.ams.music.widget.blowingdetection.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0700a implements Comparator<byte[]> {
        static IPatchRedirector $redirector_;

        C0700a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, (Object) bArr2)).intValue();
            }
            return bArr.length - bArr2.length;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55849);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f71647e = new C0700a();
        }
    }

    public a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f71649b = new LinkedList();
        this.f71650c = new ArrayList(64);
        this.f71651d = 0;
        this.f71648a = i3;
    }

    public synchronized byte[] a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        for (int i16 = 0; i16 < this.f71650c.size(); i16++) {
            byte[] bArr = this.f71650c.get(i16);
            if (bArr.length >= i3) {
                this.f71651d -= bArr.length;
                this.f71650c.remove(i16);
                this.f71649b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i3];
    }
}
