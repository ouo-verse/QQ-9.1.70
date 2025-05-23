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
public final class HYUserExtendInfo extends ExtendableMessageNano<HYUserExtendInfo> {
    private static volatile HYUserExtendInfo[] _emptyArray;
    public int attentionSwitch;

    /* renamed from: id, reason: collision with root package name */
    public long f237280id;
    public LiveState liveState;

    public HYUserExtendInfo() {
        clear();
    }

    public static HYUserExtendInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new HYUserExtendInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static HYUserExtendInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (HYUserExtendInfo) MessageNano.mergeFrom(new HYUserExtendInfo(), bArr);
    }

    public HYUserExtendInfo clear() {
        this.f237280id = 0L;
        this.liveState = null;
        this.attentionSwitch = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.f237280id);
        LiveState liveState = this.liveState;
        if (liveState != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveState);
        }
        int i3 = this.attentionSwitch;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.f237280id);
        LiveState liveState = this.liveState;
        if (liveState != null) {
            codedOutputByteBufferNano.writeMessage(2, liveState);
        }
        int i3 = this.attentionSwitch;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static HYUserExtendInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new HYUserExtendInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public HYUserExtendInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f237280id = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                if (this.liveState == null) {
                    this.liveState = new LiveState();
                }
                codedInputByteBufferNano.readMessage(this.liveState);
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.attentionSwitch = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
