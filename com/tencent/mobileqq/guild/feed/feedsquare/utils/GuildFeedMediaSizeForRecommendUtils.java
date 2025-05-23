package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildFeedMediaSizeForRecommendUtils;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "", "toString", "", "f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/a;", "j", "()I", "screenWidth", "", "g", "c", "()F", "defaultFeedListMaxWidth", "maxWidthForViewSize", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedMediaSizeForRecommendUtils extends AbsGuildFeedMediaSizeUtils {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildFeedMediaSizeForRecommendUtils f219289d;

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f219290e = {Reflection.property1(new PropertyReference1Impl(GuildFeedMediaSizeForRecommendUtils.class, "screenWidth", "getScreenWidth()I", 0)), Reflection.property1(new PropertyReference1Impl(GuildFeedMediaSizeForRecommendUtils.class, "defaultFeedListMaxWidth", "getDefaultFeedListMaxWidth()F", 0))};

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a screenWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a defaultFeedListMaxWidth;

    static {
        final GuildFeedMediaSizeForRecommendUtils guildFeedMediaSizeForRecommendUtils = new GuildFeedMediaSizeForRecommendUtils();
        f219289d = guildFeedMediaSizeForRecommendUtils;
        screenWidth = new a(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeForRecommendUtils$screenWidth$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT);
            }
        }, ComputedKt.a(), new Function1<Boolean, Integer>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeForRecommendUtils$screenWidth$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            @NotNull
            public final Integer invoke(boolean z16) {
                int screenWidth2 = ImmersiveUtils.getScreenWidth();
                Logger.f235387a.d().i("GuildFeedMediaSizeForRecommendUtils", 1, "screenWidth: " + screenWidth2 + ", isSplit: " + z16);
                if (z16) {
                    screenWidth2 = (int) (com.tencent.mobileqq.pad.e.h() * screenWidth2);
                }
                return Integer.valueOf(screenWidth2);
            }
        });
        defaultFeedListMaxWidth = new a(new PropertyReference0Impl(guildFeedMediaSizeForRecommendUtils) { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeForRecommendUtils$defaultFeedListMaxWidth$2
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                int j3;
                j3 = ((GuildFeedMediaSizeForRecommendUtils) this.receiver).j();
                return Integer.valueOf(j3);
            }
        }, ComputedKt.a(), new Function1<Integer, Float>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeForRecommendUtils$defaultFeedListMaxWidth$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                return invoke(num.intValue());
            }

            @NotNull
            public final Float invoke(int i3) {
                return Float.valueOf(i3 - (2 * cw.d(32)));
            }
        });
    }

    GuildFeedMediaSizeForRecommendUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j() {
        return ((Number) screenWidth.getValue(this, f219290e[0])).intValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils
    public float c() {
        return ((Number) defaultFeedListMaxWidth.getValue(this, f219290e[1])).floatValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils
    public float g() {
        return c();
    }

    @NotNull
    public String toString() {
        return "Recommend";
    }
}
