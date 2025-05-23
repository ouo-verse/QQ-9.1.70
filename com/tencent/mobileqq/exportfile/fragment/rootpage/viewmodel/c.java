package com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeDirectoryType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\b\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/rootpage/viewmodel/c;", "Lcom/tencent/mobileqq/exportfile/fragment/rootpage/viewmodel/a;", "", "b", "Ljava/lang/String;", "getIconPath", "()Ljava/lang/String;", "iconPath", "c", "fileId", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeDirectoryType;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeDirectoryType;", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeDirectoryType;", "type", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeDirectoryType;)V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String iconPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String fileId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FileBridgeDirectoryType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull String name, @NotNull String iconPath, @NotNull String fileId, @NotNull FileBridgeDirectoryType type) {
        super(name, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iconPath, "iconPath");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, name, iconPath, fileId, type);
            return;
        }
        this.iconPath = iconPath;
        this.fileId = fileId;
        this.type = type;
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
    public final FileBridgeDirectoryType c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FileBridgeDirectoryType) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.type;
    }
}
