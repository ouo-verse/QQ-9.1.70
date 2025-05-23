package km0;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private long f412662d = JoinTimeType.THIRTY_MINUTES;

    public static d b(String str) {
        d dVar = new d();
        if (TextUtils.isEmpty(str)) {
            return dVar;
        }
        try {
            dVar.f412662d = new JSONObject(str).optLong("ad_BannerDelay", JoinTimeType.THIRTY_MINUTES);
        } catch (JSONException e16) {
            QLog.e("BannerAdConfigBean", 1, e16, new Object[0]);
        }
        return dVar;
    }

    public long a() {
        return this.f412662d;
    }

    public String toString() {
        return "BannerAdConfigBean{ad_BannerDelay=" + this.f412662d + '}';
    }
}
