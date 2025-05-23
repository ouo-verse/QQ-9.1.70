package pt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: a, reason: collision with root package name */
    public long f427182a;

    /* renamed from: b, reason: collision with root package name */
    public int f427183b;

    /* renamed from: c, reason: collision with root package name */
    public int f427184c;

    /* renamed from: d, reason: collision with root package name */
    public long f427185d;

    /* renamed from: e, reason: collision with root package name */
    public q f427186e;

    /* renamed from: f, reason: collision with root package name */
    public long[] f427187f;

    /* renamed from: g, reason: collision with root package name */
    public int f427188g;

    /* renamed from: h, reason: collision with root package name */
    public int f427189h;

    public m() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427182a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f427183b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f427184c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f427185d = codedInputByteBufferNano.readInt64();
            } else if (readTag == 42) {
                if (this.f427186e == null) {
                    this.f427186e = new q();
                }
                codedInputByteBufferNano.readMessage(this.f427186e);
            } else if (readTag == 48) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 48);
                long[] jArr = this.f427187f;
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
                this.f427187f = jArr2;
            } else if (readTag == 50) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.f427187f;
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
                this.f427187f = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 56) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f427188g = readInt32;
                }
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427189h = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f427182a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f427183b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f427184c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        long j16 = this.f427185d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j16);
        }
        q qVar = this.f427186e;
        if (qVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, qVar);
        }
        long[] jArr2 = this.f427187f;
        if (jArr2 != null && jArr2.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                jArr = this.f427187f;
                if (i17 >= jArr.length) {
                    break;
                }
                i18 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i17]);
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (jArr.length * 1);
        }
        int i19 = this.f427188g;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i19);
        }
        int i26 = this.f427189h;
        return i26 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(8, i26) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f427182a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f427183b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f427184c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        long j16 = this.f427185d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j16);
        }
        q qVar = this.f427186e;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(5, qVar);
        }
        long[] jArr = this.f427187f;
        if (jArr != null && jArr.length > 0) {
            int i17 = 0;
            while (true) {
                long[] jArr2 = this.f427187f;
                if (i17 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(6, jArr2[i17]);
                i17++;
            }
        }
        int i18 = this.f427188g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i18);
        }
        int i19 = this.f427189h;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public m a() {
        this.f427182a = 0L;
        this.f427183b = 0;
        this.f427184c = 0;
        this.f427185d = 0L;
        this.f427186e = null;
        this.f427187f = WireFormatNano.EMPTY_LONG_ARRAY;
        this.f427188g = 0;
        this.f427189h = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
