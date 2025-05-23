package kp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long[] f412845a;

    public a() {
        a();
    }

    public a a() {
        this.f412845a = WireFormatNano.EMPTY_LONG_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 10) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int i3 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt64();
                            i3++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        long[] jArr = this.f412845a;
                        if (jArr == null) {
                            length = 0;
                        } else {
                            length = jArr.length;
                        }
                        int i16 = i3 + length;
                        long[] jArr2 = new long[i16];
                        if (length != 0) {
                            System.arraycopy(jArr, 0, jArr2, 0, length);
                        }
                        while (length < i16) {
                            jArr2[length] = codedInputByteBufferNano.readInt64();
                            length++;
                        }
                        this.f412845a = jArr2;
                        codedInputByteBufferNano.popLimit(pushLimit);
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                    long[] jArr3 = this.f412845a;
                    if (jArr3 == null) {
                        length2 = 0;
                    } else {
                        length2 = jArr3.length;
                    }
                    int i17 = repeatedFieldArrayLength + length2;
                    long[] jArr4 = new long[i17];
                    if (length2 != 0) {
                        System.arraycopy(jArr3, 0, jArr4, 0, length2);
                    }
                    while (length2 < i17 - 1) {
                        jArr4[length2] = codedInputByteBufferNano.readInt64();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    jArr4[length2] = codedInputByteBufferNano.readInt64();
                    this.f412845a = jArr4;
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
        long[] jArr = this.f412845a;
        if (jArr != null && jArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.f412845a;
                if (i3 < jArr2.length) {
                    i16 += CodedOutputByteBufferNano.computeInt64SizeNoTag(jArr2[i3]);
                    i3++;
                } else {
                    return computeSerializedSize + i16 + (jArr2.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long[] jArr = this.f412845a;
        if (jArr != null && jArr.length > 0) {
            int i3 = 0;
            while (true) {
                long[] jArr2 = this.f412845a;
                if (i3 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt64(1, jArr2[i3]);
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
