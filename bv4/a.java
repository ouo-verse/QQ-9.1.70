package bv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f29253a;

    /* renamed from: b, reason: collision with root package name */
    public d f29254b;

    /* renamed from: c, reason: collision with root package name */
    public c f29255c;

    /* renamed from: d, reason: collision with root package name */
    public b f29256d;

    /* renamed from: e, reason: collision with root package name */
    public e f29257e;

    /* renamed from: f, reason: collision with root package name */
    public g f29258f;

    public a() {
        a();
    }

    public a a() {
        this.f29253a = "";
        this.f29254b = null;
        this.f29255c = null;
        this.f29256d = null;
        this.f29257e = null;
        this.f29258f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f29253a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.f29254b == null) {
                    this.f29254b = new d();
                }
                codedInputByteBufferNano.readMessage(this.f29254b);
            } else if (readTag == 26) {
                if (this.f29255c == null) {
                    this.f29255c = new c();
                }
                codedInputByteBufferNano.readMessage(this.f29255c);
            } else if (readTag == 34) {
                if (this.f29256d == null) {
                    this.f29256d = new b();
                }
                codedInputByteBufferNano.readMessage(this.f29256d);
            } else if (readTag == 42) {
                if (this.f29257e == null) {
                    this.f29257e = new e();
                }
                codedInputByteBufferNano.readMessage(this.f29257e);
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f29258f == null) {
                    this.f29258f = new g();
                }
                codedInputByteBufferNano.readMessage(this.f29258f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f29253a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f29253a);
        }
        d dVar = this.f29254b;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
        }
        c cVar = this.f29255c;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
        }
        b bVar = this.f29256d;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, bVar);
        }
        e eVar = this.f29257e;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, eVar);
        }
        g gVar = this.f29258f;
        return gVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, gVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f29253a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f29253a);
        }
        d dVar = this.f29254b;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(2, dVar);
        }
        c cVar = this.f29255c;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(3, cVar);
        }
        b bVar = this.f29256d;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(4, bVar);
        }
        e eVar = this.f29257e;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(5, eVar);
        }
        g gVar = this.f29258f;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(6, gVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
