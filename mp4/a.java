package mp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a[] f417135d;

    /* renamed from: a, reason: collision with root package name */
    public int f417136a;

    /* renamed from: b, reason: collision with root package name */
    public String f417137b;

    /* renamed from: c, reason: collision with root package name */
    public int f417138c;

    public a() {
        a();
    }

    public static a[] b() {
        if (f417135d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f417135d == null) {
                    f417135d = new a[0];
                }
            }
        }
        return f417135d;
    }

    public a a() {
        this.f417136a = 0;
        this.f417137b = "";
        this.f417138c = 0;
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
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f417138c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        this.f417137b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f417136a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f417136a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f417137b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f417137b);
        }
        int i16 = this.f417138c;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f417136a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f417137b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f417137b);
        }
        int i16 = this.f417138c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
