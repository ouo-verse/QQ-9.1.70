package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface IEmoticonFromGroupDBManagerService<T> extends IRuntimeService {
    public static final int MAX_EMO_FROM_GROUP_FIRST_PAGE_SIZE = 200;
    public static final int MAX_EMO_FROM_GROUP_SIZE = 500;
    public static final int MAX_SHOW_DATA_SIZE = 300;

    void decreaseCountOfSpare();

    int getCountOfSpare();

    void setCountOfSpare(int i3);
}
