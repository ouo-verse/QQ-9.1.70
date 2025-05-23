package com.tencent.ecommerce.biz.webviewplugin.processor;

import com.tencent.ecommerce.biz.webviewplugin.IECWebViewPluginCallBack;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/webviewplugin/processor/IECWebViewPluginProcessor;", "", "invoke", "", "reqData", "Lorg/json/JSONObject;", "callback", "Lcom/tencent/ecommerce/biz/webviewplugin/IECWebViewPluginCallBack;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECWebViewPluginProcessor {
    void invoke(JSONObject reqData, IECWebViewPluginCallBack callback);
}
