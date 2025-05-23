package or4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public int f423486a;

    /* renamed from: b, reason: collision with root package name */
    public String f423487b;

    /* renamed from: c, reason: collision with root package name */
    public int f423488c;

    /* renamed from: d, reason: collision with root package name */
    public k[] f423489d;

    /* renamed from: e, reason: collision with root package name */
    public int f423490e;

    /* renamed from: f, reason: collision with root package name */
    public int f423491f;

    /* renamed from: g, reason: collision with root package name */
    public int f423492g;

    /* renamed from: h, reason: collision with root package name */
    public j f423493h;

    /* renamed from: i, reason: collision with root package name */
    public long f423494i;

    /* renamed from: j, reason: collision with root package name */
    public int f423495j;

    public g() {
        a();
    }

    public static g c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (g) MessageNano.mergeFrom(new g(), bArr);
    }

    public g a() {
        this.f423486a = 0;
        this.f423487b = "";
        this.f423488c = 0;
        this.f423489d = k.b();
        this.f423490e = 0;
        this.f423491f = 0;
        this.f423492g = 0;
        this.f423493h = null;
        this.f423494i = 0L;
        this.f423495j = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f423486a = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.f423487b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f423488c = readInt32;
                        break;
                    }
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    k[] kVarArr = this.f423489d;
                    if (kVarArr == null) {
                        length = 0;
                    } else {
                        length = kVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    k[] kVarArr2 = new k[i3];
                    if (length != 0) {
                        System.arraycopy(kVarArr, 0, kVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        k kVar = new k();
                        kVarArr2[length] = kVar;
                        codedInputByteBufferNano.readMessage(kVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    k kVar2 = new k();
                    kVarArr2[length] = kVar2;
                    codedInputByteBufferNano.readMessage(kVar2);
                    this.f423489d = kVarArr2;
                    break;
                case 40:
                    this.f423490e = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.f423491f = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.f423492g = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    if (this.f423493h == null) {
                        this.f423493h = new j();
                    }
                    codedInputByteBufferNano.readMessage(this.f423493h);
                    break;
                case 72:
                    this.f423494i = codedInputByteBufferNano.readUInt64();
                    break;
                case 80:
                    this.f423495j = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f423486a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f423487b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f423487b);
        }
        int i16 = this.f423488c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        k[] kVarArr = this.f423489d;
        if (kVarArr != null && kVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                k[] kVarArr2 = this.f423489d;
                if (i17 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i17];
                if (kVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, kVar);
                }
                i17++;
            }
        }
        int i18 = this.f423490e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        int i19 = this.f423491f;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i19);
        }
        int i26 = this.f423492g;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i26);
        }
        j jVar = this.f423493h;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, jVar);
        }
        long j3 = this.f423494i;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j3);
        }
        int i27 = this.f423495j;
        if (i27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(10, i27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f423486a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f423487b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f423487b);
        }
        int i16 = this.f423488c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        k[] kVarArr = this.f423489d;
        if (kVarArr != null && kVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                k[] kVarArr2 = this.f423489d;
                if (i17 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i17];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, kVar);
                }
                i17++;
            }
        }
        int i18 = this.f423490e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        int i19 = this.f423491f;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i19);
        }
        int i26 = this.f423492g;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i26);
        }
        j jVar = this.f423493h;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(8, jVar);
        }
        long j3 = this.f423494i;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j3);
        }
        int i27 = this.f423495j;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i27);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
