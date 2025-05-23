package com.tencent.mobileqq.reminder.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes18.dex */
public interface IQQActivateFriendService extends IRuntimeService {
    public static final String KEY_IS_OPEN = "key_is_open";
    public static final String KEY_IS_REMOTE = "key_is_remote";
    public static final String METHOD_ACTION_QQNOTIFY_SET_SWITCH_VALUE = "qq_notify_set_switch_value";

    boolean getSwitchValue(boolean z16);

    void setSwitchValueForQQNotify(boolean z16, boolean z17);

    void setSwtichValue(boolean z16, boolean z17);
}
