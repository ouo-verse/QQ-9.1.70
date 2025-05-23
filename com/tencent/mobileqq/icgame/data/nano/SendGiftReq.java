package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SendGiftReq extends ExtendableMessageNano<SendGiftReq> {
    private static volatile SendGiftReq[] _emptyArray;
    public int appid;
    public ComboReq comboReq;
    public int gameMode;
    public String gameRoomId;
    public int giftId;
    public long hostUid;
    public int number;
    public String openid;
    public String openkey;
    public int payFlag;
    public String receiver;
    public int roomId;
    public String sender;
    public String skey;
    public int stageMode;
    public long toUid;
    public long uid;

    public SendGiftReq() {
        clear();
    }

    public static SendGiftReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SendGiftReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SendGiftReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SendGiftReq) MessageNano.mergeFrom(new SendGiftReq(), bArr);
    }

    public SendGiftReq clear() {
        this.roomId = 0;
        this.uid = 0L;
        this.toUid = 0L;
        this.sender = "";
        this.receiver = "";
        this.giftId = 0;
        this.number = 0;
        this.openid = "";
        this.openkey = "";
        this.appid = 0;
        this.comboReq = null;
        this.skey = "";
        this.payFlag = 0;
        this.stageMode = 0;
        this.hostUid = 0L;
        this.gameMode = 0;
        this.gameRoomId = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(2, this.uid) + CodedOutputByteBufferNano.computeUInt64Size(3, this.toUid) + CodedOutputByteBufferNano.computeStringSize(4, this.sender) + CodedOutputByteBufferNano.computeStringSize(5, this.receiver) + CodedOutputByteBufferNano.computeUInt32Size(6, this.giftId) + CodedOutputByteBufferNano.computeUInt32Size(7, this.number);
        if (!this.openid.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.openid);
        }
        if (!this.openkey.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.openkey);
        }
        int i3 = this.appid;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i3);
        }
        ComboReq comboReq = this.comboReq;
        if (comboReq != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, comboReq);
        }
        if (!this.skey.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.skey);
        }
        int i16 = this.payFlag;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i16);
        }
        int i17 = this.stageMode;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i17);
        }
        long j3 = this.hostUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(15, j3);
        }
        int i18 = this.gameMode;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(16, i18);
        }
        if (!this.gameRoomId.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(17, this.gameRoomId);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt64(2, this.uid);
        codedOutputByteBufferNano.writeUInt64(3, this.toUid);
        codedOutputByteBufferNano.writeString(4, this.sender);
        codedOutputByteBufferNano.writeString(5, this.receiver);
        codedOutputByteBufferNano.writeUInt32(6, this.giftId);
        codedOutputByteBufferNano.writeUInt32(7, this.number);
        if (!this.openid.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.openid);
        }
        if (!this.openkey.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.openkey);
        }
        int i3 = this.appid;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i3);
        }
        ComboReq comboReq = this.comboReq;
        if (comboReq != null) {
            codedOutputByteBufferNano.writeMessage(11, comboReq);
        }
        if (!this.skey.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.skey);
        }
        int i16 = this.payFlag;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i16);
        }
        int i17 = this.stageMode;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i17);
        }
        long j3 = this.hostUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(15, j3);
        }
        int i18 = this.gameMode;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(16, i18);
        }
        if (!this.gameRoomId.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.gameRoomId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SendGiftReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SendGiftReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SendGiftReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.roomId = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.toUid = codedInputByteBufferNano.readUInt64();
                    break;
                case 34:
                    this.sender = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.receiver = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.number = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.openid = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.openkey = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.appid = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    if (this.comboReq == null) {
                        this.comboReq = new ComboReq();
                    }
                    codedInputByteBufferNano.readMessage(this.comboReq);
                    break;
                case 98:
                    this.skey = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.payFlag = codedInputByteBufferNano.readUInt32();
                    break;
                case 112:
                    this.stageMode = codedInputByteBufferNano.readUInt32();
                    break;
                case 120:
                    this.hostUid = codedInputByteBufferNano.readUInt64();
                    break;
                case 128:
                    this.gameMode = codedInputByteBufferNano.readUInt32();
                    break;
                case 138:
                    this.gameRoomId = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
