package gf0;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends ox.a {

    /* renamed from: d, reason: collision with root package name */
    public boolean f402022d;

    public a(Context context, String str) {
        super(context, str);
    }

    @Override // ox.a
    public String c() {
        return "key_for_troop_config_for_all_cfg";
    }

    @Override // ox.a
    public String e() {
        return "key_for_troop_config_for_all_cfg_version";
    }

    @Override // ox.a
    public void j(String str) {
        boolean z16 = true;
        this.f402022d = true;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (new JSONObject(str).optInt("isShow3kTroopTips") != 1) {
                z16 = false;
            }
            this.f402022d = z16;
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopConfigForAllUser", 2, e16.getMessage());
            }
        }
    }
}
