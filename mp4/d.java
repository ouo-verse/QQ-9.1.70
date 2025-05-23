package mp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f417145a;

    /* renamed from: b, reason: collision with root package name */
    public String f417146b;

    /* renamed from: c, reason: collision with root package name */
    public f[] f417147c;

    /* renamed from: d, reason: collision with root package name */
    public a[] f417148d;

    /* renamed from: e, reason: collision with root package name */
    public e f417149e;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f417145a = false;
        this.f417146b = "";
        this.f417147c = f.b();
        this.f417148d = a.b();
        this.f417149e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    if (this.f417149e == null) {
                                        this.f417149e = new e();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f417149e);
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                a[] aVarArr = this.f417148d;
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
                                this.f417148d = aVarArr2;
                            }
                        } else {
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            f[] fVarArr = this.f417147c;
                            if (fVarArr == null) {
                                length2 = 0;
                            } else {
                                length2 = fVarArr.length;
                            }
                            int i16 = repeatedFieldArrayLength2 + length2;
                            f[] fVarArr2 = new f[i16];
                            if (length2 != 0) {
                                System.arraycopy(fVarArr, 0, fVarArr2, 0, length2);
                            }
                            while (length2 < i16 - 1) {
                                f fVar = new f();
                                fVarArr2[length2] = fVar;
                                codedInputByteBufferNano.readMessage(fVar);
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            f fVar2 = new f();
                            fVarArr2[length2] = fVar2;
                            codedInputByteBufferNano.readMessage(fVar2);
                            this.f417147c = fVarArr2;
                        }
                    } else {
                        this.f417146b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f417145a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f417145a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        if (!this.f417146b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f417146b);
        }
        f[] fVarArr = this.f417147c;
        int i3 = 0;
        if (fVarArr != null && fVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                f[] fVarArr2 = this.f417147c;
                if (i16 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i16];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, fVar);
                }
                i16++;
            }
        }
        a[] aVarArr = this.f417148d;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f417148d;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar);
                }
                i3++;
            }
        }
        e eVar = this.f417149e;
        if (eVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, eVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f417145a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        if (!this.f417146b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f417146b);
        }
        f[] fVarArr = this.f417147c;
        int i3 = 0;
        if (fVarArr != null && fVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                f[] fVarArr2 = this.f417147c;
                if (i16 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i16];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, fVar);
                }
                i16++;
            }
        }
        a[] aVarArr = this.f417148d;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f417148d;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, aVar);
                }
                i3++;
            }
        }
        e eVar = this.f417149e;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(5, eVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
