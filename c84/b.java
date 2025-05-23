package c84;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lc84/b;", "", "", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f30450a = new b();

    b() {
    }

    public final String a() {
        dw4.b value = com.tencent.sqshow.dresskey.b.f369818a.l("ZPlanAvatarLoadingManager_", true).getValue();
        String str = value != null ? value.f395125l : null;
        if (str == null) {
            str = "";
        }
        QLog.i("ZPlanAvatarLoadingManager_", 1, "getLoadingBgUrl url:" + str);
        return str;
    }
}
