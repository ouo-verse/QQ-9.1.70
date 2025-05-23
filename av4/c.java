package av4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile c[] f27010c;

    /* renamed from: a, reason: collision with root package name */
    public String f27011a;

    /* renamed from: b, reason: collision with root package name */
    public String f27012b;

    public c() {
        a();
    }

    public static c[] b() {
        if (f27010c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f27010c == null) {
                    f27010c = new c[0];
                }
            }
        }
        return f27010c;
    }

    public c a() {
        this.f27011a = "";
        this.f27012b = "";
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
                this.f27011a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f27012b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f27011a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f27011a);
        }
        return !this.f27012b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f27012b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f27011a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f27011a);
        }
        if (!this.f27012b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f27012b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
