package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile m[] f406470c;

    /* renamed from: a, reason: collision with root package name */
    public int f406471a;

    /* renamed from: b, reason: collision with root package name */
    public String f406472b;

    public m() {
        a();
    }

    public static m[] b() {
        if (f406470c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406470c == null) {
                    f406470c = new m[0];
                }
            }
        }
        return f406470c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f406471a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406472b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f406471a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        return !this.f406472b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f406472b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f406471a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f406472b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406472b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public m a() {
        this.f406471a = 0;
        this.f406472b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
