package ct4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import gs4.o;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f391837a;

    /* renamed from: b, reason: collision with root package name */
    public int f391838b;

    /* renamed from: c, reason: collision with root package name */
    public o[] f391839c;

    /* renamed from: d, reason: collision with root package name */
    public long f391840d;

    public b() {
        a();
    }

    public b a() {
        this.f391837a = WireFormatNano.EMPTY_BYTES;
        this.f391838b = 0;
        this.f391839c = o.b();
        this.f391840d = 0L;
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
                this.f391837a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 16) {
                this.f391838b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                o[] oVarArr = this.f391839c;
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
                this.f391839c = oVarArr2;
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f391840d = codedInputByteBufferNano.readInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!Arrays.equals(this.f391837a, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f391837a);
        }
        int i3 = this.f391838b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        o[] oVarArr = this.f391839c;
        if (oVarArr != null && oVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                o[] oVarArr2 = this.f391839c;
                if (i16 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i16];
                if (oVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, oVar);
                }
                i16++;
            }
        }
        long j3 = this.f391840d;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f391837a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f391837a);
        }
        int i3 = this.f391838b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        o[] oVarArr = this.f391839c;
        if (oVarArr != null && oVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                o[] oVarArr2 = this.f391839c;
                if (i16 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i16];
                if (oVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, oVar);
                }
                i16++;
            }
        }
        long j3 = this.f391840d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
