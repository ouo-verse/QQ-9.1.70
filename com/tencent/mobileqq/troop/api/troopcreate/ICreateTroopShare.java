package com.tencent.mobileqq.troop.api.troopcreate;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ICreateTroopShare extends IRuntimeService {
    void ShareToQQ(JSONObject jSONObject, Activity activity);

    void miniAppShareQQDirectly(Intent intent, Activity activity);

    void miniAppShareQQDirectlyWithOutDialog(Intent intent, Activity activity);
}
