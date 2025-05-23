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
public final class UserVoiceCover extends ExtendableMessageNano<UserVoiceCover> {
    private static volatile UserVoiceCover[] _emptyArray;
    public float offsetX;
    public float offsetY;
    public long uid;
    public String url;
    public String urlSquare;

    public UserVoiceCover() {
        clear();
    }

    public static UserVoiceCover[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserVoiceCover[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserVoiceCover parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserVoiceCover) MessageNano.mergeFrom(new UserVoiceCover(), bArr);
    }

    public UserVoiceCover clear() {
        this.uid = 0L;
        this.url = "";
        this.offsetX = 0.0f;
        this.offsetY = 0.0f;
        this.urlSquare = "";
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
        if (!this.url.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.url);
        }
        if (Float.floatToIntBits(this.offsetX) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.offsetX);
        }
        if (Float.floatToIntBits(this.offsetY) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.offsetY);
        }
        if (!this.urlSquare.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.urlSquare);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.url);
        }
        if (Float.floatToIntBits(this.offsetX) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(3, this.offsetX);
        }
        if (Float.floatToIntBits(this.offsetY) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.offsetY);
        }
        if (!this.urlSquare.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.urlSquare);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserVoiceCover parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserVoiceCover().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserVoiceCover mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.url = codedInputByteBufferNano.readString();
            } else if (readTag == 29) {
                this.offsetX = codedInputByteBufferNano.readFloat();
            } else if (readTag == 37) {
                this.offsetY = codedInputByteBufferNano.readFloat();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.urlSquare = codedInputByteBufferNano.readString();
            }
        }
    }
}
