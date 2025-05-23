package com.tencent.mobileqq.weather.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\u0006\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0012R\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u001aR\"\u0010 \u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u001c\u001a\u0004\b\u0014\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/weather/data/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "d", "()J", "id", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "tag", "c", "desc", "author", "e", "f", "i", "(J)V", "likeNum", "Z", "()Z", tl.h.F, "(Z)V", "hasLike", "setJumpUrl", "(Ljava/lang/String;)V", WadlProxyConsts.KEY_JUMP_URL, "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String desc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String author;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long likeNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasLike;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String jumpUrl;

    public m(long j3, @NotNull String tag, @NotNull String desc, @NotNull String author, long j16, boolean z16, @NotNull String jumpUrl) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), tag, desc, author, Long.valueOf(j16), Boolean.valueOf(z16), jumpUrl);
            return;
        }
        this.id = j3;
        this.tag = tag;
        this.desc = desc;
        this.author = author;
        this.likeNum = j16;
        this.hasLike = z16;
        this.jumpUrl = jumpUrl;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.author;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.desc;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.hasLike;
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.id;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.jumpUrl;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof m)) {
            return false;
        }
        m mVar = (m) other;
        if (this.id == mVar.id && Intrinsics.areEqual(this.tag, mVar.tag) && Intrinsics.areEqual(this.desc, mVar.desc) && Intrinsics.areEqual(this.author, mVar.author) && this.likeNum == mVar.likeNum && this.hasLike == mVar.hasLike && Intrinsics.areEqual(this.jumpUrl, mVar.jumpUrl)) {
            return true;
        }
        return false;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.likeNum;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.tag;
    }

    public final void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.hasLike = z16;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        int a16 = ((((((((androidx.fragment.app.a.a(this.id) * 31) + this.tag.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.author.hashCode()) * 31) + androidx.fragment.app.a.a(this.likeNum)) * 31;
        boolean z16 = this.hasLike;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((a16 + i3) * 31) + this.jumpUrl.hashCode();
    }

    public final void i(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.likeNum = j3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "WeatherQuoteData(id=" + this.id + ", tag=" + this.tag + ", desc=" + this.desc + ", author=" + this.author + ", likeNum=" + this.likeNum + ", hasLike=" + this.hasLike + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
