package ds4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public bs4.j f394796a;

    public k() {
        a();
    }

    public static k c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (k) MessageNano.mergeFrom(new k(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f394796a == null) {
                    this.f394796a = new bs4.j();
                }
                codedInputByteBufferNano.readMessage(this.f394796a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bs4.j jVar = this.f394796a;
        return jVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, jVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bs4.j jVar = this.f394796a;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(1, jVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public k a() {
        this.f394796a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
