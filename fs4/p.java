package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: a, reason: collision with root package name */
    public String f400555a;

    /* renamed from: b, reason: collision with root package name */
    public String f400556b;

    /* renamed from: c, reason: collision with root package name */
    public String f400557c;

    /* renamed from: d, reason: collision with root package name */
    public j f400558d;

    /* renamed from: e, reason: collision with root package name */
    public j f400559e;

    /* renamed from: f, reason: collision with root package name */
    public String f400560f;

    public p() {
        a();
    }

    public p a() {
        this.f400555a = "";
        this.f400556b = "";
        this.f400557c = "";
        this.f400558d = null;
        this.f400559e = null;
        this.f400560f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f400555a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f400556b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f400557c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                if (this.f400558d == null) {
                    this.f400558d = new j();
                }
                codedInputByteBufferNano.readMessage(this.f400558d);
            } else if (readTag == 42) {
                if (this.f400559e == null) {
                    this.f400559e = new j();
                }
                codedInputByteBufferNano.readMessage(this.f400559e);
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f400560f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f400555a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400555a);
        }
        if (!this.f400556b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f400556b);
        }
        if (!this.f400557c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f400557c);
        }
        j jVar = this.f400558d;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, jVar);
        }
        j jVar2 = this.f400559e;
        if (jVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, jVar2);
        }
        return !this.f400560f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f400560f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400555a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400555a);
        }
        if (!this.f400556b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400556b);
        }
        if (!this.f400557c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400557c);
        }
        j jVar = this.f400558d;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(4, jVar);
        }
        j jVar2 = this.f400559e;
        if (jVar2 != null) {
            codedOutputByteBufferNano.writeMessage(5, jVar2);
        }
        if (!this.f400560f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f400560f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
