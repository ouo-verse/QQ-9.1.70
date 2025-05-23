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
public final class InviteEntity extends ExtendableMessageNano<InviteEntity> {
    private static volatile InviteEntity[] _emptyArray;
    public AnchorInfo receiveAnchor;
    public int replyState;
    public AnchorInfo sendAnchor;

    /* renamed from: ts, reason: collision with root package name */
    public long f237259ts;

    public InviteEntity() {
        clear();
    }

    public static InviteEntity[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InviteEntity[0];
                }
            }
        }
        return _emptyArray;
    }

    public static InviteEntity parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (InviteEntity) MessageNano.mergeFrom(new InviteEntity(), bArr);
    }

    public InviteEntity clear() {
        this.f237259ts = 0L;
        this.sendAnchor = null;
        this.receiveAnchor = null;
        this.replyState = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f237259ts;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        AnchorInfo anchorInfo = this.sendAnchor;
        if (anchorInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, anchorInfo);
        }
        AnchorInfo anchorInfo2 = this.receiveAnchor;
        if (anchorInfo2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, anchorInfo2);
        }
        int i3 = this.replyState;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f237259ts;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        AnchorInfo anchorInfo = this.sendAnchor;
        if (anchorInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, anchorInfo);
        }
        AnchorInfo anchorInfo2 = this.receiveAnchor;
        if (anchorInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(3, anchorInfo2);
        }
        int i3 = this.replyState;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static InviteEntity parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new InviteEntity().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public InviteEntity mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f237259ts = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                if (this.sendAnchor == null) {
                    this.sendAnchor = new AnchorInfo();
                }
                codedInputByteBufferNano.readMessage(this.sendAnchor);
            } else if (readTag == 26) {
                if (this.receiveAnchor == null) {
                    this.receiveAnchor = new AnchorInfo();
                }
                codedInputByteBufferNano.readMessage(this.receiveAnchor);
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.replyState = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
