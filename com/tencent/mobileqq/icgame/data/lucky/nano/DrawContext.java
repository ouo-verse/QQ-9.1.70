package com.tencent.mobileqq.icgame.data.lucky.nano;

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
public final class DrawContext extends ExtendableMessageNano<DrawContext> {
    private static volatile DrawContext[] _emptyArray;
    public Effect[] effects;

    public DrawContext() {
        clear();
    }

    public static DrawContext[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new DrawContext[0];
                }
            }
        }
        return _emptyArray;
    }

    public static DrawContext parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (DrawContext) MessageNano.mergeFrom(new DrawContext(), bArr);
    }

    public DrawContext clear() {
        this.effects = Effect.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Effect[] effectArr = this.effects;
        if (effectArr != null && effectArr.length > 0) {
            int i3 = 0;
            while (true) {
                Effect[] effectArr2 = this.effects;
                if (i3 >= effectArr2.length) {
                    break;
                }
                Effect effect = effectArr2[i3];
                if (effect != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, effect);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Effect[] effectArr = this.effects;
        if (effectArr != null && effectArr.length > 0) {
            int i3 = 0;
            while (true) {
                Effect[] effectArr2 = this.effects;
                if (i3 >= effectArr2.length) {
                    break;
                }
                Effect effect = effectArr2[i3];
                if (effect != null) {
                    codedOutputByteBufferNano.writeMessage(1, effect);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static DrawContext parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new DrawContext().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public DrawContext mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                Effect[] effectArr = this.effects;
                int length = effectArr == null ? 0 : effectArr.length;
                int i3 = repeatedFieldArrayLength + length;
                Effect[] effectArr2 = new Effect[i3];
                if (length != 0) {
                    System.arraycopy(effectArr, 0, effectArr2, 0, length);
                }
                while (length < i3 - 1) {
                    Effect effect = new Effect();
                    effectArr2[length] = effect;
                    codedInputByteBufferNano.readMessage(effect);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Effect effect2 = new Effect();
                effectArr2[length] = effect2;
                codedInputByteBufferNano.readMessage(effect2);
                this.effects = effectArr2;
            }
        }
    }
}
