package com.tencent.mobileqq.guild.util;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/util/k;", "", "", "traceId", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class k {
    @Nullable
    public final Bitmap a(int traceId, @NotNull Bitmap bitmap) {
        Object m476constructorimpl;
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (bitmap.getWidth() > 10 && bitmap.getHeight() > 10) {
            try {
                Result.Companion companion = Result.INSTANCE;
                roundToInt = MathKt__MathJVMKt.roundToInt((bitmap.getWidth() >> 1) * 0.8f);
                roundToInt2 = MathKt__MathJVMKt.roundToInt((bitmap.getHeight() >> 1) * 0.8f);
                roundToInt3 = MathKt__MathJVMKt.roundToInt(bitmap.getWidth() * 0.2f);
                roundToInt4 = MathKt__MathJVMKt.roundToInt(bitmap.getHeight() * 0.2f);
                m476constructorimpl = Result.m476constructorimpl(Bitmap.createBitmap(bitmap, roundToInt, roundToInt2, roundToInt3, roundToInt4));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "[samplingTargetArea]: traceId: " + traceId + ", " + m479exceptionOrNullimpl;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildBubblePaletteRule", 1, (String) it.next(), null);
                }
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = null;
            }
            return (Bitmap) m476constructorimpl;
        }
        Logger.f235387a.d().i("GuildBubblePaletteRule", 1, "[samplingTargetArea]: traceId=" + traceId + ", bitmap is less than minimum size");
        return bitmap;
    }
}
