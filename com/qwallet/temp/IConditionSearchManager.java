package com.qwallet.temp;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes3.dex */
public interface IConditionSearchManager extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void onGetConfig(int i3, boolean z16);
    }

    void addListener(a aVar);

    int checkUpdate();

    boolean isNetUnAvailable(int i3);

    boolean isUpdateOk(int i3);

    void removeListener(a aVar);

    int resultOk();

    int update(int i3, boolean z16);
}
