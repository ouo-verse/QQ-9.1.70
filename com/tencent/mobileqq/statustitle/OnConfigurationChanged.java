package com.tencent.mobileqq.statustitle;

import android.content.res.Configuration;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/statustitle/OnConfigurationChanged;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "newConfig", "Landroid/content/res/Configuration;", "(Landroid/content/res/Configuration;)V", "getNewConfig", "()Landroid/content/res/Configuration;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final /* data */ class OnConfigurationChanged extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final Configuration newConfig;

    public OnConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) newConfig);
        } else {
            this.newConfig = newConfig;
        }
    }

    public static /* synthetic */ OnConfigurationChanged copy$default(OnConfigurationChanged onConfigurationChanged, Configuration configuration, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            configuration = onConfigurationChanged.newConfig;
        }
        return onConfigurationChanged.copy(configuration);
    }

    @NotNull
    public final Configuration component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Configuration) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.newConfig;
    }

    @NotNull
    public final OnConfigurationChanged copy(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (OnConfigurationChanged) iPatchRedirector.redirect((short) 4, (Object) this, (Object) newConfig);
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        return new OnConfigurationChanged(newConfig);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof OnConfigurationChanged) && Intrinsics.areEqual(this.newConfig, ((OnConfigurationChanged) other).newConfig)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Configuration getNewConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Configuration) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.newConfig;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.newConfig.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "OnConfigurationChanged(newConfig=" + this.newConfig + ")";
    }
}
