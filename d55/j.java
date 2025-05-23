package d55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public a[] f393088a;

    /* renamed from: b, reason: collision with root package name */
    public long f393089b;

    /* renamed from: c, reason: collision with root package name */
    public g f393090c;

    /* renamed from: d, reason: collision with root package name */
    public int f393091d;

    /* renamed from: e, reason: collision with root package name */
    public long f393092e;

    /* renamed from: f, reason: collision with root package name */
    public int f393093f;

    public j() {
        a();
    }

    public static j c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (j) MessageNano.mergeFrom(new j(), bArr);
    }

    public j a() {
        this.f393088a = a.b();
        this.f393089b = 0L;
        this.f393090c = null;
        this.f393091d = 0;
        this.f393092e = 0L;
        this.f393093f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f393093f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f393092e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f393091d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            if (this.f393090c == null) {
                                this.f393090c = new g();
                            }
                            codedInputByteBufferNano.readMessage(this.f393090c);
                        }
                    } else {
                        this.f393089b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    a[] aVarArr = this.f393088a;
                    if (aVarArr == null) {
                        length = 0;
                    } else {
                        length = aVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    a[] aVarArr2 = new a[i3];
                    if (length != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        a aVar = new a();
                        aVarArr2[length] = aVar;
                        codedInputByteBufferNano.readMessage(aVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    a aVar2 = new a();
                    aVarArr2[length] = aVar2;
                    codedInputByteBufferNano.readMessage(aVar2);
                    this.f393088a = aVarArr2;
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
        a[] aVarArr = this.f393088a;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.f393088a;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
                }
                i3++;
            }
        }
        long j3 = this.f393089b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        g gVar = this.f393090c;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gVar);
        }
        int i16 = this.f393091d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i16);
        }
        long j16 = this.f393092e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        int i17 = this.f393093f;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a[] aVarArr = this.f393088a;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.f393088a;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, aVar);
                }
                i3++;
            }
        }
        long j3 = this.f393089b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        g gVar = this.f393090c;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(3, gVar);
        }
        int i16 = this.f393091d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        long j16 = this.f393092e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        int i17 = this.f393093f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
