package com.tencent.mobileqq.guild.feed.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativepublish.fragment.FeedThirdPlatformVideoWebFragment;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/ai;", "", "Landroid/content/Context;", "context", "", "url", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "detailInitBean", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ai {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ai f223840a = new ai();

    ai() {
    }

    public final void a(@NotNull Context context, @NotNull String url, @NotNull GuildFeedBaseInitBean detailInitBean) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(detailInitBean, "detailInitBean");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("fail to openNormalUrl, url is empty");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFeedJumpUtils", 1, (String) it.next(), null);
            }
            return;
        }
        Logger.f235387a.d().i("GuildFeedJumpUtils", 1, "openNormalUrl " + url);
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("fragment_class", FeedThirdPlatformVideoWebFragment.class.getCanonicalName());
        intent.putExtra("url", url);
        intent.putExtra(com.tencent.mobileqq.guild.feed.b.f218115a, detailInitBean);
        context.startActivity(intent);
    }
}
