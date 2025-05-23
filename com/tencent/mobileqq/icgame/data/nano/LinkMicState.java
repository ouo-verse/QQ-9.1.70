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
public final class LinkMicState extends ExtendableMessageNano<LinkMicState> {
    private static volatile LinkMicState[] _emptyArray;
    public long anchorUid;
    public long mediaType;
    public long mixType;
    public int modelType;
    public long playType;
    public long roomid;
    public long state;

    public LinkMicState() {
        clear();
    }

    public static LinkMicState[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicState[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicState parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicState) MessageNano.mergeFrom(new LinkMicState(), bArr);
    }

    public LinkMicState clear() {
        this.anchorUid = 0L;
        this.roomid = 0L;
        this.state = 0L;
        this.mediaType = 0L;
        this.mixType = 0L;
        this.playType = 0L;
        this.modelType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.anchorUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.roomid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.state;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        long j18 = this.mediaType;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j18);
        }
        long j19 = this.mixType;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j19);
        }
        long j26 = this.playType;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j26);
        }
        int i3 = this.modelType;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.anchorUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.roomid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.state;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        long j18 = this.mediaType;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j18);
        }
        long j19 = this.mixType;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j19);
        }
        long j26 = this.playType;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j26);
        }
        int i3 = this.modelType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicState().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.roomid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.state = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.mediaType = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.mixType = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.playType = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.modelType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
