package com.tencent.state.map;

import android.graphics.Rect;
import android.view.View;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.SquareRuntime;
import com.tencent.state.map.v2.MapError;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.data.FilamentDataUtilsKt;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.filamentmap.IFilamentMapController;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.utils.SquareSwitchUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0016\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001QB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u001b2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0002J0\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u00112\u001c\b\u0002\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010#j\u0004\u0018\u0001`$H\u0004J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u001bH\u0004J\b\u0010'\u001a\u00020\u001bH\u0014J\b\u0010(\u001a\u00020\u0011H\u0002J\n\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0016\u0010+\u001a\b\u0012\u0002\b\u0003\u0018\u00010,2\u0006\u0010\u0019\u001a\u00020\u0011H\u0004J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110\tH\u0002J\b\u0010.\u001a\u00020\u001bH\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\rH\u0016J\b\u00102\u001a\u00020\u001bH\u0016J\u0010\u00103\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00104\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u001a\u00107\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0018\u00107\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u00020\rH\u0016J\u0018\u0010;\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\rH\u0002J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010?\u001a\u00020\u001bH\u0016J\u0018\u0010@\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\u0006\u0010A\u001a\u00020\rH\u0016J\u001a\u0010B\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\rH\u0016J\u0010\u0010E\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010F\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010G\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J-\u0010H\u001a\u0004\u0018\u00010\u00112\u001c\b\u0002\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010#j\u0004\u0018\u0001`$H\u0002\u00a2\u0006\u0002\u0010IJ\b\u0010J\u001a\u00020\u001bH\u0002J,\u0010K\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020\u00112\u001a\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010#j\u0004\u0018\u0001`$H\u0002J\u0010\u0010M\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010N\u001a\u00020\u001bH\u0002J\u001a\u0010O\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006R"}, d2 = {"Lcom/tencent/state/map/MapPlayManager;", "Lcom/tencent/state/map/IMapPlayManager;", "Lcom/tencent/state/map/IMapItemViewChangedListener;", "vm", "Lcom/tencent/state/map/IMapItemViewManager;", "(Lcom/tencent/state/map/IMapItemViewManager;)V", "callbackFastUtils", "Lcom/tencent/state/utils/FastClickUtils;", "delayLevels", "", "", "filamentDelayLevels", "isScaled", "", "isVisible", "needLoop", "playCountNumber", "", "getPlayCountNumber", "()I", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "Lkotlin/random/Random;", "getVm", "()Lcom/tencent/state/map/IMapItemViewManager;", "canPausePlay", "index", "checkIsMostPlayer", "", "clearInvisibleFilamentAvatar", "cb", "Lkotlin/Function0;", "enableFilamentIndex", "ensureAvatarPlay", "retryOnFailTimes", "condition", "Lkotlin/Function1;", "Lcom/tencent/state/map/PlayCondition;", "ensureIndexPlay", "ensureMePlay", "ensurePlay", "getCurrentPlayCount", "getFilamentMapController", "Lcom/tencent/state/square/filamentmap/IFilamentMapController;", "getViewHolder", "Lcom/tencent/state/map/MapPlayableViewHolder;", "getVisibleList", "initialize", "isPlaying", "onCenterScaled", "isCenterScaled", "onFilamentResume", "onInVisible", HippyQQPagView.EventName.ON_PLAY_END, "data", "Lcom/tencent/state/map/MapPlayableItem;", "onPlayFilament", "listener", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "needEnsurePlay", HippyQQPagView.EventName.ON_PLAY_START, "started", "onScreenIn", "onScreenOut", "onScrollIdled", "onStopFilament", "waitForAnimationEnd", "onUpdateFilament", "onVisibilityChanged", NodeProps.VISIBLE, "onVisible", "pauseAndEnsurePlay", "playByIndex", "randomIndex", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "randomPause", "randomPlay", "count", "removeItemWhenNotNeedLoop", "stopAll", "stopPlayByIndex", "isChangeSource", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class MapPlayManager implements IMapPlayManager, IMapItemViewChangedListener {
    private static final String TAG = "Square_MapPlayManager";
    private final FastClickUtils callbackFastUtils;
    private final List<Long> delayLevels;
    private final List<Long> filamentDelayLevels;
    private boolean isScaled;
    private boolean isVisible;
    private boolean needLoop;
    private final Random random;
    private final IMapItemViewManager vm;

    public MapPlayManager(IMapItemViewManager vm5) {
        List<Long> listOf;
        List<Long> listOf2;
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.vm = vm5;
        this.random = RandomKt.Random(System.currentTimeMillis());
        this.isVisible = true;
        this.callbackFastUtils = new FastClickUtils(50L);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Long[]{400L, 0L, 800L, 200L, 1000L, 600L});
        this.delayLevels = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Long[]{20L, 0L, 40L, 10L, 50L, 30L});
        this.filamentDelayLevels = listOf2;
    }

    private final void checkIsMostPlayer() {
        int currentPlayCount;
        int playCountNumber;
        if (!enableFilamentIndex() || (currentPlayCount = getCurrentPlayCount()) <= (playCountNumber = getPlayCountNumber())) {
            return;
        }
        int i3 = currentPlayCount - playCountNumber;
        for (int i16 = 0; i16 < i3; i16++) {
            randomPause();
        }
    }

    private final boolean enableFilamentIndex() {
        return SquareSwitchUtils.INSTANCE.enableFilamentIndex() && getFilamentMapController() != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void ensureIndexPlay(int index) {
        Resource userResource;
        boolean isPlaying = isPlaying(index);
        MapPlayableViewHolder<?> viewHolder = getViewHolder(index);
        if (viewHolder != null) {
            if (!isPlaying) {
                MapPlayableItem mapPlayableItem = (MapPlayableItem) viewHolder.getData();
                if (mapPlayableItem == null || (userResource = mapPlayableItem.getUserResource()) == null) {
                    return;
                }
                boolean z16 = (userResource.getIsDefault() || (!userResource.getIsDefault() && userResource.canPlay())) && !viewHolder.getIsPlayError();
                if (enableFilamentIndex()) {
                    z16 = z16 && this.vm.getVisibleIndexSet().contains(Integer.valueOf(index));
                }
                if (z16 && playByIndex(index)) {
                    checkIsMostPlayer();
                    return;
                }
                return;
            }
            playByIndex(index);
        }
    }

    private final int getCurrentPlayCount() {
        Set<Integer> visibleIndexSet = this.vm.getVisibleIndexSet();
        int i3 = 0;
        if (!(visibleIndexSet instanceof Collection) || !visibleIndexSet.isEmpty()) {
            Iterator<T> it = visibleIndexSet.iterator();
            while (it.hasNext()) {
                if (isPlaying(((Number) it.next()).intValue()) && (i3 = i3 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i3;
    }

    private final IFilamentMapController getFilamentMapController() {
        return this.vm.getFilamentMapController();
    }

    private final int getPlayCountNumber() {
        if (enableFilamentIndex()) {
            if (SquareRuntime.INSTANCE.hasNearbyMark() || (this.vm.getCurrentZoomLevel() != 0 && this.vm.getWelcomeScaleAnimDone())) {
                return Square.INSTANCE.getConfig().getCommonUtils().getFilamentPlayCountIncludeMe();
            }
            return 0;
        }
        return Square.INSTANCE.getConfig().getCommonUtils().getPlayCountIncludeMe();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<Integer> getVisibleList() {
        MapPlayableItem mapPlayableItem;
        Location location;
        Location location2;
        int i3;
        MapPlayableItem mapPlayableItem2;
        Rect itemViewLocation;
        Set<Integer> visibleIndexSet = this.vm.getVisibleIndexSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : visibleIndexSet) {
            MapPlayableViewHolder<?> viewHolder = getViewHolder(((Number) obj).intValue());
            boolean z16 = false;
            if (viewHolder != null && (mapPlayableItem = (MapPlayableItem) viewHolder.getData()) != null && (location = mapPlayableItem.getLocation()) != null) {
                int centerX = location.getCenterX();
                MapPlayableItem mapPlayableItem3 = (MapPlayableItem) viewHolder.getData();
                if (mapPlayableItem3 != null && (location2 = mapPlayableItem3.getLocation()) != null) {
                    int centerY = location2.getCenterY();
                    Set<Integer> visibleIndexSet2 = this.vm.getVisibleIndexSet();
                    if ((visibleIndexSet2 instanceof Collection) && visibleIndexSet2.isEmpty()) {
                        i3 = 0;
                    } else {
                        Iterator<T> it = visibleIndexSet2.iterator();
                        i3 = 0;
                        while (it.hasNext()) {
                            MapPlayableViewHolder<?> viewHolder2 = getViewHolder(((Number) it.next()).intValue());
                            if (((viewHolder2 == null || (mapPlayableItem2 = (MapPlayableItem) viewHolder2.getData()) == null || (itemViewLocation = mapPlayableItem2.getItemViewLocation()) == null || !itemViewLocation.contains(centerX, centerY)) ? false : true) && (i3 = i3 + 1) < 0) {
                                CollectionsKt__CollectionsKt.throwCountOverflow();
                            }
                        }
                    }
                    if (i3 <= 1) {
                        z16 = true;
                    }
                }
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean isPlaying(int index) {
        MapPlayableViewHolder<?> viewHolder = getViewHolder(index);
        if (viewHolder != null) {
            return viewHolder.isOccupy();
        }
        return false;
    }

    private final void onPlayStart(int i3, boolean z16) {
        MapPlayableViewHolder<?> viewHolder;
        View view;
        if (!Square.INSTANCE.getConfig().getCommonUtils().getSquareDebug() || !z16 || (viewHolder = getViewHolder(i3)) == null || (view = viewHolder.itemView) == null) {
            return;
        }
        view.setBackgroundColor(-16711936);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean playByIndex(int index) {
        MapPlayableViewHolder<?> viewHolder;
        MapPlayableItem mapPlayableItem;
        Resource userResource;
        List<Long> list;
        Object orNull;
        if (getPlayCountNumber() == 0 || index < 0 || (viewHolder = getViewHolder(index)) == null || (mapPlayableItem = (MapPlayableItem) viewHolder.getData()) == null || (userResource = mapPlayableItem.getUserResource()) == null) {
            return false;
        }
        if (enableFilamentIndex()) {
            list = this.filamentDelayLevels;
        } else {
            list = this.delayLevels;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, index % this.delayLevels.size());
        Long l3 = (Long) orNull;
        if (l3 == null) {
            return false;
        }
        boolean playOtherResource = viewHolder.playOtherResource(userResource, l3.longValue());
        viewHolder.getPlayerView().setLoopPlay(this.needLoop);
        onPlayStart(index, playOtherResource);
        return playOtherResource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Integer randomIndex(Function1<? super Integer, Boolean> condition) {
        Integer num;
        Object first;
        MapPlayableItem mapPlayableItem;
        Rect itemViewLocation;
        Location location;
        Location location2;
        Boolean invoke;
        Resource userResource;
        Set<Integer> visibleIndexSet = this.vm.getVisibleIndexSet();
        final ArrayList arrayList = new ArrayList();
        Iterator<T> it = visibleIndexSet.iterator();
        while (true) {
            num = null;
            num = null;
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int intValue = ((Number) next).intValue();
            MapPlayableViewHolder<?> viewHolder = getViewHolder(intValue);
            MapPlayableItem mapPlayableItem2 = viewHolder != null ? (MapPlayableItem) viewHolder.getData() : null;
            boolean z17 = !isPlaying(intValue);
            byte b16 = (mapPlayableItem2 == null || (userResource = mapPlayableItem2.getUserResource()) == null || !userResource.canPlay()) ? false : true;
            byte b17 = (viewHolder == null || viewHolder.getIsPlayError()) ? false : true;
            byte b18 = (viewHolder == null || viewHolder.getIsInAnim()) ? false : true;
            if (z17 && b16 != false) {
                if (((condition == null || (invoke = condition.invoke(Integer.valueOf(intValue))) == null) ? true : invoke.booleanValue()) && b17 != false && b18 != false) {
                    z16 = true;
                }
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!(!arrayList.isEmpty())) {
            return null;
        }
        int intValue2 = ((Number) arrayList.get(this.random.nextInt(arrayList.size()))).intValue();
        MapPlayableViewHolder<?> viewHolder2 = getViewHolder(intValue2);
        if (viewHolder2 != null) {
            MapPlayableItem mapPlayableItem3 = (MapPlayableItem) viewHolder2.getData();
            Integer valueOf = (mapPlayableItem3 == null || (location2 = mapPlayableItem3.getLocation()) == null) ? null : Integer.valueOf(location2.getCenterX());
            MapPlayableItem mapPlayableItem4 = (MapPlayableItem) viewHolder2.getData();
            if (mapPlayableItem4 != null && (location = mapPlayableItem4.getLocation()) != null) {
                num = Integer.valueOf(location.getCenterY());
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                MapPlayableViewHolder<?> viewHolder3 = getViewHolder(((Number) obj).intValue());
                boolean z18 = (valueOf == null || num == null || viewHolder3 == null || (mapPlayableItem = (MapPlayableItem) viewHolder3.getData()) == null || (itemViewLocation = mapPlayableItem.getItemViewLocation()) == null || !itemViewLocation.contains(valueOf.intValue(), num.intValue())) ? false : true;
                if (viewHolder3 != null) {
                    viewHolder3.setRepeat(z18);
                }
                if (z18) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.size() > 1) {
                CollectionsKt___CollectionsKt.sortedWith(arrayList2, new Comparator<T>() { // from class: com.tencent.state.map.MapPlayManager$randomIndex$$inlined$let$lambda$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t16, T t17) {
                        int compareValues;
                        MapPlayableItem mapPlayableItem5;
                        Location location3;
                        MapPlayableItem mapPlayableItem6;
                        Location location4;
                        MapPlayableViewHolder<?> viewHolder4 = MapPlayManager.this.getViewHolder(((Number) t17).intValue());
                        Integer num2 = null;
                        Integer valueOf2 = (viewHolder4 == null || (mapPlayableItem6 = (MapPlayableItem) viewHolder4.getData()) == null || (location4 = mapPlayableItem6.getLocation()) == null) ? null : Integer.valueOf(location4.getCenterY());
                        MapPlayableViewHolder<?> viewHolder5 = MapPlayManager.this.getViewHolder(((Number) t16).intValue());
                        if (viewHolder5 != null && (mapPlayableItem5 = (MapPlayableItem) viewHolder5.getData()) != null && (location3 = mapPlayableItem5.getLocation()) != null) {
                            num2 = Integer.valueOf(location3.getCenterY());
                        }
                        compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf2, num2);
                        return compareValues;
                    }
                });
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
                return (Integer) first;
            }
        }
        return Integer.valueOf(intValue2);
    }

    private final void randomPause() {
        Object randomOrNull;
        Set<Integer> visibleIndexSet = this.vm.getVisibleIndexSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : visibleIndexSet) {
            if (canPausePlay(((Number) obj).intValue())) {
                arrayList.add(obj);
            }
        }
        randomOrNull = CollectionsKt___CollectionsKt.randomOrNull(arrayList, Random.INSTANCE);
        Integer num = (Integer) randomOrNull;
        if (num != null) {
            stopPlayByIndex$default(this, num.intValue(), false, 2, null);
        }
    }

    public final void removeItemWhenNotNeedLoop(int index) {
        MapPlayableViewHolder<?> viewHolder;
        if (this.needLoop || index == this.vm.getMeIndex() || (viewHolder = getViewHolder(index)) == null) {
            return;
        }
        viewHolder.stopWaitForAnimationEnd();
    }

    private final void stopAll() {
        Iterator<T> it = this.vm.getInScreenIndexSet().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (isPlaying(intValue)) {
                MapPlayableViewHolder<?> viewHolder = getViewHolder(intValue);
                if (viewHolder != null) {
                    MapPlayableViewHolder.stop$default(viewHolder, false, 1, null);
                }
                onPlayEnd(intValue);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void stopPlayByIndex(int index, boolean isChangeSource) {
        MapPlayableItem mapPlayableItem;
        MapPlayableViewHolder<?> viewHolder = getViewHolder(index);
        if (viewHolder == null || (mapPlayableItem = (MapPlayableItem) viewHolder.getData()) == null) {
            return;
        }
        if (isChangeSource) {
            Resource userResource = mapPlayableItem.getUserResource();
            if (userResource != null) {
                viewHolder.changeSource(mapPlayableItem, userResource);
                return;
            }
            return;
        }
        MapPlayableViewHolder.stop$default(viewHolder, false, 1, null);
        onPlayEnd(mapPlayableItem);
    }

    public boolean canPausePlay(int index) {
        return isPlaying(index) && index != this.vm.getMeIndex();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.IMapPlayManager
    public void clearInvisibleFilamentAvatar(final Function0<Unit> cb5) {
        List<String> avatarList;
        int lastIndex;
        Object obj;
        MapPlayableItem mapPlayableItem;
        IFilamentMapController filamentMapController = getFilamentMapController();
        if (filamentMapController == null || (avatarList = filamentMapController.getAvatarList()) == null) {
            if (cb5 != null) {
                cb5.invoke();
                return;
            }
            return;
        }
        final ArrayList arrayList = new ArrayList();
        Iterator<T> it = avatarList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            Iterator<T> it5 = this.vm.getVisibleIndexSet().iterator();
            while (true) {
                obj = null;
                if (!it5.hasNext()) {
                    break;
                }
                Object next2 = it5.next();
                MapPlayableViewHolder<?> viewHolder = getViewHolder(((Number) next2).intValue());
                if (viewHolder != null && (mapPlayableItem = (MapPlayableItem) viewHolder.getData()) != null) {
                    obj = FilamentDataUtilsKt.getFilamentId(mapPlayableItem);
                }
                if (Intrinsics.areEqual(obj, str)) {
                    obj = next2;
                    break;
                }
            }
            if (obj == null) {
                arrayList.add(next);
            }
        }
        if (!(!arrayList.isEmpty())) {
            if (cb5 != null) {
                cb5.invoke();
                return;
            }
            return;
        }
        int i3 = 0;
        for (Object obj2 : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj2;
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            if (i3 == lastIndex) {
                IFilamentMapController filamentMapController2 = getFilamentMapController();
                if (filamentMapController2 != null) {
                    filamentMapController2.removeItem(str2, false, (Function2<? super MapError, ? super Unit, Unit>) new Function2<MapError, Unit, Unit>() { // from class: com.tencent.state.map.MapPlayManager$clearInvisibleFilamentAvatar$$inlined$forEachIndexed$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(MapError mapError, Unit unit) {
                            invoke2(mapError, unit);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(MapError mapError, Unit unit) {
                            Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.map.MapPlayManager$clearInvisibleFilamentAvatar$$inlined$forEachIndexed$lambda$1.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    Function0 function0 = cb5;
                                    if (function0 != null) {
                                    }
                                }
                            });
                        }
                    });
                }
            } else {
                IFilamentMapController filamentMapController3 = getFilamentMapController();
                if (filamentMapController3 != null) {
                    IFilamentMapController.DefaultImpls.removeItem$default(filamentMapController3, str2, false, (Function2) null, 6, (Object) null);
                }
            }
            i3 = i16;
        }
    }

    public final void ensureAvatarPlay(final int retryOnFailTimes, final Function1<? super Integer, Boolean> condition) {
        int i3;
        SquareAvatarView playerView;
        Set<Integer> visibleIndexSet = this.vm.getVisibleIndexSet();
        if ((visibleIndexSet instanceof Collection) && visibleIndexSet.isEmpty()) {
            i3 = 0;
        } else {
            Iterator<T> it = visibleIndexSet.iterator();
            i3 = 0;
            while (it.hasNext()) {
                MapPlayableViewHolder<?> viewHolder = getViewHolder(((Number) it.next()).intValue());
                if (((viewHolder == null || viewHolder.getIsInAnim()) ? false : true) && (i3 = i3 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        int playCountNumber = getPlayCountNumber();
        this.needLoop = i3 <= playCountNumber;
        Iterator<T> it5 = this.vm.getVisibleIndexSet().iterator();
        while (it5.hasNext()) {
            int intValue = ((Number) it5.next()).intValue();
            if (isPlaying(intValue)) {
                MapPlayableViewHolder<?> viewHolder2 = getViewHolder(intValue);
                if (viewHolder2 != null && (playerView = viewHolder2.getPlayerView()) != null) {
                    playerView.setLoopPlay(this.needLoop);
                }
                removeItemWhenNotNeedLoop(intValue);
            }
        }
        int currentPlayCount = getCurrentPlayCount();
        if (currentPlayCount < playCountNumber) {
            randomPlay(playCountNumber - currentPlayCount, condition);
        }
        checkIsMostPlayer();
        if (i3 != 0 || retryOnFailTimes <= 0) {
            return;
        }
        this.vm.checkRecycleAndFill();
        SquareBaseKt.getSquareThread().postOnUiDelayed(50L, new Function0<Unit>() { // from class: com.tencent.state.map.MapPlayManager$ensureAvatarPlay$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MapPlayManager.this.ensureAvatarPlay(retryOnFailTimes - 1, condition);
            }
        });
    }

    public final void ensureMePlay() {
        ensureIndexPlay(this.vm.getMeIndex());
    }

    public final MapPlayableViewHolder<?> getViewHolder(int index) {
        MapViewHolder<?> viewHolder = this.vm.getViewHolder(index);
        if (!(viewHolder instanceof MapPlayableViewHolder)) {
            viewHolder = null;
        }
        return (MapPlayableViewHolder) viewHolder;
    }

    public final IMapItemViewManager getVm() {
        return this.vm;
    }

    @Override // com.tencent.state.map.IMapPlayManager
    public void initialize() {
        this.vm.setViewChangedListener(this);
        if (enableFilamentIndex()) {
            return;
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.map.MapPlayManager$initialize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MapPlayManager.this.ensurePlay();
            }
        });
    }

    @Override // com.tencent.state.map.IMapPlayManager
    public void onCenterScaled(boolean isCenterScaled) {
        this.isScaled = isCenterScaled;
        if (this.isVisible && !isCenterScaled) {
            ensurePlay();
        } else {
            stopAll();
        }
    }

    @Override // com.tencent.state.map.IMapPlayManager
    public void onFilamentResume() {
        if (enableFilamentIndex()) {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.map.MapPlayManager$onFilamentResume$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    boolean z16;
                    boolean z17;
                    z16 = MapPlayManager.this.isVisible;
                    if (z16) {
                        z17 = MapPlayManager.this.isScaled;
                        if (z17 || !MapPlayManager.this.getVm().getWelcomeScaleAnimDone()) {
                            return;
                        }
                        MapPlayManager.this.ensurePlay();
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.map.IMapItemViewChangedListener
    public void onInVisible(int index) {
        MapViewHolder<?> viewHolder = this.vm.getViewHolder(index);
        if (viewHolder != null) {
            viewHolder.onInVisible();
        }
        MapPlayableViewHolder<?> viewHolder2 = getViewHolder(index);
        if (viewHolder2 != null) {
            MapPlayableViewHolder.stop$default(viewHolder2, false, 1, null);
        }
    }

    @Override // com.tencent.state.map.IMapPlayManager
    public void onPlayEnd(MapPlayableItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        onPlayEnd(this.vm.indexOf(data));
        if (!this.isVisible || this.isScaled) {
            return;
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.map.MapPlayManager$onPlayEnd$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MapPlayManager.this.ensurePlay();
            }
        });
    }

    @Override // com.tencent.state.map.IMapPlayManager
    public void onPlayFilament(MapPlayableItem data, boolean needEnsurePlay) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (SquareSwitchUtils.INSTANCE.enableFilamentIndex()) {
            if (this.isVisible && !this.isScaled) {
                this.vm.checkRecycleAndFill();
            }
            int indexOf = this.vm.indexOf(data);
            if (this.vm.getVisibleIndexSet().contains(Integer.valueOf(indexOf))) {
                if (needEnsurePlay) {
                    ensureIndexPlay(indexOf);
                } else {
                    ensurePlay();
                }
            }
        }
    }

    @Override // com.tencent.state.map.IMapItemViewChangedListener
    public void onScreenIn(int index) {
        if (!enableFilamentIndex() && index == this.vm.getMeIndex()) {
            ensureMePlay();
        }
    }

    @Override // com.tencent.state.map.IMapItemViewChangedListener
    public void onScreenOut(int index) {
        onPlayEnd(index);
    }

    @Override // com.tencent.state.map.IMapPlayManager
    public void onScrollIdled() {
        if (enableFilamentIndex()) {
            return;
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.map.MapPlayManager$onScrollIdled$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MapPlayManager.this.ensurePlay();
            }
        });
    }

    @Override // com.tencent.state.map.IMapPlayManager
    public void onStopFilament(final MapPlayableItem data, boolean waitForAnimationEnd) {
        IFilamentMapController filamentMapController;
        Intrinsics.checkNotNullParameter(data, "data");
        if (SquareSwitchUtils.INSTANCE.enableFilamentIndex() && (filamentMapController = getFilamentMapController()) != null) {
            if (waitForAnimationEnd) {
                filamentMapController.stopAvatarByData(data, true, new Function2<MapError, Unit, Unit>() { // from class: com.tencent.state.map.MapPlayManager$onStopFilament$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(MapError mapError, Unit unit) {
                        invoke2(mapError, unit);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(MapError mapError, Unit unit) {
                        Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.map.MapPlayManager$onStopFilament$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                FastClickUtils fastClickUtils;
                                fastClickUtils = MapPlayManager.this.callbackFastUtils;
                                if (fastClickUtils.isFastDoubleClick()) {
                                    return;
                                }
                                MapPlayManager mapPlayManager = MapPlayManager.this;
                                MapPlayableViewHolder<?> viewHolder = mapPlayManager.getViewHolder(mapPlayManager.getVm().indexOf(data));
                                if (viewHolder != null) {
                                    viewHolder.stop(false);
                                }
                                MapPlayManager$onStopFilament$1 mapPlayManager$onStopFilament$1 = MapPlayManager$onStopFilament$1.this;
                                MapPlayManager.this.onPlayEnd(data);
                            }
                        });
                    }
                });
            } else {
                IFilamentMapController.DefaultImpls.removeItem$default(filamentMapController, (MapItem) data, false, (Function2) null, 6, (Object) null);
            }
        }
    }

    @Override // com.tencent.state.map.IMapPlayManager
    public void onUpdateFilament(MapPlayableItem data, IAvatarAnimListener listener) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (SquareSwitchUtils.INSTANCE.enableFilamentIndex()) {
            IFilamentMapController filamentMapController = getFilamentMapController();
            if (filamentMapController != null) {
                filamentMapController.updateItem(data);
            }
            IFilamentMapController filamentMapController2 = getFilamentMapController();
            if (filamentMapController2 == null || !filamentMapController2.checkInScreen(FilamentDataUtilsKt.getFilamentId(data)) || listener == null) {
                return;
            }
            listener.onPlayStart();
        }
    }

    @Override // com.tencent.state.map.IMapPlayManager
    public void onVisibilityChanged(boolean r16) {
        this.isVisible = r16;
        if (r16 && !this.isScaled) {
            ensurePlay();
        } else {
            stopAll();
        }
    }

    @Override // com.tencent.state.map.IMapItemViewChangedListener
    public void onVisible(int index) {
        MapViewHolder<?> viewHolder = this.vm.getViewHolder(index);
        if (viewHolder != null) {
            viewHolder.onVisible();
        }
        if (enableFilamentIndex() && index == this.vm.getMeIndex()) {
            ensureMePlay();
        }
    }

    @Override // com.tencent.state.map.IMapPlayManager
    public void pauseAndEnsurePlay(int index) {
        Object obj;
        Iterator<T> it = this.vm.getVisibleIndexSet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((Number) obj).intValue() == index) {
                    break;
                }
            }
        }
        if (((Integer) obj) == null) {
            return;
        }
        if (isPlaying(index)) {
            stopPlayByIndex(index, true);
        } else {
            randomPause();
        }
    }

    private final void randomPlay(int count, Function1<? super Integer, Boolean> condition) {
        int i3 = 0;
        while (i3 < count) {
            Integer randomIndex = randomIndex(condition);
            if (randomIndex == null) {
                return;
            }
            if (playByIndex(randomIndex.intValue())) {
                i3++;
            }
        }
    }

    public void ensurePlay() {
        ensureAvatarPlay$default(this, 0, null, 3, null);
    }

    private final void onPlayEnd(int i3) {
        MapPlayableViewHolder<?> viewHolder;
        View view;
        if (!Square.INSTANCE.getConfig().isDebug() || (viewHolder = getViewHolder(i3)) == null || (view = viewHolder.itemView) == null) {
            return;
        }
        view.setBackgroundColor(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Integer randomIndex$default(MapPlayManager mapPlayManager, Function1 function1, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                function1 = null;
            }
            return mapPlayManager.randomIndex(function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: randomIndex");
    }

    static /* synthetic */ void stopPlayByIndex$default(MapPlayManager mapPlayManager, int i3, boolean z16, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                z16 = false;
            }
            mapPlayManager.stopPlayByIndex(i3, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopPlayByIndex");
    }

    @Override // com.tencent.state.map.IMapPlayManager
    public void onPlayFilament(final MapPlayableItem data, IAvatarAnimListener listener) {
        IFilamentMapController filamentMapController;
        Intrinsics.checkNotNullParameter(data, "data");
        if (SquareSwitchUtils.INSTANCE.enableFilamentIndex() && (filamentMapController = getFilamentMapController()) != null) {
            filamentMapController.ensureAvatarPlay(data, true, new Function2<MapError, Unit, Unit>() { // from class: com.tencent.state.map.MapPlayManager$onPlayFilament$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(MapError mapError, Unit unit) {
                    invoke2(mapError, unit);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MapError mapError, Unit unit) {
                    Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                    MapPlayManager mapPlayManager = MapPlayManager.this;
                    mapPlayManager.removeItemWhenNotNeedLoop(mapPlayManager.getVm().indexOf(data));
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ensureAvatarPlay$default(MapPlayManager mapPlayManager, int i3, Function1 function1, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                i3 = 1;
            }
            if ((i16 & 2) != 0) {
                function1 = null;
            }
            mapPlayManager.ensureAvatarPlay(i3, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureAvatarPlay");
    }
}
