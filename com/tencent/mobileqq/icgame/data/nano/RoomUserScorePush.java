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
public final class RoomUserScorePush extends ExtendableMessageNano<RoomUserScorePush> {
    private static volatile RoomUserScorePush[] _emptyArray;
    public int roomId;
    public int updateListType;
    public UserScoreItem[] userScoreRemoveItem;
    public UserScoreItem[] userScoreUpdateItem;

    public RoomUserScorePush() {
        clear();
    }

    public static RoomUserScorePush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RoomUserScorePush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RoomUserScorePush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RoomUserScorePush) MessageNano.mergeFrom(new RoomUserScorePush(), bArr);
    }

    public RoomUserScorePush clear() {
        this.roomId = 0;
        this.updateListType = 0;
        this.userScoreUpdateItem = UserScoreItem.emptyArray();
        this.userScoreRemoveItem = UserScoreItem.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt32Size(2, this.updateListType);
        UserScoreItem[] userScoreItemArr = this.userScoreUpdateItem;
        int i3 = 0;
        if (userScoreItemArr != null && userScoreItemArr.length > 0) {
            int i16 = 0;
            while (true) {
                UserScoreItem[] userScoreItemArr2 = this.userScoreUpdateItem;
                if (i16 >= userScoreItemArr2.length) {
                    break;
                }
                UserScoreItem userScoreItem = userScoreItemArr2[i16];
                if (userScoreItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, userScoreItem);
                }
                i16++;
            }
        }
        UserScoreItem[] userScoreItemArr3 = this.userScoreRemoveItem;
        if (userScoreItemArr3 != null && userScoreItemArr3.length > 0) {
            while (true) {
                UserScoreItem[] userScoreItemArr4 = this.userScoreRemoveItem;
                if (i3 >= userScoreItemArr4.length) {
                    break;
                }
                UserScoreItem userScoreItem2 = userScoreItemArr4[i3];
                if (userScoreItem2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, userScoreItem2);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt32(2, this.updateListType);
        UserScoreItem[] userScoreItemArr = this.userScoreUpdateItem;
        int i3 = 0;
        if (userScoreItemArr != null && userScoreItemArr.length > 0) {
            int i16 = 0;
            while (true) {
                UserScoreItem[] userScoreItemArr2 = this.userScoreUpdateItem;
                if (i16 >= userScoreItemArr2.length) {
                    break;
                }
                UserScoreItem userScoreItem = userScoreItemArr2[i16];
                if (userScoreItem != null) {
                    codedOutputByteBufferNano.writeMessage(3, userScoreItem);
                }
                i16++;
            }
        }
        UserScoreItem[] userScoreItemArr3 = this.userScoreRemoveItem;
        if (userScoreItemArr3 != null && userScoreItemArr3.length > 0) {
            while (true) {
                UserScoreItem[] userScoreItemArr4 = this.userScoreRemoveItem;
                if (i3 >= userScoreItemArr4.length) {
                    break;
                }
                UserScoreItem userScoreItem2 = userScoreItemArr4[i3];
                if (userScoreItem2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, userScoreItem2);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RoomUserScorePush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RoomUserScorePush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RoomUserScorePush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.updateListType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                UserScoreItem[] userScoreItemArr = this.userScoreUpdateItem;
                int length = userScoreItemArr == null ? 0 : userScoreItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                UserScoreItem[] userScoreItemArr2 = new UserScoreItem[i3];
                if (length != 0) {
                    System.arraycopy(userScoreItemArr, 0, userScoreItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    UserScoreItem userScoreItem = new UserScoreItem();
                    userScoreItemArr2[length] = userScoreItem;
                    codedInputByteBufferNano.readMessage(userScoreItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                UserScoreItem userScoreItem2 = new UserScoreItem();
                userScoreItemArr2[length] = userScoreItem2;
                codedInputByteBufferNano.readMessage(userScoreItem2);
                this.userScoreUpdateItem = userScoreItemArr2;
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                UserScoreItem[] userScoreItemArr3 = this.userScoreRemoveItem;
                int length2 = userScoreItemArr3 == null ? 0 : userScoreItemArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                UserScoreItem[] userScoreItemArr4 = new UserScoreItem[i16];
                if (length2 != 0) {
                    System.arraycopy(userScoreItemArr3, 0, userScoreItemArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    UserScoreItem userScoreItem3 = new UserScoreItem();
                    userScoreItemArr4[length2] = userScoreItem3;
                    codedInputByteBufferNano.readMessage(userScoreItem3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                UserScoreItem userScoreItem4 = new UserScoreItem();
                userScoreItemArr4[length2] = userScoreItem4;
                codedInputByteBufferNano.readMessage(userScoreItem4);
                this.userScoreRemoveItem = userScoreItemArr4;
            }
        }
    }
}
