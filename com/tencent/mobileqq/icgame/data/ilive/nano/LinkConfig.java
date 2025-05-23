package com.tencent.mobileqq.icgame.data.ilive.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LinkConfig extends ExtendableMessageNano<LinkConfig> {
    private static volatile LinkConfig[] _emptyArray;
    public int mediaType;
    public int mixType;
    public int modelType;
    public int playType;

    public LinkConfig() {
        clear();
    }

    public static LinkConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkConfig) MessageNano.mergeFrom(new LinkConfig(), bArr);
    }

    public LinkConfig clear() {
        this.playType = 0;
        this.mediaType = 0;
        this.mixType = 0;
        this.modelType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.playType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.mediaType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.mixType;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.modelType;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.playType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.mediaType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.mixType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.modelType;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkConfig().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.playType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.mediaType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.mixType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.modelType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
