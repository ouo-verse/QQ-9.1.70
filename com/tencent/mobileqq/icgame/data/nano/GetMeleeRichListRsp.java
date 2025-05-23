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
public final class GetMeleeRichListRsp extends ExtendableMessageNano<GetMeleeRichListRsp> {
    private static volatile GetMeleeRichListRsp[] _emptyArray;
    public UserMeleeRankItem[] userItemList;

    public GetMeleeRichListRsp() {
        clear();
    }

    public static GetMeleeRichListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetMeleeRichListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetMeleeRichListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetMeleeRichListRsp) MessageNano.mergeFrom(new GetMeleeRichListRsp(), bArr);
    }

    public GetMeleeRichListRsp clear() {
        this.userItemList = UserMeleeRankItem.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        UserMeleeRankItem[] userMeleeRankItemArr = this.userItemList;
        if (userMeleeRankItemArr != null && userMeleeRankItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserMeleeRankItem[] userMeleeRankItemArr2 = this.userItemList;
                if (i3 >= userMeleeRankItemArr2.length) {
                    break;
                }
                UserMeleeRankItem userMeleeRankItem = userMeleeRankItemArr2[i3];
                if (userMeleeRankItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userMeleeRankItem);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UserMeleeRankItem[] userMeleeRankItemArr = this.userItemList;
        if (userMeleeRankItemArr != null && userMeleeRankItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserMeleeRankItem[] userMeleeRankItemArr2 = this.userItemList;
                if (i3 >= userMeleeRankItemArr2.length) {
                    break;
                }
                UserMeleeRankItem userMeleeRankItem = userMeleeRankItemArr2[i3];
                if (userMeleeRankItem != null) {
                    codedOutputByteBufferNano.writeMessage(1, userMeleeRankItem);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetMeleeRichListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetMeleeRichListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetMeleeRichListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                UserMeleeRankItem[] userMeleeRankItemArr = this.userItemList;
                int length = userMeleeRankItemArr == null ? 0 : userMeleeRankItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                UserMeleeRankItem[] userMeleeRankItemArr2 = new UserMeleeRankItem[i3];
                if (length != 0) {
                    System.arraycopy(userMeleeRankItemArr, 0, userMeleeRankItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    UserMeleeRankItem userMeleeRankItem = new UserMeleeRankItem();
                    userMeleeRankItemArr2[length] = userMeleeRankItem;
                    codedInputByteBufferNano.readMessage(userMeleeRankItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                UserMeleeRankItem userMeleeRankItem2 = new UserMeleeRankItem();
                userMeleeRankItemArr2[length] = userMeleeRankItem2;
                codedInputByteBufferNano.readMessage(userMeleeRankItem2);
                this.userItemList = userMeleeRankItemArr2;
            }
        }
    }
}
