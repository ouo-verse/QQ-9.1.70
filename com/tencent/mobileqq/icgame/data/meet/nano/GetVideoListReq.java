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
public final class GetVideoListReq extends ExtendableMessageNano<GetVideoListReq> {
    private static volatile GetVideoListReq[] _emptyArray;
    public String bizId;
    public double lat;
    public double lng;
    public String qmei;
    public String session;

    public GetVideoListReq() {
        clear();
    }

    public static GetVideoListReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetVideoListReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetVideoListReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetVideoListReq) MessageNano.mergeFrom(new GetVideoListReq(), bArr);
    }

    public GetVideoListReq clear() {
        this.bizId = "";
        this.session = "";
        this.qmei = "";
        this.lng = 0.0d;
        this.lat = 0.0d;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.bizId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.bizId);
        }
        if (!this.session.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.session);
        }
        if (!this.qmei.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.qmei);
        }
        if (Double.doubleToLongBits(this.lng) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(4, this.lng);
        }
        if (Double.doubleToLongBits(this.lat) != Double.doubleToLongBits(0.0d)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(5, this.lat);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.bizId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.bizId);
        }
        if (!this.session.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.session);
        }
        if (!this.qmei.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.qmei);
        }
        if (Double.doubleToLongBits(this.lng) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(4, this.lng);
        }
        if (Double.doubleToLongBits(this.lat) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(5, this.lat);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetVideoListReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetVideoListReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetVideoListReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.bizId = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.session = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.qmei = codedInputByteBufferNano.readString();
            } else if (readTag == 33) {
                this.lng = codedInputByteBufferNano.readDouble();
            } else if (readTag != 41) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.lat = codedInputByteBufferNano.readDouble();
            }
        }
    }
}
