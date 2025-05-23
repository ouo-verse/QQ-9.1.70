package com.tencent.mobileqq.nearbypro.map.viewmodel;

import ab2.a;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.map.request.GetNearByInfoRequest;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.nearbypro.utils.ToStringExKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.xweb.FileReaderHelper;
import da2.FetchMapDataTimingInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xp4.h;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u00012\u00020\u0002:\u0001IB\u0007\u00a2\u0006\u0004\bG\u0010HJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\u001e\u0010\u0016\u001a\u00020\f*\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0014J\u0012\u0010\u001d\u001a\u00020\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ*\u0010#\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$J\u0010\u0010(\u001a\u00020\f2\b\b\u0002\u0010'\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u000fR(\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u0005\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R/\u0010>\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0012098\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/viewmodel/NearByProClusterVM;", "Landroidx/lifecycle/ViewModel;", "Landroid/os/Handler$Callback;", "Lda2/d;", "oriNearbyPos", "lastRspFetchPos", "", "e2", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "req", "Lxp4/c;", "rsp", "", "U1", "d2", "", "T1", "X1", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lda2/b;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroid/os/Message;", "msg", "handleMessage", "onCleared", "Landroid/content/Context;", "context", "c2", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "latLng", "dis", "filterMe", FileReaderHelper.OPEN_FILE_FROM_FORCE, "P1", "Landroidx/lifecycle/Lifecycle$Event;", "state", "Z1", "delay", "f2", "feedId", "b2", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "lastFetchDataMap", "Lda2/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lda2/a;", "fetchTimingInfo", BdhLogUtil.LogTag.Tag_Conn, "Lda2/d;", "D", "I", "currentNearBySSOSeq", "E", "Landroid/content/Context;", "Landroidx/lifecycle/MutableLiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "S1", "()Landroidx/lifecycle/MutableLiveData;", "fetchDataMutableLiveData", "Lcom/tencent/util/WeakReferenceHandler;", "G", "Lcom/tencent/util/WeakReferenceHandler;", "uiHandler", "Lab2/a$a;", "H", "Lab2/a$a;", "requestInfoOptimizeConfig", "<init>", "()V", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearByProClusterVM extends ViewModel implements Handler.Callback {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private da2.d lastRspFetchPos;

    /* renamed from: D, reason: from kotlin metadata */
    private volatile int currentNearBySSOSeq;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Context context;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ConcurrentHashMap<Integer, List<da2.b>>> fetchDataMutableLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final WeakReferenceHandler uiHandler;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final a.RequestInfoOptimizeConfig requestInfoOptimizeConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<Integer, List<da2.b>> lastFetchDataMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile FetchMapDataTimingInfo fetchTimingInfo;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253592a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f253592a = iArr;
        }
    }

    public NearByProClusterVM() {
        ConcurrentHashMap<Integer, List<da2.b>> concurrentHashMap = new ConcurrentHashMap<>();
        a2(concurrentHashMap);
        this.lastFetchDataMap = concurrentHashMap;
        this.fetchTimingInfo = new FetchMapDataTimingInfo(false, 120, null, 5, null);
        this.lastRspFetchPos = new da2.d(null, 0, 3, null);
        this.fetchDataMutableLiveData = new MutableLiveData<>();
        this.uiHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.requestInfoOptimizeConfig = ab2.a.f25767a.j();
    }

    public static /* synthetic */ void Q1(NearByProClusterVM nearByProClusterVM, LatLng latLng, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        if ((i16 & 8) != 0) {
            z17 = false;
        }
        nearByProClusterVM.P1(latLng, i3, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(NearByProClusterVM this$0, NearbyProBaseRequest request, RspStatus rspStatus, xp4.c cVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        j.c().e("NBP.NearByProClusterPart", "fetchNearbyInfoData " + rspStatus);
        if (rspStatus.c() && cVar != null) {
            int ssoSeq = request.getSsoSeq();
            if (ssoSeq <= this$0.currentNearBySSOSeq) {
                j.c().e("NBP.NearByProClusterPart", "fetchNearbyInfoData return currentNearBySSOSeq:" + this$0.currentNearBySSOSeq + " ssoSeq:" + ssoSeq);
                return;
            }
            this$0.currentNearBySSOSeq = ssoSeq;
            this$0.U1(request, cVar);
        }
        this$0.X1();
    }

    private final String T1() {
        String joinToString$default;
        String joinToString$default2;
        if (j.a().debug()) {
            ConcurrentHashMap<Integer, List<da2.b>> concurrentHashMap = this.lastFetchDataMap;
            ArrayList arrayList = new ArrayList(concurrentHashMap.size());
            for (Map.Entry<Integer, List<da2.b>> entry : concurrentHashMap.entrySet()) {
                Integer key = entry.getKey();
                List<da2.b> value = entry.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(value, ",", null, null, 0, null, new Function1<Object, CharSequence>() { // from class: com.tencent.mobileqq.nearbypro.map.viewmodel.NearByProClusterVM$getLastFetchDataMapStr$1$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CharSequence invoke(@NotNull Object it12) {
                        Intrinsics.checkNotNullParameter(it12, "it1");
                        if (it12 instanceof gb2.c) {
                            return "{" + ToStringExKt.n(((gb2.c) it12).getData()) + "}";
                        }
                        if (it12 instanceof eb2.a) {
                            return "{" + ToStringExKt.h(((eb2.a) it12).getAreaInfo()) + "}";
                        }
                        if (!(it12 instanceof hb2.b)) {
                            return "";
                        }
                        return "{" + ToStringExKt.m(((hb2.b) it12).getData()) + "}";
                    }
                }, 30, null);
                arrayList.add(key + "={" + joinToString$default2 + "}");
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
            return joinToString$default;
        }
        return "";
    }

    private final void U1(BaseRequest req, final xp4.c rsp) {
        final long currentTimeMillis = System.currentTimeMillis();
        int delay = this.fetchTimingInfo.getDelay();
        int i3 = rsp.f448314f;
        if (delay != i3 && i3 > 0) {
            this.fetchTimingInfo.e(rsp.f448314f);
        }
        Intrinsics.checkNotNull(req, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.map.request.GetNearByInfoRequest");
        GetNearByInfoRequest getNearByInfoRequest = (GetNearByInfoRequest) req;
        this.lastRspFetchPos.d(new LatLng(getNearByInfoRequest.getReq().f448306b.f429215a, getNearByInfoRequest.getReq().f448306b.f429216b));
        this.lastRspFetchPos.c(rsp.f448313e);
        j.c().e("NBP.NearByProClusterPart", "handleFetchNearbyInfoData nextReqInterval:" + this.fetchTimingInfo.getDelay() + " lastFetchPos:" + this.lastRspFetchPos);
        final long m3 = ab2.a.f25767a.m();
        j.g().a(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.viewmodel.d
            @Override // java.lang.Runnable
            public final void run() {
                NearByProClusterVM.W1(xp4.c.this, m3, currentTimeMillis, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v7, types: [T, xp4.h] */
    public static final void W1(xp4.c rsp, long j3, long j16, final NearByProClusterVM this$0) {
        boolean z16;
        boolean z17;
        List<xp4.a> list;
        List<qp4.a> list2;
        List<h> list3;
        Iterator<da2.b> it;
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final ConcurrentHashMap<Integer, List<da2.b>> concurrentHashMap = new ConcurrentHashMap<>();
        this$0.a2(concurrentHashMap);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        h[] hVarArr = rsp.f448310b;
        Intrinsics.checkNotNullExpressionValue(hVarArr, "rsp.persons");
        boolean z18 = false;
        if (hVarArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            ab2.a aVar = ab2.a.f25767a;
            h[] hVarArr2 = rsp.f448310b;
            Intrinsics.checkNotNullExpressionValue(hVarArr2, "rsp.persons");
            list3 = ArraysKt___ArraysKt.toList(hVarArr2);
            concurrentHashMap.put(1, aVar.D(list3));
            if (j3 != 0) {
                List<da2.b> list4 = concurrentHashMap.get(1);
                if (list4 != null) {
                    it = list4.iterator();
                } else {
                    it = null;
                }
                if (it != null) {
                    while (it.hasNext()) {
                        da2.b next = it.next();
                        if (Intrinsics.areEqual(next.b(), String.valueOf(j3))) {
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.map.marker.personal.UserInfoClusterItem");
                            objectRef.element = ((gb2.c) next).getData();
                            it.remove();
                        }
                    }
                }
            }
        }
        qp4.a[] aVarArr = rsp.f448312d;
        Intrinsics.checkNotNullExpressionValue(aVarArr, "rsp.areas");
        if (aVarArr.length == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            ab2.a aVar2 = ab2.a.f25767a;
            qp4.a[] aVarArr2 = rsp.f448312d;
            Intrinsics.checkNotNullExpressionValue(aVarArr2, "rsp.areas");
            list2 = ArraysKt___ArraysKt.toList(aVarArr2);
            concurrentHashMap.put(3, aVar2.B(list2));
        }
        xp4.a[] aVarArr3 = rsp.f448311c;
        Intrinsics.checkNotNullExpressionValue(aVarArr3, "rsp.feeds");
        if (aVarArr3.length == 0) {
            z18 = true;
        }
        if (!z18) {
            ab2.a aVar3 = ab2.a.f25767a;
            xp4.a[] aVarArr4 = rsp.f448311c;
            Intrinsics.checkNotNullExpressionValue(aVarArr4, "rsp.feeds");
            list = ArraysKt___ArraysKt.toList(aVarArr4);
            concurrentHashMap.put(2, aVar3.C(list));
        }
        j.c().d("NBP.NearByProClusterPart", "handleFetchNearbyInfoData cost(ms):" + (System.currentTimeMillis() - j16) + " lastFetchDataMap:" + this$0.T1());
        j.g().postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.viewmodel.NearByProClusterVM$handleFetchNearbyInfoData$1$2
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
                SelfUserInfo selfUserInfo;
                h hVar = objectRef.element;
                if (hVar != null) {
                    IMapNearbyDataService f16 = ab2.a.f25767a.f();
                    if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null) {
                        ab2.c.f25771a.f(selfUserInfo, hVar);
                    }
                    j.c().e("NBP.NearByProClusterPart", "handleFetchNearbyInfoData updateSelf: " + hVar);
                }
                this$0.lastFetchDataMap = concurrentHashMap;
                this$0.d2();
            }
        });
    }

    private final void X1() {
        if (this.fetchTimingInfo.getBTiming()) {
            this.uiHandler.removeMessages(101);
            this.uiHandler.sendEmptyMessageDelayed(101, this.fetchTimingInfo.getDelay() * 1000);
        }
    }

    private final void a2(ConcurrentHashMap<Integer, List<da2.b>> concurrentHashMap) {
        concurrentHashMap.clear();
        concurrentHashMap.put(1, new ArrayList());
        concurrentHashMap.put(2, new ArrayList());
        concurrentHashMap.put(3, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2() {
        SelfUserInfo selfUserInfo;
        MutableLiveData<ConcurrentHashMap<Integer, List<da2.b>>> mutableLiveData = this.fetchDataMutableLiveData;
        ConcurrentHashMap<Integer, List<da2.b>> concurrentHashMap = new ConcurrentHashMap<>(this.lastFetchDataMap);
        ArrayList arrayList = new ArrayList(concurrentHashMap.get(1));
        ab2.a aVar = ab2.a.f25767a;
        IMapNearbyDataService f16 = aVar.f();
        if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null) {
            if (selfUserInfo.getTid() != 0) {
                h hVar = new h();
                aVar.w(hVar, selfUserInfo);
                LatLng a16 = ab2.c.f25771a.a(selfUserInfo);
                if (a16 == null) {
                    a16 = new LatLng();
                }
                arrayList.add(new gb2.c(hVar, a16));
            } else {
                j.c().d("NBP.NearByProClusterPart", "setFetchLiveData selfTid == 0");
            }
        }
        Unit unit = Unit.INSTANCE;
        concurrentHashMap.put(1, arrayList);
        mutableLiveData.setValue(concurrentHashMap);
    }

    private final boolean e2(da2.d oriNearbyPos, da2.d lastRspFetchPos) {
        if (this.requestInfoOptimizeConfig.getEnableOptimize() && this.requestInfoOptimizeConfig.getRatio() > 0.0d) {
            return ab2.a.f25767a.u(oriNearbyPos, lastRspFetchPos, this.requestInfoOptimizeConfig.getRatio());
        }
        return ab2.a.v(ab2.a.f25767a, oriNearbyPos, lastRspFetchPos, 0.0d, 2, null);
    }

    public final void P1(@NotNull LatLng latLng, int dis, boolean filterMe, boolean force) {
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        da2.d dVar = new da2.d(latLng, dis);
        j.c().e("NBP.NearByProClusterPart", "fetchNearbyInfoData oriNearbyPos:" + dVar + " filterMe:" + filterMe + " force:" + force);
        this.fetchTimingInfo.f(dVar);
        if (!force && e2(dVar, this.lastRspFetchPos)) {
            return;
        }
        j.e().c(this.context, new GetNearByInfoRequest(latLng, dis, filterMe), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.map.viewmodel.c
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                NearByProClusterVM.R1(NearByProClusterVM.this, (NearbyProBaseRequest) obj, rspStatus, (xp4.c) obj2);
            }
        });
    }

    @NotNull
    public final MutableLiveData<ConcurrentHashMap<Integer, List<da2.b>>> S1() {
        return this.fetchDataMutableLiveData;
    }

    public final void Z1(@NotNull Lifecycle.Event state) {
        Intrinsics.checkNotNullParameter(state, "state");
        j.c().e("NBP.NearByProClusterPart", "onFetchTimingState state:" + state);
        int i3 = b.f253592a[state.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                this.fetchTimingInfo.d(false);
                this.uiHandler.removeMessages(101);
                return;
            }
            return;
        }
        this.fetchTimingInfo.d(true);
        this.uiHandler.removeMessages(101);
        this.uiHandler.sendEmptyMessageDelayed(101, this.fetchTimingInfo.getDelay() * 1000);
    }

    public final void b2(@NotNull String feedId) {
        Object obj;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        List<da2.b> list = this.lastFetchDataMap.get(2);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((da2.b) obj).b(), feedId)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            da2.b bVar = (da2.b) obj;
            if (bVar != null) {
                list.remove(bVar);
                d2();
                j.c().e("NBP.NearByProClusterPart", "removeFeed feedId:" + feedId);
            }
        }
    }

    public final void c2(@Nullable Context context) {
        this.context = context;
    }

    public final void f2(boolean delay) {
        if (delay) {
            if (!this.uiHandler.hasMessages(100)) {
                this.uiHandler.sendEmptyMessageDelayed(100, 10000L);
            }
        } else {
            this.uiHandler.removeMessages(100);
            this.uiHandler.sendEmptyMessage(100);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        da2.d pos;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 != 100) {
            if (i3 == 101 && this.fetchTimingInfo.getBTiming() && (pos = this.fetchTimingInfo.getPos()) != null) {
                Q1(this, pos.getLatLng(), pos.getDis(), false, true, 4, null);
                return true;
            }
            return true;
        }
        j.c().e("NBP.NearByProClusterPart", "refreshSelf");
        d2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.uiHandler.removeMessages(100);
        this.uiHandler.removeMessages(101);
    }
}
