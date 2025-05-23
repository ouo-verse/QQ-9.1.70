package com.tencent.mobileqq.qqlive.api.room;

import android.os.Bundle;
import androidx.fragment.app.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0010H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010(\u001a\u00020\nH\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\nH\u00c6\u0003Js\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u00020\u0005H\u00d6\u0001J\t\u00101\u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001f\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/StartRoomConfig;", "", "roomId", "", "roomType", "", "playUrl", "", "coverUrl", "translucentPage", "", "videoSource", "abToken", "from", "noClearTop", "bundle", "Landroid/os/Bundle;", "(JILjava/lang/String;Ljava/lang/String;ZJLjava/lang/String;IZLandroid/os/Bundle;)V", "getAbToken", "()Ljava/lang/String;", "getBundle", "()Landroid/os/Bundle;", "getCoverUrl", "getFrom", "()I", "setFrom", "(I)V", "getNoClearTop", "()Z", "getPlayUrl", "getRoomId", "()J", "getRoomType", "getTranslucentPage", "getVideoSource", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "qq-live-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final /* data */ class StartRoomConfig {
    static IPatchRedirector $redirector_;

    @Nullable
    private final String abToken;

    @NotNull
    private final Bundle bundle;

    @Nullable
    private final String coverUrl;
    private int from;
    private final boolean noClearTop;

    @Nullable
    private final String playUrl;
    private final long roomId;
    private final int roomType;
    private final boolean translucentPage;
    private final long videoSource;

    @JvmOverloads
    public StartRoomConfig(long j3) {
        this(j3, 0, null, null, false, 0L, null, 0, false, null, 1022, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            return;
        }
        iPatchRedirector.redirect((short) 36, (Object) this, j3);
    }

    public final long component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.roomId;
    }

    @NotNull
    public final Bundle component10() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Bundle) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.bundle;
    }

    public final int component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.roomType;
    }

    @Nullable
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.playUrl;
    }

    @Nullable
    public final String component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.coverUrl;
    }

    public final boolean component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.translucentPage;
    }

    public final long component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        return this.videoSource;
    }

    @Nullable
    public final String component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.abToken;
    }

    public final int component8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.from;
    }

    public final boolean component9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.noClearTop;
    }

    @NotNull
    public final StartRoomConfig copy(long roomId, int roomType, @Nullable String playUrl, @Nullable String coverUrl, boolean translucentPage, long videoSource, @Nullable String abToken, int from, boolean noClearTop, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (StartRoomConfig) iPatchRedirector.redirect((short) 24, this, Long.valueOf(roomId), Integer.valueOf(roomType), playUrl, coverUrl, Boolean.valueOf(translucentPage), Long.valueOf(videoSource), abToken, Integer.valueOf(from), Boolean.valueOf(noClearTop), bundle);
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return new StartRoomConfig(roomId, roomType, playUrl, coverUrl, translucentPage, videoSource, abToken, from, noClearTop, bundle);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartRoomConfig)) {
            return false;
        }
        StartRoomConfig startRoomConfig = (StartRoomConfig) other;
        if (this.roomId == startRoomConfig.roomId && this.roomType == startRoomConfig.roomType && Intrinsics.areEqual(this.playUrl, startRoomConfig.playUrl) && Intrinsics.areEqual(this.coverUrl, startRoomConfig.coverUrl) && this.translucentPage == startRoomConfig.translucentPage && this.videoSource == startRoomConfig.videoSource && Intrinsics.areEqual(this.abToken, startRoomConfig.abToken) && this.from == startRoomConfig.from && this.noClearTop == startRoomConfig.noClearTop && Intrinsics.areEqual(this.bundle, startRoomConfig.bundle)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getAbToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.abToken;
    }

    @NotNull
    public final Bundle getBundle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Bundle) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.bundle;
    }

    @Nullable
    public final String getCoverUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.coverUrl;
    }

    public final int getFrom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.from;
    }

    public final boolean getNoClearTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.noClearTop;
    }

    @Nullable
    public final String getPlayUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.playUrl;
    }

    public final long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.roomId;
    }

    public final int getRoomType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.roomType;
    }

    public final boolean getTranslucentPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.translucentPage;
    }

    public final long getVideoSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.videoSource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        int a16 = ((a.a(this.roomId) * 31) + this.roomType) * 31;
        String str = this.playUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        String str2 = this.coverUrl;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        boolean z16 = this.translucentPage;
        int i18 = 1;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        int a17 = (((i17 + i19) * 31) + a.a(this.videoSource)) * 31;
        String str3 = this.abToken;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        int i26 = (((a17 + i3) * 31) + this.from) * 31;
        boolean z17 = this.noClearTop;
        if (!z17) {
            i18 = z17 ? 1 : 0;
        }
        return ((i26 + i18) * 31) + this.bundle.hashCode();
    }

    public final void setFrom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.from = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return "StartRoomConfig(roomId=" + this.roomId + ", roomType=" + this.roomType + ", playUrl=" + this.playUrl + ", coverUrl=" + this.coverUrl + ", translucentPage=" + this.translucentPage + ", videoSource=" + this.videoSource + ", abToken=" + this.abToken + ", from=" + this.from + ", noClearTop=" + this.noClearTop + ", bundle=" + this.bundle + ')';
    }

    @JvmOverloads
    public StartRoomConfig(long j3, int i3) {
        this(j3, i3, null, null, false, 0L, null, 0, false, null, 1020, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) {
            return;
        }
        iPatchRedirector.redirect((short) 35, this, Long.valueOf(j3), Integer.valueOf(i3));
    }

    @JvmOverloads
    public StartRoomConfig(long j3, int i3, @Nullable String str) {
        this(j3, i3, str, null, false, 0L, null, 0, false, null, 1016, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) {
            return;
        }
        iPatchRedirector.redirect((short) 34, this, Long.valueOf(j3), Integer.valueOf(i3), str);
    }

    @JvmOverloads
    public StartRoomConfig(long j3, int i3, @Nullable String str, @Nullable String str2) {
        this(j3, i3, str, str2, false, 0L, null, 0, false, null, 1008, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) {
            return;
        }
        iPatchRedirector.redirect((short) 33, this, Long.valueOf(j3), Integer.valueOf(i3), str, str2);
    }

    @JvmOverloads
    public StartRoomConfig(long j3, int i3, @Nullable String str, @Nullable String str2, boolean z16) {
        this(j3, i3, str, str2, z16, 0L, null, 0, false, null, 992, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) {
            return;
        }
        iPatchRedirector.redirect((short) 32, this, Long.valueOf(j3), Integer.valueOf(i3), str, str2, Boolean.valueOf(z16));
    }

    @JvmOverloads
    public StartRoomConfig(long j3, int i3, @Nullable String str, @Nullable String str2, boolean z16, long j16) {
        this(j3, i3, str, str2, z16, j16, null, 0, false, null, 960, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            return;
        }
        iPatchRedirector.redirect((short) 31, this, Long.valueOf(j3), Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), Long.valueOf(j16));
    }

    @JvmOverloads
    public StartRoomConfig(long j3, int i3, @Nullable String str, @Nullable String str2, boolean z16, long j16, @Nullable String str3) {
        this(j3, i3, str, str2, z16, j16, str3, 0, false, null, 896, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
            return;
        }
        iPatchRedirector.redirect((short) 30, this, Long.valueOf(j3), Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), Long.valueOf(j16), str3);
    }

    @JvmOverloads
    public StartRoomConfig(long j3, int i3, @Nullable String str, @Nullable String str2, boolean z16, long j16, @Nullable String str3, int i16) {
        this(j3, i3, str, str2, z16, j16, str3, i16, false, null, 768, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) {
            return;
        }
        iPatchRedirector.redirect((short) 29, this, Long.valueOf(j3), Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), Long.valueOf(j16), str3, Integer.valueOf(i16));
    }

    @JvmOverloads
    public StartRoomConfig(long j3, int i3, @Nullable String str, @Nullable String str2, boolean z16, long j16, @Nullable String str3, int i16, boolean z17) {
        this(j3, i3, str, str2, z16, j16, str3, i16, z17, null, 512, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            return;
        }
        iPatchRedirector.redirect((short) 28, this, Long.valueOf(j3), Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), Long.valueOf(j16), str3, Integer.valueOf(i16), Boolean.valueOf(z17));
    }

    @JvmOverloads
    public StartRoomConfig(long j3, int i3, @Nullable String str, @Nullable String str2, boolean z16, long j16, @Nullable String str3, int i16, boolean z17, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), Long.valueOf(j16), str3, Integer.valueOf(i16), Boolean.valueOf(z17), bundle);
            return;
        }
        this.roomId = j3;
        this.roomType = i3;
        this.playUrl = str;
        this.coverUrl = str2;
        this.translucentPage = z16;
        this.videoSource = j16;
        this.abToken = str3;
        this.from = i16;
        this.noClearTop = z17;
        this.bundle = bundle;
    }

    public /* synthetic */ StartRoomConfig(long j3, int i3, String str, String str2, boolean z16, long j16, String str3, int i16, boolean z17, Bundle bundle, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? "" : str, (i17 & 8) != 0 ? "" : str2, (i17 & 16) != 0 ? false : z16, (i17 & 32) != 0 ? 0L : j16, (i17 & 64) != 0 ? "" : str3, (i17 & 128) != 0 ? -1 : i16, (i17 & 256) != 0 ? false : z17, (i17 & 512) != 0 ? new Bundle() : bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), Long.valueOf(j16), str3, Integer.valueOf(i16), Boolean.valueOf(z17), bundle, Integer.valueOf(i17), defaultConstructorMarker);
    }
}
