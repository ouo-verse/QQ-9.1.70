package com.tencent.qq.minibox.permission;

import com.tencent.mobileqq.persistence.Entity;

/* loaded from: classes22.dex */
public class GamePermissionItem extends Entity {
    public static final int PERMISSION_STATUS_ALLOWED = 1;
    public static final int PERMISSION_STATUS_NOT_CONFIRMED = 0;
    public static final int PERMISSION_STATUS_REFUSED = -1;
    public String mGameId;
    public String mPermission;
    public int mStatus;
}
