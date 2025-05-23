package com.tencent.tbs.one;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TBSOneOnlineService {
    void cancelUpdate();

    void update(Bundle bundle, TBSOneCallback<Void> tBSOneCallback);
}
