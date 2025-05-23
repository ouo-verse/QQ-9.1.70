package com.tencent.mobileqq.icgame.data.mgr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ODScreenShareInfo extends ExtendableMessageNano<ODScreenShareInfo> {
    private static volatile ODScreenShareInfo[] _emptyArray;
    public float captureHeight;
    public float captureWidth;
    public float sdkHeight;
    public float sdkWidth;

    public ODScreenShareInfo() {
        clear();
    }

    public static ODScreenShareInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ODScreenShareInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ODScreenShareInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ODScreenShareInfo) MessageNano.mergeFrom(new ODScreenShareInfo(), bArr);
    }

    public ODScreenShareInfo clear() {
        this.sdkWidth = 0.0f;
        this.sdkHeight = 0.0f;
        this.captureWidth = 0.0f;
        this.captureHeight = 0.0f;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeFloatSize(1, this.sdkWidth) + CodedOutputByteBufferNano.computeFloatSize(2, this.sdkHeight) + CodedOutputByteBufferNano.computeFloatSize(3, this.captureWidth) + CodedOutputByteBufferNano.computeFloatSize(4, this.captureHeight);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeFloat(1, this.sdkWidth);
        codedOutputByteBufferNano.writeFloat(2, this.sdkHeight);
        codedOutputByteBufferNano.writeFloat(3, this.captureWidth);
        codedOutputByteBufferNano.writeFloat(4, this.captureHeight);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ODScreenShareInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ODScreenShareInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ODScreenShareInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 13) {
                this.sdkWidth = codedInputByteBufferNano.readFloat();
            } else if (readTag == 21) {
                this.sdkHeight = codedInputByteBufferNano.readFloat();
            } else if (readTag == 29) {
                this.captureWidth = codedInputByteBufferNano.readFloat();
            } else if (readTag != 37) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.captureHeight = codedInputByteBufferNano.readFloat();
            }
        }
    }
}
