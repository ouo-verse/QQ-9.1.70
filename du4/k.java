package du4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f394994a;

    /* renamed from: b, reason: collision with root package name */
    public long f394995b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f394996c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f394997d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f394998e;

    /* renamed from: f, reason: collision with root package name */
    public int f394999f;

    /* renamed from: g, reason: collision with root package name */
    public int f395000g;

    public k() {
        a();
    }

    public k a() {
        this.f394994a = false;
        this.f394995b = 0L;
        this.f394996c = false;
        this.f394997d = false;
        this.f394998e = false;
        this.f394999f = 0;
        this.f395000g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                            int readInt32 = codedInputByteBufferNano.readInt32();
                                            if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                                                this.f395000g = readInt32;
                                            }
                                        }
                                    } else {
                                        this.f394999f = codedInputByteBufferNano.readInt32();
                                    }
                                } else {
                                    this.f394998e = codedInputByteBufferNano.readBool();
                                }
                            } else {
                                this.f394997d = codedInputByteBufferNano.readBool();
                            }
                        } else {
                            this.f394996c = codedInputByteBufferNano.readBool();
                        }
                    } else {
                        this.f394995b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f394994a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f394994a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        long j3 = this.f394995b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        boolean z17 = this.f394996c;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z17);
        }
        boolean z18 = this.f394997d;
        if (z18) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z18);
        }
        boolean z19 = this.f394998e;
        if (z19) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z19);
        }
        int i3 = this.f394999f;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i3);
        }
        int i16 = this.f395000g;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f394994a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        long j3 = this.f394995b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        boolean z17 = this.f394996c;
        if (z17) {
            codedOutputByteBufferNano.writeBool(3, z17);
        }
        boolean z18 = this.f394997d;
        if (z18) {
            codedOutputByteBufferNano.writeBool(4, z18);
        }
        boolean z19 = this.f394998e;
        if (z19) {
            codedOutputByteBufferNano.writeBool(5, z19);
        }
        int i3 = this.f394999f;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i3);
        }
        int i16 = this.f395000g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
