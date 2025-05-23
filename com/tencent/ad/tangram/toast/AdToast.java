package com.tencent.ad.tangram.toast;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdToast {
    public static final int ICON_DEFAULT = 0;
    public static final int ICON_ERROR = 1;
    public static final int ICON_SUCCESS = 2;
    private static volatile AdToast sInstance;
    private WeakReference<AdToastAdapter> adapter;

    AdToast() {
    }

    @Nullable
    private AdToastAdapter getAdapter() {
        WeakReference<AdToastAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdToast getInstance() {
        if (sInstance == null) {
            synchronized (AdToast.class) {
                if (sInstance == null) {
                    sInstance = new AdToast();
                }
            }
        }
        return sInstance;
    }

    public void setAdapter(WeakReference<AdToastAdapter> weakReference) {
        this.adapter = weakReference;
    }

    public void show(Context context, int i3, CharSequence charSequence, int i16) {
        AdToastAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.show(context, i3, charSequence, i16);
        }
    }
}
