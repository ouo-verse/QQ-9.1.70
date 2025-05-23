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
public final class LinkMicHistoryQueryRsp extends ExtendableMessageNano<LinkMicHistoryQueryRsp> {
    private static volatile LinkMicHistoryQueryRsp[] _emptyArray;
    public LinkMicHistoryInfo[] hisList;

    public LinkMicHistoryQueryRsp() {
        clear();
    }

    public static LinkMicHistoryQueryRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicHistoryQueryRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicHistoryQueryRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicHistoryQueryRsp) MessageNano.mergeFrom(new LinkMicHistoryQueryRsp(), bArr);
    }

    public LinkMicHistoryQueryRsp clear() {
        this.hisList = LinkMicHistoryInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        LinkMicHistoryInfo[] linkMicHistoryInfoArr = this.hisList;
        if (linkMicHistoryInfoArr != null && linkMicHistoryInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                LinkMicHistoryInfo[] linkMicHistoryInfoArr2 = this.hisList;
                if (i3 >= linkMicHistoryInfoArr2.length) {
                    break;
                }
                LinkMicHistoryInfo linkMicHistoryInfo = linkMicHistoryInfoArr2[i3];
                if (linkMicHistoryInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, linkMicHistoryInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        LinkMicHistoryInfo[] linkMicHistoryInfoArr = this.hisList;
        if (linkMicHistoryInfoArr != null && linkMicHistoryInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                LinkMicHistoryInfo[] linkMicHistoryInfoArr2 = this.hisList;
                if (i3 >= linkMicHistoryInfoArr2.length) {
                    break;
                }
                LinkMicHistoryInfo linkMicHistoryInfo = linkMicHistoryInfoArr2[i3];
                if (linkMicHistoryInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, linkMicHistoryInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicHistoryQueryRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicHistoryQueryRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicHistoryQueryRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                LinkMicHistoryInfo[] linkMicHistoryInfoArr = this.hisList;
                int length = linkMicHistoryInfoArr == null ? 0 : linkMicHistoryInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                LinkMicHistoryInfo[] linkMicHistoryInfoArr2 = new LinkMicHistoryInfo[i3];
                if (length != 0) {
                    System.arraycopy(linkMicHistoryInfoArr, 0, linkMicHistoryInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    LinkMicHistoryInfo linkMicHistoryInfo = new LinkMicHistoryInfo();
                    linkMicHistoryInfoArr2[length] = linkMicHistoryInfo;
                    codedInputByteBufferNano.readMessage(linkMicHistoryInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                LinkMicHistoryInfo linkMicHistoryInfo2 = new LinkMicHistoryInfo();
                linkMicHistoryInfoArr2[length] = linkMicHistoryInfo2;
                codedInputByteBufferNano.readMessage(linkMicHistoryInfo2);
                this.hisList = linkMicHistoryInfoArr2;
            }
        }
    }
}
