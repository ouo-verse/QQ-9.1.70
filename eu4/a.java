package eu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile a[] f397168f;

    /* renamed from: a, reason: collision with root package name */
    public int f397169a;

    /* renamed from: b, reason: collision with root package name */
    public int f397170b;

    /* renamed from: c, reason: collision with root package name */
    public int f397171c;

    /* renamed from: d, reason: collision with root package name */
    public int f397172d;

    /* renamed from: e, reason: collision with root package name */
    public int f397173e;

    public a() {
        a();
    }

    public static a[] b() {
        if (f397168f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f397168f == null) {
                    f397168f = new a[0];
                }
            }
        }
        return f397168f;
    }

    public a a() {
        this.f397169a = 0;
        this.f397170b = 0;
        this.f397171c = 0;
        this.f397172d = 0;
        this.f397173e = 0;
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
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f397173e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f397172d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f397171c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f397170b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f397169a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f397169a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f397170b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.f397171c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.f397172d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        int i19 = this.f397173e;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f397169a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f397170b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.f397171c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.f397172d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        int i19 = this.f397173e;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
