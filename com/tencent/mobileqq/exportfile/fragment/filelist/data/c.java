package com.tencent.mobileqq.exportfile.fragment.filelist.data;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeNodeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u00a2\u0006\u0004\b\"\u0010#J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\"\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\"\u0004\b \u0010\u0013\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/data/c;", "", "other", "", "equals", "", "toString", "", "hashCode", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeNodeInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeNodeInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeNodeInfo;", "nodeInfo", "b", "Ljava/lang/String;", "getLocalPath", "()Ljava/lang/String;", "setLocalPath", "(Ljava/lang/String;)V", "localPath", "c", "Z", "getCanCheckable", "()Z", "setCanCheckable", "(Z)V", "canCheckable", "d", "isChecked", "setChecked", "e", "setThumbnailPath", "thumbnailPath", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeNodeInfo;Ljava/lang/String;ZZLjava/lang/String;)V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FileBridgeNodeInfo nodeInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String localPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean canCheckable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isChecked;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String thumbnailPath;

    public c(@NotNull FileBridgeNodeInfo nodeInfo, @NotNull String localPath, boolean z16, boolean z17, @NotNull String thumbnailPath) {
        Intrinsics.checkNotNullParameter(nodeInfo, "nodeInfo");
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(thumbnailPath, "thumbnailPath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, nodeInfo, localPath, Boolean.valueOf(z16), Boolean.valueOf(z17), thumbnailPath);
            return;
        }
        this.nodeInfo = nodeInfo;
        this.localPath = localPath;
        this.canCheckable = z16;
        this.isChecked = z17;
        this.thumbnailPath = thumbnailPath;
    }

    @NotNull
    public final FileBridgeNodeInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (FileBridgeNodeInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.nodeInfo;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.thumbnailPath;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (!(other instanceof c) || TextUtils.isEmpty(this.nodeInfo.fileId)) {
            return false;
        }
        return TextUtils.equals(this.nodeInfo.fileId, ((c) other).nodeInfo.fileId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        int hashCode = ((this.nodeInfo.hashCode() * 31) + this.localPath.hashCode()) * 31;
        boolean z16 = this.canCheckable;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.isChecked;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i17 + i3) * 31) + this.thumbnailPath.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "FileRecord(nodeInfo=" + this.nodeInfo + ", localPath=" + this.localPath + ", canCheckable=" + this.canCheckable + ", isChecked=" + this.isChecked + ", thumbnailPath=" + this.thumbnailPath + ")";
    }

    public /* synthetic */ c(FileBridgeNodeInfo fileBridgeNodeInfo, String str, boolean z16, boolean z17, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileBridgeNodeInfo, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? false : z17, (i3 & 16) != 0 ? "" : str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, fileBridgeNodeInfo, str, Boolean.valueOf(z16), Boolean.valueOf(z17), str2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
