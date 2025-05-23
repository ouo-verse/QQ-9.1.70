package op4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile a[] f423301g;

    /* renamed from: a, reason: collision with root package name */
    public String f423302a;

    /* renamed from: b, reason: collision with root package name */
    public int f423303b;

    /* renamed from: c, reason: collision with root package name */
    public g[] f423304c;

    /* renamed from: d, reason: collision with root package name */
    public f f423305d;

    /* renamed from: e, reason: collision with root package name */
    public int f423306e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f423307f;

    public a() {
        a();
    }

    public static a[] b() {
        if (f423301g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f423301g == null) {
                    f423301g = new a[0];
                }
            }
        }
        return f423301g;
    }

    public a a() {
        this.f423302a = "";
        this.f423303b = 0;
        this.f423304c = g.b();
        this.f423305d = null;
        this.f423306e = 0;
        this.f423307f = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f423307f = codedInputByteBufferNano.readBytes();
                                    }
                                } else {
                                    this.f423306e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                if (this.f423305d == null) {
                                    this.f423305d = new f();
                                }
                                codedInputByteBufferNano.readMessage(this.f423305d);
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            g[] gVarArr = this.f423304c;
                            if (gVarArr == null) {
                                length = 0;
                            } else {
                                length = gVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            g[] gVarArr2 = new g[i3];
                            if (length != 0) {
                                System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                g gVar = new g();
                                gVarArr2[length] = gVar;
                                codedInputByteBufferNano.readMessage(gVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            g gVar2 = new g();
                            gVarArr2[length] = gVar2;
                            codedInputByteBufferNano.readMessage(gVar2);
                            this.f423304c = gVarArr2;
                        }
                    } else {
                        this.f423303b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f423302a = codedInputByteBufferNano.readString();
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
        if (!this.f423302a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f423302a);
        }
        int i3 = this.f423303b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        g[] gVarArr = this.f423304c;
        if (gVarArr != null && gVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                g[] gVarArr2 = this.f423304c;
                if (i16 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i16];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gVar);
                }
                i16++;
            }
        }
        f fVar = this.f423305d;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, fVar);
        }
        int i17 = this.f423306e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        if (!Arrays.equals(this.f423307f, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(6, this.f423307f);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f423302a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f423302a);
        }
        int i3 = this.f423303b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        g[] gVarArr = this.f423304c;
        if (gVarArr != null && gVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                g[] gVarArr2 = this.f423304c;
                if (i16 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i16];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, gVar);
                }
                i16++;
            }
        }
        f fVar = this.f423305d;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(4, fVar);
        }
        int i17 = this.f423306e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        if (!Arrays.equals(this.f423307f, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(6, this.f423307f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
