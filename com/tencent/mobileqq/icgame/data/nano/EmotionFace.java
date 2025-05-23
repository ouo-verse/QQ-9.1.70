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
public final class EmotionFace extends ExtendableMessageNano<EmotionFace> {
    private static volatile EmotionFace[] _emptyArray;

    /* renamed from: id, reason: collision with root package name */
    public int f237277id;
    public String name;
    public String pic;
    public String previewPic;

    public EmotionFace() {
        clear();
    }

    public static EmotionFace[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EmotionFace[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EmotionFace parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EmotionFace) MessageNano.mergeFrom(new EmotionFace(), bArr);
    }

    public EmotionFace clear() {
        this.f237277id = 0;
        this.name = "";
        this.pic = "";
        this.previewPic = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.f237277id) + CodedOutputByteBufferNano.computeStringSize(2, this.name) + CodedOutputByteBufferNano.computeStringSize(3, this.pic) + CodedOutputByteBufferNano.computeStringSize(4, this.previewPic);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.f237277id);
        codedOutputByteBufferNano.writeString(2, this.name);
        codedOutputByteBufferNano.writeString(3, this.pic);
        codedOutputByteBufferNano.writeString(4, this.previewPic);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EmotionFace parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EmotionFace().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EmotionFace mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f237277id = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.name = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.pic = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.previewPic = codedInputByteBufferNano.readString();
            }
        }
    }
}
