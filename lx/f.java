package lx;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f implements s43.b {
    @Override // s43.b
    public boolean a(String str) {
        return false;
    }

    @Override // s43.b
    public boolean b(String str, String str2) {
        if ("publicAccountNew.config".equals(str2)) {
            return true;
        }
        if (((IPublicAccountH5AbilityPlugin) QRoute.api(IPublicAccountH5AbilityPlugin.class)).hasConfig(str) && !TextUtils.isEmpty(str2)) {
            return ((IPublicAccountH5AbilityPlugin) QRoute.api(IPublicAccountH5AbilityPlugin.class)).hasRight(str, str2);
        }
        return false;
    }

    @Override // s43.b
    public boolean d() {
        return false;
    }

    @Override // s43.b
    @NonNull
    public String getBusinessName() {
        return "public_account_authorize_config";
    }

    @Override // s43.b
    public void c(JSONObject jSONObject) {
    }
}
