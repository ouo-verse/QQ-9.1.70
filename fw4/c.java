package fw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile c[] f400911c;

    /* renamed from: a, reason: collision with root package name */
    public String f400912a;

    /* renamed from: b, reason: collision with root package name */
    public String f400913b;

    public c() {
        a();
    }

    public static c[] b() {
        if (f400911c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400911c == null) {
                    f400911c = new c[0];
                }
            }
        }
        return f400911c;
    }

    public c a() {
        this.f400912a = "";
        this.f400913b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f400912a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f400913b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f400912a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400912a);
        }
        return !this.f400913b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f400913b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400912a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400912a);
        }
        if (!this.f400913b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400913b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
