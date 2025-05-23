package lu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public long f415579a;

    /* renamed from: b, reason: collision with root package name */
    public String f415580b;

    /* renamed from: c, reason: collision with root package name */
    public int f415581c;

    public b() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f415579a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f415580b = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f415581c = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f415579a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f415580b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f415580b);
        }
        int i3 = this.f415581c;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f415579a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f415580b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f415580b);
        }
        int i3 = this.f415581c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f415579a = 0L;
        this.f415580b = "";
        this.f415581c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
