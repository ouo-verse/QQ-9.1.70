package com.tencent.mobileqq.wink.editor.util;

import android.content.Context;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.draft.WinkEditStretchedData;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J6\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J6\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J6\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\"\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ<\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/f;", "", "", "playerWidth", "playerHeight", "", "videoWidth", "videoHeight", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut$b;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditStretchedData;", "e", "c", "d", "Landroid/content/Context;", "context", "b", "renderFillType", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f322633a = new f();

    f() {
    }

    private final Pair<WinkVideoTavCut.RenderSizeAndOriginSize, WinkEditStretchedData> c(int playerWidth, int playerHeight, float videoWidth, float videoHeight) {
        boolean z16;
        int i3;
        int i16;
        float f16;
        float f17;
        float f18;
        float f19;
        float f26 = videoWidth;
        float f27 = videoHeight;
        boolean z17 = true;
        if (f27 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        float f28 = 1.0f;
        WinkEditStretchedData winkEditStretchedData = null;
        if (!z16) {
            if (f26 != 0.0f) {
                z17 = false;
            }
            if (!z17) {
                float f29 = f27 / f26;
                double d16 = playerHeight;
                double d17 = playerWidth;
                if (f29 >= d16 / d17) {
                    f28 = (float) (d16 / f27);
                    int i17 = (int) (f28 * f27);
                    int i18 = (int) (f28 * f26);
                    f26 = i18;
                    f27 = i17;
                    i16 = i17;
                    i3 = i18;
                    f19 = f26;
                    f18 = f27;
                    f17 = 0.0f;
                    f16 = 0.0f;
                    return new Pair<>(new WinkVideoTavCut.RenderSizeAndOriginSize(i3, i16, f19, f18, f17, f16, f28, true), winkEditStretchedData);
                }
                float f36 = playerHeight;
                float f37 = playerWidth;
                float f38 = (f29 / f36) * f37;
                winkEditStretchedData = new WinkEditStretchedData(true, f37, (f37 * f27) / f26, 0.0f, 0.0f, f38, f38, 24, null);
                float f39 = f27 / ((f26 * 1.0f) / f37);
                float f46 = (f36 - f39) / 2;
                f28 = (float) (d17 / f26);
                i3 = playerWidth;
                i16 = playerHeight;
                f19 = f26;
                f18 = f27;
                f17 = f46;
                f16 = f39 + f46;
                return new Pair<>(new WinkVideoTavCut.RenderSizeAndOriginSize(i3, i16, f19, f18, f17, f16, f28, true), winkEditStretchedData);
            }
        }
        i3 = playerWidth;
        i16 = playerHeight;
        f19 = f26;
        f18 = f27;
        f17 = 0.0f;
        f16 = 0.0f;
        return new Pair<>(new WinkVideoTavCut.RenderSizeAndOriginSize(i3, i16, f19, f18, f17, f16, f28, true), winkEditStretchedData);
    }

    private final Pair<WinkVideoTavCut.RenderSizeAndOriginSize, WinkEditStretchedData> d(int playerWidth, int playerHeight, float videoWidth, float videoHeight) {
        boolean z16;
        float f16;
        double d16 = videoWidth;
        if (d16 == 0.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f16 = 1.0f;
        } else {
            double d17 = playerHeight;
            double d18 = playerWidth;
            if (videoHeight / videoWidth >= d17 / d18) {
                f16 = (float) (d18 / d16);
            } else {
                f16 = (float) (d17 / videoHeight);
            }
        }
        float f17 = f16;
        int i3 = (int) (videoHeight * f17);
        int i16 = (int) (videoWidth * f17);
        float f18 = i16;
        float f19 = i3;
        return new Pair<>(new WinkVideoTavCut.RenderSizeAndOriginSize(i16, i3, f18, f19, 0.0f, 0.0f, f17, false), new WinkEditStretchedData(false, f18, f19, 0.0f, 0.0f, 0.0f, 0.0f, 120, null));
    }

    private final Pair<WinkVideoTavCut.RenderSizeAndOriginSize, WinkEditStretchedData> e(int playerWidth, int playerHeight, float videoWidth, float videoHeight) {
        boolean z16;
        float f16;
        double d16 = videoHeight;
        if (d16 == 0.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = (float) (playerHeight / d16);
        }
        float f17 = f16;
        int i3 = (int) (videoHeight * f17);
        int i16 = (int) (videoWidth * f17);
        return new Pair<>(new WinkVideoTavCut.RenderSizeAndOriginSize(i16, i3, i16, i3, 0.0f, 0.0f, f17, true), null);
    }

    @NotNull
    public final Pair<WinkVideoTavCut.RenderSizeAndOriginSize, WinkEditStretchedData> a(int renderFillType, int playerWidth, int playerHeight, float videoWidth, float videoHeight) {
        if (renderFillType != 1) {
            if (renderFillType != 3) {
                return f322633a.d(playerWidth, playerHeight, videoWidth, videoHeight);
            }
            return f322633a.e(playerWidth, playerHeight, videoWidth, videoHeight);
        }
        return f322633a.c(playerWidth, playerHeight, videoWidth, videoHeight);
    }

    public final int b(float videoWidth, float videoHeight, @Nullable Context context) {
        if (context != null && ((TransitionHelper.isFolderScreenOpenMode(context) || AppSetting.o(context)) && videoWidth < videoHeight)) {
            return 3;
        }
        if (100 * videoHeight <= 174 * videoWidth || videoHeight * 1 >= videoWidth * 3) {
            return 1;
        }
        return 2;
    }
}
