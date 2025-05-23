package ip4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile c[] f408150h;

    /* renamed from: a, reason: collision with root package name */
    public String f408151a;

    /* renamed from: b, reason: collision with root package name */
    public String f408152b;

    /* renamed from: c, reason: collision with root package name */
    public int f408153c;

    /* renamed from: d, reason: collision with root package name */
    public String f408154d;

    /* renamed from: e, reason: collision with root package name */
    public String f408155e;

    /* renamed from: f, reason: collision with root package name */
    public long f408156f;

    /* renamed from: g, reason: collision with root package name */
    public String f408157g;

    public c() {
        a();
    }

    public static c[] b() {
        if (f408150h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f408150h == null) {
                    f408150h = new c[0];
                }
            }
        }
        return f408150h;
    }

    public c a() {
        this.f408151a = "";
        this.f408152b = "";
        this.f408153c = 0;
        this.f408154d = "";
        this.f408155e = "";
        this.f408156f = 0L;
        this.f408157g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f408157g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f408156f = codedInputByteBufferNano.readInt64();
                                    }
                                } else {
                                    this.f408155e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f408154d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f408153c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f408152b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f408151a = codedInputByteBufferNano.readString();
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
        if (!this.f408151a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f408151a);
        }
        if (!this.f408152b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f408152b);
        }
        int i3 = this.f408153c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.f408154d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f408154d);
        }
        if (!this.f408155e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f408155e);
        }
        long j3 = this.f408156f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j3);
        }
        if (!this.f408157g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f408157g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f408151a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f408151a);
        }
        if (!this.f408152b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f408152b);
        }
        int i3 = this.f408153c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.f408154d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f408154d);
        }
        if (!this.f408155e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f408155e);
        }
        long j3 = this.f408156f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j3);
        }
        if (!this.f408157g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f408157g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
