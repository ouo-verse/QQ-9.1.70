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
public final class TextElement extends ExtendableMessageNano<TextElement> {
    private static volatile TextElement[] _emptyArray;
    public int bgcolor;
    public int color;
    public int fgcolor;
    public String text;

    public TextElement() {
        clear();
    }

    public static TextElement[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TextElement[0];
                }
            }
        }
        return _emptyArray;
    }

    public static TextElement parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (TextElement) MessageNano.mergeFrom(new TextElement(), bArr);
    }

    public TextElement clear() {
        this.text = "";
        this.fgcolor = 0;
        this.bgcolor = 0;
        this.color = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.text.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
        }
        int i3 = this.fgcolor;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.bgcolor;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.color;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.text);
        }
        int i3 = this.fgcolor;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.bgcolor;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.color;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static TextElement parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new TextElement().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public TextElement mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.text = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.fgcolor = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.bgcolor = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.color = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
