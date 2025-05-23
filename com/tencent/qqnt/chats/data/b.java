package com.tencent.qqnt.chats.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BS\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0018\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0004\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/chats/data/b;", "", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "data", "", "b", "I", "()I", "count", "", "Z", "d", "()Z", "fetchOld", "e", "partRefresh", "getLocation", "location", "f", "isGuildData", "Lcom/tencent/qqnt/chats/data/a;", "g", "Lcom/tencent/qqnt/chats/data/a;", "()Lcom/tencent/qqnt/chats/data/a;", "changeInfo", "<init>", "(Ljava/util/List;IZZIZLcom/tencent/qqnt/chats/data/a;)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int count;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean fetchOld;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean partRefresh;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int location;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isGuildData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a changeInfo;

    public b(@NotNull List<g> data, int i3, boolean z16, boolean z17, int i16, boolean z18, @Nullable a aVar) {
        Intrinsics.checkNotNullParameter(data, "data");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, data, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16), Boolean.valueOf(z18), aVar);
            return;
        }
        this.data = data;
        this.count = i3;
        this.fetchOld = z16;
        this.partRefresh = z17;
        this.location = i16;
        this.isGuildData = z18;
        this.changeInfo = aVar;
    }

    @Nullable
    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.changeInfo;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.count;
    }

    @NotNull
    public final List<g> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.data;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.fetchOld;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.partRefresh;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isGuildData;
    }

    public /* synthetic */ b(List list, int i3, boolean z16, boolean z17, int i16, boolean z18, a aVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i17 & 2) != 0 ? 200 : i3, (i17 & 4) != 0 ? false : z16, (i17 & 8) != 0 ? false : z17, (i17 & 16) != 0 ? 0 : i16, (i17 & 32) != 0 ? false : z18, (i17 & 64) != 0 ? null : aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, list, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16), Boolean.valueOf(z18), aVar, Integer.valueOf(i17), defaultConstructorMarker);
    }
}
