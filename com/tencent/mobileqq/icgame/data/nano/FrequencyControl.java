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
public final class FrequencyControl extends ExtendableMessageNano<FrequencyControl> {
    private static volatile FrequencyControl[] _emptyArray;
    public FrequencyAnchorInfo[] infos;
    public long last;
    public int times;

    public FrequencyControl() {
        clear();
    }

    public static FrequencyControl[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FrequencyControl[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FrequencyControl parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FrequencyControl) MessageNano.mergeFrom(new FrequencyControl(), bArr);
    }

    public FrequencyControl clear() {
        this.last = 0L;
        this.times = 0;
        this.infos = FrequencyAnchorInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.last;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        int i3 = this.times;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        FrequencyAnchorInfo[] frequencyAnchorInfoArr = this.infos;
        if (frequencyAnchorInfoArr != null && frequencyAnchorInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                FrequencyAnchorInfo[] frequencyAnchorInfoArr2 = this.infos;
                if (i16 >= frequencyAnchorInfoArr2.length) {
                    break;
                }
                FrequencyAnchorInfo frequencyAnchorInfo = frequencyAnchorInfoArr2[i16];
                if (frequencyAnchorInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, frequencyAnchorInfo);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.last;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        int i3 = this.times;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        FrequencyAnchorInfo[] frequencyAnchorInfoArr = this.infos;
        if (frequencyAnchorInfoArr != null && frequencyAnchorInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                FrequencyAnchorInfo[] frequencyAnchorInfoArr2 = this.infos;
                if (i16 >= frequencyAnchorInfoArr2.length) {
                    break;
                }
                FrequencyAnchorInfo frequencyAnchorInfo = frequencyAnchorInfoArr2[i16];
                if (frequencyAnchorInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, frequencyAnchorInfo);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FrequencyControl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FrequencyControl().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FrequencyControl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.last = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.times = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                FrequencyAnchorInfo[] frequencyAnchorInfoArr = this.infos;
                int length = frequencyAnchorInfoArr == null ? 0 : frequencyAnchorInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                FrequencyAnchorInfo[] frequencyAnchorInfoArr2 = new FrequencyAnchorInfo[i3];
                if (length != 0) {
                    System.arraycopy(frequencyAnchorInfoArr, 0, frequencyAnchorInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    FrequencyAnchorInfo frequencyAnchorInfo = new FrequencyAnchorInfo();
                    frequencyAnchorInfoArr2[length] = frequencyAnchorInfo;
                    codedInputByteBufferNano.readMessage(frequencyAnchorInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                FrequencyAnchorInfo frequencyAnchorInfo2 = new FrequencyAnchorInfo();
                frequencyAnchorInfoArr2[length] = frequencyAnchorInfo2;
                codedInputByteBufferNano.readMessage(frequencyAnchorInfo2);
                this.infos = frequencyAnchorInfoArr2;
            }
        }
    }
}
