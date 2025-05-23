package com.tencent.mobileqq.perf.process.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u000bB9\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\u000b\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/perf/process/config/a;", "", "", "d", "e", "", "toString", "", "hashCode", "other", "equals", "a", "I", "getSwitch", "()I", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "b", "getTopVersionType", "topVersionType", "c", "delayStatWhenBackground", "delayStatCollect", "checkOnNetChange", "<init>", "(IIIII)V", "f", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final String f257890g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int switch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int topVersionType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int delayStatWhenBackground;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int delayStatCollect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int checkOnNetChange;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/perf/process/config/a$a;", "", "Lcom/tencent/mobileqq/perf/process/config/a;", "a", "", "AUDIO_STAT_SWITCH_OPEN", "I", "CHECK_ON_NET_CHANGE_WIFI", "", "DEFAULT_CONFIG_JSON", "Ljava/lang/String;", "DELAY_STAT_COLLECT", "DELAY_WHEN_BACKGROUND", "TAG", "VERSION_TYPE_DEBUG", "VERSION_TYPE_RELEASE", "VERSION_TYPE_RELEASE_GREY", "VERSION_TYPE_RELEASE_PUBLIC", "WNS_CONFIG_MAIN_KEY", "WNS_CONFIG_SUB_KEY", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.process.config.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final a a() {
            boolean isBlank;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            try {
                String jsonString = QzoneConfig.getInstance().getConfig("qqlive", "background_audio_stat_config", "");
                Intrinsics.checkNotNullExpressionValue(jsonString, "jsonString");
                isBlank = StringsKt__StringsJVMKt.isBlank(jsonString);
                if (isBlank) {
                    QLog.d("AudioStatConfig", 4, "no wns config");
                    return new a(0, 0, 0, 0, 0, 31, null);
                }
                JSONObject jSONObject = new JSONObject(jsonString);
                return new a(jSONObject.getInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH), jSONObject.getInt("topVersionType"), jSONObject.getInt("delayStatWhenBackground"), jSONObject.getInt("delayStatCollect"), jSONObject.getInt("checkOnNetChange"));
            } catch (Exception e16) {
                QLog.e("AudioStatConfig", 1, "[parse] error, ", e16);
                return new a(0, 0, 0, 0, 0, 31, null);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31868);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
            f257890g = "\n                {\n                    \"switch\": 1,\n                    \"topVersionType\": 3,\n                    \"delayStatWhenBackground\": 3000,\n                    \"delayStatCollect\": 2000,\n                    \"checkOnNetChange\": 1\n                }\n            ";
        }
    }

    public a() {
        this(0, 0, 0, 0, 0, 31, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, (Object) this);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.checkOnNetChange;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.delayStatCollect;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.delayStatWhenBackground;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.switch == 1) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        int i3 = this.topVersionType;
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 == 4) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.switch == aVar.switch && this.topVersionType == aVar.topVersionType && this.delayStatWhenBackground == aVar.delayStatWhenBackground && this.delayStatCollect == aVar.delayStatCollect && this.checkOnNetChange == aVar.checkOnNetChange) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return (((((((this.switch * 31) + this.topVersionType) * 31) + this.delayStatWhenBackground) * 31) + this.delayStatCollect) * 31) + this.checkOnNetChange;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "AudioStatConfig(switch=" + this.switch + ", topVersionType=" + this.topVersionType + ", delayStatWhenBackground=" + this.delayStatWhenBackground + ", delayStatCollect=" + this.delayStatCollect + ", checkOnNetChange=" + this.checkOnNetChange + ')';
    }

    public a(int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        this.switch = i3;
        this.topVersionType = i16;
        this.delayStatWhenBackground = i17;
        this.delayStatCollect = i18;
        this.checkOnNetChange = i19;
    }

    public /* synthetic */ a(int i3, int i16, int i17, int i18, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? 1 : i3, (i26 & 2) != 0 ? 3 : i16, (i26 & 4) != 0 ? 3000 : i17, (i26 & 8) != 0 ? 2000 : i18, (i26 & 16) != 0 ? 1 : i19);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), defaultConstructorMarker);
    }
}
