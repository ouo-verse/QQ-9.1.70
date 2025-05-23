package com.qzone.proxy.covercomponent.adapter;

import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverResAdapter implements ICoverResources {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ICoverResources f50108a;

    CoverResAdapter() {
    }

    public static ICoverResources getInstance() {
        if (f50108a == null) {
            synchronized (CoverResAdapter.class) {
                if (f50108a == null) {
                    f50108a = new CoverResAdapter();
                }
            }
        }
        return f50108a;
    }

    @Override // com.qzone.proxy.covercomponent.adapter.ICoverResources
    public int getResId(int i3) {
        switch (i3) {
            case 1:
                return R.drawable.common_loading6;
            case 2:
                return R.id.baw;
            case 3:
                return R.id.bav;
            case 4:
                return R.layout.bjl;
            case 5:
                return R.id.hf8;
            case 6:
                return R.color.f157901a72;
            case 7:
            default:
                return 0;
            case 8:
                return R.drawable.ghl;
            case 9:
                return R.drawable.g_m;
        }
    }
}
