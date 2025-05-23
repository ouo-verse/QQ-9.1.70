package com.tencent.mobileqq.onlinestatus.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes16.dex */
public interface IOnlineStatusMiniService extends IRuntimeService {
    public static final String ONLINE_STATE = "onlineState";
    public static final String VIDEO_ID = "cid";
    public static final String VIDEO_NAME = "vName";
    public static final String VIDEO_URL = "url";

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface c {
        void a(boolean z16);
    }

    void doShowTencentVideoStatusPopWindow(QBaseActivity qBaseActivity, String str, String str2, String str3, int i3, JSONObject jSONObject, c cVar, a aVar);

    void sendReqToGetVideoName(String str, y.f fVar);

    void setTencentVideoStatus(AppInterface appInterface, String str, String str2, CustomShareInfo customShareInfo, b bVar);
}
