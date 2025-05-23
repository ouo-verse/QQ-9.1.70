package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: a, reason: collision with root package name */
    public o[] f406486a;

    /* renamed from: b, reason: collision with root package name */
    public r[] f406487b;

    public q() {
        a();
    }

    public q a() {
        this.f406486a = o.b();
        this.f406487b = r.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                o[] oVarArr = this.f406486a;
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
                this.f406486a = oVarArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                r[] rVarArr = this.f406487b;
                int length2 = rVarArr == null ? 0 : rVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                r[] rVarArr2 = new r[i16];
                if (length2 != 0) {
                    System.arraycopy(rVarArr, 0, rVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    r rVar = new r();
                    rVarArr2[length2] = rVar;
                    codedInputByteBufferNano.readMessage(rVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                r rVar2 = new r();
                rVarArr2[length2] = rVar2;
                codedInputByteBufferNano.readMessage(rVar2);
                this.f406487b = rVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        o[] oVarArr = this.f406486a;
        int i3 = 0;
        if (oVarArr != null && oVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                o[] oVarArr2 = this.f406486a;
                if (i16 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i16];
                if (oVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, oVar);
                }
                i16++;
            }
        }
        r[] rVarArr = this.f406487b;
        if (rVarArr != null && rVarArr.length > 0) {
            while (true) {
                r[] rVarArr2 = this.f406487b;
                if (i3 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i3];
                if (rVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, rVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        o[] oVarArr = this.f406486a;
        int i3 = 0;
        if (oVarArr != null && oVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                o[] oVarArr2 = this.f406486a;
                if (i16 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i16];
                if (oVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, oVar);
                }
                i16++;
            }
        }
        r[] rVarArr = this.f406487b;
        if (rVarArr != null && rVarArr.length > 0) {
            while (true) {
                r[] rVarArr2 = this.f406487b;
                if (i3 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i3];
                if (rVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, rVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
