package com.tencent.icgame.game.trtc.roomservice.multipevoiceroom;

import android.text.TextUtils;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.icgame.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil;
import com.tencent.icgame.trpc.yes.common.TcloudServerOuterClass$GetUserTCloudSignRsp;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.timi.game.utils.IResultListener;
import java.io.File;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TimiGameQQTrtcUtil {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f115851a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f115852b = false;

    /* renamed from: c, reason: collision with root package name */
    public static String f115853c;

    /* renamed from: d, reason: collision with root package name */
    public static String f115854d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f115857a;

        a(b bVar) {
            this.f115857a = bVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(TcloudServerOuterClass$GetUserTCloudSignRsp tcloudServerOuterClass$GetUserTCloudSignRsp) {
            QLog.i("ICGameGameQQTrtcCheckUtil", 2, "checkTrtcUserSig[Success]");
            TimiGameQQTrtcUtil.f115853c = tcloudServerOuterClass$GetUserTCloudSignRsp.trtc_sign.get();
            TimiGameQQTrtcUtil.f115854d = tcloudServerOuterClass$GetUserTCloudSignRsp.live_trtc_sign.get();
            TimiGameQQTrtcUtil.d(this.f115857a);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            QLog.e("ICGameGameQQTrtcCheckUtil", 2, "errCode:" + i3 + " errMsg:" + str);
            this.f115857a.onError(-3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface b {
        void onError(int i3, String str);

        void onSuccess();
    }

    public static void c() {
        AVBizModuleFactory.getModuleByName(Constants.Business.TIMI_GAME).abandonAVFocus();
        AVBizModuleFactory.removeModuleByName(Constants.Business.TIMI_GAME);
        f115851a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(final b bVar) {
        if (f115852b) {
            bVar.onSuccess();
        } else {
            SoLoad.load(SoLoad.BIZ_TRTC_QQCHANNEL, SoLoadConstants.SONAME_TRTC, new SoLoad.LoadCallback() { // from class: com.tencent.icgame.game.trtc.roomservice.multipevoiceroom.e
                @Override // com.tencent.mobileqq.soload.api.SoLoad.LoadCallback
                public final void onLoad(boolean z16, String str, String str2) {
                    TimiGameQQTrtcUtil.g(TimiGameQQTrtcUtil.b.this, z16, str, str2);
                }
            });
        }
    }

    private static void e(b bVar) {
        ((sx0.b) qx0.a.b(sx0.b.class)).O(new a(bVar));
    }

    public static boolean f() {
        if (f115851a && f115852b && !TextUtils.isEmpty(f115853c) && !TextUtils.isEmpty(f115854d)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(final b bVar, boolean z16, String str, String str2) {
        QLog.i("ICGameGameQQTrtcCheckUtil", 1, "checkTrtcEnv onLoadResult isSuccess:" + z16);
        if (z16) {
            QLog.i("ICGameGameQQTrtcCheckUtil", 1, "setLibraryPath: " + str2);
            QLog.i("ICGameGameQQTrtcCheckUtil", 1, "setLibraryPath file list: " + Arrays.toString(new File(str2).list()));
            TXLiveBase.setLibraryPath(str2);
            f115852b = true;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.icgame.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.onSuccess();
                }
            });
            return;
        }
        QLog.e("ICGameGameQQTrtcCheckUtil", 2, "Trtc SO\u52a0\u8f7d\u5f02\u5e38");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.icgame.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.onError(-1, "TRTC SO\u52a0\u8f7d\u5f02\u5e38");
            }
        });
    }

    public static void h(b bVar) {
        String requestAVFocus = AVBizModuleFactory.getModuleByName(Constants.Business.TIMI_GAME).requestAVFocus();
        if (!"true".equals(requestAVFocus)) {
            QLog.e("ICGameGameQQTrtcCheckUtil", 2, "\u83b7\u53d6\u97f3\u9891\u4e1a\u52a1\u6743\u9650\u5931\u8d25,\u5360\u7528\u4e1a\u52a1 res[" + requestAVFocus + "]");
            f115851a = false;
            bVar.onError(-2, requestAVFocus);
            return;
        }
        QLog.i("ICGameGameQQTrtcCheckUtil", 2, "\u83b7\u53d6\u97f3\u9891\u4e1a\u52a1\u6743\u9650[Success]");
        f115851a = true;
        e(bVar);
    }
}
