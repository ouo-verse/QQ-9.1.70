package com.tencent.qqnt.qbasealbum.base.repository;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u000f\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R%\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u0018\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/qbasealbum/base/repository/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "albumId", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", QAdVrReportParams.ParamKey.MEDIA, "Z", "f", "()Z", "isSuccess", "d", "hasMore", "e", "queryNext", "", "Ljava/util/Map;", "()Ljava/util/Map;", "payload", "<init>", "(Ljava/lang/String;Ljava/util/List;ZZZLjava/util/Map;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String albumId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> media;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isSuccess;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean hasMore;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean queryNext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Map<String, Object> payload;

    public a(@NotNull String albumId, @NotNull List<LocalMediaInfo> media, boolean z16, boolean z17, boolean z18, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(media, "media");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, albumId, media, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), map);
            return;
        }
        this.albumId = albumId;
        this.media = media;
        this.isSuccess = z16;
        this.hasMore = z17;
        this.queryNext = z18;
        this.payload = map;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.albumId;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.hasMore;
    }

    @NotNull
    public final List<LocalMediaInfo> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.media;
    }

    @Nullable
    public final Map<String, Object> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Map) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.payload;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.queryNext;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.albumId, aVar.albumId) && Intrinsics.areEqual(this.media, aVar.media) && this.isSuccess == aVar.isSuccess && this.hasMore == aVar.hasMore && this.queryNext == aVar.queryNext && Intrinsics.areEqual(this.payload, aVar.payload)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isSuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        int hashCode2 = ((this.albumId.hashCode() * 31) + this.media.hashCode()) * 31;
        boolean z16 = this.isSuccess;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.hasMore;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.queryNext;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        int i26 = (i19 + i3) * 31;
        Map<String, Object> map = this.payload;
        if (map == null) {
            hashCode = 0;
        } else {
            hashCode = map.hashCode();
        }
        return i26 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "albumId=" + this.albumId + ", isSuccess=" + this.isSuccess + ", hasMore=" + this.hasMore + ", media.size=" + this.media.size() + ", payload=" + this.payload;
    }
}
