package com.tencent.mobileqq.guild.robot.api;

import android.content.Context;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildRobotApi extends QRouteApi {
    @NonNull
    /* synthetic */ Object createEnterCmdSchemeAction();

    @NonNull
    /* synthetic */ Object createParameterCmdSchemeAction();

    String getGuildDirectMsgTypeKey();

    String getLastAtUin(EditText editText);

    void openRobotSlashPanelFromBtn(EditText editText);

    void startH5Service(Context context, String str);

    void startMiniAppService(Context context, String str);

    void updateFuncSort(Context context, String str, String str2);

    void updateRobotSort(Context context, String str, String str2);
}
