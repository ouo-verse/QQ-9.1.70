package com.tencent.mobileqq.qqlive.api.config.qmanage;

import com.tencent.ark.ark;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J(\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000fJ(\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/config/qmanage/ConfigItem;", "", "content", "", "greyHitStatus", "Lcom/tencent/mobileqq/qqlive/api/config/qmanage/GreyHitStatus;", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqlive/api/config/qmanage/GreyHitStatus;)V", "getContent", "()Ljava/lang/String;", "getGreyHitStatus", "()Lcom/tencent/mobileqq/qqlive/api/config/qmanage/GreyHitStatus;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "parseSwitch", "switchKey", "switchOpenVal", "defaultVal", "defaultValWhenNotHit", ark.ARKMETADATA_JSON, "exceptionVal", "toString", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final /* data */ class ConfigItem {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String content;

    @NotNull
    private final GreyHitStatus greyHitStatus;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28264);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[GreyHitStatus.values().length];
            try {
                iArr[GreyHitStatus.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GreyHitStatus.NOT_HIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ConfigItem(@NotNull String content, @NotNull GreyHitStatus greyHitStatus) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(greyHitStatus, "greyHitStatus");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) content, (Object) greyHitStatus);
        } else {
            this.content = content;
            this.greyHitStatus = greyHitStatus;
        }
    }

    public static /* synthetic */ ConfigItem copy$default(ConfigItem configItem, String str, GreyHitStatus greyHitStatus, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = configItem.content;
        }
        if ((i3 & 2) != 0) {
            greyHitStatus = configItem.greyHitStatus;
        }
        return configItem.copy(str, greyHitStatus);
    }

    public static /* synthetic */ boolean parseSwitch$default(ConfigItem configItem, String str, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z17 = z16;
        }
        return configItem.parseSwitch(str, i3, z16, z17);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.content;
    }

    @NotNull
    public final GreyHitStatus component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (GreyHitStatus) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.greyHitStatus;
    }

    @NotNull
    public final ConfigItem copy(@NotNull String content, @NotNull GreyHitStatus greyHitStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ConfigItem) iPatchRedirector.redirect((short) 7, (Object) this, (Object) content, (Object) greyHitStatus);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(greyHitStatus, "greyHitStatus");
        return new ConfigItem(content, greyHitStatus);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigItem)) {
            return false;
        }
        ConfigItem configItem = (ConfigItem) other;
        if (Intrinsics.areEqual(this.content, configItem.content) && this.greyHitStatus == configItem.greyHitStatus) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.content;
    }

    @NotNull
    public final GreyHitStatus getGreyHitStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GreyHitStatus) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.greyHitStatus;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return (this.content.hashCode() * 31) + this.greyHitStatus.hashCode();
    }

    public final boolean parseSwitch(@NotNull String switchKey, int switchOpenVal, boolean defaultVal, boolean defaultValWhenNotHit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, switchKey, Integer.valueOf(switchOpenVal), Boolean.valueOf(defaultVal), Boolean.valueOf(defaultValWhenNotHit))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(switchKey, "switchKey");
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.greyHitStatus.ordinal()];
        return i3 != 1 ? i3 != 2 ? parseSwitch(this.content, switchKey, switchOpenVal, defaultVal) : defaultValWhenNotHit : defaultVal;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "ConfigItem(content=" + this.content + ", greyHitStatus=" + this.greyHitStatus + ')';
    }

    private final boolean parseSwitch(String json, String switchKey, int switchOpenVal, boolean exceptionVal) {
        try {
            return new JSONObject(json).optInt(switchKey) == switchOpenVal;
        } catch (Exception e16) {
            QLog.e("ConfigItem", 1, e16, new Object[0]);
            return exceptionVal;
        }
    }
}
