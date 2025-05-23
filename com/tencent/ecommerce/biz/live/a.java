package com.tencent.ecommerce.biz.live;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.live.event.ECLiveWindowLocalUpdateEvent;
import com.tencent.ecommerce.biz.live.event.ECLiveWindowRemoteUpdateEvent;
import com.tencent.ecommerce.biz.live.ui.ECLiveVideoSelectGoodsTypeFragment;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.repo.live.ECLiveTabInfoRepo;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qzone.remote.ServiceConst;
import di0.j;
import di0.l;
import di0.m;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b;\u0010<JN\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J2\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u001a\u0010\u001a\u001a\u00020\u00102\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0018J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u001bJ4\u0010\u001f\u001a\u00020\u00102\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0018j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001bJ4\u0010 \u001a\u00020\u00102\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0018j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001bJ2\u0010!\u001a\u00020\u00102\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0018j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001d2\u0006\u0010\u0016\u001a\u00020\u001bJ2\u0010\"\u001a\u00020\u00102\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0018j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001d2\u0006\u0010\u0016\u001a\u00020\u001bJ\"\u0010$\u001a\u00020\u00102\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0#2\u0006\u0010\u0016\u001a\u00020\u001bJB\u0010%\u001a\u00020\u00102\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fJB\u0010&\u001a\u00020\u00102\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ*\u0010'\u001a\u00020\u00102\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0018j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001dJ*\u0010(\u001a\u00020\u00102\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0018j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001dJ*\u0010)\u001a\u00020\u00102\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0018j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001dJ(\u0010+\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010*\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020\fJ\"\u0010.\u001a\u00020\u00102\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0#2\u0006\u0010\u0016\u001a\u00020\u001bJ*\u0010/\u001a\u00020\u00102\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0018j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001dJ\u0006\u00100\u001a\u00020\u0010R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/ecommerce/biz/live/a;", "", "", "event", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "eventTabId", "", "isMaster", WadlProxyConsts.CHANNEL, "", "mediaProductId", "liveUserId", "", "liveRoomId", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "", ReportConstant.COSTREPORT_PREFIX, "sessionId", "Lcom/tencent/ecommerce/biz/live/ECLiveEntryResponse;", "respModel", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "callback", "l", "Ljava/util/HashMap;", "data", "y", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "j", "Lkotlin/collections/HashMap;", "dataMap", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "u", "", "v", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "o", "p", ZPlanPublishSource.FROM_SCHEME, "k", WidgetCacheConstellationData.MONEY, "i", tl.h.F, "t", "g", "Lcom/tencent/ecommerce/biz/live/TransactionData;", "a", "Lcom/tencent/ecommerce/biz/live/TransactionData;", "lastTransactionData", "b", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "callbackForGetTransactionData", "c", "Z", "isRequestingTransactionData", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static volatile TransactionData lastTransactionData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile IECLogicCallback callbackForGetTransactionData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isRequestingTransactionData;

    /* renamed from: d, reason: collision with root package name */
    public static final a f102661d = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/a$a", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.live.a$a, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class C1057a implements IECSchemeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECLogicCallback f102662a;

        C1057a(IECLogicCallback iECLogicCallback) {
            this.f102662a = iECLogicCallback;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            HashMap<String, Object> hashMapOf;
            IECLogicCallback iECLogicCallback = this.f102662a;
            hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_JSON_RESULT", data));
            iECLogicCallback.onResult(hashMapOf);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/live/a$b", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/d;", "Lcom/tencent/ecommerce/biz/live/ECLiveEntryResponse;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkCallback<di0.d, ECLiveEntryResponse> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f102663a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f102664b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f102665c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ C1057a f102666d;

        b(String str, long j3, String str2, C1057a c1057a) {
            this.f102663a = str;
            this.f102664b = j3;
            this.f102665c = str2;
            this.f102666d = c1057a;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(di0.d reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a("ECLiveHelper", "handleLiveScheme", "handleLiveScheme requestWithCmd error reqModel:" + reqModel + ",errorResponse:" + errorResponse);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("PARAM_ENTRY_SCHEME_ERROR", errorResponse.toString());
            C1057a c1057a = this.f102666d;
            if (c1057a != null) {
                c1057a.onCallbackFinished(jSONObject);
            }
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(di0.d reqModel, ECLiveEntryResponse respModel) {
            cg0.a.b("ECLiveHelper", "handleGoodsScheme type:1,respModel:" + respModel);
            a.f102661d.l(this.f102663a, this.f102664b, this.f102665c, respModel, this.f102666d);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/a$c", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECSchemeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECLogicCallback f102667a;

        c(IECLogicCallback iECLogicCallback) {
            this.f102667a = iECLogicCallback;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            HashMap<String, Object> hashMapOf;
            IECLogicCallback iECLogicCallback = this.f102667a;
            hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_JSON_RESULT", data));
            iECLogicCallback.onResult(hashMapOf);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/live/a$d", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/e;", "Ldi0/c;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements IECNetworkCallback<di0.e, di0.c> {
        d() {
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(di0.e reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a("ECLiveHelper", "notifyLiveFinish", "notifyLiveFinish error reqModel:" + reqModel + ",errorResponse:" + errorResponse);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(di0.e reqModel, di0.c respModel) {
            cg0.a.b("ECLiveHelper", "notifyLiveFinish success ");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/live/a$e", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/f;", "Ldi0/c;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements IECNetworkCallback<di0.f, di0.c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f102668a;

        e(HashMap hashMap) {
            this.f102668a = hashMap;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(di0.f reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a("ECLiveHelper", "notifyLiveOpen", "notifyLiveOpen error reqModel:" + reqModel + ",errorResponse:" + errorResponse);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(di0.f reqModel, di0.c respModel) {
            cg0.a.b("ECLiveHelper", "notifyLiveOpen success ");
            this.f102668a.put("PARAM_IS_MASTER", String.valueOf(true));
            a.f102661d.t(this.f102668a);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/live/a$f", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/l;", "Ldi0/m;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements IECNetworkCallback<l, m> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECLogicCallback f102669a;

        f(IECLogicCallback iECLogicCallback) {
            this.f102669a = iECLogicCallback;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(l reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a("ECLiveHelper", "requestLiveBubbleInfo", "requestLiveBubbleInfo error reqModel:" + reqModel + ",errorResponse:" + errorResponse);
            this.f102669a.onResult(new HashMap<>());
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(l reqModel, m respModel) {
            this.f102669a.onResult(respModel.a());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/live/a$g", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/a;", "Ldi0/b;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements IECNetworkCallback<di0.a, di0.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECLogicCallback f102670a;

        g(IECLogicCallback iECLogicCallback) {
            this.f102670a = iECLogicCallback;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(di0.a reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a("ECLiveHelper", "requestLiveBuyingBubbleInfo", "requestLiveBuyingBubbleInfo error reqModel:" + reqModel + ",errorResponse:" + errorResponse);
            this.f102670a.onResult(new HashMap<>());
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(di0.a reqModel, di0.b respModel) {
            this.f102670a.onResult(respModel.a());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/live/a$h", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/d;", "Lcom/tencent/ecommerce/biz/live/ECLiveEntryResponse;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements IECNetworkCallback<di0.d, ECLiveEntryResponse> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECLogicCallback f102671a;

        h(IECLogicCallback iECLogicCallback) {
            this.f102671a = iECLogicCallback;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(di0.d reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a("ECLiveHelper", "requestLiveData", "requestLiveData requestWithCmd error reqModel:" + reqModel + ",errorResponse:" + errorResponse);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(di0.d reqModel, ECLiveEntryResponse respModel) {
            cg0.a.b("ECLiveHelper", "requestLiveData respModel:" + respModel);
            this.f102671a.onResult(respModel.b());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/live/a$i", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/i;", "Ldi0/j;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i implements IECNetworkCallback<di0.i, j> {
        i() {
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(di0.i reqModel, ECRemoteResponse errorResponse) {
            a aVar = a.f102661d;
            a.lastTransactionData = new TransactionData(0L, 0L, 0L);
            a.isRequestingTransactionData = false;
            IECLogicCallback a16 = a.a(aVar);
            if (a16 != null) {
                TransactionData b16 = a.b(aVar);
                if (b16 != null) {
                    a16.onResult(com.tencent.ecommerce.biz.live.c.a(b16));
                }
                a.callbackForGetTransactionData = null;
                a.lastTransactionData = null;
            }
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(di0.i reqModel, j respModel) {
            a aVar = a.f102661d;
            a.lastTransactionData = new TransactionData(respModel.getOrderMoney(), respModel.getOrderNum(), respModel.getPersonNum());
            a.isRequestingTransactionData = false;
            IECLogicCallback a16 = a.a(aVar);
            if (a16 != null) {
                TransactionData b16 = a.b(aVar);
                if (b16 != null) {
                    a16.onResult(com.tencent.ecommerce.biz.live.c.a(b16));
                }
                a.callbackForGetTransactionData = null;
                a.lastTransactionData = null;
            }
        }
    }

    a() {
    }

    public static final /* synthetic */ IECLogicCallback a(a aVar) {
        return callbackForGetTransactionData;
    }

    public static final /* synthetic */ TransactionData b(a aVar) {
        return lastTransactionData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String liveUserId, long liveRoomId, String sessionId, ECLiveEntryResponse respModel, IECSchemeCallback callback) {
        if (!respModel.getIsEcomAuthenticated()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mqqapi://ecommerce/open?target=1&channel=8&src_type=internal&version=1&jump_scheme=");
            String k3 = k(liveUserId, liveRoomId, sessionId, "mqqapi://ecommerce/open?target=7&channel=8&window_type=3&src_type=internal&version=1");
            Charset charset = StandardCharsets.UTF_8;
            if (k3 != null) {
                byte[] bytes = k3.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                sb5.append(Base64.encodeToString(bytes, 0));
                ECScheme.f(sb5.toString(), callback, null, 4, null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        if (respModel.getLiveGoodsNumber() > 0) {
            ECScheme.f(k(liveUserId, liveRoomId, sessionId, "mqqapi://ecommerce/open?target=19&channel=8&is_master=1&is_trans_activity=1&is_appcompat_style=1&default_tab_id=0"), callback, null, 4, null);
        } else {
            ECScheme.f(k(liveUserId, liveRoomId, sessionId, "mqqapi://ecommerce/open?target=7&channel=8&window_type=3&src_type=internal&version=1"), callback, null, 4, null);
        }
    }

    private final void s(@ECLiveEvent int event, LiveTabId eventTabId, boolean isMaster, int channel, String mediaProductId, String liveUserId, long liveRoomId, LiveProduct liveProduct) {
        cg0.a.b("ECLiveHelper", "requestLiveWindowUpdate event:" + event + ", eventTabId:" + eventTabId + ", isMaster:" + isMaster + ", channel:" + channel + ", mediaProductId:" + mediaProductId + ", liveUserId:" + liveUserId + ", liveRoomId:" + liveRoomId + ", isLocal=true");
        LifecycleEventBus.f100688b.f(new ECLiveWindowLocalUpdateEvent(event, eventTabId, mediaProductId, liveUserId, String.valueOf(liveRoomId), liveProduct));
    }

    public final void g() {
        ECLiveTabInfoRepo.f105070b.c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0010, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(Map<String, String> data, IECLogicCallback callback) {
        Long longOrNull;
        HashMap<String, Object> hashMap = new HashMap<>();
        String str = data.get("PARAM_MONEY");
        if (str != null && longOrNull != null) {
            hashMap.put("PARAM_FORMAT_MONETY", com.tencent.ecommerce.biz.util.i.f104869a.b(longOrNull.longValue()));
            callback.onResult(hashMap);
        } else {
            callback.onResult(new HashMap<>());
        }
    }

    public final String i(long money) {
        return com.tencent.ecommerce.biz.util.i.f104869a.b(money);
    }

    public final void j(IECLogicCallback callback) {
        if (lastTransactionData != null) {
            TransactionData transactionData = lastTransactionData;
            if (transactionData != null) {
                callback.onResult(com.tencent.ecommerce.biz.live.c.a(transactionData));
            }
            lastTransactionData = null;
            return;
        }
        if (isRequestingTransactionData) {
            callbackForGetTransactionData = callback;
        } else {
            callback.onResult(new HashMap<>());
        }
    }

    public final String k(String liveUserId, long liveRoomId, String sessionId, String scheme) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        Uri.Builder buildUpon = Uri.parse(scheme).buildUpon();
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) scheme, (CharSequence) "live_user_id", false, 2, (Object) null);
        if (!contains$default && !TextUtils.isEmpty(liveUserId)) {
            buildUpon.appendQueryParameter("live_user_id", liveUserId);
        }
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) scheme, (CharSequence) "live_room_id", false, 2, (Object) null);
        if (!contains$default2) {
            buildUpon.appendQueryParameter("live_room_id", String.valueOf(liveRoomId));
        }
        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) scheme, (CharSequence) ServiceConst.PARA_SESSION_ID, false, 2, (Object) null);
        if (!contains$default3 && !TextUtils.isEmpty(sessionId)) {
            buildUpon.appendQueryParameter(ServiceConst.PARA_SESSION_ID, liveUserId);
        }
        return buildUpon.build().toString();
    }

    public final void n(HashMap<String, String> dataMap, IECLogicCallback callback) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        bundle.putString("is_trans_activity", "1");
        yi0.a.p(wg0.a.a(), ECLiveVideoSelectGoodsTypeFragment.class, bundle, 0, callback != null ? new c(callback) : null);
    }

    public final void o(HashMap<String, String> dataMap) {
        String str = dataMap.get("PARAM_ROOM_ID");
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr", "/trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr/Finish", new di0.e(str != null ? Long.parseLong(str) : 0L), new di0.c(), new d());
    }

    public final void p(HashMap<String, String> data) {
        String str = data.get("PARAM_USER_ID");
        if (str == null) {
            str = "";
        }
        String str2 = data.get("PARAM_ROOM_ID");
        long parseLong = str2 != null ? Long.parseLong(str2) : 0L;
        String str3 = data.get("PARAM_CHANNEL");
        if (str3 != null) {
            Integer.parseInt(str3);
        }
        String str4 = data.get("PARAM_OPEN_TAB_LEVEL");
        int parseInt = str4 != null ? Integer.parseInt(str4) : 0;
        String str5 = data.get("PARAM_TITLE");
        String str6 = str5 != null ? str5 : "";
        String str7 = data.get("PARAM_SESSION_ID");
        String str8 = str7 != null ? str7 : "";
        String str9 = data.get("PARAM_LIVE_TYPE");
        int parseInt2 = str9 != null ? Integer.parseInt(str9) : 0;
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr", "/trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr/Open", new di0.f(str, parseLong, parseInt, str6, str8), new di0.c(), new e(data));
        ei0.d.f396304b.v(str, parseLong, parseInt2);
    }

    public final void t(HashMap<String, String> dataMap) {
        String str = dataMap.get("PARAM_IS_MASTER");
        boolean parseBoolean = str != null ? Boolean.parseBoolean(str) : false;
        String str2 = dataMap.get("PARAM_CHANNEL");
        int parseInt = str2 != null ? Integer.parseInt(str2) : 0;
        String str3 = dataMap.get("PARAM_ROOM_ID");
        long parseLong = str3 != null ? Long.parseLong(str3) : 0L;
        ECLiveTabInfoRepo eCLiveTabInfoRepo = ECLiveTabInfoRepo.f105070b;
        eCLiveTabInfoRepo.c();
        eCLiveTabInfoRepo.i(parseBoolean, parseInt, parseLong);
    }

    public final void u(HashMap<String, String> dataMap, IECLogicCallback callback) {
        String str = dataMap.get("PARAM_CHANNEL");
        int parseInt = str != null ? Integer.parseInt(str) : 0;
        String str2 = dataMap.get("PARAM_ROOM_ID");
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr", "/trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr/GetBubbleInfo", new l(str2 != null ? Long.parseLong(str2) : 0L, parseInt, null, 4, null), new m(), new f(callback));
    }

    public final void v(Map<String, String> dataMap, IECLogicCallback callback) {
        String str = dataMap.get("PARAM_ROOM_ID");
        if (str == null) {
            str = "";
        }
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_product_dynamic_svr.QqliveProductDynamicSvr", "/trpc.ecom.qqlive_product_dynamic_svr.QqliveProductDynamicSvr/GetPurchaseBulletChat", new di0.a(str), new di0.b(), new g(callback));
    }

    public final void w(HashMap<String, String> dataMap, IECLogicCallback callback) {
        String str = dataMap.get("PARAM_USER_ID");
        if (str == null) {
            str = "";
        }
        String str2 = dataMap.get("PARAM_ROOM_ID");
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_entry_svr.QqliveEntrySvr", "/trpc.ecom.qqlive_entry_svr.QqliveEntrySvr/Get", new di0.d(str, str2 != null ? Long.parseLong(str2) : 0L), new ECLiveEntryResponse(), new h(callback));
    }

    public final void x(HashMap<String, String> dataMap) {
        String str = dataMap.get("PARAM_LIVE_EVENT_TYPE");
        int parseInt = str != null ? Integer.parseInt(str) : -1;
        String str2 = dataMap.get("PARAM_TAB_ID");
        int parseInt2 = str2 != null ? Integer.parseInt(str2) : 0;
        String str3 = dataMap.get("PARAM_IS_MASTER");
        boolean parseBoolean = str3 != null ? Boolean.parseBoolean(str3) : false;
        String str4 = dataMap.get("PARAM_CHANNEL");
        int parseInt3 = str4 != null ? Integer.parseInt(str4) : 0;
        String str5 = dataMap.get("PARAM_PRODUCT_ID");
        String str6 = str5 != null ? str5 : "";
        String str7 = dataMap.get("PARAM_USER_ID");
        String str8 = str7 != null ? str7 : "";
        String str9 = dataMap.get("PARAM_ROOM_ID");
        long parseLong = str9 != null ? Long.parseLong(str9) : 0L;
        cg0.a.b("ECLiveHelper", "requestLiveWindowUpdate event:" + parseInt + ", eventTabId:" + parseInt + ", isMaster:" + parseBoolean + ", channel:" + parseInt3 + ", mediaProductId:" + str6 + ", liveUserId:" + str8 + ", liveRoomId:" + parseLong + ", isLocal=false");
        LifecycleEventBus.f100688b.f(new ECLiveWindowRemoteUpdateEvent(parseInt, LiveTabId.INSTANCE.a(parseInt2), str6, str8, String.valueOf(parseLong), null));
        if (parseInt == 0 || parseInt == 1 || parseInt == 2) {
            ECLiveTabInfoRepo.f105070b.j(parseBoolean, parseInt3, parseLong);
        }
    }

    public final void y(HashMap<String, String> data) {
        String str = data.get("PARAM_START_TIME_SEC");
        int parseInt = str != null ? Integer.parseInt(str) : 0;
        String str2 = data.get("PARAM_END_TIME_SEC");
        int parseInt2 = str2 != null ? Integer.parseInt(str2) : 0;
        String str3 = data.get("PARAM_CHANNEL");
        int parseInt3 = str3 != null ? Integer.parseInt(str3) : 0;
        lastTransactionData = null;
        callbackForGetTransactionData = null;
        isRequestingTransactionData = true;
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.trade_data_panel_svr.TradeDataPanelSvr", "/trpc.ecom.trade_data_panel_svr.TradeDataPanelSvr/GetStatData", new di0.i(parseInt, parseInt2, parseInt3), new j(), new i());
    }

    public final void q(@ECLiveEvent int event, LiveTabId eventTabId, boolean isMaster, int channel, String liveUserId, long liveRoomId, LiveProduct liveProduct) {
        s(event, eventTabId, isMaster, channel, liveProduct != null ? liveProduct.getMediaProductId() : null, liveUserId, liveRoomId, liveProduct);
    }

    public final void m(HashMap<String, String> dataMap, IECLogicCallback callback) {
        C1057a c1057a = callback != null ? new C1057a(callback) : null;
        String str = dataMap.get("PARAM_USER_ID");
        String str2 = str != null ? str : "";
        String str3 = dataMap.get("PARAM_ROOM_ID");
        long parseLong = str3 != null ? Long.parseLong(str3) : 0L;
        String str4 = dataMap.get("PARAM_SESSION_ID");
        String str5 = str4 != null ? str4 : "";
        if (dataMap.containsKey("PARAM_ENTRY_JUMP_SCHEME")) {
            String str6 = dataMap.get("PARAM_ENTRY_JUMP_SCHEME");
            ECScheme.f(k(str2, parseLong, str5, str6 != null ? str6 : ""), c1057a, null, 4, null);
        } else {
            com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_entry_svr.QqliveEntrySvr", "/trpc.ecom.qqlive_entry_svr.QqliveEntrySvr/Get", new di0.d(str2, parseLong), new ECLiveEntryResponse(), new b(str2, parseLong, str5, c1057a));
        }
    }

    public final void r(@ECLiveEvent int event, LiveTabId eventTabId, boolean isMaster, int channel, String mediaProductId, String liveUserId, long liveRoomId) {
        s(event, eventTabId, isMaster, channel, mediaProductId, liveUserId, liveRoomId, null);
    }
}
