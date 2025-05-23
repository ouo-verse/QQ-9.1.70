package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile h[] f406428c;

    /* renamed from: a, reason: collision with root package name */
    public String f406429a;

    /* renamed from: b, reason: collision with root package name */
    public String f406430b;

    public h() {
        a();
    }

    public static h[] b() {
        if (f406428c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406428c == null) {
                    f406428c = new h[0];
                }
            }
        }
        return f406428c;
    }

    public h a() {
        this.f406429a = "";
        this.f406430b = "";
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
                this.f406429a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406430b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406429a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406429a);
        }
        return !this.f406430b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f406430b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406429a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406429a);
        }
        if (!this.f406430b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406430b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
