package com.tencent.qui.quiblurview;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qui.quiblurview.QQBlurDeviceConfigHolder;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00072\u00020\u0001:\u0002\u0005\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qui/quiblurview/QQBlurDeviceConfigHolder;", "", "", "d", "Lcom/tencent/qui/quiblurview/b;", "a", "Lkotlin/Lazy;", "c", "()Lcom/tencent/qui/quiblurview/b;", DownloadInfo.spKey_Config, "<init>", "()V", "b", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class QQBlurDeviceConfigHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f363584b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy config;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qui/quiblurview/QQBlurDeviceConfigHolder$a;", "", "Lcom/tencent/qui/quiblurview/QQBlurDeviceConfigHolder;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qui/quiblurview/QQBlurDeviceConfigHolder;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.qui.quiblurview.QQBlurDeviceConfigHolder$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final QQBlurDeviceConfigHolder a() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                value = iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                value = QQBlurDeviceConfigHolder.f363584b.getValue();
            }
            return (QQBlurDeviceConfigHolder) value;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qui/quiblurview/QQBlurDeviceConfigHolder$b;", "", "", ark.ARKMETADATA_JSON, "Lcom/tencent/qui/quiblurview/b;", "a", "<init>", "()V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f363587a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8371);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f363587a = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @NotNull
        public final com.tencent.qui.quiblurview.b a(@Nullable String json) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.qui.quiblurview.b) iPatchRedirector.redirect((short) 1, (Object) this, (Object) json);
            }
            if (TextUtils.isEmpty(json)) {
                return com.tencent.qui.quiblurview.b.INSTANCE.a();
            }
            try {
                Intrinsics.checkNotNull(json);
                JSONObject jSONObject = new JSONObject(json);
                return new com.tencent.qui.quiblurview.b(jSONObject.getInt("apiLevel"), jSONObject.getInt("memorySizeInGigaByte"));
            } catch (JSONException e16) {
                ud0.d.k("QQBlurDeviceConfigHolder", ud0.d.f438811e, "[parse] exc=" + e16 + " content=" + json);
                return com.tencent.qui.quiblurview.b.INSTANCE.a();
            }
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8416);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) QQBlurDeviceConfigHolder$Companion$instance$2.INSTANCE);
        f363584b = lazy;
    }

    public QQBlurDeviceConfigHolder() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qui.quiblurview.b>() { // from class: com.tencent.qui.quiblurview.QQBlurDeviceConfigHolder$config$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) QQBlurDeviceConfigHolder.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final b invoke() {
                    String d16;
                    b a16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        return (b) iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                    d16 = QQBlurDeviceConfigHolder.this.d();
                    return (d16 == null || (a16 = QQBlurDeviceConfigHolder.b.f363587a.a(d16)) == null) ? b.INSTANCE.a() : a16;
                }
            });
            this.config = lazy;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d() {
        return ud0.g.c("qq_blur_device_requirement_config_900", null);
    }

    @NotNull
    public final com.tencent.qui.quiblurview.b c() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            value = iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            value = this.config.getValue();
        }
        return (com.tencent.qui.quiblurview.b) value;
    }
}
