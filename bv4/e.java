package bv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import uv4.az;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public long[] f29274a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f29275b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f29276c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f29277d;

    /* renamed from: e, reason: collision with root package name */
    public az[] f29278e;

    /* renamed from: f, reason: collision with root package name */
    public long f29279f;

    public e() {
        a();
    }

    public e a() {
        long[] jArr = WireFormatNano.EMPTY_LONG_ARRAY;
        this.f29274a = jArr;
        this.f29275b = jArr;
        this.f29276c = jArr;
        this.f29277d = jArr;
        this.f29278e = az.b();
        this.f29279f = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                    long[] jArr = this.f29274a;
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
                    this.f29274a = jArr2;
                    break;
                case 10:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i16 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i16++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.f29274a;
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
                    this.f29274a = jArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 16:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                    long[] jArr5 = this.f29275b;
                    int length3 = jArr5 == null ? 0 : jArr5.length;
                    int i18 = repeatedFieldArrayLength2 + length3;
                    long[] jArr6 = new long[i18];
                    if (length3 != 0) {
                        System.arraycopy(jArr5, 0, jArr6, 0, length3);
                    }
                    while (length3 < i18 - 1) {
                        jArr6[length3] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    jArr6[length3] = codedInputByteBufferNano.readUInt64();
                    this.f29275b = jArr6;
                    break;
                case 18:
                    int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position2 = codedInputByteBufferNano.getPosition();
                    int i19 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i19++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position2);
                    long[] jArr7 = this.f29275b;
                    int length4 = jArr7 == null ? 0 : jArr7.length;
                    int i26 = i19 + length4;
                    long[] jArr8 = new long[i26];
                    if (length4 != 0) {
                        System.arraycopy(jArr7, 0, jArr8, 0, length4);
                    }
                    while (length4 < i26) {
                        jArr8[length4] = codedInputByteBufferNano.readUInt64();
                        length4++;
                    }
                    this.f29275b = jArr8;
                    codedInputByteBufferNano.popLimit(pushLimit2);
                    break;
                case 24:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                    long[] jArr9 = this.f29276c;
                    int length5 = jArr9 == null ? 0 : jArr9.length;
                    int i27 = repeatedFieldArrayLength3 + length5;
                    long[] jArr10 = new long[i27];
                    if (length5 != 0) {
                        System.arraycopy(jArr9, 0, jArr10, 0, length5);
                    }
                    while (length5 < i27 - 1) {
                        jArr10[length5] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    jArr10[length5] = codedInputByteBufferNano.readUInt64();
                    this.f29276c = jArr10;
                    break;
                case 26:
                    int pushLimit3 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position3 = codedInputByteBufferNano.getPosition();
                    int i28 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i28++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position3);
                    long[] jArr11 = this.f29276c;
                    int length6 = jArr11 == null ? 0 : jArr11.length;
                    int i29 = i28 + length6;
                    long[] jArr12 = new long[i29];
                    if (length6 != 0) {
                        System.arraycopy(jArr11, 0, jArr12, 0, length6);
                    }
                    while (length6 < i29) {
                        jArr12[length6] = codedInputByteBufferNano.readUInt64();
                        length6++;
                    }
                    this.f29276c = jArr12;
                    codedInputByteBufferNano.popLimit(pushLimit3);
                    break;
                case 32:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                    long[] jArr13 = this.f29277d;
                    int length7 = jArr13 == null ? 0 : jArr13.length;
                    int i36 = repeatedFieldArrayLength4 + length7;
                    long[] jArr14 = new long[i36];
                    if (length7 != 0) {
                        System.arraycopy(jArr13, 0, jArr14, 0, length7);
                    }
                    while (length7 < i36 - 1) {
                        jArr14[length7] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length7++;
                    }
                    jArr14[length7] = codedInputByteBufferNano.readUInt64();
                    this.f29277d = jArr14;
                    break;
                case 34:
                    int pushLimit4 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position4 = codedInputByteBufferNano.getPosition();
                    int i37 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i37++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position4);
                    long[] jArr15 = this.f29277d;
                    int length8 = jArr15 == null ? 0 : jArr15.length;
                    int i38 = i37 + length8;
                    long[] jArr16 = new long[i38];
                    if (length8 != 0) {
                        System.arraycopy(jArr15, 0, jArr16, 0, length8);
                    }
                    while (length8 < i38) {
                        jArr16[length8] = codedInputByteBufferNano.readUInt64();
                        length8++;
                    }
                    this.f29277d = jArr16;
                    codedInputByteBufferNano.popLimit(pushLimit4);
                    break;
                case 42:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    az[] azVarArr = this.f29278e;
                    int length9 = azVarArr == null ? 0 : azVarArr.length;
                    int i39 = repeatedFieldArrayLength5 + length9;
                    az[] azVarArr2 = new az[i39];
                    if (length9 != 0) {
                        System.arraycopy(azVarArr, 0, azVarArr2, 0, length9);
                    }
                    while (length9 < i39 - 1) {
                        az azVar = new az();
                        azVarArr2[length9] = azVar;
                        codedInputByteBufferNano.readMessage(azVar);
                        codedInputByteBufferNano.readTag();
                        length9++;
                    }
                    az azVar2 = new az();
                    azVarArr2[length9] = azVar2;
                    codedInputByteBufferNano.readMessage(azVar2);
                    this.f29278e = azVarArr2;
                    break;
                case 48:
                    this.f29279f = codedInputByteBufferNano.readUInt64();
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
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        long[] jArr4;
        int computeSerializedSize = super.computeSerializedSize();
        long[] jArr5 = this.f29274a;
        int i3 = 0;
        if (jArr5 != null && jArr5.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                jArr4 = this.f29274a;
                if (i16 >= jArr4.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr4[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (jArr4.length * 1);
        }
        long[] jArr6 = this.f29275b;
        if (jArr6 != null && jArr6.length > 0) {
            int i18 = 0;
            int i19 = 0;
            while (true) {
                jArr3 = this.f29275b;
                if (i18 >= jArr3.length) {
                    break;
                }
                i19 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr3[i18]);
                i18++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (jArr3.length * 1);
        }
        long[] jArr7 = this.f29276c;
        if (jArr7 != null && jArr7.length > 0) {
            int i26 = 0;
            int i27 = 0;
            while (true) {
                jArr2 = this.f29276c;
                if (i26 >= jArr2.length) {
                    break;
                }
                i27 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i26]);
                i26++;
            }
            computeSerializedSize = computeSerializedSize + i27 + (jArr2.length * 1);
        }
        long[] jArr8 = this.f29277d;
        if (jArr8 != null && jArr8.length > 0) {
            int i28 = 0;
            int i29 = 0;
            while (true) {
                jArr = this.f29277d;
                if (i28 >= jArr.length) {
                    break;
                }
                i29 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i28]);
                i28++;
            }
            computeSerializedSize = computeSerializedSize + i29 + (jArr.length * 1);
        }
        az[] azVarArr = this.f29278e;
        if (azVarArr != null && azVarArr.length > 0) {
            while (true) {
                az[] azVarArr2 = this.f29278e;
                if (i3 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i3];
                if (azVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, azVar);
                }
                i3++;
            }
        }
        long j3 = this.f29279f;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long[] jArr = this.f29274a;
        int i3 = 0;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.f29274a;
                if (i16 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(1, jArr2[i16]);
                i16++;
            }
        }
        long[] jArr3 = this.f29275b;
        if (jArr3 != null && jArr3.length > 0) {
            int i17 = 0;
            while (true) {
                long[] jArr4 = this.f29275b;
                if (i17 >= jArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(2, jArr4[i17]);
                i17++;
            }
        }
        long[] jArr5 = this.f29276c;
        if (jArr5 != null && jArr5.length > 0) {
            int i18 = 0;
            while (true) {
                long[] jArr6 = this.f29276c;
                if (i18 >= jArr6.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(3, jArr6[i18]);
                i18++;
            }
        }
        long[] jArr7 = this.f29277d;
        if (jArr7 != null && jArr7.length > 0) {
            int i19 = 0;
            while (true) {
                long[] jArr8 = this.f29277d;
                if (i19 >= jArr8.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(4, jArr8[i19]);
                i19++;
            }
        }
        az[] azVarArr = this.f29278e;
        if (azVarArr != null && azVarArr.length > 0) {
            while (true) {
                az[] azVarArr2 = this.f29278e;
                if (i3 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i3];
                if (azVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, azVar);
                }
                i3++;
            }
        }
        long j3 = this.f29279f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
