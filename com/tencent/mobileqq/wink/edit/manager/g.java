package com.tencent.mobileqq.wink.edit.manager;

import android.os.Bundle;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ProcessUtil;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes21.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f318428a = "com.tencent.mobileqq.wink.edit.manager.g";

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends EIPCModule {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f318429d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f318430e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, b bVar) {
            super(str);
            this.f318429d = str2;
            this.f318430e = bVar;
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            String str2;
            if (bundle == null) {
                return null;
            }
            if (((IPeakIpcController) QRoute.api(IPeakIpcController.class)).ACTION_UPLOAD_ARK_VIDEO_SUCCESS().equals(str)) {
                if (bundle.containsKey(((IPeakIpcController) QRoute.api(IPeakIpcController.class)).KEY_UPLOAD_ARK_VIDEO_DOWNLOAD_URL())) {
                    str2 = bundle.getString(((IPeakIpcController) QRoute.api(IPeakIpcController.class)).KEY_UPLOAD_ARK_VIDEO_DOWNLOAD_URL());
                } else {
                    str2 = null;
                }
                ms.a.f(g.f318428a, this.f318429d + " uploadArkVideo SUCCESS: videoDownUrl=" + str2);
                QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
                b bVar = this.f318430e;
                if (bVar != null) {
                    bVar.onSuccess(str2);
                }
            } else if (((IPeakIpcController) QRoute.api(IPeakIpcController.class)).ACTION_UPLOAD_ARK_VIDEO_FAIL().equals(str)) {
                ms.a.f(g.f318428a, this.f318429d + " uploadArkVideo FAIL");
                QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
                b bVar2 = this.f318430e;
                if (bVar2 != null) {
                    bVar2.onFail();
                }
            } else if (((IPeakIpcController) QRoute.api(IPeakIpcController.class)).ACTION_UPLOAD_ARK_VIDEO_PROGRESS_UPDATE().equals(str)) {
                if (bundle.containsKey(((IPeakIpcController) QRoute.api(IPeakIpcController.class)).KEY_UPLOAD_ARK_VIDEO_PROGRESS())) {
                    int i16 = bundle.getInt(((IPeakIpcController) QRoute.api(IPeakIpcController.class)).KEY_UPLOAD_ARK_VIDEO_PROGRESS());
                    b bVar3 = this.f318430e;
                    if (bVar3 != null) {
                        bVar3.onProgress(i16);
                    }
                }
            } else if (((IPeakIpcController) QRoute.api(IPeakIpcController.class)).ACTION_UPLOAD_ARK_VIDEO_CANCEL().equals(str)) {
                ms.a.f(g.f318428a, this.f318429d + " uploadArkVideo CANCEL");
                QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
                b bVar4 = this.f318430e;
                if (bVar4 != null) {
                    bVar4.onCancel();
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
        void onCancel();

        void onFail();

        void onProgress(int i3);

        void onSuccess(String str);
    }

    private static void b(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(((IPeakIpcModuleServer) QRoute.api(IPeakIpcModuleServer.class)).KEY_UPLOAD_ARK_VIDEO_PATH(), str);
        bundle.putString(((IPeakIpcModuleServer) QRoute.api(IPeakIpcModuleServer.class)).KEY_UPLOAD_ARK_RES_POSTFIX(), str2);
        bundle.putString(((IPeakIpcController) QRoute.api(IPeakIpcController.class)).KEY_UPLOAD_ARK_VIDEO_CALLBACK_CLIENT_NAME(), str3);
        bundle.putInt(((IPeakIpcController) QRoute.api(IPeakIpcController.class)).KEY_UPLOAD_COMMAND_ID(), 93);
        bundle.putString(((IPeakIpcController) QRoute.api(IPeakIpcController.class)).keyUploadProcessName(), ProcessUtil.getCurrentProcessName(BaseApplication.context));
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        qIPCClientHelper.callServer(IPeakIpcModuleServer.NAME, ((IPeakIpcModuleServer) QRoute.api(IPeakIpcModuleServer.class)).ACTION_UPLOAD_ARK_VIDEO(), bundle, null);
    }

    public static void c(String str, String str2, b bVar) {
        String str3 = "receive_progress_" + System.nanoTime() + "_" + UUID.randomUUID().toString();
        ms.a.f(f318428a, "uploadOriginImageFile---: " + str + ", clientName:" + str3);
        QIPCClientHelper.getInstance().getClient().registerModule(new a(str3, str3, bVar));
        b(str, str2, str3);
    }
}
