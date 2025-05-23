package pt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile p[] f427206g;

    /* renamed from: a, reason: collision with root package name */
    public long f427207a;

    /* renamed from: b, reason: collision with root package name */
    public String f427208b;

    /* renamed from: c, reason: collision with root package name */
    public String f427209c;

    /* renamed from: d, reason: collision with root package name */
    public String f427210d;

    /* renamed from: e, reason: collision with root package name */
    public String f427211e;

    /* renamed from: f, reason: collision with root package name */
    public String f427212f;

    public p() {
        a();
    }

    public static p[] b() {
        if (f427206g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427206g == null) {
                    f427206g = new p[0];
                }
            }
        }
        return f427206g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427207a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f427208b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f427209c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f427210d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f427211e = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427212f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f427207a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f427208b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427208b);
        }
        if (!this.f427209c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427209c);
        }
        if (!this.f427210d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427210d);
        }
        if (!this.f427211e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f427211e);
        }
        return !this.f427212f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f427212f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f427207a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f427208b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427208b);
        }
        if (!this.f427209c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427209c);
        }
        if (!this.f427210d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427210d);
        }
        if (!this.f427211e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427211e);
        }
        if (!this.f427212f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427212f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public p a() {
        this.f427207a = 0L;
        this.f427208b = "";
        this.f427209c = "";
        this.f427210d = "";
        this.f427211e = "";
        this.f427212f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
