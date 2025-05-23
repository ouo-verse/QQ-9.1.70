package com.tencent.sqshow.zootopia.nativeui.view.action;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import uv4.af;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u001b\u0010\u0016\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0010R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010!R\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010!R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreCreateRoleBubbleHelper;", "", "Luv4/af;", "bubbleInfo", "", "l", "Landroid/content/Context;", "context", "", "url", "g", "Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreCreateRoleBubbleView;", "view", "b", "c", tl.h.F, "", "e", "j", "d", "", "data", "k", "([Luv4/af;)V", "f", "Luv4/af;", "mallBubbleInfo", "", "I", "PORTAL_STORE_BUBBLE_ID", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "createRoleBubbleView", "Z", "isFromAIOTofu", "sourceFromBubble", "Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "Lkotlin/Lazy;", "getZPlanMMKV", "()Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "zPlanMMKV", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreCreateRoleBubbleHelper {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static af mallBubbleInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<PortalStoreCreateRoleBubbleView> createRoleBubbleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isFromAIOTofu;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean sourceFromBubble;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Lazy zPlanMMKV;

    /* renamed from: a, reason: collision with root package name */
    public static final PortalStoreCreateRoleBubbleHelper f371421a = new PortalStoreCreateRoleBubbleHelper();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int PORTAL_STORE_BUBBLE_ID = 1;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IZPlanMMKVApi>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreCreateRoleBubbleHelper$zPlanMMKV$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IZPlanMMKVApi invoke() {
                QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
                return (IZPlanMMKVApi) api;
            }
        });
        zPlanMMKV = lazy;
    }

    PortalStoreCreateRoleBubbleHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        f94.c.d(f94.c.f398021a, false, 1, null);
    }

    private final void l(af bubbleInfo) {
        PortalStoreCreateRoleBubbleView portalStoreCreateRoleBubbleView;
        if (f() && bubbleInfo != null) {
            WeakReference<PortalStoreCreateRoleBubbleView> weakReference = createRoleBubbleView;
            if (weakReference != null && (portalStoreCreateRoleBubbleView = weakReference.get()) != null) {
                portalStoreCreateRoleBubbleView.setBubbleInfo(bubbleInfo);
            }
            WeakReference<PortalStoreCreateRoleBubbleView> weakReference2 = createRoleBubbleView;
            PortalStoreCreateRoleBubbleView portalStoreCreateRoleBubbleView2 = weakReference2 != null ? weakReference2.get() : null;
            if (portalStoreCreateRoleBubbleView2 == null) {
                return;
            }
            portalStoreCreateRoleBubbleView2.setVisibility(0);
        }
    }

    public final void b(PortalStoreCreateRoleBubbleView view) {
        if (isFromAIOTofu && view != null) {
            createRoleBubbleView = new WeakReference<>(view);
            f371421a.l(mallBubbleInfo);
        }
    }

    public final void c() {
        WeakReference<PortalStoreCreateRoleBubbleView> weakReference = createRoleBubbleView;
        PortalStoreCreateRoleBubbleView portalStoreCreateRoleBubbleView = weakReference != null ? weakReference.get() : null;
        if (portalStoreCreateRoleBubbleView != null) {
            portalStoreCreateRoleBubbleView.setVisibility(8);
        }
        WeakReference<PortalStoreCreateRoleBubbleView> weakReference2 = createRoleBubbleView;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        createRoleBubbleView = null;
        mallBubbleInfo = null;
        isFromAIOTofu = false;
    }

    public final void d() {
        PortalStoreCreateRoleBubbleView portalStoreCreateRoleBubbleView;
        if (isFromAIOTofu) {
            WeakReference<PortalStoreCreateRoleBubbleView> weakReference = createRoleBubbleView;
            boolean z16 = false;
            if (weakReference != null && (portalStoreCreateRoleBubbleView = weakReference.get()) != null && portalStoreCreateRoleBubbleView.getVisibility() == 8) {
                z16 = true;
            }
            if (!z16 && f()) {
                c();
            }
        }
    }

    public final boolean e() {
        return sourceFromBubble;
    }

    public final boolean f() {
        return isFromAIOTofu && mallBubbleInfo != null;
    }

    public final void g(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            return;
        }
        isFromAIOTofu = true;
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, url);
    }

    public final void k(af[] data) {
        Object first;
        Intrinsics.checkNotNullParameter(data, "data");
        if (isFromAIOTofu) {
            ArrayList arrayList = new ArrayList();
            for (af afVar : data) {
                if (afVar.f440122a == PORTAL_STORE_BUBBLE_ID) {
                    arrayList.add(afVar);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            af afVar2 = (af) first;
            mallBubbleInfo = afVar2;
            l(afVar2);
        }
    }

    public final void h() {
        sourceFromBubble = false;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.p
            @Override // java.lang.Runnable
            public final void run() {
                PortalStoreCreateRoleBubbleHelper.i();
            }
        });
    }

    public final void j() {
        sourceFromBubble = true;
    }
}
