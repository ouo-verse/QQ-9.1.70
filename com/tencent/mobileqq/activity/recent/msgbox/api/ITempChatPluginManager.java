package com.tencent.mobileqq.activity.recent.msgbox.api;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.a;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {""})
/* loaded from: classes10.dex */
public interface ITempChatPluginManager extends IRuntimeService {
    a getTempChatPlugin(int i3);

    boolean isCustomizeByBiz(int i3);

    boolean onHeadIconClickCusTempConv(Context context, int i3, String str);
}
