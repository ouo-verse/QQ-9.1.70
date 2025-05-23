package com.tencent.mobileqq.icgame.data.lucky.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AnchorProfit extends ExtendableMessageNano<AnchorProfit> {
    private static volatile AnchorProfit[] _emptyArray;
    public int luckyNum;
    public int profit;
    public int rank;

    /* renamed from: ts, reason: collision with root package name */
    public int f237265ts;

    public AnchorProfit() {
        clear();
    }

    public static AnchorProfit[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AnchorProfit[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AnchorProfit parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AnchorProfit) MessageNano.mergeFrom(new AnchorProfit(), bArr);
    }

    public AnchorProfit clear() {
        this.f237265ts = 0;
        this.rank = 0;
        this.luckyNum = 0;
        this.profit = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f237265ts;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.rank;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.luckyNum;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.profit;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f237265ts;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.rank;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.luckyNum;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.profit;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AnchorProfit parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AnchorProfit().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AnchorProfit mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f237265ts = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.rank = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.luckyNum = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.profit = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
