package ot3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String[] f424021a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f424022b;

    /* renamed from: c, reason: collision with root package name */
    public long f424023c;

    /* renamed from: d, reason: collision with root package name */
    public long f424024d;

    /* renamed from: e, reason: collision with root package name */
    public long f424025e;

    /* renamed from: f, reason: collision with root package name */
    public int f424026f;

    /* renamed from: g, reason: collision with root package name */
    public long f424027g;

    /* renamed from: h, reason: collision with root package name */
    public String f424028h;

    public d() {
        a();
    }

    public d a() {
        this.f424021a = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f424022b = WireFormatNano.EMPTY_INT_ARRAY;
        this.f424023c = 0L;
        this.f424024d = 0L;
        this.f424025e = 0L;
        this.f424026f = 0;
        this.f424027g = 0L;
        this.f424028h = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 18) {
                            if (readTag != 24) {
                                if (readTag != 32) {
                                    if (readTag != 40) {
                                        if (readTag != 48) {
                                            if (readTag != 56) {
                                                if (readTag != 66) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f424028h = codedInputByteBufferNano.readString();
                                                }
                                            } else {
                                                this.f424027g = codedInputByteBufferNano.readInt64();
                                            }
                                        } else {
                                            this.f424026f = codedInputByteBufferNano.readInt32();
                                        }
                                    } else {
                                        this.f424025e = codedInputByteBufferNano.readInt64();
                                    }
                                } else {
                                    this.f424024d = codedInputByteBufferNano.readInt64();
                                }
                            } else {
                                this.f424023c = codedInputByteBufferNano.readInt64();
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
                            int[] iArr = this.f424022b;
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
                            this.f424022b = iArr2;
                            codedInputByteBufferNano.popLimit(pushLimit);
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                        int[] iArr3 = this.f424022b;
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
                        this.f424022b = iArr4;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    String[] strArr = this.f424021a;
                    if (strArr == null) {
                        length3 = 0;
                    } else {
                        length3 = strArr.length;
                    }
                    int i18 = repeatedFieldArrayLength2 + length3;
                    String[] strArr2 = new String[i18];
                    if (length3 != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length3);
                    }
                    while (length3 < i18 - 1) {
                        strArr2[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr2[length3] = codedInputByteBufferNano.readString();
                    this.f424021a = strArr2;
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
        String[] strArr = this.f424021a;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f424021a;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    i18++;
                    i17 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (i18 * 1);
        }
        int[] iArr2 = this.f424022b;
        if (iArr2 != null && iArr2.length > 0) {
            int i19 = 0;
            while (true) {
                iArr = this.f424022b;
                if (i3 >= iArr.length) {
                    break;
                }
                i19 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (iArr.length * 1);
        }
        long j3 = this.f424023c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j3);
        }
        long j16 = this.f424024d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j16);
        }
        long j17 = this.f424025e;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j17);
        }
        int i26 = this.f424026f;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i26);
        }
        long j18 = this.f424027g;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j18);
        }
        if (!this.f424028h.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.f424028h);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        String[] strArr = this.f424021a;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f424021a;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                i16++;
            }
        }
        int[] iArr = this.f424022b;
        if (iArr != null && iArr.length > 0) {
            while (true) {
                int[] iArr2 = this.f424022b;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(2, iArr2[i3]);
                i3++;
            }
        }
        long j3 = this.f424023c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        long j16 = this.f424024d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j16);
        }
        long j17 = this.f424025e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j17);
        }
        int i17 = this.f424026f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        long j18 = this.f424027g;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j18);
        }
        if (!this.f424028h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f424028h);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
