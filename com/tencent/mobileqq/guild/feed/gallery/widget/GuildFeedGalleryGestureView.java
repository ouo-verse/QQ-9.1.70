package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002)*B\u0017\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryGestureView;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryGestureView$b;", "listener", "", "setRatePlayLongPressListener", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "longPressHandler", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "longPressRunnable", "", "f", UserInfo.SEX_FEMALE, "mDownX", tl.h.F, "mDownY", "i", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryGestureView$b;", "ratePlayLongPressListener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "touchSlop", BdhLogUtil.LogTag.Tag_Conn, "Z", "isLongPressTriggered", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryGestureView extends FrameLayout {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isLongPressTriggered;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler longPressHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable longPressRunnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mDownX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mDownY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b ratePlayLongPressListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int touchSlop;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryGestureView$a;", "", "Landroid/view/View;", "view", "", "positionX", "positionY", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryGestureView$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@Nullable View view, float positionX, float positionY) {
            boolean z16;
            boolean z17;
            if (view == null) {
                return false;
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            int a16 = cx.a(140.0f);
            if (positionX >= rect.left && positionX < r2 + a16 && positionY >= rect.top && positionY < rect.bottom) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (positionX <= rect.right && positionX > r3 - a16 && positionY >= rect.top && positionY < rect.bottom) {
                z17 = true;
            } else {
                z17 = false;
            }
            QLog.d("GuildFeedGalleryGestureView", 1, "isInPlayRateArea :" + z16 + "|" + z17);
            if (!z16 && !z17) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryGestureView$b;", "", "Landroid/view/View;", "view", "", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(@Nullable View view);

        void b(@Nullable View view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryGestureView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.longPressHandler = new Handler(Looper.getMainLooper());
        this.longPressRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryGestureView.b(GuildFeedGalleryGestureView.this);
            }
        };
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildFeedGalleryGestureView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (INSTANCE.a(this$0, this$0.mDownX, this$0.mDownY)) {
            this$0.isLongPressTriggered = true;
            b bVar = this$0.ratePlayLongPressListener;
            if (bVar != null) {
                bVar.a(this$0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 5) {
                            this.longPressHandler.removeCallbacks(this.longPressRunnable);
                        }
                    }
                } else if (Math.abs(this.mDownX - event.getRawX()) > this.touchSlop || Math.abs(this.mDownY - event.getRawY()) > this.touchSlop) {
                    this.longPressHandler.removeCallbacks(this.longPressRunnable);
                }
            }
            this.longPressHandler.removeCallbacks(this.longPressRunnable);
            b bVar = this.ratePlayLongPressListener;
            if (bVar != null) {
                bVar.b(this);
            }
        } else {
            this.isLongPressTriggered = false;
            this.mDownX = event.getRawX();
            this.mDownY = event.getRawY();
            this.longPressHandler.removeCallbacks(this.longPressRunnable);
            this.longPressHandler.postDelayed(this.longPressRunnable, 500L);
        }
        if (!this.isLongPressTriggered && !super.dispatchTouchEvent(event)) {
            return false;
        }
        return true;
    }

    public final void setRatePlayLongPressListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.ratePlayLongPressListener = listener;
    }
}
