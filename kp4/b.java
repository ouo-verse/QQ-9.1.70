package kp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile b[] f412846h;

    /* renamed from: a, reason: collision with root package name */
    public long f412847a;

    /* renamed from: b, reason: collision with root package name */
    public long f412848b;

    /* renamed from: c, reason: collision with root package name */
    public int f412849c;

    /* renamed from: d, reason: collision with root package name */
    public int f412850d;

    /* renamed from: e, reason: collision with root package name */
    public int f412851e;

    /* renamed from: f, reason: collision with root package name */
    public long f412852f;

    /* renamed from: g, reason: collision with root package name */
    public long f412853g;

    public b() {
        a();
    }

    public static b[] b() {
        if (f412846h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f412846h == null) {
                    f412846h = new b[0];
                }
            }
        }
        return f412846h;
    }

    public b a() {
        this.f412847a = 0L;
        this.f412848b = 0L;
        this.f412849c = 0;
        this.f412850d = 0;
        this.f412851e = 0;
        this.f412852f = 0L;
        this.f412853g = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f412853g = codedInputByteBufferNano.readInt64();
                                        }
                                    } else {
                                        this.f412852f = codedInputByteBufferNano.readInt64();
                                    }
                                } else {
                                    this.f412851e = codedInputByteBufferNano.readInt32();
                                }
                            } else {
                                this.f412850d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            this.f412849c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        this.f412848b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    this.f412847a = codedInputByteBufferNano.readInt64();
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
        long j3 = this.f412847a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f412848b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        int i3 = this.f412849c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        int i16 = this.f412850d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i16);
        }
        int i17 = this.f412851e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i17);
        }
        long j17 = this.f412852f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j17);
        }
        long j18 = this.f412853g;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(7, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f412847a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f412848b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        int i3 = this.f412849c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        int i16 = this.f412850d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        int i17 = this.f412851e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i17);
        }
        long j17 = this.f412852f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j17);
        }
        long j18 = this.f412853g;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
