package av4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile a[] f27002e;

    /* renamed from: a, reason: collision with root package name */
    public String f27003a;

    /* renamed from: b, reason: collision with root package name */
    public int f27004b;

    /* renamed from: c, reason: collision with root package name */
    public int f27005c;

    /* renamed from: d, reason: collision with root package name */
    public String f27006d;

    public a() {
        a();
    }

    public static a[] b() {
        if (f27002e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f27002e == null) {
                    f27002e = new a[0];
                }
            }
        }
        return f27002e;
    }

    public a a() {
        this.f27003a = "";
        this.f27004b = 0;
        this.f27005c = 0;
        this.f27006d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f27003a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f27004b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f27005c = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f27006d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f27003a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f27003a);
        }
        int i3 = this.f27004b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f27005c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        return !this.f27006d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f27006d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f27003a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f27003a);
        }
        int i3 = this.f27004b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f27005c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        if (!this.f27006d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f27006d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
