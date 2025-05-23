package lz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public String f415830a;

    /* renamed from: b, reason: collision with root package name */
    public String f415831b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f415832c;

    /* renamed from: d, reason: collision with root package name */
    public String f415833d;

    /* renamed from: e, reason: collision with root package name */
    public String f415834e;

    /* renamed from: f, reason: collision with root package name */
    public String f415835f;

    /* renamed from: g, reason: collision with root package name */
    public String f415836g;

    /* renamed from: h, reason: collision with root package name */
    public String f415837h;

    /* renamed from: i, reason: collision with root package name */
    public String f415838i;

    /* renamed from: j, reason: collision with root package name */
    public String f415839j;

    /* renamed from: k, reason: collision with root package name */
    public String f415840k;

    public g() {
        a();
    }

    public g a() {
        this.f415830a = "";
        this.f415831b = "";
        this.f415832c = false;
        this.f415833d = "";
        this.f415834e = "";
        this.f415835f = "";
        this.f415836g = "";
        this.f415837h = "";
        this.f415838i = "";
        this.f415839j = "";
        this.f415840k = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f415830a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f415831b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f415832c = codedInputByteBufferNano.readBool();
                    break;
                case 34:
                    this.f415833d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f415834e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f415835f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f415836g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f415837h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f415838i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f415839j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f415840k = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f415830a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f415830a);
        }
        if (!this.f415831b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f415831b);
        }
        boolean z16 = this.f415832c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        if (!this.f415833d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f415833d);
        }
        if (!this.f415834e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f415834e);
        }
        if (!this.f415835f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f415835f);
        }
        if (!this.f415836g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f415836g);
        }
        if (!this.f415837h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f415837h);
        }
        if (!this.f415838i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f415838i);
        }
        if (!this.f415839j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f415839j);
        }
        if (!this.f415840k.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.f415840k);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f415830a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f415830a);
        }
        if (!this.f415831b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f415831b);
        }
        boolean z16 = this.f415832c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        if (!this.f415833d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f415833d);
        }
        if (!this.f415834e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f415834e);
        }
        if (!this.f415835f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f415835f);
        }
        if (!this.f415836g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f415836g);
        }
        if (!this.f415837h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f415837h);
        }
        if (!this.f415838i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f415838i);
        }
        if (!this.f415839j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f415839j);
        }
        if (!this.f415840k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f415840k);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
