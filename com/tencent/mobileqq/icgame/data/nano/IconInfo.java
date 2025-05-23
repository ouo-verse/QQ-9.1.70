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
public final class IconInfo extends ExtendableMessageNano<IconInfo> {
    private static volatile IconInfo[] _emptyArray;
    public int height;
    public String iconId;
    public int width;

    public IconInfo() {
        clear();
    }

    public static IconInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new IconInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static IconInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (IconInfo) MessageNano.mergeFrom(new IconInfo(), bArr);
    }

    public IconInfo clear() {
        this.iconId = "";
        this.width = 0;
        this.height = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.iconId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.iconId);
        }
        int i3 = this.width;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.height;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.iconId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.iconId);
        }
        int i3 = this.width;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.height;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static IconInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new IconInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public IconInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.iconId = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.width = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.height = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
