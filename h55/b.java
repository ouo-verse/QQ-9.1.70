package h55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f404401a;

    /* renamed from: b, reason: collision with root package name */
    public d f404402b;

    /* renamed from: c, reason: collision with root package name */
    public long f404403c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f404404d;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f404401a = 0;
        this.f404402b = null;
        this.f404403c = 0L;
        this.f404404d = WireFormatNano.EMPTY_LONG_ARRAY;
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
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 34) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                    int position = codedInputByteBufferNano.getPosition();
                                    int i3 = 0;
                                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                        codedInputByteBufferNano.readUInt64();
                                        i3++;
                                    }
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    long[] jArr = this.f404404d;
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
                                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                                        length++;
                                    }
                                    this.f404404d = jArr2;
                                    codedInputByteBufferNano.popLimit(pushLimit);
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                                long[] jArr3 = this.f404404d;
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
                                    jArr4[length2] = codedInputByteBufferNano.readUInt64();
                                    codedInputByteBufferNano.readTag();
                                    length2++;
                                }
                                jArr4[length2] = codedInputByteBufferNano.readUInt64();
                                this.f404404d = jArr4;
                            }
                        } else {
                            this.f404403c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        if (this.f404402b == null) {
                            this.f404402b = new d();
                        }
                        codedInputByteBufferNano.readMessage(this.f404402b);
                    }
                } else {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                        this.f404401a = readInt32;
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
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f404401a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        d dVar = this.f404402b;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
        }
        long j3 = this.f404403c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        long[] jArr = this.f404404d;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                long[] jArr2 = this.f404404d;
                if (i16 < jArr2.length) {
                    i17 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i16]);
                    i16++;
                } else {
                    return computeSerializedSize + i17 + (jArr2.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f404401a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        d dVar = this.f404402b;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(2, dVar);
        }
        long j3 = this.f404403c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        long[] jArr = this.f404404d;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.f404404d;
                if (i16 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(4, jArr2[i16]);
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
