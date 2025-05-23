package com.tencent.mobileqq.guild.feed.gallery.widget.item;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryCloseEvent;
import com.tencent.mobileqq.guild.feed.gallery.widget.item.ImageFeedGalleryViewHolder$clickOperationListener$2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0015\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/ImageFeedGalleryViewHolder;", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/b;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "data", "", "position", "verPos", "", "w", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "r", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "I", com.tencent.luggage.wxa.c8.c.G, "", "J", "lastDoubleTapTime", "com/tencent/mobileqq/guild/feed/gallery/widget/item/ImageFeedGalleryViewHolder$clickOperationListener$2$a", "K", "Lkotlin/Lazy;", "B", "()Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/ImageFeedGalleryViewHolder$clickOperationListener$2$a;", "clickOperationListener", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/GuildBannerImageItemViewV2;", "rootItemView", "<init>", "(Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/GuildBannerImageItemViewV2;)V", "L", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ImageFeedGalleryViewHolder extends b {

    /* renamed from: I, reason: from kotlin metadata */
    private int pos;

    /* renamed from: J, reason: from kotlin metadata */
    private long lastDoubleTapTime;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy clickOperationListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageFeedGalleryViewHolder(@NotNull GuildBannerImageItemViewV2 rootItemView) {
        super(rootItemView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(rootItemView, "rootItemView");
        this.pos = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageFeedGalleryViewHolder$clickOperationListener$2.a>() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.ImageFeedGalleryViewHolder$clickOperationListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/widget/item/ImageFeedGalleryViewHolder$clickOperationListener$2$a", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/k;", "", "from", "", "positionX", "positionY", "", "b", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "Landroid/view/MotionEvent;", "event", "c", "Landroid/content/Context;", "context", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements k {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ImageFeedGalleryViewHolder f219926a;

                a(ImageFeedGalleryViewHolder imageFeedGalleryViewHolder) {
                    this.f219926a = imageFeedGalleryViewHolder;
                }

                @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.k
                public void a(@NotNull Context context, @NotNull String from) {
                    int i3;
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(from, "from");
                    Logger.f235387a.d().i("Guild_Feed_GAL_ImageFeedGalleryViewHolder", 1, "[doLongClick] from:" + from);
                    ImageFeedGalleryViewHolder imageFeedGalleryViewHolder = this.f219926a;
                    i3 = imageFeedGalleryViewHolder.pos;
                    b.v(imageFeedGalleryViewHolder, context, i3, 0.0f, 0.0f, null, 28, null);
                }

                @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.k
                public void b(@NotNull String from, @Nullable Float positionX, @Nullable Float positionY) {
                    long j3;
                    long j16;
                    Intrinsics.checkNotNullParameter(from, "from");
                    long uptimeMillis = SystemClock.uptimeMillis();
                    j3 = this.f219926a.lastDoubleTapTime;
                    long j17 = uptimeMillis - j3;
                    Logger.f235387a.d().i("Guild_Feed_GAL_ImageFeedGalleryViewHolder", 1, "[onSingleTap] from:" + from + ", interval: " + j17);
                    j16 = this.f219926a.lastDoubleTapTime;
                    if (j16 > 0 && j17 < 900) {
                        this.f219926a.s(positionX, positionY);
                        this.f219926a.lastDoubleTapTime = 0L;
                    } else {
                        this.f219926a.C();
                    }
                }

                @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.k
                public void c(@NotNull String from, @Nullable MotionEvent event) {
                    Intrinsics.checkNotNullParameter(from, "from");
                    Logger logger = Logger.f235387a;
                    logger.d().i("Guild_Feed_GAL_ImageFeedGalleryViewHolder", 1, "[onDoubleTap] from:" + from);
                    if (event == null) {
                        logger.d().i("Guild_Feed_GAL_ImageFeedGalleryViewHolder", 1, "[onDoubleTap] event is null");
                        return;
                    }
                    this.f219926a.s(Float.valueOf(event.getX()), Float.valueOf(event.getY()));
                    this.f219926a.lastDoubleTapTime = SystemClock.uptimeMillis();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(ImageFeedGalleryViewHolder.this);
            }
        });
        this.clickOperationListener = lazy;
    }

    private final ImageFeedGalleryViewHolder$clickOperationListener$2.a B() {
        return (ImageFeedGalleryViewHolder$clickOperationListener$2.a) this.clickOperationListener.getValue();
    }

    public void C() {
        QLog.i("Guild_Feed_GAL_ImageFeedGalleryViewHolder", 1, "[onSingleClick] start");
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryCloseEvent());
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.b
    public void onPause() {
        GuildBannerImageItemViewV2 guildBannerImageItemViewV2;
        View rootItemView = getRootItemView();
        if (rootItemView instanceof GuildBannerImageItemViewV2) {
            guildBannerImageItemViewV2 = (GuildBannerImageItemViewV2) rootItemView;
        } else {
            guildBannerImageItemViewV2 = null;
        }
        if (guildBannerImageItemViewV2 != null) {
            guildBannerImageItemViewV2.onPause();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.b
    public void onResume() {
        GuildBannerImageItemViewV2 guildBannerImageItemViewV2;
        View rootItemView = getRootItemView();
        if (rootItemView instanceof GuildBannerImageItemViewV2) {
            guildBannerImageItemViewV2 = (GuildBannerImageItemViewV2) rootItemView;
        } else {
            guildBannerImageItemViewV2 = null;
        }
        if (guildBannerImageItemViewV2 != null) {
            guildBannerImageItemViewV2.onResume();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.b
    public void q() {
        GuildBannerImageItemViewV2 guildBannerImageItemViewV2;
        View rootItemView = getRootItemView();
        if (rootItemView instanceof GuildBannerImageItemViewV2) {
            guildBannerImageItemViewV2 = (GuildBannerImageItemViewV2) rootItemView;
        } else {
            guildBannerImageItemViewV2 = null;
        }
        if (guildBannerImageItemViewV2 != null) {
            guildBannerImageItemViewV2.b1();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.b
    public void r(@Nullable GProStFeed feed) {
        GuildBannerImageItemViewV2 guildBannerImageItemViewV2;
        View rootItemView = getRootItemView();
        if (rootItemView instanceof GuildBannerImageItemViewV2) {
            guildBannerImageItemViewV2 = (GuildBannerImageItemViewV2) rootItemView;
        } else {
            guildBannerImageItemViewV2 = null;
        }
        if (guildBannerImageItemViewV2 != null) {
            guildBannerImageItemViewV2.c1(feed);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.b
    public void w(@Nullable GProStFeed feed, @NotNull GuildFeedRichMediaData data, int position, int verPos) {
        GuildBannerImageItemViewV2 guildBannerImageItemViewV2;
        Intrinsics.checkNotNullParameter(data, "data");
        super.w(feed, data, position, verPos);
        this.pos = position;
        View rootItemView = getRootItemView();
        if (rootItemView instanceof GuildBannerImageItemViewV2) {
            guildBannerImageItemViewV2 = (GuildBannerImageItemViewV2) rootItemView;
        } else {
            guildBannerImageItemViewV2 = null;
        }
        if (guildBannerImageItemViewV2 != null) {
            guildBannerImageItemViewV2.setClickOperationListener(B());
            guildBannerImageItemViewV2.setDisplayVerticalPos(verPos);
            guildBannerImageItemViewV2.setData(data, position);
            ((GuildBannerImageItemViewV2) getRootItemView()).setGuildFeed(feed);
        }
    }
}
