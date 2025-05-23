package fv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public c f400873a;

    /* renamed from: b, reason: collision with root package name */
    public d[] f400874b;

    public e() {
        a();
    }

    public e a() {
        this.f400873a = null;
        this.f400874b = d.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        d[] dVarArr = this.f400874b;
                        if (dVarArr == null) {
                            length = 0;
                        } else {
                            length = dVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        d[] dVarArr2 = new d[i3];
                        if (length != 0) {
                            System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            d dVar = new d();
                            dVarArr2[length] = dVar;
                            codedInputByteBufferNano.readMessage(dVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        d dVar2 = new d();
                        dVarArr2[length] = dVar2;
                        codedInputByteBufferNano.readMessage(dVar2);
                        this.f400874b = dVarArr2;
                    }
                } else {
                    if (this.f400873a == null) {
                        this.f400873a = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f400873a);
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
        c cVar = this.f400873a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        d[] dVarArr = this.f400874b;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f400874b;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i3];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        c cVar = this.f400873a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        d[] dVarArr = this.f400874b;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f400874b;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i3];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, dVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
