package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import kotlin.Metadata;
import u43.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\b*\u0001\u0019\u0018\u0000 \u001f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J&\u0010\r\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/webviewplugin/StudyModeWebInterceptor;", "Lu43/a;", "", "d", "e", "", "url", "Lu43/a$a;", "callback", "", "c", "Landroid/content/Context;", "context", "a", "Lcom/tencent/mobileqq/webviewplugin/a;", "Lcom/tencent/mobileqq/webviewplugin/a;", "interceptorCallBack", "b", "Ljava/lang/String;", "interceptorResultUrl", "", "I", "STUDYMODE_REGISTER", "STUDYMODE_UNREGISTER", "isStudyModePassWordCheckReceiverRegister", "com/tencent/mobileqq/webviewplugin/StudyModeWebInterceptor$studyModePassWordCheckReceiver$1", "f", "Lcom/tencent/mobileqq/webviewplugin/StudyModeWebInterceptor$studyModePassWordCheckReceiver$1;", "studyModePassWordCheckReceiver", "<init>", "()V", "g", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class StudyModeWebInterceptor implements u43.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private a interceptorCallBack;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int STUDYMODE_REGISTER;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String interceptorResultUrl = "https://accounts.qq.com/teen-mode/index.html?";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int STUDYMODE_UNREGISTER = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int isStudyModePassWordCheckReceiverRegister = -1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final StudyModeWebInterceptor$studyModePassWordCheckReceiver$1 studyModePassWordCheckReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.webviewplugin.StudyModeWebInterceptor$studyModePassWordCheckReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a aVar;
            Activity a16;
            a aVar2;
            String stringExtra = intent != null ? intent.getStringExtra(IStudyModeManager.STUDY_MODE_ULR_FILTER_RESULT) : null;
            boolean z16 = false;
            if (stringExtra != null && stringExtra.equals(IStudyModeManager.STUDY_MODE_URL_FILTER_RESULT_SUC)) {
                z16 = true;
            }
            if (z16) {
                aVar2 = StudyModeWebInterceptor.this.interceptorCallBack;
                if (aVar2 != null) {
                    String stringExtra2 = intent.getStringExtra(IStudyModeManager.STUDY_MODE_URL_FILTER_PATH_URL);
                    intent.getLongExtra(IStudyModeManager.STUDY_MODE_ULR_FILTER_RESULT_TIME, 0L);
                    if (stringExtra2 == null || !aVar2.getUrl().equals(stringExtra2)) {
                        return;
                    }
                    aVar2.c();
                    Activity a17 = aVar2.a();
                    if (a17 != null) {
                        a17.finish();
                        return;
                    }
                    return;
                }
                return;
            }
            aVar = StudyModeWebInterceptor.this.interceptorCallBack;
            if (aVar == null || (a16 = aVar.a()) == null) {
                return;
            }
            a16.finish();
        }
    };

    private final void d() {
        if (this.studyModePassWordCheckReceiver == null || this.isStudyModePassWordCheckReceiverRegister != this.STUDYMODE_UNREGISTER) {
            return;
        }
        BaseApplication.getContext().registerReceiver(this.studyModePassWordCheckReceiver, new IntentFilter(IStudyModeManager.STUDY_MODE_URL_FILTER_PATH));
        this.isStudyModePassWordCheckReceiverRegister = this.STUDYMODE_REGISTER;
    }

    private final void e() {
        if (this.studyModePassWordCheckReceiver == null || this.isStudyModePassWordCheckReceiverRegister != this.STUDYMODE_REGISTER) {
            return;
        }
        BaseApplication.getContext().unregisterReceiver(this.studyModePassWordCheckReceiver);
        this.isStudyModePassWordCheckReceiverRegister = this.STUDYMODE_UNREGISTER;
    }

    @Override // u43.a
    public boolean a(String url, Context context, a.InterfaceC11322a callback) {
        w43.a aVar = w43.a.f444584a;
        boolean c16 = aVar.c();
        boolean studyModeUrlFilterNeed = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).studyModeUrlFilterNeed();
        QLog.d("WebInterceptorImpl", 1, "urlfilter studyMode=" + c16 + " urlfilter=" + studyModeUrlFilterNeed);
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).studyMode9165Switch() || !studyModeUrlFilterNeed || !c16 || context == null || url == null) {
            return false;
        }
        if (aVar.g(url)) {
            if (callback != null) {
                callback.resume();
            }
            QLog.d("WebInterceptorImpl", 1, "urlfilter white open");
            return true;
        }
        if (c(url, callback)) {
            QLog.d("WebInterceptorImpl", 1, "caches white open");
            return true;
        }
        this.interceptorCallBack = new a(url, callback);
        Intent intent = new Intent();
        intent.putExtra(IStudyModeManager.STUDY_MODE_URL_FILTER_PATH_URL, url);
        ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).openUrlFilterMainFragment(context, intent);
        e();
        d();
        return true;
    }

    private final boolean c(String url, a.InterfaceC11322a callback) {
        Bundle bundle;
        String string;
        if (url == null) {
            return false;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(IStudyModeManager.STUDY_MODE_URL_FILTER_PATH, url);
        bundle2.putString(IStudyModeManager.STUDY_MODE_ULR_FILTER_EQUAL, url);
        bundle2.putString(IStudyModeManager.STUDY_MODE_ULR_FILTER_RESULT, IStudyModeManager.STUDY_MODE_URL_FILTER_RESULT_FAIL);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), IStudyModeManager.STUDY_MODE_ULR_FILTER_PROCESS_NAME, IStudyModeManager.STUDY_MODE_URL_FILTER_PATH, bundle2);
        if (callServer != null && (bundle = callServer.data) != null && (string = bundle.getString(IStudyModeManager.STUDY_MODE_ULR_FILTER_EQUAL)) != null) {
            if (string.equals(url)) {
                Bundle bundle3 = callServer.data;
                String string2 = bundle3 != null ? bundle3.getString(IStudyModeManager.STUDY_MODE_ULR_FILTER_RESULT) : null;
                if (string2 != null && string2.equals(IStudyModeManager.STUDY_MODE_URL_FILTER_RESULT_SUC)) {
                    if (callback != null) {
                        callback.resume();
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
