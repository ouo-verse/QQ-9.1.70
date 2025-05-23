package lu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public int f415586a;

    /* renamed from: b, reason: collision with root package name */
    public b f415587b;

    /* renamed from: c, reason: collision with root package name */
    public e f415588c;

    /* renamed from: d, reason: collision with root package name */
    public f f415589d;

    /* renamed from: e, reason: collision with root package name */
    public String f415590e;

    /* renamed from: f, reason: collision with root package name */
    public String f415591f;

    /* renamed from: g, reason: collision with root package name */
    public String f415592g;

    /* renamed from: h, reason: collision with root package name */
    public int f415593h;

    /* renamed from: i, reason: collision with root package name */
    public int f415594i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f415595j;

    /* renamed from: k, reason: collision with root package name */
    public a[] f415596k;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                        break;
                    } else {
                        this.f415586a = readInt32;
                        break;
                    }
                case 18:
                    if (this.f415587b == null) {
                        this.f415587b = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f415587b);
                    break;
                case 26:
                    if (this.f415588c == null) {
                        this.f415588c = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f415588c);
                    break;
                case 34:
                    if (this.f415589d == null) {
                        this.f415589d = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f415589d);
                    break;
                case 42:
                    this.f415590e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f415591f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f415592g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f415593h = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.f415594i = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.f415595j = codedInputByteBufferNano.readBool();
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    a[] aVarArr = this.f415596k;
                    int length = aVarArr == null ? 0 : aVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    a[] aVarArr2 = new a[i3];
                    if (length != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        a aVar = new a();
                        aVarArr2[length] = aVar;
                        codedInputByteBufferNano.readMessage(aVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    a aVar2 = new a();
                    aVarArr2[length] = aVar2;
                    codedInputByteBufferNano.readMessage(aVar2);
                    this.f415596k = aVarArr2;
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
        int i3 = this.f415586a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        b bVar = this.f415587b;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
        }
        e eVar = this.f415588c;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
        }
        f fVar = this.f415589d;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, fVar);
        }
        if (!this.f415590e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f415590e);
        }
        if (!this.f415591f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f415591f);
        }
        if (!this.f415592g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f415592g);
        }
        int i16 = this.f415593h;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        int i17 = this.f415594i;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i17);
        }
        boolean z16 = this.f415595j;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z16);
        }
        a[] aVarArr = this.f415596k;
        if (aVarArr != null && aVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                a[] aVarArr2 = this.f415596k;
                if (i18 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i18];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, aVar);
                }
                i18++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f415586a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        b bVar = this.f415587b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar);
        }
        e eVar = this.f415588c;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(3, eVar);
        }
        f fVar = this.f415589d;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(4, fVar);
        }
        if (!this.f415590e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f415590e);
        }
        if (!this.f415591f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f415591f);
        }
        if (!this.f415592g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f415592g);
        }
        int i16 = this.f415593h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        int i17 = this.f415594i;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i17);
        }
        boolean z16 = this.f415595j;
        if (z16) {
            codedOutputByteBufferNano.writeBool(10, z16);
        }
        a[] aVarArr = this.f415596k;
        if (aVarArr != null && aVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                a[] aVarArr2 = this.f415596k;
                if (i18 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i18];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, aVar);
                }
                i18++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f415586a = 0;
        this.f415587b = null;
        this.f415588c = null;
        this.f415589d = null;
        this.f415590e = "";
        this.f415591f = "";
        this.f415592g = "";
        this.f415593h = 0;
        this.f415594i = 0;
        this.f415595j = false;
        this.f415596k = a.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
