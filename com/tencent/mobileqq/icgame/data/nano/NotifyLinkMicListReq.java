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
public final class NotifyLinkMicListReq extends ExtendableMessageNano<NotifyLinkMicListReq> {
    private static volatile NotifyLinkMicListReq[] _emptyArray;
    public LinkMicList list;

    public NotifyLinkMicListReq() {
        clear();
    }

    public static NotifyLinkMicListReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new NotifyLinkMicListReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static NotifyLinkMicListReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (NotifyLinkMicListReq) MessageNano.mergeFrom(new NotifyLinkMicListReq(), bArr);
    }

    public NotifyLinkMicListReq clear() {
        this.list = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        LinkMicList linkMicList = this.list;
        if (linkMicList != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, linkMicList);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        LinkMicList linkMicList = this.list;
        if (linkMicList != null) {
            codedOutputByteBufferNano.writeMessage(1, linkMicList);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static NotifyLinkMicListReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new NotifyLinkMicListReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public NotifyLinkMicListReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.list == null) {
                    this.list = new LinkMicList();
                }
                codedInputByteBufferNano.readMessage(this.list);
            }
        }
    }
}
