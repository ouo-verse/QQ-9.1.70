package com.tencent.mobileqq.qqlive.sail.report;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J6\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006JB\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006J@\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004J$\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006J,\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00152\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00190\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/report/a;", "", "fragment", "target", "", ISchemeApi.KEY_PAGE_ID, "", "params", "", "e", "Landroid/view/View;", "view", "", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "businessParams", "b", "a", "eventId", "i", "Ljava/lang/Object;", h.F, "", "roomId", "Lcom/tencent/mobileqq/qqlive/sail/report/QQLiveDaTongParams;", "f", "g", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "roomIdToParams", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f272382a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, QQLiveDaTongParams> roomIdToParams;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18799);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f272382a = new a();
            roomIdToParams = new ConcurrentHashMap<>();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void c(a aVar, View view, String str, Map map, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i3 & 16) != 0) {
            str2 = null;
        }
        aVar.a(view, str, map, z17, str2);
    }

    public static /* synthetic */ void d(a aVar, View view, boolean z16, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i3 & 4) != 0) {
            str = null;
        }
        String str3 = str;
        if ((i3 & 16) != 0) {
            map = new HashMap();
        }
        aVar.b(view, z17, str3, str2, map);
    }

    public final void a(@NotNull View view, @NotNull String elementID, @NotNull Map<String, String> params, boolean isAsync, @Nullable String identifier) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, elementID, params, Boolean.valueOf(isAsync), identifier);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(params, "params");
        ((ug4.a) mm4.b.b(ug4.a.class)).a(view, isAsync, identifier, elementID, params);
    }

    public final void b(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Boolean.valueOf(isAsync), identifier, elementID, businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((ug4.a) mm4.b.b(ug4.a.class)).a(view, isAsync, identifier, elementID, businessParams);
    }

    public final void e(@NotNull Object fragment, @NotNull Object target, @NotNull String pageID, @Nullable Map<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, fragment, target, pageID, params);
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        ((ug4.a) mm4.b.b(ug4.a.class)).i(fragment, target, pageID, params);
    }

    @NotNull
    public final QQLiveDaTongParams f(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (QQLiveDaTongParams) iPatchRedirector.redirect((short) 7, (Object) this, roomId);
        }
        return b.a(new QQLiveDaTongParams(), g(roomId));
    }

    @NotNull
    public final QQLiveDaTongParams g(long roomId) {
        QQLiveDaTongParams putIfAbsent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QQLiveDaTongParams) iPatchRedirector.redirect((short) 8, (Object) this, roomId);
        }
        ConcurrentHashMap<Long, QQLiveDaTongParams> concurrentHashMap = roomIdToParams;
        Long valueOf = Long.valueOf(roomId);
        QQLiveDaTongParams qQLiveDaTongParams = concurrentHashMap.get(valueOf);
        if (qQLiveDaTongParams == null && (putIfAbsent = concurrentHashMap.putIfAbsent(valueOf, (qQLiveDaTongParams = new QQLiveDaTongParams()))) != null) {
            qQLiveDaTongParams = putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(qQLiveDaTongParams, "roomIdToParams.getOrPut(\u2026 { QQLiveDaTongParams() }");
        return qQLiveDaTongParams;
    }

    public final void h(@NotNull String eventId, @NotNull Object view, @NotNull Map<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, eventId, view, params);
            return;
        }
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(params, "params");
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent(eventId, view, params);
    }

    public final void i(@NotNull String eventId, @NotNull Map<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eventId, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(params, "params");
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent(eventId, params);
    }
}
