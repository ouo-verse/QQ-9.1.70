package cr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile l[] f391789f;

    /* renamed from: a, reason: collision with root package name */
    public long f391790a;

    /* renamed from: b, reason: collision with root package name */
    public g[] f391791b;

    /* renamed from: c, reason: collision with root package name */
    public String f391792c;

    /* renamed from: d, reason: collision with root package name */
    public String f391793d;

    /* renamed from: e, reason: collision with root package name */
    public String f391794e;

    public l() {
        a();
    }

    public static l[] b() {
        if (f391789f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f391789f == null) {
                    f391789f = new l[0];
                }
            }
        }
        return f391789f;
    }

    public l a() {
        this.f391790a = 0L;
        this.f391791b = g.b();
        this.f391792c = "";
        this.f391793d = "";
        this.f391794e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f391794e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f391793d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f391792c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        g[] gVarArr = this.f391791b;
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
                        this.f391791b = gVarArr2;
                    }
                } else {
                    this.f391790a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f391790a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        g[] gVarArr = this.f391791b;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f391791b;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
                }
                i3++;
            }
        }
        if (!this.f391792c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f391792c);
        }
        if (!this.f391793d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f391793d);
        }
        if (!this.f391794e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f391794e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f391790a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        g[] gVarArr = this.f391791b;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f391791b;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, gVar);
                }
                i3++;
            }
        }
        if (!this.f391792c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f391792c);
        }
        if (!this.f391793d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f391793d);
        }
        if (!this.f391794e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f391794e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
