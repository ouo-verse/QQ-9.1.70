package gx4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile d[] f403756e;

    /* renamed from: a, reason: collision with root package name */
    public int f403757a;

    /* renamed from: b, reason: collision with root package name */
    public int f403758b;

    /* renamed from: c, reason: collision with root package name */
    public k f403759c;

    /* renamed from: d, reason: collision with root package name */
    public i f403760d;

    public d() {
        a();
    }

    public static d[] b() {
        if (f403756e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403756e == null) {
                    f403756e = new d[0];
                }
            }
        }
        return f403756e;
    }

    public d a() {
        this.f403757a = 0;
        this.f403758b = 0;
        this.f403759c = null;
        this.f403760d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                if (this.f403760d == null) {
                                    this.f403760d = new i();
                                }
                                codedInputByteBufferNano.readMessage(this.f403760d);
                            }
                        } else {
                            if (this.f403759c == null) {
                                this.f403759c = new k();
                            }
                            codedInputByteBufferNano.readMessage(this.f403759c);
                        }
                    } else {
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.f403758b = readInt32;
                        }
                    }
                } else {
                    this.f403757a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f403757a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f403758b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        k kVar = this.f403759c;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, kVar);
        }
        i iVar = this.f403760d;
        if (iVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, iVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403757a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f403758b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        k kVar = this.f403759c;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(3, kVar);
        }
        i iVar = this.f403760d;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(4, iVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
