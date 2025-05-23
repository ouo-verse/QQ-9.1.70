package com.tencent.mobileqq.guild.discoveryv2.util;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.picload.GuildFeedPicLoader;
import com.tribe.async.log.SLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J8\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tJ\"\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006J\u001e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/util/d;", "", "Landroid/widget/ImageView;", "targetView", "", "url", "", "width", "height", "", SLog.LOG_TAG, "", "b", "f", "e", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f217794a = new d();

    d() {
    }

    public static /* synthetic */ void c(d dVar, ImageView imageView, String str, int i3, int i16, boolean z16, int i17, Object obj) {
        int i18;
        int i19;
        boolean z17;
        if ((i17 & 4) != 0) {
            i18 = 0;
        } else {
            i18 = i3;
        }
        if ((i17 & 8) != 0) {
            i19 = 0;
        } else {
            i19 = i16;
        }
        if ((i17 & 16) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        dVar.b(imageView, str, i18, i19, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ImageView it, String str, int i3, int i16) {
        Intrinsics.checkNotNullParameter(it, "$it");
        c(f217794a, it, str, i3, i16, false, 16, null);
    }

    public static /* synthetic */ void g(d dVar, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        dVar.f(str, i3, i16);
    }

    public final void b(@Nullable final ImageView targetView, @Nullable final String url, final int width, final int height, boolean async) {
        boolean z16;
        if (targetView != null) {
            if (url != null && url.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!(true ^ z16)) {
                targetView = null;
            }
            if (targetView != null) {
                Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                targetView.setImageDrawable(drawable);
                if (async) {
                    targetView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.util.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.d(targetView, url, width, height);
                        }
                    });
                    return;
                }
                GuildFeedPicLoader guildFeedPicLoader = GuildFeedPicLoader.f231079a;
                Option requestWidth = Option.obtain().setTargetView(targetView).setUrl(url).setLoadingDrawable(drawable).setRequestHeight(height).setRequestWidth(width);
                Intrinsics.checkNotNullExpressionValue(requestWidth, "obtain()\n               \u2026  .setRequestWidth(width)");
                guildFeedPicLoader.d(requestWidth, null);
            }
        }
    }

    public final void e(@NotNull String url, int width, int height) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        com.tencent.mobileqq.guild.picload.e.a().f(Option.obtain().setUrl(url).setRequestWidth(width).setRequestHeight(height).setPredecode(true), null);
    }

    public final void f(@NotNull String url, int width, int height) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Option option = Option.obtain().setUrl(url);
        GuildFeedPicLoader guildFeedPicLoader = GuildFeedPicLoader.f231079a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        guildFeedPicLoader.d(option, null);
    }
}
