package com.tencent.mobileqq.troop.troopblacklist.model;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopblacklist/model/b;", "Lcom/tencent/mobileqq/troop/troopblacklist/model/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", BdhLogUtil.LogTag.Tag_Conn, "b", "()C", "indexChar", "I", "()I", "groupNum", "<init>", "(CI)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final char indexChar;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int groupNum;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b() {
        this(r2, r2, 3, null);
        char c16 = 0;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.groupNum;
    }

    public final char b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Character) iPatchRedirector.redirect((short) 3, (Object) this)).charValue();
        }
        return this.indexChar;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (this.indexChar == bVar.indexChar && this.groupNum == bVar.groupNum) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return (this.indexChar * 31) + this.groupNum;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "TroopBlackListIndexModel(indexChar=" + this.indexChar + ", groupNum=" + this.groupNum + ")";
    }

    public /* synthetic */ b(char c16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? TokenParser.SP : c16, (i16 & 2) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Character.valueOf(c16), Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    public b(char c16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Character.valueOf(c16), Integer.valueOf(i3));
        } else {
            this.indexChar = c16;
            this.groupNum = i3;
        }
    }
}
