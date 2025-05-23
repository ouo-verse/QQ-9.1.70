package com.tencent.mobileqq.springhb.interactive.config;

import android.text.TextUtils;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u0000 \f2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\r\u000e\u000fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00060\u0004R\u00020\u0000*\u00020\u0003H\u0002J\f\u0010\u0006\u001a\u00060\u0002R\u00020\u0000H\u0016J\u0014\u0010\t\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser$b;", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser$DegradeRule;", h.F, "j", "", "content", "k", "<init>", "()V", "d", "a", "b", "DegradeRule", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class DegradeConfigParser extends BaseConfigParser<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f289215d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final Lazy<Integer> f289216e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final Lazy<String> f289217f;

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final Lazy<String> f289218h;

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final Lazy<String> f289219i;

    /* renamed from: m, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final Lazy<String> f289220m;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0016\u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0006\u0010\n\u001a\u00020\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010 \u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser$DegradeRule;", "", "", "key", "a", "Lkotlin/Function0;", "param", "", "b", "toString", "c", "Ljava/lang/String;", "getMobileModel", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "mobileModel", "getManufacturer", "d", "manufacturer", "getRomName", "f", "romName", "getRomVersion", "g", "romVersion", "", "Ljava/lang/Integer;", "getSdkVersion", "()Ljava/lang/Integer;", h.F, "(Ljava/lang/Integer;)V", "sdkVersion", "<init>", "(Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser;)V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class DegradeRule {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mobileModel;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String manufacturer;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String romName;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String romVersion;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer sdkVersion;

        public DegradeRule() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DegradeConfigParser.this);
            }
        }

        private final String a(Object obj, String str) {
            if (obj == null) {
                return "";
            }
            return str + ":" + obj + " ";
        }

        private final boolean b(String str, Function0<String> function0) {
            boolean z16;
            boolean z17 = true;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return true;
            }
            String invoke = function0.invoke();
            if (invoke != null && invoke.length() != 0) {
                z17 = false;
            }
            if (z17) {
                return false;
            }
            return TextUtils.equals(str, invoke);
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
            }
            if (!b(this.mobileModel, DegradeConfigParser$DegradeRule$match$1.INSTANCE) || !b(this.manufacturer, DegradeConfigParser$DegradeRule$match$2.INSTANCE) || !b(this.romName, DegradeConfigParser$DegradeRule$match$3.INSTANCE) || !b(this.romVersion, DegradeConfigParser$DegradeRule$match$4.INSTANCE)) {
                return false;
            }
            Integer num = this.sdkVersion;
            if (num != null && num.intValue() != DegradeConfigParser.f289215d.j()) {
                return false;
            }
            return true;
        }

        public final void d(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                this.manufacturer = str;
            }
        }

        public final void e(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                this.mobileModel = str;
            }
        }

        public final void f(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                this.romName = str;
            }
        }

        public final void g(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            } else {
                this.romVersion = str;
            }
        }

        public final void h(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) num);
            } else {
                this.sdkVersion = num;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "{" + a(this.mobileModel, "mobileModel") + " " + a(this.manufacturer, "manufacturer") + " " + a(this.romName, "romName") + " " + a(this.romVersion, "romVersion") + " " + a(this.sdkVersion, "sdkVersion") + "}\n";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R#\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\fR#\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\fR#\u0010\u0013\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\fR#\u0010\u0016\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser$a;", "", "", "phoneSdkInit$delegate", "Lkotlin/Lazy;", "j", "()I", "phoneSdkInit", "", "kotlin.jvm.PlatformType", "phoneModel$delegate", "g", "()Ljava/lang/String;", "phoneModel", "phoneManufacturer$delegate", "f", "phoneManufacturer", "phoneRomName$delegate", h.F, "phoneRomName", "phoneRomVersion$delegate", "i", "phoneRomVersion", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f() {
            return (String) DegradeConfigParser.f289218h.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String g() {
            return (String) DegradeConfigParser.f289217f.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String h() {
            return (String) DegradeConfigParser.f289219i.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String i() {
            return (String) DegradeConfigParser.f289220m.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int j() {
            return ((Number) DegradeConfigParser.f289216e.getValue()).intValue();
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u0006\u0010\u000bR!\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0010R\u00020\u00110\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "c", "d", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "e", "(Ljava/lang/Boolean;)V", "closeFeature", "getCloseAutoJumpWeb", "closeAutoJumpWeb", "", "Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser$DegradeRule;", "Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser;", "f", "Ljava/util/List;", "b", "()Ljava/util/List;", "rules", "<init>", "(Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser;)V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class b implements IConfigData {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean closeFeature;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean closeAutoJumpWeb;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<DegradeRule> rules;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DegradeConfigParser.this);
            } else {
                this.rules = new ArrayList();
            }
        }

        @Nullable
        public final Boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.closeFeature;
        }

        @NotNull
        public final List<DegradeRule> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (List) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.rules;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            if (Intrinsics.areEqual(this.closeFeature, Boolean.TRUE)) {
                QLog.d("DegradeSwitch", 1, "closeFeature !!");
                return true;
            }
            Iterator<T> it = this.rules.iterator();
            while (it.hasNext()) {
                if (((DegradeRule) it.next()).c()) {
                    QLog.d("DegradeSwitch", 1, "matchBlackRule");
                    return true;
                }
            }
            return false;
        }

        public final void d(@Nullable Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) bool);
            } else {
                this.closeAutoJumpWeb = bool;
            }
        }

        public final void e(@Nullable Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bool);
            } else {
                this.closeFeature = bool;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.rules.toString();
        }
    }

    static {
        Lazy<Integer> lazy;
        Lazy<String> lazy2;
        Lazy<String> lazy3;
        Lazy<String> lazy4;
        Lazy<String> lazy5;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21071);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f289215d = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(DegradeConfigParser$Companion$phoneSdkInit$2.INSTANCE);
        f289216e = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(DegradeConfigParser$Companion$phoneModel$2.INSTANCE);
        f289217f = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(DegradeConfigParser$Companion$phoneManufacturer$2.INSTANCE);
        f289218h = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(DegradeConfigParser$Companion$phoneRomName$2.INSTANCE);
        f289219i = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(DegradeConfigParser$Companion$phoneRomVersion$2.INSTANCE);
        f289220m = lazy5;
    }

    public DegradeConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final DegradeRule h(JSONObject jSONObject) {
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.e(i(jSONObject, "phoneModel"));
        degradeRule.d(i(jSONObject, "manufacturer"));
        degradeRule.f(i(jSONObject, "romName"));
        degradeRule.g(i(jSONObject, "romVersion"));
        int optInt = jSONObject.optInt("sdkVersion", -1);
        if (optInt != -1) {
            degradeRule.h(Integer.valueOf(optInt));
        }
        return degradeRule;
    }

    private static final String i(JSONObject jSONObject, String str) {
        boolean z16;
        String it = jSONObject.optString(str);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return it;
        }
        return null;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        JSONObject jSONObject;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        b bVar = new b();
        try {
            String str = new String(content, Charsets.UTF_8);
            QLog.d("DegradeSwitch", 1, "configString " + str);
            jSONObject = new JSONObject(str);
            bVar.e(Boolean.valueOf(jSONObject.optBoolean("closeFeature", false)));
        } catch (Exception e16) {
            QLog.e("DegradeSwitch", 2, e16.getMessage());
        }
        if (Intrinsics.areEqual(bVar.a(), Boolean.TRUE)) {
            return bVar;
        }
        bVar.d(Boolean.valueOf(jSONObject.optBoolean("closeAutoJumpWeb", false)));
        JSONArray optJSONArray = jSONObject.optJSONArray("blacklist");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (i3 = 0; i3 < length; i3++) {
                List<DegradeRule> b16 = bVar.b();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "it.optJSONObject(i)");
                b16.add(h(optJSONObject));
            }
        }
        return bVar;
    }
}
