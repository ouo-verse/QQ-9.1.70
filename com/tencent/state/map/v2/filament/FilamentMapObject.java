package com.tencent.state.map.v2.filament;

import androidx.core.app.NotificationCompat;
import com.tencent.filament.zplan.scene.square.ObjectInteractionEvent;
import com.tencent.filament.zplan.scene.square.ObjectMoveToEvent;
import com.tencent.filament.zplan.scene.square.ObjectPlayEvent;
import com.tencent.filament.zplan.scene.square.ObjectResetEvent;
import com.tencent.filament.zplan.scene.square.ObjectStopEvent;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplan.scene.square.SquareInteractionEventData;
import com.tencent.filament.zplan.scene.square.SquareLoadObjectStatistics;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.state.map.v2.IMapObject;
import com.tencent.state.map.v2.Location;
import com.tencent.state.map.v2.MapError;
import com.tencent.state.map.v2.ObjectParams;
import com.tencent.state.map.v2.ObjectState;
import com.tencent.state.map.v2.ObjectType;
import com.tencent.state.map.v2.ObjectUpdateResourceParams;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001dH\u0016JP\u0010)\u001a\u00020\u00102F\u0010*\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J`\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.2F\u0010*\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0012H\u0016J\b\u0010/\u001a\u00020\u0010H\u0016J\b\u00100\u001a\u00020\u0010H\u0016J\u0018\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u001d2\b\u00103\u001a\u0004\u0018\u000104J \u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00142\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u000108H\u0016JX\u00109\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020:2F\u0010*\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0012H\u0016RN\u0010\n\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016RN\u0010\u0017\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006;"}, d2 = {"Lcom/tencent/state/map/v2/filament/FilamentMapObject;", "Lcom/tencent/state/map/v2/IMapObject;", "map", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/state/map/v2/filament/FilamentMap;", "params", "Lcom/tencent/state/map/v2/filament/FilamentMapObjectParams;", "interactionParams", "Lcom/tencent/filament/zplan/scene/square/SquareInteractionEventData;", "(Ljava/lang/ref/WeakReference;Lcom/tencent/state/map/v2/filament/FilamentMapObjectParams;Lcom/tencent/filament/zplan/scene/square/SquareInteractionEventData;)V", "interactionCallback", "Lkotlin/Function2;", "Lcom/tencent/state/map/v2/MapError;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_ERROR, "", "data", "Lcom/tencent/state/map/v2/MapCallback;", "isPlaying", "", "getMap", "()Ljava/lang/ref/WeakReference;", "moveToCallback", "getParams", "()Lcom/tencent/state/map/v2/filament/FilamentMapObjectParams;", "setParams", "(Lcom/tencent/state/map/v2/filament/FilamentMapObjectParams;)V", "state", "Lcom/tencent/state/map/v2/ObjectState;", "statistics", "Lcom/tencent/state/map/v2/filament/FilamentMapObjectStatistics;", "getStatistics", "()Lcom/tencent/state/map/v2/filament/FilamentMapObjectStatistics;", "setStatistics", "(Lcom/tencent/state/map/v2/filament/FilamentMapObjectStatistics;)V", "getMapLocation", "Lcom/tencent/state/map/v2/Location;", "getObjectParams", "Lcom/tencent/state/map/v2/ObjectParams;", "getState", "interaction", "callback", CanvasView.ACTION_MOVETO, "targetLocation", "duration", "", "play", "reset", "setState", "newState", "sceneLoadStatistics", "Lcom/tencent/filament/zplan/scene/square/SquareLoadObjectStatistics;", "stop", "waitForAnimationEnd", "onStopped", "Lkotlin/Function0;", "updateResource", "Lcom/tencent/state/map/v2/ObjectUpdateResourceParams;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FilamentMapObject implements IMapObject {
    private Function2<? super MapError, ? super Unit, Unit> interactionCallback;
    private SquareInteractionEventData interactionParams;
    private boolean isPlaying;
    private final WeakReference<FilamentMap> map;
    private Function2<? super MapError, ? super Unit, Unit> moveToCallback;
    private FilamentMapObjectParams params;
    private ObjectState state;
    private FilamentMapObjectStatistics statistics;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ObjectType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ObjectType.AVATAR.ordinal()] = 1;
            iArr[ObjectType.IMAGE.ordinal()] = 2;
        }
    }

    public FilamentMapObject(WeakReference<FilamentMap> map, FilamentMapObjectParams params, SquareInteractionEventData squareInteractionEventData) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(params, "params");
        this.map = map;
        this.params = params;
        this.interactionParams = squareInteractionEventData;
        this.state = ObjectState.WAITING;
        this.isPlaying = true;
        this.statistics = new FilamentMapObjectStatistics(null, null, 3, null);
    }

    public final WeakReference<FilamentMap> getMap() {
        return this.map;
    }

    @Override // com.tencent.state.map.v2.IMapObject
    public Location getMapLocation() {
        return this.params.getLocation();
    }

    @Override // com.tencent.state.map.v2.IMapObject
    public ObjectParams getObjectParams() {
        return this.params;
    }

    public final FilamentMapObjectParams getParams() {
        return this.params;
    }

    @Override // com.tencent.state.map.v2.IMapObject
    public ObjectState getState() {
        return this.state;
    }

    public final FilamentMapObjectStatistics getStatistics() {
        return this.statistics;
    }

    @Override // com.tencent.state.map.v2.IMapObject
    public void interaction(Function2<? super MapError, ? super Unit, Unit> callback) {
        if (this.interactionParams == null) {
            if (callback != null) {
                callback.invoke(null, Unit.INSTANCE);
                return;
            }
            return;
        }
        this.interactionCallback = callback;
        FilamentMap filamentMap = this.map.get();
        if (filamentMap != null) {
            String id5 = this.params.getId();
            SquareInteractionEventData squareInteractionEventData = this.interactionParams;
            SquareAvatarData.AvatarAnim hostAnim = squareInteractionEventData != null ? squareInteractionEventData.getHostAnim() : null;
            SquareInteractionEventData squareInteractionEventData2 = this.interactionParams;
            SquareAvatarData.AvatarAnim guestAnim = squareInteractionEventData2 != null ? squareInteractionEventData2.getGuestAnim() : null;
            SquareInteractionEventData squareInteractionEventData3 = this.interactionParams;
            filamentMap.dispatchToScene(new ObjectInteractionEvent(id5, hostAnim, guestAnim, squareInteractionEventData3 != null ? squareInteractionEventData3.getExtraAnimGltf() : null));
        }
    }

    @Override // com.tencent.state.map.v2.IMapObject
    /* renamed from: isPlaying, reason: from getter */
    public boolean getIsPlaying() {
        return this.isPlaying;
    }

    @Override // com.tencent.state.map.v2.IMapObject
    public void moveTo(Location targetLocation, long duration, Function2<? super MapError, ? super Unit, Unit> callback) {
        Intrinsics.checkNotNullParameter(targetLocation, "targetLocation");
        this.moveToCallback = callback;
        FilamentMap filamentMap = this.map.get();
        if (filamentMap != null) {
            filamentMap.dispatchToScene(new ObjectMoveToEvent(this.params.getId(), ModelsKt.toFilament(targetLocation), duration));
        }
    }

    @Override // com.tencent.state.map.v2.IMapObject
    public void play() {
        FilamentMap filamentMap = this.map.get();
        if (filamentMap != null) {
            filamentMap.cleanObjectAnimationEndTasks(this.params.getId());
        }
        FilamentMap filamentMap2 = this.map.get();
        if (filamentMap2 != null) {
            filamentMap2.dispatchToScene(new ObjectPlayEvent(this.params.getId()));
        }
        this.isPlaying = true;
    }

    @Override // com.tencent.state.map.v2.IMapObject
    public void reset() {
        FilamentMap filamentMap = this.map.get();
        if (filamentMap != null) {
            filamentMap.dispatchToScene(new ObjectResetEvent(this.params.getId()));
        }
    }

    public final void setParams(FilamentMapObjectParams filamentMapObjectParams) {
        Intrinsics.checkNotNullParameter(filamentMapObjectParams, "<set-?>");
        this.params = filamentMapObjectParams;
    }

    public final void setState(ObjectState newState, SquareLoadObjectStatistics sceneLoadStatistics) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        if (sceneLoadStatistics != null) {
            this.statistics.setSceneLoadStatistics(sceneLoadStatistics);
        }
        ObjectState objectState = this.state;
        ObjectState objectState2 = ObjectState.MOVING;
        if (objectState == objectState2 && newState != objectState2) {
            Function2<? super MapError, ? super Unit, Unit> function2 = this.moveToCallback;
            if (function2 != null) {
                function2.invoke(null, Unit.INSTANCE);
            }
            this.moveToCallback = null;
        }
        ObjectState objectState3 = this.state;
        ObjectState objectState4 = ObjectState.INTERACTING;
        if (objectState3 == objectState4 && newState != objectState4) {
            Function2<? super MapError, ? super Unit, Unit> function22 = this.interactionCallback;
            if (function22 != null) {
                function22.invoke(null, Unit.INSTANCE);
            }
            this.interactionCallback = null;
        }
        this.state = newState;
    }

    public final void setStatistics(FilamentMapObjectStatistics filamentMapObjectStatistics) {
        Intrinsics.checkNotNullParameter(filamentMapObjectStatistics, "<set-?>");
        this.statistics = filamentMapObjectStatistics;
    }

    @Override // com.tencent.state.map.v2.IMapObject
    public void stop(boolean waitForAnimationEnd, final Function0<Unit> onStopped) {
        if (waitForAnimationEnd) {
            String id5 = this.params.getId();
            final WeakReference weakReference = new WeakReference(this);
            FilamentMap filamentMap = this.map.get();
            if (filamentMap != null) {
                filamentMap.addObjectAnimationEndTask(id5, new Runnable() { // from class: com.tencent.state.map.v2.filament.FilamentMapObject$stop$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilamentMapObject filamentMapObject = (FilamentMapObject) weakReference.get();
                        if (filamentMapObject != null) {
                            filamentMapObject.stop(false, onStopped);
                        }
                    }
                });
                return;
            }
            return;
        }
        FilamentMap filamentMap2 = this.map.get();
        if (filamentMap2 != null) {
            filamentMap2.dispatchToScene(new ObjectStopEvent(this.params.getId()));
        }
        if (onStopped != null) {
            onStopped.invoke();
        }
        this.isPlaying = false;
    }

    @Override // com.tencent.state.map.v2.IMapObject
    public void updateResource(ObjectUpdateResourceParams params, Function2<? super MapError, ? super Unit, Unit> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        FilamentMapObjectUpdateResourceParams filamentMapObjectUpdateResourceParams = (FilamentMapObjectUpdateResourceParams) (!(params instanceof FilamentMapObjectUpdateResourceParams) ? null : params);
        if (filamentMapObjectUpdateResourceParams == null) {
            if (callback != null) {
                callback.invoke(new MapError(5, "Object update params invalid"), Unit.INSTANCE);
                return;
            }
            return;
        }
        FilamentMapObjectParams copy$default = FilamentMapObjectParams.copy$default(this.params, null, null, null, filamentMapObjectUpdateResourceParams.getAvatarResource(), filamentMapObjectUpdateResourceParams.getImageResource(), 0.0f, 39, null);
        if (copy$default.isValid()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FilamentMapObject$updateResource$1(this, params, copy$default, callback, null), 3, null);
        } else if (callback != null) {
            callback.invoke(new MapError(5, "Object params invalid"), Unit.INSTANCE);
        }
    }
}
