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
public final class LinkMicInfoQueryRsp extends ExtendableMessageNano<LinkMicInfoQueryRsp> {
    private static volatile LinkMicInfoQueryRsp[] _emptyArray;
    public LinkMicInfo[] linkMicInfo;

    public LinkMicInfoQueryRsp() {
        clear();
    }

    public static LinkMicInfoQueryRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicInfoQueryRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicInfoQueryRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicInfoQueryRsp) MessageNano.mergeFrom(new LinkMicInfoQueryRsp(), bArr);
    }

    public LinkMicInfoQueryRsp clear() {
        this.linkMicInfo = LinkMicInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        LinkMicInfo[] linkMicInfoArr = this.linkMicInfo;
        if (linkMicInfoArr != null && linkMicInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                LinkMicInfo[] linkMicInfoArr2 = this.linkMicInfo;
                if (i3 >= linkMicInfoArr2.length) {
                    break;
                }
                LinkMicInfo linkMicInfo = linkMicInfoArr2[i3];
                if (linkMicInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, linkMicInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        LinkMicInfo[] linkMicInfoArr = this.linkMicInfo;
        if (linkMicInfoArr != null && linkMicInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                LinkMicInfo[] linkMicInfoArr2 = this.linkMicInfo;
                if (i3 >= linkMicInfoArr2.length) {
                    break;
                }
                LinkMicInfo linkMicInfo = linkMicInfoArr2[i3];
                if (linkMicInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, linkMicInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicInfoQueryRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicInfoQueryRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicInfoQueryRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                LinkMicInfo[] linkMicInfoArr = this.linkMicInfo;
                int length = linkMicInfoArr == null ? 0 : linkMicInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                LinkMicInfo[] linkMicInfoArr2 = new LinkMicInfo[i3];
                if (length != 0) {
                    System.arraycopy(linkMicInfoArr, 0, linkMicInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    LinkMicInfo linkMicInfo = new LinkMicInfo();
                    linkMicInfoArr2[length] = linkMicInfo;
                    codedInputByteBufferNano.readMessage(linkMicInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                LinkMicInfo linkMicInfo2 = new LinkMicInfo();
                linkMicInfoArr2[length] = linkMicInfo2;
                codedInputByteBufferNano.readMessage(linkMicInfo2);
                this.linkMicInfo = linkMicInfoArr2;
            }
        }
    }
}
