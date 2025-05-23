package com.tencent.mobileqq.vas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class h implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private DownloaderFactory f309445d;

    /* renamed from: f, reason: collision with root package name */
    QQAppInterface f309447f;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.mobileqq.vip.k f309446e = null;

    /* renamed from: h, reason: collision with root package name */
    com.tencent.mobileqq.vip.f f309448h = new a(AppConstants.FlowStatPram.PARAM_WIFICOLOR_RING_DOWNLOAD_FLOW, AppConstants.FlowStatPram.PARAM_XGCOLOR_RING_DOWNLOAD_FLOW);

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends com.tencent.mobileqq.vip.f {
        a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            boolean z16;
            if (QLog.isColorLevel()) {
                QLog.d("ColorRingManager", 2, "onDone, status=" + gVar.i());
            }
            Bundle h16 = gVar.h();
            int i3 = h16.getInt("callId");
            int i16 = h16.getInt("resourceType");
            if (gVar.i() == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                boolean z17 = h16.getBoolean(VipFunCallConstants.KEY_EXISTS, false);
                String string = h16.getString("path");
                if (!z17) {
                    z16 = FileUtils.rename(string + ".tmp", string);
                }
                if (!z16 && QLog.isColorLevel()) {
                    QLog.d("ColorRingManager", 2, "rename failure.");
                }
            }
            if (h.this.f309446e != null && gVar.h().getBoolean(VipFunCallConstants.KEY_IS_IPC)) {
                Bundle bundle = new Bundle();
                bundle.putString("status", "onDone");
                bundle.putInt(VipFunCallConstants.KEY_STATUSE, 3);
                bundle.putInt("id", i3);
                bundle.putInt("callId", i3);
                bundle.putInt("srcType", h16.getInt("srcType"));
                bundle.putBoolean("result", z16);
                bundle.putInt("resourceType", h16.getInt("resourceType"));
                bundle.putString("colorType", h16.getString("colorType"));
                bundle.putBoolean(VipFunCallConstants.KEY_BOO_RESULT, z16);
                bundle.putInt("resourceType", i16);
                h.this.f309446e.b(bundle);
            }
            h.this.b(h16, i3, i16, z16);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onProgress(com.tencent.mobileqq.vip.g gVar) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorRingManager", 2, "onProgress, loaded=" + gVar.f313014l + "percent=" + gVar.f313015m);
            }
            if (gVar.h().getBoolean(VipFunCallConstants.KEY_IS_IPC) && h.this.f309446e != null) {
                Bundle h16 = gVar.h();
                Bundle bundle = new Bundle();
                bundle.putString("status", "onProgress");
                bundle.putInt(VipFunCallConstants.KEY_STATUSE, 2);
                bundle.putInt("id", h16.getInt("callId"));
                bundle.putInt("callId", h16.getInt("callId"));
                bundle.putInt("srcType", h16.getInt("srcType"));
                bundle.putInt("progress", (int) gVar.f313015m);
                bundle.putInt("resourceType", h16.getInt("resourceType"));
                bundle.putString("colorType", h16.getString("colorType"));
                h.this.f309446e.b(bundle);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(com.tencent.mobileqq.vip.g gVar) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorRingManager", 2, "onStart, loaded=" + gVar.f313014l + "percent=" + gVar.f313015m);
            }
            if (gVar.h().getBoolean(VipFunCallConstants.KEY_IS_IPC) && h.this.f309446e != null) {
                Bundle h16 = gVar.h();
                Bundle bundle = new Bundle();
                bundle.putString("status", "onStart");
                bundle.putInt("id", h16.getInt("callId"));
                bundle.putInt(VipFunCallConstants.KEY_STATUSE, 1);
                bundle.putInt("callId", h16.getInt("callId"));
                bundle.putInt("srcType", h16.getInt("srcType"));
                bundle.putInt("resourceType", h16.getInt("resourceType"));
                bundle.putString("colorType", h16.getString("colorType"));
                h.this.f309446e.b(bundle);
            }
            return true;
        }
    }

    public h(QQAppInterface qQAppInterface) {
        this.f309445d = null;
        this.f309447f = qQAppInterface;
        this.f309445d = (DownloaderFactory) qQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(Bundle bundle, int i3, int i16, boolean z16) {
        if (i16 == 3) {
            ISVIPHandler iSVIPHandler = (ISVIPHandler) this.f309447f.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
            int currentUserVipType = iSVIPHandler.getCurrentUserVipType();
            if (currentUserVipType == 2) {
                currentUserVipType = 0;
            } else if (currentUserVipType == 3) {
                currentUserVipType = 2;
            }
            if ("colorring".equals(bundle.getString("colorType"))) {
                ReportController.o(this.f309447f, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, !z16 ? 1 : 0, "" + currentUserVipType, i3 + "", "", "");
            }
            if ("comering".equals(bundle.getString("colorType"))) {
                ReportController.o(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, !z16 ? 1 : 0, "" + iSVIPHandler.getCurrentUserVipType(), i3 + "", "", "");
            }
        }
    }

    public static JSONObject c(long j3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(g.f309256a);
        String str = File.separator;
        sb5.append(str);
        sb5.append(j3);
        sb5.append(str);
        sb5.append("config.txt");
        try {
            String readFileContent = FileUtils.readFileContent(new File(sb5.toString()));
            if (readFileContent == null) {
                return null;
            }
            return new JSONObject(readFileContent);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Bitmap d(long j3) {
        if (j3 != 0) {
            String e16 = e(j3, 1);
            if (new File(e16).exists()) {
                try {
                    return BitmapFactory.decodeFile(e16);
                } catch (OutOfMemoryError unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorRingManager", 2, "getCoverBitmap OOM.");
                        return null;
                    }
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    public static String e(long j3, int i3) {
        if (j3 == 0) {
            return "";
        }
        if (i3 == 2) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(g.f309256a);
            String str = File.separator;
            sb5.append(str);
            sb5.append(j3);
            sb5.append(str);
            sb5.append("config.txt");
            return sb5.toString();
        }
        if (i3 == 1) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(g.f309256a);
            String str2 = File.separator;
            sb6.append(str2);
            sb6.append(j3);
            sb6.append(str2);
            sb6.append("cover.jpg");
            return sb6.toString();
        }
        if (i3 != 3) {
            return "";
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append(g.f309256a);
        String str3 = File.separator;
        sb7.append(str3);
        sb7.append(j3);
        sb7.append(str3);
        sb7.append("ring.mp3");
        return sb7.toString();
    }

    public static String f(AppRuntime appRuntime, int i3, int i16) {
        String str;
        if (i16 == 3) {
            str = VipFunCallUtil.getFunCallSP(appRuntime, 0, null).getString("_3_" + i3, null);
            if (TextUtils.isEmpty(str)) {
                str = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.COLORRING_AUDIO);
            }
        } else if (i16 == 2) {
            str = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.COLORRING_CONFIG);
        } else if (i16 == 1) {
            str = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.COLORRING_COVER);
        } else {
            str = "";
        }
        if (str != null) {
            return str.replace("[id]", String.valueOf(i3));
        }
        return str;
    }

    public void g(int i3, int i16, boolean z16, int i17, String str) {
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d("ColorRingManager", 2, ">>startDownload, id=" + i3);
        }
        if (i3 == 0) {
            return;
        }
        String e16 = e(i3, i16);
        File file = new File(e16);
        if (file.exists() && file.isFile()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ColorRingManager", 2, "startDownload exists(), id=" + i3 + ", resType=ring3,, isIPC=" + z16 + ", srcType=" + i17 + ", fileExist=" + z17);
        }
        if (z17 && !z16) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("callId", i3);
        bundle.putString("path", e16);
        bundle.putBoolean(VipFunCallConstants.KEY_IS_IPC, z16);
        bundle.putInt("resourceType", i16);
        bundle.putInt("srcType", i17);
        bundle.putString("path", e16);
        bundle.putString("colorType", str);
        String f16 = f(this.f309447f, i3, i16);
        if (z17) {
            bundle.putBoolean(VipFunCallConstants.KEY_EXISTS, true);
            com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(f16, file);
            gVar.y(3);
            gVar.f313006d = 0;
            gVar.w(bundle);
            this.f309448h.onDone(gVar);
            return;
        }
        com.tencent.mobileqq.vip.g gVar2 = new com.tencent.mobileqq.vip.g(f16, new File(e16 + ".tmp"));
        gVar2.E = 3145728L;
        gVar2.f313019q = true;
        this.f309445d.u(1).startDownload(gVar2, this.f309448h, bundle);
        if (QLog.isColorLevel()) {
            QLog.d("ColorRingManager", 2, "<<startDownload, id=" + i3);
        }
    }

    public void h(int i3, int i16) {
        this.f309445d.u(1).cancelTask(true, f(this.f309447f, i3, i16));
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.f309446e = null;
    }
}
