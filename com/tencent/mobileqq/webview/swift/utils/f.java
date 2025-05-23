package com.tencent.mobileqq.webview.swift.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001c\u0010\t\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/utils/f;", "", "", "b", "", "url", "c", "pattern", "domain", "a", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f314749a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46146);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f314749a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a(@Nullable String pattern, @Nullable String domain) {
        boolean startsWith$default;
        boolean endsWith$default;
        boolean startsWith$default2;
        boolean endsWith$default2;
        int indexOf$default;
        if (TextUtils.isEmpty(pattern) || TextUtils.isEmpty(domain) || pattern == null || domain == null) {
            return false;
        }
        if (Intrinsics.areEqual(pattern, "*")) {
            return true;
        }
        if (Intrinsics.areEqual(pattern, "*.*")) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) domain, ".", 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                return false;
            }
            return true;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(pattern, "*", false, 2, null);
        if (!startsWith$default) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(pattern, "*", false, 2, null);
            if (endsWith$default) {
                String substring = pattern.substring(0, pattern.length() - 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(domain, substring, false, 2, null);
                return startsWith$default2;
            }
            return TextUtils.equals(pattern, domain);
        }
        String substring2 = pattern.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(domain, substring2, false, 2, null);
        return endsWith$default2;
    }

    @JvmStatic
    public static final boolean b() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106113", false);
        if (QLog.isColorLevel()) {
            QLog.i("WebLog_SwiftBrowserUIStyleConfigHelper", 2, "[isHostWhiteSwitchOn], switch:" + isSwitchOn);
        }
        return isSwitchOn;
    }

    @JvmStatic
    public static final boolean c(@NotNull String url) {
        ArrayList<String> arrayList;
        Intrinsics.checkNotNullParameter(url, "url");
        String host = Uri.parse(url).getHost();
        r rVar = (r) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("106113");
        if (QLog.isDevelopLevel()) {
            QLog.i("WebLog_SwiftBrowserUIStyleConfigHelper", 4, "[isWhiteHost], loadConfig url:" + url);
            if (rVar != null) {
                arrayList = rVar.a();
            } else {
                arrayList = null;
            }
            QLog.i("WebLog_SwiftBrowserUIStyleConfigHelper", 4, "[isWhiteHost], loadConfig, hostWhiteList:" + arrayList);
        }
        if (rVar != null) {
            int size = rVar.a().size();
            for (int i3 = 0; i3 < size; i3++) {
                if (a(rVar.a().get(i3), host)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("WebLog_SwiftBrowserUIStyleConfigHelper", 2, "[isWhiteHost], hostWhite:" + ((Object) rVar.a().get(i3)) + ", url:" + url + ", result:true");
                        return true;
                    }
                    return true;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("WebLog_SwiftBrowserUIStyleConfigHelper", 2, "[isWhiteHost], url:" + url + ", result:false");
        }
        return false;
    }
}
