package cu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f391870a;

    /* renamed from: b, reason: collision with root package name */
    public String f391871b;

    /* renamed from: c, reason: collision with root package name */
    public int f391872c;

    /* renamed from: d, reason: collision with root package name */
    public int f391873d;

    /* renamed from: e, reason: collision with root package name */
    public String f391874e;

    /* renamed from: f, reason: collision with root package name */
    public String f391875f;

    /* renamed from: g, reason: collision with root package name */
    public hs4.b f391876g;

    /* renamed from: h, reason: collision with root package name */
    public String f391877h;

    /* renamed from: i, reason: collision with root package name */
    public String f391878i;

    /* renamed from: j, reason: collision with root package name */
    public String f391879j;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f391870a = codedInputByteBufferNano.readInt32();
                    break;
                case 18:
                    this.f391871b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f391872c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f391873d = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.f391874e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f391875f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    if (this.f391876g == null) {
                        this.f391876g = new hs4.b();
                    }
                    codedInputByteBufferNano.readMessage(this.f391876g);
                    break;
                case 66:
                    this.f391877h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f391878i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f391879j = codedInputByteBufferNano.readString();
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
        int i3 = this.f391870a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f391871b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f391871b);
        }
        int i16 = this.f391872c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f391873d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        if (!this.f391874e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f391874e);
        }
        if (!this.f391875f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f391875f);
        }
        hs4.b bVar = this.f391876g;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, bVar);
        }
        if (!this.f391877h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f391877h);
        }
        if (!this.f391878i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f391878i);
        }
        return !this.f391879j.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f391879j) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f391870a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f391871b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f391871b);
        }
        int i16 = this.f391872c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f391873d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        if (!this.f391874e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f391874e);
        }
        if (!this.f391875f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f391875f);
        }
        hs4.b bVar = this.f391876g;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(7, bVar);
        }
        if (!this.f391877h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f391877h);
        }
        if (!this.f391878i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f391878i);
        }
        if (!this.f391879j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f391879j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f391870a = 0;
        this.f391871b = "";
        this.f391872c = 0;
        this.f391873d = 0;
        this.f391874e = "";
        this.f391875f = "";
        this.f391876g = null;
        this.f391877h = "";
        this.f391878i = "";
        this.f391879j = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
