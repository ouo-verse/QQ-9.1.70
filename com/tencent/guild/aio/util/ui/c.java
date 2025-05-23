package com.tencent.guild.aio.util.ui;

import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/util/ui/c;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "", "origWidth", "origHeight", "Lkotlin/Pair;", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f112458a = new c();

    c() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
    
        if (r7 < r0) goto L11;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<Float, Float> a(@NotNull PicElement picElement, float origWidth, float origHeight) {
        float coerceAtLeast;
        float f16;
        float coerceAtMost;
        Intrinsics.checkNotNullParameter(picElement, "picElement");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(origWidth, origHeight);
        boolean x16 = MsgExtKt.x(picElement);
        int i3 = (int) coerceAtLeast;
        int calFavEmoMaxThumbSize = ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).calFavEmoMaxThumbSize(x16, i3);
        int calFavEmoMinThumbSize = ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).calFavEmoMinThumbSize(x16, i3);
        float f17 = calFavEmoMaxThumbSize;
        float f18 = 1.0f;
        if (origHeight > f17) {
            f16 = f17 / origHeight;
        } else {
            float f19 = calFavEmoMinThumbSize;
            if (origHeight < f19) {
                f16 = f19 / origHeight;
            } else {
                f16 = 1.0f;
            }
        }
        if (origWidth <= f17) {
            f17 = calFavEmoMinThumbSize;
        }
        f18 = f17 / origWidth;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(f16, f18);
        QLog.i("FavEmoSizeCalculator", 1, "originH=" + origHeight + " originW=" + origWidth + "$ thumbMaxSize=" + calFavEmoMaxThumbSize + " thumbMinSize=" + calFavEmoMinThumbSize + " scaleRote=" + coerceAtMost);
        return new Pair<>(Float.valueOf(origWidth * coerceAtMost), Float.valueOf(origHeight * coerceAtMost));
    }
}
