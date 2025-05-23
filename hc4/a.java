package hc4;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.usercenter.fragment.UserCenterFragment;
import com.tencent.sqshow.zootopia.utils.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qv4.bq;
import su4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J&\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\u001e"}, d2 = {"Lhc4/a;", "", "", "b", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "params", "", "e", "Lqv4/bq;", "info", "d", "", "uid", "", "currentRelation", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lsu4/h;", "callback", "f", "uin", "Lmc4/a;", "listener", "a", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f404730a = new a();

    a() {
    }

    private final String b() {
        return "key_ugc_enter_info_" + w.f373306a.b();
    }

    public void a(String uin, mc4.a listener) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(listener, "listener");
        lc4.a.f414373a.b(uin, listener);
    }

    public void c(mc4.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        lc4.a.f414373a.h(listener);
    }

    public void d(bq info) {
        Intrinsics.checkNotNullParameter(info, "info");
        pc4.a.f425898a.b(b(), info);
    }

    public void e(Context context, ZootopiaSource source, Bundle params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(params, "params");
        ZootopiaActivity.Companion.c(ZootopiaActivity.INSTANCE, context, UserCenterFragment.class, source, params, false, 16, null);
    }

    public void f(long uid, int currentRelation, e<h> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        lc4.a.f414373a.i(uid, currentRelation, callback);
    }
}
