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
public final class GetVideoListRsp extends ExtendableMessageNano<GetVideoListRsp> {
    private static volatile GetVideoListRsp[] _emptyArray;
    public String errMsg;
    public int result;
    public String session;
    public VideoInfo[] videoInfo;

    public GetVideoListRsp() {
        clear();
    }

    public static GetVideoListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetVideoListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetVideoListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetVideoListRsp) MessageNano.mergeFrom(new GetVideoListRsp(), bArr);
    }

    public GetVideoListRsp clear() {
        this.result = 0;
        this.videoInfo = VideoInfo.emptyArray();
        this.session = "";
        this.errMsg = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        VideoInfo[] videoInfoArr = this.videoInfo;
        if (videoInfoArr != null && videoInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                VideoInfo[] videoInfoArr2 = this.videoInfo;
                if (i16 >= videoInfoArr2.length) {
                    break;
                }
                VideoInfo videoInfo = videoInfoArr2[i16];
                if (videoInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, videoInfo);
                }
                i16++;
            }
        }
        if (!this.session.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.session);
        }
        if (!this.errMsg.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.errMsg);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        VideoInfo[] videoInfoArr = this.videoInfo;
        if (videoInfoArr != null && videoInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                VideoInfo[] videoInfoArr2 = this.videoInfo;
                if (i16 >= videoInfoArr2.length) {
                    break;
                }
                VideoInfo videoInfo = videoInfoArr2[i16];
                if (videoInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, videoInfo);
                }
                i16++;
            }
        }
        if (!this.session.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.session);
        }
        if (!this.errMsg.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.errMsg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetVideoListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetVideoListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetVideoListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                VideoInfo[] videoInfoArr = this.videoInfo;
                int length = videoInfoArr == null ? 0 : videoInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                VideoInfo[] videoInfoArr2 = new VideoInfo[i3];
                if (length != 0) {
                    System.arraycopy(videoInfoArr, 0, videoInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfoArr2[length] = videoInfo;
                    codedInputByteBufferNano.readMessage(videoInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                VideoInfo videoInfo2 = new VideoInfo();
                videoInfoArr2[length] = videoInfo2;
                codedInputByteBufferNano.readMessage(videoInfo2);
                this.videoInfo = videoInfoArr2;
            } else if (readTag == 26) {
                this.session = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.errMsg = codedInputByteBufferNano.readString();
            }
        }
    }
}
