package com.tencent.mobileqq.icgame.data.echo.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ForbidInfo extends ExtendableMessageNano<ForbidInfo> {
    private static volatile ForbidInfo[] _emptyArray;
    public String alertTips;
    public long effectTime;
    public long endTime;
    public boolean forbidForever;
    public int punishType;
    public long tinyId;

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
        this.tinyId = 0L;
        this.punishType = 0;
        this.effectTime = 0L;
        this.endTime = 0L;
        this.forbidForever = false;
        this.alertTips = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.tinyId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.punishType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long j16 = this.effectTime;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        long j17 = this.endTime;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j17);
        }
        boolean z16 = this.forbidForever;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        if (!this.alertTips.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.alertTips);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.tinyId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.punishType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long j16 = this.effectTime;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        long j17 = this.endTime;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j17);
        }
        boolean z16 = this.forbidForever;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        if (!this.alertTips.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.alertTips);
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
                this.tinyId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.punishType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.effectTime = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.endTime = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.forbidForever = codedInputByteBufferNano.readBool();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.alertTips = codedInputByteBufferNano.readString();
            }
        }
    }
}
