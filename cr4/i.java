package cr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public l[] f391758a;

    /* renamed from: b, reason: collision with root package name */
    public long f391759b;

    /* renamed from: c, reason: collision with root package name */
    public String f391760c;

    public i() {
        a();
    }

    public static i c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (i) MessageNano.mergeFrom(new i(), bArr);
    }

    public i a() {
        this.f391758a = l.b();
        this.f391759b = 0L;
        this.f391760c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f391760c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f391759b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    l[] lVarArr = this.f391758a;
                    if (lVarArr == null) {
                        length = 0;
                    } else {
                        length = lVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    l[] lVarArr2 = new l[i3];
                    if (length != 0) {
                        System.arraycopy(lVarArr, 0, lVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        l lVar = new l();
                        lVarArr2[length] = lVar;
                        codedInputByteBufferNano.readMessage(lVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    l lVar2 = new l();
                    lVarArr2[length] = lVar2;
                    codedInputByteBufferNano.readMessage(lVar2);
                    this.f391758a = lVarArr2;
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
        l[] lVarArr = this.f391758a;
        if (lVarArr != null && lVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                l[] lVarArr2 = this.f391758a;
                if (i3 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i3];
                if (lVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, lVar);
                }
                i3++;
            }
        }
        long j3 = this.f391759b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!this.f391760c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f391760c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        l[] lVarArr = this.f391758a;
        if (lVarArr != null && lVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                l[] lVarArr2 = this.f391758a;
                if (i3 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i3];
                if (lVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, lVar);
                }
                i3++;
            }
        }
        long j3 = this.f391759b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!this.f391760c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f391760c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
