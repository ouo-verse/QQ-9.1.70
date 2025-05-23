package ms4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile b[] f417502f;

    /* renamed from: a, reason: collision with root package name */
    public long f417503a;

    /* renamed from: b, reason: collision with root package name */
    public long f417504b;

    /* renamed from: c, reason: collision with root package name */
    public c[] f417505c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f417506d;

    /* renamed from: e, reason: collision with root package name */
    public long f417507e;

    public b() {
        a();
    }

    public static b[] b() {
        if (f417502f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f417502f == null) {
                    f417502f = new b[0];
                }
            }
        }
        return f417502f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f417503a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.f417504b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                c[] cVarArr = this.f417505c;
                int length = cVarArr == null ? 0 : cVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                c[] cVarArr2 = new c[i3];
                if (length != 0) {
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    c cVar = new c();
                    cVarArr2[length] = cVar;
                    codedInputByteBufferNano.readMessage(cVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                c cVar2 = new c();
                cVarArr2[length] = cVar2;
                codedInputByteBufferNano.readMessage(cVar2);
                this.f417505c = cVarArr2;
            } else if (readTag == 32) {
                this.f417506d = codedInputByteBufferNano.readBool();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f417507e = codedInputByteBufferNano.readInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f417503a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f417504b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        c[] cVarArr = this.f417505c;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                c[] cVarArr2 = this.f417505c;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f417506d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        long j17 = this.f417507e;
        return j17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(5, j17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f417503a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f417504b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        c[] cVarArr = this.f417505c;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                c[] cVarArr2 = this.f417505c;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, cVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f417506d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        long j17 = this.f417507e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f417503a = 0L;
        this.f417504b = 0L;
        this.f417505c = c.b();
        this.f417506d = false;
        this.f417507e = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
