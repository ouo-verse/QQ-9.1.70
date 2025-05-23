package f55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile h[] f397874h;

    /* renamed from: a, reason: collision with root package name */
    public long f397875a;

    /* renamed from: b, reason: collision with root package name */
    public String f397876b;

    /* renamed from: c, reason: collision with root package name */
    public String f397877c;

    /* renamed from: d, reason: collision with root package name */
    public int f397878d;

    /* renamed from: e, reason: collision with root package name */
    public int f397879e;

    /* renamed from: f, reason: collision with root package name */
    public int f397880f;

    /* renamed from: g, reason: collision with root package name */
    public int f397881g;

    public h() {
        a();
    }

    public static h[] b() {
        if (f397874h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f397874h == null) {
                    f397874h = new h[0];
                }
            }
        }
        return f397874h;
    }

    public h a() {
        this.f397875a = 0L;
        this.f397876b = "";
        this.f397877c = "";
        this.f397878d = 0;
        this.f397879e = 0;
        this.f397880f = 0;
        this.f397881g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f397881g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        this.f397880f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f397879e = codedInputByteBufferNano.readInt32();
                                }
                            } else {
                                this.f397878d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            this.f397877c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f397876b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f397875a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f397875a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f397876b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f397876b);
        }
        if (!this.f397877c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f397877c);
        }
        int i3 = this.f397878d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        int i16 = this.f397879e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        int i17 = this.f397880f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.f397881g;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f397875a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f397876b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f397876b);
        }
        if (!this.f397877c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f397877c);
        }
        int i3 = this.f397878d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        int i16 = this.f397879e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        int i17 = this.f397880f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.f397881g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
