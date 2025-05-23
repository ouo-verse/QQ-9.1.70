package ov4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile n[] f424182c;

    /* renamed from: a, reason: collision with root package name */
    public int f424183a;

    /* renamed from: b, reason: collision with root package name */
    public String f424184b;

    public n() {
        a();
    }

    public static n[] b() {
        if (f424182c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f424182c == null) {
                    f424182c = new n[0];
                }
            }
        }
        return f424182c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f424183a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f424184b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f424183a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        return !this.f424184b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f424184b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f424183a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f424184b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424184b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public n a() {
        this.f424183a = 0;
        this.f424184b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
