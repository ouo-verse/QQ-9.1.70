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
public final class GetAnchorLoveRoomListRsp extends ExtendableMessageNano<GetAnchorLoveRoomListRsp> {
    private static volatile GetAnchorLoveRoomListRsp[] _emptyArray;
    public GroupRoomInfo[] groupRoomInfo;
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
        this.groupRoomInfo = GroupRoomInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        LoveRoomInfo[] loveRoomInfoArr = this.loveRoomList;
        int i3 = 0;
        if (loveRoomInfoArr != null && loveRoomInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                LoveRoomInfo[] loveRoomInfoArr2 = this.loveRoomList;
                if (i16 >= loveRoomInfoArr2.length) {
                    break;
                }
                LoveRoomInfo loveRoomInfo = loveRoomInfoArr2[i16];
                if (loveRoomInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, loveRoomInfo);
                }
                i16++;
            }
        }
        GroupRoomInfo[] groupRoomInfoArr = this.groupRoomInfo;
        if (groupRoomInfoArr != null && groupRoomInfoArr.length > 0) {
            while (true) {
                GroupRoomInfo[] groupRoomInfoArr2 = this.groupRoomInfo;
                if (i3 >= groupRoomInfoArr2.length) {
                    break;
                }
                GroupRoomInfo groupRoomInfo = groupRoomInfoArr2[i3];
                if (groupRoomInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, groupRoomInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        LoveRoomInfo[] loveRoomInfoArr = this.loveRoomList;
        int i3 = 0;
        if (loveRoomInfoArr != null && loveRoomInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                LoveRoomInfo[] loveRoomInfoArr2 = this.loveRoomList;
                if (i16 >= loveRoomInfoArr2.length) {
                    break;
                }
                LoveRoomInfo loveRoomInfo = loveRoomInfoArr2[i16];
                if (loveRoomInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, loveRoomInfo);
                }
                i16++;
            }
        }
        GroupRoomInfo[] groupRoomInfoArr = this.groupRoomInfo;
        if (groupRoomInfoArr != null && groupRoomInfoArr.length > 0) {
            while (true) {
                GroupRoomInfo[] groupRoomInfoArr2 = this.groupRoomInfo;
                if (i3 >= groupRoomInfoArr2.length) {
                    break;
                }
                GroupRoomInfo groupRoomInfo = groupRoomInfoArr2[i3];
                if (groupRoomInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, groupRoomInfo);
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
            if (readTag == 10) {
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
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                GroupRoomInfo[] groupRoomInfoArr = this.groupRoomInfo;
                int length2 = groupRoomInfoArr == null ? 0 : groupRoomInfoArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                GroupRoomInfo[] groupRoomInfoArr2 = new GroupRoomInfo[i16];
                if (length2 != 0) {
                    System.arraycopy(groupRoomInfoArr, 0, groupRoomInfoArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    GroupRoomInfo groupRoomInfo = new GroupRoomInfo();
                    groupRoomInfoArr2[length2] = groupRoomInfo;
                    codedInputByteBufferNano.readMessage(groupRoomInfo);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                GroupRoomInfo groupRoomInfo2 = new GroupRoomInfo();
                groupRoomInfoArr2[length2] = groupRoomInfo2;
                codedInputByteBufferNano.readMessage(groupRoomInfo2);
                this.groupRoomInfo = groupRoomInfoArr2;
            }
        }
    }
}
