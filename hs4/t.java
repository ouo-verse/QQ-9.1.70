package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: a, reason: collision with root package name */
    public int f406209a;

    /* renamed from: b, reason: collision with root package name */
    public int f406210b;

    /* renamed from: c, reason: collision with root package name */
    public String f406211c;

    /* renamed from: d, reason: collision with root package name */
    public String f406212d;

    /* renamed from: e, reason: collision with root package name */
    public String f406213e;

    /* renamed from: f, reason: collision with root package name */
    public String f406214f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f406215g;

    /* renamed from: h, reason: collision with root package name */
    public String f406216h;

    /* renamed from: i, reason: collision with root package name */
    public String f406217i;

    /* renamed from: j, reason: collision with root package name */
    public String f406218j;

    public t() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f406209a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f406210b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f406211c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f406212d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f406213e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f406214f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f406215g = codedInputByteBufferNano.readBytes();
                    break;
                case 66:
                    this.f406216h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f406217i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f406218j = codedInputByteBufferNano.readString();
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
        int i3 = this.f406209a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f406210b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f406211c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f406211c);
        }
        if (!this.f406212d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f406212d);
        }
        if (!this.f406213e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f406213e);
        }
        if (!this.f406214f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f406214f);
        }
        if (!Arrays.equals(this.f406215g, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(7, this.f406215g);
        }
        if (!this.f406216h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f406216h);
        }
        if (!this.f406217i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f406217i);
        }
        return !this.f406218j.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f406218j) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f406209a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f406210b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f406211c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406211c);
        }
        if (!this.f406212d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f406212d);
        }
        if (!this.f406213e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f406213e);
        }
        if (!this.f406214f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f406214f);
        }
        if (!Arrays.equals(this.f406215g, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(7, this.f406215g);
        }
        if (!this.f406216h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f406216h);
        }
        if (!this.f406217i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f406217i);
        }
        if (!this.f406218j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f406218j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public t a() {
        this.f406209a = 0;
        this.f406210b = 0;
        this.f406211c = "";
        this.f406212d = "";
        this.f406213e = "";
        this.f406214f = "";
        this.f406215g = WireFormatNano.EMPTY_BYTES;
        this.f406216h = "";
        this.f406217i = "";
        this.f406218j = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
