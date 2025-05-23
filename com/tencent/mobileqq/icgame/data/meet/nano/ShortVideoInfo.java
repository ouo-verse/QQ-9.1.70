package com.tencent.mobileqq.icgame.data.meet.nano;

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
public final class ShortVideoInfo extends ExtendableMessageNano<ShortVideoInfo> {
    public static final int DEFAULT_SOURCE = 0;
    public static final int DEFAULT_TYPE = 0;
    public static final int FEED_SOURCE_ANDROID = 2;
    public static final int FEED_SOURCE_IOS = 1;
    public static final int FEED_STATUS_DELETE = 1;
    public static final int FEED_STATUS_INVALID = 2;
    public static final int FEED_STATUS_VALID = 0;
    public static final int TYPE_RECORD_LIVE_VIDEO_FEED = 1;
    public static final int TYPE_RECORD_STORY_VIDEO_FEED = 3;
    public static final int TYPE_RECORD_VIDEO_FEED = 2;
    private static volatile ShortVideoInfo[] _emptyArray;
    public UserInfo anchorInfo;
    public int bgColor;
    public int commentNum;
    public int createTime;
    public String doodlePicUrl;
    public int feedContentType;
    public int feedSource;
    public int feedType;
    public String feedsId;
    public String fileId;
    public long followUid;
    public int isLike;
    public int isListen;
    public String jumpUrl;
    public LbsInfo lbsInfo;
    public int likeNum;
    public String picUrl;
    public String[] qieVideoUrl;
    public RichTitleElement[] rptMsgRichTitle;
    public String shareMainTitle;
    public String shareSubheading;
    public String shareUrl;
    public int upStatus;
    public UserInfo userInfo;
    public String vid;
    public int videoHight;
    public int videoTime;
    public String videoUrl;
    public int videoWidth;
    public int viewTimes;

    public ShortVideoInfo() {
        clear();
    }

    public static ShortVideoInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ShortVideoInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ShortVideoInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ShortVideoInfo) MessageNano.mergeFrom(new ShortVideoInfo(), bArr);
    }

    public ShortVideoInfo clear() {
        this.userInfo = null;
        this.picUrl = "";
        this.videoUrl = "";
        this.anchorInfo = null;
        this.createTime = 0;
        this.feedType = 0;
        this.feedSource = 0;
        this.feedsId = "";
        this.fileId = "";
        this.videoTime = 0;
        this.rptMsgRichTitle = RichTitleElement.emptyArray();
        this.viewTimes = 0;
        this.videoWidth = 0;
        this.videoHight = 0;
        this.doodlePicUrl = "";
        this.isListen = 0;
        this.isLike = 0;
        this.likeNum = 0;
        this.shareUrl = "";
        this.followUid = 0L;
        this.jumpUrl = "";
        this.upStatus = 0;
        this.lbsInfo = null;
        this.bgColor = 0;
        this.vid = "";
        this.shareMainTitle = "";
        this.shareSubheading = "";
        this.feedContentType = 0;
        this.commentNum = 0;
        this.qieVideoUrl = WireFormatNano.EMPTY_STRING_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        if (!this.picUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.picUrl);
        }
        if (!this.videoUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.videoUrl);
        }
        UserInfo userInfo2 = this.anchorInfo;
        if (userInfo2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, userInfo2);
        }
        int i3 = this.createTime;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        int i16 = this.feedType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        int i17 = this.feedSource;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i17);
        }
        if (!this.feedsId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.feedsId);
        }
        if (!this.fileId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.fileId);
        }
        int i18 = this.videoTime;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i18);
        }
        RichTitleElement[] richTitleElementArr = this.rptMsgRichTitle;
        int i19 = 0;
        if (richTitleElementArr != null && richTitleElementArr.length > 0) {
            int i26 = 0;
            while (true) {
                RichTitleElement[] richTitleElementArr2 = this.rptMsgRichTitle;
                if (i26 >= richTitleElementArr2.length) {
                    break;
                }
                RichTitleElement richTitleElement = richTitleElementArr2[i26];
                if (richTitleElement != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, richTitleElement);
                }
                i26++;
            }
        }
        int i27 = this.viewTimes;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i27);
        }
        int i28 = this.videoWidth;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i28);
        }
        int i29 = this.videoHight;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i29);
        }
        if (!this.doodlePicUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.doodlePicUrl);
        }
        int i36 = this.isListen;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(16, i36);
        }
        int i37 = this.isLike;
        if (i37 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i37);
        }
        int i38 = this.likeNum;
        if (i38 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i38);
        }
        if (!this.shareUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.shareUrl);
        }
        long j3 = this.followUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(20, j3);
        }
        if (!this.jumpUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.jumpUrl);
        }
        int i39 = this.upStatus;
        if (i39 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(22, i39);
        }
        LbsInfo lbsInfo = this.lbsInfo;
        if (lbsInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, lbsInfo);
        }
        int i46 = this.bgColor;
        if (i46 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(24, i46);
        }
        if (!this.vid.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(25, this.vid);
        }
        if (!this.shareMainTitle.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(26, this.shareMainTitle);
        }
        if (!this.shareSubheading.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(27, this.shareSubheading);
        }
        int i47 = this.feedContentType;
        if (i47 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(28, i47);
        }
        int i48 = this.commentNum;
        if (i48 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(29, i48);
        }
        String[] strArr = this.qieVideoUrl;
        if (strArr != null && strArr.length > 0) {
            int i49 = 0;
            int i56 = 0;
            while (true) {
                String[] strArr2 = this.qieVideoUrl;
                if (i19 < strArr2.length) {
                    String str = strArr2[i19];
                    if (str != null) {
                        i56++;
                        i49 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i19++;
                } else {
                    return computeSerializedSize + i49 + (i56 * 2);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        if (!this.picUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.picUrl);
        }
        if (!this.videoUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.videoUrl);
        }
        UserInfo userInfo2 = this.anchorInfo;
        if (userInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(4, userInfo2);
        }
        int i3 = this.createTime;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        int i16 = this.feedType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        int i17 = this.feedSource;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        if (!this.feedsId.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.feedsId);
        }
        if (!this.fileId.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.fileId);
        }
        int i18 = this.videoTime;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i18);
        }
        RichTitleElement[] richTitleElementArr = this.rptMsgRichTitle;
        int i19 = 0;
        if (richTitleElementArr != null && richTitleElementArr.length > 0) {
            int i26 = 0;
            while (true) {
                RichTitleElement[] richTitleElementArr2 = this.rptMsgRichTitle;
                if (i26 >= richTitleElementArr2.length) {
                    break;
                }
                RichTitleElement richTitleElement = richTitleElementArr2[i26];
                if (richTitleElement != null) {
                    codedOutputByteBufferNano.writeMessage(11, richTitleElement);
                }
                i26++;
            }
        }
        int i27 = this.viewTimes;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i27);
        }
        int i28 = this.videoWidth;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i28);
        }
        int i29 = this.videoHight;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i29);
        }
        if (!this.doodlePicUrl.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.doodlePicUrl);
        }
        int i36 = this.isListen;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(16, i36);
        }
        int i37 = this.isLike;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i37);
        }
        int i38 = this.likeNum;
        if (i38 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i38);
        }
        if (!this.shareUrl.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.shareUrl);
        }
        long j3 = this.followUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(20, j3);
        }
        if (!this.jumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.jumpUrl);
        }
        int i39 = this.upStatus;
        if (i39 != 0) {
            codedOutputByteBufferNano.writeUInt32(22, i39);
        }
        LbsInfo lbsInfo = this.lbsInfo;
        if (lbsInfo != null) {
            codedOutputByteBufferNano.writeMessage(23, lbsInfo);
        }
        int i46 = this.bgColor;
        if (i46 != 0) {
            codedOutputByteBufferNano.writeUInt32(24, i46);
        }
        if (!this.vid.equals("")) {
            codedOutputByteBufferNano.writeString(25, this.vid);
        }
        if (!this.shareMainTitle.equals("")) {
            codedOutputByteBufferNano.writeString(26, this.shareMainTitle);
        }
        if (!this.shareSubheading.equals("")) {
            codedOutputByteBufferNano.writeString(27, this.shareSubheading);
        }
        int i47 = this.feedContentType;
        if (i47 != 0) {
            codedOutputByteBufferNano.writeUInt32(28, i47);
        }
        int i48 = this.commentNum;
        if (i48 != 0) {
            codedOutputByteBufferNano.writeUInt32(29, i48);
        }
        String[] strArr = this.qieVideoUrl;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.qieVideoUrl;
                if (i19 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i19];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(30, str);
                }
                i19++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ShortVideoInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ShortVideoInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ShortVideoInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.userInfo == null) {
                        this.userInfo = new UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.userInfo);
                    break;
                case 18:
                    this.picUrl = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.videoUrl = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    if (this.anchorInfo == null) {
                        this.anchorInfo = new UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.anchorInfo);
                    break;
                case 40:
                    this.createTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                        break;
                    } else {
                        this.feedType = readInt32;
                        break;
                    }
                case 56:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.feedSource = readInt322;
                        break;
                    }
                case 66:
                    this.feedsId = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.fileId = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.videoTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    RichTitleElement[] richTitleElementArr = this.rptMsgRichTitle;
                    int length = richTitleElementArr == null ? 0 : richTitleElementArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    RichTitleElement[] richTitleElementArr2 = new RichTitleElement[i3];
                    if (length != 0) {
                        System.arraycopy(richTitleElementArr, 0, richTitleElementArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        RichTitleElement richTitleElement = new RichTitleElement();
                        richTitleElementArr2[length] = richTitleElement;
                        codedInputByteBufferNano.readMessage(richTitleElement);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    RichTitleElement richTitleElement2 = new RichTitleElement();
                    richTitleElementArr2[length] = richTitleElement2;
                    codedInputByteBufferNano.readMessage(richTitleElement2);
                    this.rptMsgRichTitle = richTitleElementArr2;
                    break;
                case 96:
                    this.viewTimes = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.videoWidth = codedInputByteBufferNano.readUInt32();
                    break;
                case 112:
                    this.videoHight = codedInputByteBufferNano.readUInt32();
                    break;
                case 122:
                    this.doodlePicUrl = codedInputByteBufferNano.readString();
                    break;
                case 128:
                    this.isListen = codedInputByteBufferNano.readUInt32();
                    break;
                case 136:
                    this.isLike = codedInputByteBufferNano.readUInt32();
                    break;
                case 144:
                    this.likeNum = codedInputByteBufferNano.readUInt32();
                    break;
                case 154:
                    this.shareUrl = codedInputByteBufferNano.readString();
                    break;
                case 160:
                    this.followUid = codedInputByteBufferNano.readUInt64();
                    break;
                case 170:
                    this.jumpUrl = codedInputByteBufferNano.readString();
                    break;
                case 176:
                    this.upStatus = codedInputByteBufferNano.readUInt32();
                    break;
                case 186:
                    if (this.lbsInfo == null) {
                        this.lbsInfo = new LbsInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.lbsInfo);
                    break;
                case 192:
                    this.bgColor = codedInputByteBufferNano.readUInt32();
                    break;
                case 202:
                    this.vid = codedInputByteBufferNano.readString();
                    break;
                case 210:
                    this.shareMainTitle = codedInputByteBufferNano.readString();
                    break;
                case 218:
                    this.shareSubheading = codedInputByteBufferNano.readString();
                    break;
                case 224:
                    this.feedContentType = codedInputByteBufferNano.readUInt32();
                    break;
                case 232:
                    this.commentNum = codedInputByteBufferNano.readUInt32();
                    break;
                case 242:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 242);
                    String[] strArr = this.qieVideoUrl;
                    int length2 = strArr == null ? 0 : strArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    String[] strArr2 = new String[i16];
                    if (length2 != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        strArr2[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr2[length2] = codedInputByteBufferNano.readString();
                    this.qieVideoUrl = strArr2;
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
