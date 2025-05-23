package ma1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private int f416505d = 100;

    public static b b(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            QLog.d("MultiMsgConfBean", 1, "MultiMsgConfBean parse null");
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f416505d = jSONObject.optInt("max_multimsg_totalcount");
            if (QLog.isColorLevel()) {
                QLog.i("MultiMsgConfBean", 2, "MultiMsgConfBean =  " + jSONObject);
            }
        } catch (Exception e16) {
            QLog.e("MultiMsgConfBean", 1, "MultiMsgConfBean: " + str + " " + e16);
        }
        return bVar;
    }

    public int a() {
        return this.f416505d;
    }

    @NonNull
    public String toString() {
        return "MultiMsgConfBean{limitTotal=" + this.f416505d + '}';
    }
}
