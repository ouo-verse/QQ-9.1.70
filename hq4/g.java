package hq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public np4.c f405970a;

    /* renamed from: b, reason: collision with root package name */
    public qp4.e f405971b;

    /* renamed from: c, reason: collision with root package name */
    public String f405972c;

    public g() {
        a();
    }

    public g a() {
        this.f405970a = null;
        this.f405971b = null;
        this.f405972c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f405972c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        if (this.f405971b == null) {
                            this.f405971b = new qp4.e();
                        }
                        codedInputByteBufferNano.readMessage(this.f405971b);
                    }
                } else {
                    if (this.f405970a == null) {
                        this.f405970a = new np4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f405970a);
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        np4.c cVar = this.f405970a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        qp4.e eVar = this.f405971b;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, eVar);
        }
        if (!this.f405972c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f405972c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        np4.c cVar = this.f405970a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        qp4.e eVar = this.f405971b;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(2, eVar);
        }
        if (!this.f405972c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f405972c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
