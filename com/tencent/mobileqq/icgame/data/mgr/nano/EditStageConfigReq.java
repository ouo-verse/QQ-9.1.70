package com.tencent.mobileqq.icgame.data.mgr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class EditStageConfigReq extends ExtendableMessageNano<EditStageConfigReq> {
    private static volatile EditStageConfigReq[] _emptyArray;
    public int controlMic;
    public int freeExtraType;
    public int lineQueueFlag;
    public int liveExtraMode;
    public int performExtraType;
    public int roomId;
    public int stageMode;
    public int waitingTime;

    public EditStageConfigReq() {
        clear();
    }

    public static EditStageConfigReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditStageConfigReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditStageConfigReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditStageConfigReq) MessageNano.mergeFrom(new EditStageConfigReq(), bArr);
    }

    public EditStageConfigReq clear() {
        this.roomId = 0;
        this.stageMode = 0;
        this.controlMic = 0;
        this.performExtraType = 0;
        this.waitingTime = 0;
        this.freeExtraType = 0;
        this.lineQueueFlag = 0;
        this.liveExtraMode = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
        int i3 = this.stageMode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.controlMic;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.performExtraType;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.waitingTime;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        int i19 = this.freeExtraType;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i19);
        }
        int i26 = this.lineQueueFlag;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i26);
        }
        int i27 = this.liveExtraMode;
        if (i27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(8, i27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        int i3 = this.stageMode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.controlMic;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.performExtraType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.waitingTime;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        int i19 = this.freeExtraType;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i19);
        }
        int i26 = this.lineQueueFlag;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i26);
        }
        int i27 = this.liveExtraMode;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i27);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditStageConfigReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditStageConfigReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditStageConfigReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.stageMode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.controlMic = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.performExtraType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.waitingTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.freeExtraType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 56) {
                this.lineQueueFlag = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.liveExtraMode = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
