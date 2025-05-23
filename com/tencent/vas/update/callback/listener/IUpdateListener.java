package com.tencent.vas.update.callback.listener;

import com.tencent.vas.update.entity.UpdateListenerParams;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IUpdateListener {
    void onLoadFail(UpdateListenerParams updateListenerParams);

    void onLoadSuccess(UpdateListenerParams updateListenerParams);

    void onProgress(UpdateListenerParams updateListenerParams);
}
