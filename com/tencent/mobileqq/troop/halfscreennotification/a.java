package com.tencent.mobileqq.troop.halfscreennotification;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020 \u0012\b\u0010$\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u0017\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u000f\u0010\u001cR\u0017\u0010#\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\u0019\u0010\"R\u0019\u0010$\u001a\u0004\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\u001e\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/troop/halfscreennotification/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "i", "()J", "troopUin", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "noticeId", "c", tl.h.F, "title", "d", "desc", "e", "imageUrl", "I", "()I", "imageWidth", "g", "imageHeight", "Lcom/tencent/mobileqq/troop/halfscreennotification/b;", "Lcom/tencent/mobileqq/troop/halfscreennotification/b;", "()Lcom/tencent/mobileqq/troop/halfscreennotification/b;", "mainButton", "secondButton", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/tencent/mobileqq/troop/halfscreennotification/b;Lcom/tencent/mobileqq/troop/halfscreennotification/b;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String noticeId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String desc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String imageUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int imageWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int imageHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mainButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b secondButton;

    public a(long j3, @NotNull String noticeId, @NotNull String title, @NotNull String desc, @NotNull String imageUrl, int i3, int i16, @NotNull b mainButton, @Nullable b bVar) {
        Intrinsics.checkNotNullParameter(noticeId, "noticeId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(mainButton, "mainButton");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), noticeId, title, desc, imageUrl, Integer.valueOf(i3), Integer.valueOf(i16), mainButton, bVar);
            return;
        }
        this.troopUin = j3;
        this.noticeId = noticeId;
        this.title = title;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.imageWidth = i3;
        this.imageHeight = i16;
        this.mainButton = mainButton;
        this.secondButton = bVar;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.desc;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.imageHeight;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.imageUrl;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.imageWidth;
    }

    @NotNull
    public final b e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (b) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mainButton;
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
        if (this.troopUin == aVar.troopUin && Intrinsics.areEqual(this.noticeId, aVar.noticeId) && Intrinsics.areEqual(this.title, aVar.title) && Intrinsics.areEqual(this.desc, aVar.desc) && Intrinsics.areEqual(this.imageUrl, aVar.imageUrl) && this.imageWidth == aVar.imageWidth && this.imageHeight == aVar.imageHeight && Intrinsics.areEqual(this.mainButton, aVar.mainButton) && Intrinsics.areEqual(this.secondButton, aVar.secondButton)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.noticeId;
    }

    @Nullable
    public final b g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.secondButton;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.title;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        int a16 = ((((((((((((((androidx.fragment.app.a.a(this.troopUin) * 31) + this.noticeId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.imageWidth) * 31) + this.imageHeight) * 31) + this.mainButton.hashCode()) * 31;
        b bVar = this.secondButton;
        if (bVar == null) {
            hashCode = 0;
        } else {
            hashCode = bVar.hashCode();
        }
        return a16 + hashCode;
    }

    public final long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.troopUin;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "HalfScreenNotification(troopUin=" + this.troopUin + ", noticeId=" + this.noticeId + ", title=" + this.title + ", desc=" + this.desc + ", imageUrl=" + this.imageUrl + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", mainButton=" + this.mainButton + ", secondButton=" + this.secondButton + ")";
    }
}
