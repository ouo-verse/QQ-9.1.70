package com.tencent.qqnt.aio.assistedchat.panel;

import android.view.View;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.aio.utils.b;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J.\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\fJ.\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelDtReporter;", "", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "f", "e", "", "elementId", "view", "", "params", "c", "a", "<init>", "()V", "ReportRunnable", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatPanelDtReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final AssistedChatPanelDtReporter f349138a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR%\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelDtReporter$ReportRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "Ljava/lang/String;", "getEventId", "()Ljava/lang/String;", "eventId", "", "e", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "Lmqq/util/WeakReference;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "f", "Lmqq/util/WeakReference;", "viewRef", "view", "<init>", "(Ljava/lang/String;Landroid/view/View;Ljava/util/Map;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class ReportRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: from kotlin metadata */
        @NotNull
        private final String eventId;

        /* renamed from: e, reason: from kotlin metadata */
        @Nullable
        private final Map<String, String> params;

        /* renamed from: f, reason: from kotlin metadata */
        @NotNull
        private final WeakReference<View> viewRef;

        public ReportRunnable(@NotNull String eventId, @NotNull View view, @Nullable Map<String, String> map) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, eventId, view, map);
                return;
            }
            this.eventId = eventId;
            this.params = map;
            this.viewRef = new WeakReference<>(view);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            View view = this.viewRef.get();
            if (view != null) {
                VideoReport.reportEvent(this.eventId, view, this.params);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58977);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f349138a = new AssistedChatPanelDtReporter();
        }
    }

    AssistedChatPanelDtReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(AssistedChatPanelDtReporter assistedChatPanelDtReporter, String str, View view, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        assistedChatPanelDtReporter.a(str, view, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(AssistedChatPanelDtReporter assistedChatPanelDtReporter, String str, View view, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        assistedChatPanelDtReporter.c(str, view, map);
    }

    public final void a(@NotNull String elementId, @NotNull View view, @Nullable Map<String, String> params) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, elementId, view, params);
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
        ThreadManager.getUIHandler().postDelayed(new ReportRunnable("dt_imp", view, params), 2000L);
    }

    public final void e(@NotNull View r46, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        AIOSession r16;
        AIOContact c16;
        Map<String, Object> emptyMap;
        com.tencent.mobileqq.aio.utils.a e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) r46, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(r46, "rootView");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AIOParam g16 = aioContext.g();
        if (g16 != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            if (c16.e() == 104) {
                ((IAssistedChatAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatAdapterApi.class)).setDtReportPageInfo(r46, aioContext);
                return;
            }
            VideoReport.setPageId(r46, "pg_aio");
            b.a g17 = com.tencent.mobileqq.aio.utils.b.f194119a.g();
            if (g17 == null || (e16 = g17.e()) == null || (emptyMap = e16.a()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            VideoReport.setPageParams(r46, new PageParams((Map<String, ?>) emptyMap));
        }
    }

    public final void f(@NotNull View r46, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(r46, "rootView");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        ((IAssistedChatAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatAdapterApi.class)).setDtReportPageInfo(r46, aioContext);
    }
}
