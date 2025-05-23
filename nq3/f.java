package nq3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public h f420711a;

    /* renamed from: b, reason: collision with root package name */
    public h f420712b;

    /* renamed from: c, reason: collision with root package name */
    public h f420713c;

    public f() {
        a();
    }

    public f a() {
        this.f420711a = null;
        this.f420712b = null;
        this.f420713c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            if (this.f420713c == null) {
                                this.f420713c = new h();
                            }
                            codedInputByteBufferNano.readMessage(this.f420713c);
                        }
                    } else {
                        if (this.f420712b == null) {
                            this.f420712b = new h();
                        }
                        codedInputByteBufferNano.readMessage(this.f420712b);
                    }
                } else {
                    if (this.f420711a == null) {
                        this.f420711a = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f420711a);
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
        h hVar = this.f420711a;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, hVar);
        }
        h hVar2 = this.f420712b;
        if (hVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, hVar2);
        }
        h hVar3 = this.f420713c;
        if (hVar3 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, hVar3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        h hVar = this.f420711a;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(1, hVar);
        }
        h hVar2 = this.f420712b;
        if (hVar2 != null) {
            codedOutputByteBufferNano.writeMessage(2, hVar2);
        }
        h hVar3 = this.f420713c;
        if (hVar3 != null) {
            codedOutputByteBufferNano.writeMessage(3, hVar3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
