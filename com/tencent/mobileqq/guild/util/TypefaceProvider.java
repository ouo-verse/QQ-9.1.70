package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J0\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\t0\bH\u0007R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/util/TypefaceProvider;", "", "Landroid/content/Context;", "context", "", "assetPath", "Landroid/graphics/Typeface;", "c", "Lkotlin/Function1;", "", "block", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "typefaces", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class TypefaceProvider {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TypefaceProvider f235413a = new TypefaceProvider();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Typeface> typefaces = new ConcurrentHashMap<>();

    TypefaceProvider() {
    }

    @JvmStatic
    @Nullable
    public static final Typeface c(@Nullable Context context, @NotNull String assetPath) {
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        ConcurrentHashMap<String, Typeface> concurrentHashMap = typefaces;
        if (concurrentHashMap.containsKey(assetPath)) {
            return concurrentHashMap.get(assetPath);
        }
        if (context == null) {
            return null;
        }
        Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), assetPath);
        if (createFromAsset != null) {
            concurrentHashMap.put(assetPath, createFromAsset);
        }
        return createFromAsset;
    }

    @JvmStatic
    public static final void d(@Nullable final Context context, @NotNull final String assetPath, @NotNull final Function1<? super Typeface, Unit> block) {
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        Intrinsics.checkNotNullParameter(block, "block");
        if (typefaces.containsKey(assetPath)) {
            ThreadUtils threadUtils = ThreadUtils.f235400a;
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                block.invoke(typefaces.get(assetPath));
                return;
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.util.TypefaceProvider$loadTypeface$$inlined$ensureUiThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Function1.this.invoke(TypefaceProvider.typefaces.get(assetPath));
                    }
                });
                return;
            }
        }
        if (context == null) {
            ThreadUtils threadUtils2 = ThreadUtils.f235400a;
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                block.invoke(null);
                return;
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.util.TypefaceProvider$loadTypeface$$inlined$ensureUiThread$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Function1.this.invoke(null);
                    }
                });
                return;
            }
        }
        ThreadUtils.f(new Runnable() { // from class: com.tencent.mobileqq.guild.util.cv
            @Override // java.lang.Runnable
            public final void run() {
                TypefaceProvider.e(context, assetPath, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Context context, String assetPath, final Function1 block) {
        Intrinsics.checkNotNullParameter(assetPath, "$assetPath");
        Intrinsics.checkNotNullParameter(block, "$block");
        final Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), assetPath);
        if (createFromAsset != null) {
            typefaces.put(assetPath, createFromAsset);
        }
        ThreadUtils threadUtils = ThreadUtils.f235400a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            block.invoke(createFromAsset);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.util.TypefaceProvider$loadTypeface$lambda$3$$inlined$ensureUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    Function1.this.invoke(createFromAsset);
                }
            });
        }
    }
}
