package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge;

import com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002R$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/b;", "", "", "ns", "method", "", "b", "Lorg/json/JSONObject;", "jsonObject", "callback", "a", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/a;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "nsHandlerList", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;", "bridgeModule", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<a> nsHandlerList;

    public b(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a bridgeModule) {
        Intrinsics.checkNotNullParameter(bridgeModule, "bridgeModule");
        ArrayList<a> arrayList = new ArrayList<>(16);
        this.nsHandlerList = arrayList;
        arrayList.add(new RIJBridgeInvokeHandler(bridgeModule));
        arrayList.add(new DataBridgeInvokeHandler(bridgeModule));
        arrayList.add(new UIBridgeInvokeHandler(bridgeModule));
        arrayList.add(new AppBridgeInvokeHandler(bridgeModule));
        arrayList.add(new DeviceBridgeInvokeHandler(bridgeModule));
        arrayList.add(new MediaBridgeInvokeHandler(bridgeModule));
        arrayList.add(new e(bridgeModule));
        arrayList.add(new EventBridgeInvokeHandler(bridgeModule));
        arrayList.add(new f(bridgeModule));
        arrayList.add(new GDTBridgeInvokeHandler(bridgeModule));
        arrayList.add(new NowLiveBridgeInvokeHandler(bridgeModule));
        arrayList.add(new PublicAccountNewBridgeInvokeHandler(bridgeModule));
        arrayList.add(new SensorBridgeInvokeHandler(bridgeModule));
    }

    private final boolean b(String ns5, String method) {
        return ("downloadApp".equals(method) && "app".equals(ns5)) || ("openRoom".equals(method) && NowLiveNativePlugin.PLUGIN_NAME.equals(ns5));
    }

    public final boolean a(String ns5, String method, JSONObject jsonObject, String callback) {
        Intrinsics.checkNotNullParameter(ns5, "ns");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        if (!b(ns5, method)) {
            jsonObject = jsonObject.optJSONObject("params");
        }
        Iterator<a> it = this.nsHandlerList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.e(ns5)) {
                return next.d(method, jsonObject, callback);
            }
        }
        return false;
    }
}
