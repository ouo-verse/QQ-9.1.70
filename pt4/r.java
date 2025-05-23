package pt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile r[] f427231g;

    /* renamed from: a, reason: collision with root package name */
    public long f427232a;

    /* renamed from: b, reason: collision with root package name */
    public String f427233b;

    /* renamed from: c, reason: collision with root package name */
    public String f427234c;

    /* renamed from: d, reason: collision with root package name */
    public String f427235d;

    /* renamed from: e, reason: collision with root package name */
    public String f427236e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f427237f;

    public r() {
        a();
    }

    public static r[] b() {
        if (f427231g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427231g == null) {
                    f427231g = new r[0];
                }
            }
        }
        return f427231g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427232a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f427233b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f427234c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f427235d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f427236e = codedInputByteBufferNano.readString();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427237f = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f427232a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f427233b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427233b);
        }
        if (!this.f427234c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427234c);
        }
        if (!this.f427235d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427235d);
        }
        if (!this.f427236e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f427236e);
        }
        boolean z16 = this.f427237f;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(6, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f427232a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f427233b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427233b);
        }
        if (!this.f427234c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427234c);
        }
        if (!this.f427235d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427235d);
        }
        if (!this.f427236e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427236e);
        }
        boolean z16 = this.f427237f;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public r a() {
        this.f427232a = 0L;
        this.f427233b = "";
        this.f427234c = "";
        this.f427235d = "";
        this.f427236e = "";
        this.f427237f = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
