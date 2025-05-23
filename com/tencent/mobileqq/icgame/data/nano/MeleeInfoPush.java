package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class MeleeInfoPush extends ExtendableMessageNano<MeleeInfoPush> {
    private static volatile MeleeInfoPush[] _emptyArray;
    public MeleeBasicInfo meleeBasicInfo;
    public int roomId;
    public WaitingInfo waitingInfo;

    public MeleeInfoPush() {
        clear();
    }

    public static MeleeInfoPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MeleeInfoPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MeleeInfoPush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MeleeInfoPush) MessageNano.mergeFrom(new MeleeInfoPush(), bArr);
    }

    public MeleeInfoPush clear() {
        this.roomId = 0;
        this.meleeBasicInfo = null;
        this.waitingInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
        MeleeBasicInfo meleeBasicInfo = this.meleeBasicInfo;
        if (meleeBasicInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, meleeBasicInfo);
        }
        WaitingInfo waitingInfo = this.waitingInfo;
        if (waitingInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, waitingInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        MeleeBasicInfo meleeBasicInfo = this.meleeBasicInfo;
        if (meleeBasicInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, meleeBasicInfo);
        }
        WaitingInfo waitingInfo = this.waitingInfo;
        if (waitingInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, waitingInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MeleeInfoPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MeleeInfoPush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MeleeInfoPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.meleeBasicInfo == null) {
                    this.meleeBasicInfo = new MeleeBasicInfo();
                }
                codedInputByteBufferNano.readMessage(this.meleeBasicInfo);
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
