package m93;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f416460b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<b> f416461a = new ArrayList<>();

    a() {
    }

    public void a(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.f416461a.size() > 0) {
            Iterator<b> it = this.f416461a.iterator();
            while (it.hasNext()) {
                it.next().I2(i3, strArr, iArr);
            }
        }
    }

    public void b(@NonNull b bVar) {
        this.f416461a.add(bVar);
        QLog.d("QQPermissionRequestManager", 1, "register callback: " + bVar.d4());
    }

    public void c(@NonNull b bVar) {
        this.f416461a.remove(bVar);
        QLog.d("QQPermissionRequestManager", 1, "unregister callback: " + bVar.d4());
    }
}
