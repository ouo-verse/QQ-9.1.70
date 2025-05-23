package com.tencent.mobileqq.aio.msglist.holder.component.template.common;

import android.text.TextUtils;
import com.tencent.ark.Logger;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/l;", "", "", "url", "Ljava/net/URL;", "c", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/TemplateMsgWhiteUrlItem;", "whiteList", "", "b", "ruleUrl", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f191934a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63424);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f191934a = new l();
        }
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final URL c(String url) {
        int indexOf$default;
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        try {
            return new URL(url);
        } catch (MalformedURLException e16) {
            Logger.logE("TemMsg.UrlChecker", "ArkSafe.isUrlValidInList Exception:" + e16);
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url, '?', 0, false, 6, (Object) null);
            if (indexOf$default < 0) {
                return null;
            }
            String substring = url.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            try {
                return new URL(substring);
            } catch (MalformedURLException e17) {
                Logger.logE("TemMsg.UrlChecker", "ArkSafe.isUrlValidInList Exception:" + e17);
                return null;
            }
        }
    }

    @Nullable
    public final TemplateMsgWhiteUrlItem a(@NotNull String ruleUrl) {
        int indexOf$default;
        String substring;
        String substring2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TemplateMsgWhiteUrlItem) iPatchRedirector.redirect((short) 3, (Object) this, (Object) ruleUrl);
        }
        Intrinsics.checkNotNullParameter(ruleUrl, "ruleUrl");
        if (!TextUtils.isEmpty(ruleUrl)) {
            String removeSpecialChars = ArkAppConfigMgr.removeSpecialChars(ruleUrl);
            Intrinsics.checkNotNullExpressionValue(removeSpecialChars, "removeSpecialChars(ruleUrl)");
            TemplateMsgWhiteUrlItem templateMsgWhiteUrlItem = new TemplateMsgWhiteUrlItem();
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) removeSpecialChars, "/", 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                substring = removeSpecialChars;
            } else {
                substring = removeSpecialChars.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            templateMsgWhiteUrlItem.c(substring);
            if (indexOf$default == -1) {
                substring2 = "";
            } else {
                substring2 = removeSpecialChars.substring(indexOf$default, removeSpecialChars.length());
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            templateMsgWhiteUrlItem.e(substring2);
            return templateMsgWhiteUrlItem;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(@NotNull String url, @Nullable ArrayList<TemplateMsgWhiteUrlItem> whiteList) {
        StringBuilder sb5;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean startsWith$default;
        String str;
        boolean equals;
        int i3;
        boolean endsWith$default;
        boolean areEqual;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url, (Object) whiteList)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (!TextUtils.isEmpty(url) && whiteList != null) {
            URL c16 = c(url);
            if (c16 == null) {
                QLog.i("TemMsg.UrlChecker", 1, "ArkSafe.isUrlValidInList invalid url, url = " + ArkUtil.filterKeyForLog(url, new String[0]));
                return false;
            }
            String authority = c16.getAuthority();
            String path = c16.getPath();
            StringBuilder sb6 = new StringBuilder();
            try {
                Iterator<TemplateMsgWhiteUrlItem> it = whiteList.iterator();
                z16 = true;
                z17 = false;
                z18 = false;
                while (true) {
                    try {
                        if (it.hasNext()) {
                            TemplateMsgWhiteUrlItem next = it.next();
                            if (next != null) {
                                sb6.append("ArkSafe.isUrlValidInList.handle ruleDomain=");
                                sb6.append(next.a());
                                sb6.append(", rulePath=");
                                sb6.append(next.b());
                                sb6.append("\n");
                                if (!TextUtils.isEmpty(next.a())) {
                                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(next.a(), "*", false, 2, null);
                                    if (!startsWith$default || authority == null) {
                                        str = "*";
                                        equals = StringsKt__StringsJVMKt.equals(next.a(), authority, true);
                                    } else {
                                        int length = next.a().length() - 1;
                                        int length2 = authority.length() - length;
                                        if (length2 < 0) {
                                            i3 = 0;
                                        } else {
                                            i3 = length2;
                                        }
                                        str = "*";
                                        equals = StringsKt__StringsJVMKt.regionMatches(authority, i3, next.a(), 1, length, true);
                                    }
                                } else {
                                    equals = true;
                                    str = "*";
                                }
                                try {
                                    if (!TextUtils.isEmpty(next.b())) {
                                        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(next.b(), str, false, 2, null);
                                        if (endsWith$default && path != null) {
                                            sb5 = sb6;
                                            try {
                                                areEqual = StringsKt__StringsJVMKt.regionMatches$default(path, 0, next.b(), 0, next.b().length() - 1, false, 16, (Object) null);
                                            } catch (Exception e16) {
                                                e = e16;
                                                z17 = equals;
                                                Logger.logE("TemMsg.UrlChecker", "ArkSafe.isUrlValidInList.exception2=" + e);
                                                if (!z16) {
                                                }
                                                return z16;
                                            }
                                        } else {
                                            sb5 = sb6;
                                            areEqual = Intrinsics.areEqual(next.b(), path);
                                        }
                                        z18 = areEqual;
                                    } else {
                                        z18 = true;
                                        sb5 = sb6;
                                    }
                                    if (equals && z18) {
                                        z16 = true;
                                        z17 = equals;
                                        break;
                                    }
                                    z16 = false;
                                    z17 = equals;
                                    sb6 = sb5;
                                } catch (Exception e17) {
                                    e = e17;
                                    sb5 = sb6;
                                }
                            }
                        } else {
                            sb5 = sb6;
                            break;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        sb5 = sb6;
                    }
                }
            } catch (Exception e19) {
                e = e19;
                sb5 = sb6;
                z16 = true;
                z17 = false;
                z18 = false;
            }
            if (!z16) {
                if (com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a.c()) {
                    QLog.d("TemMsg.UrlChecker", 1, "ArkSafe.isUrlValidInList url=", ArkUtil.filterKeyForLog(url, new String[0]), ", return isValid=", Boolean.valueOf(z16), ", isDomainValid=", Boolean.valueOf(z17), ", isPathValid=", Boolean.valueOf(z18), ", detailLog=", sb5.toString());
                } else {
                    QLog.d("TemMsg.UrlChecker", 1, "not allowed: " + ArkUtil.filterKeyForLog(url, new String[0]));
                }
            }
            return z16;
        }
        if (com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a.c()) {
            QLog.d("TemMsg.UrlChecker", 1, "TextUtils.isEmpty(url) || whiteList == null:" + url);
        }
        return true;
    }
}
