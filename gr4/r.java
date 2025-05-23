package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile r[] f403190d;

    /* renamed from: a, reason: collision with root package name */
    public int f403191a;

    /* renamed from: b, reason: collision with root package name */
    public String f403192b;

    /* renamed from: c, reason: collision with root package name */
    public String f403193c;

    public r() {
        a();
    }

    public static r[] b() {
        if (f403190d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403190d == null) {
                    f403190d = new r[0];
                }
            }
        }
        return f403190d;
    }

    public r a() {
        this.f403191a = 0;
        this.f403192b = "";
        this.f403193c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f403193c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f403192b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f403191a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f403191a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f403192b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403192b);
        }
        if (!this.f403193c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f403193c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403191a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f403192b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403192b);
        }
        if (!this.f403193c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403193c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
