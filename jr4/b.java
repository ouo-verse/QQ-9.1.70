package jr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f410880a;

    /* renamed from: b, reason: collision with root package name */
    public String f410881b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f410882c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f410883d;

    /* renamed from: e, reason: collision with root package name */
    public f f410884e;

    /* renamed from: f, reason: collision with root package name */
    public String f410885f;

    /* renamed from: g, reason: collision with root package name */
    public String f410886g;

    /* renamed from: h, reason: collision with root package name */
    public kr4.a f410887h;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f410880a = 0;
        this.f410881b = "";
        this.f410882c = WireFormatNano.EMPTY_BYTES;
        this.f410883d = WireFormatNano.EMPTY_INT_ARRAY;
        this.f410884e = null;
        this.f410885f = "";
        this.f410886g = "";
        this.f410887h = null;
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
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 34) {
                                    if (readTag != 42) {
                                        if (readTag != 50) {
                                            if (readTag != 58) {
                                                if (readTag != 66) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    if (this.f410887h == null) {
                                                        this.f410887h = new kr4.a();
                                                    }
                                                    codedInputByteBufferNano.readMessage(this.f410887h);
                                                }
                                            } else {
                                                this.f410886g = codedInputByteBufferNano.readString();
                                            }
                                        } else {
                                            this.f410885f = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        if (this.f410884e == null) {
                                            this.f410884e = new f();
                                        }
                                        codedInputByteBufferNano.readMessage(this.f410884e);
                                    }
                                } else {
                                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                    int position = codedInputByteBufferNano.getPosition();
                                    int i3 = 0;
                                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                        int readInt32 = codedInputByteBufferNano.readInt32();
                                        if (readInt32 == 0 || readInt32 == 1) {
                                            i3++;
                                        }
                                    }
                                    if (i3 != 0) {
                                        codedInputByteBufferNano.rewindToPosition(position);
                                        int[] iArr = this.f410883d;
                                        if (iArr == null) {
                                            length = 0;
                                        } else {
                                            length = iArr.length;
                                        }
                                        int[] iArr2 = new int[i3 + length];
                                        if (length != 0) {
                                            System.arraycopy(iArr, 0, iArr2, 0, length);
                                        }
                                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                            int readInt322 = codedInputByteBufferNano.readInt32();
                                            if (readInt322 == 0 || readInt322 == 1) {
                                                iArr2[length] = readInt322;
                                                length++;
                                            }
                                        }
                                        this.f410883d = iArr2;
                                    }
                                    codedInputByteBufferNano.popLimit(pushLimit);
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                                int[] iArr3 = new int[repeatedFieldArrayLength];
                                int i16 = 0;
                                for (int i17 = 0; i17 < repeatedFieldArrayLength; i17++) {
                                    if (i17 != 0) {
                                        codedInputByteBufferNano.readTag();
                                    }
                                    int readInt323 = codedInputByteBufferNano.readInt32();
                                    if (readInt323 == 0 || readInt323 == 1) {
                                        iArr3[i16] = readInt323;
                                        i16++;
                                    }
                                }
                                if (i16 != 0) {
                                    int[] iArr4 = this.f410883d;
                                    if (iArr4 == null) {
                                        length2 = 0;
                                    } else {
                                        length2 = iArr4.length;
                                    }
                                    if (length2 == 0 && i16 == repeatedFieldArrayLength) {
                                        this.f410883d = iArr3;
                                    } else {
                                        int[] iArr5 = new int[length2 + i16];
                                        if (length2 != 0) {
                                            System.arraycopy(iArr4, 0, iArr5, 0, length2);
                                        }
                                        System.arraycopy(iArr3, 0, iArr5, length2, i16);
                                        this.f410883d = iArr5;
                                    }
                                }
                            }
                        } else {
                            this.f410882c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f410881b = codedInputByteBufferNano.readString();
                    }
                } else {
                    int readInt324 = codedInputByteBufferNano.readInt32();
                    if (readInt324 == 0 || readInt324 == 1) {
                        this.f410880a = readInt324;
                    }
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f410880a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f410881b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f410881b);
        }
        if (!Arrays.equals(this.f410882c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f410882c);
        }
        int[] iArr2 = this.f410883d;
        if (iArr2 != null && iArr2.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                iArr = this.f410883d;
                if (i16 >= iArr.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (iArr.length * 1);
        }
        f fVar = this.f410884e;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, fVar);
        }
        if (!this.f410885f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f410885f);
        }
        if (!this.f410886g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f410886g);
        }
        kr4.a aVar = this.f410887h;
        if (aVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, aVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f410880a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f410881b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f410881b);
        }
        if (!Arrays.equals(this.f410882c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f410882c);
        }
        int[] iArr = this.f410883d;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.f410883d;
                if (i16 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(4, iArr2[i16]);
                i16++;
            }
        }
        f fVar = this.f410884e;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(5, fVar);
        }
        if (!this.f410885f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f410885f);
        }
        if (!this.f410886g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f410886g);
        }
        kr4.a aVar = this.f410887h;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(8, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
