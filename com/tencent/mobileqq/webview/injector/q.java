package com.tencent.mobileqq.webview.injector;

import android.content.Intent;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.messageclean.x;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R(\u0010\f\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/webview/injector/q;", "Lcom/tencent/mobileqq/app/message/messageclean/x;", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "", "getCacheSize", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "kotlin.jvm.PlatformType", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "cachePathList", "<init>", "()V", "b", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class q implements x {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<String> cachePathList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/webview/injector/q$a;", "", "", "b", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.injector.q$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void b() {
            boolean isWebProcessExist = ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isWebProcessExist();
            QLog.i("WebCacheTool", 1, "clearWebCache webProcExist=" + isWebProcessExist);
            if (isWebProcessExist) {
                Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) WebProcessReceiver.class);
                intent.setAction("action_clear_cache");
                MobileQQ.sMobileQQ.sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
            } else {
                com.tencent.mobileqq.webview.webso.e.e();
                com.tencent.mobileqq.webview.swift.utils.i.e();
                com.tencent.mobileqq.webview.swift.cookie.c.g();
                com.tencent.mobileqq.webview.html.c.f313882a.a();
            }
        }

        Companion() {
        }

        public final void a() {
            QLog.i("WebCacheTool", 1, "clearOfflineCache");
            String a16 = com.tencent.biz.common.offline.c.a();
            if (a16 != null) {
                n0.a.g(new File(a16));
            }
        }
    }

    public q() {
        ArrayList arrayListOf;
        com.tencent.mobileqq.webview.html.n nVar = com.tencent.mobileqq.webview.html.n.f313939a;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(com.tencent.biz.common.offline.c.a(), nVar.e(context));
        this.cachePathList = new CopyOnWriteArrayList<>(arrayListOf);
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    public CopyOnWriteArrayList<String> a() {
        return this.cachePathList;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    public void clearCache() {
        x.a.a(this);
        Companion companion = INSTANCE;
        companion.b();
        companion.a();
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    public long getCacheSize() {
        return x.a.b(this);
    }
}
