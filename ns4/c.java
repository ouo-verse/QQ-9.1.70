package ns4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile c[] f421249d;

    /* renamed from: a, reason: collision with root package name */
    public long f421250a;

    /* renamed from: b, reason: collision with root package name */
    public String f421251b;

    /* renamed from: c, reason: collision with root package name */
    public String f421252c;

    public c() {
        a();
    }

    public static c[] b() {
        if (f421249d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f421249d == null) {
                    f421249d = new c[0];
                }
            }
        }
        return f421249d;
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
                this.f421250a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f421251b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f421252c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f421250a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f421251b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f421251b);
        }
        return !this.f421252c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f421252c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f421250a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f421251b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f421251b);
        }
        if (!this.f421252c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f421252c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f421250a = 0L;
        this.f421251b = "";
        this.f421252c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
