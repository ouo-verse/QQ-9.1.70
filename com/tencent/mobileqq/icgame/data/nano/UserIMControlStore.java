package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class UserIMControlStore extends ExtendableMessageNano<UserIMControlStore> {
    private static volatile UserIMControlStore[] _emptyArray;
    public Map<Integer, SwitchInfo> receiveSwitch;
    public Map<Integer, SwitchInfo> remindSwitch;

    public UserIMControlStore() {
        clear();
    }

    public static UserIMControlStore[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserIMControlStore[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserIMControlStore parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserIMControlStore) MessageNano.mergeFrom(new UserIMControlStore(), bArr);
    }

    public UserIMControlStore clear() {
        this.receiveSwitch = null;
        this.remindSwitch = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Map<Integer, SwitchInfo> map = this.receiveSwitch;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 1, 13, 11);
        }
        Map<Integer, SwitchInfo> map2 = this.remindSwitch;
        if (map2 != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map2, 2, 13, 11);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Map<Integer, SwitchInfo> map = this.receiveSwitch;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 1, 13, 11);
        }
        Map<Integer, SwitchInfo> map2 = this.remindSwitch;
        if (map2 != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map2, 2, 13, 11);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserIMControlStore parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserIMControlStore().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserIMControlStore mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.receiveSwitch = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.receiveSwitch, mapFactory, 13, 11, new SwitchInfo(), 8, 18);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.remindSwitch = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.remindSwitch, mapFactory, 13, 11, new SwitchInfo(), 8, 18);
            }
        }
    }
}
