package gx4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile h[] f403773e;

    /* renamed from: a, reason: collision with root package name */
    public int f403774a;

    /* renamed from: b, reason: collision with root package name */
    public int f403775b;

    /* renamed from: c, reason: collision with root package name */
    public long f403776c;

    /* renamed from: d, reason: collision with root package name */
    public f[] f403777d;

    public h() {
        a();
    }

    public static h[] b() {
        if (f403773e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403773e == null) {
                    f403773e = new h[0];
                }
            }
        }
        return f403773e;
    }

    public h a() {
        this.f403774a = 0;
        this.f403775b = 0;
        this.f403776c = 0L;
        this.f403777d = f.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                f[] fVarArr = this.f403777d;
                                if (fVarArr == null) {
                                    length = 0;
                                } else {
                                    length = fVarArr.length;
                                }
                                int i3 = repeatedFieldArrayLength + length;
                                f[] fVarArr2 = new f[i3];
                                if (length != 0) {
                                    System.arraycopy(fVarArr, 0, fVarArr2, 0, length);
                                }
                                while (length < i3 - 1) {
                                    f fVar = new f();
                                    fVarArr2[length] = fVar;
                                    codedInputByteBufferNano.readMessage(fVar);
                                    codedInputByteBufferNano.readTag();
                                    length++;
                                }
                                f fVar2 = new f();
                                fVarArr2[length] = fVar2;
                                codedInputByteBufferNano.readMessage(fVar2);
                                this.f403777d = fVarArr2;
                            }
                        } else {
                            this.f403776c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f403775b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f403774a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f403774a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f403775b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        long j3 = this.f403776c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        f[] fVarArr = this.f403777d;
        if (fVarArr != null && fVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                f[] fVarArr2 = this.f403777d;
                if (i17 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i17];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, fVar);
                }
                i17++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403774a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f403775b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        long j3 = this.f403776c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        f[] fVarArr = this.f403777d;
        if (fVarArr != null && fVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                f[] fVarArr2 = this.f403777d;
                if (i17 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i17];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, fVar);
                }
                i17++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
