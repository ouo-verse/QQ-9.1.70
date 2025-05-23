package com.tencent.open.appstore.notice;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.appcommon.Common;
import com.tencent.open.downloadnew.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R*\u0010#\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/open/appstore/notice/b;", "", "Landroid/os/Message;", "msg", "", "d", "Lcom/tencent/open/downloadnew/DownloadInfo;", "info", "c", "Lcom/tencent/open/appstore/notice/c;", "b", "Lcom/tencent/open/appstore/notice/c;", "getMAdNoticeHandler", "()Lcom/tencent/open/appstore/notice/c;", "setMAdNoticeHandler", "(Lcom/tencent/open/appstore/notice/c;)V", "mAdNoticeHandler", "Lcom/tencent/open/appstore/notice/AdNoticeReceiver;", "Lcom/tencent/open/appstore/notice/AdNoticeReceiver;", "getMNoticeReceiver", "()Lcom/tencent/open/appstore/notice/AdNoticeReceiver;", "mNoticeReceiver", "Landroid/content/IntentFilter;", "Landroid/content/IntentFilter;", "getNoticeFilter", "()Landroid/content/IntentFilter;", "noticeFilter", "", "kotlin.jvm.PlatformType", "e", "Ljava/lang/String;", "getProcessName", "()Ljava/lang/String;", "setProcessName", "(Ljava/lang/String;)V", "processName", "f", "getSuffix", "setSuffix", "suffix", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static c mAdNoticeHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IntentFilter noticeFilter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String processName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String suffix;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f340906a = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AdNoticeReceiver mNoticeReceiver = new AdNoticeReceiver();

    static {
        String replace$default;
        IntentFilter intentFilter = new IntentFilter();
        noticeFilter = intentFilter;
        String processName2 = Common.m();
        processName = processName2;
        Intrinsics.checkNotNullExpressionValue(processName2, "processName");
        replace$default = StringsKt__StringsJVMKt.replace$default(processName2, ":", ".", false, 4, (Object) null);
        suffix = "." + replace$default;
        intentFilter.addAction(com.tencent.open.downloadnew.common.c.f341481a + suffix);
        intentFilter.addAction(com.tencent.open.downloadnew.common.c.f341482b + suffix);
        intentFilter.addAction(com.tencent.open.downloadnew.common.c.f341483c + suffix);
        intentFilter.addAction(com.tencent.open.downloadnew.common.c.f341484d + suffix);
        intentFilter.addAction(com.tencent.open.downloadnew.common.c.f341485e + suffix);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.notice.a
            @Override // java.lang.Runnable
            public final void run() {
                b.b();
            }
        }, 16, null, false);
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        com.tencent.open.adapter.a.f().e().registerReceiver(mNoticeReceiver, noticeFilter);
    }

    private final void d(Message msg2) {
        if (msg2 == null) {
            return;
        }
        if (mAdNoticeHandler == null) {
            mAdNoticeHandler = new c(ThreadManagerV2.getQQCommonThreadLooper());
        }
        c cVar = mAdNoticeHandler;
        if (cVar != null) {
            cVar.sendMessage(msg2);
        }
    }

    public final void c(@Nullable DownloadInfo info) {
        Message message;
        if (info == null) {
            return;
        }
        if (mAdNoticeHandler == null) {
            mAdNoticeHandler = new c(ThreadManagerV2.getQQCommonThreadLooper());
        }
        c cVar = mAdNoticeHandler;
        if (cVar != null) {
            message = cVar.obtainMessage();
        } else {
            message = null;
        }
        if (message != null) {
            message.what = info.f();
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_New_Downloader", true);
        bundle.putParcelable("downloadInfo", info);
        if (message != null) {
            message.setData(bundle);
        }
        d(message);
    }
}
