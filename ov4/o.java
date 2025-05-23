package ov4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public String f424185a;

    /* renamed from: b, reason: collision with root package name */
    public String f424186b;

    /* renamed from: c, reason: collision with root package name */
    public String f424187c;

    /* renamed from: d, reason: collision with root package name */
    public String f424188d;

    /* renamed from: e, reason: collision with root package name */
    public String f424189e;

    /* renamed from: f, reason: collision with root package name */
    public long f424190f;

    /* renamed from: g, reason: collision with root package name */
    public String f424191g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f424192h;

    public o() {
        a();
    }

    public o a() {
        this.f424185a = "";
        this.f424186b = "";
        this.f424187c = "";
        this.f424188d = "";
        this.f424189e = "";
        this.f424190f = 0L;
        this.f424191g = "";
        this.f424192h = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f424185a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f424186b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f424187c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f424188d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f424189e = codedInputByteBufferNano.readString();
            } else if (readTag == 48) {
                this.f424190f = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 58) {
                this.f424191g = codedInputByteBufferNano.readString();
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f424192h = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f424185a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f424185a);
        }
        if (!this.f424186b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f424186b);
        }
        if (!this.f424187c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f424187c);
        }
        if (!this.f424188d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f424188d);
        }
        if (!this.f424189e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f424189e);
        }
        long j3 = this.f424190f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        if (!this.f424191g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f424191g);
        }
        boolean z16 = this.f424192h;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(8, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f424185a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f424185a);
        }
        if (!this.f424186b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424186b);
        }
        if (!this.f424187c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f424187c);
        }
        if (!this.f424188d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f424188d);
        }
        if (!this.f424189e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f424189e);
        }
        long j3 = this.f424190f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        if (!this.f424191g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f424191g);
        }
        boolean z16 = this.f424192h;
        if (z16) {
            codedOutputByteBufferNano.writeBool(8, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
