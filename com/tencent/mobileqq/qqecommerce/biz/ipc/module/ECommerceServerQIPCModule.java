package com.tencent.mobileqq.qqecommerce.biz.ipc.module;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqecommerce.biz.live.api.QQECLiveEntryGoodsData;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.ServiceConst;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import vf2.c;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/ipc/module/ECommerceServerQIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "moduleName", "<init>", "(Ljava/lang/String;)V", "d", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECommerceServerQIPCModule extends QIPCModule {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ECommerceServerQIPCModule> f262759e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/ipc/module/ECommerceServerQIPCModule$a;", "", "Lcom/tencent/mobileqq/qqecommerce/biz/ipc/module/ECommerceServerQIPCModule;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qqecommerce/biz/ipc/module/ECommerceServerQIPCModule;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.ipc.module.ECommerceServerQIPCModule$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ECommerceServerQIPCModule a() {
            return (ECommerceServerQIPCModule) ECommerceServerQIPCModule.f262759e.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002=\u0012/\u0012-\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\nJ-\u0010\u000b\u001a\u00020\t2\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0096\u0002\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/ipc/module/ECommerceServerQIPCModule$b", "Lkotlin/Function1;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceLogicCallback;", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements Function1<HashMap<String, Object>, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap<String, String> f262760d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f262761e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ECommerceServerQIPCModule f262762f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f262763h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f262764i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f262765m;

        b(HashMap<String, String> hashMap, Ref.BooleanRef booleanRef, ECommerceServerQIPCModule eCommerceServerQIPCModule, int i3, int i16, int i17) {
            this.f262760d = hashMap;
            this.f262761e = booleanRef;
            this.f262762f = eCommerceServerQIPCModule;
            this.f262763h = i3;
            this.f262764i = i16;
            this.f262765m = i17;
        }

        public void a(HashMap<String, Object> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            Object obj = result.get("PARAM_JSON_RESULT");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            JSONObject jSONObject = (JSONObject) obj;
            QLog.d("ECommerceServerQIPCModule", 2, "ACTION_CLICK_LIVE_ENTRY onCallbackFinished, jsonObject: " + jSONObject);
            if (jSONObject.has("is_from_mywindow")) {
                this.f262760d.put("PARAM_ENTRY_JUMP_SCHEME", "mqqapi://ecommerce/open?target=19&channel=8&is_master=1&is_trans_activity=1&is_appcompat_style=1");
                Ref.BooleanRef booleanRef = this.f262761e;
                booleanRef.element = jSONObject.optBoolean("is_wangzhe_select", booleanRef.element);
                ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(122, this.f262760d, this);
                return;
            }
            if (jSONObject.has("is_from_shopwindow")) {
                this.f262760d.put("PARAM_ENTRY_JUMP_SCHEME", "mqqapi://ecommerce/open?target=19&channel=8&is_master=1&is_trans_activity=1&is_appcompat_style=1&default_tab_id=2");
                Ref.BooleanRef booleanRef2 = this.f262761e;
                booleanRef2.element = jSONObject.optBoolean("is_wangzhe_select", booleanRef2.element);
                ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(122, this.f262760d, this);
                return;
            }
            if (jSONObject.has("PARAM_ENTRY_SCHEME_ERROR")) {
                this.f262762f.callbackResult(this.f262763h, EIPCResult.createResult(-102, new Bundle()));
            } else if (jSONObject.has("live_product_counts") || jSONObject.has("shop_product_counts") || jSONObject.has("is_wangzhe_select")) {
                Bundle bundle = new Bundle();
                bundle.putInt("live_product_counts", jSONObject.optInt("live_product_counts", this.f262764i));
                bundle.putInt("live_shop_product_counts", jSONObject.optInt("shop_product_counts", this.f262765m));
                bundle.putBoolean("GOK_LIVE_SELECT_WANGZHE", jSONObject.optBoolean("is_wangzhe_select", this.f262761e.element));
                this.f262762f.callbackResult(this.f262763h, EIPCResult.createSuccessResult(bundle));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
            a(hashMap);
            return Unit.INSTANCE;
        }
    }

    static {
        Lazy<ECommerceServerQIPCModule> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECommerceServerQIPCModule>() { // from class: com.tencent.mobileqq.qqecommerce.biz.ipc.module.ECommerceServerQIPCModule$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECommerceServerQIPCModule invoke() {
                return new ECommerceServerQIPCModule("EcommerceIPCModule");
            }
        });
        f262759e = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECommerceServerQIPCModule(String moduleName) {
        super(moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0032. Please report as an issue. */
    @Override // eipc.EIPCModule
    public EIPCResult onCall(String action, Bundle params, final int callbackId) {
        String str;
        String str2;
        HashMap<String, String> hashMapOf;
        String string;
        HashMap<String, String> hashMapOf2;
        HashMap<String, String> hashMapOf3;
        String string2;
        HashMap<String, String> hashMapOf4;
        HashMap<String, String> hashMapOf5;
        HashMap<String, String> hashMapOf6;
        HashMap<String, String> hashMapOf7;
        HashMap<String, String> hashMapOf8;
        HashMap<String, String> hashMapOf9;
        if (action != null) {
            String str3 = "";
            switch (action.hashCode()) {
                case -2070117584:
                    if (action.equals("ACTION_NOTIFY_LIVE_OPEN")) {
                        if (params == null || (str = params.getString("KEY_LIVE_USER_ID")) == null) {
                            str = "";
                        }
                        long j3 = params != null ? params.getLong("KEY_LIVE_ROOM_ID") : 0L;
                        int i3 = params != null ? params.getInt("KEY_CHANNEL") : 0;
                        int i16 = params != null ? params.getInt("KEY_OPENTAB_LEVEL") : 0;
                        if (params == null || (str2 = params.getString("KEY_TITLE")) == null) {
                            str2 = "";
                        }
                        int i17 = params != null ? params.getInt("KEY_LIVE_TYPE") : 0;
                        if (params != null && (string = params.getString(TraeConstants.KEY_SESSION_ID)) != null) {
                            str3 = string;
                        }
                        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_USER_ID", str), new Pair("PARAM_ROOM_ID", String.valueOf(j3)), new Pair("PARAM_CHANNEL", String.valueOf(i3)), new Pair("PARAM_OPEN_TAB_LEVEL", String.valueOf(i16)), new Pair("PARAM_TITLE", str2), new Pair("PARAM_LIVE_TYPE", String.valueOf(i17)), new Pair("PARAM_SESSION_ID", str3));
                        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(104, hashMapOf, null);
                        return null;
                    }
                    return null;
                case -1371977775:
                    if (action.equals("ACTION_SETUP_LIVE_REPORT_INFO") && params != null) {
                        c.f441540a.b(params);
                    }
                    return null;
                case -1288472269:
                    if (action.equals("ACTION_CLICK_LIVE_ENTRY_ONLINE")) {
                        String string3 = params != null ? params.getString("KEY_LIVE_USER_ID", "") : null;
                        long j16 = params != null ? params.getLong("KEY_LIVE_ROOM_ID") : 0L;
                        Uri.Builder buildUpon = Uri.parse("mqqapi://ecommerce/open?target=19&channel=8&is_master=1&is_live_opened=1&is_trans_activity=1&is_appcompat_style=1").buildUpon();
                        buildUpon.appendQueryParameter("live_user_id", string3);
                        buildUpon.appendQueryParameter("live_room_id", String.valueOf(j16));
                        IQQECommerceSdk iQQECommerceSdk = (IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class);
                        String uri = buildUpon.build().toString();
                        Intrinsics.checkNotNullExpressionValue(uri, "builder.build().toString()");
                        iQQECommerceSdk.handleScheme(uri, null);
                        return null;
                    }
                    return null;
                case -1036618987:
                    if (action.equals("ACTION_NOTIFY_LIVE_END")) {
                        hashMapOf2 = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_ROOM_ID", String.valueOf(params != null ? params.getLong("KEY_LIVE_ROOM_ID") : 0L)));
                        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(105, hashMapOf2, null);
                        return null;
                    }
                    return null;
                case -509736176:
                    if (action.equals("ACTION_CLEAR_LIVE_TAB_INFO")) {
                        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(109, new HashMap<>(), null);
                        return null;
                    }
                    return null;
                case 715055057:
                    if (action.equals("ACTION_REQUEST_LIVE_ENTRY_DATA")) {
                        if (params != null && (string2 = params.getString("KEY_LIVE_USER_ID")) != null) {
                            str3 = string2;
                        }
                        hashMapOf3 = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_USER_ID", str3), new Pair("PARAM_ROOM_ID", String.valueOf(params != null ? params.getLong("KEY_LIVE_ROOM_ID") : 0L)));
                        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(116, hashMapOf3, new Function1<HashMap<String, Object>, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.ipc.module.ECommerceServerQIPCModule$onCall$9
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
                                invoke2(hashMap);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(HashMap<String, Object> result) {
                                Intrinsics.checkNotNullParameter(result, "result");
                                Object obj = result.get("PARAM_XWORLD_AUTHENTICATED");
                                Object obj2 = result.get("PARAM_ECOM_AUTHENTICATED");
                                Object obj3 = result.get("PARAM_LIVE_GOODS_NUMBER");
                                Object obj4 = result.get("PARAM_LIVE_SHOP_GOODS_NUMBER");
                                Object obj5 = result.get("PARAM_WANGZHE_GOODS_NUMBER");
                                Object obj6 = result.get("PARAM_IS_WANGZHE_WHITE_LIST_USER");
                                Object obj7 = result.get("PARAM_IS_XIAODIAN_WHITE_LIST_USER");
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                                boolean booleanValue = ((Boolean) obj).booleanValue();
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                                boolean booleanValue2 = ((Boolean) obj2).booleanValue();
                                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                                int intValue = ((Integer) obj3).intValue();
                                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
                                int intValue2 = ((Integer) obj5).intValue();
                                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
                                int intValue3 = ((Integer) obj4).intValue();
                                Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Boolean");
                                boolean booleanValue3 = ((Boolean) obj6).booleanValue();
                                Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Boolean");
                                QQECLiveEntryGoodsData qQECLiveEntryGoodsData = new QQECLiveEntryGoodsData(booleanValue, booleanValue2, intValue, intValue2, intValue3, booleanValue3, ((Boolean) obj7).booleanValue(), false, 128, null);
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("KEY_LIVE_ENTRY_GOODS_DATA", qQECLiveEntryGoodsData);
                                ECommerceServerQIPCModule.this.callbackResult(callbackId, EIPCResult.createSuccessResult(bundle));
                            }
                        });
                        return null;
                    }
                    return null;
                case 768882015:
                    if (action.equals("ACTION_CLICK_LIVE_ENTRY")) {
                        if (params == null) {
                            return null;
                        }
                        QLog.d("ECommerceServerQIPCModule", 2, "ACTION_CLICK_LIVE_ENTRY start handleLiveScheme data:" + params);
                        String string4 = params.getString("KEY_LIVE_USER_ID", "");
                        long j17 = params.getLong("KEY_LIVE_ROOM_ID");
                        String valueOf = String.valueOf(params.getBoolean("is_ecommerce_authenticated", false));
                        String valueOf2 = String.valueOf(Boolean.valueOf(params.getBoolean("is_xiaodian_user", false)));
                        int i18 = params.getInt("live_product_counts", 0);
                        int i19 = params.getInt("live_shop_product_counts", 0);
                        String valueOf3 = String.valueOf(Boolean.valueOf(params.getBoolean("is_wangzhe_user", false)));
                        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                        booleanRef.element = params.getBoolean("is_wangzhe_select", false);
                        hashMapOf4 = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_USER_ID", string4), new Pair("PARAM_ROOM_ID", String.valueOf(j17)), new Pair("PARAM_IS_ECOMMERCE_AUTH", valueOf), new Pair("PARAM_IS_XIAODIAN_USER", valueOf2), new Pair("live_product_counts", String.valueOf(i18)), new Pair("shop_product_counts", String.valueOf(i19)), new Pair("is_wangzhe_select", String.valueOf(booleanRef.element)), new Pair("is_wangzhe_user", valueOf3));
                        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(115, hashMapOf4, new b(hashMapOf4, booleanRef, this, callbackId, i18, i19));
                        return null;
                    }
                    break;
                case 921602966:
                    if (action.equals("ACTION_JUMP_WITH_SCHEME")) {
                        String string5 = params != null ? params.getString("KEY_URL") : null;
                        if (string5 != null) {
                            ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme(string5, new Function1<JSONObject, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.ipc.module.ECommerceServerQIPCModule$onCall$6$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                                    invoke2(jSONObject);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(JSONObject json) {
                                    Intrinsics.checkNotNullParameter(json, "json");
                                    Bundle bundle = new Bundle();
                                    bundle.putString("KEY_JSON_RESULT", json.toString());
                                    ECommerceServerQIPCModule.this.callbackResult(callbackId, EIPCResult.createSuccessResult(bundle));
                                }
                            });
                            break;
                        }
                    }
                    break;
                case 930110020:
                    if (action.equals("ACTION_REQUEST_TRANSACTION_DATA")) {
                        hashMapOf5 = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_START_TIME_SEC", String.valueOf(params != null ? params.getInt("KEY_START_TIME") : 0)), new Pair("PARAM_END_TIME_SEC", String.valueOf(params != null ? params.getInt("KEY_END_TIME") : 0)), new Pair("PARAM_CHANNEL", String.valueOf(params != null ? params.getInt("KEY_CHANNEL") : 0)));
                        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(102, hashMapOf5, null);
                        break;
                    }
                    break;
                case 960696834:
                    if (action.equals("ACTION_GET_LAST_TRANSACTION_DATA")) {
                        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(103, new HashMap<>(), new Function1<HashMap<String, Object>, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.ipc.module.ECommerceServerQIPCModule$onCall$5
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
                                invoke2(hashMap);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(HashMap<String, Object> result) {
                                Intrinsics.checkNotNullParameter(result, "result");
                                if (result.size() > 0) {
                                    Bundle bundle = new Bundle();
                                    Object obj = result.get("PARAMS_ORDER_MONEY");
                                    String str4 = obj instanceof String ? (String) obj : null;
                                    bundle.putLong("KEY_ORDER_MONEY", str4 != null ? Long.parseLong(str4) : 0L);
                                    Object obj2 = result.get("PARAMS_ORDER_NUM");
                                    String str5 = obj2 instanceof String ? (String) obj2 : null;
                                    bundle.putLong("KEY_ORDER_NUM", str5 != null ? Long.parseLong(str5) : 0L);
                                    Object obj3 = result.get("PARAMS_PERSON_NUM");
                                    String str6 = obj3 instanceof String ? (String) obj3 : null;
                                    bundle.putLong("KEY_PERSON_NUM", str6 != null ? Long.parseLong(str6) : 0L);
                                    Object obj4 = result.get("PARAM_FORMAT_MONETY");
                                    bundle.putString("KEY_FORMAT_ORDER_MONEY", obj4 instanceof String ? (String) obj4 : null);
                                    ECommerceServerQIPCModule.this.callbackResult(callbackId, EIPCResult.createSuccessResult(bundle));
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("ECommerceServerQIPCModule", 2, "onCall: ACTION_GET_LAST_TRANSACTION_DATA, no result");
                                }
                            }
                        });
                        break;
                    }
                    break;
                case 1077610846:
                    if (action.equals("ACTION_REQUEST_LIVE_WINDOW_UPDATE") && params != null) {
                        hashMapOf6 = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_USER_ID", params.getString("KEY_LIVE_USER_ID", "")), new Pair("PARAM_ROOM_ID", String.valueOf(params.getLong("KEY_LIVE_ROOM_ID"))), new Pair("PARAM_LIVE_EVENT_TYPE", String.valueOf(params.getInt("KEY_LIVE_EVENT_TYPE", 0))), new Pair("PARAM_TAB_ID", String.valueOf(params.getInt("KEY_LIVE_TAB_ID"))), new Pair("PARAM_PRODUCT_ID", params.getString("KEY_LIVE_MEDIA_PRODUCT_ID", "")), new Pair("PARAM_IS_MASTER", String.valueOf(params.getBoolean("KEY_LIVE_IS_MASTER"))), new Pair("PARAM_CHANNEL", String.valueOf(params.getInt("KEY_CHANNEL"))));
                        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(106, hashMapOf6, null);
                        return EIPCResult.createSuccessResult(null);
                    }
                    break;
                case 1327620792:
                    if (action.equals("ACTION_REQUEST_LIVE_BUYING_BUBBLE_INFO") && params != null) {
                        hashMapOf7 = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_ROOM_ID", String.valueOf(params.getLong("KEY_LIVE_ROOM_ID"))));
                        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(125, hashMapOf7, new Function1<HashMap<String, Object>, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.ipc.module.ECommerceServerQIPCModule$onCall$3$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
                                invoke2(hashMap);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(HashMap<String, Object> result) {
                                Intrinsics.checkNotNullParameter(result, "result");
                                if (!result.isEmpty()) {
                                    Bundle bundle = new Bundle();
                                    Object obj = result.get("PARAM_BUYING_BUBBLE_TEXT");
                                    String str4 = obj instanceof String ? (String) obj : null;
                                    if (str4 == null) {
                                        str4 = "";
                                    }
                                    bundle.putString("KEY_LIVE_BUYING_BUBBLE_TEXT", str4);
                                    Object obj2 = result.get("PARAM_BUYING_BUBBLE_TIME_INTERVALS");
                                    Long l3 = obj2 instanceof Long ? (Long) obj2 : null;
                                    bundle.putLong("KEY_LIVE_BUYING_BUBBLE_REQUEST_INTERVALS", l3 != null ? l3.longValue() : 0L);
                                    ECommerceServerQIPCModule.this.callbackResult(callbackId, EIPCResult.createSuccessResult(bundle));
                                    return;
                                }
                                ECommerceServerQIPCModule.this.callbackResult(callbackId, EIPCResult.createResult(-102, null));
                            }
                        });
                        break;
                    }
                    break;
                case 1394574183:
                    if (action.equals("ACTION_REQUEST_LIVE_BUBBLE_INFO") && params != null) {
                        hashMapOf8 = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_ROOM_ID", String.valueOf(params.getLong("KEY_LIVE_ROOM_ID"))), new Pair("PARAM_CHANNEL", String.valueOf(params.getInt("KEY_CHANNEL"))));
                        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(107, hashMapOf8, new Function1<HashMap<String, Object>, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.ipc.module.ECommerceServerQIPCModule$onCall$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
                                invoke2(hashMap);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(HashMap<String, Object> result) {
                                Intrinsics.checkNotNullParameter(result, "result");
                                if (!result.isEmpty()) {
                                    Bundle bundle = new Bundle();
                                    Object obj = result.get("PARAM_RICH_TXT");
                                    bundle.putString("VALUE_LIVE_BUBBLE_RICHTEXT", obj instanceof String ? (String) obj : null);
                                    Object obj2 = result.get("PARAM_DETAIL_URL");
                                    bundle.putString("VALUE_LIVE_BUBBLE_DETAILURL", obj2 instanceof String ? (String) obj2 : null);
                                    Object obj3 = result.get("PARAM_PRODUCT_ID");
                                    bundle.putString("VALUE_LIVE_BUBBLE_PRODUCTID", obj3 instanceof String ? (String) obj3 : null);
                                    Object obj4 = result.get("PARAM_REPORT_INFO");
                                    bundle.putSerializable("VALUE_LIVE_BUBBLE_REPORTINFO", obj4 instanceof HashMap ? (HashMap) obj4 : null);
                                    ECommerceServerQIPCModule.this.callbackResult(callbackId, EIPCResult.createSuccessResult(bundle));
                                    return;
                                }
                                ECommerceServerQIPCModule.this.callbackResult(callbackId, EIPCResult.createResult(-102, null));
                            }
                        });
                        break;
                    }
                    break;
                case 1554591100:
                    if (action.equals("ACTION_JUMP_GOODS_TYPE_FLOAT_SCHEME")) {
                        String string6 = params != null ? params.getString("KEY_LIVE_USER_ID", "") : null;
                        long j18 = params != null ? params.getLong("KEY_LIVE_ROOM_ID") : 0L;
                        String string7 = params != null ? params.getString(TraeConstants.KEY_SESSION_ID, "") : null;
                        Uri.Builder buildUpon2 = Uri.parse("mqqapi://ecommerce/open?target=25&channel=8&is_trans_activity=1&is_appcompat_style=1").buildUpon();
                        buildUpon2.appendQueryParameter("live_user_id", string6);
                        buildUpon2.appendQueryParameter("live_room_id", String.valueOf(j18));
                        if (params != null && params.containsKey("entryJumpScheme")) {
                            buildUpon2.appendQueryParameter("entryJumpScheme", params.getString("entryJumpScheme", ""));
                        }
                        if (!TextUtils.isEmpty(string7)) {
                            buildUpon2.appendQueryParameter(ServiceConst.PARA_SESSION_ID, string7);
                        }
                        buildUpon2.appendQueryParameter("is_wangzhe_user", String.valueOf(params != null ? Boolean.valueOf(params.getBoolean("is_wangzhe_user", false)) : null));
                        buildUpon2.appendQueryParameter("is_wangzhe_select", String.valueOf(params != null ? Boolean.valueOf(params.getBoolean("is_wangzhe_select", false)) : null));
                        buildUpon2.appendQueryParameter("is_window_select", String.valueOf(params != null ? Boolean.valueOf(params.getBoolean("is_window_select", false)) : null));
                        buildUpon2.appendQueryParameter("live_product_counts", String.valueOf(params != null ? Integer.valueOf(params.getInt("live_product_counts", 0)) : null));
                        buildUpon2.appendQueryParameter("is_not_authenticated", String.valueOf(params != null ? Boolean.valueOf(params.getBoolean("is_not_authenticated", false)) : null));
                        IQQECommerceSdk iQQECommerceSdk2 = (IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class);
                        String uri2 = buildUpon2.build().toString();
                        Intrinsics.checkNotNullExpressionValue(uri2, "builder.build().toString()");
                        iQQECommerceSdk2.handleScheme(uri2, new Function1<JSONObject, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.ipc.module.ECommerceServerQIPCModule$onCall$8
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                                invoke2(jSONObject);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(JSONObject it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.d("ECommerceServerQIPCModule", 2, "ACTION_JUMP_GOODS_TYPE_FLOAT_SCHEME onCallbackFinished, jsonObject: " + it);
                                Bundle bundle = new Bundle();
                                bundle.putInt("live_product_counts", it.optInt("live_product_counts"));
                                bundle.putBoolean("GOK_LIVE_SELECT_WANGZHE", it.optBoolean("GOK_LIVE_SELECT_WANGZHE"));
                                bundle.putBoolean("GOK_LIVE_SELECT_WINDOW", it.optBoolean("GOK_LIVE_SELECT_WINDOW"));
                                ECommerceServerQIPCModule.this.callbackResult(callbackId, EIPCResult.createSuccessResult(bundle));
                            }
                        });
                        break;
                    }
                    break;
                case 1617480716:
                    if (action.equals("ACTION_PRELOAD_LIVE_TAB_INFO")) {
                        hashMapOf9 = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_ROOM_ID", String.valueOf(params != null ? params.getLong("KEY_LIVE_ROOM_ID", 0L) : 0L)), new Pair("PARAM_IS_MASTER", String.valueOf(params != null ? params.getBoolean("KEY_LIVE_IS_MASTER", false) : false)), new Pair("PARAM_CHANNEL", "8"));
                        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(108, hashMapOf9, null);
                        break;
                    }
                    break;
                case 1804915739:
                    if (action.equals("ACTION_TERMINAL_REAL_REPORT") && params != null) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        for (String key : params.keySet()) {
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            String string8 = params.getString(key);
                            if (string8 == null) {
                                string8 = "";
                            }
                            Intrinsics.checkNotNullExpressionValue(string8, "it.getString(key) ?: \"\"");
                            hashMap.put(key, string8);
                        }
                        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(120, hashMap, null);
                        break;
                    }
                    break;
                case 1883020667:
                    if (action.equals("ACTION_SELECTED_MEDIA_CALLBACK") && params != null) {
                        params.setClassLoader(ECommerceServerQIPCModule.class.getClassLoader());
                        int i26 = params.getInt("from");
                        ArrayList parcelableArrayList = params.getParcelableArrayList(QQWinkConstants.INPUT_MEDIA);
                        if (parcelableArrayList == null) {
                            return null;
                        }
                        Intrinsics.checkNotNullExpressionValue(parcelableArrayList, "it.getParcelableArrayLis\u2026PUT_MEDIA) ?: return null");
                        if (i26 != 1) {
                            if (i26 == 2) {
                                xe2.c.f447853a.h(parcelableArrayList);
                                break;
                            }
                        } else {
                            xe2.c.f447853a.f(parcelableArrayList);
                            break;
                        }
                    }
                    break;
            }
        }
        return null;
    }
}
