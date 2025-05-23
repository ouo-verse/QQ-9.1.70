package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ao extends ExtendableMessageNano<ao> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f400723a;

    /* renamed from: b, reason: collision with root package name */
    public long f400724b;

    /* renamed from: c, reason: collision with root package name */
    public w f400725c;

    /* renamed from: d, reason: collision with root package name */
    public int f400726d;

    public ao() {
        a();
    }

    public ao a() {
        this.f400723a = false;
        this.f400724b = 0L;
        this.f400725c = null;
        this.f400726d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ao mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f400726d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            if (this.f400725c == null) {
                                this.f400725c = new w();
                            }
                            codedInputByteBufferNano.readMessage(this.f400725c);
                        }
                    } else {
                        this.f400724b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f400723a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f400723a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        long j3 = this.f400724b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        w wVar = this.f400725c;
        if (wVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, wVar);
        }
        int i3 = this.f400726d;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f400723a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        long j3 = this.f400724b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        w wVar = this.f400725c;
        if (wVar != null) {
            codedOutputByteBufferNano.writeMessage(3, wVar);
        }
        int i3 = this.f400726d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
