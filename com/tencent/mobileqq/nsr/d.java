package com.tencent.mobileqq.nsr;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gdtad.basics.config.NsrConfigParser;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Set;
import km0.f;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J&\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u0011\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/nsr/d;", "Lcom/tencent/mobileqq/webview/swift/d;", "Landroid/app/Activity;", "hostActivity", "", "url", "", "a", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "c", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "b", "Landroid/content/Intent;", "intent", "navigateToAnotherActivity", "needSwitchFragment", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class d implements com.tencent.mobileqq.webview.swift.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/nsr/d$a;", "", "", "KUIKLY_IMG_HEIGT", "Ljava/lang/String;", "KUIKLY_IMG_SRC", "KUIKLY_IMG_WIDTH", "KUIKLY_PARAMS_KEY", "PARAM_OPEN_NSR", "PARAM_REDIRECT_NSR", "SPORT_DOMAIN", "SPORT_WEAK_PATH", "SPORT_WEEK_URL", "TAG", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nsr.d$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28428);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f A[Catch: all -> 0x00b7, TryCatch #0 {all -> 0x00b7, blocks: (B:3:0x0008, B:7:0x0012, B:10:0x001c, B:12:0x0024, B:16:0x002f, B:18:0x0036, B:20:0x0052, B:26:0x005f, B:28:0x006a, B:29:0x006e, B:31:0x0074, B:35:0x0089, B:38:0x0093, B:40:0x009f), top: B:2:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean a(Activity hostActivity, String url) {
        boolean contains;
        boolean contains2;
        boolean z16;
        boolean z17;
        try {
            contains = StringsKt__StringsKt.contains((CharSequence) url, (CharSequence) "open_nsr", false);
            if (contains) {
                contains2 = StringsKt__StringsKt.contains((CharSequence) url, (CharSequence) "nsr_redirect", false);
                if (contains2) {
                    return false;
                }
                f a16 = NsrConfigParser.INSTANCE.a();
                if (a16 != null && true == a16.getCanOpenNsr()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    QLog.e("QQNsrWebNavigationItem", 1, "config close return");
                    return false;
                }
                QLog.e("QQNsrWebNavigationItem", 1, "shouldInterceptUrl failed " + url);
                Uri uri = Uri.parse(url);
                String host = uri.getHost();
                if (host != null && host.length() != 0) {
                    z17 = false;
                    if (!z17) {
                        return false;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Set<String> queryParameterNames = uri.getQueryParameterNames();
                    if (queryParameterNames != null) {
                        for (String it : queryParameterNames) {
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            String queryParameter = uri.getQueryParameter(it);
                            if (queryParameter == null) {
                                queryParameter = "";
                            }
                            Intrinsics.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(it) ?: \"\"");
                            linkedHashMap.put(it, queryParameter);
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(uri, "uri");
                    if (!b(uri)) {
                        return false;
                    }
                    c(hostActivity, url + "&nsr_redirect=1");
                    return true;
                }
                z17 = true;
                if (!z17) {
                }
            } else {
                return false;
            }
        } catch (Throwable unused) {
            QLog.e("QQNsrWebNavigationItem", 1, "shouldInterceptUrl failed " + url);
            return false;
        }
    }

    private final boolean b(Uri uri) {
        boolean equals$default;
        boolean equals$default2;
        equals$default = StringsKt__StringsJVMKt.equals$default(uri.getHost(), "yundong.qq.com", false, 2, null);
        if (equals$default) {
            equals$default2 = StringsKt__StringsJVMKt.equals$default(uri.getPath(), "/v2/page/weekly", false, 2, null);
            if (!equals$default2) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final void c(Activity activity, String url) {
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("fragmentStyle", 11);
        Bundle bundle = new Bundle();
        intent.putExtra("url", url);
        bundle.putString("src_url", "https://cdn-win.qq.com/public/test/2F36ABE6CBB6043B26739AC7402336BB.jpg");
        a aVar = a.f254411a;
        if (aVar.a("https://cdn-win.qq.com/public/test/2F36ABE6CBB6043B26739AC7402336BB.jpg")) {
            bundle.putString("src_url", aVar.b("https://cdn-win.qq.com/public/test/2F36ABE6CBB6043B26739AC7402336BB.jpg"));
            Pair<Integer, Integer> e16 = c.f254415a.e("https://cdn-win.qq.com/public/test/2F36ABE6CBB6043B26739AC7402336BB.jpg");
            if (e16.getFirst().intValue() != 0 && e16.getSecond().intValue() != 0) {
                bundle.putString("imgWidth", String.valueOf(e16.getFirst().intValue()));
                bundle.putString("imgHeight", String.valueOf(e16.getSecond().intValue()));
            }
        }
        intent.putExtra("kuiklyNsrParams", bundle);
        activity.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean navigateToAnotherActivity(@Nullable Intent intent, @Nullable Activity hostActivity, @Nullable String url) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, intent, hostActivity, url)).booleanValue();
        }
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || intent == null || hostActivity == null) {
            return false;
        }
        return a(hostActivity, url);
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean needSwitchFragment(@Nullable Intent intent, @Nullable Activity activity, @Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, intent, activity, url)).booleanValue();
        }
        return false;
    }
}
