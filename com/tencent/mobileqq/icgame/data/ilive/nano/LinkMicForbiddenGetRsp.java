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
public final class LinkMicForbiddenGetRsp extends ExtendableMessageNano<LinkMicForbiddenGetRsp> {
    private static volatile LinkMicForbiddenGetRsp[] _emptyArray;
    public LinkMicForbidden[] linkMicFbList;

    public LinkMicForbiddenGetRsp() {
        clear();
    }

    public static LinkMicForbiddenGetRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicForbiddenGetRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicForbiddenGetRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicForbiddenGetRsp) MessageNano.mergeFrom(new LinkMicForbiddenGetRsp(), bArr);
    }

    public LinkMicForbiddenGetRsp clear() {
        this.linkMicFbList = LinkMicForbidden.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        LinkMicForbidden[] linkMicForbiddenArr = this.linkMicFbList;
        if (linkMicForbiddenArr != null && linkMicForbiddenArr.length > 0) {
            int i3 = 0;
            while (true) {
                LinkMicForbidden[] linkMicForbiddenArr2 = this.linkMicFbList;
                if (i3 >= linkMicForbiddenArr2.length) {
                    break;
                }
                LinkMicForbidden linkMicForbidden = linkMicForbiddenArr2[i3];
                if (linkMicForbidden != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, linkMicForbidden);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        LinkMicForbidden[] linkMicForbiddenArr = this.linkMicFbList;
        if (linkMicForbiddenArr != null && linkMicForbiddenArr.length > 0) {
            int i3 = 0;
            while (true) {
                LinkMicForbidden[] linkMicForbiddenArr2 = this.linkMicFbList;
                if (i3 >= linkMicForbiddenArr2.length) {
                    break;
                }
                LinkMicForbidden linkMicForbidden = linkMicForbiddenArr2[i3];
                if (linkMicForbidden != null) {
                    codedOutputByteBufferNano.writeMessage(1, linkMicForbidden);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicForbiddenGetRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicForbiddenGetRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicForbiddenGetRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                LinkMicForbidden[] linkMicForbiddenArr = this.linkMicFbList;
                int length = linkMicForbiddenArr == null ? 0 : linkMicForbiddenArr.length;
                int i3 = repeatedFieldArrayLength + length;
                LinkMicForbidden[] linkMicForbiddenArr2 = new LinkMicForbidden[i3];
                if (length != 0) {
                    System.arraycopy(linkMicForbiddenArr, 0, linkMicForbiddenArr2, 0, length);
                }
                while (length < i3 - 1) {
                    LinkMicForbidden linkMicForbidden = new LinkMicForbidden();
                    linkMicForbiddenArr2[length] = linkMicForbidden;
                    codedInputByteBufferNano.readMessage(linkMicForbidden);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                LinkMicForbidden linkMicForbidden2 = new LinkMicForbidden();
                linkMicForbiddenArr2[length] = linkMicForbidden2;
                codedInputByteBufferNano.readMessage(linkMicForbidden2);
                this.linkMicFbList = linkMicForbiddenArr2;
            }
        }
    }
}
