package com.tencent.adelie.qqmc.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/adelie/qqmc/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/adelie/qqmc/model/b;", "wechat", "Lcom/tencent/adelie/qqmc/model/b;", "d", "()Lcom/tencent/adelie/qqmc/model/b;", "moments", "a", "qzone", "b", "url", "c", "qr", "getQr", "<init>", "(Lcom/tencent/adelie/qqmc/model/b;Lcom/tencent/adelie/qqmc/model/b;Lcom/tencent/adelie/qqmc/model/b;Lcom/tencent/adelie/qqmc/model/b;Lcom/tencent/adelie/qqmc/model/b;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    @SerializedName("moments")
    @NotNull
    private final b moments;

    @SerializedName("qr")
    @NotNull
    private final b qr;

    @SerializedName("qzone")
    @NotNull
    private final b qzone;

    @SerializedName("url")
    @NotNull
    private final b url;

    @SerializedName("wechat")
    @NotNull
    private final b wechat;

    public a() {
        this(null, null, null, null, null, 31, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this);
    }

    @NotNull
    public final b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.moments;
    }

    @NotNull
    public final b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.qzone;
    }

    @NotNull
    public final b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.url;
    }

    @NotNull
    public final b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.wechat;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.wechat, aVar.wechat) && Intrinsics.areEqual(this.moments, aVar.moments) && Intrinsics.areEqual(this.qzone, aVar.qzone) && Intrinsics.areEqual(this.url, aVar.url) && Intrinsics.areEqual(this.qr, aVar.qr)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return (((((((this.wechat.hashCode() * 31) + this.moments.hashCode()) * 31) + this.qzone.hashCode()) * 31) + this.url.hashCode()) * 31) + this.qr.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "AdelieHomePageShareConfig(wechat=" + this.wechat + ", moments=" + this.moments + ", qzone=" + this.qzone + ", url=" + this.url + ", qr=" + this.qr + ")";
    }

    public a(@NotNull b wechat, @NotNull b moments, @NotNull b qzone2, @NotNull b url, @NotNull b qr5) {
        Intrinsics.checkNotNullParameter(wechat, "wechat");
        Intrinsics.checkNotNullParameter(moments, "moments");
        Intrinsics.checkNotNullParameter(qzone2, "qzone");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(qr5, "qr");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, wechat, moments, qzone2, url, qr5);
            return;
        }
        this.wechat = wechat;
        this.moments = moments;
        this.qzone = qzone2;
        this.url = url;
        this.qr = qr5;
    }

    public /* synthetic */ a(b bVar, b bVar2, b bVar3, b bVar4, b bVar5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new b(null, null, "https://qun.qq.com/qunpro/robot/agent-index?_wwv=128&source=8", null, 11, null) : bVar, (i3 & 2) != 0 ? new b(null, null, "https://qun.qq.com/qunpro/robot/agent-index?_wwv=128&source=7", null, 11, null) : bVar2, (i3 & 4) != 0 ? new b(null, null, "https://qun.qq.com/qunpro/robot/agent-index?_wwv=128&source=2", null, 11, null) : bVar3, (i3 & 8) != 0 ? new b(null, null, "https://qun.qq.com/qunpro/robot/agent-index?_wwv=128&source=9", null, 11, null) : bVar4, (i3 & 16) != 0 ? new b(null, null, "https://qun.qq.com/qunpro/robot/agent-index?_wwv=128&source=10", null, 11, null) : bVar5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, bVar, bVar2, bVar3, bVar4, bVar5, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
