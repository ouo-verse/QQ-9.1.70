package kx;

import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    com.tencent.biz.troop.b f413350a;

    /* renamed from: b, reason: collision with root package name */
    HashMap<Integer, WeakReference<a>> f413351b = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
        void a(Bundle bundle);
    }

    public c(com.tencent.biz.troop.b bVar) {
        this.f413350a = bVar;
    }

    public void a(int i3, a aVar) {
        if (this.f413351b.containsKey(Integer.valueOf(i3))) {
            this.f413351b.remove(Integer.valueOf(i3));
        }
        this.f413351b.put(Integer.valueOf(i3), new WeakReference<>(aVar));
    }

    public void b() {
        this.f413351b.clear();
    }

    public void c(Bundle bundle) {
        if (bundle == null) {
            if (QLog.isColorLevel()) {
                QLog.d("WebPushClient", 2, "data is null");
                return;
            }
            return;
        }
        int i3 = bundle.getInt(QQBrowserActivity.KEY_MSG_TYPE, -1);
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("WebPushClient", 2, "type is 0");
            }
        } else {
            WeakReference<a> weakReference = this.f413351b.get(Integer.valueOf(i3));
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().a(bundle);
            }
        }
    }

    public void d(int i3) {
        this.f413351b.remove(Integer.valueOf(i3));
    }
}
