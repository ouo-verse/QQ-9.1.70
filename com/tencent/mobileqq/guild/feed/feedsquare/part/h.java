package com.tencent.mobileqq.guild.feed.feedsquare.part;

import android.text.TextUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zj1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0010H\u0002J\u001c\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/h;", "Lcom/tencent/biz/richframework/part/Part;", "", "args", "", "A9", "Lzj1/a$a;", "F9", "D9", "z9", "Lzj1/a$b;", "G9", "E9", "Lij1/g;", "feed", "x9", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "H9", "I9", "C9", "", "action", "handleBroadcastMessage", "url", "B9", "", "d", "Z", "mIsScrolling", "", "e", "I", "mLastPreloadThumbEndPos", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsScrolling;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mLastPreloadThumbEndPos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/part/h$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GuildPicStateListener {
        b() {
            super(true);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            QLog.d("GuildFeedSquarePreLoadImagePart", 4, "onStateChangeCallback state\uff1a" + state + "  url: " + option.getUrl());
        }
    }

    private final void A9(Object args) {
        if ((args instanceof a.OnFeedLoadCompletedMessage) && !this.mIsScrolling) {
            try {
                F9((a.OnFeedLoadCompletedMessage) args);
                D9((a.OnFeedLoadCompletedMessage) args);
            } catch (Exception e16) {
                QLog.e("GuildFeedSquarePreLoadImagePart", 1, "[handleLoadComplete] exception: " + e16.getMessage());
            }
        }
    }

    private final void C9(GProStFeed feed) {
        Iterator<GProStImage> it = feed.images.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            GProStImage image = it.next();
            if (i3 < 3) {
                Intrinsics.checkNotNullExpressionValue(image, "image");
                String h16 = bm.h(image);
                if (!TextUtils.isEmpty(h16)) {
                    B9(h16);
                }
                i3++;
            } else {
                return;
            }
        }
    }

    private final void D9(a.OnFeedLoadCompletedMessage args) {
        List<ij1.g> a16 = args.a();
        if (a16 != null && args.getIsFirstScreen() && (!a16.isEmpty())) {
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = 3;
            if (3 > a16.size()) {
                i3 = a16.size();
            }
            for (int i16 = 0; i16 < i3; i16++) {
                x9(a16.get(i16));
            }
            QLog.i("GuildFeedSquarePreLoadImagePart", 1, "[preloadGalleryImageOnLoadComplete] preload size: " + i3 + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private final void E9(a.OnFeedScrollStateChangedMessage args) {
        int size;
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> a16 = args.a();
        if (a16 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            int firstVisiblePos = args.getFirstVisiblePos() - 3 > 0 ? args.getFirstVisiblePos() - 3 : 0;
            if (args.getLastVisiblePos() + 3 < a16.size()) {
                size = args.getLastVisiblePos() + 3;
            } else {
                size = a16.size();
            }
            for (int i3 = firstVisiblePos; i3 < size; i3++) {
                x9(a16.get(i3).getBlockData());
            }
            QLog.i("GuildFeedSquarePreLoadImagePart", 1, "[preloadGalleryImageOnStopScroll] preload list size: " + (size - firstVisiblePos) + ", firstPos: " + firstVisiblePos + ", lastPos: " + size + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private final void F9(a.OnFeedLoadCompletedMessage args) {
        List<ij1.g> a16 = args.a();
        if (a16 != null && args.getOldItemCount() < a16.size()) {
            long currentTimeMillis = System.currentTimeMillis();
            int size = a16.size();
            for (int oldItemCount = args.getOldItemCount(); oldItemCount < size; oldItemCount++) {
                GProStFeed sourceData = a16.get(oldItemCount).b();
                if (sourceData != null) {
                    Intrinsics.checkNotNullExpressionValue(sourceData, "sourceData");
                    H9(sourceData);
                }
            }
            QLog.i("GuildFeedSquarePreLoadImagePart", 1, "[preloadThumbOnLoadComplete] preload size: " + (a16.size() - args.getOldItemCount()) + ", feedList: " + a16.size() + ", oldItemCount: " + args.getOldItemCount() + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private final void G9(a.OnFeedScrollStateChangedMessage args) {
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> a16 = args.a();
        if (a16 != null && a16.size() > args.getLastVisiblePos() && this.mLastPreloadThumbEndPos < a16.size()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.mLastPreloadThumbEndPos = a16.size();
            int size = a16.size();
            for (int lastVisiblePos = args.getLastVisiblePos() + 1; lastVisiblePos < size; lastVisiblePos++) {
                if (a16.get(lastVisiblePos).getBlockData().b() != null) {
                    GProStFeed b16 = a16.get(lastVisiblePos).getBlockData().b();
                    Intrinsics.checkNotNullExpressionValue(b16, "feedList[i].blockData.sourceData");
                    H9(b16);
                }
            }
            QLog.i("GuildFeedSquarePreLoadImagePart", 1, "[preloadThumbOnStopScroll] preload size: " + (a16.size() - args.getLastVisiblePos()) + "\uff0c fistVisiblePos: " + args.getFirstVisiblePos() + ", lastVisiblePos: " + args.getLastVisiblePos() + ", mLastPreloadEndPos: " + this.mLastPreloadThumbEndPos + ", feedListSize: " + a16.size() + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private final void H9(GProStFeed feed) {
        C9(feed);
        I9(feed);
    }

    private final void I9(GProStFeed feed) {
        Iterator<GProStVideo> it = feed.videos.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            GProStVideo next = it.next();
            if (i3 < 3) {
                GProStImage gProStImage = next.cover;
                Intrinsics.checkNotNullExpressionValue(gProStImage, "video.cover");
                String h16 = bm.h(gProStImage);
                if (!TextUtils.isEmpty(h16)) {
                    i3++;
                    if (QLog.isDevelopLevel()) {
                        QLog.d("GuildFeedSquarePreLoadImagePart", 4, "preloadVideoCover\uff1a" + h16);
                    }
                    B9(h16);
                }
            } else {
                return;
            }
        }
    }

    private final void x9(ij1.g feed) {
        boolean z16;
        if (feed.b().feedType != 2) {
            ArrayList<com.tencent.mobileqq.guild.feed.adapter.n> m3 = com.tencent.mobileqq.guild.feed.adapter.n.m(feed.b());
            int i3 = 0;
            if (m3 != null && !m3.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("GuildFeedSquarePreLoadImagePart", 4, "doPreloadGalleryImage\uff1a" + m3.size());
                }
                Iterator<com.tencent.mobileqq.guild.feed.adapter.n> it = m3.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.guild.feed.adapter.n next = it.next();
                    if (i3 < 3) {
                        com.tencent.mobileqq.guild.feed.gallery.d.a(next.c());
                        i3++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private final void z9(Object args) {
        if (!(args instanceof a.OnFeedScrollStateChangedMessage)) {
            return;
        }
        a.OnFeedScrollStateChangedMessage onFeedScrollStateChangedMessage = (a.OnFeedScrollStateChangedMessage) args;
        this.mIsScrolling = onFeedScrollStateChangedMessage.getIsScrolling();
        if (!onFeedScrollStateChangedMessage.getIsScrolling()) {
            try {
                G9((a.OnFeedScrollStateChangedMessage) args);
                E9((a.OnFeedScrollStateChangedMessage) args);
            } catch (Exception e16) {
                QLog.e("GuildFeedSquarePreLoadImagePart", 1, "[handleListScroll] exception: " + e16.getMessage());
            }
        }
    }

    public final void B9(@Nullable String url) {
        com.tencent.mobileqq.guild.picload.e.a().f(Option.obtain().setPredecode(false).setUrl(url), new b());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "message_on_feed_load_complete")) {
            A9(args);
        } else if (Intrinsics.areEqual(action, "message_on_feed_scroll_state_changed")) {
            z9(args);
        }
    }
}
