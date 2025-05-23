package ot3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile c[] f424015f;

    /* renamed from: a, reason: collision with root package name */
    public int f424016a;

    /* renamed from: b, reason: collision with root package name */
    public int f424017b;

    /* renamed from: c, reason: collision with root package name */
    public String f424018c;

    /* renamed from: d, reason: collision with root package name */
    public int f424019d;

    /* renamed from: e, reason: collision with root package name */
    public int f424020e;

    public c() {
        a();
    }

    public static c[] b() {
        if (f424015f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f424015f == null) {
                    f424015f = new c[0];
                }
            }
        }
        return f424015f;
    }

    public c a() {
        this.f424016a = 0;
        this.f424017b = 0;
        this.f424018c = "";
        this.f424019d = 0;
        this.f424020e = 0;
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
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f424020e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f424019d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f424018c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f424017b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    this.f424016a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f424016a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f424017b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        if (!this.f424018c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f424018c);
        }
        int i17 = this.f424019d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.f424020e;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f424016a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f424017b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        if (!this.f424018c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f424018c);
        }
        int i17 = this.f424019d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.f424020e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
