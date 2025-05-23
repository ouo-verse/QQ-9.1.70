package com.tencent.ecommerce.biz.orders.address;

import android.app.Activity;
import android.net.Uri;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J8\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\bH\u0007J0\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\bH\u0007J8\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\bH\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/c;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "addressId", "", "isFullScreenShow", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "", "callback", "a", "", "from", "address", "e", "Lcom/tencent/ecommerce/biz/orders/address/ECEditAddressFragment$b;", "originDistrictInfo", "c", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f103047a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/orders/address/c$a", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECSchemeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f103048a;

        a(Function1 function1) {
            this.f103048a = function1;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            JSONObject optJSONObject = data.optJSONObject("callbackAddress");
            if (optJSONObject != null) {
                this.f103048a.invoke(ECAddress.INSTANCE.a(optJSONObject));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/orders/address/c$b", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECSchemeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f103049a;

        b(Function1 function1) {
            this.f103049a = function1;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            ECEditAddressFragment.b a16 = ECEditAddressFragment.b.f103018e.a(data);
            if (a16 != null) {
                this.f103049a.invoke(a16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/orders/address/c$c", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.address.c$c, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class C1061c implements IECSchemeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f103050a;

        C1061c(Function1 function1) {
            this.f103050a = function1;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            JSONObject optJSONObject = data.optJSONObject("callbackAddress");
            if (optJSONObject != null) {
                this.f103050a.invoke(ECAddress.INSTANCE.a(optJSONObject));
            }
        }
    }

    c() {
    }

    @JvmStatic
    public static final void a(Activity activity, long addressId, boolean isFullScreenShow, Function1<? super ECAddress, Unit> callback) {
        Map mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("addressId", String.valueOf(addressId)));
        if (!isFullScreenShow) {
            mutableMapOf.put("is_trans_activity", "1");
        }
        yi0.a.t(Uri.parse(String.valueOf(28)), mutableMapOf, null, new a(callback), 4, null);
        if (isFullScreenShow) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    @JvmStatic
    public static final void e(int from, ECAddress address, Function1<? super ECAddress, Unit> callback) {
        Map mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("from", String.valueOf(from)));
        if (address != null) {
            mutableMapOf.put("addressInfo", com.tencent.ecommerce.biz.orders.address.b.d(address).toString());
        }
        yi0.a.t(Uri.parse(String.valueOf(27)), mutableMapOf, null, new C1061c(callback), 4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
    
        r7 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r7);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c(Activity activity, ECEditAddressFragment.b originDistrictInfo, boolean isFullScreenShow, Function1<? super ECEditAddressFragment.b, Unit> callback) {
        Map linkedHashMap;
        if (originDistrictInfo == null || (r7 = originDistrictInfo.b()) == null || linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
        }
        Map map = linkedHashMap;
        if (!isFullScreenShow) {
            map.put("is_trans_activity", "1");
        }
        yi0.a.t(Uri.parse(String.valueOf(34)), map, null, new b(callback), 4, null);
        if (isFullScreenShow) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    public static /* synthetic */ void b(Activity activity, long j3, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        a(activity, j3, z16, function1);
    }

    public static /* synthetic */ void d(Activity activity, ECEditAddressFragment.b bVar, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        c(activity, bVar, z16, function1);
    }
}
