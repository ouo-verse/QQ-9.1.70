package com.eclipsesource.mmv8;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IV8Tracer {
    public static final IV8Tracer DUMMY = new IV8Tracer() { // from class: com.eclipsesource.mmv8.IV8Tracer.1
        @Override // com.eclipsesource.mmv8.IV8Tracer
        public void endSection() {
        }

        @Override // com.eclipsesource.mmv8.IV8Tracer
        public void beginSection(@NonNull String str) {
        }
    };

    void beginSection(@NonNull String str);

    void endSection();
}
