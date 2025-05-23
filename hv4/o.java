package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile o[] f406478e;

    /* renamed from: a, reason: collision with root package name */
    public long f406479a;

    /* renamed from: b, reason: collision with root package name */
    public int f406480b;

    /* renamed from: c, reason: collision with root package name */
    public int f406481c;

    /* renamed from: d, reason: collision with root package name */
    public p[] f406482d;

    public o() {
        a();
    }

    public static o[] b() {
        if (f406478e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406478e == null) {
                    f406478e = new o[0];
                }
            }
        }
        return f406478e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f406479a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.f406480b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f406481c = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                p[] pVarArr = this.f406482d;
                int length = pVarArr == null ? 0 : pVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                p[] pVarArr2 = new p[i3];
                if (length != 0) {
                    System.arraycopy(pVarArr, 0, pVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    p pVar = new p();
                    pVarArr2[length] = pVar;
                    codedInputByteBufferNano.readMessage(pVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                p pVar2 = new p();
                pVarArr2[length] = pVar2;
                codedInputByteBufferNano.readMessage(pVar2);
                this.f406482d = pVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f406479a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        int i3 = this.f406480b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f406481c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        p[] pVarArr = this.f406482d;
        if (pVarArr != null && pVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                p[] pVarArr2 = this.f406482d;
                if (i17 >= pVarArr2.length) {
                    break;
                }
                p pVar = pVarArr2[i17];
                if (pVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, pVar);
                }
                i17++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f406479a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        int i3 = this.f406480b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f406481c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        p[] pVarArr = this.f406482d;
        if (pVarArr != null && pVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                p[] pVarArr2 = this.f406482d;
                if (i17 >= pVarArr2.length) {
                    break;
                }
                p pVar = pVarArr2[i17];
                if (pVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, pVar);
                }
                i17++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public o a() {
        this.f406479a = 0L;
        this.f406480b = 0;
        this.f406481c = 0;
        this.f406482d = p.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
