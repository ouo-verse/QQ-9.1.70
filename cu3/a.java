package cu3;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public b f391863d = new b();

    public static a a(String str) {
        a aVar = new a();
        if (!StringUtil.isEmpty(str)) {
            try {
                b.a(aVar.f391863d, new JSONObject(str));
            } catch (JSONException e16) {
                QMLog.e("MiniManagerConfig", "json exeption: " + str, e16);
            }
        }
        return aVar;
    }
}
