package dn0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f394296a;

    /* renamed from: b, reason: collision with root package name */
    public long f394297b;

    /* renamed from: c, reason: collision with root package name */
    public long f394298c;

    /* renamed from: d, reason: collision with root package name */
    public int f394299d;

    /* renamed from: e, reason: collision with root package name */
    public int f394300e;

    /* renamed from: f, reason: collision with root package name */
    public String f394301f;

    /* renamed from: g, reason: collision with root package name */
    public String f394302g;

    /* renamed from: h, reason: collision with root package name */
    public long f394303h;

    /* renamed from: i, reason: collision with root package name */
    public int f394304i;

    /* renamed from: j, reason: collision with root package name */
    public int f394305j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f394306k = false;

    /* renamed from: l, reason: collision with root package name */
    public cn0.a[] f394307l;

    public b() {
        a();
    }

    public b a() {
        this.f394296a = 0;
        this.f394297b = 0L;
        this.f394298c = 0L;
        this.f394299d = 0;
        this.f394300e = 0;
        this.f394301f = "";
        this.f394302g = "";
        this.f394303h = 0L;
        this.f394304i = 0;
        this.f394305j = 0;
        this.f394307l = cn0.a.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f394296a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f394297b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.f394298c = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.f394299d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f394300e = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    this.f394301f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f394302g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f394303h = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.f394304i = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.f394305j = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    cn0.a[] aVarArr = this.f394307l;
                    if (aVarArr == null) {
                        length = 0;
                    } else {
                        length = aVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    cn0.a[] aVarArr2 = new cn0.a[i3];
                    if (length != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        cn0.a aVar = new cn0.a();
                        aVarArr2[length] = aVar;
                        codedInputByteBufferNano.readMessage(aVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    cn0.a aVar2 = new cn0.a();
                    aVarArr2[length] = aVar2;
                    codedInputByteBufferNano.readMessage(aVar2);
                    this.f394307l = aVarArr2;
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f394296a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.f394297b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f394298c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        int i16 = this.f394299d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f394300e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        if (!this.f394301f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f394301f);
        }
        if (!this.f394302g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f394302g);
        }
        long j17 = this.f394303h;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j17);
        }
        int i18 = this.f394304i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i18);
        }
        int i19 = this.f394305j;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i19);
        }
        cn0.a[] aVarArr = this.f394307l;
        if (aVarArr != null && aVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                cn0.a[] aVarArr2 = this.f394307l;
                if (i26 >= aVarArr2.length) {
                    break;
                }
                cn0.a aVar = aVarArr2[i26];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, aVar);
                }
                i26++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f394296a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.f394297b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f394298c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        int i16 = this.f394299d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f394300e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        if (!this.f394301f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f394301f);
        }
        if (!this.f394302g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f394302g);
        }
        long j17 = this.f394303h;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j17);
        }
        int i18 = this.f394304i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i18);
        }
        int i19 = this.f394305j;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i19);
        }
        cn0.a[] aVarArr = this.f394307l;
        if (aVarArr != null && aVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                cn0.a[] aVarArr2 = this.f394307l;
                if (i26 >= aVarArr2.length) {
                    break;
                }
                cn0.a aVar = aVarArr2[i26];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, aVar);
                }
                i26++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
