package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public int f403157a;

    /* renamed from: b, reason: collision with root package name */
    public String f403158b;

    /* renamed from: c, reason: collision with root package name */
    public s f403159c;

    /* renamed from: d, reason: collision with root package name */
    public String f403160d;

    /* renamed from: e, reason: collision with root package name */
    public int f403161e;

    /* renamed from: f, reason: collision with root package name */
    public k[] f403162f;

    /* renamed from: g, reason: collision with root package name */
    public m f403163g;

    /* renamed from: h, reason: collision with root package name */
    public int f403164h;

    /* renamed from: i, reason: collision with root package name */
    public aa f403165i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f403166j;

    /* renamed from: k, reason: collision with root package name */
    public int f403167k;

    /* renamed from: l, reason: collision with root package name */
    public tq4.a f403168l;

    public o() {
        a();
    }

    public static o c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (o) MessageNano.mergeFrom(new o(), bArr);
    }

    public o a() {
        this.f403157a = 0;
        this.f403158b = "";
        this.f403159c = null;
        this.f403160d = "";
        this.f403161e = 0;
        this.f403162f = k.b();
        this.f403163g = null;
        this.f403164h = 0;
        this.f403165i = null;
        this.f403166j = false;
        this.f403167k = 0;
        this.f403168l = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f403157a = codedInputByteBufferNano.readInt32();
                    break;
                case 18:
                    this.f403158b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    if (this.f403159c == null) {
                        this.f403159c = new s();
                    }
                    codedInputByteBufferNano.readMessage(this.f403159c);
                    break;
                case 34:
                    this.f403160d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f403161e = codedInputByteBufferNano.readInt32();
                    break;
                case 50:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    k[] kVarArr = this.f403162f;
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
                    this.f403162f = kVarArr2;
                    break;
                case 58:
                    if (this.f403163g == null) {
                        this.f403163g = new m();
                    }
                    codedInputByteBufferNano.readMessage(this.f403163g);
                    break;
                case 64:
                    this.f403164h = codedInputByteBufferNano.readUInt32();
                    break;
                case 98:
                    if (this.f403165i == null) {
                        this.f403165i = new aa();
                    }
                    codedInputByteBufferNano.readMessage(this.f403165i);
                    break;
                case 104:
                    this.f403166j = codedInputByteBufferNano.readBool();
                    break;
                case 112:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4) {
                        break;
                    } else {
                        this.f403167k = readInt32;
                        break;
                    }
                case 122:
                    if (this.f403168l == null) {
                        this.f403168l = new tq4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f403168l);
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
        int i3 = this.f403157a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f403158b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403158b);
        }
        s sVar = this.f403159c;
        if (sVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, sVar);
        }
        if (!this.f403160d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f403160d);
        }
        int i16 = this.f403161e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        k[] kVarArr = this.f403162f;
        if (kVarArr != null && kVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                k[] kVarArr2 = this.f403162f;
                if (i17 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i17];
                if (kVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, kVar);
                }
                i17++;
            }
        }
        m mVar = this.f403163g;
        if (mVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, mVar);
        }
        int i18 = this.f403164h;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i18);
        }
        aa aaVar = this.f403165i;
        if (aaVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, aaVar);
        }
        boolean z16 = this.f403166j;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, z16);
        }
        int i19 = this.f403167k;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i19);
        }
        tq4.a aVar = this.f403168l;
        if (aVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(15, aVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403157a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f403158b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403158b);
        }
        s sVar = this.f403159c;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(3, sVar);
        }
        if (!this.f403160d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403160d);
        }
        int i16 = this.f403161e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        k[] kVarArr = this.f403162f;
        if (kVarArr != null && kVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                k[] kVarArr2 = this.f403162f;
                if (i17 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i17];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, kVar);
                }
                i17++;
            }
        }
        m mVar = this.f403163g;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(7, mVar);
        }
        int i18 = this.f403164h;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i18);
        }
        aa aaVar = this.f403165i;
        if (aaVar != null) {
            codedOutputByteBufferNano.writeMessage(12, aaVar);
        }
        boolean z16 = this.f403166j;
        if (z16) {
            codedOutputByteBufferNano.writeBool(13, z16);
        }
        int i19 = this.f403167k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i19);
        }
        tq4.a aVar = this.f403168l;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(15, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
