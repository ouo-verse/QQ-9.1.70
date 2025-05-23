package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PicAndScoreInfo extends ExtendableMessageNano<PicAndScoreInfo> {
    private static volatile PicAndScoreInfo[] _emptyArray;
    public String answer;
    public String avatar;
    public int drawPicScore;
    public String nick;
    public String picUrl;
    public long roomId;
    public long uid;

    public PicAndScoreInfo() {
        clear();
    }

    public static PicAndScoreInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PicAndScoreInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PicAndScoreInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PicAndScoreInfo) MessageNano.mergeFrom(new PicAndScoreInfo(), bArr);
    }

    public PicAndScoreInfo clear() {
        this.uid = 0L;
        this.roomId = 0L;
        this.drawPicScore = 0;
        this.answer = "";
        this.picUrl = "";
        this.nick = "";
        this.avatar = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.roomId;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        int i3 = this.drawPicScore;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.answer.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.answer);
        }
        if (!this.picUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.picUrl);
        }
        if (!this.nick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.nick);
        }
        if (!this.avatar.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.avatar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.roomId;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        int i3 = this.drawPicScore;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.answer.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.answer);
        }
        if (!this.picUrl.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.picUrl);
        }
        if (!this.nick.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.nick);
        }
        if (!this.avatar.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.avatar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PicAndScoreInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PicAndScoreInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PicAndScoreInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.drawPicScore = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                this.answer = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.picUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.nick = codedInputByteBufferNano.readString();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.avatar = codedInputByteBufferNano.readString();
            }
        }
    }
}
