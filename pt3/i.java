package pt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public long f427148a;

    /* renamed from: b, reason: collision with root package name */
    public int f427149b;

    /* renamed from: c, reason: collision with root package name */
    public int f427150c;

    /* renamed from: d, reason: collision with root package name */
    public String f427151d;

    /* renamed from: e, reason: collision with root package name */
    public int f427152e;

    /* renamed from: f, reason: collision with root package name */
    public c f427153f;

    /* renamed from: g, reason: collision with root package name */
    public long f427154g;

    /* renamed from: h, reason: collision with root package name */
    public int f427155h;

    /* renamed from: i, reason: collision with root package name */
    public int f427156i;

    /* renamed from: j, reason: collision with root package name */
    public int f427157j;

    /* renamed from: k, reason: collision with root package name */
    public String f427158k;

    /* renamed from: l, reason: collision with root package name */
    public long f427159l;

    /* renamed from: m, reason: collision with root package name */
    public long f427160m;

    public i() {
        a();
    }

    public i a() {
        this.f427148a = 0L;
        this.f427149b = 0;
        this.f427150c = 0;
        this.f427151d = "";
        this.f427152e = 0;
        this.f427153f = null;
        this.f427154g = 0L;
        this.f427155h = 0;
        this.f427156i = 0;
        this.f427157j = 0;
        this.f427158k = "";
        this.f427159l = 0L;
        this.f427160m = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f427148a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f427149b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f427150c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.f427151d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f427152e = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    if (this.f427153f == null) {
                        this.f427153f = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f427153f);
                    break;
                case 56:
                    this.f427154g = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.f427155h = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.f427156i = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.f427157j = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    this.f427158k = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f427159l = codedInputByteBufferNano.readUInt64();
                    break;
                case 104:
                    this.f427160m = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f427148a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f427149b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f427150c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        if (!this.f427151d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427151d);
        }
        int i17 = this.f427152e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        c cVar = this.f427153f;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, cVar);
        }
        long j16 = this.f427154g;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j16);
        }
        int i18 = this.f427155h;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i18);
        }
        int i19 = this.f427156i;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i19);
        }
        int i26 = this.f427157j;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i26);
        }
        if (!this.f427158k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f427158k);
        }
        long j17 = this.f427159l;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(12, j17);
        }
        long j18 = this.f427160m;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(13, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f427148a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f427149b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f427150c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        if (!this.f427151d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427151d);
        }
        int i17 = this.f427152e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        c cVar = this.f427153f;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(6, cVar);
        }
        long j16 = this.f427154g;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j16);
        }
        int i18 = this.f427155h;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i18);
        }
        int i19 = this.f427156i;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i19);
        }
        int i26 = this.f427157j;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i26);
        }
        if (!this.f427158k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f427158k);
        }
        long j17 = this.f427159l;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(12, j17);
        }
        long j18 = this.f427160m;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
