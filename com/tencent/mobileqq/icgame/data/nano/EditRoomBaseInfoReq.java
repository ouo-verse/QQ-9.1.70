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
public final class EditRoomBaseInfoReq extends ExtendableMessageNano<EditRoomBaseInfoReq> {
    private static volatile EditRoomBaseInfoReq[] _emptyArray;
    public RoomBaseInfo roomBaseInfo;
    public int roomId;

    public EditRoomBaseInfoReq() {
        clear();
    }

    public static EditRoomBaseInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditRoomBaseInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditRoomBaseInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditRoomBaseInfoReq) MessageNano.mergeFrom(new EditRoomBaseInfoReq(), bArr);
    }

    public EditRoomBaseInfoReq clear() {
        this.roomId = 0;
        this.roomBaseInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
        RoomBaseInfo roomBaseInfo = this.roomBaseInfo;
        if (roomBaseInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, roomBaseInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        RoomBaseInfo roomBaseInfo = this.roomBaseInfo;
        if (roomBaseInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, roomBaseInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditRoomBaseInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditRoomBaseInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditRoomBaseInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.roomBaseInfo == null) {
                    this.roomBaseInfo = new RoomBaseInfo();
                }
                codedInputByteBufferNano.readMessage(this.roomBaseInfo);
            }
        }
    }
}
