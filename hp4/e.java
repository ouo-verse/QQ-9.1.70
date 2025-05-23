package hp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: i, reason: collision with root package name */
    private static volatile e[] f405858i;

    /* renamed from: a, reason: collision with root package name */
    public String f405859a;

    /* renamed from: b, reason: collision with root package name */
    public String f405860b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f405861c;

    /* renamed from: d, reason: collision with root package name */
    public long f405862d;

    /* renamed from: e, reason: collision with root package name */
    public long f405863e;

    /* renamed from: f, reason: collision with root package name */
    public long f405864f;

    /* renamed from: g, reason: collision with root package name */
    public String f405865g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f405866h;

    public e() {
        a();
    }

    public static e[] b() {
        if (f405858i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f405858i == null) {
                    f405858i = new e[0];
                }
            }
        }
        return f405858i;
    }

    public e a() {
        this.f405859a = "";
        this.f405860b = "";
        this.f405861c = false;
        this.f405862d = 0L;
        this.f405863e = 0L;
        this.f405864f = 0L;
        this.f405865g = "";
        this.f405866h = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (readTag != 64) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                this.f405866h = codedInputByteBufferNano.readBool();
                                            }
                                        } else {
                                            this.f405865g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f405864f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f405863e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f405862d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f405861c = codedInputByteBufferNano.readBool();
                        }
                    } else {
                        this.f405860b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f405859a = codedInputByteBufferNano.readString();
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
        if (!this.f405859a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f405859a);
        }
        if (!this.f405860b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f405860b);
        }
        boolean z16 = this.f405861c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        long j3 = this.f405862d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        long j16 = this.f405863e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        long j17 = this.f405864f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        if (!this.f405865g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f405865g);
        }
        boolean z17 = this.f405866h;
        if (z17) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(8, z17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f405859a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f405859a);
        }
        if (!this.f405860b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f405860b);
        }
        boolean z16 = this.f405861c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        long j3 = this.f405862d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        long j16 = this.f405863e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        long j17 = this.f405864f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        if (!this.f405865g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f405865g);
        }
        boolean z17 = this.f405866h;
        if (z17) {
            codedOutputByteBufferNano.writeBool(8, z17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
