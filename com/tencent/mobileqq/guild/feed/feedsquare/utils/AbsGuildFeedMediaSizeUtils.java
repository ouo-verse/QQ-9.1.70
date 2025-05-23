package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006R\u001b\u0010\u0013\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "", "", "maxSize", "originW", "originH", "Lkotlin/Pair;", "b", "Landroid/view/View;", "view", "width", "height", "a", "f", tl.h.F, "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/a;", "e", "()F", "feedListMediaMaxWidth", "d", "()Lkotlin/Pair;", "feedListLongMediaSize", "c", "defaultFeedListMaxWidth", "g", "maxWidthForViewSize", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class AbsGuildFeedMediaSizeUtils {

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f219271c = {Reflection.property1(new PropertyReference1Impl(AbsGuildFeedMediaSizeUtils.class, "feedListMediaMaxWidth", "getFeedListMediaMaxWidth()F", 0)), Reflection.property1(new PropertyReference1Impl(AbsGuildFeedMediaSizeUtils.class, "feedListLongMediaSize", "getFeedListLongMediaSize()Lkotlin/Pair;", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a feedListMediaMaxWidth = new a(new PropertyReference0Impl(this) { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils$feedListMediaMaxWidth$2
        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return Float.valueOf(((AbsGuildFeedMediaSizeUtils) this.receiver).g());
        }
    }, ComputedKt.a(), new Function1<Float, Float>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils$feedListMediaMaxWidth$3
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Float f16) {
            return invoke(f16.floatValue());
        }

        @NotNull
        public final Float invoke(float f16) {
            return Float.valueOf(f16 * 0.715f);
        }
    });

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a feedListLongMediaSize = new a(new PropertyReference0Impl(this) { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils$feedListLongMediaSize$2
        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return Float.valueOf(((AbsGuildFeedMediaSizeUtils) this.receiver).g());
        }
    }, ComputedKt.a(), new Function1<Float, Pair<? extends Integer, ? extends Integer>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils$feedListLongMediaSize$3
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(Float f16) {
            return invoke(f16.floatValue());
        }

        @NotNull
        public final Pair<Integer, Integer> invoke(float f16) {
            int roundToInt;
            roundToInt = MathKt__MathJVMKt.roundToInt(f16);
            return TuplesKt.to(Integer.valueOf(roundToInt), Integer.valueOf(roundToInt / 2));
        }
    });

    private final Pair<Integer, Integer> b(int maxSize, int originW, int originH) {
        if (maxSize <= 0) {
            return TuplesKt.to(Integer.valueOf(maxSize), Integer.valueOf(maxSize));
        }
        if (originW >= originH) {
            return TuplesKt.to(Integer.valueOf(maxSize), Integer.valueOf((int) (maxSize * 0.5625f)));
        }
        if (originW < originH) {
            return TuplesKt.to(Integer.valueOf((int) ((maxSize * 5.0f) / 7.0f)), Integer.valueOf(maxSize));
        }
        return TuplesKt.to(Integer.valueOf(maxSize), Integer.valueOf(maxSize));
    }

    @NotNull
    public final Pair<Integer, Integer> a(@NotNull View view, int width, int height) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(view, "view");
        Pair<Integer, Integer> f16 = f(width, height);
        if ((view.getMeasuredWidth() != f16.getFirst().intValue() || view.getMeasuredHeight() != f16.getSecond().intValue()) && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.width = f16.getFirst().intValue();
            layoutParams.height = f16.getSecond().intValue();
            view.setLayoutParams(layoutParams);
        }
        return f16;
    }

    public abstract float c();

    @NotNull
    public final Pair<Integer, Integer> d() {
        return (Pair) this.feedListLongMediaSize.getValue(this, f219271c[1]);
    }

    public final float e() {
        return ((Number) this.feedListMediaMaxWidth.getValue(this, f219271c[0])).floatValue();
    }

    @NotNull
    public final Pair<Integer, Integer> f(int originW, int originH) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(e());
        return b(roundToInt, originW, originH);
    }

    public abstract float g();

    @NotNull
    public final Pair<Integer, Integer> h() {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(g());
        return b(roundToInt, roundToInt, roundToInt);
    }
}
