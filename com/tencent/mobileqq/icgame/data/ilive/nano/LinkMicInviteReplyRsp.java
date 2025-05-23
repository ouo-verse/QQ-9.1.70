package com.tencent.mobileqq.icgame.data.ilive.nano;

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
public final class LinkMicInviteReplyRsp extends ExtendableMessageNano<LinkMicInviteReplyRsp> {
    private static volatile LinkMicInviteReplyRsp[] _emptyArray;
    public AnchorInfo[] anchorInfo;
    public int retCode;
    public String retMsg;

    public LinkMicInviteReplyRsp() {
        clear();
    }

    public static LinkMicInviteReplyRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicInviteReplyRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicInviteReplyRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicInviteReplyRsp) MessageNano.mergeFrom(new LinkMicInviteReplyRsp(), bArr);
    }

    public LinkMicInviteReplyRsp clear() {
        this.retCode = 0;
        this.retMsg = "";
        this.anchorInfo = AnchorInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retCode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.retMsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.retMsg);
        }
        AnchorInfo[] anchorInfoArr = this.anchorInfo;
        if (anchorInfoArr != null && anchorInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                AnchorInfo[] anchorInfoArr2 = this.anchorInfo;
                if (i16 >= anchorInfoArr2.length) {
                    break;
                }
                AnchorInfo anchorInfo = anchorInfoArr2[i16];
                if (anchorInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, anchorInfo);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retCode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.retMsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.retMsg);
        }
        AnchorInfo[] anchorInfoArr = this.anchorInfo;
        if (anchorInfoArr != null && anchorInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                AnchorInfo[] anchorInfoArr2 = this.anchorInfo;
                if (i16 >= anchorInfoArr2.length) {
                    break;
                }
                AnchorInfo anchorInfo = anchorInfoArr2[i16];
                if (anchorInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, anchorInfo);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicInviteReplyRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicInviteReplyRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicInviteReplyRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retCode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.retMsg = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                AnchorInfo[] anchorInfoArr = this.anchorInfo;
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
                this.anchorInfo = anchorInfoArr2;
            }
        }
    }
}
