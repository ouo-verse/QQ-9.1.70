package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.WireFormat;
import com.google.protobuf.ar;
import com.google.protobuf.cc;
import com.google.protobuf.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class MessageReflection {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface MergeTarget {

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public enum ContainerType {
            MESSAGE,
            EXTENSION_SET
        }

        Object a(k kVar, t tVar, Descriptors.FieldDescriptor fieldDescriptor, ar arVar) throws IOException;

        MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        r.b b(r rVar, Descriptors.b bVar, int i3);

        WireFormat.Utf8Validation c(Descriptors.FieldDescriptor fieldDescriptor);

        Object d(ByteString byteString, t tVar, Descriptors.FieldDescriptor fieldDescriptor, ar arVar) throws IOException;

        Object e(k kVar, t tVar, Descriptors.FieldDescriptor fieldDescriptor, ar arVar) throws IOException;

        ContainerType getContainerType();

        boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35589a;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            f35589a = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.f35373GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35589a[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35589a[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b implements MergeTarget {

        /* renamed from: a, reason: collision with root package name */
        private final ar.a f35590a;

        public b(ar.a aVar) {
            this.f35590a = aVar;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object a(k kVar, t tVar, Descriptors.FieldDescriptor fieldDescriptor, ar arVar) throws IOException {
            ar.a newBuilderForField;
            ar arVar2;
            if (arVar != null) {
                newBuilderForField = arVar.newBuilderForType();
            } else {
                newBuilderForField = this.f35590a.newBuilderForField(fieldDescriptor);
            }
            if (!fieldDescriptor.isRepeated() && (arVar2 = (ar) f(fieldDescriptor)) != null) {
                newBuilderForField.mergeFrom(arVar2);
            }
            kVar.w(fieldDescriptor.getNumber(), newBuilderForField, tVar);
            return newBuilderForField.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.f35590a.addRepeatedField(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public r.b b(r rVar, Descriptors.b bVar, int i3) {
            return rVar.e(bVar, i3);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation c(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.F()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            if (!fieldDescriptor.isRepeated() && (this.f35590a instanceof GeneratedMessage.f)) {
                return WireFormat.Utf8Validation.LAZY;
            }
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object d(ByteString byteString, t tVar, Descriptors.FieldDescriptor fieldDescriptor, ar arVar) throws IOException {
            ar.a newBuilderForField;
            ar arVar2;
            if (arVar != null) {
                newBuilderForField = arVar.newBuilderForType();
            } else {
                newBuilderForField = this.f35590a.newBuilderForField(fieldDescriptor);
            }
            if (!fieldDescriptor.isRepeated() && (arVar2 = (ar) f(fieldDescriptor)) != null) {
                newBuilderForField.mergeFrom(arVar2);
            }
            newBuilderForField.mergeFrom(byteString, tVar);
            return newBuilderForField.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object e(k kVar, t tVar, Descriptors.FieldDescriptor fieldDescriptor, ar arVar) throws IOException {
            ar.a newBuilderForField;
            ar arVar2;
            if (arVar != null) {
                newBuilderForField = arVar.newBuilderForType();
            } else {
                newBuilderForField = this.f35590a.newBuilderForField(fieldDescriptor);
            }
            if (!fieldDescriptor.isRepeated() && (arVar2 = (ar) f(fieldDescriptor)) != null) {
                newBuilderForField.mergeFrom(arVar2);
            }
            kVar.A(newBuilderForField, tVar);
            return newBuilderForField.buildPartial();
        }

        public Object f(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.f35590a.getField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.MESSAGE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.f35590a.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.f35590a.setField(fieldDescriptor, obj);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c implements MergeTarget {

        /* renamed from: a, reason: collision with root package name */
        private final z<Descriptors.FieldDescriptor> f35591a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(z<Descriptors.FieldDescriptor> zVar) {
            this.f35591a = zVar;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object a(k kVar, t tVar, Descriptors.FieldDescriptor fieldDescriptor, ar arVar) throws IOException {
            ar arVar2;
            ar.a newBuilderForType = arVar.newBuilderForType();
            if (!fieldDescriptor.isRepeated() && (arVar2 = (ar) f(fieldDescriptor)) != null) {
                newBuilderForType.mergeFrom(arVar2);
            }
            kVar.w(fieldDescriptor.getNumber(), newBuilderForType, tVar);
            return newBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.f35591a.f(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public r.b b(r rVar, Descriptors.b bVar, int i3) {
            return rVar.e(bVar, i3);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation c(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.F()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object d(ByteString byteString, t tVar, Descriptors.FieldDescriptor fieldDescriptor, ar arVar) throws IOException {
            ar arVar2;
            ar.a newBuilderForType = arVar.newBuilderForType();
            if (!fieldDescriptor.isRepeated() && (arVar2 = (ar) f(fieldDescriptor)) != null) {
                newBuilderForType.mergeFrom(arVar2);
            }
            newBuilderForType.mergeFrom(byteString, tVar);
            return newBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object e(k kVar, t tVar, Descriptors.FieldDescriptor fieldDescriptor, ar arVar) throws IOException {
            ar arVar2;
            ar.a newBuilderForType = arVar.newBuilderForType();
            if (!fieldDescriptor.isRepeated() && (arVar2 = (ar) f(fieldDescriptor)) != null) {
                newBuilderForType.mergeFrom(arVar2);
            }
            kVar.A(newBuilderForType, tVar);
            return newBuilderForType.buildPartial();
        }

        public Object f(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.f35591a.s(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.f35591a.z(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.f35591a.M(fieldDescriptor, obj);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(List<String> list) {
        StringBuilder sb5 = new StringBuilder();
        for (String str : list) {
            if (sb5.length() > 0) {
                sb5.append(", ");
            }
            sb5.append(str);
        }
        return sb5.toString();
    }

    private static void b(k kVar, r.b bVar, t tVar, MergeTarget mergeTarget) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = bVar.f35945a;
        mergeTarget.setField(fieldDescriptor, mergeTarget.e(kVar, tVar, fieldDescriptor, bVar.f35946b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> c(ax axVar) {
        ArrayList arrayList = new ArrayList();
        d(axVar, "", arrayList);
        return arrayList;
    }

    private static void d(ax axVar, String str, List<String> list) {
        for (Descriptors.FieldDescriptor fieldDescriptor : axVar.getDescriptorForType().r()) {
            if (fieldDescriptor.E() && !axVar.hasField(fieldDescriptor)) {
                list.add(str + fieldDescriptor.getName());
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : axVar.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (key.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (key.isRepeated()) {
                    Iterator it = ((List) value).iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        d((ax) it.next(), j(str, key, i3), list);
                        i3++;
                    }
                } else if (axVar.hasField(key)) {
                    d((ax) value, j(str, key, -1), list);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(ar arVar, Map<Descriptors.FieldDescriptor, Object> map) {
        int serializedSize;
        int o16;
        boolean messageSetWireFormat = arVar.getDescriptorForType().u().getMessageSetWireFormat();
        int i3 = 0;
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (messageSetWireFormat && key.z() && key.y() == Descriptors.FieldDescriptor.Type.MESSAGE && !key.isRepeated()) {
                o16 = CodedOutputStream.F(key.getNumber(), (ar) value);
            } else {
                o16 = z.o(key, value);
            }
            i3 += o16;
        }
        cc unknownFields = arVar.getUnknownFields();
        if (messageSetWireFormat) {
            serializedSize = unknownFields.f();
        } else {
            serializedSize = unknownFields.getSerializedSize();
        }
        return i3 + serializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(ax axVar) {
        for (Descriptors.FieldDescriptor fieldDescriptor : axVar.getDescriptorForType().r()) {
            if (fieldDescriptor.E() && !axVar.hasField(fieldDescriptor)) {
                return false;
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : axVar.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            if (key.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (key.isRepeated()) {
                    Iterator it = ((List) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        if (!((ar) it.next()).isInitialized()) {
                            return false;
                        }
                    }
                } else if (!((ar) entry.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(k kVar, cc.b bVar, t tVar, Descriptors.b bVar2, MergeTarget mergeTarget, int i3) throws IOException {
        ar arVar;
        boolean z16;
        Object a16;
        r.b b16;
        if (bVar2.u().getMessageSetWireFormat() && i3 == WireFormat.f35627a) {
            i(kVar, bVar, tVar, bVar2, mergeTarget);
            return true;
        }
        int b17 = WireFormat.b(i3);
        int a17 = WireFormat.a(i3);
        Descriptors.FieldDescriptor fieldDescriptor = null;
        if (bVar2.w(a17)) {
            if ((tVar instanceof r) && (b16 = mergeTarget.b((r) tVar, bVar2, a17)) != null) {
                Descriptors.FieldDescriptor fieldDescriptor2 = b16.f35945a;
                ar arVar2 = b16.f35946b;
                if (arVar2 == null && fieldDescriptor2.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    throw new IllegalStateException("Message-typed extension lacked default instance: " + fieldDescriptor2.i());
                }
                arVar = arVar2;
                fieldDescriptor = fieldDescriptor2;
            }
            arVar = null;
        } else {
            if (mergeTarget.getContainerType() == MergeTarget.ContainerType.MESSAGE) {
                fieldDescriptor = bVar2.o(a17);
                arVar = null;
            }
            arVar = null;
        }
        boolean z17 = false;
        if (fieldDescriptor != null) {
            if (b17 == z.y(fieldDescriptor.getLiteType(), false)) {
                z16 = false;
            } else if (fieldDescriptor.C() && b17 == z.y(fieldDescriptor.getLiteType(), true)) {
                z16 = true;
            }
            if (!z17) {
                if (bVar != null) {
                    return bVar.k(i3, kVar);
                }
                return kVar.N(i3);
            }
            if (z16) {
                int o16 = kVar.o(kVar.B());
                if (fieldDescriptor.getLiteType() == WireFormat.FieldType.ENUM) {
                    while (kVar.d() > 0) {
                        int s16 = kVar.s();
                        if (fieldDescriptor.h().z()) {
                            mergeTarget.addRepeatedField(fieldDescriptor, fieldDescriptor.s().n(s16));
                        } else {
                            Descriptors.d findValueByNumber = fieldDescriptor.s().findValueByNumber(s16);
                            if (findValueByNumber == null) {
                                if (bVar != null) {
                                    bVar.r(a17, s16);
                                }
                            } else {
                                mergeTarget.addRepeatedField(fieldDescriptor, findValueByNumber);
                            }
                        }
                    }
                } else {
                    while (kVar.d() > 0) {
                        mergeTarget.addRepeatedField(fieldDescriptor, WireFormat.d(kVar, fieldDescriptor.getLiteType(), mergeTarget.c(fieldDescriptor)));
                    }
                }
                kVar.n(o16);
            } else {
                int i16 = a.f35589a[fieldDescriptor.y().ordinal()];
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            a16 = WireFormat.d(kVar, fieldDescriptor.getLiteType(), mergeTarget.c(fieldDescriptor));
                        } else {
                            int s17 = kVar.s();
                            if (fieldDescriptor.h().z()) {
                                a16 = fieldDescriptor.s().n(s17);
                            } else {
                                Descriptors.d findValueByNumber2 = fieldDescriptor.s().findValueByNumber(s17);
                                if (findValueByNumber2 == null) {
                                    if (bVar != null) {
                                        bVar.r(a17, s17);
                                    }
                                    return true;
                                }
                                a16 = findValueByNumber2;
                            }
                        }
                    } else {
                        a16 = mergeTarget.e(kVar, tVar, fieldDescriptor, arVar);
                    }
                } else {
                    a16 = mergeTarget.a(kVar, tVar, fieldDescriptor, arVar);
                }
                if (fieldDescriptor.isRepeated()) {
                    mergeTarget.addRepeatedField(fieldDescriptor, a16);
                } else {
                    mergeTarget.setField(fieldDescriptor, a16);
                }
            }
            return true;
        }
        z16 = false;
        z17 = true;
        if (!z17) {
        }
    }

    private static void h(ByteString byteString, r.b bVar, t tVar, MergeTarget mergeTarget) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = bVar.f35945a;
        if (!mergeTarget.hasField(fieldDescriptor) && !t.c()) {
            mergeTarget.setField(fieldDescriptor, new ae(bVar.f35946b, tVar, byteString));
        } else {
            mergeTarget.setField(fieldDescriptor, mergeTarget.d(byteString, tVar, fieldDescriptor, bVar.f35946b));
        }
    }

    private static void i(k kVar, cc.b bVar, t tVar, Descriptors.b bVar2, MergeTarget mergeTarget) throws IOException {
        int i3 = 0;
        ByteString byteString = null;
        r.b bVar3 = null;
        while (true) {
            int J = kVar.J();
            if (J == 0) {
                break;
            }
            if (J == WireFormat.f35629c) {
                i3 = kVar.K();
                if (i3 != 0 && (tVar instanceof r)) {
                    bVar3 = mergeTarget.b((r) tVar, bVar2, i3);
                }
            } else if (J == WireFormat.f35630d) {
                if (i3 != 0 && bVar3 != null && t.c()) {
                    b(kVar, bVar3, tVar, mergeTarget);
                    byteString = null;
                } else {
                    byteString = kVar.q();
                }
            } else if (!kVar.N(J)) {
                break;
            }
        }
        kVar.a(WireFormat.f35628b);
        if (byteString != null && i3 != 0) {
            if (bVar3 != null) {
                h(byteString, bVar3, tVar, mergeTarget);
            } else if (bVar != null) {
                bVar.j(i3, cc.c.t().e(byteString).g());
            }
        }
    }

    private static String j(String str, Descriptors.FieldDescriptor fieldDescriptor, int i3) {
        StringBuilder sb5 = new StringBuilder(str);
        if (fieldDescriptor.z()) {
            sb5.append('(');
            sb5.append(fieldDescriptor.i());
            sb5.append(')');
        } else {
            sb5.append(fieldDescriptor.getName());
        }
        if (i3 != -1) {
            sb5.append('[');
            sb5.append(i3);
            sb5.append(']');
        }
        sb5.append('.');
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(ar arVar, Map<Descriptors.FieldDescriptor, Object> map, CodedOutputStream codedOutputStream, boolean z16) throws IOException {
        boolean messageSetWireFormat = arVar.getDescriptorForType().u().getMessageSetWireFormat();
        if (z16) {
            TreeMap treeMap = new TreeMap(map);
            for (Descriptors.FieldDescriptor fieldDescriptor : arVar.getDescriptorForType().r()) {
                if (fieldDescriptor.E() && !treeMap.containsKey(fieldDescriptor)) {
                    treeMap.put(fieldDescriptor, arVar.getField(fieldDescriptor));
                }
            }
            map = treeMap;
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (messageSetWireFormat && key.z() && key.y() == Descriptors.FieldDescriptor.Type.MESSAGE && !key.isRepeated()) {
                codedOutputStream.N0(key.getNumber(), (ar) value);
            } else {
                z.Q(key, value, codedOutputStream);
            }
        }
        cc unknownFields = arVar.getUnknownFields();
        if (messageSetWireFormat) {
            unknownFields.l(codedOutputStream);
        } else {
            unknownFields.writeTo(codedOutputStream);
        }
    }
}
