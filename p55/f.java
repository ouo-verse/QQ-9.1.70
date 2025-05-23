package p55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile f[] f425385h;

    /* renamed from: a, reason: collision with root package name */
    public int f425386a;

    /* renamed from: b, reason: collision with root package name */
    public String f425387b;

    /* renamed from: c, reason: collision with root package name */
    public int f425388c;

    /* renamed from: d, reason: collision with root package name */
    public String f425389d;

    /* renamed from: e, reason: collision with root package name */
    public int f425390e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f425391f;

    /* renamed from: g, reason: collision with root package name */
    public String f425392g;

    public f() {
        a();
    }

    public static f[] b() {
        if (f425385h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f425385h == null) {
                    f425385h = new f[0];
                }
            }
        }
        return f425385h;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f425386a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f425387b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                switch (readInt32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        this.f425388c = readInt32;
                        break;
                }
            } else if (readTag == 34) {
                this.f425389d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f425390e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.f425391f = codedInputByteBufferNano.readBool();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f425392g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f425386a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f425387b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f425387b);
        }
        int i16 = this.f425388c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        if (!this.f425389d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f425389d);
        }
        int i17 = this.f425390e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        boolean z16 = this.f425391f;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z16);
        }
        return !this.f425392g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f425392g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f425386a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f425387b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f425387b);
        }
        int i16 = this.f425388c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        if (!this.f425389d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f425389d);
        }
        int i17 = this.f425390e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        boolean z16 = this.f425391f;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        if (!this.f425392g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f425392g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f425386a = 0;
        this.f425387b = "";
        this.f425388c = 0;
        this.f425389d = "";
        this.f425390e = 0;
        this.f425391f = false;
        this.f425392g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
