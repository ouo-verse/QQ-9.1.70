package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class v extends ExtendableMessageNano<v> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile v[] f400817h;

    /* renamed from: a, reason: collision with root package name */
    public s f400818a;

    /* renamed from: b, reason: collision with root package name */
    public String f400819b;

    /* renamed from: c, reason: collision with root package name */
    public int f400820c;

    /* renamed from: d, reason: collision with root package name */
    public long f400821d;

    /* renamed from: e, reason: collision with root package name */
    public long f400822e;

    /* renamed from: f, reason: collision with root package name */
    public int f400823f;

    /* renamed from: g, reason: collision with root package name */
    public int f400824g;

    public v() {
        a();
    }

    public static v[] b() {
        if (f400817h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400817h == null) {
                    f400817h = new v[0];
                }
            }
        }
        return f400817h;
    }

    public static v d(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (v) MessageNano.mergeFrom(new v(), bArr);
    }

    public v a() {
        this.f400818a = null;
        this.f400819b = "";
        this.f400820c = 0;
        this.f400821d = 0L;
        this.f400822e = 0L;
        this.f400823f = 0;
        this.f400824g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public v mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f400824g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        int readInt32 = codedInputByteBufferNano.readInt32();
                                        if (readInt32 == 0 || readInt32 == 100 || readInt32 == 200) {
                                            this.f400823f = readInt32;
                                        }
                                    }
                                } else {
                                    this.f400822e = codedInputByteBufferNano.readInt64();
                                }
                            } else {
                                this.f400821d = codedInputByteBufferNano.readInt64();
                            }
                        } else {
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 == 0 || readInt322 == 1) {
                                this.f400820c = readInt322;
                            }
                        }
                    } else {
                        this.f400819b = codedInputByteBufferNano.readString();
                    }
                } else {
                    if (this.f400818a == null) {
                        this.f400818a = new s();
                    }
                    codedInputByteBufferNano.readMessage(this.f400818a);
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
        s sVar = this.f400818a;
        if (sVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sVar);
        }
        if (!this.f400819b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f400819b);
        }
        int i3 = this.f400820c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        long j3 = this.f400821d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j3);
        }
        long j16 = this.f400822e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j16);
        }
        int i16 = this.f400823f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        int i17 = this.f400824g;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        s sVar = this.f400818a;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(1, sVar);
        }
        if (!this.f400819b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400819b);
        }
        int i3 = this.f400820c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        long j3 = this.f400821d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j3);
        }
        long j16 = this.f400822e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j16);
        }
        int i16 = this.f400823f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        int i17 = this.f400824g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
