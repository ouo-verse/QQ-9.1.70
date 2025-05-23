package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public int f406413a;

    /* renamed from: b, reason: collision with root package name */
    public vu4.d[] f406414b;

    /* renamed from: c, reason: collision with root package name */
    public k f406415c;

    public e() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f406413a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                vu4.d[] dVarArr = this.f406414b;
                int length = dVarArr == null ? 0 : dVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                vu4.d[] dVarArr2 = new vu4.d[i3];
                if (length != 0) {
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    vu4.d dVar = new vu4.d();
                    dVarArr2[length] = dVar;
                    codedInputByteBufferNano.readMessage(dVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                vu4.d dVar2 = new vu4.d();
                dVarArr2[length] = dVar2;
                codedInputByteBufferNano.readMessage(dVar2);
                this.f406414b = dVarArr2;
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f406415c == null) {
                    this.f406415c = new k();
                }
                codedInputByteBufferNano.readMessage(this.f406415c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f406413a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        vu4.d[] dVarArr = this.f406414b;
        if (dVarArr != null && dVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                vu4.d[] dVarArr2 = this.f406414b;
                if (i16 >= dVarArr2.length) {
                    break;
                }
                vu4.d dVar = dVarArr2[i16];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
                }
                i16++;
            }
        }
        k kVar = this.f406415c;
        return kVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, kVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f406413a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        vu4.d[] dVarArr = this.f406414b;
        if (dVarArr != null && dVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                vu4.d[] dVarArr2 = this.f406414b;
                if (i16 >= dVarArr2.length) {
                    break;
                }
                vu4.d dVar = dVarArr2[i16];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, dVar);
                }
                i16++;
            }
        }
        k kVar = this.f406415c;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(3, kVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f406413a = 0;
        this.f406414b = vu4.d.b();
        this.f406415c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
