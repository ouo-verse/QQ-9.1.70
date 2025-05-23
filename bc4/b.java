package bc4;

import android.content.Context;
import cc4.b;
import cc4.d;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskBlindBoxData;
import com.tencent.sqshow.zootopia.taskcenter.header.blindbox.BlindBoxPreViewController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lbc4/b;", "", "", "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/data/s;", "b", "Lcom/tencent/sqshow/zootopia/data/s;", "getData", "()Lcom/tencent/sqshow/zootopia/data/s;", "data", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/data/s;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaTaskBlindBoxData data;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"bc4/b$a", "Lcc4/b$b;", "", "dismiss", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a implements b.InterfaceC0182b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f28270a;

        a(d dVar) {
            this.f28270a = dVar;
        }

        @Override // cc4.b.InterfaceC0182b
        public void dismiss() {
            this.f28270a.dismiss();
        }
    }

    public b(Context context, ZootopiaTaskBlindBoxData data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        this.context = context;
        this.data = data;
    }

    public void a() {
        d dVar = new d(this.context, 0, 2, null);
        BlindBoxPreViewController blindBoxPreViewController = new BlindBoxPreViewController(this.context);
        blindBoxPreViewController.b(new a(dVar));
        dVar.f(blindBoxPreViewController);
        dVar.show();
    }
}
