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
public final class MeetVideoQueryReq extends ExtendableMessageNano<MeetVideoQueryReq> {
    private static volatile MeetVideoQueryReq[] _emptyArray;
    public boolean firstGet;
    public double lat;
    public double long_;
    public int num;
    public int page;

    public MeetVideoQueryReq() {
        clear();
    }

    public static MeetVideoQueryReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MeetVideoQueryReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MeetVideoQueryReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MeetVideoQueryReq) MessageNano.mergeFrom(new MeetVideoQueryReq(), bArr);
    }

    public MeetVideoQueryReq clear() {
        this.firstGet = false;
        this.long_ = 0.0d;
        this.lat = 0.0d;
        this.page = 0;
        this.num = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.firstGet;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        if (Double.doubleToLongBits(this.long_) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.long_);
        }
        if (Double.doubleToLongBits(this.lat) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, this.lat);
        }
        int i3 = this.page;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        int i16 = this.num;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.firstGet;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        if (Double.doubleToLongBits(this.long_) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(2, this.long_);
        }
        if (Double.doubleToLongBits(this.lat) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(3, this.lat);
        }
        int i3 = this.page;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        int i16 = this.num;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MeetVideoQueryReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MeetVideoQueryReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MeetVideoQueryReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.firstGet = codedInputByteBufferNano.readBool();
            } else if (readTag == 17) {
                this.long_ = codedInputByteBufferNano.readDouble();
            } else if (readTag == 25) {
                this.lat = codedInputByteBufferNano.readDouble();
            } else if (readTag == 32) {
                this.page = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.num = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
