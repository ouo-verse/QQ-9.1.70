package ov4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public d f424169a;

    /* renamed from: b, reason: collision with root package name */
    public String f424170b;

    /* renamed from: c, reason: collision with root package name */
    public String f424171c;

    /* renamed from: d, reason: collision with root package name */
    public String f424172d;

    /* renamed from: e, reason: collision with root package name */
    public String f424173e;

    /* renamed from: f, reason: collision with root package name */
    public c f424174f;

    /* renamed from: g, reason: collision with root package name */
    public String f424175g;

    public l() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f424169a == null) {
                    this.f424169a = new d();
                }
                codedInputByteBufferNano.readMessage(this.f424169a);
            } else if (readTag == 18) {
                this.f424170b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f424171c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f424172d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f424173e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                if (this.f424174f == null) {
                    this.f424174f = new c();
                }
                codedInputByteBufferNano.readMessage(this.f424174f);
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f424175g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        d dVar = this.f424169a;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, dVar);
        }
        if (!this.f424170b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f424170b);
        }
        if (!this.f424171c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f424171c);
        }
        if (!this.f424172d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f424172d);
        }
        if (!this.f424173e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f424173e);
        }
        c cVar = this.f424174f;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, cVar);
        }
        return !this.f424175g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f424175g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        d dVar = this.f424169a;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(1, dVar);
        }
        if (!this.f424170b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424170b);
        }
        if (!this.f424171c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f424171c);
        }
        if (!this.f424172d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f424172d);
        }
        if (!this.f424173e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f424173e);
        }
        c cVar = this.f424174f;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(6, cVar);
        }
        if (!this.f424175g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f424175g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public l a() {
        this.f424169a = null;
        this.f424170b = "";
        this.f424171c = "";
        this.f424172d = "";
        this.f424173e = "";
        this.f424174f = null;
        this.f424175g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
