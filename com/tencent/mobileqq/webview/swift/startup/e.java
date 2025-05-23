package com.tencent.mobileqq.webview.swift.startup;

import android.util.SparseArray;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\f\u001a\u00020\u0007H\u0007R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\rR\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\rR\u0014\u0010!\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\rR\u0014\u0010#\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\rR\u0014\u0010%\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\rR\u0014\u0010'\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\rR\u0014\u0010)\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\rR\u0014\u0010+\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\rR\u0014\u0010-\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\rR\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020/0.8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/e;", "Ljava/util/Observable;", "", "event", "", "", "data", "", "c", "(I[Ljava/lang/Object;)V", "", "b", "a", "I", "getEventCounter", "()I", "setEventCounter", "(I)V", "eventCounter", "EVENT_ACTIVITY_CREATE", "d", "EVENT_KERNEL_CREATE", "e", "EVENT_KERNEL_START", "f", "EVENT_KERNEL_INIT_DATA", "g", "EVENT_KERNEL_INIT_X5", h.F, "EVENT_KERNEL_INIT_ENGINE", "i", "EVENT_KERNEL_INIT_WEBVIEW", "j", "EVENT_KERNEL_LOAD_URL", "k", "EVENT_KERNEL_INIT_UIFRAME", "l", "EVENT_KERNEL_INIT_UICONTENT", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "EVENT_KERNEL_INIT_TITLEBAR", DomainData.DOMAIN_NAME, "EVENT_KERNEL_INIT_BOTTOM", "o", "EVENT_KERNEL_INIT_FINAL", "p", "EVENT_END", "Landroid/util/SparseArray;", "Ljava/util/concurrent/atomic/AtomicBoolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/util/SparseArray;", "getEvents", "()Landroid/util/SparseArray;", LinkReportConstant$GlobalKey.EVENTS, "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e extends Observable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f314664a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int eventCounter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_ACTIVITY_CREATE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_KERNEL_CREATE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_KERNEL_START;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_KERNEL_INIT_DATA;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_KERNEL_INIT_X5;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_KERNEL_INIT_ENGINE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_KERNEL_INIT_WEBVIEW;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_KERNEL_LOAD_URL;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_KERNEL_INIT_UIFRAME;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_KERNEL_INIT_UICONTENT;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_KERNEL_INIT_TITLEBAR;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_KERNEL_INIT_BOTTOM;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_KERNEL_INIT_FINAL;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int EVENT_END;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<AtomicBoolean> events;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42374);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f314664a = new e();
        int i3 = eventCounter;
        int i16 = i3 + 1;
        EVENT_ACTIVITY_CREATE = i3;
        int i17 = i16 + 1;
        EVENT_KERNEL_CREATE = i16;
        int i18 = i17 + 1;
        EVENT_KERNEL_START = i17;
        int i19 = i18 + 1;
        EVENT_KERNEL_INIT_DATA = i18;
        int i26 = i19 + 1;
        EVENT_KERNEL_INIT_X5 = i19;
        int i27 = i26 + 1;
        EVENT_KERNEL_INIT_ENGINE = i26;
        int i28 = i27 + 1;
        EVENT_KERNEL_INIT_WEBVIEW = i27;
        int i29 = i28 + 1;
        EVENT_KERNEL_LOAD_URL = i28;
        int i36 = i29 + 1;
        EVENT_KERNEL_INIT_UIFRAME = i29;
        int i37 = i36 + 1;
        EVENT_KERNEL_INIT_UICONTENT = i36;
        int i38 = i37 + 1;
        EVENT_KERNEL_INIT_TITLEBAR = i37;
        int i39 = i38 + 1;
        EVENT_KERNEL_INIT_BOTTOM = i38;
        eventCounter = i39 + 1;
        EVENT_KERNEL_INIT_FINAL = i39;
        EVENT_END = i39;
        events = new SparseArray<>(eventCounter);
        int i46 = eventCounter;
        for (int i47 = 0; i47 < i46; i47++) {
            events.put(i47, new AtomicBoolean(false));
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a() {
        int i3 = eventCounter;
        for (int i16 = 0; i16 < i3; i16++) {
            events.get(i16).set(false);
        }
    }

    @JvmStatic
    public static final boolean b(int event) {
        return events.get(event).get();
    }

    @JvmStatic
    public static final void c(int event, @NotNull Object... data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (events.get(event).compareAndSet(false, true)) {
            e eVar = f314664a;
            eVar.setChanged();
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(Integer.valueOf(event));
            spreadBuilder.addSpread(data);
            eVar.notifyObservers(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }
}
