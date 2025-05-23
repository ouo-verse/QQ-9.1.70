package fw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f400896a;

    /* renamed from: b, reason: collision with root package name */
    public String f400897b;

    /* renamed from: c, reason: collision with root package name */
    public int f400898c;

    /* renamed from: d, reason: collision with root package name */
    public String f400899d;

    /* renamed from: e, reason: collision with root package name */
    public String f400900e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f400901f;

    /* renamed from: g, reason: collision with root package name */
    public c[] f400902g;

    /* renamed from: h, reason: collision with root package name */
    public int f400903h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f400904i;

    public a() {
        a();
    }

    public a a() {
        this.f400896a = "";
        this.f400897b = "";
        this.f400898c = 0;
        this.f400899d = "";
        this.f400900e = "";
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f400901f = bArr;
        this.f400902g = c.b();
        this.f400903h = 0;
        this.f400904i = bArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f400896a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f400897b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f400898c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                this.f400899d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f400900e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f400901f = codedInputByteBufferNano.readBytes();
            } else if (readTag == 58) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                c[] cVarArr = this.f400902g;
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
                this.f400902g = cVarArr2;
            } else if (readTag == 64) {
                this.f400903h = codedInputByteBufferNano.readInt32();
            } else if (readTag != 74) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f400904i = codedInputByteBufferNano.readBytes();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f400896a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400896a);
        }
        if (!this.f400897b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f400897b);
        }
        int i3 = this.f400898c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.f400899d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f400899d);
        }
        if (!this.f400900e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f400900e);
        }
        if (!Arrays.equals(this.f400901f, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.f400901f);
        }
        c[] cVarArr = this.f400902g;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                c[] cVarArr2 = this.f400902g;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i16];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, cVar);
                }
                i16++;
            }
        }
        int i17 = this.f400903h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i17);
        }
        return !Arrays.equals(this.f400904i, WireFormatNano.EMPTY_BYTES) ? computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(9, this.f400904i) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400896a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400896a);
        }
        if (!this.f400897b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400897b);
        }
        int i3 = this.f400898c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.f400899d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f400899d);
        }
        if (!this.f400900e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f400900e);
        }
        if (!Arrays.equals(this.f400901f, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(6, this.f400901f);
        }
        c[] cVarArr = this.f400902g;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                c[] cVarArr2 = this.f400902g;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i16];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, cVar);
                }
                i16++;
            }
        }
        int i17 = this.f400903h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i17);
        }
        if (!Arrays.equals(this.f400904i, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(9, this.f400904i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
