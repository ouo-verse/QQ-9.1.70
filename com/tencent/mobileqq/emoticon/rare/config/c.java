package com.tencent.mobileqq.emoticon.rare.config;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import cooperation.qzone.panorama.util.PanoramaConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/emoticon/rare/config/c;", "", "", "d", "f", "Lcom/tencent/mobileqq/emoticon/rare/config/a;", "b", "Lcom/tencent/mobileqq/emoticon/rare/config/a;", "mConfigBean", "", "c", "Ljava/lang/String;", "mCurrentAccount", "", "Z", "mIsConfigLoaded", "e", "mIsSwitchOn", "()Ljava/lang/String;", PanoramaConfig.KEY_CURRENT_UIN, "()Lcom/tencent/mobileqq/emoticon/rare/config/a;", DownloadInfo.spKey_Config, "g", "()Z", "isSwitchOn", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f204869a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a mConfigBean;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mCurrentAccount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsConfigLoaded;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsSwitchOn;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33078);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f204869a = new c();
        mConfigBean = new a();
        mCurrentAccount = "";
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c() {
        String str;
        AppRuntime peekAppRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        mConfigBean.g(FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("103155", "{}"));
        mIsConfigLoaded = true;
        QLog.d("RareEmotionConfRepo", 1, "initConfig async finished");
    }

    @NotNull
    public final a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return mConfigBean;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (Intrinsics.areEqual(mCurrentAccount, c())) {
            return;
        }
        mIsSwitchOn = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("103155", true);
        mIsConfigLoaded = false;
        String c16 = c();
        mCurrentAccount = c16;
        QLog.d("RareEmotionConfRepo", 1, "initConfig async account: " + c16 + " switch: " + mIsSwitchOn);
        mConfigBean.h();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticon.rare.config.b
            @Override // java.lang.Runnable
            public final void run() {
                c.e();
            }
        }, 16, null, true);
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (mIsConfigLoaded && Intrinsics.areEqual(mCurrentAccount, c())) {
            return;
        }
        if (!Intrinsics.areEqual(mCurrentAccount, c())) {
            mConfigBean.h();
            mCurrentAccount = c();
        }
        FreesiaWrapperImpl.Companion companion = FreesiaWrapperImpl.INSTANCE;
        boolean isSwitchOn = companion.b().isSwitchOn("103155", true);
        mIsSwitchOn = isSwitchOn;
        QLog.d("RareEmotionConfRepo", 1, "initConfig sync if need account: " + mCurrentAccount + " switch: " + isSwitchOn);
        mConfigBean.g(companion.b().loadConfigAsString("103155", "{}"));
        mIsConfigLoaded = true;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return mIsSwitchOn;
    }
}
