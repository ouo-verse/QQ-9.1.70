package at4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: k, reason: collision with root package name */
    private static volatile f[] f26932k;

    /* renamed from: a, reason: collision with root package name */
    public long f26933a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f26934b;

    /* renamed from: c, reason: collision with root package name */
    public int f26935c;

    /* renamed from: d, reason: collision with root package name */
    public int f26936d;

    /* renamed from: e, reason: collision with root package name */
    public String f26937e;

    /* renamed from: f, reason: collision with root package name */
    public String f26938f;

    /* renamed from: g, reason: collision with root package name */
    public String f26939g;

    /* renamed from: h, reason: collision with root package name */
    public String f26940h;

    /* renamed from: i, reason: collision with root package name */
    public String f26941i;

    /* renamed from: j, reason: collision with root package name */
    public es4.b[] f26942j;

    public f() {
        a();
    }

    public static f[] b() {
        if (f26932k == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f26932k == null) {
                    f26932k = new f[0];
                }
            }
        }
        return f26932k;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f26933a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.f26934b = codedInputByteBufferNano.readBytes();
                    break;
                case 24:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f26935c = readInt32;
                        break;
                    }
                case 32:
                    this.f26936d = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.f26937e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f26938f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f26939g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f26940h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f26941i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    es4.b[] bVarArr = this.f26942j;
                    int length = bVarArr == null ? 0 : bVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    es4.b[] bVarArr2 = new es4.b[i3];
                    if (length != 0) {
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        es4.b bVar = new es4.b();
                        bVarArr2[length] = bVar;
                        codedInputByteBufferNano.readMessage(bVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    es4.b bVar2 = new es4.b();
                    bVarArr2[length] = bVar2;
                    codedInputByteBufferNano.readMessage(bVar2);
                    this.f26942j = bVarArr2;
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f26933a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!Arrays.equals(this.f26934b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f26934b);
        }
        int i3 = this.f26935c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        int i16 = this.f26936d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        if (!this.f26937e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f26937e);
        }
        if (!this.f26938f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f26938f);
        }
        if (!this.f26939g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f26939g);
        }
        if (!this.f26940h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f26940h);
        }
        if (!this.f26941i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f26941i);
        }
        es4.b[] bVarArr = this.f26942j;
        if (bVarArr != null && bVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                es4.b[] bVarArr2 = this.f26942j;
                if (i17 >= bVarArr2.length) {
                    break;
                }
                es4.b bVar = bVarArr2[i17];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, bVar);
                }
                i17++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f26933a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!Arrays.equals(this.f26934b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f26934b);
        }
        int i3 = this.f26935c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        int i16 = this.f26936d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        if (!this.f26937e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f26937e);
        }
        if (!this.f26938f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f26938f);
        }
        if (!this.f26939g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f26939g);
        }
        if (!this.f26940h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f26940h);
        }
        if (!this.f26941i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f26941i);
        }
        es4.b[] bVarArr = this.f26942j;
        if (bVarArr != null && bVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                es4.b[] bVarArr2 = this.f26942j;
                if (i17 >= bVarArr2.length) {
                    break;
                }
                es4.b bVar = bVarArr2[i17];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(10, bVar);
                }
                i17++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f26933a = 0L;
        this.f26934b = WireFormatNano.EMPTY_BYTES;
        this.f26935c = 0;
        this.f26936d = 0;
        this.f26937e = "";
        this.f26938f = "";
        this.f26939g = "";
        this.f26940h = "";
        this.f26941i = "";
        this.f26942j = es4.b.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
