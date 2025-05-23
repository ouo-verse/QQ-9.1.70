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
public final class GetRoomUserScoreListRsp extends ExtendableMessageNano<GetRoomUserScoreListRsp> {
    private static volatile GetRoomUserScoreListRsp[] _emptyArray;
    public int ownRichrankScore;
    public UserScoreItem[] userGlamourItemList;
    public UserScoreItem[] userWealthItemList;

    public GetRoomUserScoreListRsp() {
        clear();
    }

    public static GetRoomUserScoreListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetRoomUserScoreListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetRoomUserScoreListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetRoomUserScoreListRsp) MessageNano.mergeFrom(new GetRoomUserScoreListRsp(), bArr);
    }

    public GetRoomUserScoreListRsp clear() {
        this.userWealthItemList = UserScoreItem.emptyArray();
        this.userGlamourItemList = UserScoreItem.emptyArray();
        this.ownRichrankScore = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        UserScoreItem[] userScoreItemArr = this.userWealthItemList;
        int i3 = 0;
        if (userScoreItemArr != null && userScoreItemArr.length > 0) {
            int i16 = 0;
            while (true) {
                UserScoreItem[] userScoreItemArr2 = this.userWealthItemList;
                if (i16 >= userScoreItemArr2.length) {
                    break;
                }
                UserScoreItem userScoreItem = userScoreItemArr2[i16];
                if (userScoreItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userScoreItem);
                }
                i16++;
            }
        }
        UserScoreItem[] userScoreItemArr3 = this.userGlamourItemList;
        if (userScoreItemArr3 != null && userScoreItemArr3.length > 0) {
            while (true) {
                UserScoreItem[] userScoreItemArr4 = this.userGlamourItemList;
                if (i3 >= userScoreItemArr4.length) {
                    break;
                }
                UserScoreItem userScoreItem2 = userScoreItemArr4[i3];
                if (userScoreItem2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userScoreItem2);
                }
                i3++;
            }
        }
        int i17 = this.ownRichrankScore;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UserScoreItem[] userScoreItemArr = this.userWealthItemList;
        int i3 = 0;
        if (userScoreItemArr != null && userScoreItemArr.length > 0) {
            int i16 = 0;
            while (true) {
                UserScoreItem[] userScoreItemArr2 = this.userWealthItemList;
                if (i16 >= userScoreItemArr2.length) {
                    break;
                }
                UserScoreItem userScoreItem = userScoreItemArr2[i16];
                if (userScoreItem != null) {
                    codedOutputByteBufferNano.writeMessage(1, userScoreItem);
                }
                i16++;
            }
        }
        UserScoreItem[] userScoreItemArr3 = this.userGlamourItemList;
        if (userScoreItemArr3 != null && userScoreItemArr3.length > 0) {
            while (true) {
                UserScoreItem[] userScoreItemArr4 = this.userGlamourItemList;
                if (i3 >= userScoreItemArr4.length) {
                    break;
                }
                UserScoreItem userScoreItem2 = userScoreItemArr4[i3];
                if (userScoreItem2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, userScoreItem2);
                }
                i3++;
            }
        }
        int i17 = this.ownRichrankScore;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetRoomUserScoreListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetRoomUserScoreListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetRoomUserScoreListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                UserScoreItem[] userScoreItemArr = this.userWealthItemList;
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
                this.userWealthItemList = userScoreItemArr2;
            } else if (readTag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                UserScoreItem[] userScoreItemArr3 = this.userGlamourItemList;
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
                this.userGlamourItemList = userScoreItemArr4;
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.ownRichrankScore = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
