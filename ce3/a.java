package ce3;

import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.repo.p;
import com.tencent.sqshow.zootopia.nativeui.ue.PortalStoreAvatarDressController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m94.h;
import mqq.util.WeakReference;
import qu4.c;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0017B\u001d\u0012\u0006\u0010\r\u001a\u00020\n\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lce3/a;", "Lcom/tencent/sqshow/zootopia/nativeui/ue/PortalStoreAvatarDressController;", "Lqu4/c;", "colorInfo", "", "addToHistory", "Lm94/h;", "cb", "", "Q8", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "K", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "panelRepo", "Lmqq/util/WeakReference;", "Lce3/a$a;", "L", "Lmqq/util/WeakReference;", "callback", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;Lmqq/util/WeakReference;)V", "M", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a extends PortalStoreAvatarDressController {

    /* renamed from: K, reason: from kotlin metadata */
    private final p panelRepo;

    /* renamed from: L, reason: from kotlin metadata */
    private final WeakReference<InterfaceC0184a> callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lce3/a$a;", "", "Lqu4/c;", "colorInfo", "", "addToHistory", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ce3.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public interface InterfaceC0184a {
        void a(c colorInfo, boolean addToHistory);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(p panelRepo, WeakReference<InterfaceC0184a> callback) {
        super(panelRepo);
        Intrinsics.checkNotNullParameter(panelRepo, "panelRepo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.panelRepo = panelRepo;
        this.callback = callback;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.PortalStoreAvatarDressController, b94.d
    public void Q8(c colorInfo, boolean addToHistory, h cb5) {
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.i("AigcDressController", 1, "modifyColorInfo");
        InterfaceC0184a interfaceC0184a = this.callback.get();
        if (interfaceC0184a != null) {
            interfaceC0184a.a(colorInfo, addToHistory);
        }
    }
}
