package hx4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public d f406577a;

    /* renamed from: b, reason: collision with root package name */
    public b f406578b;

    /* renamed from: c, reason: collision with root package name */
    public c f406579c;

    /* renamed from: d, reason: collision with root package name */
    public f f406580d;

    public e() {
        a();
    }

    public e a() {
        this.f406577a = null;
        this.f406578b = null;
        this.f406579c = null;
        this.f406580d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                if (this.f406580d == null) {
                                    this.f406580d = new f();
                                }
                                codedInputByteBufferNano.readMessage(this.f406580d);
                            }
                        } else {
                            if (this.f406579c == null) {
                                this.f406579c = new c();
                            }
                            codedInputByteBufferNano.readMessage(this.f406579c);
                        }
                    } else {
                        if (this.f406578b == null) {
                            this.f406578b = new b();
                        }
                        codedInputByteBufferNano.readMessage(this.f406578b);
                    }
                } else {
                    if (this.f406577a == null) {
                        this.f406577a = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f406577a);
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
        d dVar = this.f406577a;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, dVar);
        }
        b bVar = this.f406578b;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
        }
        c cVar = this.f406579c;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
        }
        f fVar = this.f406580d;
        if (fVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, fVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        d dVar = this.f406577a;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(1, dVar);
        }
        b bVar = this.f406578b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar);
        }
        c cVar = this.f406579c;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(3, cVar);
        }
        f fVar = this.f406580d;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(4, fVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
