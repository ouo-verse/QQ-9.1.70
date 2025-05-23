package j74;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J \u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\"\u0010\u000b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002J \u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lj74/a;", "", "", "uin", "key", "", "default", "a", "isChecked", "", "e", "c", "value", "f", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f409621a = new a();

    a() {
    }

    public final boolean a(String uin, String key, boolean r56) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean(uin + util.base64_pad_url + key, r56);
    }

    public final String c(String uin, String key, String r56) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(r56, "default");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(uin + util.base64_pad_url + key, r56);
    }

    public final void e(String uin, boolean isChecked, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean(uin + util.base64_pad_url + key, isChecked);
    }

    public final void f(String uin, String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(uin + util.base64_pad_url + key, value);
    }

    public static /* synthetic */ String d(a aVar, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        return aVar.c(str, str2, str3);
    }

    public static /* synthetic */ boolean b(a aVar, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return aVar.a(str, str2, z16);
    }
}
