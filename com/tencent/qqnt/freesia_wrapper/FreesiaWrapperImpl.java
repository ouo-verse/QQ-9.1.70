package com.tencent.qqnt.freesia_wrapper;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.freesia.UnitedConfig;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import com.tencent.qqnt.kernel.nativeinterface.IFreesia;
import com.tencent.qqnt.kernel.nativeinterface.IFreesiaBoolResCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFreesiaStringResCallback;
import com.tencent.qqnt.kernel.nativeinterface.StringResCenter;
import com.tencent.qqnt.kernel.nativeinterface.p;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tH\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0012H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/freesia_wrapper/FreesiaWrapperImpl;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFreesia;", "", "e", "", "f", VipFunCallConstants.KEY_GROUP, AdMetricTag.FALLBACK, "loadConfigAsString", "", "isSwitchOn", "Lcom/tencent/qqnt/kernel/nativeinterface/IFreesiaStringResCallback;", "cb", "loadConfigAsStringAsync", "g", "", "seq", "loadLargeConfigAsStringAsync", "Lcom/tencent/qqnt/kernel/nativeinterface/IFreesiaBoolResCallback;", "isSwitchOnAsync", "<init>", "()V", "a", "freesia_wrapper_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class FreesiaWrapperImpl implements IFreesia {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<FreesiaWrapperImpl> f356777b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<StringResCenter> f356778c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/freesia_wrapper/FreesiaWrapperImpl$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/StringResCenter;", "stringResCenter$delegate", "Lkotlin/Lazy;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/StringResCenter;", "stringResCenter", "Lcom/tencent/qqnt/freesia_wrapper/FreesiaWrapperImpl;", "INSTANCE$delegate", "b", "()Lcom/tencent/qqnt/freesia_wrapper/FreesiaWrapperImpl;", "INSTANCE", "", "DEFAULT_UIN", "Ljava/lang/String;", "TAG", "<init>", "()V", "freesia_wrapper_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final StringResCenter c() {
            Object value = FreesiaWrapperImpl.f356778c.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-stringResCenter>(...)");
            return (StringResCenter) value;
        }

        @NotNull
        public final FreesiaWrapperImpl b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FreesiaWrapperImpl) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (FreesiaWrapperImpl) FreesiaWrapperImpl.f356777b.getValue();
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
        Lazy<FreesiaWrapperImpl> lazy;
        Lazy<StringResCenter> lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41398);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(FreesiaWrapperImpl$Companion$INSTANCE$2.INSTANCE);
        f356777b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(FreesiaWrapperImpl$Companion$stringResCenter$2.INSTANCE);
        f356778c = lazy2;
    }

    public /* synthetic */ FreesiaWrapperImpl(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) defaultConstructorMarker);
    }

    private final String e() {
        String str;
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            str = firstSimpleAccount.getUin();
        } else {
            str = null;
        }
        if (str == null) {
            QLog.w("FreesiaWrapper", 1, "can not get uin, use default");
            return TVKUpdateInfo.APP_ID;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(IFreesiaStringResCallback cb5, UnitedConfig unitedConfig, String uin, String group, String fallback) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(group, "$group");
        Intrinsics.checkNotNullParameter(fallback, "$fallback");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = fallback.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] loadLargeRawConfig = unitedConfig.loadLargeRawConfig(uin, group, bytes);
        Charset UTF_82 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
        cb5.onResult(new String(loadLargeRawConfig, UTF_82));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i3, UnitedConfig unitedConfig, String uin, String group, String fallback) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(group, "$group");
        Intrinsics.checkNotNullParameter(fallback, "$fallback");
        StringResCenter c16 = INSTANCE.c();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = fallback.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] loadLargeRawConfig = unitedConfig.loadLargeRawConfig(uin, group, bytes);
        Charset UTF_82 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
        c16.onResult(i3, new String(loadLargeRawConfig, UTF_82));
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            p.a(this);
        }
    }

    public final void g(@NotNull final String group, @NotNull final String fallback, @NotNull final IFreesiaStringResCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, group, fallback, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        final UnitedConfig orNull = UnitedConfig.INSTANCE.getOrNull();
        if (orNull != null) {
            final String e16 = e();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.freesia_wrapper.b
                @Override // java.lang.Runnable
                public final void run() {
                    FreesiaWrapperImpl.h(IFreesiaStringResCallback.this, orNull, e16, group, fallback);
                }
            }, 64, null, true);
        } else {
            QLog.e("FreesiaWrapper", 1, "freesia not init, group: ", group);
            cb5.onResult(fallback);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IFreesia
    public boolean isSwitchOn(@NotNull String group, boolean fallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, group, Boolean.valueOf(fallback))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(group, "group");
        UnitedConfig orNull = UnitedConfig.INSTANCE.getOrNull();
        if (orNull != null) {
            return orNull.isSwitchOn(e(), group, fallback);
        }
        return fallback;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IFreesia
    public void isSwitchOnAsync(@NotNull String group, boolean fallback, @NotNull IFreesiaBoolResCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, group, Boolean.valueOf(fallback), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        UnitedConfig orNull = UnitedConfig.INSTANCE.getOrNull();
        if (orNull != null) {
            cb5.onResult(orNull.isSwitchOn(e(), group, fallback));
        } else {
            QLog.e("FreesiaWrapper", 1, "freesia not init, group: ", group);
            cb5.onResult(fallback);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IFreesia
    @NotNull
    public String loadConfigAsString(@NotNull String group, @NotNull String fallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) group, (Object) fallback);
        }
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        UnitedConfig orNull = UnitedConfig.INSTANCE.getOrNull();
        if (orNull != null) {
            String e16 = e();
            Charset charset = Charsets.UTF_8;
            byte[] bytes = fallback.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return new String(orNull.loadRawConfig(e16, group, bytes), charset);
        }
        return fallback;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IFreesia
    public void loadConfigAsStringAsync(@NotNull String group, @NotNull String fallback, @NotNull IFreesiaStringResCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, group, fallback, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        UnitedConfig orNull = UnitedConfig.INSTANCE.getOrNull();
        if (orNull != null) {
            String e16 = e();
            Charset charset = Charsets.UTF_8;
            byte[] bytes = fallback.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            cb5.onResult(new String(orNull.loadRawConfig(e16, group, bytes), charset));
            return;
        }
        QLog.e("FreesiaWrapper", 1, "freesia not init, group: ", group);
        cb5.onResult(fallback);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IFreesia
    public void loadLargeConfigAsStringAsync(final int seq, @NotNull final String group, @NotNull final String fallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(seq), group, fallback);
            return;
        }
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        final UnitedConfig orNull = UnitedConfig.INSTANCE.getOrNull();
        if (orNull != null) {
            final String e16 = e();
            if (!orNull.isCdn(e16, group)) {
                StringResCenter c16 = INSTANCE.c();
                Charset charset = Charsets.UTF_8;
                byte[] bytes = fallback.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                c16.onResult(seq, new String(orNull.loadRawConfig(e16, group, bytes), charset));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FreesiaWrapper", 2, "load cdn");
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.freesia_wrapper.a
                @Override // java.lang.Runnable
                public final void run() {
                    FreesiaWrapperImpl.i(seq, orNull, e16, group, fallback);
                }
            }, 64, null, true);
            return;
        }
        QLog.e("FreesiaWrapper", 1, "freesia not init, group: ", group);
        INSTANCE.c().onResult(seq, fallback);
    }

    FreesiaWrapperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
