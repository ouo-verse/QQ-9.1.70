package ot3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a[] f424006d;

    /* renamed from: a, reason: collision with root package name */
    public String f424007a;

    /* renamed from: b, reason: collision with root package name */
    public int f424008b;

    /* renamed from: c, reason: collision with root package name */
    public String f424009c;

    public a() {
        a();
    }

    public static a[] b() {
        if (f424006d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f424006d == null) {
                    f424006d = new a[0];
                }
            }
        }
        return f424006d;
    }

    public a a() {
        this.f424007a = "";
        this.f424008b = 0;
        this.f424009c = "";
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
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f424009c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f424008b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    this.f424007a = codedInputByteBufferNano.readString();
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
        if (!this.f424007a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f424007a);
        }
        int i3 = this.f424008b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f424009c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f424009c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f424007a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f424007a);
        }
        int i3 = this.f424008b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f424009c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f424009c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
