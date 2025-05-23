package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class at extends ExtendableMessageNano<at> {

    /* renamed from: a, reason: collision with root package name */
    public aq[] f400735a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f400736b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f400737c;

    /* renamed from: d, reason: collision with root package name */
    public long f400738d;

    /* renamed from: e, reason: collision with root package name */
    public int f400739e;

    /* renamed from: f, reason: collision with root package name */
    public r f400740f;

    /* renamed from: g, reason: collision with root package name */
    public int f400741g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f400742h;

    public at() {
        a();
    }

    public at a() {
        this.f400735a = aq.b();
        this.f400736b = false;
        this.f400737c = false;
        this.f400738d = 0L;
        this.f400739e = 0;
        this.f400740f = null;
        this.f400741g = 0;
        this.f400742h = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public at mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (readTag != 56) {
                                            if (readTag != 64) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                this.f400742h = codedInputByteBufferNano.readBool();
                                            }
                                        } else {
                                            this.f400741g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        if (this.f400740f == null) {
                                            this.f400740f = new r();
                                        }
                                        codedInputByteBufferNano.readMessage(this.f400740f);
                                    }
                                } else {
                                    int readInt32 = codedInputByteBufferNano.readInt32();
                                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4 || readInt32 == 5) {
                                        this.f400739e = readInt32;
                                    }
                                }
                            } else {
                                this.f400738d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f400737c = codedInputByteBufferNano.readBool();
                        }
                    } else {
                        this.f400736b = codedInputByteBufferNano.readBool();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    aq[] aqVarArr = this.f400735a;
                    if (aqVarArr == null) {
                        length = 0;
                    } else {
                        length = aqVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    aq[] aqVarArr2 = new aq[i3];
                    if (length != 0) {
                        System.arraycopy(aqVarArr, 0, aqVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        aq aqVar = new aq();
                        aqVarArr2[length] = aqVar;
                        codedInputByteBufferNano.readMessage(aqVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    aq aqVar2 = new aq();
                    aqVarArr2[length] = aqVar2;
                    codedInputByteBufferNano.readMessage(aqVar2);
                    this.f400735a = aqVarArr2;
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
        aq[] aqVarArr = this.f400735a;
        if (aqVarArr != null && aqVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                aq[] aqVarArr2 = this.f400735a;
                if (i3 >= aqVarArr2.length) {
                    break;
                }
                aq aqVar = aqVarArr2[i3];
                if (aqVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aqVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f400736b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        boolean z17 = this.f400737c;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z17);
        }
        long j3 = this.f400738d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        int i16 = this.f400739e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        r rVar = this.f400740f;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, rVar);
        }
        int i17 = this.f400741g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        boolean z18 = this.f400742h;
        if (z18) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(8, z18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        aq[] aqVarArr = this.f400735a;
        if (aqVarArr != null && aqVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                aq[] aqVarArr2 = this.f400735a;
                if (i3 >= aqVarArr2.length) {
                    break;
                }
                aq aqVar = aqVarArr2[i3];
                if (aqVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, aqVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f400736b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        boolean z17 = this.f400737c;
        if (z17) {
            codedOutputByteBufferNano.writeBool(3, z17);
        }
        long j3 = this.f400738d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        int i16 = this.f400739e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        r rVar = this.f400740f;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(6, rVar);
        }
        int i17 = this.f400741g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        boolean z18 = this.f400742h;
        if (z18) {
            codedOutputByteBufferNano.writeBool(8, z18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
