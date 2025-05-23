package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtLoadAdJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtLoadAdJsCallHandler";

    @Nullable
    private WeakReference<GdtAdWebPlugin> webPlugin;

    @NonNull
    private Map<GdtAdLoader, String> map = new HashMap();

    @NonNull
    private GdtAdLoader.Listener listener = new a();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements GdtAdLoader.Listener {
        a() {
        }

        @Override // com.tencent.gdtad.aditem.GdtAdLoader.Listener
        public void onResponse(@Nullable GdtAdLoader gdtAdLoader) {
            if (gdtAdLoader != null && gdtAdLoader.getSession() != null && GdtLoadAdJsCallHandler.this.webPlugin != null && GdtLoadAdJsCallHandler.this.webPlugin.get() != null) {
                String str = (String) GdtLoadAdJsCallHandler.this.map.get(gdtAdLoader);
                GdtLoadAdJsCallHandler.this.map.remove(gdtAdLoader);
                Object pbToJson = GdtJsonPbUtil.pbToJson(gdtAdLoader.getSession().request);
                Object pbToJson2 = GdtJsonPbUtil.pbToJson(gdtAdLoader.getSession().response);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(Const.BUNDLE_KEY_REQUEST, pbToJson);
                    jSONObject.put("response", pbToJson2);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                ((GdtAdWebPlugin) GdtLoadAdJsCallHandler.this.webPlugin.get()).callJs(str, jSONObject.toString());
            }
        }
    }

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null && activity != null) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                GdtLog.i(TAG, jSONObject.toString());
                GdtAdLoader.Session session = new GdtAdLoader.Session();
                session.supportOpenMotiveAd = true;
                session.request = (qq_ad_get.QQAdGet) qq_ad_get.QQAdGet.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGet(), jSONObject));
                this.webPlugin = new WeakReference<>(gdtAdWebPlugin);
                GdtAdLoader gdtAdLoader = new GdtAdLoader(session, new WeakReference(this.listener));
                this.map.put(gdtAdLoader, str);
                gdtAdLoader.load(new WeakReference<>(activity));
                ArrayList arrayList = new ArrayList();
                qq_ad_get.QQAdGet qQAdGet = session.request;
                if (qQAdGet != null && !qQAdGet.position_info.isEmpty()) {
                    for (int i3 = 0; i3 < session.request.position_info.size(); i3++) {
                        String str2 = session.request.position_info.get(i3).pos_id.get();
                        if (TextUtils.isEmpty(str2)) {
                            arrayList.add(str2);
                        }
                    }
                }
                AdAnalysisHelperForUtil.reportForJSBridgeInvoked(activity, false, "loadAd", gdtAdWebPlugin.getCurrentUrl());
                return true;
            } catch (JSONException e16) {
                GdtLog.e(TAG, "handleJsCallRequest error", e16);
                return true;
            }
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
