package kr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile b[] f412915j;

    /* renamed from: a, reason: collision with root package name */
    public int f412916a;

    /* renamed from: b, reason: collision with root package name */
    public int f412917b;

    /* renamed from: c, reason: collision with root package name */
    public long f412918c;

    /* renamed from: d, reason: collision with root package name */
    public int f412919d;

    /* renamed from: e, reason: collision with root package name */
    public int f412920e;

    /* renamed from: f, reason: collision with root package name */
    public long f412921f;

    /* renamed from: g, reason: collision with root package name */
    public int f412922g;

    /* renamed from: h, reason: collision with root package name */
    public int f412923h;

    /* renamed from: i, reason: collision with root package name */
    public long f412924i;

    public b() {
        a();
    }

    public static b[] b() {
        if (f412915j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f412915j == null) {
                    f412915j = new b[0];
                }
            }
        }
        return f412915j;
    }

    public b a() {
        this.f412916a = 0;
        this.f412917b = 0;
        this.f412918c = 0L;
        this.f412919d = 0;
        this.f412920e = 0;
        this.f412921f = 0L;
        this.f412922g = 0;
        this.f412923h = 0;
        this.f412924i = 0L;
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
                                            if (readTag != 80) {
                                                if (readTag != 88) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f412924i = codedInputByteBufferNano.readUInt64();
                                                }
                                            } else {
                                                int readInt32 = codedInputByteBufferNano.readInt32();
                                                if (readInt32 == 0 || readInt32 == 1) {
                                                    this.f412923h = readInt32;
                                                }
                                            }
                                        } else {
                                            int readInt322 = codedInputByteBufferNano.readInt32();
                                            if (readInt322 == 0 || readInt322 == 1) {
                                                this.f412922g = readInt322;
                                            }
                                        }
                                    } else {
                                        this.f412921f = codedInputByteBufferNano.readInt64();
                                    }
                                } else {
                                    this.f412920e = codedInputByteBufferNano.readInt32();
                                }
                            } else {
                                this.f412919d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            this.f412918c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f412917b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    if (readInt323 != 0) {
                        switch (readInt323) {
                        }
                    }
                    this.f412916a = readInt323;
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
        int i3 = this.f412916a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f412917b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        long j3 = this.f412918c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        int i17 = this.f412919d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i17);
        }
        int i18 = this.f412920e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i18);
        }
        long j16 = this.f412921f;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j16);
        }
        int i19 = this.f412922g;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i19);
        }
        int i26 = this.f412923h;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i26);
        }
        long j17 = this.f412924i;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(11, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f412916a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f412917b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        long j3 = this.f412918c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        int i17 = this.f412919d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i17);
        }
        int i18 = this.f412920e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i18);
        }
        long j16 = this.f412921f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j16);
        }
        int i19 = this.f412922g;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i19);
        }
        int i26 = this.f412923h;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i26);
        }
        long j17 = this.f412924i;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
