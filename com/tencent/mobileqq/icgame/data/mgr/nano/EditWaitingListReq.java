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
public final class EditWaitingListReq extends ExtendableMessageNano<EditWaitingListReq> {
    private static volatile EditWaitingListReq[] _emptyArray;
    public long editUid;
    public int fromListId;
    public int landscapeType;
    public int micStatus;
    public int position;
    public int roomId;
    public int toListId;
    public int type;
    public int videoStatus;

    public EditWaitingListReq() {
        clear();
    }

    public static EditWaitingListReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditWaitingListReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditWaitingListReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditWaitingListReq) MessageNano.mergeFrom(new EditWaitingListReq(), bArr);
    }

    public EditWaitingListReq clear() {
        this.roomId = 0;
        this.editUid = 0L;
        this.fromListId = 0;
        this.toListId = 0;
        this.position = 0;
        this.micStatus = 0;
        this.videoStatus = 0;
        this.type = 0;
        this.landscapeType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
        long j3 = this.editUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        int i3 = this.fromListId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.toListId;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.position;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.micStatus;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        int i19 = this.videoStatus;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        int i26 = this.type;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i26);
        }
        int i27 = this.landscapeType;
        if (i27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(9, i27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        long j3 = this.editUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        int i3 = this.fromListId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.toListId;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.position;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.micStatus;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        int i19 = this.videoStatus;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        int i26 = this.type;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i26);
        }
        int i27 = this.landscapeType;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i27);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditWaitingListReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditWaitingListReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditWaitingListReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.editUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.fromListId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.toListId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.position = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.micStatus = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 56) {
                this.videoStatus = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 64) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.landscapeType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
