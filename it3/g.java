package it3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public long f408732a;

    /* renamed from: b, reason: collision with root package name */
    public long f408733b;

    /* renamed from: c, reason: collision with root package name */
    public long f408734c;

    /* renamed from: d, reason: collision with root package name */
    public long f408735d;

    /* renamed from: e, reason: collision with root package name */
    public long f408736e;

    /* renamed from: f, reason: collision with root package name */
    public long f408737f;

    /* renamed from: g, reason: collision with root package name */
    public long f408738g;

    /* renamed from: h, reason: collision with root package name */
    public long f408739h;

    public g() {
        a();
    }

    public g a() {
        this.f408732a = 0L;
        this.f408733b = 0L;
        this.f408734c = 0L;
        this.f408735d = 0L;
        this.f408736e = 0L;
        this.f408737f = 0L;
        this.f408738g = 0L;
        this.f408739h = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 40) {
                                if (readTag != 48) {
                                    if (readTag != 56) {
                                        if (readTag != 64) {
                                            if (readTag != 72) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                this.f408739h = codedInputByteBufferNano.readUInt64();
                                            }
                                        } else {
                                            this.f408738g = codedInputByteBufferNano.readUInt64();
                                        }
                                    } else {
                                        this.f408737f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f408736e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f408735d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f408734c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f408733b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f408732a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f408732a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f408733b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.f408734c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        long j18 = this.f408735d;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j18);
        }
        long j19 = this.f408736e;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j19);
        }
        long j26 = this.f408737f;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j26);
        }
        long j27 = this.f408738g;
        if (j27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j27);
        }
        long j28 = this.f408739h;
        if (j28 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(9, j28);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f408732a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f408733b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.f408734c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        long j18 = this.f408735d;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j18);
        }
        long j19 = this.f408736e;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j19);
        }
        long j26 = this.f408737f;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j26);
        }
        long j27 = this.f408738g;
        if (j27 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j27);
        }
        long j28 = this.f408739h;
        if (j28 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j28);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
