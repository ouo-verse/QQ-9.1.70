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
public final class BatchGetRoomConfigRsp extends ExtendableMessageNano<BatchGetRoomConfigRsp> {
    private static volatile BatchGetRoomConfigRsp[] _emptyArray;
    public RoomConfig[] roomConfigList;

    public BatchGetRoomConfigRsp() {
        clear();
    }

    public static BatchGetRoomConfigRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BatchGetRoomConfigRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BatchGetRoomConfigRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BatchGetRoomConfigRsp) MessageNano.mergeFrom(new BatchGetRoomConfigRsp(), bArr);
    }

    public BatchGetRoomConfigRsp clear() {
        this.roomConfigList = RoomConfig.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        RoomConfig[] roomConfigArr = this.roomConfigList;
        if (roomConfigArr != null && roomConfigArr.length > 0) {
            int i3 = 0;
            while (true) {
                RoomConfig[] roomConfigArr2 = this.roomConfigList;
                if (i3 >= roomConfigArr2.length) {
                    break;
                }
                RoomConfig roomConfig = roomConfigArr2[i3];
                if (roomConfig != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, roomConfig);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        RoomConfig[] roomConfigArr = this.roomConfigList;
        if (roomConfigArr != null && roomConfigArr.length > 0) {
            int i3 = 0;
            while (true) {
                RoomConfig[] roomConfigArr2 = this.roomConfigList;
                if (i3 >= roomConfigArr2.length) {
                    break;
                }
                RoomConfig roomConfig = roomConfigArr2[i3];
                if (roomConfig != null) {
                    codedOutputByteBufferNano.writeMessage(1, roomConfig);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BatchGetRoomConfigRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BatchGetRoomConfigRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BatchGetRoomConfigRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                RoomConfig[] roomConfigArr = this.roomConfigList;
                int length = roomConfigArr == null ? 0 : roomConfigArr.length;
                int i3 = repeatedFieldArrayLength + length;
                RoomConfig[] roomConfigArr2 = new RoomConfig[i3];
                if (length != 0) {
                    System.arraycopy(roomConfigArr, 0, roomConfigArr2, 0, length);
                }
                while (length < i3 - 1) {
                    RoomConfig roomConfig = new RoomConfig();
                    roomConfigArr2[length] = roomConfig;
                    codedInputByteBufferNano.readMessage(roomConfig);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                RoomConfig roomConfig2 = new RoomConfig();
                roomConfigArr2[length] = roomConfig2;
                codedInputByteBufferNano.readMessage(roomConfig2);
                this.roomConfigList = roomConfigArr2;
            }
        }
    }
}
