package mw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f417712a;

    /* renamed from: b, reason: collision with root package name */
    public int f417713b;

    /* renamed from: c, reason: collision with root package name */
    public String f417714c;

    /* renamed from: d, reason: collision with root package name */
    public String f417715d;

    /* renamed from: e, reason: collision with root package name */
    public String f417716e;

    /* renamed from: f, reason: collision with root package name */
    public String f417717f;

    /* renamed from: g, reason: collision with root package name */
    public long f417718g;

    /* renamed from: h, reason: collision with root package name */
    public float f417719h;

    /* renamed from: i, reason: collision with root package name */
    public String f417720i;

    /* renamed from: j, reason: collision with root package name */
    public String f417721j;

    /* renamed from: k, reason: collision with root package name */
    public String f417722k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f417723l;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f417712a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f417713b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f417714c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f417715d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f417716e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f417717f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f417718g = codedInputByteBufferNano.readInt64();
                    break;
                case 69:
                    this.f417719h = codedInputByteBufferNano.readFloat();
                    break;
                case 74:
                    this.f417720i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f417721j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f417722k = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f417723l = codedInputByteBufferNano.readBool();
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
        int i3 = this.f417712a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f417713b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f417714c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f417714c);
        }
        if (!this.f417715d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f417715d);
        }
        if (!this.f417716e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f417716e);
        }
        if (!this.f417717f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f417717f);
        }
        long j3 = this.f417718g;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j3);
        }
        if (Float.floatToIntBits(this.f417719h) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(8, this.f417719h);
        }
        if (!this.f417720i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f417720i);
        }
        if (!this.f417721j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f417721j);
        }
        if (!this.f417722k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f417722k);
        }
        boolean z16 = this.f417723l;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(12, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f417712a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f417713b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f417714c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f417714c);
        }
        if (!this.f417715d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f417715d);
        }
        if (!this.f417716e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f417716e);
        }
        if (!this.f417717f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f417717f);
        }
        long j3 = this.f417718g;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j3);
        }
        if (Float.floatToIntBits(this.f417719h) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(8, this.f417719h);
        }
        if (!this.f417720i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f417720i);
        }
        if (!this.f417721j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f417721j);
        }
        if (!this.f417722k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f417722k);
        }
        boolean z16 = this.f417723l;
        if (z16) {
            codedOutputByteBufferNano.writeBool(12, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f417712a = 0;
        this.f417713b = 0;
        this.f417714c = "";
        this.f417715d = "";
        this.f417716e = "";
        this.f417717f = "";
        this.f417718g = 0L;
        this.f417719h = 0.0f;
        this.f417720i = "";
        this.f417721j = "";
        this.f417722k = "";
        this.f417723l = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
