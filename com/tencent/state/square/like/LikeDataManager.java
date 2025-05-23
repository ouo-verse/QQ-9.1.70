package com.tencent.state.square.like;

import android.util.Log;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasStatusSquareService;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquarePushListener;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.detail.event.DetailGuestUpdateStickersEvent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\u0014J\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u0014J\b\u0010\u001e\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/square/like/LikeDataManager;", "", "()V", "ENABLE_SQUARE_STRANGER_LIKE", "", "TAG", "", "likeDataChangeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/state/square/like/ILikeDataChangeListener;", "likeListInfo", "Lcom/tencent/state/square/like/LikeListInfo;", "likeService", "Lcom/tencent/state/square/like/LikeService;", "pushListener", "com/tencent/state/square/like/LikeDataManager$pushListener$1", "Lcom/tencent/state/square/like/LikeDataManager$pushListener$1;", "pushService", "Lcom/tencent/state/square/api/ISquarePushService;", "addDataListener", "", "ls", "clearLikeList", "getLikeListInfo", "init", "notifyChange", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "refreshStickers", "removeDataListener", "reportReadLikeList", WebViewPlugin.KEY_REQUEST, "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LikeDataManager {
    public static final boolean ENABLE_SQUARE_STRANGER_LIKE = false;
    private static final String TAG = "LikeDataManager";
    private static LikeListInfo likeListInfo;
    private static ISquarePushService pushService;
    public static final LikeDataManager INSTANCE = new LikeDataManager();
    private static final LikeService likeService = new LikeService();
    private static final CopyOnWriteArrayList<ILikeDataChangeListener> likeDataChangeListeners = new CopyOnWriteArrayList<>();
    private static final LikeDataManager$pushListener$1 pushListener = new ISquarePushListener() { // from class: com.tencent.state.square.like.LikeDataManager$pushListener$1
        @Override // com.tencent.state.square.api.ISquarePushListener
        public void onResult(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            SquareBaseKt.getSquareLog().i("LikeDataManager", "receive push");
            LikeDataManager.INSTANCE.requestData();
        }
    };

    LikeDataManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyChange() {
        Iterator<T> it = likeDataChangeListeners.iterator();
        while (it.hasNext()) {
            ((ILikeDataChangeListener) it.next()).onDataChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestData() {
        likeService.getLikeList(new Function2<LikeListInfo, Integer, Unit>() { // from class: com.tencent.state.square.like.LikeDataManager$requestData$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LikeListInfo likeListInfo2, Integer num) {
                invoke(likeListInfo2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LikeListInfo likeListInfo2, int i3) {
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getLikeList result, empty=");
                sb5.append(likeListInfo2 == null);
                sb5.append(", errCode:");
                sb5.append(i3);
                squareLog.i("LikeDataManager", sb5.toString());
                if (likeListInfo2 == null || i3 != 0) {
                    return;
                }
                LikeDataManager likeDataManager = LikeDataManager.INSTANCE;
                LikeDataManager.likeListInfo = likeListInfo2;
                likeDataManager.notifyChange();
            }
        });
        refreshStickers();
    }

    public final void addDataListener(ILikeDataChangeListener ls5) {
        Intrinsics.checkNotNullParameter(ls5, "ls");
        likeDataChangeListeners.addIfAbsent(ls5);
    }

    public final void clearLikeList() {
        reportReadLikeList();
        likeListInfo = null;
    }

    public final LikeListInfo getLikeListInfo() {
        return likeListInfo;
    }

    public final void init(ISquarePushService pushService2) {
        Intrinsics.checkNotNullParameter(pushService2, "pushService");
        pushService = pushService2;
        requestData();
        pushService2.addListener(3, pushListener);
    }

    public final void onDestroy() {
        ISquarePushService iSquarePushService = pushService;
        if (iSquarePushService != null) {
            iSquarePushService.removeListener(3, pushListener);
        }
        likeDataChangeListeners.clear();
    }

    public final void refreshStickers() {
        Log.d(TAG, "refresh stickers");
        VasStatusSquareService.INSTANCE.getStickers(new ResultCallback<Stickers>() { // from class: com.tencent.state.square.like.LikeDataManager$refreshStickers$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(Stickers result) {
                Log.d("LikeDataManager", "refresh stickers done with " + result);
                if (result != null) {
                    SimpleEventBus.getInstance().dispatchEvent(new DetailGuestUpdateStickersEvent(SquareBaseKt.getSquareCommon().getCurrentAccountUin(), result));
                }
            }
        });
    }

    public final void removeDataListener(ILikeDataChangeListener ls5) {
        Intrinsics.checkNotNullParameter(ls5, "ls");
        likeDataChangeListeners.remove(ls5);
    }

    public final void reportReadLikeList() {
        LikeListInfo likeListInfo2;
        LikeListInfo likeListInfo3 = likeListInfo;
        if ((likeListInfo3 == null || likeListInfo3.getUnReadCount() != 0) && ((likeListInfo2 = likeListInfo) == null || !likeListInfo2.getHasReaded())) {
            likeService.readLikeList(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.like.LikeDataManager$reportReadLikeList$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    SquareBaseKt.getSquareLog().i("LikeDataManager", "reportReadedLikeList, result:" + i3);
                }
            });
        }
        LikeListInfo likeListInfo4 = likeListInfo;
        if (likeListInfo4 != null) {
            likeListInfo4.setHasReaded(true);
        }
        notifyChange();
    }
}
