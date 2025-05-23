package com.tencent.mobileqq.temp.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013Jl\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072.\u0010\f\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\nj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002J`\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0018\u0010\f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/temp/report/StatisticCollector;", "", "", "uin", "tagName", "", "success", "", "duration", "size", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "reserved", "", "c", com.heytap.mcssdk.a.a.f36102l, "b", "<init>", "()V", "a", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class StatisticCollector {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final String f292628b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<StatisticCollector> f292629c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\n\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0087D\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/temp/report/StatisticCollector$a;", "", "Lcom/tencent/qphone/base/util/BaseApplication;", "context", "Lcom/tencent/mobileqq/temp/report/StatisticCollector;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/temp/report/StatisticCollector;", "sInstance", "", "SCENES_REC_EMO_MONITOR", "Ljava/lang/String;", "<init>", "()V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.temp.report.StatisticCollector$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

        private final StatisticCollector b() {
            return (StatisticCollector) StatisticCollector.f292629c.getValue();
        }

        @JvmStatic
        @NotNull
        public final StatisticCollector a(@NotNull BaseApplication context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (StatisticCollector) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            return b();
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
        Lazy<StatisticCollector> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38211);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        f292628b = com.tencent.mobileqq.statistics.StatisticCollector.SCENES_REC_EMO_MONITOR;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) StatisticCollector$Companion$sInstance$2.INSTANCE);
        f292629c = lazy;
    }

    public StatisticCollector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final StatisticCollector d(@NotNull BaseApplication baseApplication) {
        return INSTANCE.a(baseApplication);
    }

    public final void b(@Nullable String appKey, @Nullable String uin, @Nullable String tagName, boolean success, long duration, long size, @Nullable HashMap<String, String> params, @Nullable String reserved) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appKey, uin, tagName, Boolean.valueOf(success), Long.valueOf(duration), Long.valueOf(size), params, reserved);
        }
    }

    public final void c(@Nullable String uin, @Nullable String tagName, boolean success, long duration, long size, @Nullable HashMap<String, String> params, @Nullable String reserved) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uin, tagName, Boolean.valueOf(success), Long.valueOf(duration), Long.valueOf(size), params, reserved);
        }
    }
}
