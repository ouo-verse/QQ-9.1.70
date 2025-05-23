package com.tencent.qqnt.qbasealbum.select.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u000f\u0010\u001c\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/model/e;", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "downloadMedia", "b", "Z", "isFinish", "()Z", "c", "isSuccess", "d", "Ljava/lang/String;", "getDownloadedMediaPath", "()Ljava/lang/String;", "downloadedMediaPath", "e", "I", "()I", "downloadProgress", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class e extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LocalMediaInfo downloadMedia;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isFinish;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isSuccess;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String downloadedMediaPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int downloadProgress;

    @NotNull
    public final LocalMediaInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.downloadMedia;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.downloadProgress;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (Intrinsics.areEqual(this.downloadMedia, eVar.downloadMedia) && this.isFinish == eVar.isFinish && this.isSuccess == eVar.isSuccess && Intrinsics.areEqual(this.downloadedMediaPath, eVar.downloadedMediaPath) && this.downloadProgress == eVar.downloadProgress) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        int hashCode = this.downloadMedia.hashCode() * 31;
        boolean z16 = this.isFinish;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.isSuccess;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((((i17 + i3) * 31) + this.downloadedMediaPath.hashCode()) * 31) + this.downloadProgress;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "DataDownloadAction(downloadMedia=" + this.downloadMedia + ", isFinish=" + this.isFinish + ", isSuccess=" + this.isSuccess + ", downloadedMediaPath=" + this.downloadedMediaPath + ", downloadProgress=" + this.downloadProgress + ")";
    }
}
