package bs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile h[] f29068c;

    /* renamed from: a, reason: collision with root package name */
    public String f29069a;

    /* renamed from: b, reason: collision with root package name */
    public String f29070b;

    public h() {
        a();
    }

    public static h[] b() {
        if (f29068c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f29068c == null) {
                    f29068c = new h[0];
                }
            }
        }
        return f29068c;
    }

    public h a() {
        this.f29069a = "";
        this.f29070b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f29069a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f29070b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f29069a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f29069a);
        }
        return !this.f29070b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f29070b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f29069a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f29069a);
        }
        if (!this.f29070b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f29070b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
