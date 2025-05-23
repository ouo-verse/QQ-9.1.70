package com.tencent.theme.engine.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final a f376053e;

    /* renamed from: f, reason: collision with root package name */
    protected static final Comparator<byte[]> f376054f;

    /* renamed from: a, reason: collision with root package name */
    private final List<byte[]> f376055a;

    /* renamed from: b, reason: collision with root package name */
    private final List<byte[]> f376056b;

    /* renamed from: c, reason: collision with root package name */
    private int f376057c;

    /* renamed from: d, reason: collision with root package name */
    private final int f376058d;

    /* compiled from: P */
    /* renamed from: com.tencent.theme.engine.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    static class C9918a implements Comparator<byte[]> {
        static IPatchRedirector $redirector_;

        C9918a() {
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11131);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f376053e = new a(RFixConstants.MD5_FILE_BUF_LENGTH);
            f376054f = new C9918a();
        }
    }

    public a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f376055a = new LinkedList();
        this.f376056b = new ArrayList(64);
        this.f376057c = 0;
        this.f376058d = i3;
    }

    public static a b() {
        return f376053e;
    }

    private synchronized void d() {
        while (this.f376057c > this.f376058d) {
            byte[] remove = this.f376055a.remove(0);
            this.f376056b.remove(remove);
            this.f376057c -= remove.length;
        }
    }

    public synchronized byte[] a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        for (int i16 = 0; i16 < this.f376056b.size(); i16++) {
            byte[] bArr = this.f376056b.get(i16);
            if (bArr.length >= i3) {
                this.f376057c -= bArr.length;
                this.f376056b.remove(i16);
                this.f376055a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i3];
    }

    public synchronized void c(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
            return;
        }
        if (bArr != null && bArr.length <= this.f376058d) {
            this.f376055a.add(bArr);
            int binarySearch = Collections.binarySearch(this.f376056b, bArr, f376054f);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 1;
            }
            this.f376056b.add(binarySearch, bArr);
            this.f376057c += bArr.length;
            d();
        }
    }
}
