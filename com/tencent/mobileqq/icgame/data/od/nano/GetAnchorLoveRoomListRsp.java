package com.tencent.mobileqq.icgame.data.od.nano;

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
public final class GetAnchorLoveRoomListRsp extends ExtendableMessageNano<GetAnchorLoveRoomListRsp> {
    private static volatile GetAnchorLoveRoomListRsp[] _emptyArray;
    public LoveRoomInfo[] loveRoomList;

    public GetAnchorLoveRoomListRsp() {
        clear();
    }

    public static GetAnchorLoveRoomListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetAnchorLoveRoomListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetAnchorLoveRoomListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetAnchorLoveRoomListRsp) MessageNano.mergeFrom(new GetAnchorLoveRoomListRsp(), bArr);
    }

    public GetAnchorLoveRoomListRsp clear() {
        this.loveRoomList = LoveRoomInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        LoveRoomInfo[] loveRoomInfoArr = this.loveRoomList;
        if (loveRoomInfoArr != null && loveRoomInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                LoveRoomInfo[] loveRoomInfoArr2 = this.loveRoomList;
                if (i3 >= loveRoomInfoArr2.length) {
                    break;
                }
                LoveRoomInfo loveRoomInfo = loveRoomInfoArr2[i3];
                if (loveRoomInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, loveRoomInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        LoveRoomInfo[] loveRoomInfoArr = this.loveRoomList;
        if (loveRoomInfoArr != null && loveRoomInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                LoveRoomInfo[] loveRoomInfoArr2 = this.loveRoomList;
                if (i3 >= loveRoomInfoArr2.length) {
                    break;
                }
                LoveRoomInfo loveRoomInfo = loveRoomInfoArr2[i3];
                if (loveRoomInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, loveRoomInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetAnchorLoveRoomListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetAnchorLoveRoomListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetAnchorLoveRoomListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                LoveRoomInfo[] loveRoomInfoArr = this.loveRoomList;
                int length = loveRoomInfoArr == null ? 0 : loveRoomInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                LoveRoomInfo[] loveRoomInfoArr2 = new LoveRoomInfo[i3];
                if (length != 0) {
                    System.arraycopy(loveRoomInfoArr, 0, loveRoomInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    LoveRoomInfo loveRoomInfo = new LoveRoomInfo();
                    loveRoomInfoArr2[length] = loveRoomInfo;
                    codedInputByteBufferNano.readMessage(loveRoomInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                LoveRoomInfo loveRoomInfo2 = new LoveRoomInfo();
                loveRoomInfoArr2[length] = loveRoomInfo2;
                codedInputByteBufferNano.readMessage(loveRoomInfo2);
                this.loveRoomList = loveRoomInfoArr2;
            }
        }
    }
}
