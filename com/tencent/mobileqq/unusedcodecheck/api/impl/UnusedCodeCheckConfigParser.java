package com.tencent.mobileqq.unusedcodecheck.api.impl;

import android.os.Build;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/api/impl/UnusedCodeCheckConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/unusedcodecheck/api/impl/b;", "", "content", "d", "b", "", "isAccountRelated", "", "invalidModels", "c", "<init>", "()V", "a", "unusedcode_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class UnusedCodeCheckConfigParser extends BaseConfigParser<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/api/impl/UnusedCodeCheckConfigParser$a;", "", "", "BLACK_MARKET_ROM", "Ljava/lang/String;", "CONFIG_GROUP", "EMOTION_UI_ROM_KEY", "<init>", "()V", "unusedcode_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.unusedcodecheck.api.impl.UnusedCodeCheckConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18972);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public UnusedCodeCheckConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new b();
    }

    public final boolean c(@Nullable String invalidModels) {
        boolean contains;
        boolean contains2;
        List split$default;
        boolean contains3;
        boolean contains4;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) invalidModels)).booleanValue();
        }
        boolean z17 = false;
        if (invalidModels == null) {
            return false;
        }
        String str = Build.BRAND;
        int i3 = Build.VERSION.SDK_INT;
        String str2 = str + "_" + i3;
        String str3 = ROMUtil.getRomVersion() + "_" + i3;
        QLog.d("UnusedCodeCheck", 1, "checkInvalidModel brandKey:" + str2 + " romKey:" + str3);
        contains = StringsKt__StringsKt.contains((CharSequence) str3, (CharSequence) "EmotionUI", true);
        if (!contains) {
            contains2 = StringsKt__StringsKt.contains((CharSequence) str3, (CharSequence) "V417IR", true);
            if (!contains2) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) invalidModels, new String[]{";"}, false, 0, 6, (Object) null);
                ArrayList<String> arrayList = new ArrayList();
                for (Object obj : split$default) {
                    String str4 = (String) obj;
                    if (str4 != null && str4.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        arrayList.add(obj);
                    }
                }
                for (String str5 : arrayList) {
                    QLog.d("UnusedCodeCheck", 1, "checkInvalidModel invalidModel:" + str5);
                    contains3 = StringsKt__StringsKt.contains((CharSequence) str3, (CharSequence) str5, true);
                    if (!contains3) {
                        contains4 = StringsKt__StringsKt.contains((CharSequence) str2, (CharSequence) str5, true);
                        if (contains4) {
                        }
                    }
                    z17 = true;
                }
                return z17;
            }
        }
        return true;
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            b defaultConfig = defaultConfig();
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            JSONObject jSONObject = new JSONObject(new String(content, UTF_8));
            defaultConfig.F(jSONObject.optBoolean(com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, defaultConfig.p()));
            defaultConfig.B(c(jSONObject.optString("invalidModels")));
            defaultConfig.y(jSONObject.optInt("fileBufferSize", defaultConfig.i()));
            defaultConfig.E(jSONObject.optInt("lookupCountLimit", defaultConfig.n()));
            defaultConfig.C(jSONObject.optDouble("loadRateLimit", defaultConfig.l()));
            defaultConfig.q(jSONObject.optInt("allowLookupFailCount", defaultConfig.a()));
            defaultConfig.v(jSONObject.optLong("delayTimeMainProcess", defaultConfig.f()));
            defaultConfig.x(jSONObject.optLong("delayTimeOtherProcess", defaultConfig.h()));
            defaultConfig.w(jSONObject.optLong("delayTimeMsfProcess", defaultConfig.g()));
            defaultConfig.r(jSONObject.optLong("checkTimeIntervalMainProcess", defaultConfig.b()));
            defaultConfig.t(jSONObject.optLong("checkTimeIntervalOtherProcess", defaultConfig.d()));
            defaultConfig.s(jSONObject.optLong("checkTimeIntervalMsfProcess", defaultConfig.c()));
            defaultConfig.u(jSONObject.optDouble("cpuUsageLimit", defaultConfig.e()));
            defaultConfig.D(jSONObject.optDouble("loadRateLimitLastVersion", defaultConfig.m()));
            defaultConfig.A(jSONObject.optDouble("grayVersionLoadRateLimit", defaultConfig.k()));
            defaultConfig.z(jSONObject.optBoolean("grayVersionIsOpen", defaultConfig.j()));
            return defaultConfig;
        } catch (JSONException e16) {
            QLog.e("UnusedCodeCheck", 1, "parse config error", e16);
            return defaultConfig();
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public boolean isAccountRelated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
