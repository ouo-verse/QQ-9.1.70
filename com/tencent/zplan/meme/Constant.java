package com.tencent.zplan.meme;

import android.content.Context;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0006\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001b\u0010\b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/zplan/meme/Constant;", "", "", "a", "Lkotlin/Lazy;", "()Ljava/lang/String;", "memeCachePath", "b", "recordResourceCachePath", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class Constant {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy memeCachePath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy recordResourceCachePath;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Constant f385743c = new Constant();

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.zplan.meme.Constant$memeCachePath$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Context context;
                lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
                if (aVar != null && (context = aVar.getContext()) != null) {
                    File externalCacheDir = context.getExternalCacheDir();
                    if (externalCacheDir == null) {
                        externalCacheDir = context.getCacheDir();
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(externalCacheDir != null ? externalCacheDir.getPath() : null);
                    sb5.append("/meme");
                    return sb5.toString();
                }
                throw new RuntimeException("can't init memeCachePath without Context");
            }
        });
        memeCachePath = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.zplan.meme.Constant$recordResourceCachePath$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Context context;
                lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
                if (aVar != null && (context = aVar.getContext()) != null) {
                    File externalCacheDir = context.getExternalCacheDir();
                    if (externalCacheDir == null) {
                        externalCacheDir = context.getCacheDir();
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(externalCacheDir != null ? externalCacheDir.getPath() : null);
                    sb5.append("/record/resource");
                    return sb5.toString();
                }
                throw new RuntimeException("can't init recordResourceCachePath without Context");
            }
        });
        recordResourceCachePath = lazy2;
    }

    Constant() {
    }

    @NotNull
    public final String a() {
        return (String) memeCachePath.getValue();
    }

    @NotNull
    public final String b() {
        return (String) recordResourceCachePath.getValue();
    }
}
