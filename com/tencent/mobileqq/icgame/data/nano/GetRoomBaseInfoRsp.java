package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetRoomBaseInfoRsp extends ExtendableMessageNano<GetRoomBaseInfoRsp> {
    private static volatile GetRoomBaseInfoRsp[] _emptyArray;
    public RoomBaseInfo[] roomBaseInfos;

    public GetRoomBaseInfoRsp() {
        clear();
    }

    public static GetRoomBaseInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetRoomBaseInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetRoomBaseInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetRoomBaseInfoRsp) MessageNano.mergeFrom(new GetRoomBaseInfoRsp(), bArr);
    }

    public GetRoomBaseInfoRsp clear() {
        this.roomBaseInfos = RoomBaseInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        RoomBaseInfo[] roomBaseInfoArr = this.roomBaseInfos;
        if (roomBaseInfoArr != null && roomBaseInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                RoomBaseInfo[] roomBaseInfoArr2 = this.roomBaseInfos;
                if (i3 >= roomBaseInfoArr2.length) {
                    break;
                }
                RoomBaseInfo roomBaseInfo = roomBaseInfoArr2[i3];
                if (roomBaseInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, roomBaseInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        RoomBaseInfo[] roomBaseInfoArr = this.roomBaseInfos;
        if (roomBaseInfoArr != null && roomBaseInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                RoomBaseInfo[] roomBaseInfoArr2 = this.roomBaseInfos;
                if (i3 >= roomBaseInfoArr2.length) {
                    break;
                }
                RoomBaseInfo roomBaseInfo = roomBaseInfoArr2[i3];
                if (roomBaseInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, roomBaseInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetRoomBaseInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetRoomBaseInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetRoomBaseInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                RoomBaseInfo[] roomBaseInfoArr = this.roomBaseInfos;
                int length = roomBaseInfoArr == null ? 0 : roomBaseInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                RoomBaseInfo[] roomBaseInfoArr2 = new RoomBaseInfo[i3];
                if (length != 0) {
                    System.arraycopy(roomBaseInfoArr, 0, roomBaseInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    RoomBaseInfo roomBaseInfo = new RoomBaseInfo();
                    roomBaseInfoArr2[length] = roomBaseInfo;
                    codedInputByteBufferNano.readMessage(roomBaseInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                RoomBaseInfo roomBaseInfo2 = new RoomBaseInfo();
                roomBaseInfoArr2[length] = roomBaseInfo2;
                codedInputByteBufferNano.readMessage(roomBaseInfo2);
                this.roomBaseInfos = roomBaseInfoArr2;
            }
        }
    }
}
