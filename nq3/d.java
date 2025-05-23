package nq3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public int f420702a;

    /* renamed from: b, reason: collision with root package name */
    public int f420703b;

    /* renamed from: c, reason: collision with root package name */
    public int f420704c;

    /* renamed from: d, reason: collision with root package name */
    public int f420705d;

    /* renamed from: e, reason: collision with root package name */
    public long f420706e;

    /* renamed from: f, reason: collision with root package name */
    public a f420707f;

    public d() {
        a();
    }

    public d a() {
        this.f420702a = 0;
        this.f420703b = 0;
        this.f420704c = 0;
        this.f420705d = 0;
        this.f420706e = 0L;
        this.f420707f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        if (this.f420707f == null) {
                                            this.f420707f = new a();
                                        }
                                        codedInputByteBufferNano.readMessage(this.f420707f);
                                    }
                                } else {
                                    this.f420706e = codedInputByteBufferNano.readInt64();
                                }
                            } else {
                                this.f420705d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            this.f420704c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        this.f420703b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    this.f420702a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f420702a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f420703b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f420704c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        int i18 = this.f420705d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i18);
        }
        long j3 = this.f420706e;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j3);
        }
        a aVar = this.f420707f;
        if (aVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, aVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f420702a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f420703b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f420704c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        int i18 = this.f420705d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i18);
        }
        long j3 = this.f420706e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j3);
        }
        a aVar = this.f420707f;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(6, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
