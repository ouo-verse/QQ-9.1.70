package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.cw;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\t\u001a\u00020\u00048VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildFeedMediaSizeForSearchUtils;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "", "toString", "", "f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/a;", "c", "()F", "defaultFeedListMaxWidth", "g", "maxWidthForViewSize", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedMediaSizeForSearchUtils extends AbsGuildFeedMediaSizeUtils {

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f219294e = {Reflection.property1(new PropertyReference1Impl(GuildFeedMediaSizeForSearchUtils.class, "defaultFeedListMaxWidth", "getDefaultFeedListMaxWidth()F", 0))};

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildFeedMediaSizeForSearchUtils f219293d = new GuildFeedMediaSizeForSearchUtils();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a defaultFeedListMaxWidth = new a(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeForSearchUtils$defaultFeedListMaxWidth$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Integer invoke() {
            return Integer.valueOf(GuildSplitViewUtils.j(GuildSplitViewUtils.f235370a, true, null, 2, null));
        }
    }, ComputedKt.a(), new Function1<Integer, Float>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeForSearchUtils$defaultFeedListMaxWidth$3
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Integer num) {
            return invoke(num.intValue());
        }

        @NotNull
        public final Float invoke(int i3) {
            return Float.valueOf(i3 - cw.d(70));
        }
    });

    GuildFeedMediaSizeForSearchUtils() {
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils
    public float c() {
        return ((Number) defaultFeedListMaxWidth.getValue(this, f219294e[0])).floatValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils
    public float g() {
        return c() * 0.54f;
    }

    @NotNull
    public String toString() {
        return "Search";
    }
}
