package com.tencent.qqnt.msgselect.DTReport;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0000J\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/msgselect/DTReport/a;", "", "", "value", "c", "builder", "", "b", "", "", "a", "Ljava/lang/String;", "pageId", "refPageId", "J", "groupId", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pageId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String refPageId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long groupId;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.pageId = "pg_bas_includes_history_selection";
            this.refPageId = PageUtils.VR_PAGE_NONE;
        }
    }

    @NotNull
    public final Map<String, Object> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("qq_pgid", this.pageId);
        linkedHashMap.put("group_id", Long.valueOf(this.groupId));
        linkedHashMap.put("qq_ref_pgid", this.refPageId);
        return linkedHashMap;
    }

    public final void b(@NotNull a builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) builder);
            return;
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.pageId = builder.pageId;
        this.refPageId = builder.refPageId;
        this.groupId = builder.groupId;
    }

    @NotNull
    public final a c(long value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, value);
        }
        this.groupId = value;
        return this;
    }
}
