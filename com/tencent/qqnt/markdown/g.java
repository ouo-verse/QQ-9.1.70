package com.tencent.qqnt.markdown;

import com.tencent.android.androidbypass.config.h;
import com.tencent.android.androidbypass.config.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/markdown/g;", "", "Lcom/tencent/android/androidbypass/parser/d;", "g", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f359430a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31337);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f359430a = new g();
        QLog.i("QQMarkdownEngine", 1, "BypassInjecting");
        com.tencent.android.androidbypass.config.b bVar = com.tencent.android.androidbypass.config.b.f72055d;
        bVar.d(new com.tencent.android.androidbypass.config.f() { // from class: com.tencent.qqnt.markdown.d
            @Override // com.tencent.android.androidbypass.config.f
            public final void onLog(int i3, String str, String str2) {
                g.d(i3, str, str2);
            }
        });
        bVar.f(new i() { // from class: com.tencent.qqnt.markdown.e
            @Override // com.tencent.android.androidbypass.config.i
            public final boolean a() {
                boolean e16;
                e16 = g.e();
                return e16;
            }
        });
        bVar.e(new h() { // from class: com.tencent.qqnt.markdown.f
            @Override // com.tencent.android.androidbypass.config.h
            public final void reportTimeCost(String str, Map map, double d16) {
                g.f(str, map, d16);
            }
        });
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(int i3, String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        QLog.e(tag, 1, msg2);
                        return;
                    } else {
                        QLog.e(tag, 1, msg2);
                        return;
                    }
                }
                QLog.w(tag, 1, msg2);
                return;
            }
            QLog.i(tag, 1, msg2);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(tag, 4, msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e() {
        try {
            System.loadLibrary("bypass");
            QLog.d("QQMarkdownEngine", 1, "load include bypass so success");
            return true;
        } catch (Throwable th5) {
            QLog.e("QQMarkdownEngine", 1, "load include bypass so fail", th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String scene, Map map, double d16) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        ((IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class)).reportTimeCost(scene, map, d16);
    }

    @NotNull
    public final com.tencent.android.androidbypass.parser.d g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.android.androidbypass.parser.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.android.androidbypass.parser.d(null, 1, 0 == true ? 1 : 0);
    }
}
