package com.tencent.qqnt.qbasealbum.datahub;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u000b\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/datahub/m;", "Lcom/tencent/qqnt/qbasealbum/datahub/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "b", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "oldAlbumId", "c", "newAlbumId", "I", "()I", "indexInNewAlbum", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;Ljava/lang/String;Ljava/lang/String;I)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class m extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LocalMediaInfo info;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String oldAlbumId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String newAlbumId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int indexInNewAlbum;

    public m(@NotNull LocalMediaInfo info, @NotNull String oldAlbumId, @NotNull String newAlbumId, int i3) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(oldAlbumId, "oldAlbumId");
        Intrinsics.checkNotNullParameter(newAlbumId, "newAlbumId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, info, oldAlbumId, newAlbumId, Integer.valueOf(i3));
            return;
        }
        this.info = info;
        this.oldAlbumId = oldAlbumId;
        this.newAlbumId = newAlbumId;
        this.indexInNewAlbum = i3;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.indexInNewAlbum;
    }

    @NotNull
    public final LocalMediaInfo b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.info;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.newAlbumId;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.oldAlbumId;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof m)) {
            return false;
        }
        m mVar = (m) other;
        if (Intrinsics.areEqual(this.info, mVar.info) && Intrinsics.areEqual(this.oldAlbumId, mVar.oldAlbumId) && Intrinsics.areEqual(this.newAlbumId, mVar.newAlbumId) && this.indexInNewAlbum == mVar.indexInNewAlbum) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return (((((this.info.hashCode() * 31) + this.oldAlbumId.hashCode()) * 31) + this.newAlbumId.hashCode()) * 31) + this.indexInNewAlbum;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "MediaAlbumChangeEvent(info=" + this.info + ", oldAlbumId=" + this.oldAlbumId + ", newAlbumId=" + this.newAlbumId + ", indexInNewAlbum=" + this.indexInNewAlbum + ")";
    }
}
