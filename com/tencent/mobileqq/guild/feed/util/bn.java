package com.tencent.mobileqq.guild.feed.util;

import android.util.LruCache;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishState;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u001c\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fJ\f\u0010\u0013\u001a\u00020\u0006*\u0004\u0018\u00010\u0012J\f\u0010\u0014\u001a\u00020\u0006*\u0004\u0018\u00010\u0012J\f\u0010\u0015\u001a\u00020\u0006*\u0004\u0018\u00010\u0012J\f\u0010\u0017\u001a\u00020\u0006*\u0004\u0018\u00010\u0016J\f\u0010\u0018\u001a\u00020\u0006*\u0004\u0018\u00010\u0016J\f\u0010\u0019\u001a\u00020\u0006*\u0004\u0018\u00010\nJ\n\u0010\u001a\u001a\u00020\u0006*\u00020\nJ\n\u0010\u001c\u001a\u00020\u0006*\u00020\u001bR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/bn;", "", "", "content", "", "k", "", "sending", "fail", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "feed", "l", "", "toastId", "Lkotlin/Function0;", "block", "b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "d", "i", "a", "Lij1/g;", "f", "j", "e", "c", "Lvn1/b;", "g", "Landroid/util/LruCache;", "", "Landroid/util/LruCache;", "timestamps", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class bn {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bn f223895a = new bn();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<Integer, Long> timestamps = new LruCache<>(5);

    bn() {
    }

    @JvmStatic
    public static final boolean h(boolean sending, boolean fail) {
        if (fail) {
            yl1.n.B(false, R.string.f145590rw);
            return true;
        }
        if (!sending) {
            return false;
        }
        yl1.n.z(0, R.string.f145600rx);
        return true;
    }

    @JvmStatic
    public static final void k(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        QQToast.makeText(BaseApplication.getContext(), 1, content, 0).show();
    }

    @JvmStatic
    public static final boolean l(@NotNull GuildFeedGalleryInitBean feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        return f223895a.e(feed);
    }

    public final boolean a(@Nullable GuildFeedPublishInfo guildFeedPublishInfo) {
        GuildFeedPublishState guildFeedPublishState;
        if (guildFeedPublishInfo != null) {
            guildFeedPublishState = guildFeedPublishInfo.getMainStatus();
        } else {
            guildFeedPublishState = null;
        }
        if (guildFeedPublishState != GuildFeedPublishState.STATE_PUBLISHING || !h(true, false)) {
            return false;
        }
        return true;
    }

    public final void b(int toastId, @NotNull Function0<Unit> block) {
        long longValue;
        Intrinsics.checkNotNullParameter(block, "block");
        LruCache<Integer, Long> lruCache = timestamps;
        Long l3 = lruCache.get(Integer.valueOf(toastId));
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - longValue) < 1000) {
            QLog.d("ToastUtil", 1, "fastToast: " + longValue);
            return;
        }
        lruCache.put(Integer.valueOf(toastId), Long.valueOf(currentTimeMillis));
        block.invoke();
    }

    public final boolean c(@NotNull GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        GuildFeedPublishState guildFeedPublishState;
        Intrinsics.checkNotNullParameter(guildFeedGalleryInitBean, "<this>");
        GuildFeedPublishInfo guildFeedPublishInfo = guildFeedGalleryInitBean.getGuildFeedPublishInfo();
        GuildFeedPublishState guildFeedPublishState2 = null;
        if (guildFeedPublishInfo != null) {
            guildFeedPublishState = guildFeedPublishInfo.getMainStatus();
        } else {
            guildFeedPublishState = null;
        }
        if (guildFeedPublishState != GuildFeedPublishState.STATE_PUBLISHING) {
            GuildFeedPublishInfo guildFeedPublishInfo2 = guildFeedGalleryInitBean.getGuildFeedPublishInfo();
            if (guildFeedPublishInfo2 != null) {
                guildFeedPublishState2 = guildFeedPublishInfo2.getMainStatus();
            }
            if (guildFeedPublishState2 != GuildFeedPublishState.STATE_PUBLISH_FAIL) {
                return false;
            }
        }
        return true;
    }

    public final boolean d(@Nullable GuildFeedPublishInfo guildFeedPublishInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (guildFeedPublishInfo != null && guildFeedPublishInfo.isLocalFeed()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (guildFeedPublishInfo.getMainStatus() == GuildFeedPublishState.STATE_PUBLISHING) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (guildFeedPublishInfo.getMainStatus() == GuildFeedPublishState.STATE_PUBLISH_FAIL) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (h(z17, z18)) {
                return true;
            }
        }
        return false;
    }

    public final boolean e(@Nullable GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        boolean z16;
        GuildFeedPublishState guildFeedPublishState;
        boolean z17;
        boolean z18;
        GuildFeedPublishInfo guildFeedPublishInfo;
        if (guildFeedGalleryInitBean != null && (guildFeedPublishInfo = guildFeedGalleryInitBean.getGuildFeedPublishInfo()) != null && guildFeedPublishInfo.isLocalFeed()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            GuildFeedPublishInfo guildFeedPublishInfo2 = guildFeedGalleryInitBean.getGuildFeedPublishInfo();
            GuildFeedPublishState guildFeedPublishState2 = null;
            if (guildFeedPublishInfo2 != null) {
                guildFeedPublishState = guildFeedPublishInfo2.getMainStatus();
            } else {
                guildFeedPublishState = null;
            }
            if (guildFeedPublishState == GuildFeedPublishState.STATE_PUBLISHING) {
                z17 = true;
            } else {
                z17 = false;
            }
            GuildFeedPublishInfo guildFeedPublishInfo3 = guildFeedGalleryInitBean.getGuildFeedPublishInfo();
            if (guildFeedPublishInfo3 != null) {
                guildFeedPublishState2 = guildFeedPublishInfo3.getMainStatus();
            }
            if (guildFeedPublishState2 == GuildFeedPublishState.STATE_PUBLISH_FAIL) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (h(z17, z18)) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(@Nullable ij1.g gVar) {
        boolean z16;
        GProStFeed b16;
        if (gVar != null && (b16 = gVar.b()) != null && com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(b16)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && h(wj1.c.d(gVar), wj1.c.a(gVar))) {
            return true;
        }
        return false;
    }

    public final boolean g(@NotNull vn1.b bVar) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        if (!bVar.d().w()) {
            return false;
        }
        GuildTaskProgressState taskProgressState = bVar.getTaskProgressState();
        if (taskProgressState != null && kn1.c.b(taskProgressState)) {
            z16 = true;
        } else {
            z16 = false;
        }
        GuildTaskProgressState taskProgressState2 = bVar.getTaskProgressState();
        if (taskProgressState2 != null && kn1.c.a(taskProgressState2)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!h(z16, z17)) {
            return false;
        }
        return true;
    }

    public final boolean i(@Nullable GuildFeedPublishInfo guildFeedPublishInfo) {
        boolean z16;
        if (guildFeedPublishInfo != null && guildFeedPublishInfo.isLocalFeed()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && guildFeedPublishInfo.getMainStatus() == GuildFeedPublishState.STATE_PUBLISH_FAIL && h(false, true)) {
            return true;
        }
        return false;
    }

    public final boolean j(@Nullable ij1.g gVar) {
        boolean z16;
        GProStFeed b16;
        if (gVar != null && (b16 = gVar.b()) != null && com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(b16)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && wj1.c.a(gVar) && h(false, true)) {
            return true;
        }
        return false;
    }
}
