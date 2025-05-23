package at4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f26929a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f26930b;

    /* renamed from: c, reason: collision with root package name */
    public f[] f26931c;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    public e a() {
        this.f26929a = WireFormatNano.EMPTY_BYTES;
        this.f26930b = false;
        this.f26931c = f.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f26929a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 16) {
                this.f26930b = codedInputByteBufferNano.readBool();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                f[] fVarArr = this.f26931c;
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
                this.f26931c = fVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!Arrays.equals(this.f26929a, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f26929a);
        }
        boolean z16 = this.f26930b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        f[] fVarArr = this.f26931c;
        if (fVarArr != null && fVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                f[] fVarArr2 = this.f26931c;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i3];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, fVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f26929a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f26929a);
        }
        boolean z16 = this.f26930b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        f[] fVarArr = this.f26931c;
        if (fVarArr != null && fVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                f[] fVarArr2 = this.f26931c;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i3];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, fVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
