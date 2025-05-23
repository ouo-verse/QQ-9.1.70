package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public v[] f400772a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f400773b;

    /* renamed from: c, reason: collision with root package name */
    public long f400774c;

    /* renamed from: d, reason: collision with root package name */
    public long f400775d;

    /* renamed from: e, reason: collision with root package name */
    public long f400776e;

    public g() {
        a();
    }

    public g a() {
        this.f400772a = v.b();
        this.f400773b = false;
        this.f400774c = 0L;
        this.f400775d = 0L;
        this.f400776e = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
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
                                    this.f400776e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f400775d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f400774c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f400773b = codedInputByteBufferNano.readBool();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    v[] vVarArr = this.f400772a;
                    if (vVarArr == null) {
                        length = 0;
                    } else {
                        length = vVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    v[] vVarArr2 = new v[i3];
                    if (length != 0) {
                        System.arraycopy(vVarArr, 0, vVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        v vVar = new v();
                        vVarArr2[length] = vVar;
                        codedInputByteBufferNano.readMessage(vVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    v vVar2 = new v();
                    vVarArr2[length] = vVar2;
                    codedInputByteBufferNano.readMessage(vVar2);
                    this.f400772a = vVarArr2;
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
        v[] vVarArr = this.f400772a;
        if (vVarArr != null && vVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                v[] vVarArr2 = this.f400772a;
                if (i3 >= vVarArr2.length) {
                    break;
                }
                v vVar = vVarArr2[i3];
                if (vVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, vVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f400773b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        long j3 = this.f400774c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        long j16 = this.f400775d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        long j17 = this.f400776e;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        v[] vVarArr = this.f400772a;
        if (vVarArr != null && vVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                v[] vVarArr2 = this.f400772a;
                if (i3 >= vVarArr2.length) {
                    break;
                }
                v vVar = vVarArr2[i3];
                if (vVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, vVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f400773b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        long j3 = this.f400774c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        long j16 = this.f400775d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        long j17 = this.f400776e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
