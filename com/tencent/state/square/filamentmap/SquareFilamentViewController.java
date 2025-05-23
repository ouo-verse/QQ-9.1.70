package com.tencent.state.square.filamentmap;

import androidx.core.app.NotificationCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.v2.IMap;
import com.tencent.state.map.v2.IMapListener;
import com.tencent.state.map.v2.IMapObject;
import com.tencent.state.map.v2.IMapObjectKt;
import com.tencent.state.map.v2.MapError;
import com.tencent.state.map.v2.ObjectParams;
import com.tencent.state.map.v2.ObjectState;
import com.tencent.state.map.v2.ViewportInfo;
import com.tencent.state.map.v2.filament.FilamentMap;
import com.tencent.state.map.v2.filament.FilamentMapObjectParams;
import com.tencent.state.map.v2.filament.FilamentMapObjectUpdateResourceParams;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.FilamentDataUtilsKt;
import com.tencent.state.square.filamentmap.IFilamentMapController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 A2\u00020\u0001:\u0001AB2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u001b\u001a\u00020\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dH\u0002JX\u0010\u001e\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00062F\u0010\u001f\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0019H\u0016Jh\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2F\u0010&\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0019H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010!\u001a\u00020\u0012H\u0016J\b\u0010)\u001a\u00020\u0017H\u0016Jb\u0010*\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020(2F\u0010&\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0019H\u0016J\u0010\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0013H\u0016J\b\u0010.\u001a\u00020/H\u0016J\u001f\u00100\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u00010/H\u0016\u00a2\u0006\u0002\u00102J\b\u00103\u001a\u00020\u0017H\u0016J\b\u00104\u001a\u00020\u0017H\u0016J\u0010\u00105\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0012H\u0016J`\u00107\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00062\u0006\u00108\u001a\u00020(2F\u00109\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0019H\u0016J`\u00107\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00122\u0006\u00108\u001a\u00020(2F\u00109\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0019H\u0016J\u0010\u0010:\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020=H\u0016J`\u0010>\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00062\u0006\u00108\u001a\u00020(2F\u0010&\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0019H\u0016J`\u0010?\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00122\u0006\u00108\u001a\u00020(2F\u0010&\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0019H\u0016J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u0006H\u0016R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\\\u0010\u0010\u001aP\u0012\u0004\u0012\u00020\u0012\u0012F\u0012D\u0012@\u0012>\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00170\u0014j\b\u0012\u0004\u0012\u00020\u0017`\u00190\u00130\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\\\u0010\u001a\u001aP\u0012\u0004\u0012\u00020\u0012\u0012F\u0012D\u0012@\u0012>\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00170\u0014j\b\u0012\u0004\u0012\u00020\u0017`\u00190\u00130\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/tencent/state/square/filamentmap/SquareFilamentViewController;", "Lcom/tencent/state/square/filamentmap/IFilamentMapController;", "map", "Lcom/tencent/state/square/filamentmap/SquareFilamentMapView;", "getItemLocation", "Lkotlin/Function1;", "Lcom/tencent/state/map/MapItem;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/map/Location;", "(Lcom/tencent/state/square/filamentmap/SquareFilamentMapView;Lkotlin/jvm/functions/Function1;)V", "getGetItemLocation", "()Lkotlin/jvm/functions/Function1;", "getMap", "()Lcom/tencent/state/square/filamentmap/SquareFilamentMapView;", "onObjectAddedListeners", "", "", "", "Lkotlin/Function2;", "Lcom/tencent/state/map/v2/MapError;", NotificationCompat.CATEGORY_ERROR, "", "data", "Lcom/tencent/state/map/v2/MapCallback;", "onObjectRemovedListeners", "actionMapReady", "action", "Lkotlin/Function0;", "appendItem", "onAdded", "avatarMoveTo", "id", "targetLocation", "Lcom/tencent/state/map/v2/Location;", "duration", "", "callback", "checkInScreen", "", "cleanStopAvatar", "ensureAvatarPlay", "mapItem", "play", "getAvatarList", "getPlayingCount", "", "interaction", "mapZoomLevel", "(Lcom/tencent/state/map/MapItem;Ljava/lang/Integer;)V", "onBackFromDetail", "onGoToDetail", "playAvatarByData", "playAvatarById", "removeItem", "waitForAnimationEnd", "onRemoved", "resetItemLocation", "startViewAlpha", c.f123400v, "", "stopAvatarByData", "stopAvatarById", "updateItem", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareFilamentViewController implements IFilamentMapController {
    private static final String TAG = "SquareFilamentViewController";
    private final Function1<MapItem, Location> getItemLocation;
    private final SquareFilamentMapView map;
    private final Map<String, List<Function2<MapError, Unit, Unit>>> onObjectAddedListeners;
    private final Map<String, List<Function2<MapError, Unit, Unit>>> onObjectRemovedListeners;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ObjectState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ObjectState.REMOVED.ordinal()] = 1;
            iArr[ObjectState.LOADED.ordinal()] = 2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SquareFilamentViewController(SquareFilamentMapView map, Function1<? super MapItem, Location> getItemLocation) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(getItemLocation, "getItemLocation");
        this.map = map;
        this.getItemLocation = getItemLocation;
        FilamentMap container = map.getContainer();
        if (container != null) {
            container.addMapListener(new IMapListener() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController.2
                @Override // com.tencent.state.map.v2.IMapListener
                public void onObjectStateChanged(String id5, ObjectState state) {
                    Intrinsics.checkNotNullParameter(id5, "id");
                    Intrinsics.checkNotNullParameter(state, "state");
                    int i3 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                    if (i3 == 1) {
                        synchronized (SquareFilamentViewController.this.onObjectRemovedListeners) {
                            List<Function2> list = (List) SquareFilamentViewController.this.onObjectRemovedListeners.get(id5);
                            if (list != null) {
                                for (final Function2 function2 : list) {
                                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$2$onObjectStateChanged$1$1$1
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
                                            Function2.this.invoke(null, Unit.INSTANCE);
                                        }
                                    });
                                }
                            }
                        }
                        return;
                    }
                    if (i3 != 2) {
                        return;
                    }
                    synchronized (SquareFilamentViewController.this.onObjectAddedListeners) {
                        List<Function2> list2 = (List) SquareFilamentViewController.this.onObjectAddedListeners.get(id5);
                        if (list2 != null) {
                            for (final Function2 function22 : list2) {
                                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$2$onObjectStateChanged$2$1$1
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
                                        Function2.this.invoke(null, Unit.INSTANCE);
                                    }
                                });
                            }
                        }
                    }
                }

                @Override // com.tencent.state.map.v2.IMapListener
                public void onViewportChanged(ViewportInfo info) {
                    Intrinsics.checkNotNullParameter(info, "info");
                }

                @Override // com.tencent.state.map.v2.IMapListener
                public void onEngineRenderRecovered() {
                }

                @Override // com.tencent.state.map.v2.IMapListener
                public void onMapReady() {
                }
            });
        }
        this.onObjectRemovedListeners = new LinkedHashMap();
        this.onObjectAddedListeners = new LinkedHashMap();
    }

    private final void actionMapReady(Function0<Unit> action) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new SquareFilamentViewController$actionMapReady$1(this, action, null), 3, null);
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void appendItem(final MapItem item, final Function2<? super MapError, ? super Unit, Unit> onAdded) {
        Intrinsics.checkNotNullParameter(item, "item");
        final FilamentMapObjectParams formatFilamentObject = FilamentDataUtilsKt.formatFilamentObject(item);
        if (formatFilamentObject == null || checkInScreen(formatFilamentObject.getId())) {
            return;
        }
        actionMapReady(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$appendItem$1
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
                List plus;
                Location invoke = SquareFilamentViewController.this.getGetItemLocation().invoke(item);
                FilamentMap container = SquareFilamentViewController.this.getMap().getContainer();
                if (container != null) {
                    IMap.DefaultImpls.addObject$default(container, FilamentMapObjectParams.copy$default(formatFilamentObject, null, null, new com.tencent.state.map.v2.Location(invoke.getX(), invoke.getY()), null, null, 0.0f, 59, null), null, 2, null);
                }
                if (onAdded != null) {
                    String filamentId = FilamentDataUtilsKt.getFilamentId(item);
                    synchronized (SquareFilamentViewController.this.onObjectAddedListeners) {
                        Map map = SquareFilamentViewController.this.onObjectAddedListeners;
                        List list = (List) SquareFilamentViewController.this.onObjectAddedListeners.get(filamentId);
                        if (list == null) {
                            list = CollectionsKt__CollectionsKt.emptyList();
                        }
                        plus = CollectionsKt___CollectionsKt.plus((Collection<? extends Function2>) ((Collection<? extends Object>) list), onAdded);
                        map.put(filamentId, plus);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        });
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void avatarMoveTo(String id5, com.tencent.state.map.v2.Location targetLocation, long duration, Function2<? super MapError, ? super Unit, Unit> callback) {
        IMapObject object;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(targetLocation, "targetLocation");
        FilamentMap container = this.map.getContainer();
        if (container == null || (object = container.getObject(id5)) == null) {
            return;
        }
        object.moveTo(targetLocation, duration, callback);
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public boolean checkInScreen(String id5) {
        IMapObject object;
        ObjectState state;
        Intrinsics.checkNotNullParameter(id5, "id");
        FilamentMap container = this.map.getContainer();
        return (container == null || (object = container.getObject(id5)) == null || (state = object.getState()) == null || !IMapObjectKt.isInScreen(state)) ? false : true;
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void cleanStopAvatar() {
        ArrayList arrayList;
        List<IMapObject> allObjects;
        int collectionSizeOrDefault;
        FilamentMap container = this.map.getContainer();
        if (container == null || (allObjects = container.getAllObjects()) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : allObjects) {
                if (!((IMapObject) obj).getIsPlaying()) {
                    arrayList2.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(((IMapObject) it.next()).getObjectParams().getId());
            }
        }
        SquareBaseKt.getSquareLog().i(TAG, "cleanStopAvatar: ids=" + arrayList);
        if (arrayList != null) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                IFilamentMapController.DefaultImpls.removeItem$default((IFilamentMapController) this, (String) it5.next(), false, (Function2) null, 6, (Object) null);
            }
        }
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public List<String> getAvatarList() {
        FilamentMap container = this.map.getContainer();
        if (container != null) {
            return container.getCurrentObjectIds();
        }
        return null;
    }

    public final Function1<MapItem, Location> getGetItemLocation() {
        return this.getItemLocation;
    }

    public final SquareFilamentMapView getMap() {
        return this.map;
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public int getPlayingCount() {
        List<IMapObject> allObjects;
        FilamentMap container = this.map.getContainer();
        int i3 = 0;
        if (container != null && (allObjects = container.getAllObjects()) != null) {
            List<IMapObject> list = allObjects;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (IMapObjectKt.isInScreen(((IMapObject) it.next()).getState()) && (i3 = i3 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            }
        }
        return i3;
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void interaction(MapItem data, Integer mapZoomLevel) {
        IMapObject object;
        Intrinsics.checkNotNullParameter(data, "data");
        final String filamentId = FilamentDataUtilsKt.getFilamentId(data);
        if (mapZoomLevel != null && mapZoomLevel.intValue() == 0) {
            return;
        }
        if (checkInScreen(filamentId)) {
            FilamentMap container = this.map.getContainer();
            if (container == null || (object = container.getObject(filamentId)) == null) {
                return;
            }
            IMapObject.DefaultImpls.interaction$default(object, null, 1, null);
            return;
        }
        appendItem(data, new Function2<MapError, Unit, Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$interaction$1
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
                IMapObject object2;
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                FilamentMap container2 = SquareFilamentViewController.this.getMap().getContainer();
                if (container2 == null || (object2 = container2.getObject(filamentId)) == null) {
                    return;
                }
                object2.interaction(new Function2<MapError, Unit, Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$interaction$1.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(MapError mapError2, Unit unit2) {
                        invoke2(mapError2, unit2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(MapError mapError2, Unit unit2) {
                        Intrinsics.checkNotNullParameter(unit2, "<anonymous parameter 1>");
                        SquareFilamentViewController$interaction$1 squareFilamentViewController$interaction$1 = SquareFilamentViewController$interaction$1.this;
                        IFilamentMapController.DefaultImpls.removeItem$default((IFilamentMapController) SquareFilamentViewController.this, filamentId, false, (Function2) null, 6, (Object) null);
                    }
                });
            }
        });
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void onBackFromDetail() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void onGoToDetail() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void playAvatarByData(MapItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        SquareBaseKt.getSquareLog().i(TAG, "play: " + item.getUin());
        final String filamentId = FilamentDataUtilsKt.getFilamentId(item);
        actionMapReady(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$playAvatarByData$1
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
                SquareFilamentViewController.this.playAvatarById(filamentId);
            }
        });
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void playAvatarById(String id5) {
        IMapObject object;
        Intrinsics.checkNotNullParameter(id5, "id");
        FilamentMap container = this.map.getContainer();
        if (container == null || (object = container.getObject(id5)) == null) {
            return;
        }
        object.play();
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void removeItem(MapItem item, boolean waitForAnimationEnd, Function2<? super MapError, ? super Unit, Unit> onRemoved) {
        Intrinsics.checkNotNullParameter(item, "item");
        removeItem(FilamentDataUtilsKt.getFilamentId(item), waitForAnimationEnd, onRemoved);
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void resetItemLocation(final MapItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        final FilamentMapObjectParams formatFilamentObject = FilamentDataUtilsKt.formatFilamentObject(item);
        if (formatFilamentObject != null) {
            actionMapReady(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$resetItemLocation$1
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
                    IMapObject object;
                    Location invoke = SquareFilamentViewController.this.getGetItemLocation().invoke(item);
                    FilamentMap container = SquareFilamentViewController.this.getMap().getContainer();
                    if (container == null || (object = container.getObject(formatFilamentObject.getId())) == null) {
                        return;
                    }
                    object.moveTo(new com.tencent.state.map.v2.Location(invoke.getX(), invoke.getY()), 0L, null);
                }
            });
        }
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void startViewAlpha(float alpha) {
        this.map.setAlpha(alpha);
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void stopAvatarByData(MapItem item, final boolean waitForAnimationEnd, final Function2<? super MapError, ? super Unit, Unit> callback) {
        Intrinsics.checkNotNullParameter(item, "item");
        SquareBaseKt.getSquareLog().i(TAG, "stop: " + item.getUin() + ", waitForAnimationEnd: " + waitForAnimationEnd);
        final String filamentId = FilamentDataUtilsKt.getFilamentId(item);
        actionMapReady(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$stopAvatarByData$1
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
                SquareFilamentViewController.this.stopAvatarById(filamentId, waitForAnimationEnd, new Function2<MapError, Unit, Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$stopAvatarByData$1.1
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
                        Function2 function2 = callback;
                        if (function2 != null) {
                        }
                    }
                });
            }
        });
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void stopAvatarById(String id5, boolean waitForAnimationEnd, final Function2<? super MapError, ? super Unit, Unit> callback) {
        IMapObject object;
        Intrinsics.checkNotNullParameter(id5, "id");
        FilamentMap container = this.map.getContainer();
        if (container == null || (object = container.getObject(id5)) == null) {
            return;
        }
        object.stop(waitForAnimationEnd, new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$stopAvatarById$1
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
                Function2 function2 = Function2.this;
                if (function2 != null) {
                }
            }
        });
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void updateItem(final MapItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        final FilamentMapObjectUpdateResourceParams formatFilamentUpdateObject = FilamentDataUtilsKt.formatFilamentUpdateObject(item);
        if (formatFilamentUpdateObject != null) {
            actionMapReady(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$updateItem$1
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
                    List<String> listOf;
                    IMapObject object;
                    String id5 = formatFilamentUpdateObject.getId();
                    if (SquareFilamentViewController.this.checkInScreen(id5)) {
                        FilamentMap container = SquareFilamentViewController.this.getMap().getContainer();
                        if (container != null && (object = container.getObject(id5)) != null) {
                            IMapObject.DefaultImpls.updateResource$default(object, formatFilamentUpdateObject, null, 2, null);
                        }
                        SquareFilamentMapView map = SquareFilamentViewController.this.getMap();
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(id5);
                        map.playListener(listOf, false);
                        SquareBaseKt.getSquareLog().d("SquareFilamentViewController", "updateItem " + id5 + " : true");
                        return;
                    }
                    IFilamentMapController.DefaultImpls.removeItem$default((IFilamentMapController) SquareFilamentViewController.this, item, false, (Function2) null, 6, (Object) null);
                    SquareBaseKt.getSquareLog().d("SquareFilamentViewController", "updateItem " + id5 + " : false = out screen and do remove");
                }
            });
        }
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void removeItem(final String id5, final boolean waitForAnimationEnd, final Function2<? super MapError, ? super Unit, Unit> onRemoved) {
        Intrinsics.checkNotNullParameter(id5, "id");
        actionMapReady(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$removeItem$1
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
                List plus;
                FilamentMap container = SquareFilamentViewController.this.getMap().getContainer();
                if (container != null) {
                    container.removeObject(id5, waitForAnimationEnd);
                }
                if (waitForAnimationEnd && onRemoved != null) {
                    synchronized (SquareFilamentViewController.this.onObjectRemovedListeners) {
                        Map map = SquareFilamentViewController.this.onObjectRemovedListeners;
                        String str = id5;
                        List list = (List) SquareFilamentViewController.this.onObjectRemovedListeners.get(id5);
                        if (list == null) {
                            list = CollectionsKt__CollectionsKt.emptyList();
                        }
                        plus = CollectionsKt___CollectionsKt.plus((Collection<? extends Function2>) ((Collection<? extends Object>) list), onRemoved);
                        map.put(str, plus);
                        Unit unit = Unit.INSTANCE;
                    }
                    return;
                }
                Function2 function2 = onRemoved;
                if (function2 != null) {
                }
            }
        });
    }

    @Override // com.tencent.state.square.filamentmap.IFilamentMapController
    public void ensureAvatarPlay(final MapItem mapItem, final boolean play, final Function2<? super MapError, ? super Unit, Unit> callback) {
        if (mapItem != null) {
            actionMapReady(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$ensureAvatarPlay$1
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

                /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
                
                    if (r3 == true) goto L21;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2() {
                    IMapObject object;
                    boolean z16;
                    List<String> listOf;
                    String filamentId = FilamentDataUtilsKt.getFilamentId(mapItem);
                    if (play) {
                        if (SquareFilamentViewController.this.checkInScreen(filamentId)) {
                            FilamentMap container = SquareFilamentViewController.this.getMap().getContainer();
                            if (container == null || (object = container.getObject(filamentId)) == null) {
                                return;
                            }
                            FilamentMapObjectParams formatFilamentObject = FilamentDataUtilsKt.formatFilamentObject(mapItem);
                            if (formatFilamentObject != null) {
                                ObjectParams objectParams = object.getObjectParams();
                                if (!(objectParams instanceof FilamentMapObjectParams)) {
                                    objectParams = null;
                                }
                                FilamentMapObjectParams filamentMapObjectParams = (FilamentMapObjectParams) objectParams;
                                if (filamentMapObjectParams != null) {
                                    boolean isChange = filamentMapObjectParams.isChange(formatFilamentObject);
                                    z16 = true;
                                }
                            }
                            z16 = false;
                            if (z16) {
                                SquareFilamentViewController.this.updateItem(mapItem);
                                return;
                            }
                            object.play();
                            SquareFilamentMapView map = SquareFilamentViewController.this.getMap();
                            listOf = CollectionsKt__CollectionsJVMKt.listOf(filamentId);
                            map.playListener(listOf, false);
                            return;
                        }
                        SquareFilamentViewController.this.appendItem(mapItem, new Function2<MapError, Unit, Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$ensureAvatarPlay$1.1
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
                                Function2 function2 = callback;
                                if (function2 != null) {
                                }
                                SquareFilamentViewController.this.cleanStopAvatar();
                            }
                        });
                        return;
                    }
                    SquareFilamentViewController.this.stopAvatarByData(mapItem, false, new Function2<MapError, Unit, Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController$ensureAvatarPlay$1.2
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
                            Function2 function2 = callback;
                            if (function2 != null) {
                            }
                        }
                    });
                }
            });
        }
    }

    public /* synthetic */ SquareFilamentViewController(SquareFilamentMapView squareFilamentMapView, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(squareFilamentMapView, (i3 & 2) != 0 ? new Function1<MapItem, Location>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentViewController.1
            @Override // kotlin.jvm.functions.Function1
            public final Location invoke(MapItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getLocation();
            }
        } : function1);
    }
}
