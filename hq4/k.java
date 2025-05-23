package hq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public np4.c f405981a;

    /* renamed from: b, reason: collision with root package name */
    public op4.g f405982b;

    /* renamed from: c, reason: collision with root package name */
    public String f405983c;

    /* renamed from: d, reason: collision with root package name */
    public sp4.b f405984d;

    public k() {
        a();
    }

    public k a() {
        this.f405981a = null;
        this.f405982b = null;
        this.f405983c = "";
        this.f405984d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                if (this.f405984d == null) {
                                    this.f405984d = new sp4.b();
                                }
                                codedInputByteBufferNano.readMessage(this.f405984d);
                            }
                        } else {
                            this.f405983c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        if (this.f405982b == null) {
                            this.f405982b = new op4.g();
                        }
                        codedInputByteBufferNano.readMessage(this.f405982b);
                    }
                } else {
                    if (this.f405981a == null) {
                        this.f405981a = new np4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f405981a);
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
        np4.c cVar = this.f405981a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        op4.g gVar = this.f405982b;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        if (!this.f405983c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f405983c);
        }
        sp4.b bVar = this.f405984d;
        if (bVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, bVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        np4.c cVar = this.f405981a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        op4.g gVar = this.f405982b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        if (!this.f405983c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f405983c);
        }
        sp4.b bVar = this.f405984d;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(4, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
