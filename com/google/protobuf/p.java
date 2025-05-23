package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.a;
import com.google.protobuf.ar;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class p extends com.google.protobuf.a {

    /* renamed from: d, reason: collision with root package name */
    private final Descriptors.b f35927d;

    /* renamed from: e, reason: collision with root package name */
    private final z<Descriptors.FieldDescriptor> f35928e;

    /* renamed from: f, reason: collision with root package name */
    private final Descriptors.FieldDescriptor[] f35929f;

    /* renamed from: h, reason: collision with root package name */
    private final cc f35930h;

    /* renamed from: i, reason: collision with root package name */
    private int f35931i = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends c<p> {
        a() {
        }

        @Override // com.google.protobuf.bg
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public p g(k kVar, t tVar) throws InvalidProtocolBufferException {
            b r16 = p.r(p.this.f35927d);
            try {
                r16.mergeFrom(kVar, tVar);
                return r16.buildPartial();
            } catch (InvalidProtocolBufferException e16) {
                throw e16.setUnfinishedMessage(r16.buildPartial());
            } catch (IOException e17) {
                throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(r16.buildPartial());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b extends a.AbstractC0252a<b> {

        /* renamed from: d, reason: collision with root package name */
        private final Descriptors.b f35933d;

        /* renamed from: e, reason: collision with root package name */
        private z<Descriptors.FieldDescriptor> f35934e;

        /* renamed from: f, reason: collision with root package name */
        private final Descriptors.FieldDescriptor[] f35935f;

        /* renamed from: h, reason: collision with root package name */
        private cc f35936h;

        /* synthetic */ b(Descriptors.b bVar, a aVar) {
            this(bVar);
        }

        private void i(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (fieldDescriptor.isRepeated()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    k(fieldDescriptor, it.next());
                }
                return;
            }
            k(fieldDescriptor, obj);
        }

        private void j() {
            if (this.f35934e.B()) {
                this.f35934e = this.f35934e.clone();
            }
        }

        private void k(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            ad.a(obj);
            if (obj instanceof Descriptors.d) {
            } else {
                throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
            }
        }

        private void p() {
            for (Descriptors.FieldDescriptor fieldDescriptor : this.f35933d.r()) {
                if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    this.f35934e.M(fieldDescriptor, p.e(fieldDescriptor.w()));
                } else {
                    this.f35934e.M(fieldDescriptor, fieldDescriptor.r());
                }
            }
        }

        private void s(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.q() == this.f35933d) {
            } else {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void t(Descriptors.g gVar) {
            if (gVar.p() == this.f35933d) {
            } else {
                throw new IllegalArgumentException("OneofDescriptor does not match message type.");
            }
        }

        @Override // com.google.protobuf.ar.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            s(fieldDescriptor);
            j();
            this.f35934e.f(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public p build() {
            if (isInitialized()) {
                return buildPartial();
            }
            Descriptors.b bVar = this.f35933d;
            z<Descriptors.FieldDescriptor> zVar = this.f35934e;
            Descriptors.FieldDescriptor[] fieldDescriptorArr = this.f35935f;
            throw a.AbstractC0252a.newUninitializedMessageException((ar) new p(bVar, zVar, (Descriptors.FieldDescriptor[]) Arrays.copyOf(fieldDescriptorArr, fieldDescriptorArr.length), this.f35936h));
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public p buildPartial() {
            this.f35934e.G();
            Descriptors.b bVar = this.f35933d;
            z<Descriptors.FieldDescriptor> zVar = this.f35934e;
            Descriptors.FieldDescriptor[] fieldDescriptorArr = this.f35935f;
            return new p(bVar, zVar, (Descriptors.FieldDescriptor[]) Arrays.copyOf(fieldDescriptorArr, fieldDescriptorArr.length), this.f35936h);
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b clear() {
            if (this.f35934e.B()) {
                this.f35934e = z.K();
            } else {
                this.f35934e.g();
            }
            if (this.f35933d.u().getMapEntry()) {
                p();
            }
            this.f35936h = cc.c();
            return this;
        }

        @Override // com.google.protobuf.ar.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            s(fieldDescriptor);
            j();
            Descriptors.g p16 = fieldDescriptor.p();
            if (p16 != null) {
                int r16 = p16.r();
                Descriptors.FieldDescriptor[] fieldDescriptorArr = this.f35935f;
                if (fieldDescriptorArr[r16] == fieldDescriptor) {
                    fieldDescriptorArr[r16] = null;
                }
            }
            this.f35934e.h(fieldDescriptor);
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public b clearOneof(Descriptors.g gVar) {
            t(gVar);
            Descriptors.FieldDescriptor fieldDescriptor = this.f35935f[gVar.r()];
            if (fieldDescriptor != null) {
                clearField(fieldDescriptor);
            }
            return this;
        }

        @Override // com.google.protobuf.ax
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return this.f35934e.r();
        }

        @Override // com.google.protobuf.ar.a, com.google.protobuf.ax
        public Descriptors.b getDescriptorForType() {
            return this.f35933d;
        }

        @Override // com.google.protobuf.ax
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            s(fieldDescriptor);
            Object s16 = this.f35934e.s(fieldDescriptor);
            if (s16 == null) {
                if (fieldDescriptor.isRepeated()) {
                    return Collections.emptyList();
                }
                if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return p.e(fieldDescriptor.w());
                }
                return fieldDescriptor.r();
            }
            return s16;
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public ar.a getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar) {
            t(gVar);
            return this.f35935f[gVar.r()];
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public ar.a getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i3) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
        }

        @Override // com.google.protobuf.ax
        public cc getUnknownFields() {
            return this.f35936h;
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public b mo50clone() {
            b bVar = new b(this.f35933d);
            bVar.f35934e.H(this.f35934e);
            bVar.mo52mergeUnknownFields(this.f35936h);
            Descriptors.FieldDescriptor[] fieldDescriptorArr = this.f35935f;
            System.arraycopy(fieldDescriptorArr, 0, bVar.f35935f, 0, fieldDescriptorArr.length);
            return bVar;
        }

        @Override // com.google.protobuf.ax
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            s(fieldDescriptor);
            return this.f35934e.z(fieldDescriptor);
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public boolean hasOneof(Descriptors.g gVar) {
            t(gVar);
            if (this.f35935f[gVar.r()] == null) {
                return false;
            }
            return true;
        }

        @Override // com.google.protobuf.av
        public boolean isInitialized() {
            return p.q(this.f35933d, this.f35934e);
        }

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public p getDefaultInstanceForType() {
            return p.e(this.f35933d);
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(ar arVar) {
            if (arVar instanceof p) {
                p pVar = (p) arVar;
                if (pVar.f35927d == this.f35933d) {
                    j();
                    this.f35934e.H(pVar.f35928e);
                    mo52mergeUnknownFields(pVar.f35930h);
                    int i3 = 0;
                    while (true) {
                        Descriptors.FieldDescriptor[] fieldDescriptorArr = this.f35935f;
                        if (i3 < fieldDescriptorArr.length) {
                            if (fieldDescriptorArr[i3] == null) {
                                fieldDescriptorArr[i3] = pVar.f35929f[i3];
                            } else if (pVar.f35929f[i3] != null && this.f35935f[i3] != pVar.f35929f[i3]) {
                                this.f35934e.h(this.f35935f[i3]);
                                this.f35935f[i3] = pVar.f35929f[i3];
                            }
                            i3++;
                        } else {
                            return this;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
                }
            } else {
                return (b) super.mergeFrom(arVar);
            }
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b mo52mergeUnknownFields(cc ccVar) {
            this.f35936h = cc.h(this.f35936h).p(ccVar).build();
            return this;
        }

        @Override // com.google.protobuf.ar.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public b newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            s(fieldDescriptor);
            if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return new b(fieldDescriptor.w());
            }
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        @Override // com.google.protobuf.ar.a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            s(fieldDescriptor);
            j();
            if (fieldDescriptor.y() == Descriptors.FieldDescriptor.Type.ENUM) {
                i(fieldDescriptor, obj);
            }
            Descriptors.g p16 = fieldDescriptor.p();
            if (p16 != null) {
                int r16 = p16.r();
                Descriptors.FieldDescriptor fieldDescriptor2 = this.f35935f[r16];
                if (fieldDescriptor2 != null && fieldDescriptor2 != fieldDescriptor) {
                    this.f35934e.h(fieldDescriptor2);
                }
                this.f35935f[r16] = fieldDescriptor;
            } else if (fieldDescriptor.h().t() == Descriptors.FileDescriptor.Syntax.PROTO3 && !fieldDescriptor.isRepeated() && fieldDescriptor.v() != Descriptors.FieldDescriptor.JavaType.MESSAGE && obj.equals(fieldDescriptor.r())) {
                this.f35934e.h(fieldDescriptor);
                return this;
            }
            this.f35934e.M(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.ar.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public b setUnknownFields(cc ccVar) {
            this.f35936h = ccVar;
            return this;
        }

        b(Descriptors.b bVar) {
            this.f35933d = bVar;
            this.f35934e = z.K();
            this.f35936h = cc.c();
            this.f35935f = new Descriptors.FieldDescriptor[bVar.j().getOneofDeclCount()];
            if (bVar.u().getMapEntry()) {
                p();
            }
        }
    }

    p(Descriptors.b bVar, z<Descriptors.FieldDescriptor> zVar, Descriptors.FieldDescriptor[] fieldDescriptorArr, cc ccVar) {
        this.f35927d = bVar;
        this.f35928e = zVar;
        this.f35929f = fieldDescriptorArr;
        this.f35930h = ccVar;
    }

    public static p e(Descriptors.b bVar) {
        return new p(bVar, z.q(), new Descriptors.FieldDescriptor[bVar.j().getOneofDeclCount()], cc.c());
    }

    static boolean q(Descriptors.b bVar, z<Descriptors.FieldDescriptor> zVar) {
        for (Descriptors.FieldDescriptor fieldDescriptor : bVar.r()) {
            if (fieldDescriptor.E() && !zVar.z(fieldDescriptor)) {
                return false;
            }
        }
        return zVar.C();
    }

    public static b r(Descriptors.b bVar) {
        return new b(bVar, null);
    }

    private void u(Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.q() == this.f35927d) {
        } else {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    private void v(Descriptors.g gVar) {
        if (gVar.p() == this.f35927d) {
        } else {
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }
    }

    @Override // com.google.protobuf.ax
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return this.f35928e.r();
    }

    @Override // com.google.protobuf.ax
    public Descriptors.b getDescriptorForType() {
        return this.f35927d;
    }

    @Override // com.google.protobuf.ax
    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        u(fieldDescriptor);
        Object s16 = this.f35928e.s(fieldDescriptor);
        if (s16 == null) {
            if (fieldDescriptor.isRepeated()) {
                return Collections.emptyList();
            }
            if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return e(fieldDescriptor.w());
            }
            return fieldDescriptor.r();
        }
        return s16;
    }

    @Override // com.google.protobuf.a
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar) {
        v(gVar);
        return this.f35929f[gVar.r()];
    }

    @Override // com.google.protobuf.au
    public bg<p> getParserForType() {
        return new a();
    }

    @Override // com.google.protobuf.a, com.google.protobuf.au
    public int getSerializedSize() {
        int x16;
        int serializedSize;
        int i3 = this.f35931i;
        if (i3 != -1) {
            return i3;
        }
        if (this.f35927d.u().getMessageSetWireFormat()) {
            x16 = this.f35928e.t();
            serializedSize = this.f35930h.f();
        } else {
            x16 = this.f35928e.x();
            serializedSize = this.f35930h.getSerializedSize();
        }
        int i16 = x16 + serializedSize;
        this.f35931i = i16;
        return i16;
    }

    @Override // com.google.protobuf.ax
    public cc getUnknownFields() {
        return this.f35930h;
    }

    @Override // com.google.protobuf.ax
    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        u(fieldDescriptor);
        return this.f35928e.z(fieldDescriptor);
    }

    @Override // com.google.protobuf.a
    public boolean hasOneof(Descriptors.g gVar) {
        v(gVar);
        if (this.f35929f[gVar.r()] == null) {
            return false;
        }
        return true;
    }

    @Override // com.google.protobuf.a, com.google.protobuf.av
    public boolean isInitialized() {
        return q(this.f35927d, this.f35928e);
    }

    @Override // com.google.protobuf.av, com.google.protobuf.ax
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public p getDefaultInstanceForType() {
        return e(this.f35927d);
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return new b(this.f35927d, null);
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return newBuilderForType().mergeFrom(this);
    }

    @Override // com.google.protobuf.a, com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f35927d.u().getMessageSetWireFormat()) {
            this.f35928e.R(codedOutputStream);
            this.f35930h.l(codedOutputStream);
        } else {
            this.f35928e.T(codedOutputStream);
            this.f35930h.writeTo(codedOutputStream);
        }
    }
}
