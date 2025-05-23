package com.tenpay.sdk.basebl;

import com.tenpay.sdk.paynet.Net;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ListenerToBL {
    private static final int MAX_COUNT = 3;
    private static final List<ListenerToBL> sListenerToBls = new ArrayList();
    private WeakReference<TenpayBL> blRef;

    public ListenerToBL(TenpayBL tenpayBL) {
        this.blRef = new WeakReference<>(tenpayBL);
    }

    public static void add(TenpayBL tenpayBL) {
        if (tenpayBL != null && tenpayBL.mBLListener != null) {
            List<ListenerToBL> list = sListenerToBls;
            synchronized (list) {
                list.add(new ListenerToBL(tenpayBL));
                if (list.size() > 3) {
                    list.remove(0);
                }
            }
        }
    }

    public static TenpayBL getBL(Net.NetListener netListener) {
        TenpayBL tenpayBL;
        if (netListener != null) {
            List<ListenerToBL> list = sListenerToBls;
            synchronized (list) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    WeakReference<TenpayBL> weakReference = sListenerToBls.get(size).blRef;
                    if (weakReference != null && (tenpayBL = weakReference.get()) != null && tenpayBL.mBLListener == netListener) {
                        return tenpayBL;
                    }
                }
                return null;
            }
        }
        return null;
    }
}
