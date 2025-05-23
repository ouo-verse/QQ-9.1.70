package com.tencent.mobileqq.pb;

import java.io.IOException;

/* loaded from: classes16.dex */
public abstract class PBField<T> {
    public static PBBoolField initBool(boolean z16) {
        return new PBBoolField(z16, false);
    }

    public static PBBytesField initBytes(ByteStringMicro byteStringMicro) {
        return new PBBytesField(byteStringMicro, false);
    }

    public static PBDoubleField initDouble(double d16) {
        return new PBDoubleField(d16, false);
    }

    public static PBEnumField initEnum(int i3) {
        return new PBEnumField(i3, false);
    }

    public static PBFixed32Field initFixed32(int i3) {
        return new PBFixed32Field(i3, false);
    }

    public static PBFixed64Field initFixed64(long j3) {
        return new PBFixed64Field(j3, false);
    }

    public static PBFloatField initFloat(float f16) {
        return new PBFloatField(f16, false);
    }

    public static PBInt32Field initInt32(int i3) {
        return new PBInt32Field(i3, false);
    }

    public static PBInt64Field initInt64(long j3) {
        return new PBInt64Field(j3, false);
    }

    public static <T> PBRepeatField<T> initRepeat(PBField<T> pBField) {
        return new PBRepeatField<>(pBField);
    }

    public static <T extends MessageMicro<T>> PBRepeatMessageField<T> initRepeatMessage(Class<T> cls) {
        return new PBRepeatMessageField<>(cls);
    }

    public static PBSFixed32Field initSFixed32(int i3) {
        return new PBSFixed32Field(i3, false);
    }

    public static PBSFixed64Field initSFixed64(long j3) {
        return new PBSFixed64Field(j3, false);
    }

    public static PBSInt32Field initSInt32(int i3) {
        return new PBSInt32Field(i3, false);
    }

    public static PBSInt64Field initSInt64(long j3) {
        return new PBSInt64Field(j3, false);
    }

    public static PBStringField initString(String str) {
        return new PBStringField(str, false);
    }

    public static PBUInt32Field initUInt32(int i3) {
        return new PBUInt32Field(i3, false);
    }

    public static PBUInt64Field initUInt64(long j3) {
        return new PBUInt64Field(j3, false);
    }

    public final void clear() {
        clear(null);
    }

    public abstract void clear(Object obj);

    public abstract int computeSize(int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int computeSizeDirectly(int i3, T t16);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void copyFrom(PBField<T> pBField);

    public abstract void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException;

    public abstract void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i3) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i3, T t16) throws IOException;

    public static PBBytesField initBytes(byte[] bArr) {
        return new PBBytesField(ByteStringMicro.copyFrom(bArr), false);
    }
}
