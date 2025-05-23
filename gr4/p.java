package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: a, reason: collision with root package name */
    public String f403169a;

    /* renamed from: b, reason: collision with root package name */
    public String f403170b;

    /* renamed from: c, reason: collision with root package name */
    public String f403171c;

    /* renamed from: d, reason: collision with root package name */
    public String f403172d;

    /* renamed from: e, reason: collision with root package name */
    public t f403173e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f403174f;

    /* renamed from: g, reason: collision with root package name */
    public long f403175g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f403176h;

    /* renamed from: i, reason: collision with root package name */
    public String f403177i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f403178j;

    /* renamed from: k, reason: collision with root package name */
    public int f403179k;

    /* renamed from: l, reason: collision with root package name */
    public String f403180l;

    /* renamed from: m, reason: collision with root package name */
    public long f403181m;

    /* renamed from: n, reason: collision with root package name */
    public int f403182n;

    /* renamed from: o, reason: collision with root package name */
    public rq4.a f403183o;

    /* renamed from: p, reason: collision with root package name */
    public rq4.b f403184p;

    /* renamed from: q, reason: collision with root package name */
    public String f403185q;

    /* renamed from: r, reason: collision with root package name */
    public int f403186r;

    public p() {
        a();
    }

    public p a() {
        this.f403169a = "";
        this.f403170b = "";
        this.f403171c = "";
        this.f403172d = "";
        this.f403173e = null;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f403174f = bArr;
        this.f403175g = 0L;
        this.f403176h = bArr;
        this.f403177i = "";
        this.f403178j = false;
        this.f403179k = 0;
        this.f403180l = "";
        this.f403181m = 0L;
        this.f403182n = 0;
        this.f403183o = null;
        this.f403184p = null;
        this.f403185q = "";
        this.f403186r = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f403169a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f403170b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f403171c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f403172d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    if (this.f403173e == null) {
                        this.f403173e = new t();
                    }
                    codedInputByteBufferNano.readMessage(this.f403173e);
                    break;
                case 50:
                    this.f403174f = codedInputByteBufferNano.readBytes();
                    break;
                case 56:
                    this.f403175g = codedInputByteBufferNano.readUInt64();
                    break;
                case 66:
                    this.f403176h = codedInputByteBufferNano.readBytes();
                    break;
                case 88:
                    this.f403181m = codedInputByteBufferNano.readUInt64();
                    break;
                case 802:
                    this.f403177i = codedInputByteBufferNano.readString();
                    break;
                case 808:
                    this.f403178j = codedInputByteBufferNano.readBool();
                    break;
                case 816:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f403179k = readInt32;
                        break;
                    }
                case BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO /* 826 */:
                    this.f403180l = codedInputByteBufferNano.readString();
                    break;
                case 832:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1) {
                        break;
                    } else {
                        this.f403182n = readInt322;
                        break;
                    }
                case com.tencent.luggage.wxa.uf.h.CTRL_INDEX /* 842 */:
                    if (this.f403183o == null) {
                        this.f403183o = new rq4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f403183o);
                    break;
                case 850:
                    if (this.f403184p == null) {
                        this.f403184p = new rq4.b();
                    }
                    codedInputByteBufferNano.readMessage(this.f403184p);
                    break;
                case 858:
                    this.f403185q = codedInputByteBufferNano.readString();
                    break;
                case 864:
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2 && readInt323 != 3 && readInt323 != 4) {
                        break;
                    } else {
                        this.f403186r = readInt323;
                        break;
                    }
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
        if (!this.f403169a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f403169a);
        }
        if (!this.f403170b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403170b);
        }
        if (!this.f403171c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f403171c);
        }
        if (!this.f403172d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f403172d);
        }
        t tVar = this.f403173e;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, tVar);
        }
        byte[] bArr = this.f403174f;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.f403174f);
        }
        long j3 = this.f403175g;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
        }
        if (!Arrays.equals(this.f403176h, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.f403176h);
        }
        long j16 = this.f403181m;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j16);
        }
        if (!this.f403177i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(100, this.f403177i);
        }
        boolean z16 = this.f403178j;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(101, z16);
        }
        int i3 = this.f403179k;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(102, i3);
        }
        if (!this.f403180l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(103, this.f403180l);
        }
        int i16 = this.f403182n;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(104, i16);
        }
        rq4.a aVar = this.f403183o;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(105, aVar);
        }
        rq4.b bVar = this.f403184p;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(106, bVar);
        }
        if (!this.f403185q.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(107, this.f403185q);
        }
        int i17 = this.f403186r;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(108, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f403169a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f403169a);
        }
        if (!this.f403170b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403170b);
        }
        if (!this.f403171c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403171c);
        }
        if (!this.f403172d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403172d);
        }
        t tVar = this.f403173e;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(5, tVar);
        }
        byte[] bArr = this.f403174f;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(6, this.f403174f);
        }
        long j3 = this.f403175g;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
        }
        if (!Arrays.equals(this.f403176h, bArr2)) {
            codedOutputByteBufferNano.writeBytes(8, this.f403176h);
        }
        long j16 = this.f403181m;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j16);
        }
        if (!this.f403177i.equals("")) {
            codedOutputByteBufferNano.writeString(100, this.f403177i);
        }
        boolean z16 = this.f403178j;
        if (z16) {
            codedOutputByteBufferNano.writeBool(101, z16);
        }
        int i3 = this.f403179k;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(102, i3);
        }
        if (!this.f403180l.equals("")) {
            codedOutputByteBufferNano.writeString(103, this.f403180l);
        }
        int i16 = this.f403182n;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(104, i16);
        }
        rq4.a aVar = this.f403183o;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(105, aVar);
        }
        rq4.b bVar = this.f403184p;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(106, bVar);
        }
        if (!this.f403185q.equals("")) {
            codedOutputByteBufferNano.writeString(107, this.f403185q);
        }
        int i17 = this.f403186r;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(108, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
