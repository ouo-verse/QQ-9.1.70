package ez0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public long f397456a;

    /* renamed from: b, reason: collision with root package name */
    public bz0.c[] f397457b;

    /* renamed from: c, reason: collision with root package name */
    public bz0.c[] f397458c;

    /* renamed from: d, reason: collision with root package name */
    public int f397459d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f397460e;

    /* renamed from: f, reason: collision with root package name */
    public long f397461f;

    /* renamed from: g, reason: collision with root package name */
    public long f397462g;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    public c a() {
        this.f397456a = 0L;
        this.f397457b = bz0.c.b();
        this.f397458c = bz0.c.b();
        this.f397459d = 0;
        this.f397460e = WireFormatNano.EMPTY_BYTES;
        this.f397461f = 0L;
        this.f397462g = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f397462g = codedInputByteBufferNano.readUInt64();
                                        }
                                    } else {
                                        this.f397461f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f397460e = codedInputByteBufferNano.readBytes();
                                }
                            } else {
                                this.f397459d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            bz0.c[] cVarArr = this.f397458c;
                            if (cVarArr == null) {
                                length = 0;
                            } else {
                                length = cVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            bz0.c[] cVarArr2 = new bz0.c[i3];
                            if (length != 0) {
                                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                bz0.c cVar = new bz0.c();
                                cVarArr2[length] = cVar;
                                codedInputByteBufferNano.readMessage(cVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            bz0.c cVar2 = new bz0.c();
                            cVarArr2[length] = cVar2;
                            codedInputByteBufferNano.readMessage(cVar2);
                            this.f397458c = cVarArr2;
                        }
                    } else {
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        bz0.c[] cVarArr3 = this.f397457b;
                        if (cVarArr3 == null) {
                            length2 = 0;
                        } else {
                            length2 = cVarArr3.length;
                        }
                        int i16 = repeatedFieldArrayLength2 + length2;
                        bz0.c[] cVarArr4 = new bz0.c[i16];
                        if (length2 != 0) {
                            System.arraycopy(cVarArr3, 0, cVarArr4, 0, length2);
                        }
                        while (length2 < i16 - 1) {
                            bz0.c cVar3 = new bz0.c();
                            cVarArr4[length2] = cVar3;
                            codedInputByteBufferNano.readMessage(cVar3);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        bz0.c cVar4 = new bz0.c();
                        cVarArr4[length2] = cVar4;
                        codedInputByteBufferNano.readMessage(cVar4);
                        this.f397457b = cVarArr4;
                    }
                } else {
                    this.f397456a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f397456a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        bz0.c[] cVarArr = this.f397457b;
        int i3 = 0;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bz0.c[] cVarArr2 = this.f397457b;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                bz0.c cVar = cVarArr2[i16];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cVar);
                }
                i16++;
            }
        }
        bz0.c[] cVarArr3 = this.f397458c;
        if (cVarArr3 != null && cVarArr3.length > 0) {
            while (true) {
                bz0.c[] cVarArr4 = this.f397458c;
                if (i3 >= cVarArr4.length) {
                    break;
                }
                bz0.c cVar2 = cVarArr4[i3];
                if (cVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar2);
                }
                i3++;
            }
        }
        int i17 = this.f397459d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        if (!Arrays.equals(this.f397460e, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f397460e);
        }
        long j16 = this.f397461f;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        long j17 = this.f397462g;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f397456a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        bz0.c[] cVarArr = this.f397457b;
        int i3 = 0;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bz0.c[] cVarArr2 = this.f397457b;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                bz0.c cVar = cVarArr2[i16];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, cVar);
                }
                i16++;
            }
        }
        bz0.c[] cVarArr3 = this.f397458c;
        if (cVarArr3 != null && cVarArr3.length > 0) {
            while (true) {
                bz0.c[] cVarArr4 = this.f397458c;
                if (i3 >= cVarArr4.length) {
                    break;
                }
                bz0.c cVar2 = cVarArr4[i3];
                if (cVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(3, cVar2);
                }
                i3++;
            }
        }
        int i17 = this.f397459d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        if (!Arrays.equals(this.f397460e, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.f397460e);
        }
        long j16 = this.f397461f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        long j17 = this.f397462g;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
