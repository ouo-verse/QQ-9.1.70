package o91;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, b> f422238a = new HashMap<>();

    public b a(String str) {
        b bVar;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, "AAShare.getPreprocessor in valid param");
            }
            return null;
        }
        synchronized (this.f422238a) {
            bVar = this.f422238a.get(str);
        }
        return bVar;
    }
}
