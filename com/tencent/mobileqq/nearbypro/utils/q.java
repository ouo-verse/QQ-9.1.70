package com.tencent.mobileqq.nearbypro.utils;

import android.widget.ImageView;
import androidx.annotation.MainThread;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import fu4.v;
import fu4.w;
import fu4.z;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u001a \u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u001a\u0018\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\"\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"Lop4/g;", "targetStImage", "Landroid/widget/ImageView;", "targetView", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", "d", "Lfu4/v;", "indexNode", "c", "kotlin.jvm.PlatformType", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "seq", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class q {

    /* renamed from: a */
    @NotNull
    private static final AtomicInteger f253960a = new AtomicInteger(10000);

    private static final Option b(ImageView imageView) {
        Option defaultOptions = Option.getDefaultOptions(imageView);
        defaultOptions.setTargetView(imageView);
        defaultOptions.setLoadingDrawable(PicLoadUtilsKt.b());
        defaultOptions.setFailedDrawable(PicLoadUtilsKt.a());
        defaultOptions.setAnimatable(null);
        return defaultOptions;
    }

    public static final void c(@NotNull v indexNode, @NotNull Option option, @Nullable IPicLoadStateListener iPicLoadStateListener) {
        Intrinsics.checkNotNullParameter(indexNode, "indexNode");
        Intrinsics.checkNotNullParameter(option, "option");
        new InnerLoader(null, indexNode, option, iPicLoadStateListener).m();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(@NotNull op4.g targetStImage, @NotNull ImageView targetView, @NotNull Option option, @Nullable IPicLoadStateListener iPicLoadStateListener) {
        v vVar;
        z[] zVarArr;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(targetStImage, "targetStImage");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(option, "option");
        w wVar = targetStImage.f423329a;
        if (wVar != null && (zVarArr = wVar.f400825a) != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(zVarArr);
            z zVar = (z) firstOrNull;
            if (zVar != null) {
                vVar = zVar.f400830a;
                if (vVar != null) {
                    com.tencent.mobileqq.nearbypro.base.j.c().d("StImageLoader", "targetIndexNode is null " + com.tencent.mobileqq.nearbypro.request.c.d(targetStImage));
                    targetView.setImageDrawable(option.getFailedDrawable());
                    return;
                }
                new InnerLoader(targetView, vVar, option, iPicLoadStateListener).k();
                return;
            }
        }
        vVar = null;
        if (vVar != null) {
        }
    }

    public static /* synthetic */ void e(op4.g gVar, ImageView imageView, Option option, IPicLoadStateListener iPicLoadStateListener, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            option = b(imageView);
            Intrinsics.checkNotNullExpressionValue(option, "getDefaultOption(targetView)");
        }
        if ((i3 & 8) != 0) {
            iPicLoadStateListener = null;
        }
        d(gVar, imageView, option, iPicLoadStateListener);
    }
}
