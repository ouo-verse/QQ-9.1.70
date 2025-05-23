package com.tencent.qqnt.msgselect.api;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\u0006\u0010'\u001a\u00020\u001f\u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010$\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010'\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b\u001a\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/msgselect/api/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "b", "()Landroid/app/Activity;", "context", "I", "g", "()I", "requestCode", "c", "chatType", "d", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "uid", "e", "f", "nick", "from", "", "", "Ljava/util/List;", h.F, "()Ljava/util/List;", "selectedMsgID", "limitCount", "J", "()J", "limitTime", "<init>", "(Landroid/app/Activity;IILjava/lang/String;Ljava/lang/String;ILjava/util/List;IJ)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int requestCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nick;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int from;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> selectedMsgID;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int limitCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final long limitTime;

    public a(@NotNull Activity context, int i3, int i16, @NotNull String uid, @NotNull String nick, int i17, @NotNull List<Long> selectedMsgID, int i18, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(selectedMsgID, "selectedMsgID");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16), uid, nick, Integer.valueOf(i17), selectedMsgID, Integer.valueOf(i18), Long.valueOf(j3));
            return;
        }
        this.context = context;
        this.requestCode = i3;
        this.chatType = i16;
        this.uid = uid;
        this.nick = nick;
        this.from = i17;
        this.selectedMsgID = selectedMsgID;
        this.limitCount = i18;
        this.limitTime = j3;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.chatType;
    }

    @NotNull
    public final Activity b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Activity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.from;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.limitCount;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.limitTime;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.context, aVar.context) && this.requestCode == aVar.requestCode && this.chatType == aVar.chatType && Intrinsics.areEqual(this.uid, aVar.uid) && Intrinsics.areEqual(this.nick, aVar.nick) && this.from == aVar.from && Intrinsics.areEqual(this.selectedMsgID, aVar.selectedMsgID) && this.limitCount == aVar.limitCount && this.limitTime == aVar.limitTime) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.nick;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.requestCode;
    }

    @NotNull
    public final List<Long> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.selectedMsgID;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return (((((((((((((((this.context.hashCode() * 31) + this.requestCode) * 31) + this.chatType) * 31) + this.uid.hashCode()) * 31) + this.nick.hashCode()) * 31) + this.from) * 31) + this.selectedMsgID.hashCode()) * 31) + this.limitCount) * 31) + androidx.fragment.app.a.a(this.limitTime);
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uid;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "MsgSelectRequest(context=" + this.context + ", requestCode=" + this.requestCode + ", chatType=" + this.chatType + ", uid=" + this.uid + ", nick=" + this.nick + ", from=" + this.from + ", selectedMsgID=" + this.selectedMsgID + ", limitCount=" + this.limitCount + ", limitTime=" + this.limitTime + ")";
    }
}
