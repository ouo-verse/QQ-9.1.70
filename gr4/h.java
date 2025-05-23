package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public int f403126a;

    /* renamed from: b, reason: collision with root package name */
    public String f403127b;

    /* renamed from: c, reason: collision with root package name */
    public rq4.a[] f403128c;

    public h() {
        a();
    }

    public static h c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (h) MessageNano.mergeFrom(new h(), bArr);
    }

    public h a() {
        this.f403126a = 0;
        this.f403127b = "";
        this.f403128c = rq4.a.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            rq4.a[] aVarArr = this.f403128c;
                            if (aVarArr == null) {
                                length = 0;
                            } else {
                                length = aVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            rq4.a[] aVarArr2 = new rq4.a[i3];
                            if (length != 0) {
                                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                rq4.a aVar = new rq4.a();
                                aVarArr2[length] = aVar;
                                codedInputByteBufferNano.readMessage(aVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            rq4.a aVar2 = new rq4.a();
                            aVarArr2[length] = aVar2;
                            codedInputByteBufferNano.readMessage(aVar2);
                            this.f403128c = aVarArr2;
                        }
                    } else {
                        this.f403127b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f403126a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f403126a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f403127b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403127b);
        }
        rq4.a[] aVarArr = this.f403128c;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                rq4.a[] aVarArr2 = this.f403128c;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                rq4.a aVar = aVarArr2[i16];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403126a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f403127b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403127b);
        }
        rq4.a[] aVarArr = this.f403128c;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                rq4.a[] aVarArr2 = this.f403128c;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                rq4.a aVar = aVarArr2[i16];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, aVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
