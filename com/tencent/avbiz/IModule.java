package com.tencent.avbiz;

import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IModule {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface FocusChangeListener {
        void onFocusGain();

        void onFocusLoss();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void onResponse(String str);
    }

    void abandonAVFocus();

    void asyncAbandonAVFocus();

    void asyncCheckAVFocus(a aVar);

    void asyncRequestAVFocus(a aVar);

    String checkAVFocus();

    HashMap<Long, String> getFocusBusiness();

    HashSet<String> getInQueueBusiness();

    String requestAVFocus();

    void setListener(FocusChangeListener focusChangeListener);
}
