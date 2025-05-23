package com.tencent.qqnt.chats.core.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/core/report/data/c;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "levelArrStr", "b", "subLevelArrStr", "c", "typeArrStr", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String levelArrStr;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String subLevelArrStr;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String typeArrStr;

    public c(@NotNull String levelArrStr, @NotNull String subLevelArrStr, @NotNull String typeArrStr) {
        Intrinsics.checkNotNullParameter(levelArrStr, "levelArrStr");
        Intrinsics.checkNotNullParameter(subLevelArrStr, "subLevelArrStr");
        Intrinsics.checkNotNullParameter(typeArrStr, "typeArrStr");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, levelArrStr, subLevelArrStr, typeArrStr);
            return;
        }
        this.levelArrStr = levelArrStr;
        this.subLevelArrStr = subLevelArrStr;
        this.typeArrStr = typeArrStr;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.levelArrStr;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.subLevelArrStr;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.typeArrStr;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(c.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.report.data.MarkData");
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.levelArrStr, cVar.levelArrStr) && Intrinsics.areEqual(this.subLevelArrStr, cVar.subLevelArrStr) && Intrinsics.areEqual(this.typeArrStr, cVar.typeArrStr)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return (((this.levelArrStr.hashCode() * 31) + this.subLevelArrStr.hashCode()) * 31) + this.typeArrStr.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "MarkData(levelArrStr=" + this.levelArrStr + ", subLevelArrStr=" + this.subLevelArrStr + ", typeArrStr=" + this.typeArrStr + ")";
    }
}
