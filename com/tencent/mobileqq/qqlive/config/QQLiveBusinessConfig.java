package com.tencent.mobileqq.qqlive.config;

import com.qq.wx.voice.util.ErrorCode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/config/QQLiveBusinessConfig;", "Lcom/tencent/mobileqq/qqlive/config/a;", "Lcom/tencent/mobileqq/qqlive/config/b;", "d", "a", "c", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/qqlive/config/b;", "liveConfig", "", "Ljava/lang/String;", "QQLIVE_APP_ID", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveBusinessConfig extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final QQLiveBusinessConfig f271165b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy liveConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final String QQLIVE_APP_ID;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ErrorCode.SRERR_CHARSET_CONVERT_FAILED);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        QQLiveBusinessConfig qQLiveBusinessConfig = new QQLiveBusinessConfig();
        f271165b = qQLiveBusinessConfig;
        lazy = LazyKt__LazyJVMKt.lazy(QQLiveBusinessConfig$liveConfig$2.INSTANCE);
        liveConfig = lazy;
        QQLIVE_APP_ID = qQLiveBusinessConfig.c().c();
    }

    QQLiveBusinessConfig() {
        super(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final b c() {
        return (b) liveConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b d() {
        return c.f271178a.c();
    }

    @Override // com.tencent.mobileqq.qqlive.config.a
    @NotNull
    public b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return c();
    }
}
