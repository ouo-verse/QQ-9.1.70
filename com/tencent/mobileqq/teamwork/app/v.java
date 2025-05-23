package com.tencent.mobileqq.teamwork.app;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.teamwork.ProcessOpenDocsPerformanceData;
import com.tencent.mobileqq.teamwork.api.ITDocWebIPCModuleApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import eipc.EIPCResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class v extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private List<a> f291972d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(String str, int i3, String str2);

        void b(String str, ProcessOpenDocsPerformanceData processOpenDocsPerformanceData);

        void c(String str, String str2, String str3);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static v f291973a = new v();
    }

    public v() {
        super(ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_SERVER_NAME);
        this.f291972d = new CopyOnWriteArrayList();
    }

    public static v f() {
        return b.f291973a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void j(Bundle bundle, int i3) {
        int i16 = bundle.getInt("key_error_code", 0);
        String string = bundle.getString("key_error_msg", "");
        String string2 = bundle.getString("key_web_page_id", "");
        for (a aVar : this.f291972d) {
            if (aVar != null) {
                aVar.a(string2, i16, string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void k(Bundle bundle, int i3) {
        try {
            bundle.setClassLoader(ProcessOpenDocsPerformanceData.class.getClassLoader());
            ProcessOpenDocsPerformanceData processOpenDocsPerformanceData = (ProcessOpenDocsPerformanceData) bundle.getParcelable(ITDocWebIPCModuleApi.KEY_PERFORMANCE_DATA);
            String string = bundle.getString("key_web_page_id", "");
            for (a aVar : this.f291972d) {
                if (aVar != null) {
                    aVar.b(string, processOpenDocsPerformanceData);
                }
            }
        } catch (Exception e16) {
            QLog.e(ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_SERVER_NAME, 1, "handleOpenPerformanceData error : " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void lambda$onCall$0(Bundle bundle, int i3) {
        String string = bundle.getString(ITDocWebIPCModuleApi.KEY_JS_API_NAME_SPACE);
        String string2 = bundle.getString(ITDocWebIPCModuleApi.KEY_JS_API_METHOD);
        String string3 = bundle.getString(ITDocWebIPCModuleApi.KEY_JS_API_ARGS);
        for (a aVar : this.f291972d) {
            if (aVar != null) {
                aVar.c(string, string2, string3);
            }
        }
    }

    public void e(a aVar) {
        if (!this.f291972d.contains(aVar)) {
            this.f291972d.add(aVar);
        }
    }

    public void l(a aVar) {
        if (this.f291972d.contains(aVar)) {
            this.f291972d.remove(aVar);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, final Bundle bundle, final int i3) {
        Log.d(ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_SERVER_NAME, "receive action: " + str);
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1168164616:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_NOTIFY_OPEN_FILE_RESULT)) {
                    c16 = 0;
                    break;
                }
                break;
            case -296203726:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_SEND_JS_API)) {
                    c16 = 1;
                    break;
                }
                break;
            case 1065230949:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_OPEN_PERFORMANCE_DATA)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.app.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.this.j(bundle, i3);
                    }
                });
                break;
            case 1:
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.app.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.this.lambda$onCall$0(bundle, i3);
                    }
                });
                break;
            case 2:
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.app.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.this.k(bundle, i3);
                    }
                });
                break;
        }
        return EIPCResult.UNKNOW_RESULT;
    }
}
