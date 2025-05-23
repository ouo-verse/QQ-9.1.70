package c55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class a extends MessageNano {

    /* renamed from: g, reason: collision with root package name */
    private static volatile a[] f30378g;

    /* renamed from: a, reason: collision with root package name */
    public int f30379a;

    /* renamed from: b, reason: collision with root package name */
    public long f30380b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f30381c;

    /* renamed from: d, reason: collision with root package name */
    public String f30382d;

    /* renamed from: e, reason: collision with root package name */
    public int f30383e;

    /* renamed from: f, reason: collision with root package name */
    public int f30384f;

    public a() {
        a();
    }

    public static a[] b() {
        if (f30378g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f30378g == null) {
                    f30378g = new a[0];
                }
            }
        }
        return f30378g;
    }

    public a a() {
        this.f30379a = 0;
        this.f30380b = 0L;
        this.f30381c = false;
        this.f30382d = "";
        this.f30383e = 0;
        this.f30384f = 0;
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
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f30384f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f30383e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f30382d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f30381c = codedInputByteBufferNano.readBool();
                        }
                    } else {
                        this.f30380b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1) {
                        this.f30379a = readInt32;
                    }
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f30379a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long j3 = this.f30380b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        boolean z16 = this.f30381c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        if (!this.f30382d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f30382d);
        }
        int i16 = this.f30383e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.f30384f;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f30379a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long j3 = this.f30380b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        boolean z16 = this.f30381c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        if (!this.f30382d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f30382d);
        }
        int i16 = this.f30383e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.f30384f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
