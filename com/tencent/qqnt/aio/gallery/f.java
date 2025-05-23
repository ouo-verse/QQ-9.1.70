package com.tencent.qqnt.aio.gallery;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0003J\"\u0010\b\u001a\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0003J*\u0010\u000b\u001a\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0003J\"\u0010\u000e\u001a\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/f;", "", "", "", "pageParam", "elementId", "", "a", "b", "", "duration", "c", "", "actionType", "d", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f349999a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22676);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f349999a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull Map<String, ? extends Object> pageParam, @NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pageParam, (Object) elementId);
            return;
        }
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Map<String, Object> a16 = new com.tencent.mobileqq.aio.utils.a().a();
        a16.put("qq_eid", elementId);
        a16.putAll(pageParam);
        VideoReport.reportEvent("qq_clck", a16);
    }

    public final void b(@NotNull Map<String, ? extends Object> pageParam, @NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pageParam, (Object) elementId);
            return;
        }
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Map<String, Object> a16 = new com.tencent.mobileqq.aio.utils.a().a();
        a16.put("qq_eid", elementId);
        a16.putAll(pageParam);
        VideoReport.reportEvent("qq_imp", a16);
    }

    public final void c(@NotNull Map<String, ? extends Object> pageParam, long duration, @NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, pageParam, Long.valueOf(duration), elementId);
            return;
        }
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Map<String, Object> a16 = new com.tencent.mobileqq.aio.utils.a().a();
        a16.put("qq_eid", elementId);
        a16.put("qq_element_lvtm", Long.valueOf(duration));
        a16.putAll(pageParam);
        VideoReport.reportEvent("qq_imp_end", a16);
    }

    public final void d(@NotNull Map<String, ? extends Object> pageParam, int actionType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) pageParam, actionType);
            return;
        }
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        Map<String, Object> a16 = new com.tencent.mobileqq.aio.utils.a().a();
        a16.put("media_action_type", Integer.valueOf(actionType));
        a16.putAll(pageParam);
        VideoReport.reportEvent("ev_bas_picture_page_view", a16);
    }
}
