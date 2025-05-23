package com.tencent.qqnt.chats.core.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqnt.chats.core.report.DTChatsConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\rJ\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/chats/core/report/b;", "", "", "b", "", "c", "Lcom/tencent/qqnt/chats/core/report/DTChatsConst$PageType;", "d", "value", "g", "i", h.F, "f", "", "e", "", "a", "Ljava/lang/String;", "pageId", "refPageId", "I", "pageStp", "", "Z", "isFirstImp", "isFirstImpFlag", "Lcom/tencent/qqnt/chats/core/report/DTChatsConst$PageType;", "chatsPageType", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pageId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String refPageId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int pageStp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstImp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstImpFlag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private DTChatsConst.PageType chatsPageType;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.pageId = "";
        this.refPageId = "";
        this.pageStp = 1;
        this.isFirstImp = true;
        this.isFirstImpFlag = true;
        this.chatsPageType = DTChatsConst.PageType.OTHER;
    }

    @NotNull
    public final Map<String, Object> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Map) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("qq_pgid", this.pageId);
        linkedHashMap.put("qq_pgstp", Integer.valueOf(this.pageStp));
        linkedHashMap.put("qq_ref_pgid", this.refPageId);
        linkedHashMap.put("qq_ele_is_first_imp", Integer.valueOf(this.isFirstImp ? 1 : 0));
        linkedHashMap.put("qq_pg_contentid", this.pageId);
        linkedHashMap.put("msglist_type", Integer.valueOf(this.chatsPageType.ordinal()));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "peekAppRuntime()");
            String currentUin = peekAppRuntime.getCurrentUin();
            String str = "";
            if (currentUin == null) {
                currentUin = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(currentUin, "it.currentUin ?: \"\"");
            }
            linkedHashMap.put("home_uin", currentUin);
            String currentUid = peekAppRuntime.getCurrentUid();
            if (currentUid != null) {
                Intrinsics.checkNotNullExpressionValue(currentUid, "it.currentUid ?: \"\"");
                str = currentUid;
            }
            linkedHashMap.put("uid", str);
        }
        return linkedHashMap;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.pageId;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.pageStp;
    }

    @NotNull
    public final DTChatsConst.PageType d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DTChatsConst.PageType) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.chatsPageType;
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.isFirstImpFlag) {
            this.isFirstImp = true;
            this.isFirstImpFlag = false;
        } else {
            this.isFirstImp = false;
        }
    }

    @NotNull
    public final b f(@NotNull DTChatsConst.PageType value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) value);
        }
        Intrinsics.checkNotNullParameter(value, "value");
        this.chatsPageType = value;
        return this;
    }

    @NotNull
    public final b g(@NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
        }
        Intrinsics.checkNotNullParameter(value, "value");
        this.pageId = value;
        return this;
    }

    @NotNull
    public final b h(int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this, value);
        }
        this.pageStp = value;
        return this;
    }

    @NotNull
    public final b i(@NotNull String value) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) value);
        }
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            value = PageUtils.VR_PAGE_NONE;
        }
        this.refPageId = value;
        return this;
    }
}
