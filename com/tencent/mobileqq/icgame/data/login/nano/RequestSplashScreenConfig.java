package com.tencent.mobileqq.icgame.data.login.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class RequestSplashScreenConfig extends ExtendableMessageNano<RequestSplashScreenConfig> {
    private static volatile RequestSplashScreenConfig[] _emptyArray;
    public int heightPx;
    public int widthPx;

    public RequestSplashScreenConfig() {
        clear();
    }

    public static RequestSplashScreenConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RequestSplashScreenConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RequestSplashScreenConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RequestSplashScreenConfig) MessageNano.mergeFrom(new RequestSplashScreenConfig(), bArr);
    }

    public RequestSplashScreenConfig clear() {
        this.widthPx = 0;
        this.heightPx = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.widthPx;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.heightPx;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.widthPx;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.heightPx;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RequestSplashScreenConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RequestSplashScreenConfig().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RequestSplashScreenConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.widthPx = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.heightPx = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
