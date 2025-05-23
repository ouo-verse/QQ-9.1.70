package ls4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public f[] f415518a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f415519b;

    /* renamed from: c, reason: collision with root package name */
    public long f415520c;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    public c a() {
        this.f415518a = f.b();
        this.f415519b = false;
        this.f415520c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                f[] fVarArr = this.f415518a;
                int length = fVarArr == null ? 0 : fVarArr.length;
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
                this.f415518a = fVarArr2;
            } else if (readTag == 16) {
                this.f415519b = codedInputByteBufferNano.readBool();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f415520c = codedInputByteBufferNano.readInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        f[] fVarArr = this.f415518a;
        if (fVarArr != null && fVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                f[] fVarArr2 = this.f415518a;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i3];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f415519b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        long j3 = this.f415520c;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        f[] fVarArr = this.f415518a;
        if (fVarArr != null && fVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                f[] fVarArr2 = this.f415518a;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i3];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, fVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f415519b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        long j3 = this.f415520c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
