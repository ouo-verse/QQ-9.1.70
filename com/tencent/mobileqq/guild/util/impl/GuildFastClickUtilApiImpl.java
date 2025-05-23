package com.tencent.mobileqq.guild.util.impl;

import android.view.View;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.guild.util.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/util/impl/GuildFastClickUtilApiImpl;", "Lcom/tencent/mobileqq/guild/util/IGuildFastClickUtilApi;", "()V", "isFastClick", "", "view", "Landroid/view/View;", "tag", "", "timeThreshold", "", "resetFastClick", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildFastClickUtilApiImpl implements IGuildFastClickUtilApi {
    @Override // com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi
    public boolean isFastClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return o.a(view);
    }

    @Override // com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi
    public void resetFastClick(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        o.e(tag);
    }

    @Override // com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi
    public boolean isFastClick(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return o.c(tag);
    }

    @Override // com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi
    public boolean isFastClick(@NotNull String tag, long timeThreshold) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return o.d(tag, timeThreshold);
    }
}
