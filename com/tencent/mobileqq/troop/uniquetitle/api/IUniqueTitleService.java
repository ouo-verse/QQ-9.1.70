package com.tencent.mobileqq.troop.uniquetitle.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface IUniqueTitleService extends IRuntimeService {
    public static final String UNIQUE_TITLE_NEW_FLAG = "uniqueTitleNewFlag";

    long getOldestUniqueTitleExpireTime(String str);

    int getUniqueTitleNewFlag();

    boolean hasUniqueTitleExpireNotified(String str, String str2);

    void setOldestUniqueTitleExpireTime(String str, long j3);

    void setUniqueTitleExpireNotified(String str, String str2, boolean z16);

    void setUniqueTitleNewFlag(int i3);
}
