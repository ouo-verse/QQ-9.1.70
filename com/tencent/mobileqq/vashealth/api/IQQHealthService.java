package com.tencent.mobileqq.vashealth.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashMap;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes20.dex */
public interface IQQHealthService extends IRuntimeService {
    void openSportHippy(Context context, HashMap<String, String> hashMap);

    boolean redirectAIOToMainPage(Context context, int i3);

    void redirectAIOToMainPageInPA(Context context);
}
