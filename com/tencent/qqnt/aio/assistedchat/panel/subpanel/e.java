package com.tencent.qqnt.aio.assistedchat.panel.subpanel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "viewType", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "b", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "()Lcom/tencent/qqnt/aio/assistedchat/model/c;", "recommend", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/a;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/a;", "()Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/a;", "emptyData", "<init>", "(ILcom/tencent/qqnt/aio/assistedchat/model/c;Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/a;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
final /* data */ class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int viewType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.aio.assistedchat.model.c recommend;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a emptyData;

    public e(int i3, @Nullable com.tencent.qqnt.aio.assistedchat.model.c cVar, @Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), cVar, aVar);
            return;
        }
        this.viewType = i3;
        this.recommend = cVar;
        this.emptyData = aVar;
    }

    @Nullable
    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.emptyData;
    }

    @Nullable
    public final com.tencent.qqnt.aio.assistedchat.model.c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.aio.assistedchat.model.c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.recommend;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.viewType;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (this.viewType == eVar.viewType && Intrinsics.areEqual(this.recommend, eVar.recommend) && Intrinsics.areEqual(this.emptyData, eVar.emptyData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int i3 = this.viewType * 31;
        com.tencent.qqnt.aio.assistedchat.model.c cVar = this.recommend;
        int i16 = 0;
        if (cVar == null) {
            hashCode = 0;
        } else {
            hashCode = cVar.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        a aVar = this.emptyData;
        if (aVar != null) {
            i16 = aVar.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "AssistedChatSubPanelAdapterItem(viewType=" + this.viewType + ", recommend=" + this.recommend + ", emptyData=" + this.emptyData + ")";
    }

    public /* synthetic */ e(int i3, com.tencent.qqnt.aio.assistedchat.model.c cVar, a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : cVar, (i16 & 4) == 0 ? aVar : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), cVar, aVar, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
