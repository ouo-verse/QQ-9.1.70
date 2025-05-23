package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class AnimInfo extends ExtendableMessageNano<AnimInfo> {
    private static volatile AnimInfo[] _emptyArray;
    public long actId;
    public AnimList[] animList;

    public AnimInfo() {
        clear();
    }

    public static AnimInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AnimInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AnimInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AnimInfo) MessageNano.mergeFrom(new AnimInfo(), bArr);
    }

    public AnimInfo clear() {
        this.animList = AnimList.emptyArray();
        this.actId = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        AnimList[] animListArr = this.animList;
        if (animListArr != null && animListArr.length > 0) {
            int i3 = 0;
            while (true) {
                AnimList[] animListArr2 = this.animList;
                if (i3 >= animListArr2.length) {
                    break;
                }
                AnimList animList = animListArr2[i3];
                if (animList != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, animList);
                }
                i3++;
            }
        }
        long j3 = this.actId;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        AnimList[] animListArr = this.animList;
        if (animListArr != null && animListArr.length > 0) {
            int i3 = 0;
            while (true) {
                AnimList[] animListArr2 = this.animList;
                if (i3 >= animListArr2.length) {
                    break;
                }
                AnimList animList = animListArr2[i3];
                if (animList != null) {
                    codedOutputByteBufferNano.writeMessage(1, animList);
                }
                i3++;
            }
        }
        long j3 = this.actId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AnimInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AnimInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AnimInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                AnimList[] animListArr = this.animList;
                int length = animListArr == null ? 0 : animListArr.length;
                int i3 = repeatedFieldArrayLength + length;
                AnimList[] animListArr2 = new AnimList[i3];
                if (length != 0) {
                    System.arraycopy(animListArr, 0, animListArr2, 0, length);
                }
                while (length < i3 - 1) {
                    AnimList animList = new AnimList();
                    animListArr2[length] = animList;
                    codedInputByteBufferNano.readMessage(animList);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                AnimList animList2 = new AnimList();
                animListArr2[length] = animList2;
                codedInputByteBufferNano.readMessage(animList2);
                this.animList = animListArr2;
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.actId = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
