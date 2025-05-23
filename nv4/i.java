package nv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public int f421406a;

    /* renamed from: b, reason: collision with root package name */
    public String f421407b;

    public i() {
        a();
    }

    public static i c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (i) MessageNano.mergeFrom(new i(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f421406a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f421407b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f421406a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        return !this.f421407b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f421407b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f421406a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f421407b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f421407b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public i a() {
        this.f421406a = 0;
        this.f421407b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
