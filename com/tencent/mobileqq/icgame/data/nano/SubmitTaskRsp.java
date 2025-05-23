package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SubmitTaskRsp extends ExtendableMessageNano<SubmitTaskRsp> {
    private static volatile SubmitTaskRsp[] _emptyArray;
    public byte[] result;
    public int retcode;
    public String retmsg;

    public SubmitTaskRsp() {
        clear();
    }

    public static SubmitTaskRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SubmitTaskRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SubmitTaskRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SubmitTaskRsp) MessageNano.mergeFrom(new SubmitTaskRsp(), bArr);
    }

    public SubmitTaskRsp clear() {
        this.retcode = 0;
        this.retmsg = "";
        this.result = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retcode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.retmsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.retmsg);
        }
        if (!Arrays.equals(this.result, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(3, this.result);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retcode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.retmsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.retmsg);
        }
        if (!Arrays.equals(this.result, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.result);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SubmitTaskRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SubmitTaskRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SubmitTaskRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retcode = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.retmsg = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.result = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
