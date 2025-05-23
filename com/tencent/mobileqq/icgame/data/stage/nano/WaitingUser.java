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
public final class WaitingUser extends ExtendableMessageNano<WaitingUser> {
    private static volatile WaitingUser[] _emptyArray;
    public int avRight;
    public int clientType;
    public String ext;
    public int liveTime;
    public long timestamp;
    public long tinyid;
    public long uid;

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
        this.avRight = 0;
        this.timestamp = 0L;
        this.liveTime = 0;
        this.tinyid = 0L;
        this.clientType = 0;
        this.ext = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.avRight;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long j16 = this.timestamp;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        int i16 = this.liveTime;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        long j17 = this.tinyid;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        int i17 = this.clientType;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        if (!this.ext.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(20, this.ext);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.avRight;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long j16 = this.timestamp;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        int i16 = this.liveTime;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        long j17 = this.tinyid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        int i17 = this.clientType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        if (!this.ext.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.ext);
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
                this.avRight = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.liveTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.tinyid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.clientType = codedInputByteBufferNano.readUInt32();
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
