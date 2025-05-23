package gb4;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.sqshow.zootopia.data.f;
import com.tencent.sqshow.zootopia.utils.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qv4.bk;
import qv4.bq;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001f\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\f8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\f8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u001f\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lgb4/a;", "", "", "d", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "g", "Lqv4/bk;", "f", "info", h.F, "Landroidx/lifecycle/MutableLiveData;", "", "b", "Landroidx/lifecycle/MutableLiveData;", "c", "()Landroidx/lifecycle/MutableLiveData;", "mailRedDotId", "a", "bagRedDotId", "Lqv4/bq;", "getUserEntranceData", "userEntranceData", "Lcom/tencent/sqshow/zootopia/data/f;", "e", "currencyData", "portalTitleModelInfo", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f401894a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<Integer> mailRedDotId = new MutableLiveData<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<Integer> bagRedDotId = new MutableLiveData<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<bq> userEntranceData = new MutableLiveData<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<f> currencyData = new MutableLiveData<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<bk> portalTitleModelInfo = new MutableLiveData<>();

    a() {
    }

    private final String d() {
        return "key_title_module_" + w.f373306a.b();
    }

    public final MutableLiveData<Integer> a() {
        return bagRedDotId;
    }

    public final MutableLiveData<f> b() {
        return currencyData;
    }

    public final MutableLiveData<Integer> c() {
        return mailRedDotId;
    }

    public final MutableLiveData<bk> e() {
        return portalTitleModelInfo;
    }

    public final bk f() {
        bk bkVar = new bk();
        pc4.a.f425898a.a(d(), bkVar);
        return bkVar;
    }

    public final void g(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        mailRedDotId.removeObservers(owner);
        bagRedDotId.removeObservers(owner);
        userEntranceData.removeObservers(owner);
        portalTitleModelInfo.removeObservers(owner);
    }

    public final void h(bk info) {
        Intrinsics.checkNotNullParameter(info, "info");
        pc4.a.f425898a.b(d(), info);
    }
}
