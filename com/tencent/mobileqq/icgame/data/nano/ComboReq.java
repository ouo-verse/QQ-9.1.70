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
public final class ComboReq extends ExtendableMessageNano<ComboReq> {
    private static volatile ComboReq[] _emptyArray;
    public int comboGiftId;
    public int comboGiftNumber;
    public int comboOver;
    public int comboSeq;
    public int comboTimes;
    public int comboTotalCount;

    public ComboReq() {
        clear();
    }

    public static ComboReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ComboReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ComboReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ComboReq) MessageNano.mergeFrom(new ComboReq(), bArr);
    }

    public ComboReq clear() {
        this.comboSeq = 0;
        this.comboGiftId = 0;
        this.comboGiftNumber = 0;
        this.comboTimes = 0;
        this.comboTotalCount = 0;
        this.comboOver = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.comboSeq;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.comboGiftId;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.comboGiftNumber;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.comboTimes;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        int i19 = this.comboTotalCount;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i19);
        }
        int i26 = this.comboOver;
        if (i26 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i26);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.comboSeq;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.comboGiftId;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.comboGiftNumber;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.comboTimes;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        int i19 = this.comboTotalCount;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i19);
        }
        int i26 = this.comboOver;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ComboReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ComboReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ComboReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.comboSeq = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.comboGiftId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.comboGiftNumber = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.comboTimes = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.comboTotalCount = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.comboOver = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
