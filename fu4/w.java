package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class w extends ExtendableMessageNano<w> {

    /* renamed from: a, reason: collision with root package name */
    public z[] f400825a;

    /* renamed from: b, reason: collision with root package name */
    public r f400826b;

    public w() {
        a();
    }

    public w a() {
        this.f400825a = z.b();
        this.f400826b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.f400826b == null) {
                            this.f400826b = new r();
                        }
                        codedInputByteBufferNano.readMessage(this.f400826b);
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    z[] zVarArr = this.f400825a;
                    if (zVarArr == null) {
                        length = 0;
                    } else {
                        length = zVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    z[] zVarArr2 = new z[i3];
                    if (length != 0) {
                        System.arraycopy(zVarArr, 0, zVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        z zVar = new z();
                        zVarArr2[length] = zVar;
                        codedInputByteBufferNano.readMessage(zVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    z zVar2 = new z();
                    zVarArr2[length] = zVar2;
                    codedInputByteBufferNano.readMessage(zVar2);
                    this.f400825a = zVarArr2;
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
        z[] zVarArr = this.f400825a;
        if (zVarArr != null && zVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                z[] zVarArr2 = this.f400825a;
                if (i3 >= zVarArr2.length) {
                    break;
                }
                z zVar = zVarArr2[i3];
                if (zVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, zVar);
                }
                i3++;
            }
        }
        r rVar = this.f400826b;
        if (rVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, rVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        z[] zVarArr = this.f400825a;
        if (zVarArr != null && zVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                z[] zVarArr2 = this.f400825a;
                if (i3 >= zVarArr2.length) {
                    break;
                }
                z zVar = zVarArr2[i3];
                if (zVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, zVar);
                }
                i3++;
            }
        }
        r rVar = this.f400826b;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(2, rVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
