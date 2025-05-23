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
public final class GetDrawToolsRsp extends ExtendableMessageNano<GetDrawToolsRsp> {
    private static volatile GetDrawToolsRsp[] _emptyArray;
    public DrawTool drawTool;
    public String errmsg;
    public int result;

    public GetDrawToolsRsp() {
        clear();
    }

    public static GetDrawToolsRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetDrawToolsRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetDrawToolsRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetDrawToolsRsp) MessageNano.mergeFrom(new GetDrawToolsRsp(), bArr);
    }

    public GetDrawToolsRsp clear() {
        this.result = 0;
        this.errmsg = "";
        this.drawTool = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.errmsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.errmsg);
        }
        DrawTool drawTool = this.drawTool;
        if (drawTool != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, drawTool);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.errmsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.errmsg);
        }
        DrawTool drawTool = this.drawTool;
        if (drawTool != null) {
            codedOutputByteBufferNano.writeMessage(3, drawTool);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetDrawToolsRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetDrawToolsRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetDrawToolsRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.errmsg = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.drawTool == null) {
                    this.drawTool = new DrawTool();
                }
                codedInputByteBufferNano.readMessage(this.drawTool);
            }
        }
    }
}
