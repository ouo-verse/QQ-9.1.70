package com.tencent.mobileqq.relation.api;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes17.dex */
public interface ISafetyReportTempService extends IRuntimeService {
    String encrypt(String str, String str2);

    String getKeyForMode(int i3);

    void safetyNewReport(QBaseActivity qBaseActivity, String str, String str2, String str3, String str4, String str5, int i3, String str6, Bundle bundle);

    void safetyReport(QBaseActivity qBaseActivity, String str, String str2, String str3, int i3, String str4);
}
