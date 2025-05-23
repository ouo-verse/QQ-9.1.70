package com.tencent.mobileqq.icgame.data.punish.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ForbidInfo extends ExtendableMessageNano<ForbidInfo> {
    private static volatile ForbidInfo[] _emptyArray;
    public int effectTime;
    public int endTime;
    public long handler;
    public int leftTime;
    public int punishType;
    public byte[] reason;
    public long uid;

    public ForbidInfo() {
        clear();
    }

    public static ForbidInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ForbidInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ForbidInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ForbidInfo) MessageNano.mergeFrom(new ForbidInfo(), bArr);
    }

    public ForbidInfo clear() {
        this.uid = 0L;
        this.effectTime = 0;
        this.endTime = 0;
        this.handler = 0L;
        this.reason = WireFormatNano.EMPTY_BYTES;
        this.punishType = 0;
        this.leftTime = 0;
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
        int i3 = this.effectTime;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.endTime;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        long j16 = this.handler;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        if (!Arrays.equals(this.reason, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.reason);
        }
        int i17 = this.punishType;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.leftTime;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.effectTime;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.endTime;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        long j16 = this.handler;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        if (!Arrays.equals(this.reason, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.reason);
        }
        int i17 = this.punishType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.leftTime;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ForbidInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ForbidInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ForbidInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.effectTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.endTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.handler = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 42) {
                this.reason = codedInputByteBufferNano.readBytes();
            } else if (readTag == 48) {
                this.punishType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.leftTime = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
