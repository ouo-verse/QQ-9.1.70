package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes15.dex */
public final class GivePayGiftReq extends ExtendableMessageNano<GivePayGiftReq> {
    private static volatile GivePayGiftReq[] _emptyArray;
    public byte[] anchorName;
    public String billNo;
    public int comboCount;
    public int comboSeq;
    public byte[] fromId;
    public int fromType;
    public long fromWhere;
    public int giftId;
    public int giftNum;
    public byte[] headKey;
    public ILiveGiftSite[] iLiveGiftSites;
    public byte[] imei;
    public int installChannel;
    public int isCompress;
    public long logoTimestamp;
    public byte[] message;
    public TransparentMsg[] msgComTrans;
    public byte[] msgTransparent;
    public long playUid;
    public long qunId;
    public long qunOwnerId;
    public int refererId;
    public int roomId;
    public byte[] sessionKey;
    public int sessionType;
    public int source;
    public int startChannel;
    public int style;
    public int subRoomId;
    public int type;
    public long uin;
    public byte[] userName;

    public GivePayGiftReq() {
        clear();
    }

    public static GivePayGiftReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GivePayGiftReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GivePayGiftReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GivePayGiftReq) MessageNano.mergeFrom(new GivePayGiftReq(), bArr);
    }

    public GivePayGiftReq clear() {
        this.uin = 0L;
        this.roomId = 0;
        this.subRoomId = 0;
        this.type = 0;
        this.giftId = 0;
        this.giftNum = 0;
        this.style = 0;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.message = bArr;
        this.userName = bArr;
        this.anchorName = bArr;
        this.source = 0;
        this.sessionType = 0;
        this.sessionKey = bArr;
        this.iLiveGiftSites = ILiveGiftSite.emptyArray();
        this.isCompress = 0;
        this.comboSeq = 0;
        this.comboCount = 0;
        this.installChannel = 0;
        this.startChannel = 0;
        this.headKey = bArr;
        this.logoTimestamp = 0L;
        this.imei = bArr;
        this.msgTransparent = bArr;
        this.fromType = 0;
        this.fromId = bArr;
        this.refererId = 0;
        this.fromWhere = 0L;
        this.playUid = 0L;
        this.msgComTrans = TransparentMsg.emptyArray();
        this.billNo = "";
        this.qunId = 0L;
        this.qunOwnerId = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.uin) + CodedOutputByteBufferNano.computeUInt32Size(2, this.roomId) + CodedOutputByteBufferNano.computeUInt32Size(3, this.subRoomId);
        int i3 = this.type;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        int computeUInt32Size = computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, this.giftId) + CodedOutputByteBufferNano.computeUInt32Size(6, this.giftNum);
        int i16 = this.style;
        if (i16 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        byte[] bArr = this.message;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeUInt32Size += CodedOutputByteBufferNano.computeBytesSize(8, this.message);
        }
        if (!Arrays.equals(this.userName, bArr2)) {
            computeUInt32Size += CodedOutputByteBufferNano.computeBytesSize(9, this.userName);
        }
        if (!Arrays.equals(this.anchorName, bArr2)) {
            computeUInt32Size += CodedOutputByteBufferNano.computeBytesSize(10, this.anchorName);
        }
        int i17 = this.source;
        if (i17 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt32Size(11, i17);
        }
        int i18 = this.sessionType;
        if (i18 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt32Size(12, i18);
        }
        if (!Arrays.equals(this.sessionKey, bArr2)) {
            computeUInt32Size += CodedOutputByteBufferNano.computeBytesSize(13, this.sessionKey);
        }
        ILiveGiftSite[] iLiveGiftSiteArr = this.iLiveGiftSites;
        int i19 = 0;
        if (iLiveGiftSiteArr != null && iLiveGiftSiteArr.length > 0) {
            int i26 = 0;
            while (true) {
                ILiveGiftSite[] iLiveGiftSiteArr2 = this.iLiveGiftSites;
                if (i26 >= iLiveGiftSiteArr2.length) {
                    break;
                }
                ILiveGiftSite iLiveGiftSite = iLiveGiftSiteArr2[i26];
                if (iLiveGiftSite != null) {
                    computeUInt32Size += CodedOutputByteBufferNano.computeMessageSize(14, iLiveGiftSite);
                }
                i26++;
            }
        }
        int i27 = this.isCompress;
        if (i27 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt32Size(15, i27);
        }
        int i28 = this.comboSeq;
        if (i28 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt32Size(16, i28);
        }
        int i29 = this.comboCount;
        if (i29 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt32Size(17, i29);
        }
        int i36 = this.installChannel;
        if (i36 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt32Size(18, i36);
        }
        int i37 = this.startChannel;
        if (i37 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt32Size(19, i37);
        }
        byte[] bArr3 = this.headKey;
        byte[] bArr4 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr3, bArr4)) {
            computeUInt32Size += CodedOutputByteBufferNano.computeBytesSize(20, this.headKey);
        }
        long j3 = this.logoTimestamp;
        if (j3 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt64Size(21, j3);
        }
        if (!Arrays.equals(this.imei, bArr4)) {
            computeUInt32Size += CodedOutputByteBufferNano.computeBytesSize(22, this.imei);
        }
        if (!Arrays.equals(this.msgTransparent, bArr4)) {
            computeUInt32Size += CodedOutputByteBufferNano.computeBytesSize(23, this.msgTransparent);
        }
        int i38 = this.fromType;
        if (i38 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt32Size(24, i38);
        }
        if (!Arrays.equals(this.fromId, bArr4)) {
            computeUInt32Size += CodedOutputByteBufferNano.computeBytesSize(25, this.fromId);
        }
        int i39 = this.refererId;
        if (i39 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt32Size(26, i39);
        }
        long j16 = this.fromWhere;
        if (j16 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt64Size(27, j16);
        }
        long j17 = this.playUid;
        if (j17 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt64Size(28, j17);
        }
        TransparentMsg[] transparentMsgArr = this.msgComTrans;
        if (transparentMsgArr != null && transparentMsgArr.length > 0) {
            while (true) {
                TransparentMsg[] transparentMsgArr2 = this.msgComTrans;
                if (i19 >= transparentMsgArr2.length) {
                    break;
                }
                TransparentMsg transparentMsg = transparentMsgArr2[i19];
                if (transparentMsg != null) {
                    computeUInt32Size += CodedOutputByteBufferNano.computeMessageSize(29, transparentMsg);
                }
                i19++;
            }
        }
        if (!this.billNo.equals("")) {
            computeUInt32Size += CodedOutputByteBufferNano.computeStringSize(30, this.billNo);
        }
        long j18 = this.qunId;
        if (j18 != 0) {
            computeUInt32Size += CodedOutputByteBufferNano.computeUInt64Size(31, j18);
        }
        long j19 = this.qunOwnerId;
        if (j19 != 0) {
            return computeUInt32Size + CodedOutputByteBufferNano.computeUInt64Size(32, j19);
        }
        return computeUInt32Size;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.uin);
        codedOutputByteBufferNano.writeUInt32(2, this.roomId);
        codedOutputByteBufferNano.writeUInt32(3, this.subRoomId);
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        codedOutputByteBufferNano.writeUInt32(5, this.giftId);
        codedOutputByteBufferNano.writeUInt32(6, this.giftNum);
        int i16 = this.style;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        byte[] bArr = this.message;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(8, this.message);
        }
        if (!Arrays.equals(this.userName, bArr2)) {
            codedOutputByteBufferNano.writeBytes(9, this.userName);
        }
        if (!Arrays.equals(this.anchorName, bArr2)) {
            codedOutputByteBufferNano.writeBytes(10, this.anchorName);
        }
        int i17 = this.source;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i17);
        }
        int i18 = this.sessionType;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i18);
        }
        if (!Arrays.equals(this.sessionKey, bArr2)) {
            codedOutputByteBufferNano.writeBytes(13, this.sessionKey);
        }
        ILiveGiftSite[] iLiveGiftSiteArr = this.iLiveGiftSites;
        int i19 = 0;
        if (iLiveGiftSiteArr != null && iLiveGiftSiteArr.length > 0) {
            int i26 = 0;
            while (true) {
                ILiveGiftSite[] iLiveGiftSiteArr2 = this.iLiveGiftSites;
                if (i26 >= iLiveGiftSiteArr2.length) {
                    break;
                }
                ILiveGiftSite iLiveGiftSite = iLiveGiftSiteArr2[i26];
                if (iLiveGiftSite != null) {
                    codedOutputByteBufferNano.writeMessage(14, iLiveGiftSite);
                }
                i26++;
            }
        }
        int i27 = this.isCompress;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(15, i27);
        }
        int i28 = this.comboSeq;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(16, i28);
        }
        int i29 = this.comboCount;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i29);
        }
        int i36 = this.installChannel;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i36);
        }
        int i37 = this.startChannel;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeUInt32(19, i37);
        }
        byte[] bArr3 = this.headKey;
        byte[] bArr4 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr3, bArr4)) {
            codedOutputByteBufferNano.writeBytes(20, this.headKey);
        }
        long j3 = this.logoTimestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(21, j3);
        }
        if (!Arrays.equals(this.imei, bArr4)) {
            codedOutputByteBufferNano.writeBytes(22, this.imei);
        }
        if (!Arrays.equals(this.msgTransparent, bArr4)) {
            codedOutputByteBufferNano.writeBytes(23, this.msgTransparent);
        }
        int i38 = this.fromType;
        if (i38 != 0) {
            codedOutputByteBufferNano.writeUInt32(24, i38);
        }
        if (!Arrays.equals(this.fromId, bArr4)) {
            codedOutputByteBufferNano.writeBytes(25, this.fromId);
        }
        int i39 = this.refererId;
        if (i39 != 0) {
            codedOutputByteBufferNano.writeUInt32(26, i39);
        }
        long j16 = this.fromWhere;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(27, j16);
        }
        long j17 = this.playUid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(28, j17);
        }
        TransparentMsg[] transparentMsgArr = this.msgComTrans;
        if (transparentMsgArr != null && transparentMsgArr.length > 0) {
            while (true) {
                TransparentMsg[] transparentMsgArr2 = this.msgComTrans;
                if (i19 >= transparentMsgArr2.length) {
                    break;
                }
                TransparentMsg transparentMsg = transparentMsgArr2[i19];
                if (transparentMsg != null) {
                    codedOutputByteBufferNano.writeMessage(29, transparentMsg);
                }
                i19++;
            }
        }
        if (!this.billNo.equals("")) {
            codedOutputByteBufferNano.writeString(30, this.billNo);
        }
        long j18 = this.qunId;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(31, j18);
        }
        long j19 = this.qunOwnerId;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(32, j19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GivePayGiftReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GivePayGiftReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GivePayGiftReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.uin = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.roomId = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.subRoomId = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.type = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.giftNum = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.style = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.message = codedInputByteBufferNano.readBytes();
                    break;
                case 74:
                    this.userName = codedInputByteBufferNano.readBytes();
                    break;
                case 82:
                    this.anchorName = codedInputByteBufferNano.readBytes();
                    break;
                case 88:
                    this.source = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.sessionType = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    this.sessionKey = codedInputByteBufferNano.readBytes();
                    break;
                case 114:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 114);
                    ILiveGiftSite[] iLiveGiftSiteArr = this.iLiveGiftSites;
                    int length = iLiveGiftSiteArr == null ? 0 : iLiveGiftSiteArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    ILiveGiftSite[] iLiveGiftSiteArr2 = new ILiveGiftSite[i3];
                    if (length != 0) {
                        System.arraycopy(iLiveGiftSiteArr, 0, iLiveGiftSiteArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        ILiveGiftSite iLiveGiftSite = new ILiveGiftSite();
                        iLiveGiftSiteArr2[length] = iLiveGiftSite;
                        codedInputByteBufferNano.readMessage(iLiveGiftSite);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    ILiveGiftSite iLiveGiftSite2 = new ILiveGiftSite();
                    iLiveGiftSiteArr2[length] = iLiveGiftSite2;
                    codedInputByteBufferNano.readMessage(iLiveGiftSite2);
                    this.iLiveGiftSites = iLiveGiftSiteArr2;
                    break;
                case 120:
                    this.isCompress = codedInputByteBufferNano.readUInt32();
                    break;
                case 128:
                    this.comboSeq = codedInputByteBufferNano.readUInt32();
                    break;
                case 136:
                    this.comboCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 144:
                    this.installChannel = codedInputByteBufferNano.readUInt32();
                    break;
                case 152:
                    this.startChannel = codedInputByteBufferNano.readUInt32();
                    break;
                case 162:
                    this.headKey = codedInputByteBufferNano.readBytes();
                    break;
                case 168:
                    this.logoTimestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 178:
                    this.imei = codedInputByteBufferNano.readBytes();
                    break;
                case 186:
                    this.msgTransparent = codedInputByteBufferNano.readBytes();
                    break;
                case 192:
                    this.fromType = codedInputByteBufferNano.readUInt32();
                    break;
                case 202:
                    this.fromId = codedInputByteBufferNano.readBytes();
                    break;
                case 208:
                    this.refererId = codedInputByteBufferNano.readUInt32();
                    break;
                case 216:
                    this.fromWhere = codedInputByteBufferNano.readUInt64();
                    break;
                case 224:
                    this.playUid = codedInputByteBufferNano.readUInt64();
                    break;
                case 234:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 234);
                    TransparentMsg[] transparentMsgArr = this.msgComTrans;
                    int length2 = transparentMsgArr == null ? 0 : transparentMsgArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    TransparentMsg[] transparentMsgArr2 = new TransparentMsg[i16];
                    if (length2 != 0) {
                        System.arraycopy(transparentMsgArr, 0, transparentMsgArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        TransparentMsg transparentMsg = new TransparentMsg();
                        transparentMsgArr2[length2] = transparentMsg;
                        codedInputByteBufferNano.readMessage(transparentMsg);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    TransparentMsg transparentMsg2 = new TransparentMsg();
                    transparentMsgArr2[length2] = transparentMsg2;
                    codedInputByteBufferNano.readMessage(transparentMsg2);
                    this.msgComTrans = transparentMsgArr2;
                    break;
                case 242:
                    this.billNo = codedInputByteBufferNano.readString();
                    break;
                case 248:
                    this.qunId = codedInputByteBufferNano.readUInt64();
                    break;
                case 256:
                    this.qunOwnerId = codedInputByteBufferNano.readUInt64();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
