package com.tencent.av.zplan.avatar.resmgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.so.ResMgr;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private d f77321c;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<c> f77319a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<c> f77320b = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f77322d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HttpNetReq f77323d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f77324e;

        a(HttpNetReq httpNetReq, c cVar) {
            this.f77323d = httpNetReq;
            this.f77324e = cVar;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            int i3;
            if (netResp.mResult == 0) {
                File file = new File(this.f77323d.mOutPath);
                if (file.exists()) {
                    if (ResMgr.d(this.f77323d.mOutPath, this.f77324e.f77327a.md5)) {
                        if (this.f77324e.f77327a.isZip) {
                            try {
                                FileUtils.uncompressZip(this.f77323d.mOutPath, file.getParent(), false);
                                i3 = 1;
                            } catch (Exception unused) {
                                QLog.e("AVAvatarResDownloader", 1, "download end but failed. uncompressZip failed. " + this.f77324e.f77327a);
                                i3 = -4;
                            }
                            file.delete();
                        } else {
                            i3 = 1;
                        }
                    } else {
                        QLog.e("AVAvatarResDownloader", 1, "download end but failed. md5 not match. " + this.f77324e.f77327a);
                        i3 = -3;
                    }
                } else {
                    QLog.e("AVAvatarResDownloader", 1, "download end but failed. file not exist. " + this.f77324e.f77327a);
                    i3 = -2;
                }
            } else {
                QLog.e("AVAvatarResDownloader", 1, "download end but failed. error code: " + netResp.mResult + ". " + this.f77324e.f77327a);
                i3 = -1;
            }
            if (i3 == 1) {
                QLog.i("AVAvatarResDownloader", 1, "download successfully. " + this.f77324e.f77327a);
                if (b.this.f77321c != null) {
                    d dVar = b.this.f77321c;
                    c cVar = this.f77324e;
                    dVar.a(cVar.f77327a, 100, cVar.f77331e);
                    d dVar2 = b.this.f77321c;
                    c cVar2 = this.f77324e;
                    dVar2.b(cVar2.f77327a, i3, cVar2.f77331e);
                }
            } else if (b.this.f77321c != null) {
                d dVar3 = b.this.f77321c;
                c cVar3 = this.f77324e;
                dVar3.b(cVar3.f77327a, i3, cVar3.f77331e);
            }
            if (this.f77324e.f77330d == this.f77323d) {
                b.this.f77319a.remove(this.f77324e);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            int i3;
            if (j16 == 0) {
                i3 = 0;
            } else if (j3 >= j16) {
                i3 = 99;
            } else {
                i3 = (int) ((((float) j3) * 100.0f) / ((float) j16));
            }
            this.f77324e.f77329c = i3;
            if (i3 % 10 == 0 || i3 == 1 || i3 == 99) {
                QLog.i("AVAvatarResDownloader", 1, "download... progress: " + i3 + ". " + this.f77324e.f77327a);
            }
            if (b.this.f77321c != null) {
                d dVar = b.this.f77321c;
                c cVar = this.f77324e;
                dVar.a(cVar.f77327a, i3, cVar.f77331e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.av.zplan.avatar.resmgr.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0777b extends BroadcastReceiver {
        C0777b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            c cVar;
            if (intent == null || intent.getAction() == null || !AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION.equals(intent.getAction())) {
                return;
            }
            String stringExtra = intent.getStringExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_AGENT_TYPE);
            if (stringExtra.equalsIgnoreCase(AEResInfo.LIGHT_RES_BUNDLE_BODY_3D.agentType)) {
                str = "LightResBody3DModel";
            } else if (stringExtra.equalsIgnoreCase(AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType)) {
                str = "LightResBasePackage";
            } else if (stringExtra.equalsIgnoreCase(AEResInfo.LIGHT_RES_PAG.agentType)) {
                str = "LightResPag";
            } else if (stringExtra.equalsIgnoreCase(AEResInfo.LIGHT_RES_FILAMENT.agentType)) {
                str = "LightResFilament";
            } else {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 < b.this.f77320b.size()) {
                    if (((c) b.this.f77320b.get(i3)).f77327a.f77300id.equalsIgnoreCase(str)) {
                        cVar = (c) b.this.f77320b.get(i3);
                        break;
                    }
                    i3++;
                } else {
                    cVar = null;
                    break;
                }
            }
            if (cVar == null) {
                QLog.e("AVAvatarResDownloader", 1, "mShareResBroadcastReceiver failed. resId: " + str);
                return;
            }
            QLog.i("AVAvatarResDownloader", 1, "download successfully. " + cVar.f77327a);
            if (b.this.f77321c != null) {
                b.this.f77321c.a(cVar.f77327a, 100, cVar.f77331e);
                b.this.f77321c.b(cVar.f77327a, 1, cVar.f77331e);
            }
            b.this.f77320b.remove(cVar);
            if (b.this.f77320b.size() == 0) {
                BaseApplicationImpl.getApplication().unregisterReceiver(b.this.f77322d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public AVAvatarResInfo f77327a = new AVAvatarResInfo();

        /* renamed from: b, reason: collision with root package name */
        public int f77328b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f77329c = 0;

        /* renamed from: d, reason: collision with root package name */
        public HttpNetReq f77330d = null;

        /* renamed from: e, reason: collision with root package name */
        public int f77331e = 0;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface d {
        void a(AVAvatarResInfo aVAvatarResInfo, int i3, int i16);

        void b(AVAvatarResInfo aVAvatarResInfo, int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar) {
        this.f77321c = dVar;
        QLog.i("AVAvatarResDownloader", 1, "AVAvatarResDownloader for " + BaseApplicationImpl.getApplication().getQQProcessName());
    }

    private boolean f(c cVar) {
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mReqUrl = cVar.f77327a.url;
        boolean z16 = false;
        httpNetReq.mHttpMethod = 0;
        StringBuilder sb5 = new StringBuilder();
        AVAvatarResInfo aVAvatarResInfo = cVar.f77327a;
        sb5.append(AVAvatarResMgr.u(aVAvatarResInfo.f77300id, aVAvatarResInfo.md5));
        sb5.append(File.separator);
        sb5.append(cVar.f77327a.fileName);
        httpNetReq.mOutPath = sb5.toString();
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mCallback = new a(httpNetReq, cVar);
        IHttpEngineService iHttpEngineService = (IHttpEngineService) ((AppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IHttpEngineService.class, "all");
        if (iHttpEngineService != null) {
            cVar.f77330d = httpNetReq;
            iHttpEngineService.sendReq(httpNetReq);
            z16 = true;
        } else {
            QLog.e("AVAvatarResDownloader", 1, "download failed. netEngine == null. " + cVar.f77327a);
        }
        if (!z16) {
            this.f77319a.remove(cVar);
        } else {
            QLog.i("AVAvatarResDownloader", 1, "download. " + cVar.f77327a);
            cVar.f77328b = 2;
            d dVar = this.f77321c;
            if (dVar != null) {
                dVar.b(cVar.f77327a, 2, cVar.f77331e);
            }
        }
        return z16;
    }

    private boolean g(AVAvatarResInfo aVAvatarResInfo, int i3) {
        for (int i16 = 0; i16 < this.f77319a.size(); i16++) {
            if (this.f77319a.get(i16).f77327a.f77300id.equalsIgnoreCase(aVAvatarResInfo.f77300id) && this.f77319a.get(i16).f77328b == 2) {
                c cVar = this.f77319a.get(i16);
                cVar.f77331e = i3 | cVar.f77331e;
                QLog.i("AVAvatarResDownloader", 1, "download repeatedly. resId: " + this.f77319a.get(i16).f77327a.f77300id);
                return true;
            }
        }
        c cVar2 = new c();
        cVar2.f77327a = aVAvatarResInfo;
        cVar2.f77331e |= i3;
        this.f77319a.add(cVar2);
        return f(cVar2);
    }

    private boolean h(c cVar) {
        String str;
        if (this.f77322d == null) {
            this.f77322d = new C0777b();
        }
        if (this.f77320b.size() == 1) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION);
            BaseApplicationImpl.getApplication().registerReceiver(this.f77322d, intentFilter);
        }
        if (cVar.f77327a.f77300id.equalsIgnoreCase("LightResBody3DModel")) {
            str = AEResInfo.LIGHT_RES_BUNDLE_BODY_3D.agentType;
        } else if (cVar.f77327a.f77300id.equalsIgnoreCase("LightResBasePackage")) {
            str = AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType;
        } else if (cVar.f77327a.f77300id.equalsIgnoreCase("LightResPag")) {
            str = AEResInfo.LIGHT_RES_PAG.agentType;
        } else if (cVar.f77327a.f77300id.equalsIgnoreCase("LightResFilament")) {
            str = AEResInfo.LIGHT_RES_FILAMENT.agentType;
        } else {
            return false;
        }
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(str);
        QLog.i("AVAvatarResDownloader", 1, "download. " + cVar.f77327a);
        cVar.f77328b = 2;
        d dVar = this.f77321c;
        if (dVar != null) {
            dVar.b(cVar.f77327a, 2, cVar.f77331e);
        }
        return true;
    }

    private boolean i(AVAvatarResInfo aVAvatarResInfo, int i3) {
        for (int i16 = 0; i16 < this.f77320b.size(); i16++) {
            if (this.f77320b.get(i16).f77327a.f77300id.equalsIgnoreCase(aVAvatarResInfo.f77300id) && this.f77320b.get(i16).f77328b == 2) {
                c cVar = this.f77320b.get(i16);
                cVar.f77331e = i3 | cVar.f77331e;
                QLog.i("AVAvatarResDownloader", 1, "download repeatedly. resId: " + this.f77320b.get(i16).f77327a.f77300id);
                return true;
            }
        }
        c cVar2 = new c();
        cVar2.f77327a = aVAvatarResInfo;
        cVar2.f77331e |= i3;
        this.f77320b.add(cVar2);
        return h(cVar2);
    }

    public boolean e(AVAvatarResInfo aVAvatarResInfo, int i3) {
        if (AVAvatarResMgr.A(aVAvatarResInfo.f77300id)) {
            return g(aVAvatarResInfo, i3);
        }
        return i(aVAvatarResInfo, i3);
    }
}
