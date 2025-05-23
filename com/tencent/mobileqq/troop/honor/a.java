package com.tencent.mobileqq.troop.honor;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import java.util.List;
import java.util.Observable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends Observable {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(com.tencent.mobileqq.troop.honor.config.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        List<com.tencent.mobileqq.troop.honor.config.a> d16 = bVar.d();
        QLog.i("TroopHonorDownloader", 1, "[downloadConfigIcons], honorListSize: " + d16.size());
        for (com.tencent.mobileqq.troop.honor.config.a aVar : d16) {
            if (!TextUtils.isEmpty(aVar.f297513f)) {
                com.tencent.cachedrawable.dynamicdrawable.api.a.a().i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).k(aVar.f297513f).d(VasApngUtil.getCacheFilePath(aVar.f297513f)).a();
            }
        }
    }
}
