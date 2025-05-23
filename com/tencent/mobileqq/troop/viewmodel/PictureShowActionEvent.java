package com.tencent.mobileqq.troop.viewmodel;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/viewmodel/PictureShowActionEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "callbackId", "", "type", "", "isLiked", "", "(Ljava/lang/String;IZ)V", "getCallbackId", "()Ljava/lang/String;", "()Z", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final /* data */ class PictureShowActionEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String callbackId;
    private final boolean isLiked;
    private final int type;

    public PictureShowActionEvent(@NotNull String callbackId, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, callbackId, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.callbackId = callbackId;
        this.type = i3;
        this.isLiked = z16;
    }

    public static /* synthetic */ PictureShowActionEvent copy$default(PictureShowActionEvent pictureShowActionEvent, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = pictureShowActionEvent.callbackId;
        }
        if ((i16 & 2) != 0) {
            i3 = pictureShowActionEvent.type;
        }
        if ((i16 & 4) != 0) {
            z16 = pictureShowActionEvent.isLiked;
        }
        return pictureShowActionEvent.copy(str, i3, z16);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.callbackId;
    }

    public final int component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.type;
    }

    public final boolean component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isLiked;
    }

    @NotNull
    public final PictureShowActionEvent copy(@NotNull String callbackId, int type, boolean isLiked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (PictureShowActionEvent) iPatchRedirector.redirect((short) 8, this, callbackId, Integer.valueOf(type), Boolean.valueOf(isLiked));
        }
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        return new PictureShowActionEvent(callbackId, type, isLiked);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof PictureShowActionEvent)) {
            return false;
        }
        PictureShowActionEvent pictureShowActionEvent = (PictureShowActionEvent) other;
        if (Intrinsics.areEqual(this.callbackId, pictureShowActionEvent.callbackId) && this.type == pictureShowActionEvent.type && this.isLiked == pictureShowActionEvent.isLiked) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getCallbackId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.callbackId;
    }

    public final int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        int hashCode = ((this.callbackId.hashCode() * 31) + this.type) * 31;
        boolean z16 = this.isLiked;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final boolean isLiked() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isLiked;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "PictureShowActionEvent(callbackId=" + this.callbackId + ", type=" + this.type + ", isLiked=" + this.isLiked + ")";
    }
}
