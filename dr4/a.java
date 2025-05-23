package dr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a[] f394687d;

    /* renamed from: a, reason: collision with root package name */
    public String f394688a;

    /* renamed from: b, reason: collision with root package name */
    public String f394689b;

    /* renamed from: c, reason: collision with root package name */
    public int f394690c;

    public a() {
        a();
    }

    public static a[] b() {
        if (f394687d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f394687d == null) {
                    f394687d = new a[0];
                }
            }
        }
        return f394687d;
    }

    public a a() {
        this.f394688a = "";
        this.f394689b = "";
        this.f394690c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f394690c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f394689b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f394688a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f394688a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f394688a);
        }
        if (!this.f394689b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f394689b);
        }
        int i3 = this.f394690c;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f394688a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f394688a);
        }
        if (!this.f394689b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f394689b);
        }
        int i3 = this.f394690c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
