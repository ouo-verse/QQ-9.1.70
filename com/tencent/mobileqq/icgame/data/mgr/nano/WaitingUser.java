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
public final class WaitingUser extends ExtendableMessageNano<WaitingUser> {
    private static volatile WaitingUser[] _emptyArray;
    public int clientType;
    public int landscapeType;
    public int micStatus;
    public int status;
    public long timestamp;
    public long tinyid;
    public int type;
    public long uid;
    public int videoStatus;

    public WaitingUser() {
        clear();
    }

    public static WaitingUser[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new WaitingUser[0];
                }
            }
        }
        return _emptyArray;
    }

    public static WaitingUser parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (WaitingUser) MessageNano.mergeFrom(new WaitingUser(), bArr);
    }

    public WaitingUser clear() {
        this.uid = 0L;
        this.micStatus = 0;
        this.videoStatus = 0;
        this.status = 0;
        this.type = 0;
        this.landscapeType = 0;
        this.timestamp = 0L;
        this.tinyid = 0L;
        this.clientType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.uid);
        int i3 = this.micStatus;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.videoStatus;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.status;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.type;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        int i19 = this.landscapeType;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i19);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
        }
        long j16 = this.tinyid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j16);
        }
        int i26 = this.clientType;
        if (i26 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(9, i26);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.uid);
        int i3 = this.micStatus;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.videoStatus;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.status;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.type;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        int i19 = this.landscapeType;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i19);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
        }
        long j16 = this.tinyid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j16);
        }
        int i26 = this.clientType;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static WaitingUser parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new WaitingUser().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public WaitingUser mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.micStatus = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.videoStatus = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.status = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.landscapeType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 56) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 64) {
                this.tinyid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.clientType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
