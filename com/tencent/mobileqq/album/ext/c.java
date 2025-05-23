package com.tencent.mobileqq.album.ext;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/album/ext/c;", "", "", "b", "other", "", "equals", "", "hashCode", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "localInfo", "Ljava/lang/String;", "originalPathMd5", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "album_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LocalMediaInfo localInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String originalPathMd5;

    public c(@NotNull LocalMediaInfo localInfo) {
        Intrinsics.checkNotNullParameter(localInfo, "localInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) localInfo);
        } else {
            this.localInfo = localInfo;
        }
    }

    @NotNull
    public final LocalMediaInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.localInfo;
    }

    @Nullable
    public final String b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String str = this.originalPathMd5;
        boolean z17 = false;
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17) {
            String str2 = this.originalPathMd5;
            if (str2 != null) {
                return str2;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        String b16 = com.tencent.qqnt.util.file.b.f362981a.b(this.localInfo.getPath());
        this.originalPathMd5 = b16;
        return b16;
    }

    public boolean equals(@Nullable Object other) {
        c cVar;
        LocalMediaInfo localMediaInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other instanceof c) {
            cVar = (c) other;
        } else {
            cVar = null;
        }
        if (cVar == null || (localMediaInfo = cVar.localInfo) == null || !localMediaInfo.equals(this.localInfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.localInfo.hashCode();
    }
}
