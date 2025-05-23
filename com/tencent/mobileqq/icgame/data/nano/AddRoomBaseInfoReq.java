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
public final class AddRoomBaseInfoReq extends ExtendableMessageNano<AddRoomBaseInfoReq> {
    private static volatile AddRoomBaseInfoReq[] _emptyArray;
    public RoomBaseInfo roomBaseInfo;

    public AddRoomBaseInfoReq() {
        clear();
    }

    public static AddRoomBaseInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AddRoomBaseInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AddRoomBaseInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AddRoomBaseInfoReq) MessageNano.mergeFrom(new AddRoomBaseInfoReq(), bArr);
    }

    public AddRoomBaseInfoReq clear() {
        this.roomBaseInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        RoomBaseInfo roomBaseInfo = this.roomBaseInfo;
        if (roomBaseInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, roomBaseInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        RoomBaseInfo roomBaseInfo = this.roomBaseInfo;
        if (roomBaseInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, roomBaseInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AddRoomBaseInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AddRoomBaseInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AddRoomBaseInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
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
