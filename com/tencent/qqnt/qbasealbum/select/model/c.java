package com.tencent.qqnt.qbasealbum.select.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/model/c;", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "indexInSelectedMedia", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "b", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "getRemovedMedia", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "removedMedia", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "selectedMedia", "<init>", "(ILcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;Ljava/util/List;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int indexInSelectedMedia;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LocalMediaInfo removedMedia;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> selectedMedia;

    public c(int i3, @NotNull LocalMediaInfo removedMedia, @NotNull List<LocalMediaInfo> selectedMedia) {
        Intrinsics.checkNotNullParameter(removedMedia, "removedMedia");
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), removedMedia, selectedMedia);
            return;
        }
        this.indexInSelectedMedia = i3;
        this.removedMedia = removedMedia;
        this.selectedMedia = selectedMedia;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.indexInSelectedMedia;
    }

    @NotNull
    public final List<LocalMediaInfo> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.selectedMedia;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (this.indexInSelectedMedia == cVar.indexInSelectedMedia && Intrinsics.areEqual(this.removedMedia, cVar.removedMedia) && Intrinsics.areEqual(this.selectedMedia, cVar.selectedMedia)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return (((this.indexInSelectedMedia * 31) + this.removedMedia.hashCode()) * 31) + this.selectedMedia.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "DataClickAction(indexInSelectedMedia=" + this.indexInSelectedMedia + ", removedMedia=" + this.removedMedia + ", selectedMedia=" + this.selectedMedia + ")";
    }
}
