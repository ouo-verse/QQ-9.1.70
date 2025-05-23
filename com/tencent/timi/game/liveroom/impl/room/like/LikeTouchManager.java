package com.tencent.timi.game.liveroom.impl.room.like;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tencent.timi.game.utils.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010!\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0017J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010$\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u000fJ\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0017H\u0002J\b\u0010'\u001a\u00020\u0010H\u0002J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0010J\u001c\u0010+\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0,J\u0006\u0010-\u001a\u00020)J\u000e\u0010.\u001a\u00020)2\u0006\u0010\n\u001a\u00020\fJ\u0016\u0010/\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u0010J\u0016\u00101\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u0010J\u000e\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u0010J\u0010\u00104\u001a\u00020)2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u00105\u001a\u00020)2\b\u0010\"\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LikeTouchManager;", "", "()V", "CLICK_AREA_BOTTOM_LAND", "", "CLICK_AREA_BOTTOM_PORT", "CLICK_AREA_TOP_LAND", "CLICK_AREA_TOP_PORT", "TAG", "", "beLikeView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/timi/game/liveroom/impl/room/like/LiveLikeView;", "busLikeEnableMap", "", "", "", "getBusLikeEnableMap", "()Ljava/util/Map;", "setBusLikeEnableMap", "(Ljava/util/Map;)V", "comboing", "curTouchEvent", "Landroid/view/MotionEvent;", MiniChatConstants.MINI_APP_LANDSCAPE, "isMsgListScrolling", "likeEnableMap", "ownerLikeView", "Lcom/tencent/timi/game/liveroom/impl/room/like/LiveOwnerLikeView;", "roomId", "viewsNotResponse", "", "Landroid/view/ViewGroup;", "dispatchTouchEvent", "ev", "enableLike", "enableLikeBus", "inClickArea", "event", "innerTriggerLike", "onConfigurationChanged", "", "isLandScape", "onEnterRoom", "", "onExitRoom", "setBeLikeView", "setEnableLike", "enable", "setEnableLikeBus", "setMsgListScrolling", "listScrolling", "setOwnerLikeView", "triggerLikeIfMsgListIdle", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class LikeTouchManager {

    @NotNull
    private static final String TAG = "Like_Biz|LikeTouchManager";

    @Nullable
    private static WeakReference<LiveLikeView> beLikeView;
    private static boolean comboing;

    @Nullable
    private static MotionEvent curTouchEvent;
    private static boolean isLandscape;
    private static boolean isMsgListScrolling;

    @Nullable
    private static WeakReference<LiveOwnerLikeView> ownerLikeView;
    private static long roomId;

    @NotNull
    public static final LikeTouchManager INSTANCE = new LikeTouchManager();
    private static int CLICK_AREA_TOP_PORT = com.tencent.timi.game.utils.b.a(120);
    private static int CLICK_AREA_BOTTOM_PORT = ViewUtils.getScreenHeight() - com.tencent.timi.game.utils.b.a(100);
    private static int CLICK_AREA_TOP_LAND = com.tencent.timi.game.utils.b.a(80);
    private static int CLICK_AREA_BOTTOM_LAND = ViewUtils.getScreenWidth() - com.tencent.timi.game.utils.b.a(80);

    @NotNull
    private static List<ViewGroup> viewsNotResponse = new ArrayList();

    @NotNull
    private static Map<Long, Boolean> likeEnableMap = new LinkedHashMap();

    @NotNull
    private static Map<Long, Boolean> busLikeEnableMap = new LinkedHashMap();

    LikeTouchManager() {
    }

    private final boolean inClickArea(MotionEvent event) {
        if (!isLandscape && event.getRawY() > CLICK_AREA_TOP_PORT && event.getRawY() < CLICK_AREA_BOTTOM_PORT) {
            return true;
        }
        if (isLandscape && event.getRawY() > CLICK_AREA_TOP_LAND && event.getRawY() < CLICK_AREA_BOTTOM_LAND) {
            return true;
        }
        AegisLogger.INSTANCE.d(TAG, "inClickArea", "\u4e0d\u5728\u70b9\u51fb\u8303\u56f4, x=" + event.getRawX() + ", y=" + event.getRawY());
        return false;
    }

    private final boolean innerTriggerLike() {
        WeakReference<LiveOwnerLikeView> weakReference;
        LiveOwnerLikeView liveOwnerLikeView;
        LiveOwnerLikeView liveOwnerLikeView2;
        long j3 = roomId;
        if (j3 != 0 && curTouchEvent != null && enableLike(j3)) {
            if (comboing) {
                WeakReference<LiveOwnerLikeView> weakReference2 = ownerLikeView;
                if (weakReference2 != null && (liveOwnerLikeView2 = weakReference2.get()) != null) {
                    AegisLogger.INSTANCE.i(TAG, "\u8fde\u51fb\u4e2d innerTriggerLike");
                    MotionEvent motionEvent = curTouchEvent;
                    Intrinsics.checkNotNull(motionEvent);
                    float x16 = motionEvent.getX();
                    MotionEvent motionEvent2 = curTouchEvent;
                    Intrinsics.checkNotNull(motionEvent2);
                    liveOwnerLikeView2.like(x16, motionEvent2.getY());
                    return true;
                }
            } else if (o.e("live_like", BusConfigHelper.f378723a.e(roomId)) && (weakReference = ownerLikeView) != null && (liveOwnerLikeView = weakReference.get()) != null) {
                AegisLogger.INSTANCE.i(TAG, "\u53cc\u51fb innerTriggerLike");
                MotionEvent motionEvent3 = curTouchEvent;
                Intrinsics.checkNotNull(motionEvent3);
                float x17 = motionEvent3.getX();
                MotionEvent motionEvent4 = curTouchEvent;
                Intrinsics.checkNotNull(motionEvent4);
                liveOwnerLikeView.like(x17, motionEvent4.getY());
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchTouchEvent(long roomId2, @NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (roomId2 != roomId || ev5.getAction() != 0) {
            return false;
        }
        curTouchEvent = MotionEvent.obtain(ev5);
        Iterator<T> it = viewsNotResponse.iterator();
        if (it.hasNext()) {
            ViewGroup viewGroup = (ViewGroup) it.next();
            if (ev5.getY() > viewGroup.getTop() && ev5.getY() < viewGroup.getBottom()) {
                LikeTouchManager likeTouchManager = INSTANCE;
                if (likeTouchManager.inClickArea(ev5)) {
                    return likeTouchManager.innerTriggerLike();
                }
            }
        }
        return false;
    }

    public final boolean enableLike(long roomId2) {
        Boolean bool = likeEnableMap.get(Long.valueOf(roomId2));
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final boolean enableLikeBus(long roomId2) {
        Boolean bool = busLikeEnableMap.get(Long.valueOf(roomId2));
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @NotNull
    public final Map<Long, Boolean> getBusLikeEnableMap() {
        return busLikeEnableMap;
    }

    public final void onConfigurationChanged(boolean isLandScape) {
        isLandscape = isLandScape;
    }

    public final void onEnterRoom(long roomId2, @NotNull List<? extends ViewGroup> viewsNotResponse2) {
        Intrinsics.checkNotNullParameter(viewsNotResponse2, "viewsNotResponse");
        AegisLogger.INSTANCE.i(TAG, "onEnterRoom, roomId:" + roomId2);
        roomId = roomId2;
        viewsNotResponse.clear();
        viewsNotResponse.addAll(viewsNotResponse2);
    }

    public final void onExitRoom() {
        LiveOwnerLikeView liveOwnerLikeView;
        AegisLogger.INSTANCE.i(TAG, "onExitRoom, roomId:" + roomId);
        viewsNotResponse.clear();
        WeakReference<LiveOwnerLikeView> weakReference = ownerLikeView;
        if (weakReference != null) {
            liveOwnerLikeView = weakReference.get();
        } else {
            liveOwnerLikeView = null;
        }
        if (liveOwnerLikeView != null) {
            liveOwnerLikeView.setAnimateStatusListener(null);
        }
        WeakReference<LiveOwnerLikeView> weakReference2 = ownerLikeView;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        WeakReference<LiveLikeView> weakReference3 = beLikeView;
        if (weakReference3 != null) {
            weakReference3.clear();
        }
        curTouchEvent = null;
        comboing = false;
        isLandscape = false;
    }

    public final void setBeLikeView(@NotNull LiveLikeView beLikeView2) {
        Intrinsics.checkNotNullParameter(beLikeView2, "beLikeView");
        beLikeView = new WeakReference<>(beLikeView2);
    }

    public final void setBusLikeEnableMap(@NotNull Map<Long, Boolean> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        busLikeEnableMap = map;
    }

    public final void setEnableLike(long roomId2, boolean enable) {
        likeEnableMap.put(Long.valueOf(roomId2), Boolean.valueOf(enable));
    }

    public final void setEnableLikeBus(long roomId2, boolean enable) {
        busLikeEnableMap.put(Long.valueOf(roomId2), Boolean.valueOf(enable));
    }

    public final void setMsgListScrolling(boolean listScrolling) {
        isMsgListScrolling = listScrolling;
    }

    public final void setOwnerLikeView(@Nullable LiveOwnerLikeView ownerLikeView2) {
        ownerLikeView = new WeakReference<>(ownerLikeView2);
        if (ownerLikeView2 != null) {
            ownerLikeView2.setAnimateStatusListener(new LiveOwnerLikeView.AnimateStatusListener() { // from class: com.tencent.timi.game.liveroom.impl.room.like.LikeTouchManager$setOwnerLikeView$1$1
                @Override // com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView.AnimateStatusListener
                public void onComboEnd() {
                    LikeTouchManager.comboing = false;
                }

                @Override // com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView.AnimateStatusListener
                public void onComboStart() {
                    WeakReference weakReference;
                    LiveLikeView liveLikeView;
                    LikeTouchManager.comboing = true;
                    weakReference = LikeTouchManager.beLikeView;
                    if (weakReference != null && (liveLikeView = (LiveLikeView) weakReference.get()) != null) {
                        liveLikeView.sendAvatarLike();
                    }
                }

                @Override // com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView.AnimateStatusListener
                public void onAnimateEnd() {
                }
            });
        }
    }

    public final void triggerLikeIfMsgListIdle(@Nullable MotionEvent ev5) {
        if (!isMsgListScrolling && ev5 != null) {
            LikeTouchManager likeTouchManager = INSTANCE;
            if (likeTouchManager.inClickArea(ev5)) {
                likeTouchManager.innerTriggerLike();
            }
        }
    }
}
