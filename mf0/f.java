package mf0;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    String f416659a = "";

    public static f a(String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.videostory.capture", 2, "config TextUtils.isEmpty(config) return");
                return null;
            }
            return null;
        }
        f fVar = new f();
        fVar.b(str);
        return fVar;
    }

    public void b(String str) {
        this.f416659a = str;
    }
}
