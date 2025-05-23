package com.tencent.mobileqq.guild.inbox.centerpanel.notice;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001b\u0010\u0012\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u0014\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001b\u0010\u0015\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/DrawableDownloadHelper;", "", "", "url", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "", "callback", "g", "", "b", "Lkotlin/Lazy;", "f", "()I", "ICON_WIDTH", "c", "BOUNDS_LEFT", "d", "BOUNDS_RIGHT", "e", "BOUNDS_TOP", "BOUNDS_BOTTOM", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DrawableDownloadHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DrawableDownloadHelper f226160a = new DrawableDownloadHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy ICON_WIDTH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy BOUNDS_LEFT;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy BOUNDS_RIGHT;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy BOUNDS_TOP;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy BOUNDS_BOTTOM;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.DrawableDownloadHelper$ICON_WIDTH$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(QQGuildUIUtil.f(10.0f));
            }
        });
        ICON_WIDTH = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.DrawableDownloadHelper$BOUNDS_LEFT$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return 0;
            }
        });
        BOUNDS_LEFT = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.DrawableDownloadHelper$BOUNDS_RIGHT$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(QQGuildUIUtil.f(10.0f));
            }
        });
        BOUNDS_RIGHT = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.DrawableDownloadHelper$BOUNDS_TOP$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(QQGuildUIUtil.f(-3.0f));
            }
        });
        BOUNDS_TOP = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.DrawableDownloadHelper$BOUNDS_BOTTOM$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(QQGuildUIUtil.f(7.0f));
            }
        });
        BOUNDS_BOTTOM = lazy5;
    }

    DrawableDownloadHelper() {
    }

    private final int b() {
        return ((Number) BOUNDS_BOTTOM.getValue()).intValue();
    }

    private final int c() {
        return ((Number) BOUNDS_LEFT.getValue()).intValue();
    }

    private final int d() {
        return ((Number) BOUNDS_RIGHT.getValue()).intValue();
    }

    private final int e() {
        return ((Number) BOUNDS_TOP.getValue()).intValue();
    }

    private final int f() {
        return ((Number) ICON_WIDTH.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 callback, String url, Bitmap bitmap) {
        Unit unit;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(url, "$url");
        if (bitmap != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(ch.i().getResources(), bitmap);
            DrawableDownloadHelper drawableDownloadHelper = f226160a;
            bitmapDrawable.setBounds(drawableDownloadHelper.c(), drawableDownloadHelper.e(), drawableDownloadHelper.d(), drawableDownloadHelper.b());
            callback.invoke(bitmapDrawable);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "Failed load image " + url;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.GuildNoticeViewHolder.DrawDownloader", 1, (String) it.next(), null);
            }
        }
    }

    public final void g(@NotNull final String url, @NotNull final Function1<? super Drawable, Unit> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.guild.util.v.f(url, f(), f(), new GuildLevelRoleView.a() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.a
            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public final void a(Bitmap bitmap) {
                DrawableDownloadHelper.h(Function1.this, url, bitmap);
            }
        });
    }
}
