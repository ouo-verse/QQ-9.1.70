package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class SendExpressionPush extends ExtendableMessageNano<SendExpressionPush> {
    private static volatile SendExpressionPush[] _emptyArray;
    public int dynamicResult;
    public int expressionId;
    public int expressionIndex;
    public String expressionName;
    public int expressionType;
    public long roomId;
    public String sendNick;
    public int sendSeatNo;
    public long sendUid;

    public SendExpressionPush() {
        clear();
    }

    public static SendExpressionPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SendExpressionPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SendExpressionPush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SendExpressionPush) MessageNano.mergeFrom(new SendExpressionPush(), bArr);
    }

    public SendExpressionPush clear() {
        this.expressionType = 0;
        this.expressionId = 0;
        this.expressionName = "";
        this.expressionIndex = 0;
        this.sendSeatNo = 0;
        this.sendUid = 0L;
        this.sendNick = "";
        this.roomId = 0L;
        this.dynamicResult = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.expressionType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.expressionId;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.expressionName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.expressionName);
        }
        int i17 = this.expressionIndex;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.sendSeatNo;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        long j3 = this.sendUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        if (!this.sendNick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.sendNick);
        }
        long j16 = this.roomId;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j16);
        }
        int i19 = this.dynamicResult;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(9, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.expressionType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.expressionId;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.expressionName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.expressionName);
        }
        int i17 = this.expressionIndex;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.sendSeatNo;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        long j3 = this.sendUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        if (!this.sendNick.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.sendNick);
        }
        long j16 = this.roomId;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j16);
        }
        int i19 = this.dynamicResult;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SendExpressionPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SendExpressionPush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SendExpressionPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.expressionType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.expressionId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.expressionName = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.expressionIndex = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.sendSeatNo = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.sendUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 58) {
                this.sendNick = codedInputByteBufferNano.readString();
            } else if (readTag == 64) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.dynamicResult = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
