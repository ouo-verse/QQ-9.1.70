package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class FreePlayInfoPush extends ExtendableMessageNano<FreePlayInfoPush> {
    private static volatile FreePlayInfoPush[] _emptyArray;
    public FreePlayBasicInfo basicInfo;
    public int roomId;
    public WaitingInfo waitingInfo;

    public FreePlayInfoPush() {
        clear();
    }

    public static FreePlayInfoPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FreePlayInfoPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FreePlayInfoPush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FreePlayInfoPush) MessageNano.mergeFrom(new FreePlayInfoPush(), bArr);
    }

    public FreePlayInfoPush clear() {
        this.roomId = 0;
        this.basicInfo = null;
        this.waitingInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        FreePlayBasicInfo freePlayBasicInfo = this.basicInfo;
        if (freePlayBasicInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, freePlayBasicInfo);
        }
        WaitingInfo waitingInfo = this.waitingInfo;
        if (waitingInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, waitingInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        FreePlayBasicInfo freePlayBasicInfo = this.basicInfo;
        if (freePlayBasicInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, freePlayBasicInfo);
        }
        WaitingInfo waitingInfo = this.waitingInfo;
        if (waitingInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, waitingInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FreePlayInfoPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FreePlayInfoPush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FreePlayInfoPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.basicInfo == null) {
                    this.basicInfo = new FreePlayBasicInfo();
                }
                codedInputByteBufferNano.readMessage(this.basicInfo);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.waitingInfo == null) {
                    this.waitingInfo = new WaitingInfo();
                }
                codedInputByteBufferNano.readMessage(this.waitingInfo);
            }
        }
    }
}
