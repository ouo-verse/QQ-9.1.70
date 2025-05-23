package com.tencent.open.appstore.notice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.appcommon.Common;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.common.NoticeParam;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/open/appstore/notice/AdNoticeReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "", "b", "Landroid/content/Intent;", "intent", "onReceive", "", "a", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AdNoticeReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "AdNoticeReceiver";

    private final void b(Context context) {
        try {
            Object systemService = context.getSystemService("statusbar");
            Method method = systemService.getClass().getMethod("collapsePanels", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(method, "statusBarManager.javaCla\u2026tMethod(\"collapsePanels\")");
            method.invoke(systemService, new Object[0]);
        } catch (Exception e16) {
            com.tencent.open.base.f.d(this.TAG, ">>throws exception:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0072, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(com.tencent.open.downloadnew.common.c.f341483c + "." + r6, r7) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c(String str, AdNoticeReceiver this$0, String str2, String str3, Context context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DownloadInfo queryDownloadInfoByUrl = ((IGdtAPI) QRoute.api(IGdtAPI.class)).queryDownloadInfoByUrl(str);
        if (queryDownloadInfoByUrl == null) {
            com.tencent.open.base.f.e(this$0.TAG, "downloadInfo is null.");
            return;
        }
        queryDownloadInfoByUrl.S = 0;
        if (Intrinsics.areEqual(com.tencent.open.downloadnew.common.c.f341482b + "." + str2, str3)) {
            queryDownloadInfoByUrl.S = 3;
        }
        if (!Intrinsics.areEqual(com.tencent.open.downloadnew.common.c.f341481a + "." + str2, str3)) {
        }
        queryDownloadInfoByUrl.S = 2;
        if (queryDownloadInfoByUrl.S != 0) {
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).actionByDownloadInfo(queryDownloadInfoByUrl);
            return;
        }
        if (Intrinsics.areEqual(com.tencent.open.downloadnew.common.c.f341484d + "." + str2, str3)) {
            com.tencent.open.business.base.a.r(context, queryDownloadInfoByUrl.L, queryDownloadInfoByUrl.M, queryDownloadInfoByUrl.e(LaunchParam.KEY_REF_ID), queryDownloadInfoByUrl.e(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE));
            queryDownloadInfoByUrl.f341199o0 = BaseApplicationImpl.getApplication().getQQProcessName();
            if (context != null) {
                this$0.b(context);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable final Context context, @Nullable Intent intent) {
        boolean equals;
        final String str;
        String replace$default;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("processName");
            if (!TextUtils.isEmpty(stringExtra)) {
                equals = StringsKt__StringsJVMKt.equals(stringExtra, Common.m(), true);
                if (equals) {
                    final String action = intent.getAction();
                    NoticeParam noticeParam = (NoticeParam) intent.getParcelableExtra("noticeParam");
                    if (noticeParam == null) {
                        return;
                    }
                    if (stringExtra != null) {
                        replace$default = StringsKt__StringsJVMKt.replace$default(stringExtra, ":", ".", false, 4, (Object) null);
                        str = replace$default;
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(com.tencent.open.downloadnew.common.c.f341485e + "." + str, action)) {
                        com.tencent.open.business.base.a.w(context, noticeParam.f341448h);
                        return;
                    }
                    com.tencent.open.base.f.e(this.TAG, "processName :" + stringExtra + " | formatStr:" + str);
                    String str2 = noticeParam.f341448h;
                    final String str3 = noticeParam.f341449i;
                    if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                        return;
                    }
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.notice.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            AdNoticeReceiver.c(str3, this, str, action, context);
                        }
                    }, 16, null, false);
                }
            }
        }
    }
}
