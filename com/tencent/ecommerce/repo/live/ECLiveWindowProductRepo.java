package com.tencent.ecommerce.repo.live;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.biz.live.ScrollDirection;
import com.tencent.ecommerce.repo.live.k;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import di0.aa;
import di0.ab;
import di0.ac;
import di0.p;
import di0.s;
import di0.t;
import di0.u;
import di0.x;
import di0.y;
import di0.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 O2\u00020\u0001:\u0001#B;\u0012\u0006\u0010;\u001a\u00020\u000b\u0012\u0006\u0010<\u001a\u00020\u0015\u0012\u0006\u0010?\u001a\u00020=\u0012\u0006\u0010B\u001a\u00020\r\u0012\u0006\u0010F\u001a\u00020C\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\bM\u0010NJ$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\u001e\u0010\t\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\u001e\u0010\n\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J.\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002J,\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J.\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J&\u0010\u001d\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J$\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J$\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u001c\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u0015H\u0016J\u001e\u0010$\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J*\u0010&\u001a\u00020\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J$\u0010'\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J!\u0010*\u001a\u00020)2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010.R(\u00103\u001a\u0004\u0018\u00010\u00022\b\u00100\u001a\u0004\u0018\u00010\u00028\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010.\"\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00104R\u0016\u00106\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00104R\u0016\u0010\u001b\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00107R\u0016\u00108\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00107R\u0016\u00109\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00107R\u0014\u0010:\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00107R\u0014\u0010;\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u00104R\u0014\u0010<\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b'\u00107R\u0014\u0010?\u001a\u00020=8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010>R\u0014\u0010B\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bG\u00107R\"\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010I8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010K\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006P"}, d2 = {"Lcom/tencent/ecommerce/repo/live/ECLiveWindowProductRepo;", "Lcom/tencent/ecommerce/repo/live/k;", "Lcom/tencent/ecommerce/repo/live/q;", "product", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/repo/live/k$b;", "", "callback", "E", BdhLogUtil.LogTag.Tag_Conn, "D", "", "isRefreshAll", "", "scrollDirection", "Lcom/tencent/ecommerce/repo/live/k$d;", "B", "", "dataList", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "couponId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "f", "d", "query", "g", "c", "l", "j", "mediaProductId", "liveProduct", "e", "a", "i", "productList", tl.h.F, "k", "activityIdList", "Lcom/tencent/ecommerce/repo/live/k$a;", "b", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/List;", "unduplicateDataList", "Lcom/tencent/ecommerce/repo/live/q;", "hotPushProduct", "value", UserInfo.SEX_FEMALE, "(Lcom/tencent/ecommerce/repo/live/q;)V", "explainingProduct", "Z", "needRequestExplainingProduct", "needRequestingHotPushProduct", "Ljava/lang/String;", "cookie", "couponPageCookie", "logTag", "isMaster", "userId", "", "J", "roomId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", WadlProxyConsts.CHANNEL, "Lcom/tencent/ecommerce/repo/live/TabInfo;", DomainData.DOMAIN_NAME, "Lcom/tencent/ecommerce/repo/live/TabInfo;", "tabInfo", "o", "clickId", "", "y", "()Ljava/util/Map;", "transKV", "<init>", "(ZLjava/lang/String;JILcom/tencent/ecommerce/repo/live/TabInfo;Ljava/lang/String;)V", "r", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowProductRepo implements k {

    /* renamed from: q, reason: collision with root package name */
    private static int f105078q;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private LiveProduct hotPushProduct;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private LiveProduct explainingProduct;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needRequestExplainingProduct;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String logTag;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final boolean isMaster;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final String userId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final long roomId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final int channel;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final TabInfo tabInfo;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final String clickId;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: p, reason: collision with root package name */
    private static LiveTabId f105077p = LiveTabId.LIVE_TAB_NONE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<LiveProduct> unduplicateDataList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needRequestingHotPushProduct = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String query = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String cookie = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String couponPageCookie = "";

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\nR*\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/repo/live/ECLiveWindowProductRepo$a;", "", "Ldi0/u;", "rsp", "", "Lcom/tencent/ecommerce/repo/live/q;", "dataList", "topProduct", "Lcom/tencent/ecommerce/repo/live/k$d;", "e", "Lcom/tencent/ecommerce/base/network/api/e;", "b", "", "<set-?>", "pollingTickSecs", "I", "c", "()I", "d", "(I)V", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "sExplaningTabId", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.ECLiveWindowProductRepo$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(int i3) {
            ECLiveWindowProductRepo.f105078q = i3;
        }

        public final k.PageResponse b(ECRemoteResponse rsp) {
            return new k.PageResponse(new k.CommonResponse(false, rsp.getCode(), rsp.getMsg()), new ArrayList(), null, 0, false, null, 32, null);
        }

        public final int c() {
            return ECLiveWindowProductRepo.f105078q;
        }

        public final k.PageResponse e(u rsp, List<LiveProduct> dataList, LiveProduct topProduct) {
            return new k.PageResponse(new k.CommonResponse(true, 0, ""), dataList, topProduct, rsp.getTotal(), rsp.getIsEnd(), null, 32, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/repo/live/ECLiveWindowProductRepo$b", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/n;", "Ldi0/o;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkCallback<di0.n, di0.o> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f105096b;

        b(Function1 function1) {
            this.f105096b = function1;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(di0.n reqModel, ECRemoteResponse errorResponse) {
            cg0.a.b(ECLiveWindowProductRepo.this.logTag, "requestCouponDataFromNet error code=" + errorResponse.getCode() + ", msg=" + errorResponse.getMsg());
            this.f105096b.invoke(ECLiveWindowProductRepo.INSTANCE.b(errorResponse));
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(di0.n reqModel, di0.o respModel) {
            ECLiveWindowProductRepo.this.couponPageCookie = respModel.getCookie();
            List z16 = ECLiveWindowProductRepo.this.z(respModel.c());
            Iterator it = z16.iterator();
            while (it.hasNext()) {
                ((LiveProduct) it.next()).M(ECLiveWindowProductRepo.this.tabInfo.id);
            }
            cg0.a.b(ECLiveWindowProductRepo.this.logTag, "requestCouponDataFromNet success, dataList=" + z16);
            this.f105096b.invoke(new k.PageResponse(new k.CommonResponse(true, 0, ""), respModel.c(), null, respModel.getTotal(), respModel.getIsEnd(), respModel.getLiveCouponLabel()));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/repo/live/ECLiveWindowProductRepo$c", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/t;", "Ldi0/u;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECNetworkCallback<t, u> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f105098b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1 f105099c;

        c(boolean z16, Function1 function1) {
            this.f105098b = z16;
            this.f105099c = function1;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(t reqModel, ECRemoteResponse errorResponse) {
            cg0.a.b(ECLiveWindowProductRepo.this.logTag, "requestDataFromNet error code=" + errorResponse.getCode() + ", msg=" + errorResponse.getMsg());
            this.f105099c.invoke(ECLiveWindowProductRepo.INSTANCE.b(errorResponse));
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(t reqModel, u respModel) {
            ECLiveWindowProductRepo.this.cookie = respModel.getCookie();
            ECLiveWindowProductRepo.INSTANCE.d(Math.max(respModel.getPollingTickSecs(), 1));
            List<LiveProduct> z16 = ECLiveWindowProductRepo.this.z(respModel.b());
            LiveTabId liveTabId = ECLiveWindowProductRepo.this.tabInfo.id;
            LiveTabId liveTabId2 = LiveTabId.LIVE_TAB_PRODUCT;
            LiveProduct liveProduct = null;
            if (liveTabId != liveTabId2 && liveTabId != LiveTabId.LIVE_TAB_QSHOP && (ECLiveWindowProductRepo.f105077p == ECLiveWindowProductRepo.this.tabInfo.id || ECLiveWindowProductRepo.f105077p == LiveTabId.LIVE_TAB_NONE)) {
                if (ECLiveWindowProductRepo.this.explainingProduct != null) {
                    liveProduct = ECLiveWindowProductRepo.this.explainingProduct;
                } else if (ECLiveWindowProductRepo.this.hotPushProduct != null) {
                    liveProduct = ECLiveWindowProductRepo.this.hotPushProduct;
                }
            }
            if (this.f105098b && ECLiveWindowProductRepo.this.tabInfo.id != liveTabId2 && liveProduct != null) {
                z16.remove(liveProduct);
            }
            Iterator it = z16.iterator();
            while (it.hasNext()) {
                ((LiveProduct) it.next()).M(ECLiveWindowProductRepo.this.tabInfo.id);
            }
            if (liveProduct != null) {
                liveProduct.M(ECLiveWindowProductRepo.this.tabInfo.id);
            }
            cg0.a.b(ECLiveWindowProductRepo.this.logTag, "requestDataFromNet success, topProduct=" + liveProduct + ", resultList=" + z16);
            this.f105099c.invoke(ECLiveWindowProductRepo.INSTANCE.e(respModel, z16, liveProduct));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/repo/live/ECLiveWindowProductRepo$d", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/p;", "Ldi0/q;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements IECNetworkCallback<di0.p, di0.q> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f105101b;

        d(Function1 function1) {
            this.f105101b = function1;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(di0.p reqModel, ECRemoteResponse errorResponse) {
            cg0.a.b(ECLiveWindowProductRepo.this.logTag, "requestExplainingFromNet error code=" + errorResponse.getCode() + ", msg=" + errorResponse.getMsg());
            this.f105101b.invoke(null);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(di0.p reqModel, di0.q respModel) {
            ECLiveWindowProductRepo.this.F(respModel.getProduct());
            cg0.a.b(ECLiveWindowProductRepo.this.logTag, "requestDataFromNet, explainingProduct=" + ECLiveWindowProductRepo.this.explainingProduct);
            this.f105101b.invoke(respModel.getProduct());
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/repo/live/ECLiveWindowProductRepo$e", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/r;", "Ldi0/s;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements IECNetworkCallback<di0.r, s> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f105103b;

        e(Function1 function1) {
            this.f105103b = function1;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(di0.r reqModel, ECRemoteResponse errorResponse) {
            cg0.a.b(ECLiveWindowProductRepo.this.logTag, "requestHotPushFromNet error code=" + errorResponse.getCode() + ", msg=" + errorResponse.getMsg());
            this.f105103b.invoke(null);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(di0.r reqModel, s respModel) {
            ECLiveWindowProductRepo.this.hotPushProduct = respModel.getProduct();
            cg0.a.b(ECLiveWindowProductRepo.this.logTag, "requestDataFromNet, hotPushProduct=" + ECLiveWindowProductRepo.this.hotPushProduct);
            this.f105103b.invoke(respModel.getProduct());
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/repo/live/ECLiveWindowProductRepo$f", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/y;", "Ldi0/z;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements IECNetworkCallback<y, z> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f105105b;

        f(Function1 function1) {
            this.f105105b = function1;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(y reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a(ECLiveWindowProductRepo.this.logTag, "setExplainProductToNet", "onError errorResponse:" + errorResponse);
            this.f105105b.invoke(new k.CommonResponse(false, errorResponse.getCode(), errorResponse.getMsg()));
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(y reqModel, z respModel) {
            cg0.a.b(ECLiveWindowProductRepo.this.logTag, "setExplainProductToNet onSuccess");
            this.f105105b.invoke(new k.CommonResponse(true, 0, ""));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/repo/live/ECLiveWindowProductRepo$g", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/x;", "Ldi0/aa;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements IECNetworkCallback<x, aa> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f105106a;

        g(Function1 function1) {
            this.f105106a = function1;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(x reqModel, ECRemoteResponse errorResponse) {
            this.f105106a.invoke(new k.CommonResponse(false, errorResponse.getCode(), errorResponse.getMsg()));
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(x reqModel, aa respModel) {
            this.f105106a.invoke(new k.CommonResponse(true, 0, ""));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/repo/live/ECLiveWindowProductRepo$h", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/ab;", "Ldi0/ac;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements IECNetworkCallback<ab, ac> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f105107a;

        h(Function1 function1) {
            this.f105107a = function1;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(ab reqModel, ECRemoteResponse errorResponse) {
            this.f105107a.invoke(new k.CommonResponse(false, errorResponse.getCode(), errorResponse.getMsg()));
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ab reqModel, ac respModel) {
            this.f105107a.invoke(new k.CommonResponse(true, 0, ""));
        }
    }

    public ECLiveWindowProductRepo(boolean z16, String str, long j3, int i3, TabInfo tabInfo, String str2) {
        this.isMaster = z16;
        this.userId = str;
        this.roomId = j3;
        this.channel = i3;
        this.tabInfo = tabInfo;
        this.clickId = str2;
        this.logTag = "ECLiveWindowProductRepo_" + tabInfo.id;
    }

    private final void A(String couponId, boolean isRefreshAll, Function1<? super k.PageResponse, Unit> callback) {
        cg0.a.b(this.logTag, "requestCouponDataFromNet, isRefreshAll=" + isRefreshAll + ", couponId=" + couponId);
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr", "/trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr/GetCouponGoods", new di0.n(this.tabInfo.id, this.roomId, this.channel, this.couponPageCookie, couponId, isRefreshAll, y()), new di0.o(), new b(callback));
    }

    private final void C(Function1<? super LiveProduct, Unit> callback) {
        cg0.a.b(this.logTag, "requestExplainingFromNet");
        p.Companion companion = di0.p.INSTANCE;
        com.tencent.ecommerce.base.network.service.a.b(companion.b(this.isMaster), companion.a(this.isMaster), new di0.p(this.roomId, this.channel, this.tabInfo.id, y()), new di0.q(), new d(callback));
    }

    private final void D(Function1<? super LiveProduct, Unit> callback) {
        cg0.a.b(this.logTag, "requestHotPushFromNet");
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr", "/trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr/GetOfficialRecom", new di0.r(this.roomId, this.channel, this.tabInfo.id, y()), new s(), new e(callback));
    }

    private final void E(LiveProduct product, Function1<? super k.CommonResponse, Unit> callback) {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr", "/trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr/ExplainProduct", new y(this.channel, this.roomId, product, this.tabInfo.id), new z(), new f(callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(LiveProduct liveProduct) {
        this.explainingProduct = liveProduct;
        if (liveProduct != null) {
            f105077p = this.tabInfo.id;
        } else if (f105077p == this.tabInfo.id) {
            f105077p = LiveTabId.LIVE_TAB_NONE;
        }
    }

    private final Map<String, String> y() {
        boolean isBlank;
        Map<String, String> mapOf;
        String str = this.clickId;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("qz_gdt", this.clickId));
                return mapOf;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<LiveProduct> z(List<LiveProduct> dataList) {
        ArrayList arrayList = new ArrayList();
        for (LiveProduct liveProduct : dataList) {
            if (this.unduplicateDataList.contains(liveProduct)) {
                if (Intrinsics.areEqual(liveProduct, this.explainingProduct)) {
                    LiveProduct liveProduct2 = this.explainingProduct;
                    if (liveProduct2 != null) {
                        arrayList.remove(liveProduct2);
                        arrayList.add(liveProduct2);
                        this.unduplicateDataList.remove(liveProduct);
                        this.unduplicateDataList.add(liveProduct2);
                    }
                } else if (Intrinsics.areEqual(liveProduct, this.hotPushProduct)) {
                    LiveProduct liveProduct3 = this.hotPushProduct;
                    if (liveProduct3 != null) {
                        arrayList.remove(liveProduct3);
                        arrayList.add(liveProduct3);
                        this.unduplicateDataList.remove(liveProduct);
                        this.unduplicateDataList.add(liveProduct3);
                    }
                } else if (wg0.a.b()) {
                    cg0.a.b(this.logTag, "\u540e\u53f0\u4e0b\u53d1\u6570\u636e\u91cd\u590d\u4e86, product=" + liveProduct);
                }
            } else {
                if (liveProduct.getIsExplaining()) {
                    F(liveProduct);
                }
                if (liveProduct.getUiStyle().type == 2) {
                    this.hotPushProduct = liveProduct;
                }
                this.unduplicateDataList.add(liveProduct);
                arrayList.add(liveProduct);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.ecommerce.repo.live.k
    public LiveProduct a(String mediaProductId) {
        cg0.a.b(this.logTag, "cancelExplainProductForGuest, mediaProductId=" + mediaProductId + ", last=" + this.explainingProduct);
        LiveProduct liveProduct = this.explainingProduct;
        if (!Intrinsics.areEqual(liveProduct != null ? liveProduct.getMediaProductId() : null, mediaProductId)) {
            return null;
        }
        LiveProduct liveProduct2 = this.explainingProduct;
        F(null);
        this.needRequestExplainingProduct = false;
        return liveProduct2;
    }

    @Override // com.tencent.ecommerce.repo.live.k
    public Object b(List<String> list, Continuation<? super k.ActivityResponse> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ECLiveWindowProductRepo$requestActivityList$2(this, list, null), continuation);
    }

    @Override // com.tencent.ecommerce.repo.live.k
    /* renamed from: d, reason: from getter */
    public LiveProduct getHotPushProduct() {
        return this.hotPushProduct;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0059, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r4 != null ? r4.getMediaProductId() : null) == false) goto L17;
     */
    @Override // com.tencent.ecommerce.repo.live.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LiveProduct e(String mediaProductId, LiveProduct liveProduct) {
        cg0.a.b(this.logTag, "explainProductForGuest, mediaProductId=" + mediaProductId + ", liveProduct=" + liveProduct + ", last=" + this.explainingProduct);
        if ((mediaProductId.length() == 0) && liveProduct == null) {
            cg0.a.b(this.logTag, "explainProduct for guest, mediaProductId and liveProduct is null");
        } else {
            if (liveProduct != null) {
                String mediaProductId2 = liveProduct.getMediaProductId();
                LiveProduct liveProduct2 = this.explainingProduct;
            }
            LiveProduct liveProduct3 = this.explainingProduct;
            if (!Intrinsics.areEqual(liveProduct3 != null ? liveProduct3.getMediaProductId() : null, mediaProductId)) {
                F(null);
                for (LiveProduct liveProduct4 : this.unduplicateDataList) {
                    if (Intrinsics.areEqual(liveProduct4.getMediaProductId(), mediaProductId)) {
                        F(liveProduct4);
                        this.needRequestExplainingProduct = false;
                        cg0.a.b(this.logTag, "explainProductForGuest, find from data list, explainingProduct=" + this.explainingProduct);
                        return liveProduct4;
                    }
                }
                if (liveProduct != null) {
                    F(liveProduct);
                    this.needRequestExplainingProduct = false;
                    cg0.a.b(this.logTag, "explainProductForGuest, find from event, explainingProduct=" + this.explainingProduct);
                    return liveProduct;
                }
                this.needRequestExplainingProduct = true;
                cg0.a.b(this.logTag, "explainProductForGuest, not find need request");
            }
            cg0.a.b(this.logTag, "explainProduct for guest, this product had explained");
        }
        return null;
    }

    @Override // com.tencent.ecommerce.repo.live.k
    /* renamed from: f, reason: from getter */
    public LiveProduct getExplainingProduct() {
        return this.explainingProduct;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.tencent.ecommerce.repo.live.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(String query, String couponId, Function1<? super k.PageResponse, Unit> callback) {
        boolean z16;
        boolean isBlank;
        x();
        this.query = query;
        if (couponId != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(couponId);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    B(true, 0, callback);
                    return;
                } else {
                    A(couponId, true, callback);
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.ecommerce.repo.live.k
    public void h(List<LiveProduct> productList, Function1<? super k.CommonResponse, Unit> callback) {
        x();
        z(productList);
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr", "/trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr/Set", new ab(this.channel, this.roomId, productList, this.tabInfo.id), new ac(), new h(callback));
    }

    @Override // com.tencent.ecommerce.repo.live.k
    public void i(Function1<? super LiveProduct, Unit> callback) {
        LiveTabId liveTabId = f105077p;
        if (liveTabId != this.tabInfo.id && liveTabId != LiveTabId.LIVE_TAB_NONE) {
            callback.invoke(null);
            return;
        }
        LiveProduct liveProduct = this.explainingProduct;
        if (liveProduct != null) {
            callback.invoke(liveProduct);
            return;
        }
        if (this.needRequestExplainingProduct) {
            this.needRequestExplainingProduct = false;
            C(callback);
            return;
        }
        LiveProduct liveProduct2 = this.hotPushProduct;
        if (liveProduct2 != null && !this.isMaster) {
            callback.invoke(liveProduct2);
        } else if (this.needRequestingHotPushProduct && !this.isMaster) {
            this.needRequestingHotPushProduct = false;
            D(callback);
        } else {
            callback.invoke(null);
        }
    }

    @Override // com.tencent.ecommerce.repo.live.k
    public void j(LiveProduct product, Function1<? super k.CommonResponse, Unit> callback) {
        cg0.a.b(this.logTag, "cancelExplainProductForMaster, product=" + product + ", last=" + this.explainingProduct);
        if (Intrinsics.areEqual(product, this.explainingProduct)) {
            F(null);
        }
        E(product, callback);
    }

    @Override // com.tencent.ecommerce.repo.live.k
    public void k(LiveProduct product, Function1<? super k.CommonResponse, Unit> callback) {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr", "/trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr/SetProductAdTxt", new x(this.channel, this.roomId, product, this.tabInfo.id), new aa(), new g(callback));
    }

    @Override // com.tencent.ecommerce.repo.live.k
    public void l(LiveProduct product, Function1<? super k.CommonResponse, Unit> callback) {
        cg0.a.b(this.logTag, "explainProductForMaster, product=" + product + ", last=" + this.explainingProduct);
        if (!Intrinsics.areEqual(product, this.explainingProduct)) {
            F(product);
            E(product, callback);
        }
    }

    public void x() {
        this.unduplicateDataList.clear();
        this.hotPushProduct = null;
        F(null);
        this.cookie = "";
        this.query = "";
        this.couponPageCookie = "";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    @Override // com.tencent.ecommerce.repo.live.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String couponId, Function1<? super k.PageResponse, Unit> callback) {
        boolean z16;
        boolean isBlank;
        if (couponId != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(couponId);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    B(false, 0, callback);
                    return;
                } else {
                    A(couponId, false, callback);
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final void B(boolean isRefreshAll, @ScrollDirection int scrollDirection, Function1<? super k.PageResponse, Unit> callback) {
        cg0.a.b(this.logTag, "requestDataFromNet, isRefreshAll=" + isRefreshAll + ", scrollDirection=" + scrollDirection + ", query=" + this.query);
        t.Companion companion = t.INSTANCE;
        com.tencent.ecommerce.base.network.service.a.b(companion.b(this.isMaster), companion.a(this.isMaster), new t(this.userId, this.roomId, this.channel, this.cookie, this.tabInfo.id, this.query, this.unduplicateDataList, isRefreshAll, scrollDirection, y()), new u(), new c(isRefreshAll, callback));
    }
}
