package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.cache;

import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes31.dex */
public final class QPlusTrafficCache<RSP extends ISSORspModel<RSP>> implements IQPlusTrafficCache<RSP> {
    public final Map<String, RSP> caches = new LinkedHashMap();
    public final RSP decoder;
    public final String keyPrefix;

    public QPlusTrafficCache(String str, RSP rsp) {
        this.keyPrefix = str;
        this.decoder = rsp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11, types: [com.tencent.hippykotlin.demo.pages.base.ISSORspModel] */
    public final RSP getCache(String str, boolean z16) {
        String str2 = this.keyPrefix + util.base64_pad_url + str;
        if (z16 || !this.caches.containsKey(str2)) {
            String cachedFromNative = Utils.INSTANCE.currentBridgeModule().getCachedFromNative(str2);
            RSP rsp = cachedFromNative.length() > 0 ? (ISSORspModel) this.decoder.decode(new e(cachedFromNative)) : null;
            if (rsp == null) {
                return rsp;
            }
            this.caches.put(str2, rsp);
            return rsp;
        }
        if (this.caches.containsKey(str2)) {
            return (RSP) this.caches.get(str2);
        }
        return null;
    }

    public final void saveCache(String str, RSP rsp, String str2) {
        String str3 = this.keyPrefix + util.base64_pad_url + str;
        this.caches.put(str3, rsp);
        Utils.INSTANCE.currentBridgeModule().setCachedToNative(str3, str2, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.cache.QPlusTrafficCache$saveCache$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                return Unit.INSTANCE;
            }
        });
        KLog.INSTANCE.i("QPlus", "save cache, [key:" + str3 + ']');
    }
}
