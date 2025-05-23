package com.qq.e.comm.pi;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class TGTQUICADLoader {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Callback {
        void onError(Error error);

        void onSuccess(String str);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Error {

        /* renamed from: a, reason: collision with root package name */
        private final ErrorType f38332a;

        /* renamed from: b, reason: collision with root package name */
        private final int f38333b;

        public Error(ErrorType errorType, int i3) {
            this.f38332a = errorType;
            this.f38333b = i3;
        }

        public final int getErrorCode() {
            return this.f38333b;
        }

        public final ErrorType getErrorType() {
            return this.f38332a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public enum ErrorType {
        UNKNOWN(1),
        NETWORK(2),
        IO(3),
        PROTOCOL(4);


        /* renamed from: a, reason: collision with root package name */
        private final int f38335a;

        ErrorType(int i3) {
            this.f38335a = i3;
        }

        public final int getType() {
            return this.f38335a;
        }
    }

    public abstract void request(String str, Map<String, String> map, Callback callback);
}
