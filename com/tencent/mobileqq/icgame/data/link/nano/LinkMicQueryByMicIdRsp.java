package com.tencent.mobileqq.icgame.data.link.nano;

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
public final class LinkMicQueryByMicIdRsp extends ExtendableMessageNano<LinkMicQueryByMicIdRsp> {
    private static volatile LinkMicQueryByMicIdRsp[] _emptyArray;
    public String linkMicId;
    public UserPlaceInfo[] placeInfos;

    public LinkMicQueryByMicIdRsp() {
        clear();
    }

    public static LinkMicQueryByMicIdRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicQueryByMicIdRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicQueryByMicIdRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicQueryByMicIdRsp) MessageNano.mergeFrom(new LinkMicQueryByMicIdRsp(), bArr);
    }

    public LinkMicQueryByMicIdRsp clear() {
        this.linkMicId = "";
        this.placeInfos = UserPlaceInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.linkMicId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.linkMicId);
        }
        UserPlaceInfo[] userPlaceInfoArr = this.placeInfos;
        if (userPlaceInfoArr != null && userPlaceInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserPlaceInfo[] userPlaceInfoArr2 = this.placeInfos;
                if (i3 >= userPlaceInfoArr2.length) {
                    break;
                }
                UserPlaceInfo userPlaceInfo = userPlaceInfoArr2[i3];
                if (userPlaceInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userPlaceInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.linkMicId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.linkMicId);
        }
        UserPlaceInfo[] userPlaceInfoArr = this.placeInfos;
        if (userPlaceInfoArr != null && userPlaceInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserPlaceInfo[] userPlaceInfoArr2 = this.placeInfos;
                if (i3 >= userPlaceInfoArr2.length) {
                    break;
                }
                UserPlaceInfo userPlaceInfo = userPlaceInfoArr2[i3];
                if (userPlaceInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, userPlaceInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicQueryByMicIdRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicQueryByMicIdRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicQueryByMicIdRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.linkMicId = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                UserPlaceInfo[] userPlaceInfoArr = this.placeInfos;
                int length = userPlaceInfoArr == null ? 0 : userPlaceInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                UserPlaceInfo[] userPlaceInfoArr2 = new UserPlaceInfo[i3];
                if (length != 0) {
                    System.arraycopy(userPlaceInfoArr, 0, userPlaceInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    UserPlaceInfo userPlaceInfo = new UserPlaceInfo();
                    userPlaceInfoArr2[length] = userPlaceInfo;
                    codedInputByteBufferNano.readMessage(userPlaceInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                UserPlaceInfo userPlaceInfo2 = new UserPlaceInfo();
                userPlaceInfoArr2[length] = userPlaceInfo2;
                codedInputByteBufferNano.readMessage(userPlaceInfo2);
                this.placeInfos = userPlaceInfoArr2;
            }
        }
    }
}
