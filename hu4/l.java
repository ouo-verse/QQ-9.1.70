package hu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile l[] f406384c;

    /* renamed from: a, reason: collision with root package name */
    public String f406385a;

    /* renamed from: b, reason: collision with root package name */
    public String f406386b;

    public l() {
        a();
    }

    public static l[] b() {
        if (f406384c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406384c == null) {
                    f406384c = new l[0];
                }
            }
        }
        return f406384c;
    }

    public l a() {
        this.f406385a = "";
        this.f406386b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f406385a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406386b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406385a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406385a);
        }
        return !this.f406386b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f406386b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406385a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406385a);
        }
        if (!this.f406386b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406386b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
