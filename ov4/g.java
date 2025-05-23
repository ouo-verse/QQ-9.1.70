package ov4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public int f424159a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f424160b;

    /* renamed from: c, reason: collision with root package name */
    public String f424161c;

    /* renamed from: d, reason: collision with root package name */
    public p[] f424162d;

    /* renamed from: e, reason: collision with root package name */
    public int f424163e;

    /* renamed from: f, reason: collision with root package name */
    public String f424164f;

    public g() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f424159a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                long[] jArr = this.f424160b;
                int length = jArr == null ? 0 : jArr.length;
                int i3 = repeatedFieldArrayLength + length;
                long[] jArr2 = new long[i3];
                if (length != 0) {
                    System.arraycopy(jArr, 0, jArr2, 0, length);
                }
                while (length < i3 - 1) {
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                jArr2[length] = codedInputByteBufferNano.readUInt64();
                this.f424160b = jArr2;
            } else if (readTag == 18) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.f424160b;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                int i17 = i16 + length2;
                long[] jArr4 = new long[i17];
                if (length2 != 0) {
                    System.arraycopy(jArr3, 0, jArr4, 0, length2);
                }
                while (length2 < i17) {
                    jArr4[length2] = codedInputByteBufferNano.readUInt64();
                    length2++;
                }
                this.f424160b = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 26) {
                this.f424161c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                p[] pVarArr = this.f424162d;
                int length3 = pVarArr == null ? 0 : pVarArr.length;
                int i18 = repeatedFieldArrayLength2 + length3;
                p[] pVarArr2 = new p[i18];
                if (length3 != 0) {
                    System.arraycopy(pVarArr, 0, pVarArr2, 0, length3);
                }
                while (length3 < i18 - 1) {
                    p pVar = new p();
                    pVarArr2[length3] = pVar;
                    codedInputByteBufferNano.readMessage(pVar);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                p pVar2 = new p();
                pVarArr2[length3] = pVar2;
                codedInputByteBufferNano.readMessage(pVar2);
                this.f424162d = pVarArr2;
            } else if (readTag == 40) {
                this.f424163e = codedInputByteBufferNano.readInt32();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f424164f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f424159a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long[] jArr2 = this.f424160b;
        int i16 = 0;
        if (jArr2 != null && jArr2.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                jArr = this.f424160b;
                if (i17 >= jArr.length) {
                    break;
                }
                i18 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i17]);
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (jArr.length * 1);
        }
        if (!this.f424161c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f424161c);
        }
        p[] pVarArr = this.f424162d;
        if (pVarArr != null && pVarArr.length > 0) {
            while (true) {
                p[] pVarArr2 = this.f424162d;
                if (i16 >= pVarArr2.length) {
                    break;
                }
                p pVar = pVarArr2[i16];
                if (pVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, pVar);
                }
                i16++;
            }
        }
        int i19 = this.f424163e;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i19);
        }
        return !this.f424164f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f424164f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f424159a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long[] jArr = this.f424160b;
        int i16 = 0;
        if (jArr != null && jArr.length > 0) {
            int i17 = 0;
            while (true) {
                long[] jArr2 = this.f424160b;
                if (i17 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(2, jArr2[i17]);
                i17++;
            }
        }
        if (!this.f424161c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f424161c);
        }
        p[] pVarArr = this.f424162d;
        if (pVarArr != null && pVarArr.length > 0) {
            while (true) {
                p[] pVarArr2 = this.f424162d;
                if (i16 >= pVarArr2.length) {
                    break;
                }
                p pVar = pVarArr2[i16];
                if (pVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, pVar);
                }
                i16++;
            }
        }
        int i18 = this.f424163e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i18);
        }
        if (!this.f424164f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f424164f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f424159a = 0;
        this.f424160b = WireFormatNano.EMPTY_LONG_ARRAY;
        this.f424161c = "";
        this.f424162d = p.b();
        this.f424163e = 0;
        this.f424164f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
