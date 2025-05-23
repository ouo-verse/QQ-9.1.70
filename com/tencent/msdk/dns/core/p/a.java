package com.tencent.msdk.dns.core.p;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.base.log.c;
import com.tencent.msdk.dns.core.e;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a implements m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final int f336312a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f336313b;

    /* renamed from: c, reason: collision with root package name */
    private List<String> f336314c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f336315d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f336316e;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class b implements m.a {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.msdk.dns.core.m.a
        public m a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (m) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            return new a(i3, null);
        }
    }

    /* synthetic */ a(int i3, C9217a c9217a) {
        this(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) c9217a);
    }

    private List<String> b(List<String> list, String str) {
        if (Collections.emptyList() == list) {
            list = new ArrayList<>();
        }
        list.add(str);
        return list;
    }

    @Override // com.tencent.msdk.dns.core.m
    public synchronized void a(i iVar, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iVar, (Object) strArr);
            return;
        }
        if (iVar == null) {
            throw new IllegalArgumentException("dns".concat(" can not be null"));
        }
        if (strArr != null) {
            if (com.tencent.msdk.dns.c.e.a.i(strArr)) {
                return;
            }
            int i3 = 0;
            if ("Local".equals(iVar.a().f336254a)) {
                c.c("sorter put lookup from local: %s", Arrays.toString(strArr));
                int length = strArr.length;
                while (i3 < length) {
                    String str = strArr[i3];
                    if (com.tencent.msdk.dns.c.e.c.b(str)) {
                        this.f336313b = b(this.f336313b, str);
                    } else if (com.tencent.msdk.dns.c.e.c.c(str)) {
                        this.f336314c = b(this.f336314c, str);
                    }
                    i3++;
                }
            } else {
                c.c("sorter put lookup from rest(%d): %s", Integer.valueOf(iVar.a().f336255b), Arrays.toString(strArr));
                int length2 = strArr.length;
                while (i3 < length2) {
                    String str2 = strArr[i3];
                    if (com.tencent.msdk.dns.c.e.c.b(str2)) {
                        this.f336315d = b(this.f336315d, str2);
                    } else if (com.tencent.msdk.dns.c.e.c.c(str2)) {
                        this.f336316e = b(this.f336316e, str2);
                    }
                    i3++;
                }
            }
            return;
        }
        throw new IllegalArgumentException("ips".concat(" can not be null"));
    }

    a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f336313b = Collections.emptyList();
        this.f336314c = Collections.emptyList();
        this.f336315d = Collections.emptyList();
        this.f336316e = Collections.emptyList();
        this.f336312a = i3;
    }

    @Override // com.tencent.msdk.dns.core.m
    public com.tencent.msdk.dns.core.c a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.msdk.dns.core.c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        if ((this.f336312a & 1) != 0) {
            if (!this.f336315d.isEmpty()) {
                arrayList.addAll(this.f336315d);
            } else {
                List<String> list = this.f336313b;
                if (list != null) {
                    arrayList.addAll(list);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if ((this.f336312a & 2) != 0) {
            if (!this.f336316e.isEmpty()) {
                arrayList2.addAll(this.f336316e);
            } else {
                List<String> list2 = this.f336314c;
                if (list2 != null) {
                    arrayList2.addAll(list2);
                }
            }
        }
        String[] strArr = e.f336253a;
        return new com.tencent.msdk.dns.core.c((String[]) arrayList.toArray(strArr), (String[]) arrayList2.toArray(strArr));
    }
}
