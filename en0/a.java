package en0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a[] f396832d;

    /* renamed from: a, reason: collision with root package name */
    public String f396833a;

    /* renamed from: b, reason: collision with root package name */
    public String f396834b;

    /* renamed from: c, reason: collision with root package name */
    public int f396835c;

    public a() {
        a();
    }

    public static a[] b() {
        if (f396832d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f396832d == null) {
                    f396832d = new a[0];
                }
            }
        }
        return f396832d;
    }

    public a a() {
        this.f396833a = "";
        this.f396834b = "";
        this.f396835c = 0;
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
                            this.f396835c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f396834b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f396833a = codedInputByteBufferNano.readString();
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
        if (!this.f396833a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f396833a);
        }
        if (!this.f396834b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f396834b);
        }
        int i3 = this.f396835c;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f396833a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f396833a);
        }
        if (!this.f396834b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f396834b);
        }
        int i3 = this.f396835c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
