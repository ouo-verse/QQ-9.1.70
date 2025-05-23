package com.tencent.gamecenter.wadl.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface IQQGameFullScreenNoticeService extends IRuntimeService {
    void onFullScreenPushReceived(JSONObject jSONObject);

    void showGameAppointmentFullScreen();
}
