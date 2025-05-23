package com.tencent.qqnt.aio.report;

import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u001e\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001,Bk\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\b\u0012\b\b\u0002\u0010(\u001a\u00020\b\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u001a\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b\n\u0010\u001eR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u0017\u0010%\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u0017\u0010(\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/aio/report/AIOEnterPerfConfig;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "e", "()Z", "enable", "", "D", "k", "()D", "sampleRate", "f", "i", "reportRate", h.F, "j", "reportWhenBad", "reportOnce", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "b", "()I", "badFrameCount", BdhLogUtil.LogTag.Tag_Conn, "badGcCount", "c", "badGcBlockTime", "E", "enableFramePerf", UserInfo.SEX_FEMALE, "g", "enableGcPerf", "<init>", "(ZDDZZIIIZZ)V", "G", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class AIOEnterPerfConfig implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<AIOEnterPerfConfig> H;

    /* renamed from: C, reason: from kotlin metadata */
    private final int badGcCount;

    /* renamed from: D, reason: from kotlin metadata */
    private final int badGcBlockTime;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean enableFramePerf;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean enableGcPerf;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean enable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final double sampleRate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final double reportRate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean reportWhenBad;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean reportOnce;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int badFrameCount;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\n\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/report/AIOEnterPerfConfig$a;", "", "", "content", "Lcom/tencent/qqnt/aio/report/AIOEnterPerfConfig;", "b", "config$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/aio/report/AIOEnterPerfConfig;", DownloadInfo.spKey_Config, "CONFIG_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.report.AIOEnterPerfConfig$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final AIOEnterPerfConfig a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AIOEnterPerfConfig) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return (AIOEnterPerfConfig) AIOEnterPerfConfig.H.getValue();
        }

        @NotNull
        public final AIOEnterPerfConfig b(@NotNull String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIOEnterPerfConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) content);
            }
            Intrinsics.checkNotNullParameter(content, "content");
            if (TextUtils.isEmpty(content)) {
                return new AIOEnterPerfConfig(false, 0.0d, 0.0d, false, false, 0, 0, 0, false, false, 1023, null);
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                return new AIOEnterPerfConfig(jSONObject.optBoolean("enable", false), jSONObject.optDouble(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE, 0.0d), jSONObject.optDouble("report_rate", 0.0d), jSONObject.optBoolean("report_when_badcase", false), jSONObject.optBoolean("report_once", true), jSONObject.optInt("bad_frame_count", 8), jSONObject.optInt("bad_gc_count", 2), jSONObject.optInt("bad_gc_block", 100), jSONObject.optBoolean("enable_frame", false), jSONObject.optBoolean("enable_gc", false));
            } catch (JSONException e16) {
                QLog.w("AIOEnterPerfConfig", 1, "parse config error: ", e16);
                return new AIOEnterPerfConfig(false, 0.0d, 0.0d, false, false, 0, 0, 0, false, false, 1023, null);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<AIOEnterPerfConfig> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63753);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AIOEnterPerfConfig$Companion$config$2.INSTANCE);
        H = lazy;
    }

    public AIOEnterPerfConfig() {
        this(false, 0.0d, 0.0d, false, false, 0, 0, 0, false, false, 1023, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            return;
        }
        iPatchRedirector.redirect((short) 27, (Object) this);
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.badFrameCount;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.badGcBlockTime;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.badGcCount;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.enable;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIOEnterPerfConfig)) {
            return false;
        }
        AIOEnterPerfConfig aIOEnterPerfConfig = (AIOEnterPerfConfig) other;
        if (this.enable == aIOEnterPerfConfig.enable && Double.compare(this.sampleRate, aIOEnterPerfConfig.sampleRate) == 0 && Double.compare(this.reportRate, aIOEnterPerfConfig.reportRate) == 0 && this.reportWhenBad == aIOEnterPerfConfig.reportWhenBad && this.reportOnce == aIOEnterPerfConfig.reportOnce && this.badFrameCount == aIOEnterPerfConfig.badFrameCount && this.badGcCount == aIOEnterPerfConfig.badGcCount && this.badGcBlockTime == aIOEnterPerfConfig.badGcBlockTime && this.enableFramePerf == aIOEnterPerfConfig.enableFramePerf && this.enableGcPerf == aIOEnterPerfConfig.enableGcPerf) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.enableFramePerf;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.enableGcPerf;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.reportOnce;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        boolean z16 = this.enable;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int a16 = ((((r06 * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.sampleRate)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.reportRate)) * 31;
        ?? r26 = this.reportWhenBad;
        int i16 = r26;
        if (r26 != 0) {
            i16 = 1;
        }
        int i17 = (a16 + i16) * 31;
        ?? r27 = this.reportOnce;
        int i18 = r27;
        if (r27 != 0) {
            i18 = 1;
        }
        int i19 = (((((((i17 + i18) * 31) + this.badFrameCount) * 31) + this.badGcCount) * 31) + this.badGcBlockTime) * 31;
        ?? r28 = this.enableFramePerf;
        int i26 = r28;
        if (r28 != 0) {
            i26 = 1;
        }
        int i27 = (i19 + i26) * 31;
        boolean z17 = this.enableGcPerf;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i27 + i3;
    }

    public final double i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Double) iPatchRedirector.redirect((short) 5, (Object) this)).doubleValue();
        }
        return this.reportRate;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.reportWhenBad;
    }

    public final double k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Double) iPatchRedirector.redirect((short) 4, (Object) this)).doubleValue();
        }
        return this.sampleRate;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return "AIOEnterPerfConfig(enable=" + this.enable + ", sampleRate=" + this.sampleRate + ", reportRate=" + this.reportRate + ", reportWhenBad=" + this.reportWhenBad + ", reportOnce=" + this.reportOnce + ", badFrameCount=" + this.badFrameCount + ", badGcCount=" + this.badGcCount + ", badGcBlockTime=" + this.badGcBlockTime + ", enableFramePerf=" + this.enableFramePerf + ", enableGcPerf=" + this.enableGcPerf + ")";
    }

    public AIOEnterPerfConfig(boolean z16, double d16, double d17, boolean z17, boolean z18, int i3, int i16, int i17, boolean z19, boolean z26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Double.valueOf(d16), Double.valueOf(d17), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z19), Boolean.valueOf(z26));
            return;
        }
        this.enable = z16;
        this.sampleRate = d16;
        this.reportRate = d17;
        this.reportWhenBad = z17;
        this.reportOnce = z18;
        this.badFrameCount = i3;
        this.badGcCount = i16;
        this.badGcBlockTime = i17;
        this.enableFramePerf = z19;
        this.enableGcPerf = z26;
    }

    public /* synthetic */ AIOEnterPerfConfig(boolean z16, double d16, double d17, boolean z17, boolean z18, int i3, int i16, int i17, boolean z19, boolean z26, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? false : z16, (i18 & 2) != 0 ? 0.0d : d16, (i18 & 4) != 0 ? 0.0d : d17, (i18 & 8) != 0 ? false : z17, (i18 & 16) != 0 ? true : z18, (i18 & 32) != 0 ? 8 : i3, (i18 & 64) != 0 ? 3 : i16, (i18 & 128) != 0 ? 100 : i17, (i18 & 256) != 0 ? false : z19, (i18 & 512) != 0 ? false : z26);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Double.valueOf(d16), Double.valueOf(d17), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z19), Boolean.valueOf(z26), Integer.valueOf(i18), defaultConstructorMarker);
    }
}
