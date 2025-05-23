package ks4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile e[] f412966c;

    /* renamed from: a, reason: collision with root package name */
    public long f412967a;

    /* renamed from: b, reason: collision with root package name */
    public d[] f412968b;

    public e() {
        a();
    }

    public static e[] b() {
        if (f412966c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f412966c == null) {
                    f412966c = new e[0];
                }
            }
        }
        return f412966c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f412967a = codedInputByteBufferNano.readInt64();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                d[] dVarArr = this.f412968b;
                int length = dVarArr == null ? 0 : dVarArr.length;
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
                this.f412968b = dVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f412967a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        d[] dVarArr = this.f412968b;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f412968b;
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
        long j3 = this.f412967a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        d[] dVarArr = this.f412968b;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f412968b;
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

    public e a() {
        this.f412967a = 0L;
        this.f412968b = d.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
