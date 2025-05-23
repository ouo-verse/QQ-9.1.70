package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BaseMessageNavigateInfo extends Entity {
    public static int STATUS_ADD = 1;
    public static int STATUS_DELETE = 3;
    public static int STATUS_MODIFY = 2;
    public static int STATUS_NORMAL;
    public long msgseq;
    public int receivedFlowserCount;
    public long shmsgseq;
    public String summary;
    public int type;
    public int status = STATUS_NORMAL;
    public Object extObj = null;
}
