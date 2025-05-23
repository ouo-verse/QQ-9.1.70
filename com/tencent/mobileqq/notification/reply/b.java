package com.tencent.mobileqq.notification.reply;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\n\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0018\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/notification/reply/b;", "", "", "myManufacturer", "myModel", "", "myApiLevel", "", "a", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getManufacturer", "()Ljava/lang/String;", "manufacturer", "b", "getModel", "model", "c", "I", "getApiLevel", "()I", "apiLevel", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "qq_notification_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String manufacturer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String model;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int apiLevel;

    public b(@NotNull String manufacturer, @NotNull String model, int i3) {
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, manufacturer, model, Integer.valueOf(i3));
            return;
        }
        this.manufacturer = manufacturer;
        this.model = model;
        this.apiLevel = i3;
    }

    public final boolean a(@NotNull String myManufacturer, @NotNull String myModel, int myApiLevel) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, myManufacturer, myModel, Integer.valueOf(myApiLevel))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(myManufacturer, "myManufacturer");
        Intrinsics.checkNotNullParameter(myModel, "myModel");
        if (this.manufacturer.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !Intrinsics.areEqual(this.manufacturer, myManufacturer)) {
            return false;
        }
        if (this.model.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && !Intrinsics.areEqual(this.model, myModel)) {
            return false;
        }
        int i3 = this.apiLevel;
        if (i3 == 0 || i3 == myApiLevel) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.manufacturer, bVar.manufacturer) && Intrinsics.areEqual(this.model, bVar.model) && this.apiLevel == bVar.apiLevel) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return (((this.manufacturer.hashCode() * 31) + this.model.hashCode()) * 31) + this.apiLevel;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "MsgReplyDeviceDesc(manufacturer=" + this.manufacturer + ", model=" + this.model + ", apiLevel=" + this.apiLevel + ")";
    }
}
