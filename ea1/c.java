package ea1;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f396025a = 1;

    public static c b(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteRecentConfBean", 2, String.format("parse content=%s", str));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            cVar.f396025a = new JSONObject(str).getInt("ifrecent");
            return cVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ColorNoteRecentConfBean", 2, "ColorNoteRecentConfBean parse err: ", e16);
            }
            return null;
        }
    }

    public boolean a() {
        if (this.f396025a == 1) {
            return true;
        }
        return false;
    }
}
