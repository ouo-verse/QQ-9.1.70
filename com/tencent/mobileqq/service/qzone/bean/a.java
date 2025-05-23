package com.tencent.mobileqq.service.qzone.bean;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fB\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/service/qzone/bean/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/service/qzone/bean/a$a;", "summaryRes", "Lcom/tencent/mobileqq/service/qzone/bean/a$a;", "a", "()Lcom/tencent/mobileqq/service/qzone/bean/a$a;", "<init>", "(Lcom/tencent/mobileqq/service/qzone/bean/a$a;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    @SerializedName("summary_res")
    @Nullable
    private final C8576a summaryRes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/service/qzone/bean/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "mode", "Ljava/lang/String;", "getMode", "()Ljava/lang/String;", "text", "getText", "bgLight", "b", "bgDark", "a", "textColorLight", "d", "textColorDark", "c", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.service.qzone.bean.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final /* data */ class C8576a {
        static IPatchRedirector $redirector_;

        @SerializedName("bg_dark")
        @NotNull
        private final String bgDark;

        @SerializedName("bg_light")
        @NotNull
        private final String bgLight;

        @SerializedName("mode")
        @NotNull
        private final String mode;

        @SerializedName("text")
        @NotNull
        private final String text;

        @SerializedName("text_color_dark")
        @NotNull
        private final String textColorDark;

        @SerializedName("text_color_light")
        @NotNull
        private final String textColorLight;

        public C8576a(@NotNull String mode, @NotNull String text, @NotNull String bgLight, @NotNull String bgDark, @NotNull String textColorLight, @NotNull String textColorDark) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(bgLight, "bgLight");
            Intrinsics.checkNotNullParameter(bgDark, "bgDark");
            Intrinsics.checkNotNullParameter(textColorLight, "textColorLight");
            Intrinsics.checkNotNullParameter(textColorDark, "textColorDark");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, mode, text, bgLight, bgDark, textColorLight, textColorDark);
                return;
            }
            this.mode = mode;
            this.text = text;
            this.bgLight = bgLight;
            this.bgDark = bgDark;
            this.textColorLight = textColorLight;
            this.textColorDark = textColorDark;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.bgDark;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.bgLight;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.textColorDark;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.textColorLight;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C8576a)) {
                return false;
            }
            C8576a c8576a = (C8576a) other;
            if (Intrinsics.areEqual(this.mode, c8576a.mode) && Intrinsics.areEqual(this.text, c8576a.text) && Intrinsics.areEqual(this.bgLight, c8576a.bgLight) && Intrinsics.areEqual(this.bgDark, c8576a.bgDark) && Intrinsics.areEqual(this.textColorLight, c8576a.textColorLight) && Intrinsics.areEqual(this.textColorDark, c8576a.textColorDark)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            return (((((((((this.mode.hashCode() * 31) + this.text.hashCode()) * 31) + this.bgLight.hashCode()) * 31) + this.bgDark.hashCode()) * 31) + this.textColorLight.hashCode()) * 31) + this.textColorDark.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "SummaryRes(mode=" + this.mode + ", text=" + this.text + ", bgLight=" + this.bgLight + ", bgDark=" + this.bgDark + ", textColorLight=" + this.textColorLight + ", textColorDark=" + this.textColorDark + ")";
        }
    }

    public a(@Nullable C8576a c8576a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c8576a);
        } else {
            this.summaryRes = c8576a;
        }
    }

    @Nullable
    public final C8576a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (C8576a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.summaryRes;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof a) && Intrinsics.areEqual(this.summaryRes, ((a) other).summaryRes)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        C8576a c8576a = this.summaryRes;
        if (c8576a == null) {
            return 0;
        }
        return c8576a.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "QZoneHolidayFeedRes(summaryRes=" + this.summaryRes + ")";
    }
}
