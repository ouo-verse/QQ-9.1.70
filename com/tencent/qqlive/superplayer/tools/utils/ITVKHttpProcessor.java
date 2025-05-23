package com.tencent.qqlive.superplayer.tools.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes22.dex */
public interface ITVKHttpProcessor {

    /* loaded from: classes22.dex */
    public static final class InvalidResponseCodeException extends IOException {
        public final int responseCode;

        @Nullable
        public final String responseMessage;

        public InvalidResponseCodeException(int i3, @Nullable String str) {
            super("Response code: " + i3);
            this.responseCode = i3;
            this.responseMessage = str;
        }
    }

    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map<String, List<String>> f345469a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f345470b;

        public a(Map<String, List<String>> map, byte[] bArr) {
            this.f345469a = map;
            this.f345470b = bArr;
        }
    }

    /* loaded from: classes22.dex */
    public interface b {
        void onFailure(IOException iOException);

        void onSuccess(a aVar);
    }

    void a(@NonNull String str, @Nullable Map<String, String> map, @NonNull byte[] bArr, int i3, @NonNull b bVar);

    void b(@NonNull String str, @Nullable Map<String, String> map, int i3, @NonNull b bVar);
}
