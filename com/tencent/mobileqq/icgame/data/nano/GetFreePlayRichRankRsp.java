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
public final class GetFreePlayRichRankRsp extends ExtendableMessageNano<GetFreePlayRichRankRsp> {
    private static volatile GetFreePlayRichRankRsp[] _emptyArray;
    public UserScoreItem[] userItemList;

    public GetFreePlayRichRankRsp() {
        clear();
    }

    public static GetFreePlayRichRankRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetFreePlayRichRankRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetFreePlayRichRankRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetFreePlayRichRankRsp) MessageNano.mergeFrom(new GetFreePlayRichRankRsp(), bArr);
    }

    public GetFreePlayRichRankRsp clear() {
        this.userItemList = UserScoreItem.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        UserScoreItem[] userScoreItemArr = this.userItemList;
        if (userScoreItemArr != null && userScoreItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserScoreItem[] userScoreItemArr2 = this.userItemList;
                if (i3 >= userScoreItemArr2.length) {
                    break;
                }
                UserScoreItem userScoreItem = userScoreItemArr2[i3];
                if (userScoreItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userScoreItem);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UserScoreItem[] userScoreItemArr = this.userItemList;
        if (userScoreItemArr != null && userScoreItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserScoreItem[] userScoreItemArr2 = this.userItemList;
                if (i3 >= userScoreItemArr2.length) {
                    break;
                }
                UserScoreItem userScoreItem = userScoreItemArr2[i3];
                if (userScoreItem != null) {
                    codedOutputByteBufferNano.writeMessage(1, userScoreItem);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetFreePlayRichRankRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetFreePlayRichRankRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetFreePlayRichRankRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
