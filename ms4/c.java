package ms4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile c[] f417508h;

    /* renamed from: a, reason: collision with root package name */
    public long f417509a;

    /* renamed from: b, reason: collision with root package name */
    public String f417510b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f417511c;

    /* renamed from: d, reason: collision with root package name */
    public long f417512d;

    /* renamed from: e, reason: collision with root package name */
    public long f417513e;

    /* renamed from: f, reason: collision with root package name */
    public String f417514f;

    /* renamed from: g, reason: collision with root package name */
    public c[] f417515g;

    public c() {
        a();
    }

    public static c[] b() {
        if (f417508h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f417508h == null) {
                    f417508h = new c[0];
                }
            }
        }
        return f417508h;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f417509a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f417510b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f417511c = codedInputByteBufferNano.readBytes();
            } else if (readTag == 32) {
                this.f417512d = codedInputByteBufferNano.readInt64();
            } else if (readTag == 40) {
                this.f417513e = codedInputByteBufferNano.readInt64();
            } else if (readTag == 50) {
                this.f417514f = codedInputByteBufferNano.readString();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                c[] cVarArr = this.f417515g;
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
                this.f417515g = cVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f417509a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f417510b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f417510b);
        }
        if (!Arrays.equals(this.f417511c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f417511c);
        }
        long j16 = this.f417512d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j16);
        }
        long j17 = this.f417513e;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j17);
        }
        if (!this.f417514f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f417514f);
        }
        c[] cVarArr = this.f417515g;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                c[] cVarArr2 = this.f417515g;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, cVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f417509a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f417510b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f417510b);
        }
        if (!Arrays.equals(this.f417511c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f417511c);
        }
        long j16 = this.f417512d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j16);
        }
        long j17 = this.f417513e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j17);
        }
        if (!this.f417514f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f417514f);
        }
        c[] cVarArr = this.f417515g;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                c[] cVarArr2 = this.f417515g;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, cVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f417509a = 0L;
        this.f417510b = "";
        this.f417511c = WireFormatNano.EMPTY_BYTES;
        this.f417512d = 0L;
        this.f417513e = 0L;
        this.f417514f = "";
        this.f417515g = b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
