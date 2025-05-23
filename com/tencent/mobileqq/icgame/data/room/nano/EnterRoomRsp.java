package com.tencent.mobileqq.icgame.data.room.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.mobileqq.icgame.data.nano.SeqInfo;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class EnterRoomRsp extends ExtendableMessageNano<EnterRoomRsp> {
    private static volatile EnterRoomRsp[] _emptyArray;
    public byte[] avAuthKey;
    public long result;
    public String resultTip;
    public RoomInfo roomInfo;
    public UserInfo selfInfo;
    public SeqInfo stageInfo;

    public EnterRoomRsp() {
        clear();
    }

    public static EnterRoomRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EnterRoomRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EnterRoomRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EnterRoomRsp) MessageNano.mergeFrom(new EnterRoomRsp(), bArr);
    }

    public EnterRoomRsp clear() {
        this.roomInfo = null;
        this.selfInfo = null;
        this.stageInfo = null;
        this.avAuthKey = WireFormatNano.EMPTY_BYTES;
        this.result = 0L;
        this.resultTip = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        RoomInfo roomInfo = this.roomInfo;
        if (roomInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, roomInfo);
        }
        UserInfo userInfo = this.selfInfo;
        if (userInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
        }
        SeqInfo seqInfo = this.stageInfo;
        if (seqInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, seqInfo);
        }
        if (!Arrays.equals(this.avAuthKey, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.avAuthKey);
        }
        long j3 = this.result;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j3);
        }
        if (!this.resultTip.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.resultTip);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        RoomInfo roomInfo = this.roomInfo;
        if (roomInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, roomInfo);
        }
        UserInfo userInfo = this.selfInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo);
        }
        SeqInfo seqInfo = this.stageInfo;
        if (seqInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, seqInfo);
        }
        if (!Arrays.equals(this.avAuthKey, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.avAuthKey);
        }
        long j3 = this.result;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j3);
        }
        if (!this.resultTip.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.resultTip);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EnterRoomRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EnterRoomRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EnterRoomRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.roomInfo == null) {
                    this.roomInfo = new RoomInfo();
                }
                codedInputByteBufferNano.readMessage(this.roomInfo);
            } else if (readTag == 18) {
                if (this.selfInfo == null) {
                    this.selfInfo = new UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.selfInfo);
            } else if (readTag == 26) {
                if (this.stageInfo == null) {
                    this.stageInfo = new SeqInfo();
                }
                codedInputByteBufferNano.readMessage(this.stageInfo);
            } else if (readTag == 34) {
                this.avAuthKey = codedInputByteBufferNano.readBytes();
            } else if (readTag == 40) {
                this.result = codedInputByteBufferNano.readInt64();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.resultTip = codedInputByteBufferNano.readString();
            }
        }
    }
}
