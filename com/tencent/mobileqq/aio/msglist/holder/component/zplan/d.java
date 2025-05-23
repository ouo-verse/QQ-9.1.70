package com.tencent.mobileqq.aio.msglist.holder.component.zplan;

import android.content.Context;
import android.graphics.Typeface;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/zplan/d;", "", "Landroid/content/Context;", "context", "Landroid/graphics/Typeface;", "a", "", "assetPath", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "typefaces", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f192284a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Typeface> typefaces = new ConcurrentHashMap<>();

    d() {
    }

    @JvmStatic
    @Nullable
    public static final Typeface a(@Nullable Context context) {
        return b(context, "fonts/icomoon.ttf");
    }

    @JvmStatic
    @Nullable
    public static final Typeface b(@Nullable Context context, @NotNull String assetPath) {
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
}
