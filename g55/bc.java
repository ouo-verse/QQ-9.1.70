package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class bc extends ExtendableMessageNano<bc> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile bc[] f401352e;

    /* renamed from: a, reason: collision with root package name */
    public String f401353a;

    /* renamed from: b, reason: collision with root package name */
    public String f401354b;

    /* renamed from: c, reason: collision with root package name */
    public int f401355c;

    /* renamed from: d, reason: collision with root package name */
    public long f401356d;

    public bc() {
        a();
    }

    public static bc[] b() {
        if (f401352e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f401352e == null) {
                    f401352e = new bc[0];
                }
            }
        }
        return f401352e;
    }

    public bc a() {
        this.f401353a = "";
        this.f401354b = "";
        this.f401355c = 0;
        this.f401356d = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bc mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f401356d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f401355c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f401354b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f401353a = codedInputByteBufferNano.readString();
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
        if (!this.f401353a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f401353a);
        }
        if (!this.f401354b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f401354b);
        }
        int i3 = this.f401355c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        long j3 = this.f401356d;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f401353a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f401353a);
        }
        if (!this.f401354b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f401354b);
        }
        int i3 = this.f401355c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        long j3 = this.f401356d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
