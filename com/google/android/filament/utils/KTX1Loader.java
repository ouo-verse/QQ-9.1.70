package com.google.android.filament.utils;

import com.google.android.filament.Engine;
import com.google.android.filament.IndirectLight;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.nio.Buffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J)\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0082 J)\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0082 J!\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0082 J)\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0082 J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/google/android/filament/utils/KTX1Loader;", "", "", "nativeEngine", "Ljava/nio/Buffer;", "buffer", "", "remaining", "", "srgb", "nCreateKTXTexture", "nCreateIndirectLight", "", "outSphericalHarmonics", "nGetSphericalHarmonics", "nCreateSkybox", "Lcom/google/android/filament/Engine;", EnginePathProvider.ENGINE_DIR, "Lcom/google/android/filament/utils/KTX1Loader$a;", "options", "Lcom/google/android/filament/IndirectLight;", "a", "<init>", "()V", "filament-utils-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class KTX1Loader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final KTX1Loader f33068a = new KTX1Loader();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/google/android/filament/utils/KTX1Loader$a;", "", "", "a", "Z", "()Z", "setSrgb", "(Z)V", "srgb", "<init>", "()V", "filament-utils-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean srgb;

        /* renamed from: a, reason: from getter */
        public final boolean getSrgb() {
            return this.srgb;
        }
    }

    KTX1Loader() {
    }

    public static /* synthetic */ IndirectLight b(KTX1Loader kTX1Loader, Engine engine, Buffer buffer, a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            aVar = new a();
        }
        return kTX1Loader.a(engine, buffer, aVar);
    }

    private final native long nCreateIndirectLight(long nativeEngine, Buffer buffer, int remaining, boolean srgb);

    private final native long nCreateKTXTexture(long nativeEngine, Buffer buffer, int remaining, boolean srgb);

    private final native long nCreateSkybox(long nativeEngine, Buffer buffer, int remaining, boolean srgb);

    private final native boolean nGetSphericalHarmonics(Buffer buffer, int remaining, float[] outSphericalHarmonics);

    @NotNull
    public final IndirectLight a(@NotNull Engine engine, @NotNull Buffer buffer, @NotNull a options) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(options, "options");
        return new IndirectLight(nCreateIndirectLight(engine.getNativeObject(), buffer, buffer.remaining(), options.getSrgb()));
    }
}
