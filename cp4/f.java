package cp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public i[] f391591a;

    /* renamed from: b, reason: collision with root package name */
    public long f391592b;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f391591a = i.b();
        this.f391592b = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f391592b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    i[] iVarArr = this.f391591a;
                    if (iVarArr == null) {
                        length = 0;
                    } else {
                        length = iVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    i[] iVarArr2 = new i[i3];
                    if (length != 0) {
                        System.arraycopy(iVarArr, 0, iVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        i iVar = new i();
                        iVarArr2[length] = iVar;
                        codedInputByteBufferNano.readMessage(iVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    i iVar2 = new i();
                    iVarArr2[length] = iVar2;
                    codedInputByteBufferNano.readMessage(iVar2);
                    this.f391591a = iVarArr2;
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
        i[] iVarArr = this.f391591a;
        if (iVarArr != null && iVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                i[] iVarArr2 = this.f391591a;
                if (i3 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i3];
                if (iVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, iVar);
                }
                i3++;
            }
        }
        long j3 = this.f391592b;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        i[] iVarArr = this.f391591a;
        if (iVarArr != null && iVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                i[] iVarArr2 = this.f391591a;
                if (i3 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i3];
                if (iVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, iVar);
                }
                i3++;
            }
        }
        long j3 = this.f391592b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
