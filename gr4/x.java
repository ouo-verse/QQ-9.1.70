package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class x extends ExtendableMessageNano<x> {

    /* renamed from: a, reason: collision with root package name */
    public String f403237a;

    /* renamed from: b, reason: collision with root package name */
    public String f403238b;

    /* renamed from: c, reason: collision with root package name */
    public String f403239c;

    /* renamed from: d, reason: collision with root package name */
    public String f403240d;

    /* renamed from: e, reason: collision with root package name */
    public f f403241e;

    public x() {
        a();
    }

    public x a() {
        this.f403237a = "";
        this.f403238b = "";
        this.f403239c = "";
        this.f403240d = "";
        this.f403241e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public x mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    if (this.f403241e == null) {
                                        this.f403241e = new f();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f403241e);
                                }
                            } else {
                                this.f403240d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f403239c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f403238b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f403237a = codedInputByteBufferNano.readString();
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
        if (!this.f403237a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f403237a);
        }
        if (!this.f403238b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403238b);
        }
        if (!this.f403239c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f403239c);
        }
        if (!this.f403240d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f403240d);
        }
        f fVar = this.f403241e;
        if (fVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, fVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f403237a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f403237a);
        }
        if (!this.f403238b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403238b);
        }
        if (!this.f403239c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403239c);
        }
        if (!this.f403240d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403240d);
        }
        f fVar = this.f403241e;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(5, fVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
