package iz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a[] f408990d;

    /* renamed from: a, reason: collision with root package name */
    public String f408991a;

    /* renamed from: b, reason: collision with root package name */
    public String f408992b;

    /* renamed from: c, reason: collision with root package name */
    public int f408993c;

    public a() {
        a();
    }

    public static a[] b() {
        if (f408990d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f408990d == null) {
                    f408990d = new a[0];
                }
            }
        }
        return f408990d;
    }

    public a a() {
        this.f408991a = "";
        this.f408992b = "";
        this.f408993c = 0;
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
                            this.f408993c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f408992b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f408991a = codedInputByteBufferNano.readString();
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
        if (!this.f408991a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f408991a);
        }
        if (!this.f408992b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f408992b);
        }
        int i3 = this.f408993c;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f408991a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f408991a);
        }
        if (!this.f408992b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f408992b);
        }
        int i3 = this.f408993c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
