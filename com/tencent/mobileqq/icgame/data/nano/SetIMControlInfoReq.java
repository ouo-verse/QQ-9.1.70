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
public final class SetIMControlInfoReq extends ExtendableMessageNano<SetIMControlInfoReq> {
    private static volatile SetIMControlInfoReq[] _emptyArray;
    public SwitchInfo[] receiveSwitch;
    public SwitchInfo[] remindSwitch;

    public SetIMControlInfoReq() {
        clear();
    }

    public static SetIMControlInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetIMControlInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetIMControlInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetIMControlInfoReq) MessageNano.mergeFrom(new SetIMControlInfoReq(), bArr);
    }

    public SetIMControlInfoReq clear() {
        this.remindSwitch = SwitchInfo.emptyArray();
        this.receiveSwitch = SwitchInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        SwitchInfo[] switchInfoArr = this.remindSwitch;
        int i3 = 0;
        if (switchInfoArr != null && switchInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                SwitchInfo[] switchInfoArr2 = this.remindSwitch;
                if (i16 >= switchInfoArr2.length) {
                    break;
                }
                SwitchInfo switchInfo = switchInfoArr2[i16];
                if (switchInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, switchInfo);
                }
                i16++;
            }
        }
        SwitchInfo[] switchInfoArr3 = this.receiveSwitch;
        if (switchInfoArr3 != null && switchInfoArr3.length > 0) {
            while (true) {
                SwitchInfo[] switchInfoArr4 = this.receiveSwitch;
                if (i3 >= switchInfoArr4.length) {
                    break;
                }
                SwitchInfo switchInfo2 = switchInfoArr4[i3];
                if (switchInfo2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, switchInfo2);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        SwitchInfo[] switchInfoArr = this.remindSwitch;
        int i3 = 0;
        if (switchInfoArr != null && switchInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                SwitchInfo[] switchInfoArr2 = this.remindSwitch;
                if (i16 >= switchInfoArr2.length) {
                    break;
                }
                SwitchInfo switchInfo = switchInfoArr2[i16];
                if (switchInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, switchInfo);
                }
                i16++;
            }
        }
        SwitchInfo[] switchInfoArr3 = this.receiveSwitch;
        if (switchInfoArr3 != null && switchInfoArr3.length > 0) {
            while (true) {
                SwitchInfo[] switchInfoArr4 = this.receiveSwitch;
                if (i3 >= switchInfoArr4.length) {
                    break;
                }
                SwitchInfo switchInfo2 = switchInfoArr4[i3];
                if (switchInfo2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, switchInfo2);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetIMControlInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetIMControlInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetIMControlInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                SwitchInfo[] switchInfoArr = this.remindSwitch;
                int length = switchInfoArr == null ? 0 : switchInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                SwitchInfo[] switchInfoArr2 = new SwitchInfo[i3];
                if (length != 0) {
                    System.arraycopy(switchInfoArr, 0, switchInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    SwitchInfo switchInfo = new SwitchInfo();
                    switchInfoArr2[length] = switchInfo;
                    codedInputByteBufferNano.readMessage(switchInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                SwitchInfo switchInfo2 = new SwitchInfo();
                switchInfoArr2[length] = switchInfo2;
                codedInputByteBufferNano.readMessage(switchInfo2);
                this.remindSwitch = switchInfoArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                SwitchInfo[] switchInfoArr3 = this.receiveSwitch;
                int length2 = switchInfoArr3 == null ? 0 : switchInfoArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                SwitchInfo[] switchInfoArr4 = new SwitchInfo[i16];
                if (length2 != 0) {
                    System.arraycopy(switchInfoArr3, 0, switchInfoArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    SwitchInfo switchInfo3 = new SwitchInfo();
                    switchInfoArr4[length2] = switchInfo3;
                    codedInputByteBufferNano.readMessage(switchInfo3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                SwitchInfo switchInfo4 = new SwitchInfo();
                switchInfoArr4[length2] = switchInfo4;
                codedInputByteBufferNano.readMessage(switchInfo4);
                this.receiveSwitch = switchInfoArr4;
            }
        }
    }
}
