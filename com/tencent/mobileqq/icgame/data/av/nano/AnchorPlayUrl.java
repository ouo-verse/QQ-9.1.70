package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AnchorPlayUrl extends ExtendableMessageNano<AnchorPlayUrl> {
    private static volatile AnchorPlayUrl[] _emptyArray;
    public String flv;
    public String hls;
    public String liveCode;
    public int liveType;
    public Resolution resolution;
    public String rtmp;

    /* renamed from: ts, reason: collision with root package name */
    public long f237255ts;

    public AnchorPlayUrl() {
        clear();
    }

    public static AnchorPlayUrl[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AnchorPlayUrl[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AnchorPlayUrl parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AnchorPlayUrl) MessageNano.mergeFrom(new AnchorPlayUrl(), bArr);
    }

    public AnchorPlayUrl clear() {
        this.rtmp = "";
        this.flv = "";
        this.hls = "";
        this.f237255ts = 0L;
        this.liveType = 0;
        this.liveCode = "";
        this.resolution = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.rtmp.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.rtmp);
        }
        if (!this.flv.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.flv);
        }
        if (!this.hls.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.hls);
        }
        long j3 = this.f237255ts;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        int i3 = this.liveType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        if (!this.liveCode.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.liveCode);
        }
        Resolution resolution = this.resolution;
        if (resolution != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, resolution);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.rtmp.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.rtmp);
        }
        if (!this.flv.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.flv);
        }
        if (!this.hls.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.hls);
        }
        long j3 = this.f237255ts;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        int i3 = this.liveType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        if (!this.liveCode.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.liveCode);
        }
        Resolution resolution = this.resolution;
        if (resolution != null) {
            codedOutputByteBufferNano.writeMessage(7, resolution);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AnchorPlayUrl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AnchorPlayUrl().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AnchorPlayUrl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.rtmp = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.flv = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.hls = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.f237255ts = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.liveType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 50) {
                this.liveCode = codedInputByteBufferNano.readString();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.resolution == null) {
                    this.resolution = new Resolution();
                }
                codedInputByteBufferNano.readMessage(this.resolution);
            }
        }
    }
}
