package defpackage;

import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.anisticker.view.e;
import com.tencent.qqnt.base.utils.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004J\u001c\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\n"}, d2 = {"La;", "", "", "c", "Lkotlin/Pair;", "b", "Lcom/tencent/mobileqq/data/AniStickerInfo;", "stickerInfo", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f25157a = new a();

    a() {
    }

    @NotNull
    public final Pair<Integer, Integer> a(@Nullable AniStickerInfo stickerInfo) {
        Pair<Integer, Integer> b16 = b();
        if (stickerInfo != null) {
            String str = stickerInfo.aniStickerWidth;
            if (str != null && stickerInfo.aniStickerHeight != null) {
                try {
                    Intrinsics.checkNotNullExpressionValue(str, "it.aniStickerWidth");
                    int dpToPx = ViewUtils.dpToPx(Float.parseFloat(str));
                    String str2 = stickerInfo.aniStickerHeight;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.aniStickerHeight");
                    int dpToPx2 = ViewUtils.dpToPx(Float.parseFloat(str2));
                    if (dpToPx > 0 && dpToPx2 > 0) {
                        int b17 = a.C7329a.f192417a.b();
                        c cVar = c.f353052a;
                        int b18 = b17 - cVar.b(60);
                        cVar.b(75);
                        if (dpToPx > b18) {
                            return new Pair<>(Integer.valueOf(b18), Integer.valueOf((int) ((b18 / dpToPx) * dpToPx2)));
                        }
                        return new Pair<>(Integer.valueOf(dpToPx), Integer.valueOf(dpToPx2));
                    }
                    QLog.w("AniStickerAIOHelper", 1, "[getChainLottieBubbleSize] invalidate size. configWidth=" + dpToPx + ", configHeight=" + dpToPx2);
                    return b16;
                } catch (NumberFormatException e16) {
                    QLog.e("AniStickerAIOHelper", 1, "[getChainLottieBubbleSize] parse config size error.", e16);
                    return b16;
                }
            }
            QLog.w("AniStickerAIOHelper", 1, "[getChainLottieBubbleSize] invalidate config ani sticker size.");
        }
        return b16;
    }

    @NotNull
    public final Pair<Integer, Integer> b() {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(e.f348849a.i(), a.C7329a.f192417a.b() - c.f353052a.b(60));
        return new Pair<>(Integer.valueOf(coerceAtMost), Integer.valueOf(coerceAtMost / 2));
    }

    public final int c() {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(e.f348849a.i(), a.C7329a.f192417a.b() - c.f353052a.b(30));
        if (FontSettingManager.isFontSizeLarge() && FontSettingManager.getFontScale() > 1.0f) {
            return (int) (coerceAtMost / FontSettingManager.getFontScale());
        }
        return coerceAtMost;
    }
}
