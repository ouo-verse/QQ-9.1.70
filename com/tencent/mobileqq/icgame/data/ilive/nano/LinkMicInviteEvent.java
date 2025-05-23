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
public final class LinkMicInviteEvent extends ExtendableMessageNano<LinkMicInviteEvent> {
    private static volatile LinkMicInviteEvent[] _emptyArray;
    public int inviteState;
    public int linkMicPay;
    public int linkMicType;
    public AnchorInfo receiveAnchor;
    public int replyState;
    public AnchorInfo sendAnchor;
    public long type;

    public LinkMicInviteEvent() {
        clear();
    }

    public static LinkMicInviteEvent[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicInviteEvent[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicInviteEvent parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicInviteEvent) MessageNano.mergeFrom(new LinkMicInviteEvent(), bArr);
    }

    public LinkMicInviteEvent clear() {
        this.type = 0L;
        this.inviteState = 0;
        this.replyState = 0;
        this.sendAnchor = null;
        this.receiveAnchor = null;
        this.linkMicType = 0;
        this.linkMicPay = 0;
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
        int i3 = this.inviteState;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.replyState;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        AnchorInfo anchorInfo = this.sendAnchor;
        if (anchorInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, anchorInfo);
        }
        AnchorInfo anchorInfo2 = this.receiveAnchor;
        if (anchorInfo2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, anchorInfo2);
        }
        int i17 = this.linkMicType;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.linkMicPay;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.type;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.inviteState;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.replyState;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        AnchorInfo anchorInfo = this.sendAnchor;
        if (anchorInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, anchorInfo);
        }
        AnchorInfo anchorInfo2 = this.receiveAnchor;
        if (anchorInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(5, anchorInfo2);
        }
        int i17 = this.linkMicType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.linkMicPay;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicInviteEvent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicInviteEvent().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicInviteEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.inviteState = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.replyState = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                if (this.sendAnchor == null) {
                    this.sendAnchor = new AnchorInfo();
                }
                codedInputByteBufferNano.readMessage(this.sendAnchor);
            } else if (readTag == 42) {
                if (this.receiveAnchor == null) {
                    this.receiveAnchor = new AnchorInfo();
                }
                codedInputByteBufferNano.readMessage(this.receiveAnchor);
            } else if (readTag == 48) {
                this.linkMicType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.linkMicPay = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
