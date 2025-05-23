package com.tencent.qqnt.rich;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0019\u0010 \u001a\u0004\u0018\u00010\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u000f\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/rich/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/rich/c;", "a", "Lcom/tencent/qqnt/rich/c;", "()Lcom/tencent/qqnt/rich/c;", "dataInfo", "Lcom/tencent/qqnt/rich/o;", "b", "Lcom/tencent/qqnt/rich/o;", "c", "()Lcom/tencent/qqnt/rich/o;", "streamInfo", "I", "e", "()I", "width", "Lcom/tencent/qqnt/rich/p;", "d", "Lcom/tencent/qqnt/rich/p;", "()Lcom/tencent/qqnt/rich/p;", "textInfo", "Lcom/tencent/qqnt/rich/e;", "Lcom/tencent/qqnt/rich/e;", "()Lcom/tencent/qqnt/rich/e;", "inlineKeyboardInfo", "<init>", "(Lcom/tencent/qqnt/rich/c;Lcom/tencent/qqnt/rich/o;ILcom/tencent/qqnt/rich/p;Lcom/tencent/qqnt/rich/e;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c dataInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final o streamInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final p textInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final e inlineKeyboardInfo;

    public j(@NotNull c dataInfo, @NotNull o streamInfo, int i3, @NotNull p textInfo, @Nullable e eVar) {
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        Intrinsics.checkNotNullParameter(streamInfo, "streamInfo");
        Intrinsics.checkNotNullParameter(textInfo, "textInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, dataInfo, streamInfo, Integer.valueOf(i3), textInfo, eVar);
            return;
        }
        this.dataInfo = dataInfo;
        this.streamInfo = streamInfo;
        this.width = i3;
        this.textInfo = textInfo;
        this.inlineKeyboardInfo = eVar;
    }

    @NotNull
    public final c a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.dataInfo;
    }

    @Nullable
    public final e b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (e) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.inlineKeyboardInfo;
    }

    @NotNull
    public final o c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (o) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.streamInfo;
    }

    @NotNull
    public final p d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (p) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.textInfo;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.width;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof j)) {
            return false;
        }
        j jVar = (j) other;
        if (Intrinsics.areEqual(this.dataInfo, jVar.dataInfo) && Intrinsics.areEqual(this.streamInfo, jVar.streamInfo) && this.width == jVar.width && Intrinsics.areEqual(this.textInfo, jVar.textInfo) && Intrinsics.areEqual(this.inlineKeyboardInfo, jVar.inlineKeyboardInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        int hashCode2 = ((((((this.dataInfo.hashCode() * 31) + this.streamInfo.hashCode()) * 31) + this.width) * 31) + this.textInfo.hashCode()) * 31;
        e eVar = this.inlineKeyboardInfo;
        if (eVar == null) {
            hashCode = 0;
        } else {
            hashCode = eVar.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "RichData(dataInfo=" + this.dataInfo + ", streamInfo=" + this.streamInfo + ", width=" + this.width + ", textInfo=" + this.textInfo + ", inlineKeyboardInfo=" + this.inlineKeyboardInfo + ')';
    }

    public /* synthetic */ j(c cVar, o oVar, int i3, p pVar, e eVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, (i16 & 2) != 0 ? new o(false, false, 0, 7, null) : oVar, i3, pVar, (i16 & 16) != 0 ? null : eVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, cVar, oVar, Integer.valueOf(i3), pVar, eVar, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
