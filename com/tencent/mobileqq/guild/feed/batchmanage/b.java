package com.tencent.mobileqq.guild.feed.batchmanage;

import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import ij1.g;
import kn1.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/b;", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/b$a;", "", "Lij1/g;", "guildFeedBlockData", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.batchmanage.b$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull g guildFeedBlockData) {
            boolean z16;
            Intrinsics.checkNotNullParameter(guildFeedBlockData, "guildFeedBlockData");
            if (guildFeedBlockData.b().recommendCard.cardType != 0) {
                return false;
            }
            GProStFeed b16 = guildFeedBlockData.b();
            Intrinsics.checkNotNullExpressionValue(b16, "guildFeedBlockData.sourceData");
            if (com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(b16)) {
                return false;
            }
            GuildTaskProgressState p16 = guildFeedBlockData.p();
            if (p16 != null && c.a(p16)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }
}
