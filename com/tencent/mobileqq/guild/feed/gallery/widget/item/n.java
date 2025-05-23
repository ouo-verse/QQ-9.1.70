package com.tencent.mobileqq.guild.feed.gallery.widget.item;

import android.content.Context;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/n;", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/b;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "data", "", "position", "verPos", "", "w", BdhLogUtil.LogTag.Tag_Conn, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "H", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "p", "Landroid/view/GestureDetector;", "I", "Landroid/view/GestureDetector;", "gestureDetector", "", "J", "lastDoubleTapTime", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/GuildBannerVideoItemViewV2;", "rootItemView", "<init>", "(Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/GuildBannerVideoItemViewV2;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n extends b {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private GestureDetector gestureDetector;

    /* renamed from: J, reason: from kotlin metadata */
    private long lastDoubleTapTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/widget/item/n$a", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "onDoubleTap", "", e.a.NAME, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f219943e;

        a(int i3) {
            this.f219943e = i3;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@Nullable MotionEvent e16) {
            if (e16 != null) {
                n.this.s(Float.valueOf(e16.getX()), Float.valueOf(e16.getY()));
                n.this.lastDoubleTapTime = SystemClock.uptimeMillis();
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(@Nullable MotionEvent e16) {
            if (e16 != null) {
                n nVar = n.this;
                Context context = nVar.getRootItemView().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "rootItemView.context");
                nVar.u(context, this.f219943e, e16.getX(), e16.getY(), n.this.getRootItemView());
                return;
            }
            n nVar2 = n.this;
            Context context2 = nVar2.getRootItemView().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "rootItemView.context");
            b.v(nVar2, context2, this.f219943e, 0.0f, 0.0f, null, 28, null);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@Nullable MotionEvent e16) {
            if (e16 != null) {
                long uptimeMillis = SystemClock.uptimeMillis() - n.this.lastDoubleTapTime;
                if (n.this.lastDoubleTapTime > 0 && uptimeMillis < 900) {
                    n.this.s(Float.valueOf(e16.getX()), Float.valueOf(e16.getY()));
                    n.this.lastDoubleTapTime = 0L;
                    return true;
                }
                n.this.H();
                return true;
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull GuildBannerVideoItemViewV2 rootItemView) {
        super(rootItemView);
        Intrinsics.checkNotNullParameter(rootItemView, "rootItemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(n this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GestureDetector gestureDetector = this$0.gestureDetector;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(n this$0, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s(Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
    }

    public final void C(int position) {
        GuildBannerVideoItemViewV2 guildBannerVideoItemViewV2;
        this.gestureDetector = new GestureDetector(getRootItemView().getContext(), new a(position));
        getRootItemView().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.l
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean D;
                D = n.D(n.this, view, motionEvent);
                return D;
            }
        });
        View rootItemView = getRootItemView();
        if (rootItemView instanceof GuildBannerVideoItemViewV2) {
            guildBannerVideoItemViewV2 = (GuildBannerVideoItemViewV2) rootItemView;
        } else {
            guildBannerVideoItemViewV2 = null;
        }
        if (guildBannerVideoItemViewV2 != null) {
            guildBannerVideoItemViewV2.setExtraOnDoubleTapListener(new com.tencent.biz.qqcircle.widgets.multitouchimg.d() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.m
                @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.d
                public final void onDoubleTap(MotionEvent motionEvent) {
                    n.E(n.this, motionEvent);
                }
            });
        }
    }

    public void H() {
        GuildBannerVideoItemViewV2 guildBannerVideoItemViewV2;
        View rootItemView = getRootItemView();
        if (rootItemView instanceof GuildBannerVideoItemViewV2) {
            guildBannerVideoItemViewV2 = (GuildBannerVideoItemViewV2) rootItemView;
        } else {
            guildBannerVideoItemViewV2 = null;
        }
        if (guildBannerVideoItemViewV2 != null) {
            guildBannerVideoItemViewV2.k1();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.b
    public void onPause() {
        GuildBannerVideoItemViewV2 guildBannerVideoItemViewV2;
        View rootItemView = getRootItemView();
        if (rootItemView instanceof GuildBannerVideoItemViewV2) {
            guildBannerVideoItemViewV2 = (GuildBannerVideoItemViewV2) rootItemView;
        } else {
            guildBannerVideoItemViewV2 = null;
        }
        if (guildBannerVideoItemViewV2 != null) {
            guildBannerVideoItemViewV2.onPause();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.b
    public void onResume() {
        GuildBannerVideoItemViewV2 guildBannerVideoItemViewV2;
        View rootItemView = getRootItemView();
        if (rootItemView instanceof GuildBannerVideoItemViewV2) {
            guildBannerVideoItemViewV2 = (GuildBannerVideoItemViewV2) rootItemView;
        } else {
            guildBannerVideoItemViewV2 = null;
        }
        if (guildBannerVideoItemViewV2 != null) {
            guildBannerVideoItemViewV2.onResume();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.b
    public boolean p() {
        GuildBannerVideoItemViewV2 guildBannerVideoItemViewV2;
        View rootItemView = getRootItemView();
        if (rootItemView instanceof GuildBannerVideoItemViewV2) {
            guildBannerVideoItemViewV2 = (GuildBannerVideoItemViewV2) rootItemView;
        } else {
            guildBannerVideoItemViewV2 = null;
        }
        if (guildBannerVideoItemViewV2 != null) {
            return guildBannerVideoItemViewV2.g1();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.b
    public void q() {
        GuildBannerVideoItemViewV2 guildBannerVideoItemViewV2;
        View rootItemView = getRootItemView();
        if (rootItemView instanceof GuildBannerVideoItemViewV2) {
            guildBannerVideoItemViewV2 = (GuildBannerVideoItemViewV2) rootItemView;
        } else {
            guildBannerVideoItemViewV2 = null;
        }
        if (guildBannerVideoItemViewV2 != null) {
            guildBannerVideoItemViewV2.j1();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.b
    public void w(@Nullable GProStFeed feed, @NotNull GuildFeedRichMediaData data, int position, int verPos) {
        GuildBannerVideoItemViewV2 guildBannerVideoItemViewV2;
        Intrinsics.checkNotNullParameter(data, "data");
        super.w(feed, data, position, verPos);
        View rootItemView = getRootItemView();
        if (rootItemView instanceof GuildBannerVideoItemViewV2) {
            guildBannerVideoItemViewV2 = (GuildBannerVideoItemViewV2) rootItemView;
        } else {
            guildBannerVideoItemViewV2 = null;
        }
        if (guildBannerVideoItemViewV2 != null) {
            guildBannerVideoItemViewV2.setFeedInfo(feed);
            guildBannerVideoItemViewV2.setDisplayVerticalPosition(verPos);
            guildBannerVideoItemViewV2.setData(data, position);
        }
    }
}
