package com.tencent.qqnt.aio.predownload.video.strategy;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/video/strategy/d;", "", "", "c", "Lcom/tencent/qqnt/aio/predownload/video/strategy/e;", "b", "Lcom/tencent/qqnt/aio/predownload/video/strategy/e;", "()Lcom/tencent/qqnt/aio/predownload/video/strategy/e;", "shortVideoPreDownloadConfigItem", "a", "longVideoPreDownloadConfigItem", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f351863a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final e shortVideoPreDownloadConfigItem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final e longVideoPreDownloadConfigItem;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65610);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f351863a = new d();
        shortVideoPreDownloadConfigItem = new e(new f(true, true, 1440L), new f(false, true, 1440L));
        longVideoPreDownloadConfigItem = new e(new f(true, true, Long.MAX_VALUE), new f(true, true, Long.MAX_VALUE));
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final e a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return longVideoPreDownloadConfigItem;
    }

    @NotNull
    public final e b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return shortVideoPreDownloadConfigItem;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        String loadConfigAsString = FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("100278", "");
        if (TextUtils.isEmpty(loadConfigAsString)) {
            QLog.e("ShortVideoPreDownloadConfig", 1, "[updateConfig] failed, empty configJson!");
            return;
        }
        QLog.d("ShortVideoPreDownloadConfig", 1, "[updateConfig] content = " + loadConfigAsString);
        try {
            JSONObject jSONObject = new JSONObject(loadConfigAsString);
            JSONObject optJSONObject = jSONObject.optJSONObject(AppConstants.TAG_RAW_SHORT_VIDEO);
            if (optJSONObject != null) {
                shortVideoPreDownloadConfigItem.c(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("long_video");
            if (optJSONObject2 != null) {
                longVideoPreDownloadConfigItem.c(optJSONObject2);
            }
        } catch (Throwable unused) {
            QLog.e("ShortVideoPreDownloadConfig", 1, "[updateConfig] failed, empty configJson!");
        }
    }
}
