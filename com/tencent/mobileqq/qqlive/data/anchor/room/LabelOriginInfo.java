package com.tencent.mobileqq.qqlive.data.anchor.room;

import androidx.fragment.app.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001J\t\u0010#\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqlive/data/anchor/room/LabelOriginInfo;", "", "secondId", "", "id", "", VirtualAppProxy.KEY_GAME_ID, "name", "", "logo", "showLogo", "labelType", "(IJILjava/lang/String;Ljava/lang/String;II)V", "getGameId", "()I", "getId", "()J", "getLabelType", "getLogo", "()Ljava/lang/String;", "getName", "getSecondId", "getShowLogo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final /* data */ class LabelOriginInfo {
    static IPatchRedirector $redirector_;
    private final int gameId;
    private final long id;
    private final int labelType;

    @NotNull
    private final String logo;

    @NotNull
    private final String name;
    private final int secondId;
    private final int showLogo;

    public LabelOriginInfo(int i3, long j3, int i16, @NotNull String name, @NotNull String logo, int i17, int i18) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(logo, "logo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), name, logo, Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.secondId = i3;
        this.id = j3;
        this.gameId = i16;
        this.name = name;
        this.logo = logo;
        this.showLogo = i17;
        this.labelType = i18;
    }

    public static /* synthetic */ LabelOriginInfo copy$default(LabelOriginInfo labelOriginInfo, int i3, long j3, int i16, String str, String str2, int i17, int i18, int i19, Object obj) {
        int i26;
        long j16;
        int i27;
        String str3;
        String str4;
        int i28;
        int i29;
        if ((i19 & 1) != 0) {
            i26 = labelOriginInfo.secondId;
        } else {
            i26 = i3;
        }
        if ((i19 & 2) != 0) {
            j16 = labelOriginInfo.id;
        } else {
            j16 = j3;
        }
        if ((i19 & 4) != 0) {
            i27 = labelOriginInfo.gameId;
        } else {
            i27 = i16;
        }
        if ((i19 & 8) != 0) {
            str3 = labelOriginInfo.name;
        } else {
            str3 = str;
        }
        if ((i19 & 16) != 0) {
            str4 = labelOriginInfo.logo;
        } else {
            str4 = str2;
        }
        if ((i19 & 32) != 0) {
            i28 = labelOriginInfo.showLogo;
        } else {
            i28 = i17;
        }
        if ((i19 & 64) != 0) {
            i29 = labelOriginInfo.labelType;
        } else {
            i29 = i18;
        }
        return labelOriginInfo.copy(i26, j16, i27, str3, str4, i28, i29);
    }

    public final int component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.secondId;
    }

    public final long component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.id;
    }

    public final int component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.gameId;
    }

    @NotNull
    public final String component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.name;
    }

    @NotNull
    public final String component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.logo;
    }

    public final int component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.showLogo;
    }

    public final int component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.labelType;
    }

    @NotNull
    public final LabelOriginInfo copy(int secondId, long id5, int gameId, @NotNull String name, @NotNull String logo, int showLogo, int labelType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (LabelOriginInfo) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(secondId), Long.valueOf(id5), Integer.valueOf(gameId), name, logo, Integer.valueOf(showLogo), Integer.valueOf(labelType));
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(logo, "logo");
        return new LabelOriginInfo(secondId, id5, gameId, name, logo, showLogo, labelType);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof LabelOriginInfo)) {
            return false;
        }
        LabelOriginInfo labelOriginInfo = (LabelOriginInfo) other;
        if (this.secondId == labelOriginInfo.secondId && this.id == labelOriginInfo.id && this.gameId == labelOriginInfo.gameId && Intrinsics.areEqual(this.name, labelOriginInfo.name) && Intrinsics.areEqual(this.logo, labelOriginInfo.logo) && this.showLogo == labelOriginInfo.showLogo && this.labelType == labelOriginInfo.labelType) {
            return true;
        }
        return false;
    }

    public final int getGameId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.gameId;
    }

    public final long getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.id;
    }

    public final int getLabelType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.labelType;
    }

    @NotNull
    public final String getLogo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.logo;
    }

    @NotNull
    public final String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.name;
    }

    public final int getSecondId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.secondId;
    }

    public final int getShowLogo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.showLogo;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return (((((((((((this.secondId * 31) + a.a(this.id)) * 31) + this.gameId) * 31) + this.name.hashCode()) * 31) + this.logo.hashCode()) * 31) + this.showLogo) * 31) + this.labelType;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "LabelOriginInfo(secondId=" + this.secondId + ", id=" + this.id + ", gameId=" + this.gameId + ", name=" + this.name + ", logo=" + this.logo + ", showLogo=" + this.showLogo + ", labelType=" + this.labelType + ")";
    }
}
