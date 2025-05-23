package com.tencent.mobileqq.album.media;

import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001b\u0010\u0011R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/album/media/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/net/Uri;", "a", "Landroid/net/Uri;", "c", "()Landroid/net/Uri;", "mediaUri", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "localPath", "I", "d", "()I", "resultUriType", "Ljava/lang/Object;", "getExtra", "()Ljava/lang/Object;", "extra", "e", "thumbPath", "f", "localPathMd5", "<init>", "(Landroid/net/Uri;Ljava/lang/String;ILjava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V", "album_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Uri mediaUri;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String localPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int resultUriType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Object extra;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String thumbPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String localPathMd5;

    public c() {
        this(null, null, 0, null, null, null, 63, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, (Object) this);
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.localPath;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.localPathMd5;
    }

    @Nullable
    public final Uri c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Uri) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mediaUri;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.resultUriType;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.thumbPath;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.mediaUri, cVar.mediaUri) && Intrinsics.areEqual(this.localPath, cVar.localPath) && this.resultUriType == cVar.resultUriType && Intrinsics.areEqual(this.extra, cVar.extra) && Intrinsics.areEqual(this.thumbPath, cVar.thumbPath) && Intrinsics.areEqual(this.localPathMd5, cVar.localPathMd5)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        Uri uri = this.mediaUri;
        int i3 = 0;
        if (uri == null) {
            hashCode = 0;
        } else {
            hashCode = uri.hashCode();
        }
        int i16 = hashCode * 31;
        String str = this.localPath;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (((i16 + hashCode2) * 31) + this.resultUriType) * 31;
        Object obj = this.extra;
        if (obj == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = obj.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str2 = this.thumbPath;
        if (str2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str2.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str3 = this.localPathMd5;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "PickPhotoResult(mediaUri=" + this.mediaUri + ", localPath=" + this.localPath + ", resultUriType=" + this.resultUriType + ", extra=" + this.extra + ", thumbPath=" + this.thumbPath + ", localPathMd5=" + this.localPathMd5 + ")";
    }

    public c(@Nullable Uri uri, @Nullable String str, int i3, @Nullable Object obj, @Nullable String str2, @Nullable String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uri, str, Integer.valueOf(i3), obj, str2, str3);
            return;
        }
        this.mediaUri = uri;
        this.localPath = str;
        this.resultUriType = i3;
        this.extra = obj;
        this.thumbPath = str2;
        this.localPathMd5 = str3;
    }

    public /* synthetic */ c(Uri uri, String str, int i3, Object obj, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : uri, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? -1 : i3, (i16 & 8) != 0 ? null : obj, (i16 & 16) != 0 ? null : str2, (i16 & 32) != 0 ? null : str3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, uri, str, Integer.valueOf(i3), obj, str2, str3, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
