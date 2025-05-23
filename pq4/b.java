package pq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f427016a;

    /* renamed from: b, reason: collision with root package name */
    public int f427017b;

    /* renamed from: c, reason: collision with root package name */
    public String f427018c;

    /* renamed from: d, reason: collision with root package name */
    public String f427019d;

    /* renamed from: e, reason: collision with root package name */
    public String f427020e;

    /* renamed from: f, reason: collision with root package name */
    public String f427021f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f427022g;

    public b() {
        a();
    }

    public b a() {
        this.f427016a = "";
        this.f427017b = 0;
        this.f427018c = "";
        this.f427019d = "";
        this.f427020e = "";
        this.f427021f = "";
        this.f427022g = WireFormatNano.EMPTY_INT_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 56) {
                                            if (readTag != 58) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                                int position = codedInputByteBufferNano.getPosition();
                                                int i3 = 0;
                                                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                                    codedInputByteBufferNano.readInt32();
                                                    i3++;
                                                }
                                                codedInputByteBufferNano.rewindToPosition(position);
                                                int[] iArr = this.f427022g;
                                                if (iArr == null) {
                                                    length = 0;
                                                } else {
                                                    length = iArr.length;
                                                }
                                                int i16 = i3 + length;
                                                int[] iArr2 = new int[i16];
                                                if (length != 0) {
                                                    System.arraycopy(iArr, 0, iArr2, 0, length);
                                                }
                                                while (length < i16) {
                                                    iArr2[length] = codedInputByteBufferNano.readInt32();
                                                    length++;
                                                }
                                                this.f427022g = iArr2;
                                                codedInputByteBufferNano.popLimit(pushLimit);
                                            }
                                        } else {
                                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 56);
                                            int[] iArr3 = this.f427022g;
                                            if (iArr3 == null) {
                                                length2 = 0;
                                            } else {
                                                length2 = iArr3.length;
                                            }
                                            int i17 = repeatedFieldArrayLength + length2;
                                            int[] iArr4 = new int[i17];
                                            if (length2 != 0) {
                                                System.arraycopy(iArr3, 0, iArr4, 0, length2);
                                            }
                                            while (length2 < i17 - 1) {
                                                iArr4[length2] = codedInputByteBufferNano.readInt32();
                                                codedInputByteBufferNano.readTag();
                                                length2++;
                                            }
                                            iArr4[length2] = codedInputByteBufferNano.readInt32();
                                            this.f427022g = iArr4;
                                        }
                                    } else {
                                        this.f427021f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f427020e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f427019d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f427018c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f427017b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f427016a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f427016a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427016a);
        }
        int i3 = this.f427017b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.f427018c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427018c);
        }
        if (!this.f427019d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427019d);
        }
        if (!this.f427020e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f427020e);
        }
        if (!this.f427021f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f427021f);
        }
        int[] iArr = this.f427022g;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                int[] iArr2 = this.f427022g;
                if (i16 < iArr2.length) {
                    i17 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i16]);
                    i16++;
                } else {
                    return computeSerializedSize + i17 + (iArr2.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427016a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427016a);
        }
        int i3 = this.f427017b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.f427018c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427018c);
        }
        if (!this.f427019d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427019d);
        }
        if (!this.f427020e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427020e);
        }
        if (!this.f427021f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427021f);
        }
        int[] iArr = this.f427022g;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.f427022g;
                if (i16 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(7, iArr2[i16]);
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
