package com.tencent.mobileqq.aio.msglist.holder.base;

import com.tencent.libra.download.ILibraDownloader;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/libra/request/Option;", "Lcom/tencent/libra/request/Option;", "c", "()Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/libra/download/ILibraDownloader$PicDownLoadListener;", "Lcom/tencent/libra/download/ILibraDownloader$PicDownLoadListener;", "()Lcom/tencent/libra/download/ILibraDownloader$PicDownLoadListener;", "listener", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgElement msgElement;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Option option;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ILibraDownloader.PicDownLoadListener listener;

    @NotNull
    public final ILibraDownloader.PicDownLoadListener a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ILibraDownloader.PicDownLoadListener) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.listener;
    }

    @NotNull
    public final MsgElement b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgElement) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msgElement;
    }

    @NotNull
    public final Option c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Option) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.option;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof h)) {
            return false;
        }
        h hVar = (h) other;
        if (Intrinsics.areEqual(this.msgElement, hVar.msgElement) && Intrinsics.areEqual(this.option, hVar.option) && Intrinsics.areEqual(this.listener, hVar.listener)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return (((this.msgElement.hashCode() * 31) + this.option.hashCode()) * 31) + this.listener.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "FileDownloadContext(msgElement=" + this.msgElement + ", option=" + this.option + ", listener=" + this.listener + ")";
    }
}
