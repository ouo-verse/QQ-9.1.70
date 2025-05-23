package com.tencent.mobileqq.exportfile.global;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\t\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/exportfile/global/o;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "fileId", "c", "localFilePath", "I", "getErrorCode", "()I", "errorCode", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "d", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "()Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String fileId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String localFilePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int errorCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final FileManagerEntity entity;

    public o(@NotNull String fileId, @NotNull String localFilePath, int i3, @Nullable FileManagerEntity fileManagerEntity) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fileId, localFilePath, Integer.valueOf(i3), fileManagerEntity);
            return;
        }
        this.fileId = fileId;
        this.localFilePath = localFilePath;
        this.errorCode = i3;
        this.entity = fileManagerEntity;
    }

    @Nullable
    public final FileManagerEntity a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (FileManagerEntity) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.entity;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.fileId;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.localFilePath;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof o)) {
            return false;
        }
        o oVar = (o) other;
        if (Intrinsics.areEqual(this.fileId, oVar.fileId) && Intrinsics.areEqual(this.localFilePath, oVar.localFilePath) && this.errorCode == oVar.errorCode && Intrinsics.areEqual(this.entity, oVar.entity)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        int hashCode2 = ((((this.fileId.hashCode() * 31) + this.localFilePath.hashCode()) * 31) + this.errorCode) * 31;
        FileManagerEntity fileManagerEntity = this.entity;
        if (fileManagerEntity == null) {
            hashCode = 0;
        } else {
            hashCode = fileManagerEntity.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "TransferFileFinishBody(fileId=" + this.fileId + ", localFilePath=" + this.localFilePath + ", errorCode=" + this.errorCode + ", entity=" + this.entity + ")";
    }
}
