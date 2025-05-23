package com.tencent.mobileqq.webview.html.impl;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webview.html.SessionData;
import com.tencent.mobileqq.webview.html.b;
import com.tencent.mobileqq.webview.html.c;
import com.tencent.mobileqq.webview.html.d;
import com.tencent.mobileqq.webview.html.h;
import com.tencent.mobileqq.webview.html.n;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/webview/html/impl/DefaultCacheHandler;", "Lcom/tencent/mobileqq/webview/html/h;", "", "id", "Lcom/tencent/mobileqq/webview/html/SessionData;", "b", "sessionData", "", "a", "c", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class DefaultCacheHandler implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final LruCache<String, SessionData> f313900b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/webview/html/impl/DefaultCacheHandler$a;", "", "", "TAG", "Ljava/lang/String;", "Landroidx/collection/LruCache;", "Lcom/tencent/mobileqq/webview/html/SessionData;", "lruCookieMonsterMap", "Landroidx/collection/LruCache;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.html.impl.DefaultCacheHandler$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(VasWebviewConstants.REPORT_FROM_USER_PROFILE_CARD);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
            f313900b = new LruCache<>(8);
        }
    }

    public DefaultCacheHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.html.h
    public void a(@NotNull SessionData sessionData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) sessionData);
            return;
        }
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        LruCache<String, SessionData> lruCache = f313900b;
        synchronized (lruCache) {
            lruCache.put(sessionData.sessionId, sessionData);
        }
        c.g(c.f313882a, "htmlAgent_DefaultCacheHandler", 3, "updateOrSaveSessionData " + sessionData, null, 8, null);
        b.f313880a.f(sessionData);
    }

    @Override // com.tencent.mobileqq.webview.html.h
    @Nullable
    public SessionData b(@NotNull String id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SessionData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) id5);
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        LruCache<String, SessionData> lruCache = f313900b;
        synchronized (lruCache) {
            SessionData sessionData = lruCache.get(id5);
            if (sessionData != null) {
                return sessionData;
            }
            Unit unit = Unit.INSTANCE;
            SessionData e16 = b.f313880a.e(id5);
            if (e16 != null) {
                synchronized (lruCache) {
                    lruCache.put(id5, e16);
                }
            }
            c.g(c.f313882a, "htmlAgent_DefaultCacheHandler", 3, "lookupSessionData from db id:" + id5 + " " + e16, null, 8, null);
            return e16;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (r1.p(r2, r23.htmlSha1) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008a, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009c, code lost:
    
        r0 = r23.sessionId;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a2, code lost:
    
        if (r2 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
    
        r1 = java.lang.Integer.valueOf(r2.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ae, code lost:
    
        com.tencent.mobileqq.webview.html.c.g(r8, "htmlAgent_DefaultCacheHandler", 4, "getCachedHtmlWithValidation id:" + r0 + " strict:" + r4 + " valid:" + r7 + " len:" + r1, null, 8, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ad, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0099, code lost:
    
        if (r1 != false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.webview.html.h
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(@NotNull SessionData sessionData) {
        String str;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) sessionData);
        }
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        n nVar = n.f313939a;
        File file = new File(nVar.f(sessionData.sessionId));
        boolean z18 = false;
        if (sessionData.htmlSize > 0 && !TextUtils.isEmpty(sessionData.htmlSha1)) {
            if (!file.exists()) {
                c.g(c.f313882a, "htmlAgent_DefaultCacheHandler", 3, "getCachedHtmlWithValidation id:" + sessionData.sessionId + " file not exists", null, 8, null);
            } else {
                str = nVar.n(file);
                c cVar = c.f313882a;
                d e16 = cVar.e();
                if (e16 != null && e16.k()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (str != null && str.length() == sessionData.htmlSize) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
                if (z18) {
                    return null;
                }
                return str;
            }
        } else {
            c.g(c.f313882a, "htmlAgent_DefaultCacheHandler", 3, "getCachedHtmlWithValidation id:" + sessionData.sessionId + " data invalid", null, 8, null);
        }
        str = null;
        if (z18) {
        }
    }
}
