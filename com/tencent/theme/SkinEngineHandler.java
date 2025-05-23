package com.tencent.theme;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface SkinEngineHandler {
    boolean onDecodeOOM(OutOfMemoryError outOfMemoryError, String str, boolean z16);

    boolean onDecodeReturnNullBitmap(String str, boolean z16);

    boolean onSecondDecodeOOM(OutOfMemoryError outOfMemoryError, String str, boolean z16);
}
