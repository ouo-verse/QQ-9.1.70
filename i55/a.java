package i55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile a[] f407255h;

    /* renamed from: a, reason: collision with root package name */
    public int f407256a;

    /* renamed from: b, reason: collision with root package name */
    public int f407257b;

    /* renamed from: c, reason: collision with root package name */
    public String f407258c;

    /* renamed from: d, reason: collision with root package name */
    public String f407259d;

    /* renamed from: e, reason: collision with root package name */
    public int f407260e;

    /* renamed from: f, reason: collision with root package name */
    public String f407261f;

    /* renamed from: g, reason: collision with root package name */
    public int f407262g;

    public a() {
        a();
    }

    public static a[] b() {
        if (f407255h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f407255h == null) {
                    f407255h = new a[0];
                }
            }
        }
        return f407255h;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f407256a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.f407257b = readInt32;
                }
            } else if (readTag == 26) {
                this.f407258c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f407259d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f407260e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 50) {
                this.f407261f = codedInputByteBufferNano.readString();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f407262g = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f407256a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f407257b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        if (!this.f407258c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f407258c);
        }
        if (!this.f407259d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f407259d);
        }
        int i17 = this.f407260e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        if (!this.f407261f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f407261f);
        }
        int i18 = this.f407262g;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f407256a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f407257b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        if (!this.f407258c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f407258c);
        }
        if (!this.f407259d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f407259d);
        }
        int i17 = this.f407260e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        if (!this.f407261f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f407261f);
        }
        int i18 = this.f407262g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f407256a = 0;
        this.f407257b = 0;
        this.f407258c = "";
        this.f407259d = "";
        this.f407260e = 0;
        this.f407261f = "";
        this.f407262g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
