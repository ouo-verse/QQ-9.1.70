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
public final class LinkMicEvent extends ExtendableMessageNano<LinkMicEvent> {
    private static volatile LinkMicEvent[] _emptyArray;
    public LinkMicList list;
    public LinkMicState state;
    public long type;

    public LinkMicEvent() {
        clear();
    }

    public static LinkMicEvent[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicEvent[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicEvent parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicEvent) MessageNano.mergeFrom(new LinkMicEvent(), bArr);
    }

    public LinkMicEvent clear() {
        this.type = 0L;
        this.state = null;
        this.list = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.type;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        LinkMicState linkMicState = this.state;
        if (linkMicState != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, linkMicState);
        }
        LinkMicList linkMicList = this.list;
        if (linkMicList != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, linkMicList);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.type;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        LinkMicState linkMicState = this.state;
        if (linkMicState != null) {
            codedOutputByteBufferNano.writeMessage(2, linkMicState);
        }
        LinkMicList linkMicList = this.list;
        if (linkMicList != null) {
            codedOutputByteBufferNano.writeMessage(3, linkMicList);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicEvent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicEvent().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                if (this.state == null) {
                    this.state = new LinkMicState();
                }
                codedInputByteBufferNano.readMessage(this.state);
            } else if (readTag != 26) {
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
