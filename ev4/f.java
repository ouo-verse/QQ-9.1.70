package ev4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile f[] f397232e;

    /* renamed from: a, reason: collision with root package name */
    public int f397233a;

    /* renamed from: b, reason: collision with root package name */
    public int f397234b;

    /* renamed from: c, reason: collision with root package name */
    public String f397235c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f397236d;

    public f() {
        a();
    }

    public static f[] b() {
        if (f397232e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f397232e == null) {
                    f397232e = new f[0];
                }
            }
        }
        return f397232e;
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
                this.f397233a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f397234b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                this.f397235c = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f397236d = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f397233a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f397234b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        if (!this.f397235c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f397235c);
        }
        boolean z16 = this.f397236d;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f397233a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f397234b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        if (!this.f397235c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f397235c);
        }
        boolean z16 = this.f397236d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f397233a = 0;
        this.f397234b = 0;
        this.f397235c = "";
        this.f397236d = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
