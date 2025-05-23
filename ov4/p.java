package ov4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile p[] f424193c;

    /* renamed from: a, reason: collision with root package name */
    public int f424194a;

    /* renamed from: b, reason: collision with root package name */
    public String f424195b;

    public p() {
        a();
    }

    public static p[] b() {
        if (f424193c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f424193c == null) {
                    f424193c = new p[0];
                }
            }
        }
        return f424193c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f424194a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f424195b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f424194a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        return !this.f424195b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f424195b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f424194a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f424195b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424195b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public p a() {
        this.f424194a = 0;
        this.f424195b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
