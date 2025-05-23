package com.tencent.mobileqq.icgame.data.ilive.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class AnchorInfo extends ExtendableMessageNano<AnchorInfo> {
    private static volatile AnchorInfo[] _emptyArray;
    public long anchorUid;
    public String headImgUrl;
    public String nickName;
    public String rankUrl;
    public long watchCount;

    public AnchorInfo() {
        clear();
    }

    public static AnchorInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AnchorInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AnchorInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AnchorInfo) MessageNano.mergeFrom(new AnchorInfo(), bArr);
    }

    public AnchorInfo clear() {
        this.anchorUid = 0L;
        this.headImgUrl = "";
        this.nickName = "";
        this.watchCount = 0L;
        this.rankUrl = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.anchorUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.headImgUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.headImgUrl);
        }
        if (!this.nickName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.nickName);
        }
        long j16 = this.watchCount;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        if (!this.rankUrl.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.rankUrl);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.anchorUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.headImgUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.headImgUrl);
        }
        if (!this.nickName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.nickName);
        }
        long j16 = this.watchCount;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        if (!this.rankUrl.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.rankUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AnchorInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AnchorInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AnchorInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.headImgUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.nickName = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.watchCount = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.rankUrl = codedInputByteBufferNano.readString();
            }
        }
    }
}
