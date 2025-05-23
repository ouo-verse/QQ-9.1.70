package com.tencent.mobileqq.intervideo.audioroom.pluginimpl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/intervideo/audioroom/pluginimpl/AudioRoomOpenWebViewHandler;", "", "Landroid/os/Bundle;", "bundle", "", "openWebView", "", "url", "b", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class AudioRoomOpenWebViewHandler {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final AudioRoomOpenWebViewHandler INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58552);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new AudioRoomOpenWebViewHandler();
        }
    }

    AudioRoomOpenWebViewHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(String url, Bundle bundle) {
        List split$default;
        boolean z16;
        String string = bundle.getString("cookie");
        boolean z17 = false;
        if (string != null) {
            if (string.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17) {
            CookieSyncManager.createInstance(BaseApplicationImpl.getApplication().getBaseContext());
            String host = Uri.parse(url).getHost();
            if (host != null) {
                url = host;
            }
            Intrinsics.checkNotNullExpressionValue(url, "Uri.parse(url).host ?: url");
            split$default = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{";"}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                CookieManager.getInstance().setCookie(url, (String) it.next());
            }
            CookieSyncManager.getInstance().sync();
        }
    }

    private final void b(String url) {
        Intent intent = new Intent(BaseApplicationImpl.getApplication().getBaseContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", url);
        intent.addFlags(268435456);
        BaseApplicationImpl.getApplication().getBaseContext().startActivity(intent);
    }

    @JvmStatic
    public static final void openWebView(@NotNull Bundle bundle) {
        boolean z16;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString("url");
        boolean z17 = false;
        if (string != null) {
            if (string.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17) {
            AudioRoomOpenWebViewHandler audioRoomOpenWebViewHandler = INSTANCE;
            audioRoomOpenWebViewHandler.a(string, bundle);
            audioRoomOpenWebViewHandler.b(string);
        }
    }
}
