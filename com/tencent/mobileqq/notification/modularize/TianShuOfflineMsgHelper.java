package com.tencent.mobileqq.notification.modularize;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb$MsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J6\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/TianShuOfflineMsgHelper;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "Lcom/tencent/mobileqq/notification/modularize/f;", "pushList", "", "g", "", QQBrowserActivity.KEY_MSG_TYPE, "msgSubType", "Ltencent/im/s2c/msgtype0x210/submsgtype0x135/ModulePushPb$MsgBody;", "msg", "", "isFirstMsg", TPReportKeys.Common.COMMON_ONLINE, "c", "", "b", "Ljava/util/List;", "Lkotlin/Lazy;", "f", "()Z", "sIsUsedSubThread", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class TianShuOfflineMsgHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TianShuOfflineMsgHelper f254256a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static List<f> pushList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sIsUsedSubThread;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class a<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((f) t17).time), Long.valueOf(((f) t16).time));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59299);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f254256a = new TianShuOfflineMsgHelper();
        pushList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(TianShuOfflineMsgHelper$sIsUsedSubThread$2.INSTANCE);
        sIsUsedSubThread = lazy;
    }

    TianShuOfflineMsgHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QQAppInterface app, ModulePushPb$MsgBody msg2) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        new OnlineModulePushReceiver(app).i(new OnlineModulePushReceiver(app).f(msg2, "1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(QQAppInterface app) {
        List<f> list;
        Intrinsics.checkNotNullParameter(app, "$app");
        list = CollectionsKt___CollectionsKt.toList(pushList);
        f254256a.g(app, list);
    }

    private final boolean f() {
        return ((Boolean) sIsUsedSubThread.getValue()).booleanValue();
    }

    private final void g(QQAppInterface app, List<f> pushList2) {
        CollectionsKt___CollectionsKt.sortedWith(pushList2, new a());
        new OnlineModulePushReceiver(app).h(pushList2);
        QLog.d("TianShuOfflineMsgHelper", 1, "pushList sort: ", pushList2);
    }

    public final void c(@NotNull final QQAppInterface app, long msgType, long msgSubType, @NotNull final ModulePushPb$MsgBody msg2, boolean isFirstMsg, boolean online) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, app, Long.valueOf(msgType), Long.valueOf(msgSubType), msg2, Boolean.valueOf(isFirstMsg), Boolean.valueOf(online));
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d("TianShuOfflineMsgHelper", 1, "dispatchTianShuMsg");
        if (online) {
            if (f()) {
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.notification.modularize.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        TianShuOfflineMsgHelper.d(QQAppInterface.this, msg2);
                    }
                });
                return;
            } else {
                new OnlineModulePushReceiver(app).i(new OnlineModulePushReceiver(app).f(msg2, "1"));
                return;
            }
        }
        if (isFirstMsg) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.notification.modularize.t
                @Override // java.lang.Runnable
                public final void run() {
                    TianShuOfflineMsgHelper.e(QQAppInterface.this);
                }
            }, 16, null, true, 5000L);
        }
        synchronized (pushList) {
            pushList.add(new OnlineModulePushReceiver(app).f(msg2, "2"));
        }
    }
}
