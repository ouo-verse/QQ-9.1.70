package com.tencent.mobileqq.statistics.provider.statistic;

import android.text.TextUtils;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b implements aa1.b, Provider<aa1.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String[] f290073a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f290073a = new String[]{StatisticCollector.C2C_PICUP_STATISTIC_TAG, StatisticCollector.C2C_PICUP_STATISTIC_TAG_V2, StatisticCollector.TROOP_PIC_UPLOAD_STATISTIC_TAG_V2, StatisticCollector.DISCUSSION_PIC_UPLOAD_STATISTIC_TAG_V2, StatisticCollector.C2C_PICDOWN_STATISTIC_TAG, StatisticCollector.C2C_SMAILLPICDOWN_STATISTIC_TAG, StatisticCollector.TROOP_PIC_UPLOAD_STATISTIC_TAG, StatisticCollector.TROOP_PIC_DOWNLOAD_STATISTIC_TAG, StatisticCollector.TROOP_SMAILLPIC_DOWNLOAD_STATISTIC_TAG, StatisticCollector.AVIF_PIC_DOWNLOAD_STATISTIC_TAG, StatisticCollector.DISCUSSION_PIC_UPLOAD_STATISTIC_TAG, StatisticCollector.DISCUSSION_PIC_DOWNLOAD_STATISTIC_TAG, StatisticCollector.DISCUSSION_SMALLPIC_DOWNLOAD_STATISTIC_TAG, StatisticCollector.TROOP_PTT_UPLOAD_STATISTIC_TAG, StatisticCollector.TROOP_PTT_DOWNLOAD_STATISTIC_TAG, StatisticCollector.DISCUSSION_PTT_UPLOAD_STATISTIC_TAG, StatisticCollector.DISCUSSION_PTT_DOWNLOAD_STATISTIC_TAG, StatisticCollector.C2C_STREAM_PTT_UP_STATISTIC_TAG, StatisticCollector.C2C_STREAM_PTT_DOWN_STATISTIC_TAG, StatisticCollector.C2C_PUSHTALK_PTT_DOWNLOAD_STATISTIC_TAG, StatisticCollector.C2C_PTT_UPLOAD_STATISTIC_TAG, "actFileDown", "actFileUp", "actFileOf2Of", "actFileOf2Wy", "actFileWy2Of", "actFileWyUp", "actFileWyDown", "actFileUpDetail", "actFileDownDetail", "actFAFileDown", "actFAFileUp", StatisticCollector.C2C_SHORTVIDEO_UPLOAD, StatisticCollector.C2C_SHORTVIDEO_UPLOAD_BDH, StatisticCollector.GROUP_SHORTVIDEO_UPLOAD_BDH, StatisticCollector.SHORTVIDEO_FORWARD_BDH, StatisticCollector.C2C_SHORTVIDEO_DOWNLOAD_VIDEO, StatisticCollector.C2C_SHORTVIDEO_DOWNLOAD_THUMB, StatisticCollector.GROUP_SHORTVIDEO_UPLOAD, StatisticCollector.GROUP_SHORTVIDEO_DOWNLOAD_VIDEO, StatisticCollector.GROUP_SHORTVIDEO_DOWNLOAD_THUMB, StatisticCollector.STATISTIC_KEY_FOR_UPLOAD_PIC};
        }
    }

    @Override // aa1.b
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        for (String str2 : this.f290073a) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // aa1.b
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return PrivacyPolicyHelper.isUserAllow();
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public aa1.b get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (aa1.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this;
    }
}
