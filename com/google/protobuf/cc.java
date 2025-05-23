package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Writer;
import com.google.protobuf.au;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class cc implements au {

    /* renamed from: f, reason: collision with root package name */
    private static final cc f35792f = new cc(Collections.emptyMap(), Collections.emptyMap());

    /* renamed from: h, reason: collision with root package name */
    private static final d f35793h = new d();

    /* renamed from: d, reason: collision with root package name */
    private final Map<Integer, c> f35794d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<Integer, c> f35795e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b implements au.a {

        /* renamed from: d, reason: collision with root package name */
        private Map<Integer, c> f35796d;

        /* renamed from: e, reason: collision with root package name */
        private int f35797e;

        /* renamed from: f, reason: collision with root package name */
        private c.a f35798f;

        b() {
        }

        static /* synthetic */ b a() {
            return f();
        }

        private static b f() {
            b bVar = new b();
            bVar.s();
            return bVar;
        }

        private c.a h(int i3) {
            c.a aVar = this.f35798f;
            if (aVar != null) {
                int i16 = this.f35797e;
                if (i3 == i16) {
                    return aVar;
                }
                b(i16, aVar.g());
            }
            if (i3 == 0) {
                return null;
            }
            c cVar = this.f35796d.get(Integer.valueOf(i3));
            this.f35797e = i3;
            c.a t16 = c.t();
            this.f35798f = t16;
            if (cVar != null) {
                t16.i(cVar);
            }
            return this.f35798f;
        }

        private void s() {
            this.f35796d = Collections.emptyMap();
            this.f35797e = 0;
            this.f35798f = null;
        }

        public b b(int i3, c cVar) {
            if (i3 != 0) {
                if (this.f35798f != null && this.f35797e == i3) {
                    this.f35798f = null;
                    this.f35797e = 0;
                }
                if (this.f35796d.isEmpty()) {
                    this.f35796d = new TreeMap();
                }
                this.f35796d.put(Integer.valueOf(i3), cVar);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public cc build() {
            cc ccVar;
            h(0);
            if (this.f35796d.isEmpty()) {
                ccVar = cc.c();
            } else {
                ccVar = new cc(Collections.unmodifiableMap(this.f35796d), Collections.unmodifiableMap(((TreeMap) this.f35796d).descendingMap()));
            }
            this.f35796d = null;
            return ccVar;
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public cc buildPartial() {
            return build();
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b clone() {
            h(0);
            return cc.g().p(new cc(this.f35796d, Collections.unmodifiableMap(((TreeMap) this.f35796d).descendingMap())));
        }

        public boolean i(int i3) {
            if (i3 != 0) {
                if (i3 != this.f35797e && !this.f35796d.containsKey(Integer.valueOf(i3))) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public b j(int i3, c cVar) {
            if (i3 != 0) {
                if (i(i3)) {
                    h(i3).i(cVar);
                } else {
                    b(i3, cVar);
                }
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public boolean k(int i3, k kVar) throws IOException {
            int a16 = WireFormat.a(i3);
            int b16 = WireFormat.b(i3);
            if (b16 != 0) {
                if (b16 != 1) {
                    if (b16 != 2) {
                        if (b16 != 3) {
                            if (b16 != 4) {
                                if (b16 == 5) {
                                    h(a16).b(kVar.t());
                                    return true;
                                }
                                throw InvalidProtocolBufferException.invalidWireType();
                            }
                            return false;
                        }
                        b g16 = cc.g();
                        kVar.w(a16, g16, r.f());
                        h(a16).d(g16.build());
                        return true;
                    }
                    h(a16).e(kVar.q());
                    return true;
                }
                h(a16).c(kVar.u());
                return true;
            }
            h(a16).f(kVar.y());
            return true;
        }

        public b l(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                k newCodedInput = byteString.newCodedInput();
                m(newCodedInput);
                newCodedInput.a(0);
                return this;
            } catch (InvalidProtocolBufferException e16) {
                throw e16;
            } catch (IOException e17) {
                throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e17);
            }
        }

        public b m(k kVar) throws IOException {
            int J;
            do {
                J = kVar.J();
                if (J == 0) {
                    break;
                }
            } while (k(J, kVar));
            return this;
        }

        @Override // com.google.protobuf.au.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(k kVar, t tVar) throws IOException {
            return m(kVar);
        }

        @Override // com.google.protobuf.au.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(au auVar) {
            if (auVar instanceof cc) {
                return p((cc) auVar);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        public b p(cc ccVar) {
            if (ccVar != cc.c()) {
                for (Map.Entry entry : ccVar.f35794d.entrySet()) {
                    j(((Integer) entry.getKey()).intValue(), (c) entry.getValue());
                }
            }
            return this;
        }

        @Override // com.google.protobuf.au.a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            try {
                k k3 = k.k(bArr);
                m(k3);
                k3.a(0);
                return this;
            } catch (InvalidProtocolBufferException e16) {
                throw e16;
            } catch (IOException e17) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e17);
            }
        }

        public b r(int i3, int i16) {
            if (i3 != 0) {
                h(i3).f(i16);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: f, reason: collision with root package name */
        private static final c f35799f = t().g();

        /* renamed from: a, reason: collision with root package name */
        private List<Long> f35800a;

        /* renamed from: b, reason: collision with root package name */
        private List<Integer> f35801b;

        /* renamed from: c, reason: collision with root package name */
        private List<Long> f35802c;

        /* renamed from: d, reason: collision with root package name */
        private List<ByteString> f35803d;

        /* renamed from: e, reason: collision with root package name */
        private List<cc> f35804e;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private c f35805a;

            a() {
            }

            static /* synthetic */ a a() {
                return h();
            }

            private static a h() {
                a aVar = new a();
                aVar.f35805a = new c();
                return aVar;
            }

            public a b(int i3) {
                if (this.f35805a.f35801b == null) {
                    this.f35805a.f35801b = new ArrayList();
                }
                this.f35805a.f35801b.add(Integer.valueOf(i3));
                return this;
            }

            public a c(long j3) {
                if (this.f35805a.f35802c == null) {
                    this.f35805a.f35802c = new ArrayList();
                }
                this.f35805a.f35802c.add(Long.valueOf(j3));
                return this;
            }

            public a d(cc ccVar) {
                if (this.f35805a.f35804e == null) {
                    this.f35805a.f35804e = new ArrayList();
                }
                this.f35805a.f35804e.add(ccVar);
                return this;
            }

            public a e(ByteString byteString) {
                if (this.f35805a.f35803d == null) {
                    this.f35805a.f35803d = new ArrayList();
                }
                this.f35805a.f35803d.add(byteString);
                return this;
            }

            public a f(long j3) {
                if (this.f35805a.f35800a == null) {
                    this.f35805a.f35800a = new ArrayList();
                }
                this.f35805a.f35800a.add(Long.valueOf(j3));
                return this;
            }

            public c g() {
                if (this.f35805a.f35800a == null) {
                    this.f35805a.f35800a = Collections.emptyList();
                } else {
                    c cVar = this.f35805a;
                    cVar.f35800a = Collections.unmodifiableList(cVar.f35800a);
                }
                if (this.f35805a.f35801b == null) {
                    this.f35805a.f35801b = Collections.emptyList();
                } else {
                    c cVar2 = this.f35805a;
                    cVar2.f35801b = Collections.unmodifiableList(cVar2.f35801b);
                }
                if (this.f35805a.f35802c == null) {
                    this.f35805a.f35802c = Collections.emptyList();
                } else {
                    c cVar3 = this.f35805a;
                    cVar3.f35802c = Collections.unmodifiableList(cVar3.f35802c);
                }
                if (this.f35805a.f35803d == null) {
                    this.f35805a.f35803d = Collections.emptyList();
                } else {
                    c cVar4 = this.f35805a;
                    cVar4.f35803d = Collections.unmodifiableList(cVar4.f35803d);
                }
                if (this.f35805a.f35804e == null) {
                    this.f35805a.f35804e = Collections.emptyList();
                } else {
                    c cVar5 = this.f35805a;
                    cVar5.f35804e = Collections.unmodifiableList(cVar5.f35804e);
                }
                c cVar6 = this.f35805a;
                this.f35805a = null;
                return cVar6;
            }

            public a i(c cVar) {
                if (!cVar.f35800a.isEmpty()) {
                    if (this.f35805a.f35800a == null) {
                        this.f35805a.f35800a = new ArrayList();
                    }
                    this.f35805a.f35800a.addAll(cVar.f35800a);
                }
                if (!cVar.f35801b.isEmpty()) {
                    if (this.f35805a.f35801b == null) {
                        this.f35805a.f35801b = new ArrayList();
                    }
                    this.f35805a.f35801b.addAll(cVar.f35801b);
                }
                if (!cVar.f35802c.isEmpty()) {
                    if (this.f35805a.f35802c == null) {
                        this.f35805a.f35802c = new ArrayList();
                    }
                    this.f35805a.f35802c.addAll(cVar.f35802c);
                }
                if (!cVar.f35803d.isEmpty()) {
                    if (this.f35805a.f35803d == null) {
                        this.f35805a.f35803d = new ArrayList();
                    }
                    this.f35805a.f35803d.addAll(cVar.f35803d);
                }
                if (!cVar.f35804e.isEmpty()) {
                    if (this.f35805a.f35804e == null) {
                        this.f35805a.f35804e = new ArrayList();
                    }
                    this.f35805a.f35804e.addAll(cVar.f35804e);
                }
                return this;
            }
        }

        private Object[] o() {
            return new Object[]{this.f35800a, this.f35801b, this.f35802c, this.f35803d, this.f35804e};
        }

        public static a t() {
            return a.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(int i3, Writer writer) throws IOException {
            if (writer.F() == Writer.FieldOrder.DESCENDING) {
                List<ByteString> list = this.f35803d;
                ListIterator<ByteString> listIterator = list.listIterator(list.size());
                while (listIterator.hasPrevious()) {
                    writer.I(i3, listIterator.previous());
                }
                return;
            }
            Iterator<ByteString> it = this.f35803d.iterator();
            while (it.hasNext()) {
                writer.I(i3, it.next());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            return Arrays.equals(o(), ((c) obj).o());
        }

        public int hashCode() {
            return Arrays.hashCode(o());
        }

        public List<Integer> l() {
            return this.f35801b;
        }

        public List<Long> m() {
            return this.f35802c;
        }

        public List<cc> n() {
            return this.f35804e;
        }

        public List<ByteString> p() {
            return this.f35803d;
        }

        public int q(int i3) {
            Iterator<Long> it = this.f35800a.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                i16 += CodedOutputStream.a0(i3, it.next().longValue());
            }
            Iterator<Integer> it5 = this.f35801b.iterator();
            while (it5.hasNext()) {
                i16 += CodedOutputStream.n(i3, it5.next().intValue());
            }
            Iterator<Long> it6 = this.f35802c.iterator();
            while (it6.hasNext()) {
                i16 += CodedOutputStream.p(i3, it6.next().longValue());
            }
            Iterator<ByteString> it7 = this.f35803d.iterator();
            while (it7.hasNext()) {
                i16 += CodedOutputStream.h(i3, it7.next());
            }
            Iterator<cc> it8 = this.f35804e.iterator();
            while (it8.hasNext()) {
                i16 += CodedOutputStream.t(i3, it8.next());
            }
            return i16;
        }

        public int r(int i3) {
            Iterator<ByteString> it = this.f35803d.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                i16 += CodedOutputStream.L(i3, it.next());
            }
            return i16;
        }

        public List<Long> s() {
            return this.f35800a;
        }

        public void u(int i3, CodedOutputStream codedOutputStream) throws IOException {
            Iterator<ByteString> it = this.f35803d.iterator();
            while (it.hasNext()) {
                codedOutputStream.O0(i3, it.next());
            }
        }

        public void w(int i3, CodedOutputStream codedOutputStream) throws IOException {
            Iterator<Long> it = this.f35800a.iterator();
            while (it.hasNext()) {
                codedOutputStream.d1(i3, it.next().longValue());
            }
            Iterator<Integer> it5 = this.f35801b.iterator();
            while (it5.hasNext()) {
                codedOutputStream.w0(i3, it5.next().intValue());
            }
            Iterator<Long> it6 = this.f35802c.iterator();
            while (it6.hasNext()) {
                codedOutputStream.y0(i3, it6.next().longValue());
            }
            Iterator<ByteString> it7 = this.f35803d.iterator();
            while (it7.hasNext()) {
                codedOutputStream.q0(i3, it7.next());
            }
            Iterator<cc> it8 = this.f35804e.iterator();
            while (it8.hasNext()) {
                codedOutputStream.C0(i3, it8.next());
            }
        }

        void x(int i3, Writer writer) throws IOException {
            writer.z(i3, this.f35800a, false);
            writer.A(i3, this.f35801b, false);
            writer.L(i3, this.f35802c, false);
            writer.p(i3, this.f35803d);
            if (writer.F() == Writer.FieldOrder.ASCENDING) {
                for (int i16 = 0; i16 < this.f35804e.size(); i16++) {
                    writer.K(i3);
                    this.f35804e.get(i16).n(writer);
                    writer.B(i3);
                }
                return;
            }
            for (int size = this.f35804e.size() - 1; size >= 0; size--) {
                writer.B(i3);
                this.f35804e.get(size).n(writer);
                writer.K(i3);
            }
        }

        c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class d extends com.google.protobuf.c<cc> {
        @Override // com.google.protobuf.bg
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public cc g(k kVar, t tVar) throws InvalidProtocolBufferException {
            b g16 = cc.g();
            try {
                g16.m(kVar);
                return g16.buildPartial();
            } catch (InvalidProtocolBufferException e16) {
                throw e16.setUnfinishedMessage(g16.buildPartial());
            } catch (IOException e17) {
                throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(g16.buildPartial());
            }
        }
    }

    cc() {
        this.f35794d = null;
        this.f35795e = null;
    }

    public static cc c() {
        return f35792f;
    }

    public static b g() {
        return b.a();
    }

    public static b h(cc ccVar) {
        return g().p(ccVar);
    }

    public static cc j(ByteString byteString) throws InvalidProtocolBufferException {
        return g().l(byteString).build();
    }

    public Map<Integer, c> b() {
        return this.f35794d;
    }

    @Override // com.google.protobuf.av, com.google.protobuf.ax
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public cc getDefaultInstanceForType() {
        return f35792f;
    }

    @Override // com.google.protobuf.au
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final d getParserForType() {
        return f35793h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof cc) && this.f35794d.equals(((cc) obj).f35794d)) {
            return true;
        }
        return false;
    }

    public int f() {
        int i3 = 0;
        for (Map.Entry<Integer, c> entry : this.f35794d.entrySet()) {
            i3 += entry.getValue().r(entry.getKey().intValue());
        }
        return i3;
    }

    @Override // com.google.protobuf.au
    public int getSerializedSize() {
        int i3 = 0;
        for (Map.Entry<Integer, c> entry : this.f35794d.entrySet()) {
            i3 += entry.getValue().q(entry.getKey().intValue());
        }
        return i3;
    }

    public int hashCode() {
        return this.f35794d.hashCode();
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return g();
    }

    @Override // com.google.protobuf.av
    public boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return g().p(this);
    }

    public void l(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry<Integer, c> entry : this.f35794d.entrySet()) {
            entry.getValue().u(entry.getKey().intValue(), codedOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Writer writer) throws IOException {
        if (writer.F() == Writer.FieldOrder.DESCENDING) {
            for (Map.Entry<Integer, c> entry : this.f35795e.entrySet()) {
                entry.getValue().v(entry.getKey().intValue(), writer);
            }
            return;
        }
        for (Map.Entry<Integer, c> entry2 : this.f35794d.entrySet()) {
            entry2.getValue().v(entry2.getKey().intValue(), writer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Writer writer) throws IOException {
        if (writer.F() == Writer.FieldOrder.DESCENDING) {
            for (Map.Entry<Integer, c> entry : this.f35795e.entrySet()) {
                entry.getValue().x(entry.getKey().intValue(), writer);
            }
            return;
        }
        for (Map.Entry<Integer, c> entry2 : this.f35794d.entrySet()) {
            entry2.getValue().x(entry2.getKey().intValue(), writer);
        }
    }

    @Override // com.google.protobuf.au
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream i06 = CodedOutputStream.i0(bArr);
            writeTo(i06);
            i06.d();
            return bArr;
        } catch (IOException e16) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e16);
        }
    }

    @Override // com.google.protobuf.au
    public ByteString toByteString() {
        try {
            ByteString.g newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(newCodedBuilder.b());
            return newCodedBuilder.a();
        } catch (IOException e16) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e16);
        }
    }

    public String toString() {
        return TextFormat.n().k(this);
    }

    @Override // com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry<Integer, c> entry : this.f35794d.entrySet()) {
            entry.getValue().w(entry.getKey().intValue(), codedOutputStream);
        }
    }

    cc(Map<Integer, c> map, Map<Integer, c> map2) {
        this.f35794d = map;
        this.f35795e = map2;
    }
}
