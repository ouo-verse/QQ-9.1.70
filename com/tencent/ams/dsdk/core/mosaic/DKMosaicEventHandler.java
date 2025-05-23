package com.tencent.ams.dsdk.core.mosaic;

import android.text.TextUtils;
import com.tencent.ams.dsdk.event.DKMethodDispatcher;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.mosaic.g;
import com.tencent.ams.mosaic.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKMosaicEventHandler implements i {
    static IPatchRedirector $redirector_ = null;
    public static final String MODULE_ID = "MosaicEventCenter";
    private static final String TAG = "DKMosaicEventHandler";
    private final DKMethodDispatcher mMethodDispatcher;

    public DKMosaicEventHandler(DKMethodDispatcher dKMethodDispatcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dKMethodDispatcher);
        } else {
            this.mMethodDispatcher = dKMethodDispatcher;
        }
    }

    @Override // com.tencent.ams.mosaic.i
    public void onEvent(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
            return;
        }
        if (gVar != null && this.mMethodDispatcher != null) {
            try {
                JSONObject map2Json = DynamicUtils.map2Json(gVar.c());
                if (!TextUtils.isEmpty(gVar.b()) && (map2Json == null || !map2Json.has("msg"))) {
                    if (map2Json == null) {
                        map2Json = new JSONObject();
                    }
                    map2Json.put("msg", gVar.b());
                }
                this.mMethodDispatcher.dispatcher(MODULE_ID, gVar.a(), map2Json, new DKMethodHandler.Callback() { // from class: com.tencent.ams.dsdk.core.mosaic.DKMosaicEventHandler.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicEventHandler.this);
                        }
                    }

                    @Override // com.tencent.ams.dsdk.event.DKMethodHandler.Callback
                    public void onFailure(int i3, String str) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                            iPatchRedirector2.redirect((short) 3, (Object) this, i3, (Object) str);
                            return;
                        }
                        DLog.i(DKMosaicEventHandler.TAG, "onFailure, errorCode: " + i3 + ", message: " + str);
                    }

                    @Override // com.tencent.ams.dsdk.event.DKMethodHandler.Callback
                    public void onResult(Object obj) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, obj);
                            return;
                        }
                        DLog.i(DKMosaicEventHandler.TAG, "onResult, result: " + obj);
                    }
                });
                return;
            } catch (Exception e16) {
                DLog.e(TAG, "dispatcher mosaic event error.", e16);
                return;
            }
        }
        DLog.w(TAG, "event or dispatcher is null.");
    }
}
