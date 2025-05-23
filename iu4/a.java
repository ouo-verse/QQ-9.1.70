package iu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a[] f408758c;

    /* renamed from: a, reason: collision with root package name */
    public String f408759a;

    /* renamed from: b, reason: collision with root package name */
    public String f408760b;

    public a() {
        a();
    }

    public static a[] b() {
        if (f408758c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f408758c == null) {
                    f408758c = new a[0];
                }
            }
        }
        return f408758c;
    }

    public a a() {
        this.f408759a = "";
        this.f408760b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f408759a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f408760b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f408759a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f408759a);
        }
        return !this.f408760b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f408760b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f408759a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f408759a);
        }
        if (!this.f408760b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f408760b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
