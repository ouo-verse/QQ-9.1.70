package et4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: i, reason: collision with root package name */
    private static volatile a[] f397113i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f397114a;

    /* renamed from: b, reason: collision with root package name */
    public String f397115b;

    /* renamed from: c, reason: collision with root package name */
    public String f397116c;

    /* renamed from: d, reason: collision with root package name */
    public int f397117d;

    /* renamed from: e, reason: collision with root package name */
    public int f397118e;

    /* renamed from: f, reason: collision with root package name */
    public f f397119f;

    /* renamed from: g, reason: collision with root package name */
    public g f397120g;

    /* renamed from: h, reason: collision with root package name */
    public String f397121h;

    public a() {
        a();
    }

    public static a[] b() {
        if (f397113i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f397113i == null) {
                    f397113i = new a[0];
                }
            }
        }
        return f397113i;
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
                this.f397114a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                this.f397115b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f397116c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4 || readInt32 == 5) {
                    this.f397117d = readInt32;
                }
            } else if (readTag == 40) {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3) {
                    this.f397118e = readInt322;
                }
            } else if (readTag == 50) {
                if (this.f397119f == null) {
                    this.f397119f = new f();
                }
                codedInputByteBufferNano.readMessage(this.f397119f);
            } else if (readTag == 58) {
                if (this.f397120g == null) {
                    this.f397120g = new g();
                }
                codedInputByteBufferNano.readMessage(this.f397120g);
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f397121h = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f397114a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        if (!this.f397115b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f397115b);
        }
        if (!this.f397116c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f397116c);
        }
        int i3 = this.f397117d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        int i16 = this.f397118e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        f fVar = this.f397119f;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, fVar);
        }
        g gVar = this.f397120g;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, gVar);
        }
        return !this.f397121h.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.f397121h) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f397114a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        if (!this.f397115b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f397115b);
        }
        if (!this.f397116c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f397116c);
        }
        int i3 = this.f397117d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        int i16 = this.f397118e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        f fVar = this.f397119f;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(6, fVar);
        }
        g gVar = this.f397120g;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(7, gVar);
        }
        if (!this.f397121h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f397121h);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f397114a = false;
        this.f397115b = "";
        this.f397116c = "";
        this.f397117d = 0;
        this.f397118e = 0;
        this.f397119f = null;
        this.f397120g = null;
        this.f397121h = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
