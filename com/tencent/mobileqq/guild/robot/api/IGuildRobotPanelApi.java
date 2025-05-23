package com.tencent.mobileqq.guild.robot.api;

import android.app.Activity;
import android.widget.EditText;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildRobotPanelApi extends QRouteApi {
    void insertAtSpan(Activity activity, EditText editText, String str, String str2, boolean z16);

    boolean openRobotFunctionsPanel(EditText editText, String str, String str2, boolean z16);

    boolean openRobotInlineSearchPanel(EditText editText, String str, String str2, boolean z16);
}
