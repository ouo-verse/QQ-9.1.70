package pt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public int f427179a;

    /* renamed from: b, reason: collision with root package name */
    public o[] f427180b;

    /* renamed from: c, reason: collision with root package name */
    public long f427181c;

    public l() {
        a();
    }

    public static l c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (l) MessageNano.mergeFrom(new l(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427179a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                o[] oVarArr = this.f427180b;
                int length = oVarArr == null ? 0 : oVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                o[] oVarArr2 = new o[i3];
                if (length != 0) {
                    System.arraycopy(oVarArr, 0, oVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    o oVar = new o();
                    oVarArr2[length] = oVar;
                    codedInputByteBufferNano.readMessage(oVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                o oVar2 = new o();
                oVarArr2[length] = oVar2;
                codedInputByteBufferNano.readMessage(oVar2);
                this.f427180b = oVarArr2;
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427181c = codedInputByteBufferNano.readInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f427179a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        o[] oVarArr = this.f427180b;
        if (oVarArr != null && oVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                o[] oVarArr2 = this.f427180b;
                if (i16 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i16];
                if (oVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, oVar);
                }
                i16++;
            }
        }
        long j3 = this.f427181c;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427179a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        o[] oVarArr = this.f427180b;
        if (oVarArr != null && oVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                o[] oVarArr2 = this.f427180b;
                if (i16 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i16];
                if (oVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, oVar);
                }
                i16++;
            }
        }
        long j3 = this.f427181c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public l a() {
        this.f427179a = 0;
        this.f427180b = o.b();
        this.f427181c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
