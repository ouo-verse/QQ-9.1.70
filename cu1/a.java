package cu1;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static String f391845b = "CommentMsgInfo";

    /* renamed from: a, reason: collision with root package name */
    public long f391846a = 0;

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.f391846a = new JSONObject(str).getLong("commentCnt");
            return aVar;
        } catch (Exception e16) {
            QLog.e(f391845b, 1, e16.getMessage());
            return null;
        }
    }

    public String b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("commentCnt", this.f391846a);
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e(f391845b, 1, e16.getMessage());
            return "";
        }
    }

    public String toString() {
        return "commentCnt:" + this.f391846a + " ";
    }
}
