package com.tencent.mobileqq.qrscan;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f276673a;

    /* renamed from: b, reason: collision with root package name */
    public int f276674b;

    /* renamed from: c, reason: collision with root package name */
    public int f276675c;

    /* renamed from: d, reason: collision with root package name */
    public int f276676d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<a> f276677e;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f276673a = 0;
        this.f276674b = 0;
        this.f276675c = 0;
        this.f276676d = 0;
        this.f276677e = null;
        this.f276677e = new ArrayList<>();
    }

    public static m a(int i3, String str) {
        int i16 = 2;
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return null;
        }
        long j3 = 0;
        try {
            if (!TextUtils.isEmpty(str)) {
                j3 = Long.parseLong(str);
            }
        } catch (Exception unused) {
            QLog.e("QRActionEntity", 1, "buildEntity, e:");
        }
        m mVar = new m();
        mVar.f276673a = 1;
        mVar.f276674b = 1;
        mVar.f276675c = i3;
        mVar.f276676d = 0;
        mVar.f276677e = new ArrayList<>();
        byte[] e16 = com.tencent.mobileqq.qrscan.utils.b.e(j3);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.put(e16, 4, 4);
        allocate.flip();
        byte[] bArr = new byte[allocate.limit()];
        allocate.get(bArr);
        if (i3 != 2) {
            if (i3 == 3) {
                i16 = 7;
            } else {
                i16 = 1;
            }
        }
        mVar.f276677e.add(new a(i16, (short) 4, bArr));
        return mVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(String str) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str);
        ByteBuffer allocate = ByteBuffer.allocate(hexStr2Bytes.length);
        allocate.put(hexStr2Bytes);
        allocate.flip();
        this.f276673a = allocate.get();
        this.f276674b = allocate.get();
        this.f276675c = allocate.get();
        this.f276676d = allocate.get();
        byte b16 = allocate.get();
        this.f276677e = new ArrayList<>(b16);
        for (int i3 = 0; i3 < b16; i3++) {
            a aVar = new a();
            aVar.f276678a = allocate.get();
            byte[] bArr = new byte[2];
            allocate.get(bArr);
            int b17 = com.tencent.mobileqq.qrscan.utils.b.b(bArr);
            aVar.f276679b = b17;
            byte[] bArr2 = new byte[b17];
            allocate.get(bArr2);
            aVar.f276680c = bArr2;
            this.f276677e.add(aVar);
        }
    }

    public a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList<a> arrayList = this.f276677e;
        if (arrayList != null && !arrayList.isEmpty()) {
            return this.f276677e.get(0);
        }
        return null;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        ArrayList<a> arrayList = this.f276677e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList<a> arrayList = this.f276677e;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                i3 += it.next().a();
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        allocate.put((byte) this.f276673a);
        allocate.put((byte) this.f276674b);
        allocate.put((byte) this.f276675c);
        allocate.put((byte) this.f276676d);
        ArrayList<a> arrayList2 = this.f276677e;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            allocate.put((byte) this.f276677e.size());
            Iterator<a> it5 = this.f276677e.iterator();
            while (it5.hasNext()) {
                a next = it5.next();
                allocate.put((byte) next.f276678a);
                allocate.putShort(next.f276679b);
                allocate.put(next.f276680c);
            }
        }
        allocate.flip();
        byte[] bArr = new byte[allocate.limit()];
        allocate.get(bArr);
        return HexUtil.bytes2HexStr(bArr);
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f276678a;

        /* renamed from: b, reason: collision with root package name */
        short f276679b;

        /* renamed from: c, reason: collision with root package name */
        byte[] f276680c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f276678a = 0;
            this.f276679b = (short) 0;
            this.f276680c = null;
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f276680c.length + 4;
        }

        public long b() throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return com.tencent.mobileqq.qrscan.utils.b.a(this.f276680c);
        }

        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return new String(this.f276680c);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return String.format("{t: %s, l: %s, v: %s}", Integer.valueOf(this.f276678a), Short.valueOf(this.f276679b), this.f276680c);
        }

        public a(int i3, short s16, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Short.valueOf(s16), bArr);
                return;
            }
            this.f276678a = i3;
            this.f276680c = bArr;
            this.f276679b = s16;
        }
    }

    public m(String str) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.f276673a = 0;
        this.f276674b = 0;
        this.f276675c = 0;
        this.f276676d = 0;
        this.f276677e = null;
        b(str);
    }
}
