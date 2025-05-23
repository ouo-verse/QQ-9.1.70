package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile p[] f406483c;

    /* renamed from: a, reason: collision with root package name */
    public String f406484a;

    /* renamed from: b, reason: collision with root package name */
    public String f406485b;

    public p() {
        a();
    }

    public static p[] b() {
        if (f406483c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406483c == null) {
                    f406483c = new p[0];
                }
            }
        }
        return f406483c;
    }

    public p a() {
        this.f406484a = "";
        this.f406485b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 34) {
                this.f406484a = codedInputByteBufferNano.readString();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406485b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406484a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f406484a);
        }
        return !this.f406485b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f406485b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406484a.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f406484a);
        }
        if (!this.f406485b.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f406485b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
