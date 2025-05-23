package n55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: k, reason: collision with root package name */
    private static volatile a[] f418391k;

    /* renamed from: a, reason: collision with root package name */
    public long f418392a;

    /* renamed from: b, reason: collision with root package name */
    public String f418393b;

    /* renamed from: c, reason: collision with root package name */
    public String f418394c;

    /* renamed from: d, reason: collision with root package name */
    public int f418395d;

    /* renamed from: e, reason: collision with root package name */
    public int f418396e;

    /* renamed from: f, reason: collision with root package name */
    public int f418397f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f418398g;

    /* renamed from: h, reason: collision with root package name */
    public String f418399h;

    /* renamed from: i, reason: collision with root package name */
    public int f418400i;

    /* renamed from: j, reason: collision with root package name */
    public long f418401j;

    public a() {
        a();
    }

    public static a[] b() {
        if (f418391k == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f418391k == null) {
                    f418391k = new a[0];
                }
            }
        }
        return f418391k;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f418392a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.f418393b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f418394c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                        break;
                    } else {
                        this.f418395d = readInt32;
                        break;
                    }
                case 40:
                    this.f418396e = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.f418397f = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.f418398g = codedInputByteBufferNano.readBool();
                    break;
                case 64:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.f418400i = readInt322;
                        break;
                    }
                case 72:
                    this.f418401j = codedInputByteBufferNano.readUInt64();
                    break;
                case 802:
                    this.f418399h = codedInputByteBufferNano.readString();
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
        long j3 = this.f418392a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f418393b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f418393b);
        }
        if (!this.f418394c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f418394c);
        }
        int i3 = this.f418395d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        int i16 = this.f418396e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.f418397f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        boolean z16 = this.f418398g;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z16);
        }
        int i18 = this.f418400i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i18);
        }
        long j16 = this.f418401j;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j16);
        }
        return !this.f418399h.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(100, this.f418399h) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f418392a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f418393b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f418393b);
        }
        if (!this.f418394c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f418394c);
        }
        int i3 = this.f418395d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        int i16 = this.f418396e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.f418397f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        boolean z16 = this.f418398g;
        if (z16) {
            codedOutputByteBufferNano.writeBool(7, z16);
        }
        int i18 = this.f418400i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i18);
        }
        long j16 = this.f418401j;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j16);
        }
        if (!this.f418399h.equals("")) {
            codedOutputByteBufferNano.writeString(100, this.f418399h);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f418392a = 0L;
        this.f418393b = "";
        this.f418394c = "";
        this.f418395d = 0;
        this.f418396e = 0;
        this.f418397f = 0;
        this.f418398g = false;
        this.f418399h = "";
        this.f418400i = 0;
        this.f418401j = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
