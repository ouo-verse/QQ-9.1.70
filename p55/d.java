package p55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public c f425375a;

    /* renamed from: b, reason: collision with root package name */
    public g f425376b;

    /* renamed from: c, reason: collision with root package name */
    public h f425377c;

    public d() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f425375a == null) {
                    this.f425375a = new c();
                }
                codedInputByteBufferNano.readMessage(this.f425375a);
            } else if (readTag == 18) {
                if (this.f425376b == null) {
                    this.f425376b = new g();
                }
                codedInputByteBufferNano.readMessage(this.f425376b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f425377c == null) {
                    this.f425377c = new h();
                }
                codedInputByteBufferNano.readMessage(this.f425377c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        c cVar = this.f425375a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        g gVar = this.f425376b;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        h hVar = this.f425377c;
        return hVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, hVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        c cVar = this.f425375a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        g gVar = this.f425376b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        h hVar = this.f425377c;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(3, hVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f425375a = null;
        this.f425376b = null;
        this.f425377c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
