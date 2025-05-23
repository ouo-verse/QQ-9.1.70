package com.tencent.mobileqq.qqbattery.feature;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface e {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static abstract class a<RECORD extends a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final long f262344a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f262345b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f262346c;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qqbattery.feature.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public static abstract class AbstractC8291a<RECORD extends a> {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public final RECORD f262347a;

            /* renamed from: b, reason: collision with root package name */
            public final RECORD f262348b;

            /* renamed from: c, reason: collision with root package name */
            public final RECORD f262349c;

            public AbstractC8291a(RECORD record, RECORD record2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) record, (Object) record2);
                    return;
                }
                this.f262347a = record;
                this.f262348b = record2;
                long j3 = record2.f262344a;
                long j16 = record.f262344a;
                RECORD a16 = a();
                this.f262349c = a16;
                a16.f262345b = true;
            }

            public abstract RECORD a();
        }

        /* compiled from: P */
        /* loaded from: classes16.dex */
        public static abstract class b<ENTRY> {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public boolean f262350a;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.qqbattery.feature.e$a$b$a, reason: collision with other inner class name */
            /* loaded from: classes16.dex */
            public static class C8292a<BEAN> extends b<C8292a> {
                static IPatchRedirector $redirector_;

                /* renamed from: c, reason: collision with root package name */
                public static final C8292a<?> f262351c;

                /* renamed from: b, reason: collision with root package name */
                public BEAN f262352b;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qqbattery.feature.e$a$b$a$a, reason: collision with other inner class name */
                /* loaded from: classes16.dex */
                public class C8293a extends C8292a<Void> {
                    static IPatchRedirector $redirector_;

                    public C8293a() {
                        super(null);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }
                }

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14658);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 2)) {
                        redirector.redirect((short) 2);
                    } else {
                        f262351c = new C8293a();
                    }
                }

                public C8292a(BEAN bean) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) bean);
                    } else {
                        this.f262352b = bean;
                    }
                }

                public static <BEAN> C8292a<BEAN> a(BEAN bean) {
                    return new C8292a<>(bean);
                }

                public boolean equals(Object obj) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
                    }
                    if (this == obj) {
                        return true;
                    }
                    if (obj != null && getClass() == obj.getClass()) {
                        return String.valueOf(this.f262352b).equals(String.valueOf(((C8292a) obj).f262352b));
                    }
                    return false;
                }

                public int hashCode() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
                    }
                    return Objects.hash(this.f262352b);
                }

                public String toString() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                        return (String) iPatchRedirector.redirect((short) 7, (Object) this);
                    }
                    return String.valueOf(this.f262352b);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.qqbattery.feature.e$a$b$b, reason: collision with other inner class name */
            /* loaded from: classes16.dex */
            public static abstract class AbstractC8294b<DIGIT extends Number> extends b<AbstractC8294b> {
                static IPatchRedirector $redirector_;

                /* renamed from: b, reason: collision with root package name */
                public DIGIT f262353b;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qqbattery.feature.e$a$b$b$a, reason: collision with other inner class name */
                /* loaded from: classes16.dex */
                public static class C8295a extends AbstractC8294b<Double> {
                    static IPatchRedirector $redirector_;

                    public C8295a(Double d16) {
                        super(d16);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) d16);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqbattery.feature.e.a.b.AbstractC8294b
                    /* renamed from: d, reason: merged with bridge method [inline-methods] */
                    public Double a(Double d16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (Double) iPatchRedirector.redirect((short) 2, (Object) this, (Object) d16);
                        }
                        return Double.valueOf(((Double) this.f262353b).doubleValue() - d16.doubleValue());
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qqbattery.feature.e$a$b$b$b, reason: collision with other inner class name */
                /* loaded from: classes16.dex */
                public static class C8296b extends AbstractC8294b<Float> {
                    static IPatchRedirector $redirector_;

                    public C8296b(Float f16) {
                        super(f16);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) f16);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqbattery.feature.e.a.b.AbstractC8294b
                    /* renamed from: d, reason: merged with bridge method [inline-methods] */
                    public Float a(Float f16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (Float) iPatchRedirector.redirect((short) 2, (Object) this, (Object) f16);
                        }
                        return Float.valueOf(((Float) this.f262353b).floatValue() - f16.floatValue());
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qqbattery.feature.e$a$b$b$c */
                /* loaded from: classes16.dex */
                public static class c extends AbstractC8294b<Integer> {
                    static IPatchRedirector $redirector_;

                    public c(Integer num) {
                        super(num);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) num);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqbattery.feature.e.a.b.AbstractC8294b
                    /* renamed from: d, reason: merged with bridge method [inline-methods] */
                    public Integer a(Integer num) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                        }
                        return Integer.valueOf(((Integer) this.f262353b).intValue() - num.intValue());
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qqbattery.feature.e$a$b$b$d */
                /* loaded from: classes16.dex */
                public static class d extends AbstractC8294b<Long> {
                    static IPatchRedirector $redirector_;

                    public d(Long l3) {
                        super(l3);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) l3);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqbattery.feature.e.a.b.AbstractC8294b
                    /* renamed from: d, reason: merged with bridge method [inline-methods] */
                    public Long a(Long l3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) l3);
                        }
                        return Long.valueOf(((Long) this.f262353b).longValue() - l3.longValue());
                    }
                }

                public AbstractC8294b(DIGIT digit) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) digit);
                    } else {
                        this.f262353b = digit;
                    }
                }

                public static <DIGIT extends Number> AbstractC8294b<DIGIT> c(DIGIT digit) {
                    if (digit instanceof Integer) {
                        return new c((Integer) digit);
                    }
                    if (digit instanceof Long) {
                        return new d((Long) digit);
                    }
                    if (digit instanceof Float) {
                        return new C8296b((Float) digit);
                    }
                    if (digit instanceof Double) {
                        return new C8295a((Double) digit);
                    }
                    StringBuilder a16 = g.a("unsupported digit: ");
                    a16.append(digit.getClass());
                    throw new RuntimeException(a16.toString());
                }

                public abstract DIGIT a(DIGIT digit);

                public DIGIT b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (DIGIT) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return this.f262353b;
                }

                public boolean equals(Object obj) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
                    }
                    if (this == obj) {
                        return true;
                    }
                    if (obj != null && getClass() == obj.getClass()) {
                        return this.f262353b.equals(((AbstractC8294b) obj).f262353b);
                    }
                    return false;
                }

                public int hashCode() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
                    }
                    return Objects.hash(this.f262353b);
                }

                public String toString() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                    }
                    return String.valueOf(this.f262353b);
                }
            }

            /* compiled from: P */
            /* loaded from: classes16.dex */
            public static class c<ITEM extends b> extends b<c> {
                static IPatchRedirector $redirector_;

                /* renamed from: b, reason: collision with root package name */
                public List<ITEM> f262354b;

                public c() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                public static <ITEM extends b> c<ITEM> b(List<ITEM> list) {
                    c<ITEM> cVar = new c<>();
                    cVar.f262354b = list;
                    return cVar;
                }

                public static <BEAN> c<C8292a<BEAN>> c(List<BEAN> list) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<BEAN> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(C8292a.a(it.next()));
                    }
                    return b(arrayList);
                }

                public static <ITEM extends b> c<ITEM> d() {
                    c<ITEM> cVar = new c<>();
                    cVar.f262354b = new ArrayList();
                    return cVar;
                }

                public List<ITEM> a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
                    }
                    return this.f262354b;
                }
            }

            public b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.f262350a = true;
                }
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f262345b = false;
            this.f262346c = true;
            this.f262344a = a();
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return SystemClock.uptimeMillis();
        }

        public a<RECORD> b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
            this.f262346c = z16;
            return this;
        }
    }

    void a(boolean z16);

    void b();

    int c();

    void d(com.tencent.mobileqq.qqbattery.g gVar);
}
