package com.tencent.mobileqq.activity.recent.gamemsgbox.api;

import android.content.Context;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes10.dex */
public interface IGameMsgBoxRuntimeService extends IRuntimeService {
    public static final String DT_PAGE_ID = "pg_gb_entrance";
    public static final String MR_EXT_SHOW_TIME = "mr_ext_show_time";

    void addAuthorizeShow(String str);

    void buildGameBoxAuthSummary(JSONObject jSONObject);

    boolean getDataReady();

    String getEnterGameMsgAIOAppId();

    String getGameAppIdFromMessage(MessageRecord messageRecord);

    Long getLastAuthTime();

    boolean isAuthorizeShow(String str);

    void setEnterGameMsgAIOAppId(String str);

    void setShouldShowNewUnAuthorizedSummary(boolean z16, Context context);

    boolean shouldFilterUnintendedMultiClicks();
}
