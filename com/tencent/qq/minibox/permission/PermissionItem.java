package com.tencent.qq.minibox.permission;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* loaded from: classes22.dex */
public class PermissionItem extends Entity {
    public String mName;

    @unique
    public String mPermission;
    public String mReqDetail;
    public String mReqTitle;
}
