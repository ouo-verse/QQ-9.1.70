package com.tencent.aio.pref;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J/\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\f\u0010\t\u001a\u00020\u0003*\u00020\u0003H\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0003J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001aR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010!R\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010!\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010*\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010!\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R+\u00101\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001d8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b(\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00103\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b#\u00102R\"\u00106\u001a\u00020 8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010!\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u00069"}, d2 = {"Lcom/tencent/aio/pref/a;", "", "T", "", "methodName", "Lkotlin/Function0;", "block", "p", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "k", "d", DomainData.DOMAIN_NAME, "f", "section", "j", "label", "o", "method", "b", "e", "name", "a", "c", "", "I", "methodTracingSamplingInUs", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "actions", "", "Z", "isStartBegin", h.F, "()Z", "setEnableTracker", "(Z)V", "enableTracker", "g", "setEnableTrace", "enableTrace", "<set-?>", "Lkotlin/properties/ReadWriteProperty;", "i", "()J", "l", "(J)V", "firstRequest", "Ljava/lang/String;", "requstFirstPageMethod", "isResumeLaunchAIO$sdk_debug", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isResumeLaunchAIO", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f69779a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int methodTracingSamplingInUs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static ConcurrentHashMap<String, Long> actions;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isStartBegin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean enableTracker;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean enableTrace;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final ReadWriteProperty firstRequest;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final String requstFirstPageMethod;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean isResumeLaunchAIO;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f69788j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53460);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f69779a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "firstRequest", "getFirstRequest()J", 0))};
        f69788j = new a();
        methodTracingSamplingInUs = 2000;
        actions = new ConcurrentHashMap<>();
        firstRequest = Delegates.INSTANCE.notNull();
        requstFirstPageMethod = "requestFirstPage";
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        }
    }

    private final long i() {
        return ((Number) firstRequest.getValue(this, f69779a[0])).longValue();
    }

    private final void l(long j3) {
        firstRequest.setValue(this, f69779a[0], Long.valueOf(j3));
    }

    @JvmStatic
    public static final <T> T p(@NotNull String methodName, @NotNull Function0<? extends T> block) {
        T t16;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(block, "block");
        a aVar = f69788j;
        if (!aVar.g()) {
            return block.invoke();
        }
        aVar.b(methodName);
        String str = "AIO#" + methodName;
        if (!aVar.h()) {
            t16 = block.invoke();
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            T invoke = block.invoke();
            Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
            t16 = invoke;
        }
        aVar.e();
        return t16;
    }

    private final String q(String str) {
        if (str.length() > 127) {
            return str.subSequence(0, 50).toString();
        }
        return str;
    }

    public final void a(@NotNull String name) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) name);
            return;
        }
        Intrinsics.checkNotNullParameter(name, "name");
        if (enableTrace && Build.VERSION.SDK_INT >= 29) {
            Trace.beginAsyncSection(q("AIO#" + name), 11);
        }
    }

    public final void b(@NotNull String method) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) method);
            return;
        }
        Intrinsics.checkNotNullParameter(method, "method");
        if (!enableTrace) {
            return;
        }
        Trace.beginSection(q("AIO#" + method));
    }

    public final void c(@NotNull String name) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) name);
            return;
        }
        Intrinsics.checkNotNullParameter(name, "name");
        if (enableTrace && Build.VERSION.SDK_INT >= 29) {
            Trace.endAsyncSection(q("AIO#" + name), 11);
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (!enableTrace) {
            return;
        }
        Log.d("AIO#", "firstRequestSpend " + (System.currentTimeMillis() - i()));
        c(requstFirstPageMethod);
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            if (!enableTrace) {
                return;
            }
            Trace.endSection();
        }
    }

    public final void f() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (!isStartBegin) {
            return;
        }
        isStartBegin = false;
        if (isResumeLaunchAIO) {
            str = "\u590d\u7528";
        } else {
            str = "";
        }
        o("launchAIO", str);
        c("launchAIO");
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return enableTrace;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return enableTracker;
    }

    public final void j(@NotNull String section) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) section);
            return;
        }
        Intrinsics.checkNotNullParameter(section, "section");
        if (!enableTracker) {
            return;
        }
        actions.put(section, Long.valueOf(System.currentTimeMillis()));
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (!enableTrace) {
            return;
        }
        l(System.currentTimeMillis());
        if (actions.get("launchAIO") != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("requestFirstPage ");
            long currentTimeMillis = System.currentTimeMillis();
            Long l3 = actions.get("launchAIO");
            Intrinsics.checkNotNull(l3);
            Intrinsics.checkNotNullExpressionValue(l3, "actions[methodStartAIO]!!");
            sb5.append(currentTimeMillis - l3.longValue());
            sb5.append(TokenParser.SP);
            Log.d("AIO#", sb5.toString());
        }
        a(requstFirstPageMethod);
    }

    public final void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            isResumeLaunchAIO = z16;
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            if (!enableTrace) {
                return;
            }
            j("launchAIO");
            isStartBegin = true;
            a("launchAIO");
        }
    }

    public final void o(@NotNull String section, @NotNull String label) {
        Long remove;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) section, (Object) label);
            return;
        }
        Intrinsics.checkNotNullParameter(section, "section");
        Intrinsics.checkNotNullParameter(label, "label");
        if (enableTracker && (remove = actions.remove(section)) != null) {
            Intrinsics.checkNotNullExpressionValue(remove, "actions.remove(section) ?: return");
            Log.d("AIO#", section + label + " spend " + (System.currentTimeMillis() - remove.longValue()));
        }
    }
}
