package com.tencent.mobileqq.guild.feed.feedsquare.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/m;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "", "getToken", "Landroidx/lifecycle/MutableLiveData;", "", "o", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface m extends k {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static void a(@NotNull m mVar, boolean z16, int i3, @NotNull String topChannelId, int i16, @NotNull String topBusinessId, boolean z17, @Nullable Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> function4) {
            Intrinsics.checkNotNullParameter(topChannelId, "topChannelId");
            Intrinsics.checkNotNullParameter(topBusinessId, "topBusinessId");
            k.a.a(mVar, z16, i3, topChannelId, i16, topBusinessId, z17, function4);
        }

        public static void b(@NotNull m mVar) {
            k.a.b(mVar);
        }
    }

    @NotNull
    byte[] getToken();

    @NotNull
    MutableLiveData<Boolean> o();
}
