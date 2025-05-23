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
public final class GetLoveAnchorInfoRsp extends ExtendableMessageNano<GetLoveAnchorInfoRsp> {
    private static volatile GetLoveAnchorInfoRsp[] _emptyArray;
    public String errMsg;
    public LoveAnchorInfo[] infoList;
    public int result;
    public byte[][] roomTags;
    public int tips;
    public String tipsWording;

    public GetLoveAnchorInfoRsp() {
        clear();
    }

    public static GetLoveAnchorInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetLoveAnchorInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetLoveAnchorInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetLoveAnchorInfoRsp) MessageNano.mergeFrom(new GetLoveAnchorInfoRsp(), bArr);
    }

    public GetLoveAnchorInfoRsp clear() {
        this.infoList = LoveAnchorInfo.emptyArray();
        this.roomTags = WireFormatNano.EMPTY_BYTES_ARRAY;
        this.tips = 0;
        this.tipsWording = "";
        this.result = 0;
        this.errMsg = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        LoveAnchorInfo[] loveAnchorInfoArr = this.infoList;
        int i3 = 0;
        if (loveAnchorInfoArr != null && loveAnchorInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                LoveAnchorInfo[] loveAnchorInfoArr2 = this.infoList;
                if (i16 >= loveAnchorInfoArr2.length) {
                    break;
                }
                LoveAnchorInfo loveAnchorInfo = loveAnchorInfoArr2[i16];
                if (loveAnchorInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, loveAnchorInfo);
                }
                i16++;
            }
        }
        byte[][] bArr = this.roomTags;
        if (bArr != null && bArr.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                byte[][] bArr2 = this.roomTags;
                if (i3 >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i3];
                if (bArr3 != null) {
                    i18++;
                    i17 += CodedOutputByteBufferNano.computeBytesSizeNoTag(bArr3);
                }
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (i18 * 1);
        }
        int i19 = this.tips;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i19);
        }
        if (!this.tipsWording.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.tipsWording);
        }
        int i26 = this.result;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i26);
        }
        if (!this.errMsg.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.errMsg);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        LoveAnchorInfo[] loveAnchorInfoArr = this.infoList;
        int i3 = 0;
        if (loveAnchorInfoArr != null && loveAnchorInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                LoveAnchorInfo[] loveAnchorInfoArr2 = this.infoList;
                if (i16 >= loveAnchorInfoArr2.length) {
                    break;
                }
                LoveAnchorInfo loveAnchorInfo = loveAnchorInfoArr2[i16];
                if (loveAnchorInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, loveAnchorInfo);
                }
                i16++;
            }
        }
        byte[][] bArr = this.roomTags;
        if (bArr != null && bArr.length > 0) {
            while (true) {
                byte[][] bArr2 = this.roomTags;
                if (i3 >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i3];
                if (bArr3 != null) {
                    codedOutputByteBufferNano.writeBytes(2, bArr3);
                }
                i3++;
            }
        }
        int i17 = this.tips;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        if (!this.tipsWording.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.tipsWording);
        }
        int i18 = this.result;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        if (!this.errMsg.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.errMsg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetLoveAnchorInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetLoveAnchorInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetLoveAnchorInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                LoveAnchorInfo[] loveAnchorInfoArr = this.infoList;
                int length = loveAnchorInfoArr == null ? 0 : loveAnchorInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                LoveAnchorInfo[] loveAnchorInfoArr2 = new LoveAnchorInfo[i3];
                if (length != 0) {
                    System.arraycopy(loveAnchorInfoArr, 0, loveAnchorInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    LoveAnchorInfo loveAnchorInfo = new LoveAnchorInfo();
                    loveAnchorInfoArr2[length] = loveAnchorInfo;
                    codedInputByteBufferNano.readMessage(loveAnchorInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                LoveAnchorInfo loveAnchorInfo2 = new LoveAnchorInfo();
                loveAnchorInfoArr2[length] = loveAnchorInfo2;
                codedInputByteBufferNano.readMessage(loveAnchorInfo2);
                this.infoList = loveAnchorInfoArr2;
            } else if (readTag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                byte[][] bArr = this.roomTags;
                int length2 = bArr == null ? 0 : bArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                byte[][] bArr2 = new byte[i16];
                if (length2 != 0) {
                    System.arraycopy(bArr, 0, bArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    bArr2[length2] = codedInputByteBufferNano.readBytes();
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                bArr2[length2] = codedInputByteBufferNano.readBytes();
                this.roomTags = bArr2;
            } else if (readTag == 24) {
                this.tips = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                this.tipsWording = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.errMsg = codedInputByteBufferNano.readString();
            }
        }
    }
}
