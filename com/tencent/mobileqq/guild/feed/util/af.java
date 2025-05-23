package com.tencent.mobileqq.guild.feed.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/af;", "", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedPublishInitBean;", "target", "Landroid/content/Context;", "context", "", "a", "", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final af f223838a = new af();

    af() {
    }

    public final void a(@NotNull GuildFeedPublishInitBean target, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(context, "context");
        target.setSourceType(b(context));
    }

    public final int b(@NotNull Context context) {
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null && intent.hasExtra(com.tencent.mobileqq.guild.feed.b.f218115a)) {
            try {
                GuildFeedPublishInitBean guildFeedPublishInitBean = (GuildFeedPublishInitBean) intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
                if (guildFeedPublishInitBean != null) {
                    return guildFeedPublishInitBean.getSourceType();
                }
            } catch (Throwable th5) {
                QLog.e("GuildFeedFragmentTypeUtil", 1, "copyFragmentSourceType error !!", th5);
            }
        }
        return 0;
    }
}
