package dv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b[] f395016e;

    /* renamed from: a, reason: collision with root package name */
    public String f395017a;

    /* renamed from: b, reason: collision with root package name */
    public int f395018b;

    /* renamed from: c, reason: collision with root package name */
    public String f395019c;

    /* renamed from: d, reason: collision with root package name */
    public int f395020d;

    public b() {
        a();
    }

    public static b[] b() {
        if (f395016e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f395016e == null) {
                    f395016e = new b[0];
                }
            }
        }
        return f395016e;
    }

    public b a() {
        this.f395017a = "";
        this.f395018b = 0;
        this.f395019c = "";
        this.f395020d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f395017a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f395018b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                this.f395019c = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f395020d = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f395017a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f395017a);
        }
        int i3 = this.f395018b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f395019c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f395019c);
        }
        int i16 = this.f395020d;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f395017a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f395017a);
        }
        int i3 = this.f395018b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f395019c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f395019c);
        }
        int i16 = this.f395020d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
