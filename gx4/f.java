package gx4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile f[] f403765f;

    /* renamed from: a, reason: collision with root package name */
    public int f403766a;

    /* renamed from: b, reason: collision with root package name */
    public int f403767b;

    /* renamed from: c, reason: collision with root package name */
    public int f403768c;

    /* renamed from: d, reason: collision with root package name */
    public int f403769d;

    /* renamed from: e, reason: collision with root package name */
    public int f403770e;

    public f() {
        a();
    }

    public static f[] b() {
        if (f403765f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403765f == null) {
                    f403765f = new f[0];
                }
            }
        }
        return f403765f;
    }

    public f a() {
        this.f403766a = 0;
        this.f403767b = 0;
        this.f403768c = 0;
        this.f403769d = 0;
        this.f403770e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f403770e = codedInputByteBufferNano.readInt32();
                                }
                            } else {
                                this.f403769d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            this.f403768c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        this.f403767b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    this.f403766a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f403766a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f403767b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f403768c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        int i18 = this.f403769d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i18);
        }
        int i19 = this.f403770e;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403766a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f403767b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f403768c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        int i18 = this.f403769d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i18);
        }
        int i19 = this.f403770e;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
