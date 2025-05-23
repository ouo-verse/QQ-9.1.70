package com.tencent.mobileqq.vas.floatscreen;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.floatscr.a;
import com.tencent.mobileqq.floatscr.b;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.quickupdate.ColorScreenBusiness;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ColorScreenManagerImpl extends VasManager<a> implements b {

    /* renamed from: d, reason: collision with root package name */
    private AppRuntime f309089d = MobileQQ.sMobileQQ.waitAppRuntime(null);

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a c(int i3) {
        ColorScreenBusiness colorScreenBusiness = (ColorScreenBusiness) QQVasUpdateBusiness.getBusiness(ColorScreenBusiness.class);
        if (!colorScreenBusiness.isFileExists(i3)) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorScreenManager", 1, "getLocalConfig unzipDir not exist");
            }
            return null;
        }
        File file = new File(colorScreenBusiness.getSavePath(i3), "config.json");
        File file2 = new File(colorScreenBusiness.getSavePath(i3), "fullscreen.json");
        if (!file.exists()) {
            QLog.e("ColorScreenManager", 1, "configFile do not exists.");
        } else if (!file2.exists()) {
            QLog.e("ColorScreenManager", 1, "animFile do not exists.");
        } else {
            a aVar = new a();
            aVar.f209988a = file2.getAbsolutePath();
            aVar.f209989b = colorScreenBusiness.getSavePath(i3) + File.separator + "images";
            try {
                JSONObject jSONObject = new JSONObject(FileUtils.readFileContent(file));
                aVar.f209990c = jSONObject.optInt("repeatCount", aVar.f209990c) - 1;
                aVar.f209991d = jSONObject.optLong("eastInTime", aVar.f209991d);
                aVar.f209992e = jSONObject.optLong("eastOutTime", aVar.f209992e);
                if (QLog.isColorLevel()) {
                    QLog.d("ColorScreenManager", 1, "getLocalConfig crc32: " + Long.toHexString(IOUtil.getCRC32Value(file2)));
                }
                return aVar;
            } catch (Exception e16) {
                QLog.e("ColorScreenManager", 1, "failed read config of " + i3, e16);
            }
        }
        VasUpdateUtil.safeDeleteFile(new File(colorScreenBusiness.getSavePath(i3)));
        return null;
    }

    @Override // com.tencent.mobileqq.floatscr.b
    public void a(final int i3, final VasManager.CompleteListener<a> completeListener) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.floatscreen.ColorScreenManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                a c16 = ColorScreenManagerImpl.this.c(i3);
                if (c16 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorScreenManager", 1, "getLocalConfig return null, go to download");
                    }
                    ColorScreenBusiness colorScreenBusiness = (ColorScreenBusiness) QQVasUpdateBusiness.getBusiness(ColorScreenBusiness.class);
                    colorScreenBusiness.addDownLoadListener(i3, new Runnable() { // from class: com.tencent.mobileqq.vas.floatscreen.ColorScreenManagerImpl.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            completeListener.onComplete(ColorScreenManagerImpl.this.c(i3), Boolean.FALSE);
                        }
                    });
                    colorScreenBusiness.startDownload(i3);
                    return;
                }
                completeListener.onComplete(c16, Boolean.FALSE);
            }
        }, 5, null, false);
    }
}
