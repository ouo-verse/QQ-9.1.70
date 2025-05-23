package dz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile c[] f395242h;

    /* renamed from: a, reason: collision with root package name */
    public String f395243a;

    /* renamed from: b, reason: collision with root package name */
    public String f395244b;

    /* renamed from: c, reason: collision with root package name */
    public int f395245c;

    /* renamed from: d, reason: collision with root package name */
    public String f395246d;

    /* renamed from: e, reason: collision with root package name */
    public String f395247e;

    /* renamed from: f, reason: collision with root package name */
    public long f395248f;

    /* renamed from: g, reason: collision with root package name */
    public String f395249g;

    public c() {
        a();
    }

    public static c[] b() {
        if (f395242h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f395242h == null) {
                    f395242h = new c[0];
                }
            }
        }
        return f395242h;
    }

    public c a() {
        this.f395243a = "";
        this.f395244b = "";
        this.f395245c = 0;
        this.f395246d = "";
        this.f395247e = "";
        this.f395248f = 0L;
        this.f395249g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f395249g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f395248f = codedInputByteBufferNano.readInt64();
                                    }
                                } else {
                                    this.f395247e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f395246d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f395245c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f395244b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f395243a = codedInputByteBufferNano.readString();
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
        if (!this.f395243a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f395243a);
        }
        if (!this.f395244b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f395244b);
        }
        int i3 = this.f395245c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.f395246d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f395246d);
        }
        if (!this.f395247e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f395247e);
        }
        long j3 = this.f395248f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j3);
        }
        if (!this.f395249g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f395249g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f395243a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f395243a);
        }
        if (!this.f395244b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f395244b);
        }
        int i3 = this.f395245c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.f395246d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f395246d);
        }
        if (!this.f395247e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f395247e);
        }
        long j3 = this.f395248f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j3);
        }
        if (!this.f395249g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f395249g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
