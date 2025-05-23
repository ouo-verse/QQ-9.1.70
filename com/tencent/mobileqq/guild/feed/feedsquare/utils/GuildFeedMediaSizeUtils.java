package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import android.content.Context;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001b\u0010\u0011\u001a\u00020\f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildFeedMediaSizeUtils;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "Landroid/content/Context;", "context", "", "j", "", "toString", "Ljava/lang/ref/WeakReference;", "f", "Ljava/lang/ref/WeakReference;", "feedContextRef", "", "g", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/a;", "c", "()F", "defaultFeedListMaxWidth", "maxWidthForViewSize", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedMediaSizeUtils extends AbsGuildFeedMediaSizeUtils {

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f219297e = {Reflection.property1(new PropertyReference1Impl(GuildFeedMediaSizeUtils.class, "defaultFeedListMaxWidth", "getDefaultFeedListMaxWidth()F", 0))};

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildFeedMediaSizeUtils f219296d = new GuildFeedMediaSizeUtils();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static WeakReference<Context> feedContextRef = new WeakReference<>(null);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a defaultFeedListMaxWidth = new a(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeUtils$defaultFeedListMaxWidth$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Integer invoke() {
            WeakReference weakReference;
            GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
            weakReference = GuildFeedMediaSizeUtils.feedContextRef;
            return Integer.valueOf(guildSplitViewUtils.i(true, (Context) weakReference.get()));
        }
    }, ComputedKt.a(), new Function1<Integer, Float>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeUtils$defaultFeedListMaxWidth$3
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Integer num) {
            return invoke(num.intValue());
        }

        @NotNull
        public final Float invoke(int i3) {
            Logger.f235387a.d().i("GuildFeedMediaSizeUtils", 1, "defaultFeedListMaxWidth: screenWidth=" + i3);
            return Float.valueOf(i3 - cw.c(70.0f));
        }
    });

    GuildFeedMediaSizeUtils() {
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils
    public float c() {
        return ((Number) defaultFeedListMaxWidth.getValue(this, f219297e[0])).floatValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils
    public float g() {
        return c();
    }

    public final void j(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        feedContextRef = new WeakReference<>(context);
    }

    @NotNull
    public String toString() {
        return "Default";
    }
}
