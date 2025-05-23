package com.tencent.halley.downloader.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.common.a.f;
import com.tencent.halley.common.utils.d;
import com.tencent.halley.common.utils.g;
import com.tencent.halley.common.utils.j;
import com.tencent.halley.downloader.a.a.e;
import com.tencent.halley.downloader.task.d.a;
import com.tencent.halley.downloader.task.section.DataSection;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    private static AtomicInteger f113626n;

    /* renamed from: a, reason: collision with root package name */
    public boolean f113627a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.halley.downloader.task.d.a f113628b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f113629c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f113630d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f113631e;

    /* renamed from: f, reason: collision with root package name */
    public f f113632f;

    /* renamed from: g, reason: collision with root package name */
    public b f113633g;

    /* renamed from: h, reason: collision with root package name */
    public long f113634h;

    /* renamed from: i, reason: collision with root package name */
    public String f113635i;

    /* renamed from: j, reason: collision with root package name */
    public e f113636j;

    /* renamed from: k, reason: collision with root package name */
    public int f113637k;

    /* renamed from: l, reason: collision with root package name */
    public int f113638l;

    /* renamed from: m, reason: collision with root package name */
    public int f113639m;

    /* renamed from: o, reason: collision with root package name */
    private List<c> f113640o;

    /* renamed from: p, reason: collision with root package name */
    private Map<com.tencent.halley.downloader.task.d.a, c> f113641p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.halley.downloader.task.c f113642q;

    /* renamed from: r, reason: collision with root package name */
    private a f113643r;

    /* renamed from: s, reason: collision with root package name */
    private com.tencent.halley.downloader.task.d.b f113644s;

    /* renamed from: t, reason: collision with root package name */
    private List<com.tencent.halley.downloader.e.a> f113645t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f113646u;

    /* renamed from: v, reason: collision with root package name */
    private AtomicInteger f113647v;

    /* renamed from: w, reason: collision with root package name */
    private AtomicInteger f113648w;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a(com.tencent.halley.downloader.task.d.a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f113649a;

        /* renamed from: b, reason: collision with root package name */
        public int f113650b;

        /* renamed from: c, reason: collision with root package name */
        int f113651c;

        /* renamed from: d, reason: collision with root package name */
        public int f113652d;

        /* renamed from: e, reason: collision with root package name */
        List<String> f113653e;

        /* renamed from: f, reason: collision with root package name */
        int f113654f;

        /* renamed from: g, reason: collision with root package name */
        String f113655g;

        /* renamed from: h, reason: collision with root package name */
        int f113656h;

        /* renamed from: i, reason: collision with root package name */
        int f113657i;

        /* renamed from: j, reason: collision with root package name */
        List<String> f113658j;

        /* renamed from: k, reason: collision with root package name */
        int f113659k;

        /* renamed from: l, reason: collision with root package name */
        List<String> f113660l;

        /* renamed from: m, reason: collision with root package name */
        String f113661m;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f113650b = -1;
            this.f113651c = -1;
            this.f113652d = -1;
            this.f113653e = new ArrayList();
            this.f113655g = "";
            this.f113658j = new ArrayList();
            this.f113660l = new ArrayList();
            this.f113661m = "";
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f113649a);
            sb5.append(",");
            sb5.append(this.f113650b);
            sb5.append(",");
            sb5.append(this.f113651c);
            sb5.append(",");
            sb5.append(this.f113652d);
            sb5.append(",");
            if (this.f113653e.size() > 0) {
                Iterator<String> it = this.f113653e.iterator();
                while (it.hasNext()) {
                    sb5.append(it.next());
                    sb5.append("-");
                }
                sb5.deleteCharAt(sb5.length() - 1);
            }
            sb5.append(",");
            sb5.append(this.f113654f);
            sb5.append(",");
            sb5.append(this.f113655g);
            sb5.append(",");
            sb5.append(this.f113656h);
            sb5.append(",");
            sb5.append(this.f113657i);
            sb5.append(",");
            if (this.f113658j.size() > 0) {
                Iterator<String> it5 = this.f113658j.iterator();
                while (it5.hasNext()) {
                    sb5.append(it5.next());
                    sb5.append("-");
                }
                sb5.deleteCharAt(sb5.length() - 1);
            }
            sb5.append(",");
            sb5.append(this.f113659k);
            sb5.append(",");
            if (this.f113660l.size() > 0) {
                Iterator<String> it6 = this.f113660l.iterator();
                while (it6.hasNext()) {
                    sb5.append(it6.next());
                    sb5.append("-");
                }
                sb5.deleteCharAt(sb5.length() - 1);
            }
            sb5.append(",");
            sb5.append(this.f113661m);
            return sb5.toString();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14230);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f113626n = new AtomicInteger(1);
        }
    }

    public c(com.tencent.halley.downloader.task.c cVar, com.tencent.halley.downloader.task.d.b bVar, com.tencent.halley.downloader.task.d.a aVar, List<c> list, Map<com.tencent.halley.downloader.task.d.a, c> map, a aVar2, boolean z16, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cVar, bVar, aVar, list, map, aVar2, Boolean.valueOf(z16), atomicInteger, atomicInteger2);
            return;
        }
        this.f113629c = false;
        this.f113630d = false;
        this.f113631e = false;
        this.f113633g = new b();
        this.f113634h = 0L;
        this.f113635i = "";
        this.f113637k = -88;
        this.f113646u = false;
        this.f113638l = -1;
        this.f113639m = -1;
        this.f113642q = cVar;
        this.f113644s = bVar;
        this.f113645t = bVar.a();
        this.f113628b = aVar;
        this.f113640o = list;
        this.f113641p = map;
        this.f113643r = aVar2;
        this.f113646u = z16;
        this.f113648w = atomicInteger;
        this.f113647v = atomicInteger2;
    }

    private List<DataSection.a> d() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f113645t.size(); i3++) {
            long j3 = this.f113645t.get(i3).f113723a;
            long j16 = (r2.f113724b + j3) - 1;
            if (j3 >= 0 && j3 <= j16) {
                arrayList.add(new DataSection.a(j3, j16));
            } else {
                return null;
            }
        }
        return arrayList;
    }

    private List<c> e() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f113640o) {
            for (c cVar : this.f113640o) {
                if (cVar.f113629c) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f113631e = true;
        try {
            e eVar = this.f113636j;
            if (eVar != null) {
                eVar.B = true;
            }
            f fVar = this.f113632f;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f113633g.f113659k = -1;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.f113637k == -1) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean equals;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String str = "";
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
        } catch (Throwable th5) {
            try {
                this.f113637k = 1;
                String str2 = th5.getClass().getSimpleName() + "(" + th5.getLocalizedMessage() + ")";
                if (this.f113631e && this.f113637k == -88) {
                    this.f113637k = 5;
                    str2 = "";
                }
                b bVar = this.f113633g;
                bVar.f113651c = this.f113628b.f113892e;
                bVar.f113654f = this.f113637k;
                bVar.f113655g = str2;
                bVar.f113656h = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                this.f113633g.f113657i = (int) (SystemClock.elapsedRealtime() - this.f113634h);
                this.f113633g.f113649a = this.f113648w.incrementAndGet();
                com.tencent.halley.downloader.task.d.a aVar = this.f113628b;
                if (aVar.f113890c.equals(aVar.a())) {
                    return;
                }
            } finally {
                if (this.f113631e && this.f113637k == -88) {
                    this.f113637k = 5;
                    str = "";
                }
                b bVar2 = this.f113633g;
                bVar2.f113651c = this.f113628b.f113892e;
                bVar2.f113654f = this.f113637k;
                bVar2.f113655g = str;
                bVar2.f113656h = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                this.f113633g.f113657i = (int) (SystemClock.elapsedRealtime() - this.f113634h);
                this.f113633g.f113649a = this.f113648w.incrementAndGet();
                com.tencent.halley.downloader.task.d.a aVar2 = this.f113628b;
                if (!aVar2.f113890c.equals(aVar2.a())) {
                    this.f113633g.f113661m = this.f113628b.a();
                }
            }
        }
        if (this.f113631e) {
            if (equals) {
                return;
            } else {
                return;
            }
        }
        int i3 = 0;
        if (this.f113628b.f113891d != a.EnumC1249a.f113905j) {
            ArrayList arrayList = new ArrayList();
            List<DataSection.a> d16 = d();
            if (d16 != null) {
                String str3 = this.f113644s.f113922m;
                while (true) {
                    if (i3 >= d16.size()) {
                        a(arrayList, str3);
                        break;
                    }
                    byte[] a16 = a(this.f113628b, d16.get(i3));
                    if (a16 != null) {
                        arrayList.add(a16);
                        i3++;
                    } else if (this.f113637k != 7) {
                        this.f113637k = 4;
                    }
                }
            } else {
                this.f113637k = 2;
            }
        } else {
            this.f113637k = 0;
        }
        if (this.f113631e) {
            if (this.f113631e && this.f113637k == -88) {
                this.f113637k = 5;
                str = "";
            }
            b bVar3 = this.f113633g;
            bVar3.f113651c = this.f113628b.f113892e;
            bVar3.f113654f = this.f113637k;
            bVar3.f113655g = str;
            bVar3.f113656h = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f113633g.f113657i = (int) (SystemClock.elapsedRealtime() - this.f113634h);
            this.f113633g.f113649a = this.f113648w.incrementAndGet();
            com.tencent.halley.downloader.task.d.a aVar3 = this.f113628b;
            if (aVar3.f113890c.equals(aVar3.a())) {
                return;
            }
            this.f113633g.f113661m = this.f113628b.a();
            return;
        }
        if (this.f113637k == 0) {
            com.tencent.halley.downloader.task.d.b bVar4 = this.f113644s;
            com.tencent.halley.downloader.task.d.a aVar4 = this.f113628b;
            synchronized (bVar4.f113910a) {
                aVar4.f113893f = true;
                bVar4.f113910a.add(aVar4);
            }
        } else if (c()) {
            this.f113629c = true;
            this.f113647v.incrementAndGet();
        }
        if (!this.f113646u) {
            if (this.f113644s.b() <= 0) {
                if (this.f113631e && this.f113637k == -88) {
                    this.f113637k = 5;
                    str = "";
                }
                b bVar5 = this.f113633g;
                bVar5.f113651c = this.f113628b.f113892e;
                bVar5.f113654f = this.f113637k;
                bVar5.f113655g = str;
                bVar5.f113656h = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                this.f113633g.f113657i = (int) (SystemClock.elapsedRealtime() - this.f113634h);
                this.f113633g.f113649a = this.f113648w.incrementAndGet();
                com.tencent.halley.downloader.task.d.a aVar5 = this.f113628b;
                if (aVar5.f113890c.equals(aVar5.a())) {
                    return;
                }
                this.f113633g.f113661m = this.f113628b.a();
                return;
            }
            List<c> e16 = e();
            synchronized (c.class) {
                for (c cVar : e16) {
                    cVar.f113630d = true;
                    this.f113643r.a(cVar.f113628b);
                }
            }
        } else if (c()) {
            this.f113630d = true;
            this.f113643r.a(this.f113628b);
        }
        if (this.f113631e && this.f113637k == -88) {
            this.f113637k = 5;
            str = "";
        }
        b bVar6 = this.f113633g;
        bVar6.f113651c = this.f113628b.f113892e;
        bVar6.f113654f = this.f113637k;
        bVar6.f113655g = str;
        bVar6.f113656h = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
        this.f113633g.f113657i = (int) (SystemClock.elapsedRealtime() - this.f113634h);
        this.f113633g.f113649a = this.f113648w.incrementAndGet();
        com.tencent.halley.downloader.task.d.a aVar6 = this.f113628b;
        if (aVar6.f113890c.equals(aVar6.a())) {
            return;
        }
        this.f113633g.f113661m = this.f113628b.a();
    }

    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f113633g.f113658j.add(str);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    public final void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f113633g.f113660l.add(str);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
    }

    private void a(List<byte[]> list, String str) {
        int i3;
        if (list.size() > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (byte[] bArr : list) {
                byteArrayOutputStream.write(bArr, 0, bArr.length);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            if (!j.a(byteArray)) {
                if (str.toLowerCase().equals(g.a(byteArray).toLowerCase())) {
                    this.f113637k = 0;
                    return;
                }
                this.f113637k = -1;
                Matcher matcher = Pattern.compile("(?<=channelId=).*(?=\r\n)").matcher(new String(byteArray));
                String group = matcher.find() ? matcher.group() : "";
                if (TextUtils.isEmpty(group)) {
                    return;
                }
                this.f113635i = group;
                d.b("md5Verify", "channel was hijack,hijackChannel=".concat(String.valueOf(group)));
                return;
            }
            i3 = 6;
        } else {
            i3 = 3;
        }
        this.f113637k = i3;
    }

    private byte[] a(com.tencent.halley.downloader.task.d.a aVar, DataSection.a aVar2) {
        byte[] bArr = null;
        for (int i3 = 0; i3 < 2; i3++) {
            boolean z16 = true;
            e eVar = new e(aVar, null, aVar2, false, this.f113642q, !this.f113627a, this.f113644s, 2, false);
            this.f113636j = eVar;
            eVar.b();
            int e16 = this.f113636j.e();
            this.f113633g.f113653e.add(String.valueOf(e16));
            if (e16 == 0) {
                bArr = this.f113636j.c();
            } else if (e16 == -74) {
                this.f113637k = 7;
                bArr = null;
            }
            if (e16 != 0 && e16 != -66 && e16 != -15 && e16 != -16) {
                z16 = false;
            }
            if (z16) {
                break;
            }
            SystemClock.sleep(50L);
        }
        return bArr;
    }
}
