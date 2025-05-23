package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ag extends ExtendableMessageNano<ag> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile ag[] f400672f;

    /* renamed from: a, reason: collision with root package name */
    public String f400673a;

    /* renamed from: b, reason: collision with root package name */
    public long f400674b;

    /* renamed from: c, reason: collision with root package name */
    public int f400675c;

    /* renamed from: d, reason: collision with root package name */
    public int f400676d;

    /* renamed from: e, reason: collision with root package name */
    public int f400677e;

    public ag() {
        a();
    }

    public static ag[] b() {
        if (f400672f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400672f == null) {
                    f400672f = new ag[0];
                }
            }
        }
        return f400672f;
    }

    public ag a() {
        this.f400673a = "";
        this.f400674b = 0L;
        this.f400675c = 0;
        this.f400676d = 0;
        this.f400677e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ag mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    int readInt32 = codedInputByteBufferNano.readInt32();
                                    if (readInt32 != 0 && readInt32 != 100) {
                                        switch (readInt32) {
                                            case 10:
                                            case 11:
                                            case 12:
                                            case 13:
                                                break;
                                            default:
                                                switch (readInt32) {
                                                    case 20:
                                                    case 21:
                                                    case 22:
                                                    case 23:
                                                        break;
                                                    default:
                                                        switch (readInt32) {
                                                            case 30:
                                                            case 31:
                                                            case 32:
                                                            case 33:
                                                                break;
                                                            default:
                                                                switch (readInt32) {
                                                                    case 40:
                                                                    case 41:
                                                                    case 42:
                                                                    case 43:
                                                                        break;
                                                                    default:
                                                                        switch (readInt32) {
                                                                            case 50:
                                                                            case 51:
                                                                            case 52:
                                                                            case 53:
                                                                            case 54:
                                                                            case 55:
                                                                            case 56:
                                                                            case 57:
                                                                                break;
                                                                            default:
                                                                                switch (readInt32) {
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                    }
                                    this.f400677e = readInt32;
                                }
                            } else {
                                this.f400676d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 == 0 || readInt322 == 1) {
                                this.f400675c = readInt322;
                            }
                        }
                    } else {
                        this.f400674b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    this.f400673a = codedInputByteBufferNano.readString();
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
        if (!this.f400673a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400673a);
        }
        long j3 = this.f400674b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        int i3 = this.f400675c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        int i16 = this.f400676d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f400677e;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400673a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400673a);
        }
        long j3 = this.f400674b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        int i3 = this.f400675c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        int i16 = this.f400676d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f400677e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
