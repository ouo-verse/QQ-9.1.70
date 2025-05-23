package cw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile d[] f392178e;

    /* renamed from: a, reason: collision with root package name */
    public long f392179a;

    /* renamed from: b, reason: collision with root package name */
    public String f392180b;

    /* renamed from: c, reason: collision with root package name */
    public String f392181c;

    /* renamed from: d, reason: collision with root package name */
    public int f392182d;

    public d() {
        a();
    }

    public static d[] b() {
        if (f392178e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f392178e == null) {
                    f392178e = new d[0];
                }
            }
        }
        return f392178e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f392179a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f392180b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f392181c = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f392182d = readInt32;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f392179a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f392180b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f392180b);
        }
        if (!this.f392181c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f392181c);
        }
        int i3 = this.f392182d;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f392179a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f392180b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f392180b);
        }
        if (!this.f392181c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f392181c);
        }
        int i3 = this.f392182d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f392179a = 0L;
        this.f392180b = "";
        this.f392181c = "";
        this.f392182d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
