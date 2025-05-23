package ip4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f408138a;

    /* renamed from: b, reason: collision with root package name */
    public long f408139b;

    /* renamed from: c, reason: collision with root package name */
    public long f408140c;

    /* renamed from: d, reason: collision with root package name */
    public long f408141d;

    /* renamed from: e, reason: collision with root package name */
    public String f408142e;

    /* renamed from: f, reason: collision with root package name */
    public int f408143f;

    /* renamed from: g, reason: collision with root package name */
    public String f408144g;

    /* renamed from: h, reason: collision with root package name */
    public int f408145h;

    /* renamed from: i, reason: collision with root package name */
    public String f408146i;

    /* renamed from: j, reason: collision with root package name */
    public int f408147j;

    public a() {
        a();
    }

    public a a() {
        this.f408138a = "";
        this.f408139b = 0L;
        this.f408140c = 0L;
        this.f408141d = 0L;
        this.f408142e = "";
        this.f408143f = 0;
        this.f408144g = "";
        this.f408145h = 0;
        this.f408146i = "";
        this.f408147j = 0;
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
                    this.f408138a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f408139b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.f408140c = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.f408141d = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    this.f408142e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f408143f = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.f408144g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f408145h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f408146i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f408147j = codedInputByteBufferNano.readUInt32();
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
        if (!this.f408138a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f408138a);
        }
        long j3 = this.f408139b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f408140c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        long j17 = this.f408141d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j17);
        }
        if (!this.f408142e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f408142e);
        }
        int i3 = this.f408143f;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        if (!this.f408144g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f408144g);
        }
        int i16 = this.f408145h;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        if (!this.f408146i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f408146i);
        }
        int i17 = this.f408147j;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(10, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f408138a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f408138a);
        }
        long j3 = this.f408139b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f408140c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        long j17 = this.f408141d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j17);
        }
        if (!this.f408142e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f408142e);
        }
        int i3 = this.f408143f;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        if (!this.f408144g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f408144g);
        }
        int i16 = this.f408145h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        if (!this.f408146i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f408146i);
        }
        int i17 = this.f408147j;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
