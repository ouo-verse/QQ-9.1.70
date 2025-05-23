package lv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public iv4.e f415641a;

    /* renamed from: b, reason: collision with root package name */
    public kv4.a f415642b;

    /* renamed from: c, reason: collision with root package name */
    public jv4.g f415643c;

    public e() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f415641a == null) {
                    this.f415641a = new iv4.e();
                }
                codedInputByteBufferNano.readMessage(this.f415641a);
            } else if (readTag == 18) {
                if (this.f415642b == null) {
                    this.f415642b = new kv4.a();
                }
                codedInputByteBufferNano.readMessage(this.f415642b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f415643c == null) {
                    this.f415643c = new jv4.g();
                }
                codedInputByteBufferNano.readMessage(this.f415643c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        iv4.e eVar = this.f415641a;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
        }
        kv4.a aVar = this.f415642b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        jv4.g gVar = this.f415643c;
        return gVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, gVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        iv4.e eVar = this.f415641a;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(1, eVar);
        }
        kv4.a aVar = this.f415642b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        jv4.g gVar = this.f415643c;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(3, gVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f415641a = null;
        this.f415642b = null;
        this.f415643c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
