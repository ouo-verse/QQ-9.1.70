package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class w extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public w(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        String str;
        if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
            QQToast.makeText(BaseApplicationImpl.getApplication(), 1, R.string.ci5, 1).show();
            return false;
        }
        if (this.f307441f.containsKey("params")) {
            str = this.f307441f.get("params");
        } else {
            str = "";
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(PluginBaseInfoHelper.Base64Helper.decode(str, 0)));
            String optString = jSONObject.optString("keyword");
            JSONArray optJSONArray = jSONObject.optJSONArray("groupmask");
            long[] jArr = new long[optJSONArray.length()];
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                jArr[i3] = optJSONArray.optLong(i3);
            }
            ActiveEntitySearchActivity.c3(this.f307437b, optString, jSONObject.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_NAME), jArr);
        } catch (JSONException unused) {
            QLog.e("FTSSearchTabActionQ.uniteSearch.", 2, "\u53c2\u6570\u89e3\u6790\u6210json\u9519\u8bef.  params=" + str);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            return F();
        } catch (Exception e16) {
            QLog.e("FTSSearchTabAction", 1, "doAction error: " + e16.getMessage());
            i("FTSSearchTabAction");
            return false;
        }
    }
}
