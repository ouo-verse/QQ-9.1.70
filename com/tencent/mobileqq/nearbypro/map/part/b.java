package com.tencent.mobileqq.nearbypro.map.part;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.nearbypro.map.request.ReportLocationRequest;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.WeakReferenceHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xp4.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0018\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/part/b;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "Landroid/os/Handler$Callback;", "", "from", "", "L9", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "I9", "Lcom/tencent/mobileqq/soso/location/data/SosoLocation;", "location", "K9", "M9", "Landroid/os/Message;", "msg", "", "handleMessage", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "action", "", "args", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onPartResume", "", "f", "I", "nextReqInterval", tl.h.F, "lastReqError", "i", "count", "Lcom/tencent/util/WeakReferenceHandler;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/util/WeakReferenceHandler;", "uiHandler", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends com.tencent.mobileqq.nearbypro.part.e implements Handler.Callback {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int lastReqError;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int count;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int nextReqInterval = 120;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReferenceHandler uiHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/nearbypro/map/part/b$b", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "", "errCode", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "", "onLocationFinish", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.map.part.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C8149b extends LbsManagerServiceOnLocationChangeListener {
        C8149b() {
            super("NearByPro", true);
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int errCode, @Nullable SosoLbsInfo info) {
            if (errCode == 0 && info != null && info.mLocation != null) {
                b.this.I9(info);
            } else {
                com.tencent.mobileqq.nearbypro.base.j.c().d("NBP.HeartBeatMapPart", "onLocationFinish errCode:" + errCode + "}");
                b.this.M9();
            }
            b.this.lastReqError = errCode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(SosoLbsInfo info) {
        SelfUserInfo selfUserInfo;
        SosoLocation sosoLocation = info.mLocation;
        Intrinsics.checkNotNullExpressionValue(sosoLocation, "info.mLocation");
        K9(sosoLocation);
        IMapNearbyDataService f16 = ab2.a.f25767a.f();
        if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null) {
            LatLng latLng = selfUserInfo.getLatLng();
            SosoLocation sosoLocation2 = info.mLocation;
            boolean z16 = !Intrinsics.areEqual(latLng, new LatLng(sosoLocation2.mLat02, sosoLocation2.mLon02));
            ab2.c cVar = ab2.c.f25771a;
            SosoLocation sosoLocation3 = info.mLocation;
            LatLng latLng2 = new LatLng(sosoLocation3.mLat02, sosoLocation3.mLon02);
            String str = info.mLocation.address;
            String str2 = "";
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "info.mLocation.address ?: \"\"");
            }
            String str3 = info.mLocation.name;
            if (str3 != null) {
                Intrinsics.checkNotNullExpressionValue(str3, "info.mLocation.name ?: \"\"");
                str2 = str3;
            }
            cVar.d(selfUserInfo, latLng2, str, str2);
            if (z16) {
                broadcastMessage("MSG_UPDATE_SELF", null);
            }
            com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.HeartBeatMapPart", "dealLocationFinish pos:" + selfUserInfo.getLatLng() + " vaguePos:" + cVar.a(selfUserInfo));
            op4.h hVar = new op4.h();
            SosoLocation mLocation = info.mLocation;
            if (mLocation != null) {
                Intrinsics.checkNotNullExpressionValue(mLocation, "mLocation");
                hVar.f423334e = mLocation.address;
                op4.f fVar = new op4.f();
                double d16 = 1000000;
                fVar.f423324a = (long) (mLocation.mLat02 * d16);
                fVar.f423325b = (long) (mLocation.mLon02 * d16);
                hVar.f423336g = fVar;
                hVar.f423341l = mLocation.province;
                hVar.f423342m = mLocation.city;
                hVar.f423346q = mLocation.district;
            }
            com.tencent.mobileqq.nearbypro.base.d<NearbyProBaseRequest> e16 = com.tencent.mobileqq.nearbypro.base.j.e();
            Context context = getContext();
            LatLng a16 = cVar.a(selfUserInfo);
            Intrinsics.checkNotNull(a16);
            e16.c(context, new ReportLocationRequest(a16, hVar), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.map.part.a
                @Override // com.tencent.mobileqq.nearbypro.request.b
                public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                    b.J9(b.this, (NearbyProBaseRequest) obj, rspStatus, (k) obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(b this$0, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, k kVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        if (rspStatus.c() && kVar != null) {
            this$0.nextReqInterval = kVar.f448343b;
            com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.HeartBeatMapPart", "nextReqInterval:" + this$0.nextReqInterval);
        }
        this$0.M9();
    }

    private final void K9(SosoLocation location) {
        if (!ab2.a.f25767a.s()) {
            float l3 = (r0.l() * 30) / 100000.0f;
            double d16 = location.mLat02;
            int i3 = this.count;
            location.mLat02 = d16 + (i3 * l3);
            location.mLon02 += i3 * l3;
            this.count = i3 + 1;
        }
    }

    private final void L9(String from) {
        this.uiHandler.removeMessages(100);
        com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.HeartBeatMapPart", "startLocation from:" + from);
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new C8149b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        this.uiHandler.removeMessages(100);
        this.uiHandler.sendEmptyMessageDelayed(100, this.nextReqInterval * 1000);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual("MSG_START_HEART_BEAT", action)) {
            L9("start_beat");
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 100) {
            L9("msg_location");
            return true;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        this.uiHandler.removeMessages(100);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        if (this.lastReqError == -10004) {
            com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.HeartBeatMapPart", "lastReqError is App_BackGround");
            L9("resume");
        }
    }
}
