package com.tencent.cache.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b\u001d\u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\n\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/cache/api/d;", "", "", "hashCode", "other", "", "equals", "", "toString", "Lcom/tencent/cache/api/Business;", "a", "Lcom/tencent/cache/api/Business;", "b", "()Lcom/tencent/cache/api/Business;", "setBusiness", "(Lcom/tencent/cache/api/Business;)V", "business", "Lcom/tencent/cache/api/PageHierarchy;", "Lcom/tencent/cache/api/PageHierarchy;", "c", "()Lcom/tencent/cache/api/PageHierarchy;", "setPageHierarchy", "(Lcom/tencent/cache/api/PageHierarchy;)V", "pageHierarchy", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "blockInfo", "<init>", "(Lcom/tencent/cache/api/Business;Lcom/tencent/cache/api/PageHierarchy;Ljava/lang/String;)V", "Lcom/tencent/cache/api/Page;", "page", "(Lcom/tencent/cache/api/Page;)V", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Business business;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PageHierarchy pageHierarchy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String blockInfo;

    public d(@NotNull Business business, @NotNull PageHierarchy pageHierarchy, @Nullable String str) {
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(pageHierarchy, "pageHierarchy");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, business, pageHierarchy, str);
            return;
        }
        this.business = business;
        this.pageHierarchy = pageHierarchy;
        this.blockInfo = str;
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.blockInfo;
    }

    @NotNull
    public final Business b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Business) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.business;
    }

    @NotNull
    public final PageHierarchy c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (PageHierarchy) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.pageHierarchy;
    }

    public final void d(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.blockInfo = str;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, other)).booleanValue();
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (this.business != dVar.business || this.pageHierarchy != dVar.pageHierarchy || !Intrinsics.areEqual(this.blockInfo, dVar.blockInfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return Objects.hash(this.business, this.pageHierarchy, this.blockInfo);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.business + util.base64_pad_url + this.pageHierarchy + util.base64_pad_url + this.blockInfo;
    }

    public /* synthetic */ d(Business business, PageHierarchy pageHierarchy, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(business, pageHierarchy, (i3 & 4) != 0 ? null : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, business, pageHierarchy, str, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Page page) {
        this(page.business(), page.type(), null);
        Intrinsics.checkNotNullParameter(page, "page");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) page);
    }
}
