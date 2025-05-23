package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SetStageRsp extends ExtendableMessageNano<SetStageRsp> {
    private static volatile SetStageRsp[] _emptyArray;
    public FreePlayBasicInfo basicInfo;
    public int systemTime;

    public SetStageRsp() {
        clear();
    }

    public static SetStageRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetStageRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetStageRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetStageRsp) MessageNano.mergeFrom(new SetStageRsp(), bArr);
    }

    public SetStageRsp clear() {
        this.basicInfo = null;
        this.systemTime = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        FreePlayBasicInfo freePlayBasicInfo = this.basicInfo;
        if (freePlayBasicInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, freePlayBasicInfo);
        }
        int i3 = this.systemTime;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        FreePlayBasicInfo freePlayBasicInfo = this.basicInfo;
        if (freePlayBasicInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, freePlayBasicInfo);
        }
        int i3 = this.systemTime;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetStageRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetStageRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetStageRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.basicInfo == null) {
                    this.basicInfo = new FreePlayBasicInfo();
                }
                codedInputByteBufferNano.readMessage(this.basicInfo);
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.systemTime = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
