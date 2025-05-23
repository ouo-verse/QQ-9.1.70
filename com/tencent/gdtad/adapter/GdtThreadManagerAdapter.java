package com.tencent.gdtad.adapter;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.thread.AdThreadManagerAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtThreadManagerAdapter implements AdThreadManagerAdapter {
    @Override // com.tencent.ad.tangram.thread.AdThreadManagerAdapter
    public boolean postDelayed(@Nullable final Runnable runnable, int i3, long j3) {
        if (runnable == null) {
            return false;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>() { // from class: com.tencent.gdtad.adapter.GdtThreadManagerAdapter.1
            {
                put(3, 16);
                put(4, 128);
                put(5, 64);
            }
        };
        if (i3 == 0) {
            return new Handler(Looper.getMainLooper()).postDelayed(runnable, j3);
        }
        if (!hashMap.containsKey(Integer.valueOf(i3))) {
            return false;
        }
        final int intValue = hashMap.get(Integer.valueOf(i3)).intValue();
        return new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.gdtad.adapter.GdtThreadManagerAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                ThreadManagerV2.excute(runnable, intValue, null, true);
            }
        }, j3);
    }
}
