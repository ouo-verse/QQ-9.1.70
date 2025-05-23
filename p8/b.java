package p8;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes34.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b[] f425694b;

    /* renamed from: a, reason: collision with root package name */
    public String f425695a;

    public b() {
        a();
    }

    public static b[] b() {
        if (f425694b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f425694b == null) {
                    f425694b = new b[0];
                }
            }
        }
        return f425694b;
    }

    public b a() {
        this.f425695a = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f425695a = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f425695a.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.f425695a) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f425695a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f425695a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
