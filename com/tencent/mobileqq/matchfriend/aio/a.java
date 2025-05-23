package com.tencent.mobileqq.matchfriend.aio;

import android.os.Bundle;
import android.view.View;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J.\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bJ.\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/a;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "e", "", "elementId", "view", "", "params", "c", "a", "<init>", "()V", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f243789a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22803);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f243789a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(a aVar, String str, View view, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        aVar.a(str, view, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(a aVar, String str, View view, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        aVar.c(str, view, map);
    }

    public final void a(@NotNull String elementId, @NotNull View view, @Nullable Map<String, String> params) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, elementId, view, params);
            return;
        }
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, elementId);
        if (params != null && !params.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            VideoReport.setElementParams(view, params);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, params);
    }

    public final void c(@NotNull String elementId, @NotNull View view, @Nullable Map<String, String> params) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, elementId, view, params);
            return;
        }
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, elementId);
        if (params != null && !params.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            VideoReport.setElementParams(view, params);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", view, params);
    }

    public final void e(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull View rootView) {
        Integer num;
        String str;
        Map mapOf;
        Bundle l3;
        AIOSession r16;
        AIOContact c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        AIOParam g16 = aioContext.g();
        if (g16 != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            num = Integer.valueOf(c16.e());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 104) {
            AIOParam g17 = aioContext.g();
            if (g17 == null || (l3 = g17.l()) == null || (str = l3.getString("recom_trace")) == null) {
                str = "";
            }
            VideoReport.setPageId(rootView, "pg_kl_new_chat_page");
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId()), TuplesKt.to("kl_new_to_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getFriendOpenId()), TuplesKt.to("recom_trace", str));
            VideoReport.setPageParams(rootView, new PageParams((Map<String, ?>) mapOf));
        }
    }
}
