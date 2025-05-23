package com.huawei.hms.core.aidl;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class CodecLookup {
    CodecLookup() {
    }

    public static MessageCodec find(int i3) {
        if (i3 == 2) {
            return new MessageCodecV2();
        }
        return new MessageCodec();
    }
}
