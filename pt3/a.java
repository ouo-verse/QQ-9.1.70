package pt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f427106a;

    /* renamed from: b, reason: collision with root package name */
    public int f427107b;

    /* renamed from: c, reason: collision with root package name */
    public int f427108c;

    /* renamed from: d, reason: collision with root package name */
    public String f427109d;

    /* renamed from: e, reason: collision with root package name */
    public int f427110e;

    /* renamed from: f, reason: collision with root package name */
    public c f427111f;

    /* renamed from: g, reason: collision with root package name */
    public long f427112g;

    /* renamed from: h, reason: collision with root package name */
    public int f427113h;

    /* renamed from: i, reason: collision with root package name */
    public int f427114i;

    /* renamed from: j, reason: collision with root package name */
    public int f427115j;

    /* renamed from: k, reason: collision with root package name */
    public String f427116k;

    /* renamed from: l, reason: collision with root package name */
    public long f427117l;

    /* renamed from: m, reason: collision with root package name */
    public long f427118m;

    public a() {
        a();
    }

    public a a() {
        this.f427106a = 0L;
        this.f427107b = 0;
        this.f427108c = 0;
        this.f427109d = "";
        this.f427110e = 0;
        this.f427111f = null;
        this.f427112g = 0L;
        this.f427113h = 0;
        this.f427114i = 0;
        this.f427115j = 0;
        this.f427116k = "";
        this.f427117l = 0L;
        this.f427118m = 0L;
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
                case 8:
                    this.f427106a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f427107b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f427108c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.f427109d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f427110e = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    if (this.f427111f == null) {
                        this.f427111f = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f427111f);
                    break;
                case 56:
                    this.f427112g = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.f427113h = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.f427114i = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.f427115j = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    this.f427116k = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f427117l = codedInputByteBufferNano.readUInt64();
                    break;
                case 104:
                    this.f427118m = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f427106a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f427107b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f427108c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        if (!this.f427109d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427109d);
        }
        int i17 = this.f427110e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        c cVar = this.f427111f;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, cVar);
        }
        long j16 = this.f427112g;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j16);
        }
        int i18 = this.f427113h;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i18);
        }
        int i19 = this.f427114i;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i19);
        }
        int i26 = this.f427115j;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i26);
        }
        if (!this.f427116k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f427116k);
        }
        long j17 = this.f427117l;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(12, j17);
        }
        long j18 = this.f427118m;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(13, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f427106a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f427107b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f427108c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        if (!this.f427109d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427109d);
        }
        int i17 = this.f427110e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        c cVar = this.f427111f;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(6, cVar);
        }
        long j16 = this.f427112g;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j16);
        }
        int i18 = this.f427113h;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i18);
        }
        int i19 = this.f427114i;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i19);
        }
        int i26 = this.f427115j;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i26);
        }
        if (!this.f427116k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f427116k);
        }
        long j17 = this.f427117l;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(12, j17);
        }
        long j18 = this.f427118m;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
