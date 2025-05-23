package com.tencent.mobileqq.icgame.data.ilive.feed.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class FeedsInfo extends ExtendableMessageNano<FeedsInfo> {
    private static volatile FeedsInfo[] _emptyArray;
    public String abstract_;
    public byte[] content;
    public String coverPic;
    public String feedId;
    public int like;
    public int likeTotal;
    public long publishTime;
    public AnchorInfo[] relateAnchor;
    public int shareTotal;
    public int sticky;
    public String title;

    public FeedsInfo() {
        clear();
    }

    public static FeedsInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FeedsInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FeedsInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FeedsInfo) MessageNano.mergeFrom(new FeedsInfo(), bArr);
    }

    public FeedsInfo clear() {
        this.feedId = "";
        this.title = "";
        this.coverPic = "";
        this.publishTime = 0L;
        this.content = WireFormatNano.EMPTY_BYTES;
        this.like = 0;
        this.relateAnchor = AnchorInfo.emptyArray();
        this.sticky = 0;
        this.likeTotal = 0;
        this.shareTotal = 0;
        this.abstract_ = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.feedId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.feedId);
        }
        if (!this.title.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
        }
        if (!this.coverPic.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.coverPic);
        }
        long j3 = this.publishTime;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        if (!Arrays.equals(this.content, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.content);
        }
        int i3 = this.like;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        AnchorInfo[] anchorInfoArr = this.relateAnchor;
        if (anchorInfoArr != null && anchorInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                AnchorInfo[] anchorInfoArr2 = this.relateAnchor;
                if (i16 >= anchorInfoArr2.length) {
                    break;
                }
                AnchorInfo anchorInfo = anchorInfoArr2[i16];
                if (anchorInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, anchorInfo);
                }
                i16++;
            }
        }
        int i17 = this.sticky;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        int i18 = this.likeTotal;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i18);
        }
        int i19 = this.shareTotal;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i19);
        }
        if (!this.abstract_.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.abstract_);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.feedId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.feedId);
        }
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.title);
        }
        if (!this.coverPic.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.coverPic);
        }
        long j3 = this.publishTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        if (!Arrays.equals(this.content, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.content);
        }
        int i3 = this.like;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        AnchorInfo[] anchorInfoArr = this.relateAnchor;
        if (anchorInfoArr != null && anchorInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                AnchorInfo[] anchorInfoArr2 = this.relateAnchor;
                if (i16 >= anchorInfoArr2.length) {
                    break;
                }
                AnchorInfo anchorInfo = anchorInfoArr2[i16];
                if (anchorInfo != null) {
                    codedOutputByteBufferNano.writeMessage(7, anchorInfo);
                }
                i16++;
            }
        }
        int i17 = this.sticky;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        int i18 = this.likeTotal;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i18);
        }
        int i19 = this.shareTotal;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i19);
        }
        if (!this.abstract_.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.abstract_);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FeedsInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FeedsInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FeedsInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.feedId = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.title = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.coverPic = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.publishTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    this.content = codedInputByteBufferNano.readBytes();
                    break;
                case 48:
                    this.like = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    AnchorInfo[] anchorInfoArr = this.relateAnchor;
                    int length = anchorInfoArr == null ? 0 : anchorInfoArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    AnchorInfo[] anchorInfoArr2 = new AnchorInfo[i3];
                    if (length != 0) {
                        System.arraycopy(anchorInfoArr, 0, anchorInfoArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        AnchorInfo anchorInfo = new AnchorInfo();
                        anchorInfoArr2[length] = anchorInfo;
                        codedInputByteBufferNano.readMessage(anchorInfo);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    AnchorInfo anchorInfo2 = new AnchorInfo();
                    anchorInfoArr2[length] = anchorInfo2;
                    codedInputByteBufferNano.readMessage(anchorInfo2);
                    this.relateAnchor = anchorInfoArr2;
                    break;
                case 64:
                    this.sticky = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.likeTotal = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.shareTotal = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    this.abstract_ = codedInputByteBufferNano.readString();
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
