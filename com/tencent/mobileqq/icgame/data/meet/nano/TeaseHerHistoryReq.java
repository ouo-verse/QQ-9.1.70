package com.tencent.mobileqq.icgame.data.meet.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class TeaseHerHistoryReq extends ExtendableMessageNano<TeaseHerHistoryReq> {
    private static volatile TeaseHerHistoryReq[] _emptyArray;
    public double lat;
    public double long_;
    public int num;
    public int page;

    public TeaseHerHistoryReq() {
        clear();
    }

    public static TeaseHerHistoryReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TeaseHerHistoryReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static TeaseHerHistoryReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (TeaseHerHistoryReq) MessageNano.mergeFrom(new TeaseHerHistoryReq(), bArr);
    }

    public TeaseHerHistoryReq clear() {
        this.page = 0;
        this.num = 0;
        this.long_ = 0.0d;
        this.lat = 0.0d;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.page;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.num;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (Double.doubleToLongBits(this.long_) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, this.long_);
        }
        if (Double.doubleToLongBits(this.lat) != Double.doubleToLongBits(0.0d)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(4, this.lat);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.page;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.num;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (Double.doubleToLongBits(this.long_) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(3, this.long_);
        }
        if (Double.doubleToLongBits(this.lat) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(4, this.lat);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static TeaseHerHistoryReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new TeaseHerHistoryReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public TeaseHerHistoryReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.page = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.num = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 25) {
                this.long_ = codedInputByteBufferNano.readDouble();
            } else if (readTag != 33) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.lat = codedInputByteBufferNano.readDouble();
            }
        }
    }
}
