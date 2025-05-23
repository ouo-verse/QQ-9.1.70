package ps4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import ds4.i;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f427086a;

    /* renamed from: b, reason: collision with root package name */
    public int f427087b;

    /* renamed from: c, reason: collision with root package name */
    public i[] f427088c;

    /* renamed from: d, reason: collision with root package name */
    public long f427089d;

    public b() {
        a();
    }

    public b a() {
        this.f427086a = WireFormatNano.EMPTY_BYTES;
        this.f427087b = 0;
        this.f427088c = i.b();
        this.f427089d = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f427086a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 16) {
                this.f427087b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                i[] iVarArr = this.f427088c;
                int length = iVarArr == null ? 0 : iVarArr.length;
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
                this.f427088c = iVarArr2;
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427089d = codedInputByteBufferNano.readInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!Arrays.equals(this.f427086a, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f427086a);
        }
        int i3 = this.f427087b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        i[] iVarArr = this.f427088c;
        if (iVarArr != null && iVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                i[] iVarArr2 = this.f427088c;
                if (i16 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i16];
                if (iVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, iVar);
                }
                i16++;
            }
        }
        long j3 = this.f427089d;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f427086a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f427086a);
        }
        int i3 = this.f427087b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        i[] iVarArr = this.f427088c;
        if (iVarArr != null && iVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                i[] iVarArr2 = this.f427088c;
                if (i16 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i16];
                if (iVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, iVar);
                }
                i16++;
            }
        }
        long j3 = this.f427089d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
