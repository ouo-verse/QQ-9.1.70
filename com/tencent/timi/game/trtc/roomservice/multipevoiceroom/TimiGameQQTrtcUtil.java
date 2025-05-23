package com.tencent.timi.game.trtc.roomservice.multipevoiceroom;

import android.text.TextUtils;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil;
import com.tencent.timi.game.utils.IResultListener;
import java.io.File;
import java.util.Arrays;
import trpc.yes.common.TcloudServerOuterClass$GetUserTCloudSignRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiGameQQTrtcUtil {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f379997a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f379998b = false;

    /* renamed from: c, reason: collision with root package name */
    public static String f379999c;

    /* renamed from: d, reason: collision with root package name */
    public static String f380000d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f380003a;

        a(b bVar) {
            this.f380003a = bVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(TcloudServerOuterClass$GetUserTCloudSignRsp tcloudServerOuterClass$GetUserTCloudSignRsp) {
            QLog.i("TimiGameQQTrtcCheckUtil", 2, "checkTrtcUserSig[Success]");
            TimiGameQQTrtcUtil.f379999c = tcloudServerOuterClass$GetUserTCloudSignRsp.trtc_sign.get();
            TimiGameQQTrtcUtil.f380000d = tcloudServerOuterClass$GetUserTCloudSignRsp.live_trtc_sign.get();
            TimiGameQQTrtcUtil.d(this.f380003a);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            QLog.e("TimiGameQQTrtcCheckUtil", 2, "errCode:" + i3 + " errMsg:" + str);
            this.f380003a.onError(-3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void onError(int i3, String str);

        void onSuccess();
    }

    public static void c() {
        AVBizModuleFactory.getModuleByName(Constants.Business.TIMI_GAME).abandonAVFocus();
        AVBizModuleFactory.removeModuleByName(Constants.Business.TIMI_GAME);
        f379997a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(final b bVar) {
        if (f379998b) {
            bVar.onSuccess();
        } else {
            SoLoad.load(SoLoad.BIZ_TRTC_QQCHANNEL, SoLoadConstants.SONAME_TRTC, new SoLoad.LoadCallback() { // from class: com.tencent.timi.game.trtc.roomservice.multipevoiceroom.g
                @Override // com.tencent.mobileqq.soload.api.SoLoad.LoadCallback
                public final void onLoad(boolean z16, String str, String str2) {
                    TimiGameQQTrtcUtil.g(TimiGameQQTrtcUtil.b.this, z16, str, str2);
                }
            });
        }
    }

    private static void e(b bVar) {
        ((kn4.b) mm4.b.b(kn4.b.class)).O(new a(bVar));
    }

    public static boolean f() {
        if (f379997a && f379998b && !TextUtils.isEmpty(f379999c) && !TextUtils.isEmpty(f380000d)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(final b bVar, boolean z16, String str, String str2) {
        QLog.i("TimiGameQQTrtcCheckUtil", 1, "checkTrtcEnv onLoadResult isSuccess:" + z16);
        if (z16) {
            QLog.i("TimiGameQQTrtcCheckUtil", 1, "setLibraryPath: " + str2);
            QLog.i("TimiGameQQTrtcCheckUtil", 1, "setLibraryPath file list: " + Arrays.toString(new File(str2).list()));
            TXLiveBase.setLibraryPath(str2);
            f379998b = true;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.onSuccess();
                }
            });
            return;
        }
        QLog.e("TimiGameQQTrtcCheckUtil", 2, "Trtc SO\u52a0\u8f7d\u5f02\u5e38");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.onError(-1, "TRTC SO\u52a0\u8f7d\u5f02\u5e38");
            }
        });
    }

    public static void h(b bVar) {
        String requestAVFocus = AVBizModuleFactory.getModuleByName(Constants.Business.TIMI_GAME).requestAVFocus();
        if (!"true".equals(requestAVFocus)) {
            QLog.e("TimiGameQQTrtcCheckUtil", 2, "\u83b7\u53d6\u97f3\u9891\u4e1a\u52a1\u6743\u9650\u5931\u8d25,\u5360\u7528\u4e1a\u52a1 res[" + requestAVFocus + "]");
            f379997a = false;
            bVar.onError(-2, requestAVFocus);
            return;
        }
        QLog.i("TimiGameQQTrtcCheckUtil", 2, "\u83b7\u53d6\u97f3\u9891\u4e1a\u52a1\u6743\u9650[Success]");
        f379997a = true;
        e(bVar);
    }
}
