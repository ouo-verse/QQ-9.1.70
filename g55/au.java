package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class au extends ExtendableMessageNano<au> {

    /* renamed from: a, reason: collision with root package name */
    public String f401336a;

    /* renamed from: b, reason: collision with root package name */
    public int f401337b;

    /* renamed from: c, reason: collision with root package name */
    public aa f401338c;

    /* renamed from: d, reason: collision with root package name */
    public as f401339d;

    /* renamed from: e, reason: collision with root package name */
    public long f401340e;

    /* renamed from: f, reason: collision with root package name */
    public int f401341f;

    public au() {
        a();
    }

    public static au c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (au) MessageNano.mergeFrom(new au(), bArr);
    }

    public au a() {
        this.f401336a = "";
        this.f401337b = 0;
        this.f401338c = null;
        this.f401339d = null;
        this.f401340e = 0L;
        this.f401341f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public au mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        int readInt32 = codedInputByteBufferNano.readInt32();
                                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                                            this.f401341f = readInt32;
                                        }
                                    }
                                } else {
                                    this.f401340e = codedInputByteBufferNano.readInt64();
                                }
                            } else {
                                if (this.f401339d == null) {
                                    this.f401339d = new as();
                                }
                                codedInputByteBufferNano.readMessage(this.f401339d);
                            }
                        } else {
                            if (this.f401338c == null) {
                                this.f401338c = new aa();
                            }
                            codedInputByteBufferNano.readMessage(this.f401338c);
                        }
                    } else {
                        this.f401337b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f401336a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f401336a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f401336a);
        }
        int i3 = this.f401337b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        aa aaVar = this.f401338c;
        if (aaVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aaVar);
        }
        as asVar = this.f401339d;
        if (asVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, asVar);
        }
        long j3 = this.f401340e;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j3);
        }
        int i16 = this.f401341f;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f401336a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f401336a);
        }
        int i3 = this.f401337b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        aa aaVar = this.f401338c;
        if (aaVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aaVar);
        }
        as asVar = this.f401339d;
        if (asVar != null) {
            codedOutputByteBufferNano.writeMessage(4, asVar);
        }
        long j3 = this.f401340e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j3);
        }
        int i16 = this.f401341f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
