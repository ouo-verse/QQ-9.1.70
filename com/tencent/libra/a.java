package com.tencent.libra;

import android.graphics.BitmapFactory;
import android.os.Build;
import com.tencent.biz.richframework.util.ByteArrayPool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/libra/a;", "", "Landroid/graphics/BitmapFactory$Options;", "decodeBitmapOptions", "", "c", "a", "b", "Lkotlin/collections/ArrayDeque;", "Lkotlin/collections/ArrayDeque;", "OPTIONS_QUEUE", "<init>", "()V", "libra-extension-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f118582b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ArrayDeque<BitmapFactory.Options> OPTIONS_QUEUE = new ArrayDeque<>(1);

    a() {
    }

    private final void c(BitmapFactory.Options decodeBitmapOptions) {
        ByteArrayPool.getGenericInstance().returnBuf(decodeBitmapOptions.inTempStorage);
        decodeBitmapOptions.inTempStorage = null;
        decodeBitmapOptions.inDither = false;
        decodeBitmapOptions.inSampleSize = 1;
        decodeBitmapOptions.inPreferredConfig = null;
        decodeBitmapOptions.inJustDecodeBounds = false;
        decodeBitmapOptions.inDensity = 0;
        decodeBitmapOptions.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            decodeBitmapOptions.inPreferredColorSpace = null;
            decodeBitmapOptions.outColorSpace = null;
            decodeBitmapOptions.outConfig = null;
        }
        decodeBitmapOptions.outWidth = 0;
        decodeBitmapOptions.outHeight = 0;
        decodeBitmapOptions.outMimeType = null;
        decodeBitmapOptions.inBitmap = null;
        decodeBitmapOptions.inMutable = true;
    }

    @NotNull
    public final synchronized BitmapFactory.Options a() {
        BitmapFactory.Options removeFirstOrNull;
        ArrayDeque<BitmapFactory.Options> arrayDeque = OPTIONS_QUEUE;
        synchronized (arrayDeque) {
            removeFirstOrNull = arrayDeque.removeFirstOrNull();
            if (removeFirstOrNull == null) {
                removeFirstOrNull = new BitmapFactory.Options();
            }
        }
        removeFirstOrNull.inTempStorage = ByteArrayPool.getGenericInstance().getBuf(65536);
        return removeFirstOrNull;
    }

    public final void b(@NotNull BitmapFactory.Options decodeBitmapOptions) {
        Intrinsics.checkNotNullParameter(decodeBitmapOptions, "decodeBitmapOptions");
        c(decodeBitmapOptions);
        ArrayDeque<BitmapFactory.Options> arrayDeque = OPTIONS_QUEUE;
        synchronized (arrayDeque) {
            arrayDeque.addLast(decodeBitmapOptions);
            Unit unit = Unit.INSTANCE;
        }
    }
}
