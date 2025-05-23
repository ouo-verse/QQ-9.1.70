package cc4;

import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.taskcenter.common.CurrencyUpdateEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcc4/b;", "", "Landroid/view/View;", "getView", "", "c", "Lcc4/b$b;", "listener", "b", "onDismiss", NodeProps.ON_DETACHED_FROM_WINDOW, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public interface b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcc4/b$b;", "", "", "dismiss", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cc4.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public interface InterfaceC0182b {
        void dismiss();
    }

    void b(InterfaceC0182b listener);

    void c();

    View getView();

    void onDetachedFromWindow();

    void onDismiss();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class a {
        public static void c(b bVar) {
            Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache("task_panel_handler", ZplanCacheComponentType.PARENT_PAGE_HANDLER);
            k84.a aVar = cache instanceof k84.a ? (k84.a) cache : null;
            if (aVar != null) {
                aVar.ne();
            }
            SimpleEventBus.getInstance().dispatchEvent(new CurrencyUpdateEvent(false, 1, null));
        }

        public static void a(b bVar) {
        }

        public static void b(b bVar) {
        }
    }
}
