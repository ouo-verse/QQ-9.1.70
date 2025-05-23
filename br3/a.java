package br3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile a[] f29006e;

    /* renamed from: a, reason: collision with root package name */
    public int f29007a;

    /* renamed from: b, reason: collision with root package name */
    public String f29008b;

    /* renamed from: c, reason: collision with root package name */
    public long f29009c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f29010d;

    public a() {
        a();
    }

    public static a[] b() {
        if (f29006e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f29006e == null) {
                    f29006e = new a[0];
                }
            }
        }
        return f29006e;
    }

    public a a() {
        this.f29007a = 0;
        this.f29008b = "";
        this.f29009c = 0L;
        this.f29010d = false;
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
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f29010d = codedInputByteBufferNano.readBool();
                            }
                        } else {
                            this.f29009c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f29008b = codedInputByteBufferNano.readString();
                    }
                } else {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                        this.f29007a = readInt32;
                    }
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
        int i3 = this.f29007a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f29008b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f29008b);
        }
        long j3 = this.f29009c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        boolean z16 = this.f29010d;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f29007a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f29008b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f29008b);
        }
        long j3 = this.f29009c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        boolean z16 = this.f29010d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
