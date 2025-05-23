package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class StageInviteReq extends ExtendableMessageNano<StageInviteReq> {
    private static volatile StageInviteReq[] _emptyArray;
    public int avRight;
    public String ext;
    public int liveTime;
    public long roomId;
    public int seatType;
    public long uid;

    public StageInviteReq() {
        clear();
    }

    public static StageInviteReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new StageInviteReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static StageInviteReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (StageInviteReq) MessageNano.mergeFrom(new StageInviteReq(), bArr);
    }

    public StageInviteReq clear() {
        this.roomId = 0L;
        this.uid = 0L;
        this.seatType = 0;
        this.avRight = 0;
        this.liveTime = 0;
        this.ext = "";
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
        long j16 = this.uid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        int i3 = this.seatType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.avRight;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.liveTime;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        if (!this.ext.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(20, this.ext);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.uid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        int i3 = this.seatType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.avRight;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.liveTime;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        if (!this.ext.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.ext);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static StageInviteReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new StageInviteReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public StageInviteReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.seatType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.avRight = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.liveTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 162) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.ext = codedInputByteBufferNano.readString();
            }
        }
    }
}
