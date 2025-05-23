package com.tencent.qqnt.aio.predownload.pic.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.aio.adapter.api.IDataLineConfigApi;
import com.tencent.qqnt.kernel.nativeinterface.UIConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/pic/config/c;", "Lcx3/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/UIConfig;", "configParam", "", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c implements cx3.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f351800a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65582);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[UIConfig.values().length];
            try {
                iArr[UIConfig.KAUTODOWNLOADPICCFG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UIConfig.KAIOPICCFG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UIConfig.KGIFCFG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UIConfig.KXGAUTODOWNLOADPIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UIConfig.KAVIFDOWNLOADCFG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[UIConfig.KDATALINEAUTODOWNLOADCFG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[UIConfig.KTOFUCFG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f351800a = iArr;
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // cx3.a
    @Nullable
    public String a(@NotNull UIConfig configParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) configParam);
        }
        Intrinsics.checkNotNullParameter(configParam, "configParam");
        switch (a.f351800a[configParam.ordinal()]) {
            case 1:
                return b.f351799a.e();
            case 2:
                return b.f351799a.d();
            case 3:
                return b.f351799a.c();
            case 4:
                return b.f351799a.f();
            case 5:
                return b.f351799a.b();
            case 6:
                return ((IDataLineConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IDataLineConfigApi.class)).getAutoDownload();
            case 7:
                return ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).getTofuConfig();
            default:
                return null;
        }
    }
}
