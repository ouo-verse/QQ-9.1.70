package com.tencent.qqnt.qbasealbum.select.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/model/b;", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", "indexInSelectedMedia", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "addedMedia", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "selectedMedia", "<init>", "(ILcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;Ljava/util/List;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int indexInSelectedMedia;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LocalMediaInfo addedMedia;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> selectedMedia;

    public b(int i3, @NotNull LocalMediaInfo addedMedia, @NotNull List<LocalMediaInfo> selectedMedia) {
        Intrinsics.checkNotNullParameter(addedMedia, "addedMedia");
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), addedMedia, selectedMedia);
            return;
        }
        this.indexInSelectedMedia = i3;
        this.addedMedia = addedMedia;
        this.selectedMedia = selectedMedia;
    }

    @NotNull
    public final LocalMediaInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.addedMedia;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.indexInSelectedMedia;
    }

    @NotNull
    public final List<LocalMediaInfo> c() {
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
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (this.indexInSelectedMedia == bVar.indexInSelectedMedia && Intrinsics.areEqual(this.addedMedia, bVar.addedMedia) && Intrinsics.areEqual(this.selectedMedia, bVar.selectedMedia)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return (((this.indexInSelectedMedia * 31) + this.addedMedia.hashCode()) * 31) + this.selectedMedia.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "DataAddedAction(indexInSelectedMedia=" + this.indexInSelectedMedia + ", addedMedia=" + this.addedMedia + ", selectedMedia=" + this.selectedMedia + ")";
    }
}
