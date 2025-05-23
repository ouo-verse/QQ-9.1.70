package com.tencent.mobileqq.troop.recent;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e\u0012\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001f\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/recent/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getMSelfUin", "()Ljava/lang/String;", "mSelfUin", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "urlList", "Landroid/graphics/drawable/Drawable;", "c", "mDrawableList", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mSelfUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> urlList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Drawable> mDrawableList;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull String mSelfUin, @NotNull List<String> urlList, @NotNull List<? extends Drawable> mDrawableList) {
        Intrinsics.checkNotNullParameter(mSelfUin, "mSelfUin");
        Intrinsics.checkNotNullParameter(urlList, "urlList");
        Intrinsics.checkNotNullParameter(mDrawableList, "mDrawableList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mSelfUin, urlList, mDrawableList);
            return;
        }
        this.mSelfUin = mSelfUin;
        this.urlList = urlList;
        this.mDrawableList = mDrawableList;
    }

    @NotNull
    public final List<Drawable> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mDrawableList;
    }

    @NotNull
    public final List<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.urlList;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.mSelfUin, bVar.mSelfUin) && Intrinsics.areEqual(this.urlList, bVar.urlList) && Intrinsics.areEqual(this.mDrawableList, bVar.mDrawableList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return (((this.mSelfUin.hashCode() * 31) + this.urlList.hashCode()) * 31) + this.mDrawableList.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "RecentTroopIconData(mSelfUin=" + this.mSelfUin + ", urlList=" + this.urlList + ", mDrawableList=" + this.mDrawableList + ")";
    }
}
