package com.tencent.mobileqq.nativefilescan;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014JC\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\f\u0010\rJQ\u0010\u0011\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/nativefilescan/a;", "Lcom/tencent/mobileqq/nativefilescan/Callback;", "", "", "dirArray", "nameArray", "", "accessTimeArray", "sizeArray", "", "lastIndex", "", "onDirInfoAvailable", "([Ljava/lang/String;[Ljava/lang/String;[J[JI)V", "filePathArray", "extensionArrayArray", "lastModifiedTimeArray", "onFileInfoAvailable", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[J[JI)V", "<init>", "()V", "core_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes15.dex */
public class a implements Callback {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.nativefilescan.Callback
    public void onDirInfoAvailable(@NotNull String[] dirArray, @NotNull String[] nameArray, @NotNull long[] accessTimeArray, @NotNull long[] sizeArray, int lastIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, dirArray, nameArray, accessTimeArray, sizeArray, Integer.valueOf(lastIndex));
            return;
        }
        Intrinsics.checkNotNullParameter(dirArray, "dirArray");
        Intrinsics.checkNotNullParameter(nameArray, "nameArray");
        Intrinsics.checkNotNullParameter(accessTimeArray, "accessTimeArray");
        Intrinsics.checkNotNullParameter(sizeArray, "sizeArray");
    }

    @Override // com.tencent.mobileqq.nativefilescan.Callback
    public void onFileInfoAvailable(@NotNull String[] filePathArray, @NotNull String[] nameArray, @NotNull String[] extensionArrayArray, @NotNull long[] lastModifiedTimeArray, @NotNull long[] sizeArray, int lastIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, filePathArray, nameArray, extensionArrayArray, lastModifiedTimeArray, sizeArray, Integer.valueOf(lastIndex));
            return;
        }
        Intrinsics.checkNotNullParameter(filePathArray, "filePathArray");
        Intrinsics.checkNotNullParameter(nameArray, "nameArray");
        Intrinsics.checkNotNullParameter(extensionArrayArray, "extensionArrayArray");
        Intrinsics.checkNotNullParameter(lastModifiedTimeArray, "lastModifiedTimeArray");
        Intrinsics.checkNotNullParameter(sizeArray, "sizeArray");
    }
}
