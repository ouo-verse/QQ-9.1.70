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
public final class GetExperienceInfoRsp extends ExtendableMessageNano<GetExperienceInfoRsp> {
    private static volatile GetExperienceInfoRsp[] _emptyArray;
    public ExperimentInfo exprience;
    public boolean isHit;
    public int scene;

    public GetExperienceInfoRsp() {
        clear();
    }

    public static GetExperienceInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetExperienceInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetExperienceInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetExperienceInfoRsp) MessageNano.mergeFrom(new GetExperienceInfoRsp(), bArr);
    }

    public GetExperienceInfoRsp clear() {
        this.isHit = false;
        this.exprience = null;
        this.scene = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.isHit;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        ExperimentInfo experimentInfo = this.exprience;
        if (experimentInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, experimentInfo);
        }
        int i3 = this.scene;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.isHit;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        ExperimentInfo experimentInfo = this.exprience;
        if (experimentInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, experimentInfo);
        }
        int i3 = this.scene;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetExperienceInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetExperienceInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetExperienceInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.isHit = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.exprience == null) {
                    this.exprience = new ExperimentInfo();
                }
                codedInputByteBufferNano.readMessage(this.exprience);
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.scene = readInt32;
                }
            }
        }
    }
}
