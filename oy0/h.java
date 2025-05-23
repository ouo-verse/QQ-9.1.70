package oy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile h[] f424489f;

    /* renamed from: a, reason: collision with root package name */
    public String f424490a;

    /* renamed from: b, reason: collision with root package name */
    public String f424491b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f424492c;

    /* renamed from: d, reason: collision with root package name */
    public long f424493d;

    /* renamed from: e, reason: collision with root package name */
    public long f424494e;

    public h() {
        a();
    }

    public static h[] b() {
        if (f424489f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f424489f == null) {
                    f424489f = new h[0];
                }
            }
        }
        return f424489f;
    }

    public h a() {
        this.f424490a = "";
        this.f424491b = "";
        this.f424492c = false;
        this.f424493d = 0L;
        this.f424494e = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f424494e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f424493d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f424492c = codedInputByteBufferNano.readBool();
                        }
                    } else {
                        this.f424491b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f424490a = codedInputByteBufferNano.readString();
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
        if (!this.f424490a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f424490a);
        }
        if (!this.f424491b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f424491b);
        }
        boolean z16 = this.f424492c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        long j3 = this.f424493d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        long j16 = this.f424494e;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f424490a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f424490a);
        }
        if (!this.f424491b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424491b);
        }
        boolean z16 = this.f424492c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        long j3 = this.f424493d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        long j16 = this.f424494e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
