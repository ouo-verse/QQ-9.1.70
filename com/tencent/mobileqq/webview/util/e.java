package com.tencent.mobileqq.webview.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u001d\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016R(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010(\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010.\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010'\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u001b\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/webview/util/e;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "startIntent", "", "f", "", "url", "Landroid/os/Bundle;", "bundle", "", "heightRatio", "", "needFilterDevice", "i", "isShowNext", "a", "b", "c", "d", "Lcom/tencent/mobileqq/webview/util/i;", "listener", "e", "j", "", "Ljava/util/List;", "getWaitingList", "()Ljava/util/List;", "setWaitingList", "(Ljava/util/List;)V", "waitingList", "Landroid/content/Intent;", "getNeedToShowBeforeClose", "()Landroid/content/Intent;", "setNeedToShowBeforeClose", "(Landroid/content/Intent;)V", "needToShowBeforeClose", "Z", "isAnyHalfScreenShowing", "()Z", "g", "(Z)V", "getNeedCloseBefore", "setNeedCloseBefore", "needCloseBefore", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", tl.h.F, "(Landroid/content/Context;)V", "listeners", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes20.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f314868a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static List<Intent> waitingList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Intent needToShowBeforeClose;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isAnyHalfScreenShowing;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean needCloseBefore;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Context context;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<i> listeners;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46176);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
            return;
        }
        f314868a = new e();
        waitingList = new ArrayList();
        listeners = new ArrayList();
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f(Context context2, Intent startIntent) {
        Intent intent;
        boolean z16;
        String stringExtra = startIntent.getStringExtra("webViewUrlBeforeClose");
        float floatExtra = startIntent.getFloatExtra("webViewRatioBeforeClose", 0.0f);
        if (!TextUtils.isEmpty(stringExtra) && context2 != null) {
            if (floatExtra == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && needCloseBefore) {
                QLog.i("HalfScreenBrowserStatusManager", 2, "need restore back url is " + stringExtra);
                f fVar = f.f314875a;
                Intrinsics.checkNotNull(stringExtra);
                intent = fVar.a(context2, stringExtra, new Bundle(), floatExtra);
                needToShowBeforeClose = intent;
                startIntent.setFlags(268435456);
                if (context2 == null) {
                    context2.startActivity(startIntent);
                    return;
                }
                return;
            }
        }
        QLog.e("HalfScreenBrowserStatusManager", 1, "invalid data, backUrl is " + stringExtra + " closeRatio is " + floatExtra);
        intent = null;
        needToShowBeforeClose = intent;
        startIntent.setFlags(268435456);
        if (context2 == null) {
        }
    }

    public final void a(boolean isShowNext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, isShowNext);
            return;
        }
        List<i> list = listeners;
        QLog.i("HalfScreenBrowserStatusManager", 1, "listeners size is " + list.size());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((i) it.next()).J0(isShowNext);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        List<i> list = listeners;
        if (ArrayUtils.isOutOfArrayIndex(0, list)) {
            QLog.e("HalfScreenBrowserStatusManager", 1, "listeners is empty");
        } else {
            QLog.i("HalfScreenBrowserStatusManager", 1, "notifyCurrentActivityDestroy");
            list.get(list.size() - 1).J0(false);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (needToShowBeforeClose == null) {
            isAnyHalfScreenShowing = false;
            waitingList.clear();
            listeners.clear();
            needToShowBeforeClose = null;
            context = null;
            return;
        }
        QLog.i("HalfScreenBrowserStatusManager", 2, "start back intent");
        Intent intent = needToShowBeforeClose;
        if (intent != null) {
            intent.setFlags(268435456);
        }
        Context context2 = context;
        if (context2 != null) {
            context2.startActivity(needToShowBeforeClose);
        }
        needToShowBeforeClose = null;
        context = null;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        QLog.i("HalfScreenBrowserStatusManager", 1, "notifyShowNextHalfScreenWeb");
        isAnyHalfScreenShowing = false;
        if (ArrayUtils.isOutOfArrayIndex(0, waitingList)) {
            return;
        }
        f(context, waitingList.get(0));
        waitingList.clear();
        context = null;
    }

    public final void e(@NotNull i listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            listeners.add(listener);
        }
    }

    public final void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            isAnyHalfScreenShowing = z16;
        }
    }

    public final void h(@Nullable Context context2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context2);
        } else {
            context = context2;
        }
    }

    public final void i(@NotNull Context context2, @NotNull String url, @NotNull Bundle bundle, float heightRatio, boolean needFilterDevice) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, context2, url, bundle, Float.valueOf(heightRatio), Boolean.valueOf(needFilterDevice));
            return;
        }
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (needFilterDevice && f.f314875a.i("")) {
            Intent intent = new Intent(context2, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", url);
            context2.startActivity(intent);
            return;
        }
        Intent a16 = f.f314875a.a(context2, url, bundle, heightRatio);
        boolean equals = TextUtils.equals(a16.getStringExtra("isNeedCloseBefore"), "1");
        needCloseBefore = equals;
        if (isAnyHalfScreenShowing && equals) {
            waitingList.add(a16);
            a(true);
            QLog.i("HalfScreenBrowserStatusManager", 1, "waiting list size is " + waitingList.size());
            return;
        }
        QLog.i("HalfScreenBrowserStatusManager", 1, "startActivity, waiting list size is " + waitingList.size());
        f(context2, a16);
    }

    public final void j(@NotNull i listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            listeners.remove(listener);
        }
    }
}
