package ku4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String f413093a;

    /* renamed from: b, reason: collision with root package name */
    public i f413094b;

    /* renamed from: c, reason: collision with root package name */
    public int f413095c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f413096d;

    /* renamed from: e, reason: collision with root package name */
    public j f413097e;

    /* renamed from: f, reason: collision with root package name */
    public String f413098f;

    public d() {
        a();
    }

    public d a() {
        this.f413093a = "";
        this.f413094b = null;
        this.f413095c = 0;
        this.f413096d = WireFormatNano.EMPTY_INT_ARRAY;
        this.f413097e = null;
        this.f413098f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f413093a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.f413094b == null) {
                    this.f413094b = new i();
                }
                codedInputByteBufferNano.readMessage(this.f413094b);
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.f413095c = readInt32;
                }
            } else if (readTag == 32) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                int[] iArr = this.f413096d;
                int length = iArr == null ? 0 : iArr.length;
                int i3 = repeatedFieldArrayLength + length;
                int[] iArr2 = new int[i3];
                if (length != 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                }
                while (length < i3 - 1) {
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                iArr2[length] = codedInputByteBufferNano.readUInt32();
                this.f413096d = iArr2;
            } else if (readTag == 34) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.f413096d;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int i17 = i16 + length2;
                int[] iArr4 = new int[i17];
                if (length2 != 0) {
                    System.arraycopy(iArr3, 0, iArr4, 0, length2);
                }
                while (length2 < i17) {
                    iArr4[length2] = codedInputByteBufferNano.readUInt32();
                    length2++;
                }
                this.f413096d = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 42) {
                if (this.f413097e == null) {
                    this.f413097e = new j();
                }
                codedInputByteBufferNano.readMessage(this.f413097e);
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f413098f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f413093a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f413093a);
        }
        i iVar = this.f413094b;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, iVar);
        }
        int i3 = this.f413095c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        int[] iArr2 = this.f413096d;
        if (iArr2 != null && iArr2.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                iArr = this.f413096d;
                if (i16 >= iArr.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (iArr.length * 1);
        }
        j jVar = this.f413097e;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, jVar);
        }
        return !this.f413098f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f413098f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f413093a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f413093a);
        }
        i iVar = this.f413094b;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(2, iVar);
        }
        int i3 = this.f413095c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        int[] iArr = this.f413096d;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.f413096d;
                if (i16 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(4, iArr2[i16]);
                i16++;
            }
        }
        j jVar = this.f413097e;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(5, jVar);
        }
        if (!this.f413098f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f413098f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
