package com.tencent.mobileqq.nearbypro.map.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import bb2.ClusterGather;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.feeds.event.NBPFeedDeleteEvent;
import com.tencent.mobileqq.nearbypro.feeds.event.NBPFeedRefreshEvent;
import com.tencent.mobileqq.nearbypro.map.debug.DebugItemEvent;
import com.tencent.mobileqq.nearbypro.map.viewmodel.NearByProClusterVM;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.PlatformInfor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 T2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002UVB\u0007\u00a2\u0006\u0004\bR\u0010SJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u0005H\u0002J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0005H\u0002J\u0012\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0005H\u0002J\u0016\u0010\u0017\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u001c\u0010\u001f\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010%\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u000fH\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010.\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010/\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016J$\u00103\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040100j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000401`2H\u0016R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010A\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/part/NearByProClusterPart;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap$OnCameraChangeListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "forceCluster", "", "I9", "R9", "Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;", com.tencent.luggage.wxa.c8.c.G, "H9", "fromGesture", "N9", "", "from", FileReaderHelper.OPEN_FILE_FROM_FORCE, "J9", "L9", "", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "list", "M9", "Lcom/tencent/mobileqq/nearbypro/map/debug/DebugItemEvent;", "event", "P9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onPartResume", "onPartPause", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", PlatformInfor.SIMPLE_MODE, "C9", "getLogTag", "onCameraChange", "onCameraChangeFinished", "action", "", "args", "handleBroadcastMessage", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lbb2/b;", "f", "Lbb2/b;", "clusterManger", tl.h.F, "Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;", "lastCameraPosition", "i", "Z", "isEnterAnimationFinished", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "firstFetch", BdhLogUtil.LogTag.Tag_Conn, "isCameraChangeIng", "Lcom/tencent/mobileqq/nearbypro/map/viewmodel/NearByProClusterVM;", "D", "Lcom/tencent/mobileqq/nearbypro/map/viewmodel/NearByProClusterVM;", "nearByProClusterVM", "Landroidx/lifecycle/Lifecycle$Event;", "E", "Landroidx/lifecycle/Lifecycle$Event;", "curLifecycleEvent", "Lcom/tencent/mobileqq/nearbypro/map/part/NearByProClusterPart$b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/nearbypro/map/part/NearByProClusterPart$b;", "fetchAfterNotConcise", "Lcom/tencent/mobileqq/nearbypro/map/part/g;", "G", "Lcom/tencent/mobileqq/nearbypro/map/part/g;", "reportHelper", "<init>", "()V", "H", "a", "b", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearByProClusterPart extends com.tencent.mobileqq.nearbypro.part.e implements TencentMap.OnCameraChangeListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isCameraChangeIng;

    /* renamed from: D, reason: from kotlin metadata */
    private NearByProClusterVM nearByProClusterVM;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private FetchAfterNotConcise fetchAfterNotConcise;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private bb2.b clusterManger;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CameraPosition lastCameraPosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isEnterAnimationFinished;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean firstFetch = true;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Lifecycle.Event curLifecycleEvent = Lifecycle.Event.ON_CREATE;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final g reportHelper = new g();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/part/NearByProClusterPart$b;", "", "", "c", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "d", "(Z)V", "fetch", "b", "e", FileReaderHelper.OPEN_FILE_FROM_FORCE, "<init>", "(ZZ)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.map.part.NearByProClusterPart$b, reason: from toString */
    /* loaded from: classes15.dex */
    public static final /* data */ class FetchAfterNotConcise {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean fetch;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean force;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public FetchAfterNotConcise() {
            this(r2, r2, 3, null);
            boolean z16 = false;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getFetch() {
            return this.fetch;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getForce() {
            return this.force;
        }

        public final void c() {
            this.fetch = false;
            this.force = false;
        }

        public final void d(boolean z16) {
            this.fetch = z16;
        }

        public final void e(boolean z16) {
            this.force = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FetchAfterNotConcise)) {
                return false;
            }
            FetchAfterNotConcise fetchAfterNotConcise = (FetchAfterNotConcise) other;
            if (this.fetch == fetchAfterNotConcise.fetch && this.force == fetchAfterNotConcise.force) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.fetch;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.force;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "FetchAfterNotConcise(fetch=" + this.fetch + ", force=" + this.force + ")";
        }

        public FetchAfterNotConcise(boolean z16, boolean z17) {
            this.fetch = z16;
            this.force = z17;
        }

        public /* synthetic */ FetchAfterNotConcise(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17);
        }
    }

    public NearByProClusterPart() {
        boolean z16 = false;
        this.fetchAfterNotConcise = new FetchAfterNotConcise(z16, z16, 3, null);
    }

    private final void H9(CameraPosition pos) {
        boolean z16;
        CameraPosition cameraPosition = this.lastCameraPosition;
        boolean z17 = true;
        if (cameraPosition == null) {
            this.lastCameraPosition = pos;
            if (!this.isEnterAnimationFinished) {
                return;
            }
            broadcastMessage("MSG_ON_CAMERA_ZOOM_UPDATE", pos);
            broadcastMessage("MSG_ON_CAMERA_BEARING_UPDATE", pos);
        } else if (this.isEnterAnimationFinished) {
            Intrinsics.checkNotNull(cameraPosition);
            if (cameraPosition.zoom == pos.zoom) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                this.lastCameraPosition = pos;
                broadcastMessage("MSG_ON_CAMERA_ZOOM_UPDATE", pos);
            }
        }
        if (this.isEnterAnimationFinished) {
            CameraPosition cameraPosition2 = this.lastCameraPosition;
            Intrinsics.checkNotNull(cameraPosition2);
            if (cameraPosition2.bearing != pos.bearing) {
                z17 = false;
            }
            if (!z17) {
                com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.NearByProClusterPart", "onCameraBearingmChange:" + pos);
                this.lastCameraPosition = pos;
                broadcastMessage("MSG_ON_CAMERA_BEARING_UPDATE", pos);
            }
        }
    }

    private final void I9(boolean forceCluster) {
        if (this.isEnterAnimationFinished) {
            bb2.b bVar = this.clusterManger;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clusterManger");
                bVar = null;
            }
            bVar.c(forceCluster);
        }
    }

    private final void J9(String from, boolean force) {
        com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.NearByProClusterPart", "fetchNearbyInfoData StyleMode:" + getCooperation.qzone.PlatformInfor.SIMPLE_MODE java.lang.String() + " force:" + force + " from:" + from);
        if (getCooperation.qzone.PlatformInfor.SIMPLE_MODE java.lang.String()) {
            this.fetchAfterNotConcise.d(true);
            if (force) {
                this.fetchAfterNotConcise.e(true);
                return;
            }
            return;
        }
        L9(force);
    }

    static /* synthetic */ void K9(NearByProClusterPart nearByProClusterPart, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        nearByProClusterPart.J9(str, z16);
    }

    private final void L9(boolean force) {
        TencentMap a16 = i.INSTANCE.a(this);
        if (a16 != null) {
            NearByProClusterVM nearByProClusterVM = this.nearByProClusterVM;
            if (nearByProClusterVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nearByProClusterVM");
                nearByProClusterVM = null;
            }
            LatLng latLng = a16.getCameraPosition().target;
            Intrinsics.checkNotNullExpressionValue(latLng, "cameraPosition.target");
            nearByProClusterVM.P1(latLng, ab2.a.f25767a.i(), !this.firstFetch, force);
            this.firstFetch = false;
        }
    }

    private final void M9(List<? extends LatLng> list) {
        String str;
        float coerceAtMost;
        String str2 = "handleClusterClick size:";
        if (list.size() <= 1) {
            com.tencent.mobileqq.nearbypro.base.j.c().d("NBP.NearByProClusterPart", "handleClusterClick size:" + list.size());
            return;
        }
        TencentMap a16 = i.INSTANCE.a(this);
        if (a16 != null) {
            LatLng latLng = list.get(0);
            Iterator<T> it = list.iterator();
            double d16 = 0.0d;
            while (it.hasNext()) {
                d16 = RangesKt___RangesKt.coerceAtLeast(ab2.a.f25767a.b(latLng, (LatLng) it.next()), d16);
            }
            int i3 = (int) a16.getCameraPosition().zoom;
            ab2.a aVar = ab2.a.f25767a;
            int dpToPx = ViewUtils.dpToPx(aVar.c());
            float n3 = aVar.n();
            int i16 = i3;
            while (true) {
                if (i16 < 21) {
                    str = str2;
                    if (d16 > a16.getProjection().metersPerPixel(latLng.latitude, i16) * dpToPx) {
                        n3 = i16;
                        break;
                    } else {
                        i16++;
                        str2 = str;
                    }
                } else {
                    str = str2;
                    break;
                }
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(n3 + 0.1f, 20.0f);
            a16.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            a16.moveCamera(CameraUpdateFactory.rotateTo(0.0f, 0.0f));
            a16.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, coerceAtMost), 300L, null);
            com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.NearByProClusterPart", str + list.size() + " curZoom:" + i3 + " dis:" + d16 + " finalTargetZoom:" + coerceAtMost);
        }
    }

    private final void N9(CameraPosition pos, boolean fromGesture) {
        com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.NearByProClusterPart", "onCameraChangeFinished pos:" + pos + " isEnterAnimationFinished: " + this.isEnterAnimationFinished);
        this.isCameraChangeIng = false;
        if (!this.isEnterAnimationFinished) {
            return;
        }
        I9(false);
        K9(this, "onCameraChangeFinished", false, 2, null);
        H9(pos);
        broadcastMessage("MSG_CAMERA_CHANGE_FINISH", pos);
        this.reportHelper.a(pos, fromGesture);
    }

    static /* synthetic */ void O9(NearByProClusterPart nearByProClusterPart, CameraPosition cameraPosition, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        nearByProClusterPart.N9(cameraPosition, z16);
    }

    private final void P9(DebugItemEvent event) {
        int mType = event.getOptions().getMType();
        if (mType != 1) {
            if (mType == 2) {
                I9(false);
                return;
            }
            return;
        }
        bb2.b bVar = this.clusterManger;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clusterManger");
            bVar = null;
        }
        com.tencent.mobileqq.nearbypro.map.debug.a aVar = com.tencent.mobileqq.nearbypro.map.debug.a.f253436a;
        Object mObject = event.getOptions().getMObject();
        Intrinsics.checkNotNull(mObject, "null cannot be cast to non-null type kotlin.Int");
        bVar.d(gb2.c.class, aVar.a(((Integer) mObject).intValue()));
        I9(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void R9() {
        NearByProClusterVM nearByProClusterVM = null;
        if (this.isEnterAnimationFinished && !getCooperation.qzone.PlatformInfor.SIMPLE_MODE java.lang.String()) {
            Lifecycle.Event event = this.curLifecycleEvent;
            Lifecycle.Event event2 = Lifecycle.Event.ON_RESUME;
            if (event == event2) {
                NearByProClusterVM nearByProClusterVM2 = this.nearByProClusterVM;
                if (nearByProClusterVM2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nearByProClusterVM");
                } else {
                    nearByProClusterVM = nearByProClusterVM2;
                }
                nearByProClusterVM.Z1(event2);
                return;
            }
        }
        NearByProClusterVM nearByProClusterVM3 = this.nearByProClusterVM;
        if (nearByProClusterVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearByProClusterVM");
        } else {
            nearByProClusterVM = nearByProClusterVM3;
        }
        nearByProClusterVM.Z1(Lifecycle.Event.ON_PAUSE);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e
    public void C9(boolean concise) {
        super.C9(concise);
        bb2.b bVar = this.clusterManger;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clusterManger");
            bVar = null;
        }
        bVar.f(!concise);
        I9(true);
        R9();
        if (!concise && this.fetchAfterNotConcise.getFetch()) {
            L9(this.fetchAfterNotConcise.getForce());
            this.fetchAfterNotConcise.c();
            com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.NearByProClusterPart", "fetchNearbyInfoData AfterNotConcise");
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(DebugItemEvent.class);
        arrayList.add(NBPFeedRefreshEvent.class);
        arrayList.add(NBPFeedDeleteEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "NBP.NearByProClusterPart";
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        int collectionSizeOrDefault;
        List<? extends LatLng> list;
        int collectionSizeOrDefault2;
        List<? extends LatLng> list2;
        super.handleBroadcastMessage(action, args);
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1559074524) {
                if (hashCode != -569645997) {
                    if (hashCode == 842101121 && action.equals("MSG_ON_CLUSTER_CLICK")) {
                        if (args instanceof gb2.a) {
                            ArrayList<gb2.c> d16 = ((gb2.a) args).d();
                            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(d16, 10);
                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                            for (gb2.c cVar : d16) {
                                arrayList.add(new LatLng(cVar.getCom.tencent.luggage.wxa.c8.c.G java.lang.String().latitude, cVar.getCom.tencent.luggage.wxa.c8.c.G java.lang.String().longitude));
                            }
                            list2 = CollectionsKt___CollectionsKt.toList(arrayList);
                            M9(list2);
                            return;
                        }
                        if (args instanceof hb2.c) {
                            ArrayList<hb2.b> d17 = ((hb2.c) args).d();
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(d17, 10);
                            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                            for (hb2.b bVar : d17) {
                                arrayList2.add(new LatLng(bVar.getCom.tencent.luggage.wxa.c8.c.G java.lang.String().latitude, bVar.getCom.tencent.luggage.wxa.c8.c.G java.lang.String().longitude));
                            }
                            list = CollectionsKt___CollectionsKt.toList(arrayList2);
                            M9(list);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (action.equals("MSG_ENTER_MAP_END")) {
                    this.isEnterAnimationFinished = true;
                    TencentMap a16 = i.INSTANCE.a(this);
                    if (a16 != null) {
                        CameraPosition cameraPosition = a16.getCameraPosition();
                        Intrinsics.checkNotNullExpressionValue(cameraPosition, "cameraPosition");
                        N9(cameraPosition, false);
                    }
                    R9();
                    return;
                }
                return;
            }
            if (action.equals("MSG_UPDATE_SELF")) {
                NearByProClusterVM nearByProClusterVM = this.nearByProClusterVM;
                if (nearByProClusterVM == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nearByProClusterVM");
                    nearByProClusterVM = null;
                }
                nearByProClusterVM.f2(false);
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChange(@NotNull CameraPosition pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        this.isCameraChangeIng = true;
        H9(pos);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChangeFinished(@NotNull CameraPosition pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        O9(this, pos, false, 2, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        TencentMap a16 = i.INSTANCE.a(this);
        Intrinsics.checkNotNull(a16);
        a16.setOnCameraChangeListener(this);
        bb2.b bVar = new bb2.b(a16);
        bVar.b(new ClusterGather(new com.tencent.mobileqq.nearbypro.map.cluster.algorithm.a(a16), new cb2.a(a16)));
        bVar.b(new ClusterGather(new com.tencent.mobileqq.nearbypro.map.cluster.algorithm.i(a16), new cb2.e(a16)));
        bVar.b(new ClusterGather(new com.tencent.mobileqq.nearbypro.map.cluster.algorithm.h(a16), new cb2.d(a16)));
        this.clusterManger = bVar;
        NearByProClusterVM nearByProClusterVM = this.nearByProClusterVM;
        if (nearByProClusterVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearByProClusterVM");
            nearByProClusterVM = null;
        }
        MutableLiveData<ConcurrentHashMap<Integer, List<da2.b>>> S1 = nearByProClusterVM.S1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<ConcurrentHashMap<Integer, List<da2.b>>, Unit> function1 = new Function1<ConcurrentHashMap<Integer, List<da2.b>>, Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.part.NearByProClusterPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConcurrentHashMap<Integer, List<da2.b>> concurrentHashMap) {
                invoke2(concurrentHashMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ConcurrentHashMap<Integer, List<da2.b>> concurrentHashMap) {
                bb2.b bVar2;
                boolean z16;
                bVar2 = NearByProClusterPart.this.clusterManger;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clusterManger");
                    bVar2 = null;
                }
                NearByProClusterPart nearByProClusterPart = NearByProClusterPart.this;
                List<da2.b> list = concurrentHashMap.get(1);
                Intrinsics.checkNotNull(list);
                bVar2.e(gb2.c.class, list);
                List<da2.b> list2 = concurrentHashMap.get(2);
                Intrinsics.checkNotNull(list2);
                bVar2.e(hb2.b.class, list2);
                List<da2.b> list3 = concurrentHashMap.get(3);
                Intrinsics.checkNotNull(list3);
                bVar2.e(eb2.a.class, list3);
                z16 = nearByProClusterPart.isCameraChangeIng;
                if (!z16) {
                    bVar2.c(true);
                } else {
                    com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.NearByProClusterPart", "cluster isCameraChangeIng");
                }
            }
        };
        S1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.nearbypro.map.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearByProClusterPart.Q9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        ViewModel viewModel = getViewModel(NearByProClusterVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(NearByProClusterVM::class.java)");
        NearByProClusterVM nearByProClusterVM = (NearByProClusterVM) viewModel;
        this.nearByProClusterVM = nearByProClusterVM;
        if (nearByProClusterVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearByProClusterVM");
            nearByProClusterVM = null;
        }
        nearByProClusterVM.c2(getContext());
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        TencentMap a16 = i.INSTANCE.a(this);
        Intrinsics.checkNotNull(a16);
        a16.setOnCameraChangeListener(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        this.curLifecycleEvent = Lifecycle.Event.ON_PAUSE;
        R9();
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        this.curLifecycleEvent = Lifecycle.Event.ON_RESUME;
        R9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof DebugItemEvent) {
            P9((DebugItemEvent) event);
            return;
        }
        if (event instanceof NBPFeedDeleteEvent) {
            NBPFeedDeleteEvent nBPFeedDeleteEvent = (NBPFeedDeleteEvent) event;
            com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.NearByProClusterPart", "onReceiveEvent HasEditProfileEvent feedId:" + nBPFeedDeleteEvent.getFeedId());
            NearByProClusterVM nearByProClusterVM = this.nearByProClusterVM;
            if (nearByProClusterVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nearByProClusterVM");
                nearByProClusterVM = null;
            }
            nearByProClusterVM.b2(nBPFeedDeleteEvent.getFeedId());
            return;
        }
        if (event instanceof NBPFeedRefreshEvent) {
            J9("NBPFeedRefreshEvent", true);
        }
    }
}
