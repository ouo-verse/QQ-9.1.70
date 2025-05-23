package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetLoveAnchorInfoRsp extends ExtendableMessageNano<GetLoveAnchorInfoRsp> {
    private static volatile GetLoveAnchorInfoRsp[] _emptyArray;
    public LoveAnchorInfo infoList;
    public String roomTags;

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
        this.infoList = null;
        this.roomTags = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        LoveAnchorInfo loveAnchorInfo = this.infoList;
        if (loveAnchorInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, loveAnchorInfo);
        }
        if (!this.roomTags.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.roomTags);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        LoveAnchorInfo loveAnchorInfo = this.infoList;
        if (loveAnchorInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, loveAnchorInfo);
        }
        if (!this.roomTags.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.roomTags);
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
                if (this.infoList == null) {
                    this.infoList = new LoveAnchorInfo();
                }
                codedInputByteBufferNano.readMessage(this.infoList);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.roomTags = codedInputByteBufferNano.readString();
            }
        }
    }
}
