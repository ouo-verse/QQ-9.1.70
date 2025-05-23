package com.tencent.ams.dsdk.event.handler;

import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.fodder.TemplateManager;
import com.tencent.ams.dsdk.utils.FileUtils;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DefaultAdCommonMethodHandler implements DKMethodHandler {
    static IPatchRedirector $redirector_ = null;
    private static final String METHOD_NAME_GET_TEMPLATE_WITH_ID = "getTemplateWithInfo";
    private static final String MODULE_ID = "AdCommon";
    private static final String TAG = "AdCommonMethodHandler";
    private static final long TIMEOUT = 3000;

    public DefaultAdCommonMethodHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void handleGetTemplateWithInfo(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        String optString;
        boolean z16;
        String str = null;
        if (jSONObject == null) {
            optString = null;
        } else {
            optString = jSONObject.optString("templateId");
        }
        if (jSONObject != null && jSONObject.optBoolean("enableRealtimeDownloadWhenNotCache")) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        long j3 = 3000;
        if (jSONObject != null) {
            j3 = jSONObject.optLong("timeout", 3000L);
        }
        long j16 = j3;
        if (jSONObject != null) {
            str = jSONObject.optString("scene");
        }
        String str2 = str;
        if (TextUtils.isEmpty(optString)) {
            if (callback != null) {
                callback.onFailure(-1, "templateId is empty.");
                return;
            }
            return;
        }
        WorkThreadManager.getInstance().getImmediateThreadPool().execute(new Runnable(optString, z17, j16, str2, callback) { // from class: com.tencent.ams.dsdk.event.handler.DefaultAdCommonMethodHandler.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ DKMethodHandler.Callback val$callback;
            final /* synthetic */ boolean val$enableRealTime;
            final /* synthetic */ String val$scene;
            final /* synthetic */ String val$templateId;
            final /* synthetic */ long val$timeoutValue;

            {
                this.val$templateId = optString;
                this.val$enableRealTime = z17;
                this.val$timeoutValue = j16;
                this.val$scene = str2;
                this.val$callback = callback;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DefaultAdCommonMethodHandler.this, optString, Boolean.valueOf(z17), Long.valueOf(j16), str2, callback);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                TemplateManager templateManager = TemplateManager.getInstance();
                String str3 = this.val$templateId;
                boolean z18 = this.val$enableRealTime;
                long j17 = this.val$timeoutValue;
                if (j17 <= 0) {
                    j17 = 3000;
                }
                String templatePath = templateManager.getTemplatePath(str3, z18, j17, this.val$scene);
                if (this.val$callback != null) {
                    byte[] readBytesFromFile = FileUtils.readBytesFromFile(templatePath);
                    if (readBytesFromFile != null) {
                        this.val$callback.onResult(new String(readBytesFromFile));
                    } else {
                        this.val$callback.onFailure(-3, "content is empty.");
                    }
                }
            }
        });
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return MODULE_ID;
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public boolean invoke(DKEngine dKEngine, String str, JSONObject jSONObject, DKMethodHandler.Callback callback) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, dKEngine, str, jSONObject, callback)).booleanValue();
        }
        if (!METHOD_NAME_GET_TEMPLATE_WITH_ID.equals(str)) {
            return false;
        }
        handleGetTemplateWithInfo(jSONObject, callback);
        return true;
    }
}
