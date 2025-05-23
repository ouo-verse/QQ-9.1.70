package dz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f395230a;

    /* renamed from: b, reason: collision with root package name */
    public long f395231b;

    /* renamed from: c, reason: collision with root package name */
    public long f395232c;

    /* renamed from: d, reason: collision with root package name */
    public long f395233d;

    /* renamed from: e, reason: collision with root package name */
    public String f395234e;

    /* renamed from: f, reason: collision with root package name */
    public int f395235f;

    /* renamed from: g, reason: collision with root package name */
    public String f395236g;

    /* renamed from: h, reason: collision with root package name */
    public int f395237h;

    /* renamed from: i, reason: collision with root package name */
    public String f395238i;

    /* renamed from: j, reason: collision with root package name */
    public int f395239j;

    public a() {
        a();
    }

    public a a() {
        this.f395230a = "";
        this.f395231b = 0L;
        this.f395232c = 0L;
        this.f395233d = 0L;
        this.f395234e = "";
        this.f395235f = 0;
        this.f395236g = "";
        this.f395237h = 0;
        this.f395238i = "";
        this.f395239j = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f395230a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f395231b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.f395232c = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.f395233d = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    this.f395234e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f395235f = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.f395236g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f395237h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f395238i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f395239j = codedInputByteBufferNano.readUInt32();
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
        if (!this.f395230a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f395230a);
        }
        long j3 = this.f395231b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f395232c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        long j17 = this.f395233d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j17);
        }
        if (!this.f395234e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f395234e);
        }
        int i3 = this.f395235f;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        if (!this.f395236g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f395236g);
        }
        int i16 = this.f395237h;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        if (!this.f395238i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f395238i);
        }
        int i17 = this.f395239j;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(10, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f395230a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f395230a);
        }
        long j3 = this.f395231b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f395232c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        long j17 = this.f395233d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j17);
        }
        if (!this.f395234e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f395234e);
        }
        int i3 = this.f395235f;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        if (!this.f395236g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f395236g);
        }
        int i16 = this.f395237h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        if (!this.f395238i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f395238i);
        }
        int i17 = this.f395239j;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
