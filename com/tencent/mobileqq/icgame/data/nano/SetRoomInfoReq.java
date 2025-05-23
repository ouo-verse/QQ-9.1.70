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
public final class SetRoomInfoReq extends ExtendableMessageNano<SetRoomInfoReq> {
    private static volatile SetRoomInfoReq[] _emptyArray;
    public String announcement;
    public String coverUrl;
    public long roomId;
    public String roomTag;
    public String topic;

    public SetRoomInfoReq() {
        clear();
    }

    public static SetRoomInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetRoomInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetRoomInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetRoomInfoReq) MessageNano.mergeFrom(new SetRoomInfoReq(), bArr);
    }

    public SetRoomInfoReq clear() {
        this.roomId = 0L;
        this.coverUrl = "";
        this.roomTag = "";
        this.topic = "";
        this.announcement = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.roomId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.coverUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.coverUrl);
        }
        if (!this.roomTag.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.roomTag);
        }
        if (!this.topic.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.topic);
        }
        if (!this.announcement.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.announcement);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.coverUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.coverUrl);
        }
        if (!this.roomTag.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.roomTag);
        }
        if (!this.topic.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.topic);
        }
        if (!this.announcement.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.announcement);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetRoomInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetRoomInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetRoomInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.coverUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.roomTag = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.topic = codedInputByteBufferNano.readString();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.announcement = codedInputByteBufferNano.readString();
            }
        }
    }
}
