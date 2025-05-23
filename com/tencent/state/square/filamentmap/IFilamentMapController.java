package com.tencent.state.square.filamentmap;

import androidx.core.app.NotificationCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.v2.Location;
import com.tencent.state.map.v2.MapError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JZ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052H\b\u0002\u0010\u0006\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\rH&Jj\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142H\b\u0002\u0010\u0015\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\rH&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0018\u001a\u00020\u0003H&Jd\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u00172H\b\u0002\u0010\u0015\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\rH&J\u0010\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001dH&J\b\u0010\u001e\u001a\u00020\u001fH&J\u001f\u0010 \u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u001fH&\u00a2\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&Jd\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00172H\b\u0002\u0010)\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\rH&Jd\u0010'\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010(\u001a\u00020\u00172H\b\u0002\u0010)\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\rH&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-H&Jd\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00172H\b\u0002\u0010\u0015\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\rH&Jd\u0010/\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010(\u001a\u00020\u00172H\b\u0002\u0010\u0015\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\rH&J\u0010\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u00061"}, d2 = {"Lcom/tencent/state/square/filamentmap/IFilamentMapController;", "", "appendItem", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/map/MapItem;", "onAdded", "Lkotlin/Function2;", "Lcom/tencent/state/map/v2/MapError;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_ERROR, "data", "Lcom/tencent/state/map/v2/MapCallback;", "avatarMoveTo", "id", "", "targetLocation", "Lcom/tencent/state/map/v2/Location;", "duration", "", "callback", "checkInScreen", "", "cleanStopAvatar", "ensureAvatarPlay", "mapItem", "play", "getAvatarList", "", "getPlayingCount", "", "interaction", "mapZoomLevel", "(Lcom/tencent/state/map/MapItem;Ljava/lang/Integer;)V", "onBackFromDetail", "onGoToDetail", "playAvatarByData", "playAvatarById", "removeItem", "waitForAnimationEnd", "onRemoved", "resetItemLocation", "startViewAlpha", c.f123400v, "", "stopAvatarByData", "stopAvatarById", "updateItem", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IFilamentMapController {
    void appendItem(MapItem item, Function2<? super MapError, ? super Unit, Unit> onAdded);

    void avatarMoveTo(String id5, Location targetLocation, long duration, Function2<? super MapError, ? super Unit, Unit> callback);

    boolean checkInScreen(String id5);

    void cleanStopAvatar();

    void ensureAvatarPlay(MapItem mapItem, boolean play, Function2<? super MapError, ? super Unit, Unit> callback);

    List<String> getAvatarList();

    int getPlayingCount();

    void interaction(MapItem data, Integer mapZoomLevel);

    void onBackFromDetail();

    void onGoToDetail();

    void playAvatarByData(MapItem item);

    void playAvatarById(String id5);

    void removeItem(MapItem item, boolean waitForAnimationEnd, Function2<? super MapError, ? super Unit, Unit> onRemoved);

    void removeItem(String id5, boolean waitForAnimationEnd, Function2<? super MapError, ? super Unit, Unit> onRemoved);

    void resetItemLocation(MapItem item);

    void startViewAlpha(float alpha);

    void stopAvatarByData(MapItem item, boolean waitForAnimationEnd, Function2<? super MapError, ? super Unit, Unit> callback);

    void stopAvatarById(String id5, boolean waitForAnimationEnd, Function2<? super MapError, ? super Unit, Unit> callback);

    void updateItem(MapItem item);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void removeItem$default(IFilamentMapController iFilamentMapController, MapItem mapItem, boolean z16, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    function2 = null;
                }
                iFilamentMapController.removeItem(mapItem, z16, (Function2<? super MapError, ? super Unit, Unit>) function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeItem");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void removeItem$default(IFilamentMapController iFilamentMapController, String str, boolean z16, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    function2 = null;
                }
                iFilamentMapController.removeItem(str, z16, (Function2<? super MapError, ? super Unit, Unit>) function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeItem");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void appendItem$default(IFilamentMapController iFilamentMapController, MapItem mapItem, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function2 = null;
                }
                iFilamentMapController.appendItem(mapItem, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendItem");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void ensureAvatarPlay$default(IFilamentMapController iFilamentMapController, MapItem mapItem, boolean z16, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    function2 = null;
                }
                iFilamentMapController.ensureAvatarPlay(mapItem, z16, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureAvatarPlay");
        }

        public static /* synthetic */ void avatarMoveTo$default(IFilamentMapController iFilamentMapController, String str, Location location, long j3, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    function2 = null;
                }
                iFilamentMapController.avatarMoveTo(str, location, j3, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: avatarMoveTo");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void stopAvatarByData$default(IFilamentMapController iFilamentMapController, MapItem mapItem, boolean z16, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    function2 = null;
                }
                iFilamentMapController.stopAvatarByData(mapItem, z16, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopAvatarByData");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void stopAvatarById$default(IFilamentMapController iFilamentMapController, String str, boolean z16, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    function2 = null;
                }
                iFilamentMapController.stopAvatarById(str, z16, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopAvatarById");
        }
    }
}
