package com.qzone.business.vip;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.mobileqq.vas.quickupdate.IntimacyDownloadBusiness;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqva.intimacy.IntimacyIdentifierServer$SsoGetUsingItemReq;
import com.tencent.trpcprotocol.qqva.intimacy.IntimacyIdentifierServer$SsoGetUsingItemRsp;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes39.dex */
public class IntimacyRequest {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f44889d;

        a(b bVar) {
            this.f44889d = bVar;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            QLog.i("IntimacyRequest", 1, "receive");
            if (this.f44889d == null) {
                return;
            }
            try {
                int i3 = new IntimacyIdentifierServer$SsoGetUsingItemRsp().mergeFrom(eIPCResult.data.getByteArray(PbProtocolSSoImpl.RESP_KEY_IS_DATA)).items.get(0).get().itemid.get();
                QLog.i("IntimacyRequest", 1, "receive itemid = " + i3);
                if (i3 <= 0) {
                    return;
                }
                IntimacyRequest.b(i3, this.f44889d);
            } catch (Exception e16) {
                QLog.e("IntimacyRequest", 1, e16, new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a(Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i3, final b bVar) {
        IntimacyDownloadBusiness intimacyDownloadBusiness = (IntimacyDownloadBusiness) QQVasUpdateBusiness.getBusiness(IntimacyDownloadBusiness.class);
        if (!intimacyDownloadBusiness.isFileExists(i3)) {
            QLog.i("IntimacyRequest", 1, "request download " + i3);
            intimacyDownloadBusiness.startDownload(i3);
            return;
        }
        final File file = new File(intimacyDownloadBusiness.getSavePath(i3), "large.png");
        if (!file.exists()) {
            QLog.e("IntimacyRequest", 1, "image " + file + " not exist!");
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.business.vip.IntimacyRequest.2
            @Override // java.lang.Runnable
            public void run() {
                ApngOptions apngOptions = new ApngOptions();
                apngOptions.setRequestHeight(10);
                apngOptions.setRequestWidth(10);
                APNGDrawable apngDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable("IntimacyRequest", "", apngOptions, file.getAbsolutePath());
                apngDrawable.setSupportNinePath(true);
                bVar.a(apngDrawable);
            }
        });
    }

    public static void c(long j3, b bVar) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null || TextUtils.isEmpty(runtime.getCurrentUin())) {
            return;
        }
        IntimacyIdentifierServer$SsoGetUsingItemReq intimacyIdentifierServer$SsoGetUsingItemReq = new IntimacyIdentifierServer$SsoGetUsingItemReq();
        intimacyIdentifierServer$SsoGetUsingItemReq.appid.add(322);
        intimacyIdentifierServer$SsoGetUsingItemReq.friend_uin.set(j3);
        try {
            ((ILiveDelivery) RemoteProxy.getProxy(LiveDelivery.class)).requestPbMsfSSO("trpc.qqva.intimacy_identifier_server.IntimacyIdentifierServer.SsoGetUsingItem", new String(intimacyIdentifierServer$SsoGetUsingItemReq.toByteArray(), "ISO8859_1"), null, -1, new a(bVar));
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }
}
