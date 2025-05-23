package hw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public long[] f406516a;

    /* renamed from: b, reason: collision with root package name */
    public int f406517b;

    public b() {
        a();
    }

    public b a() {
        this.f406516a = WireFormatNano.EMPTY_LONG_ARRAY;
        this.f406517b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                long[] jArr = this.f406516a;
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
                this.f406516a = jArr2;
            } else if (readTag == 10) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.f406516a;
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
                this.f406516a = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f406517b = readInt32;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        long[] jArr2 = this.f406516a;
        if (jArr2 != null && jArr2.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                jArr = this.f406516a;
                if (i3 >= jArr.length) {
                    break;
                }
                i16 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (jArr.length * 1);
        }
        int i17 = this.f406517b;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long[] jArr = this.f406516a;
        if (jArr != null && jArr.length > 0) {
            int i3 = 0;
            while (true) {
                long[] jArr2 = this.f406516a;
                if (i3 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(1, jArr2[i3]);
                i3++;
            }
        }
        int i16 = this.f406517b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
