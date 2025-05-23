package jv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public int f411029a;

    /* renamed from: b, reason: collision with root package name */
    public b f411030b;

    /* renamed from: c, reason: collision with root package name */
    public d f411031c;

    /* renamed from: d, reason: collision with root package name */
    public n f411032d;

    public g() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f411029a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 826) {
                if (this.f411030b == null) {
                    this.f411030b = new b();
                }
                codedInputByteBufferNano.readMessage(this.f411030b);
            } else if (readTag == 834) {
                if (this.f411031c == null) {
                    this.f411031c = new d();
                }
                codedInputByteBufferNano.readMessage(this.f411031c);
            } else if (readTag != 842) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f411032d == null) {
                    this.f411032d = new n();
                }
                codedInputByteBufferNano.readMessage(this.f411032d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f411029a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        b bVar = this.f411030b;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(103, bVar);
        }
        d dVar = this.f411031c;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(104, dVar);
        }
        n nVar = this.f411032d;
        return nVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(105, nVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f411029a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        b bVar = this.f411030b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(103, bVar);
        }
        d dVar = this.f411031c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(104, dVar);
        }
        n nVar = this.f411032d;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(105, nVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f411029a = 0;
        this.f411030b = null;
        this.f411031c = null;
        this.f411032d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
