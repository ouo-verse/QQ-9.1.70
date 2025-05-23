package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class RoomGamePlayState extends ExtendableMessageNano<RoomGamePlayState> {
    private static volatile RoomGamePlayState[] _emptyArray;
    public RoomGamePlayStateItem[] items;
    public int roomId;

    public RoomGamePlayState() {
        clear();
    }

    public static RoomGamePlayState[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RoomGamePlayState[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RoomGamePlayState parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RoomGamePlayState) MessageNano.mergeFrom(new RoomGamePlayState(), bArr);
    }

    public RoomGamePlayState clear() {
        this.roomId = 0;
        this.items = RoomGamePlayStateItem.emptyArray();
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
        RoomGamePlayStateItem[] roomGamePlayStateItemArr = this.items;
        if (roomGamePlayStateItemArr != null && roomGamePlayStateItemArr.length > 0) {
            int i16 = 0;
            while (true) {
                RoomGamePlayStateItem[] roomGamePlayStateItemArr2 = this.items;
                if (i16 >= roomGamePlayStateItemArr2.length) {
                    break;
                }
                RoomGamePlayStateItem roomGamePlayStateItem = roomGamePlayStateItemArr2[i16];
                if (roomGamePlayStateItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, roomGamePlayStateItem);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        RoomGamePlayStateItem[] roomGamePlayStateItemArr = this.items;
        if (roomGamePlayStateItemArr != null && roomGamePlayStateItemArr.length > 0) {
            int i16 = 0;
            while (true) {
                RoomGamePlayStateItem[] roomGamePlayStateItemArr2 = this.items;
                if (i16 >= roomGamePlayStateItemArr2.length) {
                    break;
                }
                RoomGamePlayStateItem roomGamePlayStateItem = roomGamePlayStateItemArr2[i16];
                if (roomGamePlayStateItem != null) {
                    codedOutputByteBufferNano.writeMessage(2, roomGamePlayStateItem);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RoomGamePlayState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RoomGamePlayState().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RoomGamePlayState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                RoomGamePlayStateItem[] roomGamePlayStateItemArr = this.items;
                int length = roomGamePlayStateItemArr == null ? 0 : roomGamePlayStateItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                RoomGamePlayStateItem[] roomGamePlayStateItemArr2 = new RoomGamePlayStateItem[i3];
                if (length != 0) {
                    System.arraycopy(roomGamePlayStateItemArr, 0, roomGamePlayStateItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    RoomGamePlayStateItem roomGamePlayStateItem = new RoomGamePlayStateItem();
                    roomGamePlayStateItemArr2[length] = roomGamePlayStateItem;
                    codedInputByteBufferNano.readMessage(roomGamePlayStateItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                RoomGamePlayStateItem roomGamePlayStateItem2 = new RoomGamePlayStateItem();
                roomGamePlayStateItemArr2[length] = roomGamePlayStateItem2;
                codedInputByteBufferNano.readMessage(roomGamePlayStateItem2);
                this.items = roomGamePlayStateItemArr2;
            }
        }
    }
}
