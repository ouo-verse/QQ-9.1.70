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
public final class SwitchInfo extends ExtendableMessageNano<SwitchInfo> {
    private static volatile SwitchInfo[] _emptyArray;
    public RuleInfo rule;
    public boolean status;
    public int stype;

    public SwitchInfo() {
        clear();
    }

    public static SwitchInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SwitchInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SwitchInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SwitchInfo) MessageNano.mergeFrom(new SwitchInfo(), bArr);
    }

    public SwitchInfo clear() {
        this.stype = 0;
        this.status = false;
        this.rule = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.stype;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        boolean z16 = this.status;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        RuleInfo ruleInfo = this.rule;
        if (ruleInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, ruleInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.stype;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        boolean z16 = this.status;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        RuleInfo ruleInfo = this.rule;
        if (ruleInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, ruleInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SwitchInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SwitchInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SwitchInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 6 || readInt32 == 7 || readInt32 == 8) {
                    this.stype = readInt32;
                }
            } else if (readTag == 16) {
                this.status = codedInputByteBufferNano.readBool();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.rule == null) {
                    this.rule = new RuleInfo();
                }
                codedInputByteBufferNano.readMessage(this.rule);
            }
        }
    }
}
