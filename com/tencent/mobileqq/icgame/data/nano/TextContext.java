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
public final class TextContext extends ExtendableMessageNano<TextContext> {
    private static volatile TextContext[] _emptyArray;
    public String content;
    public String contentColor;
    public String title;
    public String titleColor;

    public TextContext() {
        clear();
    }

    public static TextContext[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TextContext[0];
                }
            }
        }
        return _emptyArray;
    }

    public static TextContext parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (TextContext) MessageNano.mergeFrom(new TextContext(), bArr);
    }

    public TextContext clear() {
        this.title = "";
        this.titleColor = "";
        this.content = "";
        this.contentColor = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.title.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
        }
        if (!this.titleColor.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.titleColor);
        }
        if (!this.content.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.content);
        }
        if (!this.contentColor.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.contentColor);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.title);
        }
        if (!this.titleColor.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.titleColor);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.content);
        }
        if (!this.contentColor.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.contentColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static TextContext parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new TextContext().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public TextContext mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.title = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.titleColor = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.content = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.contentColor = codedInputByteBufferNano.readString();
            }
        }
    }
}
