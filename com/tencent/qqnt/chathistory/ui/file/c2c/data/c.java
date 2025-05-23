package com.tencent.qqnt.chathistory.ui.file.c2c.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.chathistory.util.PicSize;
import com.tencent.weiyun.transmission.db.JobDbManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/c;", "", "", "c", "b", "", "toString", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "a", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "()Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "data", "Lcom/tencent/qqnt/chathistory/util/PicSize;", "Lcom/tencent/qqnt/chathistory/util/PicSize;", "getSize", "()Lcom/tencent/qqnt/chathistory/util/PicSize;", "size", "Z", "getUpload", "()Z", JobDbManager.TBL_UPLOAD, "<init>", "(Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;Lcom/tencent/qqnt/chathistory/util/PicSize;Z)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FileItemModel data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PicSize size;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean upload;

    public c(@NotNull FileItemModel data, @NotNull PicSize size, boolean z16) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(size, "size");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, data, size, Boolean.valueOf(z16));
            return;
        }
        this.data = data;
        this.size = size;
        this.upload = z16;
    }

    @NotNull
    public final FileItemModel a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (FileItemModel) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.data;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.data.m(this.size);
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.data.n(this.size);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.data, cVar.data) && this.size == cVar.size && this.upload == cVar.upload) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        int hashCode = ((this.data.hashCode() * 31) + this.size.hashCode()) * 31;
        boolean z16 = this.upload;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "FileDownLoadParam(data=" + this.data + ", size=" + this.size + ", upload=" + this.upload + ")";
    }

    public /* synthetic */ c(FileItemModel fileItemModel, PicSize picSize, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileItemModel, picSize, (i3 & 4) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, fileItemModel, picSize, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
