package lz3;

import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.reshub.core.k;
import iz3.q;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fR\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R2\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b\u0017\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Llz3/a;", "Liz3/q;", "Lorg/json/JSONArray;", "cdnBusyList", "", "d", "", "cdnBusy", "e", "Lorg/json/JSONObject;", "data", "a", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "c", "Z", "isCDNOverload", "()Z", "setCDNOverload", "(Z)V", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getBusyCDNIDs", "()Ljava/util/ArrayList;", "setBusyCDNIDs", "(Ljava/util/ArrayList;)V", "busyCDNIDs", "", "I", "()I", "setSampling", "(I)V", "sampling", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a implements q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isCDNOverload;

    /* renamed from: d, reason: collision with root package name */
    public static final a f415844d = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static volatile ArrayList<String> busyCDNIDs = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile int sampling = 1;

    a() {
    }

    private final void d(JSONArray cdnBusyList) {
        ArrayList<String> arrayList = new ArrayList<>();
        int length = cdnBusyList.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(String.valueOf(cdnBusyList.optLong(i3)));
        }
        if (!Intrinsics.areEqual(busyCDNIDs, arrayList)) {
            jz3.d.e("CDNOverloadMarker", "Receive CDN Busy IDs: " + arrayList);
            busyCDNIDs = arrayList;
        }
    }

    private final void e(boolean cdnBusy) {
        if (cdnBusy != isCDNOverload) {
            jz3.d.i("CDNOverloadMarker", "CDN Busy Status Changed: " + isCDNOverload + " -> " + cdnBusy);
            isCDNOverload = cdnBusy;
        }
    }

    @Override // iz3.q
    public void a(@Nullable JSONObject data) {
        JSONObject jSONObject;
        Boolean bool;
        JSONArray jSONArray = null;
        if (data != null) {
            jSONObject = data.optJSONObject("reshubBizData");
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            bool = Boolean.valueOf(jSONObject.optBoolean("cdnBusy"));
        } else {
            bool = null;
        }
        if (jSONObject != null) {
            jSONArray = jSONObject.optJSONArray("cdnBusyIds");
        }
        int i3 = 1;
        if (jSONObject != null) {
            i3 = jSONObject.optInt("sampling", 1);
        }
        sampling = i3;
        jz3.d.a("CDNOverloadMarker", "onReceiveData sampling: " + sampling);
        if (jSONArray != null) {
            d(jSONArray);
        } else {
            jz3.d.c("CDNOverloadMarker", "Receive RDelivery SubSystemResp, But Busy CDN Id List Not Found: " + data);
        }
        if (bool != null) {
            jz3.d.a("CDNOverloadMarker", "Receive CDN Busy Status: " + bool);
            e(bool.booleanValue());
            return;
        }
        jz3.d.c("CDNOverloadMarker", "Receive RDelivery SubSystemResp, But CDN Busy Status Not Found: " + data);
    }

    public final int b() {
        return sampling;
    }

    public final boolean c(@NotNull k req) {
        jz3.e eVar;
        String str;
        RDeliveryData z16;
        Intrinsics.checkParameterIsNotNull(req, "req");
        RDelivery rDelivery = req.getRDelivery();
        if (rDelivery != null && (z16 = RDelivery.z(rDelivery, req.x(), null, true, 2, null)) != null) {
            eVar = h.b(z16);
        } else {
            eVar = null;
        }
        if (eVar == null || (str = eVar.F) == null) {
            str = "0";
        }
        if (Intrinsics.areEqual(str, "0")) {
            return isCDNOverload;
        }
        return busyCDNIDs.contains(str);
    }
}
