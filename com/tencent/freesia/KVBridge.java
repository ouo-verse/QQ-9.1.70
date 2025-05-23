package com.tencent.freesia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface KVBridge {
    @Nullable
    ArrayList<String> allKeys();

    void clearAll();

    boolean containsKey(@NonNull String str);

    boolean decodeBool(@NonNull String str, boolean z16);

    @Nullable
    byte[] decodeBytes(@NonNull String str, @NonNull byte[] bArr);

    double decodeDouble(@NonNull String str, double d16);

    float decodeFloat(@NonNull String str, float f16);

    int decodeInt(@NonNull String str, int i3);

    long decodeLong(@NonNull String str, long j3);

    @Nullable
    String decodeString(@NonNull String str, @NonNull String str2);

    @Nullable
    HashSet<String> decodeStringSet(@NonNull String str, @Nullable HashSet<String> hashSet);

    void encodeBool(@NonNull String str, boolean z16);

    void encodeBytes(@NonNull String str, @NonNull byte[] bArr);

    void encodeDouble(@NonNull String str, double d16);

    void encodeFloat(@NonNull String str, float f16);

    void encodeInt(@NonNull String str, int i3);

    void encodeLong(@NonNull String str, long j3);

    void encodeString(@NonNull String str, @NonNull String str2);

    void encodeStringSet(@NonNull String str, @Nullable HashSet<String> hashSet);

    void removeValueForKey(@NonNull String str);

    void removeValuesForKeys(@NonNull ArrayList<String> arrayList);
}
