package com.tencent.pts.core.lite;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSComposer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes22.dex */
public class DefaultPTSLiteEventListener implements IPTSLiteEventListener {
    static IPatchRedirector $redirector_;

    public DefaultPTSLiteEventListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getLogString(String str, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) hashMap);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("identifier = ");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb5.append(str);
        sb5.append("\n");
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                sb5.append("dataSet [ ");
                sb5.append(entry.getKey());
                sb5.append(" ] = ");
                sb5.append(entry.getValue());
                sb5.append("\n");
            }
        }
        return sb5.toString();
    }

    @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
    public void onExposureTriggered(String str, HashMap<String, String> hashMap, View view, PTSComposer pTSComposer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, hashMap, view, pTSComposer);
        }
    }

    @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
    public void onScrollViewItemExposureTriggered(String str, HashMap<String, String> hashMap, View view, PTSComposer pTSComposer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, hashMap, view, pTSComposer);
        }
    }

    @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
    public void onSwiperDragTriggered(String str, HashMap<String, String> hashMap, View view, PTSComposer pTSComposer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, hashMap, view, pTSComposer);
        }
    }

    @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
    public void onSwiperItemExposureTriggered(String str, HashMap<String, String> hashMap, View view, PTSComposer pTSComposer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, hashMap, view, pTSComposer);
        }
    }

    @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
    public void onTapEventTriggered(String str, HashMap<String, String> hashMap, View view, PTSComposer pTSComposer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, hashMap, view, pTSComposer);
        }
    }
}
