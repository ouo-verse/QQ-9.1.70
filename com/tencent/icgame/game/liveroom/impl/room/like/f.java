package com.tencent.icgame.game.liveroom.impl.room.like;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.icgame.game.liveroom.impl.room.like.LiveOwnerLikeView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.utils.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001fR \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\"R\u0016\u0010$\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010 R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/like/f;", "", "", "roomId", "", "Landroid/view/ViewGroup;", "viewsNotResponse", "", "d", "e", "Lcom/tencent/icgame/game/liveroom/impl/room/like/LiveLikeView;", "beLikeView", "f", "Lcom/tencent/icgame/game/liveroom/impl/room/like/LiveOwnerLikeView;", "ownerLikeView", h.F, "Landroid/view/MotionEvent;", "ev", "", "c", "j", "i", "listScrolling", "g", "b", "J", "getRoomId", "()J", "setRoomId", "(J)V", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "Z", "comboing", "Landroid/view/MotionEvent;", "curTouchEvent", "isMsgListScrolling", "", "Ljava/util/List;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<LiveOwnerLikeView> ownerLikeView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<LiveLikeView> beLikeView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean comboing;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static MotionEvent curTouchEvent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean isMsgListScrolling;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f115408a = new f();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<ViewGroup> viewsNotResponse = new ArrayList();

    f() {
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean c(long roomId2, @NotNull MotionEvent ev5) {
        boolean z16;
        LiveOwnerLikeView liveOwnerLikeView;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (QLog.isDevelopLevel()) {
            QLog.d("LikeTouchManager", 4, "dispatchTouchEvent, action " + ev5.getAction());
        }
        if (roomId2 != roomId || ev5.getAction() != 0) {
            return false;
        }
        curTouchEvent = MotionEvent.obtain(ev5);
        WeakReference<LiveOwnerLikeView> weakReference = ownerLikeView;
        if (weakReference != null && (liveOwnerLikeView = weakReference.get()) != null && !liveOwnerLikeView.getComboing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        List<ViewGroup> list = viewsNotResponse;
        if (list.isEmpty()) {
            i();
            return false;
        }
        Iterator<T> it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) it.next();
        if (ev5.getY() <= viewGroup.getTop() || ev5.getY() >= viewGroup.getBottom()) {
            return false;
        }
        f115408a.i();
        return true;
    }

    public final void d(long roomId2, @NotNull List<? extends ViewGroup> viewsNotResponse2) {
        Intrinsics.checkNotNullParameter(viewsNotResponse2, "viewsNotResponse");
        roomId = roomId2;
        List<ViewGroup> list = viewsNotResponse;
        list.clear();
        list.addAll(viewsNotResponse2);
    }

    public final void e() {
        roomId = 0L;
        viewsNotResponse.clear();
    }

    public final void f(@NotNull LiveLikeView beLikeView2) {
        Intrinsics.checkNotNullParameter(beLikeView2, "beLikeView");
        beLikeView = new WeakReference<>(beLikeView2);
    }

    public final void g(boolean listScrolling) {
        isMsgListScrolling = listScrolling;
    }

    public final void h(@Nullable LiveOwnerLikeView ownerLikeView2) {
        ownerLikeView = new WeakReference<>(ownerLikeView2);
        if (ownerLikeView2 == null) {
            return;
        }
        ownerLikeView2.setAnimateStatusListener(new a());
    }

    public final void i() {
        WeakReference<LiveOwnerLikeView> weakReference;
        LiveOwnerLikeView liveOwnerLikeView;
        if (QLog.isDevelopLevel()) {
            QLog.d("LikeTouchManager", 4, "triggerLike");
        }
        MotionEvent motionEvent = curTouchEvent;
        if (motionEvent == null || roomId == 0 || (weakReference = ownerLikeView) == null || (liveOwnerLikeView = weakReference.get()) == null || !liveOwnerLikeView.l()) {
            return;
        }
        if (comboing) {
            liveOwnerLikeView.m(motionEvent.getX(), motionEvent.getY());
        } else if (o.e("live_like", liveOwnerLikeView.g())) {
            liveOwnerLikeView.m(motionEvent.getX(), motionEvent.getY());
        }
    }

    public final void j() {
        if (isMsgListScrolling) {
            return;
        }
        i();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/like/f$a", "Lcom/tencent/icgame/game/liveroom/impl/room/like/LiveOwnerLikeView$a;", "", "onComboStart", "onComboEnd", "onAnimateEnd", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements LiveOwnerLikeView.a {
        a() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.like.LiveOwnerLikeView.a
        public void onComboEnd() {
            f.comboing = false;
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.like.LiveOwnerLikeView.a
        public void onComboStart() {
            LiveLikeView liveLikeView;
            f.comboing = true;
            WeakReference weakReference = f.beLikeView;
            if (weakReference != null && (liveLikeView = (LiveLikeView) weakReference.get()) != null) {
                liveLikeView.u();
            }
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.like.LiveOwnerLikeView.a
        public void onAnimateEnd() {
        }
    }
}
