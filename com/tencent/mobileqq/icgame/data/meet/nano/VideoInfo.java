package com.tencent.mobileqq.icgame.data.meet.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class VideoInfo extends ExtendableMessageNano<VideoInfo> {
    private static volatile VideoInfo[] _emptyArray;
    public long commentNum;
    public ShortVideoInfo shortVideoInfo;

    public VideoInfo() {
        clear();
    }

    public static VideoInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new VideoInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static VideoInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (VideoInfo) MessageNano.mergeFrom(new VideoInfo(), bArr);
    }

    public VideoInfo clear() {
        this.shortVideoInfo = null;
        this.commentNum = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ShortVideoInfo shortVideoInfo = this.shortVideoInfo;
        if (shortVideoInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, shortVideoInfo);
        }
        long j3 = this.commentNum;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ShortVideoInfo shortVideoInfo = this.shortVideoInfo;
        if (shortVideoInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, shortVideoInfo);
        }
        long j3 = this.commentNum;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static VideoInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new VideoInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public VideoInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.shortVideoInfo == null) {
                    this.shortVideoInfo = new ShortVideoInfo();
                }
                codedInputByteBufferNano.readMessage(this.shortVideoInfo);
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.commentNum = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
