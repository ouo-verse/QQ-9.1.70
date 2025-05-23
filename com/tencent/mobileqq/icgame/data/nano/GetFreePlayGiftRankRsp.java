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
public final class GetFreePlayGiftRankRsp extends ExtendableMessageNano<GetFreePlayGiftRankRsp> {
    private static volatile GetFreePlayGiftRankRsp[] _emptyArray;
    public int tab;
    public UserScoreItem[] userItemList;

    public GetFreePlayGiftRankRsp() {
        clear();
    }

    public static GetFreePlayGiftRankRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetFreePlayGiftRankRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetFreePlayGiftRankRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetFreePlayGiftRankRsp) MessageNano.mergeFrom(new GetFreePlayGiftRankRsp(), bArr);
    }

    public GetFreePlayGiftRankRsp clear() {
        this.tab = 0;
        this.userItemList = UserScoreItem.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.tab;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        UserScoreItem[] userScoreItemArr = this.userItemList;
        if (userScoreItemArr != null && userScoreItemArr.length > 0) {
            int i16 = 0;
            while (true) {
                UserScoreItem[] userScoreItemArr2 = this.userItemList;
                if (i16 >= userScoreItemArr2.length) {
                    break;
                }
                UserScoreItem userScoreItem = userScoreItemArr2[i16];
                if (userScoreItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userScoreItem);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.tab;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        UserScoreItem[] userScoreItemArr = this.userItemList;
        if (userScoreItemArr != null && userScoreItemArr.length > 0) {
            int i16 = 0;
            while (true) {
                UserScoreItem[] userScoreItemArr2 = this.userItemList;
                if (i16 >= userScoreItemArr2.length) {
                    break;
                }
                UserScoreItem userScoreItem = userScoreItemArr2[i16];
                if (userScoreItem != null) {
                    codedOutputByteBufferNano.writeMessage(2, userScoreItem);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetFreePlayGiftRankRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetFreePlayGiftRankRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetFreePlayGiftRankRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.tab = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                UserScoreItem[] userScoreItemArr = this.userItemList;
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
                this.userItemList = userScoreItemArr2;
            }
        }
    }
}
