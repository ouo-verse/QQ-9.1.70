package com.tencent.mobileqq.qqlive.listener.supervision;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface AdminOperationMsgType {
    public static final int MSG_TYPE_ALLOW_CHAT = 1;
    public static final int MSG_TYPE_FORBID_CHAT = 2;
    public static final int MSG_TYPE_PLACE_HOLDER = 0;
    public static final int MSG_TYPE_ROOM_ADMIN_LIST = 3;
}
