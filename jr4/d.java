package jr4;

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
    public int f410890a;

    /* renamed from: b, reason: collision with root package name */
    public kr4.c[] f410891b;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f410890a = 0;
        this.f410891b = kr4.c.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        kr4.c[] cVarArr = this.f410891b;
                        if (cVarArr == null) {
                            length = 0;
                        } else {
                            length = cVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        kr4.c[] cVarArr2 = new kr4.c[i3];
                        if (length != 0) {
                            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            kr4.c cVar = new kr4.c();
                            cVarArr2[length] = cVar;
                            codedInputByteBufferNano.readMessage(cVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        kr4.c cVar2 = new kr4.c();
                        cVarArr2[length] = cVar2;
                        codedInputByteBufferNano.readMessage(cVar2);
                        this.f410891b = cVarArr2;
                    }
                } else {
                    this.f410890a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f410890a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        kr4.c[] cVarArr = this.f410891b;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                kr4.c[] cVarArr2 = this.f410891b;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                kr4.c cVar = cVarArr2[i16];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f410890a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        kr4.c[] cVarArr = this.f410891b;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                kr4.c[] cVarArr2 = this.f410891b;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                kr4.c cVar = cVarArr2[i16];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, cVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
