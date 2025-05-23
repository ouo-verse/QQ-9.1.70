package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile k[] f406158h;

    /* renamed from: a, reason: collision with root package name */
    public int f406159a;

    /* renamed from: b, reason: collision with root package name */
    public int f406160b;

    /* renamed from: c, reason: collision with root package name */
    public String f406161c;

    /* renamed from: d, reason: collision with root package name */
    public String f406162d;

    /* renamed from: e, reason: collision with root package name */
    public long f406163e;

    /* renamed from: f, reason: collision with root package name */
    public String f406164f;

    /* renamed from: g, reason: collision with root package name */
    public String f406165g;

    public k() {
        a();
    }

    public static k[] b() {
        if (f406158h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406158h == null) {
                    f406158h = new k[0];
                }
            }
        }
        return f406158h;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f406159a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f406160b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.f406161c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f406162d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f406163e = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 50) {
                this.f406164f = codedInputByteBufferNano.readString();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406165g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f406159a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f406160b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f406161c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f406161c);
        }
        if (!this.f406162d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f406162d);
        }
        long j3 = this.f406163e;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        if (!this.f406164f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f406164f);
        }
        return !this.f406165g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f406165g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f406159a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f406160b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f406161c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406161c);
        }
        if (!this.f406162d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f406162d);
        }
        long j3 = this.f406163e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        if (!this.f406164f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f406164f);
        }
        if (!this.f406165g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f406165g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public k a() {
        this.f406159a = 0;
        this.f406160b = 0;
        this.f406161c = "";
        this.f406162d = "";
        this.f406163e = 0L;
        this.f406164f = "";
        this.f406165g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
